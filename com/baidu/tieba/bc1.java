package com.baidu.tieba;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class bc1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            Context a = od1.a();
            Intrinsics.checkExpressionValueIsNotNull(a, "SdkRunTime.getAppContext()");
            PackageManager packageManager = a.getPackageManager();
            try {
                Context a2 = od1.a();
                Intrinsics.checkExpressionValueIsNotNull(a2, "SdkRunTime.getAppContext()");
                String str = packageManager.getPackageInfo(a2.getPackageName(), 0).packageName;
                Intrinsics.checkExpressionValueIsNotNull(str, "packageInfo.packageName");
                return str;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            Context a = od1.a();
            Intrinsics.checkExpressionValueIsNotNull(a, "SdkRunTime.getAppContext()");
            PackageManager packageManager = a.getPackageManager();
            try {
                Context a2 = od1.a();
                Intrinsics.checkExpressionValueIsNotNull(a2, "SdkRunTime.getAppContext()");
                String str = packageManager.getPackageInfo(a2.getPackageName(), 0).versionName;
                Intrinsics.checkExpressionValueIsNotNull(str, "packageInfo.versionName");
                return str;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    public static final void c(ub1 ub1Var, String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, ub1Var, str) == null) && ub1Var != null) {
            boolean z2 = false;
            if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                String a = ub1Var.a("Cookie");
                String str2 = "BDUSS=" + str;
                if ((a == null || StringsKt__StringsJVMKt.isBlank(a)) ? true : true) {
                    ub1Var.d("Cookie", str2);
                    return;
                }
                ub1Var.d("Cookie", a + "; " + str2);
            }
        }
    }

    public static final void d(ub1 ub1Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, ub1Var) == null) && ub1Var != null) {
            ub1Var.d("channel", "cashiersdk");
            ub1Var.d("deviceType", "ANDROID");
            ub1Var.d("osVersion", Build.VERSION.RELEASE);
            ub1Var.d(com.heytap.mcssdk.constant.b.C, "2.8.7.9");
            ub1Var.d("appVersion", b());
            ub1Var.d("sdkPgName", a());
            ub1Var.d("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        }
    }

    public static final tb1 e(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, jSONObject)) == null) {
            tb1 tb1Var = new tb1();
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    tb1Var.d(next, jSONObject.optString(next));
                }
            }
            return tb1Var;
        }
        return (tb1) invokeL.objValue;
    }
}
