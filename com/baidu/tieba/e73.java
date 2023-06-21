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
public class e73 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947687208, "Lcom/baidu/tieba/e73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947687208, "Lcom/baidu/tieba/e73;");
                return;
            }
        }
        a = js1.a;
    }

    public static void a(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, swanAppConfigData) != null) || swanAppConfigData == null) {
            return;
        }
        List<t73> e = swanAppConfigData.e();
        if (e != null && !e.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            b(e, jSONObject, jSONObject2);
            if (om2.k()) {
                boolean z = false;
                for (t73 t73Var : e) {
                    String h = om2.h(t73Var.a);
                    if (!TextUtils.isEmpty(h) && new File(h).exists()) {
                        t73Var.e = h;
                        c(jSONObject, jSONObject2, t73Var);
                        z = true;
                        z82.i("Module-Plugin", "use debug dependencies，name=" + t73Var.a + " path=" + t73Var.e);
                    } else {
                        z82.o("Module-Plugin", "debug dependencies not exist，name=" + t73Var.a + " path=" + t73Var.e);
                    }
                }
                if (!z) {
                    rb3.g(AppRuntime.getAppContext(), "no debug dependency").G();
                    z82.c("Module-Plugin", "no debug dependency");
                }
            }
            String jSONObject3 = jSONObject.toString();
            String jSONObject4 = jSONObject2.toString();
            x73.c("dependenciesPath", jSONObject3);
            x73.c("dependenciesConfig", jSONObject4);
            return;
        }
        x73.c("dependenciesPath", null);
        x73.c("dependenciesConfig", null);
        if (a) {
            r73.b("this swan app not apply on someone dynamic lib");
        }
    }

    public static void b(@NonNull List<t73> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65538, null, list, jSONObject, jSONObject2) != null) || list.isEmpty()) {
            return;
        }
        for (t73 t73Var : list) {
            if (t73Var != null) {
                if (t73Var.g) {
                    c(jSONObject, jSONObject2, t73Var);
                } else {
                    al4 q = wj4.i().q(t73Var.a, t73Var.h, t73Var.i);
                    if (q == null) {
                        r73.a(Log.getStackTraceString(new Throwable(t73Var.a + " query db fail")));
                    } else {
                        File t = vu2.t(t73Var.a, String.valueOf(q.i));
                        if (t != null && t.exists()) {
                            t73Var.e = t.getAbsolutePath();
                            c(jSONObject, jSONObject2, t73Var);
                        } else {
                            r73.a(Log.getStackTraceString(new Throwable(t73Var.a + " local file not exist")));
                        }
                    }
                }
            }
        }
    }

    public static void c(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull t73 t73Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, jSONObject, jSONObject2, t73Var) == null) {
            String str = t73Var.e;
            String str2 = t73Var.f;
            if (a) {
                r73.b("apply dep path, name = " + t73Var.a + "; inline = " + t73Var.g + "; path = " + str + "; config = " + str2);
            }
            if (TextUtils.isEmpty(str)) {
                r73.b(Log.getStackTraceString(new Throwable(t73Var.a + " path is empty")));
                return;
            }
            zo3.f(jSONObject, t73Var.a, str);
            if (!TextUtils.isEmpty(t73Var.f)) {
                File file = new File(str, str2);
                if (file.exists() && file.isFile()) {
                    zo3.f(jSONObject2, t73Var.a, zo3.d(ds4.E(file)));
                }
            }
        }
    }
}
