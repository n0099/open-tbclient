package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ft2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile et2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized et2 a() {
        InterceptResult invokeV;
        et2 et2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ft2.class) {
                if (a == null) {
                    a = new et2();
                }
                et2Var = a;
            }
            return et2Var;
        }
        return (et2) invokeV.objValue;
    }
}
