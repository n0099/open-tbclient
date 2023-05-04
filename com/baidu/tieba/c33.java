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
public class c33 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947623782, "Lcom/baidu/tieba/c33;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947623782, "Lcom/baidu/tieba/c33;");
                return;
            }
        }
        a = ho1.a;
    }

    public static void a(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65537, null, swanAppConfigData) != null) || swanAppConfigData == null) {
            return;
        }
        List<r33> e = swanAppConfigData.e();
        if (e != null && !e.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            b(e, jSONObject, jSONObject2);
            if (mi2.k()) {
                boolean z = false;
                for (r33 r33Var : e) {
                    String h = mi2.h(r33Var.a);
                    if (!TextUtils.isEmpty(h) && new File(h).exists()) {
                        r33Var.e = h;
                        c(jSONObject, jSONObject2, r33Var);
                        z = true;
                        x42.i("Module-Plugin", "use debug dependencies，name=" + r33Var.a + " path=" + r33Var.e);
                    } else {
                        x42.o("Module-Plugin", "debug dependencies not exist，name=" + r33Var.a + " path=" + r33Var.e);
                    }
                }
                if (!z) {
                    p73.g(AppRuntime.getAppContext(), "no debug dependency").G();
                    x42.c("Module-Plugin", "no debug dependency");
                }
            }
            String jSONObject3 = jSONObject.toString();
            String jSONObject4 = jSONObject2.toString();
            v33.c("dependenciesPath", jSONObject3);
            v33.c("dependenciesConfig", jSONObject4);
            return;
        }
        v33.c("dependenciesPath", null);
        v33.c("dependenciesConfig", null);
        if (a) {
            p33.b("this swan app not apply on someone dynamic lib");
        }
    }

    public static void b(@NonNull List<r33> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65538, null, list, jSONObject, jSONObject2) != null) || list.isEmpty()) {
            return;
        }
        for (r33 r33Var : list) {
            if (r33Var != null) {
                if (r33Var.g) {
                    c(jSONObject, jSONObject2, r33Var);
                } else {
                    yg4 q = uf4.i().q(r33Var.a, r33Var.h, r33Var.i);
                    if (q == null) {
                        p33.a(Log.getStackTraceString(new Throwable(r33Var.a + " query db fail")));
                    } else {
                        File t = tq2.t(r33Var.a, String.valueOf(q.i));
                        if (t != null && t.exists()) {
                            r33Var.e = t.getAbsolutePath();
                            c(jSONObject, jSONObject2, r33Var);
                        } else {
                            p33.a(Log.getStackTraceString(new Throwable(r33Var.a + " local file not exist")));
                        }
                    }
                }
            }
        }
    }

    public static void c(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull r33 r33Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, jSONObject, jSONObject2, r33Var) == null) {
            String str = r33Var.e;
            String str2 = r33Var.f;
            if (a) {
                p33.b("apply dep path, name = " + r33Var.a + "; inline = " + r33Var.g + "; path = " + str + "; config = " + str2);
            }
            if (TextUtils.isEmpty(str)) {
                p33.b(Log.getStackTraceString(new Throwable(r33Var.a + " path is empty")));
                return;
            }
            xk3.f(jSONObject, r33Var.a, str);
            if (!TextUtils.isEmpty(r33Var.f)) {
                File file = new File(str, str2);
                if (file.exists() && file.isFile()) {
                    xk3.f(jSONObject2, r33Var.a, xk3.d(bo4.E(file)));
                }
            }
        }
    }
}
