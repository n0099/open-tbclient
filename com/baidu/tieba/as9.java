package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class as9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zr9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zr9 a() {
        InterceptResult invokeV;
        zr9 zr9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (as9.class) {
                if (a == null) {
                    a = new zr9();
                }
                zr9Var = a;
            }
            return zr9Var;
        }
        return (zr9) invokeV.objValue;
    }
}
