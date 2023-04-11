package com.baidu.tieba;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.searchbox.ubcprocessor.UBCCloudControlProcessor;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.tieba.rs2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class ee3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static volatile boolean b;
    public static volatile boolean c;
    public static volatile boolean d;
    public static volatile boolean e;
    public static volatile boolean f;
    public static volatile boolean g;
    public static HashMap<String, String> h;
    public static String i;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Bundle a;

        public a(Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.remove("page_display_flag_for_statistic");
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xe3 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public b(xe3 xe3Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xe3Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xe3Var;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b(ne3.k(this.b));
                this.a.d(this.c);
                ne3.onEvent(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xe3 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public c(xe3 xe3Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xe3Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xe3Var;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.d(this.b);
                this.a.b(ne3.k(this.c));
                ne3.onEvent(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xe3 a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public d(xe3 xe3Var, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xe3Var, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xe3Var;
            this.b = str;
            this.c = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.b(ne3.k(this.b));
                this.a.d(this.c);
                ne3.onEvent(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class e implements nm3<JSONObject> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xe3 a;

        public e(xe3 xe3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xe3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xe3Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.nm3
        /* renamed from: b */
        public void a(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                this.a.a(GrowthConstant.UBC_VALUE_TYPE_DEVICE_INFO, jSONObject);
                ne3.onEvent(this.a);
                u42.k("SwanAppLaunchUbc", jSONObject.toString());
                br2.p0().flush(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947731414, "Lcom/baidu/tieba/ee3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947731414, "Lcom/baidu/tieba/ee3;");
                return;
            }
        }
        a = eo1.a;
        b = false;
        c = false;
        d = false;
        e = false;
        f = false;
        g = false;
    }

    public static synchronized boolean e() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            synchronized (ee3.class) {
                z = b;
            }
            return z;
        }
        return invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            return c;
        }
        return invokeV.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            return d;
        }
        return invokeV.booleanValue;
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65552, null)) == null) {
            return f;
        }
        return invokeV.booleanValue;
    }

    public static boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, null)) == null) {
            return e;
        }
        return invokeV.booleanValue;
    }

    public static boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            return g;
        }
        return invokeV.booleanValue;
    }

    public static void r() {
        u73 M;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65562, null) != null) || (M = u73.M()) == null) {
            return;
        }
        s(M.W());
    }

    public static void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65567, null) == null) {
            B(false);
        }
    }

    public static void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, null) == null) {
            A(false);
        }
    }

    public static void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, null) == null) {
            C(false);
        }
    }

    public static void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65570, null) == null) {
            y();
            D(false);
            x();
            w();
            E(false);
        }
    }

    public static synchronized void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65537, null, z) == null) {
            synchronized (ee3.class) {
                c = z;
            }
        }
    }

    public static synchronized void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65538, null, z) == null) {
            synchronized (ee3.class) {
                d = z;
            }
        }
    }

    public static synchronized void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65539, null, z) == null) {
            synchronized (ee3.class) {
                b = z;
            }
        }
    }

    public static void D(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z) == null) {
            f = z;
        }
    }

    public static void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65541, null, z) == null) {
            e = z;
        }
    }

    public static void o(rs2.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65559, null, aVar) == null) && aVar != null && !f) {
            D(true);
            k(aVar, "naarrsuccess");
        }
    }

    public static void q(rs2.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65561, null, aVar) == null) && aVar != null && !g()) {
            B(true);
            k(aVar, "arrivecancel");
        }
    }

    public static void t(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65564, null, str) == null) && g) {
            Log.d("SwanAppLaunchUbc", "handle record slave id case relaunch");
            hy2.e(str);
            g = false;
        }
    }

    public static void F(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65542, null, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (h == null) {
                h = new HashMap<>();
            }
            h.put(str, str2);
        }
    }

    public static void k(rs2.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65555, null, aVar, str) == null) {
            l(aVar, str, System.currentTimeMillis(), null);
        }
    }

    public static void G() {
        d72 V;
        au1 r3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65543, null) != null) || (V = ht2.U().V()) == null) {
            return;
        }
        a72 m = V.m();
        if ((m instanceof c72) && (r3 = ((c72) m).r3()) != null) {
            i = r3.a();
        }
    }

    public static void H() {
        HybridUbcFlow d2;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65544, null) != null) || (d2 = z03.d("startup")) == null) {
            return;
        }
        if (!d2.w() && !d2.t()) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            d2.E("value", "fe_success");
        }
    }

    public static void a(lu1 lu1Var) {
        u73 M;
        rs2.a W;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65545, null, lu1Var) != null) || f() || g() || lu1Var == null || (M = u73.M()) == null || (W = M.W()) == null) {
            return;
        }
        if (a) {
            Log.d("SwanAppLaunchUbc", "real start handle arrival report ");
        }
        A(true);
        B(true);
        c(W, lu1Var.b, "0", lu1Var.c, b(lu1Var.g), false);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String b(String str) {
        InterceptResult invokeL;
        char c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) {
            switch (str.hashCode()) {
                case 48:
                    if (str.equals("0")) {
                        c2 = 0;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 49:
                    if (str.equals("1")) {
                        c2 = 1;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 50:
                    if (str.equals("2")) {
                        c2 = 2;
                        break;
                    }
                    c2 = 65535;
                    break;
                case 51:
                    if (str.equals("3")) {
                        c2 = 3;
                        break;
                    }
                    c2 = 65535;
                    break;
                default:
                    c2 = 65535;
                    break;
            }
            if (c2 == 1) {
                return "2";
            }
            if (c2 == 2) {
                return "3";
            }
            if (c2 != 3) {
                return "0";
            }
            return "4";
        }
        return (String) invokeL.objValue;
    }

    public static void d(@NonNull rs2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, aVar) == null) {
            E(true);
            xe3 xe3Var = new xe3();
            xe3Var.a = ne3.n(0);
            xe3Var.b = "launch";
            xe3Var.e = "narendersuccess";
            xe3Var.h(aVar);
            n13.e().d(new d(xe3Var, aVar.W(), aVar.s0().getString(UBCCloudControlProcessor.UBC_KEY)), "handleNaRenderSuccess", true);
        }
    }

    public static void v(@NonNull rs2 rs2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65566, null, rs2Var) == null) {
            xe3 xe3Var = new xe3();
            xe3Var.a = ne3.n(0);
            xe3Var.f = rs2Var.H();
            xe3Var.c = rs2Var.T();
            xe3Var.b = "show";
            n13.e().d(new b(xe3Var, rs2Var.W(), rs2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY)), "onShow606", true);
        }
    }

    public static void c(rs2.a aVar, long j, String str, long j2, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65547, null, new Object[]{aVar, Long.valueOf(j), str, Long.valueOf(j2), str2, Boolean.valueOf(z)}) == null) && aVar != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            A(true);
            if (z || j > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("valuetype", str);
                } catch (JSONException e2) {
                    if (a) {
                        e2.printStackTrace();
                    }
                }
                l(aVar, "arrivesuccess", j, jSONObject);
            }
            if (z || j2 > 0) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("valuetype", str2);
                } catch (JSONException e3) {
                    if (a) {
                        e3.printStackTrace();
                    }
                }
                l(aVar, "fmparrsuccess", j2, jSONObject2);
            }
        }
    }

    public static void l(rs2.a aVar, String str, long j, JSONObject jSONObject) {
        String H;
        String jSONObject2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65556, null, new Object[]{aVar, str, Long.valueOf(j), jSONObject}) == null) && (H = aVar.H()) != null && aVar != null) {
            long j2 = 0;
            if (j != -1) {
                long l = aVar.l("launch_time", 0L);
                if (j <= 0) {
                    j = System.currentTimeMillis();
                }
                j2 = j - l;
            }
            xe3 xe3Var = new xe3();
            xe3Var.a = ne3.n(aVar.G());
            xe3Var.f = H;
            if (l52.d()) {
                xe3Var.c = "remote-debug";
            } else if (t33.D()) {
                xe3Var.c = "local-debug";
            } else {
                xe3Var.c = aVar.T();
            }
            xe3Var.b = "launch";
            xe3Var.e = str;
            xe3Var.a("arrivetime", String.valueOf(j2));
            if (jSONObject != null) {
                xe3Var.e(jSONObject);
            }
            Bundle P = aVar.P();
            if (P != null) {
                xe3Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
            }
            xe3Var.b(ne3.k(aVar.W()));
            if (a) {
                StringBuilder sb = new StringBuilder();
                sb.append("handle record arrival event, arrivalValue ");
                sb.append(str);
                sb.append(" arrive time : ");
                sb.append(j2);
                sb.append(" extJson :");
                if (jSONObject == null) {
                    jSONObject2 = "";
                } else {
                    jSONObject2 = jSONObject.toString();
                }
                sb.append(jSONObject2);
                Log.d("SwanAppLaunchUbc", sb.toString());
            }
            ne3.onEvent(xe3Var);
        }
    }

    public static void m(@NonNull rs2 rs2Var, int i2, @NonNull nj3 nj3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65557, null, rs2Var, i2, nj3Var) == null) {
            xe3 xe3Var = new xe3();
            xe3Var.a = ne3.n(i2);
            xe3Var.b = "launch";
            xe3Var.e = com.baidu.pass.biometrics.face.liveness.b.a.g0;
            xe3Var.a("errcode", String.valueOf(nj3Var.a()));
            xe3Var.a("msg", nj3Var.g().toString());
            xe3Var.h(rs2Var);
            xe3Var.d(rs2Var.s0().getString(UBCCloudControlProcessor.UBC_KEY));
            xe3Var.b(ne3.k(rs2Var.W()));
            kk3.d(rs2Var, new e(xe3Var));
        }
    }

    public static void n(xe3 xe3Var, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65558, null, xe3Var, str, str2) == null) {
            n13.e().d(new c(xe3Var, str2, str), "onLaunchSuccessUBC", true);
        }
    }

    public static void p(rs2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65560, null, aVar) == null) {
            if (a) {
                Log.d("SwanAppLaunchUbc", "handle relaunch arrival");
            }
            hy2.e(i);
            if (!i()) {
                d(aVar);
            }
            if (!f() && !g()) {
                c(aVar, -1L, "1", -1L, "1", true);
            }
        }
    }

    public static void s(rs2 rs2Var) {
        Bundle P;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65563, null, rs2Var) == null) && rs2Var != null && e() && (P = rs2Var.P()) != null) {
            long j = P.getLong("page_display_flag_for_statistic");
            long l = rs2Var.l("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            if (j > 0) {
                xe3 xe3Var = new xe3();
                xe3Var.a = ne3.n(rs2Var.G());
                xe3Var.f = rs2Var.H();
                xe3Var.c = rs2Var.T();
                xe3Var.b = "launch";
                xe3Var.e = "realsuccess";
                xe3Var.r = String.valueOf(currentTimeMillis - l);
                xe3Var.d(P.getString(UBCCloudControlProcessor.UBC_KEY));
                ne3.onEvent(xe3Var);
                ol3.e0(new a(P));
                H();
            }
        }
    }

    public static void u(String str, rs2.a aVar) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65565, null, str, aVar) == null) {
            HashMap<String, String> hashMap = h;
            String str3 = "";
            if (hashMap == null) {
                str2 = "";
            } else {
                str2 = hashMap.get(i);
            }
            if (a) {
                StringBuilder sb = new StringBuilder();
                sb.append("handle relaunch , launchPage : ");
                sb.append(str);
                sb.append(" lastSlavePath ：");
                if (str2 != null) {
                    str3 = str2;
                }
                sb.append(str3);
                Log.d("SwanAppLaunchUbc", sb.toString());
            }
            if (TextUtils.equals(str, str2)) {
                p(aVar);
                return;
            }
            x();
            g = true;
        }
    }
}
