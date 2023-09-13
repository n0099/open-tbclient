package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.core.MediaType;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.RequestBody;
import com.baidu.searchbox.network.outback.core.Response;
import com.baidu.searchbox.network.support.cookie.Cookie;
import com.baidu.searchbox.network.support.cookie.CookieHandler;
import com.baidu.searchbox.network.support.cookie.CookieJar;
import com.baidu.tieba.s60;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.List;
/* loaded from: classes6.dex */
public final class g70 implements s60 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final CookieJar a;
    public x60 b;

    public g70(CookieJar cookieJar, x60 x60Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cookieJar, x60Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cookieJar;
        this.b = x60Var;
    }

    @Override // com.baidu.tieba.s60
    public Response a(s60.a aVar) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            Request request = aVar.request();
            request.getNetworkStatRecord().startTs = System.currentTimeMillis();
            Request.Builder newBuilder = request.newBuilder();
            newBuilder.removeHeader("bdapp-support-brotli");
            RequestBody body = request.body();
            if (body != null) {
                MediaType contentType = body.contentType();
                if (contentType != null) {
                    newBuilder.header("Content-Type", contentType.toString());
                }
                long contentLength = body.contentLength();
                if (contentLength != -1) {
                    newBuilder.header("Content-Length", Long.toString(contentLength));
                    newBuilder.removeHeader("Transfer-Encoding");
                } else {
                    newBuilder.header("Transfer-Encoding", "chunked");
                    newBuilder.removeHeader("Content-Length");
                }
            }
            List<Cookie> loadForRequest = this.a.loadForRequest(request.url());
            if (!loadForRequest.isEmpty()) {
                newBuilder.header("Cookie", b(loadForRequest));
            }
            if (request.header("User-Agent") == null && this.b.C() != null) {
                newBuilder.header("User-Agent", this.b.C());
            }
            Response a = aVar.a(newBuilder.build());
            CookieHandler.receiveHeaders(this.a, request, a.headers());
            return a.newBuilder().request(request).build();
        }
        return (Response) invokeL.objValue;
    }

    public final String b(List<Cookie> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list)) == null) {
            StringBuilder sb = new StringBuilder();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    sb.append("; ");
                }
                Cookie cookie = list.get(i);
                sb.append(cookie.name());
                sb.append('=');
                sb.append(cookie.value());
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}
