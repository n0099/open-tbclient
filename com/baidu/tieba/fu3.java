package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.tieba.vu3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes6.dex */
public class fu3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile fu3 e;
    public transient /* synthetic */ FieldHolder $fh;
    public ou3 a;
    public ConcurrentLinkedQueue<ju3> b;
    public volatile boolean c;
    public tu3 d;

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ tu3 b;
        public final /* synthetic */ fu3 c;

        public a(fu3 fu3Var, String str, tu3 tu3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fu3Var, str, tu3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = fu3Var;
            this.a = str;
            this.b = tu3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                sn4.e().f();
                this.c.j(this.a, this.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements vu3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fu3 a;

        public b(fu3 fu3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fu3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fu3Var;
        }

        @Override // com.baidu.tieba.vu3.b
        public void a(boolean z, byte[] bArr) {
            mu3 a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, bArr) == null) {
                String str = "";
                try {
                    try {
                        if (zt3.a) {
                            Log.d("BDTLS", "doHandShake response");
                        }
                        if (z && bArr != null && (a = qu3.a(bArr)) != null) {
                            byte i = a.i();
                            byte[] f = a.f();
                            if (f != null) {
                                if (zt3.a) {
                                    Log.d("BDTLS", "doHandShake response schemeType =" + ((int) i));
                                }
                                if (i != 21) {
                                    if (i == 22) {
                                        if (pu3.a(this.a.a, f) != null) {
                                            if (zt3.a) {
                                                Log.d("BDTLS", "doHandShake serverHello");
                                            }
                                            this.a.a.s(1);
                                            eu3.a("serverHello");
                                            while (true) {
                                                ju3 ju3Var = (ju3) this.a.b.poll();
                                                if (ju3Var != null) {
                                                    this.a.g(ju3Var.b(), ju3Var.a());
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            str = "params decode error";
                                        }
                                    }
                                } else {
                                    if (zt3.a) {
                                        Log.d("BDTLS", "doHandShake alert");
                                    }
                                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(f);
                                    if (parseFrom != null) {
                                        if (zt3.a) {
                                            Log.d("BDTLS", "bdtls ubc handshake alert");
                                        }
                                        if (parseFrom.getDescription() != null) {
                                            str = new String(parseFrom.getDescription().toByteArray());
                                        }
                                        eu3.b(this.a.a, parseFrom);
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        if (zt3.a) {
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

    public fu3() {
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
        this.a = new ou3();
        this.c = false;
        this.b = new ConcurrentLinkedQueue<>();
    }

    public final void o(int i, tu3 tu3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048583, this, i, tu3Var) == null) && tu3Var != null) {
            tu3Var.f(i);
        }
    }

    public void p(String str, tu3 tu3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, tu3Var) == null) {
            xn3.l(new a(this, str, tu3Var), "SessionController");
        }
    }

    public static fu3 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (e == null) {
                synchronized (fu3.class) {
                    if (e == null) {
                        e = new fu3();
                    }
                }
            }
            return e;
        }
        return (fu3) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            tu3 tu3Var = this.d;
            if (tu3Var == null) {
                return false;
            }
            return tu3Var.c();
        }
        return invokeV.booleanValue;
    }

    public ou3 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a == null) {
                this.a = new ou3();
            }
            return this.a;
        }
        return (ou3) invokeV.objValue;
    }

    public final void g(String str, tu3 tu3Var) {
        byte[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, tu3Var) == null) {
            if (tu3Var == null) {
                o(-1, null);
            } else if (str == null && TextUtils.equals(tu3Var.b(), "POST")) {
                o(-1, tu3Var);
            } else {
                if (zt3.a) {
                    Log.d("BDTLS", "BdtlsPmsRequest before bdtls encrypt requestData = " + str);
                }
                if (TextUtils.equals(tu3Var.b(), "GET")) {
                    b2 = du3.f().b(this.a, null);
                } else {
                    b2 = du3.f().b(this.a, str);
                }
                if (b2 != null) {
                    if (zt3.a) {
                        Log.d("BDTLS", "doBdtlsApplicationDataRequest");
                    }
                    tu3Var.i(true);
                    this.d = tu3Var;
                    tu3Var.h(b2);
                    return;
                }
                o(-1, tu3Var);
            }
        }
    }

    public final void j(String str, tu3 tu3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, tu3Var) == null) {
            if (this.a.h() != 2) {
                if (!this.a.j()) {
                    if (this.b == null) {
                        this.b = new ConcurrentLinkedQueue<>();
                    }
                    this.b.offer(new ju3(str, tu3Var));
                    if (b53.c()) {
                        ku3 ku3Var = new ku3();
                        long j = ku3Var.getLong("expireTime", 0L);
                        if (j > System.currentTimeMillis() / 1000) {
                            this.a.l(ku3Var.getString("secretKey", "").getBytes());
                            this.a.t(ku3Var.getString("sessionTicket", "").getBytes());
                            this.a.r(j);
                            g(str, tu3Var);
                            return;
                        }
                    }
                    h();
                    return;
                }
                g(str, tu3Var);
                return;
            }
            i(str, tu3Var);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (zt3.a) {
                Log.d("BDTLS", "doHandShake");
            }
            if (this.c) {
                if (zt3.a) {
                    Log.d("BDTLS", "doHandShake isHandshakeRunning");
                    return;
                }
                return;
            }
            this.c = true;
            byte[] e2 = du3.f().e(this.a);
            if (e2 != null && e2.length > 0) {
                new vu3().a(e2, new b(this));
                return;
            }
            this.c = false;
            n("record data error");
        }
    }

    public final void i(String str, tu3 tu3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, tu3Var) == null) {
            if (tu3Var != null && TextUtils.equals(tu3Var.b(), "GET")) {
                if (zt3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                tu3Var.i(false);
                this.d = tu3Var;
                tu3Var.h(null);
            } else if (tu3Var != null && str != null) {
                if (zt3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                tu3Var.i(false);
                this.d = tu3Var;
                tu3Var.h(str.getBytes());
            } else {
                o(-1, tu3Var);
            }
        }
    }

    public final void n(String str) {
        int i;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (zt3.a) {
                Log.d("BDTLS", "onHandshakeError");
            }
            if (TextUtils.equals(str, "down grade")) {
                i = 2;
            } else {
                i = -1;
            }
            this.a.s(i);
            while (true) {
                ju3 poll = this.b.poll();
                if (poll != null) {
                    if (i == 2) {
                        i(poll.b(), poll.a());
                    } else {
                        tu3 a2 = poll.a();
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
