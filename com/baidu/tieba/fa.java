package com.baidu.tieba;

import android.os.Handler;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidParameterException;
/* loaded from: classes5.dex */
public class fa extends xi {
    public static /* synthetic */ Interceptable $ic;
    public static Handler o;
    public transient /* synthetic */ FieldHolder $fh;
    public CoderException c;
    public SocketMessage d;
    public volatile int e;
    public Runnable f;
    public ha g;
    public boolean h;
    public int i;
    public int j;
    public long k;
    public SocketMessageTask l;
    public long m;
    public long n;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fa a;

        public a(fa faVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {faVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = faVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.A();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448304210, "Lcom/baidu/tieba/fa;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448304210, "Lcom/baidu/tieba/fa;");
                return;
            }
        }
        o = new Handler(Looper.getMainLooper());
    }

    public final void A() {
        ha haVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (haVar = this.g) != null && this.h) {
            haVar.A(this);
        }
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i = this.j + 1;
            this.j = i;
            return i;
        }
        return invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i = this.i + 1;
            this.i = i;
            return i;
        }
        return invokeV.intValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.l.isCanRetry();
        }
        return invokeV.booleanValue;
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            o.removeCallbacks(u());
        }
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            SocketMessage socketMessage = this.d;
            if (socketMessage != null) {
                return socketMessage.getCmd();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int retry = this.l.getRetry();
            if (retry <= 1) {
                return 1;
            }
            return retry;
        }
        return invokeV.intValue;
    }

    public SocketMessage m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.d;
        }
        return (SocketMessage) invokeV.objValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.l.getPriority();
        }
        return invokeV.intValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.j;
        }
        return invokeV.intValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.i;
        }
        return invokeV.intValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public CoderException r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.c;
        }
        return (CoderException) invokeV.objValue;
    }

    public long s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.k;
        }
        return invokeV.longValue;
    }

    public SocketMessageTask t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.l;
        }
        return (SocketMessageTask) invokeV.objValue;
    }

    public final Runnable u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.f == null) {
                this.f = new a(this);
            }
            return this.f;
        }
        return (Runnable) invokeV.objValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.l.getNeedAck();
        }
        return invokeV.booleanValue;
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            j();
            this.h = false;
        }
    }

    public final void y() {
        ha haVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (haVar = this.g) != null && this.h) {
            haVar.y(this);
        }
    }

    public final void z() {
        ha haVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (haVar = this.g) != null && this.h) {
            haVar.z(this);
        }
    }

    public fa(SocketMessage socketMessage, SocketMessageTask socketMessageTask, ha haVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {socketMessage, socketMessageTask, haVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.d = null;
        this.e = 0;
        this.f = null;
        this.g = null;
        this.h = true;
        this.i = 0;
        this.j = 0;
        this.k = 0L;
        this.l = null;
        if (socketMessage != null && socketMessageTask != null) {
            this.l = socketMessageTask;
            this.d = socketMessage;
            this.g = haVar;
            return;
        }
        throw new InvalidParameterException("SenderData msg null");
    }

    @Override // com.baidu.tieba.ak
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            o.removeCallbacks(u());
            x(i);
        }
    }

    public final void x(int i) {
        ha haVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048598, this, i) == null) && (haVar = this.g) != null && this.h) {
            haVar.x(i, this);
        }
    }

    @Override // com.baidu.tieba.ak
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.k == 0) {
                this.k = System.currentTimeMillis();
            }
            int cmd = this.d.getCmd();
            int i = 0;
            if (e() != null) {
                i = e().length;
            }
            long clientLogID = this.d.getClientLogID();
            int i2 = this.e;
            ja.b("SenderData", cmd, clientLogID, i2, "StartSend", 0, "SenderData: start send size = " + i);
            o.removeCallbacks(u());
            if (this.l.getTimeOut() != null) {
                o.postDelayed(u(), this.l.getTimeOut().b());
            }
            z();
            r9 r9Var = r9.b;
            if (r9Var != null) {
                r9Var.a(this.d.getCmd(), "send", this.d.getData());
            }
        }
    }

    @Override // com.baidu.tieba.ak
    public void c() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int cmd = this.d.getCmd();
            if (e() != null) {
                i = e().length;
            } else {
                i = 0;
            }
            long clientLogID = this.d.getClientLogID();
            int i2 = this.e;
            ja.b("SenderData", cmd, clientLogID, i2, "FinishSend", 0, "SenderData: finish send  size = " + i);
            if (!this.l.getNeedAck()) {
                o.removeCallbacks(u());
            }
            y();
        }
    }

    @Override // com.baidu.tieba.xi
    public byte[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.k == 0) {
                this.k = System.currentTimeMillis();
            }
            this.c = null;
            la f = la.f();
            this.e = ga.a().b();
            SocketMessage socketMessage = this.d;
            if (socketMessage != null) {
                socketMessage.setSquencedId(this.e);
            }
            try {
                return f.e(this.d, this.e, this.l.getNeedCompress(), this.l.getNeedEncrypt());
            } catch (CoderException e) {
                this.c = e;
                return null;
            }
        }
        return (byte[]) invokeV.objValue;
    }
}
