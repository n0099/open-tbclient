package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.ConnectManager;
import com.baidu.searchbox.network.outback.OutbackComponent;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.internal.Util;
import com.baidu.searchbox.network.outback.statistics.NetworkStatRecord;
import com.baidu.searchbox.network.support.okhttp.converters.HeadersConverter;
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
import java.net.SocketAddress;
import java.util.List;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;
/* loaded from: classes6.dex */
public class i60 extends EventListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EventListener a;

    /* loaded from: classes6.dex */
    public interface c {
        void a(long j);
    }

    /* loaded from: classes6.dex */
    public class a extends ResponseBody {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ResponseBody a;
        public final /* synthetic */ Request b;
        public final /* synthetic */ i60 c;

        /* renamed from: com.baidu.tieba.i60$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0332a implements c {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0332a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.baidu.tieba.i60.c
            public void a(long j) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                    this.a.b.onFinishReadContent4NetworkStatRecord(j);
                }
            }
        }

        public a(i60 i60Var, ResponseBody responseBody, Request request) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i60Var, responseBody, request};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = i60Var;
            this.a = responseBody;
            this.b = request;
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a.contentLength();
            }
            return invokeV.longValue;
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a.contentType();
            }
            return (MediaType) invokeV.objValue;
        }

        @Override // okhttp3.ResponseBody
        public BufferedSource source() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.c.c(this.a.source(), new C0332a(this));
            }
            return (BufferedSource) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b extends ForwardingSource {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public boolean b;
        public final /* synthetic */ c c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(i60 i60Var, Source source, c cVar) {
            super(source);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i60Var, source, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Source) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = cVar;
            this.a = 0L;
        }

        @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    super.close();
                } finally {
                    c cVar = this.c;
                    if (cVar != null && !this.b) {
                        cVar.a(this.a);
                    }
                }
            }
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            long j2;
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, buffer, j)) == null) {
                try {
                    long read = super.read(buffer, j);
                    long j3 = this.a;
                    int i = (read > (-1L) ? 1 : (read == (-1L) ? 0 : -1));
                    if (i != 0) {
                        j2 = read;
                    } else {
                        j2 = 0;
                    }
                    long j4 = j3 + j2;
                    this.a = j4;
                    if (i == 0 && this.c != null) {
                        this.c.a(j4);
                        this.b = true;
                    }
                    return read;
                } catch (Exception e) {
                    c cVar = this.c;
                    if (cVar != null) {
                        cVar.a(this.a);
                    }
                    throw e;
                }
            }
            return invokeLJ.longValue;
        }
    }

    public i60(EventListener eventListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eventListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = eventListener;
    }

    @Override // okhttp3.EventListener
    public void callThreadSwitchEnd(Call call) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, call) == null) && d(call)) {
            ((Request) call.request().tag(Request.class)).getNetworkStatRecord().switchThreadEnd = System.currentTimeMillis();
        }
    }

    @Override // okhttp3.EventListener
    public void callThreadSwitchInQueue(Call call) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, call) == null) && d(call)) {
            ((Request) call.request().tag(Request.class)).getNetworkStatRecord().switchThreadInQueue = System.currentTimeMillis();
        }
    }

    @Override // okhttp3.EventListener
    public void callThreadSwitchStart(Call call) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, call) == null) && d(call)) {
            ((Request) call.request().tag(Request.class)).getNetworkStatRecord().switchThreadStart = System.currentTimeMillis();
        }
    }

    public final boolean d(Call call) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, call)) == null) {
            if (call != null && ((Request) call.request().tag(Request.class)) == null) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // okhttp3.EventListener
    public void requestBodyStart(Call call) {
        EventListener eventListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, call) == null) && (eventListener = this.a) != null) {
            try {
                eventListener.requestBodyStart(call);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(Call call) {
        EventListener eventListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, call) == null) && (eventListener = this.a) != null) {
            try {
                eventListener.responseBodyStart(call);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(Call call) {
        EventListener eventListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048601, this, call) == null) && (eventListener = this.a) != null) {
            try {
                eventListener.responseHeadersStart(call);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final String b(Response response) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, response)) == null) {
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

    @Override // okhttp3.EventListener
    public void callStart(Call call) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, call) == null) {
            if (d(call)) {
                ((Request) call.request().tag(Request.class)).getNetworkStatRecord().callStartTimeStamp = System.currentTimeMillis();
            }
            EventListener eventListener = this.a;
            if (eventListener != null) {
                try {
                    eventListener.callStart(call);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(Call call) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, call) == null) {
            if (d(call)) {
                ((Request) call.request().tag(Request.class)).getNetworkStatRecord().sendHeaderTs = System.currentTimeMillis();
            }
            EventListener eventListener = this.a;
            if (eventListener != null) {
                try {
                    eventListener.requestHeadersStart(call);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(Call call) {
        EventListener eventListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048603, this, call) == null) && (eventListener = this.a) != null) {
            try {
                eventListener.secureConnectStart(call);
                if (d(call)) {
                    ((Request) call.request().tag(Request.class)).getNetworkStatRecord().sslStartTs = System.currentTimeMillis();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final BufferedSource c(Source source, c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, source, cVar)) == null) {
            return Okio.buffer(new b(this, source, cVar));
        }
        return (BufferedSource) invokeLL.objValue;
    }

    @Override // okhttp3.EventListener
    public void connectionReleased(Call call, Connection connection) {
        EventListener eventListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048588, this, call, connection) == null) && (eventListener = this.a) != null) {
            try {
                eventListener.connectionReleased(call, connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void e(NetworkStatRecord networkStatRecord, Proxy proxy) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048592, this, networkStatRecord, proxy) == null) && proxy.type() != Proxy.Type.DIRECT) {
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
    public void requestHeadersEnd(Call call, okhttp3.Request request) {
        EventListener eventListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048596, this, call, request) == null) && (eventListener = this.a) != null) {
            try {
                eventListener.requestHeadersEnd(call, request);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // okhttp3.EventListener
    public void callEnd(Call call) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, call) == null) {
            if (d(call)) {
                Request request = (Request) call.request().tag(Request.class);
                request.getNetworkStatRecord().isConnected = ConnectManager.isNetworkConnected(OutbackComponent.getInstance().getContext());
                request.getNetworkStatRecord().callEndTimeStamp = System.currentTimeMillis();
            }
            EventListener eventListener = this.a;
            if (eventListener != null) {
                try {
                    eventListener.callEnd(call);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // okhttp3.EventListener
    public void callFailed(Call call, IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, call, iOException) == null) {
            if (d(call)) {
                Request request = (Request) call.request().tag(Request.class);
                request.getNetworkStatRecord().isConnected = ConnectManager.isNetworkConnected(OutbackComponent.getInstance().getContext());
                request.getNetworkStatRecord().failTs = System.currentTimeMillis();
                request.getNetworkStatRecord().exception = iOException;
            }
            EventListener eventListener = this.a;
            if (eventListener != null) {
                try {
                    eventListener.callFailed(call, iOException);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // okhttp3.EventListener
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        String protocol2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, call, inetSocketAddress, proxy, protocol) == null) {
            if (d(call)) {
                Request request = (Request) call.request().tag(Request.class);
                long currentTimeMillis = System.currentTimeMillis();
                request.getNetworkStatRecord().connTs = currentTimeMillis;
                request.getNetworkStatRecord().tcpEndTs = currentTimeMillis;
                NetworkStatRecord networkStatRecord = request.getNetworkStatRecord();
                if (protocol == null) {
                    protocol2 = "unknown";
                } else {
                    protocol2 = protocol.toString();
                }
                networkStatRecord.protocol = protocol2;
                try {
                    request.getNetworkStatRecord().useFallbackConn = call.request().isFallbackConn();
                } catch (Throwable unused) {
                    request.getNetworkStatRecord().useFallbackConn = false;
                }
            }
            EventListener eventListener = this.a;
            if (eventListener != null) {
                try {
                    eventListener.connectEnd(call, inetSocketAddress, proxy, protocol);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // okhttp3.EventListener
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        String protocol2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048585, this, call, inetSocketAddress, proxy, protocol, iOException) == null) {
            if (d(call)) {
                NetworkStatRecord networkStatRecord = ((Request) call.request().tag(Request.class)).getNetworkStatRecord();
                networkStatRecord.failTs = System.currentTimeMillis();
                networkStatRecord.exception = iOException;
                if (protocol == null) {
                    protocol2 = "unknown";
                } else {
                    protocol2 = protocol.toString();
                }
                networkStatRecord.protocol = protocol2;
                networkStatRecord.remoteIP = inetSocketAddress.toString();
                e(networkStatRecord, proxy);
            }
            EventListener eventListener = this.a;
            if (eventListener != null) {
                try {
                    eventListener.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // okhttp3.EventListener
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        EventListener eventListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048586, this, call, inetSocketAddress, proxy) == null) && (eventListener = this.a) != null) {
            try {
                eventListener.connectStart(call, inetSocketAddress, proxy);
                if (d(call)) {
                    ((Request) call.request().tag(Request.class)).getNetworkStatRecord().tcpStartTs = System.currentTimeMillis();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, call, str, list) == null) {
            if (d(call)) {
                Request request = (Request) call.request().tag(Request.class);
                request.getNetworkStatRecord().dnsEndTs = System.currentTimeMillis();
                request.getNetworkStatRecord().dnsTs = request.getNetworkStatRecord().getDnsTime();
            }
            EventListener eventListener = this.a;
            if (eventListener != null) {
                try {
                    eventListener.dnsEnd(call, str, list);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // okhttp3.EventListener
    public void connectionAcquired(Call call, Connection connection) {
        InetAddress localAddress;
        String str;
        InetAddress inetAddress;
        String protocol;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, call, connection) == null) {
            if (d(call) && connection != null) {
                Request request = (Request) call.request().tag(Request.class);
                if (connection.socket() != null) {
                    String str2 = "";
                    if (connection.socket().getLocalAddress() == null) {
                        str = "";
                    } else {
                        str = localAddress.getHostAddress() + ":" + connection.socket().getLocalPort();
                    }
                    if (connection.socket().getInetAddress() != null) {
                        str2 = inetAddress.getHostAddress() + ":" + connection.socket().getPort();
                    }
                    NetworkStatRecord networkStatRecord = request.getNetworkStatRecord();
                    networkStatRecord.localIP = str;
                    networkStatRecord.remoteIP = str2;
                    if (Util.isTextEmpty(networkStatRecord.protocol)) {
                        if (connection.protocol() != null) {
                            protocol = "unknown";
                        } else {
                            protocol = connection.protocol().toString();
                        }
                        networkStatRecord.protocol = protocol;
                    }
                    e(networkStatRecord, connection.route().proxy());
                }
            }
            EventListener eventListener = this.a;
            if (eventListener != null) {
                try {
                    eventListener.connectionAcquired(call, connection);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // okhttp3.EventListener
    public void dnsStart(Call call, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, call, str) == null) {
            if (d(call)) {
                ((Request) call.request().tag(Request.class)).getNetworkStatRecord().dnsStartTs = System.currentTimeMillis();
            }
            EventListener eventListener = this.a;
            if (eventListener != null) {
                try {
                    eventListener.dnsStart(call, str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final Response f(Request request, Response response) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, request, response)) == null) {
            if (response != null && !response.isRedirect()) {
                ResponseBody body = response.body();
                if (body == null) {
                    return response;
                }
                return response.newBuilder().body(new a(this, body, request)).build();
            }
            return response;
        }
        return (Response) invokeLL.objValue;
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(Call call, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048594, this, call, j) == null) {
            if (d(call)) {
                ((Request) call.request().tag(Request.class)).getNetworkStatRecord().requestBodyLength = j;
            }
            EventListener eventListener = this.a;
            if (eventListener != null) {
                try {
                    eventListener.requestBodyEnd(call, j);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(Call call, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048598, this, call, j) == null) {
            if (d(call)) {
                Request request = (Request) call.request().tag(Request.class);
                request.getNetworkStatRecord().responseTs = System.currentTimeMillis();
                request.getNetworkStatRecord().responseLength = j;
            }
            EventListener eventListener = this.a;
            if (eventListener != null) {
                try {
                    eventListener.responseBodyEnd(call, j);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(Call call, Handshake handshake) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048602, this, call, handshake) == null) {
            super.secureConnectEnd(call, handshake);
            EventListener eventListener = this.a;
            if (eventListener != null) {
                try {
                    eventListener.secureConnectEnd(call, handshake);
                    if (d(call)) {
                        ((Request) call.request().tag(Request.class)).getNetworkStatRecord().sslEndSTs = System.currentTimeMillis();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(Call call, Response response) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048600, this, call, response) == null) {
            if (d(call)) {
                Request request = (Request) call.request().tag(Request.class);
                if (response != null) {
                    request.getNetworkStatRecord().statusCode = response.code();
                    request.onReceiveHeader4NetworkStatRecord(System.currentTimeMillis(), HeadersConverter.fromOks(response.headers()));
                    response = f(request, response);
                    int code = response.code();
                    NetworkStatRecord networkStatRecord = request.getNetworkStatRecord();
                    if (response.isRedirect()) {
                        String header = response.header("Location");
                        if (!Util.isTextEmpty(header)) {
                            networkStatRecord.url = header;
                        }
                    }
                    String header2 = response.header("Content-Type");
                    if (!Util.isTextEmpty(header2)) {
                        networkStatRecord.contentType = header2;
                    }
                    if (code >= 400) {
                        str = b(response);
                    } else {
                        str = "";
                    }
                    if (!Util.isTextEmpty(str)) {
                        networkStatRecord.errheaders = str;
                    }
                    if (request.getNetworkStatRecord().dnsStartTs == -1) {
                        request.getNetworkStatRecord().dnsStartTs = 0L;
                    }
                    if (request.getNetworkStatRecord().dnsEndTs == -1) {
                        request.getNetworkStatRecord().dnsEndTs = 0L;
                    }
                    if (request.getNetworkStatRecord().dnsTs == -1) {
                        request.getNetworkStatRecord().dnsTs = 0L;
                    }
                    if (request.getNetworkStatRecord().connTs == -1) {
                        request.getNetworkStatRecord().connTs = 0L;
                        request.getNetworkStatRecord().isConnReused = true;
                    }
                }
            }
            EventListener eventListener = this.a;
            if (eventListener != null) {
                try {
                    eventListener.responseHeadersEnd(call, response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
