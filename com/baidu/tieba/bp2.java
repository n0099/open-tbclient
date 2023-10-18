package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bp2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ap2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ap2 a() {
        InterceptResult invokeV;
        ap2 ap2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bp2.class) {
                if (a == null) {
                    a = new ap2();
                }
                ap2Var = a;
            }
            return ap2Var;
        }
        return (ap2) invokeV.objValue;
    }
}
