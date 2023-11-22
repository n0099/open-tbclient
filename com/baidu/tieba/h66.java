package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class h66 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile g66 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized g66 a() {
        InterceptResult invokeV;
        g66 g66Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (h66.class) {
                if (a == null) {
                    a = new g66();
                }
                g66Var = a;
            }
            return g66Var;
        }
        return (g66) invokeV.objValue;
    }
}
