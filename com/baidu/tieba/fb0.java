package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class fb0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile eb0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized eb0 a() {
        InterceptResult invokeV;
        eb0 eb0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fb0.class) {
                if (a == null) {
                    a = new eb0();
                }
                eb0Var = a;
            }
            return eb0Var;
        }
        return (eb0) invokeV.objValue;
    }
}
