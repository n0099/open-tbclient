package com.baidu.tieba;

import android.app.Activity;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.o4b;
import com.baidu.tieba.r4b;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
/* loaded from: classes5.dex */
public final class a5b implements o4b.a {
    public static /* synthetic */ Interceptable $ic;
    public static com.baidu.ubs.analytics.a.n f;
    public static long g;
    public static long h;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public boolean b;
    public Handler c;
    public Runnable d;
    public e e;

    /* loaded from: classes5.dex */
    public interface e {
        void a();

        void b();
    }

    @Override // com.baidu.tieba.o4b.a
    public final void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
        }
    }

    @Override // com.baidu.tieba.o4b.a
    public final void onActivityDestroyed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, activity) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a5b a;

        /* renamed from: com.baidu.tieba.a5b$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0234a extends d5b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0234a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.d5b
            public final void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b5b.b("记录一次app启动事件");
                    y3b.c("power_on", "", "", null);
                    a4b.h().d(false);
                }
            }
        }

        public a(a5b a5bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a5bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a5bVar;
        }

        @Override // com.baidu.tieba.a5b.e
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                b5b.b("app   went foreground ");
                if (currentTimeMillis - a5b.h > a5b.g) {
                    this.a.m(currentTimeMillis);
                }
                if (a4b.h().g()) {
                    c5b.a(new C0234a(this));
                }
            }
        }

        @Override // com.baidu.tieba.a5b.e
        public final void b() {
            r4b r4bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                r4bVar = r4b.a.a;
                if (r4bVar.a().size() == 0) {
                    b5b.b("后台应用退出了 了               ");
                    a4b.h().d(true);
                    a5b.h();
                    return;
                }
                b5b.b("进入后台但没退出                  ");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a5b a;

        public b(a5b a5bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a5bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a5bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a && this.a.b) {
                a5b.k(this.a);
                try {
                    this.a.e.b();
                } catch (Exception e) {
                    j5b.b("Listener threw exception!:" + e.toString());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends d5b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(a5b a5bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a5bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.d5b
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                a5b.f.z(String.valueOf(currentTimeMillis));
                try {
                    a5b.f.A(String.valueOf(currentTimeMillis - Long.parseLong(a5b.f.N())));
                } catch (NumberFormatException e) {
                    b5b.b(e.getLocalizedMessage());
                }
                l4b l4bVar = new l4b();
                if (l4bVar.b(a5b.f.I())) {
                    l4bVar.e(a5b.f);
                } else {
                    l4bVar.f(a5b.f);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends d5b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(a5b a5bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a5bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.d5b
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b5b.b("超时了……………… 一个新的session");
                new l4b().f(a5b.f);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947567579, "Lcom/baidu/tieba/a5b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947567579, "Lcom/baidu/tieba/a5b;");
                return;
            }
        }
        g = t4b.a();
    }

    public static com.baidu.ubs.analytics.a.n e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return f;
        }
        return (com.baidu.ubs.analytics.a.n) invokeV.objValue;
    }

    public static /* synthetic */ long h() {
        h = 0L;
        return 0L;
    }

    public a5b() {
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
        this.a = false;
        this.b = true;
        this.c = new Handler();
        this.e = new a(this);
        long currentTimeMillis = System.currentTimeMillis();
        h = currentTimeMillis;
        m(currentTimeMillis);
    }

    @Override // com.baidu.tieba.o4b.a
    public final void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b = true;
            Runnable runnable = this.d;
            if (runnable != null) {
                this.c.removeCallbacks(runnable);
                this.d = null;
            }
            h = System.currentTimeMillis();
            c5b.c(new c(this));
            Handler handler = this.c;
            b bVar = new b(this);
            this.d = bVar;
            handler.postDelayed(bVar, 1000L);
        }
    }

    @Override // com.baidu.tieba.o4b.a
    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.b = false;
            boolean z = !this.a;
            this.a = true;
            Runnable runnable = this.d;
            if (runnable != null) {
                this.c.removeCallbacks(runnable);
            }
            if (z) {
                try {
                    this.e.a();
                } catch (Exception e2) {
                    j5b.b("Listener threw exception!:" + e2.toString());
                }
            }
        }
    }

    public static /* synthetic */ boolean k(a5b a5bVar) {
        a5bVar.a = false;
        return false;
    }

    public final void m(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            com.baidu.ubs.analytics.a.n nVar = new com.baidu.ubs.analytics.a.n();
            f = nVar;
            nVar.setStartTime(String.valueOf(j));
            f.x(UUID.randomUUID().toString().replace("-", ""));
            c5b.c(new d(this));
        }
    }
}
