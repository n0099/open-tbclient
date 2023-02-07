package com.baidu.tieba;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.soloader.SoUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
/* loaded from: classes4.dex */
public final class e61 {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> b;
    public static final List<File> c;
    public static Map<String, WeakReference<Lock>> d;
    public transient /* synthetic */ FieldHolder $fh;
    public StringBuilder a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947686185, "Lcom/baidu/tieba/e61;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947686185, "Lcom/baidu/tieba/e61;");
                return;
            }
        }
        b = Collections.synchronizedSet(new HashSet());
        c = new ArrayList();
        d = new ConcurrentHashMap();
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            String str = System.getenv("LD_LIBRARY_PATH");
            if (str == null) {
                str = "/vendor/lib:/system/lib";
            }
            for (String str2 : str.split(":")) {
                File file = new File(str2);
                if (!c.contains(file)) {
                    c.add(file);
                }
            }
        }
    }

    public e61() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new StringBuilder();
    }

    public static synchronized Lock e(String str) {
        InterceptResult invokeL;
        Lock reentrantLock;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            synchronized (e61.class) {
                WeakReference<Lock> weakReference = d.get(str);
                if (weakReference == null || (reentrantLock = weakReference.get()) == null) {
                    reentrantLock = new ReentrantLock();
                    d.put(str, new WeakReference<>(reentrantLock));
                }
            }
            return reentrantLock;
        }
        return (Lock) invokeL.objValue;
    }

    public final String d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            int lastIndexOf = str.lastIndexOf(".");
            if (lastIndexOf != -1) {
                str = str.substring(0, lastIndexOf);
            }
            return str + "_crc";
        }
        return (String) invokeL.objValue;
    }

    public static File g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            return new File(context.getFilesDir(), "lib");
        }
        return (File) invokeL.objValue;
    }

    public final String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.nativeLibraryDir;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public final void j(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, context) == null) {
            b();
            a(context);
        }
    }

    public static void l(Context context, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str) != null) || b.contains(str)) {
            return;
        }
        m(context, str, null);
    }

    public final long h(ZipFile zipFile, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, zipFile, str)) == null) {
            if (zipFile == null) {
                return 0L;
            }
            try {
                ZipEntry entry = zipFile.getEntry(str);
                if (entry == null) {
                    return 0L;
                }
                return entry.getCrc();
            } catch (Exception unused) {
                return 0L;
            }
        }
        return invokeLL.longValue;
    }

    public final long i(ZipFile zipFile, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, zipFile, str)) == null) {
            if (zipFile == null) {
                return 0L;
            }
            try {
                ZipEntry entry = zipFile.getEntry(str);
                if (entry == null) {
                    return 0L;
                }
                return entry.getSize();
            } catch (Exception unused) {
                return 0L;
            }
        }
        return invokeLL.longValue;
    }

    public static void m(Context context, String str, d61 d61Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, context, str, d61Var) == null) {
            if (d61Var == null) {
                d61Var = c61.a();
            }
            e61 e61Var = new e61();
            if (c.size() == 0) {
                e61Var.j(context);
            }
            if (e61Var.r(context, str, d61Var)) {
                b.add(str);
            }
        }
    }

    public final boolean n(d61 d61Var, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, d61Var, str, str2)) == null) {
            try {
                d61Var.load(str);
                return true;
            } catch (Throwable th) {
                StringBuilder sb = this.a;
                sb.append(str2 + ":::" + str + ":" + Log.getStackTraceString(th));
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final boolean t(d61 d61Var, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048591, this, d61Var, str, str2)) == null) {
            String c2 = f61.c(str);
            try {
                d61Var.loadLibrary(c2);
                return true;
            } catch (Throwable th) {
                StringBuilder sb = this.a;
                sb.append(str2 + ":::" + c2 + ":" + Log.getStackTraceString(th));
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: java.util.List<java.io.File> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new File(f(context)));
            arrayList.add(new File(context.getFilesDir(), "lib"));
            for (int i = 0; i < arrayList.size(); i++) {
                if (!c.contains(arrayList.get(i))) {
                    c.add(arrayList.get(i));
                }
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:59:0x009b */
    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.titan.sdk.runtime.Interceptable */
    /* JADX DEBUG: Multi-variable search result rejected for r3v5, resolved type: java.nio.channels.FileChannel */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0078 A[Catch: IOException -> 0x007c, TRY_ENTER, TRY_LEAVE, TryCatch #11 {IOException -> 0x007c, blocks: (B:40:0x0078, B:57:0x0097), top: B:93:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0097 A[Catch: IOException -> 0x007c, TRY_ENTER, TRY_LEAVE, TryCatch #11 {IOException -> 0x007c, blocks: (B:40:0x0078, B:57:0x0097), top: B:93:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x008d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x009e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean c(Context context, ZipFile zipFile, String str, String str2, long j) {
        FileChannel fileChannel;
        InterceptResult invokeCommon;
        FileChannel fileChannel2;
        Interceptable interceptable = $ic;
        if (interceptable == 0 || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, (fileChannel = new Object[]{context, zipFile, str, str2, Long.valueOf(j)}))) == null) {
            boolean z = false;
            if (zipFile == null) {
                return false;
            }
            File g = g(context);
            if (!g.exists()) {
                g.mkdirs();
            }
            File file = new File(g, str);
            FileLock fileLock = null;
            try {
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                try {
                    File file2 = new File(g, str + ".lock");
                    if (!file2.exists()) {
                        try {
                            file2.createNewFile();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    try {
                        fileChannel2 = new RandomAccessFile(file2, "rw").getChannel();
                    } catch (FileNotFoundException e3) {
                        e = e3;
                        fileChannel2 = null;
                    }
                    try {
                        try {
                            fileLock = fileChannel2.lock();
                        } catch (IOException e4) {
                            try {
                                e4.printStackTrace();
                            } catch (FileNotFoundException e5) {
                                e = e5;
                                e.printStackTrace();
                                if (fileLock != null) {
                                    v(j, str, g);
                                }
                                if (fileLock != null) {
                                }
                                if (fileChannel2 != null) {
                                }
                                return z;
                            }
                        }
                        if (fileLock != null && fileLock.isValid() && (z = u(zipFile, file, str2))) {
                            v(j, str, g);
                        }
                        if (fileLock != null) {
                            try {
                                fileLock.release();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                    } catch (Exception e7) {
                        e = e7;
                        e.printStackTrace();
                        if (fileLock != null) {
                            try {
                                fileLock.release();
                            } catch (IOException e8) {
                                e8.printStackTrace();
                            }
                        }
                        if (fileChannel2 != null) {
                            fileChannel2.close();
                        }
                        return z;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        try {
                            fileLock.release();
                        } catch (IOException e9) {
                            e9.printStackTrace();
                        }
                    }
                    if (fileChannel != 0) {
                        try {
                            fileChannel.close();
                        } catch (IOException e10) {
                            e10.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e11) {
                e = e11;
                fileChannel2 = null;
                e.printStackTrace();
                if (fileLock != null) {
                }
                if (fileChannel2 != null) {
                }
                return z;
            } catch (Throwable th2) {
                th = th2;
                fileChannel = 0;
                if (0 != 0) {
                }
                if (fileChannel != 0) {
                }
                throw th;
            }
            if (fileChannel2 != null) {
                fileChannel2.close();
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean k(String str, long j, long j2) {
        InterceptResult invokeCommon;
        BufferedReader bufferedReader;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            File file = new File(str);
            if (file.exists()) {
                BufferedReader bufferedReader2 = null;
                r1 = null;
                r1 = null;
                String str3 = null;
                BufferedReader bufferedReader3 = null;
                try {
                    File file2 = new File(file.getParentFile(), d(file.getName()));
                    if (file2.exists()) {
                        bufferedReader = new BufferedReader(new FileReader(file2));
                        try {
                            try {
                                bufferedReader3 = bufferedReader;
                                str2 = bufferedReader.readLine();
                            } catch (Exception e) {
                                e = e;
                                e.printStackTrace();
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                return !TextUtils.equals(String.valueOf(j), str3) ? false : false;
                            }
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader2 = bufferedReader;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (Exception e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } else {
                        str2 = null;
                    }
                    if (bufferedReader3 != null) {
                        try {
                            bufferedReader3.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    str3 = str2;
                } catch (Exception e5) {
                    e = e5;
                    bufferedReader = null;
                } catch (Throwable th2) {
                    th = th2;
                    if (bufferedReader2 != null) {
                    }
                    throw th;
                }
                if (!TextUtils.equals(String.valueOf(j), str3) && j2 == file.length()) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean u(ZipFile zipFile, File file, String str) {
        InterceptResult invokeLLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048592, this, zipFile, file, str)) == null) {
            File file2 = new File(file.getAbsoluteFile() + ".tmp");
            InputStream inputStream = null;
            try {
                if (zipFile != null) {
                    try {
                        InputStream inputStream2 = zipFile.getInputStream(zipFile.getEntry(str));
                        try {
                            fileOutputStream = new FileOutputStream(file2);
                            try {
                                if (f61.a(inputStream2, fileOutputStream, 256) > 0) {
                                    boolean renameTo = file2.renameTo(file);
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    try {
                                        fileOutputStream.close();
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                    return renameTo;
                                }
                                inputStream = inputStream2;
                            } catch (Exception unused) {
                                inputStream = inputStream2;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                    return false;
                                }
                                return false;
                            } catch (Throwable th) {
                                th = th;
                                inputStream = inputStream2;
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (Exception e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Exception e5) {
                                        e5.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        } catch (Exception unused2) {
                            fileOutputStream = null;
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream = null;
                        }
                    } catch (Exception unused3) {
                        fileOutputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        fileOutputStream = null;
                    }
                } else {
                    fileOutputStream = null;
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                    return false;
                }
                return false;
            } catch (Exception e7) {
                e7.printStackTrace();
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final boolean o(Context context, d61 d61Var, String str, long j, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{context, d61Var, str, Long.valueOf(j), str2})) == null) {
            File file = new File(f(context), str);
            if (file.exists() && file.length() == j && n(d61Var, file.getAbsolutePath(), SoUtils.SOLOG.SO_NATIVE_LIB_LOAD)) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean p(Context context, d61 d61Var, String str, ZipFile zipFile, String str2, long j) {
        InterceptResult invokeCommon;
        long h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{context, d61Var, str, zipFile, str2, Long.valueOf(j)})) == null) {
            String absolutePath = new File(g(context), str).getAbsolutePath();
            Lock e = e(str);
            e.lock();
            try {
                try {
                    h = h(zipFile, str2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (q(d61Var, absolutePath, h, j)) {
                    return true;
                }
                if (c(context, zipFile, str, str2, h)) {
                    if (q(d61Var, absolutePath, h, j)) {
                        return true;
                    }
                }
                e.unlock();
                return false;
            } finally {
                e.unlock();
            }
        }
        return invokeCommon.booleanValue;
    }

    public final boolean q(d61 d61Var, String str, long j, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{d61Var, str, Long.valueOf(j), Long.valueOf(j2)})) == null) {
            if (k(str, j, j2) && n(d61Var, str, SoUtils.SOLOG.SO_RELEASE_LIB_LOAD)) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean r(Context context, String str, d61 d61Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048589, this, context, str, d61Var)) == null) {
            if (!TextUtils.isEmpty(str)) {
                if (t(d61Var, str, SoUtils.SOLOG.SO_LOAD_LIBRARY)) {
                    return true;
                }
                return s(context, str, d61Var);
            }
            throw new IllegalArgumentException("load so library argument error,soName is null.");
        }
        return invokeLLL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003b A[Catch: all -> 0x00bc, TRY_ENTER, TRY_LEAVE, TryCatch #7 {all -> 0x00bc, blocks: (B:15:0x003b, B:22:0x0050, B:31:0x0095, B:39:0x00a7), top: B:73:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0050 A[Catch: all -> 0x00bc, TRY_ENTER, TRY_LEAVE, TryCatch #7 {all -> 0x00bc, blocks: (B:15:0x003b, B:22:0x0050, B:31:0x0095, B:39:0x00a7), top: B:73:0x0039 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean s(Context context, String str, d61 d61Var) {
        InterceptResult invokeLLL;
        Throwable th;
        ZipFile zipFile;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048590, this, context, str, d61Var)) == null) {
            String b2 = f61.b(str);
            ZipFile zipFile2 = null;
            try {
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                try {
                    try {
                        zipFile = new ZipFile(new File(context.getApplicationInfo().sourceDir));
                    } catch (ZipException e) {
                        this.a.append(Log.getStackTraceString(e));
                        e.printStackTrace();
                        zipFile = null;
                        if (zipFile == null) {
                        }
                    }
                } catch (IOException e2) {
                    this.a.append(Log.getStackTraceString(e2));
                    e2.printStackTrace();
                    zipFile = null;
                    if (zipFile == null) {
                    }
                }
                if (zipFile == null) {
                    f61.f(this.a.toString());
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    return false;
                }
                int i = !f61.d() ? 1 : 0;
                String str2 = f61.b[i] + File.separator + b2;
                long i2 = i(zipFile, str2);
                if (o(context, d61Var, b2, i2, str2)) {
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return true;
                } else if (p(context, d61Var, b2, zipFile, str2, i2)) {
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    return true;
                } else {
                    f61.f(this.a.toString());
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e6) {
                            e6.printStackTrace();
                        }
                    }
                    return false;
                }
            } catch (Throwable th3) {
                th = th3;
                zipFile2 = zipFile;
                if (zipFile2 != null) {
                    try {
                        zipFile2.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return invokeLLL.booleanValue;
    }

    public final boolean v(long j, String str, File file) {
        InterceptResult invokeCommon;
        BufferedWriter bufferedWriter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Long.valueOf(j), str, file})) == null) {
            BufferedWriter bufferedWriter2 = null;
            try {
                try {
                    bufferedWriter = new BufferedWriter(new FileWriter(new File(file, d(str))));
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                bufferedWriter.write(String.valueOf(j));
                try {
                    bufferedWriter.close();
                    return true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return true;
                }
            } catch (Exception e3) {
                e = e3;
                bufferedWriter2 = bufferedWriter;
                e.printStackTrace();
                if (bufferedWriter2 != null) {
                    try {
                        bufferedWriter2.close();
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                bufferedWriter2 = bufferedWriter;
                if (bufferedWriter2 != null) {
                    try {
                        bufferedWriter2.close();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return invokeCommon.booleanValue;
    }
}
