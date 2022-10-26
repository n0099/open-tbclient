package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class hj3 {
    public static /* synthetic */ Interceptable $ic;
    public static jj3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static jj3 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new jj3("0");
            }
            return a;
        }
        return (jj3) invokeV.objValue;
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            jj3 jj3Var = a;
            if (jj3Var == null) {
                a = new jj3(str);
            } else {
                jj3Var.n(str);
            }
        }
    }
}
