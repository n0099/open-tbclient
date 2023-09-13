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
import com.baidu.tieba.di3;
import com.baidu.tieba.ew2;
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
public final class ai3 {
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
        public final /* synthetic */ ji3 a;

        public a(ji3 ji3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ji3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ji3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b(ai3.a());
                oh3.k("778", this.a.f());
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
            if (ai3.o(this.a)) {
                if (ai3.a) {
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
                        yb2.d().e(xb2.c(this.a, this.c, this.b, this.d, this.g));
                    } else {
                        yb2.d().e(xb2.a(this.a, this.c, this.b, this.d, this.g));
                    }
                } else if (TextUtils.equals(this.f, "0")) {
                    yb2.d().e(xb2.b(this.a, this.c, this.g));
                }
            }
            if (z && j < 5000) {
                if (ai3.a) {
                    Log.d("SwanAppUBCStatistic", "code 200 & cost(" + (this.b - this.c) + ") is ok, don't report");
                    return;
                }
                return;
            }
            ai3.j(this.d, this.a, this.e, this.h, this.i, this.j, this.f, this.c, this.b, this.k);
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
            hi3 hi3Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int c = u23.c();
                if (ai3.a) {
                    Log.d("SwanAppUBCStatistic", "get NetworkQuality: " + c);
                }
                if (TextUtils.equals(this.a, "1")) {
                    hi3Var = new hi3(this.b, this.c, this.d, c);
                } else {
                    hi3Var = new hi3(this.c, c, 0L, 0L);
                }
                new di3.a(hi3Var, "downloadFile");
                if (!TextUtils.isEmpty(this.e)) {
                    hi3Var.r(this.e);
                }
                if (!TextUtils.isEmpty(this.f)) {
                    hi3Var.q(this.f);
                }
                hi3Var.b = "downloadFile";
                if (hb3.M() != null && hb3.M().Y() != null) {
                    hi3Var.c = hb3.M().Y().T();
                }
                hi3Var.f = hb3.g0();
                hi3Var.a = ai3.n(this.g);
                JSONObject f = hi3Var.f();
                oh3.k("834", f);
                h82.k("SwanAppUBCStatistic", "834-downloadFile event=" + f.toString());
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ji3 a;

