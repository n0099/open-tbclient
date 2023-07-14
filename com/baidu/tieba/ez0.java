package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ez0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dz0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dz0 a() {
        InterceptResult invokeV;
        dz0 dz0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ez0.class) {
                if (a == null) {
                    a = new dz0();
                }
                dz0Var = a;
            }
            return dz0Var;
        }
        return (dz0) invokeV.objValue;
    }
}
