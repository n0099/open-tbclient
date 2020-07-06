package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.data.BannerListData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tieba.recapp.report.b;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
import tbclient.ThreadInfo;
import tbclient.ThreadList.ThreadListResIdl;
import tbclient.User;
/* loaded from: classes9.dex */
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
            com.baidu.tieba.recapp.d.a.cZG().LU(threadListResIdl.data.asp_shown_info);
            Message<?> orginalMessage2 = getOrginalMessage();
            boolean isBrandForum = (orginalMessage2 == null || !(orginalMessage2.getExtra() instanceof LoadMoreRequestMessage)) ? false : ((LoadMoreRequestMessage) orginalMessage2.getExtra()).isBrandForum();
            this.threadList = new ArrayList<>();
            List<ThreadInfo> list2 = threadListResIdl.data.thread_list;
            if (list2 != null) {
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    ThreadInfo threadInfo = list2.get(i3);
                    bu buVar = new bu();
                    buVar.setUserMap(this.userMap);
                    buVar.a(threadInfo);
                    buVar.aTn();
                    buVar.dOj = isBrandForum;
                    if (!TextUtils.isEmpty(buVar.aTz())) {
                        ai aiVar = new ai();
                        aiVar.vG(buVar.aTz());
                        this.threadList.add(aiVar);
                    } else {
                        this.threadList.add(buVar);
                        JSONObject f = b.f(threadInfo);
                        if (f != null) {
                            arrayList.add(f);
                        }
                    }
                }
                b.cZL().eJ(arrayList);
            }
            this.bannerListData = null;
            if (threadListResIdl.data.banner_list != null && (orginalMessage = getOrginalMessage()) != null && orginalMessage.getExtra() != null && (orginalMessage.getExtra() instanceof LoadMoreRequestMessage)) {
                LoadMoreRequestMessage loadMoreRequestMessage = (LoadMoreRequestMessage) orginalMessage.getExtra();
                if (loadMoreRequestMessage.getPageType() == 1 || loadMoreRequestMessage.getPageType() == 2 || loadMoreRequestMessage.getPageType() == 3) {
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
