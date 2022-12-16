package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class cn8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bn8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bn8 a() {
        InterceptResult invokeV;
        bn8 bn8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cn8.class) {
                if (a == null) {
                    a = new bn8();
                }
                bn8Var = a;
            }
            return bn8Var;
        }
        return (bn8) invokeV.objValue;
    }
}
