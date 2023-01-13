package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.ResponseCode;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.upload.utils.RequsetNetworkUtils;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.lcp.sdk.client.bean.BLCPRequest;
import com.baidu.lcp.sdk.connect.QuicMessageHandler;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeGetResponseMsg;
import com.baidu.tieba.t80;
import com.baidu.tieba.w80;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.db.ProbeTB;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.PayUVEventType;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Observable;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.http.cookie.ClientCookie;
/* loaded from: classes3.dex */
public final class a90 extends Observable {
    public static /* synthetic */ Interceptable $ic;
    public static volatile q80 F;
    public static volatile a90 G;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public String B;
    public String C;
    public String D;
    public Runnable E;
    public AtomicInteger a;
    public int b;
    public boolean c;
    public volatile LinkedList<x80> d;
    public final HashMap<Long, x80> e;
    public final Object f;
    public final Object g;
    public e90 h;
    public Map<Long, v80> i;
    public Map<Long, v80> j;
    public h k;
    public g l;
    public f m;
    public boolean n;
    public AtomicInteger o;
    public Context p;
    public y80 q;
    public j r;
    public i s;
    public HandlerThread t;
    public e u;
    @SuppressLint({"MobilebdThread"})
    public Thread v;
    public AtomicBoolean w;
    public AtomicBoolean x;
    public long y;
    public long z;

    public final long N(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (i2 < 3) {
                return i2 * 1000;
            }
            return 3000L;
        }
        return invokeI.longValue;
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ a90 d;

        /* renamed from: com.baidu.tieba.a90$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0220a implements w80.d {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ long a;
            public final /* synthetic */ a b;

