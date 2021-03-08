package com.baidu.tieba.funad.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.f.g;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.c;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.switchs.FunAdSdkSwitch;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.EBusinessProtocolView;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.ChannelNativeAds_5;
import com.fun.ad.sdk.FunNativeAd;
import com.kwad.sdk.api.KsNativeAd;
import com.qq.e.ads.nativ.NativeUnifiedADData;
/* loaded from: classes5.dex */
public class FunAdDownloadView extends RelativeLayout {
    private ViewGroup jVA;
    private TextView jVB;
    private TextView jVC;
    private TextView jVD;
    private EBusinessProtocolView jVE;
    private FunAdButton jVt;
    private TextView jVu;
    private LinearLayout jVv;
    private RankStarView jVw;
    private TextView jVx;
    private TextView jVy;
    private TextView jVz;
    private final Context mContext;

    public FunAdDownloadView(Context context) {
        this(context, null, 0);
    }

    public FunAdDownloadView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FunAdDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initView();
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.fun_ad_download_info, (ViewGroup) this, true);
        this.jVt = (FunAdButton) findViewById(R.id.fun_ad_download_button);
        this.jVu = (TextView) findViewById(R.id.fun_ad_download_title);
        this.jVv = (LinearLayout) findViewById(R.id.fun_ad_download_score_layout);
        this.jVw = (RankStarView) findViewById(R.id.fun_ad_download_star);
        this.jVx = (TextView) findViewById(R.id.fun_ad_download_score);
        this.jVy = (TextView) findViewById(R.id.fun_ad_download_count);
        this.jVz = (TextView) findViewById(R.id.fun_ad_download_version);
        this.jVA = (ViewGroup) findViewById(R.id.fun_download_line_2);
        this.jVB = (TextView) findViewById(R.id.fun_ad_download_company);
        this.jVC = (TextView) findViewById(R.id.fun_ad_download_privacy);
        this.jVD = (TextView) findViewById(R.id.fun_ad_download_authority);
        this.jVE = new EBusinessProtocolView(this.mContext, EBusinessProtocolView.WindowType.TIP);
    }

    public void Bj(int i) {
        c.br(this).oh(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
        c.br(this.jVu).nZ(R.color.CAM_X0107);
        c.br(this.jVz).nZ(R.color.CAM_X0109);
        c.br(this.jVx).nZ(R.color.CAM_X0109);
        c.br(this.jVy).nZ(R.color.CAM_X0109);
        c.br(this.jVB).nZ(R.color.CAM_X0109);
        c.br(this.jVC).nZ(R.color.CAM_X0109);
        c.br(this.jVD).nZ(R.color.CAM_X0109);
        this.jVt.onChangeSkinType();
        this.jVw.onChangeSkinType(i);
    }

    public FunAdButton getDownloadButton() {
        return this.jVt;
    }

    public void setViewData(FunNativeAd funNativeAd, final Activity activity, final String str) {
        if (!com.baidu.tieba.funad.c.a(funNativeAd) || !FunAdSdkSwitch.isOn()) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        final a aVar = new a(funNativeAd);
        this.jVu.setText(aVar.cNH());
        float cNI = aVar.cNI();
        if (cNI > 2.5d) {
            this.jVv.setVisibility(0);
            this.jVy.setVisibility(8);
            this.jVx.setText(String.valueOf(cNI));
            this.jVw.setStarCount(cNI);
        } else if (!TextUtils.isEmpty(aVar.cNJ())) {
            this.jVv.setVisibility(8);
            this.jVy.setVisibility(0);
            this.jVy.setText(aVar.cNJ());
        } else {
            this.jVv.setVisibility(8);
            this.jVy.setVisibility(8);
        }
        if (!TextUtils.isEmpty(aVar.cNK())) {
            this.jVz.setText(aVar.cNK());
            this.jVz.setVisibility(0);
        } else {
            this.jVz.setVisibility(8);
        }
        if (!TextUtils.isEmpty(aVar.cNL())) {
            this.jVB.setText(aVar.cNL());
            this.jVB.setVisibility(0);
            this.jVB.requestLayout();
        } else {
            this.jVB.setVisibility(8);
        }
        if (!TextUtils.isEmpty(aVar.cNN())) {
            this.jVD.setVisibility(0);
            this.jVE.v(aVar.cNN());
            this.jVE.setTitle(this.mContext.getString(R.string.fun_ad_privacy_dialog_title));
            this.jVD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.funad.view.FunAdDownloadView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    g.showDialog(FunAdDownloadView.this.jVE, activity);
                    TiebaStatic.log(new ar("c14090").aq("obj_source", 6).dR("obj_type", str));
                }
            });
        } else {
            this.jVD.setVisibility(8);
        }
        if (!TextUtils.isEmpty(aVar.cNM())) {
            this.jVC.setVisibility(0);
            this.jVC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.funad.view.FunAdDownloadView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.ay(FunAdDownloadView.this.mContext, aVar.cNM());
                    TiebaStatic.log(new ar("c14089").aq("obj_source", 6).dR("obj_type", str));
                }
            });
        } else {
            this.jVC.setVisibility(8);
        }
        if ((this.jVB.getVisibility() & this.jVD.getVisibility() & this.jVC.getVisibility()) != 8) {
            this.jVA.setVisibility(0);
        } else {
            this.jVA.setVisibility(8);
        }
    }

    /* loaded from: classes5.dex */
    private static class a {
        private final CharSequence jVI;
        private final float jVJ;
        private final String jVK;
        private final String jVL;
        private final String jVM;
        private final String jVN;
        private final String jVO;

        public a(@NonNull FunNativeAd funNativeAd) {
            ChannelNativeAds_5 channelNativeAds_5 = funNativeAd.getChannelNativeAds_5();
            if (channelNativeAds_5 != null && channelNativeAds_5.csjNative != null) {
                TTNativeAd tTNativeAd = channelNativeAds_5.csjNative;
                this.jVJ = tTNativeAd.getAppScore();
                this.jVK = null;
                this.jVL = null;
                this.jVM = tTNativeAd.getSource();
                this.jVO = null;
                this.jVN = null;
                this.jVI = tTNativeAd.getTitle();
            } else if (channelNativeAds_5 != null && channelNativeAds_5.ksNative != null) {
                KsNativeAd ksNativeAd = channelNativeAds_5.ksNative;
                this.jVI = ksNativeAd.getAppName();
                this.jVJ = ksNativeAd.getAppScore() / 2.0f;
                this.jVK = ksNativeAd.getAppDownloadCountDes();
                this.jVL = TbadkCoreApplication.getInst().getString(R.string.fun_ad_item_version) + ksNativeAd.getAppVersion();
                this.jVM = ksNativeAd.getCorporationName();
                this.jVO = ksNativeAd.getPermissionInfo();
                this.jVN = ksNativeAd.getAppPrivacyUrl();
            } else if (channelNativeAds_5 != null && channelNativeAds_5.gdtNative != null) {
                NativeUnifiedADData nativeUnifiedADData = channelNativeAds_5.gdtNative;
                this.jVI = nativeUnifiedADData.getTitle();
                this.jVJ = nativeUnifiedADData.getAppScore() / 2.0f;
                this.jVK = TbadkCoreApplication.getInst().getString(R.string.fun_ad_item_download_count, new Object[]{au.numberUniformFormat(nativeUnifiedADData.getDownloadCount())});
                this.jVL = null;
                this.jVM = null;
                this.jVO = null;
                this.jVN = null;
            } else {
                this.jVJ = 0.0f;
                this.jVK = null;
                this.jVL = null;
                this.jVM = null;
                this.jVO = null;
                this.jVN = null;
                this.jVI = "";
            }
        }

        public CharSequence cNH() {
            return this.jVI;
        }

        public float cNI() {
            return this.jVJ;
        }

        public String cNJ() {
            return this.jVK;
        }

        public String cNK() {
            return this.jVL;
        }

        public String cNL() {
            return this.jVM;
        }

        public String cNM() {
            return this.jVN;
        }

        public String cNN() {
            return this.jVO;
        }
    }
}
