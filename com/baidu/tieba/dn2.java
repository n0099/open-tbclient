package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class dn2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cn2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cn2 a() {
        InterceptResult invokeV;
        cn2 cn2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dn2.class) {
                if (a == null) {
                    a = new cn2();
                }
                cn2Var = a;
            }
            return cn2Var;
        }
        return (cn2) invokeV.objValue;
    }
}
