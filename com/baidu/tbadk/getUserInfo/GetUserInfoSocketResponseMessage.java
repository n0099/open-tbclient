package com.baidu.tbadk.getUserInfo;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.e45;
import com.repackage.f45;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetUserInfo.GetUserInfoResIdl;
/* loaded from: classes3.dex */
public class GetUserInfoSocketResponseMessage extends TbSocketReponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e45 mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetUserInfoSocketResponseMessage() {
        super(303024);
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
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, bArr)) == null) {
            if (bArr == null) {
                return null;
            }
            GetUserInfoResIdl getUserInfoResIdl = (GetUserInfoResIdl) new Wire(new Class[0]).parseFrom(bArr, GetUserInfoResIdl.class);
            Error error = getUserInfoResIdl.error;
            if (error == null) {
                return getUserInfoResIdl;
            }
            setError(error.errorno.intValue());
            setErrorString(getUserInfoResIdl.error.usermsg);
            if (getError() != 0) {
                return getUserInfoResIdl;
            }
            e45 e45Var = new e45();
            this.mData = e45Var;
            e45Var.b(getUserInfoResIdl.data);
            return getUserInfoResIdl;
        }
        return invokeIL.objValue;
    }

    public e45 getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mData : (e45) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            super.afterDispatchInBackGround(i, (int) bArr);
            e45 e45Var = this.mData;
            if (e45Var != null && e45Var.a() != null) {
                f45.d().i(this.mData.a());
            } else {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2001247));
            }
        }
    }
}
