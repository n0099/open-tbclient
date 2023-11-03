package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class f24 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e24 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized e24 a() {
        InterceptResult invokeV;
        e24 e24Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (f24.class) {
                if (a == null) {
                    a = new e24();
                }
                e24Var = a;
            }
            return e24Var;
        }
        return (e24) invokeV.objValue;
    }
}
