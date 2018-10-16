package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.data.BannerListData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.v;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.ThreadInfo;
import tbclient.ThreadList.ThreadListResIdl;
import tbclient.User;
/* loaded from: classes6.dex */
public class LoadMoreHttpResponseMessage extends HttpResponsedMessage {
    private BannerListData bannerListData;
    private ArrayList<h> threadList;
    private HashMap<String, MetaData> userMap;

    public LoadMoreHttpResponseMessage(int i) {
        super(i);
    }

    public ArrayList<h> getThreadList() {
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
                if (v.I(threadListResIdl.data.user_list) > 0) {
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
                if (v.I(threadListResIdl.data.thread_list) > 0) {
                    this.threadList = new ArrayList<>();
                    List<ThreadInfo> list2 = threadListResIdl.data.thread_list;
                    if (list2 != null) {
                        for (int i3 = 0; i3 < list2.size(); i3++) {
                            bb bbVar = new bb();
                            bbVar.setUserMap(this.userMap);
                            bbVar.a(list2.get(i3));
                            bbVar.setCurrentPage(3);
                            bbVar.zf();
                            bbVar.arq = isBrandForum;
                            if (!TextUtils.isEmpty(bbVar.zp())) {
                                ab abVar = new ab();
                                abVar.dP(bbVar.zp());
                                this.threadList.add(abVar);
                            } else {
                                this.threadList.add(bbVar);
                            }
                        }
                    }
                }
                this.bannerListData = null;
                if (threadListResIdl.data.banner_list != null && (orginalMessage = getOrginalMessage()) != null && orginalMessage.getExtra() != null && (orginalMessage.getExtra() instanceof LoadMoreRequestMessage) && ((LoadMoreRequestMessage) orginalMessage.getExtra()).getPageType() == 1) {
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
