package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class f54 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e54 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized e54 a() {
        InterceptResult invokeV;
        e54 e54Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (f54.class) {
                if (a == null) {
                    a = new e54();
                }
                e54Var = a;
            }
            return e54Var;
        }
        return (e54) invokeV.objValue;
    }
}
