package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class h44 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile g44 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized g44 a() {
        InterceptResult invokeV;
        g44 g44Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (h44.class) {
                if (a == null) {
                    a = new g44();
                }
                g44Var = a;
            }
            return g44Var;
        }
        return (g44) invokeV.objValue;
    }
}
