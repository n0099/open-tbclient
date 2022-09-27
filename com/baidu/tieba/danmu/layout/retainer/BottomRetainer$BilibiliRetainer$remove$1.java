package com.baidu.tieba.danmu.layout.retainer;

import com.baidu.tieba.l66;
import com.baidu.tieba.q46;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, "Lcom/baidu/tieba/danmu/layout/retainer/DanmakuRetainer$SpaceHolder;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class BottomRetainer$BilibiliRetainer$remove$1 extends Lambda implements Function1<l66.d, Boolean> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ q46 $item;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BottomRetainer$BilibiliRetainer$remove$1(q46 q46Var) {
        super(1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {q46Var};
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
        this.$item = q46Var;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function1
    public final Boolean invoke(l66.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) ? Boolean.valueOf(Intrinsics.areEqual(dVar.d(), this.$item)) : (Boolean) invokeL.objValue;
    }
}
