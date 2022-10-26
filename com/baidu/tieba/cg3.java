package com.baidu.tieba;

import android.app.ActivityManager;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.tieba.fd3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class cg3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile String a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public final class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ long b;
        public final /* synthetic */ fi3 c;

        public a(int i, long j, fi3 fi3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Long.valueOf(j), fi3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i;
            this.b = j;
            this.c = fi3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    cg3.f(jSONObject, zu2.c(), this.a, this.b);
                } catch (Exception e) {
                    mg3.f(jSONObject, "errorMsg", e.getMessage());
                }
                this.c.a(jSONObject);
            }
        }
    }

    public cg3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (TextUtils.isEmpty(a)) {
                synchronized (cg3.class) {
                    a = e();
                }
            }
            return a;
        }
        return (String) invokeV.objValue;
    }

    public static String b(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65538, null, j)) == null) {
            return new DecimalFormat("#.##").format(j / 1.073741824E9d);
        }
        return (String) invokeJ.objValue;
    }

    public static void d(jo2 jo2Var, fi3 fi3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jo2Var, fi3Var) == null) {
            ExecutorUtilsExt.postOnElastic(new a(jo2Var.i("host_launch_type"), jo2Var.k("box_cold_launch"), fi3Var), "getDeviceInfoAsync", 2);
        }
    }

    public static String e() {
        InterceptResult invokeV;
        String replace;
        String replace2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            String str = Build.MODEL;
            String str2 = "NUL";
            if (TextUtils.isEmpty(str)) {
                replace = "NUL";
            } else {
                replace = str.replace("_", "-");
            }
            String str3 = Build.VERSION.RELEASE;
            if (TextUtils.isEmpty(str3)) {
                replace2 = "0.0";
            } else {
                replace2 = str3.replace("_", "-");
            }
            int i = Build.VERSION.SDK_INT;
            String str4 = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str4)) {
                str2 = str4.replace("_", "-");
            }
            return replace + "_" + replace2 + "_" + i + "_" + str2;
        }
        return (String) invokeV.objValue;
    }

    public static void f(JSONObject jSONObject, int i, int i2, long j) {
        int i3;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{jSONObject, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            mg3.f(jSONObject, "model", Build.MODEL);
            mg3.f(jSONObject, "systemVersion", Build.VERSION.RELEASE);
            mg3.f(jSONObject, "netStatus", Integer.valueOf(i));
            fd3.a a2 = fd3.a(tm2.c());
            if (a2 == null) {
                i3 = -1;
            } else {
                i3 = a2.a;
            }
            mg3.f(jSONObject, "batteryLevel", Integer.valueOf(i3));
            mg3.f(jSONObject, "appCurVersion", gh3.D());
            mg3.f(jSONObject, "startupType", String.valueOf(i2));
            mg3.f(jSONObject, "coldLaunchTime", Long.valueOf(j));
            StatFs statFs = new StatFs(im2.i());
            mg3.f(jSONObject, "totalDiskSpace", b(statFs.getTotalBytes()));
            mg3.f(jSONObject, "freeDiskSpace", b(statFs.getAvailableBytes()));
            ActivityManager activityManager = (ActivityManager) l33.K().getSystemService("activity");
            if (activityManager != null) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                mg3.f(jSONObject, "totalMemory", b(memoryInfo.totalMem));
                mg3.f(jSONObject, "freeMemory", b(memoryInfo.availMem));
                if (memoryInfo.lowMemory) {
                    str = "1";
                } else {
                    str = "0";
                }
                mg3.f(jSONObject, "lowMemory", str);
            }
        }
    }
}
