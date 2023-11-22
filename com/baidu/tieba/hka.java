package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class hka {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gka a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gka a() {
        InterceptResult invokeV;
        gka gkaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hka.class) {
                if (a == null) {
                    a = new gka();
                }
                gkaVar = a;
            }
            return gkaVar;
        }
        return (gka) invokeV.objValue;
    }
}
