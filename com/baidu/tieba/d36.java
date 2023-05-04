package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class d36 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c36 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized c36 a() {
        InterceptResult invokeV;
        c36 c36Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (d36.class) {
                if (a == null) {
                    a = new c36();
                }
                c36Var = a;
            }
            return c36Var;
        }
        return (c36) invokeV.objValue;
    }
}
