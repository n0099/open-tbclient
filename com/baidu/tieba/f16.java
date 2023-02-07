package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class f16 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile e16 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized e16 a() {
        InterceptResult invokeV;
        e16 e16Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (f16.class) {
                if (a == null) {
                    a = new e16();
                }
                e16Var = a;
            }
            return e16Var;
        }
        return (e16) invokeV.objValue;
    }
}
