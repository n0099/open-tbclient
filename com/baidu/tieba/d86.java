package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class d86 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c86 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized c86 a() {
        InterceptResult invokeV;
        c86 c86Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (d86.class) {
                if (a == null) {
                    a = new c86();
                }
                c86Var = a;
            }
            return c86Var;
        }
        return (c86) invokeV.objValue;
    }
}
