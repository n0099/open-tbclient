package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class b36 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a36 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized a36 a() {
        InterceptResult invokeV;
        a36 a36Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (b36.class) {
                if (a == null) {
                    a = new a36();
                }
                a36Var = a;
            }
            return a36Var;
        }
        return (a36) invokeV.objValue;
    }
}
