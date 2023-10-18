package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class c60 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b60 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized b60 a() {
        InterceptResult invokeV;
        b60 b60Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (c60.class) {
                if (a == null) {
                    a = new b60();
                }
                b60Var = a;
            }
            return b60Var;
        }
        return (b60) invokeV.objValue;
    }
}
