package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class h46 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile g46 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized g46 a() {
        InterceptResult invokeV;
        g46 g46Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (h46.class) {
                if (a == null) {
                    a = new g46();
                }
                g46Var = a;
            }
            return g46Var;
        }
        return (g46) invokeV.objValue;
    }
}
