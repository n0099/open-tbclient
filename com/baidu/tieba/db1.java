package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class db1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cb1 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cb1 a() {
        InterceptResult invokeV;
        cb1 cb1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (db1.class) {
                if (a == null) {
                    a = new cb1();
                }
                cb1Var = a;
            }
            return cb1Var;
        }
        return (cb1) invokeV.objValue;
    }
}
