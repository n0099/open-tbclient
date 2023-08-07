package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedLayout;
/* loaded from: classes5.dex */
public final class b67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(a67 a67Var, FeedLayout feedLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, a67Var, feedLayout) == null) {
            Intrinsics.checkNotNullParameter(a67Var, "<this>");
            Intrinsics.checkNotNullParameter(feedLayout, "feedLayout");
            a67Var.a().b(z87.a.a(feedLayout.business_info));
            a67Var.c().b(z87.a.a(feedLayout.log_info));
        }
    }

    public static final Map<String, String> c(a67 a67Var, String statStrategyKey) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, a67Var, statStrategyKey)) == null) {
            Intrinsics.checkNotNullParameter(a67Var, "<this>");
            Intrinsics.checkNotNullParameter(statStrategyKey, "statStrategyKey");
            HashMap hashMap = new HashMap();
            y97 y97Var = a67Var.e().get(statStrategyKey);
            if (y97Var != null) {
                hashMap.putAll(y97Var.a(a67Var.a()));
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public static final c77 b(a67 a67Var, String statStrategyKey) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, a67Var, statStrategyKey)) == null) {
            Intrinsics.checkNotNullParameter(a67Var, "<this>");
            Intrinsics.checkNotNullParameter(statStrategyKey, "statStrategyKey");
            y97 y97Var = a67Var.e().get(statStrategyKey);
            if (y97Var instanceof z97) {
                statStrategyKey = ((z97) y97Var).c(a67Var.a());
            }
            c77 c77Var = new c77(null, null, null, null, null, 31, null);
            y97 y97Var2 = a67Var.e().get(statStrategyKey);
            if (y97Var2 != null) {
                c77Var = new c77(y97Var2.getKey(), y97Var2.a(a67Var.a()), a67Var.c().a(), null, null, 24, null);
                if (y97Var2 instanceof w97) {
                    c77Var.g(((w97) y97Var2).b());
                }
                if (y97Var2 instanceof k67) {
                    c77Var.f(((k67) y97Var2).d());
                }
            }
            return c77Var;
        }
        return (c77) invokeLL.objValue;
    }
}
