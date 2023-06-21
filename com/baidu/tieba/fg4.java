package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class fg4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile eg4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized eg4 a() {
        InterceptResult invokeV;
        eg4 eg4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (fg4.class) {
                if (a == null) {
                    a = new eg4();
                }
                eg4Var = a;
            }
            return eg4Var;
        }
        return (eg4) invokeV.objValue;
    }
}
