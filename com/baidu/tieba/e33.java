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
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.c33;
import com.baidu.tieba.l22;
import com.baidu.tieba.vn2;
import com.baidu.tieba.xd4;
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
/* loaded from: classes3.dex */
public final class e33 extends g33 implements sc2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean n;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public Set<xd4.a> g;
    public int h;
    public boolean i;
    public final y23 j;
    public String k;
    public boolean l;
    public PMSAppInfo m;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(e33 e33Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e33Var};
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
                x23.K().n("flag_finish_activity", "flag_remove_task");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vn2 a;
        public final /* synthetic */ int b;

        public b(e33 e33Var, vn2 vn2Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e33Var, vn2Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = vn2Var;
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

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HybridUbcFlow a;
        public final /* synthetic */ e33 b;

        public c(e33 e33Var, HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e33Var, hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = e33Var;
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

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bundle a;
        public final /* synthetic */ e33 b;

        public d(e33 e33Var, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e33Var, bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = e33Var;
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
                if (e33.n) {
                    e33.p0("updateLocalPkgWithAsyncUpdatePkg: swanAsyncUpdate -> 发送异步升级消息");
                }
                oz2 e = oz2.e();
                qz2 qz2Var = new qz2(17, bundle);
                qz2Var.j(5000L);
                e.h(qz2Var);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements v82 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e33 a;

        public e(e33 e33Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e33Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e33Var;
        }

        @Override // com.baidu.tieba.v82
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pMSAppInfo) == null) {
                HybridUbcFlow p = dw2.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheckUpdate");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                this.a.c0(pMSAppInfo);
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheckUpdateIcon");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
            }
        }

        @Override // com.baidu.tieba.v82
        public void b(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) == null) {
                this.a.h = 5;
                e33 e33Var = this.a;
                e33Var.b0("KEY_PKG_STATE", "event_pms_check_finish", e33Var.h);
                HybridUbcFlow p = dw2.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessStart");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                if (e33.n) {
                    e33.p0("预制包安装成功");
                }
                e33.o0(this.a.j0(), pMSAppInfo, false, false);
                this.a.M0(pMSAppInfo);
                this.a.I0(null);
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheck#OnSuccessEnd");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
            }
        }

        @Override // com.baidu.tieba.v82
        public void onFailed(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
                HybridUbcFlow p = dw2.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheck#OnFailedStart");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                if (e33.n) {
                    e33.p0("预制包安装失败");
                }
                this.a.K0();
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgWithPresetCheck#OnonFailedEnd");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f extends ez2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ vn2 c;
        public final /* synthetic */ e33 d;

        public f(e33 e33Var, vn2 vn2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e33Var, vn2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = e33Var;
            this.c = vn2Var;
        }

        @Override // com.baidu.tieba.ez2, com.baidu.tieba.dz2
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 1000L;
            }
            return invokeV.longValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ez2, com.baidu.tieba.fz2, com.baidu.tieba.dz2
        public void onEvent(@NonNull bz2 bz2Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bz2Var) == null) {
                Bundle a = bz2Var.a();
                e33.o0(this.c, this.d.m, true, a != null ? a.getBoolean("isDownloading", false) : false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends w52 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e33 h;

        public g(e33 e33Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e33Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = e33Var;
        }

        @Override // com.baidu.tieba.w52, com.baidu.tieba.ta4
        public void G(gg4 gg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gg4Var) == null) {
                this.h.c = true;
                x23.K().p("event_pkg_download_start");
                super.G(gg4Var);
            }
        }

        @Override // com.baidu.tieba.w52
        public void Q(@NonNull re3 re3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, re3Var) == null) {
                ve3.a().f(re3Var);
                this.h.A0(re3Var);
                this.h.t0(false);
            }
        }

        @Override // com.baidu.tieba.w52
        public void R() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.h.c = false;
                e33.o0(this.h.j0(), this.h.m, false, false);
                e33 e33Var = this.h;
                e33Var.h = e33Var.i ? 3 : 4;
                this.h.I0(null);
                e33 e33Var2 = this.h;
                e33Var2.b0("KEY_PKG_STATE", "event_pms_check_finish", e33Var2.h);
            }
        }

        @Override // com.baidu.tieba.w52, com.baidu.tieba.ta4, com.baidu.tieba.qa4
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.h.c = false;
                x23.K().p("event_pkg_download_finish");
                super.b();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements h62 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ ae4 b;
        public final /* synthetic */ HybridUbcFlow c;
        public final /* synthetic */ e33 d;

        public h(e33 e33Var, boolean z, ae4 ae4Var, HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e33Var, Boolean.valueOf(z), ae4Var, hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = e33Var;
            this.a = z;
            this.b = ae4Var;
            this.c = hybridUbcFlow;
        }

        @Override // com.baidu.tieba.h62
        public void a(re3 re3Var, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, re3Var, z) == null) {
                long a = re3Var == null ? 0L : re3Var.a();
                yz1.k("SwanPkgMaintainer", "mFlagDownloading reset onFinalFailed isRetry = " + this.a + ",code =" + a);
                if (this.a) {
                    r93.L("pkg_retry_fail", String.valueOf(a));
                }
                if (this.d.a0(this.b, re3Var)) {
                    return;
                }
                this.d.c = false;
                x23.K().p("event_pkg_download_finish");
                HybridUbcFlow hybridUbcFlow = this.c;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedStart");
                ubcFlowEvent.a(true);
                hybridUbcFlow.F(ubcFlowEvent);
                ve3.a().f(re3Var);
                if (z) {
                    e33 e33Var = this.d;
                    e33Var.h = e33Var.i ? 3 : 4;
                    e33 e33Var2 = this.d;
                    e33Var2.b0("KEY_PKG_STATE", "event_pms_check_finish", e33Var2.h);
                    this.d.H0(re3Var);
                } else if (re3Var != null && re3Var.h() == 1020) {
                    this.d.A0(re3Var);
                }
                HybridUbcFlow hybridUbcFlow2 = this.c;
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onFinalFailedEnd");
                ubcFlowEvent2.a(true);
                hybridUbcFlow2.F(ubcFlowEvent2);
                if (re3Var == null || re3Var.h() != 2203) {
                    return;
                }
                yz1.k("SwanPkgMaintainer", "recoverPlatform for errorCode 2203");
                if (wb2.a().b(1) == 0) {
                    wb2.a().c();
                }
            }
        }

        @Override // com.baidu.tieba.h62
        public void b(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) == null) {
                yz1.k("SwanPkgMaintainer", "mFlagDownloading reset onFinalComplete isRetry = " + this.a);
                if (this.a) {
                    r93.L("pkg_retry_success", "");
                }
                this.d.c = false;
                e33 e33Var = this.d;
                e33Var.h = e33Var.e ? 2 : 0;
                e33 e33Var2 = this.d;
                e33Var2.h = e33Var2.i ? 1 : this.d.h;
                e33 e33Var3 = this.d;
                e33Var3.b0("KEY_PKG_STATE", "event_pms_check_finish", e33Var3.h);
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

    /* loaded from: classes3.dex */
    public class i implements rh3<PMSAppInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HybridUbcFlow a;
        public final /* synthetic */ e33 b;

        public i(e33 e33Var, HybridUbcFlow hybridUbcFlow) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e33Var, hybridUbcFlow};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = e33Var;
            this.a = hybridUbcFlow;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.rh3
        /* renamed from: b */
        public void a(PMSAppInfo pMSAppInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pMSAppInfo) == null) {
                HybridUbcFlow hybridUbcFlow = this.a;
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest#onAppInfoReceivedStart");
                ubcFlowEvent.a(true);
                hybridUbcFlow.F(ubcFlowEvent);
                if (e33.n) {
                    e33.p0("onAppInfoReceived appInfo=" + pMSAppInfo);
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

    /* loaded from: classes3.dex */
    public class j extends z52 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean G;
        public final /* synthetic */ e33 H;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(e33 e33Var, y23 y23Var, boolean z) {
            super(y23Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e33Var, y23Var, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((y23) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.H = e33Var;
            this.G = z;
        }

        @Override // com.baidu.tieba.z52, com.baidu.tieba.y52, com.baidu.tieba.ta4
        public void G(gg4 gg4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, gg4Var) == null) {
                yz1.k("SwanPkgMaintainer", "mFlagDownloading set onPrepareDownload isRetry = " + this.G);
                this.H.c = true;
                x23.K().p("event_pkg_download_start");
                super.G(gg4Var);
            }
        }

        @Override // com.baidu.tieba.ta4, com.baidu.tieba.qa4
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                yz1.k("SwanPkgMaintainer", "mFlagDownloading reset onTotalPkgDownloadFinish isRetry = " + this.G);
                this.H.c = false;
                x23.K().p("event_pkg_download_finish");
                super.b();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ba3 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public k(ba3 ba3Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ba3Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ba3Var;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e33.n0(this.a, this.b, this.c);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class l extends yy2 {
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

        @Override // com.baidu.tieba.yy2
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
                boolean j = ia4.j(string);
                boolean k = ia4.k(string);
                if (yy2.e) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947683364, "Lcom/baidu/tieba/e33;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947683364, "Lcom/baidu/tieba/e33;");
                return;
            }
        }
        n = ij1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e33(y23 y23Var) {
        super(y23Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {y23Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((b33) newInitContext.callArgs[0]);
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
        this.j = y23Var;
    }

    private Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            SwanAppActivity w = this.j.w();
            return (w == null || w.isDestroyed()) ? fm2.c() : w;
        }
        return (Context) invokeV.objValue;
    }

    public static String i0(Context context, re3 re3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65556, null, context, re3Var)) == null) ? String.format(context.getResources().getString(R.string.obfuscated_res_0x7f0f01a5), sg3.D(), dc3.i(lo2.U().M(), x23.K().q().k()), String.valueOf(re3Var.a())) : (String) invokeLL.objValue;
    }

    public static void n0(ba3 ba3Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65557, null, ba3Var, str, str2) == null) {
            JSONObject k2 = r93.k(str);
            ba3Var.d(str2);
            ba3Var.b(k2);
            r93.onEvent(ba3Var);
        }
    }

    public static void o0(yn2 yn2Var, PMSAppInfo pMSAppInfo, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65558, null, new Object[]{yn2Var, pMSAppInfo, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (n) {
                Log.d("SwanPkgMaintainer", "SwanPkgMaintainer#launchStatistic");
            }
            yn2Var.s0().putString("aiapp_extra_need_download", z ? "1" : "0");
            yn2Var.s0().putString("aiapp_extra_pkg_downloading", z2 ? "1" : "0");
            ba3 ba3Var = new ba3();
            ba3Var.a = r93.n(yn2Var.G());
            ba3Var.h(yn2Var);
            ba3Var.b = "launch";
            ba3Var.o = z ? "1" : "0";
            if (pMSAppInfo != null) {
                ba3Var.l = String.valueOf(pMSAppInfo.versionCode);
            }
            rw2.e().d(new k(ba3Var, yn2Var.W(), yn2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY)), "launchStatistic", true);
        }
    }

    public static void p0(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65559, null, str) == null) && n) {
            Log.i("SwanPkgMaintainer", str);
        }
    }

    public static void y0(PMSAppInfo pMSAppInfo, Context context, vn2 vn2Var, boolean z, String str, re3 re3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65560, null, new Object[]{pMSAppInfo, context, vn2Var, Boolean.valueOf(z), str, re3Var}) == null) || pMSAppInfo == null) {
            return;
        }
        ForbiddenInfo forbiddenInfo = new ForbiddenInfo(vn2Var, str, i0(context, re3Var));
        forbiddenInfo.enableSlidingFlag = -1;
        sn2.l(context, z ? "type_path_forbidden" : "type_app_forbidden", re3Var, forbiddenInfo, vn2Var.D());
        ba3 ba3Var = new ba3();
        ba3Var.a = r93.n(vn2Var.G());
        ba3Var.b = "launch";
        ba3Var.e = "success";
        ba3Var.i(vn2Var);
        ba3Var.a("status", "2");
        ba3Var.d(vn2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY));
        r93.onEvent(ba3Var);
    }

    public final void A0(re3 re3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, re3Var) == null) {
            dw2.k(re3Var);
            Context context = getContext();
            if ((context instanceof SwanAppActivity) && !hf3.d((SwanAppActivity) context)) {
                if (n) {
                    Log.d("SwanPkgMaintainer", "launcher activity closed, ignore launch err");
                    return;
                }
                return;
            }
            vn2 j0 = j0();
            int G = j0.G();
            if (!re3Var.l()) {
                z93 z93Var = new z93();
                z93Var.q(r93.n(G));
                z93Var.p(re3Var);
                z93Var.m(getAppId());
                z93Var.t(j0.T());
                r93.R(z93Var);
                re3Var.n();
            }
            if (!mo2.a().b()) {
                if (n) {
                    Log.d("SwanPkgMaintainer", "launcher activity hide, ignore launch err and reset.");
                }
                sg3.e0(new a(this));
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("mAppId", j0.H());
            bundle.putAll(j0.D());
            sn2.g(fm2.c(), re3Var, G, getAppId(), true, bundle);
            i93.m(j0, G, re3Var);
            fm2.p0().flush(false);
        }
    }

    public boolean B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.c : invokeV.booleanValue;
    }

    public final void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ul2.O(this.j);
        }
    }

    public final void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            HybridUbcFlow p = dw2.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateForIndependentPkgStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n) {
                p0("独立分包启动，本地有包--->打开小程序，异步更新主包");
            }
            vn2 j0 = j0();
            String c2 = fo2.c(this.m, j0.e0());
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

    public final int E0(re3 re3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, re3Var)) == null) {
            HybridUbcFlow p = dw2.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateInfoWithFinalCheckStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n) {
                p0("updateInfoWithFinalCheck: mAppInfo=" + this.m);
            }
            PMSAppInfo pMSAppInfo = this.m;
            if (pMSAppInfo == null) {
                if (re3Var == null) {
                    re3Var = new re3();
                    re3Var.k(10L);
                    re3Var.i(2902L);
                    re3Var.f("no pkg was installed");
                }
                ve3.a().f(re3Var);
                A0(re3Var);
                return -1;
            }
            int Z = Z(pMSAppInfo);
            if (ri3.g(re3Var, Z)) {
                return -2;
            }
            if (Z != 10001 && Z != 10002) {
                G0();
                if (Z != 0) {
                    re3 h0 = h0(10003);
                    ve3.a().f(h0);
                    z0(false, null, h0);
                    dw2.k(h0);
                    fm2.p0().flush(false);
                    return -1;
                }
                if (!this.f) {
                    Set<xd4.a> i2 = fy2.i(this.m);
                    boolean z = i2 == null || i2.isEmpty();
                    this.f = z;
                    if (!z) {
                        re3 re3Var2 = new re3();
                        re3Var2.k(17L);
                        re3Var2.i(2909L);
                        re3Var2.f("dependent pkg is missing.");
                        ve3.a().f(re3Var2);
                        A0(re3Var2);
                        return -1;
                    }
                }
                lo2 U = lo2.U();
                String e0 = q().W().e0();
                if (!TextUtils.isEmpty(e0)) {
                    if (l53.b().a(ys2.d(e0, U.z()))) {
                        re3 h02 = h0(10004);
                        ve3.a().f(h02);
                        z0(true, l53.b().d(), h02);
                        dw2.k(h02);
                        fm2.p0().flush(false);
                        return -1;
                    }
                }
                return 1;
            }
            if (re3Var == null) {
                re3Var = h0(Z);
            }
            ve3.a().f(re3Var);
            A0(re3Var);
            return -1;
        }
        return invokeL.intValue;
    }

    public final boolean F0(re3 re3Var) {
        InterceptResult invokeL;
        ib2 d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, re3Var)) == null) {
            HybridUbcFlow p = dw2.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateInstalledPkgWithFinalCheckStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (k0()) {
                return false;
            }
            int E0 = E0(re3Var);
            if (E0 == -1) {
                yz1.i("SwanPkgMaintainer", "updateInstalledPkgWithFinalCheck by null launchParams");
                t0(false);
                return false;
            } else if (E0 == -2) {
                s0();
                return false;
            } else {
                UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateInfoWithFinalCheckOk");
                ubcFlowEvent2.a(true);
                p.F(ubcFlowEvent2);
                vn2.a W = this.j.W();
                SwanCoreVersion j0 = W.j0();
                String str = j0 != null ? j0.swanCoreVersionName : "0";
                if (n) {
                    Log.d("SwanPkgMaintainer", "SwanCoreVersion target string version: " + W.k0() + " ,curSwanVersionName: " + str);
                }
                if (ng3.a(W.k0(), str)) {
                    dc3.n(W.G());
                }
                dw2.p("startup").D("launch_type", String.valueOf(W.i("host_launch_type")));
                if (W.G() == 0) {
                    C0();
                }
                UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updateInstalledPkgWithFinalCheckEnd");
                ubcFlowEvent3.a(true);
                p.F(ubcFlowEvent3);
                t0(true);
                if (ProcessUtils.isMainProcess() && (d2 = kb2.c().d()) != null && d2.m()) {
                    d2.b(getAppId());
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public final void G0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            vn2.a W = q().W();
            PMSAppInfo pMSAppInfo = this.m;
            boolean z = (pMSAppInfo == null || TextUtils.isEmpty(pMSAppInfo.appId) || !TextUtils.equals(getAppId(), this.m.appId)) ? false : true;
            if (z) {
                W.S0(this.m);
            }
            PMSAppInfo pMSAppInfo2 = this.m;
            if (pMSAppInfo2 != null) {
                int i2 = (z && pMSAppInfo2.appCategory == 1) ? 1 : 0;
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    W.u0(i2);
                } else {
                    sg3.e0(new b(this, W, i2));
                }
            }
        }
    }

    public final void H0(re3 re3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, re3Var) == null) && F0(re3Var)) {
            z93 z93Var = new z93();
            z93Var.p(re3Var);
            z93Var.r(j0());
            r93.R(z93Var);
        }
    }

    public final void I0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            HybridUbcFlow p = dw2.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n) {
                p0("启动本地包，进程预处理-加载本地包-后台异步更新");
            }
            F0(null);
            qw2.j().i(new d(this, bundle));
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updateLocalPkgWithAsyncUpdatePkgEnd");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
        }
    }

    public void J0(Set<xd4.a> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, set) == null) {
            this.g = set;
            if (set == null || set.isEmpty()) {
                this.f = true;
            }
        }
    }

    public final void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            x23.K().p("event_pms_check_start");
            HybridUbcFlow p = dw2.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgOnPresetUnavailableStart");
            boolean z = true;
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            vn2 j0 = j0();
            if (n) {
                p0("预置包不可用");
            }
            boolean r0 = r0();
            if (n) {
                Log.i("SwanPkgMaintainer", "updatePkgOnPresetUnavailable: isNeedFetchPkg " + r0);
            }
            if (!r0) {
                if (!this.f) {
                    Set<xd4.a> set = this.g;
                    if (set == null || set.isEmpty()) {
                        this.g = fy2.i(this.m);
                    }
                    Set<xd4.a> set2 = this.g;
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
                this.h = 4;
                o0(j0, this.m, false, false);
                this.h = this.i ? 3 : 4;
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
            ae4 ae4Var = new ae4(appId, j0.G());
            ae4Var.d("3");
            PMSAppInfo pMSAppInfo = this.m;
            ae4Var.u(pMSAppInfo == null ? 0L : pMSAppInfo.versionCode);
            PMSAppInfo pMSAppInfo2 = this.m;
            ae4Var.o(pMSAppInfo2 != null ? pMSAppInfo2.appSign : 0L);
            String f2 = qg3.f(j0.e0());
            if (!TextUtils.isEmpty(f2)) {
                if (f2.startsWith(File.separator)) {
                    f2 = f2.substring(1);
                }
                ae4Var.t(f2);
            }
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("updatePkgOnPresetUnavailableRequest");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
            A((c33.a) new c33.a("event_on_still_maintaining").t(" event_params_pkg_update", this.l));
            tn2.b().g(appId);
            f0(ae4Var, false, null);
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updatePkgOnPresetUnavailableReturn");
            ubcFlowEvent3.a(true);
            p.F(ubcFlowEvent3);
        }
    }

    public final void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            HybridUbcFlow p = dw2.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("updatePkgWithPresetCheckStart");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (n) {
                p0(this.m == null ? "数据库或本地无主包信息，尝试加载预置包，并下载主包" : "包信息、文件都存在，尝试加载更高版本的预置包");
            }
            u82 c2 = x82.b().c(getAppId());
            PMSAppInfo pMSAppInfo = this.m;
            long j2 = pMSAppInfo == null ? -1L : pMSAppInfo.versionCode;
            long j3 = c2 != null ? c2.i : -1L;
            boolean z = j3 > j2;
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
            x82.b().e(c2, new e(this));
            UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("updatePkgWithPresetCheckReturn");
            ubcFlowEvent3.a(true);
            p.F(ubcFlowEvent3);
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

    public final void N0(PMSAppInfo pMSAppInfo, HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048589, this, pMSAppInfo, hybridUbcFlow) == null) || pMSAppInfo == null || hybridUbcFlow == null) {
            return;
        }
        M0(pMSAppInfo);
        c0(this.m);
        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("update_icon");
        ubcFlowEvent.a(true);
        hybridUbcFlow.F(ubcFlowEvent);
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
            return (i3 > -1 || G == i3) ? 0 : 10002;
        }
        return invokeL.intValue;
    }

    public final boolean a0(@NonNull ae4 ae4Var, re3 re3Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, ae4Var, re3Var)) == null) {
            String appId = getAppId();
            if (re3Var != null && SwanAppNetworkUtils.i(fm2.c()) && tn2.b().f(appId)) {
                yz1.k("SwanPkgMaintainer", "checkGetPkgResult appId=" + appId + " errCode=" + re3Var.a());
                if (re3Var.h() == 2101) {
                    tn2.b().a(appId);
                    dw2.p("startup").F(new UbcFlowEvent("pkg_download_retry"));
                    f0(ae4Var, true, re3Var);
                    return true;
                } else if (re3Var.h() == 2205) {
                    kb2.c().d().u(ch3.a(appId), true, 12);
                    tn2.b().a(appId);
                    dw2.p("startup").F(new UbcFlowEvent("pkg_download_retry"));
                    f0(ae4Var, true, re3Var);
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void b0(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048592, this, str, str2, i2) == null) {
            Bundle bundle = new Bundle();
            bundle.putInt(str, i2);
            x23.K().v(str2, bundle);
        }
    }

    public final void c0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, pMSAppInfo) == null) || pMSAppInfo == null) {
            return;
        }
        c33.a aVar = (c33.a) ((c33.a) new c33.a("event_on_app_icon_update").z("mAppId", getAppId())).w("appFrameType", pMSAppInfo.appCategory);
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

    public final synchronized void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            synchronized (this) {
                this.h = 99;
                b0("KEY_PKG_STATE", "event_pms_check_start", 99);
                vn2.a W = this.j.W();
                if (!xy2.H() && TextUtils.isEmpty(W.g0()) && ((!n || !W.n0()) && !W.p0())) {
                    String V = W.V();
                    this.k = V;
                    if (n) {
                        do2.d(V).f("start");
                    }
                    dl2.d("1");
                    HybridUbcFlow p = dw2.p("startup");
                    p.E("type", "1");
                    p.D("is_updating", String.valueOf(p12.a().b()));
                    p.F(new UbcFlowEvent("na_query_db_start"));
                    PMSAppInfo f0 = this.j.W().f0();
                    if (f0 == null || f0.isMaxAgeExpires()) {
                        f0 = va4.i().u(getAppId());
                    }
                    p.F(new UbcFlowEvent("na_query_db"));
                    boolean e2 = fo2.e(f0);
                    this.l = e2;
                    this.e = (f0 == null || e2) ? false : true;
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("has_local_file");
                    ubcFlowEvent.a(true);
                    p.F(ubcFlowEvent);
                    if (this.l) {
                        N0(f0, p);
                    }
                    if (!this.l && fo2.f(f0, W.e0())) {
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

    public final void e0(@NonNull String str, @NonNull ez2 ez2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, str, ez2Var) == null) {
            tz2 Q = tz2.Q();
            if (Q == null) {
                bz2 bz2Var = new bz2(ez2Var.b());
                Bundle bundle = new Bundle();
                bundle.putBoolean("isDownloading", false);
                bz2Var.setResult(bundle);
                ez2Var.onEvent(bz2Var);
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, str);
            Q.X(bundle2, l.class, ez2Var);
        }
    }

    public final void f0(@NonNull ae4 ae4Var, boolean z, @Nullable re3 re3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{ae4Var, Boolean.valueOf(z), re3Var}) == null) {
            HybridUbcFlow p = dw2.p("startup");
            ae4Var.v(z ? 1L : 0L);
            j jVar = new j(this, this.j, z);
            jVar.e0(new i(this, p));
            jVar.g0(new h(this, z, ae4Var, p));
            jVar.L(this.i ? 2 : 1);
            if (z && re3Var != null) {
                ae4Var.p(re3Var.h());
            }
            ia4.c(ae4Var, jVar);
        }
    }

    public final void g0(Set<xd4.a> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, set) == null) {
            xd4 xd4Var = new xd4(set);
            xd4Var.d("3");
            g gVar = new g(this);
            gVar.L(this.i ? 2 : 1);
            ia4.d(xd4Var, gVar);
        }
    }

    public final re3 h0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
            re3 re3Var = new re3();
            switch (i2) {
                case 10001:
                    re3Var.k(10L);
                    re3Var.i(2902L);
                    re3Var.f("no aiapps info in database");
                    break;
                case 10002:
                    re3Var.k(10L);
                    re3Var.i(27L);
                    re3Var.f("category not match");
                    break;
                case 10003:
                    re3Var.k(10L);
                    re3Var.i(2107L);
                    re3Var.d("app forbiddeon");
                    break;
                case 10004:
                    re3Var.k(10L);
                    re3Var.i(48L);
                    re3Var.d("path forbiddeon");
                    break;
            }
            return re3Var;
        }
        return (re3) invokeI.objValue;
    }

    public vn2 j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.j.W() : (vn2) invokeV.objValue;
    }

    public final boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? x23.K().q().W().d("property_web_mode_degrade") : invokeV.booleanValue;
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

    public synchronized void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            synchronized (this) {
                if (SwanAppProcessInfo.current().isSwanAppProcess() && this.j.c && !l0() && !m0()) {
                    boolean z = true;
                    this.b = true;
                    HybridUbcFlow p = dw2.p("startup");
                    UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("maintain_start");
                    ubcFlowEvent.a(true);
                    p.F(ubcFlowEvent);
                    if (1 != this.j.W().G()) {
                        z = false;
                    }
                    if (z || !s92.U().m0()) {
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

    public final boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            HybridUbcFlow p = dw2.p("startup");
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
                if (p12.a().c(getAppId())) {
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

    public synchronized void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            synchronized (this) {
                v0(true, null);
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
                if (l22.b.a()) {
                    this.j.J0(true);
                }
                if (n) {
                    p0("notifyMaintainFinish: " + z);
                }
                if (q() == x23.K().q()) {
                    A((c33.a) new c33.a("event_on_pkg_maintain_finish").z("mAppId", this.j.b));
                }
                if (n) {
                    do2.d(this.k).h();
                }
                this.k = "";
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

    public synchronized void v0(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048608, this, z, str) == null) {
            synchronized (this) {
                this.b = false;
                this.d = true;
                this.m = null;
                if (this.j != null) {
                    this.j.J0(true);
                    yz1.i("SwanPkgMaintainer", "swan/web, notifyWebModeStart: true");
                    c33.a aVar = (c33.a) new c33.a("event_on_web_mode_launched").z("mAppId", this.j.b);
                    if (!TextUtils.isEmpty(str)) {
                        aVar.z("property_launch_url", str);
                    }
                    A(aVar);
                    r93.V(z, str);
                }
                if (n) {
                    do2.d(this.k).h();
                }
                this.k = "";
            }
        }
    }

    public int w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.h : invokeV.intValue;
    }

    public final synchronized void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            synchronized (this) {
                HybridUbcFlow p = dw2.p("startup");
                UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("postExec-onhold");
                ubcFlowEvent.a(true);
                p.F(ubcFlowEvent);
                x23.M().post(new c(this, p));
            }
        }
    }

    public final void z0(boolean z, String str, re3 re3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{Boolean.valueOf(z), str, re3Var}) == null) || this.m == null) {
            return;
        }
        y0(this.m, getContext(), j0(), z, str, re3Var);
    }
}
