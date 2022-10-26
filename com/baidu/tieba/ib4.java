package com.baidu.tieba;

import android.os.Bundle;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Arrays;
import java.util.HashSet;
/* loaded from: classes4.dex */
public final class ib4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static Bundle a(fb4 fb4Var, Bundle bundle, String... strArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, fb4Var, bundle, strArr)) == null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            if (bundle.getLong("timestamp", -1L) < 0) {
                bundle.putLong("timestamp", System.currentTimeMillis());
            }
            return fb4Var.m(bundle, new HashSet(Arrays.asList(strArr)));
        }
        return (Bundle) invokeLLL.objValue;
    }

    public static Bundle b(fb4 fb4Var, String... strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, fb4Var, strArr)) == null) {
            return a(fb4Var, null, strArr);
        }
        return (Bundle) invokeLL.objValue;
    }
}
