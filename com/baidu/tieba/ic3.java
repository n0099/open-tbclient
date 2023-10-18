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
import com.baidu.tieba.lc3;
import com.baidu.tieba.mq2;
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
/* loaded from: classes6.dex */
public final class ic3 {
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

    /* loaded from: classes6.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rc3 a;

        public a(rc3 rc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rc3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rc3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b(ic3.a());
                wb3.k("778", this.a.f());
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if (ic3.o(this.a)) {
                if (ic3.a) {
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
                        g62.d().e(f62.c(this.a, this.c, this.b, this.d, this.g));
                    } else {
                        g62.d().e(f62.a(this.a, this.c, this.b, this.d, this.g));
                    }
                } else if (TextUtils.equals(this.f, "0")) {
                    g62.d().e(f62.b(this.a, this.c, this.g));
                }
            }
            if (z && j < 5000) {
                if (ic3.a) {
                    Log.d("SwanAppUBCStatistic", "code 200 & cost(" + (this.b - this.c) + ") is ok, don't report");
                    return;
                }
                return;
            }
            ic3.j(this.d, this.a, this.e, this.h, this.i, this.j, this.f, this.c, this.b, this.k);
        }
    }

    /* loaded from: classes6.dex */
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
            pc3 pc3Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int c = cx2.c();
                if (ic3.a) {
                    Log.d("SwanAppUBCStatistic", "get NetworkQuality: " + c);
                }
                if (TextUtils.equals(this.a, "1")) {
                    pc3Var = new pc3(this.b, this.c, this.d, c);
                } else {
                    pc3Var = new pc3(this.c, c, 0L, 0L);
                }
                new lc3.a(pc3Var, "downloadFile");
                if (!TextUtils.isEmpty(this.e)) {
                    pc3Var.r(this.e);
                }
                if (!TextUtils.isEmpty(this.f)) {
                    pc3Var.q(this.f);
                }
                pc3Var.b = "downloadFile";
                if (p53.M() != null && p53.M().Z() != null) {
                    pc3Var.c = p53.M().Z().U();
                }
                pc3Var.f = p53.h0();
                pc3Var.a = ic3.n(this.g);
                JSONObject f = pc3Var.f();
                wb3.k("834", f);
                p22.k("SwanAppUBCStatistic", "834-downloadFile event=" + f.toString());
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rc3 a;

