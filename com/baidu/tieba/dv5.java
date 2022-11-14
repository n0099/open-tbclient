package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class dv5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cv5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cv5 a() {
        InterceptResult invokeV;
        cv5 cv5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dv5.class) {
                if (a == null) {
                    a = new cv5();
                }
                cv5Var = a;
            }
            return cv5Var;
        }
        return (cv5) invokeV.objValue;
    }
}
