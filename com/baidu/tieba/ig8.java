package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ig8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hg8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hg8 a() {
        InterceptResult invokeV;
        hg8 hg8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ig8.class) {
                if (a == null) {
                    a = new hg8();
                }
                hg8Var = a;
            }
            return hg8Var;
        }
        return (hg8) invokeV.objValue;
    }
}
