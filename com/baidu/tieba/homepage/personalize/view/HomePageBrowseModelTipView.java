package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import com.baidu.tieba.hv4;
import com.baidu.tieba.oy4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/baidu/tieba/homepage/personalize/view/HomePageBrowseModelTipView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "contentContainer", "value", "Landroid/view/View$OnClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getListener", "()Landroid/view/View$OnClickListener;", "setListener", "(Landroid/view/View$OnClickListener;)V", "placeHolder", "Landroid/view/View;", "tipBtn", "Lcom/baidu/tbadk/core/view/commonBtn/TBSpecificationBtn;", "tipText", "Landroid/widget/TextView;", "onChangeSkinType", "", "recommendfrs_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class HomePageBrowseModelTipView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TextView a;
    public final TBSpecificationBtn b;
    public final View c;
    public final LinearLayout d;
    public View.OnClickListener e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HomePageBrowseModelTipView(Context context) {
        this(context, null);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            hv4 d = hv4.d(this.d);
            d.n(R.string.J_X06);
            d.f(R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0105);
            this.b.k();
        }
    }

    public final View.OnClickListener getListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.e : (View.OnClickListener) invokeV.objValue;
    }

    public final void setListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.e = onClickListener;
            if (onClickListener == null) {
                return;
            }
            this.b.setOnClickListener(onClickListener);
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
        this.a = new TextView(getContext());
        this.b = new TBSpecificationBtn(getContext());
        this.c = new View(getContext());
        this.d = new LinearLayout(getContext());
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
        this.c.setLayoutParams(new LinearLayout.LayoutParams(-1, getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X003)));
        addView(this.c);
        addView(this.d);
        ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        this.d.setLayoutParams(layoutParams);
        this.d.setOrientation(0);
        hv4 d = hv4.d(this.d);
        d.n(R.string.J_X06);
        d.f(R.color.CAM_X0201);
        this.d.addView(this.a);
        this.d.addView(this.b);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.tbds174), getContext().getResources().getDimensionPixelSize(R.dimen.tbds75));
        layoutParams2.topMargin = getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X005);
        layoutParams2.bottomMargin = getContext().getResources().getDimensionPixelSize(R.dimen.M_H_X005);
        layoutParams2.rightMargin = getContext().getResources().getDimensionPixelSize(R.dimen.M_W_X005);
        layoutParams2.gravity = 16;
        this.b.setLayoutParams(layoutParams2);
        oy4 oy4Var = new oy4();
        oy4Var.p(R.color.CAM_X0304);
        this.b.setConfig(oy4Var);
        this.b.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0347));
        this.b.setTextSize(R.dimen.T_X08);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.leftMargin = getContext().getResources().getDimensionPixelSize(R.dimen.M_W_X005);
        layoutParams3.rightMargin = getContext().getResources().getDimensionPixelSize(R.dimen.M_W_X005);
        layoutParams3.gravity = 16;
        layoutParams3.weight = 1.0f;
        this.a.setLayoutParams(layoutParams3);
        hv4 d2 = hv4.d(this.a);
        d2.z(R.dimen.T_X06);
        d2.v(R.color.CAM_X0105);
        this.a.setText(getContext().getString(R.string.obfuscated_res_0x7f0f0348));
        this.a.setSingleLine();
        this.a.setEllipsize(TextUtils.TruncateAt.END);
    }
}
