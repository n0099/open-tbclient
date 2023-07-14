package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class db6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cb6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cb6 a() {
        InterceptResult invokeV;
        cb6 cb6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (db6.class) {
                if (a == null) {
                    a = new cb6();
                }
                cb6Var = a;
            }
            return cb6Var;
        }
        return (cb6) invokeV.objValue;
    }
}
