package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class a26 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile z16 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized z16 a() {
        InterceptResult invokeV;
        z16 z16Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (a26.class) {
                if (a == null) {
                    a = new z16();
                }
                z16Var = a;
            }
            return z16Var;
        }
        return (z16) invokeV.objValue;
    }
}
