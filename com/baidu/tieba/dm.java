package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class dm {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cm a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cm a() {
        InterceptResult invokeV;
        cm cmVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dm.class) {
                if (a == null) {
                    a = new cm();
                }
                cmVar = a;
            }
            return cmVar;
        }
        return (cm) invokeV.objValue;
    }
}
