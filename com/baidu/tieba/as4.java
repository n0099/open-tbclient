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
/* loaded from: classes3.dex */
public class as4 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947625735, "Lcom/baidu/tieba/as4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947625735, "Lcom/baidu/tieba/as4;");
                return;
            }
        }
        i = new HashSet();
    }

    public as4() {
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
        as4 as4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) && advertAppInfo != null && (as4Var = advertAppInfo.i) != null && !as4Var.h && !a(as4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).r(as4Var.d).s(as4Var.e).t(as4Var.c).w(String.valueOf(as4Var.b)).p(advertAppInfo.g);
            z01.b(clogBuilder);
            zl7.b(zl7.a(advertAppInfo));
            as4Var.h = true;
            i.add(as4Var.g);
        }
    }

    public static void f(ks8 ks8Var) {
        as4 as4Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65543, null, ks8Var) == null) && ks8Var != null && ks8Var.getAdvertAppInfo() != null && (as4Var = ks8Var.getAdvertAppInfo().i) != null && !as4Var.h && !a(as4Var.g)) {
            ks8Var.Z0 = as4Var.d;
            ks8Var.a1 = as4Var.e;
            ks8Var.Y0 = as4Var.c;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).q(String.valueOf(ks8Var.e1 + 1)).w(String.valueOf(ks8Var.c1)).v(as4Var.a).r(as4Var.d).s(as4Var.e).t(as4Var.c).p(as4Var.g);
            z01.b(clogBuilder);
            as4Var.h = true;
            i.add(as4Var.g);
        }
    }

    public static void c(as4 as4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{as4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && as4Var != null && !as4Var.h && !a(as4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(as4Var.a).q(String.valueOf(i2 + 1)).r(as4Var.d).s(as4Var.e).t(as4Var.c).w(String.valueOf(as4Var.b)).p(as4Var.g);
            z01.b(clogBuilder);
            as4Var.h = true;
            i.add(as4Var.g);
        }
    }

    public static void e(as4 as4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{as4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && as4Var != null && !as4Var.h && !a(as4Var.g)) {
            ClogBuilder clogBuilder = new ClogBuilder();
            if (z) {
                logType = ClogBuilder.LogType.STOCK;
            } else {
                logType = ClogBuilder.LogType.SHOW;
            }
            clogBuilder.y(logType).v(as4Var.a).q(String.valueOf(i2 + 1)).w(String.valueOf(as4Var.b)).p(as4Var.g);
            z01.b(clogBuilder);
            as4Var.h = true;
            i.add(as4Var.g);
        }
    }

    public static void g(as4 as4Var, int i2, boolean z) {
        ClogBuilder.LogType logType;
        int i3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{as4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && as4Var != null && !as4Var.h && !a(as4Var.g)) {
            boolean equals = "PB_BANNER".equals(as4Var.a);
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
                i4 = as4Var.b;
            }
            q.w(String.valueOf(i4)).v(as4Var.a).r(as4Var.d).s(as4Var.e).t(as4Var.c).p(as4Var.g);
            z01.b(clogBuilder);
            as4Var.h = true;
            i.add(as4Var.g);
        }
    }

    public static void d(q56 q56Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, q56Var) == null) && q56Var != null && q56Var.c() != null && q56Var.c().i != null && !q56Var.c().i.h && !a(q56Var.c().i.g)) {
            q56Var.c().j = q56Var.c().i.a;
            ClogBuilder clogBuilder = new ClogBuilder();
            clogBuilder.y(ClogBuilder.LogType.SHOW).v(q56Var.c().j).q(String.valueOf(q56Var.c().position + 1)).w(String.valueOf(q56Var.c().i.b)).p(q56Var.c().i.g);
            z01.b(clogBuilder);
            zl7.b(zl7.a(q56Var.c()));
            q56Var.c().i.h = true;
            i.add(q56Var.c().i.g);
        }
    }
}
