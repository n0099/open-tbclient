package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class faa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile eaa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized eaa a() {
        InterceptResult invokeV;
        eaa eaaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (faa.class) {
                if (a == null) {
                    a = new eaa();
                }
                eaaVar = a;
            }
            return eaaVar;
        }
        return (eaa) invokeV.objValue;
    }
}
