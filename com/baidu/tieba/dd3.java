package com.baidu.tieba;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.log.Logger;
import com.baidu.tbadk.core.util.GameCenterCoreUtils;
import com.baidu.tieba.gd3;
import com.baidu.tieba.hr2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Sets;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class dd3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final ExecutorService b;
    public static Object c;
    public static final Set<String> d;
    public static final CopyOnWriteArrayList<String> e;
    public transient /* synthetic */ FieldHolder $fh;

    public static String n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65577, null, i2)) == null) ? i2 != 1 ? "swan" : SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME : (String) invokeI.objValue;
    }

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ md3 a;

        public a(md3 md3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {md3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = md3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b(dd3.a());
                rc3.k("778", this.a.f());
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ long b;
        public final /* synthetic */ long c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;
        public final /* synthetic */ NetworkStatRecord k;

        public b(String str, long j, long j2, int i, int i2, String str2, String str3, String str4, String str5, String str6, NetworkStatRecord networkStatRecord) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r3;
                Object[] objArr = {str, Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(i2), str2, str3, str4, str5, str6, networkStatRecord};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = j;
            this.c = j2;
            this.d = i;
            this.e = i2;
            this.f = str2;
            this.g = str3;
            this.h = str4;
            this.i = str5;
            this.j = str6;
            this.k = networkStatRecord;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || !SwanAppNetworkUtils.i(null)) {
                return;
            }
            if (dd3.o(this.a)) {
                if (dd3.a) {
                    Log.d("SwanAppUBCStatistic", "onRequest: ignore " + this.a);
                    return;
                }
                return;
            }
            long j = this.b - this.c;
            if (this.d == 200) {
                z = true;
            } else {
                z = false;
            }
            if (this.e == 0) {
                if (TextUtils.equals(this.f, "1")) {
                    if (z) {
                        b72.d().e(a72.c(this.a, this.c, this.b, this.d, this.g));
                    } else {
                        b72.d().e(a72.a(this.a, this.c, this.b, this.d, this.g));
                    }
                } else if (TextUtils.equals(this.f, "0")) {
                    b72.d().e(a72.b(this.a, this.c, this.g));
                }
            }
            if (z && j < 5000) {
                if (dd3.a) {
                    Log.d("SwanAppUBCStatistic", "code 200 & cost(" + (this.b - this.c) + ") is ok, don't report");
                    return;
                }
                return;
            }
            dd3.j(this.d, this.a, this.e, this.h, this.i, this.j, this.f, this.c, this.b, this.k);
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ int g;

        public c(String str, int i, String str2, String str3, String str4, String str5, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), str2, str3, str4, str5, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = i;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = str5;
            this.g = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            kd3 kd3Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int c = xx2.c();
                if (dd3.a) {
                    Log.d("SwanAppUBCStatistic", "get NetworkQuality: " + c);
                }
                if (TextUtils.equals(this.a, "1")) {
                    kd3Var = new kd3(this.b, this.c, this.d, c);
                } else {
                    kd3Var = new kd3(this.c, c, 0L, 0L);
                }
                new gd3.a(kd3Var, "downloadFile");
                if (!TextUtils.isEmpty(this.e)) {
                    kd3Var.r(this.e);
                }
                if (!TextUtils.isEmpty(this.f)) {
                    kd3Var.q(this.f);
                }
                kd3Var.b = "downloadFile";
                if (k63.M() != null && k63.M().Z() != null) {
                    kd3Var.c = k63.M().Z().U();
                }
                kd3Var.f = k63.h0();
                kd3Var.a = dd3.n(this.g);
                JSONObject f = kd3Var.f();
                rc3.k("834", f);
                k32.k("SwanAppUBCStatistic", "834-downloadFile event=" + f.toString());
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ md3 a;

        public d(md3 md3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {md3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = md3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                rc3.k("894", this.a.f());
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jd3 a;

        public e(jd3 jd3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jd3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                rc3.k("751", this.a.f());
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ForbiddenInfo b;

        public f(String str, ForbiddenInfo forbiddenInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, forbiddenInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = forbiddenInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ld3 ld3Var = new ld3();
                ld3Var.e = this.a;
                ld3Var.b = "show";
                ld3Var.a = "swan";
                ForbiddenInfo forbiddenInfo = this.b;
                ld3Var.c = forbiddenInfo.launchSource;
                ld3Var.a("path", forbiddenInfo.launchPath);
                ld3Var.a("appkey", this.b.appId);
                rc3.m("1400", ld3Var.f());
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Exception d;

        public g(String str, String str2, int i, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, Integer.valueOf(i), exc};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            k63 c0;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (c0 = k63.c0()) == null) {
                return;
            }
            hr2.a X = c0.X();
            String a0 = c0.a0();
            String appId = c0.getAppId();
            ld3 ld3Var = new ld3();
            ld3Var.b = "login";
            ld3Var.a = dd3.n(X.H());
            ld3Var.f = appId;
            ld3Var.e = this.a;
            ld3Var.a("appName", a0);
            ld3Var.a("invokeFrom", this.b);
            ld3Var.a("scene", Integer.valueOf(this.c));
            JSONObject f = ld3Var.f();
            if (TextUtils.equals(this.a, "show")) {
                k32.j("SwanAppUBCStatistic", "1936", "登录展示 event=" + f, false);
                rc3.i("1936", "80", f);
            } else if (TextUtils.equals(this.a, "success")) {
                k32.j("SwanAppUBCStatistic", "1936", "登录成功 event=" + f, false);
                rc3.i("1936", "81", f);
            } else if (TextUtils.equals(this.a, "fail") || TextUtils.equals(this.a, "check_fail")) {
                k32.e("SwanAppUBCStatistic", "1936", "登录失败 event=" + f, this.d, false);
                rc3.i("1936", "82", f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ Exception e;
        public final /* synthetic */ boolean f;

        public h(String str, String str2, String str3, boolean z, Exception exc, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3, Boolean.valueOf(z), exc, Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = z;
            this.e = exc;
            this.f = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                k63 q = j63.K().q();
                hr2.a X = q.X();
                String a0 = q.a0();
                String appId = q.getAppId();
                ld3 ld3Var = new ld3();
                ld3Var.b = "swanLogin";
                ld3Var.a = dd3.n(X.H());
                ld3Var.f = appId;
                ld3Var.e = this.a;
                ld3Var.a("appName", a0);
                ld3Var.a("loginScene", this.b);
                String str = this.c;
                if (str != null) {
                    ld3Var.a("errorInfo", str);
                }
                JSONObject f = ld3Var.f();
                if (this.d) {
                    k32.p("SwanAppUBCStatistic", "1936", "登录取消打点 event=" + f, this.e, false);
                } else if (this.f) {
                    k32.e("SwanAppUBCStatistic", "1936", "登录失败打点 event=" + f, this.e, false);
                } else {
                    k32.j("SwanAppUBCStatistic", "1936", "登录数据打点 event=" + f, false);
                }
                rc3.i("1936", "1936", f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public i(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                md3 md3Var = new md3();
                md3Var.a = dd3.n(j63.K().q().k());
                String str = this.a;
                md3Var.b = str;
                md3Var.g = this.b;
                if (TextUtils.equals(str, "click")) {
                    md3Var.e = this.c;
                }
                md3Var.f = j63.K().getAppId();
                md3Var.a("source", j63.K().q().X().U());
                md3Var.a("mode", "normal");
                md3Var.a("from", "login");
                JSONObject f = md3Var.f();
                if (dd3.a) {
                    Log.d("SwanAppUBCStatistic", "staticLoginResult: event = " + f);
                }
                rc3.k("1936", f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        public j(int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (dd3.c) {
                    try {
                        dd3.c.wait(this.a);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ md3 a;
        public final /* synthetic */ qc3 b;

        public k(md3 md3Var, qc3 qc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {md3Var, qc3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = md3Var;
            this.b = qc3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                md3 md3Var = this.a;
                if (md3Var != null) {
                    rc3.f(this.b, md3Var.f().toString());
                }
                rc3.c(this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class l implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ String b;

        public l(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ld3 ld3Var = new ld3();
                ld3Var.a = dd3.n(j63.K().q().k());
                ld3Var.f = j63.K().getAppId();
                if (this.a) {
                    i = 1;
                } else {
                    i = 2;
                }
                ld3Var.a("type", Integer.valueOf(i));
                ld3Var.a(CloudStabilityUBCUtils.KEY_ERROR_CODE, Long.valueOf(cm3.c().g()));
                ld3Var.a("degradeUrl", this.b);
                ld3Var.a("appid", j63.K().getAppId());
                ld3Var.a("hostname", rp2.n().a());
                ld3Var.a("_swebfr", dm3.e());
                rc3.i("3863", "3863", ld3Var.f());
                if (this.a) {
                    di3 di3Var = new di3();
                    di3Var.k(1L);
                    di3Var.i(2108L);
                    hi3.a().f(di3Var);
                    ld3 ld3Var2 = new ld3();
                    ld3Var2.p(di3Var);
                    ld3Var2.r(j63.K().q().X());
                    ld3Var2.q(dd3.n(j63.K().k()));
                    ld3Var2.m(j63.K().getAppId());
                    dd3.R(ld3Var2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ld3 a;
        public final /* synthetic */ long b;
        public final /* synthetic */ Exception c;

        public m(ld3 ld3Var, long j, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ld3Var, Long.valueOf(j), exc};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ld3Var;
            this.b = j;
            this.c = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (TextUtils.isEmpty(this.a.g())) {
                    this.a.k(j63.K().q().X().W());
                }
                JSONObject f = this.a.f();
                k32.e("SwanAppUBCStatistic", "671", "稳定性打点 since=" + yi3.e(new Date(this.b), "yyyy-MM-dd HH:mm:ss.SSS") + " event=" + f, this.c, false);
                rc3.k("671", f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ md3 a;
        public final /* synthetic */ String b;

        public n(md3 md3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {md3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = md3Var;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSONObject f = this.a.f();
                rc3.k(this.b, f);
                if (GameCenterCoreUtils.REF_TYPE_FROM_GAMECENTER.equals(this.b)) {
                    bd3.a().b(f.toString());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ md3 c;

        public o(String str, String str2, md3 md3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, md3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
            this.c = md3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                rc3.i(this.a, this.b, this.c.f());
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jd3 a;

        public p(jd3 jd3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jd3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                rc3.k("751", this.a.f());
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jd3 a;

        public q(jd3 jd3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jd3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                rc3.k("751", this.a.f());
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jd3 a;

        public r(jd3 jd3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jd3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                rc3.k("751", this.a.f());
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class s implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ jd3 a;

        public s(jd3 jd3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jd3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jd3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                rc3.k("751", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947700662, "Lcom/baidu/tieba/dd3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947700662, "Lcom/baidu/tieba/dd3;");
                return;
            }
        }
        a = vm1.a;
        b = Executors.newSingleThreadExecutor();
        c = new Object();
        d = Sets.newHashSet("hmma.baidu.com");
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        e = copyOnWriteArrayList;
        copyOnWriteArrayList.add("https://hmma.baidu.com/mini.gif");
        e.add("https://dxp.baidu.com/mini");
        CopyOnWriteArrayList<String> copyOnWriteArrayList2 = e;
        copyOnWriteArrayList2.add(e32.c() + "/smtapp/recordhandler/getrecordinfo");
        CopyOnWriteArrayList<String> copyOnWriteArrayList3 = e;
        copyOnWriteArrayList3.add(e32.b() + "/smtapp/recordhandler/getrecordinfo");
    }

    public static void A(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, null, str, i2) == null) {
            t(0, str, i2, null, null, null, "0");
        }
    }

    public static void T(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, str, str2) == null) {
            U(str, str2, null);
        }
    }

    public static void V(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65558, null, z, str) == null) {
            b.execute(new l(z, str));
        }
    }

    public static void i(qc3 qc3Var, md3 md3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65572, null, qc3Var, md3Var) != null) || qc3Var == null) {
            return;
        }
        ej3.j(new k(md3Var, qc3Var), "SwanAppUBCEndFlow");
    }

    @NonNull
    public static String m(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65576, null, str, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", str);
                jSONObject.put(PmsConstant.Statistic.STATISTIC_ERRMSG, str2);
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
            return jSONObject.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static void w(ForbiddenInfo forbiddenInfo, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65587, null, forbiddenInfo, str) == null) && forbiddenInfo != null && !TextUtils.isEmpty(str)) {
            b.execute(new f(str, forbiddenInfo));
        }
    }

    public static void x(String str, md3 md3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65588, null, str, md3Var) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        d03.e().d(new n(md3Var, str), "SwanAppUBCOnEvent", true);
    }

    public static void B(String str, int i2, NetworkStatRecord networkStatRecord) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65538, null, str, i2, networkStatRecord) == null) {
            C(str, i2, networkStatRecord, 0L, 0L, "");
        }
    }

    public static void S(String str, int i2, String str2) {
        Exception exc;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65555, null, str, i2, str2) == null) {
            if (TextUtils.equals(str, "fail")) {
                exc = new Exception("stack");
            } else {
                exc = null;
            }
            b.execute(new g(str, str2, i2, exc));
        }
    }

    public static void s(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65583, null, str, str2, str3) == null) {
            b.execute(new i(str, str2, str3));
        }
    }

    public static void y(String str, String str2, md3 md3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65589, null, str, str2, md3Var) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ej3.j(new o(str, str2, md3Var), "SwanAppUbcCeresOnEvent");
        }
    }

    public static void C(String str, int i2, NetworkStatRecord networkStatRecord, long j2, long j3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{str, Integer.valueOf(i2), networkStatRecord, Long.valueOf(j2), Long.valueOf(j3), str2}) == null) {
            M(0, str, i2, null, null, null, "0", j2, j3, networkStatRecord, str2);
        }
    }

    public static void O(int i2, String str, int i3, String str2, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            Q(i2, str, i3, str2, null, null, j2, j3, "");
        }
    }

    public static void D(String str, int i2, NetworkStatRecord networkStatRecord, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i2, networkStatRecord, str2) == null) {
            C(str, i2, networkStatRecord, 0L, 0L, str2);
        }
    }

    public static void E() {
        hr2.a X;
        Bundle Q;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, null) == null) && j63.K().E() && (Q = (X = j63.K().q().X()).Q()) != null && Q.getLong("launch_flag_for_statistic") > 0) {
            long k2 = X.k("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            nd3 nd3Var = new nd3();
            nd3Var.a = n(j63.K().k());
            nd3Var.f = X.I();
            if (j23.F(X.h0())) {
                nd3Var.c = "remote-debug";
            } else if (j23.D()) {
                nd3Var.c = "local-debug";
            } else {
                nd3Var.c = X.U();
            }
            nd3Var.b = "launch";
            nd3Var.e = "success";
            nd3Var.r = String.valueOf(currentTimeMillis - k2);
            nd3Var.a("status", "0");
            uc3.n(nd3Var, X.X(), X.t0().getString("ubc"));
            Q.putLong("launch_flag_for_statistic", 0L);
            HybridUbcFlow d2 = pz2.d("startup");
            if (d2 != null) {
                if (!d2.w() && !d2.t()) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    d2.E("value", "na_success");
                }
            }
        }
    }

    public static void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, null) == null) {
            j63 K = j63.K();
            k63 q2 = K.q();
            hr2.a X = q2.X();
            if (K.E() && q2.t0()) {
                Bundle t0 = X.t0();
                if (t0.getLong("launch_flag_for_statistic") > 0) {
                    String valueOf = String.valueOf(System.currentTimeMillis() - q2.X().v1());
                    nd3 nd3Var = new nd3();
                    nd3Var.a = n(X.H());
                    nd3Var.b = "launch";
                    nd3Var.e = "cancel";
                    nd3Var.q = valueOf;
                    nd3Var.j(X);
                    nd3Var.d(t0.getString("ubc"));
                    nd3Var.b(k(X.X()));
                    onEvent(nd3Var);
                    nd3 nd3Var2 = new nd3();
                    nd3Var2.a = n(X.H());
                    nd3Var2.b = "launch";
                    nd3Var2.e = "realcancel";
                    nd3Var2.q = valueOf;
                    nd3Var2.j(X);
                    nd3Var2.b(k(X.X()));
                    nd3Var2.a("reason", "cancel");
                    if (X.H() == 1) {
                        nd3Var.a("errorList", sp2.j().a());
                    }
                    nd3Var2.d(t0.getString("ubc"));
                    onEvent(nd3Var2);
                    t0.remove("launch_flag_for_statistic");
                }
            }
        }
    }

    public static void F(boolean z, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65542, null, z, str) == null) {
            md3 md3Var = new md3();
            if (j63.K().q().I()) {
                md3Var.d(j63.K().q().X().t0().getString("ubc"));
            }
            md3Var.b = "show";
            md3Var.c = str;
            if (z) {
                str2 = "success";
            } else {
                str2 = "fail";
            }
            md3Var.e = str2;
            md3Var.f = k63.h0();
            d03.e().d(new a(md3Var), "SwanAppUBCOnPagesRoute", true);
        }
    }

    public static void G(String str, String str2, List<String> list) {
        int i2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, str2, list) == null) {
            if (j63.K().q().I()) {
                hr2.a X = j63.K().q().X();
                i2 = X.H();
                str3 = X.t0().getString("ubc");
            } else {
                i2 = 0;
                str3 = "";
            }
            jd3 jd3Var = new jd3();
            jd3Var.b = Logger.PAY_TYPE;
            jd3Var.c = str;
            jd3Var.f = k63.h0();
            jd3Var.a = n(i2);
            try {
                JSONObject jSONObject = new JSONObject(str3);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("paymenturl", str2);
                }
                if (list != null) {
                    jSONObject.put("whitelist", list);
                }
                jSONObject.put("appname", k63.M().a0());
                jd3Var.e(jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
                jd3Var.d(str3);
            }
            jd3Var.b(Z());
            ej3.k(new q(jd3Var), "SwanAppUBCOnPay");
        }
    }

    public static void H(boolean z, String str, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
            jd3 jd3Var = new jd3();
            hr2.a X = j63.K().q().X();
            if (j63.K().q().I()) {
                jd3Var.d(X.t0().getString("ubc"));
            }
            jd3Var.b = Logger.PAY_TYPE;
            if (z) {
                str3 = "success";
            } else {
                str3 = "fail";
            }
            jd3Var.e = str3;
            jd3Var.c = str;
            jd3Var.f = k63.h0();
            jd3Var.a = n(X.H());
            jd3Var.a("money", str2);
            jd3Var.b(Z());
            ej3.j(new p(jd3Var), "SwanAppUBCOnPay");
        }
    }

    public static void q(String str, String str2, boolean z) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65581, null, str, str2, z) == null) {
            md3 md3Var = new md3();
            md3Var.b = str;
            md3Var.e = str2;
            md3Var.f = k63.h0();
            if (k63.M() != null && k63.M().Z() != null) {
                hr2.a Z = k63.M().Z();
                md3Var.c = Z.U();
                md3Var.a = n(Z.H());
            }
            if (TextUtils.equals("click", str)) {
                if (z) {
                    str3 = "success";
                } else {
                    str3 = "fail";
                }
                md3Var.a("authorize", str3);
            }
            ej3.k(new d(md3Var), "SwanAppUBCOnAuthDialog");
        }
    }

    public static void z(String str, int i2, String str2) {
        k63 c0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(65590, null, str, i2, str2) != null) || (c0 = k63.c0()) == null) {
            return;
        }
        di3 di3Var = new di3();
        di3Var.k(5L);
        di3Var.i(50L);
        ld3 ld3Var = new ld3();
        ld3Var.p(di3Var);
        ld3Var.r(c0.X());
        ld3Var.q(n(c0.k()));
        ld3Var.m(c0.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", c0.getAppId());
            jSONObject.put("url", str);
            jSONObject.put(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, i2);
            jSONObject.put("msg", str2);
        } catch (JSONException e2) {
            if (a) {
                e2.printStackTrace();
            }
        }
        ld3Var.e(jSONObject);
        R(ld3Var);
    }

    public static void I(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65545, null, str, str2, str3, str4) == null) && j63.K().q().I()) {
            hr2.a X = j63.K().q().X();
            int H = X.H();
            jd3 jd3Var = new jd3();
            jd3Var.b = "paykey";
            jd3Var.a = n(H);
            jd3Var.c = str;
            jd3Var.e = str4;
            jd3Var.a("appid", X.I());
            jd3Var.a("money", str2);
            jd3Var.a("source", X.U());
            jd3Var.a("pmappkey", str3);
            ej3.k(new s(jd3Var), "SwanAppUBCOnPayChecked");
        }
    }

    public static void J(String str, boolean z, boolean z2) {
        String str2;
        String str3;
        lw2 S1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            jd3 jd3Var = new jd3();
            hr2.a X = j63.K().q().X();
            if (j63.K().q().I()) {
                jd3Var.d(X.t0().getString("ubc"));
            }
            jd3Var.b = "paylogin";
            jd3Var.c = str;
            jd3Var.f = X.J();
            jd3Var.a = n(X.H());
            if (z) {
                str2 = "success";
            } else {
                str2 = "fail";
            }
            jd3Var.e = str2;
            jd3Var.a("nativeAppId", rp2.n().a());
            if (z2) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            jd3Var.a("paylogin", str3);
            s52 J = xr2.V().J();
            if (J == null) {
                S1 = null;
            } else {
                S1 = J.S1();
            }
            if (S1 != null && !TextUtils.isEmpty(S1.i())) {
                jd3Var.a("page", S1.i());
            }
            jd3Var.b(Z());
            ej3.j(new e(jd3Var), "SwanAppUBCOnPayLogin");
        }
    }

    public static void K(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65547, null, str, str2, i2) == null) && j63.K().q().I()) {
            hr2.a X = j63.K().q().X();
            int H = X.H();
            jd3 jd3Var = new jd3();
            jd3Var.b = "payProcess";
            jd3Var.a = n(H);
            jd3Var.c = str;
            jd3Var.a("paymentProcess", str2);
            jd3Var.a("appid", X.I());
            jd3Var.a("source", X.U());
            if (X.k0() != null) {
                jd3Var.a("swan", X.k0().swanCoreVersionName);
            }
            if (TextUtils.equals("result", str2)) {
                if (i2 != 0) {
                    if (i2 != 2) {
                        jd3Var.a("payResultStatus", "fail");
                    } else {
                        jd3Var.a("payResultStatus", "cancel");
                    }
                } else {
                    jd3Var.a("payResultStatus", "success");
                }
            }
            jd3Var.b(Z());
            ej3.k(new r(jd3Var), "SwanAppUBCOnPayProcess");
        }
    }

    public static void L(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, str2) == null) {
            nd3 nd3Var = new nd3();
            nd3Var.b = "launch";
            nd3Var.e = str;
            if (k63.c0() != null) {
                hr2.a X = k63.c0().X();
                nd3Var.a = n(X.H());
                nd3Var.f = X.I();
                nd3Var.c = X.U();
            }
            nd3Var.t = str2;
            onEvent(nd3Var);
        }
    }

    public static void M(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5, long j2, long j3, @Nullable NetworkStatRecord networkStatRecord, @NonNull String str6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, str5, Long.valueOf(j2), Long.valueOf(j3), networkStatRecord, str6}) == null) {
            b.execute(new b(str, j3, j2, i2, i3, str5, str6, str2, str3, str4, networkStatRecord));
        }
    }

    public static void N(String str, String str2, @NonNull JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, str, str2, jSONObject) == null) {
            if (!TextUtils.equals(str, "1")) {
                if (a) {
                    Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. requestType=" + str);
                }
            } else if (TextUtils.isEmpty(str2)) {
                if (a) {
                    Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. url is empty");
                }
            } else {
                HttpUrl parse = HttpUrl.parse(str2);
                if (parse == null) {
                    if (a) {
                        Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. url is illegal, url=" + str2);
                        return;
                    }
                    return;
                }
                String host = parse.host();
                if (TextUtils.isEmpty(host)) {
                    if (a) {
                        Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. host is empty, url=" + str2);
                    }
                } else if (d.contains(host)) {
                    if (a) {
                        Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: miss. host is ignored, host=" + host + " ,url=" + str2);
                    }
                } else {
                    if (a) {
                        Log.d("SwanAppUBCStatistic", "RequestForAvatar: onRequestForAvatar: hit. url=" + str2 + " value=" + jSONObject);
                    }
                    rc3.i("1415", PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_SHOW, jSONObject);
                }
            }
        }
    }

    public static void P(int i2, String str, int i3, String str2, long j2, long j3, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, Long.valueOf(j2), Long.valueOf(j3), str3}) == null) {
            Q(i2, str, i3, str2, null, null, j2, j3, str3);
        }
    }

    @WorkerThread
    public static void t(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65584, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, str5}) != null) || i2 == 200) {
            return;
        }
        b.execute(new c(str5, i2, str, str2, str3, str4, i3));
    }

    public static void Q(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, long j2, long j3, @NonNull String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, Long.valueOf(j2), Long.valueOf(j3), str5}) == null) {
            M(i2, str, i3, str2, str3, str4, "1", j2, j3, null, str5);
        }
    }

    public static void R(ld3 ld3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65554, null, ld3Var) != null) || ld3Var == null) {
            return;
        }
        ej3.j(new m(ld3Var, System.currentTimeMillis(), new Exception("stack")), "SwanAppUBCStability");
    }

    public static void a0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65564, null, i2) == null) {
            b.execute(new j(i2));
        }
    }

    public static qc3 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, str)) == null) {
            return rc3.a(str);
        }
        return (qc3) invokeL.objValue;
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65568, null, str) == null) {
            md3 md3Var = new md3();
            md3Var.a = n(0);
            md3Var.b = str;
            x("956", md3Var);
        }
    }

    public static void U(String str, String str2, String str3) {
        Exception exc;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65557, null, str, str2, str3) == null) {
            boolean equals = TextUtils.equals(str2, "cancel");
            boolean equals2 = TextUtils.equals(str2, "fail");
            if (!equals && !equals2) {
                exc = null;
            } else {
                exc = new Exception("stack");
            }
            b.execute(new h(str2, str, str3, equals, exc, equals2));
        }
    }

    public static void W(String str, String str2) {
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, null, str, str2) == null) {
            md3 md3Var = new md3();
            k63 c0 = k63.c0();
            String str5 = "";
            if (c0 == null) {
                str3 = "";
                str4 = str3;
            } else {
                str5 = n(c0.k());
                str4 = c0.P();
                str3 = c0.X().U();
            }
            md3Var.a = str5;
            md3Var.b = AlbumActivityConfig.FROM_WEB_VIEW;
            md3Var.c = str3;
            md3Var.a("appkey", str4);
            md3Var.a("url", str);
            md3Var.a("browser", str2);
            y("3320", "96", md3Var);
            if (a) {
                Log.d("SwanAppUBCStatistic", "onWebViewHistoryChange: " + String.format("ubcId=%s && ceresId=%s , content:%s ", "3320", "96", md3Var.f()));
            }
        }
    }

    public static void r(int i2, kb3 kb3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65582, null, i2, kb3Var) == null) {
            k63 c0 = k63.c0();
            if (c0 == null) {
                if (a) {
                    Log.e("SwanAppUBCStatistic", "onAuthorizeFailed-swanApp is null");
                    return;
                }
                return;
            }
            ld3 ld3Var = new ld3();
            ld3Var.o(i2);
            ld3Var.r(c0.Z());
            ld3Var.q(n(c0.k()));
            ld3Var.m(c0.getAppId());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", c0.getAppId());
                jSONObject.put("msg", ib3.f(i2));
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, c0.f0().q("cur_request_id", ""));
                if (kb3Var != null) {
                    jSONObject.put("scope", kb3Var.b);
                    jSONObject.put("scopeData", kb3Var.a);
                }
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
            ld3Var.e(jSONObject);
            R(ld3Var);
        }
    }

    public static JSONObject X(@Nullable NetworkStatRecord networkStatRecord) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, networkStatRecord)) == null) {
            if (networkStatRecord == null) {
                return null;
            }
            long j2 = networkStatRecord.dnsEndTs;
            long j3 = networkStatRecord.dnsStartTs;
            long j4 = networkStatRecord.connTs;
            long j5 = networkStatRecord.startTs;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("request_network_start", j5);
                jSONObject.put("request_network_conn", j4);
                jSONObject.put("request_dns_start", j3);
                jSONObject.put("request_dns_end", j2);
                jSONObject.put("request_network_response", networkStatRecord.responseTs);
                jSONObject.put("request_send_header", networkStatRecord.sendHeaderTs);
                jSONObject.put("request_receive_header", networkStatRecord.receiveHeaderTs);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("connectTime", jSONObject);
                return jSONObject2;
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
                return null;
            }
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void d(nd3 nd3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65567, null, nd3Var) == null) && nd3Var != null && k63.M() != null && k63.M().Z() != null) {
            hr2.a Z = k63.M().Z();
            nd3Var.a = n(Z.H());
            nd3Var.f = Z.I();
            nd3Var.a("appkey", Z.J());
            x("1032", nd3Var);
        }
    }

    public static JSONObject k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String queryParameter = Uri.parse(str).getQueryParameter("_baiduboxapp");
            if (!TextUtils.isEmpty(queryParameter)) {
                try {
                    JSONObject optJSONObject = new JSONObject(queryParameter).optJSONObject("ext");
                    if (optJSONObject != null) {
                        if (TextUtils.equals(optJSONObject.optString("token"), "swanubc")) {
                            return optJSONObject;
                        }
                    }
                } catch (JSONException e2) {
                    if (a) {
                        e2.printStackTrace();
                    }
                }
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static JSONObject Z() {
        InterceptResult invokeV;
        hr2.a Z;
        JSONObject N;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            k63 M = k63.M();
            if (M == null || (Z = M.Z()) == null || (N = Z.N()) == null || !TextUtils.equals(N.optString("token"), "swanubc")) {
                return null;
            }
            return N;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static /* synthetic */ JSONObject a() {
        return Z();
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tieba.dd3.j.run():void] */
    public static /* synthetic */ boolean b() {
        return a;
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) {
            if (xw2.g()) {
                return "1";
            }
            return "0";
        }
        return (String) invokeV.objValue;
    }

    public static void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65580, null) == null) {
            synchronized (c) {
                try {
                    c.notifyAll();
                }
            }
        }
    }

    public static void f(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65569, null, str, str2, str3) == null) {
            md3 md3Var = new md3();
            if (k63.M() != null && k63.M().Z() != null) {
                hr2.a Z = k63.M().Z();
                md3Var.a = n(Z.H());
                md3Var.f = Z.I();
                md3Var.b = str;
                md3Var.c = str2;
                md3Var.e = str3;
                md3Var.a("appkey", Z.J());
            }
            x("923", md3Var);
        }
    }

    public static void g(md3 md3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65570, null, md3Var) == null) {
            if (k63.M() != null && k63.M().Z() != null) {
                hr2.a Z = k63.M().Z();
                md3Var.a = n(Z.H());
                md3Var.f = Z.I();
                md3Var.c = Z.U();
            }
            x("936", md3Var);
        }
    }

    public static void h(md3 md3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65571, null, md3Var) == null) {
            if (k63.M() != null && k63.M().Z() != null) {
                hr2.a Z = k63.M().Z();
                md3Var.a = n(Z.H());
                md3Var.f = Z.I();
                md3Var.c = Z.U();
            }
            x("914", md3Var);
        }
    }

    @WorkerThread
    public static void j(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5, long j2, long j3, @Nullable NetworkStatRecord networkStatRecord) {
        kd3 kd3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65573, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, str5, Long.valueOf(j2), Long.valueOf(j3), networkStatRecord}) == null) {
            int c2 = xx2.c();
            if (a) {
                Log.d("SwanAppUBCStatistic", "get NetworkQuality: " + c2);
            }
            if (TextUtils.equals(str5, "1")) {
                kd3Var = new kd3(i2, str, str2, c2, j2, j3);
            } else {
                kd3Var = new kd3(str, c2, j2, j3);
            }
            gd3.a aVar = new gd3.a(kd3Var, "request");
            if (!TextUtils.isEmpty(str3)) {
                kd3Var.r(str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                kd3Var.q(str4);
            }
            kd3Var.b = "request";
            k63 q2 = j63.K().q();
            if (q2 != null && q2.I()) {
                kd3Var.c = q2.X().U();
                kd3Var.d = q2.X().W();
            }
            kd3Var.f = k63.h0();
            kd3Var.a = n(i3);
            JSONObject X = X(networkStatRecord);
            aVar.b = X;
            if (X != null) {
                kd3Var.e(X);
            }
            if (a) {
                Log.d("SwanAppUBCStatistic", "Reporting: " + kd3Var.f());
            }
            JSONObject f2 = kd3Var.f();
            if (kd3Var.o()) {
                k32.j("SwanAppUBCStatistic", "834", "网络请求成功打点 event=" + f2, false);
            } else {
                k32.e("SwanAppUBCStatistic", "834", "网络请求失败打点 event=" + f2, null, false);
            }
            rc3.k("834", f2);
            N(kd3Var.m(), kd3Var.n(), f2);
        }
    }

    public static boolean o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, str)) == null) {
            if (a) {
                Log.d("SwanAppUBCStatistic", "isIgnoreRequest: start with " + str);
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            int size = e.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str2 = e.get(i2);
                if (!TextUtils.isEmpty(str2) && str.startsWith(str2)) {
                    if (a) {
                        Log.d("SwanAppUBCStatistic", "isIgnoreRequest: ignore " + str);
                        return true;
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void onEvent(nd3 nd3Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65579, null, nd3Var) == null) {
            ExtensionCore U = ed2.V().U();
            if (U != null) {
                nd3Var.a("extension_ver", U.extensionCoreVersionName);
            }
            if (j63.K().q().X().c("launch_by_reload")) {
                str = "1";
            } else {
                str = "0";
            }
            nd3Var.a("isReloadApp", str);
            JSONObject jSONObject = new JSONObject();
            kj3.f(jSONObject, "static", Float.valueOf(rp2.m().a()));
            nd3Var.a("device_score", jSONObject.toString());
            x(GameCenterCoreUtils.REF_TYPE_FROM_GAMECENTER, nd3Var);
        }
    }

    public static void u(int i2, String str, int i3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65585, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2}) == null) {
            t(i2, str, i3, str2, null, null, "1");
        }
    }

    public static void v(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65586, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4}) == null) {
            t(i2, str, i3, str2, str3, str4, "1");
        }
    }
}
