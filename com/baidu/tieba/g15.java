package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.nadcore.stats.request.ClogBuilder;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class g15 {
    public static /* synthetic */ Interceptable $ic;
    public static final Set<String> i;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public int b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public boolean h;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947741086, "Lcom/baidu/tieba/g15;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947741086, "Lcom/baidu/tieba/g15;");
                return;
            }
        }
        i = new HashSet();
    }

    public g15() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return i.contains(str);
        }
        return invokeL.booleanValue;
    }

    public static void b(AdvertAppInfo advertAppInfo) {
        g15 g15Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) && advertAppInfo != null && (g15Var = advertAppInfo.i) != null && !g15Var.h && !a(g15Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).r(g15Var.d).s(g15Var.e).t(g15Var.c).w(String.valueOf(g15Var.b)).p(advertAppInfo.g);
            x31.e(clogBuilder);
            d39.b(d39.a(advertAppInfo));
            g15Var.h = true;
            i.add(g15Var.g);
        }
    }

    public static void d(AdvertAppInfo advertAppInfo) {
        g15 g15Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, advertAppInfo) == null) && advertAppInfo != null && (g15Var = advertAppInfo.i) != null && !g15Var.h && !a(g15Var.g)) {
            advertAppInfo.j = advertAppInfo.i.a;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).w(String.valueOf(advertAppInfo.i.b)).p(advertAppInfo.i.g);
            x31.e(clogBuilder);
            d39.b(d39.a(advertAppInfo));
            g15 g15Var2 = advertAppInfo.i;
            g15Var2.h = true;
            i.add(g15Var2.g);
        }
    }

    public static void g(sha shaVar) {
        g15 g15Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, shaVar) == null) && shaVar != null && shaVar.getAdvertAppInfo() != null && (g15Var = shaVar.getAdvertAppInfo().i) != null && !g15Var.h && !a(g15Var.g)) {
            shaVar.j1 = g15Var.d;
            shaVar.k1 = g15Var.e;
            shaVar.i1 = g15Var.c;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).q(String.valueOf(shaVar.o1 + 1)).w(String.valueOf(shaVar.m1)).v(g15Var.a).r(g15Var.d).s(g15Var.e).t(g15Var.c).p(g15Var.g);
            x31.e(clogBuilder);
            g15Var.h = true;
            i.add(g15Var.g);
        }
    }

    public static void c(g15 g15Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{g15Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && g15Var != null && !g15Var.h && !a(g15Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(g15Var.a).q(String.valueOf(i2 + 1)).r(g15Var.d).s(g15Var.e).t(g15Var.c).w(String.valueOf(g15Var.b)).p(g15Var.g);
            x31.e(clogBuilder);
            g15Var.h = true;
            i.add(g15Var.g);
        }
    }

    public static void f(g15 g15Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{g15Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && g15Var != null && !g15Var.h && !a(g15Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(g15Var.a).q(String.valueOf(i2 + 1)).w(String.valueOf(g15Var.b)).p(g15Var.g);
            x31.e(clogBuilder);
            g15Var.h = true;
            i.add(g15Var.g);
        }
    }

    public static void h(g15 g15Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{g15Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && g15Var != null && !g15Var.h && !a(g15Var.g)) {
            boolean equals = "PB_BANNER".equals(g15Var.a);
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            ClogBuilder y = clogBuilder.y(logType);
            int i4 = -1;
            if (equals) {
                i3 = -1;
            } else {
                i3 = i2 + 1;
            }
            ClogBuilder q = y.q(String.valueOf(i3));
            if (!equals) {
                i4 = g15Var.b;
            }
            q.w(String.valueOf(i4)).v(g15Var.a).r(g15Var.d).s(g15Var.e).t(g15Var.c).p(g15Var.g);
            x31.e(clogBuilder);
            g15Var.h = true;
            i.add(g15Var.g);
        }
    }

    public static void e(wp6 wp6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, wp6Var) == null) && wp6Var != null && wp6Var.c() != null && wp6Var.c().i != null && !wp6Var.c().i.h && !a(wp6Var.c().i.g)) {
            wp6Var.c().j = wp6Var.c().i.a;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(wp6Var.c().j).q(String.valueOf(wp6Var.c().position + 1)).w(String.valueOf(wp6Var.c().i.b)).p(wp6Var.c().i.g);
            x31.e(clogBuilder);
            d39.b(d39.a(wp6Var.c()));
            wp6Var.c().i.h = true;
            i.add(wp6Var.c().i.g);
        }
    }
}
