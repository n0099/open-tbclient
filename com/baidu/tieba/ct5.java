package com.baidu.tieba;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.idlehelp.IdleHandlerManager;
import com.baidu.adp.lib.service.AsyncService;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.performance.speed.SpeedStats;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.EnterForePvThread;
import com.baidu.tbadk.core.util.PermissionUtil;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.mutiprocess.MutiProcessManager;
import com.baidu.tbadk.mutiprocess.event.AppBackgroundSwitchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class ct5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ct5 j;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public long b;
    public long c;
    public long d;
    public int e;
    public AtomicBoolean f;
    public boolean g;
    public Handler h;
    public Runnable i;

    /* loaded from: classes5.dex */
    public class a implements Handler.Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ct5 a;

        public a(ct5 ct5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ct5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ct5Var;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                if (message.what == 5 && !mv6.a.a()) {
                    if (Boolean.TRUE.equals(message.obj)) {
                        this.a.s();
                        this.a.o();
                        return false;
                    }
                    this.a.p();
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ct5 a;

        public b(ct5 ct5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ct5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ct5Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ct5 ct5Var = this.a;
                if (ct5Var.f == null) {
                    ct5Var.f = new AtomicBoolean(false);
                }
                if (this.a.f.get()) {
                    return;
                }
                this.a.f.set(true);
                if (this.a.n(true)) {
                    TbadkCoreApplication.getInst().fixOppoTimeout();
                    MessageManager.getInstance().dispatchResponsedMessage(new BackgroundSwitchMessage(Boolean.TRUE));
                    MutiProcessManager.publishEvent(new AppBackgroundSwitchEvent(true));
                    TiebaStaticHelper.setCurrentActivity(null);
                    TiebaStatic.save();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(ct5 ct5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ct5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                aw4.c().b();
            }
        }
    }

    public ct5() {
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
        this.a = 0;
        this.b = 0L;
        this.c = 0L;
        this.d = 0L;
        this.e = 0;
        this.f = null;
        this.g = false;
        this.h = new Handler(Looper.getMainLooper(), new a(this));
        this.i = new b(this);
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (n(false)) {
                if (!this.g) {
                    return true;
                }
                Intent intent = new Intent("com.tieba.baidu.notifyprocess");
                intent.setPackage(TbadkCoreApplication.getInst().getPackageName());
                intent.putExtra("message", true);
                TbadkCoreApplication.getInst().sendBroadcast(intent);
                return false;
            }
            Intent intent2 = new Intent("com.tieba.baidu.notifyprocess");
            intent2.setPackage(TbadkCoreApplication.getInst().getPackageName());
            intent2.putExtra("message", false);
            TbadkCoreApplication.getInst().sendBroadcast(intent2);
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean n(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
            return TbadkCoreApplication.getInst().isMainProcess(z);
        }
        return invokeZ.booleanValue;
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.g = !z;
        }
    }

    public static ct5 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (j == null) {
                synchronized (ct5.class) {
                    if (j == null) {
                        j = new ct5();
                    }
                }
            }
            return j;
        }
        return (ct5) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.e++;
            r();
            IdleHandlerManager.getInstance().addOrRunTask("CornerManager", new c(this));
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.e--;
            r();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || !mv6.a.a()) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        o();
        mv6.a.d();
    }

    public void e() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || !mv6.a.a()) {
            return;
        }
        mv6.a.e();
        p();
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.a = 0;
        }
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public long k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.d;
        }
        return invokeV.longValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            AtomicBoolean atomicBoolean = this.f;
            if (atomicBoolean == null) {
                return true;
            }
            return atomicBoolean.get();
        }
        return invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            AtomicBoolean atomicBoolean = this.f;
            if (atomicBoolean == null) {
                return false;
            }
            return atomicBoolean.get();
        }
        return invokeV.booleanValue;
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            AsyncService.INSTANCE.sendRunnable(this.i);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.e == 0) {
            long j2 = this.c;
            if (j2 > 0) {
                mv6.a.c(j2);
                this.c = 0L;
                this.d = 0L;
            }
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            Handler handler = this.h;
            handler.sendMessageDelayed(handler.obtainMessage(5, Boolean.TRUE), 1000L);
        }
    }

    public void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            this.b = System.currentTimeMillis();
            new EnterForePvThread().start();
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            AsyncService.INSTANCE.removeRunnable(this.i);
            if (this.f == null) {
                this.f = new AtomicBoolean(true);
            }
            if (!this.f.get()) {
                return;
            }
            this.f.set(false);
            this.a++;
            if (n(true)) {
                long currentTimeMillis = System.currentTimeMillis();
                long j2 = this.b;
                if ((currentTimeMillis - j2 > 3600000 || j2 == 0) && PermissionUtil.isAgreePrivacyPolicy()) {
                    u();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new BackgroundSwitchMessage(Boolean.FALSE));
                MutiProcessManager.publishEvent(new AppBackgroundSwitchEvent(false));
            }
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.e < 0) {
                this.e = 0;
            }
            if (n(true) && this.c == 0 && this.e > 0) {
                this.c = System.nanoTime();
                this.d = System.currentTimeMillis();
            }
            this.h.removeMessages(5);
            if (this.e == 0) {
                SpeedStats.getInstance().onAppBackground();
                t();
                return;
            }
            AtomicBoolean atomicBoolean = this.f;
            if (atomicBoolean == null || atomicBoolean.get()) {
                SpeedStats.getInstance().onAppForeground();
                Handler handler = this.h;
                handler.sendMessageDelayed(handler.obtainMessage(5, Boolean.FALSE), 1000L);
            }
        }
    }
}
