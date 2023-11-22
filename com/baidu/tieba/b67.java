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
public final class b67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final e57 a(a67 a67Var, Map<String, String> appendMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, a67Var, appendMap)) == null) {
            Intrinsics.checkNotNullParameter(a67Var, "<this>");
            Intrinsics.checkNotNullParameter(appendMap, "appendMap");
            e57 e57Var = new e57();
            e57Var.a().putAll(a67Var.a().a());
            e57Var.a().putAll(appendMap);
            return e57Var;
        }
        return (e57) invokeLL.objValue;
    }

    public static final void b(a67 a67Var, FeedLayout feedLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, a67Var, feedLayout) == null) {
            Intrinsics.checkNotNullParameter(a67Var, "<this>");
            Intrinsics.checkNotNullParameter(feedLayout, "feedLayout");
            a67Var.a().b(ea7.a.a(feedLayout.business_info));
            a67Var.c().b(ea7.a.a(feedLayout.log_info));
        }
    }

    public static final Map<String, String> e(a67 a67Var, String statStrategyKey) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, a67Var, statStrategyKey)) == null) {
            Intrinsics.checkNotNullParameter(a67Var, "<this>");
            Intrinsics.checkNotNullParameter(statStrategyKey, "statStrategyKey");
            HashMap hashMap = new HashMap();
            hb7 hb7Var = a67Var.e().get(statStrategyKey);
            if (hb7Var != null) {
                hashMap.putAll(hb7Var.a(a67Var.a()));
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public static final n77 c(a67 a67Var, String statStrategyKey, e57 e57Var) {
        InterceptResult invokeLLL;
        e57 e57Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, a67Var, statStrategyKey, e57Var)) == null) {
            Intrinsics.checkNotNullParameter(a67Var, "<this>");
            Intrinsics.checkNotNullParameter(statStrategyKey, "statStrategyKey");
            hb7 hb7Var = a67Var.e().get(statStrategyKey);
            if (hb7Var instanceof ib7) {
                ib7 ib7Var = (ib7) hb7Var;
                if (e57Var == null) {
                    e57Var2 = a67Var.a();
                } else {
                    e57Var2 = e57Var;
                }
                statStrategyKey = ib7Var.c(e57Var2);
            }
            n77 n77Var = new n77(null, null, null, null, null, 31, null);
            hb7 hb7Var2 = a67Var.e().get(statStrategyKey);
            if (hb7Var2 != null) {
                String key = hb7Var2.getKey();
                if (e57Var == null) {
                    e57Var = a67Var.a();
                }
                n77Var = new n77(key, hb7Var2.a(e57Var), a67Var.c().a(), null, null, 24, null);
                if (hb7Var2 instanceof eb7) {
                    n77Var.g(((eb7) hb7Var2).b());
                }
                if (hb7Var2 instanceof o67) {
                    n77Var.f(((o67) hb7Var2).d());
                }
            }
            return n77Var;
        }
        return (n77) invokeLLL.objValue;
    }

    public static /* synthetic */ n77 d(a67 a67Var, String str, e57 e57Var, int i, Object obj) {
        if ((i & 2) != 0) {
            e57Var = null;
        }
        return c(a67Var, str, e57Var);
    }
}
