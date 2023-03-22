package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.pq2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes3.dex */
public final class bd2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final bd2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-922711973, "Lcom/baidu/tieba/bd2$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-922711973, "Lcom/baidu/tieba/bd2$b;");
                    return;
                }
            }
            a = new bd2(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947641049, "Lcom/baidu/tieba/bd2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947641049, "Lcom/baidu/tieba/bd2;");
                return;
            }
        }
        b = do1.a;
    }

    public bd2() {
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
    }

    public static bd2 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (bd2) invokeV.objValue;
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.a = false;
            }
        }
    }

    public /* synthetic */ bd2(a aVar) {
        this();
    }

    public final void a(@NonNull SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, swanAppConfigData) == null) {
            if (b) {
                Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
            }
            dx1.k(swanAppConfigData);
            dd2.k().x(s73.K().getAppId(), false);
            pg3.l().t();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00d2 A[Catch: all -> 0x02ce, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x0020, B:12:0x0026, B:17:0x0030, B:18:0x0033, B:20:0x004c, B:22:0x0054, B:24:0x007c, B:26:0x009e, B:31:0x00ac, B:33:0x00c0, B:35:0x00c8, B:36:0x00cc, B:38:0x00d2, B:39:0x00d8, B:41:0x00de, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:47:0x00f9, B:49:0x013e, B:52:0x0156, B:54:0x016d, B:56:0x0175, B:58:0x019d, B:60:0x01c0, B:62:0x01c8, B:65:0x01dd, B:67:0x01e1, B:68:0x01ea, B:70:0x0231, B:71:0x02c3, B:64:0x01d4, B:57:0x017a, B:51:0x014d, B:23:0x0059), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00de A[Catch: all -> 0x02ce, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x0020, B:12:0x0026, B:17:0x0030, B:18:0x0033, B:20:0x004c, B:22:0x0054, B:24:0x007c, B:26:0x009e, B:31:0x00ac, B:33:0x00c0, B:35:0x00c8, B:36:0x00cc, B:38:0x00d2, B:39:0x00d8, B:41:0x00de, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:47:0x00f9, B:49:0x013e, B:52:0x0156, B:54:0x016d, B:56:0x0175, B:58:0x019d, B:60:0x01c0, B:62:0x01c8, B:65:0x01dd, B:67:0x01e1, B:68:0x01ea, B:70:0x0231, B:71:0x02c3, B:64:0x01d4, B:57:0x017a, B:51:0x014d, B:23:0x0059), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f0 A[Catch: all -> 0x02ce, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x0020, B:12:0x0026, B:17:0x0030, B:18:0x0033, B:20:0x004c, B:22:0x0054, B:24:0x007c, B:26:0x009e, B:31:0x00ac, B:33:0x00c0, B:35:0x00c8, B:36:0x00cc, B:38:0x00d2, B:39:0x00d8, B:41:0x00de, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:47:0x00f9, B:49:0x013e, B:52:0x0156, B:54:0x016d, B:56:0x0175, B:58:0x019d, B:60:0x01c0, B:62:0x01c8, B:65:0x01dd, B:67:0x01e1, B:68:0x01ea, B:70:0x0231, B:71:0x02c3, B:64:0x01d4, B:57:0x017a, B:51:0x014d, B:23:0x0059), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013e A[Catch: all -> 0x02ce, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x0020, B:12:0x0026, B:17:0x0030, B:18:0x0033, B:20:0x004c, B:22:0x0054, B:24:0x007c, B:26:0x009e, B:31:0x00ac, B:33:0x00c0, B:35:0x00c8, B:36:0x00cc, B:38:0x00d2, B:39:0x00d8, B:41:0x00de, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:47:0x00f9, B:49:0x013e, B:52:0x0156, B:54:0x016d, B:56:0x0175, B:58:0x019d, B:60:0x01c0, B:62:0x01c8, B:65:0x01dd, B:67:0x01e1, B:68:0x01ea, B:70:0x0231, B:71:0x02c3, B:64:0x01d4, B:57:0x017a, B:51:0x014d, B:23:0x0059), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01c0 A[Catch: all -> 0x02ce, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x0020, B:12:0x0026, B:17:0x0030, B:18:0x0033, B:20:0x004c, B:22:0x0054, B:24:0x007c, B:26:0x009e, B:31:0x00ac, B:33:0x00c0, B:35:0x00c8, B:36:0x00cc, B:38:0x00d2, B:39:0x00d8, B:41:0x00de, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:47:0x00f9, B:49:0x013e, B:52:0x0156, B:54:0x016d, B:56:0x0175, B:58:0x019d, B:60:0x01c0, B:62:0x01c8, B:65:0x01dd, B:67:0x01e1, B:68:0x01ea, B:70:0x0231, B:71:0x02c3, B:64:0x01d4, B:57:0x017a, B:51:0x014d, B:23:0x0059), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01c8 A[Catch: all -> 0x02ce, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x0020, B:12:0x0026, B:17:0x0030, B:18:0x0033, B:20:0x004c, B:22:0x0054, B:24:0x007c, B:26:0x009e, B:31:0x00ac, B:33:0x00c0, B:35:0x00c8, B:36:0x00cc, B:38:0x00d2, B:39:0x00d8, B:41:0x00de, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:47:0x00f9, B:49:0x013e, B:52:0x0156, B:54:0x016d, B:56:0x0175, B:58:0x019d, B:60:0x01c0, B:62:0x01c8, B:65:0x01dd, B:67:0x01e1, B:68:0x01ea, B:70:0x0231, B:71:0x02c3, B:64:0x01d4, B:57:0x017a, B:51:0x014d, B:23:0x0059), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01e1 A[Catch: all -> 0x02ce, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x0020, B:12:0x0026, B:17:0x0030, B:18:0x0033, B:20:0x004c, B:22:0x0054, B:24:0x007c, B:26:0x009e, B:31:0x00ac, B:33:0x00c0, B:35:0x00c8, B:36:0x00cc, B:38:0x00d2, B:39:0x00d8, B:41:0x00de, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:47:0x00f9, B:49:0x013e, B:52:0x0156, B:54:0x016d, B:56:0x0175, B:58:0x019d, B:60:0x01c0, B:62:0x01c8, B:65:0x01dd, B:67:0x01e1, B:68:0x01ea, B:70:0x0231, B:71:0x02c3, B:64:0x01d4, B:57:0x017a, B:51:0x014d, B:23:0x0059), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0231 A[Catch: all -> 0x02ce, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x0020, B:12:0x0026, B:17:0x0030, B:18:0x0033, B:20:0x004c, B:22:0x0054, B:24:0x007c, B:26:0x009e, B:31:0x00ac, B:33:0x00c0, B:35:0x00c8, B:36:0x00cc, B:38:0x00d2, B:39:0x00d8, B:41:0x00de, B:43:0x00ea, B:44:0x00ec, B:46:0x00f0, B:47:0x00f9, B:49:0x013e, B:52:0x0156, B:54:0x016d, B:56:0x0175, B:58:0x019d, B:60:0x01c0, B:62:0x01c8, B:65:0x01dd, B:67:0x01e1, B:68:0x01ea, B:70:0x0231, B:71:0x02c3, B:64:0x01d4, B:57:0x017a, B:51:0x014d, B:23:0x0059), top: B:80:0x000d }] */
    /* JADX WARN: Type inference failed for: r3v15, types: [com.baidu.tieba.au1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void b(@NonNull p92 p92Var, @NonNull zt1 zt1Var, @NonNull qs2 qs2Var, @NonNull SwanAppConfigData swanAppConfigData, @Nullable pq2.g gVar, boolean z) {
        boolean z2;
        PMSAppInfo f0;
        boolean H;
        Bundle P;
        boolean F;
        ke2 ke2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{p92Var, zt1Var, qs2Var, swanAppConfigData, gVar, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (b) {
                    Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
                    Log.d("SwanPrelink", "start dispatch launch event");
                }
                if (this.a) {
                    if (z) {
                        ie2.c(14);
                    }
                    return;
                }
                if (z) {
                    ie2.c(1);
                }
                String d = eb3.d(gt2.U(), qs2Var, swanAppConfigData);
                String h = swanAppConfigData.h(d);
                he2 he2Var = new he2();
                he2Var.a = swanAppConfigData.n;
                if (gVar != null && !TextUtils.isEmpty(gVar.a)) {
                    he2Var.b = gVar.a;
                } else {
                    he2Var.b = pq2.e.i(qs2Var.H(), qs2Var.v1()).getPath() + File.separator;
                }
                he2Var.c = zt1Var.a();
                he2Var.d = d;
                he2Var.f = String.valueOf(q42.a());
                he2Var.g = he2.c(t73.M(), d);
                he2Var.i = h;
                if (!b && !gt2.U().N()) {
                    z2 = false;
                    he2Var.h = z2;
                    he2Var.j = zt1Var.J();
                    he2Var.l = le2.b();
                    f0 = qs2Var.f0();
                    if (f0 != null && !TextUtils.isEmpty(f0.userActionApis)) {
                        he2Var.m = f0.userActionApis;
                    }
                    H = s33.H();
                    if (H) {
                        he2Var.k = w42.b();
                    }
                    P = qs2Var.P();
                    if (P != null) {
                        String string = P.getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
                        if (!TextUtils.isEmpty(string)) {
                            he2Var.e = string;
                        }
                    }
                    if (b) {
                        Log.d("AppLaunchMessenger", he2Var.toString());
                    }
                    y03.o().F(new UbcFlowEvent("master_dispatch_start"));
                    td3.d().i("master_dispatch_start");
                    p92Var.D(he2Var);
                    ne2.U().U0(he2.b(he2Var));
                    ar2.m0().a();
                    ne2.U().h1(he2Var.j);
                    F = s33.F(qs2Var.g0());
                    boolean p0 = qs2Var.p0();
                    if (!F) {
                        j52.d();
                        j52.g().h("appready");
                    } else if (p0) {
                        c52.e().f("appready");
                    }
                    i83 f = gt2.U().f(lb3.b(ll3.f(d)));
                    ke2Var = new ke2();
                    if (gVar == null && !TextUtils.isEmpty(gVar.a)) {
                        ke2Var.a = gVar.a;
                    } else {
                        ke2Var.a = pq2.e.i(qs2Var.H(), qs2Var.v1()).getPath() + File.separator;
                    }
                    ke2Var.b = d;
                    ke2Var.d = f.g;
                    ke2Var.c = h;
                    ke2Var.k = he2Var.g;
                    ke2Var.e = String.valueOf(qs2Var.m0());
                    ke2Var.g = z2;
                    ke2Var.i = zt1Var.J();
                    ke2Var.m = true;
                    if (H) {
                        ke2Var.j = w42.d();
                    }
                    if (!F) {
                        j52.g().h("pageready");
                    } else if (p0) {
                        c52.e().f("pageready");
                    }
                    if (b) {
                        Log.d("AppLaunchMessenger", ke2Var.toString());
                    }
                    y03.o().F(new UbcFlowEvent("slave_dispatch_start"));
                    td3.d().i("slave_dispatch_start");
                    zt1Var.L(ke2Var);
                    al3.d();
                    zt1Var.r().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d);
                    zt1Var.R(d);
                    ne2.U().V0(zt1Var.a(), ke2.a(ke2Var));
                    de3.F(zt1Var.a(), ke2Var.b);
                    if (b) {
                        Log.d("AppLaunchMessenger", "app path: " + he2Var.b);
                        Log.d("AppLaunchMessenger", "webviewId: " + zt1Var.a());
                        Log.d("AppLaunchMessenger", "pageUrl: " + d);
                        Log.d("AppLaunchMessenger", "pagePath: " + ke2Var.b);
                        Log.d("AppLaunchMessenger", "onReachBottomDistance: " + ke2Var.d);
                        Log.d("AppLaunchMessenger", "sConsole:" + ke2Var.e);
                    }
                    a(swanAppConfigData);
                    this.a = true;
                    e();
                }
                z2 = true;
                he2Var.h = z2;
                he2Var.j = zt1Var.J();
                he2Var.l = le2.b();
                f0 = qs2Var.f0();
                if (f0 != null) {
                    he2Var.m = f0.userActionApis;
                }
                H = s33.H();
                if (H) {
                }
                P = qs2Var.P();
                if (P != null) {
                }
                if (b) {
                }
                y03.o().F(new UbcFlowEvent("master_dispatch_start"));
                td3.d().i("master_dispatch_start");
                p92Var.D(he2Var);
                ne2.U().U0(he2.b(he2Var));
                ar2.m0().a();
                ne2.U().h1(he2Var.j);
                F = s33.F(qs2Var.g0());
                boolean p02 = qs2Var.p0();
                if (!F) {
                }
                i83 f2 = gt2.U().f(lb3.b(ll3.f(d)));
                ke2Var = new ke2();
                if (gVar == null) {
                }
                ke2Var.a = pq2.e.i(qs2Var.H(), qs2Var.v1()).getPath() + File.separator;
                ke2Var.b = d;
                ke2Var.d = f2.g;
                ke2Var.c = h;
                ke2Var.k = he2Var.g;
                ke2Var.e = String.valueOf(qs2Var.m0());
                ke2Var.g = z2;
                ke2Var.i = zt1Var.J();
                ke2Var.m = true;
                if (H) {
                }
                if (!F) {
                }
                if (b) {
                }
                y03.o().F(new UbcFlowEvent("slave_dispatch_start"));
                td3.d().i("slave_dispatch_start");
                zt1Var.L(ke2Var);
                al3.d();
                zt1Var.r().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d);
                zt1Var.R(d);
                ne2.U().V0(zt1Var.a(), ke2.a(ke2Var));
                de3.F(zt1Var.a(), ke2Var.b);
                if (b) {
                }
                a(swanAppConfigData);
                this.a = true;
                e();
            }
        }
    }

    public final void e() {
        int b2;
        p92 W;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (b2 = r13.b()) != 0 && (W = ne2.U().W()) != null) {
            if (b2 < 0) {
                W.p(b2);
            } else if (b2 == 1) {
                W.p(-4);
            } else {
                W.p(-2);
            }
        }
    }
}
