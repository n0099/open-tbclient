package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class d3 {
    public static /* synthetic */ Interceptable $ic;
    public static final a3<Class, c3> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448300862, "Lcom/baidu/tieba/d3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448300862, "Lcom/baidu/tieba/d3;");
                return;
            }
        }
        a = new a3<>();
    }

    public static <T> c3<T> a(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cls)) == null) {
            return b(cls, 100);
        }
        return (c3) invokeL.objValue;
    }

    public static <T> c3<T> b(Class<T> cls, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, cls, i)) == null) {
            c3<T> b = a.b(cls);
            if (b == null) {
                e3 e3Var = new e3(cls, 4, i);
                a.h(cls, e3Var);
                return e3Var;
            }
            return b;
        }
        return (c3) invokeLI.objValue;
    }
}
