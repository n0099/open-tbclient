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
import androidx.cardview.widget.CardView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.switchs.FunAdSdkSwitch;
import com.baidu.tieba.R;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.ChannelNativeAds_6;
import com.fun.ad.sdk.FunNativeAd;
import com.kwad.sdk.api.KsNativeAd;
import d.a.m0.b.d;
import d.a.m0.r.u.c;
import d.a.n0.e3.h0.n;
import d.a.n0.s0.a;
import d.a.n0.t0.b;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public class FunAdNativePbView extends FunAbsAdView {

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f16038f;

    /* renamed from: g  reason: collision with root package name */
    public View f16039g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f16040h;

    /* renamed from: i  reason: collision with root package name */
    public FunAdSmallPicView f16041i;
    public ViewGroup j;
    public CardView k;
    public FunAdNativePicView l;
    public EMTextView m;
    public TextView n;
    public LinearLayout o;
    public ImageView p;
    public TextView q;
    public ImageView r;
    public FunAdButton s;
    public FunAdDownloadView t;
    public FunAdButton u;

    public FunAdNativePbView(Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void b() {
        this.s.i();
        this.t.getDownloadButton().i();
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public FrameLayout c(FunNativeAd funNativeAd) {
        return this;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void d(int i2) {
        this.f16038f.setVisibility(i2);
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void e(BdUniqueId bdUniqueId) {
        if (bdUniqueId == AdvertAppInfo.o4) {
            this.r.setVisibility(8);
        } else {
            this.r.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void f(@NonNull n nVar, @NonNull Activity activity) {
        if (nVar.d() == null) {
            return;
        }
        FunNativeAd funNativeAd = (FunNativeAd) nVar.d();
        b.f(funNativeAd);
        String title = funNativeAd.getTitle();
        this.f16004e = title;
        if (StringUtils.isNull(title) || this.f16004e.equals(activity.getString(R.string.fun_ad_label))) {
            this.f16004e = activity.getString(R.string.fun_ad_title_promotion);
        }
        this.n.setText(this.f16004e);
        this.m.setText(funNativeAd.getDescription());
        List<String> imageUrls = funNativeAd.getImageUrls();
        this.k.removeAllViews();
        if (b.k(funNativeAd, imageUrls)) {
            this.f16040h.setVisibility(8);
            this.f16041i.setVisibility(0);
            this.f16041i.setData(funNativeAd, (String) ListUtils.getItem(imageUrls, 0));
            return;
        }
        this.f16040h.setVisibility(0);
        this.f16041i.setVisibility(8);
        if (funNativeAd.getVideoView() != null) {
            b.q(this.j, b.m(funNativeAd));
            this.k.addView(funNativeAd.getVideoView(), new ViewGroup.LayoutParams(-1, -1));
            this.k.setVisibility(0);
            this.l.setVisibility(8);
        } else {
            b.p(this.j, b.l(funNativeAd, imageUrls), imageUrls);
            this.k.setVisibility(8);
            this.l.setFunNativeAd(imageUrls);
        }
        i(funNativeAd);
        this.t.setViewData(funNativeAd, activity, getPageType());
        if (StringUtils.isNull(nVar.b())) {
            nVar.i(b.b(funNativeAd, activity));
        }
        this.t.getDownloadButton().setText(nVar.b());
        this.s.setText(nVar.b());
        j(b.j(funNativeAd));
        k(funNativeAd, nVar);
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void g(Context context) {
        LayoutInflater.from(context).inflate(getLayoutId(), (ViewGroup) this, true);
        this.f16038f = (RelativeLayout) findViewById(R.id.fun_card_layout);
        this.f16039g = findViewById(R.id.divider_with_reply_title);
        this.m = (EMTextView) findViewById(R.id.fun_card_description);
        this.f16040h = (ViewGroup) findViewById(R.id.fun_ad_container);
        this.j = (ViewGroup) findViewById(R.id.media_container);
        this.k = (CardView) findViewById(R.id.media_video);
        this.l = (FunAdNativePicView) findViewById(R.id.medig_image);
        this.f16041i = (FunAdSmallPicView) findViewById(R.id.media_small);
        this.n = (TextView) findViewById(R.id.fun_ad_title);
        this.o = (LinearLayout) findViewById(R.id.fun_ad_lable_pb_layout);
        this.p = (ImageView) findViewById(R.id.fun_ad_lable_icon);
        this.q = (TextView) findViewById(R.id.fun_ad_lable_pb);
        this.s = (FunAdButton) findViewById(R.id.fun_ad_button);
        this.r = (ImageView) findViewById(R.id.fun_ad_feedback_pb);
        this.t = (FunAdDownloadView) findViewById(R.id.fun_ad_download_container);
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public List<View> getClickViews() {
        return Arrays.asList(this, this.f16038f, this.k, this.n, this.t, this.s);
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public List<View> getCreativeViews() {
        return Collections.singletonList(this.s);
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
    public a.e getLogItem() {
        return a.a("pb", d.B() ? "1" : "0");
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public String getPageType() {
        return "a005";
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void h() {
        WebPManager.setPureDrawable(this.r, R.drawable.icon_pure_card_close22, R.color.CAM_X0111, null);
        SkinManager.setBackgroundColor(this.f16039g, R.color.CAM_X0204);
        c.d(this.m).s(R.color.CAM_X0105);
        c.d(this.n).s(R.color.CAM_X0109);
        c.d(this.q).s(R.color.CAM_X0101);
        c d2 = c.d(this.o);
        d2.m(R.string.J_X01);
        d2.f(R.color.CAM_X0606);
        this.s.h();
        this.t.d(TbadkCoreApplication.getInst().getSkinType());
        this.l.d();
        this.f16041i.c();
    }

    public void i(@NonNull FunNativeAd funNativeAd) {
        b.r(this.p, funNativeAd);
    }

    public void j(boolean z) {
        if (FunAdSdkSwitch.isOn() && z) {
            this.t.setVisibility(0);
            this.s.setVisibility(8);
            this.u = this.t.getDownloadButton();
            return;
        }
        this.t.setVisibility(8);
        this.s.setVisibility(0);
        this.u = this.s;
    }

    public final void k(@NonNull FunNativeAd funNativeAd, n nVar) {
        TTNativeAd tTNativeAd;
        KsNativeAd ksNativeAd;
        ChannelNativeAds_6 channelNativeAds_6 = funNativeAd.getChannelNativeAds_6();
        this.u.setTag(nVar);
        d.a.n0.t0.f.a aVar = new d.a.n0.t0.f.a(this.u, nVar);
        if (channelNativeAds_6 != null && (ksNativeAd = channelNativeAds_6.ksNative) != null) {
            ksNativeAd.setDownloadListener(aVar);
        } else if (channelNativeAds_6 != null && (tTNativeAd = channelNativeAds_6.csjNative) != null) {
            tTNativeAd.setDownloadListener(aVar);
        } else if (channelNativeAds_6 == null || channelNativeAds_6.gdtNative == null) {
        } else {
            channelNativeAds_6.setGdtADStatusChangeListener(aVar);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void setDownloadDelayText(String str, long j) {
        if (this.s.getVisibility() == 0) {
            this.s.setTextDelay(str, j);
        }
        if (this.t.getDownloadButton().getVisibility() == 0) {
            this.t.getDownloadButton().setTextDelay(str, j);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void setFeedBackListener(View.OnClickListener onClickListener) {
        FunAdSmallPicView funAdSmallPicView = this.f16041i;
        if (funAdSmallPicView != null) {
            funAdSmallPicView.setFeedBackListener(onClickListener);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void setFunAdViewVisible(boolean z) {
        RelativeLayout relativeLayout = this.f16038f;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(z ? 0 : 8);
        }
    }

    public FunAdNativePbView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FunAdNativePbView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
