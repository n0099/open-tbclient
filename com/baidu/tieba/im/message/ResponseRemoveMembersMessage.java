package com.baidu.tieba.im.message;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import protobuf.DelGroupUsers.DelGroupUsersResIdl;
/* loaded from: classes4.dex */
public class ResponseRemoveMembersMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String groupId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseRemoveMembersMessage() {
        super(103112);
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

    public String getGroupId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.groupId;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            DelGroupUsersResIdl delGroupUsersResIdl = (DelGroupUsersResIdl) new Wire(new Class[0]).parseFrom(bArr, DelGroupUsersResIdl.class);
            setError(delGroupUsersResIdl.error.errorno.intValue());
            setErrorString(delGroupUsersResIdl.error.usermsg);
            if (getError() != 0) {
                return delGroupUsersResIdl;
            }
            setGroupId(String.valueOf(delGroupUsersResIdl.data.groupId));
            return delGroupUsersResIdl;
        }
        return invokeIL.objValue;
    }

    public void setGroupId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.groupId = str;
        }
    }
}
