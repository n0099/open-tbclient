package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class gk8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fk8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fk8 a() {
        InterceptResult invokeV;
        fk8 fk8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gk8.class) {
                if (a == null) {
                    a = new fk8();
                }
                fk8Var = a;
            }
            return fk8Var;
        }
        return (fk8) invokeV.objValue;
    }
}
