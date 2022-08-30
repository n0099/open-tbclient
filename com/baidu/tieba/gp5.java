package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class gp5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fp5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fp5 a() {
        InterceptResult invokeV;
        fp5 fp5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gp5.class) {
                if (a == null) {
                    a = new fp5();
                }
                fp5Var = a;
            }
            return fp5Var;
        }
        return (fp5) invokeV.objValue;
    }
}
