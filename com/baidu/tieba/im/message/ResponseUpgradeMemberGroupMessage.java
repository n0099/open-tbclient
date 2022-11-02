package com.baidu.tieba.im.message;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import protobuf.UpgradeMemberGroup.UpgradeMemberGroupResIdl;
/* loaded from: classes4.dex */
public class ResponseUpgradeMemberGroupMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseUpgradeMemberGroupMessage() {
        super(103105);
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
            UpgradeMemberGroupResIdl upgradeMemberGroupResIdl = (UpgradeMemberGroupResIdl) new Wire(new Class[0]).parseFrom(bArr, UpgradeMemberGroupResIdl.class);
            setError(upgradeMemberGroupResIdl.error.errorno.intValue());
            setErrorString(upgradeMemberGroupResIdl.error.usermsg);
            return upgradeMemberGroupResIdl;
        }
        return invokeIL.objValue;
    }
}
