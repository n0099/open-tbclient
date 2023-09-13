package com.baidu.tieba.im.biz.aibot.sugslice;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.jc8;
import com.baidu.tieba.zfa;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\bH\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0014¨\u0006\u0010"}, d2 = {"Lcom/baidu/tieba/im/biz/aibot/sugslice/AibotSugAdapter;", "Lcom/baidu/tieba/im/biz/aibot/sugslice/ImSugAdapter;", "context", "Landroid/content/Context;", "processor", "Lcom/baidu/tieba/im/base/core/uilist/AbilityProcessor;", "(Landroid/content/Context;Lcom/baidu/tieba/im/base/core/uilist/AbilityProcessor;)V", "customAndHandleDefaultBgColor", "", "container", "Landroid/view/View;", "customAndHandleDefaultTextColor", "Landroid/widget/TextView;", "isForcedCustomization", "sourceType", "Lcom/baidu/tieba/im/biz/aibot/sugslice/SugSourceType;", "im-personal_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AibotSugAdapter extends ImSugAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Override // com.baidu.tieba.im.biz.aibot.sugslice.ImSugAdapter
    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AibotSugAdapter(Context context, jc8 processor) {
        super(context, processor);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, processor};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (jc8) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(processor, "processor");
    }

    @Override // com.baidu.tieba.im.biz.aibot.sugslice.ImSugAdapter
    public boolean m(View container) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, container)) == null) {
            Intrinsics.checkNotNullParameter(container, "container");
            EMManager.from(container).setCorner(R.string.J_X01).setBackGroundRealColor(zfa.a(SkinManager.getColor(R.color.CAM_X0614), 1.0f));
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.im.biz.aibot.sugslice.ImSugAdapter
    public boolean n(TextView container) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, container)) == null) {
            Intrinsics.checkNotNullParameter(container, "container");
            container.setTextColor(SkinManager.getColor(R.color.CAM_X0101));
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.im.biz.aibot.sugslice.ImSugAdapter
    public SugSourceType z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return SugSourceType.AI_BOT;
        }
        return (SugSourceType) invokeV.objValue;
    }
}
