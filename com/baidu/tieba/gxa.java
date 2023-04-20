package com.baidu.tieba;

import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.webkit.internal.RC4;
import com.yy.hiidostatis.inner.util.cipher.Coder;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import org.apache.commons.codec.digest4util.MessageDigestAlgorithms;
/* loaded from: classes4.dex */
public abstract class gxa {
    public static /* synthetic */ Interceptable $ic;
    public static final String[] a;
    public static final String[] b;
    public static final String[] c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947810681, "Lcom/baidu/tieba/gxa;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947810681, "Lcom/baidu/tieba/gxa;");
                return;
            }
        }
        a = new String[]{"TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA"};
        b = new String[]{"TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384"};
        c = new String[]{"TLS_RSA", "CBC", "TEA", "SHA0", MessageDigestAlgorithms.MD2, "MD4", "RIPEMD", "NULL", RC4.LOGTAG, Coder.KEY_DES, "DESX", "DES40", "RC2", "MD5", "ANON", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV"};
    }

    public static boolean a(SSLSocket sSLSocket) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, sSLSocket)) == null) {
            if (sSLSocket == null) {
                return false;
            }
            return b(sSLSocket, c);
        }
        return invokeL.booleanValue;
    }

    public static void c(SSLSocket sSLSocket) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, sSLSocket) == null) && sSLSocket != null && !g(sSLSocket)) {
            a(sSLSocket);
        }
    }

    public static boolean g(SSLSocket sSLSocket) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, sSLSocket)) == null) {
            if (sSLSocket == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT > 19) {
                return h(sSLSocket, b);
            }
            return h(sSLSocket, a);
        }
        return invokeL.booleanValue;
    }

    public static boolean b(SSLSocket sSLSocket, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, sSLSocket, strArr)) == null) {
            if (sSLSocket == null) {
                return false;
            }
            String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
            ArrayList arrayList = new ArrayList();
            int length = enabledCipherSuites.length;
            int i = 0;
            while (true) {
                boolean z = true;
                if (i >= length) {
                    break;
                }
                String str = enabledCipherSuites[i];
                String upperCase = str.toUpperCase(Locale.ENGLISH);
                int length2 = strArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length2) {
                        if (upperCase.contains(strArr[i2].toUpperCase(Locale.ENGLISH))) {
                            break;
                        }
                        i2++;
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    arrayList.add(str);
                }
                i++;
            }
            if (arrayList.isEmpty()) {
                return false;
            }
            sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static boolean h(SSLSocket sSLSocket, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, sSLSocket, strArr)) == null) {
            if (sSLSocket == null) {
                return false;
            }
            String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
            ArrayList arrayList = new ArrayList();
            List asList = Arrays.asList(strArr);
            for (String str : enabledCipherSuites) {
                if (asList.contains(str.toUpperCase(Locale.ENGLISH))) {
                    arrayList.add(str);
                }
            }
            if (arrayList.isEmpty()) {
                return false;
            }
            sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static void d(SSLSocket sSLSocket) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, sSLSocket) != null) || sSLSocket == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            sSLSocket.setEnabledProtocols(new String[]{"TLSv1.3", "TLSv1.2"});
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 16 && i < 29) {
            sSLSocket.setEnabledProtocols(new String[]{"TLSv1.2"});
        } else if (Build.VERSION.SDK_INT < 16) {
            sSLSocket.setEnabledProtocols(new String[]{"TLSv1"});
        }
    }

    public static boolean e(SSLSocket sSLSocket, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, sSLSocket, strArr)) == null) {
            if (sSLSocket != null && strArr != null) {
                try {
                    sSLSocket.setEnabledProtocols(strArr);
                    return true;
                } catch (Exception e) {
                    txa.d("SSLUtil", "setEnabledProtocols: exception : " + e.getMessage());
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static SSLContext f() throws NoSuchAlgorithmException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 29) {
                return SSLContext.getInstance("TLSv1.3");
            }
            if (i >= 16) {
                return SSLContext.getInstance("TLSv1.2");
            }
            return SSLContext.getInstance("TLS");
        }
        return (SSLContext) invokeV.objValue;
    }
}
