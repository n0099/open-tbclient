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
/* loaded from: classes5.dex */
public class c82 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final Map<String, ix1> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947628556, "Lcom/baidu/tieba/c82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947628556, "Lcom/baidu/tieba/c82;");
                return;
            }
        }
        a = nr1.a;
        b = new HashMap(2);
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) && c()) {
            b();
        }
    }

    public static ix1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a) {
                Log.d("ConsoleCache", "create new sConsole");
            }
            d82.n(true);
            return xh2.U().f0().b(AppRuntime.getAppContext());
        }
        return (ix1) invokeV.objValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            db3 b0 = db3.b0();
            if (b0 != null && !TextUtils.isEmpty(b0.b)) {
                return b82.b(f32.a(b0.b));
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
    public static synchronized ix1 b() {
        InterceptResult invokeV;
        String str;
        ix1 ix1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (c82.class) {
                db3 b0 = db3.b0();
                if (b0 != null && !TextUtils.isEmpty(b0.getAppId())) {
                    str = b0.getAppId();
                    String a2 = f32.a(str);
                    ix1Var = b.get(a2);
                    if (ix1Var == null) {
                        e();
                        ix1Var = a();
                        b.put(a2, ix1Var);
                        if (a) {
                            Log.d("ConsoleCache", "can not find sconsole for appId - " + str);
                        }
                    }
                    if (a) {
                        Log.d("ConsoleCache", "get sconsole for appId - " + str);
                    }
                }
                str = "_no_id_";
                String a22 = f32.a(str);
                ix1Var = b.get(a22);
                if (ix1Var == null) {
                }
                if (a) {
                }
            }
            return ix1Var;
        }
        return (ix1) invokeV.objValue;
    }

    public static synchronized void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            synchronized (c82.class) {
                if (b.size() > 0) {
                    for (String str : b.keySet()) {
                        ix1 ix1Var = b.get(str);
                        if (ix1Var != null) {
                            ix1Var.D();
                        }
                    }
                    b.clear();
                }
            }
        }
    }
}