        public d(ji3 ji3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ji3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ji3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                oh3.k("894", this.a.f());
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gi3 a;

        public e(gi3 gi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gi3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gi3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                oh3.k("751", this.a.f());
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
                ii3 ii3Var = new ii3();
                ii3Var.e = this.a;
                ii3Var.b = "show";
                ii3Var.a = "swan";
                ForbiddenInfo forbiddenInfo = this.b;
                ii3Var.c = forbiddenInfo.launchSource;
                ii3Var.a("path", forbiddenInfo.launchPath);
                ii3Var.a("appkey", this.b.appId);
                oh3.m("1400", ii3Var.f());
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
            hb3 b0;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (b0 = hb3.b0()) == null) {
                return;
            }
            ew2.a W = b0.W();
            String Z = b0.Z();
            String appId = b0.getAppId();
            ii3 ii3Var = new ii3();
            ii3Var.b = "login";
            ii3Var.a = ai3.n(W.G());
            ii3Var.f = appId;
            ii3Var.e = this.a;
            ii3Var.a("appName", Z);
            ii3Var.a("invokeFrom", this.b);
            ii3Var.a("scene", Integer.valueOf(this.c));
            JSONObject f = ii3Var.f();
            if (TextUtils.equals(this.a, "show")) {
                h82.j("SwanAppUBCStatistic", "1936", "登录展示 event=" + f, false);
                oh3.i("1936", "80", f);
            } else if (TextUtils.equals(this.a, "success")) {
                h82.j("SwanAppUBCStatistic", "1936", "登录成功 event=" + f, false);
                oh3.i("1936", "81", f);
            } else if (TextUtils.equals(this.a, "fail") || TextUtils.equals(this.a, "check_fail")) {
                h82.e("SwanAppUBCStatistic", "1936", "登录失败 event=" + f, this.d, false);
                oh3.i("1936", "82", f);
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
                hb3 q = gb3.K().q();
                ew2.a W = q.W();
                String Z = q.Z();
                String appId = q.getAppId();
                ii3 ii3Var = new ii3();
                ii3Var.b = "swanLogin";
                ii3Var.a = ai3.n(W.G());
                ii3Var.f = appId;
                ii3Var.e = this.a;
                ii3Var.a("appName", Z);
                ii3Var.a("loginScene", this.b);
                String str = this.c;
                if (str != null) {
                    ii3Var.a("errorInfo", str);
                }
                JSONObject f = ii3Var.f();
                if (this.d) {
                    h82.p("SwanAppUBCStatistic", "1936", "登录取消打点 event=" + f, this.e, false);
                } else if (this.f) {
                    h82.e("SwanAppUBCStatistic", "1936", "登录失败打点 event=" + f, this.e, false);
                } else {
                    h82.j("SwanAppUBCStatistic", "1936", "登录数据打点 event=" + f, false);
                }
                oh3.i("1936", "1936", f);
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
                ji3 ji3Var = new ji3();
                ji3Var.a = ai3.n(gb3.K().q().k());
                String str = this.a;
                ji3Var.b = str;
                ji3Var.g = this.b;
                if (TextUtils.equals(str, "click")) {
                    ji3Var.e = this.c;
                }
                ji3Var.f = gb3.K().getAppId();
                ji3Var.a("source", gb3.K().q().W().T());
                ji3Var.a("mode", "normal");
                ji3Var.a("from", "login");
                JSONObject f = ji3Var.f();
                if (ai3.a) {
                    Log.d("SwanAppUBCStatistic", "staticLoginResult: event = " + f);
                }
                oh3.k("1936", f);
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
                synchronized (ai3.c) {
                    try {
                        ai3.c.wait(this.a);
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ji3 a;
        public final /* synthetic */ nh3 b;

        public k(ji3 ji3Var, nh3 nh3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ji3Var, nh3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ji3Var;
            this.b = nh3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ji3 ji3Var = this.a;
                if (ji3Var != null) {
                    oh3.f(this.b, ji3Var.f().toString());
                }
                oh3.c(this.b);
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
                ii3 ii3Var = new ii3();
                ii3Var.a = ai3.n(gb3.K().q().k());
                ii3Var.f = gb3.K().getAppId();
                if (this.a) {
                    i = 1;
                } else {
                    i = 2;
                }
                ii3Var.a("type", Integer.valueOf(i));
                ii3Var.a(CloudStabilityUBCUtils.KEY_ERROR_CODE, Long.valueOf(zq3.c().g()));
                ii3Var.a("degradeUrl", this.b);
                ii3Var.a("appid", gb3.K().getAppId());
                ii3Var.a("hostname", ou2.n().a());
                ii3Var.a("_swebfr", ar3.e());
                oh3.i("3863", "3863", ii3Var.f());
                if (this.a) {
                    an3 an3Var = new an3();
                    an3Var.k(1L);
                    an3Var.i(2108L);
                    en3.a().f(an3Var);
                    ii3 ii3Var2 = new ii3();
                    ii3Var2.p(an3Var);
                    ii3Var2.r(gb3.K().q().W());
                    ii3Var2.q(ai3.n(gb3.K().k()));
                    ii3Var2.m(gb3.K().getAppId());
                    ai3.R(ii3Var2);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ii3 a;
        public final /* synthetic */ long b;
        public final /* synthetic */ Exception c;

        public m(ii3 ii3Var, long j, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ii3Var, Long.valueOf(j), exc};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ii3Var;
            this.b = j;
            this.c = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (TextUtils.isEmpty(this.a.g())) {
                    this.a.k(gb3.K().q().W().V());
                }
                JSONObject f = this.a.f();
                h82.e("SwanAppUBCStatistic", "671", "稳定性打点 since=" + vn3.e(new Date(this.b), "yyyy-MM-dd HH:mm:ss.SSS") + " event=" + f, this.c, false);
                oh3.k("671", f);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ji3 a;
        public final /* synthetic */ String b;

        public n(ji3 ji3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ji3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ji3Var;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSONObject f = this.a.f();
                oh3.k(this.b, f);
                if (GameCenterCoreUtils.REF_TYPE_FROM_GAMECENTER.equals(this.b)) {
                    yh3.a().b(f.toString());
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
        public final /* synthetic */ ji3 c;

        public o(String str, String str2, ji3 ji3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, ji3Var};
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
            this.c = ji3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                oh3.i(this.a, this.b, this.c.f());
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gi3 a;

        public p(gi3 gi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gi3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gi3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                oh3.k("751", this.a.f());
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gi3 a;

        public q(gi3 gi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gi3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gi3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                oh3.k("751", this.a.f());
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gi3 a;

        public r(gi3 gi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gi3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gi3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                oh3.k("751", this.a.f());
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class s implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gi3 a;

        public s(gi3 gi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gi3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gi3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                oh3.k("751", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947616094, "Lcom/baidu/tieba/ai3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947616094, "Lcom/baidu/tieba/ai3;");
                return;
            }
        }
        a = rr1.a;
        b = Executors.newSingleThreadExecutor();
        c = new Object();
        d = Sets.newHashSet("hmma.baidu.com");
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        e = copyOnWriteArrayList;
        copyOnWriteArrayList.add("https://hmma.baidu.com/mini.gif");
        e.add("https://dxp.baidu.com/mini");
        CopyOnWriteArrayList<String> copyOnWriteArrayList2 = e;
        copyOnWriteArrayList2.add(b82.c() + "/smtapp/recordhandler/getrecordinfo");
        CopyOnWriteArrayList<String> copyOnWriteArrayList3 = e;
        copyOnWriteArrayList3.add(b82.b() + "/smtapp/recordhandler/getrecordinfo");
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

    public static void i(nh3 nh3Var, ji3 ji3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65572, null, nh3Var, ji3Var) != null) || nh3Var == null) {
            return;
        }
        bo3.j(new k(ji3Var, nh3Var), "SwanAppUBCEndFlow");
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

    public static void x(String str, ji3 ji3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65588, null, str, ji3Var) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        a53.e().d(new n(ji3Var, str), "SwanAppUBCOnEvent", true);
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

    public static void y(String str, String str2, ji3 ji3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65589, null, str, str2, ji3Var) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            bo3.j(new o(str, str2, ji3Var), "SwanAppUbcCeresOnEvent");
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
        ew2.a W;
        Bundle P;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, null) == null) && gb3.K().E() && (P = (W = gb3.K().q().W()).P()) != null && P.getLong("launch_flag_for_statistic") > 0) {
            long l2 = W.l("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            ki3 ki3Var = new ki3();
            ki3Var.a = n(gb3.K().k());
            ki3Var.f = W.H();
            if (g73.F(W.g0())) {
                ki3Var.c = "remote-debug";
            } else if (g73.D()) {
                ki3Var.c = "local-debug";
            } else {
                ki3Var.c = W.T();
            }
            ki3Var.b = "launch";
            ki3Var.e = "success";
            ki3Var.r = String.valueOf(currentTimeMillis - l2);
            ki3Var.a("status", "0");
            rh3.n(ki3Var, W.W(), W.s0().getString("ubc"));
            P.putLong("launch_flag_for_statistic", 0L);
            HybridUbcFlow d2 = m43.d("startup");
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
            gb3 K = gb3.K();
            hb3 q2 = K.q();
            ew2.a W = q2.W();
            if (K.E() && q2.s0()) {
                Bundle s0 = W.s0();
                if (s0.getLong("launch_flag_for_statistic") > 0) {
                    String valueOf = String.valueOf(System.currentTimeMillis() - q2.W().u1());
                    ki3 ki3Var = new ki3();
                    ki3Var.a = n(W.G());
                    ki3Var.b = "launch";
                    ki3Var.e = "cancel";
                    ki3Var.q = valueOf;
                    ki3Var.j(W);
                    ki3Var.d(s0.getString("ubc"));
                    ki3Var.b(k(W.W()));
                    onEvent(ki3Var);
                    ki3 ki3Var2 = new ki3();
                    ki3Var2.a = n(W.G());
                    ki3Var2.b = "launch";
                    ki3Var2.e = "realcancel";
                    ki3Var2.q = valueOf;
                    ki3Var2.j(W);
                    ki3Var2.b(k(W.W()));
                    ki3Var2.a("reason", "cancel");
                    if (W.G() == 1) {
                        ki3Var.a("errorList", pu2.j().a());
                    }
                    ki3Var2.d(s0.getString("ubc"));
                    onEvent(ki3Var2);
                    s0.remove("launch_flag_for_statistic");
                }
            }
        }
    }

    public static void F(boolean z, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65542, null, z, str) == null) {
            ji3 ji3Var = new ji3();
            if (gb3.K().q().I()) {
                ji3Var.d(gb3.K().q().W().s0().getString("ubc"));
            }
            ji3Var.b = "show";
            ji3Var.c = str;
            if (z) {
                str2 = "success";
            } else {
                str2 = "fail";
            }
            ji3Var.e = str2;
            ji3Var.f = hb3.g0();
            a53.e().d(new a(ji3Var), "SwanAppUBCOnPagesRoute", true);
        }
    }

    public static void G(String str, String str2, List<String> list) {
        int i2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, str2, list) == null) {
            if (gb3.K().q().I()) {
                ew2.a W = gb3.K().q().W();
                i2 = W.G();
                str3 = W.s0().getString("ubc");
            } else {
                i2 = 0;
                str3 = "";
            }
            gi3 gi3Var = new gi3();
            gi3Var.b = Logger.PAY_TYPE;
            gi3Var.c = str;
            gi3Var.f = hb3.g0();
            gi3Var.a = n(i2);
            try {
                JSONObject jSONObject = new JSONObject(str3);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("paymenturl", str2);
                }
                if (list != null) {
                    jSONObject.put("whitelist", list);
                }
                jSONObject.put("appname", hb3.M().Z());
                gi3Var.e(jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
                gi3Var.d(str3);
            }
            gi3Var.b(Z());
            bo3.k(new q(gi3Var), "SwanAppUBCOnPay");
        }
    }

    public static void H(boolean z, String str, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
            gi3 gi3Var = new gi3();
            ew2.a W = gb3.K().q().W();
            if (gb3.K().q().I()) {
                gi3Var.d(W.s0().getString("ubc"));
            }
            gi3Var.b = Logger.PAY_TYPE;
            if (z) {
                str3 = "success";
            } else {
                str3 = "fail";
            }
            gi3Var.e = str3;
            gi3Var.c = str;
            gi3Var.f = hb3.g0();
            gi3Var.a = n(W.G());
            gi3Var.a("money", str2);
            gi3Var.b(Z());
            bo3.j(new p(gi3Var), "SwanAppUBCOnPay");
        }
    }

    public static void q(String str, String str2, boolean z) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65581, null, str, str2, z) == null) {
            ji3 ji3Var = new ji3();
            ji3Var.b = str;
            ji3Var.e = str2;
            ji3Var.f = hb3.g0();
            if (hb3.M() != null && hb3.M().Y() != null) {
                ew2.a Y = hb3.M().Y();
                ji3Var.c = Y.T();
                ji3Var.a = n(Y.G());
            }
            if (TextUtils.equals("click", str)) {
                if (z) {
                    str3 = "success";
                } else {
                    str3 = "fail";
                }
                ji3Var.a("authorize", str3);
            }
            bo3.k(new d(ji3Var), "SwanAppUBCOnAuthDialog");
        }
    }

    public static void z(String str, int i2, String str2) {
        hb3 b0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(65590, null, str, i2, str2) != null) || (b0 = hb3.b0()) == null) {
            return;
        }
        an3 an3Var = new an3();
        an3Var.k(5L);
        an3Var.i(50L);
        ii3 ii3Var = new ii3();
        ii3Var.p(an3Var);
        ii3Var.r(b0.W());
        ii3Var.q(n(b0.k()));
        ii3Var.m(b0.getAppId());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", b0.getAppId());
            jSONObject.put("url", str);
            jSONObject.put(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, i2);
            jSONObject.put("msg", str2);
        } catch (JSONException e2) {
            if (a) {
                e2.printStackTrace();
            }
        }
        ii3Var.e(jSONObject);
        R(ii3Var);
    }

    public static void I(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65545, null, str, str2, str3, str4) == null) && gb3.K().q().I()) {
            ew2.a W = gb3.K().q().W();
            int G = W.G();
            gi3 gi3Var = new gi3();
            gi3Var.b = "paykey";
            gi3Var.a = n(G);
            gi3Var.c = str;
            gi3Var.e = str4;
            gi3Var.a("appid", W.H());
            gi3Var.a("money", str2);
            gi3Var.a("source", W.T());
            gi3Var.a("pmappkey", str3);
            bo3.k(new s(gi3Var), "SwanAppUBCOnPayChecked");
        }
    }

    public static void J(String str, boolean z, boolean z2) {
        String str2;
        String str3;
        i13 O1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            gi3 gi3Var = new gi3();
            ew2.a W = gb3.K().q().W();
            if (gb3.K().q().I()) {
                gi3Var.d(W.s0().getString("ubc"));
            }
            gi3Var.b = "paylogin";
            gi3Var.c = str;
            gi3Var.f = W.I();
            gi3Var.a = n(W.G());
            if (z) {
                str2 = "success";
            } else {
                str2 = "fail";
            }
            gi3Var.e = str2;
            gi3Var.a("nativeAppId", ou2.n().a());
            if (z2) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            gi3Var.a("paylogin", str3);
            pa2 H = uw2.T().H();
            if (H == null) {
                O1 = null;
            } else {
                O1 = H.O1();
            }
            if (O1 != null && !TextUtils.isEmpty(O1.i())) {
                gi3Var.a("page", O1.i());
            }
            gi3Var.b(Z());
            bo3.j(new e(gi3Var), "SwanAppUBCOnPayLogin");
        }
    }

    public static void K(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65547, null, str, str2, i2) == null) && gb3.K().q().I()) {
            ew2.a W = gb3.K().q().W();
            int G = W.G();
            gi3 gi3Var = new gi3();
            gi3Var.b = "payProcess";
            gi3Var.a = n(G);
            gi3Var.c = str;
            gi3Var.a("paymentProcess", str2);
            gi3Var.a("appid", W.H());
            gi3Var.a("source", W.T());
            if (W.j0() != null) {
                gi3Var.a("swan", W.j0().swanCoreVersionName);
            }
            if (TextUtils.equals("result", str2)) {
                if (i2 != 0) {
                    if (i2 != 2) {
                        gi3Var.a("payResultStatus", "fail");
                    } else {
                        gi3Var.a("payResultStatus", "cancel");
                    }
                } else {
                    gi3Var.a("payResultStatus", "success");
                }
            }
            gi3Var.b(Z());
            bo3.k(new r(gi3Var), "SwanAppUBCOnPayProcess");
        }
    }

    public static void L(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, str2) == null) {
            ki3 ki3Var = new ki3();
            ki3Var.b = "launch";
            ki3Var.e = str;
            if (hb3.b0() != null) {
                ew2.a W = hb3.b0().W();
                ki3Var.a = n(W.G());
                ki3Var.f = W.H();
                ki3Var.c = W.T();
            }
            ki3Var.t = str2;
            onEvent(ki3Var);
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
                    oh3.i("1415", PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_SHOW, jSONObject);
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

    public static void R(ii3 ii3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65554, null, ii3Var) != null) || ii3Var == null) {
            return;
        }
        bo3.j(new m(ii3Var, System.currentTimeMillis(), new Exception("stack")), "SwanAppUBCStability");
    }

    public static void a0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65564, null, i2) == null) {
            b.execute(new j(i2));
        }
    }

    public static nh3 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, str)) == null) {
            return oh3.a(str);
        }
        return (nh3) invokeL.objValue;
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65568, null, str) == null) {
            ji3 ji3Var = new ji3();
            ji3Var.a = n(0);
            ji3Var.b = str;
            x("956", ji3Var);
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
            ji3 ji3Var = new ji3();
            hb3 b0 = hb3.b0();
            String str5 = "";
            if (b0 == null) {
                str3 = "";
                str4 = str3;
            } else {
                str5 = n(b0.k());
                str4 = b0.O();
                str3 = b0.W().T();
            }
            ji3Var.a = str5;
            ji3Var.b = AlbumActivityConfig.FROM_WEB_VIEW;
            ji3Var.c = str3;
            ji3Var.a("appkey", str4);
            ji3Var.a("url", str);
            ji3Var.a("browser", str2);
            y("3320", "96", ji3Var);
            if (a) {
                Log.d("SwanAppUBCStatistic", "onWebViewHistoryChange: " + String.format("ubcId=%s && ceresId=%s , content:%s ", "3320", "96", ji3Var.f()));
            }
        }
    }

    public static void r(int i2, hg3 hg3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65582, null, i2, hg3Var) == null) {
            hb3 b0 = hb3.b0();
            if (b0 == null) {
                if (a) {
                    Log.e("SwanAppUBCStatistic", "onAuthorizeFailed-swanApp is null");
                    return;
                }
                return;
            }
            ii3 ii3Var = new ii3();
            ii3Var.o(i2);
            ii3Var.r(b0.Y());
            ii3Var.q(n(b0.k()));
            ii3Var.m(b0.getAppId());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", b0.getAppId());
                jSONObject.put("msg", fg3.f(i2));
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, b0.e0().q("cur_request_id", ""));
                if (hg3Var != null) {
                    jSONObject.put("scope", hg3Var.b);
                    jSONObject.put("scopeData", hg3Var.a);
                }
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
            ii3Var.e(jSONObject);
            R(ii3Var);
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

    public static void d(ki3 ki3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65567, null, ki3Var) == null) && ki3Var != null && hb3.M() != null && hb3.M().Y() != null) {
            ew2.a Y = hb3.M().Y();
            ki3Var.a = n(Y.G());
            ki3Var.f = Y.H();
            ki3Var.a("appkey", Y.I());
            x("1032", ki3Var);
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
        ew2.a Y;
        JSONObject M;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            hb3 M2 = hb3.M();
            if (M2 == null || (Y = M2.Y()) == null || (M = Y.M()) == null || !TextUtils.equals(M.optString("token"), "swanubc")) {
                return null;
            }
            return M;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static /* synthetic */ JSONObject a() {
        return Z();
    }

    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tieba.ai3.j.run():void] */
    public static /* synthetic */ boolean b() {
        return a;
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) {
            if (u13.g()) {
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
            ji3 ji3Var = new ji3();
            if (hb3.M() != null && hb3.M().Y() != null) {
                ew2.a Y = hb3.M().Y();
                ji3Var.a = n(Y.G());
                ji3Var.f = Y.H();
                ji3Var.b = str;
                ji3Var.c = str2;
                ji3Var.e = str3;
                ji3Var.a("appkey", Y.I());
            }
            x("923", ji3Var);
        }
    }

    public static void g(ji3 ji3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65570, null, ji3Var) == null) {
            if (hb3.M() != null && hb3.M().Y() != null) {
                ew2.a Y = hb3.M().Y();
                ji3Var.a = n(Y.G());
                ji3Var.f = Y.H();
                ji3Var.c = Y.T();
            }
            x("936", ji3Var);
        }
    }

    public static void h(ji3 ji3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65571, null, ji3Var) == null) {
            if (hb3.M() != null && hb3.M().Y() != null) {
                ew2.a Y = hb3.M().Y();
                ji3Var.a = n(Y.G());
                ji3Var.f = Y.H();
                ji3Var.c = Y.T();
            }
            x("914", ji3Var);
        }
    }

    @WorkerThread
    public static void j(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5, long j2, long j3, @Nullable NetworkStatRecord networkStatRecord) {
        hi3 hi3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65573, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, str5, Long.valueOf(j2), Long.valueOf(j3), networkStatRecord}) == null) {
            int c2 = u23.c();
            if (a) {
                Log.d("SwanAppUBCStatistic", "get NetworkQuality: " + c2);
            }
            if (TextUtils.equals(str5, "1")) {
                hi3Var = new hi3(i2, str, str2, c2, j2, j3);
            } else {
                hi3Var = new hi3(str, c2, j2, j3);
            }
            di3.a aVar = new di3.a(hi3Var, "request");
            if (!TextUtils.isEmpty(str3)) {
                hi3Var.r(str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                hi3Var.q(str4);
            }
            hi3Var.b = "request";
            hb3 q2 = gb3.K().q();
            if (q2 != null && q2.I()) {
                hi3Var.c = q2.W().T();
                hi3Var.d = q2.W().V();
            }
            hi3Var.f = hb3.g0();
            hi3Var.a = n(i3);
            JSONObject X = X(networkStatRecord);
            aVar.b = X;
            if (X != null) {
                hi3Var.e(X);
            }
            if (a) {
                Log.d("SwanAppUBCStatistic", "Reporting: " + hi3Var.f());
            }
            JSONObject f2 = hi3Var.f();
            if (hi3Var.o()) {
                h82.j("SwanAppUBCStatistic", "834", "网络请求成功打点 event=" + f2, false);
            } else {
                h82.e("SwanAppUBCStatistic", "834", "网络请求失败打点 event=" + f2, null, false);
            }
            oh3.k("834", f2);
            N(hi3Var.m(), hi3Var.n(), f2);
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

    public static void onEvent(ki3 ki3Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65579, null, ki3Var) == null) {
            ExtensionCore T2 = bi2.U().T();
            if (T2 != null) {
                ki3Var.a("extension_ver", T2.extensionCoreVersionName);
            }
            if (gb3.K().q().W().c("launch_by_reload")) {
                str = "1";
            } else {
                str = "0";
            }
            ki3Var.a("isReloadApp", str);
            JSONObject jSONObject = new JSONObject();
            ho3.f(jSONObject, "static", Float.valueOf(ou2.m().a()));
            ki3Var.a("device_score", jSONObject.toString());
            x(GameCenterCoreUtils.REF_TYPE_FROM_GAMECENTER, ki3Var);
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
