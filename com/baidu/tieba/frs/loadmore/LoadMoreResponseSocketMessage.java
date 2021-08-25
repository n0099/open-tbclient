package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import c.a.e.l.e.n;
import c.a.p0.s.q.c2;
import c.a.p0.s.q.p0;
import c.a.q0.x2.j0.a;
import c.a.q0.x2.l0.b;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.BannerListData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.SpecHotTopicHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;
import tbclient.ThreadInfo;
import tbclient.ThreadList.ThreadListResIdl;
import tbclient.User;
/* loaded from: classes7.dex */
public class LoadMoreResponseSocketMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BannerListData bannerListData;
    public ArrayList<n> threadList;
    public HashMap<String, MetaData> userMap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadMoreResponseSocketMessage() {
        super(301002);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public BannerListData getBannerListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.bannerListData : (BannerListData) invokeV.objValue;
    }

    public ArrayList<n> getThreadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.threadList : (ArrayList) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        boolean z;
        Message<?> orginalMessage;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            ThreadListResIdl threadListResIdl = (ThreadListResIdl) new Wire(new Class[0]).parseFrom(bArr, ThreadListResIdl.class);
            setError(threadListResIdl.error.errorno.intValue());
            setErrorString(threadListResIdl.error.usermsg);
            if (getError() != 0) {
                return;
            }
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
            a.e().h(threadListResIdl.data.asp_shown_info);
            long j2 = 0;
            Message<?> orginalMessage2 = getOrginalMessage();
            if (orginalMessage2 == null || !(orginalMessage2.getExtra() instanceof LoadMoreRequestMessage)) {
                z = false;
            } else {
                LoadMoreRequestMessage loadMoreRequestMessage = (LoadMoreRequestMessage) orginalMessage2.getExtra();
                boolean isBrandForum = loadMoreRequestMessage.isBrandForum();
                long forumId = loadMoreRequestMessage.getForumId();
                z = isBrandForum;
                j2 = forumId;
            }
            this.threadList = new ArrayList<>();
            List<ThreadInfo> list2 = threadListResIdl.data.thread_list;
            if (list2 != null) {
                ArrayList arrayList = new ArrayList();
                for (int i4 = 0; i4 < list2.size(); i4++) {
                    ThreadInfo threadInfo = list2.get(i4);
                    c2 c2Var = new c2();
                    SpecHotTopicHelper.setSpecTopicIcon(j2, c2Var);
                    c2Var.u4(this.userMap);
                    c2Var.S2(threadInfo);
                    c2Var.W2();
                    c2Var.H1 = z;
                    if (!TextUtils.isEmpty(c2Var.w0())) {
                        p0 p0Var = new p0();
                        p0Var.k(c2Var.w0());
                        this.threadList.add(p0Var);
                    } else {
                        this.threadList.add(c2Var);
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
}
