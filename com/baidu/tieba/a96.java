package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class a96 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile z86 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized z86 a() {
        InterceptResult invokeV;
        z86 z86Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (a96.class) {
                if (a == null) {
                    a = new z86();
                }
                z86Var = a;
            }
            return z86Var;
        }
        return (z86) invokeV.objValue;
    }
}
