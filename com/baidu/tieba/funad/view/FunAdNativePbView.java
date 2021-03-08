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
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.elementsMaven.c;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.switchs.FunAdSdkSwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.funad.a.a;
import com.baidu.tieba.tbadkCore.data.n;
import com.bumptech.glide.Glide;
import com.fun.ad.sdk.ChannelNativeAds_5;
import com.fun.ad.sdk.FunNativeAd;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class FunAdNativePbView extends FunAbsAdView {
    protected RelativeLayout jWa;
    protected View jWb;
    protected EMTextView jWc;
    protected ViewGroup jWd;
    protected TbImageView jWe;
    protected View jWf;
    protected LinearLayout jWg;
    protected ImageView jWh;
    protected TextView jWi;
    protected TextView jWj;
    protected TextView jWk;
    protected FunAdButton jWl;
    protected ImageView jWm;
    protected FunAdDownloadView jWn;
    private FunAdButton jWo;

    public FunAdNativePbView(Context context) {
        super(context);
    }

    public FunAdNativePbView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FunAdNativePbView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void initView(Context context) {
        LayoutInflater.from(context).inflate(getLayoutId(), (ViewGroup) this, true);
        this.jWa = (RelativeLayout) findViewById(R.id.fun_card_layout);
        this.jWb = findViewById(R.id.divider_with_reply_title);
        this.jWc = (EMTextView) findViewById(R.id.fun_card_description);
        this.jWd = (ViewGroup) findViewById(R.id.media_bg);
        this.jWf = findViewById(R.id.media_mask);
        this.jWe = (TbImageView) findViewById(R.id.medig_image);
        this.jWg = (LinearLayout) findViewById(R.id.fun_ad_lable_pb_layout);
        this.jWh = (ImageView) findViewById(R.id.fun_ad_lable_icon);
        this.jWi = (TextView) findViewById(R.id.fun_ad_lable_pb);
        this.jWj = (TextView) findViewById(R.id.fun_ad_title);
        this.jWk = (TextView) findViewById(R.id.fun_ad_lable_frs);
        this.jWl = (FunAdButton) findViewById(R.id.fun_ad_button);
        this.jWm = (ImageView) findViewById(R.id.fun_ad_feedback_pb);
        this.jWn = (FunAdDownloadView) findViewById(R.id.fun_ad_download_container);
        c.br(this.jWf).setBackGroundColor(R.color.CAM_X0607);
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void cNF() {
        WebPManager.a(this.jWm, R.drawable.icon_pure_card_close22, R.color.CAM_X0111, null);
        ap.setBackgroundColor(this.jWb, R.color.CAM_X0204);
        c.br(this.jWc).nZ(R.color.CAM_X0105);
        c.br(this.jWj).nZ(R.color.CAM_X0109);
        c.br(this.jWi).nZ(R.color.CAM_X0101);
        c.br(this.jWg).oh(R.string.J_X04).setBackGroundColor(R.color.CAM_X0606);
        this.jWl.onChangeSkinType();
        this.jWn.Bj(TbadkCoreApplication.getInst().getSkinType());
        this.jWf.setVisibility(TbadkCoreApplication.getInst().getSkinType() == 0 ? 8 : 0);
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void a(@NonNull n nVar, @NonNull Activity activity) {
        if (nVar.dNz() != null) {
            FunNativeAd funNativeAd = (FunNativeAd) nVar.dNz();
            this.jVe = funNativeAd.getTitle();
            if (StringUtils.isNull(this.jVe) || this.jVe.equals(activity.getString(R.string.fun_ad_label))) {
                this.jVe = activity.getString(R.string.fun_ad_title_promotion);
            }
            this.jWj.setText(this.jVe);
            this.jWc.setText(funNativeAd.getDescription());
            this.jWn.setViewData(funNativeAd, activity, getPageType());
            if (this.jWd.getChildCount() > 2) {
                this.jWd.removeViews(2, this.jWd.getChildCount() - 2);
            }
            if (funNativeAd.getVideoView() != null) {
                this.jWd.addView(funNativeAd.getVideoView(), new ViewGroup.LayoutParams(-1, -1));
            }
            if (StringUtils.isNull(nVar.dNA())) {
                nVar.Tv(com.baidu.tieba.funad.c.a(funNativeAd, activity));
            }
            this.jWn.getDownloadButton().setText(nVar.dNA());
            this.jWl.setText(nVar.dNA());
            f(funNativeAd);
            List<String> imageUrls = funNativeAd.getImageUrls();
            if (y.isEmpty(imageUrls)) {
                this.jWe.reset();
                this.jWe.setVisibility(8);
            } else {
                this.jWe.setVisibility(0);
                Glide.with(this.jWe).load(imageUrls.get(0)).into(this.jWe);
            }
            rN(com.baidu.tieba.funad.c.a(funNativeAd));
            a(funNativeAd, nVar);
        }
    }

    public void rN(boolean z) {
        if (FunAdSdkSwitch.isOn() && z) {
            this.jWn.setVisibility(0);
            this.jWl.setVisibility(8);
            this.jWo = this.jWn.getDownloadButton();
            return;
        }
        this.jWn.setVisibility(8);
        this.jWl.setVisibility(0);
        this.jWo = this.jWl;
    }

    public void f(@NonNull FunNativeAd funNativeAd) {
        int b = com.baidu.tieba.funad.c.b(funNativeAd);
        if (b == -1) {
            this.jWh.setVisibility(8);
            return;
        }
        this.jWh.setVisibility(0);
        this.jWh.setImageDrawable(WebPManager.a(b, WebPManager.ResourceStateType.NORMAL));
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public String getPageType() {
        return PageStayDurationConstants.PageName.PB;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    protected int getLayoutId() {
        return R.layout.fun_ad_pb_native;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public View getFeedBackView() {
        return this.jWm;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public List<View> getClickViews() {
        return Arrays.asList(this, this.jWa, this.jWd, this.jWj, this.jWn, this.jWl);
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public List<View> getCreativeViews() {
        return Collections.singletonList(this.jWl);
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void setFunAdViewVisible(boolean z) {
        if (this.jWa != null) {
            this.jWa.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public FrameLayout e(FunNativeAd funNativeAd) {
        return this;
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void s(BdUniqueId bdUniqueId) {
        if (bdUniqueId == AdvertAppInfo.eMN) {
            this.jWm.setVisibility(8);
        } else {
            this.jWm.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void Bi(int i) {
        this.jWa.setVisibility(i);
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void cNG() {
        this.jWl.onDestroy();
        this.jWn.getDownloadButton().onDestroy();
    }

    @Override // com.baidu.tieba.funad.view.FunAbsAdView
    public void setDownloadDelayText(String str, long j) {
        if (this.jWl.getVisibility() == 0) {
            this.jWl.setTextDelay(str, j);
        }
        if (this.jWn.getDownloadButton().getVisibility() == 0) {
            this.jWn.getDownloadButton().setTextDelay(str, j);
        }
    }

    private void a(@NonNull FunNativeAd funNativeAd, n nVar) {
        ChannelNativeAds_5 channelNativeAds_5 = funNativeAd.getChannelNativeAds_5();
        this.jWo.setTag(nVar);
        a aVar = new a(this.jWo, nVar);
        if (channelNativeAds_5 != null && channelNativeAds_5.ksNative != null) {
            channelNativeAds_5.ksNative.setDownloadListener(aVar);
        } else if (channelNativeAds_5 != null && channelNativeAds_5.csjNative != null) {
            channelNativeAds_5.csjNative.setDownloadListener(aVar);
        } else if (channelNativeAds_5 != null && channelNativeAds_5.gdtNative != null) {
            channelNativeAds_5.setGdtADStatusChangeListener(aVar);
        }
    }
}
