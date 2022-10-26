package com.baidu.tieba;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.WebSocketException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.ck;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
/* loaded from: classes4.dex */
public class gk {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler a;
    public volatile cl b;
    public volatile el c;
    public ck.a d;
    public URI e;
    public String f;
    public String g;
    public int h;
    public String i;
    public String j;
    public String[] k;
    public List l;
    public ek m;
    public bl n;
    public boolean o;
    public boolean p;
    public volatile boolean q;
    public long r;
    public ak s;

    public void G(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, obj) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gk a;

        public a(gk gkVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gkVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gkVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                Object obj = message.obj;
                if (obj instanceof al) {
                    al alVar = (al) obj;
                    if (this.a.m != null) {
                        this.a.m.a(alVar.a);
                    }
                } else if (obj instanceof uk) {
                    uk ukVar = (uk) obj;
                    if (this.a.m != null) {
                        this.a.m.d(ukVar.a);
                    } else if (this.a.D()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (obj instanceof ik) {
                    ik ikVar = (ik) obj;
                    if (this.a.m != null) {
                        this.a.m.f(ikVar);
                    } else if (this.a.D()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (obj instanceof rk) {
                    sk skVar = new sk();
                    skVar.a = ((rk) obj).a;
                    this.a.c.b(skVar);
                } else if (obj instanceof sk) {
                    sk skVar2 = (sk) obj;
                    if (this.a.m != null) {
                        this.a.m.e();
                    }
                } else {
                    String str = null;
                    if (obj instanceof kk) {
                        this.a.q(1, null);
                    } else if (obj instanceof yk) {
                        yk ykVar = (yk) obj;
                        if (ykVar.a) {
                            if (this.a.m != null) {
                                this.a.m.onOpen(ykVar.b);
                                this.a.o = true;
                                this.a.p = false;
                                if (this.a.m != null) {
                                    this.a.m.c(null);
                                    return;
                                }
                                return;
                            }
                            this.a.q(6, "handler already NULL");
                        }
                    } else if (obj instanceof lk) {
                        SocketException socketException = ((lk) obj).a;
                        if (socketException != null) {
                            str = socketException.getMessage();
                        }
                        gk gkVar = this.a;
                        gkVar.q(3, "WebSockets connection lost = " + str);
                    } else if (obj instanceof tk) {
                        WebSocketException webSocketException = ((tk) obj).a;
                        if (webSocketException != null) {
                            str = webSocketException.getMessage();
                        }
                        gk gkVar2 = this.a;
                        gkVar2.q(4, "WebSockets protocol violation error = " + str);
                    } else if (obj instanceof nk) {
                        gk gkVar3 = this.a;
                        gkVar3.q(5, "WebSockets internal error (" + ((nk) obj).a.toString() + SmallTailInfo.EMOTION_SUFFIX);
                    } else if (obj instanceof xk) {
                        xk xkVar = (xk) obj;
                        gk gkVar4 = this.a;
                        gkVar4.q(6, "Server error " + xkVar.a + " (" + xkVar.b + SmallTailInfo.EMOTION_SUFFIX);
                    } else if (obj instanceof mk) {
                        gk gkVar5 = this.a;
                        gkVar5.q(2, "WebSockets connot connect:" + ((mk) obj).a);
                    } else if (obj instanceof zk) {
                        if (this.a.m != null) {
                            this.a.m.i(((zk) message.obj).a);
                        }
                    } else if (!(obj instanceof ok)) {
                        if (!(obj instanceof vk)) {
                            this.a.G(obj);
                            return;
                        }
                        this.a.s = null;
                        ak akVar = ((vk) message.obj).a;
                        if (this.a.m != null) {
                            this.a.m.g(2, akVar);
                        }
                        if (this.a.m != null) {
                            this.a.m.c(akVar);
                        }
                    } else {
                        this.a.s = null;
                        ak akVar2 = ((ok) message.obj).a;
                        if (this.a.m != null) {
                            this.a.m.h(akVar2);
                        }
                        if (this.a.m != null) {
                            this.a.m.c(akVar2);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gk a;

        public b(gk gkVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gkVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gkVar;
        }

        public /* synthetic */ b(gk gkVar, a aVar) {
            this(gkVar);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Thread.currentThread().setName("WebSocketConnector");
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    ck ckVar = new ck();
                    this.a.d = ckVar.a(this.a.g, this.a.h, this.a.n, false);
                    if (this.a.q) {
                        this.a.H(new kk());
                        return;
                    }
                    try {
                        if (!this.a.d.isConnected()) {
                            this.a.H(new mk(2, "cannot connect"));
                            return;
                        }
                        this.a.r = System.currentTimeMillis() - currentTimeMillis;
                        this.a.t();
                        this.a.u();
                        jk jkVar = new jk(this.a.g + ":" + this.a.h);
                        jkVar.b = this.a.i;
                        jkVar.c = this.a.j;
                        jkVar.e = this.a.k;
                        jkVar.f = this.a.l;
                        this.a.c.b(jkVar);
                        if (this.a.q) {
                            this.a.H(new kk());
                        }
                    } catch (Throwable th) {
                        if (this.a.D()) {
                            BdLog.e("----WebSocketConnector error. e:" + th.getMessage());
                        }
                        this.a.H(new nk(new Exception(th)));
                    }
                } catch (Throwable th2) {
                    this.a.H(new mk(2, th2.getMessage()));
                }
            }
        }
    }

    public gk() {
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
        this.r = 0L;
        this.s = null;
        s();
    }

    public final void H(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, obj) == null) {
            Message obtainMessage = this.a.obtainMessage();
            obtainMessage.obj = obj;
            this.a.sendMessage(obtainMessage);
        }
    }

    public boolean I(ak akVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, akVar)) == null) {
            if (akVar == null) {
                return false;
            }
            if (this.s == null && E()) {
                this.s = akVar;
                return J(akVar);
            }
            D();
            if (akVar != null) {
                akVar.a(1);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean J(ak akVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, akVar)) == null) {
            if (this.c == null) {
                H(new nk(new Exception("mWriter = null")));
                return false;
            }
            return this.c.b(new qk(akVar));
        }
        return invokeL.booleanValue;
    }

