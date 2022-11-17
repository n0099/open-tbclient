package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class cv5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bv5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bv5 a() {
        InterceptResult invokeV;
        bv5 bv5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cv5.class) {
                if (a == null) {
                    a = new bv5();
                }
                bv5Var = a;
            }
            return bv5Var;
        }
        return (bv5) invokeV.objValue;
    }
}
