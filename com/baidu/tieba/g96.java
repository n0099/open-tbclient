package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class g96 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile f96 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized f96 a() {
        InterceptResult invokeV;
        f96 f96Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (g96.class) {
                if (a == null) {
                    a = new f96();
                }
                f96Var = a;
            }
            return f96Var;
        }
        return (f96) invokeV.objValue;
    }
}
