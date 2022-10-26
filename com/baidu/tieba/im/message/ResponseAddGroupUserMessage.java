package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import protobuf.AddGroupUsers.AddGroupUsersResIdl;
/* loaded from: classes4.dex */
public class ResponseAddGroupUserMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long groupId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseAddGroupUserMessage() {
        super(103111);
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

    public long getGroupId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.groupId;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            AddGroupUsersResIdl addGroupUsersResIdl = (AddGroupUsersResIdl) new Wire(new Class[0]).parseFrom(bArr, AddGroupUsersResIdl.class);
            setError(addGroupUsersResIdl.error.errorno.intValue());
            setErrorString(addGroupUsersResIdl.error.usermsg);
            if (getError() != 0) {
                return addGroupUsersResIdl;
            }
            this.groupId = addGroupUsersResIdl.data.groupId.longValue();
            return addGroupUsersResIdl;
        }
        return invokeIL.objValue;
    }
}
