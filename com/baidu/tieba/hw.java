package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class hw {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, gw> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448306814, "Lcom/baidu/tieba/hw;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448306814, "Lcom/baidu/tieba/hw;");
                return;
            }
        }
        a = new HashMap<>();
    }

    public static synchronized gw a(String str) {
        InterceptResult invokeL;
        gw b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            synchronized (hw.class) {
                b = b(str, 0);
            }
            return b;
        }
        return (gw) invokeL.objValue;
    }

    public static synchronized void c(gw gwVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, gwVar) == null) {
            synchronized (hw.class) {
                if (gwVar != null) {
                    gwVar.a();
                    a.values().remove(gwVar);
                }
            }
        }
    }

    public static synchronized gw b(String str, int i) {
        InterceptResult invokeLI;
        gw gwVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            synchronized (hw.class) {
                if (a.containsKey(str) && (gwVar = a.get(str)) != null) {
                    return gwVar;
                }
                gw gwVar2 = new gw(str, i);
                try {
                    gwVar2.start();
                } catch (Exception unused) {
                }
                a.put(str, gwVar2);
                return gwVar2;
            }
        }
        return (gw) invokeLI.objValue;
    }
}
