package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.q0.s.u.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bB\u001d\b\u0016\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001a\u0010\u001eJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R.\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001f"}, d2 = {"Lcom/baidu/tieba/homepage/personalize/view/HomePageBrowseModelTipView;", "Landroid/widget/LinearLayout;", "", "onChangeSkinType", "()V", "contentContainer", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "value", "listener", "Landroid/view/View$OnClickListener;", "getListener", "()Landroid/view/View$OnClickListener;", "setListener", "(Landroid/view/View$OnClickListener;)V", "Landroid/view/View;", "placeHolder", "Landroid/view/View;", "Lcom/baidu/tbadk/core/view/commonBtn/TBSpecificationBtn;", "tipBtn", "Lcom/baidu/tbadk/core/view/commonBtn/TBSpecificationBtn;", "Landroid/widget/TextView;", "tipText", "Landroid/widget/TextView;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "recommendfrs_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class HomePageBrowseModelTipView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f52425e;

    /* renamed from: f  reason: collision with root package name */
    public final TBSpecificationBtn f52426f;

    /* renamed from: g  reason: collision with root package name */
    public final View f52427g;

    /* renamed from: h  reason: collision with root package name */
    public final LinearLayout f52428h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f52429i;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HomePageBrowseModelTipView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final View.OnClickListener getListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f52429i : (View.OnClickListener) invokeV.objValue;
    }

    public final void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c d2 = c.d(this.f52428h);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f52425e, R.color.CAM_X0105);
            this.f52426f.changeSkinType();
        }
    }

    public final void setListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.f52429i = onClickListener;
            if (onClickListener != null) {
                this.f52426f.setOnClickListener(onClickListener);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomePageBrowseModelTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f52425e = new TextView(getContext());
        this.f52426f = new TBSpecificationBtn(getContext());
        this.f52427g = new View(getContext());
        this.f52428h = new LinearLayout(getContext());
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
        Context context2 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context2, "context");
        this.f52427g.setLayoutParams(new LinearLayout.LayoutParams(-1, context2.getResources().getDimensionPixelSize(R.dimen.M_H_X003)));
        addView(this.f52427g);
        addView(this.f52428h);
        ViewGroup.LayoutParams layoutParams = this.f52428h.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        this.f52428h.setLayoutParams(layoutParams);
        this.f52428h.setOrientation(0);
        c d2 = c.d(this.f52428h);
        d2.n(R.string.J_X06);
        d2.f(R.color.CAM_X0201);
        this.f52428h.addView(this.f52425e);
        this.f52428h.addView(this.f52426f);
        Context context3 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context3, "context");
        int dimensionPixelSize = context3.getResources().getDimensionPixelSize(R.dimen.tbds174);
        Context context4 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context4, "context");
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(dimensionPixelSize, context4.getResources().getDimensionPixelSize(R.dimen.tbds75));
        Context context5 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context5, "context");
        layoutParams2.topMargin = context5.getResources().getDimensionPixelSize(R.dimen.M_H_X005);
        Context context6 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context6, "context");
        layoutParams2.bottomMargin = context6.getResources().getDimensionPixelSize(R.dimen.M_H_X005);
        Context context7 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context7, "context");
        layoutParams2.rightMargin = context7.getResources().getDimensionPixelSize(R.dimen.M_W_X005);
        layoutParams2.gravity = 16;
        this.f52426f.setLayoutParams(layoutParams2);
        c.a.q0.s.f0.n.c cVar = new c.a.q0.s.f0.n.c();
        cVar.p(R.color.CAM_X0304);
        this.f52426f.setConfig(cVar);
        this.f52426f.setText(getContext().getString(R.string.browse_mode_tip_view_btn_text));
        this.f52426f.setTextSize(R.dimen.T_X08);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        Context context8 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context8, "context");
        layoutParams3.leftMargin = context8.getResources().getDimensionPixelSize(R.dimen.M_W_X005);
        Context context9 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context9, "context");
        layoutParams3.rightMargin = context9.getResources().getDimensionPixelSize(R.dimen.M_W_X005);
        layoutParams3.gravity = 16;
        layoutParams3.weight = 1.0f;
        this.f52425e.setLayoutParams(layoutParams3);
        c d3 = c.d(this.f52425e);
        d3.z(R.dimen.T_X06);
        d3.v(R.color.CAM_X0105);
        this.f52425e.setText(getContext().getString(R.string.browse_mode_tip_view_tip_text));
        this.f52425e.setSingleLine();
        this.f52425e.setEllipsize(TextUtils.TruncateAt.END);
    }
}
