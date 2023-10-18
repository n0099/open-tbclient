package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class d46 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c46 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized c46 a() {
        InterceptResult invokeV;
        c46 c46Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (d46.class) {
                if (a == null) {
                    a = new c46();
                }
                c46Var = a;
            }
            return c46Var;
        }
        return (c46) invokeV.objValue;
    }
}
