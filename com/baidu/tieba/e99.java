package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class e99 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d99 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized d99 a() {
        InterceptResult invokeV;
        d99 d99Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (e99.class) {
                if (a == null) {
                    a = new d99();
                }
                d99Var = a;
            }
            return d99Var;
        }
        return (d99) invokeV.objValue;
    }
}
