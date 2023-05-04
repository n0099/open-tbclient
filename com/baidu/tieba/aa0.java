package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class aa0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile z90 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized z90 a() {
        InterceptResult invokeV;
        z90 z90Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (aa0.class) {
                if (a == null) {
                    a = new z90();
                }
                z90Var = a;
            }
            return z90Var;
        }
        return (z90) invokeV.objValue;
    }
}
