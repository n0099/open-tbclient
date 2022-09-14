package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.tieba.qm3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes3.dex */
public class am3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile am3 e;
    public transient /* synthetic */ FieldHolder $fh;
    public jm3 a;
    public ConcurrentLinkedQueue<em3> b;
    public volatile boolean c;
    public om3 d;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ om3 b;
        public final /* synthetic */ am3 c;

        public a(am3 am3Var, String str, om3 om3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {am3Var, str, om3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = am3Var;
            this.a = str;
            this.b = om3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                nf4.e().f();
                this.c.j(this.a, this.b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements qm3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ am3 a;

        public b(am3 am3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {am3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = am3Var;
        }

        @Override // com.baidu.tieba.qm3.b
        public void a(boolean z, byte[] bArr) {
            String str;
            hm3 a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, bArr) == null) {
                str = "";
                try {
                    try {
                        if (ul3.a) {
                            Log.d("BDTLS", "doHandShake response");
                        }
                        if (z && bArr != null && (a = lm3.a(bArr)) != null) {
                            byte i = a.i();
                            byte[] f = a.f();
                            if (f != null) {
                                if (ul3.a) {
                                    Log.d("BDTLS", "doHandShake response schemeType =" + ((int) i));
                                }
                                if (i == 21) {
                                    if (ul3.a) {
                                        Log.d("BDTLS", "doHandShake alert");
                                    }
                                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(f);
                                    if (parseFrom != null) {
                                        if (ul3.a) {
                                            Log.d("BDTLS", "bdtls ubc handshake alert");
                                        }
                                        str = parseFrom.getDescription() != null ? new String(parseFrom.getDescription().toByteArray()) : "";
                                        zl3.b(this.a.a, parseFrom);
                                    }
                                } else if (i == 22) {
                                    if (km3.a(this.a.a, f) != null) {
                                        if (ul3.a) {
                                            Log.d("BDTLS", "doHandShake serverHello");
                                        }
                                        this.a.a.s(1);
                                        zl3.a("serverHello");
                                        while (true) {
                                            em3 em3Var = (em3) this.a.b.poll();
                                            if (em3Var == null) {
                                                return;
                                            }
                                            this.a.g(em3Var.b(), em3Var.a());
                                        }
                                    } else {
                                        str = "params decode error";
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        if (ul3.a) {
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

    public am3() {
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
        this.a = new jm3();
        this.c = false;
        this.b = new ConcurrentLinkedQueue<>();
    }

    public static am3 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (e == null) {
                synchronized (am3.class) {
                    if (e == null) {
                        e = new am3();
                    }
                }
            }
            return e;
        }
        return (am3) invokeV.objValue;
    }

    public final void g(String str, om3 om3Var) {
        byte[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, om3Var) == null) {
            if (om3Var == null) {
                o(-1, null);
            } else if (str == null && TextUtils.equals(om3Var.b(), "POST")) {
                o(-1, om3Var);
            } else {
                if (ul3.a) {
                    Log.d("BDTLS", "BdtlsPmsRequest before bdtls encrypt requestData = " + str);
                }
                if (TextUtils.equals(om3Var.b(), "GET")) {
                    b2 = yl3.f().b(this.a, null);
                } else {
                    b2 = yl3.f().b(this.a, str);
                }
                if (b2 != null) {
                    if (ul3.a) {
                        Log.d("BDTLS", "doBdtlsApplicationDataRequest");
                    }
                    om3Var.i(true);
                    this.d = om3Var;
                    om3Var.h(b2);
                    return;
                }
                o(-1, om3Var);
            }
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (ul3.a) {
                Log.d("BDTLS", "doHandShake");
            }
            if (this.c) {
                if (ul3.a) {
                    Log.d("BDTLS", "doHandShake isHandshakeRunning");
                    return;
                }
                return;
            }
            this.c = true;
            byte[] e2 = yl3.f().e(this.a);
            if (e2 != null && e2.length > 0) {
                new qm3().a(e2, new b(this));
                return;
            }
            this.c = false;
            n("record data error");
        }
    }

    public final void i(String str, om3 om3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, om3Var) == null) {
            if (om3Var != null && TextUtils.equals(om3Var.b(), "GET")) {
                if (ul3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                om3Var.i(false);
                this.d = om3Var;
                om3Var.h(null);
            } else if (om3Var != null && str != null) {
                if (ul3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                om3Var.i(false);
                this.d = om3Var;
                om3Var.h(str.getBytes());
            } else {
                o(-1, om3Var);
            }
        }
    }

    public final void j(String str, om3 om3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, om3Var) == null) {
            if (this.a.h() != 2) {
                if (!this.a.j()) {
                    if (this.b == null) {
                        this.b = new ConcurrentLinkedQueue<>();
                    }
                    this.b.offer(new em3(str, om3Var));
                    if (ww2.c()) {
                        fm3 fm3Var = new fm3();
                        long j = fm3Var.getLong("expireTime", 0L);
                        if (j > System.currentTimeMillis() / 1000) {
                            this.a.l(fm3Var.getString("secretKey", "").getBytes());
                            this.a.t(fm3Var.getString("sessionTicket", "").getBytes());
                            this.a.r(j);
                            g(str, om3Var);
                            return;
                        }
                    }
                    h();
                    return;
                }
                g(str, om3Var);
                return;
            }
            i(str, om3Var);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            om3 om3Var = this.d;
            if (om3Var == null) {
                return false;
            }
            return om3Var.c();
        }
        return invokeV.booleanValue;
    }

    public jm3 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a == null) {
                this.a = new jm3();
            }
            return this.a;
        }
        return (jm3) invokeV.objValue;
    }

    public final void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048582, this, str) != null) {
            return;
        }
        if (ul3.a) {
            Log.d("BDTLS", "onHandshakeError");
        }
        int i = TextUtils.equals(str, "down grade") ? 2 : -1;
        this.a.s(i);
        while (true) {
            em3 poll = this.b.poll();
            if (poll == null) {
                return;
            }
            if (i == 2) {
                i(poll.b(), poll.a());
            } else {
                om3 a2 = poll.a();
                if (a2 != null) {
                    a2.e(new IOException(TextUtils.isEmpty(str) ? "connect fail" : str));
                }
            }
        }
    }

    public final void o(int i, om3 om3Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048583, this, i, om3Var) == null) || om3Var == null) {
            return;
        }
        om3Var.f(i);
    }

    public void p(String str, om3 om3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, om3Var) == null) {
            sf3.l(new a(this, str, om3Var), "SessionController");
        }
    }
}
