package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class fpa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile epa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized epa a() {
        InterceptResult invokeV;
        epa epaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fpa.class) {
                if (a == null) {
                    a = new epa();
                }
                epaVar = a;
            }
            return epaVar;
        }
        return (epa) invokeV.objValue;
    }
}
