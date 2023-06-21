package com.baidu.tieba.addresslist.relationship;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.i76;
import com.baidu.tieba.o95;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetAddressList.GetAddressListResIdl;
/* loaded from: classes5.dex */
public class ResponseGetAddressListMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public i76 mAddressListData;

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

    public i76 getAddressListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mAddressListData;
        }
        return (i76) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            GetAddressListResIdl getAddressListResIdl = (GetAddressListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetAddressListResIdl.class);
            if (getAddressListResIdl != null) {
                if (getAddressListResIdl.data != null) {
                    i76 i76Var = new i76();
                    this.mAddressListData = i76Var;
                    if (i76Var.c(getAddressListResIdl.data)) {
                        o95 p = o95.p();
                        p.A("get_addresslist_switch" + TbadkCoreApplication.getCurrentAccount(), true);
                    }
                }
                Error error = getAddressListResIdl.error;
                if (error != null) {
                    setError(error.errorno.intValue());
                    setErrorString(getAddressListResIdl.error.errmsg);
                }
            }
            return getAddressListResIdl;
        }
        return invokeIL.objValue;
    }
}
