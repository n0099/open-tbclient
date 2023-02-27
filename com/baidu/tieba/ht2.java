package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ht2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gt2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gt2 a() {
        InterceptResult invokeV;
        gt2 gt2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ht2.class) {
                if (a == null) {
                    a = new gt2();
                }
                gt2Var = a;
            }
            return gt2Var;
        }
        return (gt2) invokeV.objValue;
    }
}
