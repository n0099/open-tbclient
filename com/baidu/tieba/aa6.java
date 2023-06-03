package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class aa6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile z96 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized z96 a() {
        InterceptResult invokeV;
        z96 z96Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (aa6.class) {
                if (a == null) {
                    a = new z96();
                }
                z96Var = a;
            }
            return z96Var;
        }
        return (z96) invokeV.objValue;
    }
}
