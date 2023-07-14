package com.baidu.tieba.compact;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.fc7;
import com.baidu.tieba.gc7;
import com.baidu.tieba.vx7;
import com.baidu.tieba.wca;
import com.baidu.tieba.zd7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\r\u001a\u00020\u000eH\u0016JJ\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aR\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/baidu/tieba/compact/DelegateFunAdView;", "Landroid/widget/FrameLayout;", "Lcom/baidu/tieba/feed/list/OnChangeSkinListener;", "context", "Landroid/content/Context;", "type", "Lcom/baidu/adp/BdUniqueId;", "(Landroid/content/Context;Lcom/baidu/adp/BdUniqueId;)V", "realView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getType", "()Lcom/baidu/adp/BdUniqueId;", "onChangeSkin", "", "updateFunAdView", "funAdData", "Lcom/baidu/tieba/tbadkCore/data/FunAdData;", "sid", "", "pageType", "sceneKey", "fromTab", "currentFloor", "", "feedbackClickListener", "Landroid/view/View$OnClickListener;", "recommendfrs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@SuppressLint({"ViewConstructor"})
/* loaded from: classes5.dex */
public final class DelegateFunAdView extends FrameLayout implements fc7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BdUniqueId a;
    public final View b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DelegateFunAdView(Context context, BdUniqueId type) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, type};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(type, "type");
        this.a = type;
        View b = vx7.h().b(context, this.a);
        this.b = b;
        addView(b, new FrameLayout.LayoutParams(-1, -2));
        zd7.a aVar = zd7.b;
        View realView = this.b;
        Intrinsics.checkNotNullExpressionValue(realView, "realView");
        zd7.a.f(aVar, realView, null, null, 6, null);
    }

    public final void a(wca wcaVar, String str, String str2, String str3, String str4, int i, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{wcaVar, str, str2, str3, str4, Integer.valueOf(i), onClickListener}) == null) {
            vx7.h().f(this.b, wcaVar, this.a, str, str2, str3, str4, i, onClickListener);
        }
    }

    @Override // com.baidu.tieba.fc7
    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || gc7.a(this)) {
            return;
        }
        vx7.h().e(this.b);
    }

    public final BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.a;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
