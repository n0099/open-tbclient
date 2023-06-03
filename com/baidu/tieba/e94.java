package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class e94 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d94 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized d94 a() {
        InterceptResult invokeV;
        d94 d94Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (e94.class) {
                if (a == null) {
                    a = new d94();
                }
                d94Var = a;
            }
            return d94Var;
        }
        return (d94) invokeV.objValue;
    }
}
