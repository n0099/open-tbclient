package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.tieba.qv3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes5.dex */
public class av3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile av3 e;
    public transient /* synthetic */ FieldHolder $fh;
    public jv3 a;
    public ConcurrentLinkedQueue<ev3> b;
    public volatile boolean c;
    public ov3 d;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ov3 b;
        public final /* synthetic */ av3 c;

        public a(av3 av3Var, String str, ov3 ov3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {av3Var, str, ov3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = av3Var;
            this.a = str;
            this.b = ov3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                no4.e().f();
                this.c.j(this.a, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements qv3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ av3 a;

        public b(av3 av3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {av3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = av3Var;
        }

        @Override // com.baidu.tieba.qv3.b
        public void a(boolean z, byte[] bArr) {
            hv3 a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, bArr) == null) {
                String str = "";
                try {
                    try {
                        if (uu3.a) {
                            Log.d("BDTLS", "doHandShake response");
                        }
                        if (z && bArr != null && (a = lv3.a(bArr)) != null) {
                            byte i = a.i();
                            byte[] f = a.f();
                            if (f != null) {
                                if (uu3.a) {
                                    Log.d("BDTLS", "doHandShake response schemeType =" + ((int) i));
                                }
                                if (i != 21) {
                                    if (i == 22) {
                                        if (kv3.a(this.a.a, f) != null) {
                                            if (uu3.a) {
                                                Log.d("BDTLS", "doHandShake serverHello");
                                            }
                                            this.a.a.s(1);
                                            zu3.a("serverHello");
                                            while (true) {
                                                ev3 ev3Var = (ev3) this.a.b.poll();
                                                if (ev3Var != null) {
                                                    this.a.g(ev3Var.b(), ev3Var.a());
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            str = "params decode error";
                                        }
                                    }
                                } else {
                                    if (uu3.a) {
                                        Log.d("BDTLS", "doHandShake alert");
                                    }
                                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(f);
                                    if (parseFrom != null) {
                                        if (uu3.a) {
                                            Log.d("BDTLS", "bdtls ubc handshake alert");
                                        }
                                        if (parseFrom.getDescription() != null) {
                                            str = new String(parseFrom.getDescription().toByteArray());
                                        }
                                        zu3.b(this.a.a, parseFrom);
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        if (uu3.a) {
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

    public av3() {
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
        this.a = new jv3();
        this.c = false;
        this.b = new ConcurrentLinkedQueue<>();
    }

    public final void o(int i, ov3 ov3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048583, this, i, ov3Var) == null) && ov3Var != null) {
            ov3Var.f(i);
        }
    }

    public void p(String str, ov3 ov3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, ov3Var) == null) {
            so3.l(new a(this, str, ov3Var), "SessionController");
        }
    }

    public static av3 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (e == null) {
                synchronized (av3.class) {
                    if (e == null) {
                        e = new av3();
                    }
                }
            }
            return e;
        }
        return (av3) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ov3 ov3Var = this.d;
            if (ov3Var == null) {
                return false;
            }
            return ov3Var.c();
        }
        return invokeV.booleanValue;
    }

    public jv3 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a == null) {
                this.a = new jv3();
            }
            return this.a;
        }
        return (jv3) invokeV.objValue;
    }

    public final void g(String str, ov3 ov3Var) {
        byte[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, ov3Var) == null) {
            if (ov3Var == null) {
                o(-1, null);
            } else if (str == null && TextUtils.equals(ov3Var.b(), "POST")) {
                o(-1, ov3Var);
            } else {
                if (uu3.a) {
                    Log.d("BDTLS", "BdtlsPmsRequest before bdtls encrypt requestData = " + str);
                }
                if (TextUtils.equals(ov3Var.b(), "GET")) {
                    b2 = yu3.f().b(this.a, null);
                } else {
                    b2 = yu3.f().b(this.a, str);
                }
                if (b2 != null) {
                    if (uu3.a) {
                        Log.d("BDTLS", "doBdtlsApplicationDataRequest");
                    }
                    ov3Var.i(true);
                    this.d = ov3Var;
                    ov3Var.h(b2);
                    return;
                }
                o(-1, ov3Var);
            }
        }
    }

    public final void j(String str, ov3 ov3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, ov3Var) == null) {
            if (this.a.h() != 2) {
                if (!this.a.j()) {
                    if (this.b == null) {
                        this.b = new ConcurrentLinkedQueue<>();
                    }
                    this.b.offer(new ev3(str, ov3Var));
                    if (w53.c()) {
                        fv3 fv3Var = new fv3();
                        long j = fv3Var.getLong("expireTime", 0L);
                        if (j > System.currentTimeMillis() / 1000) {
                            this.a.l(fv3Var.getString("secretKey", "").getBytes());
                            this.a.t(fv3Var.getString("sessionTicket", "").getBytes());
                            this.a.r(j);
                            g(str, ov3Var);
                            return;
                        }
                    }
                    h();
                    return;
                }
                g(str, ov3Var);
                return;
            }
            i(str, ov3Var);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (uu3.a) {
                Log.d("BDTLS", "doHandShake");
            }
            if (this.c) {
                if (uu3.a) {
                    Log.d("BDTLS", "doHandShake isHandshakeRunning");
                    return;
                }
                return;
            }
            this.c = true;
            byte[] e2 = yu3.f().e(this.a);
            if (e2 != null && e2.length > 0) {
                new qv3().a(e2, new b(this));
                return;
            }
            this.c = false;
            n("record data error");
        }
    }

    public final void i(String str, ov3 ov3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, ov3Var) == null) {
            if (ov3Var != null && TextUtils.equals(ov3Var.b(), "GET")) {
                if (uu3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                ov3Var.i(false);
                this.d = ov3Var;
                ov3Var.h(null);
            } else if (ov3Var != null && str != null) {
                if (uu3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                ov3Var.i(false);
                this.d = ov3Var;
                ov3Var.h(str.getBytes());
            } else {
                o(-1, ov3Var);
            }
        }
    }

    public final void n(String str) {
        int i;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (uu3.a) {
                Log.d("BDTLS", "onHandshakeError");
            }
            if (TextUtils.equals(str, "down grade")) {
                i = 2;
            } else {
                i = -1;
            }
            this.a.s(i);
            while (true) {
                ev3 poll = this.b.poll();
                if (poll != null) {
                    if (i == 2) {
                        i(poll.b(), poll.a());
                    } else {
                        ov3 a2 = poll.a();
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
