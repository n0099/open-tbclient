package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class bi8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ai8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ai8 a() {
        InterceptResult invokeV;
        ai8 ai8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (bi8.class) {
                if (a == null) {
                    a = new ai8();
                }
                ai8Var = a;
            }
            return ai8Var;
        }
        return (ai8) invokeV.objValue;
    }
}
