package com.baidu.tieba;

import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.games.inspector.SwanInspectorEndpoint;
import com.baidu.tieba.account.AccountRestoreActivity;
import com.baidu.tieba.n32;
import com.baidu.tieba.u04;
import com.baidu.tieba.z03;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class f04 extends dh2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean r;
    public transient /* synthetic */ FieldHolder $fh;
    public long q;

    @Override // com.baidu.tieba.dh2
    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // com.baidu.tieba.dh2
    public void D0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    @Override // com.baidu.tieba.m43, com.baidu.tieba.h43
    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.dh2
    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    @Override // com.baidu.tieba.dh2
    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    @Override // com.baidu.tieba.dh2
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements ym2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f04 a;

        public a(f04 f04Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f04Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f04Var;
        }

        @Override // com.baidu.tieba.ym2
        public void a(int i, xm2 xm2Var) {
            u04.c cVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i, xm2Var) == null) && (cVar = (u04.c) xm2Var) != null && !TextUtils.isEmpty(cVar.a)) {
                e04.m().I(this.a.Z());
                e04.m().x(cVar);
                hy3.h();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements z03.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f04 a;

        public b(f04 f04Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f04Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f04Var;
        }

        @Override // com.baidu.tieba.z03.c
        public boolean a(Message message) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, message)) == null) {
                int i = message.what;
                if (i != 100) {
                    if (i != 102) {
                        if (i != 103) {
                            if (i != 106) {
                                if (i != 107) {
                                    switch (i) {
                                        case 123:
                                            kg3.r(message);
                                            return true;
                                        case 124:
                                            kg3.q(message);
                                            return true;
                                        case 125:
                                            x03.b(message);
                                            return true;
                                        case 126:
                                            x03.d(message);
                                            return true;
                                        default:
                                            return false;
                                    }
                                }
                                g72.a(message);
                                return true;
                            }
                            d43.K().s();
                            return true;
                        }
                        e43 M = e43.M();
                        if (M != null) {
                            M.e0().i();
                            aw2.g().v();
                        }
                        this.a.Q0();
                        e04.m().H();
                        sx3.b();
                        return true;
                    }
                    boolean a = ln2.M().a();
                    ln2.M().d(a);
                    if (this.a.b != null) {
                        this.a.b.x(a, false);
                    }
                    return true;
                }
                u03.e().h(new w03(4));
                this.a.Q0();
                e04.m().H();
                d43.K().s();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f04 a;

        public c(f04 f04Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f04Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f04Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (f04.r) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager onFirstFrameFinished");
                }
                this.a.q = System.currentTimeMillis();
                b54.f(this.a.Z());
                this.a.b.O();
                jx2.h("preload", "startup");
                int j = e04.m().j();
                HybridUbcFlow p = jx2.p("startup");
                p.I(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                p.D("codecache", String.valueOf(j));
                p.F(new UbcFlowEvent("na_first_paint"));
                p.A();
                long f = p.f("na_first_paint", "naStart");
                e04.m().i(new e24(f));
                if (f04.r) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager 小游戏启动时长: " + f);
                }
                r64.A().D();
                v04.f().init();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f04 a;

        public d(f04 f04Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f04Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f04Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            this.a.i1();
            this.a.h1();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947710303, "Lcom/baidu/tieba/f04;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947710303, "Lcom/baidu/tieba/f04;");
                return;
            }
        }
        r = ok1.a;
    }

    @Override // com.baidu.tieba.dh2
    @NonNull
    public z03.c b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return new b(this);
        }
        return (z03.c) invokeV.objValue;
    }

    public long f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.q;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.dh2
    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (d43.K().q().Y().d0() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public mb2 g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return e04.m().n();
        }
        return (mb2) invokeV.objValue;
    }

    public final void h1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            r64.A().m();
        }
    }

    public final void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            r64.A().F();
        }
    }

    public boolean j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.q > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void k1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            yh3.e0(new c(this));
            ExecutorUtilsExt.postOnElastic(new d(this), "SwanGameFrameRequestAd", 2);
            t64.q();
            s64.b();
        }
    }

    public final void l1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.q = 0L;
        }
    }

    @Override // com.baidu.tieba.dh2
    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.s0();
            e04.m().h(this.b);
        }
    }

    @Override // com.baidu.tieba.dh2
    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            rp2.U().registerReceiver(this.b);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f04(SwanAppActivity swanAppActivity, String str) {
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

    @Override // com.baidu.tieba.dh2
    public void G0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && z) {
            xa3.E();
            if (z2) {
                b54.f(Z());
                sx3.b();
            }
        }
    }

    public final void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            l1();
            if (!d43.K().E()) {
                return;
            }
            rp2.U().E(Z(), new a(this));
            if (e04.m().v() && e04.m().q()) {
                e04.m().F(this.b);
            }
        }
    }

    @Override // com.baidu.tieba.dh2
    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            rx3.v();
            jg2.i();
            b54.e(AccountRestoreActivity.JS_PROMPT_ACCOUNT_METHOD_EXIT, Z());
            rp2.U().unregisterReceiver(this.b);
            rp2.b0();
            k64.a().b();
            SwanInspectorEndpoint.v().q();
            v44.c().b();
            s24.b().e();
        }
    }

    @Override // com.baidu.tieba.dh2
    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            e12.i("SwanApp", "onBackPressed back stack count:" + this.c.k());
            hb3 hb3Var = new hb3();
            hb3Var.e = "back";
            Q(hb3Var);
            k32 m = this.c.m();
            if (m != null && m.I()) {
                return;
            }
            if (e0()) {
                e43 M = e43.M();
                if (M != null) {
                    M.P().E();
                }
                b54.e("back", Z());
                sx3.g("0");
                return;
            }
            n32.b i = this.c.i("navigateBack");
            i.n(n32.i, n32.h);
            i.g();
            i.a();
        }
    }

    public final void m1() {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || !q().I()) {
            return;
        }
        if (th3.f(Z().a0())) {
            if (r) {
                Log.d("SwanGameFrame", "release SwanGameCoreRuntime minSwanVersion:" + Z().a0());
            }
            e04.C();
            return;
        }
        SwanCoreVersion j0 = Z().j0();
        if (j0 != null && th3.f(j0.swanCoreVersionName) && ap2.a(Z().S())) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (r) {
                Log.d("SwanGameFrame", "SwanGameCoreRuntime版本过低释放并重新加载");
            }
            e04.C();
        }
    }

    @Override // com.baidu.tieba.dh2
    public void m0() {
        String K;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            m1();
            v44.c().b();
            s24.b().e();
            q().J(true);
            e1();
            if (Z() == null) {
                K = "";
            } else {
                K = Z().K();
            }
            V8Engine.setCrashKeyValue("game_title", K);
        }
    }
}
