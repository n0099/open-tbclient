package com.baidu.tieba.home;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetUserBfbInfo.DataRes;
import tbclient.GetUserBfbInfo.GetUserBfbInfoResIdl;
import tbclient.UserBfbInfo;
/* loaded from: classes4.dex */
public class BfbInfoSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public UserBfbInfo bfbInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BfbInfoSocketResponseMessage() {
        super(309366);
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

    public UserBfbInfo getBfbInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.bfbInfo;
        }
        return (UserBfbInfo) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            GetUserBfbInfoResIdl getUserBfbInfoResIdl = (GetUserBfbInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetUserBfbInfoResIdl.class);
            if (getUserBfbInfoResIdl == null) {
                return null;
            }
            Error error = getUserBfbInfoResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(getUserBfbInfoResIdl.error.usermsg);
            }
            DataRes dataRes = getUserBfbInfoResIdl.data;
            if (dataRes != null) {
                this.bfbInfo = dataRes.bfb;
            }
            return getUserBfbInfoResIdl;
        }
        return invokeIL.objValue;
    }
}
