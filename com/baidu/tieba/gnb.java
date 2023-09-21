package com.baidu.tieba;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.JsonWriter;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.yalog.Logger;
import com.baidu.yalog.impl.mmap.YaNativeLogger;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public class gnb extends Logger {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static volatile int c;
    public static String[] d;
    public static Object e;
    public static ExecutorService f;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;
        public final /* synthetic */ long f;
        public final /* synthetic */ int[] g;
        public final /* synthetic */ gnb h;

        public a(gnb gnbVar, String str, int i, String str2, String str3, int i2, long j, int[] iArr) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gnbVar, str, Integer.valueOf(i), str2, str3, Integer.valueOf(i2), Long.valueOf(j), iArr};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = gnbVar;
            this.a = str;
            this.b = i;
            this.c = str2;
            this.d = str3;
            this.e = i2;
            this.f = j;
            this.g = iArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.h.y(this.a, this.b, this.c, this.d, this.e, this.f, this.g);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Callable<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ int e;
        public final /* synthetic */ long f;
        public final /* synthetic */ gnb g;

        public b(gnb gnbVar, String str, int i, String str2, String str3, int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gnbVar, str, Integer.valueOf(i), str2, str3, Integer.valueOf(i2), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.g = gnbVar;
            this.a = str;
            this.b = i;
            this.c = str2;
            this.d = str3;
            this.e = i2;
            this.f = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.concurrent.Callable
        public Void call() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
                return (Void) invokeV.objValue;
            }
            this.g.y(this.a, this.b, this.c, this.d, this.e, this.f, 0);
            return null;
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gnb a;

        public c(gnb gnbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gnbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gnbVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.x(false);
        }
    }

    /* loaded from: classes6.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(gnb gnbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gnbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                gnb.C();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
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

        @Override // java.lang.Runnable
        public void run() {
            long min;
            long min2;
            long min3;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            synchronized (gnb.e) {
                String g = gnb.g();
                boolean z = gnb.z(g);
                anb c = anb.c();
                if (!c.m()) {
                    if (z && c.l()) {
                        gnb.r();
                    }
                    int unused = gnb.c = 2;
                    return;
                }
                YaNativeLogger.a();
                YaNativeLogger.setBaseDir(gnb.m());
                YaNativeLogger.setProcessName(gnb.t(g));
                if (z) {
                    YaNativeLogger.setMainController(true);
                } else {
                    YaNativeLogger.setMainController(false);
                }
                long h = c.h() * 1024 * 1024;
                if (h <= 0) {
                    min = 104857600;
                } else {
                    min = Math.min(h, 1073741824L);
                }
                YaNativeLogger.setMaxSizeAllLogFile(min);
                long d = c.d() * 1024 * 1024;
                if (d <= 0) {
                    min2 = 1048576;
                } else {
                    min2 = Math.min(d, min);
                }
                YaNativeLogger.setMaxSizePerLogFile(min2);
                YaNativeLogger.setDefaultSpaceEnable(true);
                YaNativeLogger.setDefaultLogIdEnable(true);
                long f = c.f() * 1024 * 1024;
                if (f <= 0) {
                    f = 20971520;
                }
                YaNativeLogger.setDefaultSpaceMaxSize(f);
                List<dnb> e = c.e();
                if (e != null && e.size() > 0) {
                    for (dnb dnbVar : e) {
                        if (dnbVar != null && !TextUtils.isEmpty(dnbVar.b())) {
                            String b = dnbVar.b();
                            YaNativeLogger.setSpaceEnable(b, dnbVar.c());
                            long a = dnbVar.a() * 1024 * 1024;
                            if (a <= 0) {
                                a = 20971520;
                            }
                            YaNativeLogger.setSpaceMaxSize(b, a);
                            long d2 = dnbVar.d() * 60 * 60 * 24;
                            if (d2 <= 0) {
                                d2 = 604800;
                            }
                            YaNativeLogger.setMaxAliveTimeForSpace(b, d2);
                        }
                    }
                }
                long b2 = c.b() * 1024 * 1024;
                if (b2 <= 0) {
                    b2 = 20971520;
                }
                YaNativeLogger.setDefaultLogIdMaxSize(b2);
                Map<String, cnb> a2 = c.a();
                if (a2 != null && a2.size() > 0) {
                    for (String str : a2.keySet()) {
                        if (!TextUtils.isEmpty(str) && a2.get(str) != null) {
                            cnb cnbVar = a2.get(str);
                            YaNativeLogger.setLogIdEnable(str, cnbVar.b());
                            long a3 = cnbVar.a() * 1024 * 1024;
                            if (a3 <= 0) {
                                a3 = 20971520;
                            }
                            YaNativeLogger.setLogIdMaxSize(str, a3);
                        }
                    }
                }
                long g2 = c.g() * 24 * 60 * 60;
                if (g2 <= 0) {
                    min3 = 604800;
                } else {
                    min3 = Math.min(g2, 2592000L);
                }
                YaNativeLogger.setDefaultMaxAliveTimeForSpace(min3);
                YaNativeLogger.start();
                int unused2 = gnb.c = 1;
                if (gnb.b) {
                    Log.v("MmapLogger", "Yalog init finish");
                }
                gnb.e.notifyAll();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947801102, "Lcom/baidu/tieba/gnb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947801102, "Lcom/baidu/tieba/gnb;");
                return;
            }
        }
        b = AppConfig.isDebug();
        c = 0;
        d = new String[]{"L0", "L1", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "D", "I", ExifInterface.LONGITUDE_WEST, ExifInterface.LONGITUDE_EAST, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS};
        e = new Object();
        f = Executors.newSingleThreadExecutor();
    }

    public static String u() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            Context appContext = AppRuntime.getAppContext();
            Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) appContext.getSystemService("activity")).getRunningAppProcesses().iterator();
            while (true) {
                if (it.hasNext()) {
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == Process.myPid()) {
                        str = next.processName;
                        break;
                    }
                } else {
                    str = null;
                    break;
                }
            }
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            return appContext.getPackageName();
        }
        return (String) invokeV.objValue;
    }

    public gnb(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = str;
        D();
        E();
    }

    public static void s(File file) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65555, null, file) == null) && file != null && file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        s(file2);
                    } else {
                        file2.delete();
                    }
                }
            }
            file.delete();
        }
    }

    public static List<String> B(long j, long j2, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, str2})) == null) {
            ArrayList arrayList = new ArrayList();
            if (!F()) {
                return arrayList;
            }
            try {
                YaNativeLogger.queryLogFiles(j, j2, str, str2, arrayList);
            } catch (Throwable th) {
                if (b) {
                    th.printStackTrace();
                }
            }
            return arrayList;
        }
        return (List) invokeCommon.objValue;
    }

    public static void C() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65539, null) != null) || !F()) {
            return;
        }
        try {
            YaNativeLogger.requestCleanOverQuotaLog();
        } catch (Throwable th) {
            if (b) {
                th.printStackTrace();
            }
        }
    }

    public static void D() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) != null) || c != 0) {
            return;
        }
        inb.a(new e());
    }

    public static boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (c == 0) {
                synchronized (e) {
                    while (c == 0) {
                        try {
                            e.wait();
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
            if (c == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static /* synthetic */ String g() {
        return u();
    }

    public static /* synthetic */ String m() {
        return p();
    }

    public static String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            return new File(AppRuntime.getAppContext().getApplicationInfo().dataDir, ".yalog").getAbsolutePath();
        }
        return (String) invokeV.objValue;
    }

    public static void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, null) == null) {
            s(new File(p()));
        }
    }

    public /* synthetic */ void A() {
        if (c == 3) {
            c = 0;
            D();
            E();
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            new Handler(Looper.getMainLooper()).postDelayed(new d(this), 30000L);
        }
    }

    @Override // com.baidu.yalog.Logger
    public void reinitialize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            inb.a(new Runnable() { // from class: com.baidu.tieba.enb
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        gnb.this.A();
                    }
                }
            });
        }
    }

    @Override // com.baidu.yalog.Logger
    public void executeRunnable(@NonNull Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, runnable) == null) {
            f.execute(runnable);
        }
    }

    @Override // com.baidu.yalog.Logger
    public void flush(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            if (z) {
                x(true);
            } else {
                f.execute(new c(this));
            }
        }
    }

    public final void x(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) != null) || !F()) {
            return;
        }
        try {
            YaNativeLogger.flush(this.a, z);
        } catch (Throwable th) {
            if (b) {
                th.printStackTrace();
            }
        }
    }

    public static List<String> q(long j, long j2, String str, String str2, boolean z, boolean z2, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65553, null, new Object[]{Long.valueOf(j), Long.valueOf(j2), str, str2, Boolean.valueOf(z), Boolean.valueOf(z2), str3})) == null) {
            ArrayList arrayList = new ArrayList();
            if (!F()) {
                return arrayList;
            }
            try {
                YaNativeLogger.createLogSnapShot(j, j2, str, str2, z, z2, str3, arrayList);
            } catch (Throwable th) {
                if (b) {
                    th.printStackTrace();
                }
            }
            return arrayList;
        }
        return (List) invokeCommon.objValue;
    }

    public static String t(String str) {
        InterceptResult invokeL;
        String replaceAll;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "unknown";
            }
            if (z(str)) {
                return "main";
            }
            Context appContext = AppRuntime.getAppContext();
            String str2 = appContext.getApplicationInfo().packageName;
            if (TextUtils.isEmpty(str2)) {
                str2 = appContext.getPackageName();
            }
            String str3 = str2 + ":";
            if (str.startsWith(str3)) {
                String substring = str.substring(str3.length());
                if (TextUtils.equals("main", substring)) {
                    return "_main";
                }
                if (!TextUtils.isEmpty(substring)) {
                    replaceAll = substring.replaceAll("[:/]", "_");
                } else {
                    replaceAll = "";
                }
            } else {
                replaceAll = str.replaceAll("[:/]", "_");
            }
            if (TextUtils.isEmpty(replaceAll)) {
                return "unknown";
            }
            return replaceAll;
        }
        return (String) invokeL.objValue;
    }

    public static boolean z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, str)) == null) {
            if (str == null) {
                return true;
            }
            Context appContext = AppRuntime.getAppContext();
            String str2 = appContext.getApplicationInfo().processName;
            if (TextUtils.isEmpty(str2)) {
                str2 = appContext.getPackageName();
            }
            if (str.startsWith(str2)) {
                if (str.length() == str2.length() || str.charAt(str2.length()) != ':') {
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.yalog.Logger
    public void log(String str, int i, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048580, this, str, i, str2, str3) == null) {
            log(str, i, str2, str3, 0);
        }
    }

    @Override // com.baidu.yalog.Logger
    public void log(String str, int i, String str2, String str3, int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Integer.valueOf(i), str2, str3, iArr}) == null) {
            f.execute(new a(this, str, i, str2, str3, Process.myTid(), System.currentTimeMillis(), iArr));
        }
    }

    @Override // com.baidu.yalog.Logger
    public void logSync(String str, int i, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(1048582, this, str, i, str2, str3) == null) {
            try {
                f.submit(new b(this, str, i, str2, str3, Process.myTid(), System.currentTimeMillis())).get();
            } catch (Exception e2) {
                if (b) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final void y(String str, int i, String str2, String str3, int i2, long j, int... iArr) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048585, this, new Object[]{str, Integer.valueOf(i), str2, str3, Integer.valueOf(i2), Long.valueOf(j), iArr}) != null) || !F()) {
            return;
        }
        int myPid = Process.myPid();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        int i3 = 0;
        for (int i4 : iArr) {
            i3 |= i4;
        }
        try {
            jsonWriter.beginObject();
            if ((i3 & 17) != 17) {
                jsonWriter.name("pid").value(myPid);
            }
            if ((i3 & 18) != 18) {
                jsonWriter.name("tid").value(i2);
            }
            jsonWriter.name("time").value(simpleDateFormat.format(Long.valueOf(j)));
            if (!TextUtils.isEmpty(str)) {
                jsonWriter.name("logid").value(str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jsonWriter.name("tag").value(str2);
            }
            if (i >= 0 && i < d.length) {
                jsonWriter.name("level").value(d[i]);
            } else if (i != -1) {
                jsonWriter.name("level").value("L" + i);
            }
            jsonWriter.endObject();
        } catch (IOException unused) {
        }
        YaNativeLogger.b(this.a, "main", str, stringWriter.toString(), str3);
    }
}
