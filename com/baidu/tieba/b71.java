package com.baidu.tieba;

import android.content.Context;
import com.baidu.nadcore.webview.view.AbsNadBrowserView;
import com.baidu.tieba.j81;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class b71 {
    public static /* synthetic */ Interceptable $ic;
    public static final a a;
    public static final int b = 0;
    public static final int c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public interface a {
        boolean a(HashMap<String, String> hashMap, int i);

        void b(Context context, int i);

        AbsNadBrowserView c(Context context, l81 l81Var, int i);

        void d(Context context, boolean z, int i, j81.b bVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947597773, "Lcom/baidu/tieba/b71;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947597773, "Lcom/baidu/tieba/b71;");
                return;
            }
        }
        a aVar = a71.b;
        Intrinsics.checkNotNullExpressionValue(aVar, "BuildConfig.BROWSER_FACTORY");
        a = aVar;
        c = 1;
    }

    public static final a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a;
        }
        return (a) invokeV.objValue;
    }

    public static final int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b;
        }
        return invokeV.intValue;
    }

    public static final int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return c;
        }
        return invokeV.intValue;
    }
}
