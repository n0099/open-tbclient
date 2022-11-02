package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class b8 {
    public static /* synthetic */ Interceptable $ic;
    public static final x7<Class, a8> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448299095, "Lcom/baidu/tieba/b8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448299095, "Lcom/baidu/tieba/b8;");
                return;
            }
        }
        a = new x7<>();
    }

    public static <T> a8<T> a(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, cls)) == null) {
            return b(cls, 100);
        }
        return (a8) invokeL.objValue;
    }

    public static <T> a8<T> b(Class<T> cls, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, cls, i)) == null) {
            a8<T> c = a.c(cls);
            if (c == null) {
                e8 e8Var = new e8(cls, 4, i);
                a.i(cls, e8Var);
                return e8Var;
            }
            return c;
        }
        return (a8) invokeLI.objValue;
    }
}
