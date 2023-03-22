package com.baidu.tieba;

import com.baidu.searchbox.live.interfaces.net.INetWork;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class db0 {
    public static /* synthetic */ Interceptable $ic;
    public static INetWork a;
    public transient /* synthetic */ FieldHolder $fh;

    public static INetWork a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            return a;
        }
        return (INetWork) invokeV.objValue;
    }

    public static void b(INetWork iNetWork) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, iNetWork) == null) {
            a = iNetWork;
        }
    }
}
