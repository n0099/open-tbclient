package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class dy3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cy3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cy3 a() {
        InterceptResult invokeV;
        cy3 cy3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dy3.class) {
                if (a == null) {
                    a = new cy3();
                }
                cy3Var = a;
            }
            return cy3Var;
        }
        return (cy3) invokeV.objValue;
    }
}
