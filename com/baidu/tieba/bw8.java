package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bw8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static Object a(@NonNull vv8 vv8Var, @NonNull wv8 wv8Var, @NonNull Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, vv8Var, wv8Var, obj)) == null) {
            try {
                return vv8Var.b(wv8Var, obj);
            } catch (Exception e) {
                BdLog.e(e);
                return null;
            }
        }
        return invokeLLL.objValue;
    }

    @Nullable
    public static Object b(@NonNull vv8 vv8Var, @NonNull wv8 wv8Var, @NonNull Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, vv8Var, wv8Var, obj)) == null) {
            try {
                return vv8Var.a(wv8Var, obj);
            } catch (Exception e) {
                e.printStackTrace();
                BdLog.e(e);
                return null;
            }
        }
        return invokeLLL.objValue;
    }
}
