package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class bp5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ap5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ap5 a() {
        InterceptResult invokeV;
        ap5 ap5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bp5.class) {
                if (a == null) {
                    a = new ap5();
                }
                ap5Var = a;
            }
            return ap5Var;
        }
        return (ap5) invokeV.objValue;
    }
}
