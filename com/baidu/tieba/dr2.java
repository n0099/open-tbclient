package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class dr2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cr2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cr2 a() {
        InterceptResult invokeV;
        cr2 cr2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dr2.class) {
                if (a == null) {
                    a = new cr2();
                }
                cr2Var = a;
            }
            return cr2Var;
        }
        return (cr2) invokeV.objValue;
    }
}
