package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class dp5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cp5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized cp5 a() {
        InterceptResult invokeV;
        cp5 cp5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (dp5.class) {
                if (a == null) {
                    a = new cp5();
                }
                cp5Var = a;
            }
            return cp5Var;
        }
        return (cp5) invokeV.objValue;
    }
}
