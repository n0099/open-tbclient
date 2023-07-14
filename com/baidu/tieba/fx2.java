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
import com.baidu.tieba.kf3;
import com.baidu.tieba.ru2;
import com.baidu.tieba.sw2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class fx2 extends ex2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean l;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable k;

    /* loaded from: classes5.dex */
    public class b implements pu2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sw2 a;
        public final /* synthetic */ fx2 b;

        /* loaded from: classes5.dex */
        public class a implements kf3.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ ru2.g b;
            public final /* synthetic */ b c;

            public a(b bVar, int i, ru2.g gVar) {
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

            @Override // com.baidu.tieba.kf3.e
            public void a(String str) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                    v82.i("SwanApp", "download subpackage success");
                    b bVar = this.c;
                    bVar.b.W(this.a, bVar.a, this.b);
                }
            }

            @Override // com.baidu.tieba.kf3.e
            public void b(int i, on3 on3Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, on3Var) == null) {
                    v82.o("SwanApp", "download subpackage fail: " + i);
                    this.c.a.R0(null);
                    b bVar = this.c;
                    bVar.b.W(this.a, bVar.a, this.b);
                    on3 on3Var2 = new on3();
                    on3Var2.k(5L);
                    on3Var2.i(38L);
                    on3Var2.f("download subpackage fail, errcode=" + i);
                    wi3 wi3Var = new wi3();
                    wi3Var.q(oi3.n(this.c.a.G()));
                    wi3Var.p(on3Var2);
                    wi3Var.r(this.c.a);
                    oi3.R(wi3Var);
                }
            }
        }

        public b(fx2 fx2Var, sw2 sw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fx2Var, sw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fx2Var;
            this.a = sw2Var;
        }

        @Override // com.baidu.tieba.pu2
        public void a(int i, ou2 ou2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(1048576, this, i, ou2Var) == null) {
                ru2.g gVar = (ru2.g) ou2Var;
                if (kf3.p(this.a, gVar)) {
                    if (vb3.M() != null && !TextUtils.isEmpty(gVar.a)) {
                        String f = np3.f(this.a.e0());
                        if (!TextUtils.isEmpty(f) && f.startsWith(File.separator)) {
                            f = f.substring(1);
                        }
                        String str = gVar.b.c.c.get(nf3.b(f));
                        kf3.m(this.a.H(), this.a.v1(), "3", str, gVar.b.d.a.get(str), this.b.C(), new a(this, i, gVar));
                        return;
                    }
                    v82.o("SwanApp", "subpackage is invalid");
                }
                this.b.W(i, this.a, gVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        public a(fx2 fx2Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fx2Var, Long.valueOf(j)};
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
                op3.g(this.a);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sw2 a;

        public c(fx2 fx2Var, sw2 sw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fx2Var, sw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sw2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ru2.e.c(this.a.H(), this.a.v1());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sw2 a;
        public final /* synthetic */ ru2.g b;
        public final /* synthetic */ fx2 c;

        public d(fx2 fx2Var, sw2 sw2Var, ru2.g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fx2Var, sw2Var, gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fx2Var;
            this.a = sw2Var;
            this.b = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.c.X(this.a, this.b);
        }
    }

    /* loaded from: classes5.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sw2 a;

        public e(fx2 fx2Var, sw2 sw2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fx2Var, sw2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sw2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                String n = this.a.n("fromHost");
                String n2 = this.a.n("spuId");
                String n3 = this.a.n("contentId");
                if (!TextUtils.isEmpty(n) && !TextUtils.isEmpty(n2) && !TextUtils.isEmpty(n3) && cv2.s0().a(n, n2, n3)) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947779433, "Lcom/baidu/tieba/fx2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947779433, "Lcom/baidu/tieba/fx2;");
                return;
            }
        }
        l = fs1.a;
    }

    public fx2() {
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

    @Override // com.baidu.tieba.ex2, com.baidu.tieba.gx2
    @Nullable
    public vb3 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return vb3.M();
        }
        return (vb3) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ex2, com.baidu.tieba.gx2
    public SwanCoreVersion getCoreVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return pi2.U().d0();
        }
        return (SwanCoreVersion) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ex2, com.baidu.tieba.gx2
    public void E(sw2 sw2Var, pu2 pu2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sw2Var, pu2Var) == null) {
            super.E(sw2Var, pu2Var);
            if (l) {
                Log.d("AppsControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + sw2Var.j0());
            }
            ru2.c(sw2Var, new b(this, sw2Var));
            pi2.U().d1(sw2Var);
            pi2.U().c1(sw2Var);
            pi2.U().H0(null);
        }
    }

    @Override // com.baidu.tieba.ex2, com.baidu.tieba.gx2
    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.N();
            ai2.d();
            pi2.N0(false);
            if (this.a != null) {
                this.a = null;
            }
            io3.j();
            uy2.b();
            l03.y();
            sm3.u();
            PaymentPanelManager.F();
            ul3.n();
            hl3.d();
            dm3.k();
            bp2.d();
            ao4.f();
            j23.e().o();
            le3.h();
            nl3.h();
            i23.k();
            if (cv2.I() != null) {
                cv2.I().e();
            }
            m22.e().n();
            e42.b().f();
            ie3.b().k();
            mq2.d();
            h32.d().h();
            a23.g().f();
            ki2.b();
            ow2.c().a();
            p63.g().b();
            SwanPrefetchImageRes.b().e();
            uf2.g().d();
            v92.c().n();
            nr3.c().i();
        }
    }

    @Override // com.baidu.tieba.ex2, com.baidu.tieba.gx2
    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.v();
            v82.i("SwanApp", "onAppForeground");
            String g0 = vb3.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onAppShow");
            hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            hashMap.put("launchId", v53.b());
            SwanAppActivity swanAppActivity = this.d;
            if (swanAppActivity != null && swanAppActivity.T() != null) {
                hashMap.put("clkid", this.d.T().L());
                hashMap.put("scene", this.d.T().T());
                sw2.a T2 = this.d.T();
                fi3.v(T2);
                Y(T2);
            }
            u(new xl2(hashMap));
            v82.i("SwanApp", "onAppShow");
            e42.b().g(false);
            uy2.h(true);
            l03.r(false);
            j23.e().h(false);
            m22.e().j();
            i23.i();
            if (cv2.I() != null) {
                cv2.I().a();
            }
            a aVar = new a(this, System.currentTimeMillis());
            if (w53.h()) {
                o53.e().d(aVar, "saveSwanAppForeGroundTime", false);
            } else {
                po3.k(aVar, "saveSwanAppForeGroundTime");
            }
        }
    }

    public final void W(int i, sw2 sw2Var, ru2.g gVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048579, this, i, sw2Var, gVar) == null) && i == 0 && sw2Var != null && gVar != null) {
            a53.o().F(new UbcFlowEvent("na_post_to_main_start"));
            pp3.d0(this.k);
            d dVar = new d(this, sw2Var, gVar);
            this.k = dVar;
            pp3.g0(dVar);
        }
    }

    public final void X(sw2 sw2Var, ru2.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, sw2Var, gVar) == null) {
            a53.o().F(new UbcFlowEvent("na_post_to_main_end"));
            vh3.d().i("na_post_to_main_end");
            if (l) {
                Log.d("AppsControllerImpl", "onLoaded loadedInfo: " + gVar);
            }
            if (this.i) {
                if (l) {
                    Log.e("AppsControllerImpl", Log.getStackTraceString(new Exception("object is released. bundlePath:" + gVar.a + ", baseUrl:" + ix2.T().z())));
                    return;
                }
                return;
            }
            this.c = gVar.a;
            Z(gVar.b);
            if (sw2Var.m0()) {
                n(this.d).setVisibility(0);
                s82.b(true);
                v82.i("AppsControllerImpl", "init sConsole for devHook");
            }
            v82.i("AppsControllerImpl", "handleLoadSwanApp: start MiniApp first page.");
            pi2.U().Z0(sw2Var, gVar);
        }
    }

    @Override // com.baidu.tieba.ex2, com.baidu.tieba.gx2
    public void d(sw2 sw2Var, pu2 pu2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, sw2Var, pu2Var) == null) {
            super.d(sw2Var, pu2Var);
            if (l) {
                Log.d("AppsControllerImpl", "syncLoadSwanApp swanCoreVersion: " + sw2Var.j0());
            }
            pi2.U().d1(sw2Var);
            pi2.U().H0(null);
            SwanAppConfigData Q = ub3.K().q().Q();
            if (Q != null) {
                ru2.g gVar = new ru2.g();
                o53.e().d(new c(this, sw2Var), "deleteLowerVersionFolder", true);
                gVar.b = Q;
                gVar.a = ru2.e.i(sw2Var.H(), sw2Var.v1()).getPath() + File.separator;
                a53.o().F(new UbcFlowEvent("na_post_to_main_start"));
                vh3.d().i("na_post_to_main_start");
                X(sw2Var, gVar);
            }
        }
    }

    public final void Y(sw2 sw2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, sw2Var) == null) && !TextUtils.isEmpty(sw2Var.n("fromHost")) && !TextUtils.isEmpty(sw2Var.n("spuId")) && !TextUtils.isEmpty(sw2Var.n("contentId"))) {
            pp3.b0(new e(this, sw2Var), 2000L);
        }
    }

    public final void Z(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, swanAppConfigData) == null) {
            ub3 K = ub3.K();
            if (K.E()) {
                K.q().G0(swanAppConfigData);
            }
        }
    }

    @Override // com.baidu.tieba.gx2
    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            long R = ix2.T().R();
            if (l) {
                Log.i("AppsControllerImpl", "onAppBackground: background alive thread count:" + R);
            }
            if (this.h && R <= 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.ex2, com.baidu.tieba.gx2
    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.w();
            v82.i("SwanApp", "onAppBackground");
            String g0 = vb3.g0();
            if (TextUtils.isEmpty(g0)) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("lcType", "onAppHide");
            contentValues.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g0);
            contentValues.put("hiddenType", Integer.valueOf(xp3.b().a()));
            u(new xl2(contentValues));
            v82.i("SwanApp", "onAppHide");
            xp3.b().d();
            e42.b().g(true);
            uy2.h(false);
            l03.r(true);
            j23.e().h(true);
            i23.j(false);
            if (cv2.I() != null) {
                cv2.I().c();
            }
            op3.h();
            t13.i();
        }
    }
}
