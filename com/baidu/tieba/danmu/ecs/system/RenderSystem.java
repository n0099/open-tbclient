package com.baidu.tieba.danmu.ecs.system;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.MainThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.tieba.at6;
import com.baidu.tieba.av6;
import com.baidu.tieba.danmu.data.ItemState;
import com.baidu.tieba.danmu.data.state.DrawState;
import com.baidu.tieba.dt6;
import com.baidu.tieba.dv6;
import com.baidu.tieba.ev6;
import com.baidu.tieba.g0;
import com.baidu.tieba.it6;
import com.baidu.tieba.iv6;
import com.baidu.tieba.jv6;
import com.baidu.tieba.kv6;
import com.baidu.tieba.lt6;
import com.baidu.tieba.mu6;
import com.baidu.tieba.nu6;
import com.baidu.tieba.ot6;
import com.baidu.tieba.ou6;
import com.baidu.tieba.pt6;
import com.baidu.tieba.q0;
import com.baidu.tieba.r7;
import com.baidu.tieba.st6;
import com.baidu.tieba.xs6;
import com.baidu.tieba.zs6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt___SequencesKt;
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0000\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0003KLMB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001e\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\f\u00102\u001a\b\u0012\u0004\u0012\u00020/03H\u0007J(\u00104\u001a\u0002052\u0006\u00100\u001a\u0002012\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0002J\u0016\u0010<\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010=2\u0006\u0010?\u001a\u00020@J\u0016\u0010<\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010=2\u0006\u0010A\u001a\u00020BJ\u0010\u0010C\u001a\u0002052\u0006\u0010D\u001a\u00020EH\u0016J\b\u0010F\u001a\u00020/H\u0016J\b\u0010G\u001a\u00020/H\u0002J\u0010\u0010H\u001a\u00020/2\u0006\u0010I\u001a\u00020JH\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R?\u0010\u0015\u001a&\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00170\u0017 \u0018*\u0012\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00170\u0017\u0018\u00010\u00160\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010*\u001a\u00060+R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/baidu/tieba/danmu/ecs/system/RenderSystem;", "Lcom/baidu/tieba/danmu/ecs/base/DanmakuEntitySystem;", "Landroid/os/Handler$Callback;", "context", "Lcom/baidu/tieba/danmu/ecs/DanmakuContext;", "(Lcom/baidu/tieba/danmu/ecs/DanmakuContext;)V", "cacheHit", "Lcom/baidu/tieba/danmu/utils/Fraction;", "getCacheHit", "()Lcom/baidu/tieba/danmu/utils/Fraction;", "setCacheHit", "(Lcom/baidu/tieba/danmu/utils/Fraction;)V", "callbackHandler", "Landroid/os/Handler;", "debugPaint", "Landroid/graphics/Paint;", "getDebugPaint", "()Landroid/graphics/Paint;", "debugPaint$delegate", "Lkotlin/Lazy;", "drawPaint", "entities", "Lcom/badlogic/ashley/utils/ImmutableArray;", "Lcom/badlogic/ashley/core/Entity;", "kotlin.jvm.PlatformType", "getEntities", "()Lcom/badlogic/ashley/utils/ImmutableArray;", "entities$delegate", "lastAllGeneration", "", "lastDrawTime", "", "lastRenderGeneration", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/baidu/tieba/danmu/ui/DanmakuListener;", "getListener$danmu_release", "()Lcom/baidu/tieba/danmu/ui/DanmakuListener;", "setListener$danmu_release", "(Lcom/baidu/tieba/danmu/ui/DanmakuListener;)V", "pendingDiscardResults", "", "Lcom/baidu/tieba/danmu/ecs/system/RenderSystem$RenderResult;", "renderObjectPool", "Lcom/baidu/tieba/danmu/ecs/system/RenderSystem$RenderObjectPool;", "renderResult", "resultGeneration", "draw", "", "canvas", "Landroid/graphics/Canvas;", "onRenderReady", "Lkotlin/Function0;", "drawRenderObject", "", "obj", "Lcom/baidu/tieba/danmu/render/RenderObject;", "displayer", "Lcom/baidu/tieba/danmu/ui/DanmakuDisplayer;", "config", "Lcom/baidu/tieba/danmu/DanmakuConfig;", "getDanmakus", "", "Lcom/baidu/tieba/danmu/data/DanmakuItem;", Config.EVENT_HEAT_POINT, "Landroid/graphics/Point;", "rect", "Landroid/graphics/RectF;", "handleMessage", "msg", "Landroid/os/Message;", "release", "releaseDiscardResults", StickerDataChangeType.UPDATE, "deltaTime", "", "Companion", "RenderObjectPool", "RenderResult", "danmu_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RenderSystem extends lt6 implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy e;
    public final a f;
    public List<b> g;
    public int h;
    public b i;
    public final Paint j;
    public final Handler k;
    public int l;
    public ev6 m;
    public jv6 n;
    public int o;
    public final Lazy p;
    public long q;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-204789420, "Lcom/baidu/tieba/danmu/ecs/system/RenderSystem;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-204789420, "Lcom/baidu/tieba/danmu/ecs/system/RenderSystem;");
        }
    }

    /* loaded from: classes5.dex */
    public final class a extends r7<av6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RenderSystem renderSystem, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {renderSystem, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.r7
        /* renamed from: g */
        public av6 d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return new av6(dt6.i.a(), zs6.f.a(), kv6.a.b(), kv6.a.c(), new Matrix());
            }
            return (av6) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.r7
        /* renamed from: h */
        public void f(av6 av6Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048579, this, av6Var) != null) || av6Var == null) {
                return;
            }
            if (!Intrinsics.areEqual(av6Var.b(), zs6.f.a())) {
                av6Var.b().d();
            }
            av6Var.k(dt6.i.a());
            av6Var.i(zs6.f.a());
            av6Var.f().setEmpty();
            av6Var.e().set(0.0f, 0.0f);
            av6Var.g().reset();
            av6Var.h(1.0f);
            av6Var.j(false);
        }
    }

    /* loaded from: classes5.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<av6> a;
        public final int b;
        public final int c;

        public b(List<av6> renderObjects, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {renderObjects, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(renderObjects, "renderObjects");
            this.a = renderObjects;
            this.b = i;
            this.c = i2;
        }

        public final int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.b;
            }
            return invokeV.intValue;
        }

        public final List<av6> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.a;
            }
            return (List) invokeV.objValue;
        }

        public final int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.c;
            }
            return invokeV.intValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RenderSystem(it6 context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((it6) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.e = LazyKt__LazyJVMKt.lazy(new Function0<q0<g0>>(this) { // from class: com.baidu.tieba.danmu.ecs.system.RenderSystem$entities$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ RenderSystem this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final q0<g0> invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return this.this$0.f().j(iv6.a.c());
                }
                return (q0) invokeV.objValue;
            }
        });
        a aVar = new a(this, 200, 500);
        aVar.b(200);
        this.f = aVar;
        this.g = new ArrayList();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        this.j = paint;
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.k = new Handler(myLooper, this);
            this.n = new jv6(1, 1);
            this.o = -1;
            this.p = LazyKt__LazyJVMKt.lazy(RenderSystem$debugPaint$2.INSTANCE);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg) {
        InterceptResult invokeL;
        dt6 dt6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, msg)) == null) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            ev6 ev6Var = this.m;
            if (ev6Var != null && msg.what == 1) {
                Object obj = msg.obj;
                if (obj instanceof dt6) {
                    dt6Var = (dt6) obj;
                } else {
                    dt6Var = null;
                }
                if (dt6Var == null) {
                    return false;
                }
                ev6Var.a(dt6Var);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void q(ev6 ev6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ev6Var) == null) {
            this.m = ev6Var;
        }
    }

    @Override // com.baidu.tieba.lt6
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b bVar = this.i;
            if (bVar != null) {
                this.g.add(bVar);
            }
            this.i = null;
            p();
        }
    }

    public final Paint n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return (Paint) this.p.getValue();
        }
        return (Paint) invokeV.objValue;
    }

    public final q0<g0> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return (q0) this.e.getValue();
        }
        return (q0) invokeV.objValue;
    }

    @MainThread
    public final void k(Canvas canvas, Function0<Unit> onRenderReady) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, canvas, onRenderReady) == null) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(onRenderReady, "onRenderReady");
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = elapsedRealtime - this.q;
            b bVar = this.i;
            ou6.b("notify_monitor");
            onRenderReady.invoke();
            ou6.a();
            xs6 c = i().c();
            if (c.w() && bVar != null && bVar.c() == c.x()) {
                if (bVar.b().isEmpty()) {
                    this.o = bVar.a();
                    return;
                }
                ou6.b("RenderSystem_draw");
                int a2 = bVar.a();
                int i = (a2 - this.o) - 1;
                if (!mu6.e(this)) {
                    if (i > 0) {
                        BdLog.w("DanmakuEngine [Engine] skipped " + i + " frames results");
                    } else if (a2 == this.o && !mu6.e(this)) {
                        BdLog.w("DanmakuEngine [Engine] render same frame");
                    }
                }
                this.o = a2;
                int i2 = 0;
                av6 av6Var = null;
                try {
                    dv6 c2 = mu6.c(this);
                    for (av6 av6Var2 : bVar.b()) {
                        Paint n = n();
                        if (n != null) {
                            canvas.drawRect(av6Var2.f(), n);
                        }
                        if (av6Var2.c()) {
                            av6Var = av6Var2;
                        } else {
                            this.j.setAlpha((int) (c.f() * av6Var2.a() * 255));
                            if (l(canvas, av6Var2, c2, c)) {
                                i2++;
                            }
                        }
                    }
                    if (av6Var != null) {
                        this.j.setAlpha(255);
                        if (l(canvas, av6Var, c2, c)) {
                            i2++;
                        }
                    }
                } catch (Exception unused) {
                    BdLog.e("DanmakuEngine [Exception] onDraw");
                }
                long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                if (!mu6.e(this) && elapsedRealtime2 > 20) {
                    BdLog.w("DanmakuEngine[RenderSystem][DRAW] OVERLOAD! interval: " + j + ", cost: " + elapsedRealtime2);
                }
                this.q = elapsedRealtime;
                this.n.b(i2);
                this.n.a(bVar.b().size());
                ou6.a();
            }
        }
    }

    public final boolean l(Canvas canvas, av6 av6Var, dv6 dv6Var, xs6 xs6Var) {
        InterceptResult invokeLLLL;
        at6 g;
        Bitmap c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, canvas, av6Var, dv6Var, xs6Var)) == null) {
            if (Intrinsics.areEqual(av6Var.b(), zs6.f.a()) || av6Var.b().g() == null || av6Var.d().f().b() != xs6Var.h() || av6Var.d().i().compareTo(ItemState.Rendered) < 0 || (g = av6Var.b().g()) == null || (c = g.c()) == null || c.isRecycled()) {
                return false;
            }
            canvas.drawBitmap(c, av6Var.g(), this.j);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final List<dt6> m(final RectF rect) {
        InterceptResult invokeL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, rect)) == null) {
            Intrinsics.checkNotNullParameter(rect, "rect");
            if (!i().c().w() || (bVar = this.i) == null) {
                return null;
            }
            return SequencesKt___SequencesKt.toList(SequencesKt___SequencesKt.map(SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(bVar.b()), new Function1<av6, Boolean>(rect) { // from class: com.baidu.tieba.danmu.ecs.system.RenderSystem$getDanmakus$3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ RectF $rect;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {rect};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Integer) newInitContext.callArgs[0]).intValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.$rect = rect;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(av6 it) {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, it)) == null) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        RectF f = it.f();
                        RectF rectF = this.$rect;
                        return Boolean.valueOf(f.intersects(rectF.left, rectF.top, rectF.right, rectF.bottom));
                    }
                    return (Boolean) invokeL2.objValue;
                }
            }), RenderSystem$getDanmakus$4.INSTANCE));
        }
        return (List) invokeL.objValue;
    }

    public final void p() {
        List<b> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            synchronized (this) {
                list = CollectionsKt___CollectionsKt.toList(this.g);
                this.g.clear();
            }
            for (b bVar : list) {
                List<av6> b2 = bVar.b();
                a aVar = this.f;
                for (av6 av6Var : b2) {
                    aVar.c(av6Var);
                }
            }
        }
    }

    @Override // com.baidu.tieba.i0
    public void update(float f) {
        av6 av6Var;
        dt6 a2;
        dt6 a3;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f) == null) {
            xs6 c = i().c();
            if (mu6.e(this) && c.d() == this.h) {
                return;
            }
            if (mu6.e(this)) {
                BdLog.d("DanmakuEngine [Render] update on pause");
            }
            ou6.b("RenderSystem_update");
            this.h = c.d();
            p();
            q0<g0> entities = o();
            Intrinsics.checkNotNullExpressionValue(entities, "entities");
            ArrayList<g0> arrayList = new ArrayList();
            Iterator<g0> it = entities.iterator();
            while (true) {
                boolean z2 = true;
                if (!it.hasNext()) {
                    break;
                }
                g0 next = it.next();
                g0 entity = next;
                Intrinsics.checkNotNullExpressionValue(entity, "entity");
                pt6 b2 = nu6.b(entity);
                boolean z3 = false;
                if (b2 != null && (a3 = b2.a()) != null) {
                    DrawState f2 = a3.f();
                    ot6 d = nu6.d(entity);
                    if (d != null && !d.d()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    z3 = (z && a3.i().compareTo(ItemState.Measured) >= 0 && f2.p() && f2.f() == c.p() && f2.e() == c.o()) ? false : false;
                }
                if (z3) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = new ArrayList(o().size());
            for (g0 entity2 : arrayList) {
                Intrinsics.checkNotNullExpressionValue(entity2, "entity");
                pt6 b3 = nu6.b(entity2);
                if (b3 != null && (a2 = b3.a()) != null) {
                    DrawState f3 = a2.f();
                    zs6 c2 = a2.f().c();
                    st6 a4 = nu6.a(entity2);
                    if (this.m != null && a2.h() != c.m()) {
                        a2.o(c.m());
                        this.k.obtainMessage(1, a2).sendToTarget();
                    }
                    av6Var = this.f.e();
                    c2.l();
                    av6Var.k(a2);
                    av6Var.i(c2);
                    av6Var.g().reset();
                    if (a4 != null) {
                        av6Var.e().set(a4.f());
                        av6Var.f().setEmpty();
                        a4.i(av6Var.g());
                        av6Var.h(a4.e());
                        av6Var.g().postConcat(f3.m());
                    } else {
                        av6Var.g().set(f3.m());
                    }
                    av6Var.e().set(f3.g(), f3.h());
                    av6Var.f().set(f3.i());
                    if (a2.k()) {
                        av6Var.h(1.0f);
                        av6Var.j(true);
                    }
                } else {
                    av6Var = null;
                }
                if (av6Var != null) {
                    arrayList2.add(av6Var);
                }
            }
            synchronized (this) {
                b bVar = this.i;
                if (bVar != null) {
                    this.g.add(bVar);
                }
                int i = this.l;
                this.l = i + 1;
                this.i = new b(arrayList2, i, c.x());
                Unit unit = Unit.INSTANCE;
            }
            ou6.a();
        }
    }
}
