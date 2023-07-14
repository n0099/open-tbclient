package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class f44 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e44 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized e44 a() {
        InterceptResult invokeV;
        e44 e44Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (f44.class) {
                if (a == null) {
                    a = new e44();
                }
                e44Var = a;
            }
            return e44Var;
        }
        return (e44) invokeV.objValue;
    }
}
