package com.baidu.tieba;

import android.preference.PreferenceManager;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.storage.swankv.SwanKV;
import com.baidu.swan.apps.so.SoLoader;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.internal.GlobalConstants;
import com.baidu.webkit.sdk.ZeusWebViewPreloadClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
/* loaded from: classes6.dex */
public class gh2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final String b;
    public static final String c;
    public static final String d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947793848, "Lcom/baidu/tieba/gh2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947793848, "Lcom/baidu/tieba/gh2;");
                return;
            }
        }
        a = qr1.a;
        b = AppRuntime.getAppContext().getFilesDir().getAbsolutePath() + File.separator + ZeusWebViewPreloadClass.ZEUS_FILE_DIR + File.separator + "libs";
        StringBuilder sb = new StringBuilder();
        sb.append(AppRuntime.getAppContext().getFilesDir().getAbsolutePath());
        sb.append(File.separator);
        sb.append("libs");
        c = sb.toString();
        d = AppRuntime.getAppContext().getFilesDir().getAbsolutePath() + File.separator + "swan_so_lite" + File.separator + "libs";
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0173 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0132 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a() {
        FileLock fileLock;
        FileOutputStream fileOutputStream;
        FileChannel fileChannel;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            if (a) {
                Log.d("SwanSailorHelper", "fixSoLoadCrash: start");
            }
            File file = new File(b + File.separator + GlobalConstants.LIB_ZEUS_V8);
            if (file.exists() && file.length() > 0) {
                File file2 = new File(c);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                File file3 = new File(file2, GlobalConstants.LIB_ZEUS_V8);
                long j = uj3.a().getLong("zeus_v8_modified_time", -1L);
                if (file.lastModified() == j && file.length() == file3.length()) {
                    if (a) {
                        Log.d("SwanSailorHelper", "fixSoLoadCrash: srcModifiedTime=" + file.lastModified() + ";savedModifiedTime=" + j + ";srcFileLength=" + file.length() + ";destFileLength=" + file3.length());
                        return;
                    }
                    return;
                }
                if (a) {
                    Log.d("SwanSailorHelper", "fixSoLoadCrash: start copy");
                }
                FileInputStream fileInputStream = null;
                try {
                    File file4 = new File(file2, "libzeusv8.so.lock");
                    if (!file4.exists()) {
                        try {
                            file4.createNewFile();
                        } catch (IOException unused) {
                        }
                    }
                    FileChannel channel = new RandomAccessFile(file4, "rw").getChannel();
                    try {
                        fileLock = channel.lock();
                        if (fileLock != null) {
                            try {
                                if (fileLock.isValid()) {
                                    long lastModified = file.lastModified();
                                    FileInputStream fileInputStream2 = new FileInputStream(file);
                                    try {
                                        fileOutputStream = new FileOutputStream(file3);
                                        try {
                                            byte[] bArr = new byte[8192];
                                            while (true) {
                                                int read = fileInputStream2.read(bArr);
                                                if (read <= 0) {
                                                    break;
                                                }
                                                fileOutputStream.write(bArr, 0, read);
                                            }
                                            fileOutputStream.flush();
                                            uj3.a().putLong("zeus_v8_modified_time", lastModified);
                                            fileInputStream = fileInputStream2;
                                            kr4.d(fileInputStream);
                                            kr4.d(fileOutputStream);
                                            if (fileLock != null) {
                                                try {
                                                    fileLock.release();
                                                } catch (IOException e) {
                                                    e.printStackTrace();
                                                }
                                            }
                                            kr4.d(channel);
                                        } catch (Exception e2) {
                                            fileChannel = channel;
                                            e = e2;
                                            fileInputStream = fileInputStream2;
                                            try {
                                                e.printStackTrace();
                                                kr4.d(fileInputStream);
                                                kr4.d(fileOutputStream);
                                                if (fileLock != null) {
                                                    try {
                                                        fileLock.release();
                                                    } catch (IOException e3) {
                                                        e3.printStackTrace();
                                                    }
                                                }
                                                kr4.d(fileChannel);
                                                return;
                                            } catch (Throwable th) {
                                                th = th;
                                                kr4.d(fileInputStream);
                                                kr4.d(fileOutputStream);
                                                if (fileLock != null) {
                                                    try {
                                                        fileLock.release();
                                                    } catch (IOException e4) {
                                                        e4.printStackTrace();
                                                    }
                                                }
                                                kr4.d(fileChannel);
                                                throw th;
                                            }
                                        } catch (Throwable th2) {
                                            fileChannel = channel;
                                            th = th2;
                                            fileInputStream = fileInputStream2;
                                            kr4.d(fileInputStream);
                                            kr4.d(fileOutputStream);
                                            if (fileLock != null) {
                                            }
                                            kr4.d(fileChannel);
                                            throw th;
                                        }
                                    } catch (Exception e5) {
                                        fileChannel = channel;
                                        e = e5;
                                        fileOutputStream = null;
                                    } catch (Throwable th3) {
                                        fileChannel = channel;
                                        th = th3;
                                        fileOutputStream = null;
                                    }
                                }
                            } catch (Exception e6) {
                                fileChannel = channel;
                                e = e6;
                                fileOutputStream = null;
                            } catch (Throwable th4) {
                                fileChannel = channel;
                                th = th4;
                                fileOutputStream = null;
                            }
                        }
                        fileOutputStream = null;
                        kr4.d(fileInputStream);
                        kr4.d(fileOutputStream);
                        if (fileLock != null) {
                        }
                        kr4.d(channel);
                    } catch (Exception e7) {
                        fileChannel = channel;
                        fileOutputStream = null;
                        e = e7;
                        fileLock = null;
                    } catch (Throwable th5) {
                        fileChannel = channel;
                        fileOutputStream = null;
                        th = th5;
                        fileLock = null;
                    }
                } catch (Exception e8) {
                    e = e8;
                    fileLock = null;
                    fileOutputStream = null;
                    fileChannel = null;
                } catch (Throwable th6) {
                    th = th6;
                    fileLock = null;
                    fileOutputStream = null;
                    fileChannel = null;
                }
            } else if (a) {
                Log.d("SwanSailorHelper", "fixSoLoadCrash: srcFile is not exist");
            }
        }
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("swan_full_install", true);
        }
        return invokeV.booleanValue;
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            uj3.a().putLong("zeus_v8_modified_time", -1L);
            if (a) {
                Log.d("SwanSailorHelper", "fixSoLoadCrash: resetZeusV8ModifiedTime");
            }
        }
    }

    public static bh3 c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65539, null, z)) == null) {
            if (z) {
                return bh3.c(SoLoader.load(AppRuntime.getAppContext(), "v8.engine"));
            }
            boolean z2 = true;
            if (b()) {
                a();
                jh2.g(AppRuntime.getAppContext(), b);
                boolean h = jh2.h("zeusv8", c, true);
                if (new File(b + File.separator + "libv8.engine.so").exists()) {
                    if (!jh2.h("arcore_sdk_c", b, false) || !jh2.h("arcore_sdk_jni", b, false) || !jh2.h(SwanKV.LIB_CPP_SHARED, b, false) || !jh2.h("v8.engine", b, false)) {
                        z2 = false;
                    }
                } else {
                    z2 = SoLoader.load(AppRuntime.getAppContext(), "v8.engine");
                }
                return bh3.d(h, z2);
            }
            jh2.h("zeusv8", d, true);
            return bh3.c(jh2.h("v8.engine", d, true));
        }
        return (bh3) invokeZ.objValue;
    }
}
