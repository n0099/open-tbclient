package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class fu0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile eu0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized eu0 a() {
        InterceptResult invokeV;
        eu0 eu0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fu0.class) {
                if (a == null) {
                    a = new eu0();
                }
                eu0Var = a;
            }
            return eu0Var;
        }
        return (eu0) invokeV.objValue;
    }
}
