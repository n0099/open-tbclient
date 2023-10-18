package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.tieba.e92;
import com.baidu.tieba.lo2;
import com.baidu.tieba.og4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes5.dex */
public class e93 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface e {
        void a(String str);

        void b(int i, ih3 ih3Var);
    }

    /* loaded from: classes5.dex */
    public static class f implements e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final e a;
        public final boolean b;

        /* loaded from: classes5.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ String a;
            public final /* synthetic */ f b;

            public a(f fVar, String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, str};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = fVar;
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.b.a.a(this.a);
                }
            }
        }

        /* loaded from: classes5.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ ih3 b;
            public final /* synthetic */ f c;

            public b(f fVar, int i, ih3 ih3Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar, Integer.valueOf(i), ih3Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = fVar;
                this.a = i;
                this.b = ih3Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (this.c.b) {
                        h53.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f15ae).G();
                    }
                    this.c.a.b(this.a, this.b);
                }
            }
        }

        public f(@NonNull e eVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
            this.b = z;
        }

        @Override // com.baidu.tieba.e93.e
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                jj3.e0(new a(this, str));
            }
        }

        @Override // com.baidu.tieba.e93.e
        public void b(int i, ih3 ih3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ih3Var) == null) {
                jj3.e0(new b(this, i, ih3Var));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class a extends n82 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e h;
        public final /* synthetic */ String i;

        public a(e eVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = eVar;
            this.i = str;
        }

        @Override // com.baidu.tieba.n82
        public void Q(@NonNull ih3 ih3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, ih3Var) == null) {
                if (e93.a) {
                    Log.d("PagesRoute", "downloadDependentPackages-fail:" + ih3Var);
                }
                this.h.b(2113, ih3Var);
            }
        }

        @Override // com.baidu.tieba.n82
        public void R() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (e93.a) {
                    Log.d("PagesRoute", "downloadDependentPackages-success.");
                }
                this.h.a(this.i);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements e92.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ p53 b;
        public final /* synthetic */ e c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;

        public b(boolean z, p53 p53Var, e eVar, String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z), p53Var, eVar, str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = z;
            this.b = p53Var;
            this.c = eVar;
            this.d = str;
            this.e = str2;
            this.f = str3;
        }

        @Override // com.baidu.tieba.e92.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                e93.h(this.a, this.b.b, "pkg_retry_fail", String.valueOf(2113));
                this.c.b(2113, null);
            }
        }

        @Override // com.baidu.tieba.e92.b
        public void onSuccess() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                e93.h(this.a, this.b.b, "pkg_retry_success", "");
                this.c.a(this.d);
            }
        }

        @Override // com.baidu.tieba.e92.b
        public void b(ih3 ih3Var) {
            long a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ih3Var) == null) {
                boolean o = e93.o(this.b.b, ih3Var);
                if (e93.a) {
                    Log.d("PagesRoute", "getAppPackage-isNeedGetPkgRetry:" + o + ",isRetry:" + this.a + ",pmsErrorCode:" + ih3Var);
                }
                if (o) {
                    e93.i(this.b.b, ih3Var);
                    kq2.b().a(this.b.b);
                    e93.k(this.b, this.e, this.d, this.c, this.f, true);
                    return;
                }
                h53.f(AppRuntime.getAppContext(), R.string.obfuscated_res_0x7f0f15ae).G();
                boolean z = this.a;
                String str = this.b.b;
                if (ih3Var == null) {
                    a = 0;
                } else {
                    a = ih3Var.a();
                }
                e93.h(z, str, "pkg_retry_fail", String.valueOf(a));
                this.c.b(2113, ih3Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements k82 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ e b;
        public final /* synthetic */ String c;

        public c(String str, e eVar, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, eVar, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = eVar;
            this.c = str2;
        }

        @Override // com.baidu.tieba.k82
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                p53 M = p53.M();
                if (M != null) {
                    M.P0(this.a, true);
                }
                this.b.a(this.c);
            }
        }

        @Override // com.baidu.tieba.k82
        public void b(int i, ih3 ih3Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ih3Var) == null) {
                this.b.b(i, ih3Var);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements k82 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ String c;
        public final /* synthetic */ e d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;

        public d(String str, boolean z, String str2, e eVar, String str3, String str4, String str5, String str6, String str7) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z), str2, eVar, str3, str4, str5, str6, str7};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = z;
            this.c = str2;
            this.d = eVar;
            this.e = str3;
            this.f = str4;
            this.g = str5;
            this.h = str6;
            this.i = str7;
        }

        @Override // com.baidu.tieba.k82
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                o53.K().q().P0(this.a, true);
                e93.h(this.b, this.c, "sub_pkg_retry_success", "");
                this.d.a(this.e);
            }
        }

        @Override // com.baidu.tieba.k82
        public void b(int i, ih3 ih3Var) {
            long a;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, ih3Var) == null) {
                boolean o = e93.o(this.c, ih3Var);
                if (e93.a) {
                    Log.d("PagesRoute", "isNeedGetPkgRetry:" + o + ",isRetry:" + this.b + ",pmsErrorCode:" + ih3Var);
                }
                if (o) {
                    e93.i(this.f, ih3Var);
                    kq2.b().a(this.c);
                    e93.n(this.f, this.g, this.h, this.a, this.i, this.e, this.d, true);
                    return;
                }
                boolean z = this.b;
                String str = this.c;
                if (ih3Var == null) {
                    a = 0;
                } else {
                    a = ih3Var.a();
                }
                e93.h(z, str, "sub_pkg_retry_fail", String.valueOf(a));
                this.d.b(i, ih3Var);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947689130, "Lcom/baidu/tieba/e93;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947689130, "Lcom/baidu/tieba/e93;");
                return;
            }
        }
        a = am1.a;
    }

    public static boolean p(mq2 mq2Var, lo2.g gVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65552, null, mq2Var, gVar)) == null) {
            if (gVar == null) {
                return false;
            }
            return q(mq2Var, gVar.b);
        }
        return invokeLL.booleanValue;
    }

    public static void g(p53 p53Var, pv2 pv2Var, String str, e eVar, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65543, null, p53Var, pv2Var, str, eVar, str2) == null) {
            if (p53Var != null) {
                p53Var.B().I(p53Var.getAppId());
            }
            if (eVar == null) {
                return;
            }
            if (p53Var != null && pv2Var != null && !TextUtils.isEmpty(pv2Var.a) && !TextUtils.isEmpty(pv2Var.d)) {
                String str3 = pv2Var.d;
                String d0 = p53Var.d0(pv2Var.a);
                boolean s0 = p53Var.s0(str3);
                if (!g32.d() && !o13.H() && !o13.D()) {
                    if (w03.k(pv2Var.a)) {
                        eVar.a(str);
                        return;
                    }
                    boolean z = true;
                    if (s0) {
                        boolean A = lo2.A(p53Var.b, p53Var.l0());
                        boolean p0 = p53Var.p0();
                        if (A) {
                            if (!p0) {
                                eVar.a(str);
                                return;
                            }
                            Set<og4.a> i = w03.i(p53Var.X().g0());
                            if (i != null && !i.isEmpty()) {
                                z = false;
                            }
                            if (z) {
                                eVar.a(str);
                                return;
                            } else {
                                j(i, eVar, str);
                                return;
                            }
                        } else if (p0) {
                            k(p53Var, str3, str, eVar, str2, false);
                            return;
                        }
                    }
                    if (TextUtils.isEmpty(d0)) {
                        eVar.b(2111, null);
                        return;
                    } else if (p53Var.u0(d0)) {
                        eVar.a(str);
                        return;
                    } else if (p53Var.w0(d0) && p53Var.v0(d0)) {
                        eVar.a(str);
                        p53Var.P0(d0, true);
                        return;
                    } else {
                        String S = p53Var.S(d0);
                        if (TextUtils.isEmpty(S)) {
                            eVar.b(2112, null);
                            return;
                        }
                        boolean r0 = p53Var.r0(str3);
                        if (!lo2.A(p53Var.b, p53Var.l0()) && !r0) {
                            k(p53Var, str3, str, eVar, str2, false);
                            return;
                        }
                        HybridUbcFlow q = uy2.q("route", str2);
                        q.F(new UbcFlowEvent("na_start_sub_package_download"));
                        q.D("sub_state", "1");
                        m(p53Var.b, p53Var.l0(), "3", d0, S, str, new f(eVar, true));
                        return;
                    }
                } else if (!s0 && TextUtils.isEmpty(d0)) {
                    eVar.b(2111, null);
                    return;
                } else {
                    eVar.a(str);
                    return;
                }
            }
            eVar.b(2110, null);
        }
    }

    public static void h(boolean z, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{Boolean.valueOf(z), str, str2, str3}) == null) && z) {
            kq2.b().g(str);
            ic3.L(str2, str3);
        }
    }

    public static void i(String str, ih3 ih3Var) {
        long h;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, str, ih3Var) == null) {
            if (ih3Var == null) {
                h = 0;
            } else {
                h = ih3Var.h();
            }
            if (h == 2205) {
                be2.c().d().u(tj3.a(str), true, 12);
            }
        }
    }

    public static boolean o(String str, ih3 ih3Var) {
        InterceptResult invokeLL;
        long h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, str, ih3Var)) == null) {
            if (ih3Var == null) {
                h = 0;
            } else {
                h = ih3Var.h();
            }
            if (SwanAppNetworkUtils.i(wo2.c()) && kq2.b().f(str) && (h == 2101 || h == 2205)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static void j(Set<og4.a> set, e eVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, set, eVar, str) == null) {
            og4 og4Var = new og4(set);
            og4Var.d("3");
            a aVar = new a(eVar, str);
            aVar.L(1);
            zc4.d(og4Var, aVar);
        }
    }

    public static void k(p53 p53Var, String str, String str2, e eVar, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65547, null, new Object[]{p53Var, str, str2, eVar, str3, Boolean.valueOf(z)}) != null) || eVar == null) {
            return;
        }
        if (p53Var == null) {
            eVar.b(2111, null);
            return;
        }
        HybridUbcFlow q = uy2.q("route", str3);
        q.F(new UbcFlowEvent("na_start_sub_package_download"));
        q.D("sub_state", "1");
        rg4 rg4Var = new rg4(p53Var.b, o53.K().k());
        rg4Var.q(jj3.o(p53Var.l0()));
        rg4Var.t(str);
        zc4.c(rg4Var, new e92(p53Var.b, new b(z, p53Var, eVar, str2, str, str3)));
    }

    public static void l(String str, String str2, String str3, String str4, String str5, String str6, e eVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65548, null, new Object[]{str, str2, str3, str4, str5, str6, eVar}) != null) || eVar == null) {
            return;
        }
        ug4 ug4Var = new ug4(str, str2, str5, 0);
        ug4Var.d(str3);
        zc4.h(ug4Var, new g92(str, str2, new c(str4, eVar, str6)));
    }

    public static void m(String str, String str2, String str3, String str4, String str5, String str6, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{str, str2, str3, str4, str5, str6, eVar}) == null) {
            n(str, str2, str3, str4, str5, str6, eVar, false);
        }
    }

    public static void n(String str, String str2, String str3, String str4, String str5, String str6, e eVar, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65550, null, new Object[]{str, str2, str3, str4, str5, str6, eVar, Boolean.valueOf(z)}) != null) || eVar == null) {
            return;
        }
        String e2 = kq2.b().e(str, str4);
        ug4 ug4Var = new ug4(str, str2, str5, 0);
        ug4Var.d(str3);
        zc4.h(ug4Var, new g92(str, str2, new d(str4, z, e2, eVar, str6, str, str2, str3, str5)));
    }

    public static boolean q(mq2 mq2Var, SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, mq2Var, swanAppConfigData)) == null) {
            if (mq2Var != null && !TextUtils.isEmpty(mq2Var.f0()) && !g32.d() && !o13.D()) {
                String f2 = hj3.f(mq2Var.f0());
                if (!TextUtils.isEmpty(f2) && f2.startsWith(File.separator)) {
                    f2 = f2.substring(1);
                }
                if (swanAppConfigData != null && swanAppConfigData.b != null) {
                    String c2 = h93.c(f2, swanAppConfigData);
                    if (swanAppConfigData.b.c(c2)) {
                        return false;
                    }
                    String str = swanAppConfigData.c.c.get(c2);
                    if (!TextUtils.isEmpty(str)) {
                        if (!md4.i().n(mq2Var.I(), mq2Var.x1(), str)) {
                            return true;
                        }
                        return !new File(lo2.e.i(mq2Var.I(), mq2Var.x1()), str).exists();
                    }
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }
}
