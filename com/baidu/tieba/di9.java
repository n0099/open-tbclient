package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class di9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ci9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ci9 a() {
        InterceptResult invokeV;
        ci9 ci9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (di9.class) {
                if (a == null) {
                    a = new ci9();
                }
                ci9Var = a;
            }
            return ci9Var;
        }
        return (ci9) invokeV.objValue;
    }
}
