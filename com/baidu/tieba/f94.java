package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class f94 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e94 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized e94 a() {
        InterceptResult invokeV;
        e94 e94Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (f94.class) {
                if (a == null) {
                    a = new e94();
                }
                e94Var = a;
            }
            return e94Var;
        }
        return (e94) invokeV.objValue;
    }
}
