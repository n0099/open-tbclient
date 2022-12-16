package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class bv5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile av5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized av5 a() {
        InterceptResult invokeV;
        av5 av5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bv5.class) {
                if (a == null) {
                    a = new av5();
                }
                av5Var = a;
            }
            return av5Var;
        }
        return (av5) invokeV.objValue;
    }
}
