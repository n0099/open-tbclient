package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class ek3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dk3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dk3 a() {
        InterceptResult invokeV;
        dk3 dk3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ek3.class) {
                if (a == null) {
                    a = new dk3();
                }
                dk3Var = a;
            }
            return dk3Var;
        }
        return (dk3) invokeV.objValue;
    }
}
