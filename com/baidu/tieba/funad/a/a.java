package com.baidu.tieba.funad.a;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.funad.view.FunAdButton;
import com.baidu.tieba.tbadkCore.data.n;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.fun.ad.sdk.ChannelNativeAds_5;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
/* loaded from: classes5.dex */
public class a implements TTAppDownloadListener, ChannelNativeAds_5.GdtADStatusChangeListener, KsAppDownloadListener {
    protected final n eVH;
    protected final FunAdButton jVd;

    public a(FunAdButton funAdButton, n nVar) {
        this.jVd = funAdButton;
        this.eVH = nVar;
    }

    protected void Bh(int i) {
        if (this.jVd != null && this.jVd.getTag() == this.eVH) {
            this.jVd.setText(i);
        }
        if (this.eVH != null) {
            this.eVH.Tv(TbadkApplication.getInst().getString(i));
        }
    }

    protected void setProgress(int i) {
        if (this.jVd != null && this.jVd.getTag() == this.eVH) {
            this.jVd.setProgress(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onIdle() {
        Bh(R.string.ad_interaction_type_download);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadActive(long j, long j2, String str, String str2) {
        if (j > 0) {
            setProgress((int) ((100 * j2) / j));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadPaused(long j, long j2, String str, String str2) {
        if (j > 0) {
            setProgress((int) ((100 * j2) / j));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadFailed(long j, long j2, String str, String str2) {
        Bh(R.string.ad_interaction_type_download);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onInstalled(String str, String str2) {
        Bh(R.string.ad_interaction_type_open);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
    public void onDownloadFinished(long j, String str, String str2) {
        Bh(R.string.ad_interaction_type_install);
    }

    @Override // com.fun.ad.sdk.ChannelNativeAds_5.GdtADStatusChangeListener
    public void onADStatusChanged(NativeUnifiedADData nativeUnifiedADData) {
        if (!nativeUnifiedADData.isAppAd()) {
            Bh(R.string.ad_interaction_type_view);
            return;
        }
        switch (nativeUnifiedADData.getAppStatus()) {
            case 0:
                Bh(R.string.ad_interaction_type_download);
                return;
            case 1:
                Bh(R.string.ad_interaction_type_start);
                return;
            case 2:
                Bh(R.string.ad_interaction_type_update);
                return;
            case 4:
                setProgress(nativeUnifiedADData.getProgress());
                return;
            case 8:
                Bh(R.string.ad_interaction_type_install);
                return;
            case 16:
                Bh(R.string.ad_interaction_type_redownload);
                return;
            default:
                Bh(R.string.ad_interaction_type_view);
                return;
        }
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadStarted() {
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i) {
        setProgress(i);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
        Bh(R.string.ad_interaction_type_install);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        Bh(R.string.ad_interaction_type_download);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        Bh(R.string.ad_interaction_type_open);
    }
}
