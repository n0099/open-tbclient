package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class a0a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zz9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zz9 a() {
        InterceptResult invokeV;
        zz9 zz9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (a0a.class) {
                if (a == null) {
                    a = new zz9();
                }
                zz9Var = a;
            }
            return zz9Var;
        }
        return (zz9) invokeV.objValue;
    }
}
