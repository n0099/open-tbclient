package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class dz3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cz3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cz3 a() {
        InterceptResult invokeV;
        cz3 cz3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dz3.class) {
                if (a == null) {
                    a = new cz3();
                }
                cz3Var = a;
            }
            return cz3Var;
        }
        return (cz3) invokeV.objValue;
    }
}
