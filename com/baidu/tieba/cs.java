package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.tieba.as;
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
public class cs {
    public static /* synthetic */ Interceptable $ic;
    public static volatile cs d;
    public transient /* synthetic */ FieldHolder $fh;
    public tr a;
    public ConcurrentLinkedQueue<or> b;
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
        public final /* synthetic */ zr b;
        public final /* synthetic */ cs c;

        public b(cs csVar, String str, zr zrVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {csVar, str, zrVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = csVar;
            this.a = str;
            this.b = zrVar;
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
    public class c implements as.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cs a;

        public c(cs csVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {csVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = csVar;
        }

        @Override // com.baidu.tieba.as.b
        public void a(boolean z, byte[] bArr) {
            rr a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, bArr) == null) {
                String str = "";
                try {
                    try {
                        DebugTrace.a.a("doHandShake response");
                        if (z && bArr != null && (a = wr.a(bArr)) != null) {
                            byte i = a.i();
                            byte[] o = a.o();
                            if (o != null) {
                                DebugTrace debugTrace = DebugTrace.a;
                                debugTrace.a("doHandShake response schemeType =" + ((int) i));
                                if (i != 21) {
                                    if (i == 22) {
                                        if (vr.a(this.a.a, o) != null) {
                                            DebugTrace.a.a("doHandShake serverHello");
                                            this.a.a.b(1);
                                            while (true) {
                                                or orVar = (or) this.a.b.poll();
                                                if (orVar == null) {
                                                    return;
                                                }
                                                this.a.n(orVar.a(), orVar.b());
                                            }
                                        } else {
                                            str = "params decode error";
                                        }
                                    }
                                } else {
                                    DebugTrace.a.a("doHandShake alert");
                                    hr a2 = hr.a(o);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448301885, "Lcom/baidu/tieba/cs;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448301885, "Lcom/baidu/tieba/cs;");
                return;
            }
        }
        kt.a(new a());
        d = new cs();
    }

    public static cs b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return d;
        }
        return (cs) invokeV.objValue;
    }

    public tr i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a == null) {
                this.a = new tr();
            }
            return this.a;
        }
        return (tr) invokeV.objValue;
    }

    public cs() {
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
        this.a = new tr();
        this.c = false;
        this.b = new ConcurrentLinkedQueue<>();
    }

    public final void c(int i, zr zrVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048576, this, i, zrVar) == null) && zrVar != null) {
            zrVar.b(i);
        }
    }

    public void g(String str, zr zrVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, zrVar) == null) {
            ExecutorUtilsExt.postOnSerial(new b(this, str, zrVar), "SessionController");
        }
    }

    public final void o(String str, zr zrVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, zrVar) == null) {
            if (zrVar != null && str != null) {
                DebugTrace.a.a("doNormalApplicationDataRequest");
                zrVar.e(false);
                zrVar.f(str.getBytes());
                return;
            }
            c(-1, zrVar);
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
                or poll = this.b.poll();
                if (poll != null) {
                    if (i == 2) {
                        o(poll.a(), poll.b());
                    } else {
                        zr b2 = poll.b();
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

    public final void l(String str, zr zrVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, zrVar) == null) {
            if (this.a.a() != 2) {
                if (!this.a.k()) {
                    if (this.b == null) {
                        this.b = new ConcurrentLinkedQueue<>();
                    }
                    this.b.offer(new or(str, zrVar));
                    m();
                    return;
                }
                n(str, zrVar);
                return;
            }
            o(str, zrVar);
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
            byte[] e = bs.c().e(this.a);
            if (e != null && e.length > 0) {
                new as().a(e, new c(this));
                return;
            }
            this.c = false;
            f("record data error");
        }
    }

    public final void n(String str, zr zrVar) {
        byte[] f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, zrVar) == null) {
            if (str != null && zrVar != null) {
                if (TextUtils.equals(zrVar.a(), "GET")) {
                    f = bs.c().f(this.a, null);
                } else {
                    f = bs.c().f(this.a, str);
                }
                if (f != null) {
                    DebugTrace.a.a("doBdtlsApplicationDataRequest");
                    zrVar.e(true);
                    zrVar.f(f);
                    return;
                }
                c(-1, zrVar);
                return;
            }
            c(-1, null);
        }
    }
}
