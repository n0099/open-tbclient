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
import com.baidu.mobstat.Config;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.tieba.bt6;
import com.baidu.tieba.danmu.ecs.system.DataSystem;
import com.baidu.tieba.danmu.ecs.system.RenderSystem;
import com.baidu.tieba.danmu.ui.DanmakuPlayer;
import com.baidu.tieba.kr6;
import com.baidu.tieba.mt6;
import com.baidu.tieba.qr6;
import com.baidu.tieba.qt6;
import com.baidu.tieba.rr6;
import com.baidu.tieba.rt6;
import com.baidu.tieba.sr6;
import com.baidu.tieba.wr6;
import com.baidu.tieba.xt6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001f\u0018\u0000 p2\u00020\u0001:\u0003opqB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010:\u001a\u00020;2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0015\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020>H\u0000¢\u0006\u0002\b?J\b\u0010@\u001a\u0004\u0018\u00010\u0017J\u0006\u0010A\u001a\u00020BJ\u0016\u0010C\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010D2\u0006\u0010F\u001a\u00020GJ\u0016\u0010H\u001a\n\u0012\u0004\u0012\u00020E\u0018\u00010D2\u0006\u0010I\u001a\u00020JJ\u0010\u0010K\u001a\u00020;2\b\u0010L\u001a\u0004\u0018\u00010EJ\u001d\u0010M\u001a\u00020;2\u0006\u0010N\u001a\u00020\u00192\u0006\u0010O\u001a\u00020\u0019H\u0000¢\u0006\u0002\bPJ\u000e\u0010Q\u001a\u00020E2\u0006\u0010R\u001a\u00020SJ\u0006\u0010T\u001a\u00020;J\b\u0010U\u001a\u00020;H\u0002J\u0006\u0010V\u001a\u00020;J\u000e\u0010W\u001a\u00020;2\u0006\u0010L\u001a\u00020EJ\b\u0010X\u001a\u00020;H\u0002J\u000e\u0010Y\u001a\u00020;2\u0006\u0010Z\u001a\u00020BJ\u000e\u0010[\u001a\u00020;2\u0006\u0010L\u001a\u00020EJ\u000e\u0010[\u001a\u00020E2\u0006\u0010R\u001a\u00020SJ\u0012\u0010\\\u001a\u00020;2\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u0017J\u000e\u0010^\u001a\u00020;2\u0006\u0010_\u001a\u00020\u0019J\u0006\u0010`\u001a\u00020;J\u0010\u0010a\u001a\u00020;2\b\u0010]\u001a\u0004\u0018\u00010\u0017J\u001a\u0010b\u001a\b\u0012\u0004\u0012\u00020E0D2\f\u0010c\u001a\b\u0012\u0004\u0012\u00020S0DJ\u0019\u0010d\u001a\u00020;2\n\b\u0002\u0010e\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0002\u0010fJ\u000e\u0010g\u001a\u00020;2\u0006\u0010L\u001a\u00020EJ\u0014\u0010h\u001a\u00020;2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020E0DJ\b\u0010j\u001a\u00020;H\u0002J\u000e\u0010k\u001a\u00020;2\u0006\u0010l\u001a\u00020\u001bJ \u0010m\u001a\u00020;2\u0006\u0010N\u001a\u00020\u00192\u0006\u0010O\u001a\u00020\u00192\u0006\u0010n\u001a\u00020\u001bH\u0002R\u001f\u0010\u0007\u001a\u00060\bR\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020&X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001b\u0010)\u001a\u00020*8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\f\u001a\u0004\b+\u0010,R\u001e\u00100\u001a\u00020/2\u0006\u0010.\u001a\u00020/@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R(\u00104\u001a\u0004\u0018\u0001032\b\u00102\u001a\u0004\u0018\u000103@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u000e\u00109\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006r"}, d2 = {"Lcom/baidu/tieba/danmu/ui/DanmakuPlayer;", "", "renderer", "Lcom/baidu/tieba/danmu/render/DanmakuRenderer;", "dataSource", "Lcom/baidu/tieba/danmu/data/DataSource;", "(Lcom/baidu/tieba/danmu/render/DanmakuRenderer;Lcom/baidu/tieba/danmu/data/DataSource;)V", "actionHandler", "Lcom/baidu/tieba/danmu/ui/DanmakuPlayer$ActionHandler;", "getActionHandler", "()Lcom/baidu/tieba/danmu/ui/DanmakuPlayer$ActionHandler;", "actionHandler$delegate", "Lkotlin/Lazy;", "actionThread", "Landroid/os/HandlerThread;", "getActionThread", "()Landroid/os/HandlerThread;", "actionThread$delegate", "cacheHit", "Lcom/baidu/tieba/danmu/utils/Fraction;", "getCacheHit", "()Lcom/baidu/tieba/danmu/utils/Fraction;", "config", "Lcom/baidu/tieba/danmu/DanmakuConfig;", "currentDisplayerHeight", "", "currentDisplayerSizeFactor", "", "currentDisplayerWidth", "danmakuView", "Lcom/baidu/tieba/danmu/ui/DanmakuView;", "dataSystem", "Lcom/baidu/tieba/danmu/ecs/system/DataSystem;", "getDataSystem", "()Lcom/baidu/tieba/danmu/ecs/system/DataSystem;", "drawSemaphore", "Ljava/util/concurrent/Semaphore;", "engine", "Lcom/baidu/tieba/danmu/ecs/DanmakuEngine;", "getEngine$danmu_release", "()Lcom/baidu/tieba/danmu/ecs/DanmakuEngine;", "frameCallback", "Lcom/baidu/tieba/danmu/ui/DanmakuPlayer$FrameCallback;", "getFrameCallback", "()Lcom/baidu/tieba/danmu/ui/DanmakuPlayer$FrameCallback;", "frameCallback$delegate", "<set-?>", "", "isReleased", "()Z", "value", "Lcom/baidu/tieba/danmu/ui/DanmakuListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getListener", "()Lcom/baidu/tieba/danmu/ui/DanmakuListener;", "setListener", "(Lcom/baidu/tieba/danmu/ui/DanmakuListener;)V", "started", "bindView", "", "draw", "canvas", "Landroid/graphics/Canvas;", "draw$danmu_release", "getConfig", "getCurrentTimeMs", "", "getDanmakusAtPoint", "", "Lcom/baidu/tieba/danmu/data/DanmakuItem;", Config.EVENT_HEAT_POINT, "Landroid/graphics/Point;", "getDanmakusInRect", "hitRect", "Landroid/graphics/RectF;", "hold", "item", "notifyDisplayerSizeChanged", "width", "height", "notifyDisplayerSizeChanged$danmu_release", "obtainItem", "danmaku", "Lcom/baidu/tieba/danmu/data/DanmakuItemData;", DownloadStatisticConstants.UBC_TYPE_PAUSE, "postFrameCallback", "release", "releaseItem", "releaseSemaphore", "seekTo", "positionMs", "send", "start", "danmakuConfig", "step", "deltaTimeMs", "stop", "updateConfig", "updateData", "dataList", "updateFrame", "deltaTimeSeconds", "(Ljava/lang/Float;)V", "updateItem", "updateItems", "items", "updateMaxDanmakuDuration", "updatePlaySpeed", "speed", "updateViewportState", "viewportSizeFactor", "ActionHandler", "Companion", "FrameCallback", "danmu_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DanmakuPlayer {
    public static /* synthetic */ Interceptable $ic;
    public static boolean n;
    public transient /* synthetic */ FieldHolder $fh;
    public DanmakuView a;
    public final wr6 b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public int f;
    public int g;
    public float h;
    public kr6 i;
    public final Semaphore j;
    public boolean k;
    public rt6 l;
    public boolean m;

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

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public final class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ DanmakuPlayer a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(DanmakuPlayer danmakuPlayer, Looper looper) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {danmakuPlayer, looper};
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
            Intrinsics.checkNotNullParameter(looper, "looper");
            this.a = danmakuPlayer;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Float f;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, msg) == null) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                int i = msg.what;
                if (i != 2101) {
                    if (i == 2201) {
                        kr6 c = this.a.m().v().c();
                        c.F();
                        c.G();
                        c.C();
                        c.I();
                        return;
                    }
                    return;
                }
                int i2 = msg.arg1;
                if (i2 > 0) {
                    f = Float.valueOf(i2 / 1000.0f);
                } else {
                    f = null;
                }
                this.a.C(f);
            }
        }
    }

    /* loaded from: classes5.dex */
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

    public DanmakuPlayer(mt6 renderer, sr6 sr6Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {renderer, sr6Var};
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
        this.b = wr6.a.c(wr6.m, renderer, null, 2, null);
        this.c = LazyKt__LazyJVMKt.lazy(DanmakuPlayer$actionThread$2.INSTANCE);
        this.d = LazyKt__LazyJVMKt.lazy(new Function0<a>(this) { // from class: com.baidu.tieba.danmu.ui.DanmakuPlayer$actionHandler$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DanmakuPlayer this$0;

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
            public final DanmakuPlayer.a invoke() {
                InterceptResult invokeV;
                HandlerThread h;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    DanmakuPlayer danmakuPlayer = this.this$0;
                    h = danmakuPlayer.h();
                    Looper looper = h.getLooper();
                    Intrinsics.checkNotNullExpressionValue(looper, "actionThread.looper");
                    return new DanmakuPlayer.a(danmakuPlayer, looper);
                }
                return (DanmakuPlayer.a) invokeV.objValue;
            }
        });
        this.e = LazyKt__LazyJVMKt.lazy(new Function0<b>(this) { // from class: com.baidu.tieba.danmu.ui.DanmakuPlayer$frameCallback$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ DanmakuPlayer this$0;

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
            public final DanmakuPlayer.b invoke() {
                InterceptResult invokeV;
                DanmakuPlayer.a g;
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null && (invokeV = interceptable2.invokeV(1048576, this)) != null) {
                    return (DanmakuPlayer.b) invokeV.objValue;
                }
                g = this.this$0.g();
                return new DanmakuPlayer.b(g);
            }
        });
        this.h = 1.0f;
        this.j = new Semaphore(0);
        if (sr6Var == null) {
            return;
        }
        sr6Var.a(l());
        throw null;
    }

    public /* synthetic */ DanmakuPlayer(mt6 mt6Var, sr6 sr6Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(mt6Var, (i & 2) != 0 ? null : sr6Var);
    }

    public static final void y(DanmakuPlayer this$0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, this$0) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.r();
        }
    }

    public final void A(kr6 kr6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, kr6Var) == null) {
            this.i = kr6Var;
            wr6 wr6Var = this.b;
            if (kr6Var == null) {
                return;
            }
            wr6Var.G(kr6Var);
        }
    }

    public final List<qr6> k(RectF hitRect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, hitRect)) == null) {
            Intrinsics.checkNotNullParameter(hitRect, "hitRect");
            RenderSystem renderSystem = (RenderSystem) this.b.k(RenderSystem.class);
            if (renderSystem != null) {
                return renderSystem.n(hitRect);
            }
            return null;
        }
        return (List) invokeL.objValue;
    }

    public final qr6 p(rr6 danmaku) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, danmaku)) == null) {
            Intrinsics.checkNotNullParameter(danmaku, "danmaku");
            return xt6.a.a(danmaku, this);
        }
        return (qr6) invokeL.objValue;
    }

    public final qr6 v(rr6 danmaku) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, danmaku)) == null) {
            Intrinsics.checkNotNullParameter(danmaku, "danmaku");
            qr6 p = p(danmaku);
            DataSystem l = l();
            if (l != null) {
                l.x(p);
            }
            return p;
        }
        return (qr6) invokeL.objValue;
    }

    public final void w(rt6 rt6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, rt6Var) == null) && !Intrinsics.areEqual(this.l, rt6Var)) {
            this.l = rt6Var;
            RenderSystem renderSystem = (RenderSystem) this.b.k(RenderSystem.class);
            if (renderSystem != null) {
                renderSystem.r(rt6Var);
            }
        }
    }

    public final void x(kr6 kr6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, kr6Var) == null) {
            if (kr6Var != null) {
                A(kr6Var);
            }
            this.b.D();
            if (!this.k) {
                this.k = true;
                if (!n) {
                    g().post(new Runnable() { // from class: com.baidu.tieba.pt6
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
        }
    }

    public final List<qr6> B(List<rr6> dataList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataList)) == null) {
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(dataList, 10));
            for (rr6 rr6Var : dataList) {
                arrayList.add(p(rr6Var));
            }
            DataSystem l = l();
            if (l != null) {
                l.y(arrayList);
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
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
            this.b.v().g(danmakuView.getDisplayer$danmu_release());
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
                wr6.F(this.b, null, 1, null);
            }
            this.j.tryAcquire();
            if (!this.k) {
                t();
            } else {
                this.b.t(canvas, new Function0<Unit>(this) { // from class: com.baidu.tieba.danmu.ui.DanmakuPlayer$draw$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ DanmakuPlayer this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
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
                        this.this$0 = this;
                    }

                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                            return;
                        }
                        this.this$0.t();
                    }
                });
            }
        }
    }

    public final void u(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048597, this, j) == null) {
            BdLog.d("DanmakuEngine [Player] SeekTo(" + j + ')');
            kr6 i = i();
            if (i != null) {
                i.E();
            }
            this.b.C(Math.max(j, 0L));
        }
    }

    public final void C(Float f) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, f) != null) || !this.k) {
            return;
        }
        if (n) {
            this.b.E(f);
        } else {
            r();
            this.b.A();
            this.j.acquire();
        }
        if (!this.k) {
            return;
        }
        bt6.b("updateFrame");
        this.b.s();
        bt6.b("postInvalidate");
        DanmakuView danmakuView = this.a;
        if (danmakuView != null) {
            danmakuView.postInvalidateOnAnimation();
        }
        bt6.a();
        bt6.a();
    }

    public final void E(int i, int i2, float f) {
        kr6 kr6Var;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f)}) != null) || (kr6Var = this.i) == null) {
            return;
        }
        if (this.f == i && this.g == i2) {
            if (this.h == f) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return;
            }
        }
        long clamp = MathUtils.clamp(((float) 13000) * ((i * f) / 682), 9000L, 15000L);
        if (kr6Var.t() != clamp) {
            kr6Var.A(clamp);
            kr6Var.I();
            kr6Var.F();
            kr6Var.J();
        }
        BdLog.d("XanaDanmaku [Factor] update rolling duration to " + clamp);
        this.f = i;
        this.g = i2;
        this.h = f;
    }

    public final a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return (a) this.d.getValue();
        }
        return (a) invokeV.objValue;
    }

    public final HandlerThread h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return (HandlerThread) this.c.getValue();
        }
        return (HandlerThread) invokeV.objValue;
    }

    public final kr6 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.b.u();
        }
        return (kr6) invokeV.objValue;
    }

    public final long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.b.w();
        }
        return invokeV.longValue;
    }

    public final DataSystem l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return (DataSystem) this.b.k(DataSystem.class);
        }
        return (DataSystem) invokeV.objValue;
    }

    public final wr6 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.b;
        }
        return (wr6) invokeV.objValue;
    }

    public final b n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return (b) this.e.getValue();
        }
        return (b) invokeV.objValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.b.z();
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            Choreographer.getInstance().postFrameCallback(n());
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && this.j.availablePermits() == 0) {
            this.j.release();
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            this.b.z();
            u(0L);
        }
    }

    public final void o(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048591, this, i, i2) == null) {
            qt6 d = this.b.v().d();
            E(i, i2, d.d());
            D();
            if (d.getWidth() != i || d.getHeight() != i2) {
                BdLog.d("DanmakuEngine notifyDisplayerSizeChanged(" + i + StringUtil.ARRAY_ELEMENT_SEPARATOR + i2 + ')');
                d.setWidth(i);
                d.setHeight(i2);
                g().obtainMessage(2201).sendToTarget();
            }
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048595, this) != null) || this.m) {
            return;
        }
        this.m = true;
        g().removeCallbacksAndMessages(null);
        Choreographer.getInstance().removeFrameCallback(n());
        this.k = false;
        h().quitSafely();
        h().join(50L);
        this.b.B();
    }
}
