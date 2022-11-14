package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class b54 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a54 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized a54 a() {
        InterceptResult invokeV;
        a54 a54Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (b54.class) {
                if (a == null) {
                    a = new a54();
                }
                a54Var = a;
            }
            return a54Var;
        }
        return (a54) invokeV.objValue;
    }
}
