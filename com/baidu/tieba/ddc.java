package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes5.dex */
public class ddc extends SSLSocketFactory {
    public static /* synthetic */ Interceptable $ic;
    public static final String g;
    public transient /* synthetic */ FieldHolder $fh;
    public SSLContext a;
    public SSLSocket b;
    public String[] c;
    public String[] d;
    public String[] e;
    public String[] f;

    public void b(X509TrustManager x509TrustManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, x509TrustManager) == null) {
        }
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? new String[0] : (String[]) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947702150, "Lcom/baidu/tieba/ddc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947702150, "Lcom/baidu/tieba/ddc;");
                return;
            }
        }
        g = ddc.class.getSimpleName();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            String[] strArr = this.c;
            if (strArr != null) {
                return strArr;
            }
            return new String[0];
        }
        return (String[]) invokeV.objValue;
    }

    public ddc(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x509TrustManager};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.a = bdc.f();
        b(x509TrustManager);
        this.a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    public final void a(Socket socket) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, socket) == null) {
            boolean z2 = true;
            if (!kdc.a(this.f)) {
                odc.e(g, "set protocols");
                bdc.e((SSLSocket) socket, this.f);
                z = true;
            } else {
                z = false;
            }
            if (kdc.a(this.e) && kdc.a(this.d)) {
                z2 = false;
            } else {
                odc.e(g, "set white cipher or black cipher");
                SSLSocket sSLSocket = (SSLSocket) socket;
                bdc.d(sSLSocket);
                if (!kdc.a(this.e)) {
                    bdc.h(sSLSocket, this.e);
                } else {
                    bdc.b(sSLSocket, this.d);
                }
            }
            if (!z) {
                odc.e(g, "set default protocols");
                bdc.d((SSLSocket) socket);
            }
            if (!z2) {
                odc.e(g, "set default cipher suites");
                bdc.c((SSLSocket) socket);
            }
        }
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i)) == null) {
            odc.e(g, "createSocket: host , port");
            Socket createSocket = this.a.getSocketFactory().createSocket(str, i);
            if (createSocket instanceof SSLSocket) {
                a(createSocket);
                SSLSocket sSLSocket = (SSLSocket) createSocket;
                this.b = sSLSocket;
                this.c = (String[]) sSLSocket.getEnabledCipherSuites().clone();
            }
            return createSocket;
        }
        return (Socket) invokeLI.objValue;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{str, Integer.valueOf(i), inetAddress, Integer.valueOf(i2)})) == null) {
            return createSocket(str, i);
        }
        return (Socket) invokeCommon.objValue;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, inetAddress, i)) == null) {
            return createSocket(inetAddress.getHostAddress(), i);
        }
        return (Socket) invokeLI.objValue;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{inetAddress, Integer.valueOf(i), inetAddress2, Integer.valueOf(i2)})) == null) {
            return createSocket(inetAddress.getHostAddress(), i);
        }
        return (Socket) invokeCommon.objValue;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{socket, str, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            odc.e(g, "createSocket s host port autoClose");
            Socket createSocket = this.a.getSocketFactory().createSocket(socket, str, i, z);
            if (createSocket instanceof SSLSocket) {
                a(createSocket);
                SSLSocket sSLSocket = (SSLSocket) createSocket;
                this.b = sSLSocket;
                this.c = (String[]) sSLSocket.getEnabledCipherSuites().clone();
            }
            return createSocket;
        }
        return (Socket) invokeCommon.objValue;
    }
}
