package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.net.exception.RequestError;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.tieba.jr0;
import com.baidu.tieba.xr0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;
/* loaded from: classes5.dex */
public class hs0 extends jr0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public OkHttpClient a;
    public or0 b;

    /* loaded from: classes5.dex */
    public class a implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jr0.a a;
        public final /* synthetic */ boolean b;

        /* renamed from: com.baidu.tieba.hs0$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0324a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ IOException a;
            public final /* synthetic */ a b;

            public RunnableC0324a(a aVar, IOException iOException) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, iOException};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = iOException;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.a.a(this.a, 502);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ a b;

            public b(a aVar, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.a.a(new Exception("body is null!"), this.a);
                }
            }
        }

        public a(hs0 hs0Var, jr0.a aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hs0Var, aVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.b = z;
        }

        @Override // okhttp3.Callback
        public void onFailure(@NonNull Call call, @NonNull IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                qj0.b(new RunnableC0324a(this, iOException));
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                Headers.a aVar = new Headers.a();
                int code = response.code();
                ResponseBody body = response.body();
                if (body != null) {
                    for (Map.Entry<String, List<String>> entry : response.headers().toMultimap().entrySet()) {
                        List<String> value = entry.getValue();
                        if (value != null && value.size() > 0) {
                            aVar.a(entry.getKey(), value.get(0));
                        }
                    }
                    if (this.b) {
                        try {
                            try {
                                this.a.c(aVar.c(), body.string(), code);
                                return;
                            } catch (Throwable th) {
                                this.a.a(new Exception(th), 611);
                                return;
                            }
                        } catch (Throwable th2) {
                            this.a.a(new Exception(th2), 610);
                            return;
                        }
                    }
                    try {
                        this.a.b(aVar.c(), body.byteStream(), code);
                    } finally {
                        try {
                            return;
                        } finally {
                        }
                    }
                    return;
                }
                qj0.b(new b(this, code));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements jr0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bs0 a;
        public final /* synthetic */ js0 b;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Headers a;
            public final /* synthetic */ Object b;
            public final /* synthetic */ int c;
            public final /* synthetic */ b d;

            public a(b bVar, Headers headers, Object obj, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, headers, obj, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = bVar;
                this.a = headers;
                this.b = obj;
                this.c = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.d.a.b(this.a, this.b, this.c);
                }
            }
        }

        /* renamed from: com.baidu.tieba.hs0$b$b  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0325b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Exception a;
            public final /* synthetic */ int b;
            public final /* synthetic */ b c;

            public RunnableC0325b(b bVar, Exception exc, int i) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, exc, Integer.valueOf(i)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = bVar;
                this.a = exc;
                this.b = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.c.a.a(this.a, this.b);
                }
            }
        }

        public b(hs0 hs0Var, bs0 bs0Var, js0 js0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hs0Var, bs0Var, js0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bs0Var;
            this.b = js0Var;
        }

        @Override // com.baidu.tieba.jr0.a
        public void a(Exception exc, int i) {
            bs0 bs0Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) && (bs0Var = this.a) != null) {
                if (this.b.g) {
                    qj0.b(new RunnableC0325b(this, exc, i));
                } else {
                    bs0Var.a(exc, i);
                }
            }
        }

        @Override // com.baidu.tieba.jr0.a
        public void b(Headers headers, InputStream inputStream, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, headers, inputStream, i) == null) {
                throw new IllegalStateException("走错路了");
            }
        }

        @Override // com.baidu.tieba.jr0.a
        public void c(Headers headers, String str, int i) throws Exception {
            bs0 bs0Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, headers, str, i) != null) || (bs0Var = this.a) == null) {
                return;
            }
            Object d = bs0Var.d(headers, str, i);
            if (this.b.g) {
                qj0.b(new a(this, headers, d, i));
            } else {
                this.a.b(headers, d, i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements jr0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ as0 a;

        public c(hs0 hs0Var, as0 as0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hs0Var, as0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = as0Var;
        }

        @Override // com.baidu.tieba.jr0.a
        public void a(Exception exc, int i) {
            as0 as0Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) && (as0Var = this.a) != null) {
                as0Var.a(exc, i);
            }
        }

        @Override // com.baidu.tieba.jr0.a
        public void b(Headers headers, InputStream inputStream, int i) throws Exception {
            as0 as0Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, headers, inputStream, i) == null) && (as0Var = this.a) != null) {
                as0Var.c(headers, inputStream, i);
            }
        }

        @Override // com.baidu.tieba.jr0.a
        public void c(Headers headers, String str, int i) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, headers, str, i) == null) {
                throw new IllegalStateException("走错路了");
            }
        }
    }

    public hs0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
    }

    @Override // com.baidu.tieba.ur0
    public <T> void a(@NonNull js0 js0Var, @Nullable bs0<T> bs0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, js0Var, bs0Var) == null) {
            d(js0Var, true, new b(this, bs0Var, js0Var));
        }
    }

    @Override // com.baidu.tieba.ur0
    public void b(@NonNull js0 js0Var, @Nullable as0 as0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, js0Var, as0Var) == null) {
            d(js0Var, false, new c(this, as0Var));
        }
    }

    public final OkHttpClient c(@NonNull js0 js0Var) {
        InterceptResult invokeL;
        OkHttpClient.Builder newBuilder;
        or0 or0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, js0Var)) == null) {
            if (this.a != null && (or0Var = this.b) != null && or0Var.equals(js0Var.f)) {
                return this.a;
            }
            this.b = js0Var.f;
            OkHttpClient okHttpClient = this.a;
            if (okHttpClient == null) {
                newBuilder = new OkHttpClient.Builder();
            } else {
                newBuilder = okHttpClient.newBuilder();
            }
            newBuilder.dns(xr0.a.a());
            int i = this.b.b;
            if (i > 0) {
                newBuilder.readTimeout(i, TimeUnit.MILLISECONDS);
            }
            int i2 = this.b.c;
            if (i2 > 0) {
                newBuilder.writeTimeout(i2, TimeUnit.MILLISECONDS);
            }
            int i3 = this.b.a;
            if (i3 > 0) {
                newBuilder.connectTimeout(i3, TimeUnit.MILLISECONDS);
            }
            if (this.b.d != null) {
                newBuilder.cookieJar(new ds0(this.b.d));
            }
            return newBuilder.build();
        }
        return (OkHttpClient) invokeL.objValue;
    }

    public final void d(@NonNull js0 js0Var, boolean z, @NonNull jr0.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{js0Var, Boolean.valueOf(z), aVar}) == null) {
            RequestError b2 = js0Var.b();
            if (b2 != null) {
                aVar.a(b2, 1001);
                return;
            }
            this.a = c(js0Var);
            try {
                this.a.newCall(ks0.a(js0Var).build()).enqueue(new a(this, aVar, z));
            } catch (RequestError e) {
                aVar.a(e, 1001);
            }
        }
    }
}
