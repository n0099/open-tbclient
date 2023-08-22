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
/* loaded from: classes6.dex */
public class i63 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947805411, "Lcom/baidu/tieba/i63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947805411, "Lcom/baidu/tieba/i63;");
                return;
            }
        }
        a = nr1.a;
    }

    public static void a(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, swanAppConfigData) != null) || swanAppConfigData == null) {
            return;
        }
        List<x63> e = swanAppConfigData.e();
        if (e != null && !e.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            b(e, jSONObject, jSONObject2);
            if (sl2.k()) {
                boolean z = false;
                for (x63 x63Var : e) {
                    String h = sl2.h(x63Var.a);
                    if (!TextUtils.isEmpty(h) && new File(h).exists()) {
                        x63Var.e = h;
                        c(jSONObject, jSONObject2, x63Var);
                        z = true;
                        d82.i("Module-Plugin", "use debug dependencies，name=" + x63Var.a + " path=" + x63Var.e);
                    } else {
                        d82.o("Module-Plugin", "debug dependencies not exist，name=" + x63Var.a + " path=" + x63Var.e);
                    }
                }
                if (!z) {
                    va3.g(AppRuntime.getAppContext(), "no debug dependency").G();
                    d82.c("Module-Plugin", "no debug dependency");
                }
            }
            String jSONObject3 = jSONObject.toString();
            String jSONObject4 = jSONObject2.toString();
            b73.c("dependenciesPath", jSONObject3);
            b73.c("dependenciesConfig", jSONObject4);
            return;
        }
        b73.c("dependenciesPath", null);
        b73.c("dependenciesConfig", null);
        if (a) {
            v63.b("this swan app not apply on someone dynamic lib");
        }
    }

    public static void b(@NonNull List<x63> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65538, null, list, jSONObject, jSONObject2) != null) || list.isEmpty()) {
            return;
        }
        for (x63 x63Var : list) {
            if (x63Var != null) {
                if (x63Var.g) {
                    c(jSONObject, jSONObject2, x63Var);
                } else {
                    ek4 q = aj4.i().q(x63Var.a, x63Var.h, x63Var.i);
                    if (q == null) {
                        v63.a(Log.getStackTraceString(new Throwable(x63Var.a + " query db fail")));
                    } else {
                        File t = zt2.t(x63Var.a, String.valueOf(q.i));
                        if (t != null && t.exists()) {
                            x63Var.e = t.getAbsolutePath();
                            c(jSONObject, jSONObject2, x63Var);
                        } else {
                            v63.a(Log.getStackTraceString(new Throwable(x63Var.a + " local file not exist")));
                        }
                    }
                }
            }
        }
    }

    public static void c(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull x63 x63Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, jSONObject, jSONObject2, x63Var) == null) {
            String str = x63Var.e;
            String str2 = x63Var.f;
            if (a) {
                v63.b("apply dep path, name = " + x63Var.a + "; inline = " + x63Var.g + "; path = " + str + "; config = " + str2);
            }
            if (TextUtils.isEmpty(str)) {
                v63.b(Log.getStackTraceString(new Throwable(x63Var.a + " path is empty")));
                return;
            }
            do3.f(jSONObject, x63Var.a, str);
            if (!TextUtils.isEmpty(x63Var.f)) {
                File file = new File(str, str2);
                if (file.exists() && file.isFile()) {
                    do3.f(jSONObject2, x63Var.a, do3.d(hr4.E(file)));
                }
            }
        }
    }
}
