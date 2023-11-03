package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class aka {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zja a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zja a() {
        InterceptResult invokeV;
        zja zjaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (aka.class) {
                if (a == null) {
                    a = new zja();
                }
                zjaVar = a;
            }
            return zjaVar;
        }
        return (zja) invokeV.objValue;
    }
}
