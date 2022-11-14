package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class gv5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fv5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fv5 a() {
        InterceptResult invokeV;
        fv5 fv5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gv5.class) {
                if (a == null) {
                    a = new fv5();
                }
                fv5Var = a;
            }
            return fv5Var;
        }
        return (fv5) invokeV.objValue;
    }
}
