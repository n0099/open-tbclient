package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class gv0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fv0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fv0 a() {
        InterceptResult invokeV;
        fv0 fv0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gv0.class) {
                if (a == null) {
                    a = new fv0();
                }
                fv0Var = a;
            }
            return fv0Var;
        }
        return (fv0) invokeV.objValue;
    }
}
