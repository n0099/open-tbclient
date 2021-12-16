package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.r0.s.v.c;
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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/baidu/tieba/homepage/personalize/view/HomePageBrowseModelTipView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "contentContainer", "value", "Landroid/view/View$OnClickListener;", "listener", "getListener", "()Landroid/view/View$OnClickListener;", "setListener", "(Landroid/view/View$OnClickListener;)V", "placeHolder", "Landroid/view/View;", "tipBtn", "Lcom/baidu/tbadk/core/view/commonBtn/TBSpecificationBtn;", "tipText", "Landroid/widget/TextView;", "onChangeSkinType", "", "recommendfrs_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class HomePageBrowseModelTipView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f45859e;

    /* renamed from: f  reason: collision with root package name */
    public final TBSpecificationBtn f45860f;

    /* renamed from: g  reason: collision with root package name */
    public final View f45861g;

    /* renamed from: h  reason: collision with root package name */
    public final LinearLayout f45862h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f45863i;

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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f45863i : (View.OnClickListener) invokeV.objValue;
    }

    public final void onChangeSkinType() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            c d2 = c.d(this.f45862h);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.f45859e, R.color.CAM_X0105);
            this.f45860f.changeSkinType();
        }
    }

    public final void setListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.f45863i = onClickListener;
            if (onClickListener == null) {
                return;
            }
            this.f45860f.setOnClickListener(onClickListener);
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
        this.f45859e = new TextView(getContext());
        this.f45860f = new TBSpecificationBtn(getContext());
        this.f45861g = new View(getContext());
        this.f45862h = new LinearLayout(getContext());
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
        this.f45861g.setLayoutParams(new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X003)));
        addView(this.f45861g);
        addView(this.f45862h);
        ViewGroup.LayoutParams layoutParams = this.f45862h.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        this.f45862h.setLayoutParams(layoutParams);
        this.f45862h.setOrientation(0);
        c d2 = c.d(this.f45862h);
        d2.n(R.string.J_X06);
        d2.f(R.color.CAM_X0201);
        this.f45862h.addView(this.f45859e);
        this.f45862h.addView(this.f45860f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.tbds174), getContext().getResources().getDimensionPixelSize(R.dimen.tbds75));
        layoutParams2.topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X005);
        layoutParams2.bottomMargin = getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X005);
        layoutParams2.rightMargin = getContext().getResources().getDimensionPixelSize(R.dimen.M_W_X005);
        layoutParams2.gravity = 16;
        this.f45860f.setLayoutParams(layoutParams2);
        c.a.r0.s.i0.n.c cVar = new c.a.r0.s.i0.n.c();
        cVar.p(R.color.CAM_X0304);
        this.f45860f.setConfig(cVar);
        this.f45860f.setText(getContext().getString(R.string.browse_mode_tip_view_btn_text));
        this.f45860f.setTextSize(R.dimen.T_X08);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.M_W_X005);
        layoutParams3.rightMargin = getContext().getResources().getDimensionPixelSize(R.dimen.M_W_X005);
        layoutParams3.gravity = 16;
        layoutParams3.weight = 1.0f;
        this.f45859e.setLayoutParams(layoutParams3);
        c d3 = c.d(this.f45859e);
        d3.z(R.dimen.T_X06);
        d3.v(R.color.CAM_X0105);
        this.f45859e.setText(getContext().getString(R.string.browse_mode_tip_view_tip_text));
        this.f45859e.setSingleLine();
        this.f45859e.setEllipsize(TextUtils.TruncateAt.END);
    }
}
