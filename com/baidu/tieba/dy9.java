package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.JvmStatic;
/* loaded from: classes5.dex */
public final class dy9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947721029, "Lcom/baidu/tieba/dy9;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947721029, "Lcom/baidu/tieba/dy9;");
        }
    }

    @JvmStatic
    public static final void a(by9 by9Var, String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLI(65537, null, by9Var, str, str2, i) == null) && !b(by9Var, str) && by9Var != null) {
            by9Var.startLoad(str2, i, false);
        }
    }

    @JvmStatic
    public static final boolean b(by9 by9Var, String str) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, by9Var, str)) == null) {
            if (by9Var != null) {
                if (str != null && str.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    by9Var.startLoad(str);
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
