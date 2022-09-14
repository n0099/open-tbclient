package com.baidu.tieba;

import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Autowired;
import com.baidu.pyramid.annotation.Inject;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.tieba.gg2;
import com.baidu.tieba.h22;
import com.baidu.tieba.tz2;
import com.baidu.tieba.ul2;
import com.baidu.tieba.vn2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONObject;
@Autowired
/* loaded from: classes3.dex */
public class ag2 extends xf2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean q;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ag2 a;

        public a(ag2 ag2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ag2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ag2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && hf3.d(this.a.b)) {
                f73.g();
                lo2.U().registerReceiver(this.a.b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(ag2 ag2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ag2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                uu2.g().y();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements k42<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ag2 a;

        public c(ag2 ag2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ag2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ag2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.k42
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) && this.a.b != null && bool.booleanValue()) {
                this.a.b.onBackPressed();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements gg2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ag2 a;

        public d(ag2 ag2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ag2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ag2Var;
        }

        @Override // com.baidu.tieba.gg2.b
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.moveTaskToBack(true);
            ah3.b().e(1);
        }
    }

    /* loaded from: classes3.dex */
    public class e implements tz2.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ag2 a;

        public e(ag2 ag2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ag2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ag2Var;
        }

        @Override // com.baidu.tieba.tz2.c
        public boolean a(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i = message.what;
                if (i == 100) {
                    oz2.e().h(new qz2(4));
                    this.a.Q0();
                    this.a.l1();
                    x23.K().s();
                    return true;
                } else if (i == 127) {
                    int d = us2.d();
                    int a = us2.a(d);
                    if (!us2.f()) {
                        ts2.a(Integer.valueOf(d), String.valueOf(a));
                    }
                    return true;
                } else if (i == 129) {
                    int p = ef3.m().p();
                    yz1.i("SwanAppFrame", "resetCore: client receive msg topTaskId = " + p);
                    if (this.a.b != null && this.a.b.e0() && p != -1 && this.a.b.getTaskId() != p) {
                        yz1.i("SwanAppFrame", "resetCore: purgeSwanApp");
                        x23.K().s();
                    }
                    return true;
                } else if (i == 102) {
                    boolean a2 = fm2.M().a();
                    fm2.M().d(a2);
                    if (this.a.b != null) {
                        this.a.b.x(a2, false);
                    }
                    return true;
                } else if (i == 103) {
                    y23 M = y23.M();
                    if (M != null) {
                        M.e0().i();
                        uu2.g().v();
                    }
                    this.a.Q0();
                    this.a.k1();
                    return true;
                } else if (i == 106) {
                    x23.K().s();
                    return true;
                } else if (i != 107) {
                    switch (i) {
                        case 123:
                            ef3.r(message);
                            return true;
                        case 124:
                            ef3.q(message);
                            return true;
                        case 125:
                            rz2.b(message);
                            return true;
                        default:
                            return false;
                    }
                } else {
                    a62.a(message);
                    return true;
                }
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ub3.u(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947614141, "Lcom/baidu/tieba/ag2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947614141, "Lcom/baidu/tieba/ag2;");
                return;
            }
        }
        q = ij1.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag2(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {swanAppActivity, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((SwanAppActivity) objArr2[0], (String) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tieba.xf2
    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.tieba.xf2
    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.tieba.xf2
    public void F0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.F0(i);
        }
    }

    @Override // com.baidu.tieba.xf2
    public void G0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            yz1.i("SwanApp", "onUpdate isLaunch=" + z + ";isRelaunch=" + z2);
            String p1 = p1();
            JSONObject d2 = yf3.d(Z().n("_naExtParams"));
            if (q) {
                Log.d("SwanAppFrame", "onNewIntent launchPage : " + p1);
            }
            String v1 = v1(p1);
            if (z) {
                i93.w();
                mt2.e().l(z2);
                HybridUbcFlow p = dw2.p("startup");
                vn2.a Z = Z();
                if (z2) {
                    if (q) {
                        Log.d("SwanAppFrame", "onRelaunch launchPage : " + v1);
                    }
                    i82.k().x(Z.H(), true);
                    q93.d(2);
                    if (!TextUtils.isEmpty(v1)) {
                        if (d2.optString("_naScene", "").equals("message")) {
                            h63.f("backtohome", "message", v1);
                        } else {
                            boolean i = h63.i(v1);
                            i93.u(v1, Z);
                            a32.f(i);
                            p.I(HybridUbcFlow.SubmitStrategy.RELAUNCH);
                            p.E("type", "2");
                            boolean a2 = l53.b().a(ys2.d(v1, lo2.U().z()));
                            h63.f("backtohome", a2 ? "message" : "relaunch", v1);
                            if (i && !a2) {
                                h63.q("reLaunch");
                                ku1.d().i();
                                dl2.d("2");
                            } else {
                                dl2.d("3");
                            }
                        }
                    } else if (ia3.a()) {
                        h63.f("backtohome", "relaunch", lo2.U().g());
                    } else {
                        mt2.e().m();
                        mt2.e().l(false);
                        a32.f(false);
                        p.I(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                        p.E("type", "3");
                        dl2.d("3");
                        i93.s(Z);
                        i93.p(Z);
                    }
                    if (a0().hasResumed()) {
                        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_page_show");
                        ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
                        p.F(ubcFlowEvent);
                        y83.d().i("na_page_show");
                    }
                    y83.d().i("frame_new_intent");
                    y23 q2 = x23.K().q();
                    q2.e0().j();
                    q2.N().a();
                    if (q) {
                        Log.d("SwanAppFrame", "hot start: hit prelink");
                        Log.d("SwanPrelink", "hot start: hit prelink");
                    }
                    q2.Q();
                    if (q) {
                        i82.k().w();
                    }
                    r93.E();
                } else {
                    p.I(HybridUbcFlow.SubmitStrategy.HYBRID);
                    ti3.b("0");
                }
                u1();
            }
        }
    }

    @Override // com.baidu.tieba.xf2
    @NonNull
    public tz2.c b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new e(this) : (tz2.c) invokeV.objValue;
    }

    @Override // com.baidu.tieba.g33, com.baidu.tieba.b33
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.xf2
    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            l0(1);
        }
    }

    public final void k1() {
        f q1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (q1 = q1()) == null) {
            return;
        }
        q1.a();
    }

    @Override // com.baidu.tieba.xf2
    public void l0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            yz1.i("SwanApp", "onBackPressed back stack count:" + this.c.k());
            n1(i);
            e22 m = this.c.m();
            if (m == null || !m.I()) {
                if (e0()) {
                    y23 M = y23.M();
                    if (M != null) {
                        M.P().E();
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("lcType", "onClose");
                    hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, y23.g0());
                    lo2.U().u(new ad2(hashMap));
                    yz1.i("SwanAppFrame", "onBack");
                    mo2.a().d(false);
                    return;
                }
                m93.f(UUID.randomUUID().toString(), 1);
                if3.a(c0(), this.b);
                h22.b i2 = this.c.i("navigateBack");
                i2.n(h22.i, h22.h);
                i2.g();
                i2.a();
            }
        }
    }

    public final void l1() {
        f q1;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (q1 = q1()) == null) {
            return;
        }
        q1.b();
    }

    @Override // com.baidu.tieba.xf2
    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b.setRequestedOrientation(1);
            hf3.a(this.b);
            if (l12.d()) {
                WebView.setWebContentsDebuggingEnabled(true);
            }
            y83.d().a();
            y83.d().i("frame_create");
            mt2.e().l(true);
            mt2.e().n();
            w1();
            r1();
            V8Engine.setCrashKeyValue("app_title", Z().K());
        }
    }

    public final boolean m1(vn2 vn2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, vn2Var)) == null) {
            if (vn2Var != null && !xy2.B(vn2Var)) {
                if (vn2Var.G() != 0) {
                    if (q) {
                        Log.i("SwanAppFrame", "checkSyncLegal error: games category");
                    }
                    return false;
                }
                SwanAppConfigData Q = x23.K().q().Q();
                if (Q == null) {
                    if (q) {
                        Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    }
                    return false;
                } else if (!ul2.e.i(vn2Var.H(), vn2Var.v1()).exists()) {
                    if (q) {
                        Log.i("SwanAppFrame", "checkSyncLegal error : unzip foldr is not exist");
                    }
                    return false;
                } else {
                    return !n63.q(vn2Var, Q);
                }
            }
            if (q) {
                Log.i("SwanAppFrame", "checkSyncLegal error: info is null or debug model");
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void n1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            String str = i != 2 ? i != 3 ? "virtual" : "gesture" : "click";
            aa3 aa3Var = new aa3();
            aa3Var.e = "back";
            h22 h22Var = this.c;
            boolean z = true;
            aa3Var.g = (h22Var == null || h22Var.k() <= 1) ? false : false ? "1" : "0";
            aa3Var.b = str;
            h93.a(aa3Var, Z());
            h93.c(aa3Var);
        }
    }

    @Override // com.baidu.tieba.xf2
    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            f73.j();
            f73.h();
            mt2.e().o();
            fm2.a0().a();
            lo2.U().unregisterReceiver(this.b);
        }
    }

    public final gg2.b o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? new d(this) : (gg2.b) invokeV.objValue;
    }

    public final String p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? vn2.m1(Z(), lo2.U().s()) : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xf2
    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    @Inject(force = false)
    public final f q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? new f() : (f) invokeV.objValue;
    }

    @Override // com.baidu.tieba.xf2
    public boolean r0(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048594, this, i, keyEvent)) == null) {
            if (i == 4) {
                if (eg2.b().c()) {
                    eg2.b().f(this.b, new c(this));
                    return true;
                }
                h22 h22Var = this.c;
                if (h22Var != null && h22Var.k() == 1) {
                    fg2 fg2Var = new fg2();
                    fg2Var.h();
                    if (fg2Var.j()) {
                        gg2.a().c(this.b, fg2Var.f(), fg2Var.e(), fg2Var, o1());
                        return true;
                    }
                    mt2.e().g();
                }
            }
            return super.r0(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public final void r1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (x23.K().q().y0()) {
                yz1.i("SwanAppFrame", "swan/web, handleLoadApps: ");
                return;
            }
            i93.z();
            if (E()) {
                t1();
                vn2.a Z = Z();
                if (m1(Z)) {
                    if (q) {
                        Log.i("SwanAppFrame", "start load aiapps sync ");
                    }
                    lo2.U().d(Z, null);
                    return;
                }
                if (q) {
                    Log.i("SwanAppFrame", "start load aiapps async ");
                }
                lo2.U().E(Z, null);
            }
        }
    }

    @Override // com.baidu.tieba.xf2
    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.s0();
            if (s92.U().W() != null) {
                s92.U().W().attachActivity(this.b);
            }
        }
    }

    public final boolean s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            x23 K = x23.K();
            if (K.E()) {
                vn2.a Y = K.q().Y();
                String T = Y.T();
                String U = Y.U();
                if (TextUtils.isEmpty(Y.T()) || TextUtils.equals(T, U)) {
                    return false;
                }
                a33 U2 = q().U();
                if (U2.b(Y.T())) {
                    return !U2.c(T, Boolean.FALSE).booleanValue();
                }
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void t1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            vn2.a Z = Z();
            if (q) {
                Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
            }
            if (Z == null) {
                if (q) {
                    Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                }
            } else if (ng3.f(Z.a0())) {
                s92.N0(true);
            } else {
                SwanCoreVersion j0 = Z.j0();
                ExtensionCore T = s92.U().T();
                ExtensionCore O = Z.O();
                boolean z = false;
                boolean z2 = j0 != null && ng3.f(j0.swanCoreVersionName) && un2.a(Z.S());
                if (T != null && O != null && T.extensionCoreVersionCode < O.extensionCoreVersionCode && un2.b(Z.S())) {
                    z = true;
                }
                if (z2 || z) {
                    if (q) {
                        Log.d("SwanAppFrame", "预加载的swan-core或Extension版本过低时释放并重新加载");
                    }
                    s92.N0(true);
                }
            }
        }
    }

    @Override // com.baidu.tieba.xf2
    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
        }
    }

    public final void u1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && s1()) {
            rw2.e().d(new b(this), "tryUpdateAsync", false);
        }
    }

    public final String v1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            vn2.a Z = Z();
            return (TextUtils.isEmpty(str) && Z != null && h0(Z.H())) ? lo2.U().g() : str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tieba.xf2
    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            ExecutorUtilsExt.postOnElastic(new a(this), "registerScreenshotEvent", 2);
        }
    }

    public final void w1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            vn2.a Z = Z();
            if (q) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + Z.j0());
            }
            if (Z.j0() == null || !Z.j0().isAvailable()) {
                if (q) {
                    Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
                }
                Z.Z0(dc3.g(0));
                if (q) {
                    Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + Z.j0());
                }
            }
        }
    }

    @Override // com.baidu.tieba.xf2
    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
        }
    }

    @Override // com.baidu.tieba.xf2
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            dw2.o().F(new UbcFlowEvent("frame_start_end"));
            y83.d().i("frame_start_end");
        }
    }
}
