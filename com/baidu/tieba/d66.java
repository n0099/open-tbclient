package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class d66 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c66 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized c66 a() {
        InterceptResult invokeV;
        c66 c66Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (d66.class) {
                if (a == null) {
                    a = new c66();
                }
                c66Var = a;
            }
            return c66Var;
        }
        return (c66) invokeV.objValue;
    }
}
