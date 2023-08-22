package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class cl {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, fl> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448301668, "Lcom/baidu/tieba/cl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448301668, "Lcom/baidu/tieba/cl;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("com.baidu.searchbox.livenps", new bl());
    }

    public static void a(String str, int i) {
        fl flVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65537, null, str, i) == null) && (flVar = a.get(str)) != null) {
            flVar.b(i);
        }
    }

    public static void b(String str, int i, long j) {
        fl flVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), Long.valueOf(j)}) == null) && (flVar = a.get(str)) != null) {
            flVar.c(i, j);
        }
    }

    public static void c(String str, int i, int i2) {
        fl flVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65539, null, str, i, i2) == null) && (flVar = a.get(str)) != null) {
            flVar.d(i, i2);
        }
    }

    public static void d(String str, int i, int i2) {
        fl flVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) && (flVar = a.get(str)) != null) {
            flVar.e(i, i2);
        }
    }
}
