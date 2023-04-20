package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ga4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fa4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fa4 a() {
        InterceptResult invokeV;
        fa4 fa4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ga4.class) {
                if (a == null) {
                    a = new fa4();
                }
                fa4Var = a;
            }
            return fa4Var;
        }
        return (fa4) invokeV.objValue;
    }
}
