package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.core.data.BannerListData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SpecHotTopicHelper;
import com.squareup.wire.Wire;
import d.a.c.k.e.n;
import d.a.m0.r.q.a2;
import d.a.m0.r.q.n0;
import d.a.n0.t2.i0.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
import tbclient.Error;
import tbclient.ThreadInfo;
import tbclient.ThreadList.DataRes;
import tbclient.ThreadList.ThreadListResIdl;
import tbclient.User;
/* loaded from: classes4.dex */
public class LoadMoreHttpResponseMessage extends HttpResponsedMessage {
    public BannerListData bannerListData;
    public ArrayList<n> threadList;
    public HashMap<String, MetaData> userMap;

    public LoadMoreHttpResponseMessage(int i2) {
        super(i2);
    }

    public BannerListData getBannerListData() {
        return this.bannerListData;
    }

    public ArrayList<n> getThreadList() {
        return this.threadList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        Error error;
        DataRes dataRes;
        boolean z;
        Message<?> orginalMessage;
        ThreadListResIdl threadListResIdl = (ThreadListResIdl) new Wire(new Class[0]).parseFrom(bArr, ThreadListResIdl.class);
        if (threadListResIdl == null || (error = threadListResIdl.error) == null) {
            return;
        }
        setError(error.errorno.intValue());
        setErrorString(threadListResIdl.error.usermsg);
        if (getError() == 0 && (dataRes = threadListResIdl.data) != null) {
            if (ListUtils.getCount(dataRes.user_list) > 0) {
                this.userMap = new HashMap<>();
                List<User> list = threadListResIdl.data.user_list;
                if (list != null) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        MetaData metaData = new MetaData();
                        metaData.parserProtobuf(list.get(i3));
                        String userId = metaData.getUserId();
                        if (userId != null && !userId.equals("0")) {
                            this.userMap.put(metaData.getUserId(), metaData);
                        }
                    }
                }
            }
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
            if (ListUtils.getCount(threadListResIdl.data.thread_list) > 0) {
                this.threadList = new ArrayList<>();
                List<ThreadInfo> list2 = threadListResIdl.data.thread_list;
                if (list2 != null) {
                    ArrayList arrayList = new ArrayList();
                    for (int i4 = 0; i4 < list2.size(); i4++) {
                        ThreadInfo threadInfo = list2.get(i4);
                        a2 a2Var = new a2();
                        SpecHotTopicHelper.setSpecTopicIcon(j, a2Var);
                        a2Var.u4(this.userMap);
                        a2Var.V2(threadInfo);
                        a2Var.Z2();
                        a2Var.F1 = z;
                        if (!TextUtils.isEmpty(a2Var.F0())) {
                            n0 n0Var = new n0();
                            n0Var.i(a2Var.F0());
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
}
