package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class if9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hf9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hf9 a() {
        InterceptResult invokeV;
        hf9 hf9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (if9.class) {
                if (a == null) {
                    a = new hf9();
                }
                hf9Var = a;
            }
            return hf9Var;
        }
        return (hf9) invokeV.objValue;
    }
}
