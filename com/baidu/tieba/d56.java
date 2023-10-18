package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class d56 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile c56 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized c56 a() {
        InterceptResult invokeV;
        c56 c56Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (d56.class) {
                if (a == null) {
                    a = new c56();
                }
                c56Var = a;
            }
            return c56Var;
        }
        return (c56) invokeV.objValue;
    }
}
