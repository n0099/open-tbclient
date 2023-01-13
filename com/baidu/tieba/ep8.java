package com.baidu.tieba;

import android.app.ActivityManager;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class ep8 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947742140, "Lcom/baidu/tieba/ep8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947742140, "Lcom/baidu/tieba/ep8;");
        }
    }

    public static void a(ClogBuilder clogBuilder, int i) {
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, null, clogBuilder, i) == null) {
            clogBuilder.y(ClogBuilder.LogType.DEEP_LINK);
            if (i == 1000) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                str = "APP";
            } else {
                str = "URL";
            }
            clogBuilder.j(str);
            if (!z) {
                clogBuilder.l(String.valueOf(i));
            }
            clogBuilder.v("DEEPLINK");
        }
    }

    public static String b(HashMap hashMap) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, hashMap)) == null) {
            if (hashMap != null) {
                str = String.valueOf(hashMap.get("da_area"));
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                return "hotarea";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static void l(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, advertAppInfo) == null) {
            m(advertAppInfo, 0, "");
        }
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            try {
                int myPid = Process.myPid();
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) TbadkCoreApplication.getInst().getContext().getSystemService("activity")).getRunningAppProcesses()) {
                    if (runningAppProcessInfo.pid == myPid) {
                        return runningAppProcessInfo.processName;
                    }
                }
                return "GET_PROCESS_NAME_FAIL";
            } catch (Exception unused) {
                return "GET_PROCESS_NAME_FAIL";
            }
        }
        return (String) invokeV.objValue;
    }

    public static void d(String str, @NonNull String str2, int i, int i2, String str3, String str4, String str5, String str6, String str7, String str8) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3, str4, str5, str6, str7, str8}) == null) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.z(String.valueOf(i2)).q(String.valueOf(i)).v(str).j(str3).k(str4).l(str5).m(str6).n(str7).o(str8).p(str2);
            e11.b(clogBuilder);
        }
    }

    public static void e(AdvertAppInfo advertAppInfo, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65541, null, advertAppInfo, i) == null) {
            f(advertAppInfo, 0, "", i);
        }
    }

    public static void j(hx8 hx8Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65546, null, hx8Var, i) == null) {
            k(hx8Var, i, -999, -999);
        }
    }

    public static void f(AdvertAppInfo advertAppInfo, int i, String str, int i2) {
        int i3;
        hi0 hi0Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65542, null, new Object[]{advertAppInfo, Integer.valueOf(i), str, Integer.valueOf(i2)}) != null) || advertAppInfo == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "hotarea";
        }
        boolean equals = "PB_BANNER".equals(advertAppInfo.j);
        ClogBuilder clogBuilder = new ClogBuilder();
        ClogBuilder y = clogBuilder.y(ClogBuilder.LogType.CLICK);
        if (equals) {
            i3 = -1;
        } else {
            i3 = advertAppInfo.position + 1;
        }
        ClogBuilder q = y.q(String.valueOf(i3));
        if (equals) {
            i = -1;
        }
        q.w(String.valueOf(i)).v(advertAppInfo.j).j(str).p(advertAppInfo.g);
        if (advertAppInfo != null && (hi0Var = advertAppInfo.r) != null) {
            clogBuilder.m(hi0Var.a());
        }
        e11.b(clogBuilder);
        a(clogBuilder, i2);
        e11.b(clogBuilder);
    }

    public static void g(AdvertAppInfo advertAppInfo, int i, HashMap hashMap, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{advertAppInfo, Integer.valueOf(i), hashMap, Integer.valueOf(i2)}) == null) {
            f(advertAppInfo, i, b(hashMap), i2);
        }
    }

    public static void h(AdvertAppInfo advertAppInfo, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65544, null, advertAppInfo, i, i2) == null) {
            i(advertAppInfo, i, i2, -999, -999);
        }
    }

    public static void i(AdvertAppInfo advertAppInfo, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{advertAppInfo, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) && advertAppInfo != null && (i5 = advertAppInfo.c) != 1001 && i5 != -1001) {
            boolean equals = "PB_BANNER".equals(advertAppInfo.j);
            ClogBuilder clogBuilder = new ClogBuilder();
            ClogBuilder k = clogBuilder.y(ClogBuilder.LogType.DISCARD).k(String.valueOf(i2));
            if (equals) {
                i6 = -1;
            } else {
                i6 = advertAppInfo.position + 1;
            }
            ClogBuilder q = k.q(String.valueOf(i6));
            if (equals) {
                i = -1;
            }
            q.w(String.valueOf(i)).v(advertAppInfo.j).p(advertAppInfo.g);
            if (i3 != -999) {
                clogBuilder.l(String.valueOf(i3));
            }
            if (i4 != -999) {
                clogBuilder.m(String.valueOf(i4));
            }
            if (i2 == 31) {
                if (TextUtils.isEmpty(a)) {
                    a = c();
                }
                clogBuilder.o(a);
            }
            e11.b(clogBuilder);
        }
    }

    public static void k(hx8 hx8Var, int i, int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLIII(65547, null, hx8Var, i, i2, i3) == null) && hx8Var != null && hx8Var.getAdvertAppInfo() != null && hx8Var.getAdvertAppInfo().c != 1001 && hx8Var.getAdvertAppInfo().c != -1001) {
            AdvertAppInfo advertAppInfo = hx8Var.getAdvertAppInfo();
            ClogBuilder clogBuilder = new ClogBuilder();
            ClogBuilder k = clogBuilder.y(ClogBuilder.LogType.DISCARD).k(String.valueOf(i));
            int i5 = -1;
            if (hx8Var.Z0) {
                i4 = -1;
            } else {
                i4 = hx8Var.g1 + 1;
            }
            ClogBuilder q = k.q(String.valueOf(i4));
            if (!hx8Var.Z0) {
                i5 = hx8Var.e1;
            }
            q.w(String.valueOf(i5)).v(hx8Var.r1()).r(hx8Var.b1).s(hx8Var.c1).t(hx8Var.a1).p(advertAppInfo.g);
            if (i2 != -999) {
                clogBuilder.l(String.valueOf(i2));
            }
            if (i3 != -999) {
                clogBuilder.m(String.valueOf(i3));
            }
            e11.b(clogBuilder);
        }
    }

    public static void m(AdvertAppInfo advertAppInfo, int i, String str) {
        int i2;
        hi0 hi0Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLIL(65549, null, advertAppInfo, i, str) != null) || advertAppInfo == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "hotarea";
        }
        boolean equals = "PB_BANNER".equals(advertAppInfo.j);
        ClogBuilder clogBuilder = new ClogBuilder();
        ClogBuilder y = clogBuilder.y(ClogBuilder.LogType.CLICK);
        if (equals) {
            i2 = -1;
        } else {
            i2 = advertAppInfo.position + 1;
        }
        ClogBuilder q = y.q(String.valueOf(i2));
        if (equals) {
            i = -1;
        }
        q.w(String.valueOf(i)).v(advertAppInfo.j).j(str).p(advertAppInfo.g);
        if (advertAppInfo != null && (hi0Var = advertAppInfo.r) != null) {
            clogBuilder.m(hi0Var.a());
        }
        e11.b(clogBuilder);
    }

    public static void n(AdvertAppInfo advertAppInfo, int i, String str, String str2, HashMap hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{advertAppInfo, Integer.valueOf(i), str, str2, hashMap}) == null) {
            m(advertAppInfo, i, b(hashMap));
        }
    }

    public static void o(AdvertAppInfo advertAppInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65551, null, advertAppInfo) != null) || advertAppInfo == null) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(ClogBuilder.LogType.SHOW).q(String.valueOf(advertAppInfo.position + 1)).w(String.valueOf(-1)).v(advertAppInfo.j).p(advertAppInfo.g);
        e11.b(clogBuilder);
    }
}
