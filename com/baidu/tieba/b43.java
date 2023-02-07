package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b43 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947594952, "Lcom/baidu/tieba/b43;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947594952, "Lcom/baidu/tieba/b43;");
                return;
            }
        }
        a = gp1.a;
    }

    public static void a(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, swanAppConfigData) != null) || swanAppConfigData == null) {
            return;
        }
        List<q43> e = swanAppConfigData.e();
        if (e != null && !e.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            b(e, jSONObject, jSONObject2);
            if (lj2.k()) {
                boolean z = false;
                for (q43 q43Var : e) {
                    String h = lj2.h(q43Var.a);
                    if (!TextUtils.isEmpty(h) && new File(h).exists()) {
                        q43Var.e = h;
                        c(jSONObject, jSONObject2, q43Var);
                        z = true;
                        w52.i("Module-Plugin", "use debug dependencies，name=" + q43Var.a + " path=" + q43Var.e);
                    } else {
                        w52.o("Module-Plugin", "debug dependencies not exist，name=" + q43Var.a + " path=" + q43Var.e);
                    }
                }
                if (!z) {
                    o83.g(AppRuntime.getAppContext(), "no debug dependency").G();
                    w52.c("Module-Plugin", "no debug dependency");
                }
            }
            String jSONObject3 = jSONObject.toString();
            String jSONObject4 = jSONObject2.toString();
            u43.c("dependenciesPath", jSONObject3);
            u43.c("dependenciesConfig", jSONObject4);
            return;
        }
        u43.c("dependenciesPath", null);
        u43.c("dependenciesConfig", null);
        if (a) {
            o43.b("this swan app not apply on someone dynamic lib");
        }
    }

    public static void b(@NonNull List<q43> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65538, null, list, jSONObject, jSONObject2) != null) || list.isEmpty()) {
            return;
        }
        for (q43 q43Var : list) {
            if (q43Var != null) {
                if (q43Var.g) {
                    c(jSONObject, jSONObject2, q43Var);
                } else {
                    xh4 q = tg4.i().q(q43Var.a, q43Var.h, q43Var.i);
                    if (q == null) {
                        o43.a(Log.getStackTraceString(new Throwable(q43Var.a + " query db fail")));
                    } else {
                        File t = sr2.t(q43Var.a, String.valueOf(q.i));
                        if (t != null && t.exists()) {
                            q43Var.e = t.getAbsolutePath();
                            c(jSONObject, jSONObject2, q43Var);
                        } else {
                            o43.a(Log.getStackTraceString(new Throwable(q43Var.a + " local file not exist")));
                        }
                    }
                }
            }
        }
    }

    public static void c(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull q43 q43Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, jSONObject, jSONObject2, q43Var) == null) {
            String str = q43Var.e;
            String str2 = q43Var.f;
            if (a) {
                o43.b("apply dep path, name = " + q43Var.a + "; inline = " + q43Var.g + "; path = " + str + "; config = " + str2);
            }
            if (TextUtils.isEmpty(str)) {
                o43.b(Log.getStackTraceString(new Throwable(q43Var.a + " path is empty")));
                return;
            }
            wl3.f(jSONObject, q43Var.a, str);
            if (!TextUtils.isEmpty(q43Var.f)) {
                File file = new File(str, str2);
                if (file.exists() && file.isFile()) {
                    wl3.f(jSONObject2, q43Var.a, wl3.d(ap4.E(file)));
                }
            }
        }
    }
}
