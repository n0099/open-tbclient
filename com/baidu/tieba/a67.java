package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedLayout;
/* loaded from: classes5.dex */
public final class a67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final d57 a(z57 z57Var, Map<String, String> appendMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, z57Var, appendMap)) == null) {
            Intrinsics.checkNotNullParameter(z57Var, "<this>");
            Intrinsics.checkNotNullParameter(appendMap, "appendMap");
            d57 d57Var = new d57();
            d57Var.a().putAll(z57Var.a().a());
            d57Var.a().putAll(appendMap);
            return d57Var;
        }
        return (d57) invokeLL.objValue;
    }

    public static final void b(z57 z57Var, FeedLayout feedLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, z57Var, feedLayout) == null) {
            Intrinsics.checkNotNullParameter(z57Var, "<this>");
            Intrinsics.checkNotNullParameter(feedLayout, "feedLayout");
            z57Var.a().b(da7.a.a(feedLayout.business_info));
            z57Var.c().b(da7.a.a(feedLayout.log_info));
        }
    }

    public static final Map<String, String> e(z57 z57Var, String statStrategyKey) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, z57Var, statStrategyKey)) == null) {
            Intrinsics.checkNotNullParameter(z57Var, "<this>");
            Intrinsics.checkNotNullParameter(statStrategyKey, "statStrategyKey");
            HashMap hashMap = new HashMap();
            gb7 gb7Var = z57Var.e().get(statStrategyKey);
            if (gb7Var != null) {
                hashMap.putAll(gb7Var.a(z57Var.a()));
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public static final m77 c(z57 z57Var, String statStrategyKey, d57 d57Var) {
        InterceptResult invokeLLL;
        d57 d57Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, z57Var, statStrategyKey, d57Var)) == null) {
            Intrinsics.checkNotNullParameter(z57Var, "<this>");
            Intrinsics.checkNotNullParameter(statStrategyKey, "statStrategyKey");
            gb7 gb7Var = z57Var.e().get(statStrategyKey);
            if (gb7Var instanceof hb7) {
                hb7 hb7Var = (hb7) gb7Var;
                if (d57Var == null) {
                    d57Var2 = z57Var.a();
                } else {
                    d57Var2 = d57Var;
                }
                statStrategyKey = hb7Var.c(d57Var2);
            }
            m77 m77Var = new m77(null, null, null, null, null, 31, null);
            gb7 gb7Var2 = z57Var.e().get(statStrategyKey);
            if (gb7Var2 != null) {
                String key = gb7Var2.getKey();
                if (d57Var == null) {
                    d57Var = z57Var.a();
                }
                m77Var = new m77(key, gb7Var2.a(d57Var), z57Var.c().a(), null, null, 24, null);
                if (gb7Var2 instanceof db7) {
                    m77Var.g(((db7) gb7Var2).b());
                }
                if (gb7Var2 instanceof n67) {
                    m77Var.f(((n67) gb7Var2).d());
                }
            }
            return m77Var;
        }
        return (m77) invokeLLL.objValue;
    }

    public static /* synthetic */ m77 d(z57 z57Var, String str, d57 d57Var, int i, Object obj) {
        if ((i & 2) != 0) {
            d57Var = null;
        }
        return c(z57Var, str, d57Var);
    }
}
