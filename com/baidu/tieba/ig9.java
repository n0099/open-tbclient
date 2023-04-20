package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ig9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hg9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hg9 a() {
        InterceptResult invokeV;
        hg9 hg9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ig9.class) {
                if (a == null) {
                    a = new hg9();
                }
                hg9Var = a;
            }
            return hg9Var;
        }
        return (hg9) invokeV.objValue;
    }
}
