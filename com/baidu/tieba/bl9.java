package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bl9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile al9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized al9 a() {
        InterceptResult invokeV;
        al9 al9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bl9.class) {
                if (a == null) {
                    a = new al9();
                }
                al9Var = a;
            }
            return al9Var;
        }
        return (al9) invokeV.objValue;
    }
}
