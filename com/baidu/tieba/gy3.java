package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class gy3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fy3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fy3 a() {
        InterceptResult invokeV;
        fy3 fy3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gy3.class) {
                if (a == null) {
                    a = new fy3();
                }
                fy3Var = a;
            }
            return fy3Var;
        }
        return (fy3) invokeV.objValue;
    }
}
