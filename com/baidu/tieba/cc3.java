package com.baidu.tieba;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.cores.SwanAppCores;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.bn4;
import com.baidu.tieba.gc3;
import com.baidu.tieba.pb2;
import com.baidu.tieba.zw2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes5.dex */
public class cc3 extends kc3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean v;
    public transient /* synthetic */ FieldHolder $fh;
    public final String b;
    public final boolean c;
    public SwanAppConfigData d;
    public lc3 e;
    public lj3 f;
    public fk3 g;
    public lg3 h;
    public ps1 i;
    public n33 j;
    public HttpManager k;
    public sc3 l;
    public ez2 m;
    public o33 n;
    public ec3 o;
    public Map<String, String> p;
    public final ic3 q;
    public final zw2.a r;
    public boolean s;
    public String t;
    public boolean u;

    @Override // com.baidu.tieba.kc3, com.baidu.tieba.fc3
    public cc3 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this : (cc3) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947669910, "Lcom/baidu/tieba/cc3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947669910, "Lcom/baidu/tieba/cc3;");
                return;
            }
        }
        v = ms1.a;
    }

    @Deprecated
    public static cc3 M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b0();
        }
        return (cc3) invokeV.objValue;
    }

    public static cc3 b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            bc3 K = bc3.K();
            if (K.E()) {
                return K.q();
            }
            return null;
        }
        return (cc3) invokeV.objValue;
    }

    @Deprecated
    public static String g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return bc3.K().getAppId();
        }
        return (String) invokeV.objValue;
    }

    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.q.u0();
        }
    }

    @Override // com.baidu.tieba.kc3, com.baidu.tieba.fc3
    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public int E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.q.w0();
        }
        return invokeV.intValue;
    }

    public boolean F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.q.B0();
        }
        return invokeV.booleanValue;
    }

    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.c && this.q.m0() && k() > -1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.s;
        }
        return invokeV.booleanValue;
    }

    public ps1 N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.i == null) {
                this.i = new ps1(this);
            }
            return this.i;
        }
        return (ps1) invokeV.objValue;
    }

    public String O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return W().I();
        }
        return (String) invokeV.objValue;
    }

    public ez2 P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.m == null) {
                this.m = new ez2(this);
            }
            return this.m;
        }
        return (ez2) invokeV.objValue;
    }

    public SwanAppConfigData Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.d;
        }
        return (SwanAppConfigData) invokeV.objValue;
    }

    public final Bundle S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("mAppId", this.b);
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    public lc3 T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.e;
        }
        return (lc3) invokeV.objValue;
    }

    @NonNull
    public ec3 U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (this.o == null) {
                this.o = new ec3(this);
            }
            return this.o;
        }
        return (ec3) invokeV.objValue;
    }

    public String V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            zw2.a W = W();
            if (W != null) {
                return L(W.getType());
            }
            return "0";
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public zw2.a W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.r;
        }
        return (zw2.a) invokeV.objValue;
    }

    @NonNull
    @Deprecated
    public zw2.a Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return W();
        }
        return (zw2.a) invokeV.objValue;
    }

    public String Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return W().K();
        }
        return (String) invokeV.objValue;
    }

    public synchronized n33 a0() {
        InterceptResult invokeV;
        n33 n33Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            synchronized (this) {
                if (this.j == null) {
                    this.j = new n33(this);
                }
                n33Var = this.j;
            }
            return n33Var;
        }
        return (n33) invokeV.objValue;
    }

    @NonNull
    public lg3 e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            if (this.h == null) {
                this.h = new lg3(this);
            }
            return this.h;
        }
        return (lg3) invokeV.objValue;
    }

    public lj3 f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (this.f == null) {
                this.f = new lj3(this);
            }
            return this.f;
        }
        return (lj3) invokeV.objValue;
    }

    @Deprecated
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return w();
        }
        return (Activity) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kc3, com.baidu.tieba.fc3
    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public fk3 h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (this.g == null) {
                if (w0()) {
                    this.g = new ko2();
                } else {
                    this.g = new hk3();
                }
            }
            return this.g;
        }
        return (fk3) invokeV.objValue;
    }

    public synchronized HttpManager i0() {
        InterceptResult invokeV;
        HttpManager httpManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            synchronized (this) {
                if (this.k == null) {
                    this.k = kv2.l().a();
                }
                httpManager = this.k;
            }
            return httpManager;
        }
        return (HttpManager) invokeV.objValue;
    }

    public String j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.t;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kc3, com.baidu.tieba.fc3
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (this.c) {
                return W().G();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public String k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return W().v1();
        }
        return (String) invokeV.objValue;
    }

    public sc3 l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (this.l == null) {
                this.l = new sc3();
            }
            return this.l;
        }
        return (sc3) invokeV.objValue;
    }

    @Override // com.baidu.tieba.kc3, com.baidu.tieba.fc3
    public SwanAppCores m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            SwanAppCores swanAppCores = new SwanAppCores();
            swanAppCores.setSwanCoreVersion(W().j0());
            swanAppCores.setExtensionCore(W().O());
            return swanAppCores;
        }
        return (SwanAppCores) invokeV.objValue;
    }

    public o33 m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            if (this.n == null) {
                this.n = new o33();
            }
            return this.n;
        }
        return (o33) invokeV.objValue;
    }

    public boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return q0(px2.T().S());
        }
        return invokeV.booleanValue;
    }

    public boolean p0() {
        InterceptResult invokeV;
        bp2 R;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            SwanAppActivity w = w();
            if (w == null || (R = w.R()) == null) {
                return false;
            }
            return R.a0().hasCreated();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.kc3, com.baidu.tieba.fc3
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            e0().l();
            f0().d(true);
        }
    }

    public boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.q.l0();
        }
        return invokeV.booleanValue;
    }

    public boolean w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            if (W().G() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return TextUtils.equals("update_tag_by_app_launch", this.t);
        }
        return invokeV.booleanValue;
    }

    public boolean y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return this.u;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cc3(fc3 fc3Var, String str) {
        super(fc3Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fc3Var, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((fc3) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.q = new ic3(this);
        this.r = new zw2.a();
        boolean z = false;
        this.s = false;
        this.u = false;
        str = str == null ? "" : str;
        this.b = str;
        z = (!TextUtils.isEmpty(str) || TextUtils.equals(this.b, "swan_id_unknown")) ? true : true;
        this.c = z;
        if (z) {
            sc3 sc3Var = new sc3();
            this.l = sc3Var;
            sc3Var.f(this.b);
        }
        c92.k("SwanApp", "new SwanApp id = " + this.b + StringUtil.ARRAY_ELEMENT_SEPARATOR + Log.getStackTraceString(new RuntimeException("SwanApp log")));
    }

    @Override // com.baidu.tieba.kc3, com.baidu.tieba.fc3
    public void A(gc3.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.A((gc3.a) aVar.update(S()));
        }
    }

    public void B0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity) == null) {
            e0().w(activity);
        }
    }

    public void G0(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, swanAppConfigData) == null) {
            this.d = swanAppConfigData;
        }
    }

    public void H0(lc3 lc3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, lc3Var) == null) {
            this.e = lc3Var;
        }
    }

    public void I0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.t = str;
            c92.k("SwanApp", "SwanAppActivity setUpdateTag:" + this.t);
        }
    }

    public cc3 J(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
            this.s = z;
            p("event_first_action_launched");
            return this;
        }
        return (cc3) invokeZ.objValue;
    }

    public void J0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.u = z;
        }
    }

    public zw2 K0(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, bundle)) == null) {
            zw2.a W = W();
            W.update(bundle);
            return W;
        }
        return (zw2) invokeL.objValue;
    }

    public void M0(Set<bn4.a> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, set) == null) {
            this.q.J0(set);
        }
    }

    public void N0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, pMSAppInfo) != null) || pMSAppInfo == null) {
            return;
        }
        this.q.M0(pMSAppInfo);
    }

    public String R(String str) {
        InterceptResult invokeL;
        SwanAppConfigData.m mVar;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            SwanAppConfigData swanAppConfigData = this.d;
            if (swanAppConfigData != null && (mVar = swanAppConfigData.d) != null && (map = mVar.a) != null) {
                return map.get(str);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public String X(String str) {
        InterceptResult invokeL;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (map = this.p) == null) {
                return null;
            }
            return map.get(str);
        }
        return (String) invokeL.objValue;
    }

    public String d0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, str)) == null) {
            SwanAppConfigData swanAppConfigData = this.d;
            if (swanAppConfigData != null) {
                return swanAppConfigData.h(str);
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.kc3, com.baidu.tieba.fc3
    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, str) == null) {
            v(str, S());
        }
    }

    public boolean q0(String str) {
        InterceptResult invokeL;
        SwanAppConfigData swanAppConfigData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && (swanAppConfigData = this.d) != null) {
                return swanAppConfigData.o(str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean r0(String str) {
        InterceptResult invokeL;
        SwanAppConfigData swanAppConfigData;
        SwanAppConfigData.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && (swanAppConfigData = this.d) != null && (eVar = swanAppConfigData.b) != null) {
                return eVar.c(str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean u0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, str)) == null) {
            return new File(px2.T().z(), str).exists();
        }
        return invokeL.booleanValue;
    }

    public boolean v0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return zj4.i().n(this.b, k0(), str);
        }
        return invokeL.booleanValue;
    }

    public String C0(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, strArr)) == null) {
            if (v) {
                Log.d("SwanApp", "——> release client Id " + this.b);
            }
            SwanAppActivity w = w();
            if (w != null && !w.isDestroyed() && !w.isFinishing() && w.a0()) {
                w.y0(strArr);
            }
            px2.a0();
            ec3 ec3Var = this.o;
            if (ec3Var != null) {
                ec3Var.g();
            }
            gs4.k(kj3.x(this.b));
            ez2 ez2Var = this.m;
            if (ez2Var != null) {
                ez2Var.E();
            }
            sc3 sc3Var = this.l;
            if (sc3Var != null) {
                sc3Var.g();
            }
            o33 o33Var = this.n;
            if (o33Var != null) {
                o33Var.d();
            }
            this.f = null;
            this.h = null;
            this.k = null;
            this.s = false;
            return this.b;
        }
        return (String) invokeL.objValue;
    }

    public boolean D0(Bundle bundle, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048580, this, bundle, str, z)) == null) {
            boolean contains = fc3.p0.contains(str);
            zw2.a W = W();
            HybridUbcFlow p = h53.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("swan_app_update_info_start");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (TextUtils.equals("update_tag_by_activity_on_new_intent", str) && this.q.m0() && p0()) {
                if (W.b("swanCoreVersion")) {
                    bundle.remove("swanCoreVersion");
                    bundle.remove("extensionCore");
                }
                if (W.b("pms_db_info_onload")) {
                    bundle.remove("pms_db_info_onload");
                }
            }
            bundle.putBoolean("launch_by_reload", TextUtils.equals("update_tag_by_activity_on_relaunch", str));
            W.update(bundle);
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("swan_app_update_info_end");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
            if (z) {
                p("event_on_app_occupied");
            }
            if (this.c && !this.q.m0() && !this.q.l0()) {
                UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("swan_app_maintain_start");
                ubcFlowEvent3.a(true);
                p.F(ubcFlowEvent3);
                this.q.q0();
                UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("swan_app_maintain_return");
                ubcFlowEvent4.a(true);
                p.F(ubcFlowEvent4);
                return true;
            }
            if (this.q.m0() && contains) {
                ic3.o0(W, W.f0(), false, false);
            }
            return this.q.l0();
        }
        return invokeLLZ.booleanValue;
    }

    public final String L(int i) {
        InterceptResult invokeI;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            if (i == 0) {
                zw2.a aVar = this.r;
                if (aVar != null) {
                    str = aVar.w1();
                } else {
                    str = "";
                }
                if (TextUtils.isEmpty(str)) {
                    str = k0();
                }
                String f = wp3.f(str);
                Object[] objArr = new Object[1];
                if (TextUtils.isEmpty(f)) {
                    str2 = " version is empty ";
                } else {
                    str2 = f;
                }
                objArr[0] = str2;
                c92.b("SwanApp", objArr);
                return f;
            }
            return "0";
        }
        return (String) invokeI.objValue;
    }

    public boolean t0(String str) {
        InterceptResult invokeL;
        SwanAppConfigData swanAppConfigData;
        SwanAppConfigData.l lVar;
        Map<String, Boolean> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (swanAppConfigData = this.d) == null || (lVar = swanAppConfigData.c) == null || (map = lVar.b) == null || !map.containsKey(str)) {
                return false;
            }
            if (v) {
                Log.i("SwanApp", "内存中查询分包是否存在信息");
            }
            return this.d.c.b.get(str).booleanValue();
        }
        return invokeL.booleanValue;
    }

    public void L0(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.p == null) {
                this.p = new HashMap();
            }
            if (v) {
                Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
            }
            this.p.put(str2, str);
        }
    }

    public void O0(String str, boolean z) {
        SwanAppConfigData swanAppConfigData;
        SwanAppConfigData.l lVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048598, this, str, z) == null) && !TextUtils.isEmpty(str) && (swanAppConfigData = this.d) != null && (lVar = swanAppConfigData.c) != null && lVar.b != null) {
            if (v) {
                Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
            }
            this.d.c.b.put(str, Boolean.valueOf(z));
        }
    }

    public String c0(String str) {
        InterceptResult invokeL;
        SwanAppConfigData.l lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
            SwanAppConfigData swanAppConfigData = this.d;
            if (swanAppConfigData != null && (lVar = swanAppConfigData.c) != null && lVar.c != null) {
                return this.d.c.c.get(uf3.b(str));
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public boolean n0() {
        InterceptResult invokeV;
        bp2 R;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            if (!cg2.h()) {
                return false;
            }
            SwanAppActivity w = w();
            if (w == null || w.isFinishing() || w.isDestroyed() || (R = w.R()) == null) {
                return true;
            }
            return !R.a0().hasStarted();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.kc3, com.baidu.tieba.fc3
    public void v(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048636, this, str, bundle) == null) {
            if (bundle == null) {
                bundle = S();
            } else {
                bundle.putAll(S());
            }
            super.v(str, bundle);
        }
    }

    public boolean z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            if (pb2.b.a()) {
                return true;
            }
            zw2.a W = W();
            if (W == null) {
                c92.i("SwanApp", "isWebPermit: swan app info is null.");
                return false;
            }
            PMSAppInfo f0 = W.f0();
            if (f0 == null) {
                c92.i("SwanApp", "isWebPermit: pms info is null.");
                return false;
            } else if (TextUtils.isEmpty(f0.webUrl)) {
                c92.i("SwanApp", "isWebPermit: web url is null.");
                return false;
            } else {
                c92.i("SwanApp", "isWebPermit: web permit :" + f0.webPermit);
                if (f0.webPermit == 1) {
                    return true;
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
