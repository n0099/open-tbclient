package com.baidu.tieba.danmu.ui;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Choreographer;
import androidx.core.math.MathUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.danmu.ecs.system.DataSystem;
import com.baidu.tieba.danmu.ecs.system.RenderSystem;
import com.baidu.tieba.danmu.ui.DanmakuPlayer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.c06;
import com.repackage.ly5;
import com.repackage.n06;
import com.repackage.r06;
import com.repackage.ry5;
import com.repackage.s06;
import com.repackage.sy5;
import com.repackage.ty5;
import com.repackage.xy5;
import com.repackage.y06;
import com.tachikoma.core.component.input.ReturnKeyType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001f\u0018\u0000 p2\u00020\u0001:\u0003opqB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010:\u001a\u00020;2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0015\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020>H\u0000¢\u0006\u0002\b?J\b\u0010@\u001a\u0004\u0018\u00010\u0017J\u0006\u0010A\u001a\u00020BJ\u0016\u0010C\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010D2\u0006\u0010F\u001a\u00020GJ\u0016\u0010H\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010D2\u0006\u0010I\u001a\u00020JJ\u0010\u0010K\u001a\u00020;2\b\u0010L\u001a\u0004\u0018\u00010EJ\u001d\u0010M\u001a\u00020;2\u0006\u0010N\u001a\u00020\u00192\u0006\u0010O\u001a\u00020\u0019H\u0000¢\u0006\u0002\bPJ\u000e\u0010Q\u001a\u00020E2\u0006\u0010R\u001a\u00020SJ\u0006\u0010T\u001a\u00020;J\b\u0010U\u001a\u00020;H\u0002J\u0006\u0010V\u001a\u00020;J\u000e\u0010W\u001a\u00020;2\u0006\u0010L\u001a\u00020EJ\b\u0010X\u001a\u00020;H\u0002J\u000e\u0010Y\u001a\u00020;2\u0006\u0010Z\u001a\u00020BJ\u000e\u0010[\u001a\u00020;2\u0006\u0010L\u001a\u00020EJ\u000e\u0010[\u001a\u00020E2\u0006\u0010R\u001a\u00020SJ\u0012\u0010\\\u001a\u00020;2\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u0017J\u000e\u0010^\u001a\u00020;2\u0006\u0010_\u001a\u00020\u0019J\u0006\u0010`\u001a\u00020;J\u0010\u0010a\u001a\u00020;2\b\u0010]\u001a\u0004\u0018\u00010\u0017J\u001a\u0010b\u001a\b\u0012\u0004\u0012\u00020E0D2\f\u0010c\u001a\b\u0012\u0004\u0012\u00020S0DJ\u0019\u0010d\u001a\u00020;2\n\b\u0002\u0010e\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0002\u0010fJ\u000e\u0010g\u001a\u00020;2\u0006\u0010L\u001a\u00020EJ\u0014\u0010h\u001a\u00020;2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020E0DJ\b\u0010j\u001a\u00020;H\u0002J\u000e\u0010k\u001a\u00020;2\u0006\u0010l\u001a\u00020\u001bJ \u0010m\u001a\u00020;2\u0006\u0010N\u001a\u00020\u00192\u0006\u0010O\u001a\u00020\u00192\u0006\u0010n\u001a\u00020\u001bH\u0002R\u001f\u0010\u0007\u001a\u00060\bR\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020&X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001b\u0010)\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\f\u001a\u0004\b+\u0010,R\u001e\u00100\u001a\u00020/2\u0006\u0010.\u001a\u00020/@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R(\u00104\u001a\u0004\u0018\u0001032\b\u00102\u001a\u0004\u0018\u000103@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u000e\u00109\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006r"}, d2 = {"Lcom/baidu/tieba/danmu/ui/DanmakuPlayer;", "", "renderer", "Lcom/baidu/tieba/danmu/render/DanmakuRenderer;", "dataSource", "Lcom/baidu/tieba/danmu/data/DataSource;", "(Lcom/baidu/tieba/danmu/render/DanmakuRenderer;Lcom/baidu/tieba/danmu/data/DataSource;)V", "actionHandler", "Lcom/baidu/tieba/danmu/ui/DanmakuPlayer$ActionHandler;", "getActionHandler", "()Lcom/baidu/tieba/danmu/ui/DanmakuPlayer$ActionHandler;", "actionHandler$delegate", "Lkotlin/Lazy;", "actionThread", "Landroid/os/HandlerThread;", "getActionThread", "()Landroid/os/HandlerThread;", "actionThread$delegate", "cacheHit", "Lcom/baidu/tieba/danmu/utils/Fraction;", "getCacheHit", "()Lcom/baidu/tieba/danmu/utils/Fraction;", UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, "Lcom/baidu/tieba/danmu/DanmakuConfig;", "currentDisplayerHeight", "", "currentDisplayerSizeFactor", "", "currentDisplayerWidth", "danmakuView", "Lcom/baidu/tieba/danmu/ui/DanmakuView;", "dataSystem", "Lcom/baidu/tieba/danmu/ecs/system/DataSystem;", "getDataSystem", "()Lcom/baidu/tieba/danmu/ecs/system/DataSystem;", "drawSemaphore", "Ljava/util/concurrent/Semaphore;", "engine", "Lcom/baidu/tieba/danmu/ecs/DanmakuEngine;", "getEngine$danmu_release", "()Lcom/baidu/tieba/danmu/ecs/DanmakuEngine;", "frameCallback", "Lcom/baidu/tieba/danmu/ui/DanmakuPlayer$FrameCallback;", "getFrameCallback", "()Lcom/baidu/tieba/danmu/ui/DanmakuPlayer$FrameCallback;", "frameCallback$delegate", "<set-?>", "", "isReleased", "()Z", "value", "Lcom/baidu/tieba/danmu/ui/DanmakuListener;", "listener", "getListener", "()Lcom/baidu/tieba/danmu/ui/DanmakuListener;", "setListener", "(Lcom/baidu/tieba/danmu/ui/DanmakuListener;)V", "started", "bindView", "", "draw", "canvas", "Landroid/graphics/Canvas;", "draw$danmu_release", "getConfig", "getCurrentTimeMs", "", "getDanmakusAtPoint", "", "Lcom/baidu/tieba/danmu/data/DanmakuItem;", Config.EVENT_HEAT_POINT, "Landroid/graphics/Point;", "getDanmakusInRect", "hitRect", "Landroid/graphics/RectF;", "hold", "item", "notifyDisplayerSizeChanged", "width", "height", "notifyDisplayerSizeChanged$danmu_release", "obtainItem", "danmaku", "Lcom/baidu/tieba/danmu/data/DanmakuItemData;", "pause", "postFrameCallback", "release", "releaseItem", "releaseSemaphore", "seekTo", "positionMs", ReturnKeyType.SEND, "start", "danmakuConfig", ShaderParams.VALUE_TYPE_STEP, "deltaTimeMs", IntentConfig.STOP, "updateConfig", "updateData", "dataList", "updateFrame", "deltaTimeSeconds", "(Ljava/lang/Float;)V", "updateItem", "updateItems", "items", "updateMaxDanmakuDuration", "updatePlaySpeed", "speed", "updateViewportState", "viewportSizeFactor", "ActionHandler", "Companion", "FrameCallback", "danmu_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class DanmakuPlayer {
    public static /* synthetic */ Interceptable $ic;
    public static boolean n;
    public transient /* synthetic */ FieldHolder $fh;
    public DanmakuView a;
    public final xy5 b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public int f;
    public int g;
    public float h;
    public ly5 i;
    public final Semaphore j;
    public boolean k;
    public s06 l;
    public boolean m;

    /* loaded from: classes3.dex */
    public final class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DanmakuPlayer a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(DanmakuPlayer this$0, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {this$0, looper};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(looper, "looper");
            this.a = this$0;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, msg) == null) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                int i = msg.what;
                if (i == 2101) {
                    int i2 = msg.arg1;
                    this.a.C(i2 > 0 ? Float.valueOf(i2 / 1000.0f) : null);
                } else if (i != 2201) {
                } else {
                    ly5 c = this.a.m().u().c();
                    c.F();
                    c.G();
                    c.C();
                    c.I();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements Choreographer.FrameCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Handler a;

        public b(Handler handler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {handler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(handler, "handler");
            this.a = handler;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.a.removeMessages(2101);
                this.a.sendEmptyMessage(2101);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(29652290, "Lcom/baidu/tieba/danmu/ui/DanmakuPlayer;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(29652290, "Lcom/baidu/tieba/danmu/ui/DanmakuPlayer;");
        }
    }

    public DanmakuPlayer(n06 renderer, ty5 ty5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {renderer, ty5Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(renderer, "renderer");
        this.b = xy5.a.c(xy5.m, renderer, null, 2, null);
        this.c = LazyKt__LazyJVMKt.lazy(DanmakuPlayer$actionThread$2.INSTANCE);
        this.d = LazyKt__LazyJVMKt.lazy(new DanmakuPlayer$actionHandler$2(this));
        this.e = LazyKt__LazyJVMKt.lazy(new DanmakuPlayer$frameCallback$2(this));
        this.h = 1.0f;
        this.j = new Semaphore(0);
        if (ty5Var == null) {
            return;
        }
        ty5Var.a(l());
        throw null;
    }

    public static final void y(DanmakuPlayer this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.r();
        }
    }

    public final void A(ly5 ly5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, ly5Var) == null) {
            this.i = ly5Var;
            xy5 xy5Var = this.b;
            if (ly5Var == null) {
                return;
            }
            xy5Var.F(ly5Var);
        }
    }

    public final List<ry5> B(List<sy5> dataList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataList)) == null) {
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(dataList, 10));
            for (sy5 sy5Var : dataList) {
                arrayList.add(p(sy5Var));
            }
            DataSystem l = l();
            if (l != null) {
                l.x(arrayList);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void C(Float f) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, f) == null) && this.k) {
            if (n) {
                this.b.D(f);
            } else {
                r();
                this.b.z();
                this.j.acquire();
            }
            if (this.k) {
                c06.b("updateFrame");
                this.b.r();
                c06.b("postInvalidate");
                DanmakuView danmakuView = this.a;
                if (danmakuView != null) {
                    danmakuView.postInvalidateOnAnimation();
                }
                c06.a();
                c06.a();
            }
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    public final void E(int i, int i2, float f) {
        ly5 ly5Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f)}) == null) || (ly5Var = this.i) == null) {
            return;
        }
        if (this.f == i && this.g == i2) {
            if (this.h == f) {
                return;
            }
        }
        long clamp = MathUtils.clamp(((float) 13000) * ((i * f) / 682), 9000L, 15000L);
        if (ly5Var.t() != clamp) {
            ly5Var.A(clamp);
            ly5Var.I();
            ly5Var.F();
            ly5Var.J();
        }
        BdLog.d(Intrinsics.stringPlus("XanaDanmaku [Factor] update rolling duration to ", Long.valueOf(clamp)));
        this.f = i;
        this.g = i2;
        this.h = f;
    }

    public final void e(DanmakuView danmakuView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, danmakuView) == null) {
            Intrinsics.checkNotNullParameter(danmakuView, "danmakuView");
            DanmakuView danmakuView2 = this.a;
            if (danmakuView2 != null) {
                danmakuView2.setDanmakuPlayer(null);
            }
            this.a = danmakuView;
            danmakuView.setDanmakuPlayer(this);
            this.b.u().g(danmakuView.getDisplayer$danmu_release());
            o(danmakuView.getDisplayer$danmu_release().getWidth(), danmakuView.getDisplayer$danmu_release().getHeight());
            danmakuView.postInvalidate();
        }
    }

    public final void f(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            if (this.m) {
                return;
            }
            if (!n) {
                xy5.E(this.b, null, 1, null);
            }
            this.j.tryAcquire();
            if (!this.k) {
                t();
            } else {
                this.b.s(canvas, new DanmakuPlayer$draw$1(this));
            }
        }
    }

    public final a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? (a) this.d.getValue() : (a) invokeV.objValue;
    }

    public final HandlerThread h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (HandlerThread) this.c.getValue() : (HandlerThread) invokeV.objValue;
    }

    public final ly5 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.b.t() : (ly5) invokeV.objValue;
    }

    public final long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.b.v() : invokeV.longValue;
    }

    public final List<ry5> k(RectF hitRect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, hitRect)) == null) {
            Intrinsics.checkNotNullParameter(hitRect, "hitRect");
            RenderSystem renderSystem = (RenderSystem) this.b.k(RenderSystem.class);
            if (renderSystem == null) {
                return null;
            }
            return renderSystem.m(hitRect);
        }
        return (List) invokeL.objValue;
    }

    public final DataSystem l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? (DataSystem) this.b.k(DataSystem.class) : (DataSystem) invokeV.objValue;
    }

    public final xy5 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.b : (xy5) invokeV.objValue;
    }

    public final b n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? (b) this.e.getValue() : (b) invokeV.objValue;
    }

    public final void o(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048591, this, i, i2) == null) {
            r06 d = this.b.u().d();
            E(i, i2, d.d());
            D();
            if (d.getWidth() == i && d.getHeight() == i2) {
                return;
            }
            BdLog.d("DanmakuEngine notifyDisplayerSizeChanged(" + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2 + ')');
            d.setWidth(i);
            d.setHeight(i2);
            g().obtainMessage(2201).sendToTarget();
        }
    }

    public final ry5 p(sy5 danmaku) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, danmaku)) == null) {
            Intrinsics.checkNotNullParameter(danmaku, "danmaku");
            return y06.a.a(danmaku, this);
        }
        return (ry5) invokeL.objValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.b.y();
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            Choreographer.getInstance().postFrameCallback(n());
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || this.m) {
            return;
        }
        this.m = true;
        g().removeCallbacksAndMessages(null);
        Choreographer.getInstance().removeFrameCallback(n());
        this.k = false;
        h().quitSafely();
        h().join(50L);
        this.b.A();
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && this.j.availablePermits() == 0) {
            this.j.release();
        }
    }

    public final void u(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048597, this, j) == null) {
            BdLog.d("DanmakuEngine [Player] SeekTo(" + j + ')');
            ly5 i = i();
            if (i != null) {
                i.E();
            }
            this.b.B(Math.max(j, 0L));
        }
    }

    public final ry5 v(sy5 danmaku) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, danmaku)) == null) {
            Intrinsics.checkNotNullParameter(danmaku, "danmaku");
            ry5 p = p(danmaku);
            DataSystem l = l();
            if (l != null) {
                l.w(p);
            }
            return p;
        }
        return (ry5) invokeL.objValue;
    }

    public final void w(s06 s06Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, s06Var) == null) || Intrinsics.areEqual(this.l, s06Var)) {
            return;
        }
        this.l = s06Var;
        RenderSystem renderSystem = (RenderSystem) this.b.k(RenderSystem.class);
        if (renderSystem == null) {
            return;
        }
        renderSystem.r(s06Var);
    }

    public final void x(ly5 ly5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, ly5Var) == null) {
            if (ly5Var != null) {
                A(ly5Var);
            }
            this.b.C();
            if (this.k) {
                return;
            }
            this.k = true;
            if (n) {
                return;
            }
            g().post(new Runnable() { // from class: com.repackage.q06
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        DanmakuPlayer.y(DanmakuPlayer.this);
                    }
                }
            });
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.b.y();
            u(0L);
        }
    }

    public /* synthetic */ DanmakuPlayer(n06 n06Var, ty5 ty5Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(n06Var, (i & 2) != 0 ? null : ty5Var);
    }
}
