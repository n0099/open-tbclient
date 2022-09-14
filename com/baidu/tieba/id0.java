package com.baidu.tieba;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public class id0 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String f = "id0";
    public transient /* synthetic */ FieldHolder $fh;
    public HandlerThread a;
    public Handler b;
    public kd0 c;
    public od0 d;
    public volatile boolean e;

    /* loaded from: classes4.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ByteBuffer a;
        public int b;
        public long c;

        public a(id0 id0Var, ByteBuffer byteBuffer, int i, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {id0Var, byteBuffer, Integer.valueOf(i), Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = byteBuffer;
            this.b = i;
            this.c = j;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ id0 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(id0 id0Var, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {id0Var, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = id0Var;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                switch (message.what) {
                    case 1001:
                        this.a.k((nd0) message.obj);
                        return;
                    case 1002:
                        this.a.l();
                        return;
                    case 1003:
                        a aVar = (a) message.obj;
                        this.a.h(aVar.a, aVar.b, aVar.c);
                        return;
                    case 1004:
                        this.a.m();
                        return;
                    case 1005:
                        this.a.j();
                        return;
                    case 1006:
                        this.a.i();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947849524, "Lcom/baidu/tieba/id0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947849524, "Lcom/baidu/tieba/id0;");
        }
    }

    public id0() {
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
        this.e = false;
    }

    public void g(ByteBuffer byteBuffer, int i, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{byteBuffer, Integer.valueOf(i), Long.valueOf(j)}) == null) || byteBuffer == null || i <= 0) {
            return;
        }
        a aVar = new a(this, byteBuffer, i, j);
        if (this.b == null || !this.e) {
            return;
        }
        Handler handler = this.b;
        handler.sendMessage(handler.obtainMessage(1003, aVar));
    }

    public final void h(ByteBuffer byteBuffer, int i, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{byteBuffer, Integer.valueOf(i), Long.valueOf(j)}) == null) || Build.VERSION.SDK_INT < 18) {
            return;
        }
        this.c.a(false, byteBuffer, i, j);
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            Handler handler = this.b;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.b = null;
            }
            HandlerThread handlerThread = this.a;
            if (handlerThread != null) {
                handlerThread.quit();
                this.a = null;
            }
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || Build.VERSION.SDK_INT < 18) {
            return;
        }
        kd0 kd0Var = this.c;
        if (kd0Var != null) {
            kd0Var.i();
            this.c.e();
        }
        this.c = null;
        this.d = null;
    }

    public final void k(nd0 nd0Var) {
        kd0 kd0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, nd0Var) == null) || Build.VERSION.SDK_INT < 18 || (kd0Var = this.c) == null) {
            return;
        }
        kd0Var.k(nd0Var, this.d);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || Build.VERSION.SDK_INT < 18) {
            return;
        }
        this.c.h();
    }

    public final void m() {
        kd0 kd0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || Build.VERSION.SDK_INT < 18 || (kd0Var = this.c) == null) {
            return;
        }
        kd0Var.a(true, null, 0, 0L);
    }

    public final void n(od0 od0Var, md0 md0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, od0Var, md0Var) == null) {
            HandlerThread handlerThread = new HandlerThread("AudioRecorderThread");
            this.a = handlerThread;
            handlerThread.start();
            this.b = new b(this, this.a.getLooper());
            try {
                this.c = new kd0();
            } catch (VerifyError unused) {
                Log.e(f, "initRecorder verifyError");
                if (this.c == null) {
                    return;
                }
            }
            this.d = od0Var;
            if (Build.VERSION.SDK_INT >= 18) {
                this.c.f(md0Var);
            }
        }
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            HandlerThread handlerThread = this.a;
            return handlerThread != null && handlerThread.isAlive();
        }
        return invokeV.booleanValue;
    }

    public void p() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (handler = this.b) == null) {
            return;
        }
        handler.removeCallbacksAndMessages(null);
        Handler handler2 = this.b;
        handler2.sendMessage(handler2.obtainMessage(1005));
        Handler handler3 = this.b;
        handler3.sendMessage(handler3.obtainMessage(1006));
    }

    public boolean q(nd0 nd0Var, od0 od0Var, md0 md0Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, nd0Var, od0Var, md0Var)) == null) {
            if (o()) {
                Log.e(f, "setupRecorder error! As last audio recorder thread is alive!");
                return false;
            }
            n(od0Var, md0Var);
            Handler handler = this.b;
            handler.sendMessage(handler.obtainMessage(1001, nd0Var));
            this.e = true;
            return true;
        }
        return invokeLLL.booleanValue;
    }

    public void r() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (handler = this.b) == null) {
            return;
        }
        handler.sendMessage(handler.obtainMessage(1002));
    }

    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && this.b != null && this.e) {
            this.e = false;
            Handler handler = this.b;
            handler.sendMessage(handler.obtainMessage(1004));
        }
    }
}
