package com.baidu.tieba.advert.sdk;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.l;
import com.baidu.mobad.feeds.RequestParameters;
import com.baidu.mobads.RsplashType;
import com.baidu.mobads.SplashAd;
import com.baidu.mobads.SplashLpCloseListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import com.baidu.tieba.advert.sdk.data.AdSplashStyle;
import com.baidu.tieba.advert.sdk.widget.CountDownTextView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class b implements com.baidu.tieba.advert.sdk.b.b {
    private RsplashType glW;
    private SplashAd glZ;
    private WeakReference<ViewGroup> gma;
    private int glX = 5;
    private int mPattern = 1;
    private final AdSplashStyle glY = new AdSplashStyle();
    private AdLoadState gmb = AdLoadState.INIT;
    private com.baidu.tbadk.g.b gmc = new com.baidu.tbadk.g.b() { // from class: com.baidu.tieba.advert.sdk.b.1
        @Override // com.baidu.tbadk.g.b
        public void bkr() {
            b.this.bMB();
        }
    };

    @Override // com.baidu.tieba.advert.sdk.b.b
    public AdLoadState bMz() {
        return this.gmb;
    }

    @Override // com.baidu.tieba.advert.sdk.b.b
    public String bMA() {
        return null;
    }

    @Override // com.baidu.tieba.advert.sdk.b.b
    public void show() {
        if (this.glZ != null && this.gma != null && this.gmb == AdLoadState.SUCCEED) {
            bMB();
            if (1 == this.mPattern) {
            }
            this.gmb = AdLoadState.SHOWED;
            this.glZ.show();
        }
    }

    public void destroy() {
        if (this.glZ != null) {
            this.glZ.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMB() {
        if (this.gma != null && this.gma.get().getParent() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gma.get().getLayoutParams();
            if (1 != this.mPattern) {
                layoutParams.width = l.getEquipmentWidth(this.gma.get().getContext());
                layoutParams.height = (int) (l.getEquipmentHeight(this.gma.get().getContext()) * 0.8125d);
            } else {
                layoutParams.width = -1;
                layoutParams.height = -1;
            }
            this.gma.get().setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.advert.sdk.b.b
    public void a(com.baidu.tbadk.g.c cVar) {
        if (cVar != null && cVar.bks() != null && cVar.bks().getContext() != null) {
            cVar.eII = this.gmc;
            com.baidu.tbadk.g.a bkt = cVar.bkt();
            this.gma = new WeakReference<>(cVar.bks());
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(bkt);
            try {
                Context context = cVar.bks().getContext();
                ViewGroup bks = cVar.bks();
                new RequestParameters.Builder().setHeight(l.getEquipmentWidth(context)).setWidth(l.getEquipmentHeight(context)).build();
                this.glZ = new SplashAd(context, bks, anonymousClass2, "4776976", true, null, 1000, false, true);
                this.gmb = AdLoadState.LOADING;
                this.glZ.load();
            } catch (OutOfMemoryError e) {
                TbadkCoreApplication.getInst().onLowMemory();
                bkt.zC("oom");
            }
        }
    }

    /* renamed from: com.baidu.tieba.advert.sdk.b$2  reason: invalid class name */
    /* loaded from: classes7.dex */
    class AnonymousClass2 implements SplashLpCloseListener {
        final /* synthetic */ com.baidu.tbadk.g.a gme;

        AnonymousClass2(com.baidu.tbadk.g.a aVar) {
            this.gme = aVar;
        }

        @Override // com.baidu.mobads.SplashLpCloseListener
        public void onLpClosed() {
        }

        @Override // com.baidu.mobads.SplashAdListener
        public void onAdPresent() {
            boolean z = 1 == b.this.mPattern;
            if (this.gme != null) {
                this.gme.e(b.this.glW == RsplashType.VIDEO, z, 1);
            }
            ViewGroup viewGroup = (ViewGroup) b.this.gma.get();
            if (viewGroup != null) {
                Context context = viewGroup.getContext();
                CountDownTextView countDownTextView = new CountDownTextView(context);
                countDownTextView.setGravity(17);
                countDownTextView.setNumTypeFromBes(true);
                countDownTextView.aF(context.getResources().getString(R.string.ad_skip), b.this.glX);
                com.baidu.tbadk.core.elementsMaven.c.br(countDownTextView).oh(R.string.AD_J_X45).oa(R.dimen.tbds42).nZ(R.color.CAM_X0101).setBackGroundColor(R.color.black_alpha20);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getDimens(context, R.dimen.tbds216), l.getDimens(context, R.dimen.tbds90));
                com.baidu.tieba.advert.sdk.d.a.a(layoutParams, AdSplashStyle.SplashElement.SKIP, b.this.glY, z);
                viewGroup.addView(countDownTextView, layoutParams);
                countDownTextView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.b.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tieba.advert.sdk.d.a.bMQ();
                    }
                });
                countDownTextView.setTimeoutListener(new CountDownTextView.c() { // from class: com.baidu.tieba.advert.sdk.b.2.2
                    @Override // com.baidu.tieba.advert.sdk.widget.CountDownTextView.c
                    public void cf(View view) {
                        boolean z2 = b.this.gmb == AdLoadState.DISMISSED;
                        if (AnonymousClass2.this.gme != null && !z2) {
                            b.this.destroy();
                            AnonymousClass2.this.gme.onAdDismiss();
                        }
                        b.this.gmb = AdLoadState.DISMISSED;
                    }
                });
                countDownTextView.setTimerChangedListener(new CountDownTextView.a() { // from class: com.baidu.tieba.advert.sdk.b.2.3
                    @Override // com.baidu.tieba.advert.sdk.widget.CountDownTextView.a
                    public void ti(int i) {
                        if (i == 1 && b.this.glW != null && b.this.glW != RsplashType.VIDEO) {
                            e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.advert.sdk.b.2.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    boolean z2 = b.this.gmb == AdLoadState.DISMISSED;
                                    if (AnonymousClass2.this.gme != null && !z2) {
                                        b.this.destroy();
                                        AnonymousClass2.this.gme.onAdDismiss();
                                    }
                                    b.this.gmb = AdLoadState.DISMISSED;
                                }
                            }, 300L);
                        }
                    }
                });
                if (!TextUtils.isEmpty(b.this.glY.labelName)) {
                    TextView textView = new TextView(context);
                    textView.setGravity(17);
                    textView.setText(b.this.glY.labelName);
                    com.baidu.tbadk.core.elementsMaven.c.br(textView).oh(R.string.AD_J_X09).oa(R.dimen.tbds36).nZ(R.color.CAM_X0101).setBackGroundColor(R.color.black_alpha20);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(l.getDimens(context, R.dimen.tbds105), l.getDimens(context, R.dimen.tbds63));
                    com.baidu.tieba.advert.sdk.d.a.a(layoutParams2, AdSplashStyle.SplashElement.LABEL, b.this.glY, z);
                    viewGroup.addView(textView, layoutParams2);
                }
                if (z) {
                    int dimens = l.getDimens(context, R.dimen.tbds90);
                    ImageView imageView = new ImageView(context);
                    imageView.setScaleType(ImageView.ScaleType.CENTER);
                    imageView.setImageResource(b.this.glY.bMD() ? R.drawable.bg_bes_splash_logo_white : R.drawable.bg_bes_splash_logo_blue);
                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, dimens);
                    com.baidu.tieba.advert.sdk.d.a.a(layoutParams3, AdSplashStyle.SplashElement.LOGO, b.this.glY, z);
                    viewGroup.addView(imageView, layoutParams3);
                }
            }
        }

        @Override // com.baidu.mobads.SplashAdListener
        public void onAdDismissed() {
            b.this.destroy();
            boolean z = b.this.gmb == AdLoadState.DISMISSED;
            b.this.gmb = AdLoadState.DISMISSED;
            if (this.gme != null && !z) {
                this.gme.onAdDismiss();
            }
        }

        @Override // com.baidu.mobads.SplashAdListener
        public void onAdFailed(String str) {
            b.this.gmb = AdLoadState.FAILED;
            com.baidu.tieba.advert.sdk.b.a.bMI().b(this.gme);
        }

        @Override // com.baidu.mobads.SplashAdListener
        public void onAdClick() {
            if (this.gme != null) {
                this.gme.f(b.this.glW == RsplashType.VIDEO, 1 == b.this.mPattern, 1);
            }
        }

        @Override // com.baidu.mobads.SplashAdListener
        public void onADLoaded(RsplashType rsplashType, int i) {
            b.this.gmb = AdLoadState.SUCCEED;
            if (b.this.glZ != null && b.this.gma != null) {
                b.this.glW = rsplashType;
                if (b.this.glZ != null && b.this.glZ.getExtData() != null) {
                    HashMap extData = b.this.glZ.getExtData();
                    Object obj = extData.get("custom_ext_data");
                    Object obj2 = extData.get("pattern");
                    if (obj2 != null) {
                        b.this.mPattern = com.baidu.adp.lib.f.b.toInt(obj2.toString(), 1);
                    }
                    if (obj != null) {
                        b.this.glY.parseJsonStr(obj.toString());
                    }
                }
                int i2 = b.this.glY.duration;
                if (rsplashType == RsplashType.VIDEO) {
                    if (i2 >= 3) {
                        b.this.glX = i2;
                    } else {
                        b.this.gmb = AdLoadState.FAILED;
                    }
                } else if (i2 < 3 || i2 > 5) {
                    b.this.glX = 3;
                } else {
                    b.this.glX = i2;
                }
                com.baidu.tieba.advert.sdk.b.a.bMI().b(this.gme);
            }
        }
    }
}
