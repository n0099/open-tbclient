package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.BdStatsItem;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class dg {
    public static /* synthetic */ Interceptable $ic;
    public static b a;
    public static final Object b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    public static String b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) ? 1 == i ? "2G" : 2 == i ? "3G" : 3 == i ? "4G" : 4 == i ? "5G" : 5 == i ? "WIFI" : "N" : (String) invokeI.objValue;
    }

    /* loaded from: classes5.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public gg a;
        public gg b;
        public gg c;
        public gg d;

        public b() {
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
            this.a = new gg();
            this.b = new gg();
            this.c = new gg();
            this.d = new gg();
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a.g + this.b.g + this.c.g + this.d.g;
            }
            return invokeV.intValue;
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.c.g > 0) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.b.g > 0) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.a.g > 0) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (this.d.g > 0) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.a.a();
                this.b.a();
                this.c.a();
                this.d.a();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448302474, "Lcom/baidu/tieba/dg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448302474, "Lcom/baidu/tieba/dg;");
                return;
            }
        }
        a = new b(null);
        b = new Object();
    }

    public static gg a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (BdNetTypeUtil.isWifiNet()) {
                return a.d;
            }
            if (BdNetTypeUtil.is4GNet()) {
                return a.c;
            }
            if (BdNetTypeUtil.is3GNet()) {
                return a.b;
            }
            return a.a;
        }
        return (gg) invokeV.objValue;
    }

    public static void c(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            synchronized (b) {
                gg a2 = a();
                if (z) {
                    a2.l++;
                    a2.m += j;
                }
            }
        }
    }

    public static void e(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            gg a2 = a();
            if (z) {
                a2.r++;
                a2.s += j;
            }
        }
    }

    public static void f(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            synchronized (b) {
                gg a2 = a();
                a2.d++;
                if (z) {
                    a2.e++;
                    a2.f += j;
                }
            }
        }
    }

    public static void i(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            gg a2 = a();
            a2.a++;
            if (z) {
                a2.b++;
                a2.c += j;
            }
        }
    }

    public static void k(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            gg a2 = a();
            if (z) {
                a2.n++;
                a2.o += j;
            }
        }
    }

    public static void l(boolean z, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{Boolean.valueOf(z), Long.valueOf(j)}) == null) {
            synchronized (b) {
                gg a2 = a();
                if (z) {
                    a2.j++;
                    a2.k += j;
                }
            }
        }
    }

    public static void d(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            gg a2 = a();
            if (z) {
                a2.t++;
            }
            if (z2) {
                a2.u++;
            }
            if (z3) {
                a2.v++;
            }
        }
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, null) == null) && a.a() > 10) {
            if (a.e()) {
                h(a.d, 5);
            }
            if (a.b()) {
                h(a.c, 3);
            }
            if (a.c()) {
                h(a.b, 2);
            }
            if (a.d()) {
                h(a.a, 1);
            }
            a.f();
        }
    }

    public static void h(gg ggVar, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(65544, null, ggVar, i) != null) || ggVar == null || !BdBaseApplication.getInst().isSmallFlow()) {
            return;
        }
        BdStatsItem statsItem = BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
        statsItem.append("action", "imgStat");
        statsItem.append("memoryCount", String.valueOf(ggVar.a));
        statsItem.append("memorySucCount", String.valueOf(ggVar.b));
        statsItem.append("memoryTime", String.valueOf(ggVar.c));
        statsItem.append("localCount", String.valueOf(ggVar.d));
        statsItem.append("localSucCount", String.valueOf(ggVar.e));
        statsItem.append("localTime", String.valueOf(ggVar.f));
        statsItem.append("netCount", String.valueOf(ggVar.g));
        statsItem.append("netSucCount", String.valueOf(ggVar.h));
        statsItem.append("netTime", String.valueOf(ggVar.i));
        statsItem.append("taskCount", String.valueOf(ggVar.j));
        statsItem.append("taskTime", String.valueOf(ggVar.k));
        statsItem.append("decodeCount", String.valueOf(ggVar.l));
        statsItem.append("decodeTime", String.valueOf(ggVar.m));
        statsItem.append("saveMemoryCount", String.valueOf(ggVar.n));
        statsItem.append("saveMemoryTime", String.valueOf(ggVar.o));
        statsItem.append("saveLocalCount", String.valueOf(ggVar.p));
        statsItem.append("saveLocalTime", String.valueOf(ggVar.q));
        statsItem.append("memoryHitCount", String.valueOf(ggVar.t));
        statsItem.append("localHitCount", String.valueOf(ggVar.u));
        statsItem.append("netHitCount", String.valueOf(ggVar.v));
        statsItem.append("totalHitCount", String.valueOf(ggVar.t + ggVar.u + ggVar.v));
        statsItem.append("totalCount", String.valueOf(ggVar.r));
        statsItem.append("totalTime", String.valueOf(ggVar.s));
        statsItem.append("cdnCount", String.valueOf(ggVar.w));
        statsItem.append("ipCount", String.valueOf(ggVar.x));
        statsItem.append("cdnAndIpCount", String.valueOf(ggVar.y));
        statsItem.append("imgSize", String.valueOf(ggVar.z));
        statsItem.append(FpsTracer.UBC_KEY_NET_TYPE, b(i));
        BdStatisticsManager.getInstance().performance("image", statsItem);
    }

    public static void j(boolean z, String str, of ofVar, long j, long j2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65546, null, new Object[]{Boolean.valueOf(z), str, ofVar, Long.valueOf(j), Long.valueOf(j2)}) != null) || !BdUtilHelper.isNetOk()) {
            return;
        }
        synchronized (b) {
            boolean m = m(str);
            boolean z2 = false;
            if (ofVar != null && !StringUtils.isNull(ofVar.k)) {
                z2 = true;
            }
            gg a2 = a();
            if (m) {
                a2.w++;
            }
            if (z2) {
                a2.x++;
            }
            if (m && z2) {
                a2.y++;
            }
            a2.g++;
            if (z) {
                a2.h++;
                a2.i += j;
                a2.z += j2;
            }
            if (a.a() > 100) {
                g();
            }
        }
    }

    public static boolean m(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            if (str == null) {
                return false;
            }
            int indexOf = str.indexOf("hiphotos");
            if (indexOf > 0 && indexOf < 20) {
                return true;
            }
            int indexOf2 = str.indexOf("tiebapic");
            if (indexOf2 <= 0 || indexOf2 >= 20) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
