package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class bl8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile al8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized al8 a() {
        InterceptResult invokeV;
        al8 al8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bl8.class) {
                if (a == null) {
                    a = new al8();
                }
                al8Var = a;
            }
            return al8Var;
        }
        return (al8) invokeV.objValue;
    }
}
