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
public class a33 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947564200, "Lcom/baidu/tieba/a33;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947564200, "Lcom/baidu/tieba/a33;");
                return;
            }
        }
        a = fo1.a;
    }

    public static void a(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, swanAppConfigData) != null) || swanAppConfigData == null) {
            return;
        }
        List<p33> e = swanAppConfigData.e();
        if (e != null && !e.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            b(e, jSONObject, jSONObject2);
            if (ki2.k()) {
                boolean z = false;
                for (p33 p33Var : e) {
                    String h = ki2.h(p33Var.a);
                    if (!TextUtils.isEmpty(h) && new File(h).exists()) {
                        p33Var.e = h;
                        c(jSONObject, jSONObject2, p33Var);
                        z = true;
                        v42.i("Module-Plugin", "use debug dependencies，name=" + p33Var.a + " path=" + p33Var.e);
                    } else {
                        v42.o("Module-Plugin", "debug dependencies not exist，name=" + p33Var.a + " path=" + p33Var.e);
                    }
                }
                if (!z) {
                    n73.g(AppRuntime.getAppContext(), "no debug dependency").G();
                    v42.c("Module-Plugin", "no debug dependency");
                }
            }
            String jSONObject3 = jSONObject.toString();
            String jSONObject4 = jSONObject2.toString();
            t33.c("dependenciesPath", jSONObject3);
            t33.c("dependenciesConfig", jSONObject4);
            return;
        }
        t33.c("dependenciesPath", null);
        t33.c("dependenciesConfig", null);
        if (a) {
            n33.b("this swan app not apply on someone dynamic lib");
        }
    }

    public static void b(@NonNull List<p33> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65538, null, list, jSONObject, jSONObject2) != null) || list.isEmpty()) {
            return;
        }
        for (p33 p33Var : list) {
            if (p33Var != null) {
                if (p33Var.g) {
                    c(jSONObject, jSONObject2, p33Var);
                } else {
                    wg4 q = sf4.i().q(p33Var.a, p33Var.h, p33Var.i);
                    if (q == null) {
                        n33.a(Log.getStackTraceString(new Throwable(p33Var.a + " query db fail")));
                    } else {
                        File t = rq2.t(p33Var.a, String.valueOf(q.i));
                        if (t != null && t.exists()) {
                            p33Var.e = t.getAbsolutePath();
                            c(jSONObject, jSONObject2, p33Var);
                        } else {
                            n33.a(Log.getStackTraceString(new Throwable(p33Var.a + " local file not exist")));
                        }
                    }
                }
            }
        }
    }

    public static void c(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull p33 p33Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, jSONObject, jSONObject2, p33Var) == null) {
            String str = p33Var.e;
            String str2 = p33Var.f;
            if (a) {
                n33.b("apply dep path, name = " + p33Var.a + "; inline = " + p33Var.g + "; path = " + str + "; config = " + str2);
            }
            if (TextUtils.isEmpty(str)) {
                n33.b(Log.getStackTraceString(new Throwable(p33Var.a + " path is empty")));
                return;
            }
            vk3.f(jSONObject, p33Var.a, str);
            if (!TextUtils.isEmpty(p33Var.f)) {
                File file = new File(str, str2);
                if (file.exists() && file.isFile()) {
                    vk3.f(jSONObject2, p33Var.a, vk3.d(zn4.E(file)));
                }
            }
        }
    }
}
