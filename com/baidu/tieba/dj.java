package com.baidu.tieba;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.WebSocketException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.zi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.tts.client.SpeechSynthesizer;
import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes5.dex */
public class dj {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler a;
    public volatile zj b;
    public volatile bk c;
    public zi.a d;
    public URI e;
    public String f;
    public String g;
    public int h;
    public String i;
    public String j;
    public String[] k;
    public List<BasicNameValuePair> l;
    public bj m;
    public yj n;
    public boolean o;
    public boolean p;
    public volatile boolean q;
    public long r;
    public xi s;

    public void B(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dj a;

        public a(dj djVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {djVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = djVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                Object obj = message.obj;
                if (obj instanceof xj) {
                    xj xjVar = (xj) obj;
                    if (this.a.m != null) {
                        this.a.m.a(xjVar.a);
                    }
                } else if (obj instanceof rj) {
                    rj rjVar = (rj) obj;
                    if (this.a.m != null) {
                        this.a.m.d(rjVar.a);
                    } else if (this.a.y()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (obj instanceof fj) {
                    fj fjVar = (fj) obj;
                    if (this.a.m != null) {
                        this.a.m.f(fjVar);
                    } else if (this.a.y()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (obj instanceof oj) {
                    pj pjVar = new pj();
                    pjVar.a = ((oj) obj).a;
                    this.a.c.b(pjVar);
                } else if (obj instanceof pj) {
                    pj pjVar2 = (pj) obj;
                    if (this.a.m != null) {
                        this.a.m.e();
                    }
                } else {
                    String str = null;
                    if (obj instanceof hj) {
                        this.a.q(1, null);
                    } else if (obj instanceof vj) {
                        vj vjVar = (vj) obj;
                        if (vjVar.a) {
                            if (this.a.m != null) {
                                this.a.m.onOpen(vjVar.b);
                                this.a.o = true;
                                this.a.p = false;
                                if (this.a.m != null) {
                                    this.a.m.c(null);
                                }
                                if (BdBaseApplication.getInst().isDebugMode()) {
                                    Log.d("TB-WebSocket", "建立连接：握手成功");
                                    return;
                                }
                                return;
                            }
                            this.a.q(6, "handler already NULL");
                        }
                    } else if (obj instanceof ij) {
                        SocketException socketException = ((ij) obj).a;
                        if (socketException != null) {
                            str = socketException.getMessage();
                        }
                        dj djVar = this.a;
                        djVar.q(3, "WebSockets connection lost = " + str);
                    } else if (obj instanceof qj) {
                        WebSocketException webSocketException = ((qj) obj).a;
                        if (webSocketException != null) {
                            str = webSocketException.getMessage();
                        }
                        dj djVar2 = this.a;
                        djVar2.q(4, "WebSockets protocol violation error = " + str);
                    } else if (obj instanceof kj) {
                        dj djVar3 = this.a;
                        djVar3.q(5, "WebSockets internal error (" + ((kj) obj).a.toString() + SmallTailInfo.EMOTION_SUFFIX);
                    } else if (obj instanceof uj) {
                        uj ujVar = (uj) obj;
                        dj djVar4 = this.a;
                        djVar4.q(6, "Server error " + ujVar.a + " (" + ujVar.b + SmallTailInfo.EMOTION_SUFFIX);
                    } else if (obj instanceof jj) {
                        dj djVar5 = this.a;
                        djVar5.q(2, "WebSockets connot connect:" + ((jj) obj).a);
                    } else if (obj instanceof wj) {
                        if (this.a.m != null) {
                            this.a.m.i(((wj) message.obj).a);
                        }
                    } else if (!(obj instanceof lj)) {
                        if (!(obj instanceof sj)) {
                            this.a.B(obj);
                            return;
                        }
                        this.a.s = null;
                        xi xiVar = ((sj) message.obj).a;
                        if (this.a.m != null) {
                            this.a.m.g(2, xiVar);
                        }
                        if (this.a.m != null) {
                            this.a.m.c(xiVar);
                        }
                    } else {
                        this.a.s = null;
                        xi xiVar2 = ((lj) message.obj).a;
                        if (this.a.m != null) {
                            this.a.m.h(xiVar2);
                        }
                        if (this.a.m != null) {
                            this.a.m.c(xiVar2);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dj a;

        public b(dj djVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {djVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = djVar;
        }

        public /* synthetic */ b(dj djVar, a aVar) {
            this(djVar);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Thread.currentThread().setName("WebSocketConnector");
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    zi ziVar = new zi();
                    this.a.d = ziVar.a(this.a.g, this.a.h, this.a.n, false);
                    if (this.a.q) {
                        this.a.C(new hj());
                        return;
                    }
                    try {
                        if (!this.a.d.isConnected()) {
                            this.a.C(new jj(2, "cannot connect"));
                            return;
                        }
                        this.a.r = System.currentTimeMillis() - currentTimeMillis;
                        this.a.t();
                        this.a.u();
                        gj gjVar = new gj(this.a.g + ":" + this.a.h);
                        gjVar.b = this.a.i;
                        gjVar.c = this.a.j;
                        gjVar.e = this.a.k;
                        gjVar.f = this.a.l;
                        this.a.c.b(gjVar);
                        if (this.a.q) {
                            this.a.C(new hj());
                        }
                    } catch (Throwable th) {
                        if (this.a.y()) {
                            BdLog.e("----WebSocketConnector error. e:" + th.getMessage());
                        }
                        this.a.C(new kj(new Exception(th)));
                    }
                } catch (Throwable th2) {
                    this.a.C(new jj(2, th2.getMessage()));
                }
            }
        }
    }

    public dj() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = false;
        this.p = false;
        this.q = false;
        this.s = null;
        s();
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.s != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.b != null) {
            this.b.a();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.c != null) {
            this.c.a();
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.a = new a(this);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b = new zj(this.a, this.d, this.n, "WebSocketReader");
            this.b.start();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
            handlerThread.start();
            this.c = new bk(handlerThread.getLooper(), this.a, this.d, this.n);
        }
    }

    public long v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.b != null) {
                return this.b.c();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public long w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.c != null) {
                return this.c.c();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.p;
        }
        return invokeV.booleanValue;
    }

    public final boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return BdBaseApplication.getInst().isDebugMode();
        }
        return invokeV.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.o;
        }
        return invokeV.booleanValue;
    }

    public final void C(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
            Message obtainMessage = this.a.obtainMessage();
            obtainMessage.obj = obj;
            this.a.sendMessage(obtainMessage);
        }
    }

