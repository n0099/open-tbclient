package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.data.BannerListData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.am;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.recapp.report.b;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
import tbclient.ThreadInfo;
import tbclient.ThreadList.ThreadListResIdl;
import tbclient.User;
/* loaded from: classes22.dex */
public class LoadMoreResponseSocketMessage extends SocketResponsedMessage {
    private BannerListData bannerListData;
    private ArrayList<q> threadList;
    private HashMap<String, MetaData> userMap;

    public LoadMoreResponseSocketMessage() {
        super(CmdConfigSocket.CMD_FRS_LOAD_MORE);
    }

    public ArrayList<q> getThreadList() {
        return this.threadList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        boolean z;
        Message<?> orginalMessage;
        ThreadListResIdl threadListResIdl = (ThreadListResIdl) new Wire(new Class[0]).parseFrom(bArr, ThreadListResIdl.class);
        setError(threadListResIdl.error.errorno.intValue());
        setErrorString(threadListResIdl.error.usermsg);
        if (getError() == 0) {
            this.userMap = new HashMap<>();
            List<User> list = threadListResIdl.data.user_list;
            if (list != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    MetaData metaData = new MetaData();
                    metaData.parserProtobuf(list.get(i2));
                    String userId = metaData.getUserId();
                    if (userId != null && !userId.equals("0")) {
                        this.userMap.put(metaData.getUserId(), metaData);
                    }
                }
            }
            com.baidu.tieba.recapp.d.a.dFY().Sk(threadListResIdl.data.asp_shown_info);
            long j = 0;
            Message<?> orginalMessage2 = getOrginalMessage();
            if (orginalMessage2 == null || !(orginalMessage2.getExtra() instanceof LoadMoreRequestMessage)) {
                z = false;
            } else {
                LoadMoreRequestMessage loadMoreRequestMessage = (LoadMoreRequestMessage) orginalMessage2.getExtra();
                z = loadMoreRequestMessage.isBrandForum();
                j = loadMoreRequestMessage.getForumId();
            }
            this.threadList = new ArrayList<>();
            List<ThreadInfo> list2 = threadListResIdl.data.thread_list;
            if (list2 != null) {
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    ThreadInfo threadInfo = list2.get(i3);
                    by byVar = new by();
                    aq.a(j, byVar);
                    byVar.setUserMap(this.userMap);
                    byVar.a(threadInfo);
                    byVar.bpP();
                    byVar.eLT = z;
                    if (!TextUtils.isEmpty(byVar.bqb())) {
                        am amVar = new am();
                        amVar.AS(byVar.bqb());
                        this.threadList.add(amVar);
                    } else {
                        this.threadList.add(byVar);
                        JSONObject f = b.f(threadInfo);
                        if (f != null) {
                            arrayList.add(f);
                        }
                    }
                }
                b.dGf().q("tag_frs_tab", arrayList);
            }
            this.bannerListData = null;
            if (threadListResIdl.data.banner_list != null && (orginalMessage = getOrginalMessage()) != null && orginalMessage.getExtra() != null && (orginalMessage.getExtra() instanceof LoadMoreRequestMessage)) {
                LoadMoreRequestMessage loadMoreRequestMessage2 = (LoadMoreRequestMessage) orginalMessage.getExtra();
                if (loadMoreRequestMessage2.getPageType() == 1 || loadMoreRequestMessage2.getPageType() == 2 || loadMoreRequestMessage2.getPageType() == 3) {
                    this.bannerListData = new BannerListData();
                    this.bannerListData.parserProtobuf(threadListResIdl.data.banner_list);
                }
            }
        }
    }

    public BannerListData getBannerListData() {
        return this.bannerListData;
    }
}
