package com.baidu.tieba;

import android.app.Application;
import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ij1 {
    public static /* synthetic */ Interceptable $ic;
    public static Application a;
    public transient /* synthetic */ FieldHolder $fh;

    public static Context a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            return a;
        }
        return (Context) invokeV.objValue;
    }

    public static void b(Application application) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, application) == null) {
            a = application;
        }
    }
}
