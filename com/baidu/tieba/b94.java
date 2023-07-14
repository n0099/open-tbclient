package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class b94 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a94 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized a94 a() {
        InterceptResult invokeV;
        a94 a94Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (b94.class) {
                if (a == null) {
                    a = new a94();
                }
                a94Var = a;
            }
            return a94Var;
        }
        return (a94) invokeV.objValue;
    }
}
