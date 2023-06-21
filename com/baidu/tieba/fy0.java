package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class fy0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ey0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ey0 a() {
        InterceptResult invokeV;
        ey0 ey0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fy0.class) {
                if (a == null) {
                    a = new ey0();
                }
                ey0Var = a;
            }
            return ey0Var;
        }
        return (ey0) invokeV.objValue;
    }
}
