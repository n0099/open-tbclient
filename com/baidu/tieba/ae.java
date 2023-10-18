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
import com.baidu.tieba.wd;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes5.dex */
public class ae {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Handler a;
    public volatile we b;
    public volatile ye c;
    public wd.a d;
    public URI e;
    public String f;
    public String g;
    public int h;
    public String i;
    public String j;
    public String[] k;
    public List<BasicNameValuePair> l;
    public yd m;
    public ve n;
    public boolean o;
    public boolean p;
    public volatile boolean q;
    public long r;
    public ud s;

    public void B(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ae a;

        public a(ae aeVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aeVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aeVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                Object obj = message.obj;
                if (obj instanceof ue) {
                    ue ueVar = (ue) obj;
                    if (this.a.m != null) {
                        this.a.m.a(ueVar.a);
                    }
                } else if (obj instanceof oe) {
                    oe oeVar = (oe) obj;
                    if (this.a.m != null) {
                        this.a.m.d(oeVar.a);
                    } else if (this.a.y()) {
                        BdLog.d("could not call onRawTextMessage() .. handler already NULL");
                    }
                } else if (obj instanceof ce) {
                    ce ceVar = (ce) obj;
                    if (this.a.m != null) {
                        this.a.m.f(ceVar);
                    } else if (this.a.y()) {
                        BdLog.d("could not call onBinaryMessage() .. handler already NULL");
                    }
                } else if (obj instanceof le) {
                    me meVar = new me();
                    meVar.a = ((le) obj).a;
                    this.a.c.b(meVar);
                } else if (obj instanceof me) {
                    me meVar2 = (me) obj;
                    if (this.a.m != null) {
                        this.a.m.e();
                    }
                } else {
                    String str = null;
                    if (obj instanceof ee) {
                        this.a.q(1, null);
                    } else if (obj instanceof se) {
                        se seVar = (se) obj;
                        if (seVar.a) {
                            if (this.a.m != null) {
                                this.a.m.onOpen(seVar.b);
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
                    } else if (obj instanceof fe) {
                        SocketException socketException = ((fe) obj).a;
                        if (socketException != null) {
                            str = socketException.getMessage();
                        }
                        ae aeVar = this.a;
                        aeVar.q(3, "WebSockets connection lost = " + str);
                    } else if (obj instanceof ne) {
                        WebSocketException webSocketException = ((ne) obj).a;
                        if (webSocketException != null) {
                            str = webSocketException.getMessage();
                        }
                        ae aeVar2 = this.a;
                        aeVar2.q(4, "WebSockets protocol violation error = " + str);
                    } else if (obj instanceof he) {
                        ae aeVar3 = this.a;
                        aeVar3.q(5, "WebSockets internal error (" + ((he) obj).a.toString() + SmallTailInfo.EMOTION_SUFFIX);
                    } else if (obj instanceof re) {
                        re reVar = (re) obj;
                        ae aeVar4 = this.a;
                        aeVar4.q(6, "Server error " + reVar.a + " (" + reVar.b + SmallTailInfo.EMOTION_SUFFIX);
                    } else if (obj instanceof ge) {
                        ae aeVar5 = this.a;
                        aeVar5.q(2, "WebSockets connot connect:" + ((ge) obj).a);
                    } else if (obj instanceof te) {
                        if (this.a.m != null) {
                            this.a.m.i(((te) message.obj).a);
                        }
                    } else if (!(obj instanceof ie)) {
                        if (!(obj instanceof pe)) {
                            this.a.B(obj);
                            return;
                        }
                        this.a.s = null;
                        ud udVar = ((pe) message.obj).a;
                        if (this.a.m != null) {
                            this.a.m.g(2, udVar);
                        }
                        if (this.a.m != null) {
                            this.a.m.c(udVar);
                        }
                    } else {
                        this.a.s = null;
                        ud udVar2 = ((ie) message.obj).a;
                        if (this.a.m != null) {
                            this.a.m.h(udVar2);
                        }
                        if (this.a.m != null) {
                            this.a.m.c(udVar2);
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
        public final /* synthetic */ ae a;

        public b(ae aeVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aeVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aeVar;
        }

        public /* synthetic */ b(ae aeVar, a aVar) {
            this(aeVar);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Thread.currentThread().setName("WebSocketConnector");
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    wd wdVar = new wd();
                    this.a.d = wdVar.a(this.a.g, this.a.h, this.a.n, false);
                    if (this.a.q) {
                        this.a.C(new ee());
                        return;
                    }
                    try {
                        if (!this.a.d.isConnected()) {
                            this.a.C(new ge(2, "cannot connect"));
                            return;
                        }
                        this.a.r = System.currentTimeMillis() - currentTimeMillis;
                        this.a.t();
                        this.a.u();
                        de deVar = new de(this.a.g + ":" + this.a.h);
                        deVar.b = this.a.i;
                        deVar.c = this.a.j;
                        deVar.e = this.a.k;
                        deVar.f = this.a.l;
                        this.a.c.b(deVar);
                        if (this.a.q) {
                            this.a.C(new ee());
                        }
                    } catch (Throwable th) {
                        if (this.a.y()) {
                            BdLog.e("----WebSocketConnector error. e:" + th.getMessage());
                        }
                        this.a.C(new he(new Exception(th)));
                    }
                } catch (Throwable th2) {
                    this.a.C(new ge(2, th2.getMessage()));
                }
            }
        }
    }

    public ae() {
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
            this.b = new we(this.a, this.d, this.n, "WebSocketReader");
            this.b.start();
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            HandlerThread handlerThread = new HandlerThread("WebSocketWriter");
            handlerThread.start();
            this.c = new ye(handlerThread.getLooper(), this.a, this.d, this.n);
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

    public boolean D(ud udVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, udVar)) == null) {
            if (udVar == null) {
                return false;
            }
            if (this.s == null && z()) {
                this.s = udVar;
                return E(udVar);
            }
            y();
            if (udVar != null) {
                udVar.a(1);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean E(ud udVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, udVar)) == null) {
            if (this.c == null) {
                C(new he(new Exception("mWriter = null")));
                return false;
            }
            return this.c.b(new ke(udVar));
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
            wd.a aVar = this.d;
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
            yd ydVar = this.m;
            this.m = null;
            if (ydVar != null) {
                try {
                    ydVar.b(i, str);
                } catch (Exception e) {
                    if (y()) {
                        BdLog.d(e.getMessage());
                    }
                }
            }
        }
    }

    public void r(String str, String[] strArr, yd ydVar, ve veVar, List<BasicNameValuePair> list) throws WebSocketException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, strArr, ydVar, veVar, list) == null) {
            this.p = true;
            wd.a aVar = this.d;
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
                                this.m = ydVar;
                                this.n = new ve(veVar);
                                new b(this, null).start();
                                return;
                            }
                            this.j = null;
                            this.k = strArr;
                            this.l = list;
                            this.m = ydVar;
                            this.n = new ve(veVar);
                            new b(this, null).start();
                            return;
                        }
                        this.i = "/";
                        if (this.e.getQuery() != null) {
                            this.j = this.e.getQuery();
                            this.k = strArr;
                            this.l = list;
                            this.m = ydVar;
                            this.n = new ve(veVar);
                            new b(this, null).start();
                            return;
                        }
                        this.j = null;
                        this.k = strArr;
                        this.l = list;
                        this.m = ydVar;
                        this.n = new ve(veVar);
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
