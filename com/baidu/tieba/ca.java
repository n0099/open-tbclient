package com.baidu.tieba;

import android.os.Handler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.security.InvalidParameterException;
/* loaded from: classes3.dex */
public class ca extends lj {
    public static /* synthetic */ Interceptable $ic;
    public static Handler o;
    public transient /* synthetic */ FieldHolder $fh;
    public CoderException c;
    public SocketMessage d;
    public volatile int e;
    public Runnable f;
    public ea g;
    public boolean h;
    public int i;
    public int j;
    public long k;
    public SocketMessageTask l;
    public long m;
    public long n;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ca a;

        public a(ca caVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {caVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = caVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.A();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448301327, "Lcom/baidu/tieba/ca;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448301327, "Lcom/baidu/tieba/ca;");
                return;
            }
        }
        o = new Handler();
    }

    public ca(SocketMessage socketMessage, SocketMessageTask socketMessageTask, ea eaVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {socketMessage, socketMessageTask, eaVar};
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
            this.g = eaVar;
            return;
        }
        throw new InvalidParameterException("SenderData msg null");
    }

    public final void A() {
        ea eaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (eaVar = this.g) != null && this.h) {
            eaVar.A(this);
        }
    }

    @Override // com.baidu.tieba.ok
    public void a(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            o.removeCallbacks(u());
            x(i);
        }
    }

    @Override // com.baidu.tieba.ok
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (this.k == 0) {
                this.k = System.currentTimeMillis();
            }
            int cmd = this.d.getCmd();
            int length = e() != null ? e().length : 0;
            long clientLogID = this.d.getClientLogID();
            int i = this.e;
            ga.b("SenderData", cmd, clientLogID, i, "StartSend", 0, "SenderData: start send size = " + length);
            o.removeCallbacks(u());
            if (this.l.getTimeOut() != null) {
                o.postDelayed(u(), this.l.getTimeOut().b());
            }
            z();
            o9 o9Var = o9.b;
            if (o9Var != null) {
                o9Var.a(this.d.getCmd(), "send", this.d.getData());
            }
        }
    }

    @Override // com.baidu.tieba.ok
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int cmd = this.d.getCmd();
            int length = e() != null ? e().length : 0;
            long clientLogID = this.d.getClientLogID();
            int i = this.e;
            ga.b("SenderData", cmd, clientLogID, i, "FinishSend", 0, "SenderData: finish send  size = " + length);
            if (!this.l.b()) {
                o.removeCallbacks(u());
            }
            y();
        }
    }

    @Override // com.baidu.tieba.lj
    public byte[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.k == 0) {
                this.k = System.currentTimeMillis();
            }
            this.c = null;
            ia f = ia.f();
            this.e = da.a().b();
            SocketMessage socketMessage = this.d;
            if (socketMessage != null) {
                socketMessage.setSquencedId(this.e);
                BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                SocketMessage socketMessage2 = this.d;
                long clientLogID = socketMessage2 == null ? -1L : socketMessage2.getClientLogID();
                String valueOf = String.valueOf(this.e & 4294967295L);
                Object[] objArr = new Object[2];
                objArr[0] = "cmd";
                SocketMessage socketMessage3 = this.d;
                objArr[1] = Integer.valueOf(socketMessage3 == null ? -1 : socketMessage3.getCmd());
                bdStatisticsManager.newDebug("seqid", clientLogID, valueOf, objArr);
            }
            try {
                return f.e(this.d, this.e, this.l.c(), this.l.getNeedEncrypt());
            } catch (CoderException e) {
                this.c = e;
                return null;
            }
        }
        return (byte[]) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.l.d() : invokeV.booleanValue;
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
            if (retry > 1) {
                return retry;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public SocketMessage m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.d : (SocketMessage) invokeV.objValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.l.getPriority() : invokeV.intValue;
    }

    public int o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.j : invokeV.intValue;
    }

    public int p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.i : invokeV.intValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.e : invokeV.intValue;
    }

    public CoderException r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.c : (CoderException) invokeV.objValue;
    }

    public long s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.k : invokeV.longValue;
    }

    public SocketMessageTask t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.l : (SocketMessageTask) invokeV.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.l.b() : invokeV.booleanValue;
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            j();
            this.h = false;
        }
    }

    public final void x(int i) {
        ea eaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048598, this, i) == null) && (eaVar = this.g) != null && this.h) {
            eaVar.x(i, this);
        }
    }

    public final void y() {
        ea eaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048599, this) == null) && (eaVar = this.g) != null && this.h) {
            eaVar.y(this);
        }
    }

    public final void z() {
        ea eaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && (eaVar = this.g) != null && this.h) {
            eaVar.z(this);
        }
    }
}
