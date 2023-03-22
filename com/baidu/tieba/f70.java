package com.baidu.tieba;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.DisplayMetrics;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class f70 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            DisplayMetrics c = c(context);
            if (c != null) {
                return c.densityDpi;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            DisplayMetrics c = c(context);
            if (c != null) {
                return c.heightPixels;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static DisplayMetrics c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (context == null) {
                return null;
            }
            return context.getResources().getDisplayMetrics();
        }
        return (DisplayMetrics) invokeL.objValue;
    }

    public static int d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            DisplayMetrics c = c(context);
            if (c != null) {
                return c.widthPixels;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return "unknown";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            int d = d(context);
            int b = b(context);
            int a = a(context);
            String f = f(context);
            return d + "_" + b + "_android_" + f + "_" + a;
        }
        return (String) invokeL.objValue;
    }
}
