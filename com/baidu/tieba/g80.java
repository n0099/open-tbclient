package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.core.Call;
import com.baidu.searchbox.network.outback.core.MediaType;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.Response;
import com.baidu.tieba.q70;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.List;
/* loaded from: classes6.dex */
public final class g80 implements q70.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<q70> a;
    public x70 b;
    public final int c;
    public final Request d;
    public final Call e;
    public int f;

    public g80(List<q70> list, x70 x70Var, int i, Request request, Call call) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, x70Var, Integer.valueOf(i), request, call};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = list;
        this.b = x70Var;
        this.c = i;
        this.d = request;
        this.e = call;
    }

    @Override // com.baidu.tieba.q70.a
    public Response a(Request request) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, request)) == null) {
            return b(request, this.b);
        }
        return (Response) invokeL.objValue;
    }

    public Response b(Request request, x70 x70Var) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, x70Var)) == null) {
            if (this.c < this.a.size()) {
                this.f++;
                g80 g80Var = new g80(this.a, x70Var, this.c + 1, request, this.e);
                q70 q70Var = this.a.get(this.c);
                Response a = q70Var.a(g80Var);
                if (a != null) {
                    if (a.body() != null) {
                        a.getStatRecord().responseLength = a.body().contentLength();
                        a.getStatRecord().finishTs = System.currentTimeMillis();
                        MediaType contentType = a.body().contentType();
                        if (contentType != null) {
                            a.getStatRecord().contentType = contentType.toString();
                        }
                        return a;
                    }
                    throw new IllegalStateException("interceptor " + q70Var + " returned a response with no body");
                }
                throw new NullPointerException("interceptor " + q70Var + " returned null");
            }
            throw new AssertionError();
        }
        return (Response) invokeLL.objValue;
    }

    public Call call() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.e;
        }
        return (Call) invokeV.objValue;
    }

    @Override // com.baidu.tieba.q70.a
    public x70 connection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.b;
        }
        return (x70) invokeV.objValue;
    }

    @Override // com.baidu.tieba.q70.a
    public Request request() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.d;
        }
        return (Request) invokeV.objValue;
    }
}
