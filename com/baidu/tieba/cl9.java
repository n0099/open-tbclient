package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class cl9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bl9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bl9 a() {
        InterceptResult invokeV;
        bl9 bl9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cl9.class) {
                if (a == null) {
                    a = new bl9();
                }
                bl9Var = a;
            }
            return bl9Var;
        }
        return (bl9) invokeV.objValue;
    }
}
