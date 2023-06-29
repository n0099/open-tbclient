package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class hy3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gy3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gy3 a() {
        InterceptResult invokeV;
        gy3 gy3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hy3.class) {
                if (a == null) {
                    a = new gy3();
                }
                gy3Var = a;
            }
            return gy3Var;
        }
        return (gy3) invokeV.objValue;
    }
}
