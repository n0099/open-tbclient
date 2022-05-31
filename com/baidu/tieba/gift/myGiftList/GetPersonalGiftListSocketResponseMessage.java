package com.baidu.tieba.gift.myGiftList;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.hq6;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetMyGift.GetMyGiftResIdl;
/* loaded from: classes3.dex */
public class GetPersonalGiftListSocketResponseMessage extends TbSocketReponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hq6 giftListData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetPersonalGiftListSocketResponseMessage() {
        super(309052);
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

    public hq6 getGiftListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.giftListData : (hq6) invokeV.objValue;
    }

    public void setGiftListData(hq6 hq6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hq6Var) == null) {
            this.giftListData = hq6Var;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.websockt.TbSocketReponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
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
        hq6 hq6Var = new hq6();
        this.giftListData = hq6Var;
        hq6Var.f(getMyGiftResIdl.data);
    }
}
