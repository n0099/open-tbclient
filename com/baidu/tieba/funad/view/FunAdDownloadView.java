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
import com.fun.ad.sdk.ChannelNativeAds_5;
import com.fun.ad.sdk.FunNativeAd;
import com.kwad.sdk.api.KsNativeAd;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import d.b.b.e.m.g;
/* loaded from: classes4.dex */
public class FunAdDownloadView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    public final Context f16825e;

    /* renamed from: f  reason: collision with root package name */
    public FunAdButton f16826f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16827g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f16828h;
    public RankStarView i;
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
        public final /* synthetic */ Activity f16829e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f16830f;

        public a(Activity activity, String str) {
            this.f16829e = activity;
            this.f16830f = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.i(FunAdDownloadView.this.q, this.f16829e);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_AUTHORITY_CLICK).param("obj_source", 6).param("obj_type", this.f16830f));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f16832e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f16833f;

        public b(c cVar, String str) {
            this.f16832e = cVar;
            this.f16833f = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.h0.l.a.e(FunAdDownloadView.this.f16825e, this.f16832e.d());
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_PRIVACY_CLICK).param("obj_source", 6).param("obj_type", this.f16833f));
        }
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final CharSequence f16835a;

        /* renamed from: b  reason: collision with root package name */
        public final float f16836b;

        /* renamed from: c  reason: collision with root package name */
        public final String f16837c;

        /* renamed from: d  reason: collision with root package name */
        public final String f16838d;

        /* renamed from: e  reason: collision with root package name */
        public final String f16839e;

        /* renamed from: f  reason: collision with root package name */
        public final String f16840f;

        /* renamed from: g  reason: collision with root package name */
        public final String f16841g;

        public c(@NonNull FunNativeAd funNativeAd) {
            NativeUnifiedADData nativeUnifiedADData;
            KsNativeAd ksNativeAd;
            TTNativeAd tTNativeAd;
            ChannelNativeAds_5 channelNativeAds_5 = funNativeAd.getChannelNativeAds_5();
            if (channelNativeAds_5 != null && (tTNativeAd = channelNativeAds_5.csjNative) != null) {
                this.f16836b = tTNativeAd.getAppScore();
                this.f16837c = null;
                this.f16838d = null;
                this.f16839e = tTNativeAd.getSource();
                this.f16841g = null;
                this.f16840f = null;
                this.f16835a = tTNativeAd.getTitle();
            } else if (channelNativeAds_5 != null && (ksNativeAd = channelNativeAds_5.ksNative) != null) {
                this.f16835a = ksNativeAd.getAppName();
                this.f16836b = ksNativeAd.getAppScore() / 2.0f;
                this.f16837c = ksNativeAd.getAppDownloadCountDes();
                this.f16838d = TbadkCoreApplication.getInst().getString(R.string.fun_ad_item_version) + ksNativeAd.getAppVersion();
                this.f16839e = ksNativeAd.getCorporationName();
                this.f16841g = ksNativeAd.getPermissionInfo();
                this.f16840f = ksNativeAd.getAppPrivacyUrl();
            } else if (channelNativeAds_5 != null && (nativeUnifiedADData = channelNativeAds_5.gdtNative) != null) {
                this.f16835a = nativeUnifiedADData.getTitle();
                this.f16836b = nativeUnifiedADData.getAppScore() / 2.0f;
                this.f16837c = TbadkCoreApplication.getInst().getString(R.string.fun_ad_item_download_count, new Object[]{StringHelper.numberUniformFormat(nativeUnifiedADData.getDownloadCount())});
                this.f16838d = null;
                this.f16839e = null;
                this.f16841g = null;
                this.f16840f = null;
            } else {
                this.f16836b = 0.0f;
                this.f16837c = null;
                this.f16838d = null;
                this.f16839e = null;
                this.f16841g = null;
                this.f16840f = null;
                this.f16835a = "";
            }
        }

        public String a() {
            return this.f16841g;
        }

        public String b() {
            return this.f16839e;
        }

        public String c() {
            return this.f16837c;
        }

        public String d() {
            return this.f16840f;
        }

        public String e() {
            return this.f16838d;
        }

        public float f() {
            return this.f16836b;
        }

        public CharSequence g() {
            return this.f16835a;
        }
    }

    public FunAdDownloadView(Context context) {
        this(context, null, 0);
    }

    public final void c() {
        LayoutInflater.from(this.f16825e).inflate(R.layout.fun_ad_download_info, (ViewGroup) this, true);
        this.f16826f = (FunAdButton) findViewById(R.id.fun_ad_download_button);
        this.f16827g = (TextView) findViewById(R.id.fun_ad_download_title);
        this.f16828h = (LinearLayout) findViewById(R.id.fun_ad_download_score_layout);
        this.i = (RankStarView) findViewById(R.id.fun_ad_download_star);
        this.j = (TextView) findViewById(R.id.fun_ad_download_score);
        this.k = (TextView) findViewById(R.id.fun_ad_download_count);
        this.l = (TextView) findViewById(R.id.fun_ad_download_version);
        this.m = (ViewGroup) findViewById(R.id.fun_download_line_2);
        this.n = (TextView) findViewById(R.id.fun_ad_download_company);
        this.o = (TextView) findViewById(R.id.fun_ad_download_privacy);
        this.p = (TextView) findViewById(R.id.fun_ad_download_authority);
        this.q = new EBusinessProtocolView(this.f16825e, EBusinessProtocolView.WindowType.TIP);
    }

    public void d(int i) {
        d.b.h0.r.u.c a2 = d.b.h0.r.u.c.a(this);
        a2.h(R.string.J_X05);
        a2.c(R.color.CAM_X0206);
        d.b.h0.r.u.c.a(this.f16827g).n(R.color.CAM_X0107);
        d.b.h0.r.u.c.a(this.l).n(R.color.CAM_X0109);
        d.b.h0.r.u.c.a(this.j).n(R.color.CAM_X0109);
        d.b.h0.r.u.c.a(this.k).n(R.color.CAM_X0109);
        d.b.h0.r.u.c.a(this.n).n(R.color.CAM_X0109);
        d.b.h0.r.u.c.a(this.o).n(R.color.CAM_X0109);
        d.b.h0.r.u.c.a(this.p).n(R.color.CAM_X0109);
        this.f16826f.h();
        this.i.e(i);
    }

    public FunAdButton getDownloadButton() {
        return this.f16826f;
    }

    public void setViewData(FunNativeAd funNativeAd, Activity activity, String str) {
        if (d.b.i0.r0.c.c(funNativeAd) && FunAdSdkSwitch.isOn()) {
            setVisibility(0);
            c cVar = new c(funNativeAd);
            this.f16827g.setText(cVar.g());
            float f2 = cVar.f();
            if (f2 > 2.5d) {
                this.f16828h.setVisibility(0);
                this.k.setVisibility(8);
                this.j.setText(String.valueOf(f2));
                this.i.setStarCount(f2);
            } else if (!TextUtils.isEmpty(cVar.c())) {
                this.f16828h.setVisibility(8);
                this.k.setVisibility(0);
                this.k.setText(cVar.c());
            } else {
                this.f16828h.setVisibility(8);
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
                this.q.o(this.f16825e.getString(R.string.fun_ad_privacy_dialog_title));
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

    public FunAdDownloadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f16825e = context;
        c();
    }
}
