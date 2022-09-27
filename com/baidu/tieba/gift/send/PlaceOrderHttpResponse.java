package com.baidu.tieba.gift.send;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.yv6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.PlaceOrder.PlaceOrderResIdl;
/* loaded from: classes4.dex */
public class PlaceOrderHttpResponse extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yv6 orderInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlaceOrderHttpResponse(int i) {
        super(i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
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

    public yv6 getOrderInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.orderInfo : (yv6) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
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
            yv6 yv6Var = new yv6();
            this.orderInfo = yv6Var;
            yv6Var.c(placeOrderResIdl.data);
        }
    }
}
