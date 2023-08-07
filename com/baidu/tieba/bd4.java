package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bd4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ad4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ad4 a() {
        InterceptResult invokeV;
        ad4 ad4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bd4.class) {
                if (a == null) {
                    a = new ad4();
                }
                ad4Var = a;
            }
            return ad4Var;
        }
        return (ad4) invokeV.objValue;
    }
}
