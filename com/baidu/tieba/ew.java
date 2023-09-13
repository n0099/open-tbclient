package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class ew {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, dw> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448303931, "Lcom/baidu/tieba/ew;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448303931, "Lcom/baidu/tieba/ew;");
                return;
            }
        }
        a = new HashMap<>();
    }

    public static synchronized dw a(String str) {
        InterceptResult invokeL;
        dw b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            synchronized (ew.class) {
                b = b(str, 0);
            }
            return b;
        }
        return (dw) invokeL.objValue;
    }

    public static synchronized void c(dw dwVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, dwVar) == null) {
            synchronized (ew.class) {
                if (dwVar != null) {
                    dwVar.a();
                    a.values().remove(dwVar);
                }
            }
        }
    }

    public static synchronized dw b(String str, int i) {
        InterceptResult invokeLI;
        dw dwVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            synchronized (ew.class) {
                if (a.containsKey(str) && (dwVar = a.get(str)) != null) {
                    return dwVar;
                }
                dw dwVar2 = new dw(str, i);
                try {
                    dwVar2.start();
                } catch (Exception unused) {
                }
                a.put(str, dwVar2);
                return dwVar2;
            }
        }
        return (dw) invokeLI.objValue;
    }
}
