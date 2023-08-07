package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class hy0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gy0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gy0 a() {
        InterceptResult invokeV;
        gy0 gy0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hy0.class) {
                if (a == null) {
                    a = new gy0();
                }
                gy0Var = a;
            }
            return gy0Var;
        }
        return (gy0) invokeV.objValue;
    }
}
