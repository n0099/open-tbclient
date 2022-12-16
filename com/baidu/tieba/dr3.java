package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class dr3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cr3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cr3 a() {
        InterceptResult invokeV;
        cr3 cr3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dr3.class) {
                if (a == null) {
                    a = new cr3();
                }
                cr3Var = a;
            }
            return cr3Var;
        }
        return (cr3) invokeV.objValue;
    }
}
