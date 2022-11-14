package com.baidu.tieba.homepage.topic.topicdetail.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.tieba.cj5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.CommonReq;
import tbclient.NewTopicThread.DataReq;
import tbclient.NewTopicThread.NewTopicThreadReqIdl;
/* loaded from: classes4.dex */
public class RequestGetTopicThreadMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String callFrom;

    /* renamed from: common  reason: collision with root package name */
    public CommonReq f1048common;
    public long lastFeedId;
    public long pageNo;
    public long topicId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestGetTopicThreadMessage() {
        super(CmdConfigHttp.CMD_TOPIC_THREAD, 309631);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            builder.f1305common = this.f1048common;
            builder.topic_id = Long.valueOf(this.topicId);
            builder.page_no = Long.valueOf(this.pageNo);
            builder.last_feed_id = Long.valueOf(this.lastFeedId);
            builder.call_from = this.callFrom;
            if (z || SocketAddCommonParamSwitch.getIsOn()) {
                cj5.a(builder, true);
            }
            NewTopicThreadReqIdl.Builder builder2 = new NewTopicThreadReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }

    public void setCallFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.callFrom = str;
        }
    }

    public void setCommon(CommonReq commonReq) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, commonReq) == null) {
            this.f1048common = commonReq;
        }
    }

    public void setLastFeedId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.lastFeedId = j;
        }
    }

    public void setPageNo(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.pageNo = j;
        }
    }

    public void setTopicId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.topicId = j;
        }
    }
}
