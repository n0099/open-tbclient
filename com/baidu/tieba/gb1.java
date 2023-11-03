package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class gb1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fb1 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fb1 a() {
        InterceptResult invokeV;
        fb1 fb1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gb1.class) {
                if (a == null) {
                    a = new fb1();
                }
                fb1Var = a;
            }
            return fb1Var;
        }
        return (fb1) invokeV.objValue;
    }
}
