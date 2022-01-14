package com.baidu.tieba.danmu.layout.retainer;

import c.a.t0.m0.h.i.a;
import c.a.t0.m0.j.b;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.face.platform.utils.FileUtils;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.baidu.tieba.danmu.data.state.DrawState;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt__SequenceBuilderKt;
import kotlin.sequences.SequencesKt___SequencesKt;
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0002!\"B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0016J(\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0014H\u0016J\u0018\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006#"}, d2 = {"Lcom/baidu/tieba/danmu/layout/retainer/BottomRetainer;", "Lcom/baidu/tieba/danmu/layout/retainer/DanmakuRetainer;", "endRatio", "", "(F)V", "akRetainer", "Lcom/baidu/tieba/danmu/layout/retainer/BottomRetainer$AkRetainer;", "getAkRetainer", "()Lcom/baidu/tieba/danmu/layout/retainer/BottomRetainer$AkRetainer;", "akRetainer$delegate", "Lkotlin/Lazy;", "bilibiliRetainer", "Lcom/baidu/tieba/danmu/layout/retainer/BottomRetainer$BilibiliRetainer;", "getBilibiliRetainer", "()Lcom/baidu/tieba/danmu/layout/retainer/BottomRetainer$BilibiliRetainer;", "bilibiliRetainer$delegate", "clear", "", "layout", "drawItem", "Lcom/baidu/tieba/danmu/data/DanmakuItem;", "currentTimeMills", "", "displayer", "Lcom/baidu/tieba/danmu/ui/DanmakuDisplayer;", UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, "Lcom/baidu/tieba/danmu/DanmakuConfig;", "remove", "item", "update", "start", "", "end", "AkRetainer", "BilibiliRetainer", "danmu_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class BottomRetainer implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy a;

    /* renamed from: b  reason: collision with root package name */
    public final Lazy f42428b;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0016J(\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0010H\u0016J\u0018\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/baidu/tieba/danmu/layout/retainer/BottomRetainer$AkRetainer;", "Lcom/baidu/tieba/danmu/layout/retainer/DanmakuRetainer;", "ratio", "", "(F)V", "lastVisibleEntities", "Ljava/util/TreeSet;", "Lcom/baidu/tieba/danmu/layout/retainer/DanmakuRetainer$SpaceHolder;", "kotlin.jvm.PlatformType", "getRatio", "()F", "setRatio", "clear", "", "layout", "drawItem", "Lcom/baidu/tieba/danmu/data/DanmakuItem;", "currentTimeMills", "", "displayer", "Lcom/baidu/tieba/danmu/ui/DanmakuDisplayer;", UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, "Lcom/baidu/tieba/danmu/DanmakuConfig;", "remove", "item", "update", "start", "", "end", "danmu_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class AkRetainer implements a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;

        /* renamed from: b  reason: collision with root package name */
        public final TreeSet<a.d> f42429b;

        public AkRetainer(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f2;
            this.f42429b = new TreeSet<>(new a.e());
        }

        /* JADX WARN: Removed duplicated region for block: B:49:0x0124  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x012b A[LOOP:0: B:34:0x00d7->B:54:0x012b, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:97:0x012a A[SYNTHETIC] */
        @Override // c.a.t0.m0.h.i.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public float a(c.a.t0.m0.e.a drawItem, long j2, b displayer, c.a.t0.m0.a config) {
            InterceptResult invokeCommon;
            DrawState drawState;
            a.d dVar;
            Pair pair;
            boolean z;
            Object obj;
            int intValue;
            Pair pair2;
            boolean z2;
            c.a.t0.m0.e.a d2;
            boolean z3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{drawItem, Long.valueOf(j2), displayer, config})) == null) {
                Intrinsics.checkNotNullParameter(drawItem, "drawItem");
                Intrinsics.checkNotNullParameter(displayer, "displayer");
                Intrinsics.checkNotNullParameter(config, "config");
                DrawState f2 = drawItem.f();
                if (c.a.t0.m0.g.b.d(drawItem, j2)) {
                    b(drawItem);
                    return -1.0f;
                }
                a.d dVar2 = r13;
                a.d dVar3 = new a.d(drawItem, drawItem.j(), (int) f2.h(), (int) f2.g(), (int) f2.q(), (int) f2.d(), 0, 0, 0L, FileUtils.S_IRWXU, null);
                synchronized (this.f42429b) {
                    if (!(f2.p() && f2.e() == config.o())) {
                        TreeSet<a.d> treeSet = this.f42429b;
                        if (!(treeSet instanceof Collection) || !treeSet.isEmpty()) {
                            for (a.d dVar4 : treeSet) {
                                dVar = dVar2;
                                if (Intrinsics.areEqual(dVar4, dVar)) {
                                    z = true;
                                    break;
                                }
                                dVar2 = dVar;
                            }
                        }
                        dVar = dVar2;
                        z = false;
                        if (z && f2.e() == config.o()) {
                            pair2 = TuplesKt.to(Float.valueOf(f2.h()), 0);
                            drawState = f2;
                        } else {
                            Iterator it = SequencesKt___SequencesKt.toList(SequencesKt__SequenceBuilderKt.sequence(new BottomRetainer$AkRetainer$layout$1$targetHolders$1(displayer, this, displayer.c(), null))).iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    drawState = f2;
                                    obj = null;
                                    break;
                                }
                                obj = it.next();
                                a.b bVar = (a.b) obj;
                                if (dVar.b() < bVar.b().getLast() - bVar.b().getFirst()) {
                                    a.d a = bVar.a();
                                    if (a != null && (d2 = a.d()) != null) {
                                        drawState = f2;
                                        if (c.a.t0.m0.g.b.f(d2, dVar.d(), displayer, j2, config.k())) {
                                            z3 = true;
                                            if (!z3) {
                                                z2 = true;
                                                if (!z2) {
                                                    break;
                                                }
                                                f2 = drawState;
                                            }
                                        }
                                        z3 = false;
                                        if (!z3) {
                                        }
                                    }
                                    drawState = f2;
                                    z3 = false;
                                    if (!z3) {
                                    }
                                } else {
                                    drawState = f2;
                                }
                                z2 = false;
                                if (!z2) {
                                }
                            }
                            a.b bVar2 = (a.b) obj;
                            if (bVar2 == null) {
                                BdLog.v("DanmakuEngine [Retainer] no room for this");
                                drawState.y(config.o());
                                drawState.H(false);
                                return -1.0f;
                            }
                            dVar.i(bVar2.b().getLast() - dVar.b());
                            BdLog.v("DanmakuEngine [Retainer] range: " + new IntRange(dVar.g(), dVar.a()) + " with targetHolder " + bVar2.b());
                            a.d a2 = bVar2.a();
                            if (a2 != null) {
                                this.f42429b.remove(a2);
                            }
                            Float valueOf = Float.valueOf(dVar.g());
                            a.d a3 = bVar2.a();
                            Integer valueOf2 = a3 == null ? null : Integer.valueOf(a3.c());
                            if (valueOf2 == null) {
                                intValue = this.f42429b.size() + 1;
                            } else {
                                intValue = valueOf2.intValue();
                            }
                            pair2 = TuplesKt.to(valueOf, Integer.valueOf(intValue));
                        }
                        pair = TuplesKt.to(Float.valueOf(((Number) pair2.component1()).floatValue()), Integer.valueOf(((Number) pair2.component2()).intValue()));
                    } else {
                        drawState = f2;
                        dVar = dVar2;
                        pair = TuplesKt.to(Float.valueOf(drawState.h()), 0);
                    }
                    float floatValue = ((Number) pair.component1()).floatValue();
                    boolean z4 = ((Number) pair.component2()).intValue() < 0;
                    this.f42429b.add(dVar);
                    if (z4 && !config.e()) {
                        drawState.y(config.o());
                        drawState.H(false);
                        return -1.0f;
                    }
                    drawState.H(true);
                    return floatValue;
                }
            }
            return invokeCommon.floatValue;
        }

        @Override // c.a.t0.m0.h.i.a
        public void b(c.a.t0.m0.e.a item) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, item) == null) {
                Intrinsics.checkNotNullParameter(item, "item");
                synchronized (this.f42429b) {
                    CollectionsKt__MutableCollectionsKt.removeAll(this.f42429b, new BottomRetainer$AkRetainer$remove$1$1(item));
                }
            }
        }

        @Override // c.a.t0.m0.h.i.a
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f42429b.clear();
            }
        }

        public final float d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : invokeV.floatValue;
        }

        @Override // c.a.t0.m0.h.i.a
        public void update(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048580, this, i2, i3) == null) {
            }
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/baidu/tieba/danmu/layout/retainer/BottomRetainer$BilibiliRetainer;", "Lcom/baidu/tieba/danmu/layout/retainer/DanmakuRetainer;", "()V", "cancelFlag", "", "lastVisibleEntities", "Ljava/util/TreeSet;", "Lcom/baidu/tieba/danmu/layout/retainer/DanmakuRetainer$SpaceHolder;", "kotlin.jvm.PlatformType", "clear", "", "layout", "", "drawItem", "Lcom/baidu/tieba/danmu/data/DanmakuItem;", "currentTimeMills", "", "displayer", "Lcom/baidu/tieba/danmu/ui/DanmakuDisplayer;", UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, "Lcom/baidu/tieba/danmu/DanmakuConfig;", "remove", "item", "update", "start", "", "end", "danmu_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class BilibiliRetainer implements a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        /* renamed from: b  reason: collision with root package name */
        public final TreeSet<a.d> f42430b;

        public BilibiliRetainer() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42430b = new TreeSet<>(new a.e());
        }

        /* JADX WARN: Removed duplicated region for block: B:55:0x016e  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0182  */
        @Override // c.a.t0.m0.h.i.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public float a(c.a.t0.m0.e.a drawItem, long j2, b displayer, c.a.t0.m0.a config) {
            InterceptResult invokeCommon;
            float height;
            a.d dVar;
            boolean z;
            boolean z2;
            a.d dVar2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{drawItem, Long.valueOf(j2), displayer, config})) == null) {
                Intrinsics.checkNotNullParameter(drawItem, "drawItem");
                Intrinsics.checkNotNullParameter(displayer, "displayer");
                Intrinsics.checkNotNullParameter(config, "config");
                DrawState f2 = drawItem.f();
                if (c.a.t0.m0.g.b.d(drawItem, j2)) {
                    b(drawItem);
                    return -1.0f;
                }
                a.d dVar3 = r12;
                a.d dVar4 = new a.d(drawItem, drawItem.j(), (int) f2.h(), (int) f2.g(), (int) f2.q(), (int) f2.d(), 0, 0, 0L, FileUtils.S_IRWXU, null);
                boolean z3 = f2.p() && f2.e() == config.o();
                if (z3 && f2.h() >= displayer.e()) {
                    height = f2.h();
                } else {
                    height = displayer.getHeight() - f2.d();
                }
                a.c cVar = new a.c(0, null, null, null, null, null, false, false, false, false, 1023, null);
                if (z3) {
                    dVar = dVar3;
                    z = false;
                } else {
                    this.a = false;
                    float f3 = height;
                    for (a.d dVar5 : SequencesKt___SequencesKt.takeWhile(CollectionsKt___CollectionsKt.asSequence(this.f42430b), new BottomRetainer$BilibiliRetainer$layout$1(this, cVar))) {
                        cVar.g(cVar.c() + 1);
                        a.d dVar6 = dVar3;
                        if (Intrinsics.areEqual(dVar6, dVar5)) {
                            cVar.h(null);
                            cVar.f(true);
                        } else {
                            if (cVar.a() == null) {
                                cVar.e(dVar5);
                                if (((int) f2.i().bottom) != displayer.getHeight()) {
                                    cVar.f(true);
                                }
                            }
                            if (f3 < displayer.e()) {
                                cVar.h(null);
                                cVar.f(true);
                            } else {
                                dVar2 = dVar6;
                                if (!c.a.t0.m0.g.b.f(dVar5.d(), dVar5.d(), displayer, j2, config.k())) {
                                    cVar.h(dVar5);
                                    cVar.f(true);
                                } else {
                                    f3 = (dVar5.g() - displayer.c()) - f2.d();
                                }
                                dVar3 = dVar2;
                            }
                        }
                        dVar2 = dVar6;
                        dVar3 = dVar2;
                    }
                    dVar = dVar3;
                    if (f3 >= displayer.e()) {
                        a.d a = cVar.a();
                        if (a != null && a.a() == displayer.getHeight()) {
                            z2 = false;
                            if (!z2) {
                                cVar.g(1);
                                boolean z4 = z2;
                                height = displayer.getHeight() - f2.d();
                                z = z4;
                            } else {
                                z = z2;
                                height = f3;
                                if (f3 == displayer.e()) {
                                    z3 = false;
                                }
                            }
                        }
                    }
                    z2 = true;
                    if (!z2) {
                    }
                }
                if (z) {
                    clear();
                }
                if (!z3) {
                    a.d d2 = cVar.d();
                    if (d2 != null) {
                        this.f42430b.remove(d2);
                    }
                    this.f42430b.add(dVar);
                    dVar.h(cVar.c());
                }
                return height;
            }
            return invokeCommon.floatValue;
        }

        @Override // c.a.t0.m0.h.i.a
        public void b(c.a.t0.m0.e.a item) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, item) == null) {
                Intrinsics.checkNotNullParameter(item, "item");
                CollectionsKt__MutableCollectionsKt.removeAll(this.f42430b, new BottomRetainer$BilibiliRetainer$remove$1(item));
            }
        }

        @Override // c.a.t0.m0.h.i.a
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a = true;
                this.f42430b.clear();
            }
        }

        @Override // c.a.t0.m0.h.i.a
        public void update(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            }
        }
    }

    public BottomRetainer(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = LazyKt__LazyJVMKt.lazy(BottomRetainer$bilibiliRetainer$2.INSTANCE);
        this.f42428b = LazyKt__LazyJVMKt.lazy(new BottomRetainer$akRetainer$2(f2));
    }

    @Override // c.a.t0.m0.h.i.a
    public float a(c.a.t0.m0.e.a drawItem, long j2, b displayer, c.a.t0.m0.a config) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{drawItem, Long.valueOf(j2), displayer, config})) == null) {
            Intrinsics.checkNotNullParameter(drawItem, "drawItem");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            Intrinsics.checkNotNullParameter(config, "config");
            if (config.s() == 0) {
                return d().a(drawItem, j2, displayer, config);
            }
            return c().a(drawItem, j2, displayer, config);
        }
        return invokeCommon.floatValue;
    }

    @Override // c.a.t0.m0.h.i.a
    public void b(c.a.t0.m0.e.a item) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, item) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            d().b(item);
            c().b(item);
        }
    }

    public final AkRetainer c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (AkRetainer) this.f42428b.getValue() : (AkRetainer) invokeV.objValue;
    }

    @Override // c.a.t0.m0.h.i.a
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            d().clear();
            c().clear();
        }
    }

    public final BilibiliRetainer d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? (BilibiliRetainer) this.a.getValue() : (BilibiliRetainer) invokeV.objValue;
    }

    @Override // c.a.t0.m0.h.i.a
    public void update(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
            d().update(i2, i3);
            c().update(i2, i3);
        }
    }
}
