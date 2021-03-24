package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.BannerListData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.SpecHotTopicHelper;
import com.squareup.wire.Wire;
import d.b.b.j.e.n;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.n0;
import d.b.i0.r2.a0.a;
import d.b.i0.r2.b0.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
import tbclient.ThreadInfo;
import tbclient.ThreadList.ThreadListResIdl;
import tbclient.User;
/* loaded from: classes4.dex */
public class LoadMoreResponseSocketMessage extends SocketResponsedMessage {
    public BannerListData bannerListData;
    public ArrayList<n> threadList;
    public HashMap<String, MetaData> userMap;

    public LoadMoreResponseSocketMessage() {
        super(301002);
    }

    public BannerListData getBannerListData() {
        return this.bannerListData;
    }

    public ArrayList<n> getThreadList() {
        return this.threadList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        boolean z;
        Message<?> orginalMessage;
        ThreadListResIdl threadListResIdl = (ThreadListResIdl) new Wire(new Class[0]).parseFrom(bArr, ThreadListResIdl.class);
        setError(threadListResIdl.error.errorno.intValue());
        setErrorString(threadListResIdl.error.usermsg);
        if (getError() != 0) {
            return;
        }
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
        a.e().h(threadListResIdl.data.asp_shown_info);
        long j = 0;
        Message<?> orginalMessage2 = getOrginalMessage();
        if (orginalMessage2 == null || !(orginalMessage2.getExtra() instanceof LoadMoreRequestMessage)) {
            z = false;
        } else {
            LoadMoreRequestMessage loadMoreRequestMessage = (LoadMoreRequestMessage) orginalMessage2.getExtra();
            boolean isBrandForum = loadMoreRequestMessage.isBrandForum();
            long forumId = loadMoreRequestMessage.getForumId();
            z = isBrandForum;
            j = forumId;
        }
        this.threadList = new ArrayList<>();
        List<ThreadInfo> list2 = threadListResIdl.data.thread_list;
        if (list2 != null) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < list2.size(); i3++) {
                ThreadInfo threadInfo = list2.get(i3);
                a2 a2Var = new a2();
                SpecHotTopicHelper.setSpecTopicIcon(j, a2Var);
                a2Var.p4(this.userMap);
                a2Var.Q2(threadInfo);
                a2Var.U2();
                a2Var.D1 = z;
                if (!TextUtils.isEmpty(a2Var.E0())) {
                    n0 n0Var = new n0();
                    n0Var.n(a2Var.E0());
                    this.threadList.add(n0Var);
                } else {
                    this.threadList.add(a2Var);
                    JSONObject b2 = b.b(threadInfo);
                    if (b2 != null) {
                        arrayList.add(b2);
                    }
                }
            }
            b.f().h("FRS", arrayList);
        }
        this.bannerListData = null;
        if (threadListResIdl.data.banner_list == null || (orginalMessage = getOrginalMessage()) == null || orginalMessage.getExtra() == null || !(orginalMessage.getExtra() instanceof LoadMoreRequestMessage)) {
            return;
        }
        LoadMoreRequestMessage loadMoreRequestMessage2 = (LoadMoreRequestMessage) orginalMessage.getExtra();
        if (loadMoreRequestMessage2.getPageType() == 1 || loadMoreRequestMessage2.getPageType() == 2 || loadMoreRequestMessage2.getPageType() == 3) {
            BannerListData bannerListData = new BannerListData();
            this.bannerListData = bannerListData;
            bannerListData.parserProtobuf(threadListResIdl.data.banner_list);
        }
    }
}
