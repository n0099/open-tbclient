package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ds8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cs8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cs8 a() {
        InterceptResult invokeV;
        cs8 cs8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ds8.class) {
                if (a == null) {
                    a = new cs8();
                }
                cs8Var = a;
            }
            return cs8Var;
        }
        return (cs8) invokeV.objValue;
    }
}
