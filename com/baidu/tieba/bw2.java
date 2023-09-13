package com.baidu.tieba;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppClearCacheErrorActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.res.widget.dialog.BaseActivityDialog;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.swan.apps.view.SwanAppErrorDialog;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tbadk.core.util.schemeaction.deeplink.DeepLinkItem;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Sets;
import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class bw2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static boolean b;
    public static final long c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class c extends ProviderDelegation {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ Bundle a;

            public a(c cVar, Bundle bundle) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, bundle};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                bw2.j(this.a.getString("arg_title"), this.a.getString("arg_message"), this.a.getInt("arg_match_target_down", SwanAppProcessInfo.UNKNOWN.index));
            }
        }

        public c() {
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

        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bundle)) == null) {
                if (bundle != null) {
                    bp3.e0(new a(this, bundle));
                    return null;
                }
                return null;
            }
            return (Bundle) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class a implements e83 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ Set b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public a(int i, Set set, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), set, str, str2};
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
            this.b = set;
            this.c = str;
            this.d = str2;
        }

        @Override // com.baidu.tieba.e83
        public void a(String str, g83 g83Var) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, str, g83Var) == null) && g83Var.b.index == this.a && this.b.contains(str)) {
                i83.k().h(this);
                bw2.i(this.c, this.d);
            }
        }

        @Override // com.baidu.tieba.e83
        public void timeout() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                bw2.i(this.c, this.d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements DialogInterface.OnDismissListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, dialogInterface) != null) {
                return;
            }
            boolean unused = bw2.b = false;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947659308, "Lcom/baidu/tieba/bw2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947659308, "Lcom/baidu/tieba/bw2;");
                return;
            }
        }
        a = rr1.a;
        b = false;
        c = TimeUnit.SECONDS.toMillis(1L);
    }

    public static boolean h(@NonNull Context context, @Nullable String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) {
            if (!TextUtils.isEmpty(str) && !SwanAppNetworkUtils.i(context) && !ow2.d(str)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static String d(@NonNull Context context, String str, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, str, Long.valueOf(j)})) == null) {
            if (h(context, str)) {
                return "type_network_error";
            }
            if (j == 2205) {
                return "type_2205";
            }
            if (j == 49) {
                return "type_0049";
            }
            return "type_normal";
        }
        return (String) invokeCommon.objValue;
    }

    public static void e(Context context, @NonNull an3 an3Var, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(65541, null, context, an3Var, i, str) == null) {
            f(context, an3Var, i, str, null);
        }
    }

    public static void f(Context context, @NonNull an3 an3Var, int i, String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{context, an3Var, Integer.valueOf(i), str, bundle}) == null) {
            m43.k(an3Var);
            g(context, an3Var, i, str, false, bundle);
        }
    }

    public static void g(Context context, @NonNull an3 an3Var, int i, String str, boolean z, Bundle bundle) {
        boolean z2;
        String a2;
        File a3;
        String c2;
        SwanAppProcessInfo swanAppProcessInfo;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65543, null, new Object[]{context, an3Var, Integer.valueOf(i), str, Boolean.valueOf(z), bundle}) != null) || context == null) {
            return;
        }
        if ((context instanceof SwanAppActivity) && ((SwanAppActivity) context).isDestroyed()) {
            h82.k("LaunchError", "launch activity closed, ignore launch error");
            return;
        }
        SwanLauncher.p("LaunchError", "处理调起错误 errorCode=" + an3Var);
        String i2 = mk3.i(uw2.T().getCoreVersion(), i);
        long h = an3Var.h();
        String r = an3Var.r();
        if (1020 == h && !TextUtils.isEmpty(r)) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            a2 = r;
        } else {
            a2 = fn4.b().a(h);
        }
        String format = String.format(context.getResources().getString(R.string.obfuscated_res_0x7f0f01d2), bp3.D(), i2, String.valueOf(an3Var.a()));
        if (!ou2.T().a(context, str, an3Var)) {
            if (i == 0) {
                String d = d(context, str, h);
                ForbiddenInfo forbiddenInfo = new ForbiddenInfo(gb3.K().q().W(), a2, format);
                forbiddenInfo.enableSlidingFlag = -1;
                zq3.c().n(an3Var);
                l(context, d, an3Var, forbiddenInfo, bundle);
            } else if (i == 1) {
                if (z2) {
                    c2 = r;
                } else {
                    c2 = fn4.b().c(h);
                }
                if (z) {
                    swanAppProcessInfo = SwanAppProcessInfo.current();
                } else {
                    swanAppProcessInfo = SwanAppProcessInfo.UNKNOWN;
                }
                m(context, str, a2, c2, format, swanAppProcessInfo.index);
            }
        }
        StringBuilder sb = new StringBuilder();
        String b2 = vn3.b(vn3.a(), "yyyy-MM-dd HH:mm:ss");
        if (!TextUtils.isEmpty(str)) {
            sb.append(b2);
            sb.append(": ");
            sb.append(str);
            sb.append("\r\n");
        }
        sb.append(b2);
        sb.append(": ");
        sb.append(format);
        sb.append("\r\n");
        co3.c(sb.toString(), false);
        if (rr1.a) {
            String y = bp3.y();
            if (!TextUtils.isEmpty(y) && (a3 = wn3.a()) != null) {
                File file = new File(a3.getPath(), "error_dialog_info.txt");
                lr4.j(file);
                StringBuilder sb2 = new StringBuilder();
                if (!TextUtils.isEmpty(format)) {
                    sb2.append(format);
                    sb2.append("\n");
                }
                sb2.append(y);
                sb2.append("\n");
                lr4.N(sb2.toString(), file);
            }
        }
    }

    public static void i(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65545, null, str, str2) == null) && !b) {
            BaseActivityDialog.e r = SwanAppErrorDialog.r();
            r.C(str);
            r.y(new b());
            r.v(str2);
            r.z(R.string.obfuscated_res_0x7f0f0149, null);
            r.D();
            b = true;
        }
    }

    public static void j(String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65546, null, str, str2, i) == null) {
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                return;
            }
            if (!ProcessUtils.isMainProcess()) {
                Bundle bundle = new Bundle();
                bundle.putString("arg_title", str);
                bundle.putString("arg_message", str2);
                bundle.putInt("arg_match_target_down", i);
                u73.c(c.class, bundle);
                return;
            }
            if (a) {
                Log.d("LaunchError", "show normal err dialog, isShowing=" + b);
            }
            if (!SwanAppProcessInfo.checkProcessId(i)) {
                i(str, str2);
                return;
            }
            i83.k().c(new a(i, Sets.newHashSet("event_puppet_unload_app", "event_puppet_offline"), str, str2), c);
        }
    }

    public static void k(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65547, null, context, str, str2) == null) {
            String format = String.format(context.getResources().getString(R.string.obfuscated_res_0x7f0f1550), str, str2);
            if (a) {
                Log.d("LaunchError", "show normal err toast: " + format);
            }
            za3 g = za3.g(AppRuntime.getAppContext(), format);
            g.q(Integer.MAX_VALUE);
            g.F();
        }
    }

    public static void l(Context context, String str, an3 an3Var, ForbiddenInfo forbiddenInfo, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65548, null, context, str, an3Var, forbiddenInfo, bundle) == null) {
            Intent intent = new Intent();
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            int g = f13.g();
            int i = 0;
            if (!bp3.O()) {
                i = f13.h(context);
            }
            intent.putExtra("swan_error_type", str);
            intent.putExtra("swan_error_code", String.valueOf(an3Var.a()));
            intent.putExtra("swan_error_forbidden_info", forbiddenInfo);
            intent.putExtra("swan_error_menu_notice_count", g);
            intent.putExtra("swan_error_menu_privacy_count", i);
            PMSAppInfo f0 = gb3.K().q().W().f0();
            if (f0 != null) {
                zq3.c().n(an3Var);
                intent.putExtra(DeepLinkItem.DEEPLINK_WEBURL_KEY, f0.webUrl);
                intent.putExtra("webPermit", f0.webPermit);
            }
            if (TextUtils.equals(str, "type_2205") && bp3.G()) {
                intent.setComponent(new ComponentName(context, SwanAppClearCacheErrorActivity.class));
            } else {
                intent.setComponent(new ComponentName(context, SwanAppErrorActivity.class));
            }
            if (!(context instanceof Activity)) {
                intent.addFlags(LaunchTaskConstants.OTHER_PROCESS);
            }
            context.startActivity(intent);
        }
    }

    public static void m(Context context, String str, String str2, String str3, String str4, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{context, str, str2, str3, str4, Integer.valueOf(i)}) == null) {
            if (h(context, str)) {
                if (ko3.a(context)) {
                    za3.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f01cd).G();
                    return;
                }
                if (a) {
                    Log.w("LaunchError", "show network err toast: areNotificationsEnabled false");
                }
                j(str2, str4, i);
            } else if (ko3.a(context)) {
                k(context, str3, str4);
            } else {
                if (a) {
                    Log.w("LaunchError", "handleLaunchError: areNotificationsEnabled false");
                }
                j(str2, str4, i);
            }
        }
    }
}
