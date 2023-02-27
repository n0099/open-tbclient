package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class d09 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c09 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized c09 a() {
        InterceptResult invokeV;
        c09 c09Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (d09.class) {
                if (a == null) {
                    a = new c09();
                }
                c09Var = a;
            }
            return c09Var;
        }
        return (c09) invokeV.objValue;
    }
}
