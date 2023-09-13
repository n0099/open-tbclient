package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class daa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile caa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized caa a() {
        InterceptResult invokeV;
        caa caaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (daa.class) {
                if (a == null) {
                    a = new caa();
                }
                caaVar = a;
            }
            return caaVar;
        }
        return (caa) invokeV.objValue;
    }
}
