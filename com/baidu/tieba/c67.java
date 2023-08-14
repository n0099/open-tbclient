package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedLayout;
/* loaded from: classes5.dex */
public final class c67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(b67 b67Var, FeedLayout feedLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, b67Var, feedLayout) == null) {
            Intrinsics.checkNotNullParameter(b67Var, "<this>");
            Intrinsics.checkNotNullParameter(feedLayout, "feedLayout");
            b67Var.a().b(a97.a.a(feedLayout.business_info));
            b67Var.c().b(a97.a.a(feedLayout.log_info));
        }
    }

    public static final Map<String, String> c(b67 b67Var, String statStrategyKey) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, b67Var, statStrategyKey)) == null) {
            Intrinsics.checkNotNullParameter(b67Var, "<this>");
            Intrinsics.checkNotNullParameter(statStrategyKey, "statStrategyKey");
            HashMap hashMap = new HashMap();
            z97 z97Var = b67Var.e().get(statStrategyKey);
            if (z97Var != null) {
                hashMap.putAll(z97Var.a(b67Var.a()));
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public static final d77 b(b67 b67Var, String statStrategyKey) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, b67Var, statStrategyKey)) == null) {
            Intrinsics.checkNotNullParameter(b67Var, "<this>");
            Intrinsics.checkNotNullParameter(statStrategyKey, "statStrategyKey");
            z97 z97Var = b67Var.e().get(statStrategyKey);
            if (z97Var instanceof aa7) {
                statStrategyKey = ((aa7) z97Var).c(b67Var.a());
            }
            d77 d77Var = new d77(null, null, null, null, null, 31, null);
            z97 z97Var2 = b67Var.e().get(statStrategyKey);
            if (z97Var2 != null) {
                d77Var = new d77(z97Var2.getKey(), z97Var2.a(b67Var.a()), b67Var.c().a(), null, null, 24, null);
                if (z97Var2 instanceof x97) {
                    d77Var.g(((x97) z97Var2).b());
                }
                if (z97Var2 instanceof l67) {
                    d77Var.f(((l67) z97Var2).d());
                }
            }
            return d77Var;
        }
        return (d77) invokeLL.objValue;
    }
}
