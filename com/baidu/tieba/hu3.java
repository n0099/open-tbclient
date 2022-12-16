package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class hu3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gu3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gu3 a() {
        InterceptResult invokeV;
        gu3 gu3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hu3.class) {
                if (a == null) {
                    a = new gu3();
                }
                gu3Var = a;
            }
            return gu3Var;
        }
        return (gu3) invokeV.objValue;
    }
}
