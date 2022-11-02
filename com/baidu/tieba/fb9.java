package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class fb9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile eb9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized eb9 a() {
        InterceptResult invokeV;
        eb9 eb9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fb9.class) {
                if (a == null) {
                    a = new eb9();
                }
                eb9Var = a;
            }
            return eb9Var;
        }
        return (eb9) invokeV.objValue;
    }
}
