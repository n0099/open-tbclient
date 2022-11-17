package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class el8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile dl8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized dl8 a() {
        InterceptResult invokeV;
        dl8 dl8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (el8.class) {
                if (a == null) {
                    a = new dl8();
                }
                dl8Var = a;
            }
            return dl8Var;
        }
        return (dl8) invokeV.objValue;
    }
}
