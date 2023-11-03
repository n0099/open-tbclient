package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bp3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ap3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ap3 a() {
        InterceptResult invokeV;
        ap3 ap3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bp3.class) {
                if (a == null) {
                    a = new ap3();
                }
                ap3Var = a;
            }
            return ap3Var;
        }
        return (ap3) invokeV.objValue;
    }
}
