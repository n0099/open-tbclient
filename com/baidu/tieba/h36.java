package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class h36 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile g36 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized g36 a() {
        InterceptResult invokeV;
        g36 g36Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (h36.class) {
                if (a == null) {
                    a = new g36();
                }
                g36Var = a;
            }
            return g36Var;
        }
        return (g36) invokeV.objValue;
    }
}
