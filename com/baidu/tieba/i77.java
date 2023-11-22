package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class i77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final h77 a(z47 z47Var, Map<String, String> businessInfo) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, z47Var, businessInfo)) == null) {
            Intrinsics.checkNotNullParameter(businessInfo, "businessInfo");
            try {
                String str = businessInfo.get("forum_id");
                wc7.b(str, null, 1, null);
                String str2 = businessInfo.get("thread_id");
                wc7.b(str2, null, 1, null);
                h77 h77Var = new h77(str, str2);
                h77Var.d(z47Var);
                return h77Var;
            } catch (Exception unused) {
                return null;
            }
        }
        return (h77) invokeLL.objValue;
    }
}
