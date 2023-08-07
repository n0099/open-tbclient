package com.baidu.tieba;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.common.internal.TransactionIdCreater;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes6.dex */
public class hqb {
    public static /* synthetic */ Interceptable $ic;
    public static final Uri a;
    public static final String[] b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947833776, "Lcom/baidu/tieba/hqb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947833776, "Lcom/baidu/tieba/hqb;");
                return;
            }
        }
        a = Uri.parse("content://com.huawei.hwid");
        b = new String[]{"B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05", "E49D5C2C0E11B3B1B96CA56C6DE2A14EC7DAB5CCC3B5F300D03E5B4DBA44F539"};
    }

    public static int a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            File file = new File(str);
            if (file.exists()) {
                mqb.f("BksUtil", "The directory  has already exists");
                return 1;
            } else if (file.mkdirs()) {
                mqb.b("BksUtil", "create directory  success");
                return 0;
            } else {
                mqb.d("BksUtil", "create directory  failed");
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static String c(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, bArr)) == null) {
            if (bArr != null && bArr.length != 0) {
                StringBuilder sb = new StringBuilder();
                for (byte b2 : bArr) {
                    String hexString = Integer.toHexString(b2 & 255);
                    if (hexString.length() == 1) {
                        sb.append(TransactionIdCreater.FILL_BYTE);
                    }
                    sb.append(hexString);
                }
                return sb.toString();
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    public static String g(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, bArr)) == null) {
            if (bArr == null) {
                return "";
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                messageDigest.update(bArr);
                return c(messageDigest.digest());
            } catch (NoSuchAlgorithmException unused) {
                mqb.d("BksUtil", "inputstraem exception");
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static boolean k(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            return new File(b(context) + File.separator + "hmsrootcas.bks").exists();
        }
        return invokeL.booleanValue;
    }

    public static InputStream n(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, context)) == null) {
            if (k(context)) {
                mqb.e("BksUtil", "getFilesBksIS ");
                try {
                    return new FileInputStream(f(context));
                } catch (FileNotFoundException unused) {
                    mqb.d("BksUtil", "FileNotFoundExceptio: ");
                    return null;
                }
            }
            return null;
        }
        return (InputStream) invokeL.objValue;
    }

    public static String b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                return context.createDeviceProtectedStorageContext().getFilesDir() + File.separator + "aegis";
            }
            return context.getApplicationContext().getFilesDir() + File.separator + "aegis";
        }
        return (String) invokeL.objValue;
    }

    public static String j(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, bArr)) == null) {
            if (bArr == null || bArr.length == 0) {
                return "";
            }
            try {
                return c(MessageDigest.getInstance("SHA-256").digest(bArr));
            } catch (NoSuchAlgorithmException e) {
                Log.e("BksUtil", "NoSuchAlgorithmException" + e.getMessage());
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    public static void d(InputStream inputStream, Context context) {
        FileOutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, inputStream, context) == null) && inputStream != null && context != null) {
            String b2 = b(context);
            if (!new File(b2).exists()) {
                a(b2);
            }
            File file = new File(b2, "hmsrootcas.bks");
            if (file.exists()) {
                file.delete();
            }
            FileOutputStream fileOutputStream2 = null;
            try {
                try {
                    mqb.e("BksUtil", "write output stream ");
                    fileOutputStream = new FileOutputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException unused) {
            }
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = inputStream.read(bArr, 0, 2048);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        lqb.c(fileOutputStream);
                        return;
                    }
                }
            } catch (IOException unused2) {
                fileOutputStream2 = fileOutputStream;
                mqb.d("BksUtil", " IOException");
                lqb.c(fileOutputStream2);
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                lqb.c(fileOutputStream2);
                throw th;
            }
        }
    }

    public static byte[] e(Context context, String str) {
        InterceptResult invokeLL;
        PackageInfo packageInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, context, str)) == null) {
            if (context != null && !TextUtils.isEmpty(str)) {
                try {
                    PackageManager packageManager = context.getPackageManager();
                    if (packageManager != null && (packageInfo = packageManager.getPackageInfo(str, 64)) != null) {
                        return packageInfo.signatures[0].toByteArray();
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    Log.e("BksUtil", "PackageManager.NameNotFoundException : " + e.getMessage());
                } catch (Exception e2) {
                    Log.e("BksUtil", "get pm exception : " + e2.getMessage());
                }
                return new byte[0];
            }
            Log.e("BksUtil", "packageName is null or context is null");
            return new byte[0];
        }
        return (byte[]) invokeLL.objValue;
    }

    public static String f(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            return b(context) + File.separator + "hmsrootcas.bks";
        }
        return (String) invokeL.objValue;
    }

    public static boolean h(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, str)) == null) {
            return "E49D5C2C0E11B3B1B96CA56C6DE2A14EC7DAB5CCC3B5F300D03E5B4DBA44F539".equalsIgnoreCase(j(e(context, str)));
        }
        return invokeLL.booleanValue;
    }

    public static boolean l(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, null, context, str)) == null) {
            byte[] e = e(context, str);
            for (String str2 : b) {
                if (str2.equalsIgnoreCase(j(e))) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean i(String str) {
        InterceptResult invokeL;
        int parseInt;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            mqb.e("BksUtil", "hms version code is : " + str);
            String[] split = str.split("\\.");
            String[] split2 = "4.0.2.300".split("\\.");
            int length = split.length;
            int length2 = split2.length;
            int max = Math.max(length, length2);
            for (int i2 = 0; i2 < max; i2++) {
                if (i2 < length) {
                    try {
                        parseInt = Integer.parseInt(split[i2]);
                    } catch (Exception e) {
                        mqb.d("BksUtil", " exception : " + e.getMessage());
                        if (i2 < length2) {
                            return false;
                        }
                        return true;
                    }
                } else {
                    parseInt = 0;
                }
                if (i2 < length2) {
                    i = Integer.parseInt(split2[i2]);
                } else {
                    i = 0;
                }
                if (parseInt < i) {
                    return false;
                }
                if (parseInt > i) {
                    return true;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:56:0x0100 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.io.OutputStream, java.io.ByteArrayOutputStream] */
    public static synchronized InputStream m(Context context) {
        InterceptResult invokeL;
        InputStream inputStream;
        ByteArrayInputStream byteArrayInputStream;
        String a2;
        String g;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) {
            synchronized (hqb.class) {
                mqb.e("BksUtil", "get bks from tss begin");
                if (context != null) {
                    jqb.b(context);
                }
                Context a3 = jqb.a();
                ByteArrayInputStream byteArrayInputStream2 = null;
                if (a3 == null) {
                    mqb.d("BksUtil", "context is null");
                    return null;
                } else if (!i(nqb.a("com.huawei.hwid")) && !i(nqb.a("com.huawei.hms"))) {
                    mqb.d("BksUtil", "hms version code is too low : " + nqb.a("com.huawei.hwid"));
                    return null;
                } else {
                    boolean l = l(a3, "com.huawei.hwid");
                    ?? r2 = l;
                    if (!l) {
                        boolean h = h(a3, "com.huawei.hms");
                        r2 = h;
                        if (!h) {
                            mqb.d("BksUtil", "hms sign error");
                            return null;
                        }
                    }
                    try {
                        r2 = new ByteArrayOutputStream();
                        try {
                            inputStream = a3.getContentResolver().openInputStream(Uri.withAppendedPath(a, "files/hmsrootcas.bks"));
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int read = inputStream.read(bArr);
                                    if (read <= -1) {
                                        break;
                                    }
                                    r2.write(bArr, 0, read);
                                }
                                r2.flush();
                                byteArrayInputStream = new ByteArrayInputStream(r2.toByteArray());
                            } catch (Exception unused) {
                            }
                            try {
                                a2 = oqb.a("bks_hash", "", a3);
                                g = g(r2.toByteArray());
                            } catch (Exception unused2) {
                                byteArrayInputStream2 = byteArrayInputStream;
                                mqb.d("BksUtil", "Get bks from HMS_VERSION_CODE exception : No content provider");
                                lqb.b(inputStream);
                                lqb.c(r2);
                                lqb.b(byteArrayInputStream2);
                                return n(a3);
                            } catch (Throwable th) {
                                th = th;
                                byteArrayInputStream2 = byteArrayInputStream;
                                lqb.b(inputStream);
                                lqb.c(r2);
                                lqb.b(byteArrayInputStream2);
                                throw th;
                            }
                        } catch (Exception unused3) {
                            inputStream = null;
                        } catch (Throwable th2) {
                            th = th2;
                            inputStream = null;
                        }
                        if (k(a3) && a2.equals(g)) {
                            mqb.e("BksUtil", "bks not update");
                            lqb.b(inputStream);
                            lqb.c(r2);
                            lqb.b(byteArrayInputStream);
                            return n(a3);
                        }
                        mqb.e("BksUtil", "update bks and sp");
                        d(byteArrayInputStream, a3);
                        oqb.c("bks_hash", g, a3);
                        lqb.b(inputStream);
                        lqb.c(r2);
                        lqb.b(byteArrayInputStream);
                        return n(a3);
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
            }
        } else {
            return (InputStream) invokeL.objValue;
        }
    }
}
