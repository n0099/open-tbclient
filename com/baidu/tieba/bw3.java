package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class bw3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile aw3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized aw3 a() {
        InterceptResult invokeV;
        aw3 aw3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bw3.class) {
                if (a == null) {
                    a = new aw3();
                }
                aw3Var = a;
            }
            return aw3Var;
        }
        return (aw3) invokeV.objValue;
    }
}
