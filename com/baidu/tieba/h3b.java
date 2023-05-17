package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.net.ssl.SSLException;
import okhttp3.CertificatePinner;
/* loaded from: classes5.dex */
public class h3b {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern a;
    public static final String[] b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947774194, "Lcom/baidu/tieba/h3b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947774194, "Lcom/baidu/tieba/h3b;");
                return;
            }
        }
        a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
        String[] strArr = {"ac", "co", "com", Config.EVENT_PATH_MAPPING, "edu", "go", "gouv", "gov", "info", "lg", "ne", "net", "or", "org"};
        b = strArr;
        Arrays.sort(strArr);
    }

    public static final void a(String str, X509Certificate x509Certificate, boolean z) throws SSLException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65537, null, str, x509Certificate, z) == null) {
            String[] d = d(x509Certificate);
            String[] f = f(x509Certificate);
            n3b.b("", "cn is : " + Arrays.toString(d));
            n3b.b("", "san is : " + Arrays.toString(f));
            b(str, d, f, z);
        }
    }

    public static final void b(String str, String[] strArr, String[] strArr2, boolean z) throws SSLException {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, strArr, strArr2, Boolean.valueOf(z)}) == null) {
            LinkedList linkedList = new LinkedList();
            if (strArr != null && strArr.length > 0 && strArr[0] != null) {
                linkedList.add(strArr[0]);
            }
            if (strArr2 != null) {
                for (String str2 : strArr2) {
                    if (str2 != null) {
                        linkedList.add(str2);
                    }
                }
            }
            if (!linkedList.isEmpty()) {
                StringBuffer stringBuffer = new StringBuffer();
                String lowerCase = str.trim().toLowerCase(Locale.ENGLISH);
                Iterator it = linkedList.iterator();
                boolean z3 = false;
                while (it.hasNext()) {
                    String lowerCase2 = ((String) it.next()).toLowerCase(Locale.ENGLISH);
                    stringBuffer.append(" <");
                    stringBuffer.append(lowerCase2);
                    stringBuffer.append('>');
                    if (it.hasNext()) {
                        stringBuffer.append(" OR");
                    }
                    if (lowerCase2.startsWith(CertificatePinner.Pin.WILDCARD) && lowerCase2.indexOf(46, 2) != -1 && c(lowerCase2) && !g(str)) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        boolean endsWith = lowerCase.endsWith(lowerCase2.substring(1));
                        if (endsWith && z) {
                            if (e(lowerCase) == e(lowerCase2)) {
                                z3 = true;
                                continue;
                            } else {
                                z3 = false;
                                continue;
                            }
                        } else {
                            z3 = endsWith;
                            continue;
                        }
                    } else {
                        z3 = lowerCase.equals(lowerCase2);
                        continue;
                    }
                    if (z3) {
                        break;
                    }
                }
                if (z3) {
                    return;
                }
                throw new SSLException("hostname in certificate didn't match: <" + str + "> !=" + ((Object) stringBuffer));
            }
            throw new SSLException("Certificate for <" + str + "> doesn't contain CN or DNS subjectAlt");
        }
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            int length = str.length();
            if (length < 7 || length > 9) {
                return true;
            }
            int i = length - 3;
            if (str.charAt(i) != '.') {
                return true;
            }
            if (Arrays.binarySearch(b, str.substring(2, i)) < 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String[] d(X509Certificate x509Certificate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, x509Certificate)) == null) {
            List<String> d = new g3b(x509Certificate.getSubjectX500Principal()).d("cn");
            if (!d.isEmpty()) {
                String[] strArr = new String[d.size()];
                d.toArray(strArr);
                return strArr;
            }
            return null;
        }
        return (String[]) invokeL.objValue;
    }

    public static int e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            int i = 0;
            for (int i2 = 0; i2 < str.length(); i2++) {
                if (str.charAt(i2) == '.') {
                    i++;
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            return a.matcher(str).matches();
        }
        return invokeL.booleanValue;
    }

    public static String[] f(X509Certificate x509Certificate) {
        InterceptResult invokeL;
        Collection<List<?>> collection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, x509Certificate)) == null) {
            LinkedList linkedList = new LinkedList();
            try {
                collection = x509Certificate.getSubjectAlternativeNames();
            } catch (CertificateParsingException e) {
                n3b.c("", "Error parsing certificate.", e);
                collection = null;
            }
            if (collection != null) {
                for (List<?> list : collection) {
                    if (((Integer) list.get(0)).intValue() == 2) {
                        linkedList.add((String) list.get(1));
                    }
                }
            }
            if (linkedList.isEmpty()) {
                return null;
            }
            String[] strArr = new String[linkedList.size()];
            linkedList.toArray(strArr);
            return strArr;
        }
        return (String[]) invokeL.objValue;
    }
}
