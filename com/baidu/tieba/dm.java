package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class dm {
    public static /* synthetic */ Interceptable $ic;
    public static Map<String, gm> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448302660, "Lcom/baidu/tieba/dm;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448302660, "Lcom/baidu/tieba/dm;");
                return;
            }
        }
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("com.baidu.searchbox.livenps", new cm());
    }

    public static void a(String str, int i) {
        gm gmVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65537, null, str, i) == null) || (gmVar = a.get(str)) == null) {
            return;
        }
        gmVar.b(i);
    }

    public static void b(String str, int i, long j) {
        gm gmVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Integer.valueOf(i), Long.valueOf(j)}) == null) || (gmVar = a.get(str)) == null) {
            return;
        }
        gmVar.c(i, j);
    }

    public static void c(String str, int i, int i2) {
        gm gmVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(65539, null, str, i, i2) == null) || (gmVar = a.get(str)) == null) {
            return;
        }
        gmVar.d(i, i2);
    }

    public static void d(String str, int i, int i2) {
        gm gmVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2) == null) || (gmVar = a.get(str)) == null) {
            return;
        }
        gmVar.e(i, i2);
    }
}
