package com.baidu.tieba.homepage.topic.topicdetail.message;

import c.a.q0.d1.z;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.CommonReq;
import tbclient.NewTopicThread.DataReq;
import tbclient.NewTopicThread.NewTopicThreadReqIdl;
/* loaded from: classes7.dex */
public class RequestGetTopicThreadMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String callFrom;

    /* renamed from: common  reason: collision with root package name */
    public CommonReq f52541common;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            builder.f80165common = this.f52541common;
            builder.topic_id = Long.valueOf(this.topicId);
            builder.page_no = Long.valueOf(this.pageNo);
            builder.last_feed_id = Long.valueOf(this.lastFeedId);
            builder.call_from = this.callFrom;
            if (z) {
                z.a(builder, true);
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
            this.f52541common = commonReq;
        }
    }

    public void setLastFeedId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j2) == null) {
            this.lastFeedId = j2;
        }
    }

    public void setPageNo(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j2) == null) {
            this.pageNo = j2;
        }
    }

    public void setTopicId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
            this.topicId = j2;
        }
    }
}
