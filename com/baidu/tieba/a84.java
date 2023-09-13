package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class a84 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile z74 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized z74 a() {
        InterceptResult invokeV;
        z74 z74Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (a84.class) {
                if (a == null) {
                    a = new z74();
                }
                z74Var = a;
            }
            return z74Var;
        }
        return (z74) invokeV.objValue;
    }
}
