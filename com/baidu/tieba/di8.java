package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class di8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ci8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ci8 a() {
        InterceptResult invokeV;
        ci8 ci8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (di8.class) {
                if (a == null) {
                    a = new ci8();
                }
                ci8Var = a;
            }
            return ci8Var;
        }
        return (ci8) invokeV.objValue;
    }
}
