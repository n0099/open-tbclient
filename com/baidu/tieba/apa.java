package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class apa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zoa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zoa a() {
        InterceptResult invokeV;
        zoa zoaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (apa.class) {
                if (a == null) {
                    a = new zoa();
                }
                zoaVar = a;
            }
            return zoaVar;
        }
        return (zoa) invokeV.objValue;
    }
}
