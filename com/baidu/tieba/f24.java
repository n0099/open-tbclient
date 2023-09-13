package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiWebView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class f24 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static long b;
    public static Handler c;
    public static long d;
    public static final Handler.Callback e;
    public static final f24 f;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static final class a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-854311868, "Lcom/baidu/tieba/f24$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-854311868, "Lcom/baidu/tieba/f24$a;");
                    return;
                }
            }
            a = new a();
        }

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message msg) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, msg)) == null) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                if (msg.what == 0 && f24.f.g() && f24.a(f24.f) < SapiWebView.DEFAULT_TIMEOUT_MILLIS) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    f24.b = (f24.a(f24.f) + elapsedRealtime) - f24.c(f24.f);
                    f24 f24Var = f24.f;
                    f24.d = elapsedRealtime;
                    Handler b = f24.b(f24.f);
                    if (b != null) {
                        b.sendEmptyMessageDelayed(0, 1000L);
                    }
                    if ((f24.a(f24.f) / 1000) % 15 == 0) {
                        g14.o.U(f24.a(f24.f));
                        return true;
                    }
                    return true;
                }
                f24 f24Var2 = f24.f;
                f24.d = 0L;
                f24.f.i(false);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947712225, "Lcom/baidu/tieba/f24;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947712225, "Lcom/baidu/tieba/f24;");
                return;
            }
        }
        f = new f24();
        e = a.a;
    }

    public f24() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final long f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return b;
        }
        return invokeV.longValue;
    }

    public final boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return a;
        }
        return invokeV.booleanValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            long j = b;
            if (j < 30000) {
                return;
            }
            b = j % 30000;
            g14.o.M();
        }
    }

    public static final /* synthetic */ long a(f24 f24Var) {
        return b;
    }

    public static final /* synthetic */ Handler b(f24 f24Var) {
        return c;
    }

    public static final /* synthetic */ long c(f24 f24Var) {
        return d;
    }

    public final void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            a = z;
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (c == null) {
                c = new Handler(e);
            }
            b = g14.o.A();
            a = true;
            d = SystemClock.elapsedRealtime();
            Handler handler = c;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(0, 1000L);
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            a = false;
            Handler handler = c;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            if (d > 0) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                b = (b + elapsedRealtime) - d;
                d = elapsedRealtime;
            }
            g14.o.U(b);
        }
    }
}
