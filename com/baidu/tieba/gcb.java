package com.baidu.tieba;

import com.fun.ad.sdk.internal.api.config.Ssp;
/* loaded from: classes5.dex */
public interface gcb {
    void onAdClicked(Ssp.Pid pid);

    void onAdClose(Ssp.Pid pid);

    void onAdLoad(Ssp.Pid pid);

    void onAdLoadError(Ssp.Pid pid, int i, String str);

    void onAdLoaded(Ssp.Pid pid, double d);

    void onAdShow(Ssp.Pid pid, double d);

    void onAdShowError(Ssp.Pid pid, int i, String str);

    void onRewardedVideo(Ssp.Pid pid, boolean z, int i);
}
