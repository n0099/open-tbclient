package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.Charset;
/* loaded from: classes4.dex */
public class hn2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947829405, "Lcom/baidu/tieba/hn2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947829405, "Lcom/baidu/tieba/hn2;");
                return;
            }
        }
        a = ok1.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00bd A[Catch: all -> 0x00f4, TryCatch #2 {, blocks: (B:6:0x0007, B:8:0x0012, B:10:0x0016, B:13:0x001f, B:23:0x0078, B:24:0x007b, B:51:0x00b5, B:53:0x00bd, B:54:0x00d9, B:27:0x0080, B:28:0x0086, B:59:0x00e2, B:60:0x00e5, B:64:0x00f3, B:63:0x00ea, B:46:0x00a6, B:47:0x00a9, B:50:0x00ae), top: B:74:0x0007, inners: #0, #5, #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @SuppressLint({"SwanDebugLog"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized String a(String str) {
        InterceptResult invokeL;
        BufferedReader bufferedReader;
        String str2;
        String stackTraceString;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            synchronized (hn2.class) {
                long currentTimeMillis = System.currentTimeMillis();
                FileLock fileLock = null;
                if (TextUtils.isEmpty(str) && a) {
                    Log.w("SwanAppFile", "path name is empty");
                    return null;
                }
                StringBuffer stringBuffer = new StringBuffer();
                try {
                    FileChannel channel = new RandomAccessFile(str, "rw").getChannel();
                    FileLock lock = channel.lock(0L, Long.MAX_VALUE, true);
                    try {
                        bufferedReader = new BufferedReader(Channels.newReader(channel, Charset.defaultCharset().name()));
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                stringBuffer.append(readLine);
                            } catch (IOException e) {
                                e = e;
                                fileLock = lock;
                                try {
                                    Log.e("SwanAppFile", Log.getStackTraceString(e));
                                    if (fileLock != null) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException e2) {
                                            str2 = "SwanAppFile";
                                            stackTraceString = Log.getStackTraceString(e2);
                                            Log.e(str2, stackTraceString);
                                            long currentTimeMillis2 = System.currentTimeMillis();
                                            if (a) {
                                            }
                                            return stringBuffer.toString();
                                        }
                                    }
                                    ik4.d(bufferedReader);
                                    long currentTimeMillis22 = System.currentTimeMillis();
                                    if (a) {
                                    }
                                    return stringBuffer.toString();
                                } catch (Throwable th) {
                                    th = th;
                                    if (fileLock != null) {
                                        try {
                                            fileLock.release();
                                        } catch (IOException e3) {
                                            Log.e("SwanAppFile", Log.getStackTraceString(e3));
                                            throw th;
                                        }
                                    }
                                    ik4.d(bufferedReader);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                fileLock = lock;
                                if (fileLock != null) {
                                }
                                ik4.d(bufferedReader);
                                throw th;
                            }
                        }
                        if (a) {
                            Log.d("SwanAppFile", "Read file: " + stringBuffer.toString());
                        }
                        if (lock != null) {
                            try {
                                lock.release();
                            } catch (IOException e4) {
                                str2 = "SwanAppFile";
                                stackTraceString = Log.getStackTraceString(e4);
                                Log.e(str2, stackTraceString);
                                long currentTimeMillis222 = System.currentTimeMillis();
                                if (a) {
                                }
                                return stringBuffer.toString();
                            }
                        }
                        ik4.d(bufferedReader);
                    } catch (IOException e5) {
                        e = e5;
                        bufferedReader = null;
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = null;
                    }
                } catch (IOException e6) {
                    e = e6;
                    bufferedReader = null;
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader = null;
                }
                long currentTimeMillis2222 = System.currentTimeMillis();
                if (a) {
                    Log.d("SwanAppFile", "Read file done: cost time = " + (currentTimeMillis2222 - currentTimeMillis) + "ms");
                }
                return stringBuffer.toString();
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00c2 A[Catch: all -> 0x00f5, TRY_LEAVE, TryCatch #2 {, blocks: (B:6:0x0007, B:8:0x0012, B:10:0x0016, B:28:0x007d, B:32:0x008b, B:49:0x00ba, B:51:0x00c2, B:31:0x0082, B:56:0x00e3, B:60:0x00f1, B:61:0x00f4, B:59:0x00e8, B:44:0x00a9, B:48:0x00b7, B:47:0x00ae), top: B:73:0x0007, inners: #1, #4, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @SuppressLint({"SwanDebugLog"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized boolean b(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        FileChannel fileChannel;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65538, null, str, str2, z)) == null) {
            synchronized (hn2.class) {
                long currentTimeMillis = System.currentTimeMillis();
                boolean z2 = false;
                if (TextUtils.isEmpty(str) && a) {
                    Log.w("SwanAppFile", "path name is null");
                    return false;
                }
                FileLock fileLock = null;
                try {
                    File file = new File(str);
                    File file2 = new File(file.getParent());
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    FileChannel channel = new FileOutputStream(file, z).getChannel();
                    try {
                        fileLock = channel.lock();
                        if (TextUtils.isEmpty(str2)) {
                            str2 = "";
                        }
                        channel.write(ByteBuffer.wrap(str2.getBytes()));
                        z2 = true;
                        if (a) {
                            Log.d("SwanAppFile", "Write file：" + str2);
                        }
                        if (fileLock != null) {
                            try {
                                fileLock.release();
                            } catch (IOException e) {
                                Log.e("SwanAppFile", Log.getStackTraceString(e));
                            }
                        }
                        ik4.d(channel);
                    } catch (IOException e2) {
                        fileChannel = channel;
                        e = e2;
                        try {
                            Log.e("SwanAppFile", Log.getStackTraceString(e));
                            if (fileLock != null) {
                                try {
                                    fileLock.release();
                                } catch (IOException e3) {
                                    Log.e("SwanAppFile", Log.getStackTraceString(e3));
                                }
                            }
                            ik4.d(fileChannel);
                            long currentTimeMillis2 = System.currentTimeMillis();
                            if (a) {
                            }
                            return z2;
                        } catch (Throwable th) {
                            th = th;
                            if (fileLock != null) {
                                try {
                                    fileLock.release();
                                } catch (IOException e4) {
                                    Log.e("SwanAppFile", Log.getStackTraceString(e4));
                                }
                            }
                            ik4.d(fileChannel);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        fileChannel = channel;
                        th = th2;
                        if (fileLock != null) {
                        }
                        ik4.d(fileChannel);
                        throw th;
                    }
                } catch (IOException e5) {
                    e = e5;
                    fileChannel = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileChannel = null;
                }
                long currentTimeMillis22 = System.currentTimeMillis();
                if (a) {
                    Log.d("SwanAppFile", "Write file done: cost time =" + (currentTimeMillis22 - currentTimeMillis) + "ms");
                }
                return z2;
            }
        }
        return invokeLLZ.booleanValue;
    }
}
