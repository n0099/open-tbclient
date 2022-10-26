package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class fn2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile en2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized en2 a() {
        InterceptResult invokeV;
        en2 en2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fn2.class) {
                if (a == null) {
                    a = new en2();
                }
                en2Var = a;
            }
            return en2Var;
        }
        return (en2) invokeV.objValue;
    }
}
