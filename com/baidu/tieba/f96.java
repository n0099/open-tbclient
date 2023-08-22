package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class f96 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e96 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized e96 a() {
        InterceptResult invokeV;
        e96 e96Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (f96.class) {
                if (a == null) {
                    a = new e96();
                }
                e96Var = a;
            }
            return e96Var;
        }
        return (e96) invokeV.objValue;
    }
}
