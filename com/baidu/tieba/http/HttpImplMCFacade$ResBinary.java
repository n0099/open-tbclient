package com.baidu.tieba.http;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.oj8;
import com.baidu.tieba.pj8;
import com.baidu.tieba.qj8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/baidu/tieba/http/HttpImplMCFacade$ResBinary;", "Lcom/baidu/adp/framework/message/HttpResponsedMessage;", "()V", "decodeInBackGround", "", "cmd", "", "data", "", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class HttpImplMCFacade$ResBinary extends HttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpImplMCFacade$ResBinary() {
        super(CmdConfigHttp.THE_COMMON_HTTP_CMD_FOR_ALL);
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] data) throws Exception {
        HttpMessage httpMessage;
        Object obj;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Message<?> orginalMessage = getOrginalMessage();
            oj8 oj8Var = null;
            if (orginalMessage instanceof HttpMessage) {
                httpMessage = (HttpMessage) orginalMessage;
            } else {
                httpMessage = null;
            }
            if (httpMessage != null) {
                obj = httpMessage.getExtra();
            } else {
                obj = null;
            }
            if (obj instanceof oj8) {
                oj8Var = obj;
            }
            if (oj8Var == null) {
                z = pj8.a;
                if (z) {
                    throw new IllegalStateException();
                }
                return;
            }
            qj8 a = oj8Var.a();
            if (a != null) {
                a.b(data);
            }
        }
    }
}
