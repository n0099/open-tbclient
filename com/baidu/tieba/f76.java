package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class f76 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e76 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized e76 a() {
        InterceptResult invokeV;
        e76 e76Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (f76.class) {
                if (a == null) {
                    a = new e76();
                }
                e76Var = a;
            }
            return e76Var;
        }
        return (e76) invokeV.objValue;
    }
}
