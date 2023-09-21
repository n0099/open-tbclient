package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bb6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ab6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ab6 a() {
        InterceptResult invokeV;
        ab6 ab6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bb6.class) {
                if (a == null) {
                    a = new ab6();
                }
                ab6Var = a;
            }
            return ab6Var;
        }
        return (ab6) invokeV.objValue;
    }
}
