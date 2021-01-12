package com.baidu.tieba.funad;

import android.app.Activity;
import android.app.Application;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
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
import java.lang.ref.WeakReference;
import java.util.List;
/* loaded from: classes14.dex */
public class b implements a.b {
    private static volatile boolean jLV = false;

    private void cLA() {
        initSdk(TbadkCoreApplication.getInst());
    }

    public void initSdk(Application application) {
        if (!jLV) {
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
            jLV = true;
        }
    }

    @Override // com.baidu.tieba.h.a.b
    public boolean isAdReady(String str) {
        cLA();
        return FunAdSdk.getAdFactory().isAdReady(str);
    }

    @Override // com.baidu.tieba.h.a.b
    public void a(Activity activity, String str, final a.d dVar) {
        System.currentTimeMillis();
        cLA();
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
        cLA();
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
        cLA();
        return new FunAdView(activity);
    }

    @Override // com.baidu.tieba.h.a.b
    public void destroyAd(String str) {
        cLA();
        FunAdSdk.getAdFactory().destroyAd(str);
    }

    @Override // com.baidu.tieba.h.a.b
    public void b(Activity activity, String str, a.d dVar) {
        cLA();
        FunAdSlot build = new FunAdSlot.Builder().setSid(str).build();
        final WeakReference weakReference = new WeakReference(dVar);
        FunAdSdk.getAdFactory().loadNativeAd(activity, build, new FunNativeAdLoadListener() { // from class: com.baidu.tieba.funad.b.4
            @Override // com.fun.ad.sdk.FunNativeAdLoadListener
            public void onNativeAdLoaded(String str2, List<FunNativeAd> list) {
                c.onNativeAdLoaded(str2, list);
                List<bz> KD = com.baidu.tieba.h.a.cLv().KD("6051001537-901554884");
                if (weakReference.get() != null) {
                    ((a.d) weakReference.get()).a(str2, x.isEmpty(KD) ? null : KD.get(0).eRU);
                }
            }

            @Override // com.fun.ad.sdk.FunNativeAdLoadListener
            public void onError(String str2, int i, String str3) {
                if (weakReference.get() != null) {
                    ((a.d) weakReference.get()).onError(str2);
                }
            }
        });
    }

    @Override // com.baidu.tieba.h.a.b
    public void KE(String str) {
        if (!StringUtils.isNull(str)) {
            FunAdSdk.getAdFactory().destroyNativeAd(str);
        }
    }

    @Override // com.baidu.tieba.h.a.b
    public void a(a.C0741a c0741a, final a.e eVar) {
        cLA();
        if (c0741a != null && c0741a.eRU != null && (c0741a.eRU.dKW() instanceof FunNativeAd)) {
            FunNativeAd funNativeAd = (FunNativeAd) c0741a.eRU.dKW();
            funNativeAd.show(c0741a.jLJ, c0741a.jLK, c0741a.jLL, c0741a.jLM, c0741a.jLN, c0741a.jLO, c0741a.jLP, c0741a.jLQ, c0741a.jLR, new FunNativeAdInteractionListener() { // from class: com.baidu.tieba.funad.b.5
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
            if (a(funNativeAd) && c0741a.jLJ != null && c0741a.jLJ.getChildCount() > 1) {
                c0741a.jLJ.removeViewAt(c0741a.jLJ.getChildCount() - 1);
            }
        }
    }

    @Override // com.baidu.tieba.h.a.b
    public void a(a.C0741a c0741a) {
        cLA();
        if (c0741a != null && c0741a.eRU != null && c0741a.eRU.dKW() != null && (c0741a.eRU.dKW() instanceof FunNativeAd)) {
            ((FunNativeAd) c0741a.eRU.dKW()).destroy();
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
