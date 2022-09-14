package com.baidu.tieba.frs.loadmore;

import android.text.TextUtils;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.BannerListData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SpecHotTopicHelper;
import com.baidu.tieba.Cdo;
import com.baidu.tieba.bs4;
import com.baidu.tieba.ye8;
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
import tbclient.Error;
import tbclient.ThreadInfo;
import tbclient.ThreadList.DataRes;
import tbclient.ThreadList.ThreadListResIdl;
import tbclient.User;
/* loaded from: classes4.dex */
public class LoadMoreHttpResponseMessage extends HttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BannerListData bannerListData;
    public ArrayList<Cdo> threadList;
    public HashMap<String, MetaData> userMap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadMoreHttpResponseMessage(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
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

    public ArrayList<Cdo> getThreadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.threadList : (ArrayList) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Error error;
        DataRes dataRes;
        boolean z;
        Message<?> orginalMessage;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
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
                        for (int i3 = 0; i3 < list2.size(); i3++) {
                            ThreadInfo threadInfo = list2.get(i3);
                            ThreadData threadData = new ThreadData();
                            SpecHotTopicHelper.setSpecTopicIcon(j, threadData);
                            threadData.setUserMap(this.userMap);
                            threadData.parserProtobuf(threadInfo);
                            threadData.parser_title();
                            threadData.isFromBrandForum = z;
                            if (!TextUtils.isEmpty(threadData.getLegoCard())) {
                                bs4 bs4Var = new bs4();
                                bs4Var.h(threadData.getLegoCard());
                                this.threadList.add(bs4Var);
                            } else {
                                this.threadList.add(threadData);
                                JSONObject b = ye8.b(threadInfo);
                                if (b != null) {
                                    arrayList.add(b);
                                }
                            }
                        }
                        ye8.f().h("FRS", arrayList);
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
}
