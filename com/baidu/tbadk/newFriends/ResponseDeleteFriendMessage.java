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
import tbclient.DeleteFriend.DeleteFriendResIdl;
/* loaded from: classes5.dex */
public class ResponseDeleteFriendMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long friendId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseDeleteFriendMessage() {
        super(304102);
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

    public long getFriendId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.friendId;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            DeleteFriendResIdl deleteFriendResIdl = (DeleteFriendResIdl) new Wire(new Class[0]).parseFrom(bArr, DeleteFriendResIdl.class);
            setError(deleteFriendResIdl.error.errorno.intValue());
            setErrorString(deleteFriendResIdl.error.usermsg);
            if (getError() != 0) {
                return deleteFriendResIdl;
            }
            this.friendId = deleteFriendResIdl.data.friend_id.longValue();
            return deleteFriendResIdl;
        }
        return invokeIL.objValue;
    }
}
