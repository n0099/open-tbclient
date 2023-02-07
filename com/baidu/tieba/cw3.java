package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class cw3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bw3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bw3 a() {
        InterceptResult invokeV;
        bw3 bw3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cw3.class) {
                if (a == null) {
                    a = new bw3();
                }
                bw3Var = a;
            }
            return bw3Var;
        }
        return (bw3) invokeV.objValue;
    }
}
