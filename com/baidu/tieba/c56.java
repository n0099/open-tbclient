package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class c56 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b56 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized b56 a() {
        InterceptResult invokeV;
        b56 b56Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (c56.class) {
                if (a == null) {
                    a = new b56();
                }
                b56Var = a;
            }
            return b56Var;
        }
        return (b56) invokeV.objValue;
    }
}
