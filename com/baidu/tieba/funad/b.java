package com.baidu.tieba.funad;

import android.app.Activity;
import android.app.Application;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.h.a;
import com.fun.ad.sdk.FunAdConfig;
import com.fun.ad.sdk.FunAdInteractionListener;
import com.fun.ad.sdk.FunAdLoadListener;
import com.fun.ad.sdk.FunAdSdk;
import com.fun.ad.sdk.FunAdSlot;
import com.fun.ad.sdk.FunNativeAd;
import java.lang.ref.WeakReference;
import java.util.List;
/* loaded from: classes5.dex */
public class b implements a.InterfaceC0749a {
    private void a(a.e eVar) {
        a(TbadkCoreApplication.getInst(), eVar);
    }

    @Override // com.baidu.tieba.h.a.InterfaceC0749a
    public synchronized void a(Application application, final a.e eVar) {
        if (FunAdSdk.isSdkInitializeComplete()) {
            if (eVar != null) {
                eVar.cNA();
            }
        } else {
            FunAdSdk.init(new FunAdConfig.Builder(application).setAppName(application.getString(R.string.app_name)).setAppId("b122ce58b8954c27b6882f7987c08860").setUserId("").setUseTextureView(true).setTitleBarTheme(1).setVideoSoundEnable(false).setVideoDataFlowAutoStart(false).setLogEnabled(TbadkCoreApplication.getInst().isDebugMode()).build(), null, new FunAdSdk.SdkInitializeCallback() { // from class: com.baidu.tieba.funad.b.1
                @Override // com.fun.ad.sdk.FunAdSdk.SdkInitializeCallback
                public void onComplete() {
                    if (eVar != null) {
                        eVar.cNA();
                    }
                }
            });
        }
    }

    @Override // com.baidu.tieba.h.a.InterfaceC0749a
    public boolean isAdReady(String str) {
        a(null);
        return FunAdSdk.getAdFactory().isAdReady(str);
    }

    @Override // com.baidu.tieba.h.a.InterfaceC0749a
    public void a(final Activity activity, String str, final a.b bVar) {
        final FunAdSlot build = new FunAdSlot.Builder().setSid(str).setExpressWidth(l.getEquipmentWidth(activity)).build();
        final FunAdLoadListener funAdLoadListener = new FunAdLoadListener() { // from class: com.baidu.tieba.funad.b.3
            @Override // com.fun.ad.sdk.FunAdLoadListener
            public void onAdLoaded(String str2) {
                if (bVar != null) {
                    bVar.aE(str2, 0);
                }
            }

            @Override // com.fun.ad.sdk.FunAdLoadListener
            public void onError(String str2) {
                if (bVar != null) {
                    bVar.onError(str2);
                }
            }
        };
        a(new a.e() { // from class: com.baidu.tieba.funad.b.4
            @Override // com.baidu.tieba.h.a.e
            public void cNA() {
                FunAdSdk.getAdFactory().loadAd(activity, build, funAdLoadListener);
            }
        });
    }

    @Override // com.baidu.tieba.h.a.InterfaceC0749a
    public void a(final Activity activity, final String str, final ViewGroup viewGroup, final a.c cVar) {
        if (viewGroup != null) {
            final FunAdInteractionListener funAdInteractionListener = new FunAdInteractionListener() { // from class: com.baidu.tieba.funad.b.5
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
                        cVar.onAdError(str2);
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
            };
            a(new a.e() { // from class: com.baidu.tieba.funad.b.6
                @Override // com.baidu.tieba.h.a.e
                public void cNA() {
                    FunAdSdk.getAdFactory().showAd(activity, viewGroup, str, funAdInteractionListener);
                }
            });
        }
    }

    @Override // com.baidu.tieba.h.a.InterfaceC0749a
    public ViewGroup g(Activity activity, String str) {
        return new FrameLayout(activity);
    }

    @Override // com.baidu.tieba.h.a.InterfaceC0749a
    public void destroyAd(final String str) {
        a(new a.e() { // from class: com.baidu.tieba.funad.b.7
            @Override // com.baidu.tieba.h.a.e
            public void cNA() {
                FunAdSdk.getAdFactory().destroyAd(str);
            }
        });
    }

    @Override // com.baidu.tieba.h.a.InterfaceC0749a
    public void b(final Activity activity, String str, a.b bVar) {
        final WeakReference weakReference = new WeakReference(bVar);
        final FunAdSlot build = new FunAdSlot.Builder().setSid(str).setExpressWidth(l.getEquipmentWidth(activity)).build();
        final FunAdLoadListener funAdLoadListener = new FunAdLoadListener() { // from class: com.baidu.tieba.funad.b.8
            @Override // com.fun.ad.sdk.FunAdLoadListener
            public void onAdLoaded(String str2) {
                if (weakReference.get() != null) {
                    ((a.b) weakReference.get()).aE(str2, 0);
                }
            }

            @Override // com.fun.ad.sdk.FunAdLoadListener
            public void onError(String str2) {
                if (weakReference.get() != null) {
                    ((a.b) weakReference.get()).onError(str2);
                }
            }
        };
        a(new a.e() { // from class: com.baidu.tieba.funad.b.9
            @Override // com.baidu.tieba.h.a.e
            public void cNA() {
                FunAdSdk.getAdFactory().loadAd(activity, build, funAdLoadListener);
            }
        });
    }

    @Override // com.baidu.tieba.h.a.InterfaceC0749a
    public Object h(@NonNull Activity activity, @NonNull String str) {
        a(null);
        return FunAdSdk.getAdFactory().getNativeAd(activity, str);
    }

    @Override // com.baidu.tieba.h.a.InterfaceC0749a
    public void a(final Activity activity, @NonNull Object obj, final a.c cVar, final ViewGroup viewGroup, final List<View> list, final List<View> list2) {
        if (!activity.isDestroyed() && (obj instanceof FunNativeAd)) {
            final FunNativeAd funNativeAd = (FunNativeAd) obj;
            final FunAdInteractionListener funAdInteractionListener = new FunAdInteractionListener() { // from class: com.baidu.tieba.funad.b.10
                @Override // com.fun.ad.sdk.FunAdInteractionListener
                public void onAdClicked(String str) {
                    if (cVar != null) {
                        cVar.onAdClicked(str);
                    }
                }

                @Override // com.fun.ad.sdk.FunAdInteractionListener
                public void onAdShow(String str) {
                    if (cVar != null) {
                        cVar.onAdShow(str);
                    }
                }

                @Override // com.fun.ad.sdk.FunAdInteractionListener
                public void onAdError(String str) {
                    if (cVar != null) {
                        cVar.onAdError(str);
                    }
                }

                @Override // com.fun.ad.sdk.FunAdInteractionListener
                public void onAdClose(String str) {
                    if (cVar != null) {
                        cVar.onAdClose(str);
                    }
                }

                @Override // com.fun.ad.sdk.FunAdInteractionListener
                public void onRewardedVideo(String str) {
                    if (cVar != null) {
                        cVar.onRewardedVideo(str);
                    }
                }
            };
            a(new a.e() { // from class: com.baidu.tieba.funad.b.2
                @Override // com.baidu.tieba.h.a.e
                public void cNA() {
                    funNativeAd.show(activity, viewGroup, list, list2, funAdInteractionListener);
                }
            });
        }
    }

    @Override // com.baidu.tieba.h.a.InterfaceC0749a
    public void Lz(String str) {
        destroyAd(str);
    }
}
