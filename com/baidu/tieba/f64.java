package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class f64 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e64 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized e64 a() {
        InterceptResult invokeV;
        e64 e64Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (f64.class) {
                if (a == null) {
                    a = new e64();
                }
                e64Var = a;
            }
            return e64Var;
        }
        return (e64) invokeV.objValue;
    }
}
