package com.baidu.tieba;

import android.app.Activity;
import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.vb9;
import com.baidu.tieba.yb9;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.UUID;
/* loaded from: classes4.dex */
public final class hc9 implements vb9.a {
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

    /* loaded from: classes4.dex */
    public class a implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hc9 a;

        /* renamed from: com.baidu.tieba.hc9$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0272a extends kc9 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C0272a(a aVar) {
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

            @Override // com.baidu.tieba.kc9
            public final void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ic9.b("记录一次app启动事件");
                    fb9.c("power_on", "", "", null);
                    hb9.h().d(false);
                }
            }
        }

        public a(hc9 hc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hc9Var;
        }

        @Override // com.baidu.tieba.hc9.e
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                ic9.b("app   went foreground ");
                if (currentTimeMillis - hc9.h > hc9.g) {
                    this.a.m(currentTimeMillis);
                }
                if (hb9.h().g()) {
                    jc9.a(new C0272a(this));
                }
            }
        }

        @Override // com.baidu.tieba.hc9.e
        public final void b() {
            yb9 yb9Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                yb9Var = yb9.a.a;
                if (yb9Var.a().size() == 0) {
                    ic9.b("后台应用退出了 了               ");
                    hb9.h().d(true);
                    long unused = hc9.h = 0L;
                    return;
                }
                ic9.b("进入后台但没退出                  ");
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hc9 a;

        public b(hc9 hc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hc9Var;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a && this.a.b) {
                this.a.a = false;
                try {
                    this.a.e.b();
                } catch (Exception e) {
                    qc9.b("Listener threw exception!:" + e.toString());
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends kc9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(hc9 hc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.kc9
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                hc9.f.z(String.valueOf(currentTimeMillis));
                try {
                    hc9.f.A(String.valueOf(currentTimeMillis - Long.parseLong(hc9.f.N())));
                } catch (NumberFormatException e) {
                    ic9.b(e.getLocalizedMessage());
                }
                sb9 sb9Var = new sb9();
                if (sb9Var.b(hc9.f.I())) {
                    sb9Var.e(hc9.f);
                } else {
                    sb9Var.f(hc9.f);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends kc9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(hc9 hc9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hc9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.kc9
        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ic9.b("超时了……………… 一个新的session");
                new sb9().f(hc9.f);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a();

        void b();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947819051, "Lcom/baidu/tieba/hc9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947819051, "Lcom/baidu/tieba/hc9;");
                return;
            }
        }
        g = ac9.a();
    }

    public hc9() {
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

    public static com.baidu.ubs.analytics.a.n e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? f : (com.baidu.ubs.analytics.a.n) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vb9.a
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
            jc9.c(new c(this));
            Handler handler = this.c;
            b bVar = new b(this);
            this.d = bVar;
            handler.postDelayed(bVar, 1000L);
        }
    }

    @Override // com.baidu.tieba.vb9.a
    public final void a(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
        }
    }

    @Override // com.baidu.tieba.vb9.a
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
                    qc9.b("Listener threw exception!:" + e2.toString());
                }
            }
        }
    }

    public final void m(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            com.baidu.ubs.analytics.a.n nVar = new com.baidu.ubs.analytics.a.n();
            f = nVar;
            nVar.setStartTime(String.valueOf(j));
            f.x(UUID.randomUUID().toString().replace("-", ""));
            jc9.c(new d(this));
        }
    }

    @Override // com.baidu.tieba.vb9.a
    public final void onActivityDestroyed(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, activity) == null) {
        }
    }
}
