package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class epa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dpa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dpa a() {
        InterceptResult invokeV;
        dpa dpaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (epa.class) {
                if (a == null) {
                    a = new dpa();
                }
                dpaVar = a;
            }
            return dpaVar;
        }
        return (dpa) invokeV.objValue;
    }
}
