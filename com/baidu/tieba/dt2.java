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
import com.baidu.tieba.ib3;
import com.baidu.tieba.pq2;
import com.baidu.tieba.qs2;
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
public class dt2 extends ct2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable k;

    /* loaded from: classes4.dex */
    public class b implements nq2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qs2 a;
        public final /* synthetic */ dt2 b;

        /* loaded from: classes4.dex */
        public class a implements ib3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ pq2.g b;
            public final /* synthetic */ b c;

            public a(b bVar, int i, pq2.g gVar) {
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

            @Override // com.baidu.tieba.ib3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    t42.i("SwanApp", "download subpackage success");
                    b bVar = this.c;
                    bVar.b.X(this.a, bVar.a, this.b);
                }
            }

            @Override // com.baidu.tieba.ib3.e
            public void b(int i, mj3 mj3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, mj3Var) == null) {
                    t42.o("SwanApp", "download subpackage fail: " + i);
                    this.c.a.R0(null);
                    b bVar = this.c;
                    bVar.b.X(this.a, bVar.a, this.b);
                    mj3 mj3Var2 = new mj3();
                    mj3Var2.k(5L);
                    mj3Var2.i(38L);
                    mj3Var2.f("download subpackage fail, errcode=" + i);
                    ue3 ue3Var = new ue3();
                    ue3Var.q(me3.n(this.c.a.G()));
                    ue3Var.p(mj3Var2);
                    ue3Var.r(this.c.a);
                    me3.R(ue3Var);
                }
            }
        }

        public b(dt2 dt2Var, qs2 qs2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dt2Var, qs2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dt2Var;
            this.a = qs2Var;
        }

        @Override // com.baidu.tieba.nq2
        public void a(int i, mq2 mq2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, mq2Var) == null) {
                pq2.g gVar = (pq2.g) mq2Var;
                if (ib3.p(this.a, gVar)) {
                    if (t73.M() != null && !TextUtils.isEmpty(gVar.a)) {
                        String f = ll3.f(this.a.e0());
                        if (!TextUtils.isEmpty(f) && f.startsWith(File.separator)) {
                            f = f.substring(1);
                        }
                        String str = gVar.b.c.c.get(lb3.b(f));
                        ib3.m(this.a.H(), this.a.v1(), "3", str, gVar.b.d.a.get(str), this.b.C(), new a(this, i, gVar));
                        return;
                    }
                    t42.o("SwanApp", "subpackage is invalid");
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

        public a(dt2 dt2Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dt2Var, Long.valueOf(j)};
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
                ml3.g(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qs2 a;

        public c(dt2 dt2Var, qs2 qs2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dt2Var, qs2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qs2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                pq2.e.c(this.a.H(), this.a.v1());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qs2 a;
        public final /* synthetic */ pq2.g b;
        public final /* synthetic */ dt2 c;

        public d(dt2 dt2Var, qs2 qs2Var, pq2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dt2Var, qs2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = dt2Var;
            this.a = qs2Var;
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
        public final /* synthetic */ qs2 a;

        public e(dt2 dt2Var, qs2 qs2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dt2Var, qs2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qs2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String n = this.a.n("fromHost");
                String n2 = this.a.n("spuId");
                String n3 = this.a.n("contentId");
                if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(n2) && !TextUtils.isEmpty(n3) && ar2.s0().a(n, n2, n3)) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947716007, "Lcom/baidu/tieba/dt2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947716007, "Lcom/baidu/tieba/dt2;");
                return;
            }
        }
        l = do1.a;
    }

    public dt2() {
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

    @Override // com.baidu.tieba.ct2, com.baidu.tieba.et2
    @Nullable
    public t73 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return t73.M();
        }
        return (t73) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ct2, com.baidu.tieba.et2
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return ne2.U().d0();
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ct2, com.baidu.tieba.et2
    public void E(qs2 qs2Var, nq2 nq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, qs2Var, nq2Var) == null) {
            super.E(qs2Var, nq2Var);
            if (l) {
                Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + qs2Var.j0());
            }
            pq2.c(qs2Var, new b(this, qs2Var));
            ne2.U().d1(qs2Var);
            ne2.U().c1(qs2Var);
            ne2.U().H0(null);
        }
    }

    @Override // com.baidu.tieba.ct2, com.baidu.tieba.et2
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.O();
            yd2.d();
            ne2.N0(false);
            if (this.a != null) {
                this.a = null;
            }
            gk3.j();
            su2.b();
            jw2.y();
            qi3.u();
            PaymentPanelManager.F();
            sh3.n();
            fh3.d();
            bi3.k();
            zk2.d();
            yj4.f();
            hy2.e().o();
            ja3.h();
            lh3.h();
            gy2.k();
            if (ar2.I() != null) {
                ar2.I().e();
            }
            ky1.e().n();
            c02.b().f();
            ga3.b().k();
            km2.d();
            fz1.d().h();
            yx2.g().f();
            ie2.b();
            ms2.c().a();
            n23.g().b();
            SwanPrefetchImageRes.b().e();
            sb2.g().d();
            t52.c().n();
            ln3.c().i();
        }
    }

    public final void X(int i, qs2 qs2Var, pq2.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048580, this, i, qs2Var, gVar) == null) && i == 0 && qs2Var != null && gVar != null) {
            y03.o().F(new UbcFlowEvent("na_post_to_main_start"));
            nl3.d0(this.k);
            d dVar = new d(this, qs2Var, gVar);
            this.k = dVar;
            nl3.g0(dVar);
        }
    }

    public final void Y(qs2 qs2Var, pq2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, qs2Var, gVar) == null) {
            y03.o().F(new UbcFlowEvent("na_post_to_main_end"));
            td3.d().i("na_post_to_main_end");
            if (l) {
                Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
            }
            if (this.i) {
                if (l) {
                    Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.a + ", baseUrl:" + gt2.U().z())));
                    return;
                }
                return;
            }
            this.c = gVar.a;
            a0(gVar.b);
            if (qs2Var.m0()) {
                n(this.d).setVisibility(0);
                q42.b(true);
                t42.i("AppsControllerImpl", "init sConsole for devHook");
            }
            t42.i("AppsControllerImpl", "handleLoadSwanApp: start MiniApp first page.");
            ne2.U().Z0(qs2Var, gVar);
        }
    }

    @Override // com.baidu.tieba.ct2, com.baidu.tieba.et2
    public void d(qs2 qs2Var, nq2 nq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, qs2Var, nq2Var) == null) {
            super.d(qs2Var, nq2Var);
            if (l) {
                Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + qs2Var.j0());
            }
            ne2.U().d1(qs2Var);
            ne2.U().H0(null);
            SwanAppConfigData Q = s73.K().q().Q();
            if (Q != null) {
                pq2.g gVar = new pq2.g();
                m13.e().d(new c(this, qs2Var), "deleteLowerVersionFolder", true);
                gVar.b = Q;
                gVar.a = pq2.e.i(qs2Var.H(), qs2Var.v1()).getPath() + File.separator;
                y03.o().F(new UbcFlowEvent("na_post_to_main_start"));
                td3.d().i("na_post_to_main_start");
                Y(qs2Var, gVar);
            }
        }
    }

    public final void Z(qs2 qs2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, qs2Var) == null) && !TextUtils.isEmpty(qs2Var.n("fromHost")) && !TextUtils.isEmpty(qs2Var.n("spuId")) && !TextUtils.isEmpty(qs2Var.n("contentId"))) {
            nl3.b0(new e(this, qs2Var), 2000L);
        }
    }

    public final void a0(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, swanAppConfigData) == null) {
            s73 K = s73.K();
            if (K.E()) {
                K.q().G0(swanAppConfigData);
            }
        }
    }

    @Override // com.baidu.tieba.et2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long S = gt2.U().S();
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

    @Override // com.baidu.tieba.ct2, com.baidu.tieba.et2
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.v();
            t42.i("SwanApp", "onAppForeground");
            String g0 = t73.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            hashMap.put("launchId", t13.b());
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.U() != null) {
                hashMap.put("clkid", this.d.U().L());
                hashMap.put("scene", this.d.U().T());
                qs2.a U = this.d.U();
                de3.v(U);
                Z(U);
            }
            u(new vh2(hashMap));
            t42.i("SwanApp", "onAppShow");
            c02.b().g(false);
            su2.h(true);
            jw2.r(false);
            hy2.e().h(false);
            ky1.e().j();
            gy2.i();
            if (ar2.I() != null) {
                ar2.I().a();
            }
            a aVar = new a(this, System.currentTimeMillis());
            if (u13.h()) {
                m13.e().d(aVar, "saveSwanAppForeGroundTime", false);
            } else {
                nk3.k(aVar, "saveSwanAppForeGroundTime");
            }
        }
    }

    @Override // com.baidu.tieba.ct2, com.baidu.tieba.et2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.w();
            t42.i("SwanApp", "onAppBackground");
            String g0 = t73.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            contentValues.put("hiddenType", Integer.valueOf(vl3.b().a()));
            u(new vh2(contentValues));
            t42.i("SwanApp", "onAppHide");
            vl3.b().d();
            c02.b().g(true);
            su2.h(false);
            jw2.r(true);
            hy2.e().h(true);
            gy2.j(false);
            if (ar2.I() != null) {
                ar2.I().c();
            }
            ml3.h();
            rx2.i();
        }
    }
}
