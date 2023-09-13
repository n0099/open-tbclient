package com.baidu.tieba.danmu.ecs.system;

import android.graphics.Point;
import android.graphics.RectF;
import com.baidu.searchbox.net.listener.DiaoqiJsonListener;
import com.baidu.tieba.hx6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, "Lcom/baidu/tieba/danmu/render/RenderObject;", DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST, "(Lcom/baidu/tieba/danmu/render/RenderObject;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RenderSystem$getDanmakus$1 extends Lambda implements Function1<hx6, Boolean> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ Point $point;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RenderSystem$getDanmakus$1(Point point) {
        super(1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {point};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.$point = point;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(hx6 it) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, it)) == null) {
            Intrinsics.checkNotNullParameter(it, "it");
            RectF f = it.f();
            Point point = this.$point;
            return Boolean.valueOf(f.contains(point.x, point.y));
        }
        return (Boolean) invokeL.objValue;
    }
}
