package com.baidu.tieba.danmu.layout.retainer;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.face.platform.utils.FileUtils;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.tieba.danmu.data.state.DrawState;
import com.baidu.tieba.danmu.layout.retainer.BottomRetainer;
import com.baidu.tieba.eu6;
import com.baidu.tieba.qs6;
import com.baidu.tieba.ru6;
import com.baidu.tieba.ws6;
import com.baidu.tieba.wu6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt__SequenceBuilderKt;
import kotlin.sequences.SequencesKt___SequencesKt;
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0002!\"B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0016J(\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u0014H\u0016J\u0018\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006#"}, d2 = {"Lcom/baidu/tieba/danmu/layout/retainer/BottomRetainer;", "Lcom/baidu/tieba/danmu/layout/retainer/DanmakuRetainer;", "endRatio", "", "(F)V", "akRetainer", "Lcom/baidu/tieba/danmu/layout/retainer/BottomRetainer$AkRetainer;", "getAkRetainer", "()Lcom/baidu/tieba/danmu/layout/retainer/BottomRetainer$AkRetainer;", "akRetainer$delegate", "Lkotlin/Lazy;", "bilibiliRetainer", "Lcom/baidu/tieba/danmu/layout/retainer/BottomRetainer$BilibiliRetainer;", "getBilibiliRetainer", "()Lcom/baidu/tieba/danmu/layout/retainer/BottomRetainer$BilibiliRetainer;", "bilibiliRetainer$delegate", DownloadStatisticConstants.UBC_VALUE_CLEAR, "", TtmlNode.TAG_LAYOUT, "drawItem", "Lcom/baidu/tieba/danmu/data/DanmakuItem;", "currentTimeMills", "", "displayer", "Lcom/baidu/tieba/danmu/ui/DanmakuDisplayer;", "config", "Lcom/baidu/tieba/danmu/DanmakuConfig;", "remove", "item", StickerDataChangeType.UPDATE, "start", "", "end", "AkRetainer", "BilibiliRetainer", "danmu_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BottomRetainer implements ru6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy a;
    public final Lazy b;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0016J(\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0010H\u0016J\u0018\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/baidu/tieba/danmu/layout/retainer/BottomRetainer$AkRetainer;", "Lcom/baidu/tieba/danmu/layout/retainer/DanmakuRetainer;", MapBundleKey.OfflineMapKey.OFFLINE_RATION, "", "(F)V", "lastVisibleEntities", "Ljava/util/TreeSet;", "Lcom/baidu/tieba/danmu/layout/retainer/DanmakuRetainer$SpaceHolder;", "kotlin.jvm.PlatformType", "getRatio", "()F", "setRatio", DownloadStatisticConstants.UBC_VALUE_CLEAR, "", TtmlNode.TAG_LAYOUT, "drawItem", "Lcom/baidu/tieba/danmu/data/DanmakuItem;", "currentTimeMills", "", "displayer", "Lcom/baidu/tieba/danmu/ui/DanmakuDisplayer;", "config", "Lcom/baidu/tieba/danmu/DanmakuConfig;", "remove", "item", StickerDataChangeType.UPDATE, "start", "", "end", "danmu_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class AkRetainer implements ru6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;
        public final TreeSet<ru6.d> b;

        @Override // com.baidu.tieba.ru6
        public void update(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            }
        }

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
            this.b = new TreeSet<>(new ru6.e());
        }

        @Override // com.baidu.tieba.ru6
        public void b(final ws6 item) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, item) == null) {
                Intrinsics.checkNotNullParameter(item, "item");
                synchronized (this.b) {
                    CollectionsKt__MutableCollectionsKt.removeAll(this.b, new Function1<ru6.d, Boolean>(item) { // from class: com.baidu.tieba.danmu.layout.retainer.BottomRetainer$AkRetainer$remove$1$1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ws6 $item;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {item};
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
                            this.$item = item;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(ru6.d dVar) {
                            InterceptResult invokeL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, dVar)) == null) {
                                return Boolean.valueOf(Intrinsics.areEqual(dVar.d(), this.$item));
                            }
                            return (Boolean) invokeL.objValue;
                        }
                    });
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:48:0x0123  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x012a A[LOOP:0: B:34:0x00d7->B:53:0x012a, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:92:0x0129 A[SYNTHETIC] */
        @Override // com.baidu.tieba.ru6
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public float a(ws6 drawItem, long j, wu6 displayer, qs6 config) {
            InterceptResult invokeCommon;
            boolean z;
            DrawState drawState;
            ru6.d dVar;
            Pair pair;
            boolean z2;
            boolean z3;
            Object obj;
            int size;
            Pair pair2;
            boolean z4;
            boolean z5;
            ws6 d;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{drawItem, Long.valueOf(j), displayer, config})) == null) {
                Intrinsics.checkNotNullParameter(drawItem, "drawItem");
                Intrinsics.checkNotNullParameter(displayer, "displayer");
                Intrinsics.checkNotNullParameter(config, "config");
                DrawState f = drawItem.f();
                if (eu6.d(drawItem, j)) {
                    b(drawItem);
                    return -1.0f;
                }
                ru6.d dVar2 = r13;
                ru6.d dVar3 = new ru6.d(drawItem, drawItem.j(), (int) f.h(), (int) f.g(), (int) f.q(), (int) f.d(), 0, 0, 0L, FileUtils.S_IRWXU, null);
                synchronized (this.b) {
                    if (f.p() && f.e() == config.o()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        TreeSet<ru6.d> treeSet = this.b;
                        if (!(treeSet instanceof Collection) || !treeSet.isEmpty()) {
                            for (ru6.d dVar4 : treeSet) {
                                dVar = dVar2;
                                if (Intrinsics.areEqual(dVar4, dVar)) {
                                    z3 = true;
                                    break;
                                }
                                dVar2 = dVar;
                            }
                        }
                        dVar = dVar2;
                        z3 = false;
                        if (z3 && f.e() == config.o()) {
                            pair2 = TuplesKt.to(Float.valueOf(f.h()), 0);
                            drawState = f;
                        } else {
                            Iterator it = SequencesKt___SequencesKt.toList(SequencesKt__SequenceBuilderKt.sequence(new BottomRetainer$AkRetainer$layout$1$targetHolders$1(displayer, this, displayer.c(), null))).iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    obj = it.next();
                                    ru6.b bVar = (ru6.b) obj;
                                    if (dVar.b() < bVar.b().getLast() - bVar.b().getFirst()) {
                                        ru6.d a = bVar.a();
                                        if (a != null && (d = a.d()) != null) {
                                            drawState = f;
                                            if (eu6.f(d, dVar.d(), displayer, j, config.k())) {
                                                z5 = true;
                                                if (!z5) {
                                                    z4 = true;
                                                    if (!z4) {
                                                        break;
                                                    }
                                                    f = drawState;
                                                }
                                            }
                                        } else {
                                            drawState = f;
                                        }
                                        z5 = false;
                                        if (!z5) {
                                        }
                                    } else {
                                        drawState = f;
                                    }
                                    z4 = false;
                                    if (!z4) {
                                    }
                                } else {
                                    drawState = f;
                                    obj = null;
                                    break;
                                }
                            }
                            ru6.b bVar2 = (ru6.b) obj;
                            if (bVar2 == null) {
                                BdLog.v("DanmakuEngine [Retainer] no room for this");
                                drawState.y(config.o());
                                drawState.H(false);
                                return -1.0f;
                            }
                            dVar.i(bVar2.b().getLast() - dVar.b());
                            BdLog.v("DanmakuEngine [Retainer] range: " + new IntRange(dVar.g(), dVar.a()) + " with targetHolder " + bVar2.b());
                            ru6.d a2 = bVar2.a();
                            if (a2 != null) {
                                this.b.remove(a2);
                            }
                            Float valueOf = Float.valueOf(dVar.g());
                            ru6.d a3 = bVar2.a();
                            if (a3 != null) {
                                size = a3.c();
                            } else {
                                size = this.b.size() + 1;
                            }
                            pair2 = TuplesKt.to(valueOf, Integer.valueOf(size));
                        }
                        pair = TuplesKt.to(Float.valueOf(((Number) pair2.component1()).floatValue()), Integer.valueOf(((Number) pair2.component2()).intValue()));
                    } else {
                        drawState = f;
                        dVar = dVar2;
                        pair = TuplesKt.to(Float.valueOf(drawState.h()), 0);
                    }
                    float floatValue = ((Number) pair.component1()).floatValue();
                    if (((Number) pair.component2()).intValue() < 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    this.b.add(dVar);
                    if (z2 && !config.e()) {
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

        @Override // com.baidu.tieba.ru6
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.b.clear();
            }
        }

        public final float d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.a;
            }
            return invokeV.floatValue;
        }
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/baidu/tieba/danmu/layout/retainer/BottomRetainer$BilibiliRetainer;", "Lcom/baidu/tieba/danmu/layout/retainer/DanmakuRetainer;", "()V", "cancelFlag", "", "lastVisibleEntities", "Ljava/util/TreeSet;", "Lcom/baidu/tieba/danmu/layout/retainer/DanmakuRetainer$SpaceHolder;", "kotlin.jvm.PlatformType", DownloadStatisticConstants.UBC_VALUE_CLEAR, "", TtmlNode.TAG_LAYOUT, "", "drawItem", "Lcom/baidu/tieba/danmu/data/DanmakuItem;", "currentTimeMills", "", "displayer", "Lcom/baidu/tieba/danmu/ui/DanmakuDisplayer;", "config", "Lcom/baidu/tieba/danmu/DanmakuConfig;", "remove", "item", StickerDataChangeType.UPDATE, "start", "", "end", "danmu_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class BilibiliRetainer implements ru6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public final TreeSet<ru6.d> b;

        @Override // com.baidu.tieba.ru6
        public void update(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            }
        }

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
            this.b = new TreeSet<>(new ru6.e());
        }

        @Override // com.baidu.tieba.ru6
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a = true;
                this.b.clear();
            }
        }

        @Override // com.baidu.tieba.ru6
        public void b(final ws6 item) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, item) == null) {
                Intrinsics.checkNotNullParameter(item, "item");
                CollectionsKt__MutableCollectionsKt.removeAll(this.b, new Function1<ru6.d, Boolean>(item) { // from class: com.baidu.tieba.danmu.layout.retainer.BottomRetainer$BilibiliRetainer$remove$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ws6 $item;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {item};
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
                        this.$item = item;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(ru6.d dVar) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, dVar)) == null) {
                            return Boolean.valueOf(Intrinsics.areEqual(dVar.d(), this.$item));
                        }
                        return (Boolean) invokeL.objValue;
                    }
                });
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:55:0x016e  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0182  */
        @Override // com.baidu.tieba.ru6
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public float a(ws6 drawItem, long j, wu6 displayer, qs6 config) {
            InterceptResult invokeCommon;
            boolean z;
            float height;
            ru6.d dVar;
            boolean z2;
            boolean z3;
            boolean z4;
            ru6.d dVar2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{drawItem, Long.valueOf(j), displayer, config})) == null) {
                Intrinsics.checkNotNullParameter(drawItem, "drawItem");
                Intrinsics.checkNotNullParameter(displayer, "displayer");
                Intrinsics.checkNotNullParameter(config, "config");
                DrawState f = drawItem.f();
                if (eu6.d(drawItem, j)) {
                    b(drawItem);
                    return -1.0f;
                }
                ru6.d dVar3 = r12;
                ru6.d dVar4 = new ru6.d(drawItem, drawItem.j(), (int) f.h(), (int) f.g(), (int) f.q(), (int) f.d(), 0, 0, 0L, FileUtils.S_IRWXU, null);
                boolean z5 = true;
                if (f.p() && f.e() == config.o()) {
                    z = true;
                } else {
                    z = false;
                }
                if (z && f.h() >= displayer.e()) {
                    height = f.h();
                } else {
                    height = displayer.getHeight() - f.d();
                }
                final ru6.c cVar = new ru6.c(0, null, null, null, null, null, false, false, false, false, 1023, null);
                if (!z) {
                    this.a = false;
                    float f2 = height;
                    for (ru6.d dVar5 : SequencesKt___SequencesKt.takeWhile(CollectionsKt___CollectionsKt.asSequence(this.b), new Function1<ru6.d, Boolean>(this, cVar) { // from class: com.baidu.tieba.danmu.layout.retainer.BottomRetainer$BilibiliRetainer$layout$1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ ru6.c $state;
                        public final /* synthetic */ BottomRetainer.BilibiliRetainer this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, cVar};
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
                            this.$state = cVar;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // kotlin.jvm.functions.Function1
                        public final Boolean invoke(ru6.d dVar6) {
                            InterceptResult invokeL;
                            boolean z6;
                            boolean z7;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null && (invokeL = interceptable2.invokeL(1048576, this, dVar6)) != null) {
                                return (Boolean) invokeL.objValue;
                            }
                            z6 = this.this$0.a;
                            if (!z6 && !this.$state.b()) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            return Boolean.valueOf(z7);
                        }
                    })) {
                        cVar.g(cVar.c() + 1);
                        ru6.d dVar6 = dVar3;
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
                                if (!eu6.f(dVar5.d(), dVar5.d(), displayer, j, config.k())) {
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
                        ru6.d a = cVar.a();
                        if (a != null && a.a() == displayer.getHeight()) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (z4) {
                            z3 = false;
                            if (!z3) {
                                cVar.g(1);
                                boolean z6 = z3;
                                height = displayer.getHeight() - f.d();
                                z2 = z6;
                            } else {
                                if (f2 != displayer.e()) {
                                    z5 = false;
                                }
                                z2 = z3;
                                height = f2;
                                if (z5) {
                                    z = false;
                                }
                            }
                        }
                    }
                    z3 = true;
                    if (!z3) {
                    }
                } else {
                    dVar = dVar3;
                    z2 = false;
                }
                if (z2) {
                    clear();
                }
                if (!z) {
                    ru6.d d = cVar.d();
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
    }

    public BottomRetainer(final float f) {
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
        this.b = LazyKt__LazyJVMKt.lazy(new Function0<AkRetainer>(f) { // from class: com.baidu.tieba.danmu.layout.retainer.BottomRetainer$akRetainer$2
            public static /* synthetic */ Interceptable $ic;
            public final /* synthetic */ float $endRatio;
            public transient /* synthetic */ FieldHolder $fh;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {Float.valueOf(f)};
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
                this.$endRatio = f;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BottomRetainer.AkRetainer invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return new BottomRetainer.AkRetainer(this.$endRatio);
                }
                return (BottomRetainer.AkRetainer) invokeV.objValue;
            }
        });
    }

    @Override // com.baidu.tieba.ru6
    public float a(ws6 drawItem, long j, wu6 displayer, qs6 config) {
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

    @Override // com.baidu.tieba.ru6
    public void b(ws6 item) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (AkRetainer) this.b.getValue();
        }
        return (AkRetainer) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ru6
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return (BilibiliRetainer) this.a.getValue();
        }
        return (BilibiliRetainer) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ru6
    public void update(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            d().update(i, i2);
            c().update(i, i2);
        }
    }
}
