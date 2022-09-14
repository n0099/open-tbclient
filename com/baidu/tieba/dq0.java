package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.net.exception.RequestError;
import com.baidu.nadcore.net.request.Headers;
import com.baidu.tieba.gp0;
import com.baidu.tieba.tp0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
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
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
/* loaded from: classes3.dex */
public class dq0 extends gp0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public OkHttpClient a;

    /* loaded from: classes3.dex */
    public class a implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gp0.a a;
        public final /* synthetic */ boolean b;

        /* renamed from: com.baidu.tieba.dq0$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0235a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ IOException a;
            public final /* synthetic */ a b;

            public RunnableC0235a(a aVar, IOException iOException) {
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

        /* loaded from: classes3.dex */
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

        public a(dq0 dq0Var, gp0.a aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dq0Var, aVar, Boolean.valueOf(z)};
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
                aj0.b(new RunnableC0235a(this, iOException));
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
                    try {
                        if (this.b) {
                            this.a.c(aVar.c(), body.string(), code);
                        } else {
                            InputStream byteStream = body.byteStream();
                            this.a.b(aVar.c(), byteStream, code);
                            pi0.a(byteStream);
                        }
                        return;
                    } catch (Throwable th) {
                        throw new IOException(th);
                    }
                }
                aj0.b(new b(this, code));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements gp0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xp0 a;
        public final /* synthetic */ fq0 b;

        /* loaded from: classes3.dex */
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

        /* renamed from: com.baidu.tieba.dq0$b$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0236b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Exception a;
            public final /* synthetic */ int b;
            public final /* synthetic */ b c;

            public RunnableC0236b(b bVar, Exception exc, int i) {
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

        public b(dq0 dq0Var, xp0 xp0Var, fq0 fq0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dq0Var, xp0Var, fq0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xp0Var;
            this.b = fq0Var;
        }

        @Override // com.baidu.tieba.gp0.a
        public void a(Exception exc, int i) {
            xp0 xp0Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) || (xp0Var = this.a) == null) {
                return;
            }
            if (this.b.j) {
                aj0.b(new RunnableC0236b(this, exc, i));
            } else {
                xp0Var.a(exc, i);
            }
        }

        @Override // com.baidu.tieba.gp0.a
        public void b(Headers headers, InputStream inputStream, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, headers, inputStream, i) == null) {
                throw new IllegalStateException("走错路了");
            }
        }

        @Override // com.baidu.tieba.gp0.a
        public void c(Headers headers, String str, int i) throws Exception {
            xp0 xp0Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, headers, str, i) == null) || (xp0Var = this.a) == null) {
                return;
            }
            Object d = xp0Var.d(headers, str, i);
            if (this.b.j) {
                aj0.b(new a(this, headers, d, i));
            } else {
                this.a.b(headers, d, i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements gp0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wp0 a;

        public c(dq0 dq0Var, wp0 wp0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dq0Var, wp0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wp0Var;
        }

        @Override // com.baidu.tieba.gp0.a
        public void a(Exception exc, int i) {
            wp0 wp0Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, exc, i) == null) || (wp0Var = this.a) == null) {
                return;
            }
            wp0Var.a(exc, i);
        }

        @Override // com.baidu.tieba.gp0.a
        public void b(Headers headers, InputStream inputStream, int i) throws Exception {
            wp0 wp0Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, headers, inputStream, i) == null) || (wp0Var = this.a) == null) {
                return;
            }
            wp0Var.c(headers, inputStream, i);
        }

        @Override // com.baidu.tieba.gp0.a
        public void c(Headers headers, String str, int i) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_SEND_USER_MSG, this, headers, str, i) == null) {
                throw new IllegalStateException("走错路了");
            }
        }
    }

    public dq0() {
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
    }

    @Override // com.baidu.tieba.qp0
    public <T> void a(@NonNull fq0 fq0Var, @Nullable xp0<T> xp0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, fq0Var, xp0Var) == null) {
            c(fq0Var, true, new b(this, xp0Var, fq0Var));
        }
    }

    @Override // com.baidu.tieba.qp0
    public void b(@NonNull fq0 fq0Var, @Nullable wp0 wp0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fq0Var, wp0Var) == null) {
            c(fq0Var, false, new c(this, wp0Var));
        }
    }

    public final void c(@NonNull fq0 fq0Var, boolean z, @NonNull gp0.a aVar) {
        OkHttpClient.Builder builder;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{fq0Var, Boolean.valueOf(z), aVar}) == null) {
            RequestError b2 = fq0Var.b();
            if (b2 != null) {
                aVar.a(b2, 1001);
                return;
            }
            try {
                Request.Builder a2 = gq0.a(fq0Var);
                OkHttpClient okHttpClient = this.a;
                if (okHttpClient != null) {
                    builder = okHttpClient.newBuilder();
                } else {
                    builder = new OkHttpClient.Builder();
                }
                builder.dns(tp0.a.a());
                int i = fq0Var.g;
                if (i > 0) {
                    builder.readTimeout(i, TimeUnit.MILLISECONDS);
                }
                int i2 = fq0Var.h;
                if (i2 > 0) {
                    builder.writeTimeout(i2, TimeUnit.MILLISECONDS);
                }
                int i3 = fq0Var.f;
                if (i3 > 0) {
                    builder.connectTimeout(i3, TimeUnit.MILLISECONDS);
                }
                if (fq0Var.i != null) {
                    builder.cookieJar(new zp0(fq0Var.i));
                }
                OkHttpClient build = builder.build();
                if (this.a == null) {
                    this.a = build;
                }
                build.newCall(a2.build()).enqueue(new a(this, aVar, z));
            } catch (RequestError e) {
                aVar.a(e, 1001);
            }
        }
    }
}
