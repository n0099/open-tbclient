package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bu0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile au0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized au0 a() {
        InterceptResult invokeV;
        au0 au0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bu0.class) {
                if (a == null) {
                    a = new au0();
                }
                au0Var = a;
            }
            return au0Var;
        }
        return (au0) invokeV.objValue;
    }
}
