package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class eg8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dg8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dg8 a() {
        InterceptResult invokeV;
        dg8 dg8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (eg8.class) {
                if (a == null) {
                    a = new dg8();
                }
                dg8Var = a;
            }
            return dg8Var;
        }
        return (dg8) invokeV.objValue;
    }
}
