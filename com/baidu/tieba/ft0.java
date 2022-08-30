package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ft0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile et0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized et0 a() {
        InterceptResult invokeV;
        et0 et0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ft0.class) {
                if (a == null) {
                    a = new et0();
                }
                et0Var = a;
            }
            return et0Var;
        }
        return (et0) invokeV.objValue;
    }
}
