package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class d04 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c04 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized c04 a() {
        InterceptResult invokeV;
        c04 c04Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (d04.class) {
                if (a == null) {
                    a = new c04();
                }
                c04Var = a;
            }
            return c04Var;
        }
        return (c04) invokeV.objValue;
    }
}
