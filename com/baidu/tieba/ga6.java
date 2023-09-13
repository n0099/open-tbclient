package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ga6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fa6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fa6 a() {
        InterceptResult invokeV;
        fa6 fa6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ga6.class) {
                if (a == null) {
                    a = new fa6();
                }
                fa6Var = a;
            }
            return fa6Var;
        }
        return (fa6) invokeV.objValue;
    }
}
