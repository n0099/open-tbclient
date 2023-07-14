package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class c30 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile h30 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static h30 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new i30();
            }
            return a;
        }
        return (h30) invokeV.objValue;
    }
}
