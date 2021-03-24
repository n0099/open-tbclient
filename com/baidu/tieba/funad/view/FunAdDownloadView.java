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
    public final Context f16824e;

    /* renamed from: f  reason: collision with root package name */
    public FunAdButton f16825f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16826g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f16827h;
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
        public final /* synthetic */ Activity f16828e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f16829f;

        public a(Activity activity, String str) {
            this.f16828e = activity;
            this.f16829f = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.i(FunAdDownloadView.this.q, this.f16828e);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_AUTHORITY_CLICK).param("obj_source", 6).param("obj_type", this.f16829f));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f16831e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f16832f;

        public b(c cVar, String str) {
            this.f16831e = cVar;
            this.f16832f = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.h0.l.a.e(FunAdDownloadView.this.f16824e, this.f16831e.d());
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_PRIVACY_CLICK).param("obj_source", 6).param("obj_type", this.f16832f));
        }
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final CharSequence f16834a;

        /* renamed from: b  reason: collision with root package name */
        public final float f16835b;

        /* renamed from: c  reason: collision with root package name */
        public final String f16836c;

        /* renamed from: d  reason: collision with root package name */
        public final String f16837d;

        /* renamed from: e  reason: collision with root package name */
        public final String f16838e;

        /* renamed from: f  reason: collision with root package name */
        public final String f16839f;

        /* renamed from: g  reason: collision with root package name */
        public final String f16840g;

        public c(@NonNull FunNativeAd funNativeAd) {
            NativeUnifiedADData nativeUnifiedADData;
            KsNativeAd ksNativeAd;
            TTNativeAd tTNativeAd;
            ChannelNativeAds_5 channelNativeAds_5 = funNativeAd.getChannelNativeAds_5();
            if (channelNativeAds_5 != null && (tTNativeAd = channelNativeAds_5.csjNative) != null) {
                this.f16835b = tTNativeAd.getAppScore();
                this.f16836c = null;
                this.f16837d = null;
                this.f16838e = tTNativeAd.getSource();
                this.f16840g = null;
                this.f16839f = null;
                this.f16834a = tTNativeAd.getTitle();
            } else if (channelNativeAds_5 != null && (ksNativeAd = channelNativeAds_5.ksNative) != null) {
                this.f16834a = ksNativeAd.getAppName();
                this.f16835b = ksNativeAd.getAppScore() / 2.0f;
                this.f16836c = ksNativeAd.getAppDownloadCountDes();
                this.f16837d = TbadkCoreApplication.getInst().getString(R.string.fun_ad_item_version) + ksNativeAd.getAppVersion();
                this.f16838e = ksNativeAd.getCorporationName();
                this.f16840g = ksNativeAd.getPermissionInfo();
                this.f16839f = ksNativeAd.getAppPrivacyUrl();
            } else if (channelNativeAds_5 != null && (nativeUnifiedADData = channelNativeAds_5.gdtNative) != null) {
                this.f16834a = nativeUnifiedADData.getTitle();
                this.f16835b = nativeUnifiedADData.getAppScore() / 2.0f;
                this.f16836c = TbadkCoreApplication.getInst().getString(R.string.fun_ad_item_download_count, new Object[]{StringHelper.numberUniformFormat(nativeUnifiedADData.getDownloadCount())});
                this.f16837d = null;
                this.f16838e = null;
                this.f16840g = null;
                this.f16839f = null;
            } else {
                this.f16835b = 0.0f;
                this.f16836c = null;
                this.f16837d = null;
                this.f16838e = null;
                this.f16840g = null;
                this.f16839f = null;
                this.f16834a = "";
            }
        }

        public String a() {
            return this.f16840g;
        }

        public String b() {
            return this.f16838e;
        }

        public String c() {
            return this.f16836c;
        }

        public String d() {
            return this.f16839f;
        }

        public String e() {
            return this.f16837d;
        }

        public float f() {
            return this.f16835b;
        }

        public CharSequence g() {
            return this.f16834a;
        }
    }

    public FunAdDownloadView(Context context) {
        this(context, null, 0);
    }

    public final void c() {
        LayoutInflater.from(this.f16824e).inflate(R.layout.fun_ad_download_info, (ViewGroup) this, true);
        this.f16825f = (FunAdButton) findViewById(R.id.fun_ad_download_button);
        this.f16826g = (TextView) findViewById(R.id.fun_ad_download_title);
        this.f16827h = (LinearLayout) findViewById(R.id.fun_ad_download_score_layout);
        this.i = (RankStarView) findViewById(R.id.fun_ad_download_star);
        this.j = (TextView) findViewById(R.id.fun_ad_download_score);
        this.k = (TextView) findViewById(R.id.fun_ad_download_count);
        this.l = (TextView) findViewById(R.id.fun_ad_download_version);
        this.m = (ViewGroup) findViewById(R.id.fun_download_line_2);
        this.n = (TextView) findViewById(R.id.fun_ad_download_company);
        this.o = (TextView) findViewById(R.id.fun_ad_download_privacy);
        this.p = (TextView) findViewById(R.id.fun_ad_download_authority);
        this.q = new EBusinessProtocolView(this.f16824e, EBusinessProtocolView.WindowType.TIP);
    }

    public void d(int i) {
        d.b.h0.r.u.c a2 = d.b.h0.r.u.c.a(this);
        a2.h(R.string.J_X05);
        a2.c(R.color.CAM_X0206);
        d.b.h0.r.u.c.a(this.f16826g).n(R.color.CAM_X0107);
        d.b.h0.r.u.c.a(this.l).n(R.color.CAM_X0109);
        d.b.h0.r.u.c.a(this.j).n(R.color.CAM_X0109);
        d.b.h0.r.u.c.a(this.k).n(R.color.CAM_X0109);
        d.b.h0.r.u.c.a(this.n).n(R.color.CAM_X0109);
        d.b.h0.r.u.c.a(this.o).n(R.color.CAM_X0109);
        d.b.h0.r.u.c.a(this.p).n(R.color.CAM_X0109);
        this.f16825f.h();
        this.i.e(i);
    }

    public FunAdButton getDownloadButton() {
        return this.f16825f;
    }

    public void setViewData(FunNativeAd funNativeAd, Activity activity, String str) {
        if (d.b.i0.r0.c.c(funNativeAd) && FunAdSdkSwitch.isOn()) {
            setVisibility(0);
            c cVar = new c(funNativeAd);
            this.f16826g.setText(cVar.g());
            float f2 = cVar.f();
            if (f2 > 2.5d) {
                this.f16827h.setVisibility(0);
                this.k.setVisibility(8);
                this.j.setText(String.valueOf(f2));
                this.i.setStarCount(f2);
            } else if (!TextUtils.isEmpty(cVar.c())) {
                this.f16827h.setVisibility(8);
                this.k.setVisibility(0);
                this.k.setText(cVar.c());
            } else {
                this.f16827h.setVisibility(8);
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
                this.q.o(this.f16824e.getString(R.string.fun_ad_privacy_dialog_title));
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
        this.f16824e = context;
        c();
    }
}
