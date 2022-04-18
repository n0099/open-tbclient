package com.baidu.tieba.gift.send;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.gt6;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.PlaceOrder.PlaceOrderResIdl;
/* loaded from: classes3.dex */
public class PlaceOrderSocketResponse extends TbSocketReponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gt6 orderInfo;

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

    public gt6 getOrderInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.orderInfo : (gt6) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.websockt.TbSocketReponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        PlaceOrderResIdl placeOrderResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) || (placeOrderResIdl = (PlaceOrderResIdl) new Wire(new Class[0]).parseFrom(bArr, PlaceOrderResIdl.class)) == null) {
            return;
        }
        Error error = placeOrderResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(placeOrderResIdl.error.usermsg);
        }
        if (placeOrderResIdl.data != null) {
            gt6 gt6Var = new gt6();
            this.orderInfo = gt6Var;
            gt6Var.c(placeOrderResIdl.data);
        }
    }
}
