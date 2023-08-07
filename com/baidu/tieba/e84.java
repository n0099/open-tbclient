package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class e84 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d84 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized d84 a() {
        InterceptResult invokeV;
        d84 d84Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (e84.class) {
                if (a == null) {
                    a = new d84();
                }
                d84Var = a;
            }
            return d84Var;
        }
        return (d84) invokeV.objValue;
    }
}
