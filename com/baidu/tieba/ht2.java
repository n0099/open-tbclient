package com.baidu.tieba;

import android.content.ContentValues;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.core.prefetch.image.res.SwanPrefetchImageRes;
import com.baidu.swan.apps.pay.panel.PaymentPanelManager;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.tieba.mb3;
import com.baidu.tieba.tq2;
import com.baidu.tieba.us2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class ht2 extends gt2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable k;

    /* loaded from: classes4.dex */
    public class b implements rq2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ us2 a;
        public final /* synthetic */ ht2 b;

        /* loaded from: classes4.dex */
        public class a implements mb3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ tq2.g b;
            public final /* synthetic */ b c;

            public a(b bVar, int i, tq2.g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, Integer.valueOf(i), gVar};
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
                this.a = i;
                this.b = gVar;
            }

            @Override // com.baidu.tieba.mb3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    x42.i("SwanApp", "download subpackage success");
                    b bVar = this.c;
                    bVar.b.X(this.a, bVar.a, this.b);
                }
            }

            @Override // com.baidu.tieba.mb3.e
            public void b(int i, qj3 qj3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, qj3Var) == null) {
                    x42.o("SwanApp", "download subpackage fail: " + i);
                    this.c.a.R0(null);
                    b bVar = this.c;
                    bVar.b.X(this.a, bVar.a, this.b);
                    qj3 qj3Var2 = new qj3();
                    qj3Var2.k(5L);
                    qj3Var2.i(38L);
                    qj3Var2.f("download subpackage fail, errcode=" + i);
                    ye3 ye3Var = new ye3();
                    ye3Var.q(qe3.n(this.c.a.G()));
                    ye3Var.p(qj3Var2);
                    ye3Var.r(this.c.a);
                    qe3.R(ye3Var);
                }
            }
        }

        public b(ht2 ht2Var, us2 us2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ht2Var, us2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ht2Var;
            this.a = us2Var;
        }

        @Override // com.baidu.tieba.rq2
        public void a(int i, qq2 qq2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, qq2Var) == null) {
                tq2.g gVar = (tq2.g) qq2Var;
                if (mb3.p(this.a, gVar)) {
                    if (x73.M() != null && !TextUtils.isEmpty(gVar.a)) {
                        String f = pl3.f(this.a.e0());
                        if (!TextUtils.isEmpty(f) && f.startsWith(File.separator)) {
                            f = f.substring(1);
                        }
                        String str = gVar.b.c.c.get(pb3.b(f));
                        mb3.m(this.a.H(), this.a.v1(), "3", str, gVar.b.d.a.get(str), this.b.C(), new a(this, i, gVar));
                        return;
                    }
                    x42.o("SwanApp", "subpackage is invalid");
                }
                this.b.X(i, this.a, gVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        public a(ht2 ht2Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ht2Var, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ql3.g(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ us2 a;

        public c(ht2 ht2Var, us2 us2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ht2Var, us2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = us2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                tq2.e.c(this.a.H(), this.a.v1());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ us2 a;
        public final /* synthetic */ tq2.g b;
        public final /* synthetic */ ht2 c;

        public d(ht2 ht2Var, us2 us2Var, tq2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ht2Var, us2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ht2Var;
            this.a = us2Var;
            this.b = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.c.Y(this.a, this.b);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ us2 a;

        public e(ht2 ht2Var, us2 us2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ht2Var, us2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = us2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String n = this.a.n("fromHost");
                String n2 = this.a.n("spuId");
                String n3 = this.a.n("contentId");
                if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(n2) && !TextUtils.isEmpty(n3) && er2.s0().a(n, n2, n3)) {
                    this.a.z("fromHost", null);
                    this.a.z("spuId", null);
                    this.a.z("contentId", null);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947835171, "Lcom/baidu/tieba/ht2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947835171, "Lcom/baidu/tieba/ht2;");
                return;
            }
        }
        l = ho1.a;
    }

    public ht2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.gt2, com.baidu.tieba.it2
    @Nullable
    public x73 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return x73.M();
        }
        return (x73) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gt2, com.baidu.tieba.it2
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return re2.U().d0();
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.baidu.tieba.gt2, com.baidu.tieba.it2
    public void E(us2 us2Var, rq2 rq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, us2Var, rq2Var) == null) {
            super.E(us2Var, rq2Var);
            if (l) {
                Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + us2Var.j0());
            }
            tq2.c(us2Var, new b(this, us2Var));
            re2.U().d1(us2Var);
            re2.U().c1(us2Var);
            re2.U().H0(null);
        }
    }

    @Override // com.baidu.tieba.gt2, com.baidu.tieba.it2
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.O();
            ce2.d();
            re2.N0(false);
            if (this.a != null) {
                this.a = null;
            }
            kk3.j();
            wu2.b();
            nw2.y();
            ui3.u();
            PaymentPanelManager.F();
            wh3.n();
            jh3.d();
            fi3.k();
            dl2.d();
            ck4.f();
            ly2.e().o();
            na3.h();
            ph3.h();
            ky2.k();
            if (er2.I() != null) {
                er2.I().e();
            }
            oy1.e().n();
            g02.b().f();
            ka3.b().k();
            om2.d();
            jz1.d().h();
            cy2.g().f();
            me2.b();
            qs2.c().a();
            r23.g().b();
            SwanPrefetchImageRes.b().e();
            wb2.g().d();
            x52.c().n();
            pn3.c().i();
        }
    }

    public final void X(int i, us2 us2Var, tq2.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048580, this, i, us2Var, gVar) == null) && i == 0 && us2Var != null && gVar != null) {
            c13.o().F(new UbcFlowEvent("na_post_to_main_start"));
            rl3.d0(this.k);
            d dVar = new d(this, us2Var, gVar);
            this.k = dVar;
            rl3.g0(dVar);
        }
    }

    public final void Y(us2 us2Var, tq2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, us2Var, gVar) == null) {
            c13.o().F(new UbcFlowEvent("na_post_to_main_end"));
            xd3.d().i("na_post_to_main_end");
            if (l) {
                Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
            }
            if (this.i) {
                if (l) {
                    Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.a + ", baseUrl:" + kt2.U().z())));
                    return;
                }
                return;
            }
            this.c = gVar.a;
            a0(gVar.b);
            if (us2Var.m0()) {
                n(this.d).setVisibility(0);
                u42.b(true);
                x42.i("AppsControllerImpl", "init sConsole for devHook");
            }
            x42.i("AppsControllerImpl", "handleLoadSwanApp: start MiniApp first page.");
            re2.U().Z0(us2Var, gVar);
        }
    }

    @Override // com.baidu.tieba.gt2, com.baidu.tieba.it2
    public void d(us2 us2Var, rq2 rq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, us2Var, rq2Var) == null) {
            super.d(us2Var, rq2Var);
            if (l) {
                Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + us2Var.j0());
            }
            re2.U().d1(us2Var);
            re2.U().H0(null);
            SwanAppConfigData Q = w73.K().q().Q();
            if (Q != null) {
                tq2.g gVar = new tq2.g();
                q13.e().d(new c(this, us2Var), "deleteLowerVersionFolder", true);
                gVar.b = Q;
                gVar.a = tq2.e.i(us2Var.H(), us2Var.v1()).getPath() + File.separator;
                c13.o().F(new UbcFlowEvent("na_post_to_main_start"));
                xd3.d().i("na_post_to_main_start");
                Y(us2Var, gVar);
            }
        }
    }

    public final void Z(us2 us2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, us2Var) == null) && !TextUtils.isEmpty(us2Var.n("fromHost")) && !TextUtils.isEmpty(us2Var.n("spuId")) && !TextUtils.isEmpty(us2Var.n("contentId"))) {
            rl3.b0(new e(this, us2Var), 2000L);
        }
    }

    public final void a0(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, swanAppConfigData) == null) {
            w73 K = w73.K();
            if (K.E()) {
                K.q().G0(swanAppConfigData);
            }
        }
    }

    @Override // com.baidu.tieba.it2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long S = kt2.U().S();
            if (l) {
                Log.i("AppsControllerImpl", "onAppBackground: background alive thread count:" + S);
            }
            if (this.h && S <= 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.gt2, com.baidu.tieba.it2
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.v();
            x42.i("SwanApp", "onAppForeground");
            String g0 = x73.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            hashMap.put("launchId", x13.b());
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.U() != null) {
                hashMap.put("clkid", this.d.U().L());
                hashMap.put("scene", this.d.U().T());
                us2.a U = this.d.U();
                he3.v(U);
                Z(U);
            }
            u(new zh2(hashMap));
            x42.i("SwanApp", "onAppShow");
            g02.b().g(false);
            wu2.h(true);
            nw2.r(false);
            ly2.e().h(false);
            oy1.e().j();
            ky2.i();
            if (er2.I() != null) {
                er2.I().a();
            }
            a aVar = new a(this, System.currentTimeMillis());
            if (y13.h()) {
                q13.e().d(aVar, "saveSwanAppForeGroundTime", false);
            } else {
                rk3.k(aVar, "saveSwanAppForeGroundTime");
            }
        }
    }

    @Override // com.baidu.tieba.gt2, com.baidu.tieba.it2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.w();
            x42.i("SwanApp", "onAppBackground");
            String g0 = x73.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            contentValues.put("hiddenType", Integer.valueOf(zl3.b().a()));
            u(new zh2(contentValues));
            x42.i("SwanApp", "onAppHide");
            zl3.b().d();
            g02.b().g(true);
            wu2.h(false);
            nw2.r(true);
            ly2.e().h(true);
            ky2.j(false);
            if (er2.I() != null) {
                er2.I().c();
            }
            ql3.h();
            vx2.i();
        }
    }
}
