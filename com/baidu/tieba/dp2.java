package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.swan.pms.node.Node;
import com.baidu.tieba.qg4;
import com.baidu.tieba.se4;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes5.dex */
public class dp2 implements yc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Set a;
        public final /* synthetic */ sh4 b;

        /* renamed from: com.baidu.tieba.dp2$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C0256a extends j82 {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ AtomicInteger a;
            public final /* synthetic */ a b;

            public C0256a(a aVar, AtomicInteger atomicInteger) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, atomicInteger};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = aVar;
                this.a = atomicInteger;
            }

            @Override // com.baidu.tieba.j82
            public void d() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.get() == 0) {
                    th4.a().c(this.b.b);
                }
            }

            @Override // com.baidu.tieba.j82
            public void h() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a.get() == 0) {
                    th4.a().c(this.b.b);
                }
            }

            @Override // com.baidu.tieba.j82
            public void f(je4 je4Var) {
                int i;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, je4Var) == null) {
                    super.f(je4Var);
                    if (je4Var != null && (i = je4Var.a) != 1010 && i != 1015) {
                        this.a.incrementAndGet();
                    }
                }
            }
        }

        public a(dp2 dp2Var, Set set, sh4 sh4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dp2Var, set, sh4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = set;
            this.b = sh4Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ArrayList arrayList = new ArrayList();
                AtomicInteger atomicInteger = new AtomicInteger(0);
                for (String str : this.a) {
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(new qg4.a(str, 0));
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                f42.b(arrayList, "3", new C0256a(this, atomicInteger));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xd3 a;
        public final /* synthetic */ JSONObject b;

        public b(dp2 dp2Var, xd3 xd3Var, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dp2Var, xd3Var, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xd3Var;
            this.b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                lx2.g().q(this.a, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements b72<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qe4 a;

        public c(dp2 dp2Var, qe4 qe4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dp2Var, qe4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qe4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.b72
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
                h13.b("download plugin result = " + bool);
                i13.b(this.a.g);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947712163, "Lcom/baidu/tieba/dp2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947712163, "Lcom/baidu/tieba/dp2;");
                return;
            }
        }
        boolean z = am1.a;
    }

    public dp2() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.yc4
    public zf4 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return wo2.r0();
        }
        return (zf4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yc4
    public int B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return o13.t();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.yc4
    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            oj3.k().m();
        }
    }

    @Override // com.baidu.tieba.yc4
    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return wo2.o().q();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yc4
    public String I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return l22.m();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yc4
    public ye4 M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return o53.K().N();
        }
        return (ye4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yc4
    public float a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return wo2.m().a();
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.tieba.yc4
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return bm1.a();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yc4
    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return wo2.n().a();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yc4
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return am4.b(AppRuntime.getAppContext()).a();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yc4
    public CookieManager f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return wo2.q().a();
        }
        return (CookieManager) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yc4
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return wo2.h0().i(AppRuntime.getAppContext());
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yc4
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return jj3.D();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yc4
    public ql4 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return de3.b("swan_app_pms_sp");
        }
        return (ql4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yc4
    public ye4 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return new b92(o53.K());
        }
        return (ye4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yc4
    public String q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return wo2.g0().k();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yc4
    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return pz2.b();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.yc4
    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            h13.c("线下调试需要禁用BDTLS");
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.yc4
    public void D(eh4 eh4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, eh4Var) != null) || eh4Var == null) {
            return;
        }
        try {
            JSONObject b2 = eh4Var.b();
            JSONArray a2 = eh4Var.a();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("threshold", b2.optInt("threshold"));
            jSONObject.put("timeup", b2.optInt("timeup"));
            jSONObject.put("item", a2.toString());
            if (p53.v) {
                Log.d(Node.TAG, "ceres adapted config " + jSONObject);
            }
            gl4 gl4Var = new gl4("0", jSONObject);
            gl4Var.e();
            dl4.f().o(gl4Var);
        } catch (JSONException e) {
            if (p53.v) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.baidu.tieba.yc4
    public int F(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, str, i)) == null) {
            wo2.g0().getSwitch(str, i);
            return i;
        }
        return invokeLI.intValue;
    }

    @Override // com.baidu.tieba.yc4
    public List<ie4> l(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048600, this, str, j)) == null) {
            return w03.e(str, j);
        }
        return (List) invokeLJ.objValue;
    }

    @Override // com.baidu.tieba.yc4
    public boolean o(boolean z, @NonNull JSONArray jSONArray) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048603, this, z, jSONArray)) == null) {
            return new ak3(z).c(jSONArray);
        }
        return invokeZL.booleanValue;
    }

    @Override // com.baidu.tieba.yc4
    public void y(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, str, str2) == null) {
            p22.k(str, str2);
        }
    }

    @Override // com.baidu.tieba.yc4
    public void G(String str, String str2, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, str, str2, th) == null) {
            p22.l(str, str2, th);
        }
    }

    @Override // com.baidu.tieba.yc4
    public void k(JSONArray jSONArray, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048599, this, jSONArray, str, str2) == null) {
            c83.b().n(jSONArray, str, str2);
        }
    }

    @Override // com.baidu.tieba.yc4
    public void m(String str, String str2, se4.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048601, this, str, str2, cVar) == null) {
            wo2.e().f(str, str2, cVar);
        }
    }

    @Override // com.baidu.tieba.yc4
    public void H(sh4 sh4Var) {
        Set<String> b2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, sh4Var) == null) && sh4Var != null && (b2 = sh4Var.b()) != null && b2.size() > 0) {
            ExecutorUtilsExt.postOnElastic(new a(this, b2, sh4Var), "preloadPkg", 2);
        }
    }

    @Override // com.baidu.tieba.yc4
    public String J(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            return ue3.h(i);
        }
        return (String) invokeI.objValue;
    }

    @Override // com.baidu.tieba.yc4
    public void d(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bArr) == null) {
            wo2.e().d(bArr);
        }
    }

    @Override // com.baidu.tieba.yc4
    public long j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
            return yf2.d(i);
        }
        return invokeI.longValue;
    }

    @Override // com.baidu.tieba.yc4
    public boolean r(@Nullable qe4 qe4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, qe4Var)) == null) {
            File g = w03.g(qe4Var);
            if (g != null && g.exists()) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.yc4
    public String v(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048610, this, i)) == null) {
            return yf2.e(i);
        }
        return (String) invokeI.objValue;
    }

    @Override // com.baidu.tieba.yc4
    public long w(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i)) == null) {
            return ue3.f(i);
        }
        return invokeI.longValue;
    }

    @Override // com.baidu.tieba.yc4
    public void K(String str, String str2, String str3, int i, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{str, str2, str3, Integer.valueOf(i), jSONObject, Boolean.valueOf(z)}) == null) {
            uc3.d(str, str2, str3, i, jSONObject, z);
        }
    }

    @Override // com.baidu.tieba.yc4
    public void L(String str, String str2, String str3, @Nullable Throwable th, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{str, str2, str3, th, Boolean.valueOf(z)}) == null) {
            p22.e(str, str2, str3, th, z);
        }
    }

    @Override // com.baidu.tieba.yc4
    public void p(String str, JSONObject jSONObject, oe4 oe4Var, List<pe4> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048604, this, str, jSONObject, oe4Var, list) == null) {
            tv2.g(str, jSONObject, oe4Var, list);
        }
    }

    @Override // com.baidu.tieba.yc4
    public void z(String str, String str2, String str3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{str, str2, str3, Boolean.valueOf(z)}) == null) {
            p22.j(str, str2, str3, z);
        }
    }

    @Override // com.baidu.tieba.yc4
    public void s(PMSAppInfo pMSAppInfo, JSONObject jSONObject, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048607, this, pMSAppInfo, jSONObject, z) == null) {
            if (pMSAppInfo == null) {
                if (p53.v) {
                    Log.e("SwanAppUpdateManager", "pms app info is null");
                    return;
                }
                return;
            }
            String str = pMSAppInfo.appKey;
            if (!TextUtils.isEmpty(str) && jSONObject != null) {
                int i = pMSAppInfo.type;
                xd3 b2 = de3.b(xc3.u(str, i));
                b2.putBoolean("swan_service_update_degraded", z);
                p22.k("SwanAppUpdateManager", "update async appKey = " + str + " ; type = " + i + " ; serviceDegraded = " + z);
                ji3.l(new b(this, b2, jSONObject), "parseAccreditList");
            } else if (p53.v) {
                Log.e("SwanAppUpdateManager", "appKey = " + str + " is empty or accredit list is null");
            }
        }
    }

    @Override // com.baidu.tieba.yc4
    public void t(hi4 hi4Var, xi4 xi4Var) {
        Collection<qe4> collection;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048608, this, hi4Var, xi4Var) == null) && hi4Var != null && (collection = hi4Var.e) != null && xi4Var != null) {
            for (qe4 qe4Var : collection) {
                v03 v03Var = new v03(qe4Var.g, qe4Var.j, qe4Var.i, new c(this, qe4Var));
                hi4 hi4Var2 = new hi4();
                hi4Var2.e = new ArrayList();
                xi4 xi4Var2 = new xi4();
                ii4.b(qe4Var, xi4Var2);
                v03Var.G(xi4Var2);
                hi4Var2.e.clear();
                hi4Var2.e.add(qe4Var);
                af4.e(hi4Var2, v03Var);
            }
        }
    }
}
