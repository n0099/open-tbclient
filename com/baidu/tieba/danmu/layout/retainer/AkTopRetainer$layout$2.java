package com.baidu.tieba.danmu.layout.retainer;

import android.graphics.RectF;
import com.baidu.tieba.danmu.data.state.DrawState;
import com.baidu.tieba.n26;
import com.baidu.tieba.n46;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, "Lcom/baidu/tieba/danmu/data/DanmakuItem;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class AkTopRetainer$layout$2 extends Lambda implements Function1<n26, Integer> {
    public static /* synthetic */ Interceptable $ic;
    public final /* synthetic */ n46 $displayer;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AkTopRetainer$layout$2(n46 n46Var) {
        super(1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {n46Var};
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
        this.$displayer = n46Var;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // kotlin.jvm.functions.Function1
    public final Integer invoke(n26 n26Var) {
        InterceptResult invokeL;
        DrawState f;
        RectF i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, n26Var)) == null) {
            Number number = null;
            if (n26Var != null && (f = n26Var.f()) != null && (i = f.i()) != null) {
                number = Float.valueOf(i.left);
            }
            if (number == null) {
                number = Integer.valueOf(this.$displayer.getWidth());
            }
            return Integer.valueOf(number.intValue());
        }
        return (Integer) invokeL.objValue;
    }
}
