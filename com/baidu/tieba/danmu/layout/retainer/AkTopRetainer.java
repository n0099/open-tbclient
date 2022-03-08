package com.baidu.tieba.danmu.layout.retainer;

import c.a.r0.l0.h.i.a;
import c.a.r0.l0.j.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.updateprocessor.UpdateCloudControlProcessor;
import com.baidu.tieba.danmu.collection.OrderedRangeList;
import com.baidu.tieba.danmu.data.state.DrawState;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J(\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0016R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/baidu/tieba/danmu/layout/retainer/AkTopRetainer;", "Lcom/baidu/tieba/danmu/layout/retainer/DanmakuRetainer;", "startRatio", "", "endRatio", "(FF)V", "ranges", "Lcom/baidu/tieba/danmu/collection/OrderedRangeList;", "Lcom/baidu/tieba/danmu/data/DanmakuItem;", "clear", "", "layout", "drawItem", "currentTimeMills", "", "displayer", "Lcom/baidu/tieba/danmu/ui/DanmakuDisplayer;", UpdateCloudControlProcessor.CLOUD_UPDATE_ACTION_NAME, "Lcom/baidu/tieba/danmu/DanmakuConfig;", "remove", "item", "update", "start", "", "end", "danmu_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes5.dex */
public final class AkTopRetainer implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final float a;

    /* renamed from: b  reason: collision with root package name */
    public final float f41083b;

    /* renamed from: c  reason: collision with root package name */
    public final OrderedRangeList<c.a.r0.l0.e.a> f41084c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AkTopRetainer() {
        this(0.0f, 0.0f, 3, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                this(((Float) objArr[0]).floatValue(), ((Float) objArr[1]).floatValue(), ((Integer) objArr[2]).intValue(), (DefaultConstructorMarker) objArr[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public AkTopRetainer(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f2), Float.valueOf(f3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = f2;
        this.f41083b = f3;
        this.f41084c = new OrderedRangeList<>(0, 0, 0, 4, null);
    }

    @Override // c.a.r0.l0.h.i.a
    public float a(c.a.r0.l0.e.a drawItem, long j2, b displayer, c.a.r0.l0.a config) {
        InterceptResult invokeCommon;
        boolean p;
        int h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{drawItem, Long.valueOf(j2), displayer, config})) == null) {
            Intrinsics.checkNotNullParameter(drawItem, "drawItem");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            Intrinsics.checkNotNullParameter(config, "config");
            DrawState f2 = drawItem.f();
            long t = drawItem.e().j() == 1 ? config.t() : config.k();
            if (c.a.r0.l0.g.b.d(drawItem, j2)) {
                b(drawItem);
                return -1.0f;
            }
            boolean z = f2.e() != config.o();
            boolean d2 = this.f41084c.d(drawItem);
            if (z && !d2) {
                List<OrderedRangeList.a<c.a.r0.l0.e.a>> e2 = this.f41084c.e((int) f2.d(), new AkTopRetainer$layout$holder$1(drawItem, displayer, j2, t));
                if (e2.isEmpty()) {
                    if (config.e()) {
                        this.f41084c.c();
                        e2 = this.f41084c.e((int) f2.d(), AkTopRetainer$layout$1.INSTANCE);
                    } else if (drawItem.e().p()) {
                        e2 = this.f41084c.h((int) f2.d(), new AkTopRetainer$layout$2(displayer));
                    }
                }
                if (e2.isEmpty()) {
                    h2 = -1;
                    p = false;
                } else {
                    int d3 = ((OrderedRangeList.a) CollectionsKt___CollectionsKt.first((List<? extends Object>) e2)).d();
                    p = this.f41084c.a(e2, d3, ((int) f2.d()) + d3, drawItem);
                    h2 = d3;
                }
            } else {
                p = f2.p();
                h2 = (int) drawItem.f().h();
            }
            f2.y(config.o());
            f2.H(p);
            if (p) {
                float f3 = h2;
                drawItem.f().B(f3);
                return f3;
            }
            return -1.0f;
        }
        return invokeCommon.floatValue;
    }

    @Override // c.a.r0.l0.h.i.a
    public void b(c.a.r0.l0.e.a item) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, item) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.f41084c.m(item);
        }
    }

    @Override // c.a.r0.l0.h.i.a
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f41084c.c();
        }
    }

    @Override // c.a.r0.l0.h.i.a
    public void update(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            this.f41084c.update((int) (i2 * this.a), (int) (i3 * this.f41083b));
        }
    }

    public /* synthetic */ AkTopRetainer(float f2, float f3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 1.0f : f2, (i2 & 2) != 0 ? 1.0f : f3);
    }
}
