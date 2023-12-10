package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.JvmStatic;
/* loaded from: classes5.dex */
public final class ey9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947750820, "Lcom/baidu/tieba/ey9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947750820, "Lcom/baidu/tieba/ey9;");
        }
    }

    @JvmStatic
    public static final void a(cy9 cy9Var, String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(65537, null, cy9Var, str, str2, i) == null) && !b(cy9Var, str) && cy9Var != null) {
            cy9Var.startLoad(str2, i, false);
        }
    }

    @JvmStatic
    public static final boolean b(cy9 cy9Var, String str) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, cy9Var, str)) == null) {
            if (cy9Var != null) {
                if (str != null && str.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    cy9Var.startLoad(str);
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
