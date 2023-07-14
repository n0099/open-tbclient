package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class gg4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fg4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fg4 a() {
        InterceptResult invokeV;
        fg4 fg4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gg4.class) {
                if (a == null) {
                    a = new fg4();
                }
                fg4Var = a;
            }
            return fg4Var;
        }
        return (fg4) invokeV.objValue;
    }
}
