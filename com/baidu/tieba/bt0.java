package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bt0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile at0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized at0 a() {
        InterceptResult invokeV;
        at0 at0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bt0.class) {
                if (a == null) {
                    a = new at0();
                }
                at0Var = a;
            }
            return at0Var;
        }
        return (at0) invokeV.objValue;
    }
}
