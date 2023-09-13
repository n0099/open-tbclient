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
import com.baidu.tieba.aj;
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
public class ej {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler a;
    public volatile ak b;
    public volatile ck c;
    public aj.a d;
    public URI e;
    public String f;
    public String g;
    public int h;
    public String i;
    public String j;
    public String[] k;
    public List<BasicNameValuePair> l;
    public cj m;
    public zj n;
    public boolean o;
    public boolean p;
    public volatile boolean q;
    public long r;
    public yi s;

    public void B(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ej a;

        public a(ej ejVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ejVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ejVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                Object obj = message.obj;
                if (obj instanceof yj) {
                    yj yjVar = (yj) obj;
                    if (this.a.m != null) {
                        this.a.m.a(yjVar.a);
                    }
                } else if (obj instanceof sj) {
                    sj sjVar = (sj) obj;
                    if (this.a.m != null) {
                        this.a.m.d(sjVar.a);
                    } else if (this.a.y()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (obj instanceof gj) {
                    gj gjVar = (gj) obj;
                    if (this.a.m != null) {
                        this.a.m.f(gjVar);
                    } else if (this.a.y()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (obj instanceof pj) {
                    qj qjVar = new qj();
                    qjVar.a = ((pj) obj).a;
                    this.a.c.b(qjVar);
                } else if (obj instanceof qj) {
                    qj qjVar2 = (qj) obj;
                    if (this.a.m != null) {
                        this.a.m.e();
                    }
                } else {
                    String str = null;
                    if (obj instanceof ij) {
                        this.a.q(1, null);
                    } else if (obj instanceof wj) {
                        wj wjVar = (wj) obj;
                        if (wjVar.a) {
                            if (this.a.m != null) {
                                this.a.m.onOpen(wjVar.b);
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
                    } else if (obj instanceof jj) {
                        SocketException socketException = ((jj) obj).a;
                        if (socketException != null) {
                            str = socketException.getMessage();
                        }
                        ej ejVar = this.a;
                        ejVar.q(3, "WebSockets connection lost = " + str);
                    } else if (obj instanceof rj) {
                        WebSocketException webSocketException = ((rj) obj).a;
                        if (webSocketException != null) {
                            str = webSocketException.getMessage();
                        }
                        ej ejVar2 = this.a;
                        ejVar2.q(4, "WebSockets protocol violation error = " + str);
                    } else if (obj instanceof lj) {
                        ej ejVar3 = this.a;
                        ejVar3.q(5, "WebSockets internal error (" + ((lj) obj).a.toString() + SmallTailInfo.EMOTION_SUFFIX);
                    } else if (obj instanceof vj) {
                        vj vjVar = (vj) obj;
                        ej ejVar4 = this.a;
                        ejVar4.q(6, "Server error " + vjVar.a + " (" + vjVar.b + SmallTailInfo.EMOTION_SUFFIX);
                    } else if (obj instanceof kj) {
                        ej ejVar5 = this.a;
                        ejVar5.q(2, "WebSockets connot connect:" + ((kj) obj).a);
                    } else if (obj instanceof xj) {
                        if (this.a.m != null) {
                            this.a.m.i(((xj) message.obj).a);
                        }
                    } else if (!(obj instanceof mj)) {
                        if (!(obj instanceof tj)) {
                            this.a.B(obj);
                            return;
                        }
                        this.a.s = null;
                        yi yiVar = ((tj) message.obj).a;
                        if (this.a.m != null) {
                            this.a.m.g(2, yiVar);
                        }
                        if (this.a.m != null) {
                            this.a.m.c(yiVar);
                        }
                    } else {
                        this.a.s = null;
                        yi yiVar2 = ((mj) message.obj).a;
                        if (this.a.m != null) {
                            this.a.m.h(yiVar2);
                        }
                        if (this.a.m != null) {
                            this.a.m.c(yiVar2);
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
        public final /* synthetic */ ej a;

        public b(ej ejVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ejVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ejVar;
        }

        public /* synthetic */ b(ej ejVar, a aVar) {
            this(ejVar);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Thread.currentThread().setName("WebSocketConnector");
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    aj ajVar = new aj();
                    this.a.d = ajVar.a(this.a.g, this.a.h, this.a.n, false);
                    if (this.a.q) {
                        this.a.C(new ij());
                        return;
                    }
                    try {
                        if (!this.a.d.isConnected()) {
                            this.a.C(new kj(2, "cannot connect"));
                            return;
                        }
                        this.a.r = System.currentTimeMillis() - currentTimeMillis;
                        this.a.t();
                        this.a.u();
                        hj hjVar = new hj(this.a.g + ":" + this.a.h);
                        hjVar.b = this.a.i;
                        hjVar.c = this.a.j;
                        hjVar.e = this.a.k;
                        hjVar.f = this.a.l;
                        this.a.c.b(hjVar);
                        if (this.a.q) {
                            this.a.C(new ij());
                        }
                    } catch (Throwable th) {
                        if (this.a.y()) {
                            BdLog.e("----WebSocketConnector error. e:" + th.getMessage());
                        }
                        this.a.C(new lj(new Exception(th)));
                    }
                } catch (Throwable th2) {
                    this.a.C(new kj(2, th2.getMessage()));
                }
            }
        }
    }

    public ej() {
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
            this.b = new ak(this.a, this.d, this.n, "WebSocketReader");
            this.b.start();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
            handlerThread.start();
            this.c = new ck(handlerThread.getLooper(), this.a, this.d, this.n);
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

    public boolean D(yi yiVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, yiVar)) == null) {
            if (yiVar == null) {
                return false;
            }
            if (this.s == null && z()) {
                this.s = yiVar;
                return E(yiVar);
            }
            y();
            if (yiVar != null) {
                yiVar.a(1);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean E(yi yiVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, yiVar)) == null) {
            if (this.c == null) {
                C(new lj(new Exception("mWriter = null")));
                return false;
            }
            return this.c.b(new oj(yiVar));
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
            aj.a aVar = this.d;
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
            cj cjVar = this.m;
            this.m = null;
            if (cjVar != null) {
                try {
                    cjVar.b(i, str);
                } catch (Exception e) {
                    if (y()) {
                        BdLog.d(e.getMessage());
                    }
                }
            }
        }
    }

    public void r(String str, String[] strArr, cj cjVar, zj zjVar, List<BasicNameValuePair> list) throws WebSocketException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, strArr, cjVar, zjVar, list) == null) {
            this.p = true;
            aj.a aVar = this.d;
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
                                this.m = cjVar;
                                this.n = new zj(zjVar);
                                new b(this, null).start();
                                return;
                            }
                            this.j = null;
                            this.k = strArr;
                            this.l = list;
                            this.m = cjVar;
                            this.n = new zj(zjVar);
                            new b(this, null).start();
                            return;
                        }
                        this.i = "/";
                        if (this.e.getQuery() != null) {
                            this.j = this.e.getQuery();
                            this.k = strArr;
                            this.l = list;
                            this.m = cjVar;
                            this.n = new zj(zjVar);
                            new b(this, null).start();
                            return;
                        }
                        this.j = null;
                        this.k = strArr;
                        this.l = list;
                        this.m = cjVar;
                        this.n = new zj(zjVar);
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
