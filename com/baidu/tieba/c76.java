package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class c76 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b76 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized b76 a() {
        InterceptResult invokeV;
        b76 b76Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (c76.class) {
                if (a == null) {
                    a = new b76();
                }
                b76Var = a;
            }
            return b76Var;
        }
        return (b76) invokeV.objValue;
    }
}
