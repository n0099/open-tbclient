package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class hr9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gr9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gr9 a() {
        InterceptResult invokeV;
        gr9 gr9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hr9.class) {
                if (a == null) {
                    a = new gr9();
                }
                gr9Var = a;
            }
            return gr9Var;
        }
        return (gr9) invokeV.objValue;
    }
}
