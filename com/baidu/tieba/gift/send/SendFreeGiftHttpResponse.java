package com.baidu.tieba.gift.send;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.SendFreeGift.DataRes;
import tbclient.SendFreeGift.SendFreeGiftResIdl;
/* loaded from: classes6.dex */
public class SendFreeGiftHttpResponse extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int freeChance;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendFreeGiftHttpResponse(int i) {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        SendFreeGiftResIdl sendFreeGiftResIdl;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) != null) || (sendFreeGiftResIdl = (SendFreeGiftResIdl) new Wire(new Class[0]).parseFrom(bArr, SendFreeGiftResIdl.class)) == null) {
            return;
        }
        Error error = sendFreeGiftResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(sendFreeGiftResIdl.error.usermsg);
        }
        DataRes dataRes = sendFreeGiftResIdl.data;
        if (dataRes != null) {
            this.freeChance = dataRes.free_chance.intValue();
        }
    }

    public int getFreeChance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.freeChance;
        }
        return invokeV.intValue;
    }
}
