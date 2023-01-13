package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ib1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hb1 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hb1 a() {
        InterceptResult invokeV;
        hb1 hb1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ib1.class) {
                if (a == null) {
                    a = new hb1();
                }
                hb1Var = a;
            }
            return hb1Var;
        }
        return (hb1) invokeV.objValue;
    }
}
