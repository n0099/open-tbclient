package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class a83 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947569005, "Lcom/baidu/tieba/a83;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947569005, "Lcom/baidu/tieba/a83;");
                return;
            }
        }
        a = rr1.a;
    }

    public static void a(Message message) {
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, message) == null) {
            if (a) {
                Log.e("ChannelMsgProcessor", "MSG_TYPE_CS_DELEGATION");
            }
            int i = message.arg1;
            Bundle bundle2 = (Bundle) message.obj;
            String str = "";
            String str2 = null;
            if (bundle2 != null) {
                str2 = bundle2.getString("ai_apps_delegation_name", null);
                str = bundle2.getString("ai_apps_observer_id", "");
                bundle = bundle2.getBundle("ai_apps_data");
            } else {
                bundle = null;
            }
            i73.a(i, str2, str, bundle);
        }
    }

    public static void b(Message message) {
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, message) == null) {
            Bundle bundle2 = (Bundle) message.obj;
            String str = "";
            String str2 = null;
            if (bundle2 != null) {
                str2 = bundle2.getString("ai_apps_delegation_name", null);
                str = bundle2.getString("ai_apps_observer_id", "");
                bundle = bundle2.getBundle("ai_apps_data");
            } else {
                bundle = null;
            }
            i73.a(-1000, str2, str, bundle);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public static void c(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, message) == null) {
            Object obj = message.obj;
            if (!(obj instanceof Bundle)) {
                if (!a) {
                    return;
                }
                throw new RuntimeException("delegation msg obj is not a bundle");
            }
            Bundle bundle = (Bundle) obj;
            k73 k73Var = new k73(bundle.getString("key_observer_id", ""));
            k73Var.setResult(bundle.getBundle("key_result_data"));
            l73.b().c(k73Var);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public static void d(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, message) == null) {
            Object obj = message.obj;
            if (!(obj instanceof Bundle)) {
                if (!a) {
                    return;
                }
                throw new RuntimeException("delegation msg obj is not a bundle");
            }
            Bundle bundle = (Bundle) obj;
            k73 k73Var = new k73(bundle.getString("key_observer_id", ""));
            k73Var.setResult(bundle.getBundle("key_result_data"));
            l73.b().c(k73Var);
        }
    }

    public static void e(int i, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65541, null, i, bundle) == null) {
            x73 e = x73.e();
            z73 z73Var = new z73(126, bundle);
            z73Var.a(i);
            e.h(z73Var);
        }
    }

    public static void f(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, bundle) == null) {
            x73.e().h(new z73(21, bundle));
        }
    }
}
