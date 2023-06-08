package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class e96 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d96 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized d96 a() {
        InterceptResult invokeV;
        d96 d96Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (e96.class) {
                if (a == null) {
                    a = new d96();
                }
                d96Var = a;
            }
            return d96Var;
        }
        return (d96) invokeV.objValue;
    }
}
