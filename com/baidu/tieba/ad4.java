package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ad4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile zc4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized zc4 a() {
        InterceptResult invokeV;
        zc4 zc4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ad4.class) {
                if (a == null) {
                    a = new zc4();
                }
                zc4Var = a;
            }
            return zc4Var;
        }
        return (zc4) invokeV.objValue;
    }
}
