package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class cv3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bv3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bv3 a() {
        InterceptResult invokeV;
        bv3 bv3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cv3.class) {
                if (a == null) {
                    a = new bv3();
                }
                bv3Var = a;
            }
            return bv3Var;
        }
        return (bv3) invokeV.objValue;
    }
}
