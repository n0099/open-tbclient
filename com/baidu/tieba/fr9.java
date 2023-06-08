package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class fr9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile er9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized er9 a() {
        InterceptResult invokeV;
        er9 er9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fr9.class) {
                if (a == null) {
                    a = new er9();
                }
                er9Var = a;
            }
            return er9Var;
        }
        return (er9) invokeV.objValue;
    }
}
