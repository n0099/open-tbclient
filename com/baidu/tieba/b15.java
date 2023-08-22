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
/* loaded from: classes5.dex */
public class b15 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947592131, "Lcom/baidu/tieba/b15;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947592131, "Lcom/baidu/tieba/b15;");
                return;
            }
        }
        i = new HashSet();
    }

    public b15() {
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
        b15 b15Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) && advertAppInfo != null && (b15Var = advertAppInfo.i) != null && !b15Var.h && !a(b15Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).r(b15Var.d).s(b15Var.e).t(b15Var.c).w(String.valueOf(b15Var.b)).p(advertAppInfo.g);
            t31.e(clogBuilder);
            b29.b(b29.a(advertAppInfo));
            b15Var.h = true;
            i.add(b15Var.g);
        }
    }

    public static void d(AdvertAppInfo advertAppInfo) {
        b15 b15Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, advertAppInfo) == null) && advertAppInfo != null && (b15Var = advertAppInfo.i) != null && !b15Var.h && !a(b15Var.g)) {
            advertAppInfo.j = advertAppInfo.i.a;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).w(String.valueOf(advertAppInfo.i.b)).p(advertAppInfo.i.g);
            t31.e(clogBuilder);
            b29.b(b29.a(advertAppInfo));
            b15 b15Var2 = advertAppInfo.i;
            b15Var2.h = true;
            i.add(b15Var2.g);
        }
    }

    public static void g(yfa yfaVar) {
        b15 b15Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, yfaVar) == null) && yfaVar != null && yfaVar.getAdvertAppInfo() != null && (b15Var = yfaVar.getAdvertAppInfo().i) != null && !b15Var.h && !a(b15Var.g)) {
            yfaVar.i1 = b15Var.d;
            yfaVar.j1 = b15Var.e;
            yfaVar.h1 = b15Var.c;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).q(String.valueOf(yfaVar.n1 + 1)).w(String.valueOf(yfaVar.l1)).v(b15Var.a).r(b15Var.d).s(b15Var.e).t(b15Var.c).p(b15Var.g);
            t31.e(clogBuilder);
            b15Var.h = true;
            i.add(b15Var.g);
        }
    }

    public static void c(b15 b15Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{b15Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && b15Var != null && !b15Var.h && !a(b15Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(b15Var.a).q(String.valueOf(i2 + 1)).r(b15Var.d).s(b15Var.e).t(b15Var.c).w(String.valueOf(b15Var.b)).p(b15Var.g);
            t31.e(clogBuilder);
            b15Var.h = true;
            i.add(b15Var.g);
        }
    }

    public static void f(b15 b15Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{b15Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && b15Var != null && !b15Var.h && !a(b15Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(b15Var.a).q(String.valueOf(i2 + 1)).w(String.valueOf(b15Var.b)).p(b15Var.g);
            t31.e(clogBuilder);
            b15Var.h = true;
            i.add(b15Var.g);
        }
    }

    public static void h(b15 b15Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{b15Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && b15Var != null && !b15Var.h && !a(b15Var.g)) {
            boolean equals = "PB_BANNER".equals(b15Var.a);
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
                i4 = b15Var.b;
            }
            q.w(String.valueOf(i4)).v(b15Var.a).r(b15Var.d).s(b15Var.e).t(b15Var.c).p(b15Var.g);
            t31.e(clogBuilder);
            b15Var.h = true;
            i.add(b15Var.g);
        }
    }

    public static void e(to6 to6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, to6Var) == null) && to6Var != null && to6Var.c() != null && to6Var.c().i != null && !to6Var.c().i.h && !a(to6Var.c().i.g)) {
            to6Var.c().j = to6Var.c().i.a;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(to6Var.c().j).q(String.valueOf(to6Var.c().position + 1)).w(String.valueOf(to6Var.c().i.b)).p(to6Var.c().i.g);
            t31.e(clogBuilder);
            b29.b(b29.a(to6Var.c()));
            to6Var.c().i.h = true;
            i.add(to6Var.c().i.g);
        }
    }
}
