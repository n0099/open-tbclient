package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class a30 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile f30 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static f30 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (a == null) {
                a = new g30();
            }
            return a;
        }
        return (f30) invokeV.objValue;
    }
}
