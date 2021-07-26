package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.m.b;
import tbclient.ForumMenu.DataReq;
import tbclient.ForumMenu.ForumMenuReqIdl;
/* loaded from: classes4.dex */
public class RequestOfficialBarMenuLocalMessage extends CustomMessage<Object> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String forum_id;
    public long timestamp;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestOfficialBarMenuLocalMessage() {
        super(2001177);
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

    public Object encode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            builder.forum_id = Integer.valueOf(b.d(getForum_id(), 0));
            builder.update_time = Integer.valueOf((int) getTimestamp());
            ForumMenuReqIdl.Builder builder2 = new ForumMenuReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeV.objValue;
    }

    public String getForum_id() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.forum_id : (String) invokeV.objValue;
    }

    public long getTimestamp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.timestamp : invokeV.longValue;
    }

    public void setForum_id(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.forum_id = str;
        }
    }

    public void setTimestamp(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.timestamp = j;
        }
    }
}
