package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class ax {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, zw> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448300118, "Lcom/baidu/tieba/ax;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448300118, "Lcom/baidu/tieba/ax;");
                return;
            }
        }
        a = new HashMap<>();
    }

    public static synchronized zw a(String str) {
        InterceptResult invokeL;
        zw b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            synchronized (ax.class) {
                b = b(str, 0);
            }
            return b;
        }
        return (zw) invokeL.objValue;
    }

    public static synchronized void c(zw zwVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, zwVar) == null) {
            synchronized (ax.class) {
                if (zwVar != null) {
                    zwVar.a();
                    a.values().remove(zwVar);
                }
            }
        }
    }

    public static synchronized zw b(String str, int i) {
        InterceptResult invokeLI;
        zw zwVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            synchronized (ax.class) {
                if (a.containsKey(str) && (zwVar = a.get(str)) != null) {
                    return zwVar;
                }
                zw zwVar2 = new zw(str, i);
                try {
                    zwVar2.start();
                } catch (Exception unused) {
                }
                a.put(str, zwVar2);
                return zwVar2;
            }
        }
        return (zw) invokeLI.objValue;
    }
}
