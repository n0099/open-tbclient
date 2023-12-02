package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class d34 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c34 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized c34 a() {
        InterceptResult invokeV;
        c34 c34Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (d34.class) {
                if (a == null) {
                    a = new c34();
                }
                c34Var = a;
            }
            return c34Var;
        }
        return (c34) invokeV.objValue;
    }
}
