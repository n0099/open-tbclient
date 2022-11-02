package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes4.dex */
public final class gw {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, fw> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448305853, "Lcom/baidu/tieba/gw;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448305853, "Lcom/baidu/tieba/gw;");
                return;
            }
        }
        a = new HashMap<>();
    }

    public static synchronized fw a(String str) {
        InterceptResult invokeL;
        fw b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            synchronized (gw.class) {
                b = b(str, 0);
            }
            return b;
        }
        return (fw) invokeL.objValue;
    }

    public static synchronized void c(fw fwVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, fwVar) == null) {
            synchronized (gw.class) {
                if (fwVar != null) {
                    fwVar.a();
                    a.values().remove(fwVar);
                }
            }
        }
    }

    public static synchronized fw b(String str, int i) {
        InterceptResult invokeLI;
        fw fwVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            synchronized (gw.class) {
                if (a.containsKey(str) && (fwVar = a.get(str)) != null) {
                    return fwVar;
                }
                fw fwVar2 = new fw(str, i);
                try {
                    fwVar2.start();
                } catch (Exception unused) {
                }
                a.put(str, fwVar2);
                return fwVar2;
            }
        }
        return (fw) invokeLI.objValue;
    }
}
