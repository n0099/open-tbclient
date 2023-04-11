package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ct3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bt3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized bt3 a() {
        InterceptResult invokeV;
        bt3 bt3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ct3.class) {
                if (a == null) {
                    a = new bt3();
                }
                bt3Var = a;
            }
            return bt3Var;
        }
        return (bt3) invokeV.objValue;
    }
}
