package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class fka {
    public static /* synthetic */ Interceptable $ic;
    public static volatile eka a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized eka a() {
        InterceptResult invokeV;
        eka ekaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fka.class) {
                if (a == null) {
                    a = new eka();
                }
                ekaVar = a;
            }
            return ekaVar;
        }
        return (eka) invokeV.objValue;
    }
}
