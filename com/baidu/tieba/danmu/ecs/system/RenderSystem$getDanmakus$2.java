package com.baidu.tieba.danmu.ecs.system;

import com.baidu.searchbox.net.listener.DiaoqiJsonListener;
import com.baidu.tieba.wr6;
import com.baidu.tieba.zp6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/baidu/tieba/danmu/data/DanmakuItem;", "r", "Lcom/baidu/tieba/danmu/render/RenderObject;", DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RenderSystem$getDanmakus$2 extends Lambda implements Function1<wr6, zp6> {
    public static /* synthetic */ Interceptable $ic;
    public static final RenderSystem$getDanmakus$2 INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-845672720, "Lcom/baidu/tieba/danmu/ecs/system/RenderSystem$getDanmakus$2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-845672720, "Lcom/baidu/tieba/danmu/ecs/system/RenderSystem$getDanmakus$2;");
                return;
            }
        }
        INSTANCE = new RenderSystem$getDanmakus$2();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RenderSystem$getDanmakus$2() {
        super(1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function1
    public final zp6 invoke(wr6 r) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, r)) == null) {
            Intrinsics.checkNotNullParameter(r, "r");
            return r.d();
        }
        return (zp6) invokeL.objValue;
    }
}
