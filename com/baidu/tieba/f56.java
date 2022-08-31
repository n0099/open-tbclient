package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class f56 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e56 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized e56 a() {
        InterceptResult invokeV;
        e56 e56Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (f56.class) {
                if (a == null) {
                    a = new e56();
                }
                e56Var = a;
            }
            return e56Var;
        }
        return (e56) invokeV.objValue;
    }
}
