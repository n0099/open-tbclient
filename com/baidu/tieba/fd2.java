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
import com.baidu.tieba.tq2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes4.dex */
public final class fd2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final fd2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-808195369, "Lcom/baidu/tieba/fd2$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-808195369, "Lcom/baidu/tieba/fd2$b;");
                    return;
                }
            }
            a = new fd2(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947760213, "Lcom/baidu/tieba/fd2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947760213, "Lcom/baidu/tieba/fd2;");
                return;
            }
        }
        b = ho1.a;
    }

    public fd2() {
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

    public static fd2 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (fd2) invokeV.objValue;
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.a = false;
            }
        }
    }

    public /* synthetic */ fd2(a aVar) {
        this();
    }

    public final void a(@NonNull SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, swanAppConfigData) == null) {
            if (b) {
                Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
            }
            hx1.k(swanAppConfigData);
            hd2.k().x(w73.K().getAppId(), false);
            tg3.l().t();
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
    /* JADX WARN: Type inference failed for: r3v15, types: [com.baidu.tieba.eu1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void b(@NonNull t92 t92Var, @NonNull du1 du1Var, @NonNull us2 us2Var, @NonNull SwanAppConfigData swanAppConfigData, @Nullable tq2.g gVar, boolean z) {
        boolean z2;
        PMSAppInfo f0;
        boolean H;
        Bundle P;
        boolean F;
        oe2 oe2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{t92Var, du1Var, us2Var, swanAppConfigData, gVar, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (b) {
                    Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
                    Log.d("SwanPrelink", "start dispatch launch event");
                }
                if (this.a) {
                    if (z) {
                        me2.c(14);
                    }
                    return;
                }
                if (z) {
                    me2.c(1);
                }
                String d = ib3.d(kt2.U(), us2Var, swanAppConfigData);
                String h = swanAppConfigData.h(d);
                le2 le2Var = new le2();
                le2Var.a = swanAppConfigData.n;
                if (gVar != null && !TextUtils.isEmpty(gVar.a)) {
                    le2Var.b = gVar.a;
                } else {
                    le2Var.b = tq2.e.i(us2Var.H(), us2Var.v1()).getPath() + File.separator;
                }
                le2Var.c = du1Var.a();
                le2Var.d = d;
                le2Var.f = String.valueOf(u42.a());
                le2Var.g = le2.c(x73.M(), d);
                le2Var.i = h;
                if (!b && !kt2.U().N()) {
                    z2 = false;
                    le2Var.h = z2;
                    le2Var.j = du1Var.J();
                    le2Var.l = pe2.b();
                    f0 = us2Var.f0();
                    if (f0 != null && !TextUtils.isEmpty(f0.userActionApis)) {
                        le2Var.m = f0.userActionApis;
                    }
                    H = w33.H();
                    if (H) {
                        le2Var.k = a52.b();
                    }
                    P = us2Var.P();
                    if (P != null) {
                        String string = P.getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
                        if (!TextUtils.isEmpty(string)) {
                            le2Var.e = string;
                        }
                    }
                    if (b) {
                        Log.d("AppLaunchMessenger", le2Var.toString());
                    }
                    c13.o().F(new UbcFlowEvent("master_dispatch_start"));
                    xd3.d().i("master_dispatch_start");
                    t92Var.D(le2Var);
                    re2.U().U0(le2.b(le2Var));
                    er2.m0().a();
                    re2.U().h1(le2Var.j);
                    F = w33.F(us2Var.g0());
                    boolean p0 = us2Var.p0();
                    if (!F) {
                        n52.d();
                        n52.g().h("appready");
                    } else if (p0) {
                        g52.e().f("appready");
                    }
                    m83 f = kt2.U().f(pb3.b(pl3.f(d)));
                    oe2Var = new oe2();
                    if (gVar == null && !TextUtils.isEmpty(gVar.a)) {
                        oe2Var.a = gVar.a;
                    } else {
                        oe2Var.a = tq2.e.i(us2Var.H(), us2Var.v1()).getPath() + File.separator;
                    }
                    oe2Var.b = d;
                    oe2Var.d = f.g;
                    oe2Var.c = h;
                    oe2Var.k = le2Var.g;
                    oe2Var.e = String.valueOf(us2Var.m0());
                    oe2Var.g = z2;
                    oe2Var.i = du1Var.J();
                    oe2Var.m = true;
                    if (H) {
                        oe2Var.j = a52.d();
                    }
                    if (!F) {
                        n52.g().h("pageready");
                    } else if (p0) {
                        g52.e().f("pageready");
                    }
                    if (b) {
                        Log.d("AppLaunchMessenger", oe2Var.toString());
                    }
                    c13.o().F(new UbcFlowEvent("slave_dispatch_start"));
                    xd3.d().i("slave_dispatch_start");
                    du1Var.K(oe2Var);
                    el3.d();
                    du1Var.s().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d);
                    du1Var.R(d);
                    re2.U().V0(du1Var.a(), oe2.a(oe2Var));
                    he3.F(du1Var.a(), oe2Var.b);
                    if (b) {
                        Log.d("AppLaunchMessenger", "app path: " + le2Var.b);
                        Log.d("AppLaunchMessenger", "webviewId: " + du1Var.a());
                        Log.d("AppLaunchMessenger", "pageUrl: " + d);
                        Log.d("AppLaunchMessenger", "pagePath: " + oe2Var.b);
                        Log.d("AppLaunchMessenger", "onReachBottomDistance: " + oe2Var.d);
                        Log.d("AppLaunchMessenger", "sConsole:" + oe2Var.e);
                    }
                    a(swanAppConfigData);
                    this.a = true;
                    e();
                }
                z2 = true;
                le2Var.h = z2;
                le2Var.j = du1Var.J();
                le2Var.l = pe2.b();
                f0 = us2Var.f0();
                if (f0 != null) {
                    le2Var.m = f0.userActionApis;
                }
                H = w33.H();
                if (H) {
                }
                P = us2Var.P();
                if (P != null) {
                }
                if (b) {
                }
                c13.o().F(new UbcFlowEvent("master_dispatch_start"));
                xd3.d().i("master_dispatch_start");
                t92Var.D(le2Var);
                re2.U().U0(le2.b(le2Var));
                er2.m0().a();
                re2.U().h1(le2Var.j);
                F = w33.F(us2Var.g0());
                boolean p02 = us2Var.p0();
                if (!F) {
                }
                m83 f2 = kt2.U().f(pb3.b(pl3.f(d)));
                oe2Var = new oe2();
                if (gVar == null) {
                }
                oe2Var.a = tq2.e.i(us2Var.H(), us2Var.v1()).getPath() + File.separator;
                oe2Var.b = d;
                oe2Var.d = f2.g;
                oe2Var.c = h;
                oe2Var.k = le2Var.g;
                oe2Var.e = String.valueOf(us2Var.m0());
                oe2Var.g = z2;
                oe2Var.i = du1Var.J();
                oe2Var.m = true;
                if (H) {
                }
                if (!F) {
                }
                if (b) {
                }
                c13.o().F(new UbcFlowEvent("slave_dispatch_start"));
                xd3.d().i("slave_dispatch_start");
                du1Var.K(oe2Var);
                el3.d();
                du1Var.s().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d);
                du1Var.R(d);
                re2.U().V0(du1Var.a(), oe2.a(oe2Var));
                he3.F(du1Var.a(), oe2Var.b);
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
        t92 W;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (b2 = v13.b()) != 0 && (W = re2.U().W()) != null) {
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
