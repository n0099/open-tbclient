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
import com.baidu.tieba.kb3;
import com.baidu.tieba.rq2;
import com.baidu.tieba.ss2;
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
public class ft2 extends et2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable k;

    /* loaded from: classes4.dex */
    public class b implements pq2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ss2 a;
        public final /* synthetic */ ft2 b;

        /* loaded from: classes4.dex */
        public class a implements kb3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ rq2.g b;
            public final /* synthetic */ b c;

            public a(b bVar, int i, rq2.g gVar) {
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

            @Override // com.baidu.tieba.kb3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    v42.i("SwanApp", "download subpackage success");
                    b bVar = this.c;
                    bVar.b.X(this.a, bVar.a, this.b);
                }
            }

            @Override // com.baidu.tieba.kb3.e
            public void b(int i, oj3 oj3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, oj3Var) == null) {
                    v42.o("SwanApp", "download subpackage fail: " + i);
                    this.c.a.R0(null);
                    b bVar = this.c;
                    bVar.b.X(this.a, bVar.a, this.b);
                    oj3 oj3Var2 = new oj3();
                    oj3Var2.k(5L);
                    oj3Var2.i(38L);
                    oj3Var2.f("download subpackage fail, errcode=" + i);
                    we3 we3Var = new we3();
                    we3Var.q(oe3.n(this.c.a.G()));
                    we3Var.p(oj3Var2);
                    we3Var.r(this.c.a);
                    oe3.R(we3Var);
                }
            }
        }

        public b(ft2 ft2Var, ss2 ss2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ft2Var, ss2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ft2Var;
            this.a = ss2Var;
        }

        @Override // com.baidu.tieba.pq2
        public void a(int i, oq2 oq2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, oq2Var) == null) {
                rq2.g gVar = (rq2.g) oq2Var;
                if (kb3.p(this.a, gVar)) {
                    if (v73.M() != null && !TextUtils.isEmpty(gVar.a)) {
                        String f = nl3.f(this.a.e0());
                        if (!TextUtils.isEmpty(f) && f.startsWith(File.separator)) {
                            f = f.substring(1);
                        }
                        String str = gVar.b.c.c.get(nb3.b(f));
                        kb3.m(this.a.H(), this.a.v1(), "3", str, gVar.b.d.a.get(str), this.b.C(), new a(this, i, gVar));
                        return;
                    }
                    v42.o("SwanApp", "subpackage is invalid");
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

        public a(ft2 ft2Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ft2Var, Long.valueOf(j)};
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
                ol3.g(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ss2 a;

        public c(ft2 ft2Var, ss2 ss2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ft2Var, ss2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ss2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                rq2.e.c(this.a.H(), this.a.v1());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ss2 a;
        public final /* synthetic */ rq2.g b;
        public final /* synthetic */ ft2 c;

        public d(ft2 ft2Var, ss2 ss2Var, rq2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ft2Var, ss2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ft2Var;
            this.a = ss2Var;
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
        public final /* synthetic */ ss2 a;

        public e(ft2 ft2Var, ss2 ss2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ft2Var, ss2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ss2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String n = this.a.n("fromHost");
                String n2 = this.a.n("spuId");
                String n3 = this.a.n("contentId");
                if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(n2) && !TextUtils.isEmpty(n3) && cr2.s0().a(n, n2, n3)) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947775589, "Lcom/baidu/tieba/ft2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947775589, "Lcom/baidu/tieba/ft2;");
                return;
            }
        }
        l = fo1.a;
    }

    public ft2() {
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

    @Override // com.baidu.tieba.et2, com.baidu.tieba.gt2
    @Nullable
    public v73 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return v73.M();
        }
        return (v73) invokeV.objValue;
    }

    @Override // com.baidu.tieba.et2, com.baidu.tieba.gt2
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return pe2.U().d0();
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.baidu.tieba.et2, com.baidu.tieba.gt2
    public void E(ss2 ss2Var, pq2 pq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ss2Var, pq2Var) == null) {
            super.E(ss2Var, pq2Var);
            if (l) {
                Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + ss2Var.j0());
            }
            rq2.c(ss2Var, new b(this, ss2Var));
            pe2.U().d1(ss2Var);
            pe2.U().c1(ss2Var);
            pe2.U().H0(null);
        }
    }

    @Override // com.baidu.tieba.et2, com.baidu.tieba.gt2
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.O();
            ae2.d();
            pe2.N0(false);
            if (this.a != null) {
                this.a = null;
            }
            ik3.j();
            uu2.b();
            lw2.y();
            si3.u();
            PaymentPanelManager.F();
            uh3.n();
            hh3.d();
            di3.k();
            bl2.d();
            ak4.f();
            jy2.e().o();
            la3.h();
            nh3.h();
            iy2.k();
            if (cr2.I() != null) {
                cr2.I().e();
            }
            my1.e().n();
            e02.b().f();
            ia3.b().k();
            mm2.d();
            hz1.d().h();
            ay2.g().f();
            ke2.b();
            os2.c().a();
            p23.g().b();
            SwanPrefetchImageRes.b().e();
            ub2.g().d();
            v52.c().n();
            nn3.c().i();
        }
    }

    public final void X(int i, ss2 ss2Var, rq2.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048580, this, i, ss2Var, gVar) == null) && i == 0 && ss2Var != null && gVar != null) {
            a13.o().F(new UbcFlowEvent("na_post_to_main_start"));
            pl3.d0(this.k);
            d dVar = new d(this, ss2Var, gVar);
            this.k = dVar;
            pl3.g0(dVar);
        }
    }

    public final void Y(ss2 ss2Var, rq2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, ss2Var, gVar) == null) {
            a13.o().F(new UbcFlowEvent("na_post_to_main_end"));
            vd3.d().i("na_post_to_main_end");
            if (l) {
                Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
            }
            if (this.i) {
                if (l) {
                    Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.a + ", baseUrl:" + it2.U().z())));
                    return;
                }
                return;
            }
            this.c = gVar.a;
            a0(gVar.b);
            if (ss2Var.m0()) {
                n(this.d).setVisibility(0);
                s42.b(true);
                v42.i("AppsControllerImpl", "init sConsole for devHook");
            }
            v42.i("AppsControllerImpl", "handleLoadSwanApp: start MiniApp first page.");
            pe2.U().Z0(ss2Var, gVar);
        }
    }

    @Override // com.baidu.tieba.et2, com.baidu.tieba.gt2
    public void d(ss2 ss2Var, pq2 pq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ss2Var, pq2Var) == null) {
            super.d(ss2Var, pq2Var);
            if (l) {
                Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + ss2Var.j0());
            }
            pe2.U().d1(ss2Var);
            pe2.U().H0(null);
            SwanAppConfigData Q = u73.K().q().Q();
            if (Q != null) {
                rq2.g gVar = new rq2.g();
                o13.e().d(new c(this, ss2Var), "deleteLowerVersionFolder", true);
                gVar.b = Q;
                gVar.a = rq2.e.i(ss2Var.H(), ss2Var.v1()).getPath() + File.separator;
                a13.o().F(new UbcFlowEvent("na_post_to_main_start"));
                vd3.d().i("na_post_to_main_start");
                Y(ss2Var, gVar);
            }
        }
    }

    public final void Z(ss2 ss2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, ss2Var) == null) && !TextUtils.isEmpty(ss2Var.n("fromHost")) && !TextUtils.isEmpty(ss2Var.n("spuId")) && !TextUtils.isEmpty(ss2Var.n("contentId"))) {
            pl3.b0(new e(this, ss2Var), 2000L);
        }
    }

    public final void a0(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, swanAppConfigData) == null) {
            u73 K = u73.K();
            if (K.E()) {
                K.q().G0(swanAppConfigData);
            }
        }
    }

    @Override // com.baidu.tieba.gt2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long S = it2.U().S();
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

    @Override // com.baidu.tieba.et2, com.baidu.tieba.gt2
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.v();
            v42.i("SwanApp", "onAppForeground");
            String g0 = v73.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            hashMap.put("launchId", v13.b());
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.U() != null) {
                hashMap.put("clkid", this.d.U().L());
                hashMap.put("scene", this.d.U().T());
                ss2.a U = this.d.U();
                fe3.v(U);
                Z(U);
            }
            u(new xh2(hashMap));
            v42.i("SwanApp", "onAppShow");
            e02.b().g(false);
            uu2.h(true);
            lw2.r(false);
            jy2.e().h(false);
            my1.e().j();
            iy2.i();
            if (cr2.I() != null) {
                cr2.I().a();
            }
            a aVar = new a(this, System.currentTimeMillis());
            if (w13.h()) {
                o13.e().d(aVar, "saveSwanAppForeGroundTime", false);
            } else {
                pk3.k(aVar, "saveSwanAppForeGroundTime");
            }
        }
    }

    @Override // com.baidu.tieba.et2, com.baidu.tieba.gt2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.w();
            v42.i("SwanApp", "onAppBackground");
            String g0 = v73.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            contentValues.put("hiddenType", Integer.valueOf(xl3.b().a()));
            u(new xh2(contentValues));
            v42.i("SwanApp", "onAppHide");
            xl3.b().d();
            e02.b().g(true);
            uu2.h(false);
            lw2.r(true);
            jy2.e().h(true);
            iy2.j(false);
            if (cr2.I() != null) {
                cr2.I().c();
            }
            ol3.h();
            tx2.i();
        }
    }
}
