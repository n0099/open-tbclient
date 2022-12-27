package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class bn8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile an8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized an8 a() {
        InterceptResult invokeV;
        an8 an8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bn8.class) {
                if (a == null) {
                    a = new an8();
                }
                an8Var = a;
            }
            return an8Var;
        }
        return (an8) invokeV.objValue;
    }
}
