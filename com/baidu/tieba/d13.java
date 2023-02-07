package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class d13 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c13 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized c13 a() {
        InterceptResult invokeV;
        c13 c13Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (d13.class) {
                if (a == null) {
                    a = new c13();
                }
                c13Var = a;
            }
            return c13Var;
        }
        return (c13) invokeV.objValue;
    }
}
