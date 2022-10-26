package com.baidu.tieba;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.util.DeviceId;
import com.baidu.searchbox.account.contants.AccountConstants;
import com.baidu.searchbox.common.security.DeviceIdBag;
import com.baidu.searchbox.common.security.DeviceInfoManager;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class ii1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean a = false;
    public static boolean b = false;
    public static String c = null;
    public static String d = "";
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            try {
                if (!kh1.f(context).d()) {
                    return "";
                }
                return DeviceId.getCUID(context);
            } catch (Throwable th) {
                wi1.d(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String d(DeviceIdBag deviceIdBag) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, deviceIdBag)) == null) {
            if (deviceIdBag == null) {
                return "";
            }
            if (deviceIdBag.errorCode == 3) {
                return String.valueOf(-1004);
            }
            if (TextUtils.isEmpty(deviceIdBag.deviceId)) {
                return "";
            }
            return deviceIdBag.deviceId;
        }
        return (String) invokeL.objValue;
    }

    public static boolean f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            if (!a) {
                if ("com.baidu.searchbox".equals(context.getPackageName())) {
                    b = true;
                }
                a = true;
            }
            return b;
        }
        return invokeL.booleanValue;
    }

    public static String b(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            try {
            } catch (Throwable th) {
                wi1.d(th);
            }
            if (f(context)) {
                return d(DeviceInfoManager.INSTANCE.getAndroidId(context, AccountConstants.LOGIN_TYPE_NATIVE_SRC_SSO, str));
            }
            if (!kh1.f(context).d()) {
                return d;
            }
            if (!TextUtils.isEmpty(d)) {
                return d;
            }
            if (!wi1.n(context)) {
                return "";
            }
            String string = ApiReplaceUtil.Overload.getString(context.getContentResolver(), HttpRequest.ANDROID_ID);
            d = string;
            if (TextUtils.isEmpty(string)) {
                d = "";
            }
            return d;
        }
        return (String) invokeLL.objValue;
    }

    public static String c(Context context, boolean z, boolean z2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2), str})) == null) {
            try {
                if (f(context)) {
                    return d(DeviceInfoManager.INSTANCE.getOAID(AccountConstants.LOGIN_TYPE_NATIVE_SRC_SSO, str));
                }
                if (!kh1.f(context).d()) {
                    return ej1.b(String.valueOf(-1000), z2);
                }
                if (z && !TextUtils.isEmpty(c)) {
                    return c;
                }
                if (!wi1.n(context)) {
                    return ej1.b(String.valueOf(-1002), z2);
                }
                String a2 = fj1.b().a();
                if (TextUtils.isEmpty(a2)) {
                    return ej1.b(String.valueOf(-1003), z2);
                }
                c = a2;
                return a2;
            } catch (Throwable th) {
                wi1.d(th);
                return "";
            }
        }
        return (String) invokeCommon.objValue;
    }

    public static String e(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            try {
                if (f(context)) {
                    return d(DeviceInfoManager.INSTANCE.getManufacturer(AccountConstants.LOGIN_TYPE_NATIVE_SRC_SSO, str));
                }
                return Build.MANUFACTURER;
            } catch (Throwable th) {
                wi1.d(th);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String g(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) {
            try {
                if (f(context)) {
                    return d(DeviceInfoManager.INSTANCE.getModel(AccountConstants.LOGIN_TYPE_NATIVE_SRC_SSO, str));
                }
                return Build.MODEL;
            } catch (Throwable th) {
                wi1.d(th);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String h(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, str)) == null) {
            try {
                if (f(context)) {
                    return d(DeviceInfoManager.INSTANCE.getOperator(context, AccountConstants.LOGIN_TYPE_NATIVE_SRC_SSO, str, true));
                }
                if (!kh1.f(context).d()) {
                    return "";
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    return telephonyManager.getSimOperator();
                }
                return String.valueOf(-1003);
            } catch (Throwable th) {
                wi1.d(th);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }
}
