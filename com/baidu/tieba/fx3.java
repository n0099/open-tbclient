package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class fx3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ex3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ex3 a() {
        InterceptResult invokeV;
        ex3 ex3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fx3.class) {
                if (a == null) {
                    a = new ex3();
                }
                ex3Var = a;
            }
            return ex3Var;
        }
        return (ex3) invokeV.objValue;
    }
}
