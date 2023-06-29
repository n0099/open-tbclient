package com.baidu.tieba;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.validation.utils.ValidationLog;
/* loaded from: classes5.dex */
public class d3b {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public static String b;
    public static String c;
    public static String d;
    public static String e;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (TextUtils.isEmpty(b)) {
                String str = Build.VERSION.RELEASE;
                b = str;
                return str == null ? "" : str;
            }
            return b;
        }
        return (String) invokeV.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (TextUtils.isEmpty(d)) {
                try {
                    PackageManager packageManager = context.getPackageManager();
                    String charSequence = packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString();
                    d = charSequence;
                    return charSequence;
                } catch (Throwable unused) {
                    return null;
                }
            }
            return d;
        }
        return (String) invokeL.objValue;
    }

    public static String c(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, str)) == null) {
            StringBuilder sb = new StringBuilder(str);
            sb.append(" ");
            sb.append("Sapi_");
            sb.append(d());
            sb.append("_");
            sb.append("Android_");
            sb.append(b(context));
            sb.append("_");
            sb.append(e(context));
            sb.append("_");
            sb.append(f());
            sb.append("_");
            sb.append(a());
            sb.append("_Sapi");
            ValidationLog.e(sb.toString(), new Object[0]);
            return sb.toString();
        }
        return (String) invokeLL.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (TextUtils.isEmpty(c)) {
                c = "1.0.5";
                return "1.0.5";
            }
            return c;
        }
        return (String) invokeV.objValue;
    }

    public static String e(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            if (TextUtils.isEmpty(e)) {
                try {
                    String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                    e = str;
                    return str;
                } catch (Throwable unused) {
                    return null;
                }
            }
            return e;
        }
        return (String) invokeL.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (TextUtils.isEmpty(a)) {
                String str = Build.MODEL;
                a = str;
                return str == null ? "" : str;
            }
            return a;
        }
        return (String) invokeV.objValue;
    }
}
