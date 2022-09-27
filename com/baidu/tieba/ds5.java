package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class ds5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cs5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cs5 a() {
        InterceptResult invokeV;
        cs5 cs5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ds5.class) {
                if (a == null) {
                    a = new cs5();
                }
                cs5Var = a;
            }
            return cs5Var;
        }
        return (cs5) invokeV.objValue;
    }
}
