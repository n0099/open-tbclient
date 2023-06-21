package com.baidu.tieba;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.IntentConstants;
import com.baidu.searchbox.common.security.CacheDeviceInfo;
import com.baidu.searchbox.download.util.ApkUtil;
import com.baidu.searchbox.performance.speed.task.LaunchTaskConstants;
import com.baidu.tieba.d61;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/* loaded from: classes5.dex */
public class en0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(String str, String str2) {
        InterceptResult invokeLL;
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, str, str2)) == null) {
            if (TextUtils.equals(z21.c(str).optString("direct_download_switch"), "1")) {
                return true;
            }
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            Uri parse = Uri.parse(str2);
            HashMap hashMap = new HashMap();
            if (parse != null) {
                try {
                    Set<String> queryParameterNames = parse.getQueryParameterNames();
                    if (queryParameterNames != null) {
                        for (String str3 : queryParameterNames) {
                            hashMap.put(str3, parse.getQueryParameter(str3));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            String str4 = (String) a31.b(hashMap, CacheDeviceInfo.JSON_KEY_ANDROID_ID);
            if (!TextUtils.isEmpty(str4) && (split = str4.split("_")) != null && split.length >= 4 && TextUtils.equals(split[3], "1")) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean e(File file, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, file, z)) == null) {
            if (!f(file)) {
                return false;
            }
            Context b = lk0.b();
            Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER);
            try {
                intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
                intent.setFlags(1342177280);
                intent.putExtra(ApkUtil.KEY_INSTALLER_PACKAGE_NAME, b.getPackageName());
                if (z) {
                    intent.putExtra("android.intent.extra.RETURN_RESULT", true);
                }
                if (!d61.b.e()) {
                    intent.setComponent(new ComponentName(ApkUtil.PACKAGE_INSTALLER, ApkUtil.PACKAGE_INSTALLER_ACTIVITY));
                }
                v51.a(b, file, intent);
                v51.d(b, intent);
            } catch (Exception unused) {
                intent.setComponent(null);
                v51.a(b, file, intent);
                try {
                    b.startActivity(intent);
                } catch (Exception unused2) {
                    return false;
                }
            }
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public static String b(File file) {
        InterceptResult invokeL;
        PackageManager packageManager;
        PackageInfo packageArchiveInfo;
        ApplicationInfo applicationInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
            if (file == null || TextUtils.isEmpty(file.getPath()) || (packageManager = lk0.b().getPackageManager()) == null || (packageArchiveInfo = packageManager.getPackageArchiveInfo(file.getPath(), 1)) == null || (applicationInfo = packageArchiveInfo.applicationInfo) == null) {
                return "";
            }
            return applicationInfo.packageName;
        }
        return (String) invokeL.objValue;
    }

    public static boolean f(File file) {
        InterceptResult invokeL;
        PackageManager packageManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, file)) == null) {
            if (file == null || TextUtils.isEmpty(file.getAbsolutePath()) || !file.exists() || (packageManager = lk0.b().getPackageManager()) == null || packageManager.getPackageArchiveInfo(file.getAbsolutePath(), 1) == null) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                lk0.b().getPackageManager().getApplicationInfo(str, 0);
                return true;
            } catch (PackageManager.NameNotFoundException | Exception unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static boolean d(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, file)) == null) {
            return e(file, false);
        }
        return invokeL.booleanValue;
    }

    public static boolean g(String str) {
        InterceptResult invokeL;
        ResolveInfo next;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(str);
            List<ResolveInfo> queryIntentActivities = lk0.b().getPackageManager().queryIntentActivities(intent, 0);
            if (queryIntentActivities == null || queryIntentActivities.size() <= 0 || (next = queryIntentActivities.iterator().next()) == null) {
                return false;
            }
            String str2 = next.activityInfo.name;
            Intent intent2 = new Intent("android.intent.action.MAIN");
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.setComponent(new ComponentName(str, str2));
            intent2.setFlags(LaunchTaskConstants.OTHER_PROCESS);
            return v51.e(lk0.b(), intent2, true);
        }
        return invokeL.booleanValue;
    }
}
