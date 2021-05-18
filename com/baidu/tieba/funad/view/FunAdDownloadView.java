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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.FunAdSdkSwitch;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.EBusinessProtocolView;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.fun.ad.sdk.ChannelNativeAds_6;
import com.fun.ad.sdk.FunNativeAd;
import com.kwad.sdk.api.KsNativeAd;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import d.a.c.e.m.g;
/* loaded from: classes4.dex */
public class FunAdDownloadView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public final Context f16055e;

    /* renamed from: f  reason: collision with root package name */
    public FunAdButton f16056f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16057g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f16058h;

    /* renamed from: i  reason: collision with root package name */
    public RankStarView f16059i;
    public TextView j;
    public TextView k;
    public TextView l;
    public ViewGroup m;
    public TextView n;
    public TextView o;
    public TextView p;
    public EBusinessProtocolView q;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Activity f16060e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f16061f;

        public a(Activity activity, String str) {
            this.f16060e = activity;
            this.f16061f = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.i(FunAdDownloadView.this.q, this.f16060e);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_AUTHORITY_CLICK).param("obj_source", 6).param("obj_type", this.f16061f));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f16063e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f16064f;

        public b(c cVar, String str) {
            this.f16063e = cVar;
            this.f16064f = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.j0.l.a.e(FunAdDownloadView.this.f16055e, this.f16063e.d());
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_PRIVACY_CLICK).param("obj_source", 6).param("obj_type", this.f16064f));
        }
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final CharSequence f16066a;

        /* renamed from: b  reason: collision with root package name */
        public final float f16067b;

        /* renamed from: c  reason: collision with root package name */
        public final String f16068c;

        /* renamed from: d  reason: collision with root package name */
        public final String f16069d;

        /* renamed from: e  reason: collision with root package name */
        public final String f16070e;

        /* renamed from: f  reason: collision with root package name */
        public final String f16071f;

        /* renamed from: g  reason: collision with root package name */
        public final String f16072g;

        public c(@NonNull FunNativeAd funNativeAd) {
            NativeUnifiedADData nativeUnifiedADData;
            KsNativeAd ksNativeAd;
            TTNativeAd tTNativeAd;
            ChannelNativeAds_6 channelNativeAds_6 = funNativeAd.getChannelNativeAds_6();
            if (channelNativeAds_6 != null && (tTNativeAd = channelNativeAds_6.csjNative) != null) {
                this.f16067b = tTNativeAd.getAppScore();
                this.f16068c = null;
                this.f16069d = null;
                this.f16070e = tTNativeAd.getSource();
                this.f16072g = null;
                this.f16071f = null;
                this.f16066a = tTNativeAd.getTitle();
            } else if (channelNativeAds_6 != null && (ksNativeAd = channelNativeAds_6.ksNative) != null) {
                this.f16066a = ksNativeAd.getAppName();
                this.f16067b = ksNativeAd.getAppScore() / 2.0f;
                this.f16068c = ksNativeAd.getAppDownloadCountDes();
                this.f16069d = TbadkCoreApplication.getInst().getString(R.string.fun_ad_item_version) + ksNativeAd.getAppVersion();
                this.f16070e = ksNativeAd.getCorporationName();
                this.f16072g = ksNativeAd.getPermissionInfo();
                this.f16071f = ksNativeAd.getAppPrivacyUrl();
            } else if (channelNativeAds_6 != null && (nativeUnifiedADData = channelNativeAds_6.gdtNative) != null) {
                this.f16066a = nativeUnifiedADData.getTitle();
                this.f16067b = nativeUnifiedADData.getAppScore() / 2.0f;
                this.f16068c = TbadkCoreApplication.getInst().getString(R.string.fun_ad_item_download_count, new Object[]{StringHelper.numberUniformFormat(nativeUnifiedADData.getDownloadCount())});
                this.f16069d = null;
                this.f16070e = null;
                this.f16072g = null;
                this.f16071f = null;
            } else {
                this.f16067b = 0.0f;
                this.f16068c = null;
                this.f16069d = null;
                this.f16070e = null;
                this.f16072g = null;
                this.f16071f = null;
                this.f16066a = "";
            }
        }

        public String a() {
            return this.f16072g;
        }

        public String b() {
            return this.f16070e;
        }

        public String c() {
            return this.f16068c;
        }

        public String d() {
            return this.f16071f;
        }

        public String e() {
            return this.f16069d;
        }

        public float f() {
            return this.f16067b;
        }

        public CharSequence g() {
            return this.f16066a;
        }
    }

    public FunAdDownloadView(Context context) {
        this(context, null, 0);
    }

    public final void c() {
        LayoutInflater.from(this.f16055e).inflate(R.layout.fun_ad_download_info, (ViewGroup) this, true);
        this.f16056f = (FunAdButton) findViewById(R.id.fun_ad_download_button);
        this.f16057g = (TextView) findViewById(R.id.fun_ad_download_title);
        this.f16058h = (LinearLayout) findViewById(R.id.fun_ad_download_score_layout);
        this.f16059i = (RankStarView) findViewById(R.id.fun_ad_download_star);
        this.j = (TextView) findViewById(R.id.fun_ad_download_score);
        this.k = (TextView) findViewById(R.id.fun_ad_download_count);
        this.l = (TextView) findViewById(R.id.fun_ad_download_version);
        this.m = (ViewGroup) findViewById(R.id.fun_download_line_2);
        this.n = (TextView) findViewById(R.id.fun_ad_download_company);
        this.o = (TextView) findViewById(R.id.fun_ad_download_privacy);
        this.p = (TextView) findViewById(R.id.fun_ad_download_authority);
        this.q = new EBusinessProtocolView(this.f16055e, EBusinessProtocolView.WindowType.TIP);
    }

    public void d(int i2) {
        d.a.j0.r.u.c d2 = d.a.j0.r.u.c.d(this);
        d2.k(R.string.J_X05);
        d2.f(R.color.CAM_X0206);
        d.a.j0.r.u.c.d(this.f16057g).q(R.color.CAM_X0107);
        d.a.j0.r.u.c.d(this.l).q(R.color.CAM_X0109);
        d.a.j0.r.u.c.d(this.j).q(R.color.CAM_X0109);
        d.a.j0.r.u.c.d(this.k).q(R.color.CAM_X0109);
        d.a.j0.r.u.c.d(this.n).q(R.color.CAM_X0109);
        d.a.j0.r.u.c.d(this.o).q(R.color.CAM_X0109);
        d.a.j0.r.u.c.d(this.p).q(R.color.CAM_X0109);
        this.f16056f.h();
        this.f16059i.e(i2);
    }

    public FunAdButton getDownloadButton() {
        return this.f16056f;
    }

    public void setViewData(FunNativeAd funNativeAd, Activity activity, String str) {
        if (d.a.k0.s0.b.j(funNativeAd) && FunAdSdkSwitch.isOn()) {
            setVisibility(0);
            c cVar = new c(funNativeAd);
            this.f16057g.setText(cVar.g());
            float f2 = cVar.f();
            if (f2 > 2.5d) {
                this.f16058h.setVisibility(0);
                this.k.setVisibility(8);
                this.j.setText(String.valueOf(f2));
                this.f16059i.setStarCount(f2);
            } else if (!TextUtils.isEmpty(cVar.c())) {
                this.f16058h.setVisibility(8);
                this.k.setVisibility(0);
                this.k.setText(cVar.c());
            } else {
                this.f16058h.setVisibility(8);
                this.k.setVisibility(8);
            }
            if (!TextUtils.isEmpty(cVar.e())) {
                this.l.setText(cVar.e());
                this.l.setVisibility(0);
            } else {
                this.l.setVisibility(8);
            }
            if (!TextUtils.isEmpty(cVar.b())) {
                this.n.setText(cVar.b());
                this.n.setVisibility(0);
                this.n.requestLayout();
            } else {
                this.n.setVisibility(8);
            }
            if (!TextUtils.isEmpty(cVar.a())) {
                this.p.setVisibility(0);
                this.q.k(cVar.a());
                this.q.o(this.f16055e.getString(R.string.fun_ad_privacy_dialog_title));
                this.p.setOnClickListener(new a(activity, str));
            } else {
                this.p.setVisibility(8);
            }
            if (!TextUtils.isEmpty(cVar.d())) {
                this.o.setVisibility(0);
                this.o.setOnClickListener(new b(cVar, str));
            } else {
                this.o.setVisibility(8);
            }
            if ((this.n.getVisibility() & this.p.getVisibility() & this.o.getVisibility()) != 8) {
                this.m.setVisibility(0);
                return;
            } else {
                this.m.setVisibility(8);
                return;
            }
        }
        setVisibility(8);
    }

    public FunAdDownloadView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FunAdDownloadView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f16055e = context;
        c();
    }
}
