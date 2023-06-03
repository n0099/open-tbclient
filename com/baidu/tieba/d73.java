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
public class d73 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947657417, "Lcom/baidu/tieba/d73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947657417, "Lcom/baidu/tieba/d73;");
                return;
            }
        }
        a = is1.a;
    }

    public static void a(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, swanAppConfigData) != null) || swanAppConfigData == null) {
            return;
        }
        List<s73> e = swanAppConfigData.e();
        if (e != null && !e.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            b(e, jSONObject, jSONObject2);
            if (nm2.k()) {
                boolean z = false;
                for (s73 s73Var : e) {
                    String h = nm2.h(s73Var.a);
                    if (!TextUtils.isEmpty(h) && new File(h).exists()) {
                        s73Var.e = h;
                        c(jSONObject, jSONObject2, s73Var);
                        z = true;
                        y82.i("Module-Plugin", "use debug dependencies，name=" + s73Var.a + " path=" + s73Var.e);
                    } else {
                        y82.o("Module-Plugin", "debug dependencies not exist，name=" + s73Var.a + " path=" + s73Var.e);
                    }
                }
                if (!z) {
                    qb3.g(AppRuntime.getAppContext(), "no debug dependency").G();
                    y82.c("Module-Plugin", "no debug dependency");
                }
            }
            String jSONObject3 = jSONObject.toString();
            String jSONObject4 = jSONObject2.toString();
            w73.c("dependenciesPath", jSONObject3);
            w73.c("dependenciesConfig", jSONObject4);
            return;
        }
        w73.c("dependenciesPath", null);
        w73.c("dependenciesConfig", null);
        if (a) {
            q73.b("this swan app not apply on someone dynamic lib");
        }
    }

    public static void b(@NonNull List<s73> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65538, null, list, jSONObject, jSONObject2) != null) || list.isEmpty()) {
            return;
        }
        for (s73 s73Var : list) {
            if (s73Var != null) {
                if (s73Var.g) {
                    c(jSONObject, jSONObject2, s73Var);
                } else {
                    zk4 q = vj4.i().q(s73Var.a, s73Var.h, s73Var.i);
                    if (q == null) {
                        q73.a(Log.getStackTraceString(new Throwable(s73Var.a + " query db fail")));
                    } else {
                        File t = uu2.t(s73Var.a, String.valueOf(q.i));
                        if (t != null && t.exists()) {
                            s73Var.e = t.getAbsolutePath();
                            c(jSONObject, jSONObject2, s73Var);
                        } else {
                            q73.a(Log.getStackTraceString(new Throwable(s73Var.a + " local file not exist")));
                        }
                    }
                }
            }
        }
    }

    public static void c(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull s73 s73Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, jSONObject, jSONObject2, s73Var) == null) {
            String str = s73Var.e;
            String str2 = s73Var.f;
            if (a) {
                q73.b("apply dep path, name = " + s73Var.a + "; inline = " + s73Var.g + "; path = " + str + "; config = " + str2);
            }
            if (TextUtils.isEmpty(str)) {
                q73.b(Log.getStackTraceString(new Throwable(s73Var.a + " path is empty")));
                return;
            }
            yo3.f(jSONObject, s73Var.a, str);
            if (!TextUtils.isEmpty(s73Var.f)) {
                File file = new File(str, str2);
                if (file.exists() && file.isFile()) {
                    yo3.f(jSONObject2, s73Var.a, yo3.d(cs4.E(file)));
                }
            }
        }
    }
}
