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
public final class c97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final m87 a(b97 b97Var, Map<String, String> appendMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, b97Var, appendMap)) == null) {
            Intrinsics.checkNotNullParameter(b97Var, "<this>");
            Intrinsics.checkNotNullParameter(appendMap, "appendMap");
            m87 m87Var = new m87();
            m87Var.a().putAll(b97Var.a().a());
            m87Var.a().putAll(appendMap);
            return m87Var;
        }
        return (m87) invokeLL.objValue;
    }

    public static final void b(b97 b97Var, FeedLayout feedLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, b97Var, feedLayout) == null) {
            Intrinsics.checkNotNullParameter(b97Var, "<this>");
            Intrinsics.checkNotNullParameter(feedLayout, "feedLayout");
            b97Var.a().b(dc7.a.a(feedLayout.business_info));
            b97Var.c().b(dc7.a.a(feedLayout.log_info));
        }
    }

    public static final Map<String, String> e(b97 b97Var, String statStrategyKey) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, b97Var, statStrategyKey)) == null) {
            Intrinsics.checkNotNullParameter(b97Var, "<this>");
            Intrinsics.checkNotNullParameter(statStrategyKey, "statStrategyKey");
            HashMap hashMap = new HashMap();
            cd7 cd7Var = b97Var.e().get(statStrategyKey);
            if (cd7Var != null) {
                hashMap.putAll(cd7Var.a(b97Var.a()));
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public static final ea7 c(b97 b97Var, String statStrategyKey, m87 m87Var) {
        InterceptResult invokeLLL;
        m87 m87Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, b97Var, statStrategyKey, m87Var)) == null) {
            Intrinsics.checkNotNullParameter(b97Var, "<this>");
            Intrinsics.checkNotNullParameter(statStrategyKey, "statStrategyKey");
            cd7 cd7Var = b97Var.e().get(statStrategyKey);
            if (cd7Var instanceof dd7) {
                dd7 dd7Var = (dd7) cd7Var;
                if (m87Var == null) {
                    m87Var2 = b97Var.a();
                } else {
                    m87Var2 = m87Var;
                }
                statStrategyKey = dd7Var.c(m87Var2);
            }
            ea7 ea7Var = new ea7(null, null, null, null, null, 31, null);
            cd7 cd7Var2 = b97Var.e().get(statStrategyKey);
            if (cd7Var2 != null) {
                String key = cd7Var2.getKey();
                if (m87Var == null) {
                    m87Var = b97Var.a();
                }
                ea7Var = new ea7(key, cd7Var2.a(m87Var), b97Var.c().a(), null, null, 24, null);
                if (cd7Var2 instanceof ad7) {
                    ea7Var.g(((ad7) cd7Var2).b());
                }
                if (cd7Var2 instanceof l97) {
                    ea7Var.f(((l97) cd7Var2).d());
                }
            }
            return ea7Var;
        }
        return (ea7) invokeLLL.objValue;
    }

    public static /* synthetic */ ea7 d(b97 b97Var, String str, m87 m87Var, int i, Object obj) {
        if ((i & 2) != 0) {
            m87Var = null;
        }
        return c(b97Var, str, m87Var);
    }
}
