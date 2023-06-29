package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.tieba.uv3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes5.dex */
public class ev3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ev3 e;
    public transient /* synthetic */ FieldHolder $fh;
    public nv3 a;
    public ConcurrentLinkedQueue<iv3> b;
    public volatile boolean c;
    public sv3 d;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ sv3 b;
        public final /* synthetic */ ev3 c;

        public a(ev3 ev3Var, String str, sv3 sv3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ev3Var, str, sv3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ev3Var;
            this.a = str;
            this.b = sv3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ro4.e().f();
                this.c.j(this.a, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements uv3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ev3 a;

        public b(ev3 ev3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ev3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ev3Var;
        }

        @Override // com.baidu.tieba.uv3.b
        public void a(boolean z, byte[] bArr) {
            lv3 a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, bArr) == null) {
                String str = "";
                try {
                    try {
                        if (yu3.a) {
                            Log.d("BDTLS", "doHandShake response");
                        }
                        if (z && bArr != null && (a = pv3.a(bArr)) != null) {
                            byte i = a.i();
                            byte[] f = a.f();
                            if (f != null) {
                                if (yu3.a) {
                                    Log.d("BDTLS", "doHandShake response schemeType =" + ((int) i));
                                }
                                if (i != 21) {
                                    if (i == 22) {
                                        if (ov3.a(this.a.a, f) != null) {
                                            if (yu3.a) {
                                                Log.d("BDTLS", "doHandShake serverHello");
                                            }
                                            this.a.a.s(1);
                                            dv3.a("serverHello");
                                            while (true) {
                                                iv3 iv3Var = (iv3) this.a.b.poll();
                                                if (iv3Var != null) {
                                                    this.a.g(iv3Var.b(), iv3Var.a());
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            str = "params decode error";
                                        }
                                    }
                                } else {
                                    if (yu3.a) {
                                        Log.d("BDTLS", "doHandShake alert");
                                    }
                                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(f);
                                    if (parseFrom != null) {
                                        if (yu3.a) {
                                            Log.d("BDTLS", "bdtls ubc handshake alert");
                                        }
                                        if (parseFrom.getDescription() != null) {
                                            str = new String(parseFrom.getDescription().toByteArray());
                                        }
                                        dv3.b(this.a.a, parseFrom);
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        if (yu3.a) {
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

    public ev3() {
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
        this.a = new nv3();
        this.c = false;
        this.b = new ConcurrentLinkedQueue<>();
    }

    public final void o(int i, sv3 sv3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048583, this, i, sv3Var) == null) && sv3Var != null) {
            sv3Var.f(i);
        }
    }

    public void p(String str, sv3 sv3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, sv3Var) == null) {
            wo3.l(new a(this, str, sv3Var), "SessionController");
        }
    }

    public static ev3 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (e == null) {
                synchronized (ev3.class) {
                    if (e == null) {
                        e = new ev3();
                    }
                }
            }
            return e;
        }
        return (ev3) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            sv3 sv3Var = this.d;
            if (sv3Var == null) {
                return false;
            }
            return sv3Var.c();
        }
        return invokeV.booleanValue;
    }

    public nv3 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a == null) {
                this.a = new nv3();
            }
            return this.a;
        }
        return (nv3) invokeV.objValue;
    }

    public final void g(String str, sv3 sv3Var) {
        byte[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, sv3Var) == null) {
            if (sv3Var == null) {
                o(-1, null);
            } else if (str == null && TextUtils.equals(sv3Var.b(), "POST")) {
                o(-1, sv3Var);
            } else {
                if (yu3.a) {
                    Log.d("BDTLS", "BdtlsPmsRequest before bdtls encrypt requestData = " + str);
                }
                if (TextUtils.equals(sv3Var.b(), "GET")) {
                    b2 = cv3.f().b(this.a, null);
                } else {
                    b2 = cv3.f().b(this.a, str);
                }
                if (b2 != null) {
                    if (yu3.a) {
                        Log.d("BDTLS", "doBdtlsApplicationDataRequest");
                    }
                    sv3Var.i(true);
                    this.d = sv3Var;
                    sv3Var.h(b2);
                    return;
                }
                o(-1, sv3Var);
            }
        }
    }

    public final void j(String str, sv3 sv3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, sv3Var) == null) {
            if (this.a.h() != 2) {
                if (!this.a.j()) {
                    if (this.b == null) {
                        this.b = new ConcurrentLinkedQueue<>();
                    }
                    this.b.offer(new iv3(str, sv3Var));
                    if (a63.c()) {
                        jv3 jv3Var = new jv3();
                        long j = jv3Var.getLong("expireTime", 0L);
                        if (j > System.currentTimeMillis() / 1000) {
                            this.a.l(jv3Var.getString("secretKey", "").getBytes());
                            this.a.t(jv3Var.getString("sessionTicket", "").getBytes());
                            this.a.r(j);
                            g(str, sv3Var);
                            return;
                        }
                    }
                    h();
                    return;
                }
                g(str, sv3Var);
                return;
            }
            i(str, sv3Var);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (yu3.a) {
                Log.d("BDTLS", "doHandShake");
            }
            if (this.c) {
                if (yu3.a) {
                    Log.d("BDTLS", "doHandShake isHandshakeRunning");
                    return;
                }
                return;
            }
            this.c = true;
            byte[] e2 = cv3.f().e(this.a);
            if (e2 != null && e2.length > 0) {
                new uv3().a(e2, new b(this));
                return;
            }
            this.c = false;
            n("record data error");
        }
    }

    public final void i(String str, sv3 sv3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, sv3Var) == null) {
            if (sv3Var != null && TextUtils.equals(sv3Var.b(), "GET")) {
                if (yu3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                sv3Var.i(false);
                this.d = sv3Var;
                sv3Var.h(null);
            } else if (sv3Var != null && str != null) {
                if (yu3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                sv3Var.i(false);
                this.d = sv3Var;
                sv3Var.h(str.getBytes());
            } else {
                o(-1, sv3Var);
            }
        }
    }

    public final void n(String str) {
        int i;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (yu3.a) {
                Log.d("BDTLS", "onHandshakeError");
            }
            if (TextUtils.equals(str, "down grade")) {
                i = 2;
            } else {
                i = -1;
            }
            this.a.s(i);
            while (true) {
                iv3 poll = this.b.poll();
                if (poll != null) {
                    if (i == 2) {
                        i(poll.b(), poll.a());
                    } else {
                        sv3 a2 = poll.a();
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
