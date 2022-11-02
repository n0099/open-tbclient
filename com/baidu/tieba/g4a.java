package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes4.dex */
public class g4a {
    public static /* synthetic */ Interceptable $ic;
    public static OkHttpClient b;
    public static volatile g4a c;
    public static String d;
    public transient /* synthetic */ FieldHolder $fh;
    public final HashMap<String, List<Cookie>> a;

    /* loaded from: classes4.dex */
    public class a implements CookieJar {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g4a a;

        public a(g4a g4aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g4aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g4aVar;
        }

        @Override // okhttp3.CookieJar
        public List<Cookie> loadForRequest(HttpUrl httpUrl) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, httpUrl)) == null) {
                List<Cookie> list = (List) this.a.a.get(httpUrl.host());
                if (list == null) {
                    return new ArrayList();
                }
                return list;
            }
            return (List) invokeL.objValue;
        }

        @Override // okhttp3.CookieJar
        public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, httpUrl, list) == null) {
                this.a.a.put(httpUrl.host(), list);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h4a a;
        public final /* synthetic */ Request b;

        public b(g4a g4aVar, h4a h4aVar, Request request) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g4aVar, h4aVar, request};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h4aVar;
            this.b = request;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                boolean isCanceled = call.isCanceled();
                RLog.error("HttpCore", "onFailure isCanceled:" + isCanceled, new Object[0]);
                this.a.a(this.b, isCanceled, iOException);
                RLog.error("HttpCore", "HttpCore -- enqueuePost--1-onFailure:" + iOException.getMessage(), new Object[0]);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) != null) {
                return;
            }
            String unused = g4a.d = response.body().string();
            try {
                this.a.b(g4a.d);
                RLog.debug("HttpCore", "HttpCore -- enqueuePost-onResponse:" + g4a.d);
            } catch (Exception e) {
                RLog.error("HttpCore", "HttpCore -- enqueuePost--2-onFailure:" + e.getMessage(), new Object[0]);
                e.printStackTrace();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947745333, "Lcom/baidu/tieba/g4a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947745333, "Lcom/baidu/tieba/g4a;");
                return;
            }
        }
        MediaType.parse("application/json;charset=utf-8");
        MediaType.parse("application/octet-stream");
        MediaType.parse("text/x-markdown;charset=utf-8");
    }

    public static g4a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (c == null) {
                synchronized (g4a.class) {
                    if (c == null) {
                        c = new g4a();
                    }
                }
            }
            return c;
        }
        return (g4a) invokeV.objValue;
    }

    public g4a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new HashMap<>();
        OkHttpClient.Builder cookieJar = new OkHttpClient.Builder().addInterceptor(new j4a(3)).connectTimeout(10L, TimeUnit.SECONDS).readTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).cookieJar(new a(this));
        cookieJar.dns(i4a.c());
        b = cookieJar.build();
        RLog.info("HttpCore", "HttpCore -- init");
    }

    public static String i(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, map)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (map == null) {
                new HashMap();
            } else {
                boolean z = true;
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (z && !str.contains("?")) {
                        z = false;
                        sb.append("?");
                    } else {
                        sb.append("&");
                    }
                    sb.append(entry.getKey());
                    sb.append("=");
                    if (entry.getValue() == null) {
                        sb.append(" ");
                    } else {
                        sb.append(entry.getValue());
                    }
                }
            }
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public void d(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
            String g = g(i, i2);
            RLog.info("HttpCore", "cancelAllRequest appId:" + i + " useChannel:" + i2 + " requestTag：" + g);
            OkHttpClient okHttpClient = b;
            if (okHttpClient != null && okHttpClient.dispatcher() != null) {
                for (Call call : b.dispatcher().queuedCalls()) {
                    if (g.equals(call.request().tag())) {
                        RLog.info("HttpCore", "cancel queued call:" + call);
                        call.cancel();
                    }
                }
                for (Call call2 : b.dispatcher().runningCalls()) {
                    if (g.equals(call2.request().tag())) {
                        RLog.info("HttpCore", "cancel running call:" + call2);
                        call2.cancel();
                    }
                }
                return;
            }
            RLog.error("HttpCore", "cancelAllRequest error okHttpClient null", new Object[0]);
        }
    }

    public String e(String str, Map<String, String> map, int i, int i2, String str2, String str3, String str4, String str5, int i3, h4a h4aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, map, Integer.valueOf(i), Integer.valueOf(i2), str2, str3, str4, str5, Integer.valueOf(i3), h4aVar})) == null) {
            String g = g(i, i2);
            RLog.info("HttpCore", "enqueuePost requestTag=" + g);
            if (map == null) {
                map = new HashMap<>();
            }
            FormBody.Builder builder = new FormBody.Builder();
            h(map, builder);
            FormBody build = builder.build();
            String i4 = i(str, null);
            RLog.debug("HttpCore", "HttpCore -- enqueuePost--url:" + i4);
            Request.Builder url = new Request.Builder().url(i4);
            Request build2 = url.addHeader("X-AppId", i + "").addHeader("traceid", str2).addHeader("version", str3).addHeader("pakagename", str4).addHeader("X-HostId", str5).addHeader("X-AuthType", String.valueOf(i3)).tag(g).post(build).build();
            try {
                b.newCall(build2).enqueue(new b(this, h4aVar, build2));
            } catch (Exception e) {
                e.printStackTrace();
                RLog.error("HttpCore", "HttpCore -- enqueuePost--3-onFailure:" + e.getMessage(), new Object[0]);
            }
            return d;
        }
        return (String) invokeCommon.objValue;
    }

    public String g(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2)) == null) {
            return "payhttp:appId=" + i + "&userchanel=" + i2;
        }
        return (String) invokeII.objValue;
    }

    public final void h(Map<String, String> map, FormBody.Builder builder) {
        String value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, map, builder) == null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                if (entry.getValue() == null) {
                    value = "";
                } else {
                    value = entry.getValue();
                }
                builder.add(key, value);
            }
        }
    }
}
