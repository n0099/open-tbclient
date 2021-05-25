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
    public final Context f15958e;

    /* renamed from: f  reason: collision with root package name */
    public FunAdButton f15959f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15960g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f15961h;

    /* renamed from: i  reason: collision with root package name */
    public RankStarView f15962i;
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
        public final /* synthetic */ Activity f15963e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f15964f;

        public a(Activity activity, String str) {
            this.f15963e = activity;
            this.f15964f = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.i(FunAdDownloadView.this.q, this.f15963e);
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_AUTHORITY_CLICK).param("obj_source", 6).param("obj_type", this.f15964f));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f15966e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f15967f;

        public b(c cVar, String str) {
            this.f15966e = cVar;
            this.f15967f = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.a.m0.l.a.e(FunAdDownloadView.this.f15958e, this.f15966e.d());
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_PRIVACY_CLICK).param("obj_source", 6).param("obj_type", this.f15967f));
        }
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final CharSequence f15969a;

        /* renamed from: b  reason: collision with root package name */
        public final float f15970b;

        /* renamed from: c  reason: collision with root package name */
        public final String f15971c;

        /* renamed from: d  reason: collision with root package name */
        public final String f15972d;

        /* renamed from: e  reason: collision with root package name */
        public final String f15973e;

        /* renamed from: f  reason: collision with root package name */
        public final String f15974f;

        /* renamed from: g  reason: collision with root package name */
        public final String f15975g;

        public c(@NonNull FunNativeAd funNativeAd) {
            NativeUnifiedADData nativeUnifiedADData;
            KsNativeAd ksNativeAd;
            TTNativeAd tTNativeAd;
            ChannelNativeAds_6 channelNativeAds_6 = funNativeAd.getChannelNativeAds_6();
            if (channelNativeAds_6 != null && (tTNativeAd = channelNativeAds_6.csjNative) != null) {
                this.f15970b = tTNativeAd.getAppScore();
                this.f15971c = null;
                this.f15972d = null;
                this.f15973e = tTNativeAd.getSource();
                this.f15975g = null;
                this.f15974f = null;
                this.f15969a = tTNativeAd.getTitle();
            } else if (channelNativeAds_6 != null && (ksNativeAd = channelNativeAds_6.ksNative) != null) {
                this.f15969a = ksNativeAd.getAppName();
                this.f15970b = ksNativeAd.getAppScore() / 2.0f;
                this.f15971c = ksNativeAd.getAppDownloadCountDes();
                this.f15972d = TbadkCoreApplication.getInst().getString(R.string.fun_ad_item_version) + ksNativeAd.getAppVersion();
                this.f15973e = ksNativeAd.getCorporationName();
                this.f15975g = ksNativeAd.getPermissionInfo();
                this.f15974f = ksNativeAd.getAppPrivacyUrl();
            } else if (channelNativeAds_6 != null && (nativeUnifiedADData = channelNativeAds_6.gdtNative) != null) {
                this.f15969a = nativeUnifiedADData.getTitle();
                this.f15970b = nativeUnifiedADData.getAppScore() / 2.0f;
                this.f15971c = TbadkCoreApplication.getInst().getString(R.string.fun_ad_item_download_count, new Object[]{StringHelper.numberUniformFormat(nativeUnifiedADData.getDownloadCount())});
                this.f15972d = null;
                this.f15973e = null;
                this.f15975g = null;
                this.f15974f = null;
            } else {
                this.f15970b = 0.0f;
                this.f15971c = null;
                this.f15972d = null;
                this.f15973e = null;
                this.f15975g = null;
                this.f15974f = null;
                this.f15969a = "";
            }
        }

        public String a() {
            return this.f15975g;
        }

        public String b() {
            return this.f15973e;
        }

        public String c() {
            return this.f15971c;
        }

        public String d() {
            return this.f15974f;
        }

        public String e() {
            return this.f15972d;
        }

        public float f() {
            return this.f15970b;
        }

        public CharSequence g() {
            return this.f15969a;
        }
    }

    public FunAdDownloadView(Context context) {
        this(context, null, 0);
    }

    public final void c() {
        LayoutInflater.from(this.f15958e).inflate(R.layout.fun_ad_download_info, (ViewGroup) this, true);
        this.f15959f = (FunAdButton) findViewById(R.id.fun_ad_download_button);
        this.f15960g = (TextView) findViewById(R.id.fun_ad_download_title);
        this.f15961h = (LinearLayout) findViewById(R.id.fun_ad_download_score_layout);
        this.f15962i = (RankStarView) findViewById(R.id.fun_ad_download_star);
        this.j = (TextView) findViewById(R.id.fun_ad_download_score);
        this.k = (TextView) findViewById(R.id.fun_ad_download_count);
        this.l = (TextView) findViewById(R.id.fun_ad_download_version);
        this.m = (ViewGroup) findViewById(R.id.fun_download_line_2);
        this.n = (TextView) findViewById(R.id.fun_ad_download_company);
        this.o = (TextView) findViewById(R.id.fun_ad_download_privacy);
        this.p = (TextView) findViewById(R.id.fun_ad_download_authority);
        this.q = new EBusinessProtocolView(this.f15958e, EBusinessProtocolView.WindowType.TIP);
    }

    public void d(int i2) {
        d.a.m0.r.u.c d2 = d.a.m0.r.u.c.d(this);
        d2.m(R.string.J_X05);
        d2.f(R.color.CAM_X0206);
        d.a.m0.r.u.c.d(this.f15960g).s(R.color.CAM_X0107);
        d.a.m0.r.u.c.d(this.l).s(R.color.CAM_X0109);
        d.a.m0.r.u.c.d(this.j).s(R.color.CAM_X0109);
        d.a.m0.r.u.c.d(this.k).s(R.color.CAM_X0109);
        d.a.m0.r.u.c.d(this.n).s(R.color.CAM_X0109);
        d.a.m0.r.u.c.d(this.o).s(R.color.CAM_X0109);
        d.a.m0.r.u.c.d(this.p).s(R.color.CAM_X0109);
        this.f15959f.h();
        this.f15962i.e(i2);
    }

    public FunAdButton getDownloadButton() {
        return this.f15959f;
    }

    public void setViewData(FunNativeAd funNativeAd, Activity activity, String str) {
        if (d.a.n0.t0.b.j(funNativeAd) && FunAdSdkSwitch.isOn()) {
            setVisibility(0);
            c cVar = new c(funNativeAd);
            this.f15960g.setText(cVar.g());
            float f2 = cVar.f();
            if (f2 > 2.5d) {
                this.f15961h.setVisibility(0);
                this.k.setVisibility(8);
                this.j.setText(String.valueOf(f2));
                this.f15962i.setStarCount(f2);
            } else if (!TextUtils.isEmpty(cVar.c())) {
                this.f15961h.setVisibility(8);
                this.k.setVisibility(0);
                this.k.setText(cVar.c());
            } else {
                this.f15961h.setVisibility(8);
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
                this.q.o(this.f15958e.getString(R.string.fun_ad_privacy_dialog_title));
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
        this.f15958e = context;
        c();
    }
}
