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
public class d63 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947656456, "Lcom/baidu/tieba/d63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947656456, "Lcom/baidu/tieba/d63;");
                return;
            }
        }
        a = ir1.a;
    }

    public static void a(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, swanAppConfigData) != null) || swanAppConfigData == null) {
            return;
        }
        List<s63> e = swanAppConfigData.e();
        if (e != null && !e.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            b(e, jSONObject, jSONObject2);
            if (nl2.k()) {
                boolean z = false;
                for (s63 s63Var : e) {
                    String h = nl2.h(s63Var.a);
                    if (!TextUtils.isEmpty(h) && new File(h).exists()) {
                        s63Var.e = h;
                        c(jSONObject, jSONObject2, s63Var);
                        z = true;
                        y72.i("Module-Plugin", "use debug dependencies，name=" + s63Var.a + " path=" + s63Var.e);
                    } else {
                        y72.o("Module-Plugin", "debug dependencies not exist，name=" + s63Var.a + " path=" + s63Var.e);
                    }
                }
                if (!z) {
                    qa3.g(AppRuntime.getAppContext(), "no debug dependency").G();
                    y72.c("Module-Plugin", "no debug dependency");
                }
            }
            String jSONObject3 = jSONObject.toString();
            String jSONObject4 = jSONObject2.toString();
            w63.c("dependenciesPath", jSONObject3);
            w63.c("dependenciesConfig", jSONObject4);
            return;
        }
        w63.c("dependenciesPath", null);
        w63.c("dependenciesConfig", null);
        if (a) {
            q63.b("this swan app not apply on someone dynamic lib");
        }
    }

    public static void b(@NonNull List<s63> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65538, null, list, jSONObject, jSONObject2) != null) || list.isEmpty()) {
            return;
        }
        for (s63 s63Var : list) {
            if (s63Var != null) {
                if (s63Var.g) {
                    c(jSONObject, jSONObject2, s63Var);
                } else {
                    zj4 q = vi4.i().q(s63Var.a, s63Var.h, s63Var.i);
                    if (q == null) {
                        q63.a(Log.getStackTraceString(new Throwable(s63Var.a + " query db fail")));
                    } else {
                        File t = ut2.t(s63Var.a, String.valueOf(q.i));
                        if (t != null && t.exists()) {
                            s63Var.e = t.getAbsolutePath();
                            c(jSONObject, jSONObject2, s63Var);
                        } else {
                            q63.a(Log.getStackTraceString(new Throwable(s63Var.a + " local file not exist")));
                        }
                    }
                }
            }
        }
    }

    public static void c(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull s63 s63Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, jSONObject, jSONObject2, s63Var) == null) {
            String str = s63Var.e;
            String str2 = s63Var.f;
            if (a) {
                q63.b("apply dep path, name = " + s63Var.a + "; inline = " + s63Var.g + "; path = " + str + "; config = " + str2);
            }
            if (TextUtils.isEmpty(str)) {
                q63.b(Log.getStackTraceString(new Throwable(s63Var.a + " path is empty")));
                return;
            }
            yn3.f(jSONObject, s63Var.a, str);
            if (!TextUtils.isEmpty(s63Var.f)) {
                File file = new File(str, str2);
                if (file.exists() && file.isFile()) {
                    yn3.f(jSONObject2, s63Var.a, yn3.d(cr4.E(file)));
                }
            }
        }
    }
}
