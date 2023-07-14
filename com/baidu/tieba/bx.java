package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class bx {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, ax> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448301079, "Lcom/baidu/tieba/bx;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448301079, "Lcom/baidu/tieba/bx;");
                return;
            }
        }
        a = new HashMap<>();
    }

    public static synchronized ax a(String str) {
        InterceptResult invokeL;
        ax b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            synchronized (bx.class) {
                b = b(str, 0);
            }
            return b;
        }
        return (ax) invokeL.objValue;
    }

    public static synchronized void c(ax axVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, axVar) == null) {
            synchronized (bx.class) {
                if (axVar != null) {
                    axVar.a();
                    a.values().remove(axVar);
                }
            }
        }
    }

    public static synchronized ax b(String str, int i) {
        InterceptResult invokeLI;
        ax axVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            synchronized (bx.class) {
                if (a.containsKey(str) && (axVar = a.get(str)) != null) {
                    return axVar;
                }
                ax axVar2 = new ax(str, i);
                try {
                    axVar2.start();
                } catch (Exception unused) {
                }
                a.put(str, axVar2);
                return axVar2;
            }
        }
        return (ax) invokeLI.objValue;
    }
}
