package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class gn8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fn8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fn8 a() {
        InterceptResult invokeV;
        fn8 fn8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gn8.class) {
                if (a == null) {
                    a = new fn8();
                }
                fn8Var = a;
            }
            return fn8Var;
        }
        return (fn8) invokeV.objValue;
    }
}
