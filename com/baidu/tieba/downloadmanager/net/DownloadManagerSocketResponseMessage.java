package com.baidu.tieba.downloadmanager.net;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tieba.k96;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.ItemManage.ItemManageResIdl;
/* loaded from: classes3.dex */
public class DownloadManagerSocketResponseMessage extends MvcSocketResponsedMessage<k96, ItemManageResIdl> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadManagerSocketResponseMessage() {
        super(309715);
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
    public Class<ItemManageResIdl> getProtobufResponseIdlClass() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return ItemManageResIdl.class;
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
            k96 k96Var = new k96();
            ItemManageResIdl itemManageResIdl = (ItemManageResIdl) new Wire(new Class[0]).parseFrom(bArr, ItemManageResIdl.class);
            k96Var.b(itemManageResIdl.data);
            if (itemManageResIdl != null && (error = itemManageResIdl.error) != null) {
                Integer num = error.errorno;
                if (num != null) {
                    setError(num.intValue());
                }
                setErrorString(itemManageResIdl.error.usermsg);
            }
            setData(k96Var);
            return itemManageResIdl;
        }
        return invokeIL.objValue;
    }
}
