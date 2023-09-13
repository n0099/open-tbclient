package com.baidu.tieba;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class a0c {
    public static /* synthetic */ Interceptable $ic;
    public static Context a;
    public transient /* synthetic */ FieldHolder $fh;

    public static Context a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            return a;
        }
        return (Context) invokeV.objValue;
    }

    public static void b(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, context) == null) && context != null && a == null) {
            a = context.getApplicationContext();
        }
    }
}
