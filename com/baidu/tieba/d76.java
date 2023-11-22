package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class d76 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c76 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized c76 a() {
        InterceptResult invokeV;
        c76 c76Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (d76.class) {
                if (a == null) {
                    a = new c76();
                }
                c76Var = a;
            }
            return c76Var;
        }
        return (c76) invokeV.objValue;
    }
}
