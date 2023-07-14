package com.baidu.tieba;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public final class ch2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic = null;
        public static int a = -1;
        public static int b = -1;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-890388769, "Lcom/baidu/tieba/ch2$a;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-890388769, "Lcom/baidu/tieba/ch2$a;");
            }
        }

        public static String a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
                return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("swan_sub_pkg_launch_switch", "debug_ab");
            }
            return (String) invokeV.objValue;
        }

        public static boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                if (b == -1) {
                    cv2.g0().getSwitch("swan_app_launch_optimize_v2", 0);
                    b = 0;
                }
                if (b != 1) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }

        public static boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                if (ch2.a) {
                    Log.d("AppLaunchMessenger", "isOnAppLaunchEnable getAppLaunchDebugSwitch : " + a());
                    String a2 = a();
                    char c = 65535;
                    int hashCode = a2.hashCode();
                    if (hashCode != 251117829) {
                        if (hashCode != 547804557) {
                            if (hashCode == 569516856 && a2.equals("debug_on_activity_create")) {
                                c = 1;
                            }
                        } else if (a2.equals("debug_ab")) {
                            c = 2;
                        }
                    } else if (a2.equals("debug_on_app_launch")) {
                        c = 0;
                    }
                    if (c == 0) {
                        return true;
                    }
                    if (c == 1) {
                        return false;
                    }
                }
                if (a < 0) {
                    cv2.g0().getSwitch("swan_sub_pkg_launch_switch", 0);
                    a = 0;
                }
                if (ch2.a) {
                    Log.d("AppLaunchMessenger", "isOnAppLaunchEnable sLaunchABSwitcher : " + a);
                }
                if (a != 1) {
                    return false;
                }
                return true;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947674684, "Lcom/baidu/tieba/ch2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947674684, "Lcom/baidu/tieba/ch2;");
                return;
            }
        }
        a = fs1.a;
    }

    public static void b(u83 u83Var, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, u83Var, bundle) == null) {
            if (a) {
                Log.d("AppLaunchMessenger", "sendAppLaunchEvent event start.");
            }
            Bundle bundle2 = new Bundle();
            bundle2.putBundle("swan_app_on_launch_event", bundle);
            n83 n83Var = new n83(122, bundle2);
            if (!u83Var.T() && a.c()) {
                u83Var.f0(n83Var.h());
            } else {
                l83 e = l83.e();
                n83Var.b(u83Var.b);
                n83Var.p(true);
                e.h(n83Var);
            }
            if (a) {
                Log.d("AppLaunchMessenger", "sendAppLaunchEvent event end.");
            }
        }
    }
}
