package com.baidu.tieba.frs.itemtab;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.bq7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.ItemPage.ItemPageResIdl;
/* loaded from: classes5.dex */
public class FrsItemTabSocketResponseMessage extends MvcSocketResponsedMessage<bq7, ItemPageResIdl> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsItemTabSocketResponseMessage() {
        super(309673);
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

    /* JADX DEBUG: Return type fixed from 'java.lang.Class' to match base method */
    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
    public Class<ItemPageResIdl> getProtobufResponseIdlClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return ItemPageResIdl.class;
        }
        return (Class) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Error error;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            bq7 bq7Var = new bq7();
            ItemPageResIdl itemPageResIdl = (ItemPageResIdl) new Wire(new Class[0]).parseFrom(bArr, ItemPageResIdl.class);
            bq7Var.a(itemPageResIdl.data);
            if (itemPageResIdl != null && (error = itemPageResIdl.error) != null) {
                Integer num = error.errorno;
                if (num != null) {
                    setError(num.intValue());
                }
                setErrorString(itemPageResIdl.error.usermsg);
            }
            setData(bq7Var);
            return itemPageResIdl;
        }
        return invokeIL.objValue;
    }
}
