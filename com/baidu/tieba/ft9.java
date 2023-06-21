package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ft9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile et9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized et9 a() {
        InterceptResult invokeV;
        et9 et9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ft9.class) {
                if (a == null) {
                    a = new et9();
                }
                et9Var = a;
            }
            return et9Var;
        }
        return (et9) invokeV.objValue;
    }
}
