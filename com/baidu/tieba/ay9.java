package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ay9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zx9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zx9 a() {
        InterceptResult invokeV;
        zx9 zx9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ay9.class) {
                if (a == null) {
                    a = new zx9();
                }
                zx9Var = a;
            }
            return zx9Var;
        }
        return (zx9) invokeV.objValue;
    }
}
