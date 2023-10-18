package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class gp2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fp2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fp2 a() {
        InterceptResult invokeV;
        fp2 fp2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gp2.class) {
                if (a == null) {
                    a = new fp2();
                }
                fp2Var = a;
            }
            return fp2Var;
        }
        return (fp2) invokeV.objValue;
    }
}
