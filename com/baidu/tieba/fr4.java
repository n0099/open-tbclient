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
public class fr4 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947773729, "Lcom/baidu/tieba/fr4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947773729, "Lcom/baidu/tieba/fr4;");
                return;
            }
        }
        i = new HashSet();
    }

    public fr4() {
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
        fr4 fr4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) && advertAppInfo != null && (fr4Var = advertAppInfo.i) != null && !fr4Var.h && !a(fr4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).r(fr4Var.d).s(fr4Var.e).t(fr4Var.c).w(String.valueOf(fr4Var.b)).p(advertAppInfo.g);
            i01.b(clogBuilder);
            gh7.b(gh7.a(advertAppInfo));
            fr4Var.h = true;
            i.add(fr4Var.g);
        }
    }

    public static void f(qn8 qn8Var) {
        fr4 fr4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, qn8Var) == null) && qn8Var != null && qn8Var.getAdvertAppInfo() != null && (fr4Var = qn8Var.getAdvertAppInfo().i) != null && !fr4Var.h && !a(fr4Var.g)) {
            qn8Var.X0 = fr4Var.d;
            qn8Var.Y0 = fr4Var.e;
            qn8Var.W0 = fr4Var.c;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).q(String.valueOf(qn8Var.c1 + 1)).w(String.valueOf(qn8Var.a1)).v(fr4Var.a).r(fr4Var.d).s(fr4Var.e).t(fr4Var.c).p(fr4Var.g);
            i01.b(clogBuilder);
            fr4Var.h = true;
            i.add(fr4Var.g);
        }
    }

    public static void c(fr4 fr4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{fr4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && fr4Var != null && !fr4Var.h && !a(fr4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(fr4Var.a).q(String.valueOf(i2 + 1)).r(fr4Var.d).s(fr4Var.e).t(fr4Var.c).w(String.valueOf(fr4Var.b)).p(fr4Var.g);
            i01.b(clogBuilder);
            fr4Var.h = true;
            i.add(fr4Var.g);
        }
    }

    public static void e(fr4 fr4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{fr4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && fr4Var != null && !fr4Var.h && !a(fr4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(fr4Var.a).q(String.valueOf(i2 + 1)).w(String.valueOf(fr4Var.b)).p(fr4Var.g);
            i01.b(clogBuilder);
            fr4Var.h = true;
            i.add(fr4Var.g);
        }
    }

    public static void g(fr4 fr4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{fr4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && fr4Var != null && !fr4Var.h && !a(fr4Var.g)) {
            boolean equals = "PB_BANNER".equals(fr4Var.a);
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
                i4 = fr4Var.b;
            }
            q.w(String.valueOf(i4)).v(fr4Var.a).r(fr4Var.d).s(fr4Var.e).t(fr4Var.c).p(fr4Var.g);
            i01.b(clogBuilder);
            fr4Var.h = true;
            i.add(fr4Var.g);
        }
    }

    public static void d(y26 y26Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, y26Var) == null) && y26Var != null && y26Var.c() != null && y26Var.c().i != null && !y26Var.c().i.h && !a(y26Var.c().i.g)) {
            y26Var.c().j = y26Var.c().i.a;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(y26Var.c().j).q(String.valueOf(y26Var.c().position + 1)).w(String.valueOf(y26Var.c().i.b)).p(y26Var.c().i.g);
            i01.b(clogBuilder);
            gh7.b(gh7.a(y26Var.c()));
            y26Var.c().i.h = true;
            i.add(y26Var.c().i.g);
        }
    }
}
