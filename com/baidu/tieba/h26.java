package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class h26 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile g26 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized g26 a() {
        InterceptResult invokeV;
        g26 g26Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (h26.class) {
                if (a == null) {
                    a = new g26();
                }
                g26Var = a;
            }
            return g26Var;
        }
        return (g26) invokeV.objValue;
    }
}
