package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class du0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cu0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cu0 a() {
        InterceptResult invokeV;
        cu0 cu0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (du0.class) {
                if (a == null) {
                    a = new cu0();
                }
                cu0Var = a;
            }
            return cu0Var;
        }
        return (cu0) invokeV.objValue;
    }
}
