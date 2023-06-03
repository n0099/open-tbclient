package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class f43 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e43 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized e43 a() {
        InterceptResult invokeV;
        e43 e43Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (f43.class) {
                if (a == null) {
                    a = new e43();
                }
                e43Var = a;
            }
            return e43Var;
        }
        return (e43) invokeV.objValue;
    }
}
