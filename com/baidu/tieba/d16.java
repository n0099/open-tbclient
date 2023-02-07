package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class d16 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c16 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized c16 a() {
        InterceptResult invokeV;
        c16 c16Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (d16.class) {
                if (a == null) {
                    a = new c16();
                }
                c16Var = a;
            }
            return c16Var;
        }
        return (c16) invokeV.objValue;
    }
}
