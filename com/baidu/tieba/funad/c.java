package com.baidu.tieba.funad;

import com.baidu.tbadk.core.data.bz;
import com.baidu.tieba.tbadkCore.data.n;
import com.fun.ad.sdk.FunNativeAd;
import java.util.List;
/* loaded from: classes14.dex */
public class c {
    public static void onNativeAdLoaded(String str, List<FunNativeAd> list) {
        for (FunNativeAd funNativeAd : list) {
            bz bzVar = new bz();
            bzVar.eRU = new n(funNativeAd);
            bzVar.eRO = true;
            bzVar.eRP = funNativeAd.mAid;
            com.baidu.tieba.h.a.cLv().c(str, bzVar);
        }
    }
}
