package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ec0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dc0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dc0 a() {
        InterceptResult invokeV;
        dc0 dc0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ec0.class) {
                if (a == null) {
                    a = new dc0();
                }
                dc0Var = a;
            }
            return dc0Var;
        }
        return (dc0) invokeV.objValue;
    }
}
