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
public class dy2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947720812, "Lcom/baidu/tieba/dy2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947720812, "Lcom/baidu/tieba/dy2;");
                return;
            }
        }
        a = ij1.a;
    }

    public static void a(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, swanAppConfigData) == null) || swanAppConfigData == null) {
            return;
        }
        List<sy2> e = swanAppConfigData.e();
        if (e != null && !e.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            b(e, jSONObject, jSONObject2);
            if (nd2.k()) {
                boolean z = false;
                for (sy2 sy2Var : e) {
                    String h = nd2.h(sy2Var.a);
                    if (!TextUtils.isEmpty(h) && new File(h).exists()) {
                        sy2Var.e = h;
                        c(jSONObject, jSONObject2, sy2Var);
                        z = true;
                        yz1.i("Module-Plugin", "use debug dependencies，name=" + sy2Var.a + " path=" + sy2Var.e);
                    } else {
                        yz1.o("Module-Plugin", "debug dependencies not exist，name=" + sy2Var.a + " path=" + sy2Var.e);
                    }
                }
                if (!z) {
                    q23.g(AppRuntime.getAppContext(), "no debug dependency").G();
                    yz1.c("Module-Plugin", "no debug dependency");
                }
            }
            String jSONObject3 = jSONObject.toString();
            String jSONObject4 = jSONObject2.toString();
            wy2.c("dependenciesPath", jSONObject3);
            wy2.c("dependenciesConfig", jSONObject4);
            return;
        }
        wy2.c("dependenciesPath", null);
        wy2.c("dependenciesConfig", null);
        if (a) {
            qy2.b("this swan app not apply on someone dynamic lib");
        }
    }

    public static void b(@NonNull List<sy2> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, list, jSONObject, jSONObject2) == null) || list.isEmpty()) {
            return;
        }
        for (sy2 sy2Var : list) {
            if (sy2Var != null) {
                if (sy2Var.g) {
                    c(jSONObject, jSONObject2, sy2Var);
                } else {
                    zb4 q = va4.i().q(sy2Var.a, sy2Var.h, sy2Var.i);
                    if (q == null) {
                        qy2.a(Log.getStackTraceString(new Throwable(sy2Var.a + " query db fail")));
                    } else {
                        File t = ul2.t(sy2Var.a, String.valueOf(q.i));
                        if (t != null && t.exists()) {
                            sy2Var.e = t.getAbsolutePath();
                            c(jSONObject, jSONObject2, sy2Var);
                        } else {
                            qy2.a(Log.getStackTraceString(new Throwable(sy2Var.a + " local file not exist")));
                        }
                    }
                }
            }
        }
    }

    public static void c(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull sy2 sy2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, jSONObject, jSONObject2, sy2Var) == null) {
            String str = sy2Var.e;
            String str2 = sy2Var.f;
            if (a) {
                qy2.b("apply dep path, name = " + sy2Var.a + "; inline = " + sy2Var.g + "; path = " + str + "; config = " + str2);
            }
            if (TextUtils.isEmpty(str)) {
                qy2.b(Log.getStackTraceString(new Throwable(sy2Var.a + " path is empty")));
                return;
            }
            yf3.f(jSONObject, sy2Var.a, str);
            if (TextUtils.isEmpty(sy2Var.f)) {
                return;
            }
            File file = new File(str, str2);
            if (file.exists() && file.isFile()) {
                yf3.f(jSONObject2, sy2Var.a, yf3.d(cj4.E(file)));
            }
        }
    }
}
