package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class ar {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, zq> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448299932, "Lcom/baidu/tieba/ar;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448299932, "Lcom/baidu/tieba/ar;");
                return;
            }
        }
        a = new HashMap<>();
    }

    public static synchronized zq a(String str) {
        InterceptResult invokeL;
        zq b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            synchronized (ar.class) {
                b = b(str, 0);
            }
            return b;
        }
        return (zq) invokeL.objValue;
    }

    public static synchronized void c(zq zqVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, zqVar) == null) {
            synchronized (ar.class) {
                if (zqVar != null) {
                    zqVar.a();
                    a.values().remove(zqVar);
                }
            }
        }
    }

    public static synchronized zq b(String str, int i) {
        InterceptResult invokeLI;
        zq zqVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            synchronized (ar.class) {
                if (a.containsKey(str) && (zqVar = a.get(str)) != null) {
                    return zqVar;
                }
                zq zqVar2 = new zq(str, i);
                try {
                    zqVar2.start();
                } catch (Exception unused) {
                }
                a.put(str, zqVar2);
                return zqVar2;
            }
        }
        return (zq) invokeLI.objValue;
    }
}
