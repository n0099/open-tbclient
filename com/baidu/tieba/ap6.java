package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ap6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zo6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zo6 a() {
        InterceptResult invokeV;
        zo6 zo6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ap6.class) {
                if (a == null) {
                    a = new zo6();
                }
                zo6Var = a;
            }
            return zo6Var;
        }
        return (zo6) invokeV.objValue;
    }
}
