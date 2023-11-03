package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class a40 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile z30 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized z30 a() {
        InterceptResult invokeV;
        z30 z30Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (a40.class) {
                if (a == null) {
                    a = new z30();
                }
                z30Var = a;
            }
            return z30Var;
        }
        return (z30) invokeV.objValue;
    }
}
