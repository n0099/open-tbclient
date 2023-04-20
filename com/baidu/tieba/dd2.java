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
import com.baidu.tieba.rq2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes4.dex */
public final class dd2 {
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
        public static final dd2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-865453671, "Lcom/baidu/tieba/dd2$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-865453671, "Lcom/baidu/tieba/dd2$b;");
                    return;
                }
            }
            a = new dd2(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947700631, "Lcom/baidu/tieba/dd2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947700631, "Lcom/baidu/tieba/dd2;");
                return;
            }
        }
        b = fo1.a;
    }

    public dd2() {
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

    public static dd2 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (dd2) invokeV.objValue;
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.a = false;
            }
        }
    }

    public /* synthetic */ dd2(a aVar) {
        this();
    }

    public final void a(@NonNull SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, swanAppConfigData) == null) {
            if (b) {
                Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
            }
            fx1.k(swanAppConfigData);
            fd2.k().x(u73.K().getAppId(), false);
            rg3.l().t();
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
    /* JADX WARN: Type inference failed for: r3v15, types: [com.baidu.tieba.cu1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void b(@NonNull r92 r92Var, @NonNull bu1 bu1Var, @NonNull ss2 ss2Var, @NonNull SwanAppConfigData swanAppConfigData, @Nullable rq2.g gVar, boolean z) {
        boolean z2;
        PMSAppInfo f0;
        boolean H;
        Bundle P;
        boolean F;
        me2 me2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{r92Var, bu1Var, ss2Var, swanAppConfigData, gVar, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (b) {
                    Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
                    Log.d("SwanPrelink", "start dispatch launch event");
                }
                if (this.a) {
                    if (z) {
                        ke2.c(14);
                    }
                    return;
                }
                if (z) {
                    ke2.c(1);
                }
                String d = gb3.d(it2.U(), ss2Var, swanAppConfigData);
                String h = swanAppConfigData.h(d);
                je2 je2Var = new je2();
                je2Var.a = swanAppConfigData.n;
                if (gVar != null && !TextUtils.isEmpty(gVar.a)) {
                    je2Var.b = gVar.a;
                } else {
                    je2Var.b = rq2.e.i(ss2Var.H(), ss2Var.v1()).getPath() + File.separator;
                }
                je2Var.c = bu1Var.a();
                je2Var.d = d;
                je2Var.f = String.valueOf(s42.a());
                je2Var.g = je2.c(v73.M(), d);
                je2Var.i = h;
                if (!b && !it2.U().N()) {
                    z2 = false;
                    je2Var.h = z2;
                    je2Var.j = bu1Var.J();
                    je2Var.l = ne2.b();
                    f0 = ss2Var.f0();
                    if (f0 != null && !TextUtils.isEmpty(f0.userActionApis)) {
                        je2Var.m = f0.userActionApis;
                    }
                    H = u33.H();
                    if (H) {
                        je2Var.k = y42.b();
                    }
                    P = ss2Var.P();
                    if (P != null) {
                        String string = P.getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
                        if (!TextUtils.isEmpty(string)) {
                            je2Var.e = string;
                        }
                    }
                    if (b) {
                        Log.d("AppLaunchMessenger", je2Var.toString());
                    }
                    a13.o().F(new UbcFlowEvent("master_dispatch_start"));
                    vd3.d().i("master_dispatch_start");
                    r92Var.D(je2Var);
                    pe2.U().U0(je2.b(je2Var));
                    cr2.m0().a();
                    pe2.U().h1(je2Var.j);
                    F = u33.F(ss2Var.g0());
                    boolean p0 = ss2Var.p0();
                    if (!F) {
                        l52.d();
                        l52.g().h("appready");
                    } else if (p0) {
                        e52.e().f("appready");
                    }
                    k83 f = it2.U().f(nb3.b(nl3.f(d)));
                    me2Var = new me2();
                    if (gVar == null && !TextUtils.isEmpty(gVar.a)) {
                        me2Var.a = gVar.a;
                    } else {
                        me2Var.a = rq2.e.i(ss2Var.H(), ss2Var.v1()).getPath() + File.separator;
                    }
                    me2Var.b = d;
                    me2Var.d = f.g;
                    me2Var.c = h;
                    me2Var.k = je2Var.g;
                    me2Var.e = String.valueOf(ss2Var.m0());
                    me2Var.g = z2;
                    me2Var.i = bu1Var.J();
                    me2Var.m = true;
                    if (H) {
                        me2Var.j = y42.d();
                    }
                    if (!F) {
                        l52.g().h("pageready");
                    } else if (p0) {
                        e52.e().f("pageready");
                    }
                    if (b) {
                        Log.d("AppLaunchMessenger", me2Var.toString());
                    }
                    a13.o().F(new UbcFlowEvent("slave_dispatch_start"));
                    vd3.d().i("slave_dispatch_start");
                    bu1Var.K(me2Var);
                    cl3.d();
                    bu1Var.r().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d);
                    bu1Var.R(d);
                    pe2.U().V0(bu1Var.a(), me2.a(me2Var));
                    fe3.F(bu1Var.a(), me2Var.b);
                    if (b) {
                        Log.d("AppLaunchMessenger", "app path: " + je2Var.b);
                        Log.d("AppLaunchMessenger", "webviewId: " + bu1Var.a());
                        Log.d("AppLaunchMessenger", "pageUrl: " + d);
                        Log.d("AppLaunchMessenger", "pagePath: " + me2Var.b);
                        Log.d("AppLaunchMessenger", "onReachBottomDistance: " + me2Var.d);
                        Log.d("AppLaunchMessenger", "sConsole:" + me2Var.e);
                    }
                    a(swanAppConfigData);
                    this.a = true;
                    e();
                }
                z2 = true;
                je2Var.h = z2;
                je2Var.j = bu1Var.J();
                je2Var.l = ne2.b();
                f0 = ss2Var.f0();
                if (f0 != null) {
                    je2Var.m = f0.userActionApis;
                }
                H = u33.H();
                if (H) {
                }
                P = ss2Var.P();
                if (P != null) {
                }
                if (b) {
                }
                a13.o().F(new UbcFlowEvent("master_dispatch_start"));
                vd3.d().i("master_dispatch_start");
                r92Var.D(je2Var);
                pe2.U().U0(je2.b(je2Var));
                cr2.m0().a();
                pe2.U().h1(je2Var.j);
                F = u33.F(ss2Var.g0());
                boolean p02 = ss2Var.p0();
                if (!F) {
                }
                k83 f2 = it2.U().f(nb3.b(nl3.f(d)));
                me2Var = new me2();
                if (gVar == null) {
                }
                me2Var.a = rq2.e.i(ss2Var.H(), ss2Var.v1()).getPath() + File.separator;
                me2Var.b = d;
                me2Var.d = f2.g;
                me2Var.c = h;
                me2Var.k = je2Var.g;
                me2Var.e = String.valueOf(ss2Var.m0());
                me2Var.g = z2;
                me2Var.i = bu1Var.J();
                me2Var.m = true;
                if (H) {
                }
                if (!F) {
                }
                if (b) {
                }
                a13.o().F(new UbcFlowEvent("slave_dispatch_start"));
                vd3.d().i("slave_dispatch_start");
                bu1Var.K(me2Var);
                cl3.d();
                bu1Var.r().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d);
                bu1Var.R(d);
                pe2.U().V0(bu1Var.a(), me2.a(me2Var));
                fe3.F(bu1Var.a(), me2Var.b);
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
        r92 W;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (b2 = t13.b()) != 0 && (W = pe2.U().W()) != null) {
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
