package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes5.dex */
public final class aw {
    public static /* synthetic */ Interceptable $ic;
    public static HashMap<String, zv> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448300087, "Lcom/baidu/tieba/aw;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448300087, "Lcom/baidu/tieba/aw;");
                return;
            }
        }
        a = new HashMap<>();
    }

    public static synchronized zv a(String str) {
        InterceptResult invokeL;
        zv b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            synchronized (aw.class) {
                b = b(str, 0);
            }
            return b;
        }
        return (zv) invokeL.objValue;
    }

    public static synchronized void c(zv zvVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, zvVar) == null) {
            synchronized (aw.class) {
                if (zvVar != null) {
                    zvVar.a();
                    a.values().remove(zvVar);
                }
            }
        }
    }

    public static synchronized zv b(String str, int i) {
        InterceptResult invokeLI;
        zv zvVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i)) == null) {
            synchronized (aw.class) {
                if (a.containsKey(str) && (zvVar = a.get(str)) != null) {
                    return zvVar;
                }
                zv zvVar2 = new zv(str, i);
                try {
                    zvVar2.start();
                } catch (Exception unused) {
                }
                a.put(str, zvVar2);
                return zvVar2;
            }
        }
        return (zv) invokeLI.objValue;
    }
}
