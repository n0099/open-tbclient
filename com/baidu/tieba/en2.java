package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class en2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dn2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dn2 a() {
        InterceptResult invokeV;
        dn2 dn2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (en2.class) {
                if (a == null) {
                    a = new dn2();
                }
                dn2Var = a;
            }
            return dn2Var;
        }
        return (dn2) invokeV.objValue;
    }
}
