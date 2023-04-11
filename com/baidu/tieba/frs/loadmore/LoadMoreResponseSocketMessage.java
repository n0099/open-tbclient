package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.BannerListData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SpecHotTopicHelper;
import com.baidu.tieba.ay4;
import com.baidu.tieba.fc9;
import com.baidu.tieba.hn;
import com.baidu.tieba.ic9;
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
/* loaded from: classes4.dex */
public class LoadMoreResponseSocketMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BannerListData bannerListData;
    public ArrayList<hn> threadList;
    public HashMap<String, MetaData> userMap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadMoreResponseSocketMessage() {
        super(301002);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.bannerListData;
        }
        return (BannerListData) invokeV.objValue;
    }

    public ArrayList<hn> getThreadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.threadList;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        boolean z;
        Message<?> orginalMessage;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            ThreadListResIdl threadListResIdl = (ThreadListResIdl) new Wire(new Class[0]).parseFrom(bArr, ThreadListResIdl.class);
            setError(threadListResIdl.error.errorno.intValue());
            setErrorString(threadListResIdl.error.usermsg);
            if (getError() != 0) {
                return threadListResIdl;
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
            fc9.e().h(threadListResIdl.data.asp_shown_info);
            long j = 0;
            Message<?> orginalMessage2 = getOrginalMessage();
            if (orginalMessage2 != null && (orginalMessage2.getExtra() instanceof LoadMoreRequestMessage)) {
                LoadMoreRequestMessage loadMoreRequestMessage = (LoadMoreRequestMessage) orginalMessage2.getExtra();
                boolean isBrandForum = loadMoreRequestMessage.isBrandForum();
                long forumId = loadMoreRequestMessage.getForumId();
                z = isBrandForum;
                j = forumId;
            } else {
                z = false;
            }
            this.threadList = new ArrayList<>();
            List<ThreadInfo> list2 = threadListResIdl.data.thread_list;
            if (list2 != null) {
                ArrayList arrayList = new ArrayList();
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    ThreadInfo threadInfo = list2.get(i3);
                    ThreadData threadData = new ThreadData();
                    SpecHotTopicHelper.setSpecTopicIcon(j, threadData);
                    threadData.setUserMap(this.userMap);
                    threadData.parserProtobuf(threadInfo);
                    threadData.parser_title();
                    threadData.isFromBrandForum = z;
                    if (!TextUtils.isEmpty(threadData.getLegoCard())) {
                        ay4 ay4Var = new ay4();
                        ay4Var.e(threadData.getLegoCard());
                        this.threadList.add(ay4Var);
                    } else {
                        this.threadList.add(threadData);
                        JSONObject b = ic9.b(threadInfo);
                        if (b != null) {
                            arrayList.add(b);
                        }
                    }
                }
                ic9.f().h("FRS", arrayList);
            }
            this.bannerListData = null;
            if (threadListResIdl.data.banner_list != null && (orginalMessage = getOrginalMessage()) != null && orginalMessage.getExtra() != null && (orginalMessage.getExtra() instanceof LoadMoreRequestMessage)) {
                LoadMoreRequestMessage loadMoreRequestMessage2 = (LoadMoreRequestMessage) orginalMessage.getExtra();
                if (loadMoreRequestMessage2.getPageType() == 1 || loadMoreRequestMessage2.getPageType() == 2 || loadMoreRequestMessage2.getPageType() == 3) {
                    BannerListData bannerListData = new BannerListData();
                    this.bannerListData = bannerListData;
                    bannerListData.parserProtobuf(threadListResIdl.data.banner_list);
                }
            }
            return threadListResIdl;
        }
        return invokeIL.objValue;
    }
}
