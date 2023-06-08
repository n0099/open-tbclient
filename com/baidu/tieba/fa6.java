package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class fa6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ea6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ea6 a() {
        InterceptResult invokeV;
        ea6 ea6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fa6.class) {
                if (a == null) {
                    a = new ea6();
                }
                ea6Var = a;
            }
            return ea6Var;
        }
        return (ea6) invokeV.objValue;
    }
}
