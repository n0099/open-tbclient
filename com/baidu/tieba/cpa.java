package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class cpa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bpa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bpa a() {
        InterceptResult invokeV;
        bpa bpaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cpa.class) {
                if (a == null) {
                    a = new bpa();
                }
                bpaVar = a;
            }
            return bpaVar;
        }
        return (bpa) invokeV.objValue;
    }
}
