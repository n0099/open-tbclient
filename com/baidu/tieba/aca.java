package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class aca {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zba a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zba a() {
        InterceptResult invokeV;
        zba zbaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (aca.class) {
                if (a == null) {
                    a = new zba();
                }
                zbaVar = a;
            }
            return zbaVar;
        }
        return (zba) invokeV.objValue;
    }
}
