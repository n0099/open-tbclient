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
public class dr4 {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947714147, "Lcom/baidu/tieba/dr4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947714147, "Lcom/baidu/tieba/dr4;");
                return;
            }
        }
        i = new HashSet();
    }

    public dr4() {
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? i.contains(str) : invokeL.booleanValue;
    }

    public static void b(AdvertAppInfo advertAppInfo) {
        dr4 dr4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, advertAppInfo) == null) || advertAppInfo == null || (dr4Var = advertAppInfo.i) == null || dr4Var.h || a(dr4Var.g)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(ClogBuilder.LogType.SHOW).v(advertAppInfo.j).q(String.valueOf(advertAppInfo.position + 1)).r(dr4Var.d).s(dr4Var.e).t(dr4Var.c).w(String.valueOf(dr4Var.b)).p(advertAppInfo.g);
        h01.b(clogBuilder);
        vg7.b(vg7.a(advertAppInfo));
        dr4Var.h = true;
        i.add(dr4Var.g);
    }

    public static void c(dr4 dr4Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{dr4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || dr4Var == null || dr4Var.h || a(dr4Var.g)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(z ? ClogBuilder.LogType.STOCK : ClogBuilder.LogType.SHOW).v(dr4Var.a).q(String.valueOf(i2 + 1)).r(dr4Var.d).s(dr4Var.e).t(dr4Var.c).w(String.valueOf(dr4Var.b)).p(dr4Var.g);
        h01.b(clogBuilder);
        dr4Var.h = true;
        i.add(dr4Var.g);
    }

    public static void d(r26 r26Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65541, null, r26Var) == null) || r26Var == null || r26Var.c() == null || r26Var.c().i == null || r26Var.c().i.h || a(r26Var.c().i.g)) {
            return;
        }
        r26Var.c().j = r26Var.c().i.a;
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(ClogBuilder.LogType.SHOW).v(r26Var.c().j).q(String.valueOf(r26Var.c().position + 1)).w(String.valueOf(r26Var.c().i.b)).p(r26Var.c().i.g);
        h01.b(clogBuilder);
        vg7.b(vg7.a(r26Var.c()));
        r26Var.c().i.h = true;
        i.add(r26Var.c().i.g);
    }

    public static void e(dr4 dr4Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{dr4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || dr4Var == null || dr4Var.h || a(dr4Var.g)) {
            return;
        }
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(z ? ClogBuilder.LogType.STOCK : ClogBuilder.LogType.SHOW).v(dr4Var.a).q(String.valueOf(i2 + 1)).w(String.valueOf(dr4Var.b)).p(dr4Var.g);
        h01.b(clogBuilder);
        dr4Var.h = true;
        i.add(dr4Var.g);
    }

    public static void f(jn8 jn8Var) {
        dr4 dr4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65543, null, jn8Var) == null) || jn8Var == null || jn8Var.getAdvertAppInfo() == null || (dr4Var = jn8Var.getAdvertAppInfo().i) == null || dr4Var.h || a(dr4Var.g)) {
            return;
        }
        jn8Var.X0 = dr4Var.d;
        jn8Var.Y0 = dr4Var.e;
        jn8Var.W0 = dr4Var.c;
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(ClogBuilder.LogType.SHOW).q(String.valueOf(jn8Var.c1 + 1)).w(String.valueOf(jn8Var.a1)).v(dr4Var.a).r(dr4Var.d).s(dr4Var.e).t(dr4Var.c).p(dr4Var.g);
        h01.b(clogBuilder);
        dr4Var.h = true;
        i.add(dr4Var.g);
    }

    public static void g(dr4 dr4Var, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{dr4Var, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) || dr4Var == null || dr4Var.h || a(dr4Var.g)) {
            return;
        }
        boolean equals = "PB_BANNER".equals(dr4Var.a);
        ClogBuilder clogBuilder = new ClogBuilder();
        clogBuilder.y(z ? ClogBuilder.LogType.STOCK : ClogBuilder.LogType.SHOW).q(String.valueOf(equals ? -1 : i2 + 1)).w(String.valueOf(equals ? -1 : dr4Var.b)).v(dr4Var.a).r(dr4Var.d).s(dr4Var.e).t(dr4Var.c).p(dr4Var.g);
        h01.b(clogBuilder);
        dr4Var.h = true;
        i.add(dr4Var.g);
    }
}
