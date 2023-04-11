package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class ag9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zf9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zf9 a() {
        InterceptResult invokeV;
        zf9 zf9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ag9.class) {
                if (a == null) {
                    a = new zf9();
                }
                zf9Var = a;
            }
            return zf9Var;
        }
        return (zf9) invokeV.objValue;
    }
}
