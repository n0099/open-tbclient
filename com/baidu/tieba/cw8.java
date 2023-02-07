package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class cw8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bw8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bw8 a() {
        InterceptResult invokeV;
        bw8 bw8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cw8.class) {
                if (a == null) {
                    a = new bw8();
                }
                bw8Var = a;
            }
            return bw8Var;
        }
        return (bw8) invokeV.objValue;
    }
}
