package com.baidu.tieba.addresslist.relationship;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.hj5;
import com.repackage.ys4;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetAddressList.GetAddressListResIdl;
/* loaded from: classes3.dex */
public class ResponseGetAddressListMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public hj5 mAddressListData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseGetAddressListMessage() {
        super(304001);
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

    public hj5 getAddressListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mAddressListData : (hj5) invokeV.objValue;
    }

    public void setAddressListData(hj5 hj5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, hj5Var) == null) {
            this.mAddressListData = hj5Var;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetAddressListResIdl getAddressListResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) || (getAddressListResIdl = (GetAddressListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetAddressListResIdl.class)) == null) {
            return;
        }
        if (getAddressListResIdl.data != null) {
            hj5 hj5Var = new hj5();
            this.mAddressListData = hj5Var;
            if (hj5Var.c(getAddressListResIdl.data)) {
                ys4 k = ys4.k();
                k.u("get_addresslist_switch" + TbadkCoreApplication.getCurrentAccount(), true);
            }
        }
        Error error = getAddressListResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(getAddressListResIdl.error.errmsg);
        }
    }
}
