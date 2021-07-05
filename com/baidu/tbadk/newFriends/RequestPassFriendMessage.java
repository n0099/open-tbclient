package com.baidu.tbadk.newFriends;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.websockt.TbSocketMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.PassFriend.PassFriendReqIdl;
import tbclient.PassFriend.ReqData;
/* loaded from: classes4.dex */
public class RequestPassFriendMessage extends TbSocketMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long friendId;
    public String st_type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RequestPassFriendMessage() {
        super(304101);
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

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ReqData.Builder builder = new ReqData.Builder();
            builder.friend_id = Long.valueOf(getFriendId());
            builder.st_type = getSt_type();
            PassFriendReqIdl.Builder builder2 = new PassFriendReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeV.objValue;
    }

    public long getFriendId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.friendId : invokeV.longValue;
    }

    public String getSt_type() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.st_type : (String) invokeV.objValue;
    }

    public void setFriendId(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048579, this, j, str) == null) {
            this.friendId = j;
            this.st_type = str;
        }
    }
}
