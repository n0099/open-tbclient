package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ik8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hk8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hk8 a() {
        InterceptResult invokeV;
        hk8 hk8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ik8.class) {
                if (a == null) {
                    a = new hk8();
                }
                hk8Var = a;
            }
            return hk8Var;
        }
        return (hk8) invokeV.objValue;
    }
}
