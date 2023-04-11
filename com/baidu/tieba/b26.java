package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class b26 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a26 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized a26 a() {
        InterceptResult invokeV;
        a26 a26Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (b26.class) {
                if (a == null) {
                    a = new a26();
                }
                a26Var = a;
            }
            return a26Var;
        }
        return (a26) invokeV.objValue;
    }
}
