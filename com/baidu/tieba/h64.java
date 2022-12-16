package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class h64 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile g64 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized g64 a() {
        InterceptResult invokeV;
        g64 g64Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (h64.class) {
                if (a == null) {
                    a = new g64();
                }
                g64Var = a;
            }
            return g64Var;
        }
        return (g64) invokeV.objValue;
    }
}
