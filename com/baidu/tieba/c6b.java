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
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.NotYetConnectedException;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import org.java_websocket.WebSocket;
import org.java_websocket.drafts.Draft;
import org.java_websocket.exceptions.IncompleteHandshakeException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.WebsocketNotConnectedException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes5.dex */
public class c6b implements WebSocket {
    public static /* synthetic */ Interceptable $ic = null;
    public static int t = 16384;
    public static boolean u;
    public transient /* synthetic */ FieldHolder $fh;
    public final BlockingQueue<ByteBuffer> a;
    public final d6b b;
    public SelectionKey c;
    public ByteChannel d;
    public volatile boolean e;
    public WebSocket.READYSTATE f;
    public List<Draft> g;
    public Draft h;
    public WebSocket.Role i;
    public ByteBuffer j;
    public r6b k;
    public String l;
    public Integer m;
    public Boolean n;
    public String o;
    public long p;
    public final Object q;
    public o6b r;
    public Object s;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947628122, "Lcom/baidu/tieba/c6b;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947628122, "Lcom/baidu/tieba/c6b;");
        }
    }

    public c6b(d6b d6bVar, Draft draft) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d6bVar, draft};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.e = false;
        this.f = WebSocket.READYSTATE.NOT_YET_CONNECTED;
        this.h = null;
        this.j = ByteBuffer.allocate(0);
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = System.currentTimeMillis();
        this.q = new Object();
        if (d6bVar != null && (draft != null || this.i != WebSocket.Role.SERVER)) {
            this.a = new LinkedBlockingQueue();
            new LinkedBlockingQueue();
            this.b = d6bVar;
            this.i = WebSocket.Role.CLIENT;
            if (draft != null) {
                this.h = draft.f();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("parameters must not be null");
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.e;
        }
        return invokeV.booleanValue;
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (t() == WebSocket.READYSTATE.OPEN) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void J() throws NotYetConnectedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.r == null) {
                this.r = new o6b();
            }
            sendFrame(this.r);
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.p = System.currentTimeMillis();
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            b(1000);
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return super.hashCode();
        }
        return invokeV.intValue;
    }

    public <T> T q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return (T) this.s;
        }
        return (T) invokeV.objValue;
    }

    public long r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.p;
        }
        return invokeV.longValue;
    }

    public InetSocketAddress s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.b.getLocalSocketAddress(this);
        }
        return (InetSocketAddress) invokeV.objValue;
    }

    public WebSocket.READYSTATE t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.f;
        }
        return (WebSocket.READYSTATE) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return super.toString();
        }
        return (String) invokeV.objValue;
    }

    public InetSocketAddress u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.b.getRemoteSocketAddress(this);
        }
        return (InetSocketAddress) invokeV.objValue;
    }

    public d6b v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.b;
        }
        return (d6b) invokeV.objValue;
    }

    public boolean w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return !this.a.isEmpty();
        }
        return invokeV.booleanValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (t() == WebSocket.READYSTATE.CLOSED) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            if (t() == WebSocket.READYSTATE.CLOSING) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (t() == WebSocket.READYSTATE.CONNECTING) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void C(w6b w6bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, w6bVar) == null) {
            if (u) {
                PrintStream printStream = System.out;
                printStream.println("open using draft: " + this.h);
            }
            L(WebSocket.READYSTATE.OPEN);
            try {
                this.b.onWebsocketOpen(this, w6bVar);
            } catch (RuntimeException e) {
                this.b.onWebsocketError(this, e);
            }
        }
    }

    public void D(String str) throws WebsocketNotConnectedException {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            if (str != null) {
                Draft draft = this.h;
                if (this.i == WebSocket.Role.CLIENT) {
                    z = true;
                } else {
                    z = false;
                }
                F(draft.h(str, z));
                return;
            }
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
    }

    public void E(ByteBuffer byteBuffer) throws IllegalArgumentException, WebsocketNotConnectedException {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, byteBuffer) == null) {
            if (byteBuffer != null) {
                Draft draft = this.h;
                if (this.i == WebSocket.Role.CLIENT) {
                    z = true;
                } else {
                    z = false;
                }
                F(draft.i(byteBuffer, z));
                return;
            }
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
    }

    public void G(byte[] bArr) throws IllegalArgumentException, WebsocketNotConnectedException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bArr) == null) {
            E(ByteBuffer.wrap(bArr));
        }
    }

    public void I(Collection<Framedata> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, collection) == null) {
            F(collection);
        }
    }

    public <T> void K(T t2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, t2) == null) {
            this.s = t2;
        }
    }

    public final void L(WebSocket.READYSTATE readystate) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, readystate) == null) {
            this.f = readystate;
        }
    }

    public final void P(List<ByteBuffer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            synchronized (this.q) {
                for (ByteBuffer byteBuffer : list) {
                    O(byteBuffer);
                }
            }
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            d(i, "", false);
        }
    }

    public void e(InvalidDataException invalidDataException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, invalidDataException) == null) {
            d(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
        }
    }

    public final void i(RuntimeException runtimeException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, runtimeException) == null) {
            O(p(500));
            o(-1, runtimeException.getMessage(), false);
        }
    }

    public final void j(InvalidDataException invalidDataException) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, invalidDataException) == null) {
            O(p(404));
            o(invalidDataException.getCloseCode(), invalidDataException.getMessage(), false);
        }
    }

    @Override // org.java_websocket.WebSocket
    public void sendFrame(Framedata framedata) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, framedata) == null) {
            F(Collections.singletonList(framedata));
        }
    }

    public final void F(Collection<Framedata> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, collection) == null) {
            if (B()) {
                if (collection != null) {
                    ArrayList arrayList = new ArrayList();
                    for (Framedata framedata : collection) {
                        if (u) {
                            PrintStream printStream = System.out;
                            printStream.println("send frame: " + framedata);
                        }
                        arrayList.add(this.h.g(framedata));
                    }
                    P(arrayList);
                    return;
                }
                throw new IllegalArgumentException();
            }
            throw new WebsocketNotConnectedException();
        }
    }

    public void M(s6b s6bVar) throws InvalidHandshakeException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, s6bVar) == null) {
            this.h.m(s6bVar);
            this.k = s6bVar;
            this.o = s6bVar.f();
            try {
                this.b.onWebsocketHandshakeSentAsClient(this, this.k);
                P(this.h.j(this.k, this.i));
            } catch (RuntimeException e) {
                this.b.onWebsocketError(this, e);
                throw new InvalidHandshakeException("rejected because of" + e);
            } catch (InvalidDataException unused) {
                throw new InvalidHandshakeException("Handshake data rejected by client.");
            }
        }
    }

    public final void O(ByteBuffer byteBuffer) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, byteBuffer) == null) {
            if (u) {
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append("write(");
                sb.append(byteBuffer.remaining());
                sb.append("): {");
                if (byteBuffer.remaining() > 1000) {
                    str = "too big to display";
                } else {
                    str = new String(byteBuffer.array());
                }
                sb.append(str);
                sb.append('}');
                printStream.println(sb.toString());
            }
            this.a.add(byteBuffer);
            this.b.onWriteDemand(this);
        }
    }

    public final void l(ByteBuffer byteBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, byteBuffer) == null) {
            try {
                for (Framedata framedata : this.h.u(byteBuffer)) {
                    if (u) {
                        PrintStream printStream = System.out;
                        printStream.println("matched frame: " + framedata);
                    }
                    this.h.o(this, framedata);
                }
            } catch (InvalidDataException e) {
                this.b.onWebsocketError(this, e);
                e(e);
            }
        }
    }

    public final ByteBuffer p(int i) {
        InterceptResult invokeI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i)) == null) {
            if (i != 404) {
                str = "500 Internal Server Error";
            } else {
                str = "404 WebSocket Upgrade Failure";
            }
            return ByteBuffer.wrap(e7b.a("HTTP/1.1 " + str + "\r\nContent-Type: text/html\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
        }
        return (ByteBuffer) invokeI.objValue;
    }

    public void H(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048583, this, opcode, byteBuffer, z) == null) {
            F(this.h.e(opcode, byteBuffer, z));
        }
    }

    public void c(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048594, this, i, str) == null) {
            d(i, str, false);
        }
    }

    public void f(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048597, this, i, str) == null) {
            g(i, str, false);
        }
    }

    public void h(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            g(i, "", z);
        }
    }

    public synchronized void d(int i, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (t() != WebSocket.READYSTATE.CLOSING && this.f != WebSocket.READYSTATE.CLOSED) {
                    if (t() == WebSocket.READYSTATE.OPEN) {
                        if (i == 1006) {
                            L(WebSocket.READYSTATE.CLOSING);
                            o(i, str, false);
                            return;
                        }
                        if (this.h.l() != Draft.CloseHandshakeType.NONE) {
                            try {
                                if (!z) {
                                    try {
                                        this.b.onWebsocketCloseInitiated(this, i, str);
                                    } catch (RuntimeException e) {
                                        this.b.onWebsocketError(this, e);
                                    }
                                }
                                if (B()) {
                                    j6b j6bVar = new j6b();
                                    j6bVar.r(str);
                                    j6bVar.q(i);
                                    j6bVar.h();
                                    sendFrame(j6bVar);
                                }
                            } catch (InvalidDataException e2) {
                                this.b.onWebsocketError(this, e2);
                                o(1006, "generated frame is invalid", false);
                            }
                        }
                        o(i, str, z);
                    } else if (i == -3) {
                        o(-3, str, true);
                    } else if (i == 1002) {
                        o(i, str, z);
                    } else {
                        o(-1, str, false);
                    }
                    L(WebSocket.READYSTATE.CLOSING);
                    this.j = null;
                }
            }
        }
    }

    public synchronized void g(int i, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (t() == WebSocket.READYSTATE.CLOSED) {
                    return;
                }
                if (t() == WebSocket.READYSTATE.OPEN && i == 1006) {
                    L(WebSocket.READYSTATE.CLOSING);
                }
                if (this.c != null) {
                    this.c.cancel();
                }
                if (this.d != null) {
                    try {
                        this.d.close();
                    } catch (IOException e) {
                        if (e.getMessage().equals("Broken pipe")) {
                            if (u) {
                                System.out.println("Caught IOException: Broken pipe during closeConnection()");
                            }
                        } else {
                            this.b.onWebsocketError(this, e);
                        }
                    }
                }
                try {
                    this.b.onWebsocketClose(this, i, str, z);
                } catch (RuntimeException e2) {
                    this.b.onWebsocketError(this, e2);
                }
                if (this.h != null) {
                    this.h.s();
                }
                this.k = null;
                L(WebSocket.READYSTATE.CLOSED);
            }
        }
    }

    public void k(ByteBuffer byteBuffer) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, byteBuffer) == null) {
            if (u) {
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append("process(");
                sb.append(byteBuffer.remaining());
                sb.append("): {");
                if (byteBuffer.remaining() > 1000) {
                    str = "too big to display";
                } else {
                    str = new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining());
                }
                sb.append(str);
                sb.append('}');
                printStream.println(sb.toString());
            }
            if (t() != WebSocket.READYSTATE.NOT_YET_CONNECTED) {
                if (t() == WebSocket.READYSTATE.OPEN) {
                    l(byteBuffer);
                }
            } else if (m(byteBuffer) && !y() && !x()) {
                if (byteBuffer.hasRemaining()) {
                    l(byteBuffer);
                } else if (this.j.hasRemaining()) {
                    l(this.j);
                }
            }
        }
    }

    public final boolean m(ByteBuffer byteBuffer) {
        InterceptResult invokeL;
        ByteBuffer byteBuffer2;
        w6b v;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, byteBuffer)) == null) {
            if (this.j.capacity() == 0) {
                byteBuffer2 = byteBuffer;
            } else {
                if (this.j.remaining() < byteBuffer.remaining()) {
                    ByteBuffer allocate = ByteBuffer.allocate(this.j.capacity() + byteBuffer.remaining());
                    this.j.flip();
                    allocate.put(this.j);
                    this.j = allocate;
                }
                this.j.put(byteBuffer);
                this.j.flip();
                byteBuffer2 = this.j;
            }
            byteBuffer2.mark();
            try {
                try {
                } catch (InvalidHandshakeException e) {
                    e(e);
                }
            } catch (IncompleteHandshakeException e2) {
                if (this.j.capacity() == 0) {
                    byteBuffer2.reset();
                    int preferedSize = e2.getPreferedSize();
                    if (preferedSize == 0) {
                        preferedSize = byteBuffer2.capacity() + 16;
                    }
                    ByteBuffer allocate2 = ByteBuffer.allocate(preferedSize);
                    this.j = allocate2;
                    allocate2.put(byteBuffer);
                } else {
                    ByteBuffer byteBuffer3 = this.j;
                    byteBuffer3.position(byteBuffer3.limit());
                    ByteBuffer byteBuffer4 = this.j;
                    byteBuffer4.limit(byteBuffer4.capacity());
                }
            }
            if (this.i == WebSocket.Role.SERVER) {
                if (this.h == null) {
                    for (Draft draft : this.g) {
                        Draft f = draft.f();
                        try {
                            f.t(this.i);
                            byteBuffer2.reset();
                            v = f.v(byteBuffer2);
                        } catch (InvalidHandshakeException unused) {
                        }
                        if (!(v instanceof r6b)) {
                            j(new InvalidDataException(1002, "wrong http function"));
                            return false;
                        }
                        r6b r6bVar = (r6b) v;
                        if (f.b(r6bVar) == Draft.HandshakeState.MATCHED) {
                            this.o = r6bVar.f();
                            try {
                                z6b onWebsocketHandshakeReceivedAsServer = this.b.onWebsocketHandshakeReceivedAsServer(this, f, r6bVar);
                                f.n(r6bVar, onWebsocketHandshakeReceivedAsServer);
                                P(f.j(onWebsocketHandshakeReceivedAsServer, this.i));
                                this.h = f;
                                C(r6bVar);
                                return true;
                            } catch (RuntimeException e3) {
                                this.b.onWebsocketError(this, e3);
                                i(e3);
                                return false;
                            } catch (InvalidDataException e4) {
                                j(e4);
                                return false;
                            }
                        }
                    }
                    if (this.h == null) {
                        j(new InvalidDataException(1002, "no draft matches"));
                    }
                    return false;
                }
                w6b v2 = this.h.v(byteBuffer2);
                if (!(v2 instanceof r6b)) {
                    o(1002, "wrong http function", false);
                    return false;
                }
                r6b r6bVar2 = (r6b) v2;
                if (this.h.b(r6bVar2) == Draft.HandshakeState.MATCHED) {
                    C(r6bVar2);
                    return true;
                }
                c(1002, "the handshake did finaly not match");
                return false;
            }
            if (this.i == WebSocket.Role.CLIENT) {
                this.h.t(this.i);
                w6b v3 = this.h.v(byteBuffer2);
                if (!(v3 instanceof y6b)) {
                    o(1002, "wrong http function", false);
                    return false;
                }
                y6b y6bVar = (y6b) v3;
                if (this.h.a(this.k, y6bVar) == Draft.HandshakeState.MATCHED) {
                    try {
                        this.b.onWebsocketHandshakeReceivedAsClient(this, this.k, y6bVar);
                        C(y6bVar);
                        return true;
                    } catch (RuntimeException e5) {
                        this.b.onWebsocketError(this, e5);
                        o(-1, e5.getMessage(), false);
                        return false;
                    } catch (InvalidDataException e6) {
                        o(e6.getCloseCode(), e6.getMessage(), false);
                        return false;
                    }
                }
                c(1002, "draft " + this.h + " refuses handshake");
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            if (t() == WebSocket.READYSTATE.NOT_YET_CONNECTED) {
                h(-1, true);
            } else if (this.e) {
                g(this.m.intValue(), this.l, this.n.booleanValue());
            } else if (this.h.l() == Draft.CloseHandshakeType.NONE) {
                h(1000, true);
            } else if (this.h.l() == Draft.CloseHandshakeType.ONEWAY) {
                if (this.i == WebSocket.Role.SERVER) {
                    h(1006, true);
                } else {
                    h(1000, true);
                }
            } else {
                h(1006, true);
            }
        }
    }

    public synchronized void o(int i, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048607, this, new Object[]{Integer.valueOf(i), str, Boolean.valueOf(z)}) == null) {
            synchronized (this) {
                if (this.e) {
                    return;
                }
                this.m = Integer.valueOf(i);
                this.l = str;
                this.n = Boolean.valueOf(z);
                this.e = true;
                this.b.onWriteDemand(this);
                try {
                    this.b.onWebsocketClosing(this, i, str, z);
                } catch (RuntimeException e) {
                    this.b.onWebsocketError(this, e);
                }
                if (this.h != null) {
                    this.h.s();
                }
                this.k = null;
            }
        }
    }
}
