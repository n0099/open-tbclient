package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ft3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile et3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized et3 a() {
        InterceptResult invokeV;
        et3 et3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ft3.class) {
                if (a == null) {
                    a = new et3();
                }
                et3Var = a;
            }
            return et3Var;
        }
        return (et3) invokeV.objValue;
    }
}
