package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class fk8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ek8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ek8 a() {
        InterceptResult invokeV;
        ek8 ek8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fk8.class) {
                if (a == null) {
                    a = new ek8();
                }
                ek8Var = a;
            }
            return ek8Var;
        }
        return (ek8) invokeV.objValue;
    }
}
