package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class c54 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b54 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized b54 a() {
        InterceptResult invokeV;
        b54 b54Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (c54.class) {
                if (a == null) {
                    a = new b54();
                }
                b54Var = a;
            }
            return b54Var;
        }
        return (b54) invokeV.objValue;
    }
}
