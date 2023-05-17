package com.baidu.tieba.im.message;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import protobuf.QueryUserInfos.DataRes;
import protobuf.QueryUserInfos.QueryUserInfosResIdl;
/* loaded from: classes6.dex */
public class ResponseQueryUserInfoMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DataRes resData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseQueryUserInfoMessage() {
        super(205003);
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
        this.resData = null;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            QueryUserInfosResIdl queryUserInfosResIdl = (QueryUserInfosResIdl) new Wire(new Class[0]).parseFrom(bArr, QueryUserInfosResIdl.class);
            setError(queryUserInfosResIdl.error.errorno.intValue());
            setErrorString(queryUserInfosResIdl.error.usermsg);
            if (getError() != 0) {
                return queryUserInfosResIdl;
            }
            this.resData = queryUserInfosResIdl.data;
            return queryUserInfosResIdl;
        }
        return invokeIL.objValue;
    }

    public DataRes getResData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.resData;
        }
        return (DataRes) invokeV.objValue;
    }
}
