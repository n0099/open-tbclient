package com.baidu.tieba.homepage.gamevideo.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.RecomVertical.DataRes;
import tbclient.RecomVertical.RecomVerticalResIdl;
/* loaded from: classes4.dex */
public class GameVideoSocketResMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DataRes mResultData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameVideoSocketResMessage() {
        super(309646);
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
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            RecomVerticalResIdl recomVerticalResIdl = (RecomVerticalResIdl) new Wire(new Class[0]).parseFrom(bArr, RecomVerticalResIdl.class);
            if (recomVerticalResIdl != null) {
                Error error = recomVerticalResIdl.error;
                if (error != null) {
                    setError(error.errorno.intValue());
                    setErrorString(recomVerticalResIdl.error.errmsg);
                }
                this.mResultData = recomVerticalResIdl.data;
            }
            return recomVerticalResIdl;
        }
        return invokeIL.objValue;
    }
}
