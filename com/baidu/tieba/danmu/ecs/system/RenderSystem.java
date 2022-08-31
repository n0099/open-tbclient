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
import com.baidu.tieba.c36;
import com.baidu.tieba.danmu.data.ItemState;
import com.baidu.tieba.danmu.data.state.DrawState;
import com.baidu.tieba.h26;
import com.baidu.tieba.j26;
import com.baidu.tieba.k26;
import com.baidu.tieba.k46;
import com.baidu.tieba.n26;
import com.baidu.tieba.n46;
import com.baidu.tieba.o0;
import com.baidu.tieba.o46;
import com.baidu.tieba.s26;
import com.baidu.tieba.t46;
import com.baidu.tieba.u46;
import com.baidu.tieba.v26;
import com.baidu.tieba.w36;
import com.baidu.tieba.x36;
import com.baidu.tieba.y0;
import com.baidu.tieba.y26;
import com.baidu.tieba.y36;
import com.baidu.tieba.z26;
import com.baidu.tieba.z7;
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
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0000\u0018\u0000 K2\u00020\u00012\u00020\u0002:\u0003KLMB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001e\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\f\u00102\u001a\b\u0012\u0004\u0012\u00020/03H\u0007J(\u00104\u001a\u0002052\u0006\u00100\u001a\u0002012\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;H\u0002J\u0016\u0010<\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010=2\u0006\u0010?\u001a\u00020@J\u0016\u0010<\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010=2\u0006\u0010A\u001a\u00020BJ\u0010\u0010C\u001a\u0002052\u0006\u0010D\u001a\u00020EH\u0016J\b\u0010F\u001a\u00020/H\u0016J\b\u0010G\u001a\u00020/H\u0002J\u0010\u0010H\u001a\u00020/2\u0006\u0010I\u001a\u00020JH\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R?\u0010\u0015\u001a&\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00170\u0017 \u0018*\u0012\u0012\f\u0012\n \u0018*\u0004\u0018\u00010\u00170\u0017\u0018\u00010\u00160\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010*\u001a\u00060+R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/baidu/tieba/danmu/ecs/system/RenderSystem;", "Lcom/baidu/tieba/danmu/ecs/base/DanmakuEntitySystem;", "Landroid/os/Handler$Callback;", "context", "Lcom/baidu/tieba/danmu/ecs/DanmakuContext;", "(Lcom/baidu/tieba/danmu/ecs/DanmakuContext;)V", "cacheHit", "Lcom/baidu/tieba/danmu/utils/Fraction;", "getCacheHit", "()Lcom/baidu/tieba/danmu/utils/Fraction;", "setCacheHit", "(Lcom/baidu/tieba/danmu/utils/Fraction;)V", "callbackHandler", "Landroid/os/Handler;", "debugPaint", "Landroid/graphics/Paint;", "getDebugPaint", "()Landroid/graphics/Paint;", "debugPaint$delegate", "Lkotlin/Lazy;", "drawPaint", "entities", "Lcom/badlogic/ashley/utils/ImmutableArray;", "Lcom/badlogic/ashley/core/Entity;", "kotlin.jvm.PlatformType", "getEntities", "()Lcom/badlogic/ashley/utils/ImmutableArray;", "entities$delegate", "lastAllGeneration", "", "lastDrawTime", "", "lastRenderGeneration", "listener", "Lcom/baidu/tieba/danmu/ui/DanmakuListener;", "getListener$danmu_release", "()Lcom/baidu/tieba/danmu/ui/DanmakuListener;", "setListener$danmu_release", "(Lcom/baidu/tieba/danmu/ui/DanmakuListener;)V", "pendingDiscardResults", "", "Lcom/baidu/tieba/danmu/ecs/system/RenderSystem$RenderResult;", "renderObjectPool", "Lcom/baidu/tieba/danmu/ecs/system/RenderSystem$RenderObjectPool;", "renderResult", "resultGeneration", "draw", "", "canvas", "Landroid/graphics/Canvas;", "onRenderReady", "Lkotlin/Function0;", "drawRenderObject", "", "obj", "Lcom/baidu/tieba/danmu/render/RenderObject;", "displayer", "Lcom/baidu/tieba/danmu/ui/DanmakuDisplayer;", "config", "Lcom/baidu/tieba/danmu/DanmakuConfig;", "getDanmakus", "", "Lcom/baidu/tieba/danmu/data/DanmakuItem;", Config.EVENT_HEAT_POINT, "Landroid/graphics/Point;", "rect", "Landroid/graphics/RectF;", "handleMessage", "msg", "Landroid/os/Message;", "release", "releaseDiscardResults", "update", "deltaTime", "", "Companion", "RenderObjectPool", "RenderResult", "danmu_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class RenderSystem extends v26 implements Handler.Callback {
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
    public o46 m;
    public t46 n;
    public int o;
    public final Lazy p;
    public long q;

    /* loaded from: classes3.dex */
    public final class a extends z7<k46> {
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
        @Override // com.baidu.tieba.z7
        /* renamed from: g */
        public k46 d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new k46(n26.i.a(), j26.f.a(), u46.a.b(), u46.a.c(), new Matrix()) : (k46) invokeV.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.z7
        /* renamed from: h */
        public void f(k46 k46Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, k46Var) == null) || k46Var == null) {
                return;
            }
            if (!Intrinsics.areEqual(k46Var.b(), j26.f.a())) {
                k46Var.b().d();
            }
            k46Var.k(n26.i.a());
            k46Var.i(j26.f.a());
            k46Var.f().setEmpty();
            k46Var.e().set(0.0f, 0.0f);
            k46Var.g().reset();
            k46Var.h(1.0f);
            k46Var.j(false);
        }
    }

    /* loaded from: classes3.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<k46> a;
        public final int b;
        public final int c;

        public b(List<k46> renderObjects, int i, int i2) {
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
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : invokeV.intValue;
        }

        public final List<k46> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (List) invokeV.objValue;
        }

        public final int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : invokeV.intValue;
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
    public RenderSystem(s26 context) {
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
                super((s26) newInitContext.callArgs[0]);
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
            this.n = new t46(1, 1);
            this.o = -1;
            this.p = LazyKt__LazyJVMKt.lazy(RenderSystem$debugPaint$2.INSTANCE);
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
            o46 o46Var = this.m;
            if (o46Var != null && msg.what == 1) {
                Object obj = msg.obj;
                n26 n26Var = obj instanceof n26 ? (n26) obj : null;
                if (n26Var == null) {
                    return false;
                }
                o46Var.a(n26Var);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.v26
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

    @MainThread
    public final void k(Canvas canvas, Function0<Unit> onRenderReady) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, canvas, onRenderReady) == null) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(onRenderReady, "onRenderReady");
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = elapsedRealtime - this.q;
            b bVar = this.i;
            y36.b("notify_monitor");
            onRenderReady.invoke();
            y36.a();
            h26 c = i().c();
            if (c.w() && bVar != null && bVar.c() == c.x()) {
                if (bVar.b().isEmpty()) {
                    this.o = bVar.a();
                    return;
                }
                y36.b("RenderSystem_draw");
                int a2 = bVar.a();
                int i = (a2 - this.o) - 1;
                if (!w36.e(this)) {
                    if (i > 0) {
                        BdLog.w("DanmakuEngine [Engine] skipped " + i + " frames results");
                    } else if (a2 == this.o && !w36.e(this)) {
                        BdLog.w("DanmakuEngine [Engine] render same frame");
                    }
                }
                this.o = a2;
                int i2 = 0;
                k46 k46Var = null;
                try {
                    n46 c2 = w36.c(this);
                    for (k46 k46Var2 : bVar.b()) {
                        Paint n = n();
                        if (n != null) {
                            canvas.drawRect(k46Var2.f(), n);
                        }
                        if (k46Var2.c()) {
                            k46Var = k46Var2;
                        } else {
                            this.j.setAlpha((int) (c.f() * k46Var2.a() * 255));
                            if (l(canvas, k46Var2, c2, c)) {
                                i2++;
                            }
                        }
                    }
                    if (k46Var != null) {
                        this.j.setAlpha(255);
                        if (l(canvas, k46Var, c2, c)) {
                            i2++;
                        }
                    }
                } catch (Exception unused) {
                    BdLog.e("DanmakuEngine [Exception] onDraw");
                }
                long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                if (!w36.e(this) && elapsedRealtime2 > 20) {
                    BdLog.w("DanmakuEngine[RenderSystem][DRAW] OVERLOAD! interval: " + j + ", cost: " + elapsedRealtime2);
                }
                this.q = elapsedRealtime;
                this.n.b(i2);
                this.n.a(bVar.b().size());
                y36.a();
            }
        }
    }

    public final boolean l(Canvas canvas, k46 k46Var, n46 n46Var, h26 h26Var) {
        InterceptResult invokeLLLL;
        k26 g;
        Bitmap c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048579, this, canvas, k46Var, n46Var, h26Var)) == null) {
            if (Intrinsics.areEqual(k46Var.b(), j26.f.a()) || k46Var.b().g() == null || k46Var.d().f().b() != h26Var.h() || k46Var.d().i().compareTo(ItemState.Rendered) < 0 || (g = k46Var.b().g()) == null || (c = g.c()) == null || c.isRecycled()) {
                return false;
            }
            canvas.drawBitmap(c, k46Var.g(), this.j);
            return true;
        }
        return invokeLLLL.booleanValue;
    }

    public final List<n26> m(RectF rect) {
        InterceptResult invokeL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, rect)) == null) {
            Intrinsics.checkNotNullParameter(rect, "rect");
            if (i().c().w() && (bVar = this.i) != null) {
                return SequencesKt___SequencesKt.toList(SequencesKt___SequencesKt.map(SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(bVar.b()), new RenderSystem$getDanmakus$3(rect)), RenderSystem$getDanmakus$4.INSTANCE));
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public final Paint n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (Paint) this.p.getValue() : (Paint) invokeV.objValue;
    }

    public final y0<o0> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (y0) this.e.getValue() : (y0) invokeV.objValue;
    }

    public final o46 p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.m : (o46) invokeV.objValue;
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
                List<k46> b2 = bVar.b();
                a aVar = this.f;
                for (k46 k46Var : b2) {
                    aVar.c(k46Var);
                }
            }
        }
    }

    public final void r(o46 o46Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, o46Var) == null) {
            this.m = o46Var;
        }
    }

    @Override // com.baidu.tieba.q0
    public void update(float f) {
        k46 e;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048586, this, f) == null) {
            h26 c = i().c();
            if (w36.e(this) && c.d() == this.h) {
                return;
            }
            if (w36.e(this)) {
                BdLog.d("DanmakuEngine [Render] update on pause");
            }
            y36.b("RenderSystem_update");
            this.h = c.d();
            q();
            y0<o0> entities = o();
            Intrinsics.checkNotNullExpressionValue(entities, "entities");
            ArrayList<o0> arrayList = new ArrayList();
            Iterator<o0> it = entities.iterator();
            while (true) {
                boolean z = true;
                if (!it.hasNext()) {
                    break;
                }
                o0 next = it.next();
                o0 entity = next;
                Intrinsics.checkNotNullExpressionValue(entity, "entity");
                z26 b2 = x36.b(entity);
                n26 a2 = b2 != null ? b2.a() : null;
                boolean z2 = false;
                if (a2 != null) {
                    DrawState f2 = a2.f();
                    y26 d = x36.d(entity);
                    z2 = ((d != null && !d.d()) && a2.i().compareTo(ItemState.Measured) >= 0 && f2.p() && f2.f() == c.p() && f2.e() == c.o()) ? false : false;
                }
                if (z2) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = new ArrayList(o().size());
            for (o0 entity2 : arrayList) {
                Intrinsics.checkNotNullExpressionValue(entity2, "entity");
                z26 b3 = x36.b(entity2);
                n26 a3 = b3 == null ? null : b3.a();
                if (a3 == null) {
                    e = null;
                } else {
                    DrawState f3 = a3.f();
                    j26 c2 = a3.f().c();
                    c36 a4 = x36.a(entity2);
                    if (p() != null && a3.h() != c.m()) {
                        a3.n(c.m());
                        this.k.obtainMessage(1, a3).sendToTarget();
                    }
                    e = this.f.e();
                    c2.m();
                    e.k(a3);
                    e.i(c2);
                    e.g().reset();
                    if (a4 != null) {
                        e.e().set(a4.f());
                        e.f().setEmpty();
                        a4.i(e.g());
                        e.h(a4.e());
                        e.g().postConcat(f3.m());
                    } else {
                        e.g().set(f3.m());
                    }
                    e.e().set(f3.g(), f3.h());
                    e.f().set(f3.i());
                    if (a3.k()) {
                        e.h(1.0f);
                        e.j(true);
                    }
                }
                if (e != null) {
                    arrayList2.add(e);
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
            y36.a();
        }
    }
}
