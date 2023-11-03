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
public class gw4 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947808325, "Lcom/baidu/tieba/gw4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947808325, "Lcom/baidu/tieba/gw4;");
                return;
            }
        }
        i = new HashSet();
    }

    public gw4() {
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
        gw4 gw4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) && advertAppInfo != null && (gw4Var = advertAppInfo.i) != null && !gw4Var.h && !a(gw4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).r(gw4Var.d).s(gw4Var.e).t(gw4Var.c).w(String.valueOf(gw4Var.b)).p(advertAppInfo.g);
            az0.e(clogBuilder);
            dc9.b(dc9.a(advertAppInfo));
            gw4Var.h = true;
            i.add(gw4Var.g);
        }
    }

    public static void d(AdvertAppInfo advertAppInfo) {
        gw4 gw4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, advertAppInfo) == null) && advertAppInfo != null && (gw4Var = advertAppInfo.i) != null && !gw4Var.h && !a(gw4Var.g)) {
            advertAppInfo.j = advertAppInfo.i.a;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).w(String.valueOf(advertAppInfo.i.b)).p(advertAppInfo.i.g);
            az0.e(clogBuilder);
            dc9.b(dc9.a(advertAppInfo));
            gw4 gw4Var2 = advertAppInfo.i;
            gw4Var2.h = true;
            i.add(gw4Var2.g);
        }
    }

    public static void g(tra traVar) {
        gw4 gw4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, traVar) == null) && traVar != null && traVar.getAdvertAppInfo() != null && (gw4Var = traVar.getAdvertAppInfo().i) != null && !gw4Var.h && !a(gw4Var.g)) {
            traVar.j1 = gw4Var.d;
            traVar.k1 = gw4Var.e;
            traVar.i1 = gw4Var.c;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).q(String.valueOf(traVar.o1 + 1)).w(String.valueOf(traVar.m1)).v(gw4Var.a).r(gw4Var.d).s(gw4Var.e).t(gw4Var.c).p(gw4Var.g);
            az0.e(clogBuilder);
            gw4Var.h = true;
            i.add(gw4Var.g);
        }
    }

    public static void c(gw4 gw4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{gw4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && gw4Var != null && !gw4Var.h && !a(gw4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(gw4Var.a).q(String.valueOf(i2 + 1)).r(gw4Var.d).s(gw4Var.e).t(gw4Var.c).w(String.valueOf(gw4Var.b)).p(gw4Var.g);
            az0.e(clogBuilder);
            gw4Var.h = true;
            i.add(gw4Var.g);
        }
    }

    public static void f(gw4 gw4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{gw4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && gw4Var != null && !gw4Var.h && !a(gw4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(gw4Var.a).q(String.valueOf(i2 + 1)).w(String.valueOf(gw4Var.b)).p(gw4Var.g);
            az0.e(clogBuilder);
            gw4Var.h = true;
            i.add(gw4Var.g);
        }
    }

    public static void h(gw4 gw4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{gw4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && gw4Var != null && !gw4Var.h && !a(gw4Var.g)) {
            boolean equals = "PB_BANNER".equals(gw4Var.a);
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
                i4 = gw4Var.b;
            }
            q.w(String.valueOf(i4)).v(gw4Var.a).r(gw4Var.d).s(gw4Var.e).t(gw4Var.c).p(gw4Var.g);
            az0.e(clogBuilder);
            gw4Var.h = true;
            i.add(gw4Var.g);
        }
    }

    public static void e(hm6 hm6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, hm6Var) == null) && hm6Var != null && hm6Var.c() != null && hm6Var.c().i != null && !hm6Var.c().i.h && !a(hm6Var.c().i.g)) {
            hm6Var.c().j = hm6Var.c().i.a;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(hm6Var.c().j).q(String.valueOf(hm6Var.c().position + 1)).w(String.valueOf(hm6Var.c().i.b)).p(hm6Var.c().i.g);
            az0.e(clogBuilder);
            dc9.b(dc9.a(hm6Var.c()));
            hm6Var.c().i.h = true;
            i.add(hm6Var.c().i.g);
        }
    }
}
