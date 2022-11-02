package com.baidu.tieba.homepage.concern.message;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.RedNotify.DataRes;
import tbclient.RedNotify.RedNotify;
import tbclient.RedNotify.RedNotifyResIdl;
/* loaded from: classes4.dex */
public class CheckRedNotifySocketResMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isShowRedNotify;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckRedNotifySocketResMessage() {
        super(309476);
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

    public boolean isShowRedNotify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.isShowRedNotify;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        RedNotify redNotify;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            boolean z = false;
            RedNotifyResIdl redNotifyResIdl = (RedNotifyResIdl) new Wire(new Class[0]).parseFrom(bArr, RedNotifyResIdl.class);
            if (redNotifyResIdl != null) {
                Error error = redNotifyResIdl.error;
                if (error != null) {
                    setError(error.errorno.intValue());
                    setErrorString(redNotifyResIdl.error.errmsg);
                }
                DataRes dataRes = redNotifyResIdl.data;
                if (dataRes != null && (redNotify = dataRes.notify_data) != null) {
                    if (redNotify.notify_status.intValue() == 1) {
                        z = true;
                    }
                    this.isShowRedNotify = z;
                }
            }
            return redNotifyResIdl;
        }
        return invokeIL.objValue;
    }
}
