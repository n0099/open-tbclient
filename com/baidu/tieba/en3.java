package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class en3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dn3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dn3 a() {
        InterceptResult invokeV;
        dn3 dn3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (en3.class) {
                if (a == null) {
                    a = new dn3();
                }
                dn3Var = a;
            }
            return dn3Var;
        }
        return (dn3) invokeV.objValue;
    }
}
