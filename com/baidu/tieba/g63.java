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
import com.baidu.tieba.dr2;
import com.baidu.tieba.fh4;
import com.baidu.tieba.k63;
import com.baidu.tieba.t52;
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
/* loaded from: classes6.dex */
public class g63 extends o63 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean v;
    public transient /* synthetic */ FieldHolder $fh;
    public final String b;
    public final boolean c;
    public SwanAppConfigData d;
    public p63 e;
    public pd3 f;
    public je3 g;
    public pa3 h;
    public um1 i;
    public rx2 j;
    public HttpManager k;
    public w63 l;
    public it2 m;
    public sx2 n;
    public i63 o;
    public Map<String, String> p;
    public final m63 q;
    public final dr2.a r;
    public boolean s;
    public String t;
    public boolean u;

    @Override // com.baidu.tieba.o63, com.baidu.tieba.j63
    public g63 q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this : (g63) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947745829, "Lcom/baidu/tieba/g63;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947745829, "Lcom/baidu/tieba/g63;");
                return;
            }
        }
        v = rm1.a;
    }

    @Deprecated
    public static g63 M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return c0();
        }
        return (g63) invokeV.objValue;
    }

    public static g63 c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            f63 K = f63.K();
            if (K.E()) {
                return K.q();
            }
            return null;
        }
        return (g63) invokeV.objValue;
    }

    @Deprecated
    public static String h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return f63.K().getAppId();
        }
        return (String) invokeV.objValue;
    }

    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.q.v0();
        }
    }

    @Override // com.baidu.tieba.o63, com.baidu.tieba.j63
    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public int F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.q.x0();
        }
        return invokeV.intValue;
    }

    public boolean G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.q.C0();
        }
        return invokeV.booleanValue;
    }

    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.c && this.q.n0() && k() > -1) {
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

    public um1 N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (this.i == null) {
                this.i = new um1(this);
            }
            return this.i;
        }
        return (um1) invokeV.objValue;
    }

    @Deprecated
    public Activity O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return w();
        }
        return (Activity) invokeV.objValue;
    }

    public String P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return X().J();
        }
        return (String) invokeV.objValue;
    }

    public it2 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (this.m == null) {
                this.m = new it2(this);
            }
            return this.m;
        }
        return (it2) invokeV.objValue;
    }

    public SwanAppConfigData R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.d;
        }
        return (SwanAppConfigData) invokeV.objValue;
    }

    public final Bundle T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            Bundle bundle = new Bundle();
            bundle.putString("mAppId", this.b);
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    public p63 U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.e;
        }
        return (p63) invokeV.objValue;
    }

    @NonNull
    public i63 V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (this.o == null) {
                this.o = new i63(this);
            }
            return this.o;
        }
        return (i63) invokeV.objValue;
    }

    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            dr2.a X = X();
            if (X != null) {
                return L(X.w1());
            }
            return "0";
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public dr2.a X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.r;
        }
        return (dr2.a) invokeV.objValue;
    }

    @NonNull
    @Deprecated
    public dr2.a Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return X();
        }
        return (dr2.a) invokeV.objValue;
    }

    public String a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return X().L();
        }
        return (String) invokeV.objValue;
    }

    public synchronized rx2 b0() {
        InterceptResult invokeV;
        rx2 rx2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            synchronized (this) {
                if (this.j == null) {
                    this.j = new rx2(this);
                }
                rx2Var = this.j;
            }
            return rx2Var;
        }
        return (rx2) invokeV.objValue;
    }

    @NonNull
    public pa3 f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            if (this.h == null) {
                this.h = new pa3(this);
            }
            return this.h;
        }
        return (pa3) invokeV.objValue;
    }

    public pd3 g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            if (this.f == null) {
                this.f = new pd3(this);
            }
            return this.f;
        }
        return (pd3) invokeV.objValue;
    }

    @Override // com.baidu.tieba.o63, com.baidu.tieba.j63
    public String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public je3 i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (this.g == null) {
                if (x0()) {
                    this.g = new oi2();
                } else {
                    this.g = new le3();
                }
            }
            return this.g;
        }
        return (je3) invokeV.objValue;
    }

    public synchronized HttpManager j0() {
        InterceptResult invokeV;
        HttpManager httpManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            synchronized (this) {
                if (this.k == null) {
                    this.k = op2.l().b();
                }
                httpManager = this.k;
            }
            return httpManager;
        }
        return (HttpManager) invokeV.objValue;
    }

    @Override // com.baidu.tieba.o63, com.baidu.tieba.j63
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (this.c) {
                return X().H();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public String k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.t;
        }
        return (String) invokeV.objValue;
    }

    public String l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return X().x1();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.o63, com.baidu.tieba.j63
    public SwanAppCores m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            SwanAppCores swanAppCores = new SwanAppCores();
            swanAppCores.setSwanCoreVersion(X().k0());
            swanAppCores.setExtensionCore(X().P());
            return swanAppCores;
        }
        return (SwanAppCores) invokeV.objValue;
    }

    public w63 m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            if (this.l == null) {
                this.l = new w63();
            }
            return this.l;
        }
        return (w63) invokeV.objValue;
    }

    public sx2 n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            if (this.n == null) {
                this.n = new sx2();
            }
            return this.n;
        }
        return (sx2) invokeV.objValue;
    }

    public boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return r0(tr2.V().U());
        }
        return invokeV.booleanValue;
    }

    public boolean q0() {
        InterceptResult invokeV;
        fj2 R;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            SwanAppActivity w = w();
            if (w == null || (R = w.R()) == null) {
                return false;
            }
            return R.a0().hasCreated();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.o63, com.baidu.tieba.j63
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            f0().l();
            g0().d(true);
        }
    }

    public boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.q.m0();
        }
        return invokeV.booleanValue;
    }

    public boolean x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            if (X().H() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return TextUtils.equals("update_tag_by_app_launch", this.t);
        }
        return invokeV.booleanValue;
    }

    public boolean z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.u;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g63(j63 j63Var, String str) {
        super(j63Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j63Var, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((j63) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.q = new m63(this);
        this.r = new dr2.a();
        boolean z = false;
        this.s = false;
        this.u = false;
        str = str == null ? "" : str;
        this.b = str;
        z = (!TextUtils.isEmpty(str) || TextUtils.equals(this.b, "swan_id_unknown")) ? true : true;
        this.c = z;
        if (z) {
            w63 w63Var = new w63();
            this.l = w63Var;
            w63Var.f(this.b);
        }
        g32.k("SwanApp", "new SwanApp id = " + this.b + StringUtil.ARRAY_ELEMENT_SEPARATOR + Log.getStackTraceString(new RuntimeException("SwanApp log")));
    }

    @Override // com.baidu.tieba.o63, com.baidu.tieba.j63
    public void A(k63.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            super.A((k63.a) aVar.E(T()));
        }
    }

    public void C0(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
            f0().w(activity);
        }
    }

    public void H0(SwanAppConfigData swanAppConfigData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, swanAppConfigData) == null) {
            this.d = swanAppConfigData;
        }
    }

    public void I0(p63 p63Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, p63Var) == null) {
            this.e = p63Var;
        }
    }

    public g63 J(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048588, this, z)) == null) {
            this.s = z;
            p("event_first_action_launched");
            return this;
        }
        return (g63) invokeZ.objValue;
    }

    public void J0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.t = str;
            g32.k("SwanApp", "SwanAppActivity setUpdateTag:" + this.t);
        }
    }

    public void K0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.u = z;
        }
    }

    public dr2 L0(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, bundle)) == null) {
            dr2.a X = X();
            X.E(bundle);
            return X;
        }
        return (dr2) invokeL.objValue;
    }

    public void N0(Set<fh4.a> set) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, set) == null) {
            this.q.K0(set);
        }
    }

    public void O0(PMSAppInfo pMSAppInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048598, this, pMSAppInfo) != null) || pMSAppInfo == null) {
            return;
        }
        this.q.N0(pMSAppInfo);
    }

    public String S(String str) {
        InterceptResult invokeL;
        SwanAppConfigData.m mVar;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            SwanAppConfigData swanAppConfigData = this.d;
            if (swanAppConfigData != null && (mVar = swanAppConfigData.d) != null && (map = mVar.a) != null) {
                return map.get(str);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public String Y(String str) {
        InterceptResult invokeL;
        Map<String, String> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (map = this.p) == null) {
                return null;
            }
            return map.get(str);
        }
        return (String) invokeL.objValue;
    }

    public String e0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, str)) == null) {
            SwanAppConfigData swanAppConfigData = this.d;
            if (swanAppConfigData != null) {
                return swanAppConfigData.h(str);
            }
            return "";
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.o63, com.baidu.tieba.j63
    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, str) == null) {
            v(str, T());
        }
    }

    public boolean r0(String str) {
        InterceptResult invokeL;
        SwanAppConfigData swanAppConfigData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && (swanAppConfigData = this.d) != null) {
                return swanAppConfigData.o(str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean s0(String str) {
        InterceptResult invokeL;
        SwanAppConfigData swanAppConfigData;
        SwanAppConfigData.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, str)) == null) {
            if (!TextUtils.isEmpty(str) && (swanAppConfigData = this.d) != null && (eVar = swanAppConfigData.b) != null) {
                return eVar.c(str);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean v0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, str)) == null) {
            return new File(tr2.V().A(), str).exists();
        }
        return invokeL.booleanValue;
    }

    public boolean w0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return de4.i().n(this.b, l0(), str);
        }
        return invokeL.booleanValue;
    }

    public boolean A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (t52.b.a()) {
                return true;
            }
            dr2.a X = X();
            if (X == null) {
                g32.i("SwanApp", "isWebPermit: swan app info is null.");
                return false;
            }
            PMSAppInfo g0 = X.g0();
            if (g0 == null) {
                g32.i("SwanApp", "isWebPermit: pms info is null.");
                return false;
            } else if (TextUtils.isEmpty(g0.webUrl)) {
                g32.i("SwanApp", "isWebPermit: web url is null.");
                return false;
            } else {
                g32.i("SwanApp", "isWebPermit: web permit :" + g0.webPermit);
                if (g0.webPermit == 1) {
                    return true;
                }
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public String D0(String... strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, strArr)) == null) {
            if (v) {
                Log.d("SwanApp", "——> release client Id " + this.b);
            }
            SwanAppActivity w = w();
            if (w != null && !w.isDestroyed() && !w.isFinishing() && w.a0()) {
                w.y0(strArr);
            }
            tr2.c0();
            i63 i63Var = this.o;
            if (i63Var != null) {
                i63Var.g();
            }
            jm4.k(od3.x(this.b));
            it2 it2Var = this.m;
            if (it2Var != null) {
                it2Var.E();
            }
            w63 w63Var = this.l;
            if (w63Var != null) {
                w63Var.g();
            }
            sx2 sx2Var = this.n;
            if (sx2Var != null) {
                sx2Var.d();
            }
            this.f = null;
            this.h = null;
            this.k = null;
            this.s = false;
            return this.b;
        }
        return (String) invokeL.objValue;
    }

    public boolean E0(Bundle bundle, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048582, this, bundle, str, z)) == null) {
            boolean contains = j63.p0.contains(str);
            dr2.a X = X();
            HybridUbcFlow p = lz2.p("startup");
            UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("swan_app_update_info_start");
            ubcFlowEvent.a(true);
            p.F(ubcFlowEvent);
            if (TextUtils.equals("update_tag_by_activity_on_new_intent", str) && this.q.n0() && q0()) {
                if (X.b("swanCoreVersion")) {
                    bundle.remove("swanCoreVersion");
                    bundle.remove("extensionCore");
                }
                if (X.b("pms_db_info_onload")) {
                    bundle.remove("pms_db_info_onload");
                }
            }
            bundle.putBoolean("launch_by_reload", TextUtils.equals("update_tag_by_activity_on_relaunch", str));
            X.E(bundle);
            UbcFlowEvent ubcFlowEvent2 = new UbcFlowEvent("swan_app_update_info_end");
            ubcFlowEvent2.a(true);
            p.F(ubcFlowEvent2);
            if (z) {
                p("event_on_app_occupied");
            }
            if (this.c && !this.q.n0() && !this.q.m0()) {
                UbcFlowEvent ubcFlowEvent3 = new UbcFlowEvent("swan_app_maintain_start");
                ubcFlowEvent3.a(true);
                p.F(ubcFlowEvent3);
                this.q.r0();
                UbcFlowEvent ubcFlowEvent4 = new UbcFlowEvent("swan_app_maintain_return");
                ubcFlowEvent4.a(true);
                p.F(ubcFlowEvent4);
                return true;
            }
            if (this.q.n0() && contains) {
                m63.p0(X, X.g0(), false, false);
            }
            return this.q.m0();
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
                dr2.a aVar = this.r;
                if (aVar != null) {
                    str = aVar.y1();
                } else {
                    str = "";
                }
                if (TextUtils.isEmpty(str)) {
                    str = l0();
                }
                String f = ak3.f(str);
                Object[] objArr = new Object[1];
                if (TextUtils.isEmpty(f)) {
                    str2 = " version is empty ";
                } else {
                    str2 = f;
                }
                objArr[0] = str2;
                g32.b("SwanApp", objArr);
                return f;
            }
            return "0";
        }
        return (String) invokeI.objValue;
    }

    public boolean u0(String str) {
        InterceptResult invokeL;
        SwanAppConfigData swanAppConfigData;
        SwanAppConfigData.l lVar;
        Map<String, Boolean> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, str)) == null) {
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

    public void M0(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048594, this, str, str2) == null) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (this.p == null) {
                this.p = new HashMap();
            }
            if (v) {
                Log.d("SwanApp", "update initData, page: " + str2 + " initDta : " + str);
            }
            this.p.put(str2, str);
        }
    }

    public void P0(String str, boolean z) {
        SwanAppConfigData swanAppConfigData;
        SwanAppConfigData.l lVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048600, this, str, z) == null) && !TextUtils.isEmpty(str) && (swanAppConfigData = this.d) != null && (lVar = swanAppConfigData.c) != null && lVar.b != null) {
            if (v) {
                Log.i("SwanApp", "更新内存缓存信息: " + str + ": " + z);
            }
            this.d.c.b.put(str, Boolean.valueOf(z));
        }
    }

    public String d0(String str) {
        InterceptResult invokeL;
        SwanAppConfigData.l lVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, str)) == null) {
            SwanAppConfigData swanAppConfigData = this.d;
            if (swanAppConfigData != null && (lVar = swanAppConfigData.c) != null && lVar.c != null) {
                return this.d.c.c.get(y93.b(str));
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public boolean o0() {
        InterceptResult invokeV;
        fj2 R;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            if (!ga2.h()) {
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

    @Override // com.baidu.tieba.o63, com.baidu.tieba.j63
    public void v(String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048636, this, str, bundle) == null) {
            if (bundle == null) {
                bundle = T();
            } else {
                bundle.putAll(T());
            }
            super.v(str, bundle);
        }
    }
}
