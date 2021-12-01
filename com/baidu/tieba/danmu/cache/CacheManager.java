package com.baidu.tieba.danmu.cache;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import c.a.r0.m0.c.c;
import c.a.r0.m0.g.e;
import c.a.r0.m0.k.g;
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
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 92\u00020\u0001:\u0003789B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020#J\u000e\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020'J\u0010\u0010(\u001a\u0004\u0018\u00010 2\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020#J\u000e\u0010,\u001a\u00020#2\u0006\u0010&\u001a\u00020'J\u001e\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203J\u0006\u00104\u001a\u00020#J\u001e\u00105\u001a\u00020#2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000203J\u0006\u00106\u001a\u00020#R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\t\u001a\u00060\nR\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bRN\u0010\u001c\u001aB\u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u001e0\u001e\u0012\f\u0012\n \u001f*\u0004\u0018\u00010 0  \u001f* \u0012\f\u0012\n \u001f*\u0004\u0018\u00010\u001e0\u001e\u0012\f\u0012\n \u001f*\u0004\u0018\u00010 0 \u0018\u00010!0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/baidu/tieba/danmu/cache/CacheManager;", "", "callbackHandler", "Landroid/os/Handler;", "renderer", "Lcom/baidu/tieba/danmu/render/DanmakuRenderer;", "(Landroid/os/Handler;Lcom/baidu/tieba/danmu/render/DanmakuRenderer;)V", "available", "", "cacheHandler", "Lcom/baidu/tieba/danmu/cache/CacheManager$CacheHandler;", "getCacheHandler", "()Lcom/baidu/tieba/danmu/cache/CacheManager$CacheHandler;", "cacheHandler$delegate", "Lkotlin/Lazy;", "cachePool", "Lcom/baidu/tieba/danmu/cache/DrawingCachePool;", "getCachePool", "()Lcom/baidu/tieba/danmu/cache/DrawingCachePool;", "cacheThread", "Landroid/os/HandlerThread;", "getCacheThread", "()Landroid/os/HandlerThread;", "cacheThread$delegate", "cancelFlag", "<set-?>", "isReleased", "()Z", "measureSizeCache", "", "", "kotlin.jvm.PlatformType", "Lcom/baidu/tieba/danmu/utils/Size;", "", "cancelAllRequests", "", "clearMeasureCache", "destroyCache", "cache", "Lcom/baidu/tieba/danmu/cache/DrawingCache;", "getDanmakuSize", "danmaku", "Lcom/baidu/tieba/danmu/data/DanmakuItemData;", "release", "releaseCache", "requestBuildCache", "item", "Lcom/baidu/tieba/danmu/data/DanmakuItem;", "displayer", "Lcom/baidu/tieba/danmu/ui/DanmakuDisplayer;", UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, "Lcom/baidu/tieba/danmu/DanmakuConfig;", "requestBuildSign", "requestMeasure", "requestRelease", "CacheHandler", "CacheInfo", "Companion", "danmu_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes10.dex */
public final class CacheManager {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;

    /* renamed from: b  reason: collision with root package name */
    public final c.a.r0.m0.i.a f43325b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f43326c;

    /* renamed from: d  reason: collision with root package name */
    public final Lazy f43327d;

    /* renamed from: e  reason: collision with root package name */
    public final Lazy f43328e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f43329f;

    /* renamed from: g  reason: collision with root package name */
    public final Map<Long, g> f43330g;

    /* renamed from: h  reason: collision with root package name */
    public final c f43331h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f43332i;

