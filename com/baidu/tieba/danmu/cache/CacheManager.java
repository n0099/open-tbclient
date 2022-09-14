package com.baidu.tieba.danmu.cache;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.a46;
import com.baidu.tieba.b46;
import com.baidu.tieba.d46;
import com.baidu.tieba.d66;
import com.baidu.tieba.danmu.data.ItemState;
import com.baidu.tieba.danmu.data.state.DrawState;
import com.baidu.tieba.l66;
import com.baidu.tieba.o56;
import com.baidu.tieba.x36;
import com.baidu.tieba.z36;
import com.baidu.tieba.z56;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 92\u00020\u0001:\u0003789B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020#J\u000e\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020'J\u0010\u0010(\u001a\u0004\u0018\u00010 2\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020#J\u000e\u0010,\u001a\u00020#2\u0006\u0010&\u001a\u00020'J\u001e\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203J\u0006\u00104\u001a\u00020#J\u001e\u00105\u001a\u00020#2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203J\u0006\u00106\u001a\u00020#R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\t\u001a\u00060\nR\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bRN\u0010\u001c\u001aB\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u001e0\u001e\u0012\f\u0012\n \u001f*\u0004\u0018\u00010 0  \u001f* \u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u001e0\u001e\u0012\f\u0012\n \u001f*\u0004\u0018\u00010 0 \u0018\u00010!0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/baidu/tieba/danmu/cache/CacheManager;", "", "callbackHandler", "Landroid/os/Handler;", "renderer", "Lcom/baidu/tieba/danmu/render/DanmakuRenderer;", "(Landroid/os/Handler;Lcom/baidu/tieba/danmu/render/DanmakuRenderer;)V", "available", "", "cacheHandler", "Lcom/baidu/tieba/danmu/cache/CacheManager$CacheHandler;", "getCacheHandler", "()Lcom/baidu/tieba/danmu/cache/CacheManager$CacheHandler;", "cacheHandler$delegate", "Lkotlin/Lazy;", "cachePool", "Lcom/baidu/tieba/danmu/cache/DrawingCachePool;", "getCachePool", "()Lcom/baidu/tieba/danmu/cache/DrawingCachePool;", "cacheThread", "Landroid/os/HandlerThread;", "getCacheThread", "()Landroid/os/HandlerThread;", "cacheThread$delegate", "cancelFlag", "<set-?>", "isReleased", "()Z", "measureSizeCache", "", "", "kotlin.jvm.PlatformType", "Lcom/baidu/tieba/danmu/utils/Size;", "", "cancelAllRequests", "", "clearMeasureCache", "destroyCache", "cache", "Lcom/baidu/tieba/danmu/cache/DrawingCache;", "getDanmakuSize", "danmaku", "Lcom/baidu/tieba/danmu/data/DanmakuItemData;", "release", "releaseCache", "requestBuildCache", "item", "Lcom/baidu/tieba/danmu/data/DanmakuItem;", "displayer", "Lcom/baidu/tieba/danmu/ui/DanmakuDisplayer;", "config", "Lcom/baidu/tieba/danmu/DanmakuConfig;", "requestBuildSign", "requestMeasure", "requestRelease", "CacheHandler", "CacheInfo", "Companion", "danmu_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class CacheManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;
    public final z56 b;
    public boolean c;
    public final Lazy d;
    public final Lazy e;
    public boolean f;
    public final Map<Long, l66> g;
    public final b46 h;
    public boolean i;

    /* loaded from: classes3.dex */
    public final class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CacheManager a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CacheManager this$0, Looper looper) {
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

        public final boolean a(DrawState drawState) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, drawState)) == null) ? ((float) drawState.c().l()) < drawState.q() || ((float) drawState.c().j()) < drawState.d() || ((float) drawState.c().l()) - drawState.q() > 5.0f || ((float) drawState.c().j()) - drawState.d() > 5.0f : invokeL.booleanValue;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, msg) == null) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                int i = msg.what;
                if (i != -100) {
                    switch (i) {
                        case -1:
                            this.a.a.sendEmptyMessage(-1);
                            return;
                        case 0:
                            Object obj = msg.obj;
                            b bVar = obj instanceof b ? (b) obj : null;
                            if (bVar == null) {
                                return;
                            }
                            x36 a = bVar.a();
                            d46 c = bVar.c();
                            if (this.a.f) {
                                BdLog.d("DanmakuEngine [CacheManager] cancel cache.");
                                this.a.f = false;
                                return;
                            }
                            o56.b("CacheManager_checkMeasure");
                            DrawState f = c.f();
                            if (!f.r(a.p())) {
                                l66 a2 = this.a.b.a(c, bVar.b(), a);
                                f.I(a2.b());
                                f.x(a2.a());
                                f.z(a.p());
                                c.o(ItemState.Measured);
                            }
                            o56.a();
                            return;
                        case 1:
                            Object obj2 = msg.obj;
                            b bVar2 = obj2 instanceof b ? (b) obj2 : null;
                            if (bVar2 == null) {
                                return;
                            }
                            o56.b("CacheManager_buildCache");
                            x36 a3 = bVar2.a();
                            d46 c2 = bVar2.c();
                            DrawState f2 = c2.f();
                            o56.b("CacheManager_checkCache");
                            if (f2.c().g() == null || Intrinsics.areEqual(f2.c(), z36.f.a()) || a(f2)) {
                                if (!Intrinsics.areEqual(f2.c(), z36.f.a()) && f2.c().g() != null) {
                                    f2.c().d();
                                }
                                z36 a4 = this.a.j().a((int) f2.q(), (int) f2.d());
                                if (a4 == null) {
                                    a4 = new z36();
                                    a4.b((int) f2.q(), (int) f2.d(), bVar2.b().a(), true, (r12 & 16) != 0 ? 32 : 0);
                                }
                                f2.w(a4);
                                f2.c().f();
                                f2.c().m();
                                f2.c().o(this.a);
                            }
                            o56.a();
                            o56.b("CacheManager_drawCache");
                            a46 g = f2.c().g();
                            if (g == null) {
                                this.a.j().c(f2.c());
                                f2.w(z36.f.a());
                                c2.o(ItemState.Error);
                                return;
                            }
                            CacheManager cacheManager = this.a;
                            synchronized (f2) {
                                try {
                                    cacheManager.b.b(c2, g.d(), bVar2.b(), a3);
                                    c2.o(ItemState.Rendered);
                                    c2.f().v(a3.h());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    c2.o(ItemState.Error);
                                }
                                Unit unit = Unit.INSTANCE;
                            }
                            o56.a();
                            o56.a();
                            return;
                        case 2:
                            removeCallbacksAndMessages(null);
                            return;
                        case 3:
                            Map measureSizeCache = this.a.g;
                            Intrinsics.checkNotNullExpressionValue(measureSizeCache, "measureSizeCache");
                            CacheManager cacheManager2 = this.a;
                            synchronized (measureSizeCache) {
                                cacheManager2.g.clear();
                                Unit unit2 = Unit.INSTANCE;
                            }
                            return;
                        case 4:
                            Object obj3 = msg.obj;
                            z36 z36Var = obj3 instanceof z36 ? (z36) obj3 : null;
                            if (z36Var == null) {
                                return;
                            }
                            z36Var.e();
                            return;
                        case 5:
                            Object obj4 = msg.obj;
                            z36 z36Var2 = obj4 instanceof z36 ? (z36) obj4 : null;
                            if (z36Var2 == null || this.a.j().c(z36Var2)) {
                                return;
                            }
                            z36Var2.e();
                            return;
                        default:
                            return;
                    }
                }
                this.a.j().b();
                this.a.i = true;
                this.a.k().quitSafely();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final d46 a;
        public final d66 b;
        public final x36 c;

        public b(d46 item, d66 displayer, x36 config) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {item, displayer, config};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            Intrinsics.checkNotNullParameter(config, "config");
            this.a = item;
            this.b = displayer;
            this.c = config;
        }

        public final x36 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.c : (x36) invokeV.objValue;
        }

        public final d66 b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (d66) invokeV.objValue;
        }

        public final d46 c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (d46) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1187436479, "Lcom/baidu/tieba/danmu/cache/CacheManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1187436479, "Lcom/baidu/tieba/danmu/cache/CacheManager;");
        }
    }

    public CacheManager(Handler callbackHandler, z56 renderer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callbackHandler, renderer};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(callbackHandler, "callbackHandler");
        Intrinsics.checkNotNullParameter(renderer, "renderer");
        this.a = callbackHandler;
        this.b = renderer;
        this.d = LazyKt__LazyJVMKt.lazy(new CacheManager$cacheThread$2(this));
        this.e = LazyKt__LazyJVMKt.lazy(new CacheManager$cacheHandler$2(this));
        this.g = Collections.synchronizedMap(new LinkedHashMap());
        this.h = new b46(x36.x.b());
    }

    public final a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (a) this.e.getValue() : (a) invokeV.objValue;
    }

    public final b46 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.h : (b46) invokeV.objValue;
    }

    public final HandlerThread k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (HandlerThread) this.d.getValue() : (HandlerThread) invokeV.objValue;
    }

    public final void l(z36 cache) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cache) == null) {
            Intrinsics.checkNotNullParameter(cache, "cache");
            if (Intrinsics.areEqual(cache, z36.f.a())) {
                return;
            }
            i().obtainMessage(5, cache).sendToTarget();
        }
    }

    public final void m(d46 item, d66 displayer, x36 config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, item, displayer, config) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            Intrinsics.checkNotNullParameter(config, "config");
            i().obtainMessage(1, new b(item, displayer, config)).sendToTarget();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            i().removeMessages(-1);
            i().sendEmptyMessage(-1);
        }
    }

    public final void o(d46 item, d66 displayer, x36 config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, item, displayer, config) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            Intrinsics.checkNotNullParameter(config, "config");
            i().obtainMessage(0, new b(item, displayer, config)).sendToTarget();
        }
    }
}
