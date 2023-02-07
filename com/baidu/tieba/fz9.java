package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes4.dex */
public class fz9 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947781572, "Lcom/baidu/tieba/fz9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947781572, "Lcom/baidu/tieba/fz9;");
                return;
            }
        }
        a = AppConfig.isDebug();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:25:0x0049 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:27:0x004b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:79:0x00b4 */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x008a, code lost:
        if (com.baidu.tieba.fz9.a == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x008c, code lost:
        r5.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00b0, code lost:
        if (com.baidu.tieba.fz9.a == false) goto L49;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x00b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00bf A[Catch: IOException -> 0x00bb, TryCatch #12 {IOException -> 0x00bb, blocks: (B:81:0x00b7, B:85:0x00bf, B:87:0x00c4), top: B:102:0x00b7 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00c4 A[Catch: IOException -> 0x00bb, TRY_LEAVE, TryCatch #12 {IOException -> 0x00bb, blocks: (B:81:0x00b7, B:85:0x00bf, B:87:0x00c4), top: B:102:0x00b7 }] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.baidu.titan.sdk.runtime.Interceptable] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, java.io.File] */
    /* JADX WARN: Type inference failed for: r5v11, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r5v8, types: [java.io.BufferedInputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(File file) {
        ?? r2;
        ?? r3;
        BufferedReader bufferedReader;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            r2 = interceptable;
            r3 = 65537;
            InterceptResult invokeL = r2.invokeL(65537, null, file);
            if (invokeL != null) {
                return (String) invokeL.objValue;
            }
        }
        if (file == 0 || !file.exists()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            try {
                r2 = new FileInputStream((File) file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e) {
            e = e;
            file = 0;
            r2 = 0;
            bufferedReader = null;
        } catch (IOException e2) {
            e = e2;
            file = 0;
            r2 = 0;
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
            r2 = 0;
            r3 = 0;
        }
        try {
            file = new BufferedInputStream(r2);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(file));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    } catch (FileNotFoundException e3) {
                        e = e3;
                        if (a) {
                            e.printStackTrace();
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e4) {
                                e = e4;
                            }
                        }
                        if (file != 0) {
                            file.close();
                        }
                        if (r2 != 0) {
                            r2.close();
                        }
                        return null;
                    } catch (IOException e5) {
                        e = e5;
                        if (a) {
                            e.printStackTrace();
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e6) {
                                e = e6;
                            }
                        }
                        if (file != 0) {
                            file.close();
                        }
                        if (r2 != 0) {
                            r2.close();
                        }
                        return null;
                    }
                }
                String sb2 = sb.toString();
                try {
                    bufferedReader.close();
                    file.close();
                    r2.close();
                } catch (IOException e7) {
                    if (a) {
                        e7.printStackTrace();
                    }
                }
                return sb2;
            } catch (FileNotFoundException e8) {
                e = e8;
                bufferedReader = null;
            } catch (IOException e9) {
                e = e9;
                bufferedReader = null;
            } catch (Throwable th3) {
                r3 = 0;
                th = th3;
                if (r3 != 0) {
                    try {
                        r3.close();
                    } catch (IOException e10) {
                        if (a) {
                            e10.printStackTrace();
                        }
                        throw th;
                    }
                }
                if (file != 0) {
                    file.close();
                }
                if (r2 != 0) {
                    r2.close();
                }
                throw th;
            }
        } catch (FileNotFoundException e11) {
            e = e11;
            file = 0;
            bufferedReader = null;
        } catch (IOException e12) {
            e = e12;
            file = 0;
            bufferedReader = null;
        } catch (Throwable th4) {
            th = th4;
            r3 = 0;
            r2 = r2;
            th = th;
            file = r3;
            if (r3 != 0) {
            }
            if (file != 0) {
            }
            if (r2 != 0) {
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x004d, code lost:
        if (com.baidu.tieba.fz9.a == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x004f, code lost:
        r4.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0064, code lost:
        if (com.baidu.tieba.fz9.a == false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(String str, File file) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, file)) == null) {
            if (TextUtils.isEmpty(str) || !file.exists()) {
                return false;
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException e) {
                e = e;
            } catch (IOException e2) {
                e = e2;
            }
            try {
                fileOutputStream.write(str.getBytes());
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (IOException e3) {
                    if (a) {
                        e3.printStackTrace();
                    }
                }
                return true;
            } catch (FileNotFoundException e4) {
                e = e4;
                fileOutputStream2 = fileOutputStream;
                if (a) {
                    e.printStackTrace();
                }
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e5) {
                        e = e5;
                    }
                }
                return false;
            } catch (IOException e6) {
                e = e6;
                fileOutputStream2 = fileOutputStream;
                if (a) {
                    e.printStackTrace();
                }
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e7) {
                        e = e7;
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e8) {
                        if (a) {
                            e8.printStackTrace();
                        }
                    }
                }
                throw th;
            }
        }
        return invokeLL.booleanValue;
    }
}
