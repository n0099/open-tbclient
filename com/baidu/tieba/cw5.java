package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class cw5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bw5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bw5 a() {
        InterceptResult invokeV;
        bw5 bw5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cw5.class) {
                if (a == null) {
                    a = new bw5();
                }
                bw5Var = a;
            }
            return bw5Var;
        }
        return (bw5) invokeV.objValue;
    }
}
