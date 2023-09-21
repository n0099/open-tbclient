package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class eb6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile db6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized db6 a() {
        InterceptResult invokeV;
        db6 db6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (eb6.class) {
                if (a == null) {
                    a = new db6();
                }
                db6Var = a;
            }
            return db6Var;
        }
        return (db6) invokeV.objValue;
    }
}
