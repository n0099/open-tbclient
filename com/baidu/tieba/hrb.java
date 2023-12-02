package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.jrb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.ubs.analytics.SampleResult;
import java.util.Map;
/* loaded from: classes6.dex */
public class hrb {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947834737, "Lcom/baidu/tieba/hrb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947834737, "Lcom/baidu/tieba/hrb;");
        }
    }

    public static SampleResult a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (a) {
                return jrb.a.a.f(str);
            }
            return SampleResult.OTHERE;
        }
        return (SampleResult) invokeL.objValue;
    }

    public static void b(irb irbVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, irbVar) != null) || irbVar == null) {
            return;
        }
        dsb.b(irbVar);
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) == null) && a) {
            bsb.a().b(str);
        }
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, str) == null) && a) {
            bsb.a().c(str);
        }
    }

    public static void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65542, null, z) == null) {
            a = z;
        }
    }

    public static void c(String str, String str2, String str3, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLL(65539, null, str, str2, str3, map) != null) || !a || str == null) {
            return;
        }
        gsb.a(str, str2, str3, map);
    }
}
