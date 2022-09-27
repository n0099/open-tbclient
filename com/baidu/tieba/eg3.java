package com.baidu.tieba;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.io2;
import com.baidu.tieba.l12;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.WebView;
import java.util.List;
/* loaded from: classes3.dex */
public class eg3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947733336, "Lcom/baidu/tieba/eg3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947733336, "Lcom/baidu/tieba/eg3;");
                return;
            }
        }
        a = vj1.a;
    }

    public static String a(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (a) {
                return kz2.p() ? yf3.d(i, SchemeCollecter.CLASSIFY_SWAN_V8) : "";
            } else if (z) {
                return yf3.d(i, SchemeCollecter.CLASSIFY_SWAN_V8);
            } else {
                return yf3.d(i, SchemeCollecter.CLASSIFY_SWAN_WEBVIEW);
            }
        }
        return (String) invokeCommon.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            StringBuilder sb = new StringBuilder();
            SwanCoreVersion M = yo2.U().M();
            String str2 = "";
            if (M != null) {
                String str3 = M.swanCoreVersionName;
                str2 = SwanCoreVersion.getTypeString(M.swanCoreType);
                str = str3;
            } else {
                str = "";
            }
            sb.append("swanjs: ");
            sb.append(str2);
            sb.append("/");
            sb.append(str);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static String c(Context context) {
        InterceptResult invokeL;
        rp1 o3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            l33 b0 = l33.b0();
            if (context == null || b0 == null || b0.k() != 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            io2.a W = b0.W();
            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), W.i1());
            sb.append("size: ");
            if (TextUtils.isEmpty(formatFileSize)) {
                formatFileSize = "";
            }
            sb.append(formatFileSize);
            sb.append("\n");
            sb.append("version: ");
            sb.append(TextUtils.isEmpty(W.w1()) ? "" : W.w1());
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("code: ");
            sb.append(TextUtils.isEmpty(W.v1()) ? "" : W.v1());
            sb.append("\n");
            sb.append("is opt pkg: ");
            sb.append(qt2.g().h(W.f0()));
            sb.append("\n");
            sb.append("swan native: ");
            sb.append(gn3.getContext() != null ? gn3.getContext().b() : "");
            sb.append("\n");
            sb.append(b());
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append(e(0));
            sb.append("\n");
            sb.append("is v8 master: ");
            sb.append(fa2.U().r0());
            sb.append("\n");
            String a2 = a(0, fa2.U().r0());
            sb.append("is native desc: ");
            sb.append(!TextUtils.isEmpty(a2));
            sb.append("\n");
            boolean m = be2.m();
            sb.append("debugDynamicLibEnable: ");
            sb.append(m);
            sb.append('\n');
            if (m) {
                List<String> o = be2.o();
                sb.append("debugDynamicLibList: {");
                if (!o.isEmpty()) {
                    sb.append('\n');
                    for (String str : o) {
                        sb.append(str);
                        sb.append('\n');
                    }
                }
                sb.append("}\n");
            }
            t22 H = yo2.U().H();
            if (H != null && (o3 = H.o3()) != null) {
                int Q = o3.Q();
                sb.append("top fragment na-slave: ");
                sb.append(Q == 1 ? "NA" : WebView.LOGTAG);
                sb.append("\n");
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            return "model: " + Build.MODEL + "\nandroid: " + Build.VERSION.RELEASE + StringUtil.ARRAY_ELEMENT_SEPARATOR + "api level: " + Build.VERSION.SDK_INT + "\ncuid: " + sm2.h0().i(sm2.c()) + "\n";
        }
        return (String) invokeL.objValue;
    }

    public static String e(int i) {
        InterceptResult invokeI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) {
            String str2 = "";
            if (i != 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            ExtensionCore T = fa2.U().T();
            if (T != null) {
                String str3 = T.extensionCoreVersionName;
                String typeString = SwanCoreVersion.getTypeString(T.extensionCoreType);
                str = str3;
                str2 = typeString;
            } else {
                str = "";
            }
            sb.append("extensionjs: ");
            sb.append(str2);
            sb.append("/");
            sb.append(str);
            return sb.toString();
        }
        return (String) invokeI.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            StringBuilder sb = new StringBuilder();
            SwanCoreVersion M = yo2.U().M();
            sb.append("game-core version : ");
            sb.append(qc3.i(M, 1));
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static String g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            l33 b0 = l33.b0();
            if (context == null || b0 == null || b0.k() != 1) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            io2.a W = b0.W();
            sb.append(f());
            sb.append("\n");
            sb.append("host version : ");
            sb.append(fh3.u(AppRuntime.getAppContext(), AppRuntime.getAppContext().getPackageName()));
            sb.append("\n");
            sb.append("enable V8: ");
            sb.append(fa2.U().r0());
            sb.append("\n");
            sb.append("aps version: ");
            sb.append(TextUtils.isEmpty(W.v1()) ? "" : W.v1());
            sb.append("\n");
            String formatFileSize = Formatter.formatFileSize(AppRuntime.getAppContext(), W.i1());
            sb.append("app bundle size: ");
            if (TextUtils.isEmpty(formatFileSize)) {
                formatFileSize = "";
            }
            sb.append(formatFileSize);
            sb.append("\n");
            sb.append("app bundle version: ");
            sb.append(TextUtils.isEmpty(W.w1()) ? "" : W.w1());
            sb.append("\n");
            sb.append("app is opt pkg: ");
            sb.append(qt2.g().h(W.f0()));
            sb.append("\n");
            String b = tm2.h().b();
            if (!TextUtils.isEmpty(b)) {
                sb.append("app sconsole version: ");
                sb.append(b);
                sb.append("\n");
            }
            sb.append("game engine version: ");
            sb.append("1.3.6.1");
            sb.append("\n");
            sb.append("so version: ");
            sb.append(zb3.a().getLong("swan_so_installed_version_code_zeus", 0L));
            sb.append("\n");
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String h(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            en3 context2 = gn3.getContext();
            StringBuilder sb = new StringBuilder();
            sb.append("name: ");
            sb.append(sm2.n().a());
            sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
            sb.append("version: ");
            sb.append(context2 != null ? context2.h() : "");
            sb.append("\n");
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void i(Context context, ei3<String> ei3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, context, ei3Var) == null) {
            n32.e(ei3Var);
        }
    }

    public static String j(@NonNull l33 l33Var) {
        InterceptResult invokeL;
        String str;
        SwanAppConfigData.h hVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, l33Var)) == null) {
            PMSAppInfo f0 = l33Var.W().f0();
            if (f0 == null) {
                return "no info";
            }
            StringBuilder sb = new StringBuilder();
            boolean i = qt2.g().i(f0);
            boolean j0 = fa2.U().j0();
            boolean z = false;
            SwanAppConfigData Q = l33Var.Q();
            if (Q == null || (hVar = Q.t) == null) {
                str = "";
            } else {
                z = hVar.a;
                str = hVar.b;
            }
            sb.append("is server on: ");
            sb.append(i);
            sb.append("\n");
            sb.append("app.json info: ");
            sb.append("enabled/");
            sb.append(z);
            sb.append(", trigger/");
            sb.append(str);
            sb.append("\n");
            sb.append("is hit: ");
            sb.append(j0);
            sb.append("\n");
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            long nanoTime = a ? System.nanoTime() : 0L;
            l12.d g = l12.c().g();
            if (a) {
                Log.d("SwanAppEnvironmentUtils", "获取内存信息耗时: " + ((System.nanoTime() - nanoTime) / 1000000) + " ms");
            }
            return "设备总内存：" + g.c + " M，设备剩余内存：" + g.d + " M，小程序启动占用内存：" + g.a + " M，宿主APP占用内存：" + g.b + " M\n";
        }
        return (String) invokeV.objValue;
    }

    public static String l(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            long nanoTime = a ? System.nanoTime() : 0L;
            l33 b0 = l33.b0();
            if (b0 == null || context == null) {
                return "";
            }
            String str = "=========================\n= " + b0.W().K() + "\n=========================\n===== 小程序信息 =====\n" + c(context) + "\n===== 设备信息 =====\n" + d(context) + "\n===== 宿主信息 =====\n" + h(context) + "\n===== 内存信息 =====\n" + k() + "\n===== onPrefetch信息 =====\n" + j(b0) + "\n";
            if (a) {
                StringBuilder sb = new StringBuilder();
                sb.append("获取启动时信息耗时：");
                sb.append((System.nanoTime() - nanoTime) / 1000000);
                sb.append(" ms 是否主线程：");
                sb.append(Looper.getMainLooper() == Looper.myLooper());
                Log.d("SwanAppEnvironmentUtils", sb.toString());
            }
            l02.k("SwanAppEnvironmentUtils", str);
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static void m(Activity activity) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65549, null, activity) == null) || activity == null) {
            return;
        }
        try {
            str = l(activity);
        } catch (Exception e) {
            if (!a) {
                l02.l("SwanAppEnvironmentUtils", "getExtraInfo error", e);
                str = "";
            } else {
                throw e;
            }
        }
        l02.k("SwanAppEnvironmentUtils", "recordExtraInfoToLogSystem\n--------------------ExtraInfo list----------------------\n" + str + "--------------------ExtraInfo end-----------------------");
        String k = sm2.g0().k();
        l02.k("SwanAppEnvironmentUtils", "sid = " + k);
        l72.k();
    }
}