        public d(rc3 rc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rc3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rc3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                wb3.k("894", this.a.f());
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oc3 a;

        public e(oc3 oc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oc3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oc3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                wb3.k("751", this.a.f());
            }
        }
    }

    /* loaded from: classes6.dex */
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
                qc3 qc3Var = new qc3();
                qc3Var.e = this.a;
                qc3Var.b = "show";
                qc3Var.a = "swan";
                ForbiddenInfo forbiddenInfo = this.b;
                qc3Var.c = forbiddenInfo.launchSource;
                qc3Var.a("path", forbiddenInfo.launchPath);
                qc3Var.a("appkey", this.b.appId);
                wb3.m("1400", qc3Var.f());
            }
        }
    }

    /* loaded from: classes6.dex */
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
            p53 c0;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048576, this) != null) || (c0 = p53.c0()) == null) {
                return;
            }
            mq2.a X = c0.X();
            String a0 = c0.a0();
            String appId = c0.getAppId();
            qc3 qc3Var = new qc3();
            qc3Var.b = "login";
            qc3Var.a = ic3.n(X.H());
            qc3Var.f = appId;
            qc3Var.e = this.a;
            qc3Var.a("appName", a0);
            qc3Var.a("invokeFrom", this.b);
            qc3Var.a("scene", Integer.valueOf(this.c));
            JSONObject f = qc3Var.f();
            if (TextUtils.equals(this.a, "show")) {
                p22.j("SwanAppUBCStatistic", "1936", "登录展示 event=" + f, false);
                wb3.i("1936", "80", f);
            } else if (TextUtils.equals(this.a, "success")) {
                p22.j("SwanAppUBCStatistic", "1936", "登录成功 event=" + f, false);
                wb3.i("1936", "81", f);
            } else if (TextUtils.equals(this.a, "fail") || TextUtils.equals(this.a, "check_fail")) {
                p22.e("SwanAppUBCStatistic", "1936", "登录失败 event=" + f, this.d, false);
                wb3.i("1936", "82", f);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                p53 q = o53.K().q();
                mq2.a X = q.X();
                String a0 = q.a0();
                String appId = q.getAppId();
                qc3 qc3Var = new qc3();
                qc3Var.b = "swanLogin";
                qc3Var.a = ic3.n(X.H());
                qc3Var.f = appId;
                qc3Var.e = this.a;
                qc3Var.a("appName", a0);
                qc3Var.a("loginScene", this.b);
                String str = this.c;
                if (str != null) {
                    qc3Var.a("errorInfo", str);
                }
                JSONObject f = qc3Var.f();
                if (this.d) {
                    p22.p("SwanAppUBCStatistic", "1936", "登录取消打点 event=" + f, this.e, false);
                } else if (this.f) {
                    p22.e("SwanAppUBCStatistic", "1936", "登录失败打点 event=" + f, this.e, false);
                } else {
                    p22.j("SwanAppUBCStatistic", "1936", "登录数据打点 event=" + f, false);
                }
                wb3.i("1936", "1936", f);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                rc3 rc3Var = new rc3();
                rc3Var.a = ic3.n(o53.K().q().k());
                String str = this.a;
                rc3Var.b = str;
                rc3Var.g = this.b;
                if (TextUtils.equals(str, "click")) {
                    rc3Var.e = this.c;
                }
                rc3Var.f = o53.K().getAppId();
                rc3Var.a("source", o53.K().q().X().U());
                rc3Var.a("mode", "normal");
                rc3Var.a("from", "login");
                JSONObject f = rc3Var.f();
                if (ic3.a) {
                    Log.d("SwanAppUBCStatistic", "staticLoginResult: event = " + f);
                }
                wb3.k("1936", f);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                synchronized (ic3.c) {
                    try {
                        ic3.c.wait(this.a);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rc3 a;
        public final /* synthetic */ vb3 b;

        public k(rc3 rc3Var, vb3 vb3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rc3Var, vb3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rc3Var;
            this.b = vb3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                rc3 rc3Var = this.a;
                if (rc3Var != null) {
                    wb3.f(this.b, rc3Var.f().toString());
                }
                wb3.c(this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
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
                qc3 qc3Var = new qc3();
                qc3Var.a = ic3.n(o53.K().q().k());
                qc3Var.f = o53.K().getAppId();
                if (this.a) {
                    i = 1;
                } else {
                    i = 2;
                }
                qc3Var.a("type", Integer.valueOf(i));
                qc3Var.a(CloudStabilityUBCUtils.KEY_ERROR_CODE, Long.valueOf(hl3.c().g()));
                qc3Var.a("degradeUrl", this.b);
                qc3Var.a("appid", o53.K().getAppId());
                qc3Var.a("hostname", wo2.n().a());
                qc3Var.a("_swebfr", il3.e());
                wb3.i("3863", "3863", qc3Var.f());
                if (this.a) {
                    ih3 ih3Var = new ih3();
                    ih3Var.k(1L);
                    ih3Var.i(2108L);
                    mh3.a().f(ih3Var);
                    qc3 qc3Var2 = new qc3();
                    qc3Var2.p(ih3Var);
                    qc3Var2.r(o53.K().q().X());
                    qc3Var2.q(ic3.n(o53.K().k()));
                    qc3Var2.m(o53.K().getAppId());
                    ic3.R(qc3Var2);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class m implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qc3 a;
        public final /* synthetic */ long b;
        public final /* synthetic */ Exception c;

        public m(qc3 qc3Var, long j, Exception exc) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qc3Var, Long.valueOf(j), exc};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qc3Var;
            this.b = j;
            this.c = exc;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (TextUtils.isEmpty(this.a.g())) {
                    this.a.k(o53.K().q().X().W());
                }
                JSONObject f = this.a.f();
                p22.e("SwanAppUBCStatistic", "671", "稳定性打点 since=" + di3.e(new Date(this.b), "yyyy-MM-dd HH:mm:ss.SSS") + " event=" + f, this.c, false);
                wb3.k("671", f);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class n implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rc3 a;
        public final /* synthetic */ String b;

        public n(rc3 rc3Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rc3Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = rc3Var;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSONObject f = this.a.f();
                wb3.k(this.b, f);
                if (GameCenterCoreUtils.REF_TYPE_FROM_GAMECENTER.equals(this.b)) {
                    gc3.a().b(f.toString());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ rc3 c;

        public o(String str, String str2, rc3 rc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, rc3Var};
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
            this.c = rc3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                wb3.i(this.a, this.b, this.c.f());
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class p implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oc3 a;

        public p(oc3 oc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oc3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oc3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                wb3.k("751", this.a.f());
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class q implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oc3 a;

        public q(oc3 oc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oc3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oc3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                wb3.k("751", this.a.f());
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class r implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oc3 a;

        public r(oc3 oc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oc3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oc3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                wb3.k("751", this.a.f());
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class s implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oc3 a;

        public s(oc3 oc3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oc3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oc3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                wb3.k("751", this.a.f());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947848656, "Lcom/baidu/tieba/ic3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947848656, "Lcom/baidu/tieba/ic3;");
                return;
            }
        }
        a = am1.a;
        b = Executors.newSingleThreadExecutor();
        c = new Object();
        d = Sets.newHashSet("hmma.baidu.com");
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        e = copyOnWriteArrayList;
        copyOnWriteArrayList.add("https://hmma.baidu.com/mini.gif");
        e.add("https://dxp.baidu.com/mini");
        CopyOnWriteArrayList<String> copyOnWriteArrayList2 = e;
        copyOnWriteArrayList2.add(j22.c() + "/smtapp/recordhandler/getrecordinfo");
        CopyOnWriteArrayList<String> copyOnWriteArrayList3 = e;
        copyOnWriteArrayList3.add(j22.b() + "/smtapp/recordhandler/getrecordinfo");
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

    public static void i(vb3 vb3Var, rc3 rc3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65572, null, vb3Var, rc3Var) != null) || vb3Var == null) {
            return;
        }
        ji3.j(new k(rc3Var, vb3Var), "SwanAppUBCEndFlow");
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

    public static void x(String str, rc3 rc3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65588, null, str, rc3Var) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        iz2.e().d(new n(rc3Var, str), "SwanAppUBCOnEvent", true);
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

    public static void y(String str, String str2, rc3 rc3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65589, null, str, str2, rc3Var) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            ji3.j(new o(str, str2, rc3Var), "SwanAppUbcCeresOnEvent");
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
        mq2.a X;
        Bundle Q;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65541, null) == null) && o53.K().E() && (Q = (X = o53.K().q().X()).Q()) != null && Q.getLong("launch_flag_for_statistic") > 0) {
            long l2 = X.l("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            sc3 sc3Var = new sc3();
            sc3Var.a = n(o53.K().k());
            sc3Var.f = X.I();
            if (o13.F(X.h0())) {
                sc3Var.c = "remote-debug";
            } else if (o13.D()) {
                sc3Var.c = "local-debug";
            } else {
                sc3Var.c = X.U();
            }
            sc3Var.b = "launch";
            sc3Var.e = "success";
            sc3Var.r = String.valueOf(currentTimeMillis - l2);
            sc3Var.a("status", "0");
            zb3.n(sc3Var, X.X(), X.t0().getString("ubc"));
            Q.putLong("launch_flag_for_statistic", 0L);
            HybridUbcFlow d2 = uy2.d("startup");
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
            o53 K = o53.K();
            p53 q2 = K.q();
            mq2.a X = q2.X();
            if (K.E() && q2.t0()) {
                Bundle t0 = X.t0();
                if (t0.getLong("launch_flag_for_statistic") > 0) {
                    String valueOf = String.valueOf(System.currentTimeMillis() - q2.X().v1());
                    sc3 sc3Var = new sc3();
                    sc3Var.a = n(X.H());
                    sc3Var.b = "launch";
                    sc3Var.e = "cancel";
                    sc3Var.q = valueOf;
                    sc3Var.j(X);
                    sc3Var.d(t0.getString("ubc"));
                    sc3Var.b(k(X.X()));
                    onEvent(sc3Var);
                    sc3 sc3Var2 = new sc3();
                    sc3Var2.a = n(X.H());
                    sc3Var2.b = "launch";
                    sc3Var2.e = "realcancel";
                    sc3Var2.q = valueOf;
                    sc3Var2.j(X);
                    sc3Var2.b(k(X.X()));
                    sc3Var2.a("reason", "cancel");
                    if (X.H() == 1) {
                        sc3Var.a("errorList", xo2.j().a());
                    }
                    sc3Var2.d(t0.getString("ubc"));
                    onEvent(sc3Var2);
                    t0.remove("launch_flag_for_statistic");
                }
            }
        }
    }

    public static void F(boolean z, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65542, null, z, str) == null) {
            rc3 rc3Var = new rc3();
            if (o53.K().q().I()) {
                rc3Var.d(o53.K().q().X().t0().getString("ubc"));
            }
            rc3Var.b = "show";
            rc3Var.c = str;
            if (z) {
                str2 = "success";
            } else {
                str2 = "fail";
            }
            rc3Var.e = str2;
            rc3Var.f = p53.h0();
            iz2.e().d(new a(rc3Var), "SwanAppUBCOnPagesRoute", true);
        }
    }

    public static void G(String str, String str2, List<String> list) {
        int i2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65543, null, str, str2, list) == null) {
            if (o53.K().q().I()) {
                mq2.a X = o53.K().q().X();
                i2 = X.H();
                str3 = X.t0().getString("ubc");
            } else {
                i2 = 0;
                str3 = "";
            }
            oc3 oc3Var = new oc3();
            oc3Var.b = Logger.PAY_TYPE;
            oc3Var.c = str;
            oc3Var.f = p53.h0();
            oc3Var.a = n(i2);
            try {
                JSONObject jSONObject = new JSONObject(str3);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("paymenturl", str2);
                }
                if (list != null) {
                    jSONObject.put("whitelist", list);
                }
                jSONObject.put("appname", p53.M().a0());
                oc3Var.e(jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
                oc3Var.d(str3);
            }
            oc3Var.b(Z());
            ji3.k(new q(oc3Var), "SwanAppUBCOnPay");
        }
    }

    public static void H(boolean z, String str, String str2) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
            oc3 oc3Var = new oc3();
            mq2.a X = o53.K().q().X();
            if (o53.K().q().I()) {
                oc3Var.d(X.t0().getString("ubc"));
            }
            oc3Var.b = Logger.PAY_TYPE;
            if (z) {
                str3 = "success";
            } else {
                str3 = "fail";
            }
            oc3Var.e = str3;
            oc3Var.c = str;
            oc3Var.f = p53.h0();
            oc3Var.a = n(X.H());
            oc3Var.a("money", str2);
            oc3Var.b(Z());
            ji3.j(new p(oc3Var), "SwanAppUBCOnPay");
        }
    }

    public static void q(String str, String str2, boolean z) {
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65581, null, str, str2, z) == null) {
            rc3 rc3Var = new rc3();
            rc3Var.b = str;
            rc3Var.e = str2;
            rc3Var.f = p53.h0();
            if (p53.M() != null && p53.M().Z() != null) {
                mq2.a Z = p53.M().Z();
                rc3Var.c = Z.U();
                rc3Var.a = n(Z.H());
            }
            if (TextUtils.equals("click", str)) {
                if (z) {
                    str3 = "success";
                } else {
                    str3 = "fail";
                }
                rc3Var.a("authorize", str3);
            }
            ji3.k(new d(rc3Var), "SwanAppUBCOnAuthDialog");
        }
    }

    public static void z(String str, int i2, String str2) {
        p53 c0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(65590, null, str, i2, str2) != null) || (c0 = p53.c0()) == null) {
            return;
        }
        ih3 ih3Var = new ih3();
        ih3Var.k(5L);
        ih3Var.i(50L);
        qc3 qc3Var = new qc3();
        qc3Var.p(ih3Var);
        qc3Var.r(c0.X());
        qc3Var.q(n(c0.k()));
        qc3Var.m(c0.getAppId());
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
        qc3Var.e(jSONObject);
        R(qc3Var);
    }

    public static void I(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65545, null, str, str2, str3, str4) == null) && o53.K().q().I()) {
            mq2.a X = o53.K().q().X();
            int H = X.H();
            oc3 oc3Var = new oc3();
            oc3Var.b = "paykey";
            oc3Var.a = n(H);
            oc3Var.c = str;
            oc3Var.e = str4;
            oc3Var.a("appid", X.I());
            oc3Var.a("money", str2);
            oc3Var.a("source", X.U());
            oc3Var.a("pmappkey", str3);
            ji3.k(new s(oc3Var), "SwanAppUBCOnPayChecked");
        }
    }

    public static void J(String str, boolean z, boolean z2) {
        String str2;
        String str3;
        qv2 T1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, null, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            oc3 oc3Var = new oc3();
            mq2.a X = o53.K().q().X();
            if (o53.K().q().I()) {
                oc3Var.d(X.t0().getString("ubc"));
            }
            oc3Var.b = "paylogin";
            oc3Var.c = str;
            oc3Var.f = X.J();
            oc3Var.a = n(X.H());
            if (z) {
                str2 = "success";
            } else {
                str2 = "fail";
            }
            oc3Var.e = str2;
            oc3Var.a("nativeAppId", wo2.n().a());
            if (z2) {
                str3 = "1";
            } else {
                str3 = "0";
            }
            oc3Var.a("paylogin", str3);
            x42 J = cr2.V().J();
            if (J == null) {
                T1 = null;
            } else {
                T1 = J.T1();
            }
            if (T1 != null && !TextUtils.isEmpty(T1.i())) {
                oc3Var.a("page", T1.i());
            }
            oc3Var.b(Z());
            ji3.j(new e(oc3Var), "SwanAppUBCOnPayLogin");
        }
    }

    public static void K(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65547, null, str, str2, i2) == null) && o53.K().q().I()) {
            mq2.a X = o53.K().q().X();
            int H = X.H();
            oc3 oc3Var = new oc3();
            oc3Var.b = "payProcess";
            oc3Var.a = n(H);
            oc3Var.c = str;
            oc3Var.a("paymentProcess", str2);
            oc3Var.a("appid", X.I());
            oc3Var.a("source", X.U());
            if (X.k0() != null) {
                oc3Var.a("swan", X.k0().swanCoreVersionName);
            }
            if (TextUtils.equals("result", str2)) {
                if (i2 != 0) {
                    if (i2 != 2) {
                        oc3Var.a("payResultStatus", "fail");
                    } else {
                        oc3Var.a("payResultStatus", "cancel");
                    }
                } else {
                    oc3Var.a("payResultStatus", "success");
                }
            }
            oc3Var.b(Z());
            ji3.k(new r(oc3Var), "SwanAppUBCOnPayProcess");
        }
    }

    public static void L(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, str2) == null) {
            sc3 sc3Var = new sc3();
            sc3Var.b = "launch";
            sc3Var.e = str;
            if (p53.c0() != null) {
                mq2.a X = p53.c0().X();
                sc3Var.a = n(X.H());
                sc3Var.f = X.I();
                sc3Var.c = X.U();
            }
            sc3Var.t = str2;
            onEvent(sc3Var);
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
                    wb3.i("1415", PayUVEventType.PAY_RUBY_ENTRANCE_BANNER_SHOW, jSONObject);
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

    public static void R(qc3 qc3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65554, null, qc3Var) != null) || qc3Var == null) {
            return;
        }
        ji3.j(new m(qc3Var, System.currentTimeMillis(), new Exception("stack")), "SwanAppUBCStability");
    }

    public static void a0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65564, null, i2) == null) {
            b.execute(new j(i2));
        }
    }

    public static vb3 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, str)) == null) {
            return wb3.a(str);
        }
        return (vb3) invokeL.objValue;
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65568, null, str) == null) {
            rc3 rc3Var = new rc3();
            rc3Var.a = n(0);
            rc3Var.b = str;
            x("956", rc3Var);
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
            rc3 rc3Var = new rc3();
            p53 c0 = p53.c0();
            String str5 = "";
            if (c0 == null) {
                str3 = "";
                str4 = str3;
            } else {
                str5 = n(c0.k());
                str4 = c0.P();
                str3 = c0.X().U();
            }
            rc3Var.a = str5;
            rc3Var.b = AlbumActivityConfig.FROM_WEB_VIEW;
            rc3Var.c = str3;
            rc3Var.a("appkey", str4);
            rc3Var.a("url", str);
            rc3Var.a("browser", str2);
            y("3320", "96", rc3Var);
            if (a) {
                Log.d("SwanAppUBCStatistic", "onWebViewHistoryChange: " + String.format("ubcId=%s && ceresId=%s , content:%s ", "3320", "96", rc3Var.f()));
            }
        }
    }

    public static void r(int i2, pa3 pa3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65582, null, i2, pa3Var) == null) {
            p53 c0 = p53.c0();
            if (c0 == null) {
                if (a) {
                    Log.e("SwanAppUBCStatistic", "onAuthorizeFailed-swanApp is null");
                    return;
                }
                return;
            }
            qc3 qc3Var = new qc3();
            qc3Var.o(i2);
            qc3Var.r(c0.Z());
            qc3Var.q(n(c0.k()));
            qc3Var.m(c0.getAppId());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appid", c0.getAppId());
                jSONObject.put("msg", na3.f(i2));
                jSONObject.put(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, c0.f0().q("cur_request_id", ""));
                if (pa3Var != null) {
                    jSONObject.put("scope", pa3Var.b);
                    jSONObject.put("scopeData", pa3Var.a);
                }
            } catch (JSONException e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
            qc3Var.e(jSONObject);
            R(qc3Var);
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

    public static void d(sc3 sc3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65567, null, sc3Var) == null) && sc3Var != null && p53.M() != null && p53.M().Z() != null) {
            mq2.a Z = p53.M().Z();
            sc3Var.a = n(Z.H());
            sc3Var.f = Z.I();
            sc3Var.a("appkey", Z.J());
            x("1032", sc3Var);
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
        mq2.a Z;
        JSONObject N;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            p53 M = p53.M();
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
    /* JADX DEBUG: Method not inlined, still used in: [com.baidu.tieba.ic3.j.run():void] */
    public static /* synthetic */ boolean b() {
        return a;
    }

    public static String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) {
            if (cw2.g()) {
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
            rc3 rc3Var = new rc3();
            if (p53.M() != null && p53.M().Z() != null) {
                mq2.a Z = p53.M().Z();
                rc3Var.a = n(Z.H());
                rc3Var.f = Z.I();
                rc3Var.b = str;
                rc3Var.c = str2;
                rc3Var.e = str3;
                rc3Var.a("appkey", Z.J());
            }
            x("923", rc3Var);
        }
    }

    public static void g(rc3 rc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65570, null, rc3Var) == null) {
            if (p53.M() != null && p53.M().Z() != null) {
                mq2.a Z = p53.M().Z();
                rc3Var.a = n(Z.H());
                rc3Var.f = Z.I();
                rc3Var.c = Z.U();
            }
            x("936", rc3Var);
        }
    }

    public static void h(rc3 rc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65571, null, rc3Var) == null) {
            if (p53.M() != null && p53.M().Z() != null) {
                mq2.a Z = p53.M().Z();
                rc3Var.a = n(Z.H());
                rc3Var.f = Z.I();
                rc3Var.c = Z.U();
            }
            x("914", rc3Var);
        }
    }

    @WorkerThread
    public static void j(int i2, String str, int i3, String str2, @Nullable String str3, @Nullable String str4, String str5, long j2, long j3, @Nullable NetworkStatRecord networkStatRecord) {
        pc3 pc3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65573, null, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), str2, str3, str4, str5, Long.valueOf(j2), Long.valueOf(j3), networkStatRecord}) == null) {
            int c2 = cx2.c();
            if (a) {
                Log.d("SwanAppUBCStatistic", "get NetworkQuality: " + c2);
            }
            if (TextUtils.equals(str5, "1")) {
                pc3Var = new pc3(i2, str, str2, c2, j2, j3);
            } else {
                pc3Var = new pc3(str, c2, j2, j3);
            }
            lc3.a aVar = new lc3.a(pc3Var, "request");
            if (!TextUtils.isEmpty(str3)) {
                pc3Var.r(str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                pc3Var.q(str4);
            }
            pc3Var.b = "request";
            p53 q2 = o53.K().q();
            if (q2 != null && q2.I()) {
                pc3Var.c = q2.X().U();
                pc3Var.d = q2.X().W();
            }
            pc3Var.f = p53.h0();
            pc3Var.a = n(i3);
            JSONObject X = X(networkStatRecord);
            aVar.b = X;
            if (X != null) {
                pc3Var.e(X);
            }
            if (a) {
                Log.d("SwanAppUBCStatistic", "Reporting: " + pc3Var.f());
            }
            JSONObject f2 = pc3Var.f();
            if (pc3Var.o()) {
                p22.j("SwanAppUBCStatistic", "834", "网络请求成功打点 event=" + f2, false);
            } else {
                p22.e("SwanAppUBCStatistic", "834", "网络请求失败打点 event=" + f2, null, false);
            }
            wb3.k("834", f2);
            N(pc3Var.m(), pc3Var.n(), f2);
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

    public static void onEvent(sc3 sc3Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65579, null, sc3Var) == null) {
            ExtensionCore U = jc2.V().U();
            if (U != null) {
                sc3Var.a("extension_ver", U.extensionCoreVersionName);
            }
            if (o53.K().q().X().c("launch_by_reload")) {
                str = "1";
            } else {
                str = "0";
            }
            sc3Var.a("isReloadApp", str);
            JSONObject jSONObject = new JSONObject();
            pi3.f(jSONObject, "static", Float.valueOf(wo2.m().a()));
            sc3Var.a("device_score", jSONObject.toString());
            x(GameCenterCoreUtils.REF_TYPE_FROM_GAMECENTER, sc3Var);
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
