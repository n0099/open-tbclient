package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.tieba.rk3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes3.dex */
public class bk3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile bk3 e;
    public transient /* synthetic */ FieldHolder $fh;
    public kk3 a;
    public ConcurrentLinkedQueue<fk3> b;
    public volatile boolean c;
    public pk3 d;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ pk3 b;
        public final /* synthetic */ bk3 c;

        public a(bk3 bk3Var, String str, pk3 pk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bk3Var, str, pk3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = bk3Var;
            this.a = str;
            this.b = pk3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                nd4.e().f();
                this.c.j(this.a, this.b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements rk3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bk3 a;

        public b(bk3 bk3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bk3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bk3Var;
        }

        @Override // com.baidu.tieba.rk3.b
        public void a(boolean z, byte[] bArr) {
            String str;
            ik3 a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, bArr) == null) {
                str = "";
                try {
                    try {
                        if (vj3.a) {
                            Log.d("BDTLS", "doHandShake response");
                        }
                        if (z && bArr != null && (a = mk3.a(bArr)) != null) {
                            byte i = a.i();
                            byte[] f = a.f();
                            if (f != null) {
                                if (vj3.a) {
                                    Log.d("BDTLS", "doHandShake response schemeType =" + ((int) i));
                                }
                                if (i == 21) {
                                    if (vj3.a) {
                                        Log.d("BDTLS", "doHandShake alert");
                                    }
                                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(f);
                                    if (parseFrom != null) {
                                        if (vj3.a) {
                                            Log.d("BDTLS", "bdtls ubc handshake alert");
                                        }
                                        str = parseFrom.getDescription() != null ? new String(parseFrom.getDescription().toByteArray()) : "";
                                        ak3.b(this.a.a, parseFrom);
                                    }
                                } else if (i == 22) {
                                    if (lk3.a(this.a.a, f) != null) {
                                        if (vj3.a) {
                                            Log.d("BDTLS", "doHandShake serverHello");
                                        }
                                        this.a.a.s(1);
                                        ak3.a("serverHello");
                                        while (true) {
                                            fk3 fk3Var = (fk3) this.a.b.poll();
                                            if (fk3Var == null) {
                                                return;
                                            }
                                            this.a.g(fk3Var.b(), fk3Var.a());
                                        }
                                    } else {
                                        str = "params decode error";
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        if (vj3.a) {
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

    public bk3() {
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
        this.a = new kk3();
        this.c = false;
        this.b = new ConcurrentLinkedQueue<>();
    }

    public static bk3 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (e == null) {
                synchronized (bk3.class) {
                    if (e == null) {
                        e = new bk3();
                    }
                }
            }
            return e;
        }
        return (bk3) invokeV.objValue;
    }

    public final void g(String str, pk3 pk3Var) {
        byte[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, pk3Var) == null) {
            if (pk3Var == null) {
                o(-1, null);
            } else if (str == null && TextUtils.equals(pk3Var.b(), "POST")) {
                o(-1, pk3Var);
            } else {
                if (vj3.a) {
                    Log.d("BDTLS", "BdtlsPmsRequest before bdtls encrypt requestData = " + str);
                }
                if (TextUtils.equals(pk3Var.b(), "GET")) {
                    b2 = zj3.f().b(this.a, null);
                } else {
                    b2 = zj3.f().b(this.a, str);
                }
                if (b2 != null) {
                    if (vj3.a) {
                        Log.d("BDTLS", "doBdtlsApplicationDataRequest");
                    }
                    pk3Var.i(true);
                    this.d = pk3Var;
                    pk3Var.h(b2);
                    return;
                }
                o(-1, pk3Var);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (vj3.a) {
                Log.d("BDTLS", "doHandShake");
            }
            if (this.c) {
                if (vj3.a) {
                    Log.d("BDTLS", "doHandShake isHandshakeRunning");
                    return;
                }
                return;
            }
            this.c = true;
            byte[] e2 = zj3.f().e(this.a);
            if (e2 != null && e2.length > 0) {
                new rk3().a(e2, new b(this));
                return;
            }
            this.c = false;
            n("record data error");
        }
    }

    public final void i(String str, pk3 pk3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, pk3Var) == null) {
            if (pk3Var != null && TextUtils.equals(pk3Var.b(), "GET")) {
                if (vj3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                pk3Var.i(false);
                this.d = pk3Var;
                pk3Var.h(null);
            } else if (pk3Var != null && str != null) {
                if (vj3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                pk3Var.i(false);
                this.d = pk3Var;
                pk3Var.h(str.getBytes());
            } else {
                o(-1, pk3Var);
            }
        }
    }

    public final void j(String str, pk3 pk3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, pk3Var) == null) {
            if (this.a.h() != 2) {
                if (!this.a.j()) {
                    if (this.b == null) {
                        this.b = new ConcurrentLinkedQueue<>();
                    }
                    this.b.offer(new fk3(str, pk3Var));
                    if (yu2.c()) {
                        gk3 gk3Var = new gk3();
                        long j = gk3Var.getLong("expireTime", 0L);
                        if (j > System.currentTimeMillis() / 1000) {
                            this.a.l(gk3Var.getString("secretKey", "").getBytes());
                            this.a.t(gk3Var.getString("sessionTicket", "").getBytes());
                            this.a.r(j);
                            g(str, pk3Var);
                            return;
                        }
                    }
                    h();
                    return;
                }
                g(str, pk3Var);
                return;
            }
            i(str, pk3Var);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            pk3 pk3Var = this.d;
            if (pk3Var == null) {
                return false;
            }
            return pk3Var.c();
        }
        return invokeV.booleanValue;
    }

    public kk3 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a == null) {
                this.a = new kk3();
            }
            return this.a;
        }
        return (kk3) invokeV.objValue;
    }

    public final void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048582, this, str) != null) {
            return;
        }
        if (vj3.a) {
            Log.d("BDTLS", "onHandshakeError");
        }
        int i = TextUtils.equals(str, "down grade") ? 2 : -1;
        this.a.s(i);
        while (true) {
            fk3 poll = this.b.poll();
            if (poll == null) {
                return;
            }
            if (i == 2) {
                i(poll.b(), poll.a());
            } else {
                pk3 a2 = poll.a();
                if (a2 != null) {
                    a2.e(new IOException(TextUtils.isEmpty(str) ? "connect fail" : str));
                }
            }
        }
    }

    public final void o(int i, pk3 pk3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048583, this, i, pk3Var) == null) || pk3Var == null) {
            return;
        }
        pk3Var.f(i);
    }

    public void p(String str, pk3 pk3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, pk3Var) == null) {
            ud3.l(new a(this, str, pk3Var), "SessionController");
        }
    }
}
