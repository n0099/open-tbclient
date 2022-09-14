package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class dv0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cv0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cv0 a() {
        InterceptResult invokeV;
        cv0 cv0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dv0.class) {
                if (a == null) {
                    a = new cv0();
                }
                cv0Var = a;
            }
            return cv0Var;
        }
        return (cv0) invokeV.objValue;
    }
}
