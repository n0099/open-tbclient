package com.baidu.tieba.danmu.layout.retainer;

import com.baidu.tieba.f66;
import com.baidu.tieba.x46;
import com.baidu.tieba.x66;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, "Lcom/baidu/tieba/danmu/data/DanmakuItem;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class AkTopRetainer$layout$holder$1 extends Lambda implements Function1 {
    public static /* synthetic */ Interceptable $ic;
    public final /* synthetic */ long $currentTimeMills;
    public final /* synthetic */ x66 $displayer;
    public final /* synthetic */ x46 $drawItem;
    public final /* synthetic */ long $duration;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AkTopRetainer$layout$holder$1(x46 x46Var, x66 x66Var, long j, long j2) {
        super(1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {x46Var, x66Var, Long.valueOf(j), Long.valueOf(j2)};
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
        this.$drawItem = x46Var;
        this.$displayer = x66Var;
        this.$currentTimeMills = j;
        this.$duration = j2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(x46 x46Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, x46Var)) == null) {
            if (x46Var != null && f66.f(x46Var, this.$drawItem, this.$displayer, this.$currentTimeMills, this.$duration)) {
                z = false;
            } else {
                z = true;
            }
            return Boolean.valueOf(z);
        }
        return (Boolean) invokeL.objValue;
    }
}
