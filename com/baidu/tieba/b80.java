package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
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
/* loaded from: classes3.dex */
public class b80 extends y70 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Socket c;
    public InputStream d;
    public OutputStream e;
    public String f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b80(Context context, String str) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = str;
    }

    @Override // com.baidu.tieba.y70
    public InputStream b() throws EOFException, IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new DataInputStream(this.d);
        }
        return (InputStream) invokeV.objValue;
    }

    @Override // com.baidu.tieba.y70
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return k(this.b);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.y70
    public void c(z70 z70Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z70Var) == null) {
            this.b = z70Var;
            if (z70Var != null) {
                this.d = z70Var.d;
                this.e = z70Var.e;
                return;
            }
            this.d = null;
            this.e = null;
        }
    }

    @Override // com.baidu.tieba.y70
    public void f(x70 x70Var) throws IOException {
        OutputStream outputStream;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, x70Var) == null) && this.c != null && (outputStream = this.e) != null) {
            outputStream.write(x70Var.a);
            this.e.flush();
        }
    }

    @Override // com.baidu.tieba.y70
    public z70 e(String str, int i) throws KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, str, i)) == null) {
            return g(str, i);
        }
        return (z70) invokeLI.objValue;
    }

    public final Socket h(String str, int i) throws UnknownHostException, IOException, KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048582, this, str, i)) == null) {
            if (this.f.equals("tcp")) {
                return j(str, i);
            }
            return i(str, i);
        }
        return (Socket) invokeLI.objValue;
    }

    public final Socket j(String str, int i) throws UnknownHostException, IOException {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, i)) == null) {
            return new Socket(str, i);
        }
        return (Socket) invokeLI.objValue;
    }

    public final z70 g(String str, int i) throws KeyManagementException, CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, TimeoutException, AssertionError {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i)) == null) {
            q80.d("TcpMessageHandler", "---------------ip:" + str + "  port:" + i + "-----------------");
            this.c = h(str, i);
            z70 z70Var = new z70();
            Socket socket = this.c;
            if (socket == null) {
                return z70Var;
            }
            z70Var.c = socket;
            z70Var.d = socket.getInputStream();
            z70Var.e = this.c.getOutputStream();
            Boolean bool = Boolean.TRUE;
            z70Var.a = bool;
            z70Var.b = bool;
            return z70Var;
        }
        return (z70) invokeLI.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003c, code lost:
        r9 = r6.getHostAddress();
     */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Socket i(String str, int i) throws UnknownHostException, IOException, CertificateException, KeyStoreException, NoSuchAlgorithmException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, KeyManagementException, TimeoutException, SSLHandshakeException, AssertionError {
        InterceptResult invokeLI;
        SSLSocket sSLSocket;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, str, i)) == null) {
            SSLSessionCache sSLSessionCache = new SSLSessionCache(this.a);
            if (str.contains(PublicSuffixDatabase.BAIDU_TLD_PLUS_ONE)) {
                q80.a("TcpMessageHandler", "localdns begin...,domain:" + str);
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
                    q80.c("TcpMessageHandler", "createSocketOnLine", e);
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

    public boolean k(z70 z70Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, z70Var)) == null) {
            if (z70Var == null || !z70Var.a.booleanValue()) {
                return true;
            }
            try {
                if (z70Var.c != null) {
                    z70Var.c.close();
                    z70Var.c = null;
                }
                if (z70Var.d != null) {
                    z70Var.d.close();
                    z70Var.d = null;
                }
                if (z70Var.e == null) {
                    return true;
                }
                z70Var.e.close();
                z70Var.e = null;
                return true;
            } catch (IOException e) {
                q80.c("TcpMessageHandler", "destroy:", e);
                return false;
            }
        }
        return invokeL.booleanValue;
    }
}
