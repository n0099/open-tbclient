package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class d19 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c19 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized c19 a() {
        InterceptResult invokeV;
        c19 c19Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (d19.class) {
                if (a == null) {
                    a = new c19();
                }
                c19Var = a;
            }
            return c19Var;
        }
        return (c19) invokeV.objValue;
    }
}
