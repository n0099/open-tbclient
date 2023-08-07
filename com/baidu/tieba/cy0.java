package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class cy0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile by0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized by0 a() {
        InterceptResult invokeV;
        by0 by0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cy0.class) {
                if (a == null) {
                    a = new by0();
                }
                by0Var = a;
            }
            return by0Var;
        }
        return (by0) invokeV.objValue;
    }
}