            public C0220a(a aVar, long j) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, Long.valueOf(j)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = j;
            }

            @Override // com.baidu.tieba.w80.d
            public void a(int i, String str, String str2) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, str2) == null) {
                    q90.b("SocketTransceiver", "DNS resolve result ip: " + str2 + " cost: " + (System.currentTimeMillis() - this.a) + " ms");
                    if (TextUtils.isEmpty(str2)) {
                        str2 = this.b.a;
                    }
                    a90 a90Var = this.b.d;
                    a90Var.A = str2;
                    j80 g = i80.h(a90Var.p).g(601110);
                    g.c("dns_end", System.currentTimeMillis());
                    g.d(ClientCookie.PORT_ATTR, this.b.b);
                    g.d("ip", str2);
                    g.d("domain", this.b.a);
                    g.d(ProbeTB.PROTOCOL, this.b.c);
                    g.d("con_err_code", "P31");
                    g.b("retry_cout", this.b.d.o.get());
                    g.b("connect_state", 2);
                    if (a90.F.a == -1) {
                        a aVar = this.b;
                        a90 a90Var2 = aVar.d;
                        new d(a90Var2, str2, aVar.b, Integer.valueOf(a90Var2.a.incrementAndGet())).run();
                    }
                }
            }
        }

        public a(a90 a90Var, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a90Var, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = a90Var;
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                long currentTimeMillis = System.currentTimeMillis();
                i80.h(this.d.p).g(601110).c("dns_begin", System.currentTimeMillis());
                w80.c(this.d.p).b(this.a, new C0220a(this, currentTimeMillis));
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public String b;
        public Integer c;
        public final /* synthetic */ a90 d;

        /* loaded from: classes3.dex */
        public class a implements Callable<z80> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ d a;

            public a(d dVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {dVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = dVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public z80 call() throws Exception {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                    q90.a("SocketTransceiver", "socketStateFutureTask star call()");
                    i80.h(this.a.d.p).g(601110).d("P22", "socket connect thread start");
                    return this.a.d.q.e(this.a.b, Integer.valueOf(this.a.a).intValue());
                }
                return (z80) invokeV.objValue;
            }
        }

        public d(a90 a90Var, String str, String str2, Integer num) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a90Var, str, str2, num};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = a90Var;
            this.b = str;
            this.a = str2;
            this.c = num;
        }

        @Override // java.lang.Runnable
        @SuppressLint({"MobilebdThread"})
        public synchronized void run() {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this) {
                    q90.a("SocketTransceiver", "start socket connect, connectTaskId: " + this.c);
                    try {
                    } catch (Exception e) {
                        q90.c("SocketTransceiver", "socket connect by ConnectTask occur exception: ", e);
                        this.d.R("socket connect by ConnectTask occur exception: " + e, this.b, true);
                    }
                    if (a90.F.a != -1) {
                        q90.a("SocketTransceiver", "socketConnectState is " + this.d.U() + ", return");
                        return;
                    }
                    a90.F.a = -2;
                    if (this.d.L()) {
                        q90.a("SocketTransceiver", "socket create begin, but socket has created ok.");
                        j80 g = i80.h(this.d.p).g(601110);
                        g.d("P11", "socket create begin, but socket has created ok.");
                        g.d("con_err_code", "P11");
                        g.b("retry_cout", this.d.o.get());
                        this.d.M();
                    }
                    if (this.d.v != null && this.d.v.isAlive()) {
                        this.d.v.interrupt();
                        q90.a("SocketTransceiver", "socketConnectThread interrupt");
                    }
                    if (this.d.l != null && this.d.l.isAlive()) {
                        this.d.l.interrupt();
                        q90.a("SocketTransceiver", "readThread interrupt");
                    }
                    if (this.d.k != null && this.d.k.isAlive()) {
                        this.d.k.interrupt();
                        q90.a("SocketTransceiver", "sendThread interrupt");
                    }
                    try {
                        q90.a("SocketTransceiver", "socket ConnectTask start create Socket Object for connect");
                        long currentTimeMillis = System.currentTimeMillis();
                        j80 g2 = i80.h(this.d.p).g(601110);
                        g2.b("connect_state", 3);
                        g2.c("socket_begin", System.currentTimeMillis());
                        FutureTask futureTask = new FutureTask(new a(this));
                        this.d.v = new Thread(futureTask);
                        this.d.v.start();
                        q90.a("SocketTransceiver", "ConnectTask run FutureTask by socketConnectThread for create Socket Object");
                        z80 z80Var = (z80) futureTask.get(5000L, TimeUnit.MILLISECONDS);
                        i80.h(this.d.p).g(601110).c("socket_end", System.currentTimeMillis());
                        q90.b("SocketTransceiver", "socket ConnectTask create Socket end, cost time: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                        if (z80Var != null) {
                            if (this.d.L()) {
                                q90.a("SocketTransceiver", "socketConnect after, but socket has created ok.");
                                j80 g3 = i80.h(this.d.p).g(601110);
                                g3.d("P12", "socketConnect after, but socket has created ok.");
                                g3.d("con_err_code", "P12");
                                g3.b("retry_cout", this.d.o.get());
                                this.d.M();
                            }
                            if (!z80Var.b.booleanValue()) {
                                j80 g4 = i80.h(this.d.p).g(601110);
                                g4.d("P14", "connect env error:" + this.b);
                                g4.d("con_err_code", "P14");
                                g4.b("retry_cout", this.d.o.get());
                                this.d.o0("connect env error:", this.b);
                                return;
                            }
                            q90.a("SocketTransceiver", "socketState verified ENV approved, start setCurrentSocketState");
                            this.d.q.c(z80Var);
                            if (this.d.v != null && this.d.v.isAlive()) {
                                this.d.v.interrupt();
                                q90.a("SocketTransceiver", "socketConnectThread interrupt");
                            }
                            q90.d("SocketTransceiver", "create Socket ok");
                            j80 g5 = i80.h(this.d.p).g(601110);
                            g5.d("P15", "create Socket ok");
                            g5.d("con_err_code", "P15");
                            Context context = this.d.p;
                            if (this.d.o.get() == 0) {
                                i = 1;
                            } else {
                                i = 2;
                            }
                            r90.z(context, i);
                            w80.g(this.d.p, this.b);
                            q90.a("SocketTransceiver", "socket ConnectTask end, start lcp login");
                            this.d.l0(this.d.W(true));
                            this.d.y = SystemClock.currentThreadTimeMillis();
                            q90.a("SocketTransceiver", "socket connected: create socket success when currentThreadTimeMillis is " + this.d.y);
                            this.d.n = false;
                            this.d.k = new h(this.d, this.b);
                            this.d.k.start();
                            this.d.l = new g(this.d, this.b);
                            this.d.l.start();
                            this.d.w.set(false);
                            q90.b("SocketTransceiver", "connectTaskRunning.set(false)");
                            return;
                        }
                        throw new RuntimeException("crate socket end, get SocketState is null");
                    } catch (Throwable th) {
                        String str = "ConnectTask exception: " + th;
                        q90.c("SocketTransceiver", str, th);
                        q90.b("SocketTransceiver", "socket ConnectTask create Socket end, cost time: " + (System.currentTimeMillis() - 0) + " ms");
                        if (this.d.v != null && this.d.v.isAlive()) {
                            this.d.v.interrupt();
                            q90.a("SocketTransceiver", "socketConnectThread interrupt");
                        }
                        i80.h(this.d.p).g(601110).c("socket_end", System.currentTimeMillis());
                        this.d.R(str, this.b, true);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a90 a;

        public b(a90 a90Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a90Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a90Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a90 a90Var = this.a;
                a90Var.l0(a90Var.W(false));
            }
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class c {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-991112078, "Lcom/baidu/tieba/a90$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-991112078, "Lcom/baidu/tieba/a90$c;");
                    return;
                }
            }
            int[] iArr = new int[BLCPRequest.SendTimeoutSecond.values().length];
            a = iArr;
            try {
                iArr[BLCPRequest.SendTimeoutSecond.TIMEOUT_20s.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[BLCPRequest.SendTimeoutSecond.TIMEOUT_30s.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[BLCPRequest.SendTimeoutSecond.TIMEOUT_50s.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[BLCPRequest.SendTimeoutSecond.TIMEOUT_120s.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public final /* synthetic */ a90 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(a90 a90Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a90Var, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a90Var;
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.a = str;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
                super.handleMessage(message);
                if (message.what == 1) {
                    long j = message.arg1;
                    synchronized (this.b.g) {
                        this.b.e0(j, this.a);
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public final /* synthetic */ a90 b;

        public f(a90 a90Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a90Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a90Var;
            this.a = 60000L;
        }

        public /* synthetic */ f(a90 a90Var, a aVar) {
            this(a90Var);
        }

        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.a = j;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.b.u.removeCallbacks(this.b.m);
                this.b.u.postDelayed(this.b.m, this.a);
                a90 a90Var = this.b;
                a90Var.l0(a90Var.h.b(this.b.p, 3L));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public final /* synthetic */ a90 b;

        public g(a90 a90Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a90Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a90Var;
            this.a = str;
            setName("LCP-SocketTransceiver-readThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            x80 x80Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.b.n) {
                    try {
                        x80 x80Var2 = null;
                        try {
                            x80Var2 = this.b.h.c(this.b.q.b());
                            if (x80Var2 != null && x80Var2.o > 0) {
                                this.b.u.removeCallbacks(this.b.r);
                                x80Var2.n = false;
                                if (p90.a) {
                                    q90.d("SocketTransceiver", "ReadThread receive a message : " + x80Var2.toString());
                                }
                                if (!x80Var2.l) {
                                    if (x80Var2.j == 1 && x80Var2.i == 4) {
                                        Context context = this.b.p;
                                        o90.a(context, 1L, "read", x80Var2.o + "");
                                    }
                                    if (x80Var2.j == 50 && x80Var2.i == 2) {
                                        Context context2 = this.b.p;
                                        o90.a(context2, 50L, "read", x80Var2.o + "");
                                    }
                                    synchronized (this.b.g) {
                                        x80Var = (x80) this.b.e.remove(Long.valueOf(x80Var2.o));
                                        if (x80Var != null) {
                                            q90.a("SocketTransceiver", "ReadThread receive a msg which we request before");
                                        }
                                    }
                                    this.b.c0(x80Var2, x80Var, this.a);
                                }
                                synchronized (this.b.g) {
                                    if (this.b.e.size() != 0) {
                                        q90.a("SocketTransceiver", "ReadThread [sendMessageMap.size() != 0], restart socketReadAndWriteTimeoutRunnable");
                                        this.b.r.b(x80Var2.o);
                                        this.b.r.a(this.a);
                                        this.b.u.a(this.a);
                                        this.b.u.postDelayed(this.b.r, x80Var2.c);
                                    }
                                }
                            }
                        } catch (Exception e) {
                            q90.c("SocketTransceiver", "ReadThread read message exception, mClose is " + this.b.n + " exception: " + e, e);
                            this.b.Y(x80Var2, true);
                            if (this.b.n) {
                                return;
                            }
                            this.b.c = false;
                            a90 a90Var = this.b;
                            a90Var.R("ReadThread read message exception: " + e, this.a, false);
                            return;
                        }
                    } catch (Exception e2) {
                        q90.c("SocketTransceiver", "ReadThread exception, mClose is " + this.b.n + " exception: " + e2, e2);
                        if (this.b.n) {
                            return;
                        }
                        this.b.c = false;
                        a90 a90Var2 = this.b;
                        a90Var2.R("ReadThread exception: " + e2, this.a, false);
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public final /* synthetic */ a90 b;

        public h(a90 a90Var, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a90Var, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a90Var;
            this.a = str;
            setName("LCP-SocketTransceiver-SendThread");
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!this.b.n) {
                    try {
                        x80 x80Var = null;
                        try {
                            synchronized (this.b.d) {
                                if (this.b.d.size() == 0) {
                                    this.b.d.wait();
                                } else {
                                    x80Var = (x80) this.b.d.removeFirst();
                                }
                            }
                        } catch (InterruptedException e) {
                            q90.b("SocketTransceiver", "SendThread wait exception, mClose is " + this.b.n + ", exception: " + e);
                            if (this.b.n) {
                                return;
                            }
                            this.b.c = false;
                            a90 a90Var = this.b;
                            a90Var.R("SendThread wait exception: " + e, this.a, false);
                        }
                        if (x80Var != null) {
                            try {
                                if (!this.b.n) {
                                    x80Var.n = true;
                                    x80Var.k = a90.F.a;
                                    if (x80Var.p) {
                                        synchronized (this.b.g) {
                                            if (this.b.e.isEmpty()) {
                                                this.b.u.removeCallbacks(this.b.r);
                                                this.b.r.b(x80Var.o);
                                                this.b.r.a(this.a);
                                                this.b.u.a(this.a);
                                                this.b.u.postDelayed(this.b.r, 5000L);
                                            }
                                        }
                                    }
                                    if (p90.a) {
                                        q90.e("SocketTransceiver", "SendThread :" + x80Var.toString());
                                    }
                                    if (x80Var.j == 1 && x80Var.i == 4) {
                                        Context context = this.b.p;
                                        o90.a(context, 1L, "send", x80Var.o + "");
                                    }
                                    if (x80Var.j == 50 && x80Var.i == 2) {
                                        Context context2 = this.b.p;
                                        o90.a(context2, 50L, "send", x80Var.o + "");
                                    }
                                    x80Var.b = System.currentTimeMillis();
                                    synchronized (this.b.f) {
                                        this.b.q.f(x80Var);
                                    }
                                    if (!x80Var.l && x80Var.p) {
                                        synchronized (this.b.g) {
                                            this.b.e.put(Long.valueOf(x80Var.o), x80Var);
                                        }
                                    }
                                } else {
                                    this.b.d0(x80Var.o, this.a);
                                    return;
                                }
                            } catch (Exception e2) {
                                q90.c("SocketTransceiver", "SendThread sendMessage message exception, mClose is " + this.b.n, e2);
                                this.b.Y(x80Var, false);
                                this.b.Z(x80Var.o, e2.toString(), this.a);
                                if (this.b.n) {
                                    return;
                                }
                                this.b.c = false;
                                a90 a90Var2 = this.b;
                                a90Var2.R("SendThread sendMessage Exception:" + e2, this.a, false);
                                return;
                            }
                        }
                    } catch (Exception e3) {
                        q90.c("SocketTransceiver", "SendThread Exception, mClose is " + this.b.n, e3);
                        if (this.b.n) {
                            return;
                        }
                        this.b.c = false;
                        a90 a90Var3 = this.b;
                        a90Var3.R("SendThread Exception:" + e3, this.a, false);
                        return;
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;
        public final /* synthetic */ a90 b;

        public i(a90 a90Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a90Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a90Var;
            this.a = "";
        }

        public /* synthetic */ i(a90 a90Var, a aVar) {
            this(a90Var);
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (str == null) {
                    this.a = "";
                } else {
                    this.a = str;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                j80 b = i80.h(this.b.p).b(601110);
                b.c("flow_start_time", System.currentTimeMillis());
                b.d("P18", "retry by disconnect");
                b.d("con_err_code", "P18");
                b.d("source", "retry : " + this.a);
                this.b.P();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class j implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;
        public String b;
        public final /* synthetic */ a90 c;

        public j(a90 a90Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a90Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = a90Var;
        }

        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.b = str;
            }
        }

        public void b(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                this.a = j;
            }
        }

        public /* synthetic */ j(a90 a90Var, a aVar) {
            this(a90Var);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.c.e0(this.a, this.b);
                this.c.R("read and write thread timeout:", this.b, false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947569873, "Lcom/baidu/tieba/a90;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947569873, "Lcom/baidu/tieba/a90;");
                return;
            }
        }
        F = new q80();
    }

    public final String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (F.a == -1) {
                return "UNCONNECTED";
            }
            if (F.a == -2) {
                return "CONNECTING";
            }
            return "CONNECTED";
        }
        return (String) invokeV.objValue;
    }

    public q80 X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return F;
        }
        return (q80) invokeV.objValue;
    }

    public void h0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            q90.a("SocketTransceiver", "customPingRunnable send PingRequest ");
            l0(this.h.b(this.p, 3L));
        }
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            q90.a("SocketTransceiver", "resetConnectParameter");
            this.b = 0;
            this.o.set(0);
            w80.i();
        }
    }

    public synchronized void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            synchronized (this) {
                q90.a("SocketTransceiver", "socketConnect");
                this.c = false;
                j0();
                P();
            }
        }
    }

    public a90(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new AtomicInteger(0);
        this.b = 0;
        this.c = false;
        this.d = new LinkedList<>();
        this.e = new LinkedHashMap();
        this.f = new Object();
        this.g = new Object();
        this.h = new e90();
        this.i = new LinkedHashMap();
        this.j = new LinkedHashMap();
        this.m = new f(this, null);
        this.n = false;
        this.o = new AtomicInteger(0);
        this.r = new j(this, null);
        this.s = new i(this, null);
        this.w = new AtomicBoolean(false);
        this.x = new AtomicBoolean(false);
        this.A = "";
        this.B = "";
        this.C = "";
        this.D = "";
        this.E = new b(this);
        this.p = context;
        HandlerThread handlerThread = new HandlerThread("LCP HandlerThread");
        this.t = handlerThread;
        handlerThread.start();
        this.u = new e(this, this.t.getLooper());
    }

    public static synchronized a90 V(Context context) {
        InterceptResult invokeL;
        a90 a90Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, context)) == null) {
            synchronized (a90.class) {
                if (G == null) {
                    G = new a90(context.getApplicationContext());
                }
                a90Var = G;
            }
            return a90Var;
        }
        return (a90) invokeL.objValue;
    }

    public synchronized void K(BLCPRequest bLCPRequest, v80 v80Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bLCPRequest, v80Var) == null) {
            synchronized (this) {
                x80 x80Var = new x80();
                x80Var.i = bLCPRequest.a;
                x80Var.j = bLCPRequest.b;
                x80Var.a = bLCPRequest.c;
                if (bLCPRequest.d < 0) {
                    x80Var.o = System.currentTimeMillis();
                } else {
                    x80Var.o = bLCPRequest.d;
                }
                int i2 = c.a[bLCPRequest.e.ordinal()];
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            x80Var.c = 5000L;
                        } else {
                            x80Var.c = 50000L;
                        }
                    } else {
                        x80Var.c = 30000L;
                    }
                } else {
                    x80Var.c = 20000L;
                }
                if (bLCPRequest instanceof u80) {
                    long j2 = (x80Var.i * 10000) + x80Var.j;
                    x80Var.o = j2;
                    m0(x80Var.i, x80Var.j, j2, true, v80Var);
                } else {
                    m0(x80Var.i, x80Var.j, x80Var.o, false, v80Var);
                    this.h.a(x80Var, true);
                    l0(x80Var);
                }
            }
        }
    }

    public final void d0(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048594, this, j2, str) == null) {
            try {
                if (this.e.size() > 0 && this.e.containsKey(Long.valueOf(j2))) {
                    q90.a("SocketTransceiver", "handle msg socket stoped!!! " + this.e.get(Long.valueOf(j2)).toString());
                    x80 remove = this.e.remove(Long.valueOf(j2));
                    if (remove == null) {
                        return;
                    }
                    remove.d = 8006;
                    remove.e = "socket stopped :";
                    c0(remove, remove, str);
                }
            } catch (Exception e2) {
                q90.a("SocketTransceiver", "handle msg socket stoped!!! " + e2);
            }
        }
    }

    public final void e0(long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048595, this, j2, str) == null) {
            try {
                if (this.e.size() > 0 && this.e.containsKey(Long.valueOf(j2))) {
                    q90.a("SocketTransceiver", "handle msg timeout!!! " + this.e.get(Long.valueOf(j2)).toString());
                    x80 remove = this.e.remove(Long.valueOf(j2));
                    if (remove == null) {
                        return;
                    }
                    remove.d = ResponseCode.LCP_TIME_OUT;
                    remove.e = "socket timeout";
                    c0(remove, remove, str);
                }
            } catch (Exception e2) {
                q90.a("SocketTransceiver", "handle msg timeout!!! " + e2);
            }
        }
    }

    public final boolean L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            y80 y80Var = this.q;
            if (y80Var != null && y80Var.a() != null && this.q.a().c != null && this.q.a().c.isConnected()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void M() {
        z80 a2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (a2 = this.q.a()) != null && a2.a.booleanValue()) {
            try {
                if (a2.c != null) {
                    a2.c.close();
                    a2.c = null;
                    if (a2.d != null) {
                        a2.d.close();
                        a2.d = null;
                    }
                    if (a2.e != null) {
                        a2.e.close();
                        a2.e = null;
                    }
                    q90.a("SocketTransceiver", "closeExistedConnection ok");
                }
            } catch (IOException e2) {
                q90.c("SocketTransceiver", "closeExistedConnection :" + e2.getMessage(), e2);
            }
        }
    }

    public final synchronized void O(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, str, str2, str3) == null) {
            synchronized (this) {
                if (!this.w.getAndSet(true)) {
                    q90.b("SocketTransceiver", "connectTaskRunning.set(true)");
                    n90.a(this.p).b(new a(this, str, str2, str3));
                } else {
                    q90.b("SocketTransceiver", "connect() return, ");
                }
            }
        }
    }

    public final void c0(x80 x80Var, x80 x80Var2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048593, this, x80Var, x80Var2, str) == null) {
            f0(x80Var2, x80Var, str);
            long j2 = x80Var.i;
            if (j2 == 1) {
                a0(x80Var, str);
            } else if (j2 != -1) {
                g0(x80Var);
            } else if (x80Var2 == null) {
            } else {
                if (x80Var2.i == 1) {
                    a0(x80Var2, str);
                } else {
                    g0(x80Var2);
                }
            }
        }
    }

    public final synchronized void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            synchronized (this) {
                if (!RequsetNetworkUtils.isConnected(this.p)) {
                    j80 g2 = i80.h(this.p).g(601110);
                    g2.d("net_connect", "false");
                    g2.c("flow_end_time", System.currentTimeMillis());
                    g2.d("P33", "socket connectImpl error, no net");
                    g2.d("con_err_code", "P33");
                    g2.b("retry_cout", this.o.get());
                    g2.b("connect_state", -1);
                    g2.e();
                    j0();
                    F.a = -1;
                    p0(false);
                    return;
                }
                q90.d("SocketTransceiver", "connectImpl socket connect state:" + U());
                if (F.a != 0 && F.a != -2) {
                    this.u.removeCallbacks(this.s);
                    this.u.removeCallbacks(this.E);
                    this.u.removeCallbacks(this.m);
                    i0();
                    return;
                }
                j80 g3 = i80.h(this.p).g(601110);
                g3.b("inner_connect_state", F.a);
                g3.d("P34", "socket connectImpl repeat");
                g3.d("con_err_code", "P34");
                g3.b("retry_cout", this.o.get());
            }
        }
    }

    public final synchronized void Q(String str, String str2, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            synchronized (this) {
                if (p90.a) {
                    q90.d("SocketTransceiver", "destroy socket connect start, reason : " + str + ", host: " + str2 + ", syncStatus: " + z + ", isConnectException: " + z2);
                }
                this.u.removeCallbacks(this.r);
                this.n = true;
                if (this.q != null) {
                    synchronized (this.d) {
                        this.d.notifyAll();
                        q90.d("SocketTransceiver", "destroy socket connect, sendQueue notifyAll");
                    }
                    try {
                        this.q.d();
                        q90.a("SocketTransceiver", "destroy socket connect, socketClose success");
                    } catch (Exception e2) {
                        this.q.c(null);
                        q90.c("SocketTransceiver", "Exception destroy:", e2);
                    }
                }
                F.a = -1;
                if (z) {
                    j80 g2 = i80.h(this.p).g(601110);
                    g2.d("P17", str);
                    g2.d("con_err_code", "P17");
                    p0(true);
                } else {
                    if (r80.g().h() == 0) {
                        q80 q80Var = new q80();
                        q80Var.a = -2;
                        setChanged();
                        notifyObservers(q80Var);
                        r80.g().j();
                    }
                    if (z2) {
                        j80 g3 = i80.h(this.p).g(601110);
                        g3.c("flow_end_time", System.currentTimeMillis());
                        g3.b("retry_cout", this.o.get());
                        g3.d("P21", "connect end by exception:" + str);
                        g3.d("con_err_code", "P21");
                        g3.e();
                    }
                }
            }
        }
    }

    public synchronized void R(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048583, this, str, str2, z) == null) {
            synchronized (this) {
                if (p90.a) {
                    q90.d("SocketTransceiver", "disconnectedByLcp, destroyConnection = " + this.c + ", net :" + RequsetNetworkUtils.isConnected(this.p) + ", reason : " + str);
                }
                S(str2);
                if (this.c) {
                    j80 g2 = i80.h(this.p).g(601110);
                    g2.d("P16", "disconnectedByLcp:" + this.c);
                    g2.d("con_err_code", "P16");
                    g2.b("retry_cout", this.o.get());
                    j0();
                    return;
                }
                i80.h(this.p).g(601110).c("destory_starttime", System.currentTimeMillis());
                Q(str, str2, false, z);
                i80.h(this.p).g(601110).c("destory_endtime", System.currentTimeMillis());
                if (z) {
                    this.w.set(false);
                    q90.b("SocketTransceiver", "connectTaskRunning.set(false)");
                }
                k0(false, str2, str);
            }
        }
    }

    public final void Z(long j2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Long.valueOf(j2), str, str2}) == null) {
            try {
                if (this.e.size() > 0 && this.e.containsKey(Long.valueOf(j2))) {
                    q90.a("SocketTransceiver", "handle msg exception!!! " + this.e.get(Long.valueOf(j2)).toString());
                    x80 remove = this.e.remove(Long.valueOf(j2));
                    if (remove == null) {
                        return;
                    }
                    remove.d = 8005;
                    remove.e = "socket exception :" + str;
                    c0(remove, remove, str2);
                }
            } catch (Exception e2) {
                q90.a("SocketTransceiver", "handle msg exception!!! " + e2);
            }
        }
    }

    public final void b0(long j2, boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Long.valueOf(j2), Boolean.valueOf(z), str}) == null) {
            try {
                j80 g2 = i80.h(this.p).g(601110);
                g2.c("login_end", System.currentTimeMillis());
                g2.c("flow_end_time", System.currentTimeMillis());
                g2.b("connect_state", 4);
                g2.d("P55", "lcp login success");
                g2.d("con_err_code", "lcp login success");
                g2.b("retry_cout", this.o.get());
                g2.e();
                this.o.set(0);
                F.a = 0;
                q90.b("SocketTransceiver", "lcm login success, cost: , lcm cost: " + (System.currentTimeMillis() - this.z) + "ms");
                p0(false);
                if (!z) {
                    return;
                }
                this.u.a(str);
                this.u.postDelayed(this.m, j2);
                q90.a("SocketTransceiver", "ping every 1分钟 ");
            } catch (Exception e2) {
                q90.b("SocketTransceiver", "handleLcpLoginSuccess Exception :" + e2);
            }
        }
    }

    public final void S(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            try {
                q90.a("SocketTransceiver", "socket connect disConnect, fatalAllMessage begin ");
                i80.h(this.p).g(601110).b("sendQueue_length", this.d.size());
                i80.h(this.p).g(601110).c("sendQueue_starttime", System.currentTimeMillis());
                synchronized (this.d) {
                    while (this.d.size() > 0) {
                        T(this.d.removeFirst(), str);
                    }
                    q90.a("SocketTransceiver", "fatalAllMessage sendQueue end ");
                }
                i80.h(this.p).g(601110).c("sendQueue_endtime", System.currentTimeMillis());
                i80.h(this.p).g(601110).b("sendMessageMap_length", this.e.size());
                i80.h(this.p).g(601110).c("sendMessageMap_starttime", System.currentTimeMillis());
                synchronized (this.g) {
                    q90.a("SocketTransceiver", "fatalAllMessage mSync begin");
                    for (Long l : this.e.keySet()) {
                        T(this.e.get(l), str);
                    }
                    this.e.clear();
                    q90.a("SocketTransceiver", "fatalAllMessage mSync end");
                }
                i80.h(this.p).g(601110).c("sendMessageMap_endtime", System.currentTimeMillis());
            } catch (Exception e2) {
                q90.c("SocketTransceiver", "fatalAllMessage Exception", e2);
            }
        }
    }

    public final synchronized void l0(x80 x80Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, x80Var) == null) {
            synchronized (this) {
                try {
                } catch (Exception e2) {
                    q90.c("SocketTransceiver", "sendMessage Exception :", e2);
                }
                synchronized (this.d) {
                    boolean z = false;
                    Iterator<x80> it = this.d.iterator();
                    while (it.hasNext()) {
                        x80 next = it.next();
                        q90.a("SocketTransceiver", "sendMessage queue :" + next.o);
                        if (next.m) {
                            z = true;
                        }
                    }
                    if (x80Var.m) {
                        if (!z && F.a == -2) {
                            this.d.addFirst(x80Var);
                            this.d.notifyAll();
                        }
                        q90.b("SocketTransceiver", "sendMessage cur methodId :1, state :" + U());
                    } else if (F.a == -1) {
                        if (L()) {
                            if (this.d.size() <= 0 || !z) {
                                this.d.addFirst(W(true));
                                this.d.notifyAll();
                            }
                            if (!x80Var.l) {
                                this.d.add(x80Var);
                                this.d.notifyAll();
                            }
                        } else {
                            if (x80Var.l && r80.g().h() == -1) {
                                r80.g().f("ping");
                            }
                            this.d.add(x80Var);
                        }
                    } else {
                        this.d.add(x80Var);
                        this.d.notifyAll();
                    }
                }
            }
        }
    }

    public final void T(x80 x80Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048585, this, x80Var, str) == null) && x80Var != null && x80Var.i != 1) {
            q90.b("SocketTransceiver", "fetalAndClearMsg : " + x80Var.o + ", serviceId :" + x80Var.i + ", methodId :" + x80Var.j);
            c0(new x80(), x80Var, str);
        }
    }

    public final void Y(x80 x80Var, boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048589, this, x80Var, z) == null) && x80Var != null && x80Var.j == 50 && x80Var.i == 2) {
            if (z) {
                str = "ReadThread read ImLoginMessage occur exception";
            } else {
                str = "SendThread send ImLoginMessage occur exception";
            }
            j80 g2 = i80.h(this.p).g(601110);
            g2.c("login_end", System.currentTimeMillis());
            g2.d("P46", str);
            g2.d("con_err_code", "P46");
        }
    }

    public synchronized void o0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048605, this, str, str2) == null) {
            synchronized (this) {
                q90.d("SocketTransceiver", "---socketDisconnect---");
                this.n = true;
                this.c = true;
                S(str2);
                j0();
                this.u.removeCallbacks(this.s);
                this.u.removeCallbacks(this.E);
                this.u.removeCallbacks(this.m);
                w80.h(this.p, null, false);
                Q(str, str2, true, true);
                this.w.set(false);
            }
        }
    }

    public final x80 W(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
            if (z) {
                this.z = System.currentTimeMillis();
                j80 g2 = i80.h(this.p).g(601110);
                g2.b("connect_state", 4);
                g2.c("login_begin", System.currentTimeMillis());
            }
            return this.h.b(this.p, 1L);
        }
        return (x80) invokeZ.objValue;
    }

    public final void a0(x80 x80Var, String str) {
        int i2;
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048591, this, x80Var, str) == null) {
            if (x80Var.d == 0) {
                long j3 = x80Var.h;
                if (j3 <= 0) {
                    j2 = 60000;
                } else {
                    j2 = j3;
                }
                long j4 = x80Var.j;
                if (j4 == 1) {
                    b0(j2, true, str);
                    return;
                } else if (j4 == 2) {
                    q90.d("SocketTransceiver", "LCP logout, cur msg.connectState is " + x80Var.k);
                    o0("LCP logout:", str);
                    return;
                } else if (j4 == 3) {
                    this.m.a(j2);
                    return;
                } else {
                    return;
                }
            }
            String str2 = " errorcode:" + x80Var.d + " errmsg:" + x80Var.e;
            if (!String.valueOf(x80Var.d).startsWith(PayUVEventType.THIRD_PAY_WAY_DIALOG_CHANNEL_CLICK) && (i2 = x80Var.d) != 1011 && i2 != 2001 && i2 != 2003) {
                if (i2 == 1012) {
                    q90.a("SocketTransceiver", "login error :" + str2 + ", lcm cost: " + (System.currentTimeMillis() - this.z) + "ms");
                    j80 g2 = i80.h(this.p).g(601110);
                    g2.c("login_end", System.currentTimeMillis());
                    StringBuilder sb = new StringBuilder();
                    sb.append("lcp login failed:");
                    sb.append(str2);
                    g2.d("P45", sb.toString());
                    g2.d("con_err_code", "P45");
                    if (!this.x.getAndSet(true)) {
                        r90.x(this.p, "");
                        o0(str2, str);
                        r80.g().f("lcp login failed:");
                        this.x.set(false);
                        return;
                    }
                    return;
                } else if (i2 == 1013) {
                    b0(60000L, false, str);
                    return;
                } else {
                    q90.a("SocketTransceiver", "login error :" + str2);
                    j80 g3 = i80.h(this.p).g(601110);
                    g3.c("login_end", System.currentTimeMillis());
                    g3.d("P47", "lcp login failed:" + str2);
                    g3.d("con_err_code", "P47");
                    F.a = -1;
                    k0(true, str, str2);
                    return;
                }
            }
            q90.a("SocketTransceiver", "login error, then request token, error code :" + x80Var.d + ", lcm cost: " + (System.currentTimeMillis() - this.z) + "ms");
            j80 g4 = i80.h(this.p).g(601110);
            g4.c("login_end", System.currentTimeMillis());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("lcp login failed:");
            sb2.append(str2);
            g4.d("P45", sb2.toString());
            g4.d("con_err_code", "P45");
            if (!this.x.getAndSet(true)) {
                r90.x(this.p, "");
                o0(str2, str);
                r80.g().f("lcp login failed:");
                this.x.set(false);
            }
        }
    }

    public final void f0(x80 x80Var, x80 x80Var2, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048596, this, x80Var, x80Var2, str) == null) && x80Var != null) {
            j80 b2 = i80.h(this.p).b(601111);
            b2.c(HttpRetryStrategyDataParse.DOWNFLOW_TETRY_REQUEST_ID, x80Var2.o);
            b2.c("service_id", x80Var2.i);
            b2.c("method_id", x80Var2.j);
            b2.b("error_code", x80Var2.d);
            b2.d(GameCodeGetResponseMsg.PARAM_ERROR_MSG, x80Var2.e);
            b2.c("request_time", x80Var.b);
            b2.c("response_time", System.currentTimeMillis());
            b2.d("ext", "");
            b2.d(ProbeTB.PROTOCOL, this.B);
            b2.d("ip", this.A);
            b2.d("domain", this.C);
            b2.d(ClientCookie.PORT_ATTR, this.D);
            b2.e();
        }
    }

    public final synchronized void g0(x80 x80Var) {
        long j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, x80Var) == null) {
            synchronized (this) {
                v80 v80Var = null;
                try {
                    if (!x80Var.f) {
                        j2 = x80Var.o;
                    } else {
                        j2 = (x80Var.i * 10000) + x80Var.j;
                    }
                    Long valueOf = Long.valueOf(j2);
                    if (p90.a) {
                        q90.a("SocketTransceiver", "onBLCPResponse,  key:" + valueOf + ", methodId :" + x80Var.j + ", serviceId :" + x80Var.i + ", error :" + x80Var.d + ", msgId :" + x80Var.o + ", errMsg :" + x80Var.e + ", invoke keys :" + this.i.keySet().toString() + ", notify keys :" + this.j.keySet().toString());
                    }
                    if (this.j.size() > 0 && this.j.containsKey(valueOf)) {
                        v80Var = this.j.get(valueOf);
                    } else if (this.i.size() > 0 && this.i.containsKey(valueOf)) {
                        v80Var = this.i.remove(valueOf);
                    }
                    if (v80Var != null) {
                        if (v80Var instanceof t80) {
                            t80.a aVar = new t80.a();
                            long j3 = x80Var.i;
                            aVar.a = x80Var.j;
                            aVar.b = x80Var.o;
                            aVar.c = x80Var.g;
                            aVar.d = x80Var.q;
                            ((t80) v80Var).onResponse(x80Var.d, x80Var.e, aVar);
                        } else {
                            v80Var.onResponse(x80Var.d, x80Var.e, x80Var.i, x80Var.j, x80Var.o, x80Var.g);
                        }
                        if (x80Var.d == 1011) {
                            q90.a("SocketTransceiver", "onBLCPResponse, errorCode :" + x80Var.d + ", and will send lcm login msg .");
                            l0(W(false));
                        }
                    }
                } catch (Exception e2) {
                    q90.c("SocketTransceiver", "onBLCPResponse, Exception!!!", e2);
                }
            }
        }
    }

    public final synchronized void i0() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            synchronized (this) {
                if (!this.C.isEmpty() && !this.D.isEmpty() && w80.d()) {
                    O(this.C, this.D, this.B);
                    return;
                }
                q90.f("SocketTransceiver", "protocolOption  thread :" + Thread.activeCount() + ", cur :" + Thread.currentThread() + "， protocol count :" + this.b);
                int i2 = r90.i(this.p);
                String[] split = r90.h(this.p, this.b).split(":");
                if (split.length < 3) {
                    if (this.b < i2) {
                        this.b++;
                        this.C = "";
                        this.D = "";
                        i0();
                    }
                    return;
                }
                if (TextUtils.isEmpty(split[0])) {
                    str = "tcp";
                } else {
                    str = split[0];
                }
                String str2 = split[1];
                String str3 = split[2];
                if (this.b >= i2) {
                    this.b = 0;
                    q90.a("SocketTransceiver", "protocolOption failed, connectip:" + str2 + ", port:" + str3 + ", protocolType:" + str);
                    this.q = new b90(this.p, "tls");
                    this.C = "lcs.baidu.com";
                    this.D = "443";
                    this.B = "tls";
                    O("lcs.baidu.com", "443", "tls");
                } else {
                    if ("quic".equals(str) && !(this.q instanceof QuicMessageHandler)) {
                        this.q = new QuicMessageHandler(this.p);
                    } else if ("tcp".equals(str) || ("tls".equals(str) && !(this.q instanceof b90))) {
                        this.q = new b90(this.p, str);
                    }
                    this.b++;
                    if (this.q != null && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                        q90.a("SocketTransceiver", "type :" + str + ", host :" + str2 + ", port :" + str3);
                        this.C = str2;
                        this.D = str3;
                        this.B = str;
                        O(str2, str3, str);
                    } else {
                        this.C = "";
                        this.D = "";
                        i0();
                    }
                }
            }
        }
    }

    public final void k0(boolean z, String str, String str2) {
        String str3;
        Runnable runnable;
        Runnable runnable2;
        int i2;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
            try {
                if (this.o.get() <= 10 && F.a == -1) {
                    this.u.removeCallbacks(this.m);
                    e eVar = this.u;
                    if (z) {
                        runnable = this.s;
                    } else {
                        runnable = this.E;
                    }
                    eVar.removeCallbacks(runnable);
                    this.s.a(str2);
                    if (z) {
                        runnable2 = this.E;
                    } else {
                        runnable2 = this.s;
                    }
                    Message obtain = Message.obtain(this.u, runnable2);
                    if (z) {
                        i2 = 202020;
                    } else {
                        i2 = 101010;
                    }
                    obtain.what = i2;
                    if (!this.u.hasMessages(i2)) {
                        this.o.incrementAndGet();
                        long N = N(this.o.get());
                        StringBuilder sb = new StringBuilder();
                        sb.append("waiting Schedule retry ");
                        if (z) {
                            str4 = "login";
                        } else {
                            str4 = "connect";
                        }
                        sb.append(str4);
                        sb.append(" , retry times: ");
                        sb.append(this.o.get());
                        sb.append(" time delay: ");
                        sb.append(N);
                        sb.append(", reason: ");
                        sb.append(str2);
                        String sb2 = sb.toString();
                        j80 g2 = i80.h(this.p).g(601110);
                        g2.d("P44", sb2);
                        g2.d("con_err_code", "P44");
                        this.u.sendMessageDelayed(obtain, N);
                        q90.d("SocketTransceiver", sb2);
                        return;
                    }
                    q90.d("SocketTransceiver", "waiting Schedule retry， but handler queue had this runnable, pass");
                    return;
                }
                o0("retry strategy had cost " + this.o.get() + " and stop retry, cur connectState:" + F.a + ", reason: " + str2, str);
            } catch (Exception e2) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("socket retry by ");
                if (z) {
                    str3 = "retryLcmLoginRunnable";
                } else {
                    str3 = "retrySocketConnectRunnable";
                }
                sb3.append(str3);
                sb3.append(", reason: ");
                sb3.append(str2);
                sb3.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                sb3.append("retry exception:");
                sb3.append(e2.getMessage());
                String sb4 = sb3.toString();
                q90.b("SocketTransceiver", sb4);
                o0(sb4, str);
            }
        }
    }

    public final void m0(long j2, long j3, long j4, boolean z, v80 v80Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048603, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Boolean.valueOf(z), v80Var}) == null) {
            Long valueOf = Long.valueOf(j4);
            if (z) {
                if (v80Var != null) {
                    this.j.put(valueOf, v80Var);
                }
            } else {
                this.i.put(valueOf, v80Var);
            }
            if (p90.a) {
                q90.a("SocketTransceiver", "addMessageToQueue isNotify:" + z + ", methodId:" + j3 + ", invoke keys :" + this.i.keySet().toString() + ", notify keys :" + this.j.keySet().toString());
            }
        }
    }

    public final void p0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            if (p90.a) {
                q90.a("SocketTransceiver", "socket connect state change, sync to lcp global connect state, cur socket state is " + U());
            }
            if (z && F.a == -1 && r80.g().h() == -2) {
                j80 g2 = i80.h(this.p).g(601110);
                g2.c("flow_end_time", System.currentTimeMillis());
                g2.b("retry_cout", this.o.get());
                g2.e();
            }
            setChanged();
            notifyObservers(F);
            r80.g().j();
        }
    }
}
