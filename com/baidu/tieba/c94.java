package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class c94 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b94 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized b94 a() {
        InterceptResult invokeV;
        b94 b94Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (c94.class) {
                if (a == null) {
                    a = new b94();
                }
                b94Var = a;
            }
            return b94Var;
        }
        return (b94) invokeV.objValue;
    }
}
