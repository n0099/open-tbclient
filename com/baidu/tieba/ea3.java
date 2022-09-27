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
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.favordata.SwanFavorItemData;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.util.GameCenterCoreUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ha3;
import com.baidu.tieba.io2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Sets;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class ea3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final ExecutorService b;
    public static Object c;
    public static final Set<String> d;
    public static final CopyOnWriteArrayList<String> e;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ na3 a;

        public a(na3 na3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {na3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = na3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b(ea3.Z());
                s93.k("778", this.a.f());
            }
        }
    }

    /* loaded from: classes3.dex */
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
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && SwanAppNetworkUtils.i(null)) {
                if (ea3.o(this.a)) {
                    if (ea3.a) {
                        Log.d("SwanAppUBCStatistic", "onRequest: ignore " + this.a);
                        return;
                    }
                    return;
                }
                long j = this.b - this.c;
                boolean z = this.d == 200;
                if (this.e == 0) {
                    if (TextUtils.equals(this.f, "1")) {
                        if (z) {
                            c42.d().e(b42.c(this.a, this.c, this.b, this.d, this.g));
                        } else {
                            c42.d().e(b42.a(this.a, this.c, this.b, this.d, this.g));
                        }
                    } else if (TextUtils.equals(this.f, "0")) {
                        c42.d().e(b42.b(this.a, this.c, this.g));
                    }
                }
                if (z && j < 5000) {
                    if (ea3.a) {
                        Log.d("SwanAppUBCStatistic", "code 200 & cost(" + (this.b - this.c) + ") is ok, don't report");
                        return;
                    }
                    return;
                }
                ea3.j(this.d, this.a, this.e, this.h, this.i, this.j, this.f, this.c, this.b, this.k);
            }
        }
    }

    /* loaded from: classes3.dex */
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
            la3 la3Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int c = yu2.c();
                if (ea3.a) {
                    Log.d("SwanAppUBCStatistic", "get NetworkQuality: " + c);
                }
                if (TextUtils.equals(this.a, "1")) {
                    la3Var = new la3(this.b, this.c, this.d, c);
                } else {
                    la3Var = new la3(this.c, c, 0L, 0L);
                }
                new ha3.a(la3Var, "downloadFile");
                if (!TextUtils.isEmpty(this.e)) {
                    la3Var.r(this.e);
                }
                if (!TextUtils.isEmpty(this.f)) {
                    la3Var.q(this.f);
                }
                la3Var.b = "downloadFile";
                if (l33.M() != null && l33.M().Y() != null) {
                    la3Var.c = l33.M().Y().T();
                }
                la3Var.f = l33.g0();
                la3Var.a = ea3.n(this.g);
                JSONObject f = la3Var.f();
                s93.k("834", f);
                l02.k("SwanAppUBCStatistic", "834-downloadFile event=" + f.toString());
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ na3 a;

        public d(na3 na3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {na3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = na3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                s93.k("894", this.a.f());
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ka3 a;

        public e(ka3 ka3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ka3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ka3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                s93.k("751", this.a.f());
            }
        }
    }

    /* loaded from: classes3.dex */
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
                ma3 ma3Var = new ma3();
                ma3Var.e = this.a;
                ma3Var.b = "show";
                ma3Var.a = "swan";
                ForbiddenInfo forbiddenInfo = this.b;
                ma3Var.c = forbiddenInfo.launchSource;
                ma3Var.a("path", forbiddenInfo.launchPath);
                ma3Var.a("appkey", this.b.appId);
                s93.m("1400", ma3Var.f());
            }
        }
    }

    /* loaded from: classes3.dex */
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
            l33 b0;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (b0 = l33.b0()) == null) {
                return;
            }
            io2.a W = b0.W();
            String Z = b0.Z();
            String appId = b0.getAppId();
            ma3 ma3Var = new ma3();
            ma3Var.b = "login";
            ma3Var.a = ea3.n(W.G());
            ma3Var.f = appId;
            ma3Var.e = this.a;
            ma3Var.a("appName", Z);
            ma3Var.a("invokeFrom", this.b);
            ma3Var.a("scene", Integer.valueOf(this.c));
            JSONObject f = ma3Var.f();
            if (TextUtils.equals(this.a, "show")) {
                l02.j("SwanAppUBCStatistic", "1936", "登录展示 event=" + f, false);
                s93.i("1936", "80", f);
            } else if (TextUtils.equals(this.a, "success")) {
                l02.j("SwanAppUBCStatistic", "1936", "登录成功 event=" + f, false);
                s93.i("1936", "81", f);
            } else if (TextUtils.equals(this.a, com.baidu.pass.biometrics.face.liveness.b.a.g0) || TextUtils.equals(this.a, "check_fail")) {
                l02.e("SwanAppUBCStatistic", "1936", "登录失败 event=" + f, this.d, false);
                s93.i("1936", "82", f);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                l33 q = k33.K().q();
                io2.a W = q.W();
                String Z = q.Z();
                String appId = q.getAppId();
                ma3 ma3Var = new ma3();
                ma3Var.b = "swanLogin";
                ma3Var.a = ea3.n(W.G());
                ma3Var.f = appId;
                ma3Var.e = this.a;
                ma3Var.a("appName", Z);
                ma3Var.a("loginScene", this.b);
                String str = this.c;
                if (str != null) {
                    ma3Var.a("errorInfo", str);
                }
                JSONObject f = ma3Var.f();
                if (this.d) {
                    l02.p("SwanAppUBCStatistic", "1936", "登录取消打点 event=" + f, this.e, false);
                } else if (this.f) {
                    l02.e("SwanAppUBCStatistic", "1936", "登录失败打点 event=" + f, this.e, false);
                } else {
                    l02.j("SwanAppUBCStatistic", "1936", "登录数据打点 event=" + f, false);
                }
                s93.i("1936", "1936", f);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                na3 na3Var = new na3();
                na3Var.a = ea3.n(k33.K().q().k());
                String str = this.a;
                na3Var.b = str;
                na3Var.g = this.b;
                if (TextUtils.equals(str, "click")) {
                    na3Var.e = this.c;
                }
                na3Var.f = k33.K().getAppId();
                na3Var.a("source", k33.K().q().W().T());
                na3Var.a("mode", "normal");
                na3Var.a("from", "login");
                JSONObject f = na3Var.f();
                if (ea3.a) {
                    Log.d("SwanAppUBCStatistic", "staticLoginResult: event = " + f);
                }
                s93.k("1936", f);
            }
        }
    }

    /* loaded from: classes3.dex */
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
                synchronized (ea3.c) {
                    try {
                        ea3.c.wait(this.a);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ na3 a;
        public final /* synthetic */ r93 b;

        public k(na3 na3Var, r93 r93Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {na3Var, r93Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = na3Var;
            this.b = r93Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                na3 na3Var = this.a;
                if (na3Var != null) {
                    s93.f(this.b, na3Var.f().toString());
                }
                s93.c(this.b);
            }
        }
    }

    /* loaded from: classes3.dex */
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ma3 ma3Var = new ma3();
                ma3Var.a = ea3.n(k33.K().q().k());
                ma3Var.f = k33.K().getAppId();
                ma3Var.a("type", Integer.valueOf(this.a ? 1 : 2));
                ma3Var.a("errorCode", Long.valueOf(dj3.c().g()));
                ma3Var.a("degradeUrl", this.b);
                ma3Var.a("appid", k33.K().getAppId());
                ma3Var.a("hostname", sm2.n().a());
                ma3Var.a("_swebfr", ej3.e());
                s93.i("3863", "3863", ma3Var.f());
                if (this.a) {
                    ef3 ef3Var = new ef3();
                    ef3Var.k(1L);
                    ef3Var.i(2108L);
                    if3.a().f(ef3Var);
                    ma3 ma3Var2 = new ma3();
                    ma3Var2.p(ef3Var);
                    ma3Var2.r(k33.K().q().W());
                    ma3Var2.q(ea3.n(k33.K().k()));
                    ma3Var2.m(k33.K().getAppId());
                    ea3.R(ma3Var2);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ma3 a;
        public final /* synthetic */ long b;
        public final /* synthetic */ Exception c;

        public m(ma3 ma3Var, long j, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ma3Var, Long.valueOf(j), exc};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ma3Var;
            this.b = j;
            this.c = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (TextUtils.isEmpty(this.a.g())) {
                    this.a.k(k33.K().q().W().V());
                }
                JSONObject f = this.a.f();
                l02.e("SwanAppUBCStatistic", "671", "稳定性打点 since=" + zf3.e(new Date(this.b), "yyyy-MM-dd HH:mm:ss.SSS") + " event=" + f, this.c, false);
                s93.k("671", f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ na3 a;
        public final /* synthetic */ String b;

        public n(na3 na3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {na3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = na3Var;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSONObject f = this.a.f();
                s93.k(this.b, f);
                if (GameCenterCoreUtils.REF_TYPE_FROM_GAMECENTER.equals(this.b)) {
                    ca3.a().b(f.toString());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ na3 c;

        public o(String str, String str2, na3 na3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, na3Var};
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
            this.c = na3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                s93.i(this.a, this.b, this.c.f());
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ka3 a;

        public p(ka3 ka3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ka3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ka3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                s93.k("751", this.a.f());
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ka3 a;

        public q(ka3 ka3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ka3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ka3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                s93.k("751", this.a.f());
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ka3 a;

        public r(ka3 ka3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ka3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ka3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                s93.k("751", this.a.f());
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class s implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ka3 a;

        public s(ka3 ka3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ka3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ka3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                s93.k("751", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947727570, "Lcom/baidu/tieba/ea3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947727570, "Lcom/baidu/tieba/ea3;");
                return;
            }
        }
        a = vj1.a;
        b = Executors.newSingleThreadExecutor();
        c = new Object();
        d = Sets.newHashSet("hmma.baidu.com");
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        e = copyOnWriteArrayList;
        copyOnWriteArrayList.add("https://hmma.baidu.com/mini.gif");
        e.add("https://dxp.baidu.com/mini");
        CopyOnWriteArrayList<String> copyOnWriteArrayList2 = e;
        copyOnWriteArrayList2.add(f02.c() + "/smtapp/recordhandler/getrecordinfo");
        CopyOnWriteArrayList<String> copyOnWriteArrayList3 = e;
        copyOnWriteArrayList3.add(f02.b() + "/smtapp/recordhandler/getrecordinfo");
    }

    public static void A(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, null, str, i2) == null) {
            t(0, str, i2, null, null, null, "0");
        }
    }

    public static void B(String str, int i2, NetworkStatRecord networkStatRecord) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65538, null, str, i2, networkStatRecord) == null) {
            C(str, i2, networkStatRecord, 0L, 0L, "");
        }
    }

    public static void C(String str, int i2, NetworkStatRecord networkStatRecord, long j2, long j3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{str, Integer.valueOf(i2), networkStatRecord, Long.valueOf(j2), Long.valueOf(j3), str2}) == null) {
            M(0, str, i2, null, null, null, "0", j2, j3, networkStatRecord, str2);
        }
    }

    public static void D(String str, int i2, NetworkStatRecord networkStatRecord, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i2, networkStatRecord, str2) == null) {
            C(str, i2, networkStatRecord, 0L, 0L, str2);
        }
    }

    public static void E() {
        io2.a W;
        Bundle P;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65541, null) == null) || !k33.K().E() || (P = (W = k33.K().q().W()).P()) == null || P.getLong("launch_flag_for_statistic") <= 0) {
            return;
        }
        long l2 = W.l("launch_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        oa3 oa3Var = new oa3();
        oa3Var.a = n(k33.K().k());
        oa3Var.f = W.H();
        if (kz2.F(W.g0())) {
            oa3Var.c = "remote-debug";
        } else if (kz2.D()) {
            oa3Var.c = "local-debug";
        } else {
            oa3Var.c = W.T();
        }
        oa3Var.b = "launch";
        oa3Var.e = "success";
        oa3Var.r = String.valueOf(currentTimeMillis - l2);
        oa3Var.a("status", "0");
        v93.n(oa3Var, W.W(), W.s0().getString(UBCCloudControlProcessor.UBC_KEY));
        P.putLong("launch_flag_for_statistic", 0L);
        HybridUbcFlow d2 = qw2.d("startup");
        if (d2 != null) {
            if (d2.w() || d2.t()) {
                return;
            }
            d2.E("value", "na_success");
        }
    }

    public static void F(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65542, null, z, str) == null) {
            na3 na3Var = new na3();
            if (k33.K().q().I()) {
                na3Var.d(k33.K().q().W().s0().getString(UBCCloudControlProcessor.UBC_KEY));
            }
            na3Var.b = "show";
            na3Var.c = str;
            na3Var.e = z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0;
            na3Var.f = l33.g0();
            ex2.e().d(new a(na3Var), "SwanAppUBCOnPagesRoute", true);
        }
    }

    public static void G(String str, String str2, List<String> list) {
        int i2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, str2, list) == null) {
            if (k33.K().q().I()) {
                io2.a W = k33.K().q().W();
                i2 = W.G();
                str3 = W.s0().getString(UBCCloudControlProcessor.UBC_KEY);
            } else {
                i2 = 0;
                str3 = "";
            }
            ka3 ka3Var = new ka3();
            ka3Var.b = TiebaStatic.DQPay.TYPE_VALUE;
            ka3Var.c = str;
            ka3Var.f = l33.g0();
            ka3Var.a = n(i2);
            try {
                JSONObject jSONObject = new JSONObject(str3);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("paymenturl", str2);
                }
                if (list != null) {
                    jSONObject.put("whitelist", list);
                }
                jSONObject.put("appname", l33.M().Z());
                ka3Var.e(jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
                ka3Var.d(str3);
            }
            ka3Var.b(Z());
            fg3.k(new q(ka3Var), "SwanAppUBCOnPay");
        }
    }

    public static void H(boolean z, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
            ka3 ka3Var = new ka3();
            io2.a W = k33.K().q().W();
            if (k33.K().q().I()) {
                ka3Var.d(W.s0().getString(UBCCloudControlProcessor.UBC_KEY));
            }
            ka3Var.b = TiebaStatic.DQPay.TYPE_VALUE;
            ka3Var.e = z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0;
            ka3Var.c = str;
            ka3Var.f = l33.g0();
            ka3Var.a = n(W.G());
            ka3Var.a("money", str2);
            ka3Var.b(Z());
            fg3.j(new p(ka3Var), "SwanAppUBCOnPay");
        }
    }

    public static void I(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65545, null, str, str2, str3, str4) == null) && k33.K().q().I()) {
            io2.a W = k33.K().q().W();
            int G = W.G();
            ka3 ka3Var = new ka3();
            ka3Var.b = "paykey";
            ka3Var.a = n(G);
            ka3Var.c = str;
            ka3Var.e = str4;
            ka3Var.a("appid", W.H());
            ka3Var.a("money", str2);
            ka3Var.a("source", W.T());
            ka3Var.a("pmappkey", str3);
            fg3.k(new s(ka3Var), "SwanAppUBCOnPayChecked");
        }
    }

    public static void J(String str, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            ka3 ka3Var = new ka3();
            io2.a W = k33.K().q().W();
            if (k33.K().q().I()) {
                ka3Var.d(W.s0().getString(UBCCloudControlProcessor.UBC_KEY));
            }
            ka3Var.b = "paylogin";
            ka3Var.c = str;
            ka3Var.f = W.I();
            ka3Var.a = n(W.G());
            ka3Var.e = z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0;
            ka3Var.a("nativeAppId", sm2.n().a());
            ka3Var.a("paylogin", z2 ? "1" : "0");
            t22 H = yo2.U().H();
            mt2 N1 = H == null ? null : H.N1();
            if (N1 != null && !TextUtils.isEmpty(N1.i())) {
                ka3Var.a("page", N1.i());
            }
            ka3Var.b(Z());
            fg3.j(new e(ka3Var), "SwanAppUBCOnPayLogin");
        }
    }

    public static void K(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65547, null, str, str2, i2) == null) && k33.K().q().I()) {
            io2.a W = k33.K().q().W();
            int G = W.G();
            ka3 ka3Var = new ka3();
            ka3Var.b = "payProcess";
            ka3Var.a = n(G);
            ka3Var.c = str;
            ka3Var.a("paymentProcess", str2);
            ka3Var.a("appid", W.H());
            ka3Var.a("source", W.T());
            if (W.j0() != null) {
                ka3Var.a("swan", W.j0().swanCoreVersionName);
            }
            if (TextUtils.equals(TiebaStatic.LogFields.RESULT, str2)) {
                if (i2 == 0) {
                    ka3Var.a("payResultStatus", "success");
                } else if (i2 != 2) {
                    ka3Var.a("payResultStatus", com.baidu.pass.biometrics.face.liveness.b.a.g0);
                } else {
                    ka3Var.a("payResultStatus", "cancel");
                }
            }
            ka3Var.b(Z());
            fg3.k(new r(ka3Var), "SwanAppUBCOnPayProcess");
        }
    }

    public static void L(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, str2) == null) {
            oa3 oa3Var = new oa3();
            oa3Var.b = "launch";
            oa3Var.e = str;
            if (l33.b0() != null) {
                io2.a W = l33.b0().W();
                oa3Var.a = n(W.G());
                oa3Var.f = W.H();
                oa3Var.c = W.T();
            }
            oa3Var.t = str2;
            onEvent(oa3Var);
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
                    s93.i("1415", "66", jSONObject);
                }
            }
        }
    }

    public static void O(int i2, String str, int i3, String str2, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65551, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            Q(i2, str, i3, str2, null, null, j2, j3, "");
        }
    }

    public static void P(int i2, String str, int i3, String str2, long j2, long j3, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, Long.valueOf(j2), Long.valueOf(j3), str3}) == null) {
            Q(i2, str, i3, str2, null, null, j2, j3, str3);
        }
    }

    public static void Q(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, long j2, long j3, @NonNull String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65553, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, Long.valueOf(j2), Long.valueOf(j3), str5}) == null) {
            M(i2, str, i3, str2, str3, str4, "1", j2, j3, null, str5);
        }
    }

    public static void R(ma3 ma3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65554, null, ma3Var) == null) || ma3Var == null) {
            return;
        }
        fg3.j(new m(ma3Var, System.currentTimeMillis(), new Exception("stack")), "SwanAppUBCStability");
    }

    public static void S(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65555, null, str, i2, str2) == null) {
            b.execute(new g(str, str2, i2, TextUtils.equals(str, com.baidu.pass.biometrics.face.liveness.b.a.g0) ? new Exception("stack") : null));
        }
    }

    public static void T(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65556, null, str, str2) == null) {
            U(str, str2, null);
        }
    }

    public static void U(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65557, null, str, str2, str3) == null) {
            boolean equals = TextUtils.equals(str2, "cancel");
            boolean equals2 = TextUtils.equals(str2, com.baidu.pass.biometrics.face.liveness.b.a.g0);
            b.execute(new h(str2, str, str3, equals, (equals || equals2) ? new Exception("stack") : null, equals2));
        }
    }

    public static void V(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65558, null, z, str) == null) {
            b.execute(new l(z, str));
        }
    }

    public static void W(String str, String str2) {
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65559, null, str, str2) == null) {
            na3 na3Var = new na3();
            l33 b0 = l33.b0();
            String str5 = "";
            if (b0 != null) {
                str5 = n(b0.k());
                str4 = b0.O();
                str3 = b0.W().T();
            } else {
                str3 = "";
                str4 = str3;
            }
            na3Var.a = str5;
            na3Var.b = AlbumActivityConfig.FROM_WEB_VIEW;
            na3Var.c = str3;
            na3Var.a("appkey", str4);
            na3Var.a("url", str);
            na3Var.a("browser", str2);
            y("3320", "96", na3Var);
            if (a) {
                Log.d("SwanAppUBCStatistic", "onWebViewHistoryChange: " + String.format("ubcId=%s && ceresId=%s , content:%s ", "3320", "96", na3Var.f()));
            }
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

    public static void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65561, null) == null) {
            k33 K = k33.K();
            l33 q2 = K.q();
            io2.a W = q2.W();
            if (K.E() && q2.s0()) {
                Bundle s0 = W.s0();
                if (s0.getLong("launch_flag_for_statistic") > 0) {
                    String valueOf = String.valueOf(System.currentTimeMillis() - q2.W().u1());
                    oa3 oa3Var = new oa3();
                    oa3Var.a = n(W.G());
                    oa3Var.b = "launch";
                    oa3Var.e = "cancel";
                    oa3Var.q = valueOf;
                    oa3Var.j(W);
                    oa3Var.d(s0.getString(UBCCloudControlProcessor.UBC_KEY));
                    oa3Var.b(k(W.W()));
                    onEvent(oa3Var);
                    oa3 oa3Var2 = new oa3();
                    oa3Var2.a = n(W.G());
                    oa3Var2.b = "launch";
                    oa3Var2.e = "realcancel";
                    oa3Var2.q = valueOf;
                    oa3Var2.j(W);
                    oa3Var2.b(k(W.W()));
                    oa3Var2.a("reason", "cancel");
                    if (W.G() == 1) {
                        oa3Var.a("errorList", tm2.j().a());
                    }
                    oa3Var2.d(s0.getString(UBCCloudControlProcessor.UBC_KEY));
                    onEvent(oa3Var2);
                    s0.remove("launch_flag_for_statistic");
                }
            }
        }
    }

    public static JSONObject Z() {
        InterceptResult invokeV;
        io2.a Y;
        JSONObject M;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            l33 M2 = l33.M();
            if (M2 == null || (Y = M2.Y()) == null || (M = Y.M()) == null || !TextUtils.equals(M.optString("token"), "swanubc")) {
                return null;
            }
            return M;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static void a0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65564, null, i2) == null) {
            b.execute(new j(i2));
        }
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tieba.ea3.j.run():void] */
    public static /* synthetic */ boolean b() {
        return a;
    }

    public static r93 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65566, null, str)) == null) ? s93.a(str) : (r93) invokeL.objValue;
    }

    public static void d(oa3 oa3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65567, null, oa3Var) == null) || oa3Var == null || l33.M() == null || l33.M().Y() == null) {
            return;
        }
        io2.a Y = l33.M().Y();
        oa3Var.a = n(Y.G());
        oa3Var.f = Y.H();
        oa3Var.a("appkey", Y.I());
        x("1032", oa3Var);
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65568, null, str) == null) {
            na3 na3Var = new na3();
            na3Var.a = n(0);
            na3Var.b = str;
            x("956", na3Var);
        }
    }

    public static void f(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65569, null, str, str2, str3) == null) {
            na3 na3Var = new na3();
            if (l33.M() != null && l33.M().Y() != null) {
                io2.a Y = l33.M().Y();
                na3Var.a = n(Y.G());
                na3Var.f = Y.H();
                na3Var.b = str;
                na3Var.c = str2;
                na3Var.e = str3;
                na3Var.a("appkey", Y.I());
            }
            x("923", na3Var);
        }
    }

    public static void g(na3 na3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65570, null, na3Var) == null) {
            if (l33.M() != null && l33.M().Y() != null) {
                io2.a Y = l33.M().Y();
                na3Var.a = n(Y.G());
                na3Var.f = Y.H();
                na3Var.c = Y.T();
            }
            x("936", na3Var);
        }
    }

    public static void h(na3 na3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65571, null, na3Var) == null) {
            if (l33.M() != null && l33.M().Y() != null) {
                io2.a Y = l33.M().Y();
                na3Var.a = n(Y.G());
                na3Var.f = Y.H();
                na3Var.c = Y.T();
            }
            x("914", na3Var);
        }
    }

    public static void i(r93 r93Var, na3 na3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65572, null, r93Var, na3Var) == null) || r93Var == null) {
            return;
        }
        fg3.j(new k(na3Var, r93Var), "SwanAppUBCEndFlow");
    }

    @WorkerThread
    public static void j(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5, long j2, long j3, @Nullable NetworkStatRecord networkStatRecord) {
        la3 la3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65573, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, str5, Long.valueOf(j2), Long.valueOf(j3), networkStatRecord}) == null) {
            int c2 = yu2.c();
            if (a) {
                Log.d("SwanAppUBCStatistic", "get NetworkQuality: " + c2);
            }
            if (TextUtils.equals(str5, "1")) {
                la3Var = new la3(i2, str, str2, c2, j2, j3);
            } else {
                la3Var = new la3(str, c2, j2, j3);
            }
            ha3.a aVar = new ha3.a(la3Var, "request");
            if (!TextUtils.isEmpty(str3)) {
                la3Var.r(str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                la3Var.q(str4);
            }
            la3Var.b = "request";
            l33 q2 = k33.K().q();
            if (q2 != null && q2.I()) {
                la3Var.c = q2.W().T();
                la3Var.d = q2.W().V();
            }
            la3Var.f = l33.g0();
            la3Var.a = n(i3);
            JSONObject X = X(networkStatRecord);
            aVar.b = X;
            if (X != null) {
                la3Var.e(X);
            }
            if (a) {
                Log.d("SwanAppUBCStatistic", "Reporting: " + la3Var.f());
            }
            JSONObject f2 = la3Var.f();
            if (la3Var.o()) {
                l02.j("SwanAppUBCStatistic", "834", "网络请求成功打点 event=" + f2, false);
            } else {
                l02.e("SwanAppUBCStatistic", "834", "网络请求失败打点 event=" + f2, null, false);
            }
            s93.k("834", f2);
            N(la3Var.m(), la3Var.n(), f2);
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

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) ? yt2.g() ? "1" : "0" : (String) invokeV.objValue;
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

    public static String n(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65577, null, i2)) == null) ? i2 != 1 ? "swan" : SwanFavorItemData.SCHEME_AUTHORITY_SWAN_GAME : (String) invokeI.objValue;
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

    public static void onEvent(oa3 oa3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65579, null, oa3Var) == null) {
            ExtensionCore T = fa2.U().T();
            if (T != null) {
                oa3Var.a("extension_ver", T.extensionCoreVersionName);
            }
            oa3Var.a("isReloadApp", k33.K().q().W().d("launch_by_reload") ? "1" : "0");
            JSONObject jSONObject = new JSONObject();
            lg3.f(jSONObject, "static", Float.valueOf(sm2.m().a()));
            oa3Var.a("device_score", jSONObject.toString());
            x(GameCenterCoreUtils.REF_TYPE_FROM_GAMECENTER, oa3Var);
        }
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

    public static void q(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65581, null, str, str2, z) == null) {
            na3 na3Var = new na3();
            na3Var.b = str;
            na3Var.e = str2;
            na3Var.f = l33.g0();
            if (l33.M() != null && l33.M().Y() != null) {
                io2.a Y = l33.M().Y();
                na3Var.c = Y.T();
                na3Var.a = n(Y.G());
            }
            if (TextUtils.equals("click", str)) {
                na3Var.a("authorize", z ? "success" : com.baidu.pass.biometrics.face.liveness.b.a.g0);
            }
            fg3.k(new d(na3Var), "SwanAppUBCOnAuthDialog");
        }
    }

    public static void r(int i2, l83 l83Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65582, null, i2, l83Var) == null) {
            l33 b0 = l33.b0();
            if (b0 == null) {
                if (a) {
                    Log.e("SwanAppUBCStatistic", "onAuthorizeFailed-swanApp is null");
                    return;
                }
                return;
            }
            ma3 ma3Var = new ma3();
            ma3Var.o(i2);
            ma3Var.r(b0.Y());
            ma3Var.q(n(b0.k()));
            ma3Var.m(b0.getAppId());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", b0.getAppId());
                jSONObject.put("msg", j83.f(i2));
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, b0.e0().q("cur_request_id", ""));
                if (l83Var != null) {
                    jSONObject.put("scope", l83Var.b);
                    jSONObject.put("scopeData", l83Var.a);
                }
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
            ma3Var.e(jSONObject);
            R(ma3Var);
        }
    }

    public static void s(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65583, null, str, str2, str3) == null) {
            b.execute(new i(str, str2, str3));
        }
    }

    @WorkerThread
    public static void t(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65584, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, str5}) == null) || i2 == 200) {
            return;
        }
        b.execute(new c(str5, i2, str, str2, str3, str4, i3));
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

    public static void w(ForbiddenInfo forbiddenInfo, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65587, null, forbiddenInfo, str) == null) || forbiddenInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        b.execute(new f(str, forbiddenInfo));
    }

    public static void x(String str, na3 na3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65588, null, str, na3Var) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        ex2.e().d(new n(na3Var, str), "SwanAppUBCOnEvent", true);
    }

    public static void y(String str, String str2, na3 na3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65589, null, str, str2, na3Var) == null) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        fg3.j(new o(str, str2, na3Var), "SwanAppUbcCeresOnEvent");
    }

    public static void z(String str, int i2, String str2) {
        l33 b0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(65590, null, str, i2, str2) == null) || (b0 = l33.b0()) == null) {
            return;
        }
        ef3 ef3Var = new ef3();
        ef3Var.k(5L);
        ef3Var.i(50L);
        ma3 ma3Var = new ma3();
        ma3Var.p(ef3Var);
        ma3Var.r(b0.W());
        ma3Var.q(n(b0.k()));
        ma3Var.m(b0.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", b0.getAppId());
            jSONObject.put("url", str);
            jSONObject.put("errcode", i2);
            jSONObject.put("msg", str2);
        } catch (JSONException e2) {
            if (a) {
                e2.printStackTrace();
            }
        }
        ma3Var.e(jSONObject);
        R(ma3Var);
    }
}
