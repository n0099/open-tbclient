package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.browser.exception.UnzipErrorException;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipInputStream;
/* loaded from: classes5.dex */
public class ck6 {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947677691, "Lcom/baidu/tieba/ck6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947677691, "Lcom/baidu/tieba/ck6;");
                return;
            }
        }
        a = new String[]{"../", "~/", "__MACOSX/"};
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0048, code lost:
        throw new com.baidu.tieba.browser.exception.UnzipErrorException("创建文件夹节点时出现错误，文件夹创建失败：" + r2.getPath());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(@NonNull File file, @NonNull ZipInputStream zipInputStream) throws UnzipErrorException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, file, zipInputStream) == null) {
            String str = null;
            while (true) {
                try {
                    try {
                        try {
                            ZipEntry nextEntry = zipInputStream.getNextEntry();
                            if (nextEntry != null) {
                                str = nextEntry.getName();
                                if (d(str)) {
                                    File file2 = new File(file, str);
                                    if (nextEntry.isDirectory()) {
                                        if (!file2.exists() && !file2.mkdirs()) {
                                            break;
                                        }
                                    } else {
                                        b(file2, zipInputStream, true);
                                    }
                                }
                            } else {
                                try {
                                    zipInputStream.closeEntry();
                                    return;
                                } catch (IOException unused) {
                                    return;
                                }
                            }
                        } catch (IOException e) {
                            throw new UnzipErrorException("I/O error has occurred:" + str, e);
                        }
                    } catch (ZipException e2) {
                        throw new UnzipErrorException("a ZIP file error has occurred:" + str, e2);
                    }
                } catch (Throwable th) {
                    try {
                        zipInputStream.closeEntry();
                    } catch (IOException unused2) {
                    }
                    throw th;
                }
            }
        }
    }

    public static void b(File file, ZipInputStream zipInputStream, boolean z) throws UnzipErrorException {
        BufferedOutputStream bufferedOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65538, null, file, zipInputStream, z) == null) {
            byte[] bArr = new byte[1024];
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    bufferedOutputStream = new BufferedOutputStream(fileOutputStream2);
                    while (true) {
                        try {
                            int read = zipInputStream.read(bArr, 0, 1024);
                            if (read != -1) {
                                bufferedOutputStream.write(bArr, 0, read);
                            } else {
                                bufferedOutputStream.flush();
                                ak6.a(fileOutputStream2, bufferedOutputStream);
                                return;
                            }
                        } catch (Exception e) {
                            e = e;
                            fileOutputStream = fileOutputStream2;
                            try {
                                if (z) {
                                    b(file, zipInputStream, false);
                                    ak6.a(fileOutputStream, bufferedOutputStream);
                                    return;
                                }
                                throw new UnzipErrorException("解压后写入文件时错误：" + file, e);
                            } catch (Throwable th) {
                                th = th;
                                ak6.a(fileOutputStream, bufferedOutputStream);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            fileOutputStream = fileOutputStream2;
                            ak6.a(fileOutputStream, bufferedOutputStream);
                            throw th;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    bufferedOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream = null;
                }
            } catch (Exception e3) {
                e = e3;
                bufferedOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedOutputStream = null;
            }
        }
    }

    public static void c(File file, File file2) throws UnzipErrorException {
        Closeable closeable;
        Closeable closeable2;
        InputStream inputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, file, file2) == null) {
            if (file2 != null && file != null) {
                if (file.exists() && file.isFile() && file.canRead()) {
                    if (yj6.a(file2)) {
                        Closeable closeable3 = null;
                        try {
                            inputStream = new FileInputStream(file);
                            try {
                                closeable = new CheckedInputStream(inputStream, new CRC32());
                                try {
                                    closeable2 = new ZipInputStream(closeable);
                                } catch (FileNotFoundException e) {
                                    e = e;
                                    closeable2 = null;
                                } catch (Throwable th) {
                                    th = th;
                                    closeable2 = null;
                                }
                            } catch (FileNotFoundException e2) {
                                e = e2;
                                closeable2 = null;
                            } catch (Throwable th2) {
                                th = th2;
                                closeable = null;
                                closeable2 = null;
                            }
                        } catch (FileNotFoundException e3) {
                            e = e3;
                            inputStream = null;
                            closeable2 = null;
                        } catch (Throwable th3) {
                            th = th3;
                            closeable = null;
                            closeable2 = null;
                            ak6.a(closeable3, closeable, closeable2);
                            throw th;
                        }
                        try {
                            a(file2, closeable2);
                            ak6.a(inputStream, closeable, closeable2);
                            return;
                        } catch (FileNotFoundException e4) {
                            e = e4;
                            closeable3 = closeable;
                            try {
                                throw new UnzipErrorException("读取源文件时出现错误:" + file.getPath(), e);
                            } catch (Throwable th4) {
                                th = th4;
                                closeable = closeable3;
                                closeable3 = inputStream;
                                ak6.a(closeable3, closeable, closeable2);
                                throw th;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            closeable3 = inputStream;
                            ak6.a(closeable3, closeable, closeable2);
                            throw th;
                        }
                    }
                    throw new UnzipErrorException("目标文件夹创建失败：" + file2.getPath());
                }
                throw new UnzipErrorException("源文件不存在或不可读：" + file.getPath());
            }
            throw new UnzipErrorException("参数传入错误：destFile == null || srcFile == null");
        }
    }

    public static boolean d(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            for (String str2 : a) {
                if (str.contains(str2)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
