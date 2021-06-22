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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.RoundTbImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.fun.ad.sdk.FunNativeAd;
import d.a.n0.b.d;
import d.a.n0.r.u.c;
import d.a.o0.c1.a.a;
import d.a.o0.e3.h0.n;
import d.a.o0.s0.a;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes4.dex */
public class FunAdNativeFrsView extends FunAdNativePbView {
    public View A;
    public ImageView B;
    public TextView C;
    public View D;
    public ImageView E;
    public TextView F;
    public ViewGroup G;
    public ImageView H;
    public LinearLayout v;
    public RoundTbImageView w;
    public TextView x;
    public TextView y;
    public FunAdAgreeView z;

    public FunAdNativeFrsView(Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void d(int i2) {
        this.v.setVisibility(i2);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
        marginLayoutParams.topMargin = i2 == 0 ? UtilHelper.getDimenPixelSize(R.dimen.M_H_X003) : 0;
        setLayoutParams(marginLayoutParams);
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void e(BdUniqueId bdUniqueId) {
        super.e(bdUniqueId);
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void f(@NonNull n nVar, @NonNull Activity activity) {
        super.f(nVar, activity);
        if (nVar.d() == null) {
            return;
        }
        FunNativeAd funNativeAd = (FunNativeAd) nVar.d();
        if (nVar.a() == null) {
            AgreeData agreeData = new AgreeData();
            agreeData.agreeNum = a.a(25, 1000);
            nVar.h(agreeData);
        }
        this.y.setText(this.f16086e);
        AgreeData a2 = nVar.a();
        this.z.setAgreeAlone(true);
        this.z.setData(a2);
        this.w.U(funNativeAd.getIconUrl(), 10, false);
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void g(Context context) {
        super.g(context);
        this.v = (LinearLayout) findViewById(R.id.fun_ad_frs_view_layout);
        this.w = (RoundTbImageView) findViewById(R.id.top_ad_logo);
        this.y = (TextView) findViewById(R.id.top_ad_name);
        this.x = (TextView) findViewById(R.id.top_ad_justnow);
        this.z = (FunAdAgreeView) findViewById(R.id.ad_agree_view);
        this.A = findViewById(R.id.share_num_container);
        this.D = findViewById(R.id.thread_info_commont_container);
        this.E = (ImageView) findViewById(R.id.thread_info_commont_img);
        this.F = (TextView) findViewById(R.id.thread_info_commont_num);
        this.B = (ImageView) findViewById(R.id.share_num_img);
        this.C = (TextView) findViewById(R.id.share_num);
        this.G = (ViewGroup) findViewById(R.id.layout_card_top);
        this.H = (ImageView) findViewById(R.id.fun_ad_feedback);
        this.f16121g.setVisibility(8);
        m(this.w);
        l();
        RelativeLayout relativeLayout = this.f16120f;
        relativeLayout.setPadding(relativeLayout.getPaddingLeft(), this.f16120f.getPaddingTop(), this.f16120f.getPaddingRight(), 0);
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public List<View> getClickViews() {
        return Arrays.asList(this, this.f16120f, this.k, this.n, this.t, this.s, this.G);
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public View getFeedBackView() {
        return this.H;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public int getLayoutId() {
        return R.layout.fun_ad_frs_native;
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public a.e getLogItem() {
        return d.a.o0.s0.a.a("frs", d.m() ? "1" : "0");
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public String getPageType() {
        return "a006";
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void h() {
        super.h();
        c d2 = c.d(this);
        d2.m(R.string.J_X06);
        d2.h(R.color.CAM_X0205, R.color.CAM_X0206);
        c.d(this.x).s(R.color.CAM_X0109);
        c.d(this.y).s(R.color.CAM_X0105);
        WebPManager.setPureDrawable(this.H, R.drawable.icon_pure_card_close22, R.color.CAM_X0111, null);
        this.B.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_card_share22, d.a.o0.e3.c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE), WebPManager.ResourceStateType.NORMAL_DISABLE));
        this.E.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_card_comment22, d.a.o0.e3.c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE), WebPManager.ResourceStateType.NORMAL_DISABLE));
        this.C.setTextColor(d.a.o0.e3.c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
        this.F.setTextColor(d.a.o0.e3.c.a(SkinManager.getColor(R.color.CAM_X0107), SkinManager.RESOURCE_ALPHA_DISABLE));
        this.w.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView
    public void i(@NonNull FunNativeAd funNativeAd) {
        super.i(funNativeAd);
    }

    public final void l() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.z.getLayoutParams();
        int i2 = layoutParams.width;
        if (layoutParams.weight == 1.0f && i2 == 0) {
            return;
        }
        layoutParams.width = 0;
        layoutParams.weight = 1.0f;
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
        this.z.setLayoutParams(layoutParams);
    }

    public final void m(TbImageView tbImageView) {
        tbImageView.setDefaultResource(R.drawable.icon_frs_default_header);
        tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        tbImageView.setIsLongPic(false);
        tbImageView.setIsSmartCrop(false);
        tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        tbImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        tbImageView.setBorderSurroundContent(true);
        tbImageView.setDrawBorder(true);
    }

    @Override // com.baidu.tieba.funad.view.FunAdNativePbView, com.baidu.tieba.funad.view.FunAbsAdView
    public void setFunAdViewVisible(boolean z) {
        LinearLayout linearLayout = this.v;
        if (linearLayout != null) {
            linearLayout.setVisibility(z ? 0 : 8);
        }
    }

    public FunAdNativeFrsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FunAdNativeFrsView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
