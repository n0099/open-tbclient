package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class h96 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile g96 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized g96 a() {
        InterceptResult invokeV;
        g96 g96Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (h96.class) {
                if (a == null) {
                    a = new g96();
                }
                g96Var = a;
            }
            return g96Var;
        }
        return (g96) invokeV.objValue;
    }
}
