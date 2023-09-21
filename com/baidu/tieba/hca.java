package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class hca {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gca a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized gca a() {
        InterceptResult invokeV;
        gca gcaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (hca.class) {
                if (a == null) {
                    a = new gca();
                }
                gcaVar = a;
            }
            return gcaVar;
        }
        return (gca) invokeV.objValue;
    }
}