    public long A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ck.a aVar = this.d;
            if (aVar != null) {
                return aVar.c();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ck.a aVar = this.d;
            if (aVar != null) {
                return aVar.d();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.p;
        }
        return invokeV.booleanValue;
    }

    public final boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return BdBaseApplication.getInst().isDebugMode();
        }
        return invokeV.booleanValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.o;
        }
        return invokeV.booleanValue;
    }

    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.s != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && this.b != null) {
            this.b.a();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.c != null) {
            this.c.a();
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.a = new a(this);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.b = new cl(this.a, this.d, this.n, "WebSocketReader");
            this.b.start();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
            handlerThread.start();
            this.c = new el(handlerThread.getLooper(), this.a, this.d, this.n);
        }
    }

    public long v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.b != null) {
                return this.b.c();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            ck.a aVar = this.d;
            if (aVar != null) {
                return aVar.getLocalDns();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            ck.a aVar = this.d;
            if (aVar != null) {
                return aVar.b();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public long y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (this.c != null) {
                return this.c.c();
            }
            return 0L;
        }
        return invokeV.longValue;
    }

    public long z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.r;
        }
        return invokeV.longValue;
    }

    public void q(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048588, this, i, str) == null) {
            if (SwitchManager.getInstance().findType("need_more_logs") == 1) {
                va.a("more_log", 0, 0, "close", i, str);
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
            ck.a aVar = this.d;
            if (aVar != null) {
                try {
                    aVar.close();
                } catch (Throwable th) {
                    if (D()) {
                        th.printStackTrace();
                    }
                }
                this.d = null;
            }
            ek ekVar = this.m;
            this.m = null;
            if (ekVar != null) {
                try {
                    ekVar.b(i, str);
                } catch (Exception e) {
                    if (D()) {
                        BdLog.d(e.getMessage());
                    }
                }
            }
        }
    }

    public void r(String str, String[] strArr, ek ekVar, bl blVar, List list) throws WebSocketException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048589, this, str, strArr, ekVar, blVar, list) == null) {
            this.p = true;
            ck.a aVar = this.d;
            if (aVar != null && aVar.isConnected()) {
                throw new WebSocketException("already connected");
            }
            try {
                URI uri = new URI(str);
                this.e = uri;
                if (!uri.getScheme().equals("ws") && !this.e.getScheme().equals("wss")) {
                    throw new WebSocketException("unsupported scheme for WebSockets URI");
                }
                if (!this.e.getScheme().equals("wss")) {
                    this.f = this.e.getScheme();
                    if (this.e.getPort() == -1) {
                        if (this.f.equals("ws")) {
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
                                this.m = ekVar;
                                this.n = new bl(blVar);
                                new b(this, null).start();
                                return;
                            }
                            this.j = null;
                            this.k = strArr;
                            this.l = list;
                            this.m = ekVar;
                            this.n = new bl(blVar);
                            new b(this, null).start();
                            return;
                        }
                        this.i = "/";
                        if (this.e.getQuery() != null) {
                            this.j = this.e.getQuery();
                            this.k = strArr;
                            this.l = list;
                            this.m = ekVar;
                            this.n = new bl(blVar);
                            new b(this, null).start();
                            return;
                        }
                        this.j = null;
                        this.k = strArr;
                        this.l = list;
                        this.m = ekVar;
                        this.n = new bl(blVar);
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
