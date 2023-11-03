package com.baidu.tieba;

import com.baidu.tieba.t11;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class h31 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65536, null, f)) == null) {
            return t11.c.a(gf0.b(), f);
        }
        return invokeF.intValue;
    }

    public static int b(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65537, null, f)) == null) {
            return t11.c.a(gf0.b(), f);
        }
        return invokeF.intValue;
    }

    public static int c(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65538, null, f)) == null) {
            return Math.round(f / 1.5f);
        }
        return invokeF.intValue;
    }

    public static int d(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65539, null, f)) == null) {
            return b(f / 1.5f);
        }
        return invokeF.intValue;
    }
}
