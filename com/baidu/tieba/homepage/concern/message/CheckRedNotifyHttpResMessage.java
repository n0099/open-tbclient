package com.baidu.tieba.homepage.concern.message;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
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
public class CheckRedNotifyHttpResMessage extends HttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isShowRedNotify;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckRedNotifyHttpResMessage() {
        super(CmdConfigHttp.CMD_CONCERN_CHECK_RED_NOTIFY);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.isShowRedNotify;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        RedNotify redNotify;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
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
        }
    }
}
