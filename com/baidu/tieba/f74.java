package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class f74 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e74 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized e74 a() {
        InterceptResult invokeV;
        e74 e74Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (f74.class) {
                if (a == null) {
                    a = new e74();
                }
                e74Var = a;
            }
            return e74Var;
        }
        return (e74) invokeV.objValue;
    }
}
