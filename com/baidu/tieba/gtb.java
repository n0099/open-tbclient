package com.baidu.tieba;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.pass.biometrics.base.utils.PassBiometricUtil;
import com.baidu.searchbox.aideviceperformance.utils.HardwareInfoUtils;
import com.baidu.searchbox.download.util.MigrateStatisticUtils;
import com.baidu.tieba.btb;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.yy.hiidostatis.inner.BaseStatisContent;
import com.yy.sdk.crashreportbaidu.ActivityHistory;
import com.yy.sdk.crashreportbaidu.CrashInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class gtb {
    public static /* synthetic */ Interceptable $ic;
    public static Context a;
    public static String b;
    public static String c;
    public static String d;
    public static String e;
    public static String f;
    public static String g;
    public static String h;
    public static String i;
    public static Map<String, String> j;
    public static btb.g k;
    public static String l;
    public static int m;
    public static String n;
    public static String o;
    public static boolean p;
    public transient /* synthetic */ FieldHolder $fh;

    public static void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65553, null, z) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947806868, "Lcom/baidu/tieba/gtb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947806868, "Lcom/baidu/tieba/gtb;");
                return;
            }
        }
        j = new HashMap();
        l = null;
        m = 0;
        o = BaseStatisContent.GUID;
        p = false;
    }

    public static String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            try {
                return String.format("%s %s", Build.MANUFACTURER, Build.MODEL);
            } catch (Exception unused) {
                atb.d("CrashUtils", "get phone model info failed!");
                return "unknown";
            }
        }
        return (String) invokeV.objValue;
    }

    public static long F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            try {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                return (statFs.getBlockCount() * statFs.getBlockSize()) / 1024;
            } catch (Throwable unused) {
                atb.d("CrashUtils", "get tatal internal storge size");
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    public static long G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                try {
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    ((ActivityManager) a.getSystemService("activity")).getMemoryInfo(memoryInfo);
                    return memoryInfo.totalMem / 1024;
                } catch (Throwable unused) {
                    atb.d("CrashUtils", "get total memory failed");
                    return 0L;
                }
            }
            return H();
        }
        return invokeV.longValue;
    }

    public static String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
            String str = c;
            if (str == null) {
                try {
                    return a.getPackageManager().getPackageInfo(a.getPackageName(), 0).versionName;
                } catch (Throwable th) {
                    Log.i("CrashUtils", C(th));
                    return "unknown";
                }
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65571, null)) == null) {
            try {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                ((ActivityManager) a.getSystemService("activity")).getMemoryInfo(memoryInfo);
                return memoryInfo.availMem / 1024;
            } catch (Throwable unused) {
                atb.d("CrashUtils", "get avail memory failed!");
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    public static long l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65573, null)) == null) {
            try {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                return (statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1024;
            } catch (Throwable unused) {
                atb.d("CrashUtils", "get available internal storge size failed");
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public static String w() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65584, null)) == null) {
            if (Build.VERSION.SDK_INT >= 14) {
                i2 = ActivityHistory.INSTANCE.getLastTrimLevel();
            } else {
                try {
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    ((ActivityManager) a.getSystemService("activity")).getMemoryInfo(memoryInfo);
                    i2 = memoryInfo.lowMemory;
                } catch (Exception unused) {
                    atb.d("CrashUtils", "get low memory failed");
                    i2 = -1;
                }
            }
            return String.valueOf(i2);
        }
        return (String) invokeV.objValue;
    }

    public static String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return a.getPackageName();
        }
        return (String) invokeV.objValue;
    }

    public static boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return p;
        }
        return invokeV.booleanValue;
    }

    public static void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, null) == null) {
            f = D(System.currentTimeMillis());
        }
    }

    public static String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) {
            return b;
        }
        return (String) invokeV.objValue;
    }

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
            return e;
        }
        return (String) invokeV.objValue;
    }

    public static String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) {
            return d;
        }
        return (String) invokeV.objValue;
    }

    public static String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65575, null)) == null) {
            return l;
        }
        return (String) invokeV.objValue;
    }

    public static String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65576, null)) == null) {
            return f;
        }
        return (String) invokeV.objValue;
    }

    public static String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65577, null)) == null) {
            return String.valueOf(Process.myPid());
        }
        return (String) invokeV.objValue;
    }

    public static String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65578, null)) == null) {
            String str = i;
            if (str != null) {
                return str;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65579, null)) == null) {
            if (m == 0) {
                m = Process.myPid();
            }
            return String.valueOf(m);
        }
        return (String) invokeV.objValue;
    }

    public static String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65587, null)) == null) {
            try {
                return String.format("Android %s", Build.VERSION.RELEASE);
            } catch (Exception e2) {
                atb.d("CrashUtils", C(e2));
                return "unknown";
            }
        }
        return (String) invokeV.objValue;
    }

    public static String C(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, th)) == null) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            if (th != null) {
                th.printStackTrace(printWriter);
            }
            String obj = stringWriter.toString();
            printWriter.close();
            return obj.trim();
        }
        return (String) invokeL.objValue;
    }

    public static String D(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, null, j2)) == null) {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j2));
        }
        return (String) invokeJ.objValue;
    }

    public static void R(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65554, null, i2) == null) {
            m = i2;
        }
    }

    public static void T(Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, th) == null) {
            i = C(th);
        }
    }

    public static void U(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65557, null, z) == null) {
            p = z;
        }
    }

    public static void V(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, map) == null) {
            try {
                j.clear();
                j.putAll(map);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void W(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, null, str) == null) {
            o = str;
        }
    }

    public static void a(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65562, null, map) == null) {
            try {
                j.putAll(map);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static String m(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65574, null, j2)) == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
            return simpleDateFormat.format(new Date(j2));
        }
        return (String) invokeJ.objValue;
    }

    public static String x(CrashInfo crashInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65585, null, crashInfo)) == null) {
            return y(crashInfo.crashId, crashInfo.crashType, m(System.currentTimeMillis()), o(), q(), 0);
        }
        return (String) invokeL.objValue;
    }

    public static long E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            try {
                if (!Environment.getExternalStorageState().equals("mounted")) {
                    return 0L;
                }
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return (statFs.getBlockCount() * statFs.getBlockSize()) / 1024;
            } catch (Throwable unused) {
                atb.d("CrashUtils", "get total external storge size failed!");
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    public static String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) {
            String str = h;
            if (str == null) {
                try {
                    PackageInfo packageInfo = a.getPackageManager().getPackageInfo(a.getPackageName(), 64);
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(packageInfo.signatures[0].toByteArray());
                    return Y(messageDigest.digest());
                } catch (Throwable th) {
                    atb.d("CrashUtils", C(th));
                    return "unknown";
                }
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65572, null)) == null) {
            try {
                if (!Environment.getExternalStorageState().equals("mounted")) {
                    return 0L;
                }
                StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
                return (statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1024;
            } catch (Throwable unused) {
                atb.d("CrashUtils", "get available external storge size failed!");
                return 0L;
            }
        }
        return invokeV.longValue;
    }

    public static String s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65580, null)) == null) {
            String str = g;
            if (str != null) {
                return str;
            }
            File file = new File(ktb.b().a(a), "crash");
            if (!file.exists()) {
                file.mkdirs();
            }
            g = file.getAbsolutePath();
            dtb.d("CrashUtils", "getDumpDirectory: " + g);
            return g;
        }
        return (String) invokeV.objValue;
    }

    public static String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65583, null)) == null) {
            if (TextUtils.isEmpty(o) || o.equals("default")) {
                SharedPreferences sharedPreferences = a.getSharedPreferences("CrashUtils_preferences", 0);
                String string = sharedPreferences.getString("uuid", "default");
                if (TextUtils.isEmpty(string) || string.equals("default")) {
                    if (TextUtils.isEmpty(string)) {
                        string = UUID.randomUUID().toString();
                    }
                    string = X(string);
                    sharedPreferences.edit().putString("uuid", string).apply();
                }
                o = string;
            }
            return o;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long H() {
        InterceptResult invokeV;
        RandomAccessFile randomAccessFile;
        Exception e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            RandomAccessFile randomAccessFile2 = null;
            try {
                randomAccessFile = new RandomAccessFile(HardwareInfoUtils.MEM_INFO_FILE, "r");
                try {
                    try {
                        Matcher matcher = Pattern.compile("(\\d+)").matcher(randomAccessFile.readLine());
                        String str = "";
                        while (matcher.find()) {
                            str = matcher.group(1);
                        }
                        randomAccessFile.close();
                        long parseLong = Long.parseLong(str);
                        try {
                            randomAccessFile.close();
                            return parseLong;
                        } catch (Exception unused) {
                            atb.d("CrashUtils", "close file failed");
                            return parseLong;
                        }
                    } catch (Exception e3) {
                        e2 = e3;
                        atb.d("CrashUtils", "get mem from file failed");
                        dtb.c("CrashUtils", "get mem from file failed", e2);
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Exception unused2) {
                                atb.d("CrashUtils", "close file failed");
                            }
                        }
                        return 0L;
                    }
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile2 = randomAccessFile;
                    if (randomAccessFile2 != null) {
                        try {
                            randomAccessFile2.close();
                        } catch (Exception unused3) {
                            atb.d("CrashUtils", "close file failed");
                        }
                    }
                    throw th;
                }
            } catch (Exception e4) {
                randomAccessFile = null;
                e2 = e4;
            } catch (Throwable th2) {
                th = th2;
                if (randomAccessFile2 != null) {
                }
                throw th;
            }
        } else {
            return invokeV.longValue;
        }
    }

    public static void I(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, context, str, str2) == null) {
            a = context;
            d = str2;
            b = str;
            e = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
            l = UUID.randomUUID().toString();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:3|(2:5|(4:7|(1:73)|11|(4:15|(2:17|(1:19))|20|(3:27|28|(2:30|31)(5:32|33|35|36|(4:50|51|52|53)(4:42|43|44|45)))(2:24|25))))|74|(0)|20|(1:22)|27|28|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x015b, code lost:
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x015c, code lost:
        r12.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x015c -> B:78:0x015f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean K(Context context, String str, ClassLoader classLoader) {
        InterceptResult invokeLLL;
        String str2;
        File file;
        ZipFile zipFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65547, null, context, str, classLoader)) == null) {
            File file2 = new File(context.getApplicationInfo().nativeLibraryDir);
            ZipFile zipFile2 = null;
            if (PassBiometricUtil.CPU_TYPE_ARMEABI_V7A.equals(Build.CPU_ABI)) {
                File file3 = new File(file2, "lib" + str + "-v7a.so");
                if (file3.exists()) {
                    File file4 = new File(context.getDir("lib_v7a", 0), "lib" + str + ".so");
                    if (!file4.exists() || file3.length() != file4.length()) {
                        c(file3, file4);
                    }
                    if (file4.exists() && file4.length() == file3.length()) {
                        str2 = file4.getAbsolutePath();
                        if (str2 == null) {
                            File file5 = new File(file2, "lib" + str + ".so");
                            if (file5.exists()) {
                                str2 = file5.getAbsolutePath();
                            }
                        }
                        if (str2 == null && L(str2, classLoader)) {
                            dtb.d("CrashUtils", str2 + " loaded");
                            return true;
                        } else if (!N(str, classLoader)) {
                            dtb.d("CrashUtils", str + " loaded");
                            return true;
                        } else {
                            try {
                                file = new File(context.getDir("lib_ext", 0), "lib" + str + ".so");
                                zipFile = new ZipFile(new File(context.getApplicationInfo().sourceDir));
                            } catch (Throwable th) {
                                th = th;
                            }
                            try {
                            } catch (Throwable th2) {
                                th = th2;
                                zipFile2 = zipFile;
                                try {
                                    th.printStackTrace();
                                    if (zipFile2 != null) {
                                        zipFile2.close();
                                    }
                                    dtb.b("CrashUtils", str + " load failed");
                                    return false;
                                } catch (Throwable th3) {
                                    if (zipFile2 != null) {
                                        try {
                                            zipFile2.close();
                                        } catch (Throwable th4) {
                                            th4.printStackTrace();
                                        }
                                    }
                                    throw th3;
                                }
                            }
                            if (d(zipFile, str, file) && file.length() > 0 && L(file.getAbsolutePath(), classLoader)) {
                                dtb.d("CrashUtils", file.getAbsolutePath() + " loaded");
                                try {
                                    zipFile.close();
                                } catch (Throwable th5) {
                                    th5.printStackTrace();
                                }
                                return true;
                            }
                            zipFile.close();
                            dtb.b("CrashUtils", str + " load failed");
                            return false;
                        }
                    }
                }
            }
            str2 = null;
            if (str2 == null) {
            }
            if (str2 == null) {
            }
            if (!N(str, classLoader)) {
            }
        } else {
            return invokeLLL.booleanValue;
        }
    }

    public static boolean L(String str, ClassLoader classLoader) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, str, classLoader)) == null) {
            try {
                Runtime runtime = Runtime.getRuntime();
                Method declaredMethod = runtime.getClass().getDeclaredMethod("load", String.class, ClassLoader.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(runtime, str, classLoader);
                return true;
            } catch (InvocationTargetException e2) {
                dtb.e("CrashUtils", "Fail to load library", e2.getTargetException());
                return false;
            } catch (Throwable th) {
                dtb.e("CrashUtils", "Fail to load library", th);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean N(String str, ClassLoader classLoader) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, classLoader)) == null) {
            try {
                Runtime runtime = Runtime.getRuntime();
                Method declaredMethod = runtime.getClass().getDeclaredMethod("loadLibrary", String.class, ClassLoader.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(runtime, str, classLoader);
                return true;
            } catch (InvocationTargetException e2) {
                dtb.e("CrashUtils", "Fail to load library", e2.getTargetException());
                return false;
            } catch (Throwable th) {
                dtb.e("CrashUtils", "Fail to load library", th);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean M(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, context, str)) == null) {
            dtb.d("CrashUtils", String.format("load library: %s", str));
            try {
                System.loadLibrary(str);
                dtb.d("CrashUtils", String.format("load library: %s success", str));
                return true;
            } catch (UnsatisfiedLinkError e2) {
                dtb.c("CrashUtils", String.format("System.loadLibrary %s failed", str), e2);
                if (Build.VERSION.SDK_INT > 24) {
                    return false;
                }
                boolean K = K(context, str, context.getClassLoader());
                if (K) {
                    dtb.d("CrashUtils", String.format("load library: %s success", str));
                } else {
                    dtb.b("CrashUtils", String.format("load library: %s failed", str));
                }
                return K;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean O(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, str)) == null) {
            File file = new File(str);
            if (file.exists()) {
                atb.d("so_md5", String.format("%s so md5 : %s", str, u(file)));
                return true;
            }
            atb.d("so_md5", String.format("%s file path not exist", str));
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String X(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65560, null, str)) == null) {
            StringBuilder sb = new StringBuilder();
            try {
                sb.append(b(MessageDigest.getInstance("MD5").digest(str.getBytes())));
            } catch (NoSuchAlgorithmException e2) {
                dtb.c("CrashReport", "Exception when MD5 %s", e2);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String b(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, bArr)) == null) {
            StringBuilder sb = new StringBuilder();
            if (bArr != null) {
                for (byte b2 : bArr) {
                    sb.append(Integer.toString((b2 & 255) + 256, 16).substring(1));
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static void P(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, str) == null) {
            atb.d("CrashUtils", String.format("dump so md5 : %s", str));
            String str2 = a.getApplicationInfo().nativeLibraryDir + File.separator;
            O(str2 + "lib" + str + "-v7a.so");
            O(str2 + "lib" + str + ".so");
            O(a.getFilesDir().toString() + File.separator + "lib" + str + ".so");
            O(a.getExternalCacheDir().toString() + File.separator + "lib" + str + ".so");
        }
    }

    public static String Y(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, bArr)) == null) {
            char[] cArr = {TransactionIdCreater.FILL_BYTE, '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            StringBuffer stringBuffer = new StringBuffer();
            int length = bArr.length;
            int i2 = 0;
            while (i2 < length) {
                stringBuffer.append(cArr[(bArr[i2] & 240) >> 4]);
                stringBuffer.append(cArr[bArr[i2] & 15]);
                i2++;
                if (i2 < length) {
                    stringBuffer.append(':');
                }
            }
            return stringBuffer.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String u(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65582, null, file)) == null) {
            if (!file.isFile()) {
                return null;
            }
            byte[] bArr = new byte[1024];
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                FileInputStream fileInputStream = new FileInputStream(file);
                while (true) {
                    int read = fileInputStream.read(bArr, 0, 1024);
                    if (read != -1) {
                        messageDigest.update(bArr, 0, read);
                    } else {
                        fileInputStream.close();
                        return new BigInteger(1, messageDigest.digest()).toString(16);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        } else {
            return (String) invokeL.objValue;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0082 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(File file, File file2) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65564, null, file, file2) == null) {
            FileInputStream fileInputStream = null;
            try {
                try {
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (file.exists()) {
                        byte[] bArr = new byte[2048];
                        FileInputStream fileInputStream2 = new FileInputStream(file);
                        try {
                            fileOutputStream2 = new FileOutputStream(file2);
                            while (true) {
                                try {
                                    int read = fileInputStream2.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    fileOutputStream2.write(bArr, 0, read);
                                } catch (Exception e2) {
                                    fileOutputStream = fileOutputStream2;
                                    e = e2;
                                    fileInputStream = fileInputStream2;
                                    try {
                                        dtb.c("CrashUtils", "Fail to load library", e);
                                        file2.delete();
                                        if (fileInputStream != null) {
                                            try {
                                                fileInputStream.close();
                                            } catch (Exception e3) {
                                                dtb.c("CrashUtils", "Fail to load library", e3);
                                            }
                                        }
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        return;
                                    } catch (Throwable th) {
                                        th = th;
                                        if (fileInputStream != null) {
                                            try {
                                                fileInputStream.close();
                                            } catch (Exception e4) {
                                                dtb.c("CrashUtils", "Fail to load library", e4);
                                            }
                                        }
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (Exception e5) {
                                                dtb.c("CrashUtils", "Fail to load library", e5);
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    fileOutputStream = fileOutputStream2;
                                    th = th2;
                                    fileInputStream = fileInputStream2;
                                    if (fileInputStream != null) {
                                    }
                                    if (fileOutputStream != null) {
                                    }
                                    throw th;
                                }
                            }
                            fileInputStream = fileInputStream2;
                        } catch (Exception e6) {
                            e = e6;
                            fileOutputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            fileOutputStream = null;
                        }
                    } else {
                        fileOutputStream2 = null;
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception e7) {
                            dtb.c("CrashUtils", "Fail to load library", e7);
                        }
                    }
                } catch (Exception e8) {
                    dtb.c("CrashUtils", "Fail to load library", e8);
                    return;
                }
            } catch (Exception e9) {
                e = e9;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
            }
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
        }
    }

    public static boolean d(ZipFile zipFile, String str, File file) {
        InterceptResult invokeLLL;
        ZipEntry zipEntry;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65565, null, zipFile, str, file)) == null) {
            InputStream inputStream = null;
            if (PassBiometricUtil.CPU_TYPE_ARMEABI_V7A.equals(Build.CPU_ABI)) {
                zipEntry = zipFile.getEntry("lib/armeabi-v7a/lib" + str + ".so");
                if (zipEntry == null) {
                    zipEntry = zipFile.getEntry("lib/armeabi/lib" + str + "-v7a.so");
                }
            } else {
                zipEntry = null;
            }
            if (zipEntry == null) {
                zipEntry = zipFile.getEntry("lib/armeabi/lib" + str + ".so");
            }
            if (zipEntry == null) {
                return false;
            }
            if (zipEntry.getSize() == file.length()) {
                return true;
            }
            if (file.exists()) {
                file.delete();
            }
            try {
                InputStream inputStream2 = zipFile.getInputStream(zipEntry);
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int read = inputStream2.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                        }
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Exception e2) {
                                dtb.c("CrashUtils", "Fail to load library", e2);
                            }
                        }
                        try {
                            fileOutputStream.close();
                        } catch (Exception e3) {
                            dtb.c("CrashUtils", "Fail to load library", e3);
                        }
                        return true;
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        try {
                            th.printStackTrace();
                            return false;
                        } finally {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Exception e4) {
                                    dtb.c("CrashUtils", "Fail to load library", e4);
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e5) {
                                    dtb.c("CrashUtils", "Fail to load library", e5);
                                }
                            }
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } else {
            return invokeLLL.booleanValue;
        }
    }

    public static JSONObject t() throws JSONException {
        InterceptResult invokeV;
        Map<String, String> extInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65581, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            StringBuilder sb = new StringBuilder();
            Map<String, String> map = j;
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (sb.length() > 0) {
                        sb.append(",");
                    }
                    sb.append(entry.getKey());
                    sb.append(":");
                    sb.append(entry.getValue());
                }
            }
            btb.g gVar = k;
            if (gVar != null && (extInfo = gVar.getExtInfo()) != null) {
                for (Map.Entry<String, String> entry2 : extInfo.entrySet()) {
                    if (sb.length() > 0) {
                        sb.append(",");
                    }
                    sb.append(entry2.getKey());
                    sb.append(":");
                    sb.append(entry2.getValue());
                }
            }
            jSONObject.put("description", sb.toString());
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static String y(String str, String str2, String str3, String str4, String str5, int i2) {
        InterceptResult invokeCommon;
        String C;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65586, null, new Object[]{str, str2, str3, str4, str5, Integer.valueOf(i2)})) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("report_id", str);
                    jSONObject.put("sdk_version", "3.1.0-baidu-SNAPSHOT");
                    jSONObject.put("launch_time", f());
                    jSONObject.put("crash_time", str3);
                    jSONObject.put(CrashHianalyticsData.CRASH_TYPE, str2);
                    jSONObject.put("localTime", str4);
                    jSONObject.put("pkg_name", A());
                    jSONObject.put("app_version", i());
                    jSONObject.put("auth_md5", h());
                    jSONObject.put("app_market", g());
                    jSONObject.put("sys_os_ver", z());
                    jSONObject.put("crash_process", p());
                    jSONObject.put("crash_thread", r());
                    jSONObject.put("crash_device", v());
                    jSONObject.put("crash_device_model", B());
                    jSONObject.put("is_low_mem", w());
                    jSONObject.put("crash_vss", jtb.e());
                    jSONObject.put("flow_tracks", ActivityHistory.INSTANCE.getHistory());
                    jSONObject.put(MigrateStatisticUtils.EXT_INFO, t());
                    jSONObject.put("uid", n);
                    if (i2 > 0) {
                        jSONObject.put("feedback_module_id", String.valueOf(i2));
                    }
                    if (str5.length() > 512) {
                        str5 = str5.substring(0, 510);
                    }
                    jSONObject.put("exception_description", str5);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("RAM", j());
                    jSONObject2.put("ROM", l());
                    jSONObject2.put("SD", k());
                    jSONObject2.put("VSS", jtb.e());
                    jSONObject.put("runtime_avail", jSONObject2);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("RAM", G());
                    jSONObject3.put("ROM", F());
                    jSONObject3.put("SD", E());
                    jSONObject.put("runtime_total", jSONObject3);
                    C = jSONObject.toString();
                } catch (Exception e2) {
                    String C2 = C(e2);
                    if (C2.length() == 0) {
                        C2 = "add report id error , error msg is null";
                    }
                    atb.d("CrashUtils", C2);
                    return C2;
                }
            } catch (Throwable th) {
                C = C(th);
                C = (C == null || C.isEmpty()) ? "json error, msg is null" : "json error, msg is null";
                atb.d("CrashUtils", C);
            }
            dtb.b("CrashReport", String.format("%s crash info : %s", e(), C));
            return C;
        }
        return (String) invokeCommon.objValue;
    }
}
