package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ds6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cs6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cs6 a() {
        InterceptResult invokeV;
        cs6 cs6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ds6.class) {
                if (a == null) {
                    a = new cs6();
                }
                cs6Var = a;
            }
            return cs6Var;
        }
        return (cs6) invokeV.objValue;
    }
}
