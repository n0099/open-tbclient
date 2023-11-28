package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class e13 implements al3<HybridUbcFlow> {
    public static /* synthetic */ Interceptable $ic;
    public static final List<String> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947681442, "Lcom/baidu/tieba/e13;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947681442, "Lcom/baidu/tieba/e13;");
                return;
            }
        }
        a = new ArrayList(5);
    }

    public e13() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.al3
    /* renamed from: b */
    public void a(@NonNull HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hybridUbcFlow) == null) {
            b13.g().d(false);
            String h = hybridUbcFlow.h("launchid");
            if (!TextUtils.isEmpty(h)) {
                synchronized (a) {
                    if (!a.contains(h)) {
                        a.add(h);
                        d(h, hybridUbcFlow);
                    }
                }
            }
            String str = (String) hybridUbcFlow.k("routeId");
            if (!TextUtils.isEmpty(str)) {
                synchronized (a) {
                    if (!a.contains(str)) {
                        a.add(str);
                        c(str, hybridUbcFlow);
                    }
                }
            }
        }
    }

    public final void c(@NonNull String str, @NonNull HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, hybridUbcFlow) == null) {
            e(hybridUbcFlow);
            UbcFlowEvent g = hybridUbcFlow.g("na_first_meaningful_paint");
            HybridUbcFlow e = mz2.e("route", str);
            if (e != null && g != null) {
                e.F(g);
                e.B();
            }
        }
    }

    public final void d(@NonNull String str, @NonNull HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, hybridUbcFlow) == null) {
            e(hybridUbcFlow);
        }
    }

    public final void e(@NonNull HybridUbcFlow hybridUbcFlow) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, hybridUbcFlow) != null) || hybridUbcFlow.g("na_first_meaningful_paint") == null) {
            return;
        }
        bd2.V().V0(new og2((String) hybridUbcFlow.k(PrefetchEvent.EVENT_DATA_WEBVIEW_ID), (String) hybridUbcFlow.k(PrefetchEvent.EVENT_KEY_PAGE_URL)));
    }
}
