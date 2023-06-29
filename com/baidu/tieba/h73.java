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
public class h73 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947776581, "Lcom/baidu/tieba/h73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947776581, "Lcom/baidu/tieba/h73;");
                return;
            }
        }
        a = ms1.a;
    }

    public static void a(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, swanAppConfigData) != null) || swanAppConfigData == null) {
            return;
        }
        List<w73> e = swanAppConfigData.e();
        if (e != null && !e.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            b(e, jSONObject, jSONObject2);
            if (rm2.k()) {
                boolean z = false;
                for (w73 w73Var : e) {
                    String h = rm2.h(w73Var.a);
                    if (!TextUtils.isEmpty(h) && new File(h).exists()) {
                        w73Var.e = h;
                        c(jSONObject, jSONObject2, w73Var);
                        z = true;
                        c92.i("Module-Plugin", "use debug dependencies，name=" + w73Var.a + " path=" + w73Var.e);
                    } else {
                        c92.o("Module-Plugin", "debug dependencies not exist，name=" + w73Var.a + " path=" + w73Var.e);
                    }
                }
                if (!z) {
                    ub3.g(AppRuntime.getAppContext(), "no debug dependency").G();
                    c92.c("Module-Plugin", "no debug dependency");
                }
            }
            String jSONObject3 = jSONObject.toString();
            String jSONObject4 = jSONObject2.toString();
            a83.c("dependenciesPath", jSONObject3);
            a83.c("dependenciesConfig", jSONObject4);
            return;
        }
        a83.c("dependenciesPath", null);
        a83.c("dependenciesConfig", null);
        if (a) {
            u73.b("this swan app not apply on someone dynamic lib");
        }
    }

    public static void b(@NonNull List<w73> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65538, null, list, jSONObject, jSONObject2) != null) || list.isEmpty()) {
            return;
        }
        for (w73 w73Var : list) {
            if (w73Var != null) {
                if (w73Var.g) {
                    c(jSONObject, jSONObject2, w73Var);
                } else {
                    dl4 q = zj4.i().q(w73Var.a, w73Var.h, w73Var.i);
                    if (q == null) {
                        u73.a(Log.getStackTraceString(new Throwable(w73Var.a + " query db fail")));
                    } else {
                        File t = yu2.t(w73Var.a, String.valueOf(q.i));
                        if (t != null && t.exists()) {
                            w73Var.e = t.getAbsolutePath();
                            c(jSONObject, jSONObject2, w73Var);
                        } else {
                            u73.a(Log.getStackTraceString(new Throwable(w73Var.a + " local file not exist")));
                        }
                    }
                }
            }
        }
    }

    public static void c(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull w73 w73Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, jSONObject, jSONObject2, w73Var) == null) {
            String str = w73Var.e;
            String str2 = w73Var.f;
            if (a) {
                u73.b("apply dep path, name = " + w73Var.a + "; inline = " + w73Var.g + "; path = " + str + "; config = " + str2);
            }
            if (TextUtils.isEmpty(str)) {
                u73.b(Log.getStackTraceString(new Throwable(w73Var.a + " path is empty")));
                return;
            }
            cp3.f(jSONObject, w73Var.a, str);
            if (!TextUtils.isEmpty(w73Var.f)) {
                File file = new File(str, str2);
                if (file.exists() && file.isFile()) {
                    cp3.f(jSONObject2, w73Var.a, cp3.d(gs4.E(file)));
                }
            }
        }
    }
}
