package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class a4a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile z3a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized z3a a() {
        InterceptResult invokeV;
        z3a z3aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (a4a.class) {
                if (a == null) {
                    a = new z3a();
                }
                z3aVar = a;
            }
            return z3aVar;
        }
        return (z3a) invokeV.objValue;
    }
}
