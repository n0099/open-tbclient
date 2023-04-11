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
import com.baidu.tieba.jb3;
import com.baidu.tieba.qq2;
import com.baidu.tieba.rs2;
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
public class et2 extends dt2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable k;

    /* loaded from: classes4.dex */
    public class b implements oq2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rs2 a;
        public final /* synthetic */ et2 b;

        /* loaded from: classes4.dex */
        public class a implements jb3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ qq2.g b;
            public final /* synthetic */ b c;

            public a(b bVar, int i, qq2.g gVar) {
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

            @Override // com.baidu.tieba.jb3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    u42.i("SwanApp", "download subpackage success");
                    b bVar = this.c;
                    bVar.b.X(this.a, bVar.a, this.b);
                }
            }

            @Override // com.baidu.tieba.jb3.e
            public void b(int i, nj3 nj3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, nj3Var) == null) {
                    u42.o("SwanApp", "download subpackage fail: " + i);
                    this.c.a.R0(null);
                    b bVar = this.c;
                    bVar.b.X(this.a, bVar.a, this.b);
                    nj3 nj3Var2 = new nj3();
                    nj3Var2.k(5L);
                    nj3Var2.i(38L);
                    nj3Var2.f("download subpackage fail, errcode=" + i);
                    ve3 ve3Var = new ve3();
                    ve3Var.q(ne3.n(this.c.a.G()));
                    ve3Var.p(nj3Var2);
                    ve3Var.r(this.c.a);
                    ne3.R(ve3Var);
                }
            }
        }

        public b(et2 et2Var, rs2 rs2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {et2Var, rs2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = et2Var;
            this.a = rs2Var;
        }

        @Override // com.baidu.tieba.oq2
        public void a(int i, nq2 nq2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, nq2Var) == null) {
                qq2.g gVar = (qq2.g) nq2Var;
                if (jb3.p(this.a, gVar)) {
                    if (u73.M() != null && !TextUtils.isEmpty(gVar.a)) {
                        String f = ml3.f(this.a.e0());
                        if (!TextUtils.isEmpty(f) && f.startsWith(File.separator)) {
                            f = f.substring(1);
                        }
                        String str = gVar.b.c.c.get(mb3.b(f));
                        jb3.m(this.a.H(), this.a.v1(), "3", str, gVar.b.d.a.get(str), this.b.C(), new a(this, i, gVar));
                        return;
                    }
                    u42.o("SwanApp", "subpackage is invalid");
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

        public a(et2 et2Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {et2Var, Long.valueOf(j)};
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
                nl3.g(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rs2 a;

        public c(et2 et2Var, rs2 rs2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {et2Var, rs2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rs2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                qq2.e.c(this.a.H(), this.a.v1());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rs2 a;
        public final /* synthetic */ qq2.g b;
        public final /* synthetic */ et2 c;

        public d(et2 et2Var, rs2 rs2Var, qq2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {et2Var, rs2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = et2Var;
            this.a = rs2Var;
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
        public final /* synthetic */ rs2 a;

        public e(et2 et2Var, rs2 rs2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {et2Var, rs2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rs2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String n = this.a.n("fromHost");
                String n2 = this.a.n("spuId");
                String n3 = this.a.n("contentId");
                if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(n2) && !TextUtils.isEmpty(n3) && br2.s0().a(n, n2, n3)) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947745798, "Lcom/baidu/tieba/et2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947745798, "Lcom/baidu/tieba/et2;");
                return;
            }
        }
        l = eo1.a;
    }

    public et2() {
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

    @Override // com.baidu.tieba.dt2, com.baidu.tieba.ft2
    @Nullable
    public u73 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return u73.M();
        }
        return (u73) invokeV.objValue;
    }

    @Override // com.baidu.tieba.dt2, com.baidu.tieba.ft2
    public SwanCoreVersion M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return oe2.U().d0();
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.baidu.tieba.dt2, com.baidu.tieba.ft2
    public void E(rs2 rs2Var, oq2 oq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rs2Var, oq2Var) == null) {
            super.E(rs2Var, oq2Var);
            if (l) {
                Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + rs2Var.j0());
            }
            qq2.c(rs2Var, new b(this, rs2Var));
            oe2.U().d1(rs2Var);
            oe2.U().c1(rs2Var);
            oe2.U().H0(null);
        }
    }

    @Override // com.baidu.tieba.dt2, com.baidu.tieba.ft2
    public void O() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.O();
            zd2.d();
            oe2.N0(false);
            if (this.a != null) {
                this.a = null;
            }
            hk3.j();
            tu2.b();
            kw2.y();
            ri3.u();
            PaymentPanelManager.F();
            th3.n();
            gh3.d();
            ci3.k();
            al2.d();
            zj4.f();
            iy2.e().o();
            ka3.h();
            mh3.h();
            hy2.k();
            if (br2.I() != null) {
                br2.I().e();
            }
            ly1.e().n();
            d02.b().f();
            ha3.b().k();
            lm2.d();
            gz1.d().h();
            zx2.g().f();
            je2.b();
            ns2.c().a();
            o23.g().b();
            SwanPrefetchImageRes.b().e();
            tb2.g().d();
            u52.c().n();
            mn3.c().i();
        }
    }

    public final void X(int i, rs2 rs2Var, qq2.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048580, this, i, rs2Var, gVar) == null) && i == 0 && rs2Var != null && gVar != null) {
            z03.o().F(new UbcFlowEvent("na_post_to_main_start"));
            ol3.d0(this.k);
            d dVar = new d(this, rs2Var, gVar);
            this.k = dVar;
            ol3.g0(dVar);
        }
    }

    public final void Y(rs2 rs2Var, qq2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, rs2Var, gVar) == null) {
            z03.o().F(new UbcFlowEvent("na_post_to_main_end"));
            ud3.d().i("na_post_to_main_end");
            if (l) {
                Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
            }
            if (this.i) {
                if (l) {
                    Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.a + ", baseUrl:" + ht2.U().z())));
                    return;
                }
                return;
            }
            this.c = gVar.a;
            a0(gVar.b);
            if (rs2Var.m0()) {
                n(this.d).setVisibility(0);
                r42.b(true);
                u42.i("AppsControllerImpl", "init sConsole for devHook");
            }
            u42.i("AppsControllerImpl", "handleLoadSwanApp: start MiniApp first page.");
            oe2.U().Z0(rs2Var, gVar);
        }
    }

    @Override // com.baidu.tieba.dt2, com.baidu.tieba.ft2
    public void d(rs2 rs2Var, oq2 oq2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rs2Var, oq2Var) == null) {
            super.d(rs2Var, oq2Var);
            if (l) {
                Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + rs2Var.j0());
            }
            oe2.U().d1(rs2Var);
            oe2.U().H0(null);
            SwanAppConfigData Q = t73.K().q().Q();
            if (Q != null) {
                qq2.g gVar = new qq2.g();
                n13.e().d(new c(this, rs2Var), "deleteLowerVersionFolder", true);
                gVar.b = Q;
                gVar.a = qq2.e.i(rs2Var.H(), rs2Var.v1()).getPath() + File.separator;
                z03.o().F(new UbcFlowEvent("na_post_to_main_start"));
                ud3.d().i("na_post_to_main_start");
                Y(rs2Var, gVar);
            }
        }
    }

    public final void Z(rs2 rs2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, rs2Var) == null) && !TextUtils.isEmpty(rs2Var.n("fromHost")) && !TextUtils.isEmpty(rs2Var.n("spuId")) && !TextUtils.isEmpty(rs2Var.n("contentId"))) {
            ol3.b0(new e(this, rs2Var), 2000L);
        }
    }

    public final void a0(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, swanAppConfigData) == null) {
            t73 K = t73.K();
            if (K.E()) {
                K.q().G0(swanAppConfigData);
            }
        }
    }

    @Override // com.baidu.tieba.ft2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long S = ht2.U().S();
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

    @Override // com.baidu.tieba.dt2, com.baidu.tieba.ft2
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.v();
            u42.i("SwanApp", "onAppForeground");
            String g0 = u73.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            hashMap.put("launchId", u13.b());
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.U() != null) {
                hashMap.put("clkid", this.d.U().L());
                hashMap.put("scene", this.d.U().T());
                rs2.a U = this.d.U();
                ee3.v(U);
                Z(U);
            }
            u(new wh2(hashMap));
            u42.i("SwanApp", "onAppShow");
            d02.b().g(false);
            tu2.h(true);
            kw2.r(false);
            iy2.e().h(false);
            ly1.e().j();
            hy2.i();
            if (br2.I() != null) {
                br2.I().a();
            }
            a aVar = new a(this, System.currentTimeMillis());
            if (v13.h()) {
                n13.e().d(aVar, "saveSwanAppForeGroundTime", false);
            } else {
                ok3.k(aVar, "saveSwanAppForeGroundTime");
            }
        }
    }

    @Override // com.baidu.tieba.dt2, com.baidu.tieba.ft2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.w();
            u42.i("SwanApp", "onAppBackground");
            String g0 = u73.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            contentValues.put("hiddenType", Integer.valueOf(wl3.b().a()));
            u(new wh2(contentValues));
            u42.i("SwanApp", "onAppHide");
            wl3.b().d();
            d02.b().g(true);
            tu2.h(false);
            kw2.r(true);
            iy2.e().h(true);
            hy2.j(false);
            if (br2.I() != null) {
                br2.I().c();
            }
            nl3.h();
            sx2.i();
        }
    }
}
