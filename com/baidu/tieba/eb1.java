package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class eb1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile db1 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized db1 a() {
        InterceptResult invokeV;
        db1 db1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (eb1.class) {
                if (a == null) {
                    a = new db1();
                }
                db1Var = a;
            }
            return db1Var;
        }
        return (db1) invokeV.objValue;
    }
}
