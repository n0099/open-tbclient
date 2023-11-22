package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bka {
    public static /* synthetic */ Interceptable $ic;
    public static volatile aka a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized aka a() {
        InterceptResult invokeV;
        aka akaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bka.class) {
                if (a == null) {
                    a = new aka();
                }
                akaVar = a;
            }
            return akaVar;
        }
        return (aka) invokeV.objValue;
    }
}
