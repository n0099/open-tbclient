package com.baidu.tieba.funad;

import android.app.Activity;
import android.app.Application;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.h.a;
import com.fun.ad.sdk.FunAdCallback;
import com.fun.ad.sdk.FunAdConfig;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdLoadListener;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunAdType;
import com.fun.ad.sdk.FunAdView;
import com.fun.ad.sdk.FunNativeAd;
import com.fun.ad.sdk.FunNativeAdInteractionListener;
import com.fun.ad.sdk.FunNativeAdLoadListener;
import java.util.List;
/* loaded from: classes15.dex */
public class b implements a.b {
    private static volatile boolean jQB = false;

    private void cPs() {
        initSdk(TbadkCoreApplication.getInst());
    }

    public void initSdk(Application application) {
        if (!jQB) {
            FunAdSdk.init(new FunAdConfig.Builder(application).setAppName(application.getString(R.string.app_name)).setAppId("b122ce58b8954c27b6882f7987c08860").setLogEnabled(TbadkCoreApplication.getInst().isDebugMode()).setAsyncInit(false).setTitleBarTheme(1).setUseTextureView(true).setSupportMultiProcess(true).setReportAdMaterials(false).setVideoSoundEnable(false).setVideoDataFlowAutoStart(false).build(), new FunAdCallback() { // from class: com.baidu.tieba.funad.b.1
                @Override // com.fun.ad.sdk.FunAdCallback
                public void onAdLoad(String str, String str2, String str3, String str4) {
                }

                @Override // com.fun.ad.sdk.FunAdCallback
                public void onAdLoaded(String str, String str2, String str3, String str4) {
                }

                @Override // com.fun.ad.sdk.FunAdCallback
                public void onAdLoadError(String str, String str2, String str3, String str4, int i, String str5) {
                }

                @Override // com.fun.ad.sdk.FunAdCallback
                public void onAdClicked(String str, String str2, String str3, String str4) {
                }

                @Override // com.fun.ad.sdk.FunAdCallback
                public void onAdShow(String str, String str2, String str3, String str4) {
                }

                @Override // com.fun.ad.sdk.FunAdCallback
                public void onAdShowError(String str, String str2, String str3, String str4, int i, String str5) {
                }

                @Override // com.fun.ad.sdk.FunAdCallback
                public void onAdClose(String str, String str2, String str3, String str4) {
                }

                @Override // com.fun.ad.sdk.FunAdCallback
                public void onRewardedVideo(String str, String str2, String str3, String str4) {
                }
            });
            jQB = true;
        }
    }

    @Override // com.baidu.tieba.h.a.b
    public boolean isAdReady(String str) {
        cPs();
        return FunAdSdk.getAdFactory().isAdReady(str);
    }

    @Override // com.baidu.tieba.h.a.b
    public void a(Activity activity, String str, final a.d dVar) {
        System.currentTimeMillis();
        cPs();
        FunAdSdk.getAdFactory().loadAd(activity, new FunAdSlot.Builder().setSid(str).setExpressWidth(l.getEquipmentWidth(activity)).build(), new FunAdLoadListener() { // from class: com.baidu.tieba.funad.b.2
            @Override // com.fun.ad.sdk.FunAdLoadListener
            public void onAdLoaded(String str2) {
                if (dVar != null) {
                    dVar.a(str2, null);
                }
                System.currentTimeMillis();
            }

            @Override // com.fun.ad.sdk.FunAdLoadListener
            public void onError(String str2) {
                if (dVar != null) {
                    dVar.onError(str2);
                }
            }
        });
    }

