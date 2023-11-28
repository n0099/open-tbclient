package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class fma {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ema a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ema a() {
        InterceptResult invokeV;
        ema emaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fma.class) {
                if (a == null) {
                    a = new ema();
                }
                emaVar = a;
            }
            return emaVar;
        }
        return (ema) invokeV.objValue;
    }
}
