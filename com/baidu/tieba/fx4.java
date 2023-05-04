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
public class fx4 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947779495, "Lcom/baidu/tieba/fx4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947779495, "Lcom/baidu/tieba/fx4;");
                return;
            }
        }
        i = new HashSet();
    }

    public fx4() {
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
        fx4 fx4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) && advertAppInfo != null && (fx4Var = advertAppInfo.i) != null && !fx4Var.h && !a(fx4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).r(fx4Var.d).s(fx4Var.e).t(fx4Var.c).w(String.valueOf(fx4Var.b)).p(advertAppInfo.g);
            o11.b(clogBuilder);
            xg8.b(xg8.a(advertAppInfo));
            fx4Var.h = true;
            i.add(fx4Var.g);
        }
    }

    public static void f(op9 op9Var) {
        fx4 fx4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, op9Var) == null) && op9Var != null && op9Var.getAdvertAppInfo() != null && (fx4Var = op9Var.getAdvertAppInfo().i) != null && !fx4Var.h && !a(fx4Var.g)) {
            op9Var.e1 = fx4Var.d;
            op9Var.f1 = fx4Var.e;
            op9Var.d1 = fx4Var.c;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).q(String.valueOf(op9Var.j1 + 1)).w(String.valueOf(op9Var.h1)).v(fx4Var.a).r(fx4Var.d).s(fx4Var.e).t(fx4Var.c).p(fx4Var.g);
            o11.b(clogBuilder);
            fx4Var.h = true;
            i.add(fx4Var.g);
        }
    }

    public static void c(fx4 fx4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{fx4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && fx4Var != null && !fx4Var.h && !a(fx4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(fx4Var.a).q(String.valueOf(i2 + 1)).r(fx4Var.d).s(fx4Var.e).t(fx4Var.c).w(String.valueOf(fx4Var.b)).p(fx4Var.g);
            o11.b(clogBuilder);
            fx4Var.h = true;
            i.add(fx4Var.g);
        }
    }

    public static void e(fx4 fx4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{fx4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && fx4Var != null && !fx4Var.h && !a(fx4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(fx4Var.a).q(String.valueOf(i2 + 1)).w(String.valueOf(fx4Var.b)).p(fx4Var.g);
            o11.b(clogBuilder);
            fx4Var.h = true;
            i.add(fx4Var.g);
        }
    }

    public static void g(fx4 fx4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{fx4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && fx4Var != null && !fx4Var.h && !a(fx4Var.g)) {
            boolean equals = "PB_BANNER".equals(fx4Var.a);
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
                i4 = fx4Var.b;
            }
            q.w(String.valueOf(i4)).v(fx4Var.a).r(fx4Var.d).s(fx4Var.e).t(fx4Var.c).p(fx4Var.g);
            o11.b(clogBuilder);
            fx4Var.h = true;
            i.add(fx4Var.g);
        }
    }

    public static void d(si6 si6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, si6Var) == null) && si6Var != null && si6Var.c() != null && si6Var.c().i != null && !si6Var.c().i.h && !a(si6Var.c().i.g)) {
            si6Var.c().j = si6Var.c().i.a;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(si6Var.c().j).q(String.valueOf(si6Var.c().position + 1)).w(String.valueOf(si6Var.c().i.b)).p(si6Var.c().i.g);
            o11.b(clogBuilder);
            xg8.b(xg8.a(si6Var.c()));
            si6Var.c().i.h = true;
            i.add(si6Var.c().i.g);
        }
    }
}
