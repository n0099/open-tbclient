package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.NotYetConnectedException;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import org.apache.commons.codec.net.RFC1522Codec;
import org.java_websocket.WebSocket;
import org.java_websocket.drafts.Draft;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes3.dex */
public abstract class b0b extends xza implements Runnable, WebSocket {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CountDownLatch closeLatch;
    public CountDownLatch connectLatch;
    public Thread connectReadThread;
    public int connectTimeout;
    public Draft draft;
    public zza engine;
    public Map<String, String> headers;
    public OutputStream ostream;
    public Proxy proxy;
    public Socket socket;
    public URI uri;
    public Thread writeThread;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public abstract void onClose(int i, String str, boolean z);

    public void onCloseInitiated(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048603, this, i, str) == null) {
        }
    }

    public void onClosing(int i, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
        }
    }

    public abstract void onError(Exception exc);

    @Deprecated
    public void onFragment(Framedata framedata) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, framedata) == null) {
        }
    }

    public abstract void onMessage(String str);

    public void onMessage(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, byteBuffer) == null) {
        }
    }

    public abstract void onOpen(v0b v0bVar);

    @Override // com.baidu.tieba.a0b
    public final void onWriteDemand(WebSocket webSocket) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048618, this, webSocket) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b0b a;

        public b(b0b b0bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b0bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b0bVar;
        }

        public /* synthetic */ b(b0b b0bVar, a aVar) {
            this(b0bVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Thread currentThread = Thread.currentThread();
                currentThread.setName("WebSocketWriteThread-" + Thread.currentThread().getId());
                while (true) {
                    try {
                        try {
                            try {
                                if (Thread.interrupted()) {
                                    break;
                                }
                                ByteBuffer take = this.a.engine.a.take();
                                this.a.ostream.write(take.array(), 0, take.limit());
                                this.a.ostream.flush();
                            } catch (IOException e) {
                                this.a.handleIOException(e);
                            }
                        } finally {
                            this.a.closeSocket();
                            this.a.writeThread = null;
                        }
                    } catch (InterruptedException unused) {
                        for (ByteBuffer byteBuffer : this.a.engine.a) {
                            this.a.ostream.write(byteBuffer.array(), 0, byteBuffer.limit());
                            this.a.ostream.flush();
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b0b(URI uri) {
        this(uri, new c0b());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((URI) objArr2[0], (Draft) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b0b(URI uri, Map<String, String> map) {
        this(uri, new c0b(), map);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, map};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((URI) objArr2[0], (Draft) objArr2[1], (Map) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b0b(URI uri, Draft draft) {
        this(uri, draft, null, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, draft};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((URI) objArr2[0], (Draft) objArr2[1], (Map) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b0b(URI uri, Draft draft, Map<String, String> map) {
        this(uri, draft, map, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, draft, map};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((URI) objArr2[0], (Draft) objArr2[1], (Map) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public b0b(URI uri, Draft draft, Map<String, String> map, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {uri, draft, map, Integer.valueOf(i)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.uri = null;
        this.engine = null;
        this.socket = null;
        this.proxy = Proxy.NO_PROXY;
        this.connectLatch = new CountDownLatch(1);
        this.closeLatch = new CountDownLatch(1);
        this.connectTimeout = 0;
        if (uri != null) {
            if (draft != null) {
                this.uri = uri;
                this.draft = draft;
                this.headers = map;
                this.connectTimeout = i;
                setTcpNoDelay(false);
                setReuseAddr(false);
                this.engine = new zza(this, draft);
                return;
            }
            throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleIOException(IOException iOException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, iOException) == null) {
            if (iOException instanceof SSLException) {
                onError(iOException);
            }
            this.engine.n();
        }
    }

    public void close(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.engine.a();
        }
    }

    @Override // com.baidu.tieba.a0b
    public InetSocketAddress getLocalSocketAddress(WebSocket webSocket) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, webSocket)) == null) {
            Socket socket = this.socket;
            if (socket != null) {
                return (InetSocketAddress) socket.getLocalSocketAddress();
            }
            return null;
        }
        return (InetSocketAddress) invokeL.objValue;
    }

    @Override // com.baidu.tieba.a0b
    public InetSocketAddress getRemoteSocketAddress(WebSocket webSocket) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, webSocket)) == null) {
            Socket socket = this.socket;
            if (socket != null) {
                return (InetSocketAddress) socket.getRemoteSocketAddress();
            }
            return null;
        }
        return (InetSocketAddress) invokeL.objValue;
    }

    public void send(String str) throws NotYetConnectedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            this.engine.D(str);
        }
    }

    public void sendFrame(Collection<Framedata> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, collection) == null) {
            this.engine.I(collection);
        }
    }

    public <T> void setAttachment(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, t) == null) {
            this.engine.K(t);
        }
    }

    public void setProxy(Proxy proxy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, proxy) == null) {
            if (proxy != null) {
                this.proxy = proxy;
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    public void setSocket(Socket socket) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, socket) == null) {
            if (this.socket == null) {
                this.socket = socket;
                return;
            }
            throw new IllegalStateException("socket has already been set");
        }
    }

    public void close(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, str) == null) {
            this.engine.c(i, str);
        }
    }

    public void closeConnection(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048580, this, i, str) == null) {
            this.engine.f(i, str);
        }
    }

    public boolean connectBlocking(long j, TimeUnit timeUnit) throws InterruptedException {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048583, this, j, timeUnit)) == null) {
            connect();
            if (this.connectLatch.await(j, timeUnit) && this.engine.B()) {
                return true;
            }
            return false;
        }
        return invokeJL.booleanValue;
    }

    @Override // com.baidu.tieba.a0b
    public final void onWebsocketError(WebSocket webSocket, Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, webSocket, exc) == null) {
            onError(exc);
        }
    }

    @Override // com.baidu.tieba.a0b
    public final void onWebsocketMessage(WebSocket webSocket, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048614, this, webSocket, str) == null) {
            onMessage(str);
        }
    }

    @Override // com.baidu.tieba.yza
    public void onWebsocketMessageFragment(WebSocket webSocket, Framedata framedata) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048616, this, webSocket, framedata) == null) {
            onFragment(framedata);
        }
    }

    @Override // com.baidu.tieba.a0b
    public final void onWebsocketOpen(WebSocket webSocket, t0b t0bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048617, this, webSocket, t0bVar) == null) {
            startConnectionLostTimer();
            onOpen((v0b) t0bVar);
            this.connectLatch.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeSocket() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            try {
                if (this.socket != null) {
                    this.socket.close();
                }
            } catch (IOException e) {
                onWebsocketError(this, e);
            }
        }
    }

    public void close() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.writeThread != null) {
            this.engine.b(1000);
        }
    }

    public void closeBlocking() throws InterruptedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            close();
            this.closeLatch.await();
        }
    }

    public boolean connectBlocking() throws InterruptedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            connect();
            this.connectLatch.await();
            return this.engine.B();
        }
        return invokeV.booleanValue;
    }

    public <T> T getAttachment() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return (T) this.engine.q();
        }
        return (T) invokeV.objValue;
    }

    public WebSocket getConnection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.engine;
        }
        return (WebSocket) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xza
    public Collection<WebSocket> getConnections() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return Collections.singletonList(this.engine);
        }
        return (Collection) invokeV.objValue;
    }

    public Draft getDraft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.draft;
        }
        return (Draft) invokeV.objValue;
    }

    public InetSocketAddress getLocalSocketAddress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.engine.s();
        }
        return (InetSocketAddress) invokeV.objValue;
    }

    public WebSocket.READYSTATE getReadyState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.engine.t();
        }
        return (WebSocket.READYSTATE) invokeV.objValue;
    }

    public InetSocketAddress getRemoteSocketAddress() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.engine.u();
        }
        return (InetSocketAddress) invokeV.objValue;
    }

    public String getResourceDescriptor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.uri.getPath();
        }
        return (String) invokeV.objValue;
    }

    public Socket getSocket() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.socket;
        }
        return (Socket) invokeV.objValue;
    }

    public URI getURI() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.uri;
        }
        return (URI) invokeV.objValue;
    }

    public boolean hasBufferedData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.engine.w();
        }
        return invokeV.booleanValue;
    }

    public boolean isClosed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.engine.x();
        }
        return invokeV.booleanValue;
    }

    public boolean isClosing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.engine.y();
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public boolean isConnecting() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.engine.z();
        }
        return invokeV.booleanValue;
    }

    public boolean isFlushAndClose() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.engine.A();
        }
        return invokeV.booleanValue;
    }

    public boolean isOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.engine.B();
        }
        return invokeV.booleanValue;
    }

    public void reconnect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            reset();
            connect();
        }
    }

    public boolean reconnectBlocking() throws InterruptedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            reset();
            return connectBlocking();
        }
        return invokeV.booleanValue;
    }

    public void sendPing() throws NotYetConnectedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            this.engine.J();
        }
    }

    private int getPort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            int port = this.uri.getPort();
            if (port == -1) {
                String scheme = this.uri.getScheme();
                if ("wss".equals(scheme)) {
                    return 443;
                }
                if ("ws".equals(scheme)) {
                    return 80;
                }
                throw new IllegalArgumentException("unknown scheme: " + scheme);
            }
            return port;
        }
        return invokeV.intValue;
    }

    private void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            Thread currentThread = Thread.currentThread();
            if (currentThread != this.writeThread && currentThread != this.connectReadThread) {
                try {
                    closeBlocking();
                    if (this.writeThread != null) {
                        this.writeThread.interrupt();
                        this.writeThread = null;
                    }
                    if (this.connectReadThread != null) {
                        this.connectReadThread.interrupt();
                        this.connectReadThread = null;
                    }
                    this.draft.s();
                    if (this.socket != null) {
                        this.socket.close();
                        this.socket = null;
                    }
                    this.connectLatch = new CountDownLatch(1);
                    this.closeLatch = new CountDownLatch(1);
                    this.engine = new zza(this, this.draft);
                    return;
                } catch (Exception e) {
                    onError(e);
                    this.engine.f(1006, e.getMessage());
                    return;
                }
            }
            throw new IllegalStateException("You cannot initialize a reconnect out of the websocket thread. Use reconnect in another thread to insure a successful cleanup.");
        }
    }

    private void sendHandshake() throws InvalidHandshakeException {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            String rawPath = this.uri.getRawPath();
            String rawQuery = this.uri.getRawQuery();
            rawPath = (rawPath == null || rawPath.length() == 0) ? "/" : "/";
            if (rawQuery != null) {
                rawPath = rawPath + RFC1522Codec.SEP + rawQuery;
            }
            int port = getPort();
            StringBuilder sb = new StringBuilder();
            sb.append(this.uri.getHost());
            if (port != 80 && port != 443) {
                str = ":" + port;
            } else {
                str = "";
            }
            sb.append(str);
            String sb2 = sb.toString();
            r0b r0bVar = new r0b();
            r0bVar.b(rawPath);
            r0bVar.put("Host", sb2);
            Map<String, String> map = this.headers;
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    r0bVar.put(entry.getKey(), entry.getValue());
                }
            }
            this.engine.M(r0bVar);
        }
    }

    public void connect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (this.connectReadThread == null) {
                Thread thread = new Thread(this);
                this.connectReadThread = thread;
                thread.setName("WebSocketConnectReadThread-" + this.connectReadThread.getId());
                this.connectReadThread.start();
                return;
            }
            throw new IllegalStateException("WebSocketClient objects are not reuseable");
        }
    }

    @Override // com.baidu.tieba.a0b
    public final void onWebsocketClose(WebSocket webSocket, int i, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048610, this, new Object[]{webSocket, Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
            stopConnectionLostTimer();
            Thread thread = this.writeThread;
            if (thread != null) {
                thread.interrupt();
            }
            onClose(i, str, z);
            this.connectLatch.countDown();
            this.closeLatch.countDown();
        }
    }

    @Override // com.baidu.tieba.a0b
    public void onWebsocketCloseInitiated(WebSocket webSocket, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048611, this, webSocket, i, str) == null) {
            onCloseInitiated(i, str);
        }
    }

    public void sendFragmentedFrame(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048625, this, opcode, byteBuffer, z) == null) {
            this.engine.H(opcode, byteBuffer, z);
        }
    }

    @Override // com.baidu.tieba.a0b
    public void onWebsocketClosing(WebSocket webSocket, int i, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{webSocket, Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
            onClosing(i, str, z);
        }
    }

    @Override // com.baidu.tieba.a0b
    public final void onWebsocketMessage(WebSocket webSocket, ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048615, this, webSocket, byteBuffer) == null) {
            onMessage(byteBuffer);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        int read;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            try {
                if (this.socket == null) {
                    this.socket = new Socket(this.proxy);
                    z = true;
                } else if (!this.socket.isClosed()) {
                    z = false;
                } else {
                    throw new IOException();
                }
                this.socket.setTcpNoDelay(isTcpNoDelay());
                this.socket.setReuseAddress(isReuseAddr());
                if (!this.socket.isBound()) {
                    this.socket.connect(new InetSocketAddress(this.uri.getHost(), getPort()), this.connectTimeout);
                }
                if (z && "wss".equals(this.uri.getScheme())) {
                    SSLContext sSLContext = SSLContext.getInstance("TLS");
                    sSLContext.init(null, null, null);
                    this.socket = sSLContext.getSocketFactory().createSocket(this.socket, this.uri.getHost(), getPort(), true);
                }
                InputStream inputStream = this.socket.getInputStream();
                this.ostream = this.socket.getOutputStream();
                sendHandshake();
                Thread thread = new Thread(new b(this, null));
                this.writeThread = thread;
                thread.start();
                byte[] bArr = new byte[zza.t];
                while (!isClosing() && !isClosed() && (read = inputStream.read(bArr)) != -1) {
                    try {
                        this.engine.k(ByteBuffer.wrap(bArr, 0, read));
                    } catch (IOException e) {
                        handleIOException(e);
                    } catch (RuntimeException e2) {
                        onError(e2);
                        this.engine.f(1006, e2.getMessage());
                    }
                }
                this.engine.n();
                this.connectReadThread = null;
            } catch (Exception e3) {
                onWebsocketError(this.engine, e3);
                this.engine.f(-1, e3.getMessage());
            }
        }
    }

    public void send(ByteBuffer byteBuffer) throws IllegalArgumentException, NotYetConnectedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, byteBuffer) == null) {
            this.engine.E(byteBuffer);
        }
    }

    @Override // org.java_websocket.WebSocket
    public void sendFrame(Framedata framedata) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, framedata) == null) {
            this.engine.sendFrame(framedata);
        }
    }

    public void send(byte[] bArr) throws NotYetConnectedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, bArr) == null) {
            this.engine.G(bArr);
        }
    }
}
