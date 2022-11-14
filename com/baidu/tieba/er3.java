package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class er3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dr3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dr3 a() {
        InterceptResult invokeV;
        dr3 dr3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (er3.class) {
                if (a == null) {
                    a = new dr3();
                }
                dr3Var = a;
            }
            return dr3Var;
        }
        return (dr3) invokeV.objValue;
    }
}
