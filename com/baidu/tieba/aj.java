package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.log.NetLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.log.TbLog;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
/* loaded from: classes5.dex */
public class aj {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface a {
        int a();

        void close() throws IOException;

        boolean isConnected();

        int read(ByteBuffer byteBuffer) throws Exception;

        int write(ByteBuffer byteBuffer) throws Exception;
    }

    /* loaded from: classes5.dex */
    public static class b implements a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SocketChannel a;

        @Override // com.baidu.tieba.aj.a
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        public b(String str, int i, zj zjVar) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), zjVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
            this.a = SocketChannel.open();
            System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
            if (inetSocketAddress.getAddress() != null) {
                inetSocketAddress.getAddress().getHostAddress();
                System.currentTimeMillis();
            }
            this.a.socket().connect(inetSocketAddress, zjVar.e());
            this.a.socket().setSoTimeout(zjVar.f());
            this.a.socket().setTcpNoDelay(zjVar.g());
            BdUtilHelper.getLocalDns();
            BdUtilHelper.getLocalDnsBak();
        }

        @Override // com.baidu.tieba.aj.a
        public void close() throws IOException {
            SocketChannel socketChannel;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (socketChannel = this.a) != null) {
                socketChannel.close();
            }
        }

        @Override // com.baidu.tieba.aj.a
        public boolean isConnected() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                SocketChannel socketChannel = this.a;
                if (socketChannel != null) {
                    return socketChannel.isConnected();
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.aj.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, byteBuffer)) == null) {
                return this.a.read(byteBuffer);
            }
            return invokeL.intValue;
        }

        @Override // com.baidu.tieba.aj.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, byteBuffer)) == null) {
                return this.a.write(byteBuffer);
            }
            return invokeL.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements a {
        public static /* synthetic */ Interceptable $ic = null;
        public static int e = -1;
        public transient /* synthetic */ FieldHolder $fh;
        public Socket a;
        public InputStream b;
        public OutputStream c;
        public byte[] d;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(246573445, "Lcom/baidu/tieba/aj$c;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(246573445, "Lcom/baidu/tieba/aj$c;");
            }
        }

        @Override // com.baidu.tieba.aj.a
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        public c(String str, int i, zj zjVar) throws Exception {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i), zjVar};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            String str2 = null;
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = null;
            this.a = new Socket();
            if (e == -1) {
                e = AppRuntime.getAppContext().getSharedPreferences("settings2", 0).getInt("android_use_ipv6_default", 0);
            }
            if (e == 1 && !ei.isEmpty(str)) {
                if (xi.b().size() == 0) {
                    xi.a(str, 3);
                }
                if (xi.b().size() > 0) {
                    str2 = xi.b().remove(0);
                }
            }
            System.currentTimeMillis();
            str2 = str2 == null ? str : str2;
            TbLog netLog = NetLog.getInstance();
            netLog.i("SocketImp", "socket host ： " + str + "socket ip ： " + str2);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str2, i);
            if (inetSocketAddress.getAddress() != null) {
                inetSocketAddress.getAddress().getHostAddress();
                System.currentTimeMillis();
            }
            this.a.connect(inetSocketAddress, zjVar.e());
            this.a.setSoTimeout(zjVar.f());
            this.a.setTcpNoDelay(zjVar.g());
            this.b = this.a.getInputStream();
            this.c = this.a.getOutputStream();
            this.d = new byte[1024];
            BdUtilHelper.getLocalDns();
            BdUtilHelper.getLocalDnsBak();
        }

        @Override // com.baidu.tieba.aj.a
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                try {
                    this.b.close();
                } catch (Exception e2) {
                    BdLog.e(e2.getMessage());
                }
                try {
                    this.c.close();
                } catch (Exception e3) {
                    BdLog.e(e3.getMessage());
                }
                Socket socket = this.a;
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e4) {
                        throw e4;
                    } catch (Throwable unused) {
                    }
                }
            }
        }

        @Override // com.baidu.tieba.aj.a
        public boolean isConnected() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                Socket socket = this.a;
                if (socket != null) {
                    return socket.isConnected();
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.tieba.aj.a
        public int read(ByteBuffer byteBuffer) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, byteBuffer)) == null) {
                int read = this.b.read(this.d);
                if (read > 0) {
                    byteBuffer.put(this.d, 0, read);
                }
                return read;
            }
            return invokeL.intValue;
        }

        @Override // com.baidu.tieba.aj.a
        public int write(ByteBuffer byteBuffer) throws Exception {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, byteBuffer)) == null) {
                int remaining = byteBuffer.remaining();
                if (remaining > 0) {
                    byte[] bArr = new byte[remaining];
                    byteBuffer.get(bArr);
                    this.c.write(bArr);
                }
                return remaining;
            }
            return invokeL.intValue;
        }
    }

    public aj() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public a a(String str, int i, zj zjVar, boolean z) throws Exception {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Integer.valueOf(i), zjVar, Boolean.valueOf(z)})) == null) {
            if (z) {
                return new b(str, i, zjVar);
            }
            return new c(str, i, zjVar);
        }
        return (a) invokeCommon.objValue;
    }
}
