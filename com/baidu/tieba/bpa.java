package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bpa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile apa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized apa a() {
        InterceptResult invokeV;
        apa apaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bpa.class) {
                if (a == null) {
                    a = new apa();
                }
                apaVar = a;
            }
            return apaVar;
        }
        return (apa) invokeV.objValue;
    }
}
