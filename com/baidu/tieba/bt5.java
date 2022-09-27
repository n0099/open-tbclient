package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class bt5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile at5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized at5 a() {
        InterceptResult invokeV;
        at5 at5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bt5.class) {
                if (a == null) {
                    a = new at5();
                }
                at5Var = a;
            }
            return at5Var;
        }
        return (at5) invokeV.objValue;
    }
}
