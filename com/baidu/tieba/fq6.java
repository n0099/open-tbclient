package com.baidu.tieba;

import android.graphics.Canvas;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.danmu.ecs.system.DataSystem;
import com.baidu.tieba.danmu.ecs.system.RenderSystem;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class fq6 extends n0 {
    public static /* synthetic */ Interceptable $ic;
    public static final a m;
    public transient /* synthetic */ FieldHolder $fh;
    public final eq6 j;
    public final cs6 k;
    public long l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947772830, "Lcom/baidu/tieba/fq6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947772830, "Lcom/baidu/tieba/fq6;");
                return;
            }
        }
        m = new a(null);
    }

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
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

        public static /* synthetic */ fq6 c(a aVar, vr6 vr6Var, nr6 nr6Var, int i, Object obj) {
            if ((i & 2) != 0) {
                nr6Var = aVar.a();
            }
            return aVar.b(vr6Var, nr6Var);
        }

        public final rr6 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new rr6(new or6(), TuplesKt.to(5, new pr6()), TuplesKt.to(1, new qr6()), TuplesKt.to(4, new mr6()));
            }
            return (rr6) invokeV.objValue;
        }

        public final fq6 b(vr6 renderer, nr6 layouter) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, renderer, layouter)) == null) {
                Intrinsics.checkNotNullParameter(renderer, "renderer");
                Intrinsics.checkNotNullParameter(layouter, "layouter");
                return new fq6(renderer, layouter);
            }
            return (fq6) invokeLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fq6(vr6 renderer, nr6 layouter) {
        super(200, 1000, 200, 1500);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {renderer, layouter};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(renderer, "renderer");
        Intrinsics.checkNotNullParameter(layouter, "layouter");
        eq6 eq6Var = new eq6(renderer);
        this.j = eq6Var;
        this.k = eq6Var.f();
        dr6 dr6Var = new dr6(this.j);
        dr6Var.a = 1;
        g(dr6Var);
        DataSystem dataSystem = new DataSystem(this.j);
        dataSystem.a = 2;
        g(dataSystem);
        fr6 fr6Var = new fr6(this.j);
        fr6Var.a = 3;
        g(fr6Var);
        br6 br6Var = new br6(this.j);
        br6Var.a = 4;
        g(br6Var);
        RenderSystem renderSystem = new RenderSystem(this.j);
        renderSystem.a = 5;
        g(renderSystem);
        fr6 fr6Var2 = (fr6) k(fr6.class);
        if (fr6Var2 != null) {
            fr6Var2.p(layouter);
        }
    }

    public static /* synthetic */ void F(fq6 fq6Var, Float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = null;
        }
        fq6Var.E(f);
    }

    public final void A() {
        DataSystem dataSystem;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (dataSystem = (DataSystem) k(DataSystem.class)) != null) {
            dataSystem.E();
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            cs6.f(this.k, 0L, 0.0f, 3, null);
            this.k.d(false);
        }
    }

    public final tp6 u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            dr6 dr6Var = (dr6) k(dr6.class);
            if (dr6Var != null) {
                return dr6Var.l();
            }
            return null;
        }
        return (tp6) invokeV.objValue;
    }

    public final eq6 v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.j;
        }
        return (eq6) invokeV.objValue;
    }

    public final long w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.k.a();
        }
        return invokeV.longValue;
    }

    public final cs6 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.k;
        }
        return (cs6) invokeV.objValue;
    }

    public final boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.k.c();
        }
        return invokeV.booleanValue;
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.k.d(true);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.k.d(true);
            s0<k0> systems = l();
            Intrinsics.checkNotNullExpressionValue(systems, "systems");
            for (k0 k0Var : systems) {
                p(k0Var);
            }
        }
    }

    public final void C(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            cs6.f(this.k, j, 0.0f, 2, null);
            this.j.c().J();
            this.j.c().I();
            this.j.c().F();
        }
    }

    public final void E(Float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, f) == null) {
            kr6.b("Engine_step");
            this.k.g(f);
            kr6.a();
        }
    }

    public final void G(tp6 danmakuConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, danmakuConfig) == null) {
            Intrinsics.checkNotNullParameter(danmakuConfig, "danmakuConfig");
            dr6 dr6Var = (dr6) k(dr6.class);
            if (dr6Var != null) {
                dr6Var.n(danmakuConfig);
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            kr6.b("act");
            long elapsedRealtime = SystemClock.elapsedRealtime();
            cs6 cs6Var = this.k;
            long a2 = cs6Var.a() - this.l;
            q(cs6Var.b());
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            if (elapsedRealtime2 >= 20) {
                BdLog.w("DanmakuEngine [Engine][ACT] overload act: interval: " + a2 + ", cost: " + elapsedRealtime2);
            }
            this.l = cs6Var.a();
            kr6.a();
        }
    }

    public final void t(Canvas canvas, Function0<Unit> onRenderReady) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, canvas, onRenderReady) == null) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(onRenderReady, "onRenderReady");
            RenderSystem renderSystem = (RenderSystem) k(RenderSystem.class);
            if (renderSystem != null) {
                renderSystem.l(canvas, onRenderReady);
            }
        }
    }
}
