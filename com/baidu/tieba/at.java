package com.baidu.tieba;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.framework.utils.DebugTrace;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.tieba.ys;
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
public class at {
    public static /* synthetic */ Interceptable $ic;
    public static volatile at d;
    public transient /* synthetic */ FieldHolder $fh;
    public rs a;
    public ConcurrentLinkedQueue<ms> b;
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
        public final /* synthetic */ xs b;
        public final /* synthetic */ at c;

        public b(at atVar, String str, xs xsVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atVar, str, xsVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = atVar;
            this.a = str;
            this.b = xsVar;
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
    public class c implements ys.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ at a;

        public c(at atVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {atVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = atVar;
        }

        @Override // com.baidu.tieba.ys.b
        public void a(boolean z, byte[] bArr) {
            ps a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, bArr) == null) {
                String str = "";
                try {
                    try {
                        DebugTrace.a.a("doHandShake response");
                        if (z && bArr != null && (a = us.a(bArr)) != null) {
                            byte i = a.i();
                            byte[] o = a.o();
                            if (o != null) {
                                DebugTrace debugTrace = DebugTrace.a;
                                debugTrace.a("doHandShake response schemeType =" + ((int) i));
                                if (i != 21) {
                                    if (i == 22) {
                                        if (ts.a(this.a.a, o) != null) {
                                            DebugTrace.a.a("doHandShake serverHello");
                                            this.a.a.b(1);
                                            while (true) {
                                                ms msVar = (ms) this.a.b.poll();
                                                if (msVar == null) {
                                                    return;
                                                }
                                                this.a.n(msVar.a(), msVar.b());
                                            }
                                        } else {
                                            str = "params decode error";
                                        }
                                    }
                                } else {
                                    DebugTrace.a.a("doHandShake alert");
                                    fs a2 = fs.a(o);
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448299994, "Lcom/baidu/tieba/at;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448299994, "Lcom/baidu/tieba/at;");
                return;
            }
        }
        iu.a(new a());
        d = new at();
    }

    public static at b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return d;
        }
        return (at) invokeV.objValue;
    }

    public rs i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.a == null) {
                this.a = new rs();
            }
            return this.a;
        }
        return (rs) invokeV.objValue;
    }

    public at() {
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
        this.a = new rs();
        this.c = false;
        this.b = new ConcurrentLinkedQueue<>();
    }

    public final void c(int i, xs xsVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048576, this, i, xsVar) == null) && xsVar != null) {
            xsVar.b(i);
        }
    }

    public void g(String str, xs xsVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, xsVar) == null) {
            ExecutorUtilsExt.postOnSerial(new b(this, str, xsVar), "SessionController");
        }
    }

    public final void o(String str, xs xsVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, xsVar) == null) {
            if (xsVar != null && str != null) {
                DebugTrace.a.a("doNormalApplicationDataRequest");
                xsVar.e(false);
                xsVar.f(str.getBytes());
                return;
            }
            c(-1, xsVar);
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
                ms poll = this.b.poll();
                if (poll != null) {
                    if (i == 2) {
                        o(poll.a(), poll.b());
                    } else {
                        xs b2 = poll.b();
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

    public final void l(String str, xs xsVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, xsVar) == null) {
            if (this.a.a() != 2) {
                if (!this.a.k()) {
                    if (this.b == null) {
                        this.b = new ConcurrentLinkedQueue<>();
                    }
                    this.b.offer(new ms(str, xsVar));
                    m();
                    return;
                }
                n(str, xsVar);
                return;
            }
            o(str, xsVar);
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
            byte[] e = zs.c().e(this.a);
            if (e != null && e.length > 0) {
                new ys().a(e, new c(this));
                return;
            }
            this.c = false;
            f("record data error");
        }
    }

    public final void n(String str, xs xsVar) {
        byte[] f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, xsVar) == null) {
            if (str != null && xsVar != null) {
                if (TextUtils.equals(xsVar.a(), "GET")) {
                    f = zs.c().f(this.a, null);
                } else {
                    f = zs.c().f(this.a, str);
                }
                if (f != null) {
                    DebugTrace.a.a("doBdtlsApplicationDataRequest");
                    xsVar.e(true);
                    xsVar.f(f);
                    return;
                }
                c(-1, xsVar);
                return;
            }
            c(-1, null);
        }
    }
}
