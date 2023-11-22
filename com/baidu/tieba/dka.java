package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class dka {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cka a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cka a() {
        InterceptResult invokeV;
        cka ckaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dka.class) {
                if (a == null) {
                    a = new cka();
                }
                ckaVar = a;
            }
            return ckaVar;
        }
        return (cka) invokeV.objValue;
    }
}
