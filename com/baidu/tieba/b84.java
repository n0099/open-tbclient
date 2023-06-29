package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class b84 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a84 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized a84 a() {
        InterceptResult invokeV;
        a84 a84Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (b84.class) {
                if (a == null) {
                    a = new a84();
                }
                a84Var = a;
            }
            return a84Var;
        }
        return (a84) invokeV.objValue;
    }
}
