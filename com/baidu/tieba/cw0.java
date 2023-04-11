package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class cw0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bw0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bw0 a() {
        InterceptResult invokeV;
        bw0 bw0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cw0.class) {
                if (a == null) {
                    a = new bw0();
                }
                bw0Var = a;
            }
            return bw0Var;
        }
        return (bw0) invokeV.objValue;
    }
}
