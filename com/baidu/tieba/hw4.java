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
public class hw4 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947838116, "Lcom/baidu/tieba/hw4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947838116, "Lcom/baidu/tieba/hw4;");
                return;
            }
        }
        i = new HashSet();
    }

    public hw4() {
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
        hw4 hw4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) && advertAppInfo != null && (hw4Var = advertAppInfo.i) != null && !hw4Var.h && !a(hw4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).r(hw4Var.d).s(hw4Var.e).t(hw4Var.c).w(String.valueOf(hw4Var.b)).p(advertAppInfo.g);
            bz0.e(clogBuilder);
            uf9.b(uf9.a(advertAppInfo));
            hw4Var.h = true;
            i.add(hw4Var.g);
        }
    }

    public static void d(AdvertAppInfo advertAppInfo) {
        hw4 hw4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, advertAppInfo) == null) && advertAppInfo != null && (hw4Var = advertAppInfo.i) != null && !hw4Var.h && !a(hw4Var.g)) {
            advertAppInfo.j = advertAppInfo.i.a;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).w(String.valueOf(advertAppInfo.i.b)).p(advertAppInfo.i.g);
            bz0.e(clogBuilder);
            uf9.b(uf9.a(advertAppInfo));
            hw4 hw4Var2 = advertAppInfo.i;
            hw4Var2.h = true;
            i.add(hw4Var2.g);
        }
    }

    public static void g(mwa mwaVar) {
        hw4 hw4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65544, null, mwaVar) == null) && mwaVar != null && mwaVar.getAdvertAppInfo() != null && (hw4Var = mwaVar.getAdvertAppInfo().i) != null && !hw4Var.h && !a(hw4Var.g)) {
            mwaVar.l1 = hw4Var.d;
            mwaVar.m1 = hw4Var.e;
            mwaVar.k1 = hw4Var.c;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).q(String.valueOf(mwaVar.q1 + 1)).w(String.valueOf(mwaVar.o1)).v(hw4Var.a).r(hw4Var.d).s(hw4Var.e).t(hw4Var.c).p(hw4Var.g);
            bz0.e(clogBuilder);
            hw4Var.h = true;
            i.add(hw4Var.g);
        }
    }

    public static void c(hw4 hw4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{hw4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && hw4Var != null && !hw4Var.h && !a(hw4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(hw4Var.a).q(String.valueOf(i2 + 1)).r(hw4Var.d).s(hw4Var.e).t(hw4Var.c).w(String.valueOf(hw4Var.b)).p(hw4Var.g);
            bz0.e(clogBuilder);
            hw4Var.h = true;
            i.add(hw4Var.g);
        }
    }

    public static void f(hw4 hw4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{hw4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && hw4Var != null && !hw4Var.h && !a(hw4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(hw4Var.a).q(String.valueOf(i2 + 1)).w(String.valueOf(hw4Var.b)).p(hw4Var.g);
            bz0.e(clogBuilder);
            hw4Var.h = true;
            i.add(hw4Var.g);
        }
    }

    public static void h(hw4 hw4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{hw4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && hw4Var != null && !hw4Var.h && !a(hw4Var.g)) {
            boolean equals = "PB_BANNER".equals(hw4Var.a);
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
                i4 = hw4Var.b;
            }
            q.w(String.valueOf(i4)).v(hw4Var.a).r(hw4Var.d).s(hw4Var.e).t(hw4Var.c).p(hw4Var.g);
            bz0.e(clogBuilder);
            hw4Var.h = true;
            i.add(hw4Var.g);
        }
    }

    public static void e(sm6 sm6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65542, null, sm6Var) == null) && sm6Var != null && sm6Var.c() != null && sm6Var.c().i != null && !sm6Var.c().i.h && !a(sm6Var.c().i.g)) {
            sm6Var.c().j = sm6Var.c().i.a;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(sm6Var.c().j).q(String.valueOf(sm6Var.c().position + 1)).w(String.valueOf(sm6Var.c().i.b)).p(sm6Var.c().i.g);
            bz0.e(clogBuilder);
            uf9.b(uf9.a(sm6Var.c()));
            sm6Var.c().i.h = true;
            i.add(sm6Var.c().i.g);
        }
    }
}
