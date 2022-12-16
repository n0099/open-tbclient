package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class fv5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ev5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ev5 a() {
        InterceptResult invokeV;
        ev5 ev5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fv5.class) {
                if (a == null) {
                    a = new ev5();
                }
                ev5Var = a;
            }
            return ev5Var;
        }
        return (ev5) invokeV.objValue;
    }
}
