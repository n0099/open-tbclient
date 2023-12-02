package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class e76 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d76 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized d76 a() {
        InterceptResult invokeV;
        d76 d76Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (e76.class) {
                if (a == null) {
                    a = new d76();
                }
                d76Var = a;
            }
            return d76Var;
        }
        return (d76) invokeV.objValue;
    }
}
