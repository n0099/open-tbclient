package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class et3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dt3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dt3 a() {
        InterceptResult invokeV;
        dt3 dt3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (et3.class) {
                if (a == null) {
                    a = new dt3();
                }
                dt3Var = a;
            }
            return dt3Var;
        }
        return (dt3) invokeV.objValue;
    }
}
