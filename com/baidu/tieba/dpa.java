package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class dpa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cpa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cpa a() {
        InterceptResult invokeV;
        cpa cpaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dpa.class) {
                if (a == null) {
                    a = new cpa();
                }
                cpaVar = a;
            }
            return cpaVar;
        }
        return (cpa) invokeV.objValue;
    }
}
