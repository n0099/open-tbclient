package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class il {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hl a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hl a() {
        InterceptResult invokeV;
        hl hlVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (il.class) {
                if (a == null) {
                    a = new hl();
                }
                hlVar = a;
            }
            return hlVar;
        }
        return (hl) invokeV.objValue;
    }
}
