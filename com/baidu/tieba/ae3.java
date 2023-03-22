package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.ubc.Flow;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ae3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static zd3 a(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            Flow d = zm4.d(str);
            if (g()) {
                obj = ar2.A0().beginFlow(str);
            } else {
                obj = null;
            }
            return new zd3(obj, d);
        }
        return (zd3) invokeL.objValue;
    }

    public static void b(@NonNull zd3 zd3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, zd3Var) == null) {
            if (g()) {
                ar2.A0().b(zd3Var.b());
            }
            Flow a = zd3Var.a();
            if (a != null) {
                a.cancel();
            }
        }
    }

    public static void c(@NonNull zd3 zd3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, zd3Var) == null) {
            if (g()) {
                ar2.A0().c(zd3Var.b());
            }
            Flow a = zd3Var.a();
            if (a != null) {
                a.end();
            }
        }
    }

    public static void d(@NonNull zd3 zd3Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, zd3Var, str, str2) == null) {
            if (g()) {
                ar2.A0().a(zd3Var.b(), str, str2);
            }
            Flow a = zd3Var.a();
            if (a != null) {
                a.addEvent(str, str2);
            }
        }
    }

    public static void i(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, str, str2, jSONObject) == null) {
            if (g()) {
                ar2.A0().f(str, jSONObject);
            }
            zm4.l(str2, jSONObject);
        }
    }

    public static void e(@NonNull zd3 zd3Var, String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{zd3Var, str, str2, Long.valueOf(j)}) == null) {
            if (g()) {
                ar2.A0().g(zd3Var.b(), str, str2, j);
            }
            Flow a = zd3Var.a();
            if (a != null) {
                a.addEvent(str, str2, j);
            }
        }
    }

    public static void f(@NonNull zd3 zd3Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, zd3Var, str) == null) {
            if (g()) {
                ar2.A0().h(zd3Var.b(), str);
            }
            Flow a = zd3Var.a();
            if (a != null) {
                a.setValueWithDuration(str);
            }
        }
    }

    public static void h(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, str2) == null) {
            if (g()) {
                ar2.A0().i(str, str2);
            }
            zm4.h(str, str2);
        }
    }

    public static void j(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, map) == null) {
            if (g()) {
                ar2.A0().d(str, map);
            }
            zm4.j(str, map);
        }
    }

    public static void k(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, jSONObject) == null) {
            if (g()) {
                ar2.A0().f(str, jSONObject);
            }
            zm4.l(str, jSONObject);
        }
    }

    public static void l(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, str, str2) == null) {
            ar2.A0().i(str, str2);
        }
    }

    public static void m(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, jSONObject) == null) {
            ar2.A0().f(str, jSONObject);
        }
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return ar2.A0().e();
        }
        return invokeV.booleanValue;
    }
}
