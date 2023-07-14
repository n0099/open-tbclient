package com.baidu.tieba.compact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.d85;
import com.baidu.tieba.ev6;
import com.baidu.tieba.fc7;
import com.baidu.tieba.l18;
import com.baidu.tieba.v18;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ugc.editvideo.sticker.StickerDataChangeType;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/baidu/tieba/compact/RecommendTopicCardView;", "Landroid/widget/FrameLayout;", "Lcom/baidu/tieba/feed/list/OnChangeSkinListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "topicCardLayout", "Lcom/baidu/tieba/homepage/concern/view/RecommendTopicCardLayout;", "onChangeSkin", "", StickerDataChangeType.UPDATE, "data", "Lcom/baidu/tieba/homepage/concern/data/RecommendTopicCardData;", "recommendfrs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RecommendTopicCardView extends FrameLayout implements fc7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public v18 a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RecommendTopicCardView(Context context) {
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
    public RecommendTopicCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TbPageContext tbPageContext;
        View c;
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
        tbPageContext = context instanceof ev6 ? ((ev6) context).getPageContext() : tbPageContext;
        if (tbPageContext != null) {
            v18 v18Var = new v18(tbPageContext);
            this.a = v18Var;
            if (v18Var != null && (c = v18Var.c()) != null) {
                addView(c, new FrameLayout.LayoutParams(-1, -2));
            }
        }
        b();
    }

    public /* synthetic */ RecommendTopicCardView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    @Override // com.baidu.tieba.fc7
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            d85 d = d85.d(this);
            d.o(R.string.J_X06);
            d.j(R.color.CAM_X0205, R.color.CAM_X0206);
            v18 v18Var = this.a;
            if (v18Var != null) {
                v18Var.onChangeSkinType(null, TbadkCoreApplication.getInst().getSkinType());
            }
        }
    }

    public final void update(l18 data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            v18 v18Var = this.a;
            if (v18Var != null) {
                v18Var.e(data);
            }
            b();
        }
    }
}
