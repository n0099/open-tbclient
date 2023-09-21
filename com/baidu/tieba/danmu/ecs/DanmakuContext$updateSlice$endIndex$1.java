package com.baidu.tieba.danmu.ecs;

import com.baidu.searchbox.net.listener.DiaoqiJsonListener;
import com.baidu.tieba.qv6;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
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
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, "Lcom/baidu/tieba/danmu/data/DanmakuItem;", DiaoqiJsonListener.SCHEME_FORBID_WHITE_LIST, "(Lcom/baidu/tieba/danmu/data/DanmakuItem;)Ljava/lang/Long;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DanmakuContext$updateSlice$endIndex$1 extends Lambda implements Function1<qv6, Long> {
    public static /* synthetic */ Interceptable $ic;
    public static final DanmakuContext$updateSlice$endIndex$1 INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1975399210, "Lcom/baidu/tieba/danmu/ecs/DanmakuContext$updateSlice$endIndex$1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1975399210, "Lcom/baidu/tieba/danmu/ecs/DanmakuContext$updateSlice$endIndex$1;");
                return;
            }
        }
        INSTANCE = new DanmakuContext$updateSlice$endIndex$1();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DanmakuContext$updateSlice$endIndex$1() {
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
    public final Long invoke(qv6 it) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, it)) == null) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Long.valueOf(it.j());
        }
        return (Long) invokeL.objValue;
    }
}
