package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class fy3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ey3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ey3 a() {
        InterceptResult invokeV;
        ey3 ey3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fy3.class) {
                if (a == null) {
                    a = new ey3();
                }
                ey3Var = a;
            }
            return ey3Var;
        }
        return (ey3) invokeV.objValue;
    }
}
