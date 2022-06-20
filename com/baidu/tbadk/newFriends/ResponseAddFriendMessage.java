package com.baidu.tbadk.newFriends;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.AddFriend.AddFriendResIdl;
/* loaded from: classes3.dex */
public class ResponseAddFriendMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long friendId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseAddFriendMessage() {
        super(304100);
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

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            AddFriendResIdl addFriendResIdl = (AddFriendResIdl) new Wire(new Class[0]).parseFrom(bArr, AddFriendResIdl.class);
            setError(addFriendResIdl.error.errorno.intValue());
            setErrorString(addFriendResIdl.error.usermsg);
            if (getError() != 0) {
                return addFriendResIdl;
            }
            this.friendId = addFriendResIdl.data.friend_id.longValue();
            return addFriendResIdl;
        }
        return invokeIL.objValue;
    }

    public long getFriendId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.friendId : invokeV.longValue;
    }
}
