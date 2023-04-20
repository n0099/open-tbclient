package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class gc4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fc4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fc4 a() {
        InterceptResult invokeV;
        fc4 fc4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (gc4.class) {
                if (a == null) {
                    a = new fc4();
                }
                fc4Var = a;
            }
            return fc4Var;
        }
        return (fc4) invokeV.objValue;
    }
}
