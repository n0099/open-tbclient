package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class c86 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b86 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized b86 a() {
        InterceptResult invokeV;
        b86 b86Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (c86.class) {
                if (a == null) {
                    a = new b86();
                }
                b86Var = a;
            }
            return b86Var;
        }
        return (b86) invokeV.objValue;
    }
}
