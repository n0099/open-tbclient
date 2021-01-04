package com.baidu.tieba.funad;

import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.tbadkCore.data.n;
import com.fun.ad.sdk.FunNativeAd;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public static void onNativeAdLoaded(String str, List<FunNativeAd> list) {
        for (FunNativeAd funNativeAd : list) {
            if (funNativeAd.mNativeUnifiedADData != null) {
                bz bzVar = new bz();
                bzVar.eWF = new n(funNativeAd);
                bzVar.eWz = true;
                bzVar.eWA = funNativeAd.mAid;
                com.baidu.tieba.h.a.cPm().c(str, bzVar);
            }
        }
    }
}
