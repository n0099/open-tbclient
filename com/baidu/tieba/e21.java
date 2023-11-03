package com.baidu.tieba;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class e21 {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = false;
    public static boolean b = false;
    public static boolean c = false;
    public static boolean d = true;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947682341, "Lcom/baidu/tieba/e21;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947682341, "Lcom/baidu/tieba/e21;");
        }
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 23) {
                    if (context.checkSelfPermission(str) != 0) {
                        return false;
                    }
                    return true;
                } else if (context.checkCallingOrSelfPermission(str) != 0) {
                    return false;
                } else {
                    return true;
                }
            } catch (Throwable unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                if (MobadsPermissionSettings.PERMISSION_LOCATION.equalsIgnoreCase(str)) {
                    return b;
                }
                if (MobadsPermissionSettings.PERMISSION_STORAGE.equalsIgnoreCase(str)) {
                    return c;
                }
                if (MobadsPermissionSettings.PERMISSION_APP_LIST.equalsIgnoreCase(str)) {
                    return d;
                }
                if (MobadsPermissionSettings.PERMISSION_PHONE_STATE.equalsIgnoreCase(str)) {
                    return a;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
