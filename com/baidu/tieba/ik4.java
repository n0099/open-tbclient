package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.AtomicFile;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
/* loaded from: classes4.dex */
public final class ik4 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = null;
    public static int b = -1;
    public static int c = 1;
    public static int d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947856375, "Lcom/baidu/tieba/ik4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947856375, "Lcom/baidu/tieba/ik4;");
                return;
            }
        }
        a = o();
    }

    public static String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65576, null)) == null) {
            if (TextUtils.isEmpty(a)) {
                a = p(AppRuntime.getAppContext());
            }
            return a;
        }
        return (String) invokeV.objValue;
    }

    public static int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65578, null)) == null) {
            int i = d;
            if (i > 0) {
                return i;
            }
            try {
                d = new StatFs("/data").getBlockSize();
            } catch (IllegalArgumentException unused) {
            }
            if (d <= 0) {
                d = 8192;
            }
            return d;
        }
        return invokeV.intValue;
    }

    public static boolean A(ZipEntry zipEntry, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, zipEntry, str)) == null) {
            String name = zipEntry.getName();
            if (TextUtils.isEmpty(name) || x(name)) {
                return true;
            }
            File file = new File(str, name);
            if (zipEntry.isDirectory()) {
                return file.isDirectory();
            }
            if (file.isFile() && file.length() == zipEntry.getSize()) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean X(String str, String str2) {
        InterceptResult invokeLL;
        File file;
        ZipOutputStream zipOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65560, null, str, str2)) == null) {
            ZipOutputStream zipOutputStream2 = null;
            try {
                try {
                    File file2 = new File(str2);
                    file = new File(str);
                    zipOutputStream = new ZipOutputStream(new FileOutputStream(file2));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            }
            try {
                if (file.isFile()) {
                    Y(zipOutputStream, file, "");
                } else {
                    for (File file3 : file.listFiles()) {
                        Y(zipOutputStream, file3, "");
                    }
                }
                d(zipOutputStream);
                return true;
            } catch (Exception e2) {
                e = e2;
                zipOutputStream2 = zipOutputStream;
                e.printStackTrace();
                d(zipOutputStream2);
                return false;
            } catch (Throwable th2) {
                th = th2;
                zipOutputStream2 = zipOutputStream;
                d(zipOutputStream2);
                throw th;
            }
        }
        return invokeLL.booleanValue;
    }

    public static void e(File file, File file2) {
        String[] list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65566, null, file, file2) == null) && file != null && file2 != null && (list = file.list()) != null && list.length != 0) {
            l(file2);
            for (String str : list) {
                if (!TextUtils.isEmpty(str)) {
                    File file3 = new File(file, str);
                    File file4 = new File(file2, str);
                    if (file3.isDirectory()) {
                        e(file3, file4);
                    }
                    if (file3.isFile()) {
                        h(file4);
                        f(file3, file4);
                    }
                }
            }
        }
    }

    public static long f(File file, File file2) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65567, null, file, file2)) == null) {
            long j = 0;
            if (file == null || file2 == null || !file.exists()) {
                return 0L;
            }
            FileInputStream fileInputStream2 = null;
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Exception e) {
                    e = e;
                    fileOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = null;
                }
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
            try {
                j = g(fileInputStream, fileOutputStream);
                d(fileInputStream);
            } catch (Exception e3) {
                e = e3;
                fileInputStream2 = fileInputStream;
                try {
                    e.printStackTrace();
                    d(fileInputStream2);
                    d(fileOutputStream);
                    return j;
                } catch (Throwable th3) {
                    th = th3;
                    d(fileInputStream2);
                    d(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                fileInputStream2 = fileInputStream;
                d(fileInputStream2);
                d(fileOutputStream);
                throw th;
            }
            d(fileOutputStream);
            return j;
        }
        return invokeLL.longValue;
    }

    public static boolean z(String str, String str2) {
        InterceptResult invokeLL;
        ZipEntry nextEntry;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65587, null, str, str2)) == null) {
            try {
                ZipInputStream zipInputStream = new ZipInputStream(AppRuntime.getAppContext().getAssets().open(str));
                do {
                    nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        zipInputStream.close();
                        return true;
                    }
                } while (A(nextEntry, str2));
                zipInputStream.close();
                return false;
            } catch (IOException unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean B(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            try {
                ZipFile zipFile = new ZipFile(str);
                Enumeration<? extends ZipEntry> entries = zipFile.entries();
                while (entries.hasMoreElements()) {
                    if (!A(entries.nextElement(), str2)) {
                        zipFile.close();
                        return false;
                    }
                }
                zipFile.close();
                return true;
            } catch (IOException unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static long g(InputStream inputStream, OutputStream outputStream) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65568, null, inputStream, outputStream)) == null) {
            if (inputStream != null && outputStream != null) {
                try {
                    byte[] bArr = new byte[3072];
                    long j = 0;
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read > 0) {
                            outputStream.write(bArr, 0, read);
                            j += read;
                        } else {
                            outputStream.flush();
                            return j;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return 0L;
        }
        return invokeLL.longValue;
    }

    public static void i(File file, String str) {
        File[] C;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65570, null, file, str) == null) {
            if (str == null) {
                str = "";
            }
            for (File file2 : C(file)) {
                if (file2.isDirectory()) {
                    String name = file2.getName();
                    if (name.endsWith(".tmp") && name.contains(str)) {
                        j(file2);
                    }
                }
            }
        }
    }

    @NonNull
    public static File[] C(@Nullable File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, file)) == null) {
            if (file != null && file.exists()) {
                File[] listFiles = file.listFiles();
                if (listFiles == null) {
                    return new File[0];
                }
                return listFiles;
            }
            return new File[0];
        }
        return (File[]) invokeL.objValue;
    }

    public static String E(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, file)) == null) {
            try {
                return H(new FileInputStream(file));
            } catch (FileNotFoundException unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static List<String> F(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, file)) == null) {
            try {
                return I(new FileInputStream(file));
            } catch (FileNotFoundException unused) {
                return new ArrayList();
            }
        }
        return (List) invokeL.objValue;
    }

    public static String K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return J(new File(str));
        }
        return (String) invokeL.objValue;
    }

    public static boolean M(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && L(new File(str))) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void d(@Nullable Closeable closeable) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65565, null, closeable) == null) && closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean h(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65569, null, file)) == null) {
            if (file != null && !file.exists()) {
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.exists()) {
                    parentFile.mkdirs();
                }
                try {
                    return file.createNewFile();
                } catch (IOException unused) {
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            File file = new File(str);
            if (!file.exists()) {
                return false;
            }
            return j(file);
        }
        return invokeL.booleanValue;
    }

    public static boolean l(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, file)) == null) {
            if (file == null) {
                return false;
            }
            if (!file.exists()) {
                try {
                    file.mkdirs();
                    return true;
                } catch (SecurityException unused) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65583, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && new File(str).exists()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65585, null, str)) == null) {
            return str.contains("../");
        }
        return invokeL.booleanValue;
    }

    public static boolean y(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65586, null, file)) == null) {
            if (file != null && file.exists() && file.isFile()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public static String D(Context context, String str) {
        InterceptResult invokeLL;
        BufferedReader bufferedReader;
        Throwable th;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                try {
                    inputStream = context.getAssets().open(str);
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    } catch (IOException unused) {
                        bufferedReader = null;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = null;
                    }
                } catch (IOException unused2) {
                    inputStream = null;
                    bufferedReader = null;
                } catch (Throwable th3) {
                    bufferedReader = null;
                    th = th3;
                    inputStream = null;
                }
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            sb.append(readLine);
                        } else {
                            String sb2 = sb.toString();
                            d(inputStream);
                            d(bufferedReader);
                            return sb2;
                        }
                    }
                } catch (IOException unused3) {
                    d(inputStream);
                    d(bufferedReader);
                    return null;
                } catch (Throwable th4) {
                    th = th4;
                    d(inputStream);
                    d(bufferedReader);
                    throw th;
                }
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0077 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void P(@NonNull List<String> list, @NonNull File file) {
        FileOutputStream fileOutputStream;
        FileChannel fileChannel;
        FileLock fileLock;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65552, null, list, file) != null) || !file.exists()) {
            return;
        }
        AtomicFile atomicFile = null;
        r0 = null;
        FileLock fileLock2 = null;
        FileChannel fileChannel2 = null;
        try {
            try {
                AtomicFile atomicFile2 = new AtomicFile(file);
                try {
                    atomicFile2.startWrite();
                    fileOutputStream = atomicFile2.startWrite();
                    try {
                        fileChannel = fileOutputStream.getChannel();
                        try {
                            try {
                                fileLock = fileChannel.lock();
                                for (int i = 0; i < list.size(); i++) {
                                    try {
                                        fileOutputStream.write(list.get(i).getBytes());
                                        if (i != list.size() - 1) {
                                            fileOutputStream.write("\n".getBytes());
                                        }
                                    } catch (IOException unused) {
                                        atomicFile = atomicFile2;
                                        if (atomicFile != null) {
                                        }
                                        if (fileChannel == null) {
                                        }
                                        fileChannel.close();
                                    }
                                }
                                if (fileLock != null) {
                                    fileLock.release();
                                } else {
                                    fileLock2 = fileLock;
                                }
                                atomicFile2.finishWrite(fileOutputStream);
                                if (fileChannel == null) {
                                    return;
                                }
                            } catch (IOException unused2) {
                                fileLock = fileLock2;
                            }
                        } catch (Throwable th) {
                            th = th;
                            fileChannel2 = fileChannel;
                            if (fileChannel2 != null) {
                            }
                            throw th;
                        }
                    } catch (IOException unused3) {
                        fileChannel = null;
                        fileLock = fileChannel;
                        atomicFile = atomicFile2;
                        if (atomicFile != null) {
                            if (fileLock != null) {
                                try {
                                    fileLock.release();
                                } catch (IOException unused4) {
                                }
                            }
                            atomicFile.failWrite(fileOutputStream);
                        }
                        if (fileChannel == null) {
                            return;
                        }
                        fileChannel.close();
                    }
                } catch (IOException unused5) {
                    fileOutputStream = null;
                    fileChannel = null;
                }
            } catch (Throwable th2) {
                th = th2;
                if (fileChannel2 != null) {
                    try {
                        fileChannel2.close();
                    } catch (IOException unused6) {
                    }
                }
                throw th;
            }
        } catch (IOException unused7) {
            fileOutputStream = null;
            fileChannel = null;
            fileLock = null;
        }
        try {
            fileChannel.close();
        } catch (IOException unused8) {
        }
    }

    public static byte[] G(File file) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, file)) == null) {
            FileInputStream fileInputStream2 = null;
            if (file == null) {
                return null;
            }
            byte[] bArr = new byte[Long.valueOf(file.length()).intValue()];
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    fileInputStream.read(bArr);
                    fileInputStream.close();
                    d(fileInputStream);
                    return bArr;
                } catch (Exception unused) {
                    d(fileInputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    d(fileInputStream2);
                    throw th;
                }
            } catch (Exception unused2) {
                fileInputStream = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } else {
            return (byte[]) invokeL.objValue;
        }
    }

    public static List<String> I(FileInputStream fileInputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, fileInputStream)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                if (fileInputStream == null) {
                    return arrayList;
                }
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            arrayList.add(readLine);
                        } else {
                            try {
                                break;
                            } catch (IOException unused) {
                            }
                        }
                    }
                    fileInputStream.close();
                    return arrayList;
                } catch (IOException unused2) {
                    ArrayList arrayList2 = new ArrayList();
                    try {
                        fileInputStream.close();
                    } catch (IOException unused3) {
                    }
                    return arrayList2;
                }
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (IOException unused4) {
                }
                throw th;
            }
        }
        return (List) invokeL.objValue;
    }

    public static boolean m(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65574, null, file)) == null) {
            if (file == null) {
                return false;
            }
            if (file.exists()) {
                return true;
            }
            for (int i = 0; i < 5; i++) {
                try {
                    file.mkdirs();
                    if (file.exists()) {
                        return true;
                    }
                    Thread.sleep(1L);
                } catch (Exception unused) {
                }
            }
            return file.exists();
        }
        return invokeL.booleanValue;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public static String p(Context context) {
        InterceptResult invokeL;
        File file;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65577, null, context)) == null) {
            if (Build.VERSION.SDK_INT >= 8) {
                file = context.getExternalCacheDir();
            } else {
                file = null;
            }
            if (file == null && w()) {
                file = Environment.getExternalStorageDirectory();
            }
            if (file == null) {
                file = context.getCacheDir();
            }
            if (file == null) {
                file = context.getFilesDir();
            }
            if (file == null) {
                return null;
            }
            return file.getAbsolutePath();
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    @CheckResult
    public static String r(@Nullable String str) {
        InterceptResult invokeL;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65579, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(46)) > -1 && lastIndexOf < str.length() - 1) {
                return str.substring(lastIndexOf + 1);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65580, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && !str.endsWith(File.separator)) {
                int lastIndexOf = str.lastIndexOf(File.separator);
                int length = str.length();
                if (lastIndexOf != b && length > lastIndexOf) {
                    return str.substring(lastIndexOf + c, length);
                }
                return str;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static String t(String str) {
        InterceptResult invokeL;
        int lastIndexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65581, null, str)) == null) {
            String s = s(str);
            if (TextUtils.isEmpty(s) || (lastIndexOf = s.lastIndexOf(".")) == b || lastIndexOf == s.length() - 1) {
                return "";
            }
            return s.substring(lastIndexOf + 1);
        }
        return (String) invokeL.objValue;
    }

    public static long u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65582, null, str)) == null) {
            long j = -1;
            if (TextUtils.isEmpty(str)) {
                return -1L;
            }
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(str);
                String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
                if (!TextUtils.isEmpty(extractMetadata)) {
                    j = Long.parseLong(extractMetadata);
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                mediaMetadataRetriever.release();
                throw th;
            }
            mediaMetadataRetriever.release();
            return j;
        }
        return invokeL.longValue;
    }

    public static String H(FileInputStream fileInputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, fileInputStream)) == null) {
            if (fileInputStream == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                    } else {
                        return sb.toString();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            } finally {
                d(fileInputStream);
            }
        } else {
            return (String) invokeL.objValue;
        }
    }

    public static String J(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, file)) == null) {
            if (file != null) {
                try {
                    if (file.exists()) {
                        String absolutePath = file.getAbsolutePath();
                        File file2 = new File(absolutePath);
                        long currentTimeMillis = System.currentTimeMillis();
                        File file3 = new File(absolutePath + currentTimeMillis + ".tmp");
                        if (file2.renameTo(file3)) {
                            return file3.getAbsolutePath();
                        }
                    }
                } catch (Exception unused) {
                }
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static boolean L(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, file)) == null) {
            if (file != null) {
                try {
                    if (file.exists()) {
                        String absolutePath = file.getAbsolutePath();
                        File file2 = new File(absolutePath);
                        long currentTimeMillis = System.currentTimeMillis();
                        File file3 = new File(absolutePath + currentTimeMillis + ".tmp");
                        if (file2.renameTo(file3)) {
                            return j(file3);
                        }
                        return j(file);
                    }
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static long a(@Nullable File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, file)) == null) {
            long j = 0;
            if (file != null && file.exists()) {
                if (file.isFile()) {
                    return file.length();
                }
                Stack stack = new Stack();
                stack.push(file);
                while (!stack.isEmpty()) {
                    File file2 = (File) stack.pop();
                    if (file2 != null) {
                        if (file2.isDirectory()) {
                            File[] listFiles = file2.listFiles();
                            if (listFiles != null && listFiles.length > 0) {
                                Collections.addAll(stack, listFiles);
                            }
                        } else {
                            j += file2.length();
                        }
                    }
                }
            }
            return j;
        }
        return invokeL.longValue;
    }

    public static boolean j(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, file)) == null) {
            if (file == null) {
                return false;
            }
            boolean z = true;
            if (!file.exists()) {
                return true;
            }
            if (file.isFile()) {
                return true & file.delete();
            }
            if (!file.isDirectory()) {
                return true;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    z &= j(file2);
                }
            }
            return z & file.delete();
        }
        return invokeL.booleanValue;
    }

    public static boolean N(String str, File file) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65550, null, str, file)) == null) {
            if (TextUtils.isEmpty(str) || file.exists()) {
                return false;
            }
            O(str.getBytes(), file);
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static void O(byte[] bArr, File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, null, bArr, file) == null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            Q(byteArrayInputStream, file);
            d(byteArrayInputStream);
        }
    }

    public static void Q(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65553, null, inputStream, file) == null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException e) {
                e = e;
            }
            try {
                g(inputStream, fileOutputStream);
                d(fileOutputStream);
            } catch (FileNotFoundException e2) {
                e = e2;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                d(fileOutputStream2);
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                d(fileOutputStream2);
                throw th;
            }
        }
    }

    public static boolean U(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65557, null, str, str2)) == null) {
            if (W(str, str2) == null) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static long c(@Nullable File file, @NonNull Set<String> set) {
        InterceptResult invokeLL;
        File[] C;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65564, null, file, set)) == null) {
            long j = 0;
            for (File file2 : C(file)) {
                if (set.contains(file2.getName())) {
                    j += a(file2);
                }
            }
            return j;
        }
        return invokeLL.longValue;
    }

    public static void R(InputStream inputStream, File file, boolean z) {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65554, null, inputStream, file, z) == null) {
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file, z);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException e) {
                e = e;
            }
            try {
                g(inputStream, fileOutputStream);
                d(fileOutputStream);
            } catch (FileNotFoundException e2) {
                e = e2;
                fileOutputStream2 = fileOutputStream;
                e.printStackTrace();
                d(fileOutputStream2);
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                d(fileOutputStream2);
                throw th;
            }
        }
    }

    public static void S(String str, File file, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65555, null, str, file, z) == null) {
            R(new ByteArrayInputStream(str.getBytes()), file, z);
        }
    }

    public static String T(byte[] bArr, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65556, null, bArr, str, z)) == null) {
            StringBuilder sb = new StringBuilder();
            for (byte b2 : bArr) {
                String hexString = Integer.toHexString(b2 & 255);
                if (z) {
                    hexString = hexString.toUpperCase();
                }
                if (hexString.length() == 1) {
                    sb.append("0");
                }
                sb.append(hexString);
                sb.append(str);
            }
            return sb.toString();
        }
        return (String) invokeLLZ.objValue;
    }

    public static long b(@NonNull File file, @NonNull String str, @Nullable String str2) {
        InterceptResult invokeLLL;
        File[] C;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65563, null, file, str, str2)) == null) {
            long j = 0;
            for (File file2 : C(file)) {
                String name = file2.getName();
                if (name.startsWith(str) && str2 != null && !name.startsWith(str2)) {
                    j += a(file2);
                }
            }
            return j;
        }
        return invokeLLL.longValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v4, resolved type: java.io.BufferedOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    public static boolean V(String str, String str2) {
        InterceptResult invokeLL;
        ZipInputStream zipInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65558, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdirs();
                }
                InputStream inputStream = null;
                try {
                    InputStream open = AppRuntime.getAppContext().getAssets().open(str);
                    try {
                        zipInputStream = new ZipInputStream(open);
                        try {
                            byte[] bArr = new byte[q()];
                            while (true) {
                                ZipEntry nextEntry = zipInputStream.getNextEntry();
                                if (nextEntry != null) {
                                    if (!TextUtils.isEmpty(nextEntry.getName()) && !x(nextEntry.getName())) {
                                        File file2 = new File(str2 + File.separator + nextEntry.getName());
                                        if (nextEntry.isDirectory()) {
                                            if (!file2.exists()) {
                                                file2.mkdir();
                                            }
                                        } else if (file2.exists()) {
                                            continue;
                                        } else {
                                            h(file2);
                                            try {
                                                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2), 2048);
                                                while (true) {
                                                    try {
                                                        int read = zipInputStream.read(bArr);
                                                        if (read == -1) {
                                                            break;
                                                        }
                                                        bufferedOutputStream.write(bArr, 0, read);
                                                    } catch (Throwable th) {
                                                        th = th;
                                                        inputStream = bufferedOutputStream;
                                                        d(inputStream);
                                                        throw th;
                                                    }
                                                }
                                                d(bufferedOutputStream);
                                                inputStream = bufferedOutputStream;
                                            } catch (Throwable th2) {
                                                th = th2;
                                            }
                                        }
                                    }
                                } else {
                                    d(open);
                                    d(zipInputStream);
                                    return true;
                                }
                            }
                        } catch (IOException unused) {
                            inputStream = open;
                            d(inputStream);
                            d(zipInputStream);
                            return false;
                        } catch (Throwable th3) {
                            th = th3;
                            inputStream = open;
                            d(inputStream);
                            d(zipInputStream);
                            throw th;
                        }
                    } catch (IOException unused2) {
                        zipInputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        zipInputStream = null;
                    }
                } catch (IOException unused3) {
                    zipInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    zipInputStream = null;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static Exception W(String str, String str2) {
        InterceptResult invokeLL;
        ZipFile zipFile;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65559, null, str, str2)) == null) {
            System.currentTimeMillis();
            if (str == null) {
                return new Exception("srcFileName is null");
            }
            if (str2 == null) {
                str2 = new File(str).getParent();
            }
            BufferedOutputStream bufferedOutputStream2 = null;
            try {
                zipFile = new ZipFile(str);
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile.entries();
                    BufferedOutputStream bufferedOutputStream3 = null;
                    bufferedInputStream = null;
                    while (entries.hasMoreElements()) {
                        try {
                            ZipEntry nextElement = entries.nextElement();
                            if (!TextUtils.isEmpty(nextElement.getName()) && !x(nextElement.getName())) {
                                File file = new File(str2 + "/" + nextElement.getName());
                                if (nextElement.isDirectory()) {
                                    if (!file.exists()) {
                                        file.mkdirs();
                                    }
                                } else {
                                    if (!file.exists()) {
                                        h(file);
                                    }
                                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(zipFile.getInputStream(nextElement));
                                    try {
                                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), 2048);
                                    } catch (IOException e) {
                                        e = e;
                                        bufferedOutputStream2 = bufferedOutputStream3;
                                    } catch (Throwable th) {
                                        th = th;
                                        bufferedOutputStream2 = bufferedOutputStream3;
                                    }
                                    try {
                                        byte[] bArr = new byte[2048];
                                        while (true) {
                                            int read = bufferedInputStream2.read(bArr, 0, 2048);
                                            if (read == -1) {
                                                break;
                                            }
                                            bufferedOutputStream.write(bArr, 0, read);
                                        }
                                        d(bufferedInputStream2);
                                        d(bufferedOutputStream);
                                        bufferedOutputStream3 = bufferedOutputStream;
                                        bufferedInputStream = bufferedInputStream2;
                                    } catch (IOException e2) {
                                        e = e2;
                                        bufferedOutputStream2 = bufferedOutputStream;
                                        bufferedInputStream = bufferedInputStream2;
                                        try {
                                            e.printStackTrace();
                                            d(bufferedOutputStream2);
                                            d(bufferedInputStream);
                                            d(zipFile);
                                            System.currentTimeMillis();
                                            return e;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            d(bufferedOutputStream2);
                                            d(bufferedInputStream);
                                            d(zipFile);
                                            System.currentTimeMillis();
                                            throw th;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        bufferedOutputStream2 = bufferedOutputStream;
                                        bufferedInputStream = bufferedInputStream2;
                                        d(bufferedOutputStream2);
                                        d(bufferedInputStream);
                                        d(zipFile);
                                        System.currentTimeMillis();
                                        throw th;
                                    }
                                }
                            }
                        } catch (IOException e3) {
                            e = e3;
                            bufferedOutputStream2 = bufferedOutputStream3;
                        } catch (Throwable th4) {
                            th = th4;
                            bufferedOutputStream2 = bufferedOutputStream3;
                        }
                    }
                    d(bufferedOutputStream3);
                    d(bufferedInputStream);
                    d(zipFile);
                    System.currentTimeMillis();
                    return null;
                } catch (IOException e4) {
                    e = e4;
                    bufferedInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedInputStream = null;
                }
            } catch (IOException e5) {
                e = e5;
                zipFile = null;
                bufferedInputStream = null;
            } catch (Throwable th6) {
                th = th6;
                zipFile = null;
                bufferedInputStream = null;
            }
        } else {
            return (Exception) invokeLL.objValue;
        }
    }

    public static void Y(ZipOutputStream zipOutputStream, File file, String str) {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65561, null, zipOutputStream, file, str) == null) {
            FileInputStream fileInputStream = null;
            try {
                try {
                    if (!file.isDirectory()) {
                        byte[] bArr = new byte[4096];
                        FileInputStream fileInputStream2 = new FileInputStream(file);
                        try {
                            zipOutputStream.putNextEntry(new ZipEntry(str + file.getName()));
                            while (true) {
                                int read = fileInputStream2.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                zipOutputStream.write(bArr, 0, read);
                            }
                            zipOutputStream.closeEntry();
                            fileInputStream = fileInputStream2;
                        } catch (Exception e) {
                            e = e;
                            fileInputStream = fileInputStream2;
                            e.printStackTrace();
                            d(fileInputStream);
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            d(fileInputStream);
                            throw th;
                        }
                    } else {
                        for (File file2 : file.listFiles()) {
                            Y(zipOutputStream, file2, str + file.getName() + File.separator);
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                }
                d(fileInputStream);
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public static String n(long j) {
        InterceptResult invokeJ;
        Float valueOf;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65575, null, j)) == null) {
            if (j <= 0) {
                return FileUtils.UNKNOW;
            }
            if (j < 1024) {
                return j + "B";
            }
            if (j < 1048576) {
                valueOf = Float.valueOf(((float) j) / 1024.0f);
                str = "KB";
            } else if (j < 1073741824) {
                valueOf = Float.valueOf(((float) j) / 1048576.0f);
                str = "MB";
            } else {
                valueOf = Float.valueOf(((float) j) / 1.0737418E9f);
                str = "GB";
            }
            DecimalFormat decimalFormat = new DecimalFormat("####.##");
            return decimalFormat.format(valueOf) + str;
        }
        return (String) invokeJ.objValue;
    }

    public static boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65584, null)) == null) {
            if (!TextUtils.equals("mounted", Environment.getExternalStorageState()) || TextUtils.isEmpty(a)) {
                return false;
            }
            try {
                File file = new File(a, ".696E5309-E4A7-27C0-A787-0B2CEBF1F1AB");
                if (!file.exists()) {
                    if (!file.createNewFile()) {
                        return false;
                    }
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
