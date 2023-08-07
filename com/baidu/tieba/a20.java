package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class a20 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile f20 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static f20 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new g20();
            }
            return a;
        }
        return (f20) invokeV.objValue;
    }
}
