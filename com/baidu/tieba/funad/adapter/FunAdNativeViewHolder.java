package com.baidu.tieba.funad.adapter;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.funAd.strategy.FunAdHistoryData;
import com.baidu.tieba.funad.view.FunAbsAdView;
import com.fun.ad.sdk.ChannelNativeAds_5;
import com.fun.ad.sdk.FunNativeAd;
import d.b.j0.d3.h0.n;
import d.b.j0.r0.a;
import d.b.j0.s0.b;
/* loaded from: classes4.dex */
public class FunAdNativeViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public final BdUniqueId f16475a;

    /* renamed from: b  reason: collision with root package name */
    public final Activity f16476b;

    /* renamed from: c  reason: collision with root package name */
    public final FunAbsAdView f16477c;

    /* renamed from: d  reason: collision with root package name */
    public String f16478d;

    /* renamed from: e  reason: collision with root package name */
    public String f16479e;

    /* renamed from: f  reason: collision with root package name */
    public String f16480f;

    /* loaded from: classes4.dex */
    public class a implements a.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f16481a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f16482b;

        public a(n nVar, Object obj) {
            this.f16481a = nVar;
            this.f16482b = obj;
        }

        @Override // d.b.j0.r0.a.f
        public void onAdClicked(String str) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 6).param("obj_type", FunAdNativeViewHolder.this.f()).param("obj_locate", 0);
            b.a(param, this.f16481a);
            TiebaStatic.log(param);
            if (b.n((FunNativeAd) this.f16482b)) {
                FunAdNativeViewHolder.this.f16477c.setDownloadDelayText(FunAdNativeViewHolder.this.f16476b.getString(R.string.fun_ad_downloading), 1000L);
            }
        }

        @Override // d.b.j0.r0.a.f
        public void onAdClose(String str) {
        }

        @Override // d.b.j0.r0.a.f
        public void onAdError(String str) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", FunAdNativeViewHolder.this.f()).param("obj_locate", 1);
            b.a(param, this.f16481a);
            TiebaStatic.log(param);
        }

        @Override // d.b.j0.r0.a.f
        public void onAdShow(String str) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", FunAdNativeViewHolder.this.f()).param("obj_locate", 0);
            b.a(param, this.f16481a);
            TiebaStatic.log(param);
        }

        @Override // d.b.j0.r0.a.f
        public void onRewardedVideo(String str) {
        }
    }

    public FunAdNativeViewHolder(@NonNull FunAbsAdView funAbsAdView, @NonNull Activity activity, @NonNull BdUniqueId bdUniqueId) {
        super(funAbsAdView);
        this.f16475a = bdUniqueId;
        this.f16477c = funAbsAdView;
        this.f16476b = activity;
    }

    public final boolean d(FunNativeAd funNativeAd) {
        if (funNativeAd == null || funNativeAd.getChannelNativeAds_5() == null) {
            return false;
        }
        ChannelNativeAds_5 channelNativeAds_5 = funNativeAd.getChannelNativeAds_5();
        return (channelNativeAds_5.gdtNative == null && channelNativeAds_5.csjNative == null) ? false : true;
    }

    public FunAbsAdView e() {
        return this.f16477c;
    }

    public String f() {
        return "personalize".equals(this.f16480f) ? "a002" : this.f16475a == AdvertAppInfo.n4 ? "a006" : "a005";
    }

    public void g(View.OnClickListener onClickListener) {
        if (this.f16477c.getFeedBackView() != null) {
            this.f16477c.getFeedBackView().setOnClickListener(onClickListener);
            this.f16477c.setFeedBackListener(onClickListener);
        }
    }

    public void h(String str) {
        this.f16480f = str;
    }

    public void i(String str) {
        this.f16479e = str;
    }

    public void j(String str) {
        this.f16478d = str;
    }

    public void k(@NonNull n nVar) {
        Object d2 = nVar.d();
        if (d2 == null) {
            d2 = d.b.j0.r0.a.h().i(this.f16476b, this.f16478d);
            nVar.l(d2);
            if (!TextUtils.isEmpty(this.f16479e) && d2 != null) {
                FunAdHistoryData funAdHistoryData = new FunAdHistoryData();
                StringBuilder sb = new StringBuilder();
                FunNativeAd funNativeAd = (FunNativeAd) d2;
                sb.append(b.e(funNativeAd));
                sb.append("_");
                sb.append(funNativeAd.getTitle());
                sb.append("_");
                sb.append(funNativeAd.getDescription());
                funAdHistoryData.setFunAdKey(sb.toString());
                funAdHistoryData.setShowTime(System.currentTimeMillis() / 1000);
                d.b.j0.r0.d.a.f().a(this.f16479e, funAdHistoryData);
            }
        }
        Object obj = d2;
        if (obj == null) {
            this.f16477c.d(8);
            return;
        }
        this.f16477c.d(0);
        this.f16477c.f(nVar, this.f16476b);
        this.f16477c.e(this.f16475a);
        FunAbsAdView funAbsAdView = this.f16477c;
        FunNativeAd funNativeAd2 = (FunNativeAd) obj;
        funAbsAdView.c(funNativeAd2);
        d.b.j0.r0.a.h().o(this.f16476b, obj, new a(nVar, obj), funAbsAdView, this.f16477c.getClickViews(), this.f16477c.getCreativeViews(), this.f16477c.getLogItem());
        if (!d(funNativeAd2) || funAbsAdView == null || funAbsAdView.getChildCount() <= 1) {
            return;
        }
        funAbsAdView.removeViewAt(funAbsAdView.getChildCount() - 1);
    }
}
