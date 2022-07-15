package com.baidu.tieba.gift.myGiftList;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.yr6;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetMyGift.GetMyGiftResIdl;
/* loaded from: classes3.dex */
public class GetPersonalGiftListHttpResponseMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public yr6 giftListData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetPersonalGiftListHttpResponseMessage(int i) {
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

    public yr6 getGiftListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.giftListData : (yr6) invokeV.objValue;
    }

    public void setGiftListData(yr6 yr6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, yr6Var) == null) {
            this.giftListData = yr6Var;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetMyGiftResIdl getMyGiftResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) || (getMyGiftResIdl = (GetMyGiftResIdl) new Wire(new Class[0]).parseFrom(bArr, GetMyGiftResIdl.class)) == null) {
            return;
        }
        Error error = getMyGiftResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getMyGiftResIdl.error.usermsg);
        }
        yr6 yr6Var = new yr6();
        this.giftListData = yr6Var;
        yr6Var.f(getMyGiftResIdl.data);
    }
}
