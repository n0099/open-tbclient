package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class fv0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ev0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ev0 a() {
        InterceptResult invokeV;
        ev0 ev0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fv0.class) {
                if (a == null) {
                    a = new ev0();
                }
                ev0Var = a;
            }
            return ev0Var;
        }
        return (ev0) invokeV.objValue;
    }
}
