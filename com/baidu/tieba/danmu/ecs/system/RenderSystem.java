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
import c.a.t0.m0.j.c;
import c.a.t0.m0.k.e;
import c.a.t0.m0.k.f;
import c.b.a.a.d;
import c.b.b.q.z;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.baidu.tieba.danmu.data.ItemState;
import com.baidu.tieba.danmu.data.state.DrawState;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0000\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0003KLMB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001e\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\f\u00102\u001a\b\u0012\u0004\u0012\u00020/03H\u0007J(\u00104\u001a\u0002052\u0006\u00100\u001a\u0002012\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0002J\u0016\u0010<\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010=2\u0006\u0010?\u001a\u00020@J\u0016\u0010<\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010=2\u0006\u0010A\u001a\u00020BJ\u0010\u0010C\u001a\u0002052\u0006\u0010D\u001a\u00020EH\u0016J\b\u0010F\u001a\u00020/H\u0016J\b\u0010G\u001a\u00020/H\u0002J\u0010\u0010H\u001a\u00020/2\u0006\u0010I\u001a\u00020JH\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R?\u0010\u0015\u001a&\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00170\u0017 \u0018*\u0012\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00170\u0017\u0018\u00010\u00160\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010*\u001a\u00060+R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/baidu/tieba/danmu/ecs/system/RenderSystem;", "Lcom/baidu/tieba/danmu/ecs/base/DanmakuEntitySystem;", "Landroid/os/Handler$Callback;", "context", "Lcom/baidu/tieba/danmu/ecs/DanmakuContext;", "(Lcom/baidu/tieba/danmu/ecs/DanmakuContext;)V", "cacheHit", "Lcom/baidu/tieba/danmu/utils/Fraction;", "getCacheHit", "()Lcom/baidu/tieba/danmu/utils/Fraction;", "setCacheHit", "(Lcom/baidu/tieba/danmu/utils/Fraction;)V", "callbackHandler", "Landroid/os/Handler;", "debugPaint", "Landroid/graphics/Paint;", "getDebugPaint", "()Landroid/graphics/Paint;", "debugPaint$delegate", "Lkotlin/Lazy;", "drawPaint", "entities", "Lcom/badlogic/ashley/utils/ImmutableArray;", "Lcom/badlogic/ashley/core/Entity;", "kotlin.jvm.PlatformType", "getEntities", "()Lcom/badlogic/ashley/utils/ImmutableArray;", "entities$delegate", "lastAllGeneration", "", "lastDrawTime", "", "lastRenderGeneration", "listener", "Lcom/baidu/tieba/danmu/ui/DanmakuListener;", "getListener$danmu_release", "()Lcom/baidu/tieba/danmu/ui/DanmakuListener;", "setListener$danmu_release", "(Lcom/baidu/tieba/danmu/ui/DanmakuListener;)V", "pendingDiscardResults", "", "Lcom/baidu/tieba/danmu/ecs/system/RenderSystem$RenderResult;", "renderObjectPool", "Lcom/baidu/tieba/danmu/ecs/system/RenderSystem$RenderObjectPool;", "renderResult", "resultGeneration", "draw", "", "canvas", "Landroid/graphics/Canvas;", "onRenderReady", "Lkotlin/Function0;", "drawRenderObject", "", "obj", "Lcom/baidu/tieba/danmu/render/RenderObject;", "displayer", "Lcom/baidu/tieba/danmu/ui/DanmakuDisplayer;", UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, "Lcom/baidu/tieba/danmu/DanmakuConfig;", "getDanmakus", "", "Lcom/baidu/tieba/danmu/data/DanmakuItem;", "point", "Landroid/graphics/Point;", "rect", "Landroid/graphics/RectF;", "handleMessage", "msg", "Landroid/os/Message;", "release", "releaseDiscardResults", "update", "deltaTime", "", "Companion", "RenderObjectPool", "RenderResult", "danmu_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class RenderSystem extends c.a.t0.m0.f.c.b implements Handler.Callback {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public final Lazy f44030i;

    /* renamed from: j  reason: collision with root package name */
    public final a f44031j;

    /* renamed from: k  reason: collision with root package name */
    public List<b> f44032k;
    public int l;
    public b m;
    public final Paint n;
    public final Handler o;
    public int p;
    public c q;
    public e r;
    public int s;
    public final Lazy t;
    public long u;

    /* loaded from: classes12.dex */
    public final class a extends z<c.a.t0.m0.i.b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RenderSystem this$0, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {this$0, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
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
        @Override // c.b.b.q.z
        /* renamed from: g */
        public c.a.t0.m0.i.b d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new c.a.t0.m0.i.b(c.a.t0.m0.e.a.m.a(), c.a.t0.m0.c.a.f19692f.a(), f.a.b(), f.a.c(), new Matrix()) : (c.a.t0.m0.i.b) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.b.b.q.z
        /* renamed from: h */
        public void f(c.a.t0.m0.i.b bVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) || bVar == null) {
                return;
            }
            if (!Intrinsics.areEqual(bVar.b(), c.a.t0.m0.c.a.f19692f.a())) {
                bVar.b().d();
            }
            bVar.k(c.a.t0.m0.e.a.m.a());
            bVar.i(c.a.t0.m0.c.a.f19692f.a());
            bVar.f().setEmpty();
            bVar.e().set(0.0f, 0.0f);
            bVar.g().reset();
            bVar.h(1.0f);
            bVar.j(false);
        }
    }

    /* loaded from: classes12.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<c.a.t0.m0.i.b> a;

        /* renamed from: b  reason: collision with root package name */
        public final int f44033b;

        /* renamed from: c  reason: collision with root package name */
        public final int f44034c;

        public b(List<c.a.t0.m0.i.b> renderObjects, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {renderObjects, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(renderObjects, "renderObjects");
            this.a = renderObjects;
            this.f44033b = i2;
            this.f44034c = i3;
        }

        public final int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f44033b : invokeV.intValue;
        }

        public final List<c.a.t0.m0.i.b> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (List) invokeV.objValue;
        }

        public final int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f44034c : invokeV.intValue;
        }
    }

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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RenderSystem(c.a.t0.m0.f.a context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.t0.m0.f.a) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.f44030i = LazyKt__LazyJVMKt.lazy(new RenderSystem$entities$2(this));
        a aVar = new a(this, 200, 500);
        aVar.b(200);
        Unit unit = Unit.INSTANCE;
        this.f44031j = aVar;
        this.f44032k = new ArrayList();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Unit unit2 = Unit.INSTANCE;
        this.n = paint;
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.o = new Handler(myLooper, this);
            this.r = new e(1, 1);
            this.s = -1;
            this.t = LazyKt__LazyJVMKt.lazy(RenderSystem$debugPaint$2.INSTANCE);
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message msg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, msg)) == null) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            c cVar = this.q;
            if (cVar != null && msg.what == 1) {
                Object obj = msg.obj;
                c.a.t0.m0.e.a aVar = obj instanceof c.a.t0.m0.e.a ? (c.a.t0.m0.e.a) obj : null;
                if (aVar == null) {
                    return false;
                }
                cVar.a(aVar);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.t0.m0.f.c.b
    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            b bVar = this.m;
            if (bVar != null) {
                this.f44032k.add(bVar);
            }
            this.m = null;
            q();
        }
    }

    @MainThread
    public final void k(Canvas canvas, Function0<Unit> onRenderReady) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, canvas, onRenderReady) == null) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(onRenderReady, "onRenderReady");
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j2 = elapsedRealtime - this.u;
            b bVar = this.m;
            c.a.t0.m0.g.e.b("notify_monitor");
            onRenderReady.invoke();
            c.a.t0.m0.g.e.a();
            c.a.t0.m0.a c2 = i().c();
            if (c2.w() && bVar != null && bVar.c() == c2.x()) {
                if (bVar.b().isEmpty()) {
                    this.s = bVar.a();
                    return;
                }
                c.a.t0.m0.g.e.b("RenderSystem_draw");
                int a2 = bVar.a();
                int i2 = (a2 - this.s) - 1;
                if (!c.a.t0.m0.g.c.e(this)) {
                    if (i2 > 0) {
                        BdLog.w("DanmakuEngine [Engine] skipped " + i2 + " frames results");
                    } else if (a2 == this.s && !c.a.t0.m0.g.c.e(this)) {
                        BdLog.w("DanmakuEngine [Engine] render same frame");
                    }
                }
                this.s = a2;
                int i3 = 0;
                c.a.t0.m0.i.b bVar2 = null;
                try {
                    c.a.t0.m0.j.b c3 = c.a.t0.m0.g.c.c(this);
                    for (c.a.t0.m0.i.b bVar3 : bVar.b()) {
                        Paint n = n();
                        if (n != null) {
                            canvas.drawRect(bVar3.f(), n);
                        }
                        if (bVar3.c()) {
                            bVar2 = bVar3;
                        } else {
                            this.n.setAlpha((int) (c2.f() * bVar3.a() * 255));
                            if (l(canvas, bVar3, c3, c2)) {
                                i3++;
                            }
                        }
                    }
                    if (bVar2 != null) {
                        this.n.setAlpha(255);
                        if (l(canvas, bVar2, c3, c2)) {
                            i3++;
                        }
                    }
                } catch (Exception unused) {
                    BdLog.e("DanmakuEngine [Exception] onDraw");
                }
                long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                if (!c.a.t0.m0.g.c.e(this) && elapsedRealtime2 > 20) {
                    BdLog.w("DanmakuEngine[RenderSystem][DRAW] OVERLOAD! interval: " + j2 + ", cost: " + elapsedRealtime2);
                }
                this.u = elapsedRealtime;
                this.r.b(i3);
                this.r.a(bVar.b().size());
                c.a.t0.m0.g.e.a();
            }
        }
    }

    public final boolean l(Canvas canvas, c.a.t0.m0.i.b bVar, c.a.t0.m0.j.b bVar2, c.a.t0.m0.a aVar) {
        InterceptResult invokeLLLL;
        c.a.t0.m0.c.b g2;
        Bitmap c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, canvas, bVar, bVar2, aVar)) == null) {
            if (Intrinsics.areEqual(bVar.b(), c.a.t0.m0.c.a.f19692f.a()) || bVar.b().g() == null || bVar.d().f().b() != aVar.h() || bVar.d().i().compareTo(ItemState.Rendered) < 0 || (g2 = bVar.b().g()) == null || (c2 = g2.c()) == null || c2.isRecycled()) {
                return false;
            }
            canvas.drawBitmap(c2, bVar.g(), this.n);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final List<c.a.t0.m0.e.a> m(RectF rect) {
        InterceptResult invokeL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, rect)) == null) {
            Intrinsics.checkNotNullParameter(rect, "rect");
            if (i().c().w() && (bVar = this.m) != null) {
                return SequencesKt___SequencesKt.toList(SequencesKt___SequencesKt.map(SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(bVar.b()), new RenderSystem$getDanmakus$3(rect)), RenderSystem$getDanmakus$4.INSTANCE));
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public final Paint n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (Paint) this.t.getValue() : (Paint) invokeV.objValue;
    }

    public final c.b.a.c.b<d> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (c.b.a.c.b) this.f44030i.getValue() : (c.b.a.c.b) invokeV.objValue;
    }

    public final c p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.q : (c) invokeV.objValue;
    }

    public final void q() {
        List<b> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            synchronized (this) {
                list = CollectionsKt___CollectionsKt.toList(this.f44032k);
                this.f44032k.clear();
            }
            for (b bVar : list) {
                List<c.a.t0.m0.i.b> b2 = bVar.b();
                a aVar = this.f44031j;
                for (c.a.t0.m0.i.b bVar2 : b2) {
                    aVar.c(bVar2);
                }
            }
        }
    }

    public final void r(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, cVar) == null) {
            this.q = cVar;
        }
    }

    @Override // c.b.a.a.f
    public void update(float f2) {
        c.a.t0.m0.i.b e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048586, this, f2) == null) {
            c.a.t0.m0.a c2 = i().c();
            if (c.a.t0.m0.g.c.e(this) && c2.d() == this.l) {
                return;
            }
            if (c.a.t0.m0.g.c.e(this)) {
                BdLog.d("DanmakuEngine [Render] update on pause");
            }
            c.a.t0.m0.g.e.b("RenderSystem_update");
            this.l = c2.d();
            q();
            c.b.a.c.b<d> entities = o();
            Intrinsics.checkNotNullExpressionValue(entities, "entities");
            ArrayList<d> arrayList = new ArrayList();
            Iterator<d> it = entities.iterator();
            while (true) {
                boolean z = true;
                if (!it.hasNext()) {
                    break;
                }
                d next = it.next();
                d entity = next;
                Intrinsics.checkNotNullExpressionValue(entity, "entity");
                c.a.t0.m0.f.d.b b2 = c.a.t0.m0.g.d.b(entity);
                c.a.t0.m0.e.a a2 = b2 != null ? b2.a() : null;
                boolean z2 = false;
                if (a2 != null) {
                    DrawState f3 = a2.f();
                    c.a.t0.m0.f.d.a d2 = c.a.t0.m0.g.d.d(entity);
                    z2 = ((d2 != null && !d2.d()) && a2.i().compareTo(ItemState.Measured) >= 0 && f3.p() && f3.f() == c2.p() && f3.e() == c2.o()) ? false : false;
                }
                if (z2) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = new ArrayList(o().size());
            for (d entity2 : arrayList) {
                Intrinsics.checkNotNullExpressionValue(entity2, "entity");
                c.a.t0.m0.f.d.b b3 = c.a.t0.m0.g.d.b(entity2);
                c.a.t0.m0.e.a a3 = b3 == null ? null : b3.a();
                if (a3 == null) {
                    e2 = null;
                } else {
                    DrawState f4 = a3.f();
                    c.a.t0.m0.c.a c3 = a3.f().c();
                    c.a.t0.m0.f.d.d.b a4 = c.a.t0.m0.g.d.a(entity2);
                    if (p() != null && a3.h() != c2.m()) {
                        a3.n(c2.m());
                        this.o.obtainMessage(1, a3).sendToTarget();
                    }
                    e2 = this.f44031j.e();
                    c3.m();
                    e2.k(a3);
                    e2.i(c3);
                    e2.g().reset();
                    if (a4 != null) {
                        e2.e().set(a4.f());
                        e2.f().setEmpty();
                        a4.i(e2.g());
                        e2.h(a4.e());
                        e2.g().postConcat(f4.m());
                    } else {
                        e2.g().set(f4.m());
                    }
                    e2.e().set(f4.g(), f4.h());
                    e2.f().set(f4.i());
                    if (a3.k()) {
                        e2.h(1.0f);
                        e2.j(true);
                    }
                }
                if (e2 != null) {
                    arrayList2.add(e2);
                }
            }
            synchronized (this) {
                b bVar = this.m;
                if (bVar != null) {
                    this.f44032k.add(bVar);
                }
                int i2 = this.p;
                this.p = i2 + 1;
                this.m = new b(arrayList2, i2, c2.x());
                Unit unit = Unit.INSTANCE;
            }
            c.a.t0.m0.g.e.a();
        }
    }
}
