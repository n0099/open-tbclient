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
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.tieba.a8;
import com.baidu.tieba.c56;
import com.baidu.tieba.d76;
import com.baidu.tieba.danmu.data.ItemState;
import com.baidu.tieba.danmu.data.state.DrawState;
import com.baidu.tieba.e76;
import com.baidu.tieba.f56;
import com.baidu.tieba.g66;
import com.baidu.tieba.h66;
import com.baidu.tieba.i56;
import com.baidu.tieba.i66;
import com.baidu.tieba.j56;
import com.baidu.tieba.m56;
import com.baidu.tieba.p0;
import com.baidu.tieba.r46;
import com.baidu.tieba.t46;
import com.baidu.tieba.u46;
import com.baidu.tieba.u66;
import com.baidu.tieba.x46;
import com.baidu.tieba.x66;
import com.baidu.tieba.y66;
import com.baidu.tieba.z0;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt___SequencesKt;
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0000\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0003KLMB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001e\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\f\u00102\u001a\b\u0012\u0004\u0012\u00020/03H\u0007J(\u00104\u001a\u0002052\u0006\u00100\u001a\u0002012\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0002J\u0016\u0010<\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010=2\u0006\u0010?\u001a\u00020@J\u0016\u0010<\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010=2\u0006\u0010A\u001a\u00020BJ\u0010\u0010C\u001a\u0002052\u0006\u0010D\u001a\u00020EH\u0016J\b\u0010F\u001a\u00020/H\u0016J\b\u0010G\u001a\u00020/H\u0002J\u0010\u0010H\u001a\u00020/2\u0006\u0010I\u001a\u00020JH\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R?\u0010\u0015\u001a&\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00170\u0017 \u0018*\u0012\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00170\u0017\u0018\u00010\u00160\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010*\u001a\u00060+R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/baidu/tieba/danmu/ecs/system/RenderSystem;", "Lcom/baidu/tieba/danmu/ecs/base/DanmakuEntitySystem;", "Landroid/os/Handler$Callback;", "context", "Lcom/baidu/tieba/danmu/ecs/DanmakuContext;", "(Lcom/baidu/tieba/danmu/ecs/DanmakuContext;)V", "cacheHit", "Lcom/baidu/tieba/danmu/utils/Fraction;", "getCacheHit", "()Lcom/baidu/tieba/danmu/utils/Fraction;", "setCacheHit", "(Lcom/baidu/tieba/danmu/utils/Fraction;)V", "callbackHandler", "Landroid/os/Handler;", "debugPaint", "Landroid/graphics/Paint;", "getDebugPaint", "()Landroid/graphics/Paint;", "debugPaint$delegate", "Lkotlin/Lazy;", "drawPaint", "entities", "Lcom/badlogic/ashley/utils/ImmutableArray;", "Lcom/badlogic/ashley/core/Entity;", "kotlin.jvm.PlatformType", "getEntities", "()Lcom/badlogic/ashley/utils/ImmutableArray;", "entities$delegate", "lastAllGeneration", "", "lastDrawTime", "", "lastRenderGeneration", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/baidu/tieba/danmu/ui/DanmakuListener;", "getListener$danmu_release", "()Lcom/baidu/tieba/danmu/ui/DanmakuListener;", "setListener$danmu_release", "(Lcom/baidu/tieba/danmu/ui/DanmakuListener;)V", "pendingDiscardResults", "", "Lcom/baidu/tieba/danmu/ecs/system/RenderSystem$RenderResult;", "renderObjectPool", "Lcom/baidu/tieba/danmu/ecs/system/RenderSystem$RenderObjectPool;", "renderResult", "resultGeneration", "draw", "", "canvas", "Landroid/graphics/Canvas;", "onRenderReady", "Lkotlin/Function0;", "drawRenderObject", "", "obj", "Lcom/baidu/tieba/danmu/render/RenderObject;", "displayer", "Lcom/baidu/tieba/danmu/ui/DanmakuDisplayer;", "config", "Lcom/baidu/tieba/danmu/DanmakuConfig;", "getDanmakus", "", "Lcom/baidu/tieba/danmu/data/DanmakuItem;", Config.EVENT_HEAT_POINT, "Landroid/graphics/Point;", "rect", "Landroid/graphics/RectF;", "handleMessage", "msg", "Landroid/os/Message;", "release", "releaseDiscardResults", "update", "deltaTime", "", "Companion", "RenderObjectPool", "RenderResult", "danmu_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class RenderSystem extends f56 implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy e;
    public final a f;
    public List g;
    public int h;
    public b i;
    public final Paint j;
    public final Handler k;
    public int l;
    public y66 m;
    public d76 n;
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

    /* loaded from: classes3.dex */
    public final class a extends a8 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RenderSystem this$0, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {this$0, Integer.valueOf(i), Integer.valueOf(i2)};
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
            Intrinsics.checkNotNullParameter(this$0, "this$0");
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a8
        /* renamed from: g */
        public u66 d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return new u66(x46.i.a(), t46.f.a(), e76.a.b(), e76.a.c(), new Matrix());
            }
            return (u66) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.a8
        /* renamed from: h */
        public void f(u66 u66Var) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048579, this, u66Var) != null) || u66Var == null) {
                return;
            }
            if (!Intrinsics.areEqual(u66Var.b(), t46.f.a())) {
                u66Var.b().d();
            }
            u66Var.k(x46.i.a());
            u66Var.i(t46.f.a());
            u66Var.f().setEmpty();
            u66Var.e().set(0.0f, 0.0f);
            u66Var.g().reset();
            u66Var.h(1.0f);
            u66Var.j(false);
        }
    }

    /* loaded from: classes3.dex */
    public final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List a;
        public final int b;
        public final int c;

        public b(List renderObjects, int i, int i2) {
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

        public final List b() {
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
    public RenderSystem(c56 context) {
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
                super((c56) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.e = LazyKt__LazyJVMKt.lazy(new RenderSystem$entities$2(this));
        a aVar = new a(this, 200, 500);
        aVar.b(200);
        Unit unit = Unit.INSTANCE;
        this.f = aVar;
        this.g = new ArrayList();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Unit unit2 = Unit.INSTANCE;
        this.j = paint;
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.k = new Handler(myLooper, this);
            this.n = new d76(1, 1);
            this.o = -1;
            this.p = LazyKt__LazyJVMKt.lazy(RenderSystem$debugPaint$2.INSTANCE);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg) {
        InterceptResult invokeL;
        x46 x46Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, msg)) == null) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            y66 y66Var = this.m;
            if (y66Var != null && msg.what == 1) {
                Object obj = msg.obj;
                if (obj instanceof x46) {
                    x46Var = (x46) obj;
                } else {
                    x46Var = null;
                }
                if (x46Var == null) {
                    return false;
                }
                y66Var.a(x46Var);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void r(y66 y66Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, y66Var) == null) {
            this.m = y66Var;
        }
    }

    @Override // com.baidu.tieba.f56
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b bVar = this.i;
            if (bVar != null) {
                this.g.add(bVar);
            }
            this.i = null;
            q();
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

    public final z0 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return (z0) this.e.getValue();
        }
        return (z0) invokeV.objValue;
    }

    public final y66 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.m;
        }
        return (y66) invokeV.objValue;
    }

    public final void k(Canvas canvas, Function0 onRenderReady) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, canvas, onRenderReady) == null) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(onRenderReady, "onRenderReady");
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = elapsedRealtime - this.q;
            b bVar = this.i;
            i66.b("notify_monitor");
            onRenderReady.invoke();
            i66.a();
            r46 c = i().c();
            if (c.w() && bVar != null && bVar.c() == c.x()) {
                if (bVar.b().isEmpty()) {
                    this.o = bVar.a();
                    return;
                }
                i66.b("RenderSystem_draw");
                int a2 = bVar.a();
                int i = (a2 - this.o) - 1;
                if (!g66.e(this)) {
                    if (i > 0) {
                        BdLog.w("DanmakuEngine [Engine] skipped " + i + " frames results");
                    } else if (a2 == this.o && !g66.e(this)) {
                        BdLog.w("DanmakuEngine [Engine] render same frame");
                    }
                }
                this.o = a2;
                int i2 = 0;
                u66 u66Var = null;
                try {
                    x66 c2 = g66.c(this);
                    for (u66 u66Var2 : bVar.b()) {
                        Paint n = n();
                        if (n != null) {
                            canvas.drawRect(u66Var2.f(), n);
                        }
                        if (u66Var2.c()) {
                            u66Var = u66Var2;
                        } else {
                            this.j.setAlpha((int) (c.f() * u66Var2.a() * 255));
                            if (l(canvas, u66Var2, c2, c)) {
                                i2++;
                            }
                        }
                    }
                    if (u66Var != null) {
                        this.j.setAlpha(255);
                        if (l(canvas, u66Var, c2, c)) {
                            i2++;
                        }
                    }
                } catch (Exception unused) {
                    BdLog.e("DanmakuEngine [Exception] onDraw");
                }
                long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                if (!g66.e(this) && elapsedRealtime2 > 20) {
                    BdLog.w("DanmakuEngine[RenderSystem][DRAW] OVERLOAD! interval: " + j + ", cost: " + elapsedRealtime2);
                }
                this.q = elapsedRealtime;
                this.n.b(i2);
                this.n.a(bVar.b().size());
                i66.a();
            }
        }
    }

    public final boolean l(Canvas canvas, u66 u66Var, x66 x66Var, r46 r46Var) {
        InterceptResult invokeLLLL;
        u46 g;
        Bitmap c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, canvas, u66Var, x66Var, r46Var)) == null) {
            if (Intrinsics.areEqual(u66Var.b(), t46.f.a()) || u66Var.b().g() == null || u66Var.d().f().b() != r46Var.h() || u66Var.d().i().compareTo(ItemState.Rendered) < 0 || (g = u66Var.b().g()) == null || (c = g.c()) == null || c.isRecycled()) {
                return false;
            }
            canvas.drawBitmap(c, u66Var.g(), this.j);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final List m(RectF rect) {
        InterceptResult invokeL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, rect)) == null) {
            Intrinsics.checkNotNullParameter(rect, "rect");
            if (!i().c().w() || (bVar = this.i) == null) {
                return null;
            }
            return SequencesKt___SequencesKt.toList(SequencesKt___SequencesKt.map(SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(bVar.b()), new RenderSystem$getDanmakus$3(rect)), RenderSystem$getDanmakus$4.INSTANCE));
        }
        return (List) invokeL.objValue;
    }

    public final void q() {
        List<b> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this) {
                list = CollectionsKt___CollectionsKt.toList(this.g);
                this.g.clear();
            }
            for (b bVar : list) {
                List<u66> b2 = bVar.b();
                a aVar = this.f;
                for (u66 u66Var : b2) {
                    aVar.c(u66Var);
                }
            }
        }
    }

    @Override // com.baidu.tieba.r0
    public void update(float f) {
        x46 a2;
        u66 u66Var;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048586, this, f) == null) {
            r46 c = i().c();
            if (g66.e(this) && c.d() == this.h) {
                return;
            }
            if (g66.e(this)) {
                BdLog.d("DanmakuEngine [Render] update on pause");
            }
            i66.b("RenderSystem_update");
            this.h = c.d();
            q();
            z0 entities = o();
            Intrinsics.checkNotNullExpressionValue(entities, "entities");
            ArrayList<p0> arrayList = new ArrayList();
            Iterator it = entities.iterator();
            while (true) {
                x46 x46Var = null;
                boolean z2 = true;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                p0 entity = (p0) next;
                Intrinsics.checkNotNullExpressionValue(entity, "entity");
                j56 b2 = h66.b(entity);
                if (b2 != null) {
                    x46Var = b2.a();
                }
                boolean z3 = false;
                if (x46Var != null) {
                    DrawState f2 = x46Var.f();
                    i56 d = h66.d(entity);
                    if (d == null || d.d()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    z3 = (z && x46Var.i().compareTo(ItemState.Measured) >= 0 && f2.p() && f2.f() == c.p() && f2.e() == c.o()) ? false : false;
                }
                if (z3) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = new ArrayList(o().size());
            for (p0 entity2 : arrayList) {
                Intrinsics.checkNotNullExpressionValue(entity2, "entity");
                j56 b3 = h66.b(entity2);
                if (b3 == null) {
                    a2 = null;
                } else {
                    a2 = b3.a();
                }
                if (a2 == null) {
                    u66Var = null;
                } else {
                    DrawState f3 = a2.f();
                    t46 c2 = a2.f().c();
                    m56 a3 = h66.a(entity2);
                    if (p() != null && a2.h() != c.m()) {
                        a2.n(c.m());
                        this.k.obtainMessage(1, a2).sendToTarget();
                    }
                    u66Var = (u66) this.f.e();
                    c2.m();
                    u66Var.k(a2);
                    u66Var.i(c2);
                    u66Var.g().reset();
                    if (a3 != null) {
                        u66Var.e().set(a3.f());
                        u66Var.f().setEmpty();
                        a3.i(u66Var.g());
                        u66Var.h(a3.e());
                        u66Var.g().postConcat(f3.m());
                    } else {
                        u66Var.g().set(f3.m());
                    }
                    u66Var.e().set(f3.g(), f3.h());
                    u66Var.f().set(f3.i());
                    if (a2.k()) {
                        u66Var.h(1.0f);
                        u66Var.j(true);
                    }
                }
                if (u66Var != null) {
                    arrayList2.add(u66Var);
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
            i66.a();
        }
    }
}
