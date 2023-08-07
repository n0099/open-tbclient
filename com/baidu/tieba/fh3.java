package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.ubc.Flow;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class fh3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static eh3 a(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            Flow d = eq4.d(str);
            if (g()) {
                obj = fu2.A0().beginFlow(str);
            } else {
                obj = null;
            }
            return new eh3(obj, d);
        }
        return (eh3) invokeL.objValue;
    }

    public static void b(@NonNull eh3 eh3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, eh3Var) == null) {
            if (g()) {
                fu2.A0().b(eh3Var.b());
            }
            Flow a = eh3Var.a();
            if (a != null) {
                a.cancel();
            }
        }
    }

    public static void c(@NonNull eh3 eh3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, eh3Var) == null) {
            if (g()) {
                fu2.A0().c(eh3Var.b());
            }
            Flow a = eh3Var.a();
            if (a != null) {
                a.end();
            }
        }
    }

    public static void d(@NonNull eh3 eh3Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, eh3Var, str, str2) == null) {
            if (g()) {
                fu2.A0().a(eh3Var.b(), str, str2);
            }
            Flow a = eh3Var.a();
            if (a != null) {
                a.addEvent(str, str2);
            }
        }
    }

    public static void i(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, str, str2, jSONObject) == null) {
            if (g()) {
                fu2.A0().f(str, jSONObject);
            }
            eq4.l(str2, jSONObject);
        }
    }

    public static void e(@NonNull eh3 eh3Var, String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{eh3Var, str, str2, Long.valueOf(j)}) == null) {
            if (g()) {
                fu2.A0().g(eh3Var.b(), str, str2, j);
            }
            Flow a = eh3Var.a();
            if (a != null) {
                a.addEvent(str, str2, j);
            }
        }
    }

    public static void f(@NonNull eh3 eh3Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, eh3Var, str) == null) {
            if (g()) {
                fu2.A0().h(eh3Var.b(), str);
            }
            Flow a = eh3Var.a();
            if (a != null) {
                a.setValueWithDuration(str);
            }
        }
    }

    public static void h(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, str2) == null) {
            if (g()) {
                fu2.A0().i(str, str2);
            }
            eq4.h(str, str2);
        }
    }

    public static void j(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, map) == null) {
            if (g()) {
                fu2.A0().d(str, map);
            }
            eq4.j(str, map);
        }
    }

    public static void k(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, jSONObject) == null) {
            if (g()) {
                fu2.A0().f(str, jSONObject);
            }
            eq4.l(str, jSONObject);
        }
    }

    public static void l(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, str, str2) == null) {
            fu2.A0().i(str, str2);
        }
    }

    public static void m(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, jSONObject) == null) {
            fu2.A0().f(str, jSONObject);
        }
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return fu2.A0().e();
        }
        return invokeV.booleanValue;
    }
}
