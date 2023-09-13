package com.baidu.tieba.gift.send;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.tieba.uz7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.PlaceOrder.PlaceOrderResIdl;
/* loaded from: classes6.dex */
public class PlaceOrderSocketResponse extends TbSocketReponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public uz7 orderInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlaceOrderSocketResponse() {
        super(309051);
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

    public uz7 getOrderInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.orderInfo;
        }
        return (uz7) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            PlaceOrderResIdl placeOrderResIdl = (PlaceOrderResIdl) new Wire(new Class[0]).parseFrom(bArr, PlaceOrderResIdl.class);
            if (placeOrderResIdl == null) {
                return null;
            }
            Error error = placeOrderResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(placeOrderResIdl.error.usermsg);
            }
            if (placeOrderResIdl.data != null) {
                uz7 uz7Var = new uz7();
                this.orderInfo = uz7Var;
                uz7Var.c(placeOrderResIdl.data);
            }
            return placeOrderResIdl;
        }
        return invokeIL.objValue;
    }
}
