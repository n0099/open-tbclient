package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class cp3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bp3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bp3 a() {
        InterceptResult invokeV;
        bp3 bp3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (cp3.class) {
                if (a == null) {
                    a = new bp3();
                }
                bp3Var = a;
            }
            return bp3Var;
        }
        return (bp3) invokeV.objValue;
    }
}
