package com.baidu.tieba;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.browser.core.util.BdLog;
import com.baidu.permissionhelper.ApiUtil;
import com.baidu.permissionhelper.context.ContextCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.sdk.PermissionRequest;
/* loaded from: classes4.dex */
public class cw {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "cw";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448302009, "Lcom/baidu/tieba/cw;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448302009, "Lcom/baidu/tieba/cw;");
        }
    }

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (context == null) {
                return false;
            }
            try {
                return ContextCompat.checkPermissionGranted(context, PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            } catch (Throwable th) {
                BdLog.c(a, th);
                if (ApiUtil.shouldCheckPermission()) {
                    return false;
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        if (com.baidu.permissionhelper.context.ContextCompat.checkPermissionGranted(r5, com.kuaishou.weapon.p0.h.i) != false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            boolean z = false;
            if (context == null) {
                return false;
            }
            try {
                boolean checkPermissionGranted = ContextCompat.checkPermissionGranted(context, "android.permission.WRITE_EXTERNAL_STORAGE");
                if (Build.VERSION.SDK_INT >= 16) {
                    if (!checkPermissionGranted) {
                    }
                    z = true;
                    return z;
                }
                return checkPermissionGranted;
            } catch (Throwable th) {
                BdLog.c(a, th);
                if (ApiUtil.shouldCheckPermission()) {
                    return false;
                }
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean c(Context context, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, context, i)) == null) {
            if (context == null) {
                return false;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(a, 0);
            if (sharedPreferences == null) {
                return true;
            }
            String str = "permission_request_code=" + String.valueOf(i);
            boolean z = sharedPreferences.getBoolean(str, true);
            d(context, str);
            return z;
        }
        return invokeLI.booleanValue;
    }

    public static void d(Context context, String str) {
        SharedPreferences sharedPreferences;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str) == null) && context != null && (sharedPreferences = context.getSharedPreferences(a, 0)) != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean(str, false);
            edit.apply();
        }
    }
}
