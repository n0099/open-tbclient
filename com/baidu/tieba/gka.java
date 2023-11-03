package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class gka {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fka a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fka a() {
        InterceptResult invokeV;
        fka fkaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gka.class) {
                if (a == null) {
                    a = new fka();
                }
                fkaVar = a;
            }
            return fkaVar;
        }
        return (fka) invokeV.objValue;
    }
}
