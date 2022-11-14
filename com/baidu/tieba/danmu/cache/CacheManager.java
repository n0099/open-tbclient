package com.baidu.tieba.danmu.cache;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.b96;
import com.baidu.tieba.danmu.data.ItemState;
import com.baidu.tieba.danmu.data.state.DrawState;
import com.baidu.tieba.e86;
import com.baidu.tieba.n66;
import com.baidu.tieba.p66;
import com.baidu.tieba.p86;
import com.baidu.tieba.q66;
import com.baidu.tieba.r66;
import com.baidu.tieba.t66;
import com.baidu.tieba.t86;
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
    public final p86 b;
    public boolean c;
    public final Lazy d;
    public final Lazy e;
    public boolean f;
    public final Map<Long, b96> g;
    public final r66 h;
    public boolean i;

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
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, drawState)) == null) {
                if (drawState.c().l() >= drawState.q() && drawState.c().j() >= drawState.d() && drawState.c().l() - drawState.q() <= 5.0f && drawState.c().j() - drawState.d() <= 5.0f) {
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, msg) == null) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                int i = msg.what;
                if (i != -100) {
                    b bVar = null;
                    p66 p66Var = null;
                    p66 p66Var2 = null;
                    b bVar2 = null;
                    switch (i) {
                        case -1:
                            this.a.a.sendEmptyMessage(-1);
                            return;
                        case 0:
                            Object obj = msg.obj;
                            if (obj instanceof b) {
                                bVar = (b) obj;
                            }
                            if (bVar == null) {
                                return;
                            }
                            n66 a = bVar.a();
                            t66 c = bVar.c();
                            if (this.a.f) {
                                BdLog.d("DanmakuEngine [CacheManager] cancel cache.");
                                this.a.f = false;
                                return;
                            }
                            e86.b("CacheManager_checkMeasure");
                            DrawState f = c.f();
                            if (!f.r(a.p())) {
                                b96 a2 = this.a.b.a(c, bVar.b(), a);
                                f.I(a2.b());
                                f.x(a2.a());
                                f.z(a.p());
                                c.o(ItemState.Measured);
                            }
                            e86.a();
                            return;
                        case 1:
                            Object obj2 = msg.obj;
                            if (obj2 instanceof b) {
                                bVar2 = (b) obj2;
                            }
                            if (bVar2 == null) {
                                return;
                            }
                            e86.b("CacheManager_buildCache");
                            n66 a3 = bVar2.a();
                            t66 c2 = bVar2.c();
                            DrawState f2 = c2.f();
                            e86.b("CacheManager_checkCache");
                            if (f2.c().g() == null || Intrinsics.areEqual(f2.c(), p66.f.a()) || a(f2)) {
                                if (!Intrinsics.areEqual(f2.c(), p66.f.a()) && f2.c().g() != null) {
                                    f2.c().d();
                                }
                                p66 a4 = this.a.j().a((int) f2.q(), (int) f2.d());
                                if (a4 == null) {
                                    a4 = new p66();
                                    p66.c(a4, (int) f2.q(), (int) f2.d(), bVar2.b().a(), true, 0, 16, null);
                                }
                                f2.w(a4);
                                f2.c().f();
                                f2.c().m();
                                f2.c().o(this.a);
                            }
                            e86.a();
                            e86.b("CacheManager_drawCache");
                            q66 g = f2.c().g();
                            if (g == null) {
                                this.a.j().c(f2.c());
                                f2.w(p66.f.a());
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
                            e86.a();
                            e86.a();
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
                            if (obj3 instanceof p66) {
                                p66Var2 = (p66) obj3;
                            }
                            if (p66Var2 != null) {
                                p66Var2.e();
                                return;
                            }
                            return;
                        case 5:
                            Object obj4 = msg.obj;
                            if (obj4 instanceof p66) {
                                p66Var = (p66) obj4;
                            }
                            if (p66Var != null && !this.a.j().c(p66Var)) {
                                p66Var.e();
                                return;
                            }
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
        public final t66 a;
        public final t86 b;
        public final n66 c;

        public b(t66 item, t86 displayer, n66 config) {
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

        public final n66 a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.c;
            }
            return (n66) invokeV.objValue;
        }

        public final t86 b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.b;
            }
            return (t86) invokeV.objValue;
        }

        public final t66 c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.a;
            }
            return (t66) invokeV.objValue;
        }
    }

    public CacheManager(Handler callbackHandler, p86 renderer) {
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
        this.h = new r66(n66.x.b());
    }

    public final void l(p66 cache) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cache) == null) {
            Intrinsics.checkNotNullParameter(cache, "cache");
            if (Intrinsics.areEqual(cache, p66.f.a())) {
                return;
            }
            i().obtainMessage(5, cache).sendToTarget();
        }
    }

    public final a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return (a) this.e.getValue();
        }
        return (a) invokeV.objValue;
    }

    public final r66 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return (r66) invokeV.objValue;
    }

    public final HandlerThread k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (HandlerThread) this.d.getValue();
        }
        return (HandlerThread) invokeV.objValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            i().removeMessages(-1);
            i().sendEmptyMessage(-1);
        }
    }

    public final void m(t66 item, t86 displayer, n66 config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048580, this, item, displayer, config) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            Intrinsics.checkNotNullParameter(config, "config");
            i().obtainMessage(1, new b(item, displayer, config)).sendToTarget();
        }
    }

    public final void o(t66 item, t86 displayer, n66 config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, item, displayer, config) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            Intrinsics.checkNotNullParameter(config, "config");
            i().obtainMessage(0, new b(item, displayer, config)).sendToTarget();
        }
    }
}
