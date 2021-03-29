package com.baidu.tieba.funad.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.switchs.FunAdSdkSwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.bumptech.glide.Glide;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.ChannelNativeAds_5;
import com.fun.ad.sdk.FunNativeAd;
import com.kwad.sdk.api.KsNativeAd;
import d.b.h0.b.d;
import d.b.i0.c3.h0.n;
import d.b.i0.q0.a;
import d.b.i0.r0.c;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public class FunAdNativePbView extends FunAbsAdView {

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f16842f;

    /* renamed from: g  reason: collision with root package name */
    public View f16843g;

    /* renamed from: h  reason: collision with root package name */
    public EMTextView f16844h;
    public ViewGroup i;
    public TbImageView j;
    public View k;
    public LinearLayout l;
    public ImageView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public FunAdButton q;
    public ImageView r;
    public FunAdDownloadView s;
    public FunAdButton t;

    public FunAdNativePbView(Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void b() {
        this.q.i();
        this.s.getDownloadButton().i();
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public FrameLayout c(FunNativeAd funNativeAd) {
        return this;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void d(int i) {
        this.f16842f.setVisibility(i);
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void e(BdUniqueId bdUniqueId) {
        if (bdUniqueId == AdvertAppInfo.n4) {
            this.r.setVisibility(8);
        } else {
            this.r.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void f(@NonNull n nVar, @NonNull Activity activity) {
        if (nVar.c() == null) {
            return;
        }
        FunNativeAd funNativeAd = (FunNativeAd) nVar.c();
        String title = funNativeAd.getTitle();
        this.f16811e = title;
        if (StringUtils.isNull(title) || this.f16811e.equals(activity.getString(R.string.fun_ad_label))) {
            this.f16811e = activity.getString(R.string.fun_ad_title_promotion);
        }
        this.o.setText(this.f16811e);
        this.f16844h.setText(funNativeAd.getDescription());
        this.s.setViewData(funNativeAd, activity, getPageType());
        if (this.i.getChildCount() > 2) {
            ViewGroup viewGroup = this.i;
            viewGroup.removeViews(2, viewGroup.getChildCount() - 2);
        }
        if (funNativeAd.getVideoView() != null) {
            this.i.addView(funNativeAd.getVideoView(), new ViewGroup.LayoutParams(-1, -1));
        }
        if (StringUtils.isNull(nVar.b())) {
            nVar.g(c.b(funNativeAd, activity));
        }
        this.s.getDownloadButton().setText(nVar.b());
        this.q.setText(nVar.b());
        i(funNativeAd);
        List<String> imageUrls = funNativeAd.getImageUrls();
        if (ListUtils.isEmpty(imageUrls)) {
            this.j.S();
            this.j.setVisibility(8);
        } else {
            this.j.setVisibility(0);
            Glide.with(this.j).load(imageUrls.get(0)).into(this.j);
        }
        j(c.c(funNativeAd));
        k(funNativeAd, nVar);
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void g(Context context) {
        LayoutInflater.from(context).inflate(getLayoutId(), (ViewGroup) this, true);
        this.f16842f = (RelativeLayout) findViewById(R.id.fun_card_layout);
        this.f16843g = findViewById(R.id.divider_with_reply_title);
        this.f16844h = (EMTextView) findViewById(R.id.fun_card_description);
        this.i = (ViewGroup) findViewById(R.id.media_bg);
        this.k = findViewById(R.id.media_mask);
        this.j = (TbImageView) findViewById(R.id.medig_image);
        this.l = (LinearLayout) findViewById(R.id.fun_ad_lable_pb_layout);
        this.m = (ImageView) findViewById(R.id.fun_ad_lable_icon);
        this.n = (TextView) findViewById(R.id.fun_ad_lable_pb);
        this.o = (TextView) findViewById(R.id.fun_ad_title);
        this.p = (TextView) findViewById(R.id.fun_ad_lable_frs);
        this.q = (FunAdButton) findViewById(R.id.fun_ad_button);
        this.r = (ImageView) findViewById(R.id.fun_ad_feedback_pb);
        this.s = (FunAdDownloadView) findViewById(R.id.fun_ad_download_container);
        d.b.h0.r.u.c.a(this.k).c(R.color.CAM_X0607);
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public List<View> getClickViews() {
        return Arrays.asList(this, this.f16842f, this.i, this.o, this.s, this.q);
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public List<View> getCreativeViews() {
        return Collections.singletonList(this.q);
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public View getFeedBackView() {
        return this.r;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public int getLayoutId() {
        return R.layout.fun_ad_pb_native;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public a.c getLogItem() {
        return a.a("pb", d.A() ? "1" : "0");
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public String getPageType() {
        return "a005";
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void h() {
        WebPManager.setPureDrawable(this.r, R.drawable.icon_pure_card_close22, R.color.CAM_X0111, null);
        SkinManager.setBackgroundColor(this.f16843g, R.color.CAM_X0204);
        d.b.h0.r.u.c.a(this.f16844h).n(R.color.CAM_X0105);
        d.b.h0.r.u.c.a(this.o).n(R.color.CAM_X0109);
        d.b.h0.r.u.c.a(this.n).n(R.color.CAM_X0101);
        d.b.h0.r.u.c a2 = d.b.h0.r.u.c.a(this.l);
        a2.h(R.string.J_X04);
        a2.c(R.color.CAM_X0606);
        this.q.h();
        this.s.d(TbadkCoreApplication.getInst().getSkinType());
        this.k.setVisibility(TbadkCoreApplication.getInst().getSkinType() == 0 ? 8 : 0);
    }

    public void i(@NonNull FunNativeAd funNativeAd) {
        int a2 = c.a(funNativeAd);
        if (a2 == -1) {
            this.m.setVisibility(8);
            return;
        }
        this.m.setVisibility(0);
        this.m.setImageDrawable(WebPManager.getMaskDrawable(a2, WebPManager.ResourceStateType.NORMAL));
    }

    public void j(boolean z) {
        if (FunAdSdkSwitch.isOn() && z) {
            this.s.setVisibility(0);
            this.q.setVisibility(8);
            this.t = this.s.getDownloadButton();
            return;
        }
        this.s.setVisibility(8);
        this.q.setVisibility(0);
        this.t = this.q;
    }

    public final void k(@NonNull FunNativeAd funNativeAd, n nVar) {
        TTNativeAd tTNativeAd;
        KsNativeAd ksNativeAd;
        ChannelNativeAds_5 channelNativeAds_5 = funNativeAd.getChannelNativeAds_5();
        this.t.setTag(nVar);
        d.b.i0.r0.f.a aVar = new d.b.i0.r0.f.a(this.t, nVar);
        if (channelNativeAds_5 != null && (ksNativeAd = channelNativeAds_5.ksNative) != null) {
            ksNativeAd.setDownloadListener(aVar);
        } else if (channelNativeAds_5 != null && (tTNativeAd = channelNativeAds_5.csjNative) != null) {
            tTNativeAd.setDownloadListener(aVar);
        } else if (channelNativeAds_5 == null || channelNativeAds_5.gdtNative == null) {
        } else {
            channelNativeAds_5.setGdtADStatusChangeListener(aVar);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void setDownloadDelayText(String str, long j) {
        if (this.q.getVisibility() == 0) {
            this.q.setTextDelay(str, j);
        }
        if (this.s.getDownloadButton().getVisibility() == 0) {
            this.s.getDownloadButton().setTextDelay(str, j);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void setFunAdViewVisible(boolean z) {
        RelativeLayout relativeLayout = this.f16842f;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(z ? 0 : 8);
        }
    }

    public FunAdNativePbView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FunAdNativePbView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
