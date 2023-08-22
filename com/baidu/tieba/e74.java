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
import com.baidu.tieba.ma2;
import com.baidu.tieba.t74;
import com.baidu.tieba.y73;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class e74 extends co2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean r;
    public transient /* synthetic */ FieldHolder $fh;
    public long q;

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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return 1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.co2
    public void u0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    @Override // com.baidu.tieba.co2
    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
        }
    }

    @Override // com.baidu.tieba.co2
    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements xt2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e74 a;

        public a(e74 e74Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e74Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e74Var;
        }

        @Override // com.baidu.tieba.xt2
        public void a(int i, wt2 wt2Var) {
            t74.c cVar;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeIL(1048576, this, i, wt2Var) == null) && (cVar = (t74.c) wt2Var) != null && !TextUtils.isEmpty(cVar.a)) {
                d74.m().I(this.a.Z());
                d74.m().x(cVar);
                g54.h();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements y73.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e74 a;

        public b(e74 e74Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e74Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e74Var;
        }

        @Override // com.baidu.tieba.y73.c
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
                                            jn3.r(message);
                                            return true;
                                        case 124:
                                            jn3.q(message);
                                            return true;
                                        case 125:
                                            w73.b(message);
                                            return true;
                                        case 126:
                                            w73.d(message);
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
                        d74.m().H();
                        r44.b();
                        return true;
                    }
                    boolean a = ku2.M().a();
                    ku2.M().d(a);
                    if (this.a.b != null) {
                        this.a.b.y(a, false);
                    }
                    return true;
                }
                t73.e().h(new v73(4));
                this.a.Q0();
                d74.m().H();
                cb3.K().s();
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e74 a;

        public c(e74 e74Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e74Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e74Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (e74.r) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager onFirstFrameFinished");
                }
                this.a.q = System.currentTimeMillis();
                ac4.f(this.a.Z());
                this.a.b.O();
                i43.h("preload", "startup");
                int j = d74.m().j();
                HybridUbcFlow p = i43.p("startup");
                p.I(HybridUbcFlow.SubmitStrategy.NA_ONLY);
                p.D("codecache", String.valueOf(j));
                p.F(new UbcFlowEvent("na_first_paint"));
                p.A();
                long f = p.f("na_first_paint", "naStart");
                d74.m().i(new d94(f));
                if (e74.r) {
                    Log.d("SwanGameFrame", "SwanGameCoreRuntime SwanGamePreloadManager 小游戏启动时长: " + f);
                }
                qd4.A().D();
                u74.f().init();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e74 a;

        public d(e74 e74Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e74Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e74Var;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947687239, "Lcom/baidu/tieba/e74;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947687239, "Lcom/baidu/tieba/e74;");
                return;
            }
        }
        r = nr1.a;
    }

    @Override // com.baidu.tieba.co2
    @NonNull
    public y73.c b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return new b(this);
        }
        return (y73.c) invokeV.objValue;
    }

    public long f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.q;
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.tieba.co2
    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (cb3.K().q().Y().d0() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public li2 g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return d74.m().n();
        }
        return (li2) invokeV.objValue;
    }

    public final void h1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            qd4.A().m();
        }
    }

    public final void i1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            qd4.A().F();
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
            xo3.e0(new c(this));
            ExecutorUtilsExt.postOnElastic(new d(this), "SwanGameFrameRequestAd", 2);
            sd4.q();
            rd4.b();
        }
    }

    public final void l1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.q = 0L;
        }
    }

    @Override // com.baidu.tieba.co2
    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.s0();
            d74.m().h(this.b);
        }
    }

    @Override // com.baidu.tieba.co2
    public void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            qw2.T().registerReceiver(this.b);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e74(SwanAppActivity swanAppActivity, String str) {
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
    public void G0(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && z) {
            wh3.E();
            if (z2) {
                ac4.f(Z());
                r44.b();
            }
        }
    }

    public final void e1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            l1();
            if (!cb3.K().E()) {
                return;
            }
            qw2.T().E(Z(), new a(this));
            if (d74.m().v() && d74.m().q()) {
                d74.m().F(this.b);
            }
        }
    }

    @Override // com.baidu.tieba.co2
    public void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            q44.v();
            in2.i();
            ac4.e("exit", Z());
            qw2.T().unregisterReceiver(this.b);
            qw2.a0();
            jd4.a().b();
            SwanInspectorEndpoint.v().q();
            ub4.c().b();
            r94.b().e();
        }
    }

    @Override // com.baidu.tieba.co2
    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            d82.i("SwanApp", "onBackPressed back stack count:" + this.c.k());
            gi3 gi3Var = new gi3();
            gi3Var.e = "back";
            Q(gi3Var);
            ja2 m = this.c.m();
            if (m != null && m.H()) {
                return;
            }
            if (e0()) {
                db3 M = db3.M();
                if (M != null) {
                    M.P().E();
                }
                ac4.e("back", Z());
                r44.g("0");
                return;
            }
            ma2.b i = this.c.i("navigateBack");
            i.n(ma2.i, ma2.h);
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
        if (so3.f(Z().a0())) {
            if (r) {
                Log.d("SwanGameFrame", "release SwanGameCoreRuntime minSwanVersion:" + Z().a0());
            }
            d74.C();
            return;
        }
        SwanCoreVersion j0 = Z().j0();
        if (j0 != null && so3.f(j0.swanCoreVersionName) && zv2.a(Z().S())) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (r) {
                Log.d("SwanGameFrame", "SwanGameCoreRuntime版本过低释放并重新加载");
            }
            d74.C();
        }
    }

    @Override // com.baidu.tieba.co2
    public void m0() {
        String K;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            m1();
            ub4.c().b();
            r94.b().e();
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
