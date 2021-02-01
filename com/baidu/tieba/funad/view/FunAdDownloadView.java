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
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.fun.ad.sdk.FunNativeAd;
import com.kwad.sdk.api.KsNativeAd;
import com.qq.e.ads.nativ.NativeUnifiedADData;
/* loaded from: classes5.dex */
public class FunAdDownloadView extends RelativeLayout {
    private TextView jTF;
    private LinearLayout jTG;
    private RankStarView jTH;
    private TextView jTI;
    private TextView jTJ;
    private TextView jTK;
    private ViewGroup jTL;
    private TextView jTM;
    private TextView jTN;
    private TextView jTO;
    private EBusinessProtocolView jTP;
    private FunAdButton jTl;
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
        this.jTl = (FunAdButton) findViewById(R.id.fun_ad_download_button);
        this.jTF = (TextView) findViewById(R.id.fun_ad_download_title);
        this.jTG = (LinearLayout) findViewById(R.id.fun_ad_download_score_layout);
        this.jTH = (RankStarView) findViewById(R.id.fun_ad_download_star);
        this.jTI = (TextView) findViewById(R.id.fun_ad_download_score);
        this.jTJ = (TextView) findViewById(R.id.fun_ad_download_count);
        this.jTK = (TextView) findViewById(R.id.fun_ad_download_version);
        this.jTL = (ViewGroup) findViewById(R.id.fun_download_line_2);
        this.jTM = (TextView) findViewById(R.id.fun_ad_download_company);
        this.jTN = (TextView) findViewById(R.id.fun_ad_download_privacy);
        this.jTO = (TextView) findViewById(R.id.fun_ad_download_authority);
        this.jTP = new EBusinessProtocolView(this.mContext, EBusinessProtocolView.WindowType.TIP);
    }

    public void Bg(int i) {
        c.br(this).og(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
        c.br(this.jTF).nY(R.color.CAM_X0107);
        c.br(this.jTK).nY(R.color.CAM_X0109);
        c.br(this.jTI).nY(R.color.CAM_X0109);
        c.br(this.jTJ).nY(R.color.CAM_X0109);
        c.br(this.jTM).nY(R.color.CAM_X0109);
        c.br(this.jTN).nY(R.color.CAM_X0109);
        c.br(this.jTO).nY(R.color.CAM_X0109);
        c.br(this.jTl).og(R.string.J_X01).nY(R.color.CAM_X0302).setBackGroundColor(R.color.CAM_X0905);
        this.jTH.onChangeSkinType(i);
    }

    public FunAdButton getDownloadButton() {
        return this.jTl;
    }

    public void setViewData(FunNativeAd funNativeAd, final Activity activity, CharSequence charSequence, final String str) {
        if (funNativeAd == null || !com.baidu.tieba.funad.c.b(funNativeAd) || !FunAdSdkSwitch.isOn()) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        final a aVar = new a(funNativeAd, charSequence);
        this.jTF.setText(aVar.cNu());
        float cNv = aVar.cNv();
        if (cNv > 2.5d) {
            this.jTG.setVisibility(0);
            this.jTJ.setVisibility(8);
            this.jTI.setText(String.valueOf(cNv));
            this.jTH.setStarCount(cNv);
        } else if (!TextUtils.isEmpty(aVar.cNw())) {
            this.jTG.setVisibility(8);
            this.jTJ.setVisibility(0);
            this.jTJ.setText(aVar.cNw());
        } else {
            this.jTG.setVisibility(8);
            this.jTJ.setVisibility(8);
        }
        if (!TextUtils.isEmpty(aVar.cNx())) {
            this.jTK.setText(aVar.cNx());
            this.jTK.setVisibility(0);
        } else {
            this.jTK.setVisibility(8);
        }
        if (!TextUtils.isEmpty(aVar.cNy())) {
            this.jTM.setText(aVar.cNy());
            this.jTM.setVisibility(0);
        } else {
            this.jTM.setVisibility(8);
        }
        if (!TextUtils.isEmpty(aVar.cNA())) {
            this.jTO.setVisibility(0);
            this.jTP.v(aVar.cNA());
            this.jTP.setTitle(this.mContext.getString(R.string.fun_ad_privacy_dialog_title));
            this.jTO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.funad.view.FunAdDownloadView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    g.showDialog(FunAdDownloadView.this.jTP, activity);
                    TiebaStatic.log(new ar("c14090").ap("obj_source", 6).dR("obj_type", str));
                }
            });
        } else {
            this.jTO.setVisibility(8);
        }
        if (!TextUtils.isEmpty(aVar.cNz())) {
            this.jTN.setVisibility(0);
            this.jTN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.funad.view.FunAdDownloadView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.ay(FunAdDownloadView.this.mContext, aVar.cNz());
                    TiebaStatic.log(new ar("c14089").ap("obj_source", 6).dR("obj_type", str));
                }
            });
        } else {
            this.jTN.setVisibility(8);
        }
        if ((this.jTM.getVisibility() & this.jTO.getVisibility() & this.jTN.getVisibility()) != 8) {
            this.jTL.setVisibility(0);
        } else {
            this.jTL.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a {
        private final CharSequence jTS;
        private final float jTT;
        private final String jTU;
        private final String jTV;
        private final String jTW;
        private final String jTX;
        private final String jTY;

        public a(@NonNull FunNativeAd funNativeAd, String str) {
            this.jTS = str == null ? "" : str;
            if (funNativeAd.mTTFeedAd != null) {
                TTFeedAd tTFeedAd = funNativeAd.mTTFeedAd;
                this.jTT = tTFeedAd.getAppScore();
                this.jTU = null;
                this.jTV = null;
                this.jTW = tTFeedAd.getSource();
                this.jTY = null;
                this.jTX = null;
            } else if (funNativeAd.mKsNativeAd != null) {
                KsNativeAd ksNativeAd = funNativeAd.mKsNativeAd;
                this.jTT = ksNativeAd.getAppScore() / 2.0f;
                this.jTU = ksNativeAd.getAppDownloadCountDes();
                this.jTV = TbadkCoreApplication.getInst().getString(R.string.fun_ad_item_version) + ksNativeAd.getAppVersion();
                this.jTW = ksNativeAd.getCorporationName();
                this.jTY = ksNativeAd.getPermissionInfo();
                this.jTX = ksNativeAd.getAppPrivacyUrl();
            } else if (funNativeAd.mNativeUnifiedADData != null) {
                NativeUnifiedADData nativeUnifiedADData = funNativeAd.mNativeUnifiedADData;
                this.jTT = nativeUnifiedADData.getAppScore() / 2.0f;
                this.jTU = TbadkCoreApplication.getInst().getString(R.string.fun_ad_item_download_count, new Object[]{au.numberUniformFormat(nativeUnifiedADData.getDownloadCount())});
                this.jTV = null;
                this.jTW = null;
                this.jTY = null;
                this.jTX = null;
            } else {
                this.jTT = 0.0f;
                this.jTU = null;
                this.jTV = null;
                this.jTW = null;
                this.jTY = null;
                this.jTX = null;
            }
        }

        public CharSequence cNu() {
            return this.jTS;
        }

        public float cNv() {
            return this.jTT;
        }

        public String cNw() {
            return this.jTU;
        }

        public String cNx() {
            return this.jTV;
        }

        public String cNy() {
            return this.jTW;
        }

        public String cNz() {
            return this.jTX;
        }

        public String cNA() {
            return this.jTY;
        }
    }
}
