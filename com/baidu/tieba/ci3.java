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
public class ci3 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static bi3 a(String str) {
        InterceptResult invokeL;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            Flow d = br4.d(str);
            if (g()) {
                obj = cv2.A0().beginFlow(str);
            } else {
                obj = null;
            }
            return new bi3(obj, d);
        }
        return (bi3) invokeL.objValue;
    }

    public static void b(@NonNull bi3 bi3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, bi3Var) == null) {
            if (g()) {
                cv2.A0().b(bi3Var.b());
            }
            Flow a = bi3Var.a();
            if (a != null) {
                a.cancel();
            }
        }
    }

    public static void c(@NonNull bi3 bi3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, bi3Var) == null) {
            if (g()) {
                cv2.A0().c(bi3Var.b());
            }
            Flow a = bi3Var.a();
            if (a != null) {
                a.end();
            }
        }
    }

    public static void d(@NonNull bi3 bi3Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, bi3Var, str, str2) == null) {
            if (g()) {
                cv2.A0().a(bi3Var.b(), str, str2);
            }
            Flow a = bi3Var.a();
            if (a != null) {
                a.addEvent(str, str2);
            }
        }
    }

    public static void i(String str, String str2, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, str, str2, jSONObject) == null) {
            if (g()) {
                cv2.A0().f(str, jSONObject);
            }
            br4.l(str2, jSONObject);
        }
    }

    public static void e(@NonNull bi3 bi3Var, String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{bi3Var, str, str2, Long.valueOf(j)}) == null) {
            if (g()) {
                cv2.A0().g(bi3Var.b(), str, str2, j);
            }
            Flow a = bi3Var.a();
            if (a != null) {
                a.addEvent(str, str2, j);
            }
        }
    }

    public static void f(@NonNull bi3 bi3Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, bi3Var, str) == null) {
            if (g()) {
                cv2.A0().h(bi3Var.b(), str);
            }
            Flow a = bi3Var.a();
            if (a != null) {
                a.setValueWithDuration(str);
            }
        }
    }

    public static void h(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, str, str2) == null) {
            if (g()) {
                cv2.A0().i(str, str2);
            }
            br4.h(str, str2);
        }
    }

    public static void j(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, map) == null) {
            if (g()) {
                cv2.A0().d(str, map);
            }
            br4.j(str, map);
        }
    }

    public static void k(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65546, null, str, jSONObject) == null) {
            if (g()) {
                cv2.A0().f(str, jSONObject);
            }
            br4.l(str, jSONObject);
        }
    }

    public static void l(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, str, str2) == null) {
            cv2.A0().i(str, str2);
        }
    }

    public static void m(String str, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65548, null, str, jSONObject) == null) {
            cv2.A0().f(str, jSONObject);
        }
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return cv2.A0().e();
        }
        return invokeV.booleanValue;
    }
}
