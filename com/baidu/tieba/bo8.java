package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class bo8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ao8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ao8 a() {
        InterceptResult invokeV;
        ao8 ao8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bo8.class) {
                if (a == null) {
                    a = new ao8();
                }
                ao8Var = a;
            }
            return ao8Var;
        }
        return (ao8) invokeV.objValue;
    }
}
