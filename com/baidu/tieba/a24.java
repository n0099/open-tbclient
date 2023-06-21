package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class a24 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile z14 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized z14 a() {
        InterceptResult invokeV;
        z14 z14Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (a24.class) {
                if (a == null) {
                    a = new z14();
                }
                z14Var = a;
            }
            return z14Var;
        }
        return (z14) invokeV.objValue;
    }
}
