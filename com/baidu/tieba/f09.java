package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class f09 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e09 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized e09 a() {
        InterceptResult invokeV;
        e09 e09Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (f09.class) {
                if (a == null) {
                    a = new e09();
                }
                e09Var = a;
            }
            return e09Var;
        }
        return (e09) invokeV.objValue;
    }
}
