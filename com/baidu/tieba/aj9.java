package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class aj9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zi9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zi9 a() {
        InterceptResult invokeV;
        zi9 zi9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (aj9.class) {
                if (a == null) {
                    a = new zi9();
                }
                zi9Var = a;
            }
            return zi9Var;
        }
        return (zi9) invokeV.objValue;
    }
}
