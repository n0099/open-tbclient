package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class gr5 {
    public static /* synthetic */ Interceptable $ic;
    public static long a;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            return b(500);
        }
        return invokeV.booleanValue;
    }

    public static boolean b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = a;
            if (j > currentTimeMillis) {
                a = currentTimeMillis;
                return false;
            } else if (currentTimeMillis - j < i) {
                return true;
            } else {
                a = currentTimeMillis;
                return false;
            }
        }
        return invokeI.booleanValue;
    }
}
