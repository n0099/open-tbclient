package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class by3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ay3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ay3 a() {
        InterceptResult invokeV;
        ay3 ay3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (by3.class) {
                if (a == null) {
                    a = new ay3();
                }
                ay3Var = a;
            }
            return ay3Var;
        }
        return (ay3) invokeV.objValue;
    }
}
