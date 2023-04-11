package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class af9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ze9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ze9 a() {
        InterceptResult invokeV;
        ze9 ze9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (af9.class) {
                if (a == null) {
                    a = new ze9();
                }
                ze9Var = a;
            }
            return ze9Var;
        }
        return (ze9) invokeV.objValue;
    }
}
