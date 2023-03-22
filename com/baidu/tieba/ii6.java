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
/* loaded from: classes4.dex */
public final class ii6 extends d0 {
    public static /* synthetic */ Interceptable $ic;
    public static final a m;
    public transient /* synthetic */ FieldHolder $fh;
    public final hi6 j;
    public final fk6 k;
    public long l;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947854515, "Lcom/baidu/tieba/ii6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947854515, "Lcom/baidu/tieba/ii6;");
                return;
            }
        }
        m = new a(null);
    }

    /* loaded from: classes4.dex */
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

        public static /* synthetic */ ii6 c(a aVar, yj6 yj6Var, qj6 qj6Var, int i, Object obj) {
            if ((i & 2) != 0) {
                qj6Var = aVar.a();
            }
            return aVar.b(yj6Var, qj6Var);
        }

        public final uj6 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new uj6(new rj6(), TuplesKt.to(5, new sj6()), TuplesKt.to(1, new tj6()), TuplesKt.to(4, new pj6()));
            }
            return (uj6) invokeV.objValue;
        }

        public final ii6 b(yj6 renderer, qj6 layouter) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, renderer, layouter)) == null) {
                Intrinsics.checkNotNullParameter(renderer, "renderer");
                Intrinsics.checkNotNullParameter(layouter, "layouter");
                return new ii6(renderer, layouter);
            }
            return (ii6) invokeLL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ii6(yj6 renderer, qj6 layouter) {
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
        hi6 hi6Var = new hi6(renderer);
        this.j = hi6Var;
        this.k = hi6Var.f();
        gj6 gj6Var = new gj6(this.j);
        gj6Var.a = 1;
        g(gj6Var);
        DataSystem dataSystem = new DataSystem(this.j);
        dataSystem.a = 2;
        g(dataSystem);
        ij6 ij6Var = new ij6(this.j);
        ij6Var.a = 3;
        g(ij6Var);
        ej6 ej6Var = new ej6(this.j);
        ej6Var.a = 4;
        g(ej6Var);
        RenderSystem renderSystem = new RenderSystem(this.j);
        renderSystem.a = 5;
        g(renderSystem);
        ij6 ij6Var2 = (ij6) k(ij6.class);
        if (ij6Var2 != null) {
            ij6Var2.o(layouter);
        }
    }

    public static /* synthetic */ void E(ii6 ii6Var, Float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = null;
        }
        ii6Var.D(f);
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.k.d(true);
            i0<a0> systems = l();
            Intrinsics.checkNotNullExpressionValue(systems, "systems");
            for (a0 a0Var : systems) {
                p(a0Var);
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            fk6.f(this.k, 0L, 0.0f, 3, null);
            this.k.d(false);
        }
    }

    public final wh6 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            gj6 gj6Var = (gj6) k(gj6.class);
            if (gj6Var != null) {
                return gj6Var.k();
            }
            return null;
        }
        return (wh6) invokeV.objValue;
    }

    public final hi6 u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.j;
        }
        return (hi6) invokeV.objValue;
    }

    public final long v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.k.a();
        }
        return invokeV.longValue;
    }

    public final fk6 w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.k;
        }
        return (fk6) invokeV.objValue;
    }

    public final boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.k.c();
        }
        return invokeV.booleanValue;
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.k.d(true);
        }
    }

    public final void z() {
        DataSystem dataSystem;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (dataSystem = (DataSystem) k(DataSystem.class)) != null) {
            dataSystem.D();
        }
    }

    public final void B(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            fk6.f(this.k, j, 0.0f, 2, null);
            this.j.c().J();
            this.j.c().I();
            this.j.c().F();
        }
    }

    public final void D(Float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, f) == null) {
            nj6.b("Engine_step");
            this.k.g(f);
            nj6.a();
        }
    }

    public final void F(wh6 danmakuConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, danmakuConfig) == null) {
            Intrinsics.checkNotNullParameter(danmakuConfig, "danmakuConfig");
            gj6 gj6Var = (gj6) k(gj6.class);
            if (gj6Var != null) {
                gj6Var.m(danmakuConfig);
            }
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            nj6.b("act");
            long elapsedRealtime = SystemClock.elapsedRealtime();
            fk6 fk6Var = this.k;
            long a2 = fk6Var.a() - this.l;
            update(fk6Var.b());
            long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
            if (elapsedRealtime2 >= 20) {
                BdLog.w("DanmakuEngine [Engine][ACT] overload act: interval: " + a2 + ", cost: " + elapsedRealtime2);
            }
            this.l = fk6Var.a();
            nj6.a();
        }
    }

    public final void s(Canvas canvas, Function0<Unit> onRenderReady) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, canvas, onRenderReady) == null) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(onRenderReady, "onRenderReady");
            RenderSystem renderSystem = (RenderSystem) k(RenderSystem.class);
            if (renderSystem != null) {
                renderSystem.k(canvas, onRenderReady);
            }
        }
    }
}
