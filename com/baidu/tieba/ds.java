package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.tieba.bs;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
/* loaded from: classes5.dex */
public class ds {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ds d;
    public transient /* synthetic */ FieldHolder $fh;
    public ur a;
    public ConcurrentLinkedQueue<pr> b;
    public volatile boolean c;

    /* loaded from: classes5.dex */
    public static class a implements Function0<Unit> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a */
        public Unit invoke() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                System.loadLibrary("bdptask");
                return null;
            }
            return (Unit) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ as b;
        public final /* synthetic */ ds c;

        public b(ds dsVar, String str, as asVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dsVar, str, asVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = dsVar;
            this.a = str;
            this.b = asVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.c.l(this.a, this.b);
        }
    }

    /* loaded from: classes5.dex */
    public class c implements bs.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ds a;

        public c(ds dsVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dsVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dsVar;
        }

        @Override // com.baidu.tieba.bs.b
        public void a(boolean z, byte[] bArr) {
            sr a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, bArr) == null) {
                String str = "";
                try {
                    try {
                        DebugTrace.a.a("doHandShake response");
                        if (z && bArr != null && (a = xr.a(bArr)) != null) {
                            byte i = a.i();
                            byte[] o = a.o();
                            if (o != null) {
                                DebugTrace debugTrace = DebugTrace.a;
                                debugTrace.a("doHandShake response schemeType =" + ((int) i));
                                if (i != 21) {
                                    if (i == 22) {
                                        if (wr.a(this.a.a, o) != null) {
                                            DebugTrace.a.a("doHandShake serverHello");
                                            this.a.a.b(1);
                                            while (true) {
                                                pr prVar = (pr) this.a.b.poll();
                                                if (prVar == null) {
                                                    return;
                                                }
                                                this.a.n(prVar.a(), prVar.b());
                                            }
                                        } else {
                                            str = "params decode error";
                                        }
                                    }
                                } else {
                                    DebugTrace.a.a("doHandShake alert");
                                    ir a2 = ir.a(o);
                                    if (a2 != null) {
                                        DebugTrace.a.a("bdtls ubc handshake alert");
                                        if (a2.b() != null) {
                                            str = a2.b();
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        DebugTrace debugTrace2 = DebugTrace.a;
                        debugTrace2.a("exception=" + e.getMessage());
                    }
                    this.a.f(str);
                } finally {
                    this.a.c = false;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448302846, "Lcom/baidu/tieba/ds;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448302846, "Lcom/baidu/tieba/ds;");
                return;
            }
        }
        lt.a(new a());
        d = new ds();
    }

    public static ds b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return d;
        }
        return (ds) invokeV.objValue;
    }

    public ur i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a == null) {
                this.a = new ur();
            }
            return this.a;
        }
        return (ur) invokeV.objValue;
    }

    public ds() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new ur();
        this.c = false;
        this.b = new ConcurrentLinkedQueue<>();
    }

    public final void c(int i, as asVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048576, this, i, asVar) == null) && asVar != null) {
            asVar.b(i);
        }
    }

    public void g(String str, as asVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, asVar) == null) {
            ExecutorUtilsExt.postOnSerial(new b(this, str, asVar), "SessionController");
        }
    }

    public final void o(String str, as asVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, asVar) == null) {
            if (asVar != null && str != null) {
                DebugTrace.a.a("doNormalApplicationDataRequest");
                asVar.e(false);
                asVar.f(str.getBytes());
                return;
            }
            c(-1, asVar);
        }
    }

    public final void f(String str) {
        int i;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            DebugTrace.a.a("onHandshakeError");
            if (TextUtils.equals(str, "down grade")) {
                i = 2;
            } else {
                i = -1;
            }
            this.a.b(i);
            while (true) {
                pr poll = this.b.poll();
                if (poll != null) {
                    if (i == 2) {
                        o(poll.a(), poll.b());
                    } else {
                        as b2 = poll.b();
                        if (b2 != null) {
                            if (TextUtils.isEmpty(str)) {
                                str2 = "connect fail";
                            } else {
                                str2 = str;
                            }
                            b2.c(new IOException(str2));
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public final void l(String str, as asVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, asVar) == null) {
            if (this.a.a() != 2) {
                if (!this.a.k()) {
                    if (this.b == null) {
                        this.b = new ConcurrentLinkedQueue<>();
                    }
                    this.b.offer(new pr(str, asVar));
                    m();
                    return;
                }
                n(str, asVar);
                return;
            }
            o(str, asVar);
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            DebugTrace.a.a("doHandShake");
            if (this.c) {
                DebugTrace.a.a("doHandShake isHandshakeRunning");
                return;
            }
            this.c = true;
            byte[] e = cs.c().e(this.a);
            if (e != null && e.length > 0) {
                new bs().a(e, new c(this));
                return;
            }
            this.c = false;
            f("record data error");
        }
    }

    public final void n(String str, as asVar) {
        byte[] f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, asVar) == null) {
            if (str != null && asVar != null) {
                if (TextUtils.equals(asVar.a(), "GET")) {
                    f = cs.c().f(this.a, null);
                } else {
                    f = cs.c().f(this.a, str);
                }
                if (f != null) {
                    DebugTrace.a.a("doBdtlsApplicationDataRequest");
                    asVar.e(true);
                    asVar.f(f);
                    return;
                }
                c(-1, asVar);
                return;
            }
            c(-1, null);
        }
    }
}
