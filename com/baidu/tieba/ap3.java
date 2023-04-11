package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class ap3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zo3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zo3 a() {
        InterceptResult invokeV;
        zo3 zo3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ap3.class) {
                if (a == null) {
                    a = new zo3();
                }
                zo3Var = a;
            }
            return zo3Var;
        }
        return (zo3) invokeV.objValue;
    }
}
