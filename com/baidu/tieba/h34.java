package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class h34 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile g34 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized g34 a() {
        InterceptResult invokeV;
        g34 g34Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (h34.class) {
                if (a == null) {
                    a = new g34();
                }
                g34Var = a;
            }
            return g34Var;
        }
        return (g34) invokeV.objValue;
    }
}
