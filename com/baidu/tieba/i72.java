package com.baidu.tieba;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class i72 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;
    public j72 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947806341, "Lcom/baidu/tieba/i72;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947806341, "Lcom/baidu/tieba/i72;");
                return;
            }
        }
        b = vj1.a;
    }

    public i72() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = j72.a;
    }

    public final void a(@NonNull k03 k03Var, @NonNull PrefetchEvent prefetchEvent, @Nullable PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, k03Var, prefetchEvent, pMSAppInfo) == null) {
            Bundle bundle = new Bundle();
            bundle.setClassLoader(PrefetchEvent.class.getClassLoader());
            bundle.putParcelable("swan_app_bundle_prefetch", prefetchEvent);
            if (pMSAppInfo == null) {
                pMSAppInfo = ib4.i().u(prefetchEvent.appId);
            }
            if (pMSAppInfo == null) {
                return;
            }
            bundle.putParcelable("swan_app_prefetch_pms_info", pMSAppInfo);
            if (this.a.a(prefetchEvent, pMSAppInfo, bundle)) {
                b03 e = b03.e();
                d03 d03Var = new d03(120, bundle);
                d03Var.b(k03Var.b);
                d03Var.p(false);
                e.h(d03Var);
            }
        }
    }

    public void b(@NonNull PrefetchEvent prefetchEvent, @NonNull k03 k03Var, @Nullable PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, prefetchEvent, k03Var, pMSAppInfo) == null) {
            a(k03Var, prefetchEvent, pMSAppInfo);
            k03Var.j0(prefetchEvent);
            if (b) {
                Log.d("PrefetchMessenger", "onPrefetchReady event: " + prefetchEvent);
                Log.d("PrefetchMessenger", "onPrefetchReady client id: " + k03Var.b.index);
            }
        }
    }
}
