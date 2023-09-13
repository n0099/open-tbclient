package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class gy0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fy0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fy0 a() {
        InterceptResult invokeV;
        fy0 fy0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gy0.class) {
                if (a == null) {
                    a = new fy0();
                }
                fy0Var = a;
            }
            return fy0Var;
        }
        return (fy0) invokeV.objValue;
    }
}
