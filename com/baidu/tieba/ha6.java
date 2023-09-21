package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ha6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ga6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ga6 a() {
        InterceptResult invokeV;
        ga6 ga6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ha6.class) {
                if (a == null) {
                    a = new ga6();
                }
                ga6Var = a;
            }
            return ga6Var;
        }
        return (ga6) invokeV.objValue;
    }
}
