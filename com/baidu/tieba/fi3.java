package com.baidu.tieba;

import android.app.ActivityManager;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.tieba.if3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.DecimalFormat;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class fi3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile String a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ long b;
        public final /* synthetic */ ik3 c;

        public a(int i, long j, ik3 ik3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Long.valueOf(j), ik3Var};
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
            this.c = ik3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    fi3.f(jSONObject, cx2.c(), this.a, this.b);
                } catch (Exception e) {
                    pi3.f(jSONObject, "errorMsg", e.getMessage());
                }
                this.c.a(jSONObject);
            }
        }
    }

    public fi3() {
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
                synchronized (fi3.class) {
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

    public static void d(@NonNull mq2 mq2Var, @NonNull ik3<JSONObject> ik3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, mq2Var, ik3Var) == null) {
            ExecutorUtilsExt.postOnElastic(new a(mq2Var.h("host_launch_type"), mq2Var.k("box_cold_launch"), ik3Var), "getDeviceInfoAsync", 2);
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
                replace2 = com.baidu.mobads.sdk.internal.cj.d;
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

    public static void f(@NonNull JSONObject jSONObject, int i, int i2, long j) {
        int i3;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{jSONObject, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)}) == null) {
            pi3.f(jSONObject, "model", Build.MODEL);
            pi3.f(jSONObject, "systemVersion", Build.VERSION.RELEASE);
            pi3.f(jSONObject, "netStatus", Integer.valueOf(i));
            if3.a a2 = if3.a(wo2.c());
            if (a2 == null) {
                i3 = -1;
            } else {
                i3 = a2.a;
            }
            pi3.f(jSONObject, "batteryLevel", Integer.valueOf(i3));
            pi3.f(jSONObject, "appCurVersion", jj3.D());
            pi3.f(jSONObject, "startupType", String.valueOf(i2));
            pi3.f(jSONObject, "coldLaunchTime", Long.valueOf(j));
            StatFs statFs = new StatFs(lo2.i());
            pi3.f(jSONObject, "totalDiskSpace", b(statFs.getTotalBytes()));
            pi3.f(jSONObject, "freeDiskSpace", b(statFs.getAvailableBytes()));
            ActivityManager activityManager = (ActivityManager) o53.K().getSystemService("activity");
            if (activityManager != null) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                pi3.f(jSONObject, "totalMemory", b(memoryInfo.totalMem));
                pi3.f(jSONObject, "freeMemory", b(memoryInfo.availMem));
                if (memoryInfo.lowMemory) {
                    str = "1";
                } else {
                    str = "0";
                }
                pi3.f(jSONObject, "lowMemory", str);
            }
        }
    }
}
