package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class bt2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile at2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized at2 a() {
        InterceptResult invokeV;
        at2 at2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bt2.class) {
                if (a == null) {
                    a = new at2();
                }
                at2Var = a;
            }
            return at2Var;
        }
        return (at2) invokeV.objValue;
    }
}
