package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class a03 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zz2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zz2 a() {
        InterceptResult invokeV;
        zz2 zz2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (a03.class) {
                if (a == null) {
                    a = new zz2();
                }
                zz2Var = a;
            }
            return zz2Var;
        }
        return (zz2) invokeV.objValue;
    }
}
