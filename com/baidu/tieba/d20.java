package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.Response;
import com.baidu.searchbox.network.outback.statistics.NetworkStatRecord;
import com.baidu.tieba.f20;
import com.baidu.tieba.s20;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
/* loaded from: classes5.dex */
public class d20 implements f20 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final p20 a;
    public m20 b;
    public boolean c;

    public d20(k20 k20Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {k20Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        s20.b b = s20.b();
        b.c(k20Var);
        this.a = b.b();
    }

    @Override // com.baidu.tieba.f20
    public Response a(f20.a aVar) throws IOException {
        InterceptResult invokeL;
        long contentLength;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            if (!this.c) {
                v20 v20Var = (v20) aVar;
                Request request = aVar.request();
                NetworkStatRecord networkStatRecord = request.getNetworkStatRecord();
                if (request.body() == null) {
                    contentLength = 0;
                } else {
                    contentLength = request.body().contentLength();
                }
                networkStatRecord.requestBodyLength = contentLength;
                m20 c = c(request);
                this.b = c;
                return v20Var.b(request, c);
            }
            throw new IOException("The request has been cancelled.");
        }
        return (Response) invokeL.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.c = true;
            m20 m20Var = this.b;
            if (m20Var != null) {
                m20Var.disconnect();
            }
        }
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public final m20 c(Request request) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, request)) == null) {
            return this.a.a(request);
        }
        return (m20) invokeL.objValue;
    }
}
