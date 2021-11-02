package com.baidu.tieba.im.model;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.AddMsgRecord.AddMsgRecordResIdl;
import tbclient.AddMsgRecord.DataRes;
import tbclient.Error;
/* loaded from: classes9.dex */
public class AddMsgRecordSocketResponse extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DataRes mData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddMsgRecordSocketResponse() {
        super(309265);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
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

    public DataRes getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mData : (DataRes) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        AddMsgRecordResIdl addMsgRecordResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) || (addMsgRecordResIdl = (AddMsgRecordResIdl) new Wire(new Class[0]).parseFrom(bArr, AddMsgRecordResIdl.class)) == null) {
            return;
        }
        Error error = addMsgRecordResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(addMsgRecordResIdl.error.errmsg);
        }
        DataRes dataRes = addMsgRecordResIdl.data;
        if (dataRes == null) {
            return;
        }
        this.mData = dataRes;
    }
}
