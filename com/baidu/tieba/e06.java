package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class e06 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d06 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized d06 a() {
        InterceptResult invokeV;
        d06 d06Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (e06.class) {
                if (a == null) {
                    a = new d06();
                }
                d06Var = a;
            }
            return d06Var;
        }
        return (d06) invokeV.objValue;
    }
}
