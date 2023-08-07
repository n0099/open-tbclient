package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class f86 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e86 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized e86 a() {
        InterceptResult invokeV;
        e86 e86Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (f86.class) {
                if (a == null) {
                    a = new e86();
                }
                e86Var = a;
            }
            return e86Var;
        }
        return (e86) invokeV.objValue;
    }
}
