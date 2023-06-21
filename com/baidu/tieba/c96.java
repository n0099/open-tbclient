package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class c96 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b96 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized b96 a() {
        InterceptResult invokeV;
        b96 b96Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (c96.class) {
                if (a == null) {
                    a = new b96();
                }
                b96Var = a;
            }
            return b96Var;
        }
        return (b96) invokeV.objValue;
    }
}
