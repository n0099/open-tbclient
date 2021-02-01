package com.baidu.tieba.funad;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tieba.tbadkCore.data.n;
import com.fun.ad.sdk.FunNativeAd;
import java.util.List;
/* loaded from: classes5.dex */
public class c {
    public static void onNativeAdLoaded(String str, List<FunNativeAd> list) {
        for (FunNativeAd funNativeAd : list) {
            cb cbVar = new cb();
            cbVar.eUi = new n(funNativeAd);
            cbVar.eUc = true;
            cbVar.eUd = funNativeAd.mAid;
            com.baidu.tieba.h.a.cNj().e(str, cbVar);
        }
    }

    public static boolean b(FunNativeAd funNativeAd) {
        return (funNativeAd == null || funNativeAd.mNativeUnifiedADData != null || funNativeAd.mTTFeedAd != null || funNativeAd.mKsNativeAd == null || TextUtils.isEmpty(funNativeAd.mKsNativeAd.getAppIconUrl())) ? false : true;
    }

    public static boolean c(FunNativeAd funNativeAd) {
        if (funNativeAd == null) {
            return false;
        }
        if (funNativeAd.mKsNativeAd == null || !funNativeAd.isDownloadAd()) {
            return (funNativeAd.mTTFeedAd == null || (funNativeAd.mTTFeedAd.getAppSize() == 0 && funNativeAd.mTTFeedAd.getAppScore() == 0)) ? false : true;
        }
        return true;
    }
}
