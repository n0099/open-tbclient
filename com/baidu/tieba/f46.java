package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class f46 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e46 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized e46 a() {
        InterceptResult invokeV;
        e46 e46Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (f46.class) {
                if (a == null) {
                    a = new e46();
                }
                e46Var = a;
            }
            return e46Var;
        }
        return (e46) invokeV.objValue;
    }
}
