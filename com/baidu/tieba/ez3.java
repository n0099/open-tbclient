package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ez3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dz3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dz3 a() {
        InterceptResult invokeV;
        dz3 dz3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ez3.class) {
                if (a == null) {
                    a = new dz3();
                }
                dz3Var = a;
            }
            return dz3Var;
        }
        return (dz3) invokeV.objValue;
    }
}
