package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class ea0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile da0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized da0 a() {
        InterceptResult invokeV;
        da0 da0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ea0.class) {
                if (a == null) {
                    a = new da0();
                }
                da0Var = a;
            }
            return da0Var;
        }
        return (da0) invokeV.objValue;
    }
}
