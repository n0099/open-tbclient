package com.baidu.tieba.homepage.personalize.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
import d.a.n0.r.u.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bB\u001d\b\u0016\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001a\u0010\u001eJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R.\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001f"}, d2 = {"Lcom/baidu/tieba/homepage/personalize/view/HomePageBrowseModelTipView;", "Landroid/widget/LinearLayout;", "", "onChangeSkinType", "()V", "contentContainer", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "value", "listener", "Landroid/view/View$OnClickListener;", "getListener", "()Landroid/view/View$OnClickListener;", "setListener", "(Landroid/view/View$OnClickListener;)V", "Landroid/view/View;", "placeHolder", "Landroid/view/View;", "Lcom/baidu/tbadk/core/view/commonBtn/TBSpecificationBtn;", "tipBtn", "Lcom/baidu/tbadk/core/view/commonBtn/TBSpecificationBtn;", "Landroid/widget/TextView;", "tipText", "Landroid/widget/TextView;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "recommendfrs_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class HomePageBrowseModelTipView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public final TextView f16626e;

    /* renamed from: f  reason: collision with root package name */
    public final TBSpecificationBtn f16627f;

    /* renamed from: g  reason: collision with root package name */
    public final View f16628g;

    /* renamed from: h  reason: collision with root package name */
    public final LinearLayout f16629h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f16630i;

    public HomePageBrowseModelTipView(Context context) {
        this(context, null);
    }

    public final void a() {
        c d2 = c.d(this.f16629h);
        d2.m(R.string.J_X06);
        d2.f(R.color.CAM_X0201);
        SkinManager.setViewTextColor(this.f16626e, R.color.CAM_X0105);
        this.f16627f.k();
    }

    public final View.OnClickListener getListener() {
        return this.f16630i;
    }

    public final void setListener(View.OnClickListener onClickListener) {
        this.f16630i = onClickListener;
        if (onClickListener != null) {
            this.f16627f.setOnClickListener(onClickListener);
        }
    }

    public HomePageBrowseModelTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16626e = new TextView(getContext());
        this.f16627f = new TBSpecificationBtn(getContext());
        this.f16628g = new View(getContext());
        this.f16629h = new LinearLayout(getContext());
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        setOrientation(1);
        Context context2 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context2, "context");
        this.f16628g.setLayoutParams(new LinearLayout.LayoutParams(-1, context2.getResources().getDimensionPixelSize(R.dimen.M_H_X003)));
        addView(this.f16628g);
        addView(this.f16629h);
        ViewGroup.LayoutParams layoutParams = this.f16629h.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        this.f16629h.setLayoutParams(layoutParams);
        this.f16629h.setOrientation(0);
        c d2 = c.d(this.f16629h);
        d2.m(R.string.J_X06);
        d2.f(R.color.CAM_X0201);
        this.f16629h.addView(this.f16626e);
        this.f16629h.addView(this.f16627f);
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
        this.f16627f.setLayoutParams(layoutParams2);
        d.a.n0.r.f0.m.c cVar = new d.a.n0.r.f0.m.c();
        cVar.o(R.color.CAM_X0304);
        this.f16627f.setConfig(cVar);
        this.f16627f.setText(getContext().getString(R.string.browse_mode_tip_view_btn_text));
        this.f16627f.setTextSize(R.dimen.T_X08);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        Context context8 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context8, "context");
        layoutParams3.leftMargin = context8.getResources().getDimensionPixelSize(R.dimen.M_W_X005);
        Context context9 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context9, "context");
        layoutParams3.rightMargin = context9.getResources().getDimensionPixelSize(R.dimen.M_W_X005);
        layoutParams3.gravity = 16;
        layoutParams3.weight = 1.0f;
        this.f16626e.setLayoutParams(layoutParams3);
        c d3 = c.d(this.f16626e);
        d3.w(R.dimen.T_X06);
        d3.s(R.color.CAM_X0105);
        this.f16626e.setText(getContext().getString(R.string.browse_mode_tip_view_tip_text));
        this.f16626e.setSingleLine();
        this.f16626e.setEllipsize(TextUtils.TruncateAt.END);
    }
}
