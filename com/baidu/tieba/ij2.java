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
import com.baidu.tieba.b33;
import com.baidu.tieba.cp2;
import com.baidu.tieba.dr2;
import com.baidu.tieba.oj2;
import com.baidu.tieba.p52;
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
/* loaded from: classes6.dex */
public class ij2 extends fj2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean q;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.fj2
    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.tieba.fj2
    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.tieba.o63, com.baidu.tieba.j63
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.fj2
    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    @Override // com.baidu.tieba.fj2
    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
        }
    }

    @Override // com.baidu.tieba.fj2
    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ij2 a;

        public a(ij2 ij2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ij2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ij2Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && pi3.d(this.a.b)) {
                na3.g();
                tr2.V().E(this.a.b);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(ij2 ij2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ij2Var};
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
                cy2.g().y();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements s72<Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ij2 a;

        public c(ij2 ij2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ij2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ij2Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.s72
        /* renamed from: b */
        public void a(Boolean bool) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) && this.a.b != null && bool.booleanValue()) {
                this.a.b.onBackPressed();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements oj2.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ij2 a;

        public d(ij2 ij2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ij2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ij2Var;
        }

        @Override // com.baidu.tieba.oj2.b
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b != null) {
                this.a.b.moveTaskToBack(true);
                ik3.b().e(1);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements b33.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ij2 a;

        public e(ij2 ij2Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ij2Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ij2Var;
        }

        @Override // com.baidu.tieba.b33.c
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
                                                    mi3.r(message);
                                                    return true;
                                                case 124:
                                                    mi3.q(message);
                                                    return true;
                                                case 125:
                                                    z23.b(message);
                                                    return true;
                                                default:
                                                    return false;
                                            }
                                        }
                                        i92.a(message);
                                        return true;
                                    }
                                    f63.K().s();
                                    return true;
                                }
                                g63 M = g63.M();
                                if (M != null) {
                                    M.f0().i();
                                    cy2.g().v();
                                }
                                this.a.Q0();
                                this.a.l1();
                                return true;
                            }
                            boolean a = np2.M().a();
                            np2.M().d(a);
                            if (this.a.b != null) {
                                this.a.b.z(a, false);
                            }
                            return true;
                        }
                        int p = mi3.m().p();
                        g32.i("SwanAppFrame", "resetCore: client receive msg topTaskId = " + p);
                        if (this.a.b != null && this.a.b.f0() && p != -1 && this.a.b.getTaskId() != p) {
                            g32.i("SwanAppFrame", "resetCore: purgeSwanApp");
                            f63.K().s();
                        }
                        return true;
                    }
                    int d = cw2.d();
                    int a2 = cw2.a(d);
                    if (!cw2.f()) {
                        bw2.a(Integer.valueOf(d), String.valueOf(a2));
                    }
                    return true;
                }
                w23.e().h(new y23(4));
                this.a.Q0();
                this.a.m1();
                f63.K().s();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
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
                cf3.u(false);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947855352, "Lcom/baidu/tieba/ij2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947855352, "Lcom/baidu/tieba/ij2;");
                return;
            }
        }
        q = rm1.a;
    }

    @Override // com.baidu.tieba.fj2
    @NonNull
    public b33.c b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return new e(this);
        }
        return (b33.c) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fj2
    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            l0(1);
        }
    }

    public final void l1() {
        f r1;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (r1 = r1()) != null) {
            r1.a();
        }
    }

    public final void m1() {
        f r1;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && (r1 = r1()) != null) {
            r1.b();
        }
    }

    @Override // com.baidu.tieba.fj2
    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            na3.j();
            na3.h();
            uw2.e().o();
            np2.a0().a();
            tr2.V().l(this.b);
        }
    }

    public final oj2.b p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return new d(this);
        }
        return (oj2.b) invokeV.objValue;
    }

    public final String q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return dr2.n1(Z(), tr2.V().t());
        }
        return (String) invokeV.objValue;
    }

    @Inject(force = false)
    public final f r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return new f();
        }
        return (f) invokeV.objValue;
    }

    @Override // com.baidu.tieba.fj2
    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            super.s0();
            if (ad2.V().X() != null) {
                ad2.V().X().attachActivity(this.b);
            }
        }
    }

    public final void v1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && t1()) {
            zz2.e().d(new b(this), "tryUpdateAsync", false);
        }
    }

    @Override // com.baidu.tieba.fj2
    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            ExecutorUtilsExt.postOnElastic(new a(this), "registerScreenshotEvent", 2);
        }
    }

    @Override // com.baidu.tieba.fj2
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            lz2.o().F(new UbcFlowEvent("frame_start_end"));
            gc3.d().i("frame_start_end");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ij2(SwanAppActivity swanAppActivity, String str) {
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

    @Override // com.baidu.tieba.fj2
    public void F0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            super.F0(i);
        }
    }

    @Override // com.baidu.tieba.fj2
    public void G0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            g32.i("SwanApp", "onUpdate isLaunch=" + z + ";isRelaunch=" + z2);
            String q1 = q1();
            JSONObject d2 = gj3.d(Z().n("_naExtParams"));
            if (q) {
                Log.d("SwanAppFrame", "onNewIntent launchPage : " + q1);
            }
            String w1 = w1(q1);
            if (z) {
                qc3.w();
                uw2.e().l(z2);
                HybridUbcFlow p = lz2.p("startup");
                dr2.a Z = Z();
                if (z2) {
                    if (q) {
                        Log.d("SwanAppFrame", "onRelaunch launchPage : " + w1);
                    }
                    qb2.k().x(Z.I(), true);
                    yc3.d(2);
                    String str = "relaunch";
                    if (!TextUtils.isEmpty(w1)) {
                        if (d2.optString("_naScene", "").equals("message")) {
                            p93.f("backtohome", "message", w1);
                        } else {
                            boolean i = p93.i(w1);
                            qc3.u(w1, Z);
                            i62.f(i);
                            p.I(HybridUbcFlow.SubmitStrategy.RELAUNCH);
                            p.E("type", "2");
                            boolean a2 = t83.b().a(gw2.d(w1, tr2.V().A()));
                            if (a2) {
                                str = "message";
                            }
                            p93.f("backtohome", str, w1);
                            if (i && !a2) {
                                p93.q("reLaunch");
                                tx1.d().i();
                                lo2.d("2");
                            } else {
                                lo2.d("3");
                            }
                        }
                    } else if (qd3.a()) {
                        p93.f("backtohome", "relaunch", tr2.V().g());
                    } else {
                        uw2.e().m();
                        uw2.e().l(false);
                        i62.f(false);
                        p.I(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                        p.E("type", "3");
                        lo2.d("3");
                        qc3.s(Z);
                        qc3.p(Z);
                    }
                    if (a0().hasResumed()) {
                        UbcFlowEvent ubcFlowEvent = new UbcFlowEvent("na_page_show");
                        ubcFlowEvent.d(UbcFlowEvent.RecordType.UPDATE_RECENT);
                        p.F(ubcFlowEvent);
                        gc3.d().i("na_page_show");
                    }
                    gc3.d().i("frame_new_intent");
                    g63 q2 = f63.K().q();
                    q2.f0().j();
                    q2.N().a();
                    if (q) {
                        Log.d("SwanAppFrame", "hot start: hit prelink");
                        Log.d("SwanPrelink", "hot start: hit prelink");
                    }
                    q2.R();
                    if (q) {
                        qb2.k().w();
                    }
                    zc3.E();
                } else {
                    p.I(HybridUbcFlow.SubmitStrategy.HYBRID);
                    bm3.b("0");
                }
                v1();
            }
        }
    }

    @Override // com.baidu.tieba.fj2
    public void l0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            g32.i("SwanApp", "onBackPressed back stack count:" + this.c.k());
            o1(i);
            m52 m = this.c.m();
            if (m != null && m.H()) {
                return;
            }
            if (e0()) {
                g63 M = g63.M();
                if (M != null) {
                    M.Q().E();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onClose");
                hashMap.put(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, g63.h0());
                tr2.V().v(new ig2(hashMap));
                g32.i("SwanAppFrame", "onBack");
                ur2.a().d(false);
                return;
            }
            uc3.f(UUID.randomUUID().toString(), 1);
            qi3.a(c0(), this.b);
            p52.b i2 = this.c.i("navigateBack");
            i2.n(p52.i, p52.h);
            i2.g();
            i2.a();
        }
    }

    @Override // com.baidu.tieba.fj2
    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.b.setRequestedOrientation(1);
            pi3.a(this.b);
            if (t42.d()) {
                WebView.setWebContentsDebuggingEnabled(true);
            }
            gc3.d().a();
            gc3.d().i("frame_create");
            uw2.e().l(true);
            uw2.e().n();
            x1();
            s1();
            V8Engine.setCrashKeyValue("app_title", Z().L());
        }
    }

    public final void s1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            if (f63.K().q().z0()) {
                g32.i("SwanAppFrame", "swan/web, handleLoadApps: ");
                return;
            }
            qc3.z();
            if (!E()) {
                return;
            }
            u1();
            dr2.a Z = Z();
            if (n1(Z)) {
                if (q) {
                    Log.i("SwanAppFrame", "start load aiapps sync ");
                }
                tr2.V().d(Z, null);
                return;
            }
            if (q) {
                Log.i("SwanAppFrame", "start load aiapps async ");
            }
            tr2.V().G(Z, null);
        }
    }

    public final boolean t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            f63 K = f63.K();
            if (!K.E()) {
                return false;
            }
            dr2.a Z = K.q().Z();
            String U = Z.U();
            String V = Z.V();
            if (TextUtils.isEmpty(Z.U()) || TextUtils.equals(U, V)) {
                return false;
            }
            i63 V2 = q().V();
            if (!V2.b(Z.U())) {
                return true;
            }
            return !V2.c(U, Boolean.FALSE).booleanValue();
        }
        return invokeV.booleanValue;
    }

    public final boolean n1(dr2 dr2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, dr2Var)) == null) {
            if (dr2Var != null && !f23.B(dr2Var)) {
                if (dr2Var.H() != 0) {
                    if (q) {
                        Log.i("SwanAppFrame", "checkSyncLegal error: games category");
                    }
                    return false;
                }
                SwanAppConfigData R = f63.K().q().R();
                if (R == null) {
                    if (q) {
                        Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    }
                    return false;
                } else if (!cp2.e.i(dr2Var.I(), dr2Var.x1()).exists()) {
                    if (q) {
                        Log.i("SwanAppFrame", "checkSyncLegal error : unzip foldr is not exist");
                    }
                    return false;
                } else {
                    return !v93.q(dr2Var, R);
                }
            }
            if (q) {
                Log.i("SwanAppFrame", "checkSyncLegal error: info is null or debug model");
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void o1(int i) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            if (i != 2) {
                if (i != 3) {
                    str = "virtual";
                } else {
                    str = AppFrameworkConstants.VALUE_GESTURE_BACK;
                }
            } else {
                str = "click";
            }
            id3 id3Var = new id3();
            id3Var.e = "back";
            p52 p52Var = this.c;
            boolean z = true;
            if ((p52Var == null || p52Var.k() <= 1) ? false : false) {
                str2 = "1";
            } else {
                str2 = "0";
            }
            id3Var.g = str2;
            id3Var.b = str;
            pc3.a(id3Var, Z());
            pc3.c(id3Var);
        }
    }

    @Override // com.baidu.tieba.fj2
    public boolean r0(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048593, this, i, keyEvent)) == null) {
            if (i == 4) {
                if (mj2.b().c()) {
                    mj2.b().f(this.b, new c(this));
                    return true;
                }
                p52 p52Var = this.c;
                if (p52Var != null && p52Var.k() == 1) {
                    nj2 nj2Var = new nj2();
                    nj2Var.h();
                    if (nj2Var.j()) {
                        oj2.a().c(this.b, nj2Var.f(), nj2Var.e(), nj2Var, p1());
                        return true;
                    }
                    uw2.e().g();
                }
            }
            return super.r0(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public final void u1() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            dr2.a Z = Z();
            if (q) {
                Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
            }
            if (Z == null) {
                if (q) {
                    Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                }
            } else if (vj3.f(Z.b0())) {
                ad2.O0(true);
            } else {
                SwanCoreVersion k0 = Z.k0();
                ExtensionCore U = ad2.V().U();
                ExtensionCore P = Z.P();
                boolean z2 = false;
                if (k0 != null && vj3.f(k0.swanCoreVersionName) && cr2.a(Z.T())) {
                    z = true;
                } else {
                    z = false;
                }
                if (U != null && P != null && U.extensionCoreVersionCode < P.extensionCoreVersionCode && cr2.b(Z.T())) {
                    z2 = true;
                }
                if (z || z2) {
                    if (q) {
                        Log.d("SwanAppFrame", "预加载的swan-core或Extension版本过低时释放并重新加载");
                    }
                    ad2.O0(true);
                }
            }
        }
    }

    public final void x1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            dr2.a Z = Z();
            if (q) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + Z.k0());
            }
            if (Z.k0() == null || !Z.k0().isAvailable()) {
                if (q) {
                    Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
                }
                Z.a1(lf3.g(0));
                if (q) {
                    Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + Z.k0());
                }
            }
        }
    }

    public final String w1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            dr2.a Z = Z();
            if (TextUtils.isEmpty(str) && Z != null && h0(Z.I())) {
                return tr2.V().g();
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
