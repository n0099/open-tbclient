package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.so.SoLoader;
import com.baidu.swan.apps.so.SoUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.ZipFile;
/* loaded from: classes4.dex */
public class g93 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final String b;
    public static final boolean c;
    public static final String[] d;
    public static String e;
    public transient /* synthetic */ FieldHolder $fh;

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? "v8.engine" : (String) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: com.baidu.tieba.g93$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public final class RunnableC0251a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public RunnableC0251a() {
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
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    g93.a();
                }
            }
        }

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                ExecutorUtilsExt.postOnElastic(new RunnableC0251a(), "V8SoCleaner", 3);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947748712, "Lcom/baidu/tieba/g93;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947748712, "Lcom/baidu/tieba/g93;");
                return;
            }
        }
        a = wj1.a;
        b = im2.g() + "/v8_so/";
        c = tm2.e0().b();
        d = tm2.e0().a();
        e = null;
    }

    public static void a() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            File file = new File(b);
            if (file.exists() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
                String D = gh3.D();
                for (File file2 : listFiles) {
                    if (!TextUtils.equals(file2.getName(), D)) {
                        qj4.L(file2);
                    }
                }
            }
        }
    }

    public static ArrayList b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("v8.engine");
            arrayList.add("zeusv8");
            if (c) {
                arrayList.add("com.baidu.zeus");
            }
            String[] strArr = d;
            if (strArr != null && strArr.length != 0) {
                arrayList.addAll(Arrays.asList(strArr));
            }
            return arrayList;
        }
        return (ArrayList) invokeV.objValue;
    }

    public static String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (c) {
                return e;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public static boolean e(String str, SoLoader soLoader) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, soLoader)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                System.loadLibrary(str);
                return true;
            } catch (Throwable th) {
                soLoader.appendErrorLog("loadLibsSo: " + th.getMessage());
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean f(String str, SoLoader soLoader) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, soLoader)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                System.load(str);
                return true;
            } catch (Throwable th) {
                soLoader.appendErrorLog("loadSoByPath: " + th.getMessage());
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean l(HashMap hashMap, SoLoader soLoader) {
        InterceptResult invokeLL;
        boolean f;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, hashMap, soLoader)) == null) {
            String[] strArr = d;
            boolean z = true;
            if (strArr != null && strArr.length != 0) {
                for (String str : strArr) {
                    if (hashMap == null) {
                        f = e(str, soLoader);
                    } else {
                        f = f((String) hashMap.get(str), soLoader);
                    }
                    if (!f) {
                        z = false;
                    }
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static boolean g(Context context, SoLoader soLoader) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, context, soLoader)) == null) {
            if (c) {
                File findSoFilesInLibrary = SoLoader.findSoFilesInLibrary(context, "com.baidu.zeus");
                if (findSoFilesInLibrary == null || findSoFilesInLibrary.length() == 0) {
                    return false;
                }
                e = findSoFilesInLibrary.getAbsolutePath();
                m("loadV8EngineSo: v8 dependentFile:" + e);
            }
            boolean l = l(null, soLoader);
            boolean e2 = e("v8.engine", soLoader);
            if (!l || !e2) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static h93 h(Context context, SoLoader soLoader) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, soLoader)) == null) {
            if (g(context, soLoader)) {
                m("loadV8EngineBySystemMethod:success.");
                return h93.e();
            }
            h93 k = k(context, soLoader);
            if (k.b()) {
                m("loadV8EngineSoWithSystemPath:success.");
                return k;
            }
            h93 j = j(context, soLoader);
            if (!j.b()) {
                SoUtils.onEvent("26", soLoader.getErrorLog());
            } else {
                m("loadV8EngineSoWithCustomPath:success.");
            }
            return j;
        }
        return (h93) invokeLL.objValue;
    }

    public static h93 k(Context context, SoLoader soLoader) {
        InterceptResult invokeLL;
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, context, soLoader)) == null) {
            e = null;
            HashMap hashMap = new HashMap();
            Iterator it = b().iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                File findSoFilesInLibrary = SoLoader.findSoFilesInLibrary(context, str2);
                if (findSoFilesInLibrary != null && findSoFilesInLibrary.exists() && findSoFilesInLibrary.length() != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    str = findSoFilesInLibrary.getAbsolutePath();
                } else {
                    str = null;
                }
                hashMap.put(str2, str);
            }
            return i(hashMap, soLoader);
        }
        return (h93) invokeLL.objValue;
    }

    public static h93 i(HashMap hashMap, SoLoader soLoader) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, hashMap, soLoader)) == null) {
            m("loadV8EngineSoByMap:" + hashMap);
            String str = (String) hashMap.get("com.baidu.zeus");
            boolean z = false;
            if (c && str == null) {
                return h93.d(false, false);
            }
            boolean f = f((String) hashMap.get("zeusv8"), soLoader);
            boolean l = l(hashMap, soLoader);
            boolean f2 = f((String) hashMap.get("v8.engine"), soLoader);
            if (f2) {
                e = str;
            }
            if (l && f2) {
                z = true;
            }
            return h93.d(f, z);
        }
        return (h93) invokeLL.objValue;
    }

    public static h93 j(Context context, SoLoader soLoader) {
        InterceptResult invokeLL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, soLoader)) == null) {
            e = null;
            HashMap hashMap = new HashMap();
            String D = gh3.D();
            File file = new File(b, D);
            Iterator it = b().iterator();
            while (true) {
                boolean z = true;
                if (!it.hasNext()) {
                    break;
                }
                String str2 = (String) it.next();
                File file2 = new File(file, SoUtils.getFullName(str2));
                if ((!file2.exists() || file2.length() == 0) ? false : false) {
                    str = file2.getAbsolutePath();
                } else {
                    str = null;
                }
                hashMap.put(str2, str);
            }
            if (!hashMap.containsValue(null)) {
                return i(hashMap, soLoader);
            }
            String str3 = "swan_v8so_unzip_times_" + D;
            int i = ac3.a().getInt(str3, 0);
            if (i >= 3) {
                soLoader.appendErrorLog("loadV8EngineSoWithCustomPath:reach max unzip times.");
                return k(context, soLoader);
            }
            ac3.a().putInt(str3, i + 1);
            String str4 = "lib" + File.separator + SoUtils.getCurrentCpuAbi();
            ZipFile apkZipFile = soLoader.getApkZipFile(context);
            try {
                if (apkZipFile == null) {
                    soLoader.appendErrorLog("loadV8EngineSoWithCustomPath:zipFile is null.");
                    return k(context, soLoader);
                }
                try {
                    for (String str5 : hashMap.keySet()) {
                        if (hashMap.get(str5) == null) {
                            String fullName = SoUtils.getFullName(str5);
                            File file3 = new File(file, fullName);
                            if (soLoader.executeRelease(apkZipFile, fullName, str4, file3)) {
                                hashMap.put(str5, file3.getAbsolutePath());
                            }
                        }
                    }
                } catch (Exception e2) {
                    soLoader.appendErrorLog("loadV8EngineSoWithCustomPath:" + e2.getMessage());
                    if (a) {
                        Log.e("V8InnerSoLoader", "loadV8EngineSoWithCustomPath:" + e2);
                    }
                }
                return i(hashMap, soLoader);
            } finally {
                qj4.d(apkZipFile);
            }
        }
        return (h93) invokeLL.objValue;
    }

    public static void m(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65549, null, str) == null) && a) {
            Log.d("V8InnerSoLoader", str);
        }
    }
}
