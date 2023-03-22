package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class hl {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, kl> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448306473, "Lcom/baidu/tieba/hl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448306473, "Lcom/baidu/tieba/hl;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("com.baidu.searchbox.livenps", new gl());
    }

    public static void a(String str, int i) {
        kl klVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65537, null, str, i) == null) && (klVar = a.get(str)) != null) {
            klVar.b(i);
        }
    }

    public static void b(String str, int i, long j) {
        kl klVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), Long.valueOf(j)}) == null) && (klVar = a.get(str)) != null) {
            klVar.c(i, j);
        }
    }

    public static void c(String str, int i, int i2) {
        kl klVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(65539, null, str, i, i2) == null) && (klVar = a.get(str)) != null) {
            klVar.d(i, i2);
        }
    }

    public static void d(String str, int i, int i2) {
        kl klVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) && (klVar = a.get(str)) != null) {
            klVar.e(i, i2);
        }
    }
}
