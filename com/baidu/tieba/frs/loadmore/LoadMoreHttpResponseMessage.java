package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.data.BannerListData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ak;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.recapp.report.b;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
import tbclient.ThreadInfo;
import tbclient.ThreadList.ThreadListResIdl;
import tbclient.User;
/* loaded from: classes16.dex */
public class LoadMoreHttpResponseMessage extends HttpResponsedMessage {
    private BannerListData bannerListData;
    private ArrayList<q> threadList;
    private HashMap<String, MetaData> userMap;

    public LoadMoreHttpResponseMessage(int i) {
        super(i);
    }

    public ArrayList<q> getThreadList() {
        return this.threadList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Message<?> orginalMessage;
        ThreadListResIdl threadListResIdl = (ThreadListResIdl) new Wire(new Class[0]).parseFrom(bArr, ThreadListResIdl.class);
        if (threadListResIdl != null && threadListResIdl.error != null) {
            setError(threadListResIdl.error.errorno.intValue());
            setErrorString(threadListResIdl.error.usermsg);
            if (getError() == 0 && threadListResIdl.data != null) {
                if (y.getCount(threadListResIdl.data.user_list) > 0) {
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
                }
                Message<?> orginalMessage2 = getOrginalMessage();
                boolean isBrandForum = (orginalMessage2 == null || !(orginalMessage2.getExtra() instanceof LoadMoreRequestMessage)) ? false : ((LoadMoreRequestMessage) orginalMessage2.getExtra()).isBrandForum();
                if (y.getCount(threadListResIdl.data.thread_list) > 0) {
                    this.threadList = new ArrayList<>();
                    List<ThreadInfo> list2 = threadListResIdl.data.thread_list;
                    if (list2 != null) {
                        ArrayList arrayList = new ArrayList();
                        for (int i3 = 0; i3 < list2.size(); i3++) {
                            ThreadInfo threadInfo = list2.get(i3);
                            bw bwVar = new bw();
                            bwVar.setUserMap(this.userMap);
                            bwVar.a(threadInfo);
                            bwVar.bfC();
                            bwVar.edQ = isBrandForum;
                            if (!TextUtils.isEmpty(bwVar.bfO())) {
                                ak akVar = new ak();
                                akVar.zb(bwVar.bfO());
                                this.threadList.add(akVar);
                            } else {
                                this.threadList.add(bwVar);
                                JSONObject f = b.f(threadInfo);
                                if (f != null) {
                                    arrayList.add(f);
                                }
                            }
                        }
                        b.doc().eX(arrayList);
                    }
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
    }

    public BannerListData getBannerListData() {
        return this.bannerListData;
    }
}
