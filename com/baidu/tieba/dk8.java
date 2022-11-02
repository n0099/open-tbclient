package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class dk8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ck8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ck8 a() {
        InterceptResult invokeV;
        ck8 ck8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dk8.class) {
                if (a == null) {
                    a = new ck8();
                }
                ck8Var = a;
            }
            return ck8Var;
        }
        return (ck8) invokeV.objValue;
    }
}
