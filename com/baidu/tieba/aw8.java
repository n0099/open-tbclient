package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class aw8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static Object a(@NonNull uv8 uv8Var, @NonNull vv8 vv8Var, @NonNull Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, uv8Var, vv8Var, obj)) == null) {
            try {
                return uv8Var.b(vv8Var, obj);
            } catch (Exception e) {
                BdLog.e(e);
                return null;
            }
        }
        return invokeLLL.objValue;
    }

    @Nullable
    public static Object b(@NonNull uv8 uv8Var, @NonNull vv8 vv8Var, @NonNull Object obj) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, uv8Var, vv8Var, obj)) == null) {
            try {
                return uv8Var.a(vv8Var, obj);
            } catch (Exception e) {
                e.printStackTrace();
                BdLog.e(e);
                return null;
            }
        }
        return invokeLLL.objValue;
    }
}
