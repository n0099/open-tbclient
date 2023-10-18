package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.core.Call;
import com.baidu.searchbox.network.outback.core.MediaType;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.Response;
import com.baidu.tieba.o10;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.List;
/* loaded from: classes5.dex */
public final class e20 implements o10.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<o10> a;
    public v10 b;
    public final int c;
    public final Request d;
    public final Call e;
    public int f;

    public e20(List<o10> list, v10 v10Var, int i, Request request, Call call) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, v10Var, Integer.valueOf(i), request, call};
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
        this.b = v10Var;
        this.c = i;
        this.d = request;
        this.e = call;
    }

    @Override // com.baidu.tieba.o10.a
    public Response a(Request request) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, request)) == null) {
            return b(request, this.b);
        }
        return (Response) invokeL.objValue;
    }

    public Response b(Request request, v10 v10Var) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, request, v10Var)) == null) {
            if (this.c < this.a.size()) {
                this.f++;
                e20 e20Var = new e20(this.a, v10Var, this.c + 1, request, this.e);
                o10 o10Var = this.a.get(this.c);
                Response a = o10Var.a(e20Var);
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
                    throw new IllegalStateException("interceptor " + o10Var + " returned a response with no body");
                }
                throw new NullPointerException("interceptor " + o10Var + " returned null");
            }
            throw new AssertionError();
        }
        return (Response) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.o10.a
    public v10 connection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (v10) invokeV.objValue;
    }

    @Override // com.baidu.tieba.o10.a
    public Request request() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return (Request) invokeV.objValue;
    }
}
