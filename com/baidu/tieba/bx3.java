package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bx3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ax3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ax3 a() {
        InterceptResult invokeV;
        ax3 ax3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bx3.class) {
                if (a == null) {
                    a = new ax3();
                }
                ax3Var = a;
            }
            return ax3Var;
        }
        return (ax3) invokeV.objValue;
    }
}
