package com.baidu.tieba.funad.adapter;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.funad.c;
import com.baidu.tieba.funad.view.FunAbsAdView;
import com.baidu.tieba.h.a;
import com.baidu.tieba.tbadkCore.data.n;
import com.fun.ad.sdk.ChannelNativeAds_5;
import com.fun.ad.sdk.FunNativeAd;
/* loaded from: classes5.dex */
public class FunAdNativeViewHolder extends TypeAdapter.ViewHolder {
    public n eVH;
    private final BdUniqueId jUZ;
    private final FunAbsAdView jVa;
    private final Activity mActivity;

    public FunAdNativeViewHolder(@NonNull FunAbsAdView funAbsAdView, @NonNull Activity activity, @NonNull BdUniqueId bdUniqueId) {
        super(funAbsAdView);
        this.jUZ = bdUniqueId;
        this.jVa = funAbsAdView;
        this.mActivity = activity;
    }

    public FunAbsAdView cNE() {
        return this.jVa;
    }

    public void E(View.OnClickListener onClickListener) {
        if (this.jVa.getFeedBackView() != null) {
            this.jVa.getFeedBackView().setOnClickListener(onClickListener);
        }
    }

    public void a(@NonNull n nVar) {
        this.eVH = nVar;
        String str = this.jUZ == AdvertAppInfo.eMN ? "6051001773-1862514716" : "6051001775-457565154";
        if (nVar.dNz() == null) {
            nVar.aT(com.baidu.tieba.h.a.cNx().h(this.mActivity, str));
        }
        final Object dNz = nVar.dNz();
        if (dNz == null) {
            this.jVa.setFunAdViewVisible(false);
            return;
        }
        this.jVa.setFunAdViewVisible(true);
        this.jVa.a(nVar, this.mActivity);
        this.jVa.s(this.jUZ);
        FrameLayout e = this.jVa.e((FunNativeAd) dNz);
        com.baidu.tieba.h.a.cNx().a(this.mActivity, dNz, new a.c() { // from class: com.baidu.tieba.funad.adapter.FunAdNativeViewHolder.1
            @Override // com.baidu.tieba.h.a.c
            public void onAdClicked(String str2) {
                TiebaStatic.log(new ar("c14053").aq("obj_source", 6).dR("obj_type", FunAdNativeViewHolder.this.jUZ == AdvertAppInfo.eMN ? PageStayDurationConstants.PageName.FRS : PageStayDurationConstants.PageName.PB).aq("obj_locate", 0));
                if (c.c((FunNativeAd) dNz)) {
                    FunAdNativeViewHolder.this.jVa.setDownloadDelayText(FunAdNativeViewHolder.this.mActivity.getString(R.string.fun_ad_downloading), 1000L);
                }
            }

            @Override // com.baidu.tieba.h.a.c
            public void onAdShow(String str2) {
                TiebaStatic.log(new ar("c14006").aq("obj_source", 6).dR("obj_type", FunAdNativeViewHolder.this.jUZ == AdvertAppInfo.eMN ? PageStayDurationConstants.PageName.FRS : PageStayDurationConstants.PageName.PB).aq("obj_locate", 0));
            }

            @Override // com.baidu.tieba.h.a.c
            public void onAdError(String str2) {
                TiebaStatic.log(new ar("c14006").aq("obj_source", 6).dR("obj_type", FunAdNativeViewHolder.this.jUZ == AdvertAppInfo.eMN ? PageStayDurationConstants.PageName.FRS : PageStayDurationConstants.PageName.PB).aq("obj_locate", 1));
            }

            @Override // com.baidu.tieba.h.a.c
            public void onAdClose(String str2) {
            }

            @Override // com.baidu.tieba.h.a.c
            public void onRewardedVideo(String str2) {
            }
        }, e, this.jVa.getClickViews(), this.jVa.getCreativeViews());
        if (d((FunNativeAd) dNz) && e != null && e.getChildCount() > 1) {
            e.removeViewAt(e.getChildCount() - 1);
        }
    }

    private boolean d(FunNativeAd funNativeAd) {
        if (funNativeAd == null || funNativeAd.getChannelNativeAds_5() == null) {
            return false;
        }
        ChannelNativeAds_5 channelNativeAds_5 = funNativeAd.getChannelNativeAds_5();
        return (channelNativeAds_5.gdtNative == null && channelNativeAds_5.csjNative == null) ? false : true;
    }
}
