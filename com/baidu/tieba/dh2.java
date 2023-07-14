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
import com.baidu.tieba.ru2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes5.dex */
public final class dh2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final dh2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-861759587, "Lcom/baidu/tieba/dh2$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-861759587, "Lcom/baidu/tieba/dh2$b;");
                    return;
                }
            }
            a = new dh2(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947704475, "Lcom/baidu/tieba/dh2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947704475, "Lcom/baidu/tieba/dh2;");
                return;
            }
        }
        b = fs1.a;
    }

    public dh2() {
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

    public static dh2 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (dh2) invokeV.objValue;
    }

    public synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                this.a = false;
            }
        }
    }

    public /* synthetic */ dh2(a aVar) {
        this();
    }

    public final void a(@NonNull SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, swanAppConfigData) == null) {
            if (b) {
                Log.d("AppLaunchMessenger", "afterLaunchEventSent: start");
            }
            f12.k(swanAppConfigData);
            fh2.k().x(ub3.K().getAppId(), false);
            rk3.l().t();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00d1 A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00dd A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ef A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013d A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01bf A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01c7 A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01e0 A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x022e A[Catch: all -> 0x02c9, TryCatch #0 {, blocks: (B:6:0x000d, B:8:0x0011, B:9:0x001f, B:12:0x0025, B:17:0x002f, B:18:0x0032, B:20:0x004b, B:22:0x0053, B:24:0x007b, B:26:0x009d, B:31:0x00ab, B:33:0x00bf, B:35:0x00c7, B:36:0x00cb, B:38:0x00d1, B:39:0x00d7, B:41:0x00dd, B:43:0x00e9, B:44:0x00eb, B:46:0x00ef, B:47:0x00f8, B:49:0x013d, B:52:0x0155, B:54:0x016c, B:56:0x0174, B:58:0x019c, B:60:0x01bf, B:62:0x01c7, B:65:0x01dc, B:67:0x01e0, B:68:0x01e9, B:70:0x022e, B:71:0x02be, B:64:0x01d3, B:57:0x0179, B:51:0x014c, B:23:0x0058), top: B:80:0x000d }] */
    /* JADX WARN: Type inference failed for: r3v15, types: [com.baidu.tieba.cy1] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void b(@NonNull rd2 rd2Var, @NonNull by1 by1Var, @NonNull sw2 sw2Var, @NonNull SwanAppConfigData swanAppConfigData, @Nullable ru2.g gVar, boolean z) {
        boolean z2;
        PMSAppInfo f0;
        boolean H;
        Bundle P;
        boolean F;
        mi2 mi2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{rd2Var, by1Var, sw2Var, swanAppConfigData, gVar, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (b) {
                    Log.d("AppLaunchMessenger", "dispatchLaunchEvent");
                    Log.d("SwanPrelink", "start dispatch launch event");
                }
                if (this.a) {
                    if (z) {
                        ki2.c(14);
                    }
                    return;
                }
                if (z) {
                    ki2.c(1);
                }
                String d = gf3.d(ix2.T(), sw2Var, swanAppConfigData);
                String h = swanAppConfigData.h(d);
                ji2 ji2Var = new ji2();
                ji2Var.a = swanAppConfigData.n;
                if (gVar != null && !TextUtils.isEmpty(gVar.a)) {
                    ji2Var.b = gVar.a;
                } else {
                    ji2Var.b = ru2.e.i(sw2Var.H(), sw2Var.v1()).getPath() + File.separator;
                }
                ji2Var.c = by1Var.a();
                ji2Var.d = d;
                ji2Var.f = String.valueOf(s82.a());
                ji2Var.g = ji2.c(vb3.M(), d);
                ji2Var.i = h;
                if (!b && !ix2.T().M()) {
                    z2 = false;
                    ji2Var.h = z2;
                    ji2Var.j = by1Var.I();
                    ji2Var.l = ni2.b();
                    f0 = sw2Var.f0();
                    if (f0 != null && !TextUtils.isEmpty(f0.userActionApis)) {
                        ji2Var.m = f0.userActionApis;
                    }
                    H = u73.H();
                    if (H) {
                        ji2Var.k = y82.b();
                    }
                    P = sw2Var.P();
                    if (P != null) {
                        String string = P.getString(PrefetchEvent.EVENT_DATA_EXTRA_DATA);
                        if (!TextUtils.isEmpty(string)) {
                            ji2Var.e = string;
                        }
                    }
                    if (b) {
                        Log.d("AppLaunchMessenger", ji2Var.toString());
                    }
                    a53.o().F(new UbcFlowEvent("master_dispatch_start"));
                    vh3.d().i("master_dispatch_start");
                    rd2Var.C(ji2Var);
                    pi2.U().U0(ji2.b(ji2Var));
                    cv2.m0().a();
                    pi2.U().h1(ji2Var.j);
                    F = u73.F(sw2Var.g0());
                    boolean p0 = sw2Var.p0();
                    if (!F) {
                        l92.d();
                        l92.g().h("appready");
                    } else if (p0) {
                        e92.e().f("appready");
                    }
                    kc3 f = ix2.T().f(nf3.b(np3.f(d)));
                    mi2Var = new mi2();
                    if (gVar == null && !TextUtils.isEmpty(gVar.a)) {
                        mi2Var.a = gVar.a;
                    } else {
                        mi2Var.a = ru2.e.i(sw2Var.H(), sw2Var.v1()).getPath() + File.separator;
                    }
                    mi2Var.b = d;
                    mi2Var.d = f.g;
                    mi2Var.c = h;
                    mi2Var.k = ji2Var.g;
                    mi2Var.e = String.valueOf(sw2Var.m0());
                    mi2Var.g = z2;
                    mi2Var.i = by1Var.I();
                    mi2Var.m = true;
                    if (H) {
                        mi2Var.j = y82.d();
                    }
                    if (!F) {
                        l92.g().h("pageready");
                    } else if (p0) {
                        e92.e().f("pageready");
                    }
                    if (b) {
                        Log.d("AppLaunchMessenger", mi2Var.toString());
                    }
                    a53.o().F(new UbcFlowEvent("slave_dispatch_start"));
                    vh3.d().i("slave_dispatch_start");
                    by1Var.J(mi2Var);
                    cp3.d();
                    by1Var.r().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d);
                    by1Var.Q(d);
                    pi2.U().V0(by1Var.a(), mi2.a(mi2Var));
                    fi3.F(by1Var.a(), mi2Var.b);
                    if (b) {
                        Log.d("AppLaunchMessenger", "app path: " + ji2Var.b);
                        Log.d("AppLaunchMessenger", "webviewId: " + by1Var.a());
                        Log.d("AppLaunchMessenger", "pageUrl: " + d);
                        Log.d("AppLaunchMessenger", "pagePath: " + mi2Var.b);
                        Log.d("AppLaunchMessenger", "onReachBottomDistance: " + mi2Var.d);
                        Log.d("AppLaunchMessenger", "sConsole:" + mi2Var.e);
                    }
                    a(swanAppConfigData);
                    this.a = true;
                    e();
                }
                z2 = true;
                ji2Var.h = z2;
                ji2Var.j = by1Var.I();
                ji2Var.l = ni2.b();
                f0 = sw2Var.f0();
                if (f0 != null) {
                    ji2Var.m = f0.userActionApis;
                }
                H = u73.H();
                if (H) {
                }
                P = sw2Var.P();
                if (P != null) {
                }
                if (b) {
                }
                a53.o().F(new UbcFlowEvent("master_dispatch_start"));
                vh3.d().i("master_dispatch_start");
                rd2Var.C(ji2Var);
                pi2.U().U0(ji2.b(ji2Var));
                cv2.m0().a();
                pi2.U().h1(ji2Var.j);
                F = u73.F(sw2Var.g0());
                boolean p02 = sw2Var.p0();
                if (!F) {
                }
                kc3 f2 = ix2.T().f(nf3.b(np3.f(d)));
                mi2Var = new mi2();
                if (gVar == null) {
                }
                mi2Var.a = ru2.e.i(sw2Var.H(), sw2Var.v1()).getPath() + File.separator;
                mi2Var.b = d;
                mi2Var.d = f2.g;
                mi2Var.c = h;
                mi2Var.k = ji2Var.g;
                mi2Var.e = String.valueOf(sw2Var.m0());
                mi2Var.g = z2;
                mi2Var.i = by1Var.I();
                mi2Var.m = true;
                if (H) {
                }
                if (!F) {
                }
                if (b) {
                }
                a53.o().F(new UbcFlowEvent("slave_dispatch_start"));
                vh3.d().i("slave_dispatch_start");
                by1Var.J(mi2Var);
                cp3.d();
                by1Var.r().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, d);
                by1Var.Q(d);
                pi2.U().V0(by1Var.a(), mi2.a(mi2Var));
                fi3.F(by1Var.a(), mi2Var.b);
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
        rd2 W;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (b2 = t53.b()) != 0 && (W = pi2.U().W()) != null) {
            if (b2 < 0) {
                W.o(b2);
            } else if (b2 == 1) {
                W.o(-4);
            } else {
                W.o(-2);
            }
        }
    }
}
