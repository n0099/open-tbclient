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
    private TextView jTT;
    private LinearLayout jTU;
    private RankStarView jTV;
    private TextView jTW;
    private TextView jTX;
    private TextView jTY;
    private ViewGroup jTZ;
    private FunAdButton jTz;
    private TextView jUa;
    private TextView jUb;
    private TextView jUc;
    private EBusinessProtocolView jUd;
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
        this.jTz = (FunAdButton) findViewById(R.id.fun_ad_download_button);
        this.jTT = (TextView) findViewById(R.id.fun_ad_download_title);
        this.jTU = (LinearLayout) findViewById(R.id.fun_ad_download_score_layout);
        this.jTV = (RankStarView) findViewById(R.id.fun_ad_download_star);
        this.jTW = (TextView) findViewById(R.id.fun_ad_download_score);
        this.jTX = (TextView) findViewById(R.id.fun_ad_download_count);
        this.jTY = (TextView) findViewById(R.id.fun_ad_download_version);
        this.jTZ = (ViewGroup) findViewById(R.id.fun_download_line_2);
        this.jUa = (TextView) findViewById(R.id.fun_ad_download_company);
        this.jUb = (TextView) findViewById(R.id.fun_ad_download_privacy);
        this.jUc = (TextView) findViewById(R.id.fun_ad_download_authority);
        this.jUd = new EBusinessProtocolView(this.mContext, EBusinessProtocolView.WindowType.TIP);
    }

    public void Bg(int i) {
        c.br(this).og(R.string.J_X05).setBackGroundColor(R.color.CAM_X0206);
        c.br(this.jTT).nY(R.color.CAM_X0107);
        c.br(this.jTY).nY(R.color.CAM_X0109);
        c.br(this.jTW).nY(R.color.CAM_X0109);
        c.br(this.jTX).nY(R.color.CAM_X0109);
        c.br(this.jUa).nY(R.color.CAM_X0109);
        c.br(this.jUb).nY(R.color.CAM_X0109);
        c.br(this.jUc).nY(R.color.CAM_X0109);
        c.br(this.jTz).og(R.string.J_X01).nY(R.color.CAM_X0302).setBackGroundColor(R.color.CAM_X0905);
        this.jTV.onChangeSkinType(i);
    }

    public FunAdButton getDownloadButton() {
        return this.jTz;
    }

    public void setViewData(FunNativeAd funNativeAd, final Activity activity, CharSequence charSequence, final String str) {
        if (funNativeAd == null || !com.baidu.tieba.funad.c.b(funNativeAd) || !FunAdSdkSwitch.isOn()) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        final a aVar = new a(funNativeAd, charSequence);
        this.jTT.setText(aVar.cNB());
        float cNC = aVar.cNC();
        if (cNC > 2.5d) {
            this.jTU.setVisibility(0);
            this.jTX.setVisibility(8);
            this.jTW.setText(String.valueOf(cNC));
            this.jTV.setStarCount(cNC);
        } else if (!TextUtils.isEmpty(aVar.cND())) {
            this.jTU.setVisibility(8);
            this.jTX.setVisibility(0);
            this.jTX.setText(aVar.cND());
        } else {
            this.jTU.setVisibility(8);
            this.jTX.setVisibility(8);
        }
        if (!TextUtils.isEmpty(aVar.cNE())) {
            this.jTY.setText(aVar.cNE());
            this.jTY.setVisibility(0);
        } else {
            this.jTY.setVisibility(8);
        }
        if (!TextUtils.isEmpty(aVar.cNF())) {
            this.jUa.setText(aVar.cNF());
            this.jUa.setVisibility(0);
        } else {
            this.jUa.setVisibility(8);
        }
        if (!TextUtils.isEmpty(aVar.cNH())) {
            this.jUc.setVisibility(0);
            this.jUd.v(aVar.cNH());
            this.jUd.setTitle(this.mContext.getString(R.string.fun_ad_privacy_dialog_title));
            this.jUc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.funad.view.FunAdDownloadView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    g.showDialog(FunAdDownloadView.this.jUd, activity);
                    TiebaStatic.log(new ar("c14090").ap("obj_source", 6).dR("obj_type", str));
                }
            });
        } else {
            this.jUc.setVisibility(8);
        }
        if (!TextUtils.isEmpty(aVar.cNG())) {
            this.jUb.setVisibility(0);
            this.jUb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.funad.view.FunAdDownloadView.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    com.baidu.tbadk.browser.a.ay(FunAdDownloadView.this.mContext, aVar.cNG());
                    TiebaStatic.log(new ar("c14089").ap("obj_source", 6).dR("obj_type", str));
                }
            });
        } else {
            this.jUb.setVisibility(8);
        }
        if ((this.jUa.getVisibility() & this.jUc.getVisibility() & this.jUb.getVisibility()) != 8) {
            this.jTZ.setVisibility(0);
        } else {
            this.jTZ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class a {
        private final CharSequence jUg;
        private final float jUh;
        private final String jUi;
        private final String jUj;
        private final String jUk;
        private final String jUl;
        private final String jUm;

        public a(@NonNull FunNativeAd funNativeAd, String str) {
            this.jUg = str == null ? "" : str;
            if (funNativeAd.mTTFeedAd != null) {
                TTFeedAd tTFeedAd = funNativeAd.mTTFeedAd;
                this.jUh = tTFeedAd.getAppScore();
                this.jUi = null;
                this.jUj = null;
                this.jUk = tTFeedAd.getSource();
                this.jUm = null;
                this.jUl = null;
            } else if (funNativeAd.mKsNativeAd != null) {
                KsNativeAd ksNativeAd = funNativeAd.mKsNativeAd;
                this.jUh = ksNativeAd.getAppScore() / 2.0f;
                this.jUi = ksNativeAd.getAppDownloadCountDes();
                this.jUj = TbadkCoreApplication.getInst().getString(R.string.fun_ad_item_version) + ksNativeAd.getAppVersion();
                this.jUk = ksNativeAd.getCorporationName();
                this.jUm = ksNativeAd.getPermissionInfo();
                this.jUl = ksNativeAd.getAppPrivacyUrl();
            } else if (funNativeAd.mNativeUnifiedADData != null) {
                NativeUnifiedADData nativeUnifiedADData = funNativeAd.mNativeUnifiedADData;
                this.jUh = nativeUnifiedADData.getAppScore() / 2.0f;
                this.jUi = TbadkCoreApplication.getInst().getString(R.string.fun_ad_item_download_count, new Object[]{au.numberUniformFormat(nativeUnifiedADData.getDownloadCount())});
                this.jUj = null;
                this.jUk = null;
                this.jUm = null;
                this.jUl = null;
            } else {
                this.jUh = 0.0f;
                this.jUi = null;
                this.jUj = null;
                this.jUk = null;
                this.jUm = null;
                this.jUl = null;
            }
        }

        public CharSequence cNB() {
            return this.jUg;
        }

        public float cNC() {
            return this.jUh;
        }

        public String cND() {
            return this.jUi;
        }

        public String cNE() {
            return this.jUj;
        }

        public String cNF() {
            return this.jUk;
        }

        public String cNG() {
            return this.jUl;
        }

        public String cNH() {
            return this.jUm;
        }
    }
}
