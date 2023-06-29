package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class b30 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile g30 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static g30 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new h30();
            }
            return a;
        }
        return (g30) invokeV.objValue;
    }
}