    @Override // com.baidu.tieba.h.a.b
    public View a(Activity activity, String str, View view, final a.c cVar) {
        System.currentTimeMillis();
        cPs();
        FunAdView funAdView = (view == null || !(view instanceof FunAdView)) ? new FunAdView(activity) : view;
        FunAdSdk.getAdFactory().showAd(activity, funAdView, str, new FunAdInteractionListener() { // from class: com.baidu.tieba.funad.b.3
            @Override // com.fun.ad.sdk.FunAdInteractionListener
            public void onAdClicked(String str2) {
                if (cVar != null) {
                    cVar.onAdClicked(str2);
                }
            }

            @Override // com.fun.ad.sdk.FunAdInteractionListener
            public void onAdShow(String str2) {
                if (cVar != null) {
                    cVar.onAdShow(str2);
                }
            }

            @Override // com.fun.ad.sdk.FunAdInteractionListener
            public void onAdError(String str2) {
                if (cVar != null) {
                    cVar.onAdError(str2, -1, null);
                }
            }

            @Override // com.fun.ad.sdk.FunAdInteractionListener
            public void onAdClose(String str2) {
                if (cVar != null) {
                    cVar.onAdClose(str2);
                }
            }

            @Override // com.fun.ad.sdk.FunAdInteractionListener
            public void onRewardedVideo(String str2) {
                if (cVar != null) {
                    cVar.onRewardedVideo(str2);
                }
            }
        });
        return funAdView;
    }

    @Override // com.baidu.tieba.h.a.b
    public View g(Activity activity, String str) {
        cPs();
        return new FunAdView(activity);
    }

    @Override // com.baidu.tieba.h.a.b
    public void destroyAd(String str) {
        cPs();
        FunAdSdk.getAdFactory().destroyAd(str);
    }

    @Override // com.baidu.tieba.h.a.b
    public void b(Activity activity, String str, final a.d dVar) {
        cPs();
        FunAdSdk.getAdFactory().loadNativeAd(activity, new FunAdSlot.Builder().setSid(str).build(), new FunNativeAdLoadListener() { // from class: com.baidu.tieba.funad.b.4
            @Override // com.fun.ad.sdk.FunNativeAdLoadListener
            public void onNativeAdLoaded(String str2, List<FunNativeAd> list) {
                c.onNativeAdLoaded(str2, list);
                List<bz> LM = com.baidu.tieba.h.a.cPn().LM("6051001308-627527144");
                if (dVar != null) {
                    dVar.a(str2, x.isEmpty(LM) ? null : LM.get(0).eWF);
                }
            }

            @Override // com.fun.ad.sdk.FunNativeAdLoadListener
            public void onError(String str2, int i, String str3) {
            }
        });
    }

    @Override // com.baidu.tieba.h.a.b
    public void a(a.C0758a c0758a, final a.e eVar) {
        cPs();
        if (c0758a != null && c0758a.eWF != null && (c0758a.eWF.dOO() instanceof FunNativeAd)) {
            FunNativeAd funNativeAd = (FunNativeAd) c0758a.eWF.dOO();
            funNativeAd.show(c0758a.jQp, c0758a.jQq, c0758a.jQr, c0758a.jQs, c0758a.jQt, c0758a.jQu, c0758a.jQv, c0758a.jQw, c0758a.jQx, new FunNativeAdInteractionListener() { // from class: com.baidu.tieba.funad.b.5
                @Override // com.fun.ad.sdk.FunNativeAdInteractionListener
                public void onAdClick(String str) {
                    if (eVar != null) {
                        eVar.onAdClicked(str);
                    }
                }

                @Override // com.fun.ad.sdk.FunNativeAdInteractionListener
                public void onAdShow(String str) {
                    if (eVar != null) {
                        eVar.onAdShow(str);
                    }
                }

                @Override // com.fun.ad.sdk.FunNativeAdInteractionListener
                public void onAdError(String str, int i, String str2) {
                    if (eVar != null) {
                        eVar.onAdError(str, i, str2);
                    }
                }
            }, true);
            if (a(funNativeAd) && c0758a.jQp != null && c0758a.jQp.getChildCount() > 1) {
                c0758a.jQp.removeViewAt(c0758a.jQp.getChildCount() - 1);
            }
        }
    }

    @Override // com.baidu.tieba.h.a.b
    public void a(a.C0758a c0758a) {
        cPs();
        if (c0758a != null && c0758a.eWF != null && c0758a.eWF.dOO() != null && (c0758a.eWF.dOO() instanceof FunNativeAd)) {
            ((FunNativeAd) c0758a.eWF.dOO()).destroy();
        }
    }

    public boolean a(FunNativeAd funNativeAd) {
        if (funNativeAd != null) {
            String adType = funNativeAd.getAdType();
            return FunAdType.GDT_NATIVE_UNIFIED.equals(adType) || FunAdType.CSJ_NATIVE.equals(adType);
        }
        return false;
    }
}
