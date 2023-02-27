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
import com.google.android.material.internal.ManufacturerUtils;
/* loaded from: classes4.dex */
public class ho1 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = null;
    public static String b = "";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static int a;
        public transient /* synthetic */ FieldHolder $fh;

        public static String g(Context context, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) {
                try {
                    if (d()) {
                        return b(DeviceInfoManager.INSTANCE.getAndroidId(context, AccountConstants.LOGIN_TYPE_NATIVE_SRC_SSO, str));
                    }
                } catch (Throwable unused) {
                }
                return "no_device_sdk";
            }
            return (String) invokeLL.objValue;
        }

        public static String i(Context context, String str) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) {
                try {
                    if (d()) {
                        return b(DeviceInfoManager.INSTANCE.getOperator(context, AccountConstants.LOGIN_TYPE_NATIVE_SRC_SSO, str, true));
                    }
                } catch (Throwable unused) {
                }
                return "no_device_sdk";
            }
            return (String) invokeLL.objValue;
        }

        public static String b(DeviceIdBag deviceIdBag) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, deviceIdBag)) == null) {
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

        public static String j(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
                try {
                    if (d()) {
                        return b(DeviceInfoManager.INSTANCE.getManufacturer(AccountConstants.LOGIN_TYPE_NATIVE_SRC_SSO, str));
                    }
                } catch (Throwable unused) {
                }
                return "no_device_sdk";
            }
            return (String) invokeL.objValue;
        }

        public static String k(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
                try {
                    if (d()) {
                        return b(DeviceInfoManager.INSTANCE.getModel(AccountConstants.LOGIN_TYPE_NATIVE_SRC_SSO, str));
                    }
                } catch (Throwable unused) {
                }
                return "no_device_sdk";
            }
            return (String) invokeL.objValue;
        }

        public static String l(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
                try {
                    if (d()) {
                        return b(DeviceInfoManager.INSTANCE.getOAID(AccountConstants.LOGIN_TYPE_NATIVE_SRC_SSO, str));
                    }
                } catch (Throwable unused) {
                }
                return "no_device_sdk";
            }
            return (String) invokeL.objValue;
        }

        public static boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                if (a == 0) {
                    try {
                        if (DeviceInfoManager.INSTANCE == null) {
                            a = 1;
                        } else {
                            a = 2;
                        }
                    } catch (Throwable unused) {
                        a = 1;
                    }
                }
                if (a == 2) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            try {
                if (!fn1.g(context).e()) {
                    return "";
                }
                return DeviceId.getCUID(context);
            } catch (Throwable th) {
                vo1.d(th);
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static String b(Context context, String str) {
        String g;
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, str)) == null) {
            try {
                g = a.g(context, str);
            } catch (Throwable th) {
                vo1.d(th);
            }
            if (!"no_device_sdk".equals(g)) {
                return g;
            }
            if (!fn1.g(context).e()) {
                return b;
            }
            if (!TextUtils.isEmpty(b)) {
                return b;
            }
            if (!vo1.n(context)) {
                return "";
            }
            String string = ApiReplaceUtil.Overload.getString(context.getContentResolver(), HttpRequest.ANDROID_ID);
            b = string;
            if (TextUtils.isEmpty(string)) {
                b = "";
            }
            return b;
        }
        return (String) invokeLL.objValue;
    }

    public static String g(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) {
            try {
                String i = a.i(context, str);
                if (!"no_device_sdk".equals(i)) {
                    return i;
                }
                if (!fn1.g(context).e()) {
                    return "";
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    return telephonyManager.getSimOperator();
                }
                return String.valueOf(-1003);
            } catch (Throwable th) {
                vo1.d(th);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String c(Context context, boolean z, boolean z2, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2), str})) == null) {
            try {
                String l = a.l(str);
                if (!"no_device_sdk".equals(l)) {
                    return l;
                }
                if (!fn1.g(context).e()) {
                    return ep1.b(String.valueOf(-1000), z2);
                }
                if (z && !TextUtils.isEmpty(a)) {
                    return a;
                }
                if (!vo1.n(context)) {
                    return ep1.b(String.valueOf(-1002), z2);
                }
                String a2 = fp1.b().a();
                if (TextUtils.isEmpty(a2)) {
                    return ep1.b(String.valueOf(-1003), z2);
                }
                a = a2;
                return a2;
            } catch (Throwable th) {
                vo1.d(th);
                return "";
            }
        }
        return (String) invokeCommon.objValue;
    }

    public static String d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            String h0 = fn1.g(context).h0();
            if (!TextUtils.isEmpty(h0)) {
                return h0;
            }
            String str = "0";
            if (!fn1.g(context).e()) {
                return "0";
            }
            String str2 = Build.MANUFACTURER;
            if (str2.equalsIgnoreCase("HUAWEI")) {
                str = "1";
            } else if (str2.equalsIgnoreCase("Xiaomi")) {
                str = "2";
            } else if (str2.equalsIgnoreCase("oppo")) {
                str = "3";
            } else if (str2.equalsIgnoreCase("vivo")) {
                str = "4";
            } else if (str2.equalsIgnoreCase("realme")) {
                str = "5";
            } else if (str2.equalsIgnoreCase("honor")) {
                str = "6";
            } else if (str2.equalsIgnoreCase("OnePlus")) {
                str = "7";
            } else if (str2.equalsIgnoreCase(ManufacturerUtils.SAMSUNG)) {
                str = "8";
            }
            fn1.g(context).M(str);
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static String e(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            try {
                String j = a.j(str);
                if (!"no_device_sdk".equals(j)) {
                    return j;
                }
                return Build.MANUFACTURER;
            } catch (Throwable th) {
                vo1.d(th);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String f(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, str)) == null) {
            try {
                String k = a.k(str);
                if (!"no_device_sdk".equals(k)) {
                    return k;
                }
                return Build.MODEL;
            } catch (Throwable th) {
                vo1.d(th);
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }
}
