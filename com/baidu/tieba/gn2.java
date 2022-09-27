package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class gn2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fn2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fn2 a() {
        InterceptResult invokeV;
        fn2 fn2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gn2.class) {
                if (a == null) {
                    a = new fn2();
                }
                fn2Var = a;
            }
            return fn2Var;
        }
        return (fn2) invokeV.objValue;
    }
}
