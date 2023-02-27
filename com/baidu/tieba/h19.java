package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class h19 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile g19 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized g19 a() {
        InterceptResult invokeV;
        g19 g19Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (h19.class) {
                if (a == null) {
                    a = new g19();
                }
                g19Var = a;
            }
            return g19Var;
        }
        return (g19) invokeV.objValue;
    }
}
