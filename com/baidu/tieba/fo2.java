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
import com.baidu.searchbox.appframework.AppFrameworkConstants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.tieba.aw2;
import com.baidu.tieba.lo2;
import com.baidu.tieba.ma2;
import com.baidu.tieba.y73;
import com.baidu.tieba.zt2;
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
/* loaded from: classes5.dex */
public class fo2 extends co2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean q;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.co2
    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.tieba.co2
    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.tieba.lb3, com.baidu.tieba.gb3
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.co2
    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
        }
    }

    @Override // com.baidu.tieba.co2
    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
        }
    }

    @Override // com.baidu.tieba.co2
    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fo2 a;

        public a(fo2 fo2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fo2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fo2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && mn3.d(this.a.b)) {
                kf3.g();
                qw2.T().registerReceiver(this.a.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(fo2 fo2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fo2Var};
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
                z23.g().y();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements pc2<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fo2 a;

        public c(fo2 fo2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fo2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fo2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.pc2
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) && this.a.b != null && bool.booleanValue()) {
                this.a.b.onBackPressed();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements lo2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fo2 a;

        public d(fo2 fo2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fo2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fo2Var;
        }

        @Override // com.baidu.tieba.lo2.b
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b != null) {
                this.a.b.moveTaskToBack(true);
                fp3.b().e(1);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements y73.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fo2 a;

        public e(fo2 fo2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fo2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fo2Var;
        }

        @Override // com.baidu.tieba.y73.c
        public boolean a(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i = message.what;
                if (i != 100) {
                    if (i != 127) {
                        if (i != 129) {
                            if (i != 102) {
                                if (i != 103) {
                                    if (i != 106) {
                                        if (i != 107) {
                                            switch (i) {
                                                case 123:
                                                    jn3.r(message);
                                                    return true;
                                                case 124:
                                                    jn3.q(message);
                                                    return true;
                                                case 125:
                                                    w73.b(message);
                                                    return true;
                                                default:
                                                    return false;
                                            }
                                        }
                                        fe2.a(message);
                                        return true;
                                    }
                                    cb3.K().s();
                                    return true;
                                }
                                db3 M = db3.M();
                                if (M != null) {
                                    M.e0().i();
                                    z23.g().v();
                                }
                                this.a.Q0();
                                this.a.k1();
                                return true;
                            }
                            boolean a = ku2.M().a();
                            ku2.M().d(a);
                            if (this.a.b != null) {
                                this.a.b.y(a, false);
                            }
                            return true;
                        }
                        int p = jn3.m().p();
                        d82.i("SwanAppFrame", "resetCore: client receive msg topTaskId = " + p);
                        if (this.a.b != null && this.a.b.f0() && p != -1 && this.a.b.getTaskId() != p) {
                            d82.i("SwanAppFrame", "resetCore: purgeSwanApp");
                            cb3.K().s();
                        }
                        return true;
                    }
                    int d = z03.d();
                    int a2 = z03.a(d);
                    if (!z03.f()) {
                        y03.a(Integer.valueOf(d), String.valueOf(a2));
                    }
                    return true;
                }
                t73.e().h(new v73(4));
                this.a.Q0();
                this.a.l1();
                cb3.K().s();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

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

        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                zj3.u(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947770784, "Lcom/baidu/tieba/fo2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947770784, "Lcom/baidu/tieba/fo2;");
                return;
            }
        }
        q = nr1.a;
    }

    @Override // com.baidu.tieba.co2
    @NonNull
    public y73.c b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return new e(this);
        }
        return (y73.c) invokeV.objValue;
    }

    @Override // com.baidu.tieba.co2
    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            l0(1);
        }
    }

    public final void k1() {
        f q1;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (q1 = q1()) != null) {
            q1.a();
        }
    }

    public final void l1() {
        f q1;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (q1 = q1()) != null) {
            q1.b();
        }
    }

    @Override // com.baidu.tieba.co2
    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            kf3.j();
            kf3.h();
            r13.e().o();
            ku2.a0().a();
            qw2.T().unregisterReceiver(this.b);
        }
    }

    public final lo2.b o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return new d(this);
        }
        return (lo2.b) invokeV.objValue;
    }

    public final String p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return aw2.m1(Z(), qw2.T().s());
        }
        return (String) invokeV.objValue;
    }

    @Inject(force = false)
    public final f q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return new f();
        }
        return (f) invokeV.objValue;
    }

    @Override // com.baidu.tieba.co2
    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.s0();
            if (xh2.U().W() != null) {
                xh2.U().W().attachActivity(this.b);
            }
        }
    }

    public final void u1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && s1()) {
            w43.e().d(new b(this), "tryUpdateAsync", false);
        }
    }

    @Override // com.baidu.tieba.co2
    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            ExecutorUtilsExt.postOnElastic(new a(this), "registerScreenshotEvent", 2);
        }
    }

    @Override // com.baidu.tieba.co2
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            i43.o().F(new UbcFlowEvent("frame_start_end"));
            dh3.d().i("frame_start_end");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fo2(SwanAppActivity swanAppActivity, String str) {
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

    @Override // com.baidu.tieba.co2
    public void F0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.F0(i);
        }
    }

    @Override // com.baidu.tieba.co2
    public void G0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            d82.i("SwanApp", "onUpdate isLaunch=" + z + ";isRelaunch=" + z2);
            String p1 = p1();
            JSONObject d2 = do3.d(Z().n("_naExtParams"));
            if (q) {
                Log.d("SwanAppFrame", "onNewIntent launchPage : " + p1);
            }
            String v1 = v1(p1);
            if (z) {
                nh3.w();
                r13.e().l(z2);
                HybridUbcFlow p = i43.p("startup");
                aw2.a Z = Z();
                if (z2) {
                    if (q) {
                        Log.d("SwanAppFrame", "onRelaunch launchPage : " + v1);
                    }
                    ng2.k().x(Z.H(), true);
                    vh3.d(2);
                    String str = "relaunch";
                    if (!TextUtils.isEmpty(v1)) {
                        if (d2.optString("_naScene", "").equals("message")) {
                            me3.f("backtohome", "message", v1);
                        } else {
                            boolean i = me3.i(v1);
                            nh3.u(v1, Z);
                            fb2.f(i);
                            p.I(HybridUbcFlow.SubmitStrategy.RELAUNCH);
                            p.E("type", "2");
                            boolean a2 = qd3.b().a(d13.d(v1, qw2.T().z()));
                            if (a2) {
                                str = "message";
                            }
                            me3.f("backtohome", str, v1);
                            if (i && !a2) {
                                me3.q("reLaunch");
                                p22.d().i();
                                it2.d("2");
                            } else {
                                it2.d("3");
                            }
                        }
                    } else if (ni3.a()) {
                        me3.f("backtohome", "relaunch", qw2.T().g());
                    } else {
                        r13.e().m();
                        r13.e().l(false);
                        fb2.f(false);
                        p.I(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                        p.E("type", "3");
                        it2.d("3");
                        nh3.s(Z);
                        nh3.p(Z);
                    }
                    if (a0().hasResumed()) {
                        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_page_show");
                        ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
                        p.F(ubcFlowEvent);
                        dh3.d().i("na_page_show");
                    }
                    dh3.d().i("frame_new_intent");
                    db3 q2 = cb3.K().q();
                    q2.e0().j();
                    q2.N().a();
                    if (q) {
                        Log.d("SwanAppFrame", "hot start: hit prelink");
                        Log.d("SwanPrelink", "hot start: hit prelink");
                    }
                    q2.Q();
                    if (q) {
                        ng2.k().w();
                    }
                    wh3.E();
                } else {
                    p.I(HybridUbcFlow.SubmitStrategy.HYBRID);
                    yq3.b("0");
                }
                u1();
            }
        }
    }

    @Override // com.baidu.tieba.co2
    public void l0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            d82.i("SwanApp", "onBackPressed back stack count:" + this.c.k());
            n1(i);
            ja2 m = this.c.m();
            if (m != null && m.H()) {
                return;
            }
            if (e0()) {
                db3 M = db3.M();
                if (M != null) {
                    M.P().E();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onClose");
                hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, db3.g0());
                qw2.T().u(new fl2(hashMap));
                d82.i("SwanAppFrame", "onBack");
                rw2.a().d(false);
                return;
            }
            rh3.f(UUID.randomUUID().toString(), 1);
            nn3.a(c0(), this.b);
            ma2.b i2 = this.c.i("navigateBack");
            i2.n(ma2.i, ma2.h);
            i2.g();
            i2.a();
        }
    }

    @Override // com.baidu.tieba.co2
    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.b.setRequestedOrientation(1);
            mn3.a(this.b);
            if (q92.d()) {
                WebView.setWebContentsDebuggingEnabled(true);
            }
            dh3.d().a();
            dh3.d().i("frame_create");
            r13.e().l(true);
            r13.e().n();
            w1();
            r1();
            V8Engine.setCrashKeyValue("app_title", Z().K());
        }
    }

    public final void r1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            if (cb3.K().q().y0()) {
                d82.i("SwanAppFrame", "swan/web, handleLoadApps: ");
                return;
            }
            nh3.z();
            if (!E()) {
                return;
            }
            t1();
            aw2.a Z = Z();
            if (m1(Z)) {
                if (q) {
                    Log.i("SwanAppFrame", "start load aiapps sync ");
                }
                qw2.T().d(Z, null);
                return;
            }
            if (q) {
                Log.i("SwanAppFrame", "start load aiapps async ");
            }
            qw2.T().E(Z, null);
        }
    }

    public final boolean s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            cb3 K = cb3.K();
            if (!K.E()) {
                return false;
            }
            aw2.a Y = K.q().Y();
            String T2 = Y.T();
            String U = Y.U();
            if (TextUtils.isEmpty(Y.T()) || TextUtils.equals(T2, U)) {
                return false;
            }
            fb3 U2 = q().U();
            if (!U2.b(Y.T())) {
                return true;
            }
            return !U2.c(T2, Boolean.FALSE).booleanValue();
        }
        return invokeV.booleanValue;
    }

    public final boolean m1(aw2 aw2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, aw2Var)) == null) {
            if (aw2Var != null && !c73.B(aw2Var)) {
                if (aw2Var.G() != 0) {
                    if (q) {
                        Log.i("SwanAppFrame", "checkSyncLegal error: games category");
                    }
                    return false;
                }
                SwanAppConfigData Q = cb3.K().q().Q();
                if (Q == null) {
                    if (q) {
                        Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    }
                    return false;
                } else if (!zt2.e.i(aw2Var.H(), aw2Var.v1()).exists()) {
                    if (q) {
                        Log.i("SwanAppFrame", "checkSyncLegal error : unzip foldr is not exist");
                    }
                    return false;
                } else {
                    return !se3.q(aw2Var, Q);
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
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            if (i != 2) {
                if (i != 3) {
                    str = "virtual";
                } else {
                    str = AppFrameworkConstants.VALUE_GESTURE_BACK;
                }
            } else {
                str = "click";
            }
            fi3 fi3Var = new fi3();
            fi3Var.e = "back";
            ma2 ma2Var = this.c;
            boolean z = true;
            if ((ma2Var == null || ma2Var.k() <= 1) ? false : false) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            fi3Var.g = str2;
            fi3Var.b = str;
            mh3.a(fi3Var, Z());
            mh3.c(fi3Var);
        }
    }

    @Override // com.baidu.tieba.co2
    public boolean r0(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048594, this, i, keyEvent)) == null) {
            if (i == 4) {
                if (jo2.b().c()) {
                    jo2.b().f(this.b, new c(this));
                    return true;
                }
                ma2 ma2Var = this.c;
                if (ma2Var != null && ma2Var.k() == 1) {
                    ko2 ko2Var = new ko2();
                    ko2Var.h();
                    if (ko2Var.j()) {
                        lo2.a().c(this.b, ko2Var.f(), ko2Var.e(), ko2Var, o1());
                        return true;
                    }
                    r13.e().g();
                }
            }
            return super.r0(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public final void t1() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            aw2.a Z = Z();
            if (q) {
                Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
            }
            if (Z == null) {
                if (q) {
                    Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                }
            } else if (so3.f(Z.a0())) {
                xh2.N0(true);
            } else {
                SwanCoreVersion j0 = Z.j0();
                ExtensionCore T2 = xh2.U().T();
                ExtensionCore O = Z.O();
                boolean z2 = false;
                if (j0 != null && so3.f(j0.swanCoreVersionName) && zv2.a(Z.S())) {
                    z = true;
                } else {
                    z = false;
                }
                if (T2 != null && O != null && T2.extensionCoreVersionCode < O.extensionCoreVersionCode && zv2.b(Z.S())) {
                    z2 = true;
                }
                if (z || z2) {
                    if (q) {
                        Log.d("SwanAppFrame", "预加载的swan-core或Extension版本过低时释放并重新加载");
                    }
                    xh2.N0(true);
                }
            }
        }
    }

    public final void w1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            aw2.a Z = Z();
            if (q) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + Z.j0());
            }
            if (Z.j0() == null || !Z.j0().isAvailable()) {
                if (q) {
                    Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
                }
                Z.Z0(ik3.g(0));
                if (q) {
                    Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + Z.j0());
                }
            }
        }
    }

    public final String v1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            aw2.a Z = Z();
            if (TextUtils.isEmpty(str) && Z != null && h0(Z.H())) {
                return qw2.T().g();
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
