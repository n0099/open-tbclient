package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class fi8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ei8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ei8 a() {
        InterceptResult invokeV;
        ei8 ei8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fi8.class) {
                if (a == null) {
                    a = new ei8();
                }
                ei8Var = a;
            }
            return ei8Var;
        }
        return (ei8) invokeV.objValue;
    }
}
