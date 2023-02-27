package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class gv3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fv3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fv3 a() {
        InterceptResult invokeV;
        fv3 fv3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gv3.class) {
                if (a == null) {
                    a = new fv3();
                }
                fv3Var = a;
            }
            return fv3Var;
        }
        return (fv3) invokeV.objValue;
    }
}
