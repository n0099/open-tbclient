package com.baidu.tieba;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class b83 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947598796, "Lcom/baidu/tieba/b83;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947598796, "Lcom/baidu/tieba/b83;");
                return;
            }
        }
        a = rr1.a;
    }

    public static void a(@Nullable Bundle bundle, @NonNull Class<? extends h73> cls) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, bundle, cls) == null) {
            Iterator<g83> it = i83.k().q().iterator();
            while (it.hasNext()) {
                g83 next = it.next();
                if (next != null && next.T()) {
                    b(next.b, bundle, cls, null);
                }
            }
        }
    }

    public static void b(SwanAppProcessInfo swanAppProcessInfo, @Nullable Bundle bundle, @NonNull Class<? extends h73> cls, @Nullable o73 o73Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65538, null, swanAppProcessInfo, bundle, cls, o73Var) == null) {
            if (a) {
                Log.d("SwanAppMessageChannel", "sendMessageToClient: delegation: " + cls.getName());
            }
            Message obtain = Message.obtain((Handler) null, 125);
            obtain.replyTo = i83.k().d;
            Bundle bundle2 = new Bundle();
            bundle2.putString("ai_apps_delegation_name", cls.getName());
            if (o73Var != null) {
                bundle2.putString("ai_apps_observer_id", o73Var.b());
                l73.b().e(o73Var);
            }
            if (bundle != null) {
                bundle2.putBundle("ai_apps_data", bundle);
            }
            obtain.obj = bundle2;
            x73 e = x73.e();
            z73 z73Var = new z73(obtain);
            z73Var.b(swanAppProcessInfo);
            e.h(z73Var);
        }
    }

    public static void c(@Nullable Bundle bundle, @NonNull Class<? extends h73> cls, @Nullable o73 o73Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, bundle, cls, o73Var) == null) {
            c83.Q().X(bundle, cls, o73Var);
        }
    }
}
