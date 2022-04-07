package com.baidu.tieba.danmu.layout.retainer;

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
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.repackage.d06;
import com.repackage.d26;
import com.repackage.l16;
import com.repackage.xz5;
import com.repackage.y16;
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
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0002!\"B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0016J(\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0014H\u0016J\u0018\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006#"}, d2 = {"Lcom/baidu/tieba/danmu/layout/retainer/BottomRetainer;", "Lcom/baidu/tieba/danmu/layout/retainer/DanmakuRetainer;", "endRatio", "", "(F)V", "akRetainer", "Lcom/baidu/tieba/danmu/layout/retainer/BottomRetainer$AkRetainer;", "getAkRetainer", "()Lcom/baidu/tieba/danmu/layout/retainer/BottomRetainer$AkRetainer;", "akRetainer$delegate", "Lkotlin/Lazy;", "bilibiliRetainer", "Lcom/baidu/tieba/danmu/layout/retainer/BottomRetainer$BilibiliRetainer;", "getBilibiliRetainer", "()Lcom/baidu/tieba/danmu/layout/retainer/BottomRetainer$BilibiliRetainer;", "bilibiliRetainer$delegate", "clear", "", TtmlNode.TAG_LAYOUT, "drawItem", "Lcom/baidu/tieba/danmu/data/DanmakuItem;", "currentTimeMills", "", "displayer", "Lcom/baidu/tieba/danmu/ui/DanmakuDisplayer;", UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, "Lcom/baidu/tieba/danmu/DanmakuConfig;", "remove", "item", "update", "start", "", "end", "AkRetainer", "BilibiliRetainer", "danmu_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class BottomRetainer implements y16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy a;
    public final Lazy b;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0016J(\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0010H\u0016J\u0018\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/baidu/tieba/danmu/layout/retainer/BottomRetainer$AkRetainer;", "Lcom/baidu/tieba/danmu/layout/retainer/DanmakuRetainer;", "ratio", "", "(F)V", "lastVisibleEntities", "Ljava/util/TreeSet;", "Lcom/baidu/tieba/danmu/layout/retainer/DanmakuRetainer$SpaceHolder;", "kotlin.jvm.PlatformType", "getRatio", "()F", "setRatio", "clear", "", TtmlNode.TAG_LAYOUT, "drawItem", "Lcom/baidu/tieba/danmu/data/DanmakuItem;", "currentTimeMills", "", "displayer", "Lcom/baidu/tieba/danmu/ui/DanmakuDisplayer;", UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, "Lcom/baidu/tieba/danmu/DanmakuConfig;", "remove", "item", "update", "start", "", "end", "danmu_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class AkRetainer implements y16 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;
        public final TreeSet<y16.d> b;

        public AkRetainer(float f) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Float.valueOf(f)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f;
            this.b = new TreeSet<>(new y16.e());
        }

        /* JADX WARN: Removed duplicated region for block: B:49:0x0124  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x012b A[LOOP:0: B:34:0x00d7->B:54:0x012b, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:97:0x012a A[SYNTHETIC] */
        @Override // com.repackage.y16
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public float a(d06 drawItem, long j, d26 displayer, xz5 config) {
            InterceptResult invokeCommon;
            DrawState drawState;
            y16.d dVar;
            Pair pair;
            boolean z;
            Object obj;
            int intValue;
            Pair pair2;
            boolean z2;
            d06 d;
            boolean z3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{drawItem, Long.valueOf(j), displayer, config})) == null) {
                Intrinsics.checkNotNullParameter(drawItem, "drawItem");
                Intrinsics.checkNotNullParameter(displayer, "displayer");
                Intrinsics.checkNotNullParameter(config, "config");
                DrawState f = drawItem.f();
                if (l16.d(drawItem, j)) {
                    b(drawItem);
                    return -1.0f;
                }
                y16.d dVar2 = r13;
                y16.d dVar3 = new y16.d(drawItem, drawItem.j(), (int) f.h(), (int) f.g(), (int) f.q(), (int) f.d(), 0, 0, 0L, FileUtils.S_IRWXU, null);
                synchronized (this.b) {
                    if (!(f.p() && f.e() == config.o())) {
                        TreeSet<y16.d> treeSet = this.b;
                        if (!(treeSet instanceof Collection) || !treeSet.isEmpty()) {
                            for (y16.d dVar4 : treeSet) {
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
                        if (z && f.e() == config.o()) {
                            pair2 = TuplesKt.to(Float.valueOf(f.h()), 0);
                            drawState = f;
                        } else {
                            Iterator it = SequencesKt___SequencesKt.toList(SequencesKt__SequenceBuilderKt.sequence(new BottomRetainer$AkRetainer$layout$1$targetHolders$1(displayer, this, displayer.c(), null))).iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    drawState = f;
                                    obj = null;
                                    break;
                                }
                                obj = it.next();
                                y16.b bVar = (y16.b) obj;
                                if (dVar.b() < bVar.b().getLast() - bVar.b().getFirst()) {
                                    y16.d a = bVar.a();
                                    if (a != null && (d = a.d()) != null) {
                                        drawState = f;
                                        if (l16.f(d, dVar.d(), displayer, j, config.k())) {
                                            z3 = true;
                                            if (!z3) {
                                                z2 = true;
                                                if (!z2) {
                                                    break;
                                                }
                                                f = drawState;
                                            }
                                        }
                                        z3 = false;
                                        if (!z3) {
                                        }
                                    }
                                    drawState = f;
                                    z3 = false;
                                    if (!z3) {
                                    }
                                } else {
                                    drawState = f;
                                }
                                z2 = false;
                                if (!z2) {
                                }
                            }
                            y16.b bVar2 = (y16.b) obj;
                            if (bVar2 == null) {
                                BdLog.v("DanmakuEngine [Retainer] no room for this");
                                drawState.y(config.o());
                                drawState.H(false);
                                return -1.0f;
                            }
                            dVar.i(bVar2.b().getLast() - dVar.b());
                            BdLog.v("DanmakuEngine [Retainer] range: " + new IntRange(dVar.g(), dVar.a()) + " with targetHolder " + bVar2.b());
                            y16.d a2 = bVar2.a();
                            if (a2 != null) {
                                this.b.remove(a2);
                            }
                            Float valueOf = Float.valueOf(dVar.g());
                            y16.d a3 = bVar2.a();
                            Integer valueOf2 = a3 == null ? null : Integer.valueOf(a3.c());
                            if (valueOf2 == null) {
                                intValue = this.b.size() + 1;
                            } else {
                                intValue = valueOf2.intValue();
                            }
                            pair2 = TuplesKt.to(valueOf, Integer.valueOf(intValue));
                        }
                        pair = TuplesKt.to(Float.valueOf(((Number) pair2.component1()).floatValue()), Integer.valueOf(((Number) pair2.component2()).intValue()));
                    } else {
                        drawState = f;
                        dVar = dVar2;
                        pair = TuplesKt.to(Float.valueOf(drawState.h()), 0);
                    }
                    float floatValue = ((Number) pair.component1()).floatValue();
                    boolean z4 = ((Number) pair.component2()).intValue() < 0;
                    this.b.add(dVar);
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

        @Override // com.repackage.y16
        public void b(d06 item) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, item) == null) {
                Intrinsics.checkNotNullParameter(item, "item");
                synchronized (this.b) {
                    CollectionsKt__MutableCollectionsKt.removeAll(this.b, new BottomRetainer$AkRetainer$remove$1$1(item));
                }
            }
        }

        @Override // com.repackage.y16
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.b.clear();
            }
        }

        public final float d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : invokeV.floatValue;
        }

        @Override // com.repackage.y16
        public void update(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            }
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/baidu/tieba/danmu/layout/retainer/BottomRetainer$BilibiliRetainer;", "Lcom/baidu/tieba/danmu/layout/retainer/DanmakuRetainer;", "()V", "cancelFlag", "", "lastVisibleEntities", "Ljava/util/TreeSet;", "Lcom/baidu/tieba/danmu/layout/retainer/DanmakuRetainer$SpaceHolder;", "kotlin.jvm.PlatformType", "clear", "", TtmlNode.TAG_LAYOUT, "", "drawItem", "Lcom/baidu/tieba/danmu/data/DanmakuItem;", "currentTimeMills", "", "displayer", "Lcom/baidu/tieba/danmu/ui/DanmakuDisplayer;", UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, "Lcom/baidu/tieba/danmu/DanmakuConfig;", "remove", "item", "update", "start", "", "end", "danmu_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class BilibiliRetainer implements y16 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final TreeSet<y16.d> b;

        public BilibiliRetainer() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = new TreeSet<>(new y16.e());
        }

        /* JADX WARN: Removed duplicated region for block: B:55:0x016e  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0182  */
        @Override // com.repackage.y16
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public float a(d06 drawItem, long j, d26 displayer, xz5 config) {
            InterceptResult invokeCommon;
            float height;
            y16.d dVar;
            boolean z;
            boolean z2;
            y16.d dVar2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{drawItem, Long.valueOf(j), displayer, config})) == null) {
                Intrinsics.checkNotNullParameter(drawItem, "drawItem");
                Intrinsics.checkNotNullParameter(displayer, "displayer");
                Intrinsics.checkNotNullParameter(config, "config");
                DrawState f = drawItem.f();
                if (l16.d(drawItem, j)) {
                    b(drawItem);
                    return -1.0f;
                }
                y16.d dVar3 = r12;
                y16.d dVar4 = new y16.d(drawItem, drawItem.j(), (int) f.h(), (int) f.g(), (int) f.q(), (int) f.d(), 0, 0, 0L, FileUtils.S_IRWXU, null);
                boolean z3 = f.p() && f.e() == config.o();
                if (z3 && f.h() >= displayer.e()) {
                    height = f.h();
                } else {
                    height = displayer.getHeight() - f.d();
                }
                y16.c cVar = new y16.c(0, null, null, null, null, null, false, false, false, false, 1023, null);
                if (z3) {
                    dVar = dVar3;
                    z = false;
                } else {
                    this.a = false;
                    float f2 = height;
                    for (y16.d dVar5 : SequencesKt___SequencesKt.takeWhile(CollectionsKt___CollectionsKt.asSequence(this.b), new BottomRetainer$BilibiliRetainer$layout$1(this, cVar))) {
                        cVar.g(cVar.c() + 1);
                        y16.d dVar6 = dVar3;
                        if (Intrinsics.areEqual(dVar6, dVar5)) {
                            cVar.h(null);
                            cVar.f(true);
                        } else {
                            if (cVar.a() == null) {
                                cVar.e(dVar5);
                                if (((int) f.i().bottom) != displayer.getHeight()) {
                                    cVar.f(true);
                                }
                            }
                            if (f2 < displayer.e()) {
                                cVar.h(null);
                                cVar.f(true);
                            } else {
                                dVar2 = dVar6;
                                if (!l16.f(dVar5.d(), dVar5.d(), displayer, j, config.k())) {
                                    cVar.h(dVar5);
                                    cVar.f(true);
                                } else {
                                    f2 = (dVar5.g() - displayer.c()) - f.d();
                                }
                                dVar3 = dVar2;
                            }
                        }
                        dVar2 = dVar6;
                        dVar3 = dVar2;
                    }
                    dVar = dVar3;
                    if (f2 >= displayer.e()) {
                        y16.d a = cVar.a();
                        if (a != null && a.a() == displayer.getHeight()) {
                            z2 = false;
                            if (!z2) {
                                cVar.g(1);
                                boolean z4 = z2;
                                height = displayer.getHeight() - f.d();
                                z = z4;
                            } else {
                                z = z2;
                                height = f2;
                                if (f2 == displayer.e()) {
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
                    y16.d d = cVar.d();
                    if (d != null) {
                        this.b.remove(d);
                    }
                    this.b.add(dVar);
                    dVar.h(cVar.c());
                }
                return height;
            }
            return invokeCommon.floatValue;
        }

        @Override // com.repackage.y16
        public void b(d06 item) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, item) == null) {
                Intrinsics.checkNotNullParameter(item, "item");
                CollectionsKt__MutableCollectionsKt.removeAll(this.b, new BottomRetainer$BilibiliRetainer$remove$1(item));
            }
        }

        @Override // com.repackage.y16
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a = true;
                this.b.clear();
            }
        }

        @Override // com.repackage.y16
        public void update(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            }
        }
    }

    public BottomRetainer(float f) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = LazyKt__LazyJVMKt.lazy(BottomRetainer$bilibiliRetainer$2.INSTANCE);
        this.b = LazyKt__LazyJVMKt.lazy(new BottomRetainer$akRetainer$2(f));
    }

    @Override // com.repackage.y16
    public float a(d06 drawItem, long j, d26 displayer, xz5 config) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{drawItem, Long.valueOf(j), displayer, config})) == null) {
            Intrinsics.checkNotNullParameter(drawItem, "drawItem");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            Intrinsics.checkNotNullParameter(config, "config");
            if (config.s() == 0) {
                return d().a(drawItem, j, displayer, config);
            }
            return c().a(drawItem, j, displayer, config);
        }
        return invokeCommon.floatValue;
    }

    @Override // com.repackage.y16
    public void b(d06 item) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (AkRetainer) this.b.getValue() : (AkRetainer) invokeV.objValue;
    }

    @Override // com.repackage.y16
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

    @Override // com.repackage.y16
    public void update(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            d().update(i, i2);
            c().update(i, i2);
        }
    }
}
