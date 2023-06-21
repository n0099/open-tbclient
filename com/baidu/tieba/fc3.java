package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.dc3;
import com.baidu.tieba.mb2;
import com.baidu.tieba.ww2;
import com.baidu.tieba.ym4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Locale;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class fc3 extends hc3 implements tl2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public Set<ym4.a> g;
    public int h;
    public boolean i;
    public final zb3 j;
    public String k;
    public boolean l;
    public PMSAppInfo m;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(fc3 fc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fc3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                yb3.K().n("flag_finish_activity", "flag_remove_task");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ww2 a;
        public final /* synthetic */ int b;

        public b(fc3 fc3Var, ww2 ww2Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fc3Var, ww2Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ww2Var;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.u0(this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HybridUbcFlow a;
        public final /* synthetic */ fc3 b;

        public c(fc3 fc3Var, HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fc3Var, hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fc3Var;
            this.a = hybridUbcFlow;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                HybridUbcFlow hybridUbcFlow = this.a;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("postExec-run");
                ubcFlowEvent.a(true);
                hybridUbcFlow.F(ubcFlowEvent);
                this.b.d0();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bundle a;
        public final /* synthetic */ fc3 b;

        public d(fc3 fc3Var, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fc3Var, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fc3Var;
            this.a = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Bundle bundle = new Bundle();
                Bundle bundle2 = this.a;
                if (bundle2 != null) {
                    bundle.putAll(bundle2);
                }
                bundle.putInt("appFrameType", this.b.j0().G());
                bundle.putString("mAppId", this.b.getAppId());
                if (fc3.n) {
                    fc3.p0("updateLocalPkgWithAsyncUpdatePkg: swanAsyncUpdate -> 发送异步升级消息");
                }
                p83 e = p83.e();
                r83 r83Var = new r83(17, bundle);
                r83Var.j(5000L);
                e.h(r83Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements wh2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fc3 a;

        public e(fc3 fc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fc3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fc3Var;
        }

        @Override // com.baidu.tieba.wh2
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                HybridUbcFlow p = e53.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheckUpdate");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                this.a.c0(pMSAppInfo);
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheckUpdateIcon");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
            }
        }

        @Override // com.baidu.tieba.wh2
        public void onFailed(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                HybridUbcFlow p = e53.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheck#OnFailedStart");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                if (fc3.n) {
                    fc3.p0("预制包安装失败");
                }
                this.a.K0();
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheck#OnonFailedEnd");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
            }
        }

        @Override // com.baidu.tieba.wh2
        public void b(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) != null) {
                return;
            }
            this.a.h = 5;
            fc3 fc3Var = this.a;
            fc3Var.b0("KEY_PKG_STATE", "event_pms_check_finish", fc3Var.h);
            HybridUbcFlow p = e53.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (fc3.n) {
                fc3.p0("预制包安装成功");
            }
            fc3.o0(this.a.j0(), pMSAppInfo, false, false);
            this.a.M0(pMSAppInfo);
            this.a.I0(null);
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessEnd");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
        }
    }

    /* loaded from: classes5.dex */
    public class f extends f83 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ww2 c;
        public final /* synthetic */ fc3 d;

        @Override // com.baidu.tieba.f83, com.baidu.tieba.e83
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 1000L;
            }
            return invokeV.longValue;
        }

        public f(fc3 fc3Var, ww2 ww2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fc3Var, ww2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = fc3Var;
            this.c = ww2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.f83, com.baidu.tieba.g83, com.baidu.tieba.e83
        public void onEvent(@NonNull c83 c83Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c83Var) == null) {
                Bundle a = c83Var.a();
                boolean z = false;
                if (a != null) {
                    z = a.getBoolean("isDownloading", false);
                }
                fc3.o0(this.c, this.d.m, true, z);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g extends xe2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fc3 h;

        public g(fc3 fc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fc3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = fc3Var;
        }

        @Override // com.baidu.tieba.xe2, com.baidu.tieba.uj4
        public void G(hp4 hp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, hp4Var) != null) {
                return;
            }
            this.h.c = true;
            yb3.K().p("event_pkg_download_start");
            super.G(hp4Var);
        }

        @Override // com.baidu.tieba.xe2
        public void Q(@NonNull sn3 sn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sn3Var) == null) {
                wn3.a().f(sn3Var);
                this.h.A0(sn3Var);
                this.h.t0(false);
            }
        }

        @Override // com.baidu.tieba.xe2
        public void R() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) {
                return;
            }
            this.h.c = false;
            fc3.o0(this.h.j0(), this.h.m, false, false);
            fc3 fc3Var = this.h;
            if (fc3Var.i) {
                i = 3;
            } else {
                i = 4;
            }
            fc3Var.h = i;
            this.h.I0(null);
            fc3 fc3Var2 = this.h;
            fc3Var2.b0("KEY_PKG_STATE", "event_pms_check_finish", fc3Var2.h);
        }

        @Override // com.baidu.tieba.xe2, com.baidu.tieba.uj4, com.baidu.tieba.rj4
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048579, this) != null) {
                return;
            }
            this.h.c = false;
            yb3.K().p("event_pkg_download_finish");
            super.b();
        }
    }

    /* loaded from: classes5.dex */
    public class h implements if2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ bn4 b;
        public final /* synthetic */ HybridUbcFlow c;
        public final /* synthetic */ fc3 d;

        public h(fc3 fc3Var, boolean z, bn4 bn4Var, HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fc3Var, Boolean.valueOf(z), bn4Var, hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = fc3Var;
            this.a = z;
            this.b = bn4Var;
            this.c = hybridUbcFlow;
        }

        @Override // com.baidu.tieba.if2
        public void a(sn3 sn3Var, boolean z) {
            long a;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, sn3Var, z) == null) {
                if (sn3Var == null) {
                    a = 0;
                } else {
                    a = sn3Var.a();
                }
                z82.k("SwanPkgMaintainer", "mFlagDownloading reset onFinalFailed isRetry = " + this.a + ",code =" + a);
                if (this.a) {
                    si3.L("pkg_retry_fail", String.valueOf(a));
                }
                if (this.d.a0(this.b, sn3Var)) {
                    return;
                }
                this.d.c = false;
                yb3.K().p("event_pkg_download_finish");
                HybridUbcFlow hybridUbcFlow = this.c;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedStart");
                ubcFlowEvent.a(true);
                hybridUbcFlow.F(ubcFlowEvent);
                wn3.a().f(sn3Var);
                if (z) {
                    fc3 fc3Var = this.d;
                    if (fc3Var.i) {
                        i = 3;
                    } else {
                        i = 4;
                    }
                    fc3Var.h = i;
                    fc3 fc3Var2 = this.d;
                    fc3Var2.b0("KEY_PKG_STATE", "event_pms_check_finish", fc3Var2.h);
                    this.d.H0(sn3Var);
                } else if (sn3Var != null && sn3Var.h() == 1020) {
                    this.d.A0(sn3Var);
                }
                HybridUbcFlow hybridUbcFlow2 = this.c;
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedEnd");
                ubcFlowEvent2.a(true);
                hybridUbcFlow2.F(ubcFlowEvent2);
                if (sn3Var != null && sn3Var.h() == 2203) {
                    z82.k("SwanPkgMaintainer", "recoverPlatform for errorCode 2203");
                    if (xk2.a().b(1) == 0) {
                        xk2.a().c();
                    }
                }
            }
        }

        @Override // com.baidu.tieba.if2
        public void b(PMSAppInfo pMSAppInfo) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) == null) {
                z82.k("SwanPkgMaintainer", "mFlagDownloading reset onFinalComplete isRetry = " + this.a);
                if (this.a) {
                    si3.L("pkg_retry_success", "");
                }
                int i2 = 0;
                this.d.c = false;
                fc3 fc3Var = this.d;
                if (fc3Var.e) {
                    i2 = 2;
                }
                fc3Var.h = i2;
                fc3 fc3Var2 = this.d;
                if (!fc3Var2.i) {
                    i = this.d.h;
                } else {
                    i = 1;
                }
                fc3Var2.h = i;
                fc3 fc3Var3 = this.d;
                fc3Var3.b0("KEY_PKG_STATE", "event_pms_check_finish", fc3Var3.h);
                HybridUbcFlow hybridUbcFlow = this.c;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteStart");
                ubcFlowEvent.a(true);
                hybridUbcFlow.F(ubcFlowEvent);
                this.d.M0(pMSAppInfo);
                this.d.F0(null);
                HybridUbcFlow hybridUbcFlow2 = this.c;
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalCompleteEnd");
                ubcFlowEvent2.a(true);
                hybridUbcFlow2.F(ubcFlowEvent2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements sq3<PMSAppInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HybridUbcFlow a;
        public final /* synthetic */ fc3 b;

        public i(fc3 fc3Var, HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fc3Var, hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = fc3Var;
            this.a = hybridUbcFlow;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.sq3
        /* renamed from: b */
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) == null) {
                HybridUbcFlow hybridUbcFlow = this.a;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedStart");
                ubcFlowEvent.a(true);
                hybridUbcFlow.F(ubcFlowEvent);
                if (fc3.n) {
                    fc3.p0("onAppInfoReceived appInfo=" + pMSAppInfo);
                }
                this.b.M0(pMSAppInfo);
                this.b.c0(pMSAppInfo);
                HybridUbcFlow hybridUbcFlow2 = this.a;
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedEnd");
                ubcFlowEvent2.a(true);
                hybridUbcFlow2.F(ubcFlowEvent2);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class j extends af2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean G;
        public final /* synthetic */ fc3 H;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(fc3 fc3Var, zb3 zb3Var, boolean z) {
            super(zb3Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fc3Var, zb3Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((zb3) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.H = fc3Var;
            this.G = z;
        }

        @Override // com.baidu.tieba.af2, com.baidu.tieba.ze2, com.baidu.tieba.uj4
        public void G(hp4 hp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, hp4Var) == null) {
                z82.k("SwanPkgMaintainer", "mFlagDownloading set onPrepareDownload isRetry = " + this.G);
                this.H.c = true;
                yb3.K().p("event_pkg_download_start");
                super.G(hp4Var);
            }
        }

        @Override // com.baidu.tieba.uj4, com.baidu.tieba.rj4
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                z82.k("SwanPkgMaintainer", "mFlagDownloading reset onTotalPkgDownloadFinish isRetry = " + this.G);
                this.H.c = false;
                yb3.K().p("event_pkg_download_finish");
                super.b();
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cj3 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public k(cj3 cj3Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cj3Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cj3Var;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                fc3.n0(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class l extends z73 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public l() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.z73
        public void b(@NonNull Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
                String string = bundle.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID);
                boolean z = false;
                if (TextUtils.isEmpty(string)) {
                    this.d.putBoolean("isDownloading", false);
                    c();
                    return;
                }
                boolean j = jj4.j(string);
                boolean k = jj4.k(string);
                if (z73.e) {
                    Log.d("MDelegate-Delegation", "isDownloading: " + j + ", isInQueue: " + k);
                }
                this.d.putBoolean("isDownloading", (j || k) ? true : true);
                c();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947759283, "Lcom/baidu/tieba/fc3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947759283, "Lcom/baidu/tieba/fc3;");
                return;
            }
        }
        n = js1.a;
    }

    private Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            SwanAppActivity w = this.j.w();
            if (w == null || w.isDestroyed()) {
                return gv2.c();
            }
            return w;
        }
        return (Context) invokeV.objValue;
    }

    public boolean B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public final void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            vu2.O(this.j);
        }
    }

    public ww2 j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.j.W();
        }
        return (ww2) invokeV.objValue;
    }

    public final boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return yb3.K().q().W().c("property_web_mode_degrade");
        }
        return invokeV.booleanValue;
    }

    public synchronized boolean l0() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            synchronized (this) {
                z = this.b;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public synchronized boolean m0() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            synchronized (this) {
                z = this.d;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public synchronized void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            synchronized (this) {
                v0(true, null);
            }
        }
    }

    public synchronized void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            synchronized (this) {
                v0(false, null);
            }
        }
    }

    public int w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fc3(zb3 zb3Var) {
        super(zb3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {zb3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((cc3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.h = -1;
        this.i = false;
        this.k = "";
        this.l = false;
        this.j = zb3Var;
    }

    public final void I0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            HybridUbcFlow p = e53.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n) {
                p0("启动本地包，进程预处理-加载本地包-后台异步更新");
            }
            F0(null);
            r53.j().i(new d(this, bundle));
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgEnd");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
        }
    }

    public final sn3 h0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
            sn3 sn3Var = new sn3();
            switch (i2) {
                case 10001:
                    sn3Var.k(10L);
                    sn3Var.i(2902L);
                    sn3Var.f("no aiapps info in database");
                    break;
                case 10002:
                    sn3Var.k(10L);
                    sn3Var.i(27L);
                    sn3Var.f("category not match");
                    break;
                case 10003:
                    sn3Var.k(10L);
                    sn3Var.i(2107L);
                    sn3Var.d("app forbiddeon");
                    break;
                case 10004:
                    sn3Var.k(10L);
                    sn3Var.i(48L);
                    sn3Var.d("path forbiddeon");
                    break;
            }
            return sn3Var;
        }
        return (sn3) invokeI.objValue;
    }

    public static void p0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65559, null, str) == null) && n) {
            Log.i("SwanPkgMaintainer", str);
        }
    }

    public final void H0(sn3 sn3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, sn3Var) == null) && F0(sn3Var)) {
            aj3 aj3Var = new aj3();
            aj3Var.p(sn3Var);
            aj3Var.r(j0());
            si3.R(aj3Var);
        }
    }

    public void J0(Set<ym4.a> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, set) == null) {
            this.g = set;
            if (set == null || set.isEmpty()) {
                this.f = true;
            }
        }
    }

    public void M0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, pMSAppInfo) == null) {
            this.m = pMSAppInfo;
            this.j.W().c1(pMSAppInfo);
            if (k0()) {
                G0();
                u0();
            }
        }
    }

    public final int Z(@NonNull PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, pMSAppInfo)) == null) {
            int i2 = pMSAppInfo.appStatus;
            if (i2 != 0) {
                return i2;
            }
            int G = j0().G();
            int i3 = pMSAppInfo.appCategory;
            if (i3 <= -1 && G != i3) {
                return 10002;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public final void g0(Set<ym4.a> set) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, set) == null) {
            ym4 ym4Var = new ym4(set);
            ym4Var.d("3");
            g gVar = new g(this);
            if (this.i) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            gVar.L(i2);
            jj4.d(ym4Var, gVar);
        }
    }

    public final void N0(PMSAppInfo pMSAppInfo, HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, pMSAppInfo, hybridUbcFlow) == null) && pMSAppInfo != null && hybridUbcFlow != null) {
            M0(pMSAppInfo);
            c0(this.m);
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("update_icon");
            ubcFlowEvent.a(true);
            hybridUbcFlow.F(ubcFlowEvent);
        }
    }

    public static void n0(cj3 cj3Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65557, null, cj3Var, str, str2) == null) {
            JSONObject k2 = si3.k(str);
            cj3Var.d(str2);
            cj3Var.b(k2);
            si3.onEvent(cj3Var);
        }
    }

    public final void b0(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048592, this, str, str2, i2) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt(str, i2);
            yb3.K().v(str2, bundle);
        }
    }

    public static String i0(Context context, sn3 sn3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, context, sn3Var)) == null) {
            return String.format(context.getResources().getString(R.string.obfuscated_res_0x7f0f01cf), tp3.D(), el3.i(mx2.T().getCoreVersion(), yb3.K().q().k()), String.valueOf(sn3Var.a()));
        }
        return (String) invokeLL.objValue;
    }

    public synchronized void v0(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048608, this, z, str) == null) {
            synchronized (this) {
                this.b = false;
                this.d = true;
                this.m = null;
                if (this.j != null) {
                    this.j.J0(true);
                    z82.i("SwanPkgMaintainer", "swan/web, notifyWebModeStart: true");
                    dc3.a aVar = (dc3.a) new dc3.a("event_on_web_mode_launched").z("mAppId", this.j.b);
                    if (!TextUtils.isEmpty(str)) {
                        aVar.z("property_launch_url", str);
                    }
                    A(aVar);
                    si3.V(z, str);
                }
                if (n) {
                    ex2.d(this.k).h();
                }
                this.k = "";
            }
        }
    }

    public static void o0(zw2 zw2Var, PMSAppInfo pMSAppInfo, boolean z, boolean z2) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{zw2Var, pMSAppInfo, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (n) {
                Log.d("SwanPkgMaintainer", "SwanPkgMaintainer#launchStatistic");
            }
            Bundle s0 = zw2Var.s0();
            String str3 = "1";
            if (z) {
                str = "1";
            } else {
                str = "0";
            }
            s0.putString("aiapp_extra_need_download", str);
            Bundle s02 = zw2Var.s0();
            if (z2) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            s02.putString("aiapp_extra_pkg_downloading", str2);
            cj3 cj3Var = new cj3();
            cj3Var.a = si3.n(zw2Var.G());
            cj3Var.h(zw2Var);
            cj3Var.b = "launch";
            if (!z) {
                str3 = "0";
            }
            cj3Var.o = str3;
            if (pMSAppInfo != null) {
                cj3Var.l = String.valueOf(pMSAppInfo.versionCode);
            }
            s53.e().d(new k(cj3Var, zw2Var.W(), zw2Var.s0().getString("ubc")), "launchStatistic", true);
        }
    }

    public static void y0(PMSAppInfo pMSAppInfo, Context context, ww2 ww2Var, boolean z, String str, sn3 sn3Var) {
        String str2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65560, null, new Object[]{pMSAppInfo, context, ww2Var, Boolean.valueOf(z), str, sn3Var}) != null) || pMSAppInfo == null) {
            return;
        }
        ForbiddenInfo forbiddenInfo = new ForbiddenInfo(ww2Var, str, i0(context, sn3Var));
        forbiddenInfo.enableSlidingFlag = -1;
        if (z) {
            str2 = "type_path_forbidden";
        } else {
            str2 = "type_app_forbidden";
        }
        tw2.l(context, str2, sn3Var, forbiddenInfo, ww2Var.D());
        cj3 cj3Var = new cj3();
        cj3Var.a = si3.n(ww2Var.G());
        cj3Var.b = "launch";
        cj3Var.e = "success";
        cj3Var.i(ww2Var);
        cj3Var.a("status", "2");
        cj3Var.d(ww2Var.s0().getString("ubc"));
        si3.onEvent(cj3Var);
    }

    public final void A0(sn3 sn3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sn3Var) == null) {
            e53.k(sn3Var);
            Context context = getContext();
            if ((context instanceof SwanAppActivity) && !io3.d((SwanAppActivity) context)) {
                if (n) {
                    Log.d("SwanPkgMaintainer", "launcher activity closed, ignore launch err");
                    return;
                }
                return;
            }
            ww2 j0 = j0();
            int G = j0.G();
            if (!sn3Var.l()) {
                aj3 aj3Var = new aj3();
                aj3Var.q(si3.n(G));
                aj3Var.p(sn3Var);
                aj3Var.m(getAppId());
                aj3Var.t(j0.T());
                si3.R(aj3Var);
                sn3Var.n();
            }
            if (!nx2.a().b()) {
                if (n) {
                    Log.d("SwanPkgMaintainer", "launcher activity hide, ignore launch err and reset.");
                }
                tp3.e0(new a(this));
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("mAppId", j0.H());
            bundle.putAll(j0.D());
            tw2.g(gv2.c(), sn3Var, G, getAppId(), true, bundle);
            ji3.m(j0, G, sn3Var);
            gv2.p0().flush(false);
        }
    }

    public final void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            HybridUbcFlow p = e53.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateForIndependentPkgStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n) {
                p0("独立分包启动，本地有包--->打开小程序，异步更新主包");
            }
            ww2 j0 = j0();
            String c2 = gx2.c(this.m, j0.e0());
            j0.F0(true);
            j0.V0(c2);
            Bundle bundle = new Bundle();
            bundle.putLong("pms_update_expect_pkg_ver", this.m.versionCode);
            I0(bundle);
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateForIndependentPkgEnd");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
        }
    }

    public final void G0() {
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            ww2.a W = q().W();
            PMSAppInfo pMSAppInfo = this.m;
            boolean z2 = false;
            if (pMSAppInfo != null && !TextUtils.isEmpty(pMSAppInfo.appId) && TextUtils.equals(getAppId(), this.m.appId)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                W.S0(this.m);
            }
            PMSAppInfo pMSAppInfo2 = this.m;
            if (pMSAppInfo2 != null) {
                if (z && pMSAppInfo2.appCategory == 1) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    z2 = true;
                }
                if (z2) {
                    W.u0(i2);
                } else {
                    tp3.e0(new b(this, W, i2));
                }
            }
        }
    }

    public final int E0(sn3 sn3Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, sn3Var)) == null) {
            HybridUbcFlow p = e53.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateInfoWithFinalCheckStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n) {
                p0("updateInfoWithFinalCheck: mAppInfo=" + this.m);
            }
            PMSAppInfo pMSAppInfo = this.m;
            if (pMSAppInfo == null) {
                if (sn3Var == null) {
                    sn3Var = new sn3();
                    sn3Var.k(10L);
                    sn3Var.i(2902L);
                    sn3Var.f("no pkg was installed");
                }
                wn3.a().f(sn3Var);
                A0(sn3Var);
                return -1;
            }
            int Z = Z(pMSAppInfo);
            if (sr3.g(sn3Var, Z)) {
                return -2;
            }
            if (Z != 10001 && Z != 10002) {
                G0();
                if (Z != 0) {
                    sn3 h0 = h0(10003);
                    wn3.a().f(h0);
                    z0(false, null, h0);
                    e53.k(h0);
                    gv2.p0().flush(false);
                    return -1;
                }
                if (!this.f) {
                    Set<ym4.a> i2 = g73.i(this.m);
                    if (i2 != null && !i2.isEmpty()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    this.f = z;
                    if (!z) {
                        sn3 sn3Var2 = new sn3();
                        sn3Var2.k(17L);
                        sn3Var2.i(2909L);
                        sn3Var2.f("dependent pkg is missing.");
                        wn3.a().f(sn3Var2);
                        A0(sn3Var2);
                        return -1;
                    }
                }
                mx2 T2 = mx2.T();
                String e0 = q().W().e0();
                if (!TextUtils.isEmpty(e0)) {
                    if (me3.b().a(z13.d(e0, T2.z()))) {
                        sn3 h02 = h0(10004);
                        wn3.a().f(h02);
                        z0(true, me3.b().d(), h02);
                        e53.k(h02);
                        gv2.p0().flush(false);
                        return -1;
                    }
                }
                return 1;
            }
            if (sn3Var == null) {
                sn3Var = h0(Z);
            }
            wn3.a().f(sn3Var);
            A0(sn3Var);
            return -1;
        }
        return invokeL.intValue;
    }

    public final boolean F0(sn3 sn3Var) {
        InterceptResult invokeL;
        String str;
        jk2 d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, sn3Var)) == null) {
            HybridUbcFlow p = e53.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateInstalledPkgWithFinalCheckStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (k0()) {
                return false;
            }
            int E0 = E0(sn3Var);
            if (E0 == -1) {
                z82.i("SwanPkgMaintainer", "updateInstalledPkgWithFinalCheck by null launchParams");
                t0(false);
                return false;
            } else if (E0 == -2) {
                s0();
                return false;
            } else {
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateInfoWithFinalCheckOk");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
                ww2.a W = this.j.W();
                SwanCoreVersion j0 = W.j0();
                if (j0 != null) {
                    str = j0.swanCoreVersionName;
                } else {
                    str = "0";
                }
                if (n) {
                    Log.d("SwanPkgMaintainer", "SwanCoreVersion target string version: " + W.k0() + " ,curSwanVersionName: " + str);
                }
                if (op3.a(W.k0(), str)) {
                    el3.n(W.G());
                }
                e53.p("startup").D("launch_type", String.valueOf(W.i("host_launch_type")));
                if (W.G() == 0) {
                    C0();
                }
                UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updateInstalledPkgWithFinalCheckEnd");
                ubcFlowEvent3.a(true);
                p.F(ubcFlowEvent3);
                t0(true);
                if (ProcessUtils.isMainProcess() && (d2 = lk2.c().d()) != null && d2.m()) {
                    d2.b(getAppId());
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void c0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, pMSAppInfo) == null) && pMSAppInfo != null) {
            dc3.a aVar = (dc3.a) ((dc3.a) new dc3.a("event_on_app_icon_update").z("mAppId", getAppId())).w("appFrameType", pMSAppInfo.appCategory);
            if (n) {
                p0("dispatchPmsInfo appCategory=" + pMSAppInfo.appCategory);
            }
            if (!TextUtils.isEmpty(pMSAppInfo.appName)) {
                if (n) {
                    p0("dispatchPmsInfo appName=" + pMSAppInfo.appName);
                }
                aVar.z("app_name", pMSAppInfo.appName);
            }
            if (pMSAppInfo.versionCode > -1) {
                if (n) {
                    p0("dispatchPmsInfo versionCode=" + pMSAppInfo.versionCode);
                }
                aVar.x(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_APP_VERSION_CODE, pMSAppInfo.versionCode);
            }
            if (!TextUtils.isEmpty(pMSAppInfo.iconUrl)) {
                if (n) {
                    p0("dispatchPmsInfo iconUrl=" + pMSAppInfo.iconUrl);
                }
                aVar.z("app_icon_url", pMSAppInfo.iconUrl);
            }
            aVar.w("app_pay_protected", pMSAppInfo.payProtected);
            aVar.t("event_flag_force_post", true);
            A(aVar);
        }
    }

    public final void K0() {
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            yb3.K().p("event_pms_check_start");
            HybridUbcFlow p = e53.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableStart");
            boolean z = true;
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            ww2 j0 = j0();
            if (n) {
                p0("预置包不可用");
            }
            boolean r0 = r0();
            if (n) {
                Log.i("SwanPkgMaintainer", "updatePkgOnPresetUnavailable: isNeedFetchPkg " + r0);
            }
            if (!r0) {
                if (!this.f) {
                    Set<ym4.a> set = this.g;
                    if (set == null || set.isEmpty()) {
                        this.g = g73.i(this.m);
                    }
                    Set<ym4.a> set2 = this.g;
                    if (set2 != null && !set2.isEmpty()) {
                        z = false;
                    }
                    this.f = z;
                    if (!z) {
                        g0(this.g);
                        this.g = null;
                        return;
                    }
                }
                if (n) {
                    p0("可以直接打开小程序，异步从Server拉取新包");
                }
                int i2 = 4;
                this.h = 4;
                o0(j0, this.m, false, false);
                if (this.i) {
                    i2 = 3;
                }
                this.h = i2;
                I0(null);
                b0("KEY_PKG_STATE", "event_pms_check_finish", this.h);
                return;
            }
            if (n) {
                p0("不能直接打开小程序，同步从Server拉取新包");
            }
            b0("KEY_PKG_STATE", "event_pms_check_finish", this.h);
            e0(this.j.W().H(), new f(this, j0));
            String appId = getAppId();
            bn4 bn4Var = new bn4(appId, j0.G());
            bn4Var.d("3");
            PMSAppInfo pMSAppInfo = this.m;
            long j3 = 0;
            if (pMSAppInfo == null) {
                j2 = 0;
            } else {
                j2 = pMSAppInfo.versionCode;
            }
            bn4Var.u(j2);
            PMSAppInfo pMSAppInfo2 = this.m;
            if (pMSAppInfo2 != null) {
                j3 = pMSAppInfo2.appSign;
            }
            bn4Var.o(j3);
            String f2 = rp3.f(j0.e0());
            if (!TextUtils.isEmpty(f2)) {
                if (f2.startsWith(File.separator)) {
                    f2 = f2.substring(1);
                }
                bn4Var.t(f2);
            }
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
            A((dc3.a) new dc3.a("event_on_still_maintaining").t(" event_params_pkg_update", this.l));
            uw2.b().g(appId);
            f0(bn4Var, false, null);
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updatePkgOnPresetUnavailableReturn");
            ubcFlowEvent3.a(true);
            p.F(ubcFlowEvent3);
        }
    }

    public final void L0() {
        long j2;
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            HybridUbcFlow p = e53.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheckStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n) {
                if (this.m == null) {
                    str = "数据库或本地无主包信息，尝试加载预置包，并下载主包";
                } else {
                    str = "包信息、文件都存在，尝试加载更高版本的预置包";
                }
                p0(str);
            }
            vh2 c2 = yh2.b().c(getAppId());
            PMSAppInfo pMSAppInfo = this.m;
            long j3 = -1;
            if (pMSAppInfo == null) {
                j2 = -1;
            } else {
                j2 = pMSAppInfo.versionCode;
            }
            if (c2 != null) {
                j3 = c2.i;
            }
            if (j3 > j2) {
                z = true;
            } else {
                z = false;
            }
            if (n) {
                p0(String.format(Locale.getDefault(), "尝试加载预制包，命中预制包=%b  currentVersion/presetVersion = %d/%d", Boolean.valueOf(z), Long.valueOf(j2), Long.valueOf(j3)));
            }
            if (!z) {
                K0();
                return;
            }
            p("event_on_still_maintaining");
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheckLoadPresetApp");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
            yh2.b().e(c2, new e(this));
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updatePkgWithPresetCheckReturn");
            ubcFlowEvent3.a(true);
            p.F(ubcFlowEvent3);
        }
    }

    public final boolean a0(@NonNull bn4 bn4Var, sn3 sn3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, bn4Var, sn3Var)) == null) {
            String appId = getAppId();
            if (sn3Var != null && SwanAppNetworkUtils.i(gv2.c()) && uw2.b().f(appId)) {
                z82.k("SwanPkgMaintainer", "checkGetPkgResult appId=" + appId + " errCode=" + sn3Var.a());
                if (sn3Var.h() == 2101) {
                    uw2.b().a(appId);
                    e53.p("startup").F(new UbcFlowEvent("pkg_download_retry"));
                    f0(bn4Var, true, sn3Var);
                    return true;
                } else if (sn3Var.h() == 2205) {
                    lk2.c().d().u(dq3.a(appId), true, 12);
                    uw2.b().a(appId);
                    e53.p("startup").F(new UbcFlowEvent("pkg_download_retry"));
                    f0(bn4Var, true, sn3Var);
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final synchronized void d0() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            synchronized (this) {
                this.h = 99;
                b0("KEY_PKG_STATE", "event_pms_check_start", 99);
                ww2.a W = this.j.W();
                if (!y73.H() && TextUtils.isEmpty(W.g0()) && ((!n || !W.n0()) && !W.p0())) {
                    String V = W.V();
                    this.k = V;
                    if (n) {
                        ex2.d(V).f("start");
                    }
                    eu2.d("1");
                    HybridUbcFlow p = e53.p("startup");
                    p.E("type", "1");
                    p.D("is_updating", String.valueOf(qa2.a().b()));
                    p.F(new UbcFlowEvent("na_query_db_start"));
                    PMSAppInfo f0 = this.j.W().f0();
                    if (f0 == null || f0.isMaxAgeExpires()) {
                        f0 = wj4.i().u(getAppId());
                    }
                    p.F(new UbcFlowEvent("na_query_db"));
                    boolean e2 = gx2.e(f0);
                    this.l = e2;
                    if (f0 != null && !e2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.e = z;
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("has_local_file");
                    ubcFlowEvent.a(true);
                    p.F(ubcFlowEvent);
                    if (this.l) {
                        N0(f0, p);
                    }
                    if (!this.l && gx2.f(f0, W.e0())) {
                        N0(f0, p);
                        D0();
                    } else {
                        L0();
                    }
                    return;
                }
                t0(true);
            }
        }
    }

    public final boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            HybridUbcFlow p = e53.p("startup");
            PMSAppInfo pMSAppInfo = this.m;
            if (pMSAppInfo == null) {
                if (n) {
                    Log.i("SwanPkgMaintainer", "AppInfo 为空，走Server同步下载");
                }
                p.D("launch_state", String.valueOf(0));
                b0("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 0);
                return true;
            } else if (pMSAppInfo.appStatus != 0) {
                if (n) {
                    Log.i("SwanPkgMaintainer", "有错误code，走Server同步下载");
                }
                this.e = true;
                p.D("launch_state", String.valueOf(2));
                b0("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
                return true;
            } else if (pMSAppInfo.hasPendingErrCode()) {
                if (n) {
                    Log.i("SwanPkgMaintainer", "有悬而未决的的errCode要处理，走Server同步下载");
                }
                this.e = true;
                p.D("launch_state", String.valueOf(2));
                b0("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 2);
                return true;
            } else if (this.m.isMaxAgeExpires()) {
                if (qa2.a().c(getAppId())) {
                    if (n) {
                        Log.i("SwanPkgMaintainer", "MaxAge已过期，但5小时内已通过SilentUpdateManager检测无新包，id =" + getAppId());
                    }
                    p.D("launch_state", String.valueOf(3));
                    b0("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 3);
                    return false;
                }
                if (n) {
                    Log.i("SwanPkgMaintainer", "本地包已过期");
                }
                b0("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 1);
                p.D("launch_state", String.valueOf(1));
                this.i = true;
                return true;
            } else {
                p.D("launch_state", String.valueOf(4));
                b0("KEY_PMS_UPDATE_TYPE", "event_pms_check_start", 4);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public final void e0(@NonNull String str, @NonNull f83 f83Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, str, f83Var) == null) {
            u83 Q = u83.Q();
            if (Q == null) {
                c83 c83Var = new c83(f83Var.b());
                Bundle bundle = new Bundle();
                bundle.putBoolean("isDownloading", false);
                c83Var.setResult(bundle);
                f83Var.onEvent(c83Var);
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
            Q.X(bundle2, l.class, f83Var);
        }
    }

    public final void f0(@NonNull bn4 bn4Var, boolean z, @Nullable sn3 sn3Var) {
        long j2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{bn4Var, Boolean.valueOf(z), sn3Var}) == null) {
            HybridUbcFlow p = e53.p("startup");
            if (z) {
                j2 = 1;
            } else {
                j2 = 0;
            }
            bn4Var.v(j2);
            j jVar = new j(this, this.j, z);
            jVar.e0(new i(this, p));
            jVar.g0(new h(this, z, bn4Var, p));
            if (this.i) {
                i2 = 2;
            } else {
                i2 = 1;
            }
            jVar.L(i2);
            if (z && sn3Var != null) {
                bn4Var.p(sn3Var.h());
            }
            jj4.c(bn4Var, jVar);
        }
    }

    public synchronized void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            synchronized (this) {
                if (SwanAppProcessInfo.current().isSwanAppProcess() && this.j.c && !l0() && !m0()) {
                    boolean z = true;
                    this.b = true;
                    HybridUbcFlow p = e53.p("startup");
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("maintain_start");
                    ubcFlowEvent.a(true);
                    p.F(ubcFlowEvent);
                    if (1 != this.j.W().G()) {
                        z = false;
                    }
                    if (z || !ti2.U().m0()) {
                        p("event_on_still_maintaining");
                    }
                    if (z) {
                        x0();
                    } else {
                        d0();
                    }
                }
            }
        }
    }

    public final synchronized void t0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            synchronized (this) {
                this.b = false;
                this.d = z;
                this.m = null;
                if (mb2.b.a()) {
                    this.j.J0(true);
                }
                if (n) {
                    p0("notifyMaintainFinish: " + z);
                }
                if (q() == yb3.K().q()) {
                    A((dc3.a) new dc3.a("event_on_pkg_maintain_finish").z("mAppId", this.j.b));
                }
                if (n) {
                    ex2.d(this.k).h();
                }
                this.k = "";
            }
        }
    }

    public final synchronized void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            synchronized (this) {
                HybridUbcFlow p = e53.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("postExec-onhold");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                yb3.M().post(new c(this, p));
            }
        }
    }

    public final void z0(boolean z, String str, sn3 sn3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048611, this, new Object[]{Boolean.valueOf(z), str, sn3Var}) != null) || this.m == null) {
            return;
        }
        y0(this.m, getContext(), j0(), z, str, sn3Var);
    }
}
