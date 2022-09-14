package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class d44 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c44 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized c44 a() {
        InterceptResult invokeV;
        c44 c44Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (d44.class) {
                if (a == null) {
                    a = new c44();
                }
                c44Var = a;
            }
            return c44Var;
        }
        return (c44) invokeV.objValue;
    }
}
