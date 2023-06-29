package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class fx9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ex9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ex9 a() {
        InterceptResult invokeV;
        ex9 ex9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fx9.class) {
                if (a == null) {
                    a = new ex9();
                }
                ex9Var = a;
            }
            return ex9Var;
        }
        return (ex9) invokeV.objValue;
    }
}
