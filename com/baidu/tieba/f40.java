package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.concurrent.TimeoutException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
/* loaded from: classes5.dex */
public class f40 extends c40 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Socket b;
    public InputStream c;
    public OutputStream d;
    public String e;
    public g40 f;

    @Override // com.baidu.tieba.c40
    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "tcp" : (String) invokeV.objValue;
    }

    public f40(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = null;
        this.e = str;
    }

    @Override // com.baidu.tieba.c40
    public void f(d40 d40Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, d40Var) == null) && (d40Var instanceof g40)) {
            g40 g40Var = (g40) d40Var;
            this.f = g40Var;
            if (g40Var != null) {
                this.c = g40Var.d;
                this.d = g40Var.e;
                return;
            }
            this.c = null;
            this.d = null;
        }
    }

    @Override // com.baidu.tieba.c40
    public void i(b40 b40Var) throws IOException {
        OutputStream outputStream;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, b40Var) == null) && this.b != null && (outputStream = this.d) != null) {
            outputStream.write(b40Var.a);
            this.d.flush();
        }
    }

    @Override // com.baidu.tieba.c40
    public void a(d40 d40Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, d40Var) == null) {
            if (d40Var != null) {
                if (d40Var instanceof g40) {
                    if (((g40) d40Var).c.hashCode() == this.f.c.hashCode()) {
                        w40.e("TcpMessageHandler", "closeExistedConnection  state.socket.hashCode() is same to cur socket!!!");
                        return;
                    } else {
                        g();
                        return;
                    }
                }
                return;
            }
            g();
        }
    }

    @Override // com.baidu.tieba.c40
    public d40 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.f;
        }
        return (d40) invokeV.objValue;
    }

    @Override // com.baidu.tieba.c40
    public boolean c() {
        InterceptResult invokeV;
        Socket socket;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            g40 g40Var = this.f;
            if (g40Var != null && (socket = g40Var.c) != null && socket.isConnected()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.c40
    public DataInputStream e() throws EOFException, IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return new DataInputStream(this.c);
        }
        return (DataInputStream) invokeV.objValue;
    }

    @Override // com.baidu.tieba.c40
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return n(this.f);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.c40
    public d40 h(String str, int i) throws KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, str, i)) == null) {
            return j(str, i);
        }
        return (d40) invokeLI.objValue;
    }

    public final Socket k(String str, int i) throws UnknownHostException, IOException, KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, str, i)) == null) {
            if (this.e.equals("tcp")) {
                return m(str, i);
            }
            return l(str, i);
        }
        return (Socket) invokeLI.objValue;
    }

    public final Socket m(String str, int i) throws UnknownHostException, IOException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, str, i)) == null) {
            return new Socket(str, i);
        }
        return (Socket) invokeLI.objValue;
    }

    public final d40 j(String str, int i) throws KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, str, i)) == null) {
            if (v40.a) {
                w40.d("TcpMessageHandler", "---------------ip:" + str + "  port:" + i + "-----------------");
            }
            this.b = k(str, i);
            g40 g40Var = new g40();
            Socket socket = this.b;
            if (socket == null) {
                return g40Var;
            }
            g40Var.c = socket;
            g40Var.d = socket.getInputStream();
            g40Var.e = this.b.getOutputStream();
            Boolean bool = Boolean.TRUE;
            g40Var.a = bool;
            g40Var.b = bool;
            return g40Var;
        }
        return (d40) invokeLI.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003c, code lost:
        r9 = r6.getHostAddress();
     */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Socket l(String str, int i) throws UnknownHostException, IOException, CertificateException, KeyStoreException, NoSuchAlgorithmException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, KeyManagementException, TimeoutException, SSLHandshakeException, AssertionError {
        InterceptResult invokeLI;
        SSLSocket sSLSocket;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048587, this, str, i)) == null) {
            SSLSessionCache sSLSessionCache = new SSLSessionCache(this.a);
            if (str.contains(PublicSuffixDatabase.BAIDU_TLD_PLUS_ONE)) {
                w40.a("TcpMessageHandler", "localdns begin...,domain:" + str);
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(str);
                    if (allByName != null && allByName.length > 0) {
                        int length = allByName.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length) {
                                break;
                            }
                            InetAddress inetAddress = allByName[i2];
                            if (inetAddress instanceof Inet4Address) {
                                break;
                            }
                            i2++;
                        }
                    }
                } catch (Exception e) {
                    if (v40.a) {
                        w40.c("TcpMessageHandler", "createSocketOnLine", e);
                    }
                }
            }
            SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(10000, sSLSessionCache);
            if (sSLCertificateSocketFactory == null) {
                return null;
            }
            if (str.contains(PublicSuffixDatabase.BAIDU_TLD_PLUS_ONE)) {
                sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(str, i);
            } else {
                sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(InetAddress.getByName(str), i);
            }
            SSLSocket sSLSocket2 = sSLSocket;
            sSLSocket2.setEnabledCipherSuites(sSLSocket2.getEnabledCipherSuites());
            sSLSocket2.setEnabledProtocols(sSLSocket2.getEnabledProtocols());
            sSLCertificateSocketFactory.setUseSessionTickets(sSLSocket2, true);
            sSLSocket2.startHandshake();
            return sSLSocket2;
        }
        return (Socket) invokeLI.objValue;
    }

    public boolean n(g40 g40Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, g40Var)) == null) {
            if (g40Var == null || !g40Var.a.booleanValue()) {
                return true;
            }
            try {
                if (g40Var.c != null) {
                    g40Var.c.close();
                    g40Var.c = null;
                }
                if (g40Var.d != null) {
                    g40Var.d.close();
                    g40Var.d = null;
                }
                if (g40Var.e == null) {
                    return true;
                }
                g40Var.e.close();
                g40Var.e = null;
                return true;
            } catch (IOException e) {
                if (v40.a) {
                    w40.c("TcpMessageHandler", "destroy:", e);
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
