package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class a54 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile z44 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized z44 a() {
        InterceptResult invokeV;
        z44 z44Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (a54.class) {
                if (a == null) {
                    a = new z44();
                }
                z44Var = a;
            }
            return z44Var;
        }
        return (z44) invokeV.objValue;
    }
}
