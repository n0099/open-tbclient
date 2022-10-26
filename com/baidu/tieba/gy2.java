package com.baidu.tieba;

import android.os.Bundle;
import android.os.CountDownTimer;
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
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes4.dex */
public class gy2 implements iy2, qo2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean c;
    public CopyOnWriteArrayList d;
    public CountDownTimer e;

    @Override // com.baidu.tieba.iy2
    public void c(Runnable runnable, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, runnable, str) == null) {
        }
    }

    @Override // com.baidu.tieba.iy2
    public String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? "SwanLaunchTriggerMgr" : (String) invokeV.objValue;
    }

    /* loaded from: classes4.dex */
    public class a extends CountDownTimer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gy2 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(gy2 gy2Var, long j, long j2) {
            super(j, j2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gy2Var, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Long) objArr2[0]).longValue(), ((Long) objArr2[1]).longValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gy2Var;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (qo2.a) {
                    Log.d("SwanPerformance", "count down onFinish");
                }
                this.a.d(true);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
                Iterator it = this.a.d.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (5000 - cVar.e() >= j) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!cVar.g() && z) {
                        cVar.h(true);
                        iy2 f = cVar.f();
                        if (qo2.a) {
                            Log.e("SwanPerformance", "triggerFmp, timeout = " + cVar.e() + ", trigger = " + f.getName());
                        }
                        f.d(true);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public static final gy2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-760172277, "Lcom/baidu/tieba/gy2$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-760172277, "Lcom/baidu/tieba/gy2$b;");
                    return;
                }
            }
            a = new gy2(null);
        }
    }

    /* loaded from: classes4.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public iy2 a;
        public int b;
        public boolean c;

        public c(gy2 gy2Var, iy2 iy2Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gy2Var, iy2Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = false;
            this.a = iy2Var;
            this.b = i;
        }

        public /* synthetic */ c(gy2 gy2Var, iy2 iy2Var, int i, a aVar) {
            this(gy2Var, iy2Var, i);
        }

        public final void h(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
                this.c = z;
            }
        }

        public final int e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.b;
            }
            return invokeV.intValue;
        }

        public final iy2 f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a;
            }
            return (iy2) invokeV.objValue;
        }

        public final boolean g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.c;
            }
            return invokeV.booleanValue;
        }
    }

    public gy2() {
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
        this.c = false;
        this.d = new CopyOnWriteArrayList();
        this.e = new a(this, 5000L, 500L);
    }

    @Override // com.baidu.tieba.iy2
    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.d.isEmpty()) {
            return;
        }
        if (qo2.a) {
            Log.e("SwanPerformance", "triggerDestroy");
        }
        k();
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((c) it.next()).f().b();
        }
        this.c = false;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            try {
                this.e.start();
            } catch (Throwable th) {
                if (qo2.a) {
                    Log.d("SwanPerformance", "start timer exception = " + th.getMessage());
                }
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            try {
                this.e.cancel();
            } catch (Throwable th) {
                if (qo2.a) {
                    Log.d("SwanPerformance", "stop timer exception = " + th.getMessage());
                }
            }
        }
    }

    public /* synthetic */ gy2(a aVar) {
        this();
    }

    public static gy2 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (gy2) invokeV.objValue;
    }

    @Override // com.baidu.tieba.iy2
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (qo2.a) {
                Log.e("SwanPerformance", "triggerFcp, url = " + str);
            }
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                ((c) it.next()).f().a(str);
            }
        }
    }

    public boolean h(iy2 iy2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, iy2Var)) == null) {
            if (iy2Var == null) {
                return false;
            }
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                if (iy2Var.equals(((c) it.next()).f())) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.iy2
    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048579, this, z) != null) || this.c) {
            return;
        }
        this.c = true;
        k();
        if (this.d.isEmpty()) {
            return;
        }
        if (qo2.a) {
            Log.e("SwanPerformance", "triggerFmp, timeout = " + z);
        }
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (!cVar.g()) {
                cVar.h(true);
                cVar.f().d(z);
            }
        }
        fa3.p();
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_timeout", z);
        bundle.putString("app_id", l33.K().getAppId());
        c03 e = c03.e();
        e03 e03Var = new e03(23, bundle);
        e03Var.f(true);
        e.h(e03Var);
    }

    @Override // com.baidu.tieba.iy2
    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            if (nx2.k()) {
                fa3.a0(nx2.j());
            }
            this.c = false;
            if (this.d.isEmpty()) {
                return;
            }
            if (qo2.a) {
                Log.e("SwanPerformance", "triggerLaunch, source = " + str);
            }
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                cVar.h(false);
                cVar.f().e(str);
            }
            k();
            j();
        }
    }

    public void i(iy2 iy2Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048583, this, iy2Var, i) != null) || this.c || iy2Var == null) {
            return;
        }
        if (i > 5000) {
            i = 5000;
        }
        if (!h(iy2Var)) {
            this.d.add(new c(this, iy2Var, i, null));
            if (qo2.a) {
                Log.e("SwanPerformance", "register, task name = " + iy2Var.getName() + " ; timeout = " + i);
            }
        }
    }
}
