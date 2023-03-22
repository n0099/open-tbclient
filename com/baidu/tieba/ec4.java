package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ec4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dc4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dc4 a() {
        InterceptResult invokeV;
        dc4 dc4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ec4.class) {
                if (a == null) {
                    a = new dc4();
                }
                dc4Var = a;
            }
            return dc4Var;
        }
        return (dc4) invokeV.objValue;
    }
}
