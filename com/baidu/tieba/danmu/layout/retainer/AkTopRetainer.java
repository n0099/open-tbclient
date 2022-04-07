package com.baidu.tieba.danmu.layout.retainer;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.baidu.tieba.danmu.collection.OrderedRangeList;
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
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J(\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0016R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/baidu/tieba/danmu/layout/retainer/AkTopRetainer;", "Lcom/baidu/tieba/danmu/layout/retainer/DanmakuRetainer;", "startRatio", "", "endRatio", "(FF)V", "ranges", "Lcom/baidu/tieba/danmu/collection/OrderedRangeList;", "Lcom/baidu/tieba/danmu/data/DanmakuItem;", "clear", "", TtmlNode.TAG_LAYOUT, "drawItem", "currentTimeMills", "", "displayer", "Lcom/baidu/tieba/danmu/ui/DanmakuDisplayer;", UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, "Lcom/baidu/tieba/danmu/DanmakuConfig;", "remove", "item", "update", "start", "", "end", "danmu_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class AkTopRetainer implements y16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final float a;
    public final float b;
    public final OrderedRangeList<d06> c;

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

    @Override // com.repackage.y16
    public float a(d06 drawItem, long j, d26 displayer, xz5 config) {
        InterceptResult invokeCommon;
        boolean p;
        int h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{drawItem, Long.valueOf(j), displayer, config})) == null) {
            Intrinsics.checkNotNullParameter(drawItem, "drawItem");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            Intrinsics.checkNotNullParameter(config, "config");
            DrawState f = drawItem.f();
            long t = drawItem.e().j() == 1 ? config.t() : config.k();
            if (l16.d(drawItem, j)) {
                b(drawItem);
                return -1.0f;
            }
            boolean z = f.e() != config.o();
            boolean d = this.c.d(drawItem);
            if (z && !d) {
                List<OrderedRangeList.a<d06>> e = this.c.e((int) f.d(), new AkTopRetainer$layout$holder$1(drawItem, displayer, j, t));
                if (e.isEmpty()) {
                    if (config.e()) {
                        this.c.c();
                        e = this.c.e((int) f.d(), AkTopRetainer$layout$1.INSTANCE);
                    } else if (drawItem.e().p()) {
                        e = this.c.h((int) f.d(), new AkTopRetainer$layout$2(displayer));
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
            if (p) {
                float f2 = h;
                drawItem.f().B(f2);
                return f2;
            }
            return -1.0f;
        }
        return invokeCommon.floatValue;
    }

    @Override // com.repackage.y16
    public void b(d06 item) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, item) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.c.m(item);
        }
    }

    @Override // com.repackage.y16
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c.c();
        }
    }

    @Override // com.repackage.y16
    public void update(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            this.c.update((int) (i * this.a), (int) (i2 * this.b));
        }
    }

    public /* synthetic */ AkTopRetainer(float f, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 1.0f : f, (i & 2) != 0 ? 1.0f : f2);
    }
}
