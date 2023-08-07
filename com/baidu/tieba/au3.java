package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.bdtls.impl.model.Bdtls$Alert;
import com.baidu.tieba.qu3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes5.dex */
public class au3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile au3 e;
    public transient /* synthetic */ FieldHolder $fh;
    public ju3 a;
    public ConcurrentLinkedQueue<eu3> b;
    public volatile boolean c;
    public ou3 d;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ ou3 b;
        public final /* synthetic */ au3 c;

        public a(au3 au3Var, String str, ou3 ou3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {au3Var, str, ou3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = au3Var;
            this.a = str;
            this.b = ou3Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                nn4.e().f();
                this.c.j(this.a, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements qu3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ au3 a;

        public b(au3 au3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {au3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = au3Var;
        }

        @Override // com.baidu.tieba.qu3.b
        public void a(boolean z, byte[] bArr) {
            hu3 a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, bArr) == null) {
                String str = "";
                try {
                    try {
                        if (ut3.a) {
                            Log.d("BDTLS", "doHandShake response");
                        }
                        if (z && bArr != null && (a = lu3.a(bArr)) != null) {
                            byte i = a.i();
                            byte[] f = a.f();
                            if (f != null) {
                                if (ut3.a) {
                                    Log.d("BDTLS", "doHandShake response schemeType =" + ((int) i));
                                }
                                if (i != 21) {
                                    if (i == 22) {
                                        if (ku3.a(this.a.a, f) != null) {
                                            if (ut3.a) {
                                                Log.d("BDTLS", "doHandShake serverHello");
                                            }
                                            this.a.a.s(1);
                                            zt3.a("serverHello");
                                            while (true) {
                                                eu3 eu3Var = (eu3) this.a.b.poll();
                                                if (eu3Var != null) {
                                                    this.a.g(eu3Var.b(), eu3Var.a());
                                                } else {
                                                    return;
                                                }
                                            }
                                        } else {
                                            str = "params decode error";
                                        }
                                    }
                                } else {
                                    if (ut3.a) {
                                        Log.d("BDTLS", "doHandShake alert");
                                    }
                                    Bdtls$Alert parseFrom = Bdtls$Alert.parseFrom(f);
                                    if (parseFrom != null) {
                                        if (ut3.a) {
                                            Log.d("BDTLS", "bdtls ubc handshake alert");
                                        }
                                        if (parseFrom.getDescription() != null) {
                                            str = new String(parseFrom.getDescription().toByteArray());
                                        }
                                        zt3.b(this.a.a, parseFrom);
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        if (ut3.a) {
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

    public au3() {
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
        this.a = new ju3();
        this.c = false;
        this.b = new ConcurrentLinkedQueue<>();
    }

    public final void o(int i, ou3 ou3Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048583, this, i, ou3Var) == null) && ou3Var != null) {
            ou3Var.f(i);
        }
    }

    public void p(String str, ou3 ou3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, ou3Var) == null) {
            sn3.l(new a(this, str, ou3Var), "SessionController");
        }
    }

    public static au3 l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (e == null) {
                synchronized (au3.class) {
                    if (e == null) {
                        e = new au3();
                    }
                }
            }
            return e;
        }
        return (au3) invokeV.objValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ou3 ou3Var = this.d;
            if (ou3Var == null) {
                return false;
            }
            return ou3Var.c();
        }
        return invokeV.booleanValue;
    }

    public ju3 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.a == null) {
                this.a = new ju3();
            }
            return this.a;
        }
        return (ju3) invokeV.objValue;
    }

    public final void g(String str, ou3 ou3Var) {
        byte[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, str, ou3Var) == null) {
            if (ou3Var == null) {
                o(-1, null);
            } else if (str == null && TextUtils.equals(ou3Var.b(), "POST")) {
                o(-1, ou3Var);
            } else {
                if (ut3.a) {
                    Log.d("BDTLS", "BdtlsPmsRequest before bdtls encrypt requestData = " + str);
                }
                if (TextUtils.equals(ou3Var.b(), "GET")) {
                    b2 = yt3.f().b(this.a, null);
                } else {
                    b2 = yt3.f().b(this.a, str);
                }
                if (b2 != null) {
                    if (ut3.a) {
                        Log.d("BDTLS", "doBdtlsApplicationDataRequest");
                    }
                    ou3Var.i(true);
                    this.d = ou3Var;
                    ou3Var.h(b2);
                    return;
                }
                o(-1, ou3Var);
            }
        }
    }

    public final void j(String str, ou3 ou3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, ou3Var) == null) {
            if (this.a.h() != 2) {
                if (!this.a.j()) {
                    if (this.b == null) {
                        this.b = new ConcurrentLinkedQueue<>();
                    }
                    this.b.offer(new eu3(str, ou3Var));
                    if (w43.c()) {
                        fu3 fu3Var = new fu3();
                        long j = fu3Var.getLong("expireTime", 0L);
                        if (j > System.currentTimeMillis() / 1000) {
                            this.a.l(fu3Var.getString("secretKey", "").getBytes());
                            this.a.t(fu3Var.getString("sessionTicket", "").getBytes());
                            this.a.r(j);
                            g(str, ou3Var);
                            return;
                        }
                    }
                    h();
                    return;
                }
                g(str, ou3Var);
                return;
            }
            i(str, ou3Var);
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (ut3.a) {
                Log.d("BDTLS", "doHandShake");
            }
            if (this.c) {
                if (ut3.a) {
                    Log.d("BDTLS", "doHandShake isHandshakeRunning");
                    return;
                }
                return;
            }
            this.c = true;
            byte[] e2 = yt3.f().e(this.a);
            if (e2 != null && e2.length > 0) {
                new qu3().a(e2, new b(this));
                return;
            }
            this.c = false;
            n("record data error");
        }
    }

    public final void i(String str, ou3 ou3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, ou3Var) == null) {
            if (ou3Var != null && TextUtils.equals(ou3Var.b(), "GET")) {
                if (ut3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                ou3Var.i(false);
                this.d = ou3Var;
                ou3Var.h(null);
            } else if (ou3Var != null && str != null) {
                if (ut3.a) {
                    Log.d("BDTLS", "doNormalApplicationDataRequest");
                }
                ou3Var.i(false);
                this.d = ou3Var;
                ou3Var.h(str.getBytes());
            } else {
                o(-1, ou3Var);
            }
        }
    }

    public final void n(String str) {
        int i;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            if (ut3.a) {
                Log.d("BDTLS", "onHandshakeError");
            }
            if (TextUtils.equals(str, "down grade")) {
                i = 2;
            } else {
                i = -1;
            }
            this.a.s(i);
            while (true) {
                eu3 poll = this.b.poll();
                if (poll != null) {
                    if (i == 2) {
                        i(poll.b(), poll.a());
                    } else {
                        ou3 a2 = poll.a();
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
