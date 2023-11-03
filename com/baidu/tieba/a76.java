package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class a76 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile z66 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized z66 a() {
        InterceptResult invokeV;
        z66 z66Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (a76.class) {
                if (a == null) {
                    a = new z66();
                }
                z66Var = a;
            }
            return z66Var;
        }
        return (z66) invokeV.objValue;
    }
}
