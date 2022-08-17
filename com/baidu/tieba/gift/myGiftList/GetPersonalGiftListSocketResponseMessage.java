package com.baidu.tieba.gift.myGiftList;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.qt6;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetMyGift.GetMyGiftResIdl;
/* loaded from: classes3.dex */
public class GetPersonalGiftListSocketResponseMessage extends TbSocketReponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qt6 giftListData;

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
            qt6 qt6Var = new qt6();
            this.giftListData = qt6Var;
            qt6Var.f(getMyGiftResIdl.data);
            return getMyGiftResIdl;
        }
        return invokeIL.objValue;
    }

    public qt6 getGiftListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.giftListData : (qt6) invokeV.objValue;
    }

    public void setGiftListData(qt6 qt6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, qt6Var) == null) {
            this.giftListData = qt6Var;
        }
    }
}
