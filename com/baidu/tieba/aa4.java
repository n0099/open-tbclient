package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class aa4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile z94 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized z94 a() {
        InterceptResult invokeV;
        z94 z94Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (aa4.class) {
                if (a == null) {
                    a = new z94();
                }
                z94Var = a;
            }
            return z94Var;
        }
        return (z94) invokeV.objValue;
    }
}
