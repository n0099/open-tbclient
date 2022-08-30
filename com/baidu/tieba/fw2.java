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
/* loaded from: classes4.dex */
public class fw2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947778472, "Lcom/baidu/tieba/fw2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947778472, "Lcom/baidu/tieba/fw2;");
                return;
            }
        }
        a = kh1.a;
    }

    public static void a(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, swanAppConfigData) == null) || swanAppConfigData == null) {
            return;
        }
        List<uw2> e = swanAppConfigData.e();
        if (e != null && !e.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            b(e, jSONObject, jSONObject2);
            if (pb2.k()) {
                boolean z = false;
                for (uw2 uw2Var : e) {
                    String h = pb2.h(uw2Var.a);
                    if (!TextUtils.isEmpty(h) && new File(h).exists()) {
                        uw2Var.e = h;
                        c(jSONObject, jSONObject2, uw2Var);
                        z = true;
                        ay1.i("Module-Plugin", "use debug dependencies，name=" + uw2Var.a + " path=" + uw2Var.e);
                    } else {
                        ay1.o("Module-Plugin", "debug dependencies not exist，name=" + uw2Var.a + " path=" + uw2Var.e);
                    }
                }
                if (!z) {
                    s03.g(AppRuntime.getAppContext(), "no debug dependency").G();
                    ay1.c("Module-Plugin", "no debug dependency");
                }
            }
            String jSONObject3 = jSONObject.toString();
            String jSONObject4 = jSONObject2.toString();
            yw2.c("dependenciesPath", jSONObject3);
            yw2.c("dependenciesConfig", jSONObject4);
            return;
        }
        yw2.c("dependenciesPath", null);
        yw2.c("dependenciesConfig", null);
        if (a) {
            sw2.b("this swan app not apply on someone dynamic lib");
        }
    }

    public static void b(@NonNull List<uw2> list, @NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, list, jSONObject, jSONObject2) == null) || list.isEmpty()) {
            return;
        }
        for (uw2 uw2Var : list) {
            if (uw2Var != null) {
                if (uw2Var.g) {
                    c(jSONObject, jSONObject2, uw2Var);
                } else {
                    z94 q = v84.i().q(uw2Var.a, uw2Var.h, uw2Var.i);
                    if (q == null) {
                        sw2.a(Log.getStackTraceString(new Throwable(uw2Var.a + " query db fail")));
                    } else {
                        File t = wj2.t(uw2Var.a, String.valueOf(q.i));
                        if (t != null && t.exists()) {
                            uw2Var.e = t.getAbsolutePath();
                            c(jSONObject, jSONObject2, uw2Var);
                        } else {
                            sw2.a(Log.getStackTraceString(new Throwable(uw2Var.a + " local file not exist")));
                        }
                    }
                }
            }
        }
    }

    public static void c(@NonNull JSONObject jSONObject, @NonNull JSONObject jSONObject2, @NonNull uw2 uw2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, jSONObject, jSONObject2, uw2Var) == null) {
            String str = uw2Var.e;
            String str2 = uw2Var.f;
            if (a) {
                sw2.b("apply dep path, name = " + uw2Var.a + "; inline = " + uw2Var.g + "; path = " + str + "; config = " + str2);
            }
            if (TextUtils.isEmpty(str)) {
                sw2.b(Log.getStackTraceString(new Throwable(uw2Var.a + " path is empty")));
                return;
            }
            ae3.f(jSONObject, uw2Var.a, str);
            if (TextUtils.isEmpty(uw2Var.f)) {
                return;
            }
            File file = new File(str, str2);
            if (file.exists() && file.isFile()) {
                ae3.f(jSONObject2, uw2Var.a, ae3.d(ch4.E(file)));
            }
        }
    }
}
