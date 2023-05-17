package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes5.dex */
public class e3b implements X509TrustManager {
    public static /* synthetic */ Interceptable $ic;
    public static final String b;
    public transient /* synthetic */ FieldHolder $fh;
    public List<X509TrustManager> a;

    public void b(X509Certificate[] x509CertificateArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x509CertificateArr) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947684821, "Lcom/baidu/tieba/e3b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947684821, "Lcom/baidu/tieba/e3b;");
                return;
            }
        }
        b = e3b.class.getSimpleName();
    }

    public e3b(InputStream inputStream, String str) throws IllegalArgumentException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        a(inputStream, str);
    }

    public final void a(InputStream inputStream, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, inputStream, str) == null) {
            if (inputStream != null && str != null) {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    try {
                        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
                        KeyStore keyStore = KeyStore.getInstance("bks");
                        keyStore.load(inputStream, str.toCharArray());
                        trustManagerFactory.init(keyStore);
                        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                        for (int i = 0; i < trustManagers.length; i++) {
                            if (trustManagers[i] instanceof X509TrustManager) {
                                this.a.add((X509TrustManager) trustManagers[i]);
                            }
                        }
                        m3b.b(inputStream);
                    } finally {
                        m3b.b(inputStream);
                    }
                } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e) {
                    String str2 = b;
                    n3b.d(str2, "loadInputStream: exception : " + e.getMessage());
                }
                String str3 = b;
                n3b.b(str3, "loadInputStream: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                return;
            }
            throw new IllegalArgumentException("inputstream or trustPwd is null");
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, x509CertificateArr, str) == null) {
            n3b.e(b, "checkClientTrusted: ");
            for (X509TrustManager x509TrustManager : this.a) {
                try {
                    x509TrustManager.checkServerTrusted(x509CertificateArr, str);
                    return;
                } catch (CertificateException e) {
                    String str2 = b;
                    n3b.d(str2, "checkServerTrusted CertificateException" + e.getMessage());
                }
            }
            throw new CertificateException("checkServerTrusted CertificateException");
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, x509CertificateArr, str) == null) {
            b(x509CertificateArr);
            n3b.e(b, "checkServerTrusted begin ,server ca chain size is : " + x509CertificateArr.length + " ,auth type is : " + str);
            long currentTimeMillis = System.currentTimeMillis();
            for (X509Certificate x509Certificate : x509CertificateArr) {
                n3b.b(b, "server ca chain: getSubjectDN is :" + x509Certificate.getSubjectDN());
                n3b.b(b, "IssuerDN :" + x509Certificate.getIssuerDN());
                n3b.b(b, "SerialNumber : " + x509Certificate.getSerialNumber());
            }
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                try {
                    n3b.e(b, "check server i : " + i);
                    X509TrustManager x509TrustManager = this.a.get(i);
                    X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
                    if (acceptedIssuers != null) {
                        n3b.e(b, "client root ca size is : " + acceptedIssuers.length);
                        for (int i2 = 0; i2 < acceptedIssuers.length; i2++) {
                            n3b.b(b, "client root ca getIssuerDN :" + acceptedIssuers[i2].getIssuerDN());
                        }
                    }
                    x509TrustManager.checkServerTrusted(x509CertificateArr, str);
                    n3b.e(b, "checkServerTrusted succeed ,root ca issuer is : " + x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN());
                    return;
                } catch (CertificateException e) {
                    n3b.d(b, "checkServerTrusted error :" + e.getMessage() + " , time : " + i);
                    if (i == size - 1) {
                        if (x509CertificateArr != null && x509CertificateArr.length > 0) {
                            n3b.d(b, "root ca issuer : " + x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN());
                        }
                        throw e;
                    }
                }
            }
            n3b.b(b, "checkServerTrusted: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            try {
                ArrayList arrayList = new ArrayList();
                for (X509TrustManager x509TrustManager : this.a) {
                    arrayList.addAll(Arrays.asList(x509TrustManager.getAcceptedIssuers()));
                }
                return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
            } catch (Exception e) {
                String str = b;
                n3b.d(str, "getAcceptedIssuers exception : " + e.getMessage());
                return new X509Certificate[0];
            }
        }
        return (X509Certificate[]) invokeV.objValue;
    }
}
