package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class fx0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ex0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ex0 a() {
        InterceptResult invokeV;
        ex0 ex0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fx0.class) {
                if (a == null) {
                    a = new ex0();
                }
                ex0Var = a;
            }
            return ex0Var;
        }
        return (ex0) invokeV.objValue;
    }
}
