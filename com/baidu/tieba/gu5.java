package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsMainTable;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class gu5 extends fu5 {
    public static /* synthetic */ Interceptable $ic;
    public static gu5 E;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public long B;
    public long C;
    public long D;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public long f;
    public long g;
    public long h;
    public long i;
    public long j;
    public long k;
    public long l;
    public long m;
    public long n;
    public long o;
    public long p;
    public long q;
    public long r;
    public long s;
    public long t;
    public long u;
    public long v;
    public long w;
    public long x;
    public long y;
    public long z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947806434, "Lcom/baidu/tieba/gu5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947806434, "Lcom/baidu/tieba/gu5;");
        }
    }

    public void B(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
        }
    }

    public void i(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j) == null) {
        }
    }

    public void p(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048598, this, j) == null) {
        }
    }

    public gu5() {
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
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = -1L;
        this.g = -1L;
        this.h = -1L;
        this.i = -1L;
        this.j = -1L;
        this.k = -1L;
        this.l = -1L;
        this.m = -1L;
        this.n = -1L;
        this.o = -1L;
        this.p = -1L;
        this.q = -1L;
        this.r = -1L;
        this.s = -1L;
        this.t = -1L;
        this.u = -1L;
        this.v = -1L;
        this.w = -1L;
        this.x = -1L;
        this.y = -1L;
        this.z = -1L;
        this.A = -1L;
        this.B = -1L;
        this.C = -1L;
        this.D = -1L;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.b = false;
            this.c = false;
            this.f = -1L;
            this.g = -1L;
            this.w = -1L;
            this.h = -1L;
            this.i = -1L;
            this.j = -1L;
            this.B = -1L;
            this.t = -1L;
            this.u = -1L;
            this.r = -1L;
            this.C = -1L;
            this.D = -1L;
            this.k = -1L;
            this.l = -1L;
            this.m = -1L;
            this.n = -1L;
            this.o = -1L;
            this.p = -1L;
            this.q = -1L;
            this.s = -1L;
            this.v = -1L;
            this.x = -1L;
            this.y = -1L;
            this.z = -1L;
            this.A = -1L;
        }
    }

    public static gu5 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (E == null) {
                synchronized (gu5.class) {
                    if (E == null) {
                        E = new gu5();
                    }
                }
            }
            return E;
        }
        return (gu5) invokeV.objValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.f;
        }
        return invokeV.longValue;
    }

    public long d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.w;
        }
        return invokeV.longValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public void A(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            this.i = j;
        }
    }

    public void C(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.y = j;
        }
    }

    public void D(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJ(1048579, this, j) != null) || this.z > 0) {
            return;
        }
        this.z = j;
    }

    public void E(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.A = j;
        }
    }

    public void F(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.g = j;
        }
    }

    public void G(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.o = j;
        }
    }

    public void H(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.n = j;
        }
    }

    public void I(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j) == null) {
            this.x = j;
        }
    }

    public void j(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j) == null) {
            this.r = j;
        }
    }

    public void k(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048593, this, j) == null) {
            this.s = j;
        }
    }

    public void l(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j) == null) {
            this.u = j;
        }
    }

    public void m(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048595, this, j) == null) {
            this.t = j;
        }
    }

    public void n(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048596, this, j) == null) {
            this.p = j;
        }
    }

    public void o(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJ(1048597, this, j) != null) || this.v > 0) {
            return;
        }
        this.v = j;
        this.w = System.currentTimeMillis() - this.f;
    }

    public void q(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048599, this, j) == null) {
            this.k = j;
        }
    }

    public void r(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048600, this, j) == null) {
            this.m = j;
        }
    }

    public void s(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048601, this, j) == null) {
            this.l = j;
        }
    }

    public void t(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048602, this, j) == null) {
            this.f = j;
        }
    }

    public void u(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048603, this, j) == null) {
            this.h = j;
        }
    }

    public void v(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048604, this, j) == null) {
            this.B = j;
        }
    }

    public void w(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048605, this, j) == null) {
            this.C = j;
        }
    }

    public void x(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048606, this, j) == null) {
            this.D = j;
            this.c = true;
        }
    }

    public void y(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048607, this, j) == null) {
            this.q = j;
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.b = z;
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            long j = 0;
            if (this.D - this.f <= 0 || this.d || this.v <= 0 || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
                return;
            }
            long j2 = this.g - this.f;
            long j3 = -1;
            long j4 = this.t;
            if (j4 > 0) {
                j3 = this.u - j4;
            }
            this.d = true;
            long j5 = this.D - this.C;
            eh a = fu5.a();
            a.b("procname", "main");
            a.b("appc", String.valueOf(j2));
            a.b("loadclass", String.valueOf(this.h));
            a.b("sapiinit", String.valueOf(this.i));
            a.b("acctinit", String.valueOf(this.A));
            a.b("iminit", String.valueOf(this.y));
            a.b("plugininit", String.valueOf(this.z));
            a.b("patchloaded", String.valueOf(this.j));
            a.b("naslibinit", String.valueOf(this.k));
            a.b("websocketinit", String.valueOf(this.l));
            a.b("settinginit", String.valueOf(this.m));
            a.b("toastinit", String.valueOf(this.n));
            a.b("tiebastaticinit", String.valueOf(this.o));
            a.b("cdninit", String.valueOf(this.p));
            a.b("messagesetinit", String.valueOf(this.q));
            a.b("logores", String.valueOf(this.B));
            a.b("opttest", String.valueOf(1));
            long j6 = this.r;
            String str = "1";
            if (j6 > 0 && this.t > 0 && j3 > 0) {
                a.b("adc", String.valueOf(j6 + this.s));
                a.b(SpeedStatsMainTable.AD_SHOW, String.valueOf(j3));
                a.b("adrequest", String.valueOf(this.s));
                j = this.r + this.s + j3;
                a.b("hasad", "1");
            } else {
                a.b("hasad", "0");
                long j7 = this.s;
                if (j7 > 0) {
                    j = j7;
                }
            }
            a.b("tabc", String.valueOf(j5));
            a.b("costt", String.valueOf(this.w - j));
            if (!this.b) {
                str = "0";
            }
            a.b("newinst", str);
            a.c("pluginloadsync", Boolean.valueOf(this.e));
            a.b("hptotal", String.valueOf(this.v));
            a.b("locationinit", String.valueOf(j2 + this.B + this.r + j3 + this.s + j5 + this.v));
            a.b("userperceptiont", String.valueOf(this.x - j));
            BdStatisticsManager.getInstance().performance("startt", a);
            h();
        }
    }

    public void g(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048589, this, j) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && j > 0) {
            eh a = fu5.a();
            a.b("procname", "remote");
            a.b("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", a);
        }
    }
}
