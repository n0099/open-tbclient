package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class eka {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dka a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dka a() {
        InterceptResult invokeV;
        dka dkaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (eka.class) {
                if (a == null) {
                    a = new dka();
                }
                dkaVar = a;
            }
            return dkaVar;
        }
        return (dka) invokeV.objValue;
    }
}
