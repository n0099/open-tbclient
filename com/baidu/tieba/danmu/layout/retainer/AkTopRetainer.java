package com.baidu.tieba.danmu.layout.retainer;

import android.graphics.RectF;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.al6;
import com.baidu.tieba.bn6;
import com.baidu.tieba.danmu.collection.OrderedRangeList;
import com.baidu.tieba.danmu.data.state.DrawState;
import com.baidu.tieba.gl6;
import com.baidu.tieba.gn6;
import com.baidu.tieba.om6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J(\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0016R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/baidu/tieba/danmu/layout/retainer/AkTopRetainer;", "Lcom/baidu/tieba/danmu/layout/retainer/DanmakuRetainer;", "startRatio", "", "endRatio", "(FF)V", "ranges", "Lcom/baidu/tieba/danmu/collection/OrderedRangeList;", "Lcom/baidu/tieba/danmu/data/DanmakuItem;", "clear", "", TtmlNode.TAG_LAYOUT, "drawItem", "currentTimeMills", "", "displayer", "Lcom/baidu/tieba/danmu/ui/DanmakuDisplayer;", "config", "Lcom/baidu/tieba/danmu/DanmakuConfig;", "remove", "item", StickerDataChangeType.UPDATE, "start", "", "end", "danmu_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AkTopRetainer implements bn6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final float a;
    public final float b;
    public final OrderedRangeList<gl6> c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AkTopRetainer() {
        this(0.0f, 0.0f, 3, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Float) objArr[0]).floatValue(), ((Float) objArr[1]).floatValue(), ((Integer) objArr[2]).intValue(), (DefaultConstructorMarker) objArr[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public AkTopRetainer(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f), Float.valueOf(f2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = f;
        this.b = f2;
        this.c = new OrderedRangeList<>(0, 0, 0, 4, null);
    }

    public /* synthetic */ AkTopRetainer(float f, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 1.0f : f, (i & 2) != 0 ? 1.0f : f2);
    }

    @Override // com.baidu.tieba.bn6
    public float a(final gl6 drawItem, final long j, final gn6 displayer, al6 config) {
        InterceptResult invokeCommon;
        long k;
        boolean p;
        int h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{drawItem, Long.valueOf(j), displayer, config})) == null) {
            Intrinsics.checkNotNullParameter(drawItem, "drawItem");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            Intrinsics.checkNotNullParameter(config, "config");
            DrawState f = drawItem.f();
            boolean z = true;
            if (drawItem.e().j() == 1) {
                k = config.t();
            } else {
                k = config.k();
            }
            final long j2 = k;
            if (om6.d(drawItem, j)) {
                b(drawItem);
                return -1.0f;
            }
            if (f.e() == config.o()) {
                z = false;
            }
            boolean d = this.c.d(drawItem);
            if (z && !d) {
                List<OrderedRangeList.a<gl6>> e = this.c.e((int) f.d(), new Function1<gl6, Boolean>(drawItem, displayer, j, j2) { // from class: com.baidu.tieba.danmu.layout.retainer.AkTopRetainer$layout$holder$1
                    public static /* synthetic */ Interceptable $ic;
                    public final /* synthetic */ long $currentTimeMills;
                    public final /* synthetic */ gn6 $displayer;
                    public final /* synthetic */ gl6 $drawItem;
                    public final /* synthetic */ long $duration;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {drawItem, displayer, Long.valueOf(j), Long.valueOf(j2)};
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
                        this.$drawItem = drawItem;
                        this.$displayer = displayer;
                        this.$currentTimeMills = j;
                        this.$duration = j2;
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(gl6 gl6Var) {
                        InterceptResult invokeL;
                        boolean z2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, gl6Var)) == null) {
                            if (gl6Var != null && om6.f(gl6Var, this.$drawItem, this.$displayer, this.$currentTimeMills, this.$duration)) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            return Boolean.valueOf(z2);
                        }
                        return (Boolean) invokeL.objValue;
                    }
                });
                if (e.isEmpty()) {
                    if (config.e()) {
                        this.c.c();
                        e = this.c.e((int) f.d(), AkTopRetainer$layout$1.INSTANCE);
                    } else if (drawItem.e().q()) {
                        e = this.c.f((int) f.d(), new Function1<gl6, Integer>(displayer) { // from class: com.baidu.tieba.danmu.layout.retainer.AkTopRetainer$layout$2
                            public static /* synthetic */ Interceptable $ic;
                            public final /* synthetic */ gn6 $displayer;
                            public transient /* synthetic */ FieldHolder $fh;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {displayer};
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
                                this.$displayer = displayer;
                            }

                            /* JADX DEBUG: Method merged with bridge method */
                            @Override // kotlin.jvm.functions.Function1
                            public final Integer invoke(gl6 gl6Var) {
                                InterceptResult invokeL;
                                Number valueOf;
                                DrawState f2;
                                RectF i;
                                Interceptable interceptable2 = $ic;
                                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, gl6Var)) == null) {
                                    if (gl6Var != null && (f2 = gl6Var.f()) != null && (i = f2.i()) != null) {
                                        valueOf = Float.valueOf(i.left);
                                    } else {
                                        valueOf = Integer.valueOf(this.$displayer.getWidth());
                                    }
                                    return Integer.valueOf(valueOf.intValue());
                                }
                                return (Integer) invokeL.objValue;
                            }
                        });
                    }
                }
                if (e.isEmpty()) {
                    h = -1;
                    p = false;
                } else {
                    int d2 = ((OrderedRangeList.a) CollectionsKt___CollectionsKt.first((List<? extends Object>) e)).d();
                    p = this.c.a(e, d2, ((int) f.d()) + d2, drawItem);
                    h = d2;
                }
            } else {
                p = f.p();
                h = (int) drawItem.f().h();
            }
            f.y(config.o());
            f.H(p);
            if (!p) {
                return -1.0f;
            }
            float f2 = h;
            drawItem.f().B(f2);
            return f2;
        }
        return invokeCommon.floatValue;
    }

    @Override // com.baidu.tieba.bn6
    public void b(gl6 item) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, item) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.c.k(item);
        }
    }

    @Override // com.baidu.tieba.bn6
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c.c();
        }
    }

    @Override // com.baidu.tieba.bn6
    public void update(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            this.c.update((int) (i * this.a), (int) (i2 * this.b));
        }
    }
}
