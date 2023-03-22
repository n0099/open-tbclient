package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.pass.biometrics.base.utils.SapiSystemBarTintManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
/* loaded from: classes4.dex */
public class dl3 {
    public static /* synthetic */ Interceptable $ic;
    public static final String a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947708350, "Lcom/baidu/tieba/dl3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947708350, "Lcom/baidu/tieba/dl3;");
                return;
            }
        }
        a = bm3.b;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            Context appContext = AppRuntime.getAppContext();
            if (f(appContext)) {
                return false;
            }
            return a(appContext);
        }
        return invokeV.booleanValue;
    }

    @SuppressLint({"PrivateApi", "ObsoleteSdkInt"})
    public static boolean a(Context context) {
        InterceptResult invokeL;
        boolean z;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier(SapiSystemBarTintManager.SystemBarConfig.k, "bool", "android");
            boolean z2 = false;
            if (identifier > 0) {
                z = resources.getBoolean(identifier);
            } else {
                z = false;
            }
            try {
                if (Build.VERSION.SDK_INT < 21) {
                    i = Settings.System.getInt(context.getContentResolver(), "navigationbar_is_min", 0);
                } else {
                    i = Settings.Global.getInt(context.getContentResolver(), "navigationbar_is_min", 0);
                }
                if (i != 0) {
                    return false;
                }
                Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
                String str = (String) cls.getMethod("get", String.class).invoke(cls, "qemu.hw.mainkeys");
                if (!"1".equals(str)) {
                    if ("0".equals(str)) {
                        z2 = true;
                    } else {
                        z2 = z;
                    }
                }
                return z2;
            } catch (Exception unused) {
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    public static Pair<Integer, Integer> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            Pair<Integer, Integer> d = d();
            return new Pair<>(Integer.valueOf(((Integer) d.first).intValue()), Integer.valueOf(((Integer) d.second).intValue() - c()));
        }
        return (Pair) invokeV.objValue;
    }

    public static int c() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (!e()) {
                return 0;
            }
            Resources resources = AppRuntime.getAppContext().getResources();
            if (kl3.L()) {
                str = SapiSystemBarTintManager.SystemBarConfig.h;
            } else {
                str = SapiSystemBarTintManager.SystemBarConfig.i;
            }
            return kl3.r(resources, str);
        }
        return invokeV.intValue;
    }

    public static Pair<Integer, Integer> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            Context appContext = AppRuntime.getAppContext();
            WindowManager windowManager = (WindowManager) appContext.getSystemService("window");
            if (windowManager == null) {
                return new Pair<>(Integer.valueOf(kl3.o(appContext)), Integer.valueOf(kl3.n(appContext)));
            }
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            return new Pair<>(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
        }
        return (Pair) invokeV.objValue;
    }

    public static boolean f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            String str = Build.BRAND;
            try {
                if (TextUtils.isEmpty(str)) {
                    if (Settings.Global.getInt(context.getContentResolver(), "navigationbar_is_min", 0) == 0) {
                        return false;
                    }
                    return true;
                }
                if (!str.equalsIgnoreCase("HUAWEI") && !str.equalsIgnoreCase("HONOR")) {
                    if (str.equalsIgnoreCase(RomUtils.ROM_XIAOMI)) {
                        if (Settings.Global.getInt(context.getContentResolver(), "force_fsg_nav_bar", 0) == 0) {
                            return false;
                        }
                        return true;
                    } else if (str.equalsIgnoreCase("VIVO")) {
                        if (Settings.Secure.getInt(context.getContentResolver(), "navigation_gesture_on", 0) == 0) {
                            return false;
                        }
                        return true;
                    } else if (str.equalsIgnoreCase(a)) {
                        if (Settings.Secure.getInt(context.getContentResolver(), "navigation_gesture_on", 0) == 0) {
                            return false;
                        }
                        return true;
                    } else if (str.equalsIgnoreCase("SAMSUNG")) {
                        if (Settings.Global.getInt(context.getContentResolver(), "navigationbar_hide_bar_enabled", 0) == 0) {
                            return false;
                        }
                        return true;
                    } else if (Settings.Global.getInt(context.getContentResolver(), "navigation_gesture_on", 0) == 0) {
                        return false;
                    } else {
                        return true;
                    }
                }
                if (Settings.System.getInt(context.getContentResolver(), "navigationbar_is_min", 0) == 0) {
                    return false;
                }
                return true;
            } catch (Exception e) {
                if (do1.a) {
                    e.printStackTrace();
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
