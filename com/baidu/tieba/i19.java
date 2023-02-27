package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.util.DnsUtil;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.NetworkQuality;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.statistics.NetworkStatRecord;
import com.baidu.searchbox.launch.stats.SpeedStatsManager;
import com.baidu.searchbox.network.outback.ConnectManager;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
/* loaded from: classes4.dex */
public class i19 extends EventListener {
    public static /* synthetic */ Interceptable $ic;
    public static volatile i19 c;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile ConcurrentHashMap<Integer, NetworkStatRecord> a;
    public l19 b;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NetworkStatRecord a;
        public final /* synthetic */ Call b;
        public final /* synthetic */ i19 c;

        public a(i19 i19Var, NetworkStatRecord networkStatRecord, Call call) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i19Var, networkStatRecord, call};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = i19Var;
            this.a = networkStatRecord;
            this.b = call;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.url = this.b.request().url().toString();
                this.a.localDnsIpList = this.c.h(this.b.request());
                this.a.processName = ProcessUtils.getCurProcessName();
                this.a.appLaunchTimestamp = SpeedStatsManager.getInstance().getAppLaunchStartTimeStamp();
                this.a.useFallbackConn = this.b.request().isFallbackConn();
                if (this.c.b == null) {
                    synchronized (this) {
                        if (this.c.b == null) {
                            this.c.b = new l19();
                        }
                    }
                }
                if (this.c.b.shouldRecord()) {
                    this.c.b.doRecord(this.a);
                }
            }
        }
    }

    public i19() {
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

    public static i19 f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (c == null) {
                synchronized (i19.class) {
                    if (c == null) {
                        c = new i19();
                    }
                }
            }
            return c;
        }
        return (i19) invokeV.objValue;
    }

    @Override // okhttp3.EventListener
    public void callFailed(Call call, IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, iOException) == null) {
            super.callFailed(call, iOException);
            NetworkStatRecord g = g(call);
            if (g != null) {
                g.exception = iOException;
                g.failTs = System.currentTimeMillis();
                d(call, g);
                j(call);
            }
        }
    }

    @Override // okhttp3.EventListener
    public void connectionReleased(Call call, Connection connection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, call, connection) == null) {
            super.connectionReleased(call, connection);
        }
    }

    @Override // okhttp3.EventListener
    public void dnsStart(Call call, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, call, str) == null) {
            super.dnsStart(call, str);
            NetworkStatRecord g = g(call);
            if (g != null) {
                g.dnsStartTs = System.currentTimeMillis();
            }
        }
    }

    public final void i(NetworkStatRecord networkStatRecord, Proxy proxy) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, networkStatRecord, proxy) == null) && proxy.type() != Proxy.Type.DIRECT) {
            networkStatRecord.isProxyConnect = true;
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                networkStatRecord.proxyHostString = inetSocketAddress.getHostString();
                networkStatRecord.proxyAddress = inetSocketAddress.toString();
            }
        }
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(Call call, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048595, this, call, j) == null) {
            super.requestBodyEnd(call, j);
            NetworkStatRecord g = g(call);
            if (g != null) {
                g.requestBodyLength = j;
            }
        }
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(Call call, Request request) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, call, request) == null) {
            super.requestHeadersEnd(call, request);
            NetworkStatRecord g = g(call);
            if (g != null) {
                g.sendHeaderTs = System.currentTimeMillis();
            }
        }
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(Call call, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048598, this, call, j) == null) {
            super.responseBodyEnd(call, j);
            NetworkStatRecord g = g(call);
            if (g != null) {
                g.realResponseLength = j;
                g.readOverTs = System.currentTimeMillis();
            }
        }
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(Call call, Handshake handshake) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, call, handshake) == null) {
            super.secureConnectEnd(call, handshake);
            NetworkStatRecord g = g(call);
            if (g != null) {
                g.sslEndTs = System.currentTimeMillis();
            }
        }
    }

    @Override // okhttp3.EventListener
    public void callEnd(Call call) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, call) == null) {
            super.callEnd(call);
            NetworkStatRecord g = g(call);
            if (g != null) {
                g.isConnected = ConnectManager.isNetworkConnected(z09.a());
                g.finishTs = System.currentTimeMillis();
                d(call, g);
                j(call);
            }
        }
    }

    @Override // okhttp3.EventListener
    public void callThreadSwitchEnd(Call call) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, call) == null) {
            super.callThreadSwitchEnd(call);
        }
    }

    @Override // okhttp3.EventListener
    public void callThreadSwitchInQueue(Call call) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, call) == null) {
            super.callThreadSwitchInQueue(call);
        }
    }

    @Override // okhttp3.EventListener
    public void callThreadSwitchStart(Call call) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, call) == null) {
            super.callThreadSwitchStart(call);
        }
    }

    public final NetworkStatRecord g(Call call) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, call)) == null) {
            if (this.a == null) {
                return null;
            }
            return this.a.get(Integer.valueOf(call.hashCode()));
        }
        return (NetworkStatRecord) invokeL.objValue;
    }

    public final void j(Call call) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, call) == null) && this.a != null) {
            this.a.remove(Integer.valueOf(call.hashCode()));
        }
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(Call call) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, call) == null) {
            super.requestHeadersStart(call);
        }
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(Call call) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, call) == null) {
            super.responseBodyStart(call);
            NetworkStatRecord g = g(call);
            if (g != null) {
                g.responseTs = System.currentTimeMillis();
            }
        }
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(Call call) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, call) == null) {
            super.responseHeadersStart(call);
            NetworkStatRecord g = g(call);
            if (g != null) {
                g.receiveHeaderTs = System.currentTimeMillis();
            }
        }
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(Call call) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, call) == null) {
            super.secureConnectStart(call);
            NetworkStatRecord g = g(call);
            if (g != null) {
                g.sslStartTs = System.currentTimeMillis();
            }
        }
    }

    @Override // okhttp3.EventListener
    public void callStart(Call call) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, call) == null) {
            super.callStart(call);
            Object tag = call.request().tag();
            if (!(tag instanceof HttpRequest) && !(tag instanceof com.baidu.searchbox.network.outback.core.Request)) {
                NetworkStatRecord networkStatRecord = new NetworkStatRecord();
                networkStatRecord.startTs = System.currentTimeMillis();
                if (this.a == null) {
                    synchronized (this) {
                        if (this.a == null) {
                            this.a = new ConcurrentHashMap<>();
                        }
                    }
                }
                this.a.put(Integer.valueOf(call.hashCode()), networkStatRecord);
            }
        }
    }

    @Override // okhttp3.EventListener
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, call, inetSocketAddress, proxy, protocol) == null) {
            super.connectEnd(call, inetSocketAddress, proxy, protocol);
            NetworkStatRecord g = g(call);
            if (g != null) {
                long currentTimeMillis = System.currentTimeMillis();
                g.tcpEndTs = currentTimeMillis;
                g.connTs = currentTimeMillis;
            }
        }
    }

    @Override // okhttp3.EventListener
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048583, this, call, inetSocketAddress, proxy, protocol, iOException) == null) {
            super.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
            NetworkStatRecord g = g(call);
            if (g != null) {
                g.remoteIP = inetSocketAddress.toString();
                i(g, proxy);
            }
        }
    }

    @Override // okhttp3.EventListener
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, call, inetSocketAddress, proxy) == null) {
            super.connectStart(call, inetSocketAddress, proxy);
            NetworkStatRecord g = g(call);
            if (g != null) {
                g.tcpStartTs = System.currentTimeMillis();
            }
        }
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048588, this, call, str, list) == null) {
            super.dnsEnd(call, str, list);
            NetworkStatRecord g = g(call);
            if (g != null) {
                g.dnsEndTs = System.currentTimeMillis();
                g.addressList = list;
            }
        }
    }

    @Override // okhttp3.EventListener
    public void connectionAcquired(Call call, Connection connection) {
        String protocol;
        InetAddress localAddress;
        String str;
        InetAddress inetAddress;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, call, connection) == null) {
            super.connectionAcquired(call, connection);
            NetworkStatRecord g = g(call);
            if (g != null) {
                i(g, connection.route().proxy());
                if (connection.protocol() == null) {
                    protocol = "unknown";
                } else {
                    protocol = connection.protocol().toString();
                }
                g.protocol = protocol;
                Socket socket = connection.socket();
                String str2 = "";
                if (socket != null) {
                    if (socket.getLocalAddress() == null) {
                        str = "";
                    } else {
                        str = localAddress.getHostAddress() + ":" + socket.getLocalPort();
                    }
                    if (socket.getInetAddress() != null) {
                        str2 = inetAddress.getHostAddress() + ":" + socket.getPort();
                    }
                    g.localIP = str;
                    g.remoteIP = str2;
                } else {
                    g.localIP = "";
                    g.remoteIP = "";
                }
                if (g.tcpStartTs < 0) {
                    g.isConnReused = true;
                }
                if (g.addressList == null) {
                    g.addressList = call.request().getAddressList();
                }
            }
        }
    }

    public final void d(Call call, NetworkStatRecord networkStatRecord) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, call, networkStatRecord) == null) {
            Context a2 = z09.a();
            networkStatRecord.isConnected = ConnectManager.isNetworkConnected(a2);
            networkStatRecord.networkQualityFrom = NetworkQuality.getNetworkQualityUpdateFrom();
            networkStatRecord.sdtProbeErrorCode = NetworkQuality.getLastSdtProbeErrorCode();
            networkStatRecord.isVPNConnect = com.baidu.searchbox.http.ConnectManager.isVPNConnected(a2);
            networkStatRecord.netType = HttpManager.getDefault(a2).getNetworkInfo();
            ExecutorUtilsExt.postOnSerial(new a(this, networkStatRecord, call), "ParseLocalDnsDoRecord");
        }
    }

    public final String e(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, response)) == null) {
            Headers headers = response.headers();
            StringBuilder sb = new StringBuilder();
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                sb.append(headers.name(i));
                sb.append(":");
                sb.append(headers.value(i));
                sb.append(ParamableElem.DIVIDE_PARAM);
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public final List<String> h(Request request) {
        InterceptResult invokeL;
        InetAddress[] allByName;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, request)) == null) {
            try {
                String host = request.url().host();
                if (TextUtils.isEmpty(host) || (allByName = InetAddress.getAllByName(host)) == null || allByName.length <= 0) {
                    return null;
                }
                return DnsUtil.parseRawAddressList(Arrays.asList(allByName));
            } catch (IllegalArgumentException e) {
                if (!DnsUtil.DEBUG) {
                    return null;
                }
                Log.d("GlobalEventListener", "doRecord illegalArgumentException: " + e.toString());
                return null;
            } catch (NullPointerException e2) {
                if (!DnsUtil.DEBUG) {
                    return null;
                }
                Log.d("GlobalEventListener", "doRecord nullPointerException: " + e2.toString());
                return null;
            } catch (SecurityException e3) {
                if (!DnsUtil.DEBUG) {
                    return null;
                }
                Log.d("GlobalEventListener", "parseLocalDnsIpList: " + e3.toString());
                return null;
            } catch (UnknownHostException e4) {
                if (!DnsUtil.DEBUG) {
                    return null;
                }
                Log.d("GlobalEventListener", "doRecord unknownHostException: " + e4.toString());
                return null;
            }
        }
        return (List) invokeL.objValue;
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(Call call, Response response) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, call, response) == null) {
            super.responseHeadersEnd(call, response);
            NetworkStatRecord g = g(call);
            if (g != null) {
                int code = response.code();
                g.statusCode = code;
                if (code >= 400) {
                    str = e(response);
                } else {
                    str = "";
                }
                g.errheaders = str;
                g.clientIP = response.header("X-Bfe-Svbbrers");
                g.contentType = response.header("Content-Type");
                String header = response.header("Content-Length");
                if (header != null) {
                    try {
                        g.responseLength = Long.parseLong(header);
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
    }
}
