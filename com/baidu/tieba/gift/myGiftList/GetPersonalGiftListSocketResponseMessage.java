package com.baidu.tieba.gift.myGiftList;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.tieba.z98;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetMyGift.GetMyGiftResIdl;
/* loaded from: classes6.dex */
public class GetPersonalGiftListSocketResponseMessage extends TbSocketReponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public z98 giftListData;

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

    public z98 getGiftListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.giftListData;
        }
        return (z98) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            GetMyGiftResIdl getMyGiftResIdl = (GetMyGiftResIdl) new Wire(new Class[0]).parseFrom(bArr, GetMyGiftResIdl.class);
            if (getMyGiftResIdl == null) {
                return null;
            }
            Error error = getMyGiftResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(getMyGiftResIdl.error.usermsg);
            }
            z98 z98Var = new z98();
            this.giftListData = z98Var;
            z98Var.f(getMyGiftResIdl.data);
            return getMyGiftResIdl;
        }
        return invokeIL.objValue;
    }

    public void setGiftListData(z98 z98Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, z98Var) == null) {
            this.giftListData = z98Var;
        }
    }
}
