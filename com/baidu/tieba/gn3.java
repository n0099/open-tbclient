package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.tieba.wn3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes4.dex */
public class gn3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile gn3 e;
    public transient /* synthetic */ FieldHolder $fh;
    public pn3 a;
    public ConcurrentLinkedQueue<kn3> b;
    public volatile boolean c;
    public un3 d;

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ un3 b;
        public final /* synthetic */ gn3 c;

        public a(gn3 gn3Var, String str, un3 un3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gn3Var, str, un3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = gn3Var;
            this.a = str;
            this.b = un3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                tg4.e().f();
                this.c.j(this.a, this.b);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements wn3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gn3 a;

        public b(gn3 gn3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gn3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gn3Var;
        }

        @Override // com.baidu.tieba.wn3.b
        public void a(boolean z, byte[] bArr) {
            nn3 a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, bArr) == null) {
                String str = "";
                try {
                    try {
                        if (an3.a) {
                            Log.d("BDTLS", "doHandShake response");
                        }
                        if (z && bArr != null && (a = rn3.a(bArr)) != null) {
                            byte i = a.i();
                            byte[] f = a.f();
                            if (f != null) {
                                if (an3.a) {
                                    Log.d("BDTLS", "doHandShake response schemeType =" + ((int) i));
                                }
                                if (i != 21) {
                                    if (i == 22) {
                                        if (qn3.a(this.a.a, f) != null) {
                                            if (an3.a) {
                                                Log.d("BDTLS", "doHandShake serverHello");
                                            }
                                            this.a.a.s(1);
                                            fn3.a("serverHello");
                                            while (true) {
                                                kn3 kn3Var = (kn3) this.a.b.poll();
                                                if (kn3Var != null) {
                                                    this.a.g(kn3Var.b(), kn3Var.a());
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            str = "params decode error";
                                        }
                                    }
                                } else {
                                    if (an3.a) {
                                        Log.d("BDTLS", "doHandShake alert");
                                    }
                                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(f);
                                    if (parseFrom != null) {
                                        if (an3.a) {
                                            Log.d("BDTLS", "bdtls ubc handshake alert");
                                        }
                                        if (parseFrom.getDescription() != null) {
                                            str = new String(parseFrom.getDescription().toByteArray());
                                        }
                                        fn3.b(this.a.a, parseFrom);
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        if (an3.a) {
                            e.printStackTrace();
                            Log.d("BDTLS", "exception=" + e.getMessage());
                        }
                    }
                    this.a.n(str);
                } finally {
                    this.a.c = false;
                }
            }
        }
    }

    public gn3() {
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
        this.a = new pn3();
        this.c = false;
        this.b = new ConcurrentLinkedQueue<>();
    }

    public final void o(int i, un3 un3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048583, this, i, un3Var) == null) && un3Var != null) {
            un3Var.f(i);
        }
    }

    public void p(String str, un3 un3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, un3Var) == null) {
            yg3.l(new a(this, str, un3Var), "SessionController");
        }
    }

    public static gn3 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (e == null) {
                synchronized (gn3.class) {
                    if (e == null) {
                        e = new gn3();
                    }
                }
            }
            return e;
        }
        return (gn3) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            un3 un3Var = this.d;
            if (un3Var == null) {
                return false;
            }
            return un3Var.c();
        }
        return invokeV.booleanValue;
    }

    public pn3 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a == null) {
                this.a = new pn3();
            }
            return this.a;
        }
        return (pn3) invokeV.objValue;
    }

    public final void g(String str, un3 un3Var) {
        byte[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, un3Var) == null) {
            if (un3Var == null) {
                o(-1, null);
            } else if (str == null && TextUtils.equals(un3Var.b(), "POST")) {
                o(-1, un3Var);
            } else {
                if (an3.a) {
                    Log.d("BDTLS", "BdtlsPmsRequest before bdtls encrypt requestData = " + str);
                }
                if (TextUtils.equals(un3Var.b(), "GET")) {
                    b2 = en3.f().b(this.a, null);
                } else {
                    b2 = en3.f().b(this.a, str);
                }
                if (b2 != null) {
                    if (an3.a) {
                        Log.d("BDTLS", "doBdtlsApplicationDataRequest");
                    }
                    un3Var.i(true);
                    this.d = un3Var;
                    un3Var.h(b2);
                    return;
                }
                o(-1, un3Var);
            }
        }
    }

    public final void j(String str, un3 un3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, un3Var) == null) {
            if (this.a.h() != 2) {
                if (!this.a.j()) {
                    if (this.b == null) {
                        this.b = new ConcurrentLinkedQueue<>();
                    }
                    this.b.offer(new kn3(str, un3Var));
                    if (cy2.c()) {
                        ln3 ln3Var = new ln3();
                        long j = ln3Var.getLong("expireTime", 0L);
                        if (j > System.currentTimeMillis() / 1000) {
                            this.a.l(ln3Var.getString("secretKey", "").getBytes());
                            this.a.t(ln3Var.getString("sessionTicket", "").getBytes());
                            this.a.r(j);
                            g(str, un3Var);
                            return;
                        }
                    }
                    h();
                    return;
                }
                g(str, un3Var);
                return;
            }
            i(str, un3Var);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (an3.a) {
                Log.d("BDTLS", "doHandShake");
            }
            if (this.c) {
                if (an3.a) {
                    Log.d("BDTLS", "doHandShake isHandshakeRunning");
                    return;
                }
                return;
            }
            this.c = true;
            byte[] e2 = en3.f().e(this.a);
            if (e2 != null && e2.length > 0) {
                new wn3().a(e2, new b(this));
                return;
            }
            this.c = false;
            n("record data error");
        }
    }

    public final void i(String str, un3 un3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, un3Var) == null) {
            if (un3Var != null && TextUtils.equals(un3Var.b(), "GET")) {
                if (an3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                un3Var.i(false);
                this.d = un3Var;
                un3Var.h(null);
            } else if (un3Var != null && str != null) {
                if (an3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                un3Var.i(false);
                this.d = un3Var;
                un3Var.h(str.getBytes());
            } else {
                o(-1, un3Var);
            }
        }
    }

    public final void n(String str) {
        int i;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (an3.a) {
                Log.d("BDTLS", "onHandshakeError");
            }
            if (TextUtils.equals(str, "down grade")) {
                i = 2;
            } else {
                i = -1;
            }
            this.a.s(i);
            while (true) {
                kn3 poll = this.b.poll();
                if (poll != null) {
                    if (i == 2) {
                        i(poll.b(), poll.a());
                    } else {
                        un3 a2 = poll.a();
                        if (a2 != null) {
                            if (TextUtils.isEmpty(str)) {
                                str2 = "connect fail";
                            } else {
                                str2 = str;
                            }
                            a2.e(new IOException(str2));
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }
}
