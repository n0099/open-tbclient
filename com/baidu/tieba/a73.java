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
/* loaded from: classes5.dex */
public class a73 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947568044, "Lcom/baidu/tieba/a73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947568044, "Lcom/baidu/tieba/a73;");
                return;
            }
        }
        a = fs1.a;
    }

    public static void a(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, swanAppConfigData) != null) || swanAppConfigData == null) {
            return;
        }
        List<p73> e = swanAppConfigData.e();
        if (e != null && !e.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            b(e, jSONObject, jSONObject2);
            if (km2.k()) {
                boolean z = false;
                for (p73 p73Var : e) {
                    String h = km2.h(p73Var.a);
                    if (!TextUtils.isEmpty(h) && new File(h).exists()) {
                        p73Var.e = h;
                        c(jSONObject, jSONObject2, p73Var);
                        z = true;
                        v82.i("Module-Plugin", "use debug dependencies，name=" + p73Var.a + " path=" + p73Var.e);
                    } else {
                        v82.o("Module-Plugin", "debug dependencies not exist，name=" + p73Var.a + " path=" + p73Var.e);
                    }
                }
                if (!z) {
                    nb3.g(AppRuntime.getAppContext(), "no debug dependency").G();
                    v82.c("Module-Plugin", "no debug dependency");
                }
            }
            String jSONObject3 = jSONObject.toString();
            String jSONObject4 = jSONObject2.toString();
            t73.c("dependenciesPath", jSONObject3);
            t73.c("dependenciesConfig", jSONObject4);
            return;
        }
        t73.c("dependenciesPath", null);
        t73.c("dependenciesConfig", null);
        if (a) {
            n73.b("this swan app not apply on someone dynamic lib");
        }
    }

    public static void b(@NonNull List<p73> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65538, null, list, jSONObject, jSONObject2) != null) || list.isEmpty()) {
            return;
        }
        for (p73 p73Var : list) {
            if (p73Var != null) {
                if (p73Var.g) {
                    c(jSONObject, jSONObject2, p73Var);
                } else {
                    wk4 q = sj4.i().q(p73Var.a, p73Var.h, p73Var.i);
                    if (q == null) {
                        n73.a(Log.getStackTraceString(new Throwable(p73Var.a + " query db fail")));
                    } else {
                        File t = ru2.t(p73Var.a, String.valueOf(q.i));
                        if (t != null && t.exists()) {
                            p73Var.e = t.getAbsolutePath();
                            c(jSONObject, jSONObject2, p73Var);
                        } else {
                            n73.a(Log.getStackTraceString(new Throwable(p73Var.a + " local file not exist")));
                        }
                    }
                }
            }
        }
    }

    public static void c(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull p73 p73Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, jSONObject, jSONObject2, p73Var) == null) {
            String str = p73Var.e;
            String str2 = p73Var.f;
            if (a) {
                n73.b("apply dep path, name = " + p73Var.a + "; inline = " + p73Var.g + "; path = " + str + "; config = " + str2);
            }
            if (TextUtils.isEmpty(str)) {
                n73.b(Log.getStackTraceString(new Throwable(p73Var.a + " path is empty")));
                return;
            }
            vo3.f(jSONObject, p73Var.a, str);
            if (!TextUtils.isEmpty(p73Var.f)) {
                File file = new File(str, str2);
                if (file.exists() && file.isFile()) {
                    vo3.f(jSONObject2, p73Var.a, vo3.d(zr4.E(file)));
                }
            }
        }
    }
}
