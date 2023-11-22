package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class b76 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a76 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized a76 a() {
        InterceptResult invokeV;
        a76 a76Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (b76.class) {
                if (a == null) {
                    a = new a76();
                }
                a76Var = a;
            }
            return a76Var;
        }
        return (a76) invokeV.objValue;
    }
}
