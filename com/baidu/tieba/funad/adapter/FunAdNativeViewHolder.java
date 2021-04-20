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
import d.b.i0.d3.h0.n;
import d.b.i0.r0.a;
import d.b.i0.s0.b;
/* loaded from: classes4.dex */
public class FunAdNativeViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public final BdUniqueId f16467a;

    /* renamed from: b  reason: collision with root package name */
    public final Activity f16468b;

    /* renamed from: c  reason: collision with root package name */
    public final FunAbsAdView f16469c;

    /* renamed from: d  reason: collision with root package name */
    public String f16470d;

    /* renamed from: e  reason: collision with root package name */
    public String f16471e;

    /* renamed from: f  reason: collision with root package name */
    public String f16472f;

    /* loaded from: classes4.dex */
    public class a implements a.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f16473a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f16474b;

        public a(n nVar, Object obj) {
            this.f16473a = nVar;
            this.f16474b = obj;
        }

        @Override // d.b.i0.r0.a.f
        public void onAdClicked(String str) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 6).param("obj_type", FunAdNativeViewHolder.this.f()).param("obj_locate", 0);
            b.a(param, this.f16473a);
            TiebaStatic.log(param);
            if (b.n((FunNativeAd) this.f16474b)) {
                FunAdNativeViewHolder.this.f16469c.setDownloadDelayText(FunAdNativeViewHolder.this.f16468b.getString(R.string.fun_ad_downloading), 1000L);
            }
        }

        @Override // d.b.i0.r0.a.f
        public void onAdClose(String str) {
        }

        @Override // d.b.i0.r0.a.f
        public void onAdError(String str) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", FunAdNativeViewHolder.this.f()).param("obj_locate", 1);
            b.a(param, this.f16473a);
            TiebaStatic.log(param);
        }

        @Override // d.b.i0.r0.a.f
        public void onAdShow(String str) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", FunAdNativeViewHolder.this.f()).param("obj_locate", 0);
            b.a(param, this.f16473a);
            TiebaStatic.log(param);
        }

        @Override // d.b.i0.r0.a.f
        public void onRewardedVideo(String str) {
        }
    }

    public FunAdNativeViewHolder(@NonNull FunAbsAdView funAbsAdView, @NonNull Activity activity, @NonNull BdUniqueId bdUniqueId) {
        super(funAbsAdView);
        this.f16467a = bdUniqueId;
        this.f16469c = funAbsAdView;
        this.f16468b = activity;
    }

    public final boolean d(FunNativeAd funNativeAd) {
        if (funNativeAd == null || funNativeAd.getChannelNativeAds_5() == null) {
            return false;
        }
        ChannelNativeAds_5 channelNativeAds_5 = funNativeAd.getChannelNativeAds_5();
        return (channelNativeAds_5.gdtNative == null && channelNativeAds_5.csjNative == null) ? false : true;
    }

    public FunAbsAdView e() {
        return this.f16469c;
    }

    public String f() {
        return "personalize".equals(this.f16472f) ? "a002" : this.f16467a == AdvertAppInfo.n4 ? "a006" : "a005";
    }

    public void g(View.OnClickListener onClickListener) {
        if (this.f16469c.getFeedBackView() != null) {
            this.f16469c.getFeedBackView().setOnClickListener(onClickListener);
            this.f16469c.setFeedBackListener(onClickListener);
        }
    }

    public void h(String str) {
        this.f16472f = str;
    }

    public void i(String str) {
        this.f16471e = str;
    }

    public void j(String str) {
        this.f16470d = str;
    }

    public void k(@NonNull n nVar) {
        Object d2 = nVar.d();
        if (d2 == null) {
            d2 = d.b.i0.r0.a.h().i(this.f16468b, this.f16470d);
            nVar.l(d2);
            if (!TextUtils.isEmpty(this.f16471e) && d2 != null) {
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
                d.b.i0.r0.d.a.f().a(this.f16471e, funAdHistoryData);
            }
        }
        Object obj = d2;
        if (obj == null) {
            this.f16469c.d(8);
            return;
        }
        this.f16469c.d(0);
        this.f16469c.f(nVar, this.f16468b);
        this.f16469c.e(this.f16467a);
        FunAbsAdView funAbsAdView = this.f16469c;
        FunNativeAd funNativeAd2 = (FunNativeAd) obj;
        funAbsAdView.c(funNativeAd2);
        d.b.i0.r0.a.h().o(this.f16468b, obj, new a(nVar, obj), funAbsAdView, this.f16469c.getClickViews(), this.f16469c.getCreativeViews(), this.f16469c.getLogItem());
        if (!d(funNativeAd2) || funAbsAdView == null || funAbsAdView.getChildCount() <= 1) {
            return;
        }
        funAbsAdView.removeViewAt(funAbsAdView.getChildCount() - 1);
    }
}
