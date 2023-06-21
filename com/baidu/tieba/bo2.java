package com.baidu.tieba;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.system.Os;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.io.FileUtils;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.baidu.tieba.jo2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.performance.ZeusPerformanceTiming;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class bo2 extends bk3 {
    public static /* synthetic */ Interceptable $ic;
    public static List<String> f;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public String b;
    public final ck3 c;
    public final dk3 d;
    public final String e;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947651620, "Lcom/baidu/tieba/bo2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947651620, "Lcom/baidu/tieba/bo2;");
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        f = arrayList;
        arrayList.add("ascii");
        f.add("base64");
        f.add("binary");
        f.add("hex");
        f.add("utf-8");
        f.add("utf8");
        f.add("latin1");
        f.add("ucs2");
        f.add("ucs-2");
        f.add("utf16le");
        f.add("utf-16le");
    }

    public bo2(Context context, String str, @NonNull ck3 ck3Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, ck3Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context;
        this.b = str;
        this.c = ck3Var;
        this.d = ck3Var.d();
        this.e = new File(this.c.f(), "record.pro").getAbsolutePath();
    }

    public yn2 A(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
            yn2 x = jo2.x(str, jo2.G("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true), "fail parameter error: parameter.zipFilePath should be String instead of Object;");
            if (x != null) {
                return x;
            }
            yn2 x2 = jo2.x(str2, jo2.G("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true), "fail parameter error: parameter.targetPath should be String instead of Object;");
            if (x2 != null) {
                return x2;
            }
            if (!str2.startsWith("bdfile://tmp") && !str2.startsWith(wn2.USER_DATA_PATH)) {
                return d(-1, "fail permission denied, open " + str2);
            }
            String L = jo2.L(str);
            if (!this.c.j(L, true)) {
                return d(-4, jo2.G("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
            }
            if (!jo2.V(str2)) {
                return d(-4, jo2.G("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
            }
            if (m(str2)) {
                return d(-1, jo2.G("fail permission denied, ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
            }
            String g = g(L);
            String g2 = g(str2);
            if (TextUtils.isEmpty(g)) {
                return d(-1, jo2.G("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
            }
            if (TextUtils.isEmpty(g2)) {
                return d(-1, jo2.G("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
            }
            File file = new File(g);
            if (!file.exists()) {
                return d(-1, jo2.G("fail no such file or directory ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
            }
            if (!g.endsWith(".zip")) {
                return d(-1, "fail unzip failed");
            }
            if (!file.isFile()) {
                return d(-1, jo2.G("fail permission denied, ", ZeusPerformanceTiming.KEY_UNZIP, str, str2, true));
            }
            File file2 = new File(g2);
            if (!file2.exists()) {
                file2.mkdirs();
            } else if (file2.isFile()) {
                return d(-1, "fail unzip failed");
            }
            List<String> o = jo2.o(g2, true);
            if (!ds4.U(g, g2)) {
                return d(-1, "fail unzip failed");
            }
            if (str2.startsWith(wn2.USER_DATA_PATH)) {
                List<String> o2 = jo2.o(g2, true);
                ArrayList arrayList = new ArrayList(o2.size());
                long j = 0;
                for (String str3 : o2) {
                    if (!o.contains(str3)) {
                        arrayList.add(str3);
                        j += jo2.A(str3);
                    }
                }
                if (this.d.a(j)) {
                    jo2.i(arrayList);
                    return d(-1, p());
                }
                this.d.b(j);
            }
            return d(0, DnsModel.MSG_OK);
        }
        return (yn2) invokeLL.objValue;
    }

    public final yn2 j(String str, fo2 fo2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, fo2Var)) == null) {
            String g = g(str);
            if (TextUtils.isEmpty(g)) {
                return d(-1, "fail no such file or directory " + str);
            }
            File file = new File(g);
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    fo2Var.lastAccessedTime = Os.lstat(file.getAbsolutePath()).st_atime;
                    fo2Var.lastModifiedTime = Os.lstat(file.getAbsolutePath()).st_mtime;
                    fo2Var.mode = Os.lstat(file.getAbsolutePath()).st_mode;
                    fo2Var.size = Os.lstat(file.getAbsolutePath()).st_size;
                } catch (Exception e) {
                    e.printStackTrace();
                    return d(-1, "fail");
                }
            } else {
                try {
                    Field declaredField = Class.forName("libcore.io.Libcore").getDeclaredField("os");
                    if (!declaredField.isAccessible()) {
                        declaredField.setAccessible(true);
                    }
                    Object obj = declaredField.get(null);
                    Object invoke = obj.getClass().getMethod("lstat", String.class).invoke(obj, file.getAbsolutePath());
                    Field declaredField2 = invoke.getClass().getDeclaredField("st_atime");
                    if (!declaredField2.isAccessible()) {
                        declaredField2.setAccessible(true);
                    }
                    fo2Var.lastAccessedTime = declaredField2.getLong(invoke);
                    Field declaredField3 = invoke.getClass().getDeclaredField("st_mtime");
                    if (!declaredField3.isAccessible()) {
                        declaredField3.setAccessible(true);
                    }
                    fo2Var.lastModifiedTime = declaredField3.getLong(invoke);
                    Field declaredField4 = invoke.getClass().getDeclaredField("st_mode");
                    if (!declaredField4.isAccessible()) {
                        declaredField4.setAccessible(true);
                    }
                    fo2Var.mode = declaredField4.getInt(invoke);
                    Field declaredField5 = invoke.getClass().getDeclaredField("st_size");
                    if (!declaredField5.isAccessible()) {
                        declaredField5.setAccessible(true);
                    }
                    fo2Var.size = declaredField5.getLong(invoke);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return d(-1, "fail");
                }
            }
            yn2 d = d(0, DnsModel.MSG_OK);
            d.d = fo2Var;
            d.b = DnsModel.MSG_OK;
            return d;
        }
        return (yn2) invokeLL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:102:0x01d2 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:95:0x01df */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0155 A[Catch: all -> 0x01ce, Exception -> 0x01d1, TRY_LEAVE, TryCatch #5 {Exception -> 0x01d1, all -> 0x01ce, blocks: (B:44:0x00f5, B:46:0x00ff, B:48:0x0107, B:50:0x0117, B:53:0x0126, B:56:0x0133, B:58:0x013b, B:61:0x013f, B:63:0x0147, B:65:0x0155, B:68:0x0164, B:70:0x016c, B:72:0x0185, B:71:0x0177, B:78:0x0199, B:80:0x01a5, B:83:0x01b4), top: B:103:0x00f3 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0164 A[Catch: all -> 0x01ce, Exception -> 0x01d1, TRY_ENTER, TryCatch #5 {Exception -> 0x01d1, all -> 0x01ce, blocks: (B:44:0x00f5, B:46:0x00ff, B:48:0x0107, B:50:0x0117, B:53:0x0126, B:56:0x0133, B:58:0x013b, B:61:0x013f, B:63:0x0147, B:65:0x0155, B:68:0x0164, B:70:0x016c, B:72:0x0185, B:71:0x0177, B:78:0x0199, B:80:0x01a5, B:83:0x01b4), top: B:103:0x00f3 }] */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v34 */
    /* JADX WARN: Type inference failed for: r13v35 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r13v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final yn2 B(String str, Object obj, String str2, boolean z) {
        InterceptResult invokeCommon;
        FileOutputStream fileOutputStream;
        long length;
        FileOutputStream fileOutputStream2;
        String str3;
        long length2;
        OutputStreamWriter outputStreamWriter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, obj, str2, Boolean.valueOf(z)})) == null) {
            yn2 n = n(str);
            if (n != null) {
                return n;
            }
            if (obj == null) {
                return d(-1, "The argument must be string or arrayBuffer");
            }
            int length3 = (wn2.USER_DATA_PATH + File.separator).length();
            if (!jo2.V(str)) {
                return d(-4, "fail permission denied, open " + str.substring(length3));
            }
            boolean z2 = obj instanceof byte[];
            String str4 = "utf-8";
            String str5 = str2;
            if (!z2) {
                boolean isEmpty = TextUtils.isEmpty(str2);
                str5 = str2;
                if (isEmpty) {
                    str5 = "utf-8";
                }
            }
            boolean isEmpty2 = TextUtils.isEmpty(str5);
            ?? r13 = str5;
            if (!isEmpty2) {
                boolean equals = "binary".equals(str5.toLowerCase());
                String str6 = str5;
                if (equals) {
                    str6 = "latin1";
                }
                boolean contains = f.contains(str6.toLowerCase());
                r13 = str6;
                if (!contains) {
                    return d(-1, "fail invalid encoding \"" + str6 + "\"");
                }
            }
            yn2 h = h(str, false);
            if (h != null) {
                return h;
            }
            String g = g(str);
            if (TextUtils.isEmpty(g)) {
                return d(-1, "fail no such file or directory " + str.substring(length3));
            }
            File file = new File(g);
            if (file.exists() && file.isDirectory()) {
                return d(-1, " fail illegal operation on a directory, open " + str);
            }
            long z3 = jo2.z(file);
            yn2 d = d(0, DnsModel.MSG_OK);
            BufferedWriter bufferedWriter = null;
            try {
                try {
                    try {
                        if (!z2) {
                            if (!TextUtils.isEmpty((String) obj) && TextUtils.equals("base64", r13)) {
                                byte[] decode = Base64.decode((String) obj, 2);
                                length = decode.length;
                                if (this.d.a(length)) {
                                    yn2 d2 = d(-1, p());
                                    ds4.d(null);
                                    ds4.d(null);
                                    return d2;
                                }
                                FileOutputStream fileOutputStream3 = new FileOutputStream(file, z);
                                fileOutputStream3.write(decode);
                                fileOutputStream3.flush();
                                fileOutputStream2 = fileOutputStream3;
                            } else {
                                String[] u = jo2.u((String) obj, r13);
                                if (u != null && u.length == 2) {
                                    str3 = u[0];
                                    str4 = u[1];
                                    length2 = str3.getBytes().length;
                                    if (!this.d.a(length2)) {
                                        yn2 d3 = d(-1, p());
                                        ds4.d(null);
                                        ds4.d(null);
                                        return d3;
                                    }
                                    if (TextUtils.isEmpty(str4)) {
                                        outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file, z));
                                    } else {
                                        outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file, z), str4.toLowerCase());
                                    }
                                    BufferedWriter bufferedWriter2 = new BufferedWriter(outputStreamWriter);
                                    try {
                                        bufferedWriter2.write(str3);
                                        bufferedWriter2.flush();
                                        length = length2;
                                        fileOutputStream2 = null;
                                        bufferedWriter = bufferedWriter2;
                                    } catch (Exception unused) {
                                        r13 = 0;
                                        bufferedWriter = bufferedWriter2;
                                        d = d(-1, "fail");
                                        fileOutputStream = r13;
                                        ds4.d(bufferedWriter);
                                        ds4.d(fileOutputStream);
                                        return d;
                                    } catch (Throwable th) {
                                        th = th;
                                        r13 = 0;
                                        bufferedWriter = bufferedWriter2;
                                        ds4.d(bufferedWriter);
                                        ds4.d(r13);
                                        throw th;
                                    }
                                }
                                str3 = "";
                                length2 = str3.getBytes().length;
                                if (!this.d.a(length2)) {
                                }
                            }
                        } else {
                            byte[] bArr = (byte[]) obj;
                            length = bArr.length;
                            if (this.d.a(length)) {
                                yn2 d4 = d(-1, p());
                                ds4.d(null);
                                ds4.d(null);
                                return d4;
                            }
                            FileOutputStream fileOutputStream4 = new FileOutputStream(g, z);
                            fileOutputStream4.write(bArr);
                            fileOutputStream4.flush();
                            fileOutputStream2 = fileOutputStream4;
                        }
                        if (z) {
                            this.d.b(length);
                            fileOutputStream = fileOutputStream2;
                        } else {
                            this.d.b(length - z3);
                            fileOutputStream = fileOutputStream2;
                        }
                    } catch (Exception unused2) {
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception unused3) {
                r13 = 0;
            } catch (Throwable th3) {
                th = th3;
                r13 = 0;
            }
            ds4.d(bufferedWriter);
            ds4.d(fileOutputStream);
            return d;
        }
        return (yn2) invokeCommon.objValue;
    }

    public yn2 C(boolean z, String str, Object obj, String str2) {
        InterceptResult invokeCommon;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), str, obj, str2})) == null) {
            if (z) {
                str3 = "filePath must be a string";
            } else {
                str3 = "fail permission denied, open " + str;
            }
            if (z) {
                str4 = " The argument must be string";
            } else {
                str4 = "fail parameter error: parameter.dirPath should be String instead of Object;";
            }
            yn2 x = jo2.x(str, str3, str4);
            if (x != null) {
                return x;
            }
            return B(str, obj, str2, false);
        }
        return (yn2) invokeCommon.objValue;
    }

    public yn2 a(String str, boolean z) {
        InterceptResult invokeLZ;
        String F;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048579, this, str, z)) == null) {
            if (jo2.S(str)) {
                return d(-1, "fail permission denied, open " + str);
            }
            if (z) {
                F = "path must be a string";
            } else {
                F = jo2.F("fail no such file or directory ", "access", str, null);
            }
            if (z) {
                str2 = " The argument must be string";
            } else {
                str2 = "fail parameter error: parameter.path should be String instead of Undefined;";
            }
            yn2 x = jo2.x(str, F, str2);
            if (x != null) {
                return x;
            }
            String L = jo2.L(str);
            if (!this.c.j(L, true)) {
                return d(-4, jo2.F("fail no such file or directory ", "access", str, null));
            }
            String g = g(L);
            if (TextUtils.isEmpty(g)) {
                return d(-1, "fail no such file or directory " + str);
            } else if (!new File(g).exists()) {
                return d(-1, jo2.F("fail no such file or directory ", "access", str, null));
            } else {
                return d(0, DnsModel.MSG_OK);
            }
        }
        return (yn2) invokeLZ.objValue;
    }

    public final yn2 f(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, z)) == null) {
            if (TextUtils.isEmpty(str)) {
                yn2 yn2Var = new yn2();
                yn2Var.a = -1;
                yn2Var.b = "fail no such file or directory " + str;
                return yn2Var;
            }
            String g = g(str);
            if (TextUtils.isEmpty(str)) {
                yn2 yn2Var2 = new yn2();
                yn2Var2.a = -1;
                yn2Var2.b = "fail no such file or directory " + str;
                return yn2Var2;
            }
            File file = new File(g);
            if (!file.exists()) {
                yn2 yn2Var3 = new yn2();
                yn2Var3.a = -1;
                yn2Var3.b = "fail no such file or directory " + str;
                return yn2Var3;
            } else if (z && !file.isFile()) {
                yn2 yn2Var4 = new yn2();
                yn2Var4.a = -1;
                yn2Var4.b = "fail no such file or directory " + str;
                return yn2Var4;
            } else {
                return null;
            }
        }
        return (yn2) invokeLZ.objValue;
    }

    public yn2 z(String str, boolean z) {
        InterceptResult invokeLZ;
        String F;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048604, this, str, z)) == null) {
            if (z) {
                F = "filePath must be a string";
            } else {
                F = jo2.F("fail no such file or directory ", null, str, null);
            }
            if (z) {
                str2 = " The argument must be string";
            } else {
                str2 = "fail parameter error: parameter.filePath should be String instead of Object;";
            }
            yn2 x = jo2.x(str, F, str2);
            if (x != null) {
                return x;
            }
            if (!jo2.W(str)) {
                return d(-4, jo2.F("fail permission denied, open ", null, str, null));
            }
            yn2 f2 = f(str, false);
            if (f2 != null) {
                return f2;
            }
            yn2 n = n(str);
            if (n != null) {
                return n;
            }
            String g = g(str);
            if (TextUtils.isEmpty(g)) {
                return d(-1, jo2.F("fail no such file or directory ", null, str, null));
            }
            File file = new File(g);
            if (file.isDirectory()) {
                return d(-1, jo2.F("fail operation not permitted ", "unlink", str, null));
            }
            long A = jo2.A(g);
            try {
                if (file.delete()) {
                    this.d.b(-A);
                    return d(0, DnsModel.MSG_OK);
                }
                return d(-1, jo2.F("fail", null, str, null));
            } catch (Exception unused) {
                return d(-1, jo2.F("fail", null, str, null));
            }
        }
        return (yn2) invokeLZ.objValue;
    }

    public yn2 b(String str, Object obj, String str2, boolean z) {
        InterceptResult invokeCommon;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, obj, str2, Boolean.valueOf(z)})) == null) {
            String F = jo2.F("fail permission denied, open ", null, str, null);
            if (z) {
                str3 = " The argument must be string";
            } else {
                str3 = "fail parameter error: parameter.filePath should be String instead of NULL;";
            }
            yn2 x = jo2.x(str, F, str3);
            if (x != null) {
                return x;
            }
            String L = jo2.L(str);
            if (!"mounted".equals(Environment.getExternalStorageState())) {
                return d(-1, "fail sdcard not mounted ");
            }
            yn2 n = n(L);
            if (n != null) {
                return n;
            }
            if (obj == null) {
                return d(-1, "fail TypeError: data argument must be a string, Buffer, ArrayBuffer, Array, or array-like object");
            }
            String g = g(L);
            if (TextUtils.isEmpty(g)) {
                return d(-1, "fail no such file or directory " + str);
            }
            File file = new File(g);
            if (!file.exists()) {
                return d(-1, jo2.F("fail no such file or directory ", "open", str, null));
            }
            if (file.isDirectory()) {
                return d(-1, "fail illegal operation on a directory, open " + str);
            }
            return B(L, obj, str2, true);
        }
        return (yn2) invokeCommon.objValue;
    }

    public yn2 c(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        yn2 d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048581, this, str, str2, z)) == null) {
            if (jo2.S(str)) {
                return d(-1, "fail permission denied, open " + str);
            } else if (jo2.S(str2)) {
                return d(-1, "fail permission denied, open " + str2);
            } else {
                yn2 x = jo2.x(str, "srcPath must be a string", " The argument must be string");
                if (x != null) {
                    return x;
                }
                yn2 x2 = jo2.x(str2, "destPath must be a string", " The argument must be string");
                if (x2 != null) {
                    return x2;
                }
                String L = jo2.L(str);
                boolean z2 = true;
                if (!this.c.j(L, true)) {
                    return d(-4, jo2.F("fail no such file or directory ", "copyFile", str, null));
                }
                String L2 = jo2.L(str2);
                if (!jo2.V(L2)) {
                    return d(-4, jo2.F("fail permission denied, open ", "copyFile", str2, null));
                }
                yn2 n = n(L2);
                if (n != null) {
                    return n;
                }
                String g = g(L);
                if (TextUtils.isEmpty(g)) {
                    return d(-1, "fail no such file or directory " + str);
                }
                File file = new File(g);
                if (file.exists() && file.isFile()) {
                    yn2 h = h(L2, false);
                    if (h != null) {
                        h.b = jo2.F("fail no such file or directory ", "copyFile", str2, null);
                        return h;
                    } else if (L2.endsWith(File.separator)) {
                        return d(-1, jo2.F("fail permission denied, ", "copyFile", str, str2));
                    } else {
                        String g2 = g(L2);
                        if (TextUtils.isEmpty(g2)) {
                            return d(-1, "fail no such file or directory " + str2);
                        }
                        File file2 = new File(g2);
                        if (file2.exists() && file2.isDirectory()) {
                            if (k(file2.listFiles())) {
                                return d(-1, jo2.F("fail permission denied, ", "copyFile", str, str2));
                            }
                            try {
                                file2.delete();
                            } catch (Exception unused) {
                                return d(-1, "fail");
                            }
                        }
                        long A = jo2.A(g);
                        z2 = (L.equals(L2) || L.startsWith(wn2.USER_DATA_PATH)) ? false : false;
                        if (z2 && this.d.a(A)) {
                            return d(-1, p());
                        }
                        if (!L.equals(L2)) {
                            d = w(L, L2);
                        } else {
                            d = d(0, DnsModel.MSG_OK);
                        }
                        if (z2 && d != null && d.a == 0) {
                            this.d.b(A);
                        }
                        return d;
                    }
                }
                return d(-1, jo2.F("fail no such file or directory ", "copyFile", str, null));
            }
        }
        return (yn2) invokeLLZ.objValue;
    }

    public yn2 q(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048595, this, str, str2, z)) == null) {
            if (z) {
                str3 = "filePath must be a string";
            } else {
                str3 = "fail file not found";
            }
            if (z) {
                str4 = " The argument must be string";
            } else {
                str4 = "fail parameter error: parameter.dirPath should be String instead of NULL;";
            }
            yn2 x = jo2.x(str, str3, str4);
            if (x != null) {
                return x;
            }
            String L = jo2.L(str);
            if (!this.c.j(L, true)) {
                return d(-1, "fail permission denied, open " + str);
            } else if (jo2.S(str)) {
                return d(-1, "fail permission denied, open " + str);
            } else {
                yn2 f2 = f(L, true);
                if (f2 != null) {
                    f2.b = jo2.F("fail no such file or directory ", "open", str, null);
                    return f2;
                }
                boolean isEmpty = TextUtils.isEmpty(str2);
                if (!isEmpty) {
                    str2 = str2.toLowerCase();
                    if ("binary".equals(str2)) {
                        str2 = "latin1";
                    }
                }
                if (!isEmpty && !f.contains(str2)) {
                    return d(-1, "fail Error: Unknown encoding: " + str2);
                }
                String g = g(L);
                if (TextUtils.isEmpty(g)) {
                    return d(-1, "fail no such file or directory " + str);
                }
                File file = new File(g);
                byte[] bArr = new byte[0];
                yn2 d = d(0, DnsModel.MSG_OK);
                try {
                    String str5 = "";
                    if (TextUtils.isEmpty(str2)) {
                        bArr = jo2.q(g);
                    } else if ("base64".equals(str2)) {
                        bArr = jo2.q(g);
                        if (bArr.length != 0) {
                            str5 = Base64.encodeToString(bArr, 2);
                        }
                    } else {
                        str5 = "hex".equals(str2) ? jo2.n(g) : r(new FileInputStream(file), str2);
                    }
                    if (TextUtils.isEmpty(str2)) {
                        d.h = bArr;
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(str5);
                        d.c = arrayList;
                    }
                    return d;
                } catch (Exception e) {
                    e.printStackTrace();
                    return d(-1, "fail");
                }
            }
        }
        return (yn2) invokeLLZ.objValue;
    }

    public yn2 u(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        String F;
        String str3;
        String F2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048599, this, str, str2, z)) == null) {
            if (jo2.S(str)) {
                return d(-1, "fail permission denied, open " + str);
            } else if (jo2.S(str2)) {
                return d(-1, "fail permission denied, open " + str2);
            } else {
                if (z) {
                    F = "oldPath must be a string";
                } else {
                    F = jo2.F("fail no such file or directory ", DownloadStatisticConstants.UBC_VALUE_RENAME, str, null);
                }
                String str4 = " The argument must be string";
                if (z) {
                    str3 = " The argument must be string";
                } else {
                    str3 = "fail parameter error: parameter.oldPath should be String instead of Undefined;";
                }
                yn2 x = jo2.x(str, F, str3);
                if (x != null) {
                    return x;
                }
                if (z) {
                    F2 = "newPath must be a string";
                } else {
                    F2 = jo2.F("fail no such file or directory ", DownloadStatisticConstants.UBC_VALUE_RENAME, str2, null);
                }
                if (!z) {
                    str4 = "fail parameter error: parameter.newPath should be String instead of Undefined;";
                }
                yn2 x2 = jo2.x(str2, F2, str4);
                if (x2 != null) {
                    return x2;
                }
                String L = jo2.L(str);
                yn2 n = n(L);
                if (n != null) {
                    n.b = jo2.F("fail permission denied, ", DownloadStatisticConstants.UBC_VALUE_RENAME, str, str2);
                    return n;
                }
                String L2 = jo2.L(str2);
                yn2 n2 = n(L2);
                if (n2 != null) {
                    n2.b = jo2.F("fail permission denied, ", DownloadStatisticConstants.UBC_VALUE_RENAME, str, str2);
                    return n2;
                }
                yn2 f2 = f(L, false);
                if (f2 != null) {
                    f2.b = jo2.F("fail no such file or directory ", DownloadStatisticConstants.UBC_VALUE_RENAME, str, str2);
                    return f2;
                } else if (jo2.V(L) && jo2.V(L2)) {
                    yn2 h = h(L2, false);
                    if (h != null) {
                        h.b = jo2.F("fail no such file or directory ", DownloadStatisticConstants.UBC_VALUE_RENAME, str, str2);
                        return h;
                    }
                    String g = g(L);
                    if (TextUtils.isEmpty(g)) {
                        return d(-1, "fail no such file or directory " + str);
                    }
                    String g2 = g(L2);
                    if (TextUtils.isEmpty(g2)) {
                        return d(-1, "fail no such file or directory " + str2);
                    }
                    File file = new File(g);
                    File file2 = new File(g2);
                    boolean exists = file2.exists();
                    if (jo2.U(file, file2) && (!file.isDirectory() || exists || !m(g2))) {
                        try {
                            if ((file2.isDirectory() && file2.listFiles() != null && file2.listFiles().length > 0) || !file.renameTo(file2)) {
                                return d(-1, "fail rename failed");
                            }
                            return d(0, DnsModel.MSG_OK);
                        } catch (Exception unused) {
                            return d(-1, "fail");
                        }
                    }
                    return d(-1, "fail rename failed");
                } else {
                    return d(-4, jo2.F("fail permission denied, ", DownloadStatisticConstants.UBC_VALUE_RENAME, str, str2));
                }
            }
        }
        return (yn2) invokeLLZ.objValue;
    }

    public yn2 x(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048602, this, str, str2, z)) == null) {
            if (z) {
                str3 = "tempFilePath must be a string";
            } else {
                str3 = "fail tempFilePath file not exist";
            }
            if (z) {
                str4 = " The argument must be string";
            } else {
                str4 = "fail parameter error: parameter.tempFilePath should be String instead of Object;";
            }
            yn2 x = jo2.x(str, str3, str4);
            if (x != null) {
                return x;
            }
            String L = jo2.L(str2);
            if (TextUtils.isEmpty(L)) {
                L = wn2.USER_DATA_PATH + File.separator + ds4.s(str);
            }
            if (!L.startsWith(wn2.USER_DATA_PATH)) {
                return d(-1, jo2.F("fail permission denied, open ", null, str2, null));
            }
            if (!this.c.l(str)) {
                return d(-4, "fail it is not a tempFilePath");
            }
            yn2 h = h(L, false);
            if (h != null) {
                return h;
            }
            yn2 h2 = h(str, false);
            if (h2 != null) {
                return h2;
            }
            String g = g(L);
            if (TextUtils.isEmpty(g)) {
                return d(-1, "fail no such file or directory " + str2);
            }
            File file = new File(g);
            if (!wn2.USER_DATA_PATH.equals(L) && (!file.exists() || !file.isDirectory())) {
                yn2 f2 = f(str, true);
                if (f2 != null) {
                    f2.b = "fail no such file or directory ";
                    return f2;
                }
                String g2 = g(str);
                if (TextUtils.isEmpty(g2)) {
                    return d(-1, "fail no such file or directory " + str);
                }
                long A = jo2.A(g2);
                if (this.d.a(A)) {
                    return d(-1, p());
                }
                if (L.startsWith(wn2.USER_DATA_PATH) && !jo2.R(L) && !jo2.R(str)) {
                    yn2 h3 = h(L, false);
                    if (h3 != null) {
                        return h3;
                    }
                    yn2 n = n(L);
                    if (n != null) {
                        return n;
                    }
                    yn2 w = w(str, L);
                    if (w != null && w.a == 0) {
                        this.d.b(A);
                        if (TextUtils.isEmpty(str)) {
                            return d(-1, jo2.F("fail no such file or directory ", null, str, null));
                        }
                        File file2 = new File(g2);
                        if (file2.exists()) {
                            file2.delete();
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(L);
                        w.c = arrayList;
                        w.b = DnsModel.MSG_OK;
                    }
                    return w;
                }
                return d(-1, jo2.F("fail permission denied, open ", null, str2, null));
            }
            return d(-1, jo2.F("fail Error: EISDIR: illegal operation on a directory, open ", null, str2, null));
        }
        return (yn2) invokeLLZ.objValue;
    }

    public final yn2 d(int i, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i, str)) == null) {
            yn2 yn2Var = new yn2();
            yn2Var.a = i;
            yn2Var.b = str;
            return yn2Var;
        }
        return (yn2) invokeIL.objValue;
    }

    public yn2 e(String str) {
        InterceptResult invokeL;
        long j;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            yn2 x = jo2.x(str, "fail file not exist", "fail parameter error: parameter.filePath should be String instead of Undefined;");
            if (x != null) {
                return x;
            }
            String L = jo2.L(str);
            if (!this.c.j(L, true)) {
                return d(-4, "fail file not exist");
            }
            String g = g(L);
            if (TextUtils.isEmpty(g)) {
                return d(-1, "fail no such file or directory " + str);
            }
            File file = new File(g);
            if (!file.exists()) {
                return d(-1, "fail file not exist");
            }
            if (file.isDirectory()) {
                return d(-1, "fail " + str + " is directory");
            }
            yn2 d = d(0, DnsModel.MSG_OK);
            if (file.exists()) {
                j = file.length();
            } else {
                j = 0;
            }
            d.e = j;
            if (file.exists()) {
                str2 = fs4.b(file, false);
            } else {
                str2 = null;
            }
            d.g = str2;
            return d;
        }
        return (yn2) invokeL.objValue;
    }

    public final String g(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (str.startsWith("bdfile://code")) {
                if (this.b.endsWith(File.separator)) {
                    String str3 = this.b;
                    str2 = str3.substring(0, str3.length() - 1);
                } else {
                    str2 = this.b;
                }
                this.b = str2;
                return this.b + str.substring(13);
            } else if (!str.startsWith(WebGLImageLoader.BDFILE)) {
                return "";
            } else {
                return this.c.i(str);
            }
        }
        return (String) invokeL.objValue;
    }

    public yn2 t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
            yn2 x = jo2.x(str, "fail file not exist", "fail parameter error: parameter.filePath should be String instead of Object;");
            if (x != null) {
                return x;
            }
            if (n(str) != null) {
                return d(-4, "fail file not exist");
            }
            String g = g(str);
            if (TextUtils.isEmpty(g)) {
                return d(-1, "fail no such file or directory " + str);
            }
            File file = new File(g);
            if (file.exists() && !file.isDirectory()) {
                long A = jo2.A(g);
                try {
                    if (!file.delete()) {
                        return d(-1, "fail");
                    }
                    this.d.b(-A);
                    return d(0, DnsModel.MSG_OK);
                } catch (Exception unused) {
                    return d(-1, "fail");
                }
            }
            return d(-1, "fail file not exist");
        }
        return (yn2) invokeL.objValue;
    }

    public final yn2 h(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048586, this, str, z)) == null) {
            if (str.endsWith(File.separator)) {
                str = str.substring(0, str.length() - 1);
            }
            String g = g(str);
            if (TextUtils.isEmpty(g)) {
                return d(-1, "fail no such file or directory " + str);
            } else if (g.contains(File.separator)) {
                File file = new File(g.substring(0, g.lastIndexOf(File.separator)));
                if (!z) {
                    if (!file.exists() || (file.exists() && file.isFile())) {
                        return d(-1, "fail no such file or directory " + str);
                    }
                    return null;
                }
                return null;
            } else {
                return null;
            }
        }
        return (yn2) invokeLZ.objValue;
    }

    public yn2 y(String str, boolean z) {
        InterceptResult invokeLZ;
        String F;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048603, this, str, z)) == null) {
            if (z) {
                F = "path must be a string";
            } else {
                F = jo2.F("fail no such file or directory ", null, str, null);
            }
            if (z) {
                str2 = " The argument must be string";
            } else {
                str2 = "fail parameter error: parameter.path should be String instead of Object;";
            }
            yn2 x = jo2.x(str, F, str2);
            if (x != null) {
                return x;
            }
            if (!this.c.l(str) && !this.c.b(str)) {
                return d(-1, "fail permission denied, open " + str);
            }
            yn2 f2 = f(str, false);
            if (f2 != null) {
                return f2;
            }
            fo2 fo2Var = new fo2();
            String g = g(str);
            if (TextUtils.isEmpty(g)) {
                return d(-1, jo2.F("fail no such file or directory ", null, str, null));
            }
            File file = new File(g);
            fo2Var.a(file.isDirectory());
            fo2Var.b(file.isFile());
            return j(str, fo2Var);
        }
        return (yn2) invokeLZ.objValue;
    }

    public yn2 i() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            String g = g(wn2.USER_DATA_PATH);
            if (TextUtils.isEmpty(g)) {
                return d(-1, "path must be a string");
            }
            String f2 = this.c.f();
            ArrayList arrayList = new ArrayList();
            for (String str : jo2.o(g, false)) {
                if (!TextUtils.equals(str, this.e)) {
                    File file = new File(str);
                    zn2 zn2Var = new zn2();
                    long j2 = 0;
                    if (file.exists()) {
                        j = file.lastModified();
                    } else {
                        j = 0;
                    }
                    zn2Var.createTime = j;
                    String absolutePath = file.getAbsolutePath();
                    if (file.exists() && !TextUtils.isEmpty(absolutePath) && !TextUtils.isEmpty(f2) && absolutePath.startsWith(f2)) {
                        zn2Var.filePath = this.c.g(absolutePath);
                    }
                    if (file.exists()) {
                        j2 = file.length();
                    }
                    zn2Var.size = j2;
                    arrayList.add(zn2Var);
                }
            }
            yn2 d = d(0, DnsModel.MSG_OK);
            d.f = arrayList;
            return d;
        }
        return (yn2) invokeV.objValue;
    }

    public final boolean k(File[] fileArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, fileArr)) == null) {
            if (fileArr != null && fileArr.length != 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            if (TextUtils.isEmpty(str) || !str.contains(".")) {
                return false;
            }
            String[] split = str.split("\\.");
            if (split.length != 2 || TextUtils.isEmpty(split[0]) || TextUtils.isEmpty(split[1])) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (str.contains(File.separator)) {
                return l(str.substring(str.lastIndexOf(File.separator) + 1));
            }
            return l(str);
        }
        return invokeL.booleanValue;
    }

    public final yn2 n(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            yn2 d = d(-1, "fail permission denied, open " + str);
            if (TextUtils.isEmpty(str)) {
                return d;
            }
            if (jo2.S(str)) {
                return d;
            }
            if (str.startsWith(wn2.USER_DATA_PATH)) {
                return null;
            }
            return d;
        }
        return (yn2) invokeL.objValue;
    }

    public yn2 o(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        String str2;
        String str3;
        boolean mkdir;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (z2) {
                str2 = "dirPath must be a string";
            } else {
                str2 = "fail permission denied, open " + str;
            }
            if (z2) {
                str3 = " The argument must be string";
            } else {
                str3 = "fail parameter error: parameter.dirPath should be String instead of Object;";
            }
            yn2 x = jo2.x(str, str2, str3);
            if (x != null) {
                return x;
            }
            yn2 n = n(str);
            if (n != null) {
                return n;
            }
            if (!jo2.V(str)) {
                return d(-4, "fail permission denied, open " + str);
            }
            String g = g(str);
            if (TextUtils.isEmpty(g)) {
                return d(-1, "fail no such file or directory " + str);
            }
            yn2 h = h(str, z);
            if (h != null) {
                return h;
            }
            File file = new File(g);
            if (file.exists()) {
                return d(-1, "fail file already exists " + str);
            }
            try {
                if (z) {
                    mkdir = file.mkdirs();
                } else {
                    mkdir = file.mkdir();
                }
                if (!mkdir) {
                    return d(-1, "fail");
                }
                return d(0, DnsModel.MSG_OK);
            } catch (Exception unused) {
                return d(-1, "fail");
            }
        }
        return (yn2) invokeCommon.objValue;
    }

    public yn2 v(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        String str2;
        String str3;
        boolean f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (z2) {
                str2 = "dirPath must be a string";
            } else {
                str2 = "fail permission denied, open " + str;
            }
            if (z2) {
                str3 = " The argument must be string";
            } else {
                str3 = "fail parameter error: parameter.dirPath should be String instead of Object;";
            }
            yn2 x = jo2.x(str, str2, str3);
            if (x != null) {
                return x;
            }
            yn2 n = n(str);
            if (n != null) {
                return n;
            }
            if (!jo2.W(str)) {
                return d(-4, "fail permission denied, open " + str);
            }
            String g = g(str);
            if (TextUtils.isEmpty(g)) {
                return d(-1, "fail no such file or directory " + str);
            }
            File file = new File(g);
            if (file.exists() && !file.isFile()) {
                boolean k = k(file.listFiles());
                try {
                    if (!z && k) {
                        return d(-1, "fail directory not empty ");
                    }
                    if (!z) {
                        long z3 = jo2.z(file);
                        f2 = file.delete();
                        if (f2) {
                            this.d.b(-z3);
                        }
                    } else {
                        jo2.b bVar = new jo2.b();
                        f2 = jo2.f(file, bVar);
                        this.d.b(-bVar.a);
                    }
                    if (!f2) {
                        return d(-1, "fail");
                    }
                    return d(0, DnsModel.MSG_OK);
                } catch (Exception unused) {
                    return d(-1, "fail");
                }
            }
            return d(-1, "fail no such file or directory " + str);
        }
        return (yn2) invokeCommon.objValue;
    }

    public final String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            String n = ds4.n(this.d.getMaxSize());
            return String.format("fail file size over %s", (TextUtils.isEmpty(n) || TextUtils.equals(n, FileUtils.UNKNOW)) ? "" : "");
        }
        return (String) invokeV.objValue;
    }

    public final String r(FileInputStream fileInputStream, String str) {
        InterceptResult invokeLL;
        InputStreamReader inputStreamReader;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, fileInputStream, str)) == null) {
            if (fileInputStream == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            try {
                if (TextUtils.isEmpty(str)) {
                    inputStreamReader = new InputStreamReader(fileInputStream);
                } else {
                    inputStreamReader = new InputStreamReader(fileInputStream, str);
                }
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                char[] cArr = new char[1024];
                while (true) {
                    int read = bufferedReader.read(cArr);
                    if (read != -1) {
                        sb.append(cArr, 0, read);
                    } else {
                        return sb.toString();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            } finally {
                ds4.d(fileInputStream);
            }
        } else {
            return (String) invokeLL.objValue;
        }
    }

    public yn2 s(String str, boolean z) {
        InterceptResult invokeLZ;
        String str2;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048597, this, str, z)) == null) {
            if (z) {
                str2 = "dirPath must be a string";
            } else {
                str2 = "fail permission denied, open " + str;
            }
            if (z) {
                str3 = " The argument must be string";
            } else {
                str3 = "fail parameter error: parameter.dirPath should be String instead of Object;";
            }
            yn2 x = jo2.x(str, str2, str3);
            if (x != null) {
                return x;
            }
            String L = jo2.L(str);
            if (!jo2.W(L)) {
                return d(-4, "fail permission denied, open " + str);
            }
            String g = g(L);
            if (TextUtils.isEmpty(g)) {
                return d(-1, "fail no such file or directory " + str);
            }
            File file = new File(g);
            if (!file.exists()) {
                return d(-1, "fail no such file or directory " + str);
            } else if (!file.isDirectory()) {
                return d(-1, "fail no such file or directory " + str);
            } else {
                File[] listFiles = file.listFiles();
                ArrayList arrayList = new ArrayList();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        if (file2 != null && file2.exists() && !TextUtils.equals(file2.getAbsolutePath(), this.e)) {
                            arrayList.add(ds4.s(file2.getAbsolutePath()));
                        }
                    }
                }
                yn2 d = d(0, DnsModel.MSG_OK);
                d.c = arrayList;
                return d;
            }
        }
        return (yn2) invokeLZ.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final yn2 w(String str, String str2) {
        InterceptResult invokeLL;
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048601, this, str, str2)) == null) {
            if (jo2.S(str)) {
                return d(-1, "fail permission denied, open " + str);
            }
            String g = g(str);
            String g2 = g(str2);
            FileInputStream fileInputStream = null;
            if (TextUtils.isEmpty(g)) {
                return d(-1, jo2.F("fail no such file or directory ", null, str, null));
            }
            if (TextUtils.isEmpty(g2)) {
                return d(-1, jo2.F("fail no such file or directory ", null, str2, null));
            }
            yn2 d = d(0, DnsModel.MSG_OK);
            try {
                File file = new File(g2);
                FileInputStream fileInputStream2 = new FileInputStream(new File(g));
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = fileInputStream2.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream.write(bArr, 0, read);
                            fileOutputStream.flush();
                        }
                        ds4.d(fileInputStream2);
                        ds4.d(fileOutputStream);
                        if (!TextUtils.isEmpty(str2)) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(str2);
                            d.c = arrayList;
                        } else {
                            d.b = "fail";
                            d.a = -1;
                        }
                        return d;
                    } catch (IOException e) {
                        e = e;
                        fileInputStream = fileInputStream2;
                        try {
                            e.printStackTrace();
                            yn2 d2 = d(-1, "fail");
                            ds4.d(fileInputStream);
                            ds4.d(fileOutputStream);
                            if (!TextUtils.isEmpty("")) {
                                ArrayList arrayList2 = new ArrayList();
                                arrayList2.add(str2);
                                d.c = arrayList2;
                            } else {
                                d.b = "fail";
                                d.a = -1;
                            }
                            return d2;
                        } catch (Throwable th) {
                            th = th;
                            ds4.d(fileInputStream);
                            ds4.d(fileOutputStream);
                            if (TextUtils.isEmpty("")) {
                                ArrayList arrayList3 = new ArrayList();
                                arrayList3.add(str2);
                                d.c = arrayList3;
                            } else {
                                d.b = "fail";
                                d.a = -1;
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        ds4.d(fileInputStream);
                        ds4.d(fileOutputStream);
                        if (TextUtils.isEmpty("")) {
                        }
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                    fileOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                }
            } catch (IOException e3) {
                e = e3;
                fileOutputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
            }
        } else {
            return (yn2) invokeLL.objValue;
        }
    }
}
