package com.baidu.tieba;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
/* loaded from: classes4.dex */
public class f80 {
    public static /* synthetic */ Interceptable $ic = null;
    public static volatile f80 c = null;
    public static int d = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public final OkHttpClient a;
    public Context b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947717867, "Lcom/baidu/tieba/f80;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947717867, "Lcom/baidu/tieba/f80;");
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g80 a;
        public final /* synthetic */ byte[] b;
        public final /* synthetic */ h80 c;
        public final /* synthetic */ f80 d;

        public a(f80 f80Var, g80 g80Var, byte[] bArr, h80 h80Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f80Var, g80Var, bArr, h80Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = f80Var;
            this.a = g80Var;
            this.b = bArr;
            this.c = h80Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.d.c(this.a.getMethod(), this.a.getHost(), this.a.getRequestParameter(), this.b, this.a.getHeaders(), this.a.getContentType(), this.c);
            }
        }
    }

    public f80(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new OkHttpClient.Builder().connectTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).build();
        this.b = context;
    }

    public final Headers d(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map)) == null) {
            try {
                Headers.Builder builder = new Headers.Builder();
                if (map != null && map.size() > 0) {
                    for (String str : map.keySet()) {
                        String str2 = str.toString();
                        builder.add(str2, map.get(str2));
                    }
                }
                return builder.build();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (Headers) invokeL.objValue;
    }

    public static f80 e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (c == null) {
                synchronized (f80.class) {
                    if (c == null) {
                        c = new f80(context);
                    }
                }
            }
            return c;
        }
        return (f80) invokeL.objValue;
    }

    public void b(Context context, g80 g80Var, h80 h80Var, byte[] bArr, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{context, g80Var, h80Var, bArr, Boolean.valueOf(z)}) != null) || h80Var == null) {
            return;
        }
        if (context != null && g80Var != null && !TextUtils.isEmpty(g80Var.getHost())) {
            if (z) {
                j80.a().b(new a(this, g80Var, bArr, h80Var));
                return;
            } else {
                c(g80Var.getMethod(), g80Var.getHost(), g80Var.getRequestParameter(), bArr, g80Var.getHeaders(), g80Var.getContentType(), h80Var);
                return;
            }
        }
        h80Var.a(d, Constants.ERROR_MSG_PARAMETER_ERROR.getBytes());
    }

    public final void c(String str, String str2, byte[] bArr, byte[] bArr2, Map<String, String> map, String str3, h80 h80Var) {
        Request build;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, bArr, bArr2, map, str3, h80Var}) == null) {
            try {
                if ("POST".equals(str)) {
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "application/x-www-form-urlencoded";
                    }
                    build = new Request.Builder().url(str2).headers(d(map)).removeHeader("User-Agent").addHeader("User-Agent", f()).post(RequestBody.create(MediaType.parse(str3), bArr2)).build();
                } else {
                    if (bArr != null && bArr.length > 0) {
                        str2 = str2 + "?" + new String(bArr);
                    }
                    build = new Request.Builder().url(str2).headers(d(map)).removeHeader("User-Agent").addHeader("User-Agent", f()).build();
                }
                Response execute = this.a.newCall(build).execute();
                byte[] bytes = execute.body().bytes();
                o80.c("HttpExecutor", "requestUrl:" + str2 + "\nrequest method: " + str + "\nrequest contentType: " + str3 + "\nresponse : " + new String(bytes));
                h80Var.onSuccess(execute.code(), bytes);
            } catch (Exception e) {
                e.printStackTrace();
                if (h80Var != null) {
                    h80Var.a(d, "Http Unknown exception".getBytes());
                }
            }
        }
    }

    public final String f() {
        InterceptResult invokeV;
        String property;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                try {
                    property = WebSettings.getDefaultUserAgent(this.b);
                } catch (Exception unused) {
                    property = System.getProperty("http.agent");
                }
            } else {
                property = System.getProperty("http.agent");
            }
            StringBuffer stringBuffer = new StringBuffer();
            int length = property.length();
            for (int i = 0; i < length; i++) {
                char charAt = property.charAt(i);
                if (charAt > 31 && charAt < 127) {
                    stringBuffer.append(charAt);
                } else {
                    stringBuffer.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                }
            }
            o80.a("HttpExecutor", "getUserAgent:" + stringBuffer.toString());
            return stringBuffer.toString();
        }
        return (String) invokeV.objValue;
    }
}
