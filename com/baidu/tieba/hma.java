package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class hma {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gma a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gma a() {
        InterceptResult invokeV;
        gma gmaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hma.class) {
                if (a == null) {
                    a = new gma();
                }
                gmaVar = a;
            }
            return gmaVar;
        }
        return (gma) invokeV.objValue;
    }
}
