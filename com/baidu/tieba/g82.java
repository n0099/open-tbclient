package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class g82 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final Map<String, mx1> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947747720, "Lcom/baidu/tieba/g82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947747720, "Lcom/baidu/tieba/g82;");
                return;
            }
        }
        a = rr1.a;
        b = new HashMap(2);
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) && c()) {
            b();
        }
    }

    public static mx1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a) {
                Log.d("ConsoleCache", "create new sConsole");
            }
            h82.n(true);
            return bi2.U().f0().b(AppRuntime.getAppContext());
        }
        return (mx1) invokeV.objValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            hb3 b0 = hb3.b0();
            if (b0 != null && !TextUtils.isEmpty(b0.b)) {
                return f82.b(j32.a(b0.b));
            }
            if (a) {
                Log.w("ConsoleCache", "swanApp is null or appId is empty");
                return false;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002d A[Catch: all -> 0x006f, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x000d, B:11:0x0018, B:13:0x001f, B:15:0x002d, B:17:0x003d, B:18:0x0053, B:20:0x0057), top: B:30:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0057 A[Catch: all -> 0x006f, TRY_LEAVE, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x000d, B:11:0x0018, B:13:0x001f, B:15:0x002d, B:17:0x003d, B:18:0x0053, B:20:0x0057), top: B:30:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized mx1 b() {
        InterceptResult invokeV;
        String str;
        mx1 mx1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (g82.class) {
                hb3 b0 = hb3.b0();
                if (b0 != null && !TextUtils.isEmpty(b0.getAppId())) {
                    str = b0.getAppId();
                    String a2 = j32.a(str);
                    mx1Var = b.get(a2);
                    if (mx1Var == null) {
                        e();
                        mx1Var = a();
                        b.put(a2, mx1Var);
                        if (a) {
                            Log.d("ConsoleCache", "can not find sconsole for appId - " + str);
                        }
                    }
                    if (a) {
                        Log.d("ConsoleCache", "get sconsole for appId - " + str);
                    }
                }
                str = "_no_id_";
                String a22 = j32.a(str);
                mx1Var = b.get(a22);
                if (mx1Var == null) {
                }
                if (a) {
                }
            }
            return mx1Var;
        }
        return (mx1) invokeV.objValue;
    }

    public static synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            synchronized (g82.class) {
                if (b.size() > 0) {
                    for (String str : b.keySet()) {
                        mx1 mx1Var = b.get(str);
                        if (mx1Var != null) {
                            mx1Var.D();
                        }
                    }
                    b.clear();
                }
            }
        }
    }
}
