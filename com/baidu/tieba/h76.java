package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class h76 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile g76 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized g76 a() {
        InterceptResult invokeV;
        g76 g76Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (h76.class) {
                if (a == null) {
                    a = new g76();
                }
                g76Var = a;
            }
            return g76Var;
        }
        return (g76) invokeV.objValue;
    }
}
