package com.baidu.tieba.funad.adapter;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.funad.view.FunAbsAdView;
import com.fun.ad.sdk.ChannelNativeAds_5;
import com.fun.ad.sdk.FunNativeAd;
import d.b.i0.c3.h0.n;
import d.b.i0.q0.a;
import d.b.i0.r0.c;
/* loaded from: classes4.dex */
public class FunAdNativeViewHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public final BdUniqueId f16806a;

    /* renamed from: b  reason: collision with root package name */
    public final Activity f16807b;

    /* renamed from: c  reason: collision with root package name */
    public final FunAbsAdView f16808c;

    /* loaded from: classes4.dex */
    public class a implements a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object f16809a;

        public a(Object obj) {
            this.f16809a = obj;
        }

        @Override // d.b.i0.q0.a.e
        public void onAdClicked(String str) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 6).param("obj_type", FunAdNativeViewHolder.this.f16806a == AdvertAppInfo.n4 ? "a006" : "a005").param("obj_locate", 0));
            if (c.d((FunNativeAd) this.f16809a)) {
                FunAdNativeViewHolder.this.f16808c.setDownloadDelayText(FunAdNativeViewHolder.this.f16807b.getString(R.string.fun_ad_downloading), 1000L);
            }
        }

        @Override // d.b.i0.q0.a.e
        public void onAdClose(String str) {
        }

        @Override // d.b.i0.q0.a.e
        public void onAdError(String str) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", FunAdNativeViewHolder.this.f16806a == AdvertAppInfo.n4 ? "a006" : "a005").param("obj_locate", 1));
        }

        @Override // d.b.i0.q0.a.e
        public void onAdShow(String str) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", FunAdNativeViewHolder.this.f16806a == AdvertAppInfo.n4 ? "a006" : "a005").param("obj_locate", 0));
        }

        @Override // d.b.i0.q0.a.e
        public void onRewardedVideo(String str) {
        }
    }

    public FunAdNativeViewHolder(@NonNull FunAbsAdView funAbsAdView, @NonNull Activity activity, @NonNull BdUniqueId bdUniqueId) {
        super(funAbsAdView);
        this.f16806a = bdUniqueId;
        this.f16808c = funAbsAdView;
        this.f16807b = activity;
    }

    public final boolean e(FunNativeAd funNativeAd) {
        if (funNativeAd == null || funNativeAd.getChannelNativeAds_5() == null) {
            return false;
        }
        ChannelNativeAds_5 channelNativeAds_5 = funNativeAd.getChannelNativeAds_5();
        return (channelNativeAds_5.gdtNative == null && channelNativeAds_5.csjNative == null) ? false : true;
    }

    public FunAbsAdView f() {
        return this.f16808c;
    }

    public void g(View.OnClickListener onClickListener) {
        if (this.f16808c.getFeedBackView() != null) {
            this.f16808c.getFeedBackView().setOnClickListener(onClickListener);
        }
    }

    public void h(@NonNull n nVar) {
        String str = this.f16806a == AdvertAppInfo.n4 ? "6051001773-1862514716" : "6051001775-457565154";
        if (nVar.c() == null) {
            nVar.i(d.b.i0.q0.a.h().i(this.f16807b, str));
        }
        Object c2 = nVar.c();
        if (c2 == null) {
            this.f16808c.setFunAdViewVisible(false);
            return;
        }
        this.f16808c.setFunAdViewVisible(true);
        this.f16808c.f(nVar, this.f16807b);
        this.f16808c.e(this.f16806a);
        FunAbsAdView funAbsAdView = this.f16808c;
        FunNativeAd funNativeAd = (FunNativeAd) c2;
        funAbsAdView.c(funNativeAd);
        d.b.i0.q0.a.h().o(this.f16807b, c2, new a(c2), funAbsAdView, this.f16808c.getClickViews(), this.f16808c.getCreativeViews(), this.f16808c.getLogItem());
        if (!e(funNativeAd) || funAbsAdView == null || funAbsAdView.getChildCount() <= 1) {
            return;
        }
        funAbsAdView.removeViewAt(funAbsAdView.getChildCount() - 1);
    }
}