    public boolean D(xi xiVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, xiVar)) == null) {
            if (xiVar == null) {
                return false;
            }
            if (this.s == null && z()) {
                this.s = xiVar;
                return E(xiVar);
            }
            y();
            if (xiVar != null) {
                xiVar.a(1);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean E(xi xiVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, xiVar)) == null) {
            if (this.c == null) {
                C(new kj(new Exception("mWriter = null")));
                return false;
            }
            return this.c.b(new nj(xiVar));
        }
        return invokeL.booleanValue;
    }

    public void q(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048583, this, i, str) == null) {
            if (BdBaseApplication.getInst().isDebugMode()) {
                Log.d("TB-WebSocket", "连接断开：[" + i + PreferencesUtil.RIGHT_MOUNT + str);
            }
            this.o = false;
            this.q = true;
            if (this.b != null) {
                this.b.p();
                this.b = null;
            }
            if (this.c != null) {
                this.c.i();
                this.c = null;
            }
            zi.a aVar = this.d;
            if (aVar != null) {
                try {
                    aVar.close();
                } catch (Throwable th) {
                    if (y()) {
                        th.printStackTrace();
                    }
                }
                this.d = null;
            }
            bj bjVar = this.m;
            this.m = null;
            if (bjVar != null) {
                try {
                    bjVar.b(i, str);
                } catch (Exception e) {
                    if (y()) {
                        BdLog.d(e.getMessage());
                    }
                }
            }
        }
    }

    public void r(String str, String[] strArr, bj bjVar, yj yjVar, List<BasicNameValuePair> list) throws WebSocketException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, strArr, bjVar, yjVar, list) == null) {
            this.p = true;
            zi.a aVar = this.d;
            if (aVar != null && aVar.isConnected()) {
                throw new WebSocketException("already connected");
            }
            try {
                URI uri = new URI(str);
                this.e = uri;
                if (!uri.getScheme().equals(SpeechSynthesizer.REQUEST_PROTOCOL_WS) && !this.e.getScheme().equals(SpeechSynthesizer.REQUEST_PROTOCOL_WSS)) {
                    throw new WebSocketException("unsupported scheme for WebSockets URI");
                }
                if (!this.e.getScheme().equals(SpeechSynthesizer.REQUEST_PROTOCOL_WSS)) {
                    this.f = this.e.getScheme();
                    if (this.e.getPort() == -1) {
                        if (this.f.equals(SpeechSynthesizer.REQUEST_PROTOCOL_WS)) {
                            this.h = 80;
                        } else {
                            this.h = 443;
                        }
                    } else {
                        this.h = this.e.getPort();
                    }
                    if (this.e.getHost() != null) {
                        this.g = this.e.getHost();
                        if (this.e.getPath() != null && !this.e.getPath().equals("")) {
                            this.i = this.e.getPath();
                            if (this.e.getQuery() != null && !this.e.getQuery().equals("")) {
                                this.j = this.e.getQuery();
                                this.k = strArr;
                                this.l = list;
                                this.m = bjVar;
                                this.n = new yj(yjVar);
                                new b(this, null).start();
                                return;
                            }
                            this.j = null;
                            this.k = strArr;
                            this.l = list;
                            this.m = bjVar;
                            this.n = new yj(yjVar);
                            new b(this, null).start();
                            return;
                        }
                        this.i = "/";
                        if (this.e.getQuery() != null) {
                            this.j = this.e.getQuery();
                            this.k = strArr;
                            this.l = list;
                            this.m = bjVar;
                            this.n = new yj(yjVar);
                            new b(this, null).start();
                            return;
                        }
                        this.j = null;
                        this.k = strArr;
                        this.l = list;
                        this.m = bjVar;
                        this.n = new yj(yjVar);
                        new b(this, null).start();
                        return;
                    }
                    throw new WebSocketException("no host specified in WebSockets URI");
                }
                throw new WebSocketException("secure WebSockets not implemented");
            } catch (URISyntaxException unused) {
                throw new WebSocketException("invalid WebSockets URI");
            }
        }
    }
}
