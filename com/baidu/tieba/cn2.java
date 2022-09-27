package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class cn2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bn2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bn2 a() {
        InterceptResult invokeV;
        bn2 bn2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cn2.class) {
                if (a == null) {
                    a = new bn2();
                }
                bn2Var = a;
            }
            return bn2Var;
        }
        return (bn2) invokeV.objValue;
    }
}
