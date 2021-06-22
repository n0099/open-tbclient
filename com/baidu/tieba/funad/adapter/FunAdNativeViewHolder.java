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
import com.baidu.tieba.funAd.http.FunAdRecordHttpMessage;
import com.baidu.tieba.funAd.strategy.FunAdHistoryData;
import com.baidu.tieba.funad.view.FunAbsAdView;
import com.fun.ad.sdk.ChannelNativeAds_6;
import com.fun.ad.sdk.FunNativeAd;
import d.a.o0.e3.h0.n;
import d.a.o0.s0.a;
import d.a.o0.t0.b;
/* loaded from: classes4.dex */
public class FunAdNativeViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public final BdUniqueId f16077a;

    /* renamed from: b  reason: collision with root package name */
    public final Activity f16078b;

    /* renamed from: c  reason: collision with root package name */
    public final FunAbsAdView f16079c;

    /* renamed from: d  reason: collision with root package name */
    public String f16080d;

    /* renamed from: e  reason: collision with root package name */
    public String f16081e;

    /* renamed from: f  reason: collision with root package name */
    public String f16082f;

    /* loaded from: classes4.dex */
    public class a implements a.g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f16083a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f16084b;

        public a(n nVar, Object obj) {
            this.f16083a = nVar;
            this.f16084b = obj;
        }

        @Override // d.a.o0.s0.a.g
        public void onAdClicked(String str) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 6).param("obj_type", FunAdNativeViewHolder.this.f()).param("obj_locate", 0);
            b.a(param, this.f16083a);
            b.s(0, FunAdRecordHttpMessage.CLICK_AD_RECORD, FunAdNativeViewHolder.this.f(), this.f16083a);
            TiebaStatic.log(param);
            if (b.n((FunNativeAd) this.f16084b)) {
                FunAdNativeViewHolder.this.f16079c.setDownloadDelayText(FunAdNativeViewHolder.this.f16078b.getString(R.string.fun_ad_downloading), 1000L);
            }
        }

        @Override // d.a.o0.s0.a.g
        public void onAdClose(String str) {
        }

        @Override // d.a.o0.s0.a.g
        public void onAdError(String str) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", FunAdNativeViewHolder.this.f()).param("obj_locate", 1);
            b.a(param, this.f16083a);
            b.s(1, FunAdRecordHttpMessage.SHOW_AD_RECORD, FunAdNativeViewHolder.this.f(), this.f16083a);
            TiebaStatic.log(param);
        }

        @Override // d.a.o0.s0.a.g
        public void onAdShow(String str) {
            StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", FunAdNativeViewHolder.this.f()).param("obj_locate", 0);
            b.a(param, this.f16083a);
            b.s(0, FunAdRecordHttpMessage.SHOW_AD_RECORD, FunAdNativeViewHolder.this.f(), this.f16083a);
            TiebaStatic.log(param);
        }

        @Override // d.a.o0.s0.a.g
        public void onRewardedVideo(String str) {
        }
    }

    public FunAdNativeViewHolder(@NonNull FunAbsAdView funAbsAdView, @NonNull Activity activity, @NonNull BdUniqueId bdUniqueId) {
        super(funAbsAdView);
        this.f16077a = bdUniqueId;
        this.f16079c = funAbsAdView;
        this.f16078b = activity;
    }

    public final boolean d(FunNativeAd funNativeAd) {
        if (funNativeAd == null || funNativeAd.getChannelNativeAds_6() == null) {
            return false;
        }
        ChannelNativeAds_6 channelNativeAds_6 = funNativeAd.getChannelNativeAds_6();
        return (channelNativeAds_6.gdtNative == null && channelNativeAds_6.csjNative == null) ? false : true;
    }

    public FunAbsAdView e() {
        return this.f16079c;
    }

    public String f() {
        return "personalize".equals(this.f16082f) ? "a002" : this.f16077a == AdvertAppInfo.o4 ? "a006" : "a005";
    }

    public void g(View.OnClickListener onClickListener) {
        if (this.f16079c.getFeedBackView() != null) {
            this.f16079c.getFeedBackView().setOnClickListener(onClickListener);
            this.f16079c.setFeedBackListener(onClickListener);
        }
    }

    public void h(String str) {
        this.f16082f = str;
    }

    public void i(String str) {
        this.f16081e = str;
    }

    public void j(String str) {
        this.f16080d = str;
    }

    public void k(@NonNull n nVar) {
        Object d2 = nVar.d();
        if (d2 == null) {
            d2 = d.a.o0.s0.a.h().i(this.f16078b, this.f16080d);
            nVar.l(d2);
            if (!TextUtils.isEmpty(this.f16081e) && d2 != null) {
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
                d.a.o0.s0.d.a.f().a(this.f16081e, funAdHistoryData);
            }
        }
        Object obj = d2;
        if (obj == null) {
            this.f16079c.d(8);
            return;
        }
        this.f16079c.d(0);
        this.f16079c.f(nVar, this.f16078b);
        this.f16079c.e(this.f16077a);
        FunAbsAdView funAbsAdView = this.f16079c;
        FunNativeAd funNativeAd2 = (FunNativeAd) obj;
        funAbsAdView.c(funNativeAd2);
        d.a.o0.s0.a.h().p(this.f16078b, obj, new a(nVar, obj), funAbsAdView, this.f16079c.getClickViews(), this.f16079c.getCreativeViews(), this.f16079c.getLogItem());
        if (!d(funNativeAd2) || funAbsAdView == null || funAbsAdView.getChildCount() <= 1) {
            return;
        }
        funAbsAdView.removeViewAt(funAbsAdView.getChildCount() - 1);
    }
}
