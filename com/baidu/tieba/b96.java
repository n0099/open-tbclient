package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class b96 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a96 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized a96 a() {
        InterceptResult invokeV;
        a96 a96Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (b96.class) {
                if (a == null) {
                    a = new a96();
                }
                a96Var = a;
            }
            return a96Var;
        }
        return (a96) invokeV.objValue;
    }
}
