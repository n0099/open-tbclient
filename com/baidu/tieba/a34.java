package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class a34 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile z24 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized z24 a() {
        InterceptResult invokeV;
        z24 z24Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (a34.class) {
                if (a == null) {
                    a = new z24();
                }
                z24Var = a;
            }
            return z24Var;
        }
        return (z24) invokeV.objValue;
    }
}
