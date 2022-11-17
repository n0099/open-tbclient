package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class hk8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gk8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gk8 a() {
        InterceptResult invokeV;
        gk8 gk8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hk8.class) {
                if (a == null) {
                    a = new gk8();
                }
                gk8Var = a;
            }
            return gk8Var;
        }
        return (gk8) invokeV.objValue;
    }
}
