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
/* loaded from: classes4.dex */
public class ey4 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947750665, "Lcom/baidu/tieba/ey4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947750665, "Lcom/baidu/tieba/ey4;");
                return;
            }
        }
        i = new HashSet();
    }

    public ey4() {
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
        ey4 ey4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) && advertAppInfo != null && (ey4Var = advertAppInfo.i) != null && !ey4Var.h && !a(ey4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).r(ey4Var.d).s(ey4Var.e).t(ey4Var.c).w(String.valueOf(ey4Var.b)).p(advertAppInfo.g);
            u21.b(clogBuilder);
            my7.b(my7.a(advertAppInfo));
            ey4Var.h = true;
            i.add(ey4Var.g);
        }
    }

    public static void f(v59 v59Var) {
        ey4 ey4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, v59Var) == null) && v59Var != null && v59Var.getAdvertAppInfo() != null && (ey4Var = v59Var.getAdvertAppInfo().i) != null && !ey4Var.h && !a(ey4Var.g)) {
            v59Var.c1 = ey4Var.d;
            v59Var.d1 = ey4Var.e;
            v59Var.b1 = ey4Var.c;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).q(String.valueOf(v59Var.h1 + 1)).w(String.valueOf(v59Var.f1)).v(ey4Var.a).r(ey4Var.d).s(ey4Var.e).t(ey4Var.c).p(ey4Var.g);
            u21.b(clogBuilder);
            ey4Var.h = true;
            i.add(ey4Var.g);
        }
    }

    public static void c(ey4 ey4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{ey4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && ey4Var != null && !ey4Var.h && !a(ey4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(ey4Var.a).q(String.valueOf(i2 + 1)).r(ey4Var.d).s(ey4Var.e).t(ey4Var.c).w(String.valueOf(ey4Var.b)).p(ey4Var.g);
            u21.b(clogBuilder);
            ey4Var.h = true;
            i.add(ey4Var.g);
        }
    }

    public static void e(ey4 ey4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{ey4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && ey4Var != null && !ey4Var.h && !a(ey4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(ey4Var.a).q(String.valueOf(i2 + 1)).w(String.valueOf(ey4Var.b)).p(ey4Var.g);
            u21.b(clogBuilder);
            ey4Var.h = true;
            i.add(ey4Var.g);
        }
    }

    public static void g(ey4 ey4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{ey4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && ey4Var != null && !ey4Var.h && !a(ey4Var.g)) {
            boolean equals = "PB_BANNER".equals(ey4Var.a);
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
                i4 = ey4Var.b;
            }
            q.w(String.valueOf(i4)).v(ey4Var.a).r(ey4Var.d).s(ey4Var.e).t(ey4Var.c).p(ey4Var.g);
            u21.b(clogBuilder);
            ey4Var.h = true;
            i.add(ey4Var.g);
        }
    }

    public static void d(gg6 gg6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, gg6Var) == null) && gg6Var != null && gg6Var.c() != null && gg6Var.c().i != null && !gg6Var.c().i.h && !a(gg6Var.c().i.g)) {
            gg6Var.c().j = gg6Var.c().i.a;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(gg6Var.c().j).q(String.valueOf(gg6Var.c().position + 1)).w(String.valueOf(gg6Var.c().i.b)).p(gg6Var.c().i.g);
            u21.b(clogBuilder);
            my7.b(my7.a(gg6Var.c()));
            gg6Var.c().i.h = true;
            i.add(gg6Var.c().i.g);
        }
    }
}
