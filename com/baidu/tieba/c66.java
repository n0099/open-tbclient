package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class c66 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b66 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized b66 a() {
        InterceptResult invokeV;
        b66 b66Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (c66.class) {
                if (a == null) {
                    a = new b66();
                }
                b66Var = a;
            }
            return b66Var;
        }
        return (b66) invokeV.objValue;
    }
}
