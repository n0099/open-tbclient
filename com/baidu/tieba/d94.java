package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class d94 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c94 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized c94 a() {
        InterceptResult invokeV;
        c94 c94Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (d94.class) {
                if (a == null) {
                    a = new c94();
                }
                c94Var = a;
            }
            return c94Var;
        }
        return (c94) invokeV.objValue;
    }
}
