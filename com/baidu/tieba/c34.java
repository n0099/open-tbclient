package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class c34 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile b34 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized b34 a() {
        InterceptResult invokeV;
        b34 b34Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (c34.class) {
                if (a == null) {
                    a = new b34();
                }
                b34Var = a;
            }
            return b34Var;
        }
        return (b34) invokeV.objValue;
    }
}
