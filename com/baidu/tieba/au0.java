package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class au0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zt0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zt0 a() {
        InterceptResult invokeV;
        zt0 zt0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (au0.class) {
                if (a == null) {
                    a = new zt0();
                }
                zt0Var = a;
            }
            return zt0Var;
        }
        return (zt0) invokeV.objValue;
    }
}
