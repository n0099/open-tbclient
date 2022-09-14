package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class go3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fo3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized fo3 a() {
        InterceptResult invokeV;
        fo3 fo3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (go3.class) {
                if (a == null) {
                    a = new fo3();
                }
                fo3Var = a;
            }
            return fo3Var;
        }
        return (fo3) invokeV.objValue;
    }
}
