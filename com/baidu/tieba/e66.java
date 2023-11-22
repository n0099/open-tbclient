package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class e66 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d66 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized d66 a() {
        InterceptResult invokeV;
        d66 d66Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (e66.class) {
                if (a == null) {
                    a = new d66();
                }
                d66Var = a;
            }
            return d66Var;
        }
        return (d66) invokeV.objValue;
    }
}
