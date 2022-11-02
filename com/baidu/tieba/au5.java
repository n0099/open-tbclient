package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class au5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zt5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zt5 a() {
        InterceptResult invokeV;
        zt5 zt5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (au5.class) {
                if (a == null) {
                    a = new zt5();
                }
                zt5Var = a;
            }
            return zt5Var;
        }
        return (zt5) invokeV.objValue;
    }
}
