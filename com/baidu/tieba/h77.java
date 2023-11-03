package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class h77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final g77 a(y47 y47Var, Map<String, String> businessInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, y47Var, businessInfo)) == null) {
            Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
            try {
                String str = businessInfo.get("forum_id");
                vc7.b(str, null, 1, null);
                String str2 = businessInfo.get("thread_id");
                vc7.b(str2, null, 1, null);
                g77 g77Var = new g77(str, str2);
                g77Var.d(y47Var);
                return g77Var;
            } catch (Exception unused) {
                return null;
            }
        }
        return (g77) invokeLL.objValue;
    }
}
