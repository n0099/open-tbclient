package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class fk6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ek6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ek6 a() {
        InterceptResult invokeV;
        ek6 ek6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fk6.class) {
                if (a == null) {
                    a = new ek6();
                }
                ek6Var = a;
            }
            return ek6Var;
        }
        return (ek6) invokeV.objValue;
    }
}
