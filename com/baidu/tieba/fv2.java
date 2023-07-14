package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class fv2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ev2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ev2 a() {
        InterceptResult invokeV;
        ev2 ev2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fv2.class) {
                if (a == null) {
                    a = new ev2();
                }
                ev2Var = a;
            }
            return ev2Var;
        }
        return (ev2) invokeV.objValue;
    }
}
