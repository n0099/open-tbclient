package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class h56 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile g56 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized g56 a() {
        InterceptResult invokeV;
        g56 g56Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (h56.class) {
                if (a == null) {
                    a = new g56();
                }
                g56Var = a;
            }
            return g56Var;
        }
        return (g56) invokeV.objValue;
    }
}
