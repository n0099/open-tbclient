package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class be4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ae4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ae4 a() {
        InterceptResult invokeV;
        ae4 ae4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (be4.class) {
                if (a == null) {
                    a = new ae4();
                }
                ae4Var = a;
            }
            return ae4Var;
        }
        return (ae4) invokeV.objValue;
    }
}
