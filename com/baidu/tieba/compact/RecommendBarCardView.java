package com.baidu.tieba.compact;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.concern.data.RecommendBarCardModel;
import com.baidu.tieba.homepage.concern.view.RecommendBarLayout;
import com.baidu.tieba.i37;
import com.baidu.tieba.kb7;
import com.baidu.tieba.ur6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/baidu/tieba/compact/RecommendBarCardView;", "Landroid/widget/LinearLayout;", "Lcom/baidu/tieba/feed/list/OnChangeSkinListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "recommendBar", "Lcom/baidu/tieba/homepage/concern/view/RecommendBarLayout;", "onChangeSkin", "", StickerDataChangeType.UPDATE, "state", "Lcom/baidu/tieba/feed/card/uistate/OtherTemplateUiState;", "recommendfrs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RecommendBarCardView extends LinearLayout implements kb7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public RecommendBarLayout a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RecommendBarCardView(Context context) {
        this(context, null, 2, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), (DefaultConstructorMarker) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RecommendBarCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TbPageContext tbPageContext;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (context instanceof TbPageContextSupport) {
            tbPageContext = ((TbPageContextSupport) context).getPageContext();
        } else {
            tbPageContext = null;
        }
        if (context instanceof ur6) {
            ur6 ur6Var = (ur6) context;
            Activity pageActivity = ur6Var.getPageContext().getPageActivity();
            Intrinsics.checkNotNullExpressionValue(pageActivity, "context.pageContext.pageActivity");
            tbPageContext = ur6Var.getPageContext();
            context = pageActivity;
        }
        if (tbPageContext != null) {
            RecommendBarLayout recommendBarLayout = new RecommendBarLayout(tbPageContext, context, tbPageContext.getUniqueId(), (byte) 3);
            this.a = recommendBarLayout;
            addView(recommendBarLayout, new LinearLayout.LayoutParams(-1, -2));
        }
        f();
    }

    public /* synthetic */ RecommendBarCardView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    public final void a(i37 state) {
        RecommendBarLayout recommendBarLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, state) == null) {
            Intrinsics.checkNotNullParameter(state, "state");
            Object obj = state.a().a;
            if ((obj instanceof RecommendBarCardModel) && (recommendBarLayout = this.a) != null) {
                recommendBarLayout.setData((RecommendBarCardModel) obj);
            }
            f();
        }
    }

    @Override // com.baidu.tieba.kb7
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            EMManager.from(this).setCorner(R.string.J_X06).setBackGroundSelectorColor(R.color.CAM_X0205, R.color.CAM_X0206);
            RecommendBarLayout recommendBarLayout = this.a;
            if (recommendBarLayout != null) {
                recommendBarLayout.onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }
}