    /* loaded from: classes10.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                int i2 = msg.what;
                if (i2 != -100) {
                    switch (i2) {
                        case -1:
                            this.a.a.sendEmptyMessage(-1);
                            return;
                        case 0:
                            Object obj = msg.obj;
                            b bVar = obj instanceof b ? (b) obj : null;
                            if (bVar == null) {
                                return;
                            }
                            c.a.r0.m0.a a = bVar.a();
                            c.a.r0.m0.e.a c2 = bVar.c();
                            if (this.a.f43329f) {
                                BdLog.d("DanmakuEngine [CacheManager] cancel cache.");
                                this.a.f43329f = false;
                                return;
                            }
                            e.b("CacheManager_checkMeasure");
                            DrawState f2 = c2.f();
                            if (!f2.r(a.p())) {
                                g a2 = this.a.f43325b.a(c2, bVar.b(), a);
                                f2.I(a2.b());
                                f2.x(a2.a());
                                f2.z(a.p());
                                c2.o(ItemState.Measured);
                            }
                            e.a();
                            return;
                        case 1:
                            Object obj2 = msg.obj;
                            b bVar2 = obj2 instanceof b ? (b) obj2 : null;
                            if (bVar2 == null) {
                                return;
                            }
                            e.b("CacheManager_buildCache");
                            c.a.r0.m0.a a3 = bVar2.a();
                            c.a.r0.m0.e.a c3 = bVar2.c();
                            DrawState f3 = c3.f();
                            e.b("CacheManager_checkCache");
                            if (f3.c().g() == null || Intrinsics.areEqual(f3.c(), c.a.r0.m0.c.a.f19836f.a()) || a(f3)) {
                                if (!Intrinsics.areEqual(f3.c(), c.a.r0.m0.c.a.f19836f.a()) && f3.c().g() != null) {
                                    f3.c().d();
                                }
                                c.a.r0.m0.c.a a4 = this.a.j().a((int) f3.q(), (int) f3.d());
                                if (a4 == null) {
                                    a4 = new c.a.r0.m0.c.a();
                                    a4.b((int) f3.q(), (int) f3.d(), bVar2.b().a(), true, (r12 & 16) != 0 ? 32 : 0);
                                }
                                f3.w(a4);
                                f3.c().f();
                                f3.c().m();
                                f3.c().o(this.a);
                            }
                            e.a();
                            e.b("CacheManager_drawCache");
                            c.a.r0.m0.c.b g2 = f3.c().g();
                            if (g2 == null) {
                                this.a.j().c(f3.c());
                                f3.w(c.a.r0.m0.c.a.f19836f.a());
                                c3.o(ItemState.Error);
                                return;
                            }
                            CacheManager cacheManager = this.a;
                            synchronized (f3) {
                                try {
                                    cacheManager.f43325b.b(c3, g2.d(), bVar2.b(), a3);
                                    c3.o(ItemState.Rendered);
                                    c3.f().v(a3.h());
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    c3.o(ItemState.Error);
                                }
                                Unit unit = Unit.INSTANCE;
                            }
                            e.a();
                            e.a();
                            return;
                        case 2:
                            removeCallbacksAndMessages(null);
                            return;
                        case 3:
                            Map measureSizeCache = this.a.f43330g;
                            Intrinsics.checkNotNullExpressionValue(measureSizeCache, "measureSizeCache");
                            CacheManager cacheManager2 = this.a;
                            synchronized (measureSizeCache) {
                                cacheManager2.f43330g.clear();
                                Unit unit2 = Unit.INSTANCE;
                            }
                            return;
                        case 4:
                            Object obj3 = msg.obj;
                            c.a.r0.m0.c.a aVar = obj3 instanceof c.a.r0.m0.c.a ? (c.a.r0.m0.c.a) obj3 : null;
                            if (aVar == null) {
                                return;
                            }
                            aVar.e();
                            return;
                        case 5:
                            Object obj4 = msg.obj;
                            c.a.r0.m0.c.a aVar2 = obj4 instanceof c.a.r0.m0.c.a ? (c.a.r0.m0.c.a) obj4 : null;
                            if (aVar2 == null || this.a.j().c(aVar2)) {
                                return;
                            }
                            aVar2.e();
                            return;
                        default:
                            return;
                    }
                }
                this.a.j().b();
                this.a.f43332i = true;
                this.a.k().quitSafely();
            }
        }
    }

    /* loaded from: classes10.dex */
    public static final class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final c.a.r0.m0.e.a a;

        /* renamed from: b  reason: collision with root package name */
        public final c.a.r0.m0.j.b f43333b;

        /* renamed from: c  reason: collision with root package name */
        public final c.a.r0.m0.a f43334c;

        public b(c.a.r0.m0.e.a item, c.a.r0.m0.j.b displayer, c.a.r0.m0.a config) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {item, displayer, config};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            Intrinsics.checkNotNullParameter(config, "config");
            this.a = item;
            this.f43333b = displayer;
            this.f43334c = config;
        }

        public final c.a.r0.m0.a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f43334c : (c.a.r0.m0.a) invokeV.objValue;
        }

        public final c.a.r0.m0.j.b b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f43333b : (c.a.r0.m0.j.b) invokeV.objValue;
        }

        public final c.a.r0.m0.e.a c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a : (c.a.r0.m0.e.a) invokeV.objValue;
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

    public CacheManager(Handler callbackHandler, c.a.r0.m0.i.a renderer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {callbackHandler, renderer};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(callbackHandler, "callbackHandler");
        Intrinsics.checkNotNullParameter(renderer, "renderer");
        this.a = callbackHandler;
        this.f43325b = renderer;
        this.f43327d = LazyKt__LazyJVMKt.lazy(new CacheManager$cacheThread$2(this));
        this.f43328e = LazyKt__LazyJVMKt.lazy(new CacheManager$cacheHandler$2(this));
        this.f43330g = Collections.synchronizedMap(new LinkedHashMap());
        this.f43331h = new c(c.a.r0.m0.a.x.b());
    }

    public final a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? (a) this.f43328e.getValue() : (a) invokeV.objValue;
    }

    public final c j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f43331h : (c) invokeV.objValue;
    }

    public final HandlerThread k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (HandlerThread) this.f43327d.getValue() : (HandlerThread) invokeV.objValue;
    }

    public final void l(c.a.r0.m0.c.a cache) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cache) == null) {
            Intrinsics.checkNotNullParameter(cache, "cache");
            if (Intrinsics.areEqual(cache, c.a.r0.m0.c.a.f19836f.a())) {
                return;
            }
            i().obtainMessage(5, cache).sendToTarget();
        }
    }

    public final void m(c.a.r0.m0.e.a item, c.a.r0.m0.j.b displayer, c.a.r0.m0.a config) {
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

    public final void o(c.a.r0.m0.e.a item, c.a.r0.m0.j.b displayer, c.a.r0.m0.a config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, item, displayer, config) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            Intrinsics.checkNotNullParameter(config, "config");
            i().obtainMessage(0, new b(item, displayer, config)).sendToTarget();
        }
    }
}
