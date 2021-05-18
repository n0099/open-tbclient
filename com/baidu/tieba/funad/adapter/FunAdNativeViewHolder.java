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
import com.fun.ad.sdk.ChannelNativeAds_6;
import com.fun.ad.sdk.FunNativeAd;
import d.a.k0.d3.h0.n;
import d.a.k0.r0.a;
import d.a.k0.s0.b;
/* loaded from: classes4.dex */
public class FunAdNativeViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public final BdUniqueId f16030a;

    /* renamed from: b  reason: collision with root package name */
    public final Activity f16031b;

    /* renamed from: c  reason: collision with root package name */
    public final FunAbsAdView f16032c;

    /* renamed from: d  reason: collision with root package name */
    public String f16033d;

    /* renamed from: e  reason: collision with root package name */
    public String f16034e;

    /* renamed from: f  reason: collision with root package name */
    public String f16035f;

    /* loaded from: classes4.dex */
    public class a implements a.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f16036a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f16037b;

        public a(n nVar, Object obj) {
            this.f16036a = nVar;
            this.f16037b = obj;
        }

        @Override // d.a.k0.r0.a.f
        public void onAdClicked(String str) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 6).param("obj_type", FunAdNativeViewHolder.this.f()).param("obj_locate", 0);
            b.a(param, this.f16036a);
            TiebaStatic.log(param);
            if (b.n((FunNativeAd) this.f16037b)) {
                FunAdNativeViewHolder.this.f16032c.setDownloadDelayText(FunAdNativeViewHolder.this.f16031b.getString(R.string.fun_ad_downloading), 1000L);
            }
        }

        @Override // d.a.k0.r0.a.f
        public void onAdClose(String str) {
        }

        @Override // d.a.k0.r0.a.f
        public void onAdError(String str) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", FunAdNativeViewHolder.this.f()).param("obj_locate", 1);
            b.a(param, this.f16036a);
            TiebaStatic.log(param);
        }

        @Override // d.a.k0.r0.a.f
        public void onAdShow(String str) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", FunAdNativeViewHolder.this.f()).param("obj_locate", 0);
            b.a(param, this.f16036a);
            TiebaStatic.log(param);
        }

        @Override // d.a.k0.r0.a.f
        public void onRewardedVideo(String str) {
        }
    }

    public FunAdNativeViewHolder(@NonNull FunAbsAdView funAbsAdView, @NonNull Activity activity, @NonNull BdUniqueId bdUniqueId) {
        super(funAbsAdView);
        this.f16030a = bdUniqueId;
        this.f16032c = funAbsAdView;
        this.f16031b = activity;
    }

    public final boolean d(FunNativeAd funNativeAd) {
        if (funNativeAd == null || funNativeAd.getChannelNativeAds_6() == null) {
            return false;
        }
        ChannelNativeAds_6 channelNativeAds_6 = funNativeAd.getChannelNativeAds_6();
        return (channelNativeAds_6.gdtNative == null && channelNativeAds_6.csjNative == null) ? false : true;
    }

    public FunAbsAdView e() {
        return this.f16032c;
    }

    public String f() {
        return "personalize".equals(this.f16035f) ? "a002" : this.f16030a == AdvertAppInfo.k4 ? "a006" : "a005";
    }

    public void g(View.OnClickListener onClickListener) {
        if (this.f16032c.getFeedBackView() != null) {
            this.f16032c.getFeedBackView().setOnClickListener(onClickListener);
            this.f16032c.setFeedBackListener(onClickListener);
        }
    }

    public void h(String str) {
        this.f16035f = str;
    }

    public void i(String str) {
        this.f16034e = str;
    }

    public void j(String str) {
        this.f16033d = str;
    }

    public void k(@NonNull n nVar) {
        Object d2 = nVar.d();
        if (d2 == null) {
            d2 = d.a.k0.r0.a.h().i(this.f16031b, this.f16033d);
            nVar.l(d2);
            if (!TextUtils.isEmpty(this.f16034e) && d2 != null) {
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
                d.a.k0.r0.d.a.f().a(this.f16034e, funAdHistoryData);
            }
        }
        Object obj = d2;
        if (obj == null) {
            this.f16032c.d(8);
            return;
        }
        this.f16032c.d(0);
        this.f16032c.f(nVar, this.f16031b);
        this.f16032c.e(this.f16030a);
        FunAbsAdView funAbsAdView = this.f16032c;
        FunNativeAd funNativeAd2 = (FunNativeAd) obj;
        funAbsAdView.c(funNativeAd2);
        d.a.k0.r0.a.h().o(this.f16031b, obj, new a(nVar, obj), funAbsAdView, this.f16032c.getClickViews(), this.f16032c.getCreativeViews(), this.f16032c.getLogItem());
        if (!d(funNativeAd2) || funAbsAdView == null || funAbsAdView.getChildCount() <= 1) {
            return;
        }
        funAbsAdView.removeViewAt(funAbsAdView.getChildCount() - 1);
    }
}
