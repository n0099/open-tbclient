package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class f19 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e19 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized e19 a() {
        InterceptResult invokeV;
        e19 e19Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (f19.class) {
                if (a == null) {
                    a = new e19();
                }
                e19Var = a;
            }
            return e19Var;
        }
        return (e19) invokeV.objValue;
    }
}
