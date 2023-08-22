package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.transmit.transmitter.exception.ExceptionMessage;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.HttpRuntime;
import com.baidu.searchbox.http.callback.ResponseCallback;
import com.baidu.searchbox.http.request.HttpRequestBuilder;
import com.baidu.tieba.gi4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.ConnectionPool;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.apache.http.client.methods.HttpPut;
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes6.dex */
public class hi4 extends HttpManager {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static volatile hi4 c;
    public static volatile hi4 d;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* loaded from: classes6.dex */
    public class a extends ResponseCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onFail(Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, exc) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public void onSuccess(Object obj, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, i) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.callback.ResponseCallback
        public Object parseResponse(Response response, int i) throws Exception {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, response, i)) == null) ? response : invokeLI.objValue;
        }

        public a(hi4 hi4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hi4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947824662, "Lcom/baidu/tieba/hi4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947824662, "Lcom/baidu/tieba/hi4;");
                return;
            }
        }
        b = vh4.c();
    }

    public wh4 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new wh4(this);
        }
        return (wh4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: b */
    public xh4 deleteRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new xh4(this);
        }
        return (xh4) invokeV.objValue;
    }

    public boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }

    public OkHttpClient.Builder i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return getOkHttpClient().newBuilder();
        }
        return (OkHttpClient.Builder) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: j */
    public yh4 getRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return new yh4(this);
        }
        return (yh4) invokeV.objValue;
    }

    public final ResponseCallback k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return new a(this);
        }
        return (ResponseCallback) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: m */
    public zh4 headerRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return new zh4(this);
        }
        return (zh4) invokeV.objValue;
    }

    public ai4 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return new ai4(this);
        }
        return (ai4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: p */
    public ci4 postFormRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return new ci4(this);
        }
        return (ci4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: q */
    public bi4 postRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return new bi4(this);
        }
        return (bi4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: r */
    public di4 postStringRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return new di4(this);
        }
        return (di4) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.AbstractHttpManager
    /* renamed from: s */
    public ei4 putRequest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return new ei4(this);
        }
        return (ei4) invokeV.objValue;
    }

    public fi4 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return new fi4(this);
        }
        return (fi4) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hi4() {
        super(vh4.b().getAppContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = true;
        this.a = vh4.a();
    }

    public static hi4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c == null) {
                synchronized (hi4.class) {
                    if (c == null) {
                        c = new hi4();
                        c.setNetworkStat(HttpRuntime.getHttpContext().getNewNetworkStat());
                    }
                }
            }
            return c;
        }
        return (hi4) invokeV.objValue;
    }

    public static hi4 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (d == null) {
                synchronized (hi4.class) {
                    if (d == null) {
                        d = new hi4();
                        d.setNetworkStat(HttpRuntime.getHttpContext().getNewNetworkStat());
                    }
                }
            }
            return d;
        }
        return (hi4) invokeV.objValue;
    }

    public static hi4 h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            return g();
        }
        return (hi4) invokeL.objValue;
    }

    public void d(gi4 gi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gi4Var) == null) {
            gi4Var.b = "GET";
            t(gi4Var);
        }
    }

    public void e(gi4 gi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gi4Var) == null) {
            gi4Var.b = "POST";
            t(gi4Var);
        }
    }

    public void f(gi4 gi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, gi4Var) == null) {
            gi4Var.b = HttpPut.METHOD_NAME;
            t(gi4Var);
        }
    }

    public final boolean n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                if (b) {
                    Log.e("SwanHttpManager", ExceptionMessage.URL_EMPTY);
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.searchbox.http.AbstractHttpManager
    public OkHttpClient initClient() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            OkHttpClient initClient = super.initClient();
            List<Interceptor> l = vh4.b().l();
            if (l != null && l.size() > 0) {
                OkHttpClient.Builder newBuilder = initClient.newBuilder();
                for (Interceptor interceptor : l) {
                    newBuilder.addNetworkInterceptor(interceptor);
                }
                if (vh4.b().i()) {
                    try {
                        Iterator<Interceptor> it = newBuilder.interceptors().iterator();
                        while (it.hasNext()) {
                            String obj = it.next().toString();
                            if (obj.contains("RequestFilter") || obj.contains("SimCardFreeHeader")) {
                                it.remove();
                            }
                        }
                    } catch (Throwable th) {
                        if (b) {
                            th.printStackTrace();
                        }
                    }
                }
                uh4 b2 = vh4.b();
                if (b2 != null && b2.k() > 0) {
                    newBuilder.connectionPool(new ConnectionPool(b2.k(), 5L, TimeUnit.MINUTES));
                }
                return newBuilder.build();
            }
            return initClient;
        }
        return (OkHttpClient) invokeV.objValue;
    }

    public void t(@NonNull gi4 gi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, gi4Var) == null) {
            if (gi4Var.e == null) {
                gi4Var.e = k();
            }
            if (n(gi4Var.a)) {
                gi4Var.e.onFail(new Exception("url is invalid"));
                return;
            }
            HttpRequestBuilder a2 = ii4.a(gi4Var);
            u(a2, gi4Var);
            a2.build().executeAsync(gi4Var.e);
        }
    }

    public void v(HttpRequestBuilder httpRequestBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, httpRequestBuilder) == null) {
            int m = vh4.b().m();
            if (m > 0) {
                httpRequestBuilder.connectionTimeout(m);
            }
            int readTimeout = vh4.b().getReadTimeout();
            if (readTimeout > 0) {
                httpRequestBuilder.readTimeout(readTimeout);
            }
            int g = vh4.b().g();
            if (g > 0) {
                httpRequestBuilder.writeTimeout(g);
            }
        }
    }

    public void w(OkHttpClient.Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, builder) == null) {
            int m = vh4.b().m();
            if (m > 0) {
                builder.connectTimeout(m, TimeUnit.MILLISECONDS);
            }
            int readTimeout = vh4.b().getReadTimeout();
            if (readTimeout > 0) {
                builder.readTimeout(readTimeout, TimeUnit.MILLISECONDS);
            }
            int g = vh4.b().g();
            if (g > 0) {
                builder.writeTimeout(g, TimeUnit.MILLISECONDS);
            }
        }
    }

    public void u(HttpRequestBuilder httpRequestBuilder, gi4 gi4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, httpRequestBuilder, gi4Var) == null) {
            if (httpRequestBuilder != null && gi4Var != null) {
                httpRequestBuilder.url(gi4Var.a);
                Map<String, String> map = gi4Var.c;
                if (map != null && map.size() > 0) {
                    httpRequestBuilder.headers(gi4Var.c);
                }
                if (gi4Var.f) {
                    httpRequestBuilder.userAgent(vh4.b().getUserAgent());
                }
                if (gi4Var.g) {
                    httpRequestBuilder.cookieManager(vh4.b().f());
                }
                if (gi4Var.h) {
                    gi4.a b2 = gi4Var.b();
                    if (b2 == null) {
                        v(httpRequestBuilder);
                    } else {
                        x(httpRequestBuilder, b2);
                    }
                }
                Object obj = gi4Var.i;
                if (obj != null) {
                    httpRequestBuilder.tag(obj);
                }
                if (gi4Var.k != 0) {
                    httpRequestBuilder.enableStat(true);
                    httpRequestBuilder.requestFrom(gi4Var.j);
                    httpRequestBuilder.requestSubFrom(gi4Var.k);
                }
            } else if (b) {
                Log.e("SwanHttpManager", "setNetworkConfig fail");
            }
        }
    }

    public final void x(HttpRequestBuilder httpRequestBuilder, @NonNull gi4.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, httpRequestBuilder, aVar) == null) {
            int i = aVar.a;
            if (i <= 0) {
                i = vh4.b().m();
            }
            if (i > 0) {
                httpRequestBuilder.connectionTimeout(i);
            }
            int i2 = aVar.b;
            if (i2 <= 0) {
                i2 = vh4.b().getReadTimeout();
            }
            if (i2 > 0) {
                httpRequestBuilder.readTimeout(i2);
            }
            int i3 = aVar.c;
            if (i3 <= 0) {
                i3 = vh4.b().g();
            }
            if (i3 > 0) {
                httpRequestBuilder.writeTimeout(i3);
            }
        }
    }
}
