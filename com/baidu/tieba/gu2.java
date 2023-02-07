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
import com.baidu.tieba.lc3;
import com.baidu.tieba.sr2;
import com.baidu.tieba.tt2;
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
public class gu2 extends fu2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable k;

    /* loaded from: classes4.dex */
    public class b implements qr2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tt2 a;
        public final /* synthetic */ gu2 b;

        /* loaded from: classes4.dex */
        public class a implements lc3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ sr2.g b;
            public final /* synthetic */ b c;

            public a(b bVar, int i, sr2.g gVar) {
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

            @Override // com.baidu.tieba.lc3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    w52.i("SwanApp", "download subpackage success");
                    b bVar = this.c;
                    bVar.b.X(this.a, bVar.a, this.b);
                }
            }

            @Override // com.baidu.tieba.lc3.e
            public void b(int i, pk3 pk3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, pk3Var) == null) {
                    w52.o("SwanApp", "download subpackage fail: " + i);
                    this.c.a.R0(null);
                    b bVar = this.c;
                    bVar.b.X(this.a, bVar.a, this.b);
                    pk3 pk3Var2 = new pk3();
                    pk3Var2.k(5L);
                    pk3Var2.i(38L);
                    pk3Var2.f("download subpackage fail, errcode=" + i);
                    xf3 xf3Var = new xf3();
                    xf3Var.q(pf3.n(this.c.a.G()));
                    xf3Var.p(pk3Var2);
                    xf3Var.r(this.c.a);
                    pf3.R(xf3Var);
                }
            }
        }

        public b(gu2 gu2Var, tt2 tt2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gu2Var, tt2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gu2Var;
            this.a = tt2Var;
        }

        @Override // com.baidu.tieba.qr2
        public void a(int i, pr2 pr2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, pr2Var) == null) {
                sr2.g gVar = (sr2.g) pr2Var;
                if (lc3.p(this.a, gVar)) {
                    if (w83.M() != null && !TextUtils.isEmpty(gVar.a)) {
                        String f = om3.f(this.a.e0());
                        if (!TextUtils.isEmpty(f) && f.startsWith(File.separator)) {
                            f = f.substring(1);
                        }
                        String str = gVar.b.c.c.get(oc3.b(f));
                        lc3.m(this.a.H(), this.a.v1(), "3", str, gVar.b.d.a.get(str), this.b.C(), new a(this, i, gVar));
                        return;
                    }
                    w52.o("SwanApp", "subpackage is invalid");
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

        public a(gu2 gu2Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gu2Var, Long.valueOf(j)};
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
                pm3.g(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tt2 a;

        public c(gu2 gu2Var, tt2 tt2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gu2Var, tt2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tt2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                sr2.e.c(this.a.H(), this.a.v1());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tt2 a;
        public final /* synthetic */ sr2.g b;
        public final /* synthetic */ gu2 c;

        public d(gu2 gu2Var, tt2 tt2Var, sr2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gu2Var, tt2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = gu2Var;
            this.a = tt2Var;
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
        public final /* synthetic */ tt2 a;

        public e(gu2 gu2Var, tt2 tt2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gu2Var, tt2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tt2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String n = this.a.n("fromHost");
                String n2 = this.a.n("spuId");
                String n3 = this.a.n("contentId");
                if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(n2) && !TextUtils.isEmpty(n3) && ds2.s0().a(n, n2, n3)) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947806341, "Lcom/baidu/tieba/gu2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947806341, "Lcom/baidu/tieba/gu2;");
                return;
            }
        }
        l = gp1.a;
    }

    public gu2() {
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

    @Override // com.baidu.tieba.fu2, com.baidu.tieba.hu2
    @Nullable
    public w83 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return w83.M();
        }
        return (w83) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fu2, com.baidu.tieba.hu2
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return qf2.U().d0();
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fu2, com.baidu.tieba.hu2
    public void E(tt2 tt2Var, qr2 qr2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tt2Var, qr2Var) == null) {
            super.E(tt2Var, qr2Var);
            if (l) {
                Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + tt2Var.j0());
            }
            sr2.c(tt2Var, new b(this, tt2Var));
            qf2.U().d1(tt2Var);
            qf2.U().c1(tt2Var);
            qf2.U().H0(null);
        }
    }

    @Override // com.baidu.tieba.fu2, com.baidu.tieba.hu2
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.O();
            bf2.d();
            qf2.N0(false);
            if (this.a != null) {
                this.a = null;
            }
            jl3.j();
            vv2.b();
            mx2.y();
            tj3.u();
            PaymentPanelManager.F();
            vi3.n();
            ii3.d();
            ej3.k();
            cm2.d();
            bl4.f();
            kz2.e().o();
            mb3.h();
            oi3.h();
            jz2.k();
            if (ds2.I() != null) {
                ds2.I().e();
            }
            nz1.e().n();
            f12.b().f();
            jb3.b().k();
            nn2.d();
            i02.d().h();
            bz2.g().f();
            lf2.b();
            pt2.c().a();
            q33.g().b();
            SwanPrefetchImageRes.b().e();
            vc2.g().d();
            w62.c().n();
            oo3.c().i();
        }
    }

    public final void X(int i, tt2 tt2Var, sr2.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048580, this, i, tt2Var, gVar) == null) && i == 0 && tt2Var != null && gVar != null) {
            b23.o().F(new UbcFlowEvent("na_post_to_main_start"));
            qm3.d0(this.k);
            d dVar = new d(this, tt2Var, gVar);
            this.k = dVar;
            qm3.g0(dVar);
        }
    }

    public final void Y(tt2 tt2Var, sr2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, tt2Var, gVar) == null) {
            b23.o().F(new UbcFlowEvent("na_post_to_main_end"));
            we3.d().i("na_post_to_main_end");
            if (l) {
                Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
            }
            if (this.i) {
                if (l) {
                    Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.a + ", baseUrl:" + ju2.U().z())));
                    return;
                }
                return;
            }
            this.c = gVar.a;
            a0(gVar.b);
            if (tt2Var.m0()) {
                n(this.d).setVisibility(0);
                t52.b(true);
                w52.i("AppsControllerImpl", "init sConsole for devHook");
            }
            w52.i("AppsControllerImpl", "handleLoadSwanApp: start MiniApp first page.");
            qf2.U().Z0(tt2Var, gVar);
        }
    }

    @Override // com.baidu.tieba.fu2, com.baidu.tieba.hu2
    public void d(tt2 tt2Var, qr2 qr2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tt2Var, qr2Var) == null) {
            super.d(tt2Var, qr2Var);
            if (l) {
                Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + tt2Var.j0());
            }
            qf2.U().d1(tt2Var);
            qf2.U().H0(null);
            SwanAppConfigData Q = v83.K().q().Q();
            if (Q != null) {
                sr2.g gVar = new sr2.g();
                p23.e().d(new c(this, tt2Var), "deleteLowerVersionFolder", true);
                gVar.b = Q;
                gVar.a = sr2.e.i(tt2Var.H(), tt2Var.v1()).getPath() + File.separator;
                b23.o().F(new UbcFlowEvent("na_post_to_main_start"));
                we3.d().i("na_post_to_main_start");
                Y(tt2Var, gVar);
            }
        }
    }

    public final void Z(tt2 tt2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, tt2Var) == null) && !TextUtils.isEmpty(tt2Var.n("fromHost")) && !TextUtils.isEmpty(tt2Var.n("spuId")) && !TextUtils.isEmpty(tt2Var.n("contentId"))) {
            qm3.b0(new e(this, tt2Var), 2000L);
        }
    }

    public final void a0(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, swanAppConfigData) == null) {
            v83 K = v83.K();
            if (K.E()) {
                K.q().G0(swanAppConfigData);
            }
        }
    }

    @Override // com.baidu.tieba.hu2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long S = ju2.U().S();
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

    @Override // com.baidu.tieba.fu2, com.baidu.tieba.hu2
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.v();
            w52.i("SwanApp", "onAppForeground");
            String g0 = w83.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            hashMap.put("launchId", w23.b());
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.S() != null) {
                hashMap.put("clkid", this.d.S().L());
                hashMap.put("scene", this.d.S().T());
                tt2.a S = this.d.S();
                gf3.v(S);
                Z(S);
            }
            u(new yi2(hashMap));
            w52.i("SwanApp", "onAppShow");
            f12.b().g(false);
            vv2.h(true);
            mx2.r(false);
            kz2.e().h(false);
            nz1.e().j();
            jz2.i();
            if (ds2.I() != null) {
                ds2.I().a();
            }
            a aVar = new a(this, System.currentTimeMillis());
            if (x23.h()) {
                p23.e().d(aVar, "saveSwanAppForeGroundTime", false);
            } else {
                ql3.k(aVar, "saveSwanAppForeGroundTime");
            }
        }
    }

    @Override // com.baidu.tieba.fu2, com.baidu.tieba.hu2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.w();
            w52.i("SwanApp", "onAppBackground");
            String g0 = w83.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            contentValues.put("hiddenType", Integer.valueOf(ym3.b().a()));
            u(new yi2(contentValues));
            w52.i("SwanApp", "onAppHide");
            ym3.b().d();
            f12.b().g(true);
            vv2.h(false);
            mx2.r(true);
            kz2.e().h(true);
            jz2.j(false);
            if (ds2.I() != null) {
                ds2.I().c();
            }
            pm3.h();
            uy2.i();
        }
    }
}
