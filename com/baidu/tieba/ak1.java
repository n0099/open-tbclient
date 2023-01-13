package com.baidu.tieba;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
/* loaded from: classes3.dex */
public final class ak1 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            try {
            } catch (Throwable th) {
                tj1.d(th);
            }
            if (!TextUtils.isEmpty(a)) {
                return a;
            }
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            if (packageInfo == null) {
                return "";
            }
            a = b(packageInfo, packageInfo.applicationInfo.sourceDir);
            return a;
        }
        return (String) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String b(PackageInfo packageInfo, String str) {
        InterceptResult invokeLL;
        PublicKey publicKey;
        byte[] encoded;
        Signature[] signatureArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, packageInfo, str)) == null) {
            if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length > 0 && signatureArr[0] != null) {
                try {
                    publicKey = c(signatureArr[0]);
                } catch (Throwable th) {
                    tj1.d(th);
                }
                if (publicKey == null) {
                    publicKey = d(str);
                }
                if (publicKey == null && (encoded = publicKey.getEncoded()) != null) {
                    return xj1.b(Base64.encodeToString(encoded, 0).replace("\n", "").replace("\r", ""));
                }
            }
            publicKey = null;
            if (publicKey == null) {
            }
            return publicKey == null ? "" : "";
        }
        return (String) invokeLL.objValue;
    }

    public static PublicKey c(Signature signature) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, signature)) == null) {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(signature.toByteArray());
            Certificate generateCertificate = certificateFactory.generateCertificate(byteArrayInputStream);
            try {
                byteArrayInputStream.close();
            } catch (Throwable th) {
                tj1.d(th);
            }
            return generateCertificate.getPublicKey();
        }
        return (PublicKey) invokeL.objValue;
    }

    public static PublicKey d(String str) {
        InterceptResult invokeL;
        JarFile jarFile;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                byte[] bArr = new byte[8192];
                try {
                    jarFile = new JarFile(str);
                    try {
                        Enumeration<JarEntry> entries = jarFile.entries();
                        Certificate[] certificateArr = null;
                        while (entries.hasMoreElements()) {
                            JarEntry nextElement = entries.nextElement();
                            if (!nextElement.isDirectory() && !nextElement.getName().startsWith("META-INF/")) {
                                Certificate[] e = e(jarFile, nextElement, bArr);
                                if (e != null && e.length > 0) {
                                    if (certificateArr == null) {
                                        certificateArr = e;
                                    } else {
                                        for (int i = 0; i < certificateArr.length; i++) {
                                            int i2 = 0;
                                            while (true) {
                                                if (i2 < e.length) {
                                                    if (certificateArr[i] != null && certificateArr[i].equals(e[i2])) {
                                                        z = true;
                                                        break;
                                                    }
                                                    i2++;
                                                } else {
                                                    z = false;
                                                    break;
                                                }
                                            }
                                            if (z && certificateArr.length == e.length) {
                                            }
                                            jarFile.close();
                                            jarFile.close();
                                            return null;
                                        }
                                        continue;
                                    }
                                }
                                jarFile.close();
                                jarFile.close();
                                return null;
                            }
                        }
                        jarFile.close();
                        if (certificateArr == null || certificateArr.length <= 0) {
                            return null;
                        }
                        return certificateArr[0].getPublicKey();
                    } catch (Throwable th) {
                        th = th;
                        if (jarFile != null) {
                            jarFile.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    jarFile = null;
                }
            } catch (Throwable th3) {
                tj1.d(th3);
                return null;
            }
        } else {
            return (PublicKey) invokeL.objValue;
        }
    }

    public static Certificate[] e(JarFile jarFile, JarEntry jarEntry, byte[] bArr) {
        InterceptResult invokeLLL;
        BufferedInputStream bufferedInputStream;
        Certificate[] certificateArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, jarFile, jarEntry, bArr)) == null) {
            try {
                bufferedInputStream = new BufferedInputStream(jarFile.getInputStream(jarEntry));
                while (bufferedInputStream.read(bArr, 0, bArr.length) != -1) {
                    try {
                    } catch (Throwable th) {
                        th = th;
                        try {
                            tj1.d(th);
                            return new Certificate[0];
                        } finally {
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (Throwable th2) {
                                    tj1.d(th2);
                                }
                            }
                        }
                    }
                }
                if (jarEntry != null) {
                    certificateArr = jarEntry.getCertificates();
                } else {
                    certificateArr = new Certificate[0];
                }
                try {
                    bufferedInputStream.close();
                } catch (Throwable th3) {
                    tj1.d(th3);
                }
                return certificateArr;
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream = null;
            }
        } else {
            return (Certificate[]) invokeLLL.objValue;
        }
    }
}
