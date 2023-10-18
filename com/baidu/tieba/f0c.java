package com.baidu.tieba;

import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.google.android.material.internal.ManufacturerUtils;
import com.yy.transvod.player.log.TLog;
/* loaded from: classes5.dex */
public class f0c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (h() && Build.MODEL.equals("MI 8")) {
                TLog.m("extraDelta", "from MI 8 extraDelta= 45");
                return 60;
            }
            if (c()) {
                String str = Build.MODEL;
                if (str.equals("SEA-AL10")) {
                    TLog.m("extraDelta", "from huawei nova 5 pro extraDelta= 100");
                    return 20;
                } else if (str.equals("ELE-AL00")) {
                    TLog.m("extraDelta", "from huawei p30 extraDelta= 80");
                    return 80;
                }
            }
            if (g()) {
                if (Build.MODEL.equals("vivo X21A")) {
                    TLog.m("extraDelta", "from vivo X21A extraDelta= 110");
                    return 100;
                }
                TLog.m("extraDelta", "from VIVO extraDelta= 150");
                return 150;
            } else if (e()) {
                String str2 = Build.MODEL;
                if (str2.equals("OPPO A37m")) {
                    TLog.m("extraDelta", "from OPPO A37m extraDelta= 150");
                    return 150;
                } else if (str2.equals("PBEM00")) {
                    TLog.m("extraDelta", "from oppo r17 extraDelta= 300");
                    return 300;
                } else {
                    TLog.m("extraDelta", "from oppo extraDelta= 100");
                    return 100;
                }
            } else if (b()) {
                TLog.m("extraDelta", "from EMUI extraDelta= 150");
                return 150;
            } else if (d()) {
                TLog.m("extraDelta", "from MIUI extraDelta= 150");
                return 150;
            } else if (f()) {
                TLog.m("extraDelta", "from SAMSUNG extraDelta= 50");
                return 50;
            } else {
                TLog.m("extraDelta", "from default extraDelta= 100");
                return 100;
            }
        }
        return invokeV.intValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if ("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (RomUtils.MANUFACTURER_HUAWEI.equalsIgnoreCase(Build.MANUFACTURER)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (RomUtils.MANUFACTURER_XIAOMI.equalsIgnoreCase(Build.MANUFACTURER)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if ("OPPO".equalsIgnoreCase(Build.MANUFACTURER)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (ManufacturerUtils.SAMSUNG.equalsIgnoreCase(Build.MANUFACTURER)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if ("vivo".equalsIgnoreCase(Build.MANUFACTURER)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (RomUtils.MANUFACTURER_XIAOMI.equalsIgnoreCase(Build.MANUFACTURER)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
