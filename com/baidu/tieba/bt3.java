package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class bt3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile at3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized at3 a() {
        InterceptResult invokeV;
        at3 at3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bt3.class) {
                if (a == null) {
                    a = new at3();
                }
                at3Var = a;
            }
            return at3Var;
        }
        return (at3) invokeV.objValue;
    }
}
