package com.baidu.tieba.funad.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.RoundTbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.bumptech.glide.Glide;
import com.fun.ad.sdk.FunNativeAd;
import d.b.h0.b.d;
import d.b.h0.r.u.c;
import d.b.i0.a1.a.a;
import d.b.i0.c3.h0.n;
import d.b.i0.q0.a;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes4.dex */
public class FunAdNativeFrsView extends FunAdNativePbView {
    public TextView A;
    public ImageView B;
    public TextView C;
    public ViewGroup D;
    public ImageView E;
    public LinearLayout u;
    public RoundTbImageView v;
    public TextView w;
    public TextView x;
    public FunAdAgreeView y;
    public ImageView z;

    public FunAdNativeFrsView(Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void d(int i) {
        this.u.setVisibility(i);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
        marginLayoutParams.topMargin = i == 0 ? UtilHelper.getDimenPixelSize(R.dimen.M_H_X003) : 0;
        setLayoutParams(marginLayoutParams);
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void e(BdUniqueId bdUniqueId) {
        super.e(bdUniqueId);
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void f(@NonNull n nVar, @NonNull Activity activity) {
        super.f(nVar, activity);
        if (nVar.c() == null) {
            return;
        }
        FunNativeAd funNativeAd = (FunNativeAd) nVar.c();
        if (nVar.a() == null) {
            AgreeData agreeData = new AgreeData();
            agreeData.agreeNum = a.a(20, 100);
            nVar.f(agreeData);
        }
        AgreeData a2 = nVar.a();
        this.x.setText(this.f16810e);
        this.y.setAgreeAlone(true);
        this.y.setData(a2);
        if (StringUtils.isNull(funNativeAd.getIconUrl())) {
            Glide.with(this.v).load(Integer.valueOf(R.drawable.icon_frs_default_header)).into(this.v);
        } else {
            Glide.with(this.v).load(funNativeAd.getIconUrl()).into(this.v);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void g(Context context) {
        super.g(context);
        this.u = (LinearLayout) findViewById(R.id.fun_ad_frs_view_layout);
        this.v = (RoundTbImageView) findViewById(R.id.top_ad_logo);
        this.x = (TextView) findViewById(R.id.top_ad_name);
        this.w = (TextView) findViewById(R.id.top_ad_justnow);
        this.y = (FunAdAgreeView) findViewById(R.id.ad_agree_view);
        this.B = (ImageView) findViewById(R.id.thread_info_commont_img);
        this.C = (TextView) findViewById(R.id.thread_info_commont_num);
        this.z = (ImageView) findViewById(R.id.share_num_img);
        this.A = (TextView) findViewById(R.id.share_num);
        this.D = (ViewGroup) findViewById(R.id.layout_card_top);
        this.E = (ImageView) findViewById(R.id.fun_ad_feedback);
        this.f16842g.setVisibility(8);
        l();
        RelativeLayout relativeLayout = this.f16841f;
        relativeLayout.setPadding(relativeLayout.getPaddingLeft(), this.f16841f.getPaddingTop(), this.f16841f.getPaddingRight(), 0);
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public List<View> getClickViews() {
        return Arrays.asList(this, this.f16841f, this.i, this.o, this.s, this.q, this.D);
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public View getFeedBackView() {
        return this.E;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public int getLayoutId() {
        return R.layout.fun_ad_frs_native;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public a.c getLogItem() {
        return d.b.i0.q0.a.a("frs", d.l() ? "1" : "0");
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public String getPageType() {
        return "a006";
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void h() {
        super.h();
        WebPManager.setPureDrawable(this.E, R.drawable.icon_pure_card_close22, R.color.CAM_X0111, null);
        c a2 = c.a(this);
        a2.h(R.string.J_X06);
        a2.d(R.color.CAM_X0205, R.color.CAM_X0206);
        c.a(this.w).n(R.color.CAM_X0109);
        c.a(this.x).n(R.color.CAM_X0105);
        c.a(this.n).n(R.color.CAM_X0101);
        c a3 = c.a(this.l);
        a3.h(R.string.J_X04);
        a3.c(R.color.CAM_X0606);
        this.z.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_card_share22, d.b.i0.c3.c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE), WebPManager.ResourceStateType.NORMAL_DISABLE));
        this.B.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_card_comment22, d.b.i0.c3.c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE), WebPManager.ResourceStateType.NORMAL_DISABLE));
        this.A.setTextColor(d.b.i0.c3.c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
        this.C.setTextColor(d.b.i0.c3.c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView
    public void i(@NonNull FunNativeAd funNativeAd) {
        super.i(funNativeAd);
    }

    public final void l() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.y.getLayoutParams();
        int i = layoutParams.width;
        if (layoutParams.weight == 1.0f && i == 0) {
            return;
        }
        layoutParams.width = 0;
        layoutParams.weight = 1.0f;
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.y.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void setFunAdViewVisible(boolean z) {
        LinearLayout linearLayout = this.u;
        if (linearLayout != null) {
            linearLayout.setVisibility(z ? 0 : 8);
        }
    }

    public FunAdNativeFrsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FunAdNativeFrsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
