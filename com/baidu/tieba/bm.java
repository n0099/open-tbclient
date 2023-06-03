package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bm {
    public static /* synthetic */ Interceptable $ic;
    public static volatile am a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized am a() {
        InterceptResult invokeV;
        am amVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bm.class) {
                if (a == null) {
                    a = new am();
                }
                amVar = a;
            }
            return amVar;
        }
        return (am) invokeV.objValue;
    }
}
