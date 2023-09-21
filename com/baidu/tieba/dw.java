package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class dw {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, cw> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448302970, "Lcom/baidu/tieba/dw;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448302970, "Lcom/baidu/tieba/dw;");
                return;
            }
        }
        a = new HashMap<>();
    }

    public static synchronized cw a(String str) {
        InterceptResult invokeL;
        cw b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            synchronized (dw.class) {
                b = b(str, 0);
            }
            return b;
        }
        return (cw) invokeL.objValue;
    }

    public static synchronized void c(cw cwVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, cwVar) == null) {
            synchronized (dw.class) {
                if (cwVar != null) {
                    cwVar.a();
                    a.values().remove(cwVar);
                }
            }
        }
    }

    public static synchronized cw b(String str, int i) {
        InterceptResult invokeLI;
        cw cwVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            synchronized (dw.class) {
                if (a.containsKey(str) && (cwVar = a.get(str)) != null) {
                    return cwVar;
                }
                cw cwVar2 = new cw(str, i);
                try {
                    cwVar2.start();
                } catch (Exception unused) {
                }
                a.put(str, cwVar2);
                return cwVar2;
            }
        }
        return (cw) invokeLI.objValue;
    }
}
