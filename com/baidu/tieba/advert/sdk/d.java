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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.advert.sdk.data.AdLoadState;
import com.baidu.tieba.advert.sdk.data.AdSplashStyle;
import com.baidu.tieba.advert.sdk.widget.CountDownTextView;
import com.baidu.tieba.recapp.lego.model.AdCard;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class d implements com.baidu.tieba.advert.sdk.b.b {
    private RsplashType glW;
    private SplashAd glZ;
    private WeakReference<ViewGroup> gma;
    private int glX = 5;
    private int mPattern = 1;
    private final AdSplashStyle glY = new AdSplashStyle();
    private AdLoadState gmb = AdLoadState.INIT;
    private com.baidu.tbadk.g.b gmc = new com.baidu.tbadk.g.b() { // from class: com.baidu.tieba.advert.sdk.d.1
        @Override // com.baidu.tbadk.g.b
        public void bkr() {
            d.this.bMB();
        }
    };

    @Override // com.baidu.tieba.advert.sdk.b.b
    public AdLoadState bMz() {
        return this.gmb;
    }

    @Override // com.baidu.tieba.advert.sdk.b.b
    public String bMA() {
        return AdCard.CHARGE_STYLE_CPC;
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
                this.glZ = new SplashAd(context, bks, anonymousClass2, "7352842", true, null, 1000, false, true);
                this.gmb = AdLoadState.LOADING;
                this.glZ.load();
            } catch (OutOfMemoryError e) {
                TbadkCoreApplication.getInst().onLowMemory();
                bkt.zC("oom");
            }
        }
    }

    /* renamed from: com.baidu.tieba.advert.sdk.d$2  reason: invalid class name */
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
            boolean z = 1 == d.this.mPattern;
            if (this.gme != null) {
                this.gme.e(d.this.glW == RsplashType.VIDEO, z, 7);
            }
            TiebaStatic.log(new ar("c14006").aq("obj_source", 7).dR("obj_type", "a064").aq("obj_locate", 0));
            ViewGroup viewGroup = (ViewGroup) d.this.gma.get();
            if (viewGroup != null) {
                Context context = viewGroup.getContext();
                CountDownTextView countDownTextView = new CountDownTextView(context);
                countDownTextView.setGravity(17);
                countDownTextView.setNumTypeFromBes(true);
                countDownTextView.aF(context.getResources().getString(R.string.ad_skip), d.this.glX);
                com.baidu.tbadk.core.elementsMaven.c.br(countDownTextView).oh(R.string.AD_J_X45).oa(R.dimen.tbds42).nZ(R.color.CAM_X0101).setBackGroundColor(R.color.black_alpha20);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getDimens(context, R.dimen.tbds216), l.getDimens(context, R.dimen.tbds90));
                com.baidu.tieba.advert.sdk.d.a.a(layoutParams, AdSplashStyle.SplashElement.SKIP, d.this.glY, z);
                viewGroup.addView(countDownTextView, layoutParams);
                countDownTextView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.d.2.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tieba.advert.sdk.d.a.bMQ();
                    }
                });
                countDownTextView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.d.2.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tieba.advert.sdk.d.a.bMQ();
                    }
                });
                countDownTextView.setTimeoutListener(new CountDownTextView.c() { // from class: com.baidu.tieba.advert.sdk.d.2.3
                    @Override // com.baidu.tieba.advert.sdk.widget.CountDownTextView.c
                    public void cf(View view) {
                        boolean z2 = d.this.gmb == AdLoadState.DISMISSED;
                        d.this.gmb = AdLoadState.DISMISSED;
                        if (AnonymousClass2.this.gme != null && !z2) {
                            d.this.destroy();
                            AnonymousClass2.this.gme.onAdDismiss();
                        }
                    }
                });
                countDownTextView.setTimerChangedListener(new CountDownTextView.a() { // from class: com.baidu.tieba.advert.sdk.d.2.4
                    @Override // com.baidu.tieba.advert.sdk.widget.CountDownTextView.a
                    public void ti(int i) {
                        if (i == 1 && d.this.glW != null && d.this.glW != RsplashType.VIDEO) {
                            e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.advert.sdk.d.2.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    boolean z2 = d.this.gmb == AdLoadState.DISMISSED;
                                    d.this.gmb = AdLoadState.DISMISSED;
                                    if (AnonymousClass2.this.gme != null && !z2) {
                                        d.this.destroy();
                                        AnonymousClass2.this.gme.onAdDismiss();
                                    }
                                }
                            }, 300L);
                        }
                    }
                });
                if (!TextUtils.isEmpty(d.this.glY.labelName)) {
                    TextView textView = new TextView(context);
                    textView.setGravity(17);
                    textView.setText(d.this.glY.labelName);
                    com.baidu.tbadk.core.elementsMaven.c.br(textView).oh(R.string.AD_J_X09).oa(R.dimen.tbds36).nZ(R.color.CAM_X0101).setBackGroundColor(R.color.black_alpha20);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(l.getDimens(context, R.dimen.tbds105), l.getDimens(context, R.dimen.tbds63));
                    com.baidu.tieba.advert.sdk.d.a.a(layoutParams2, AdSplashStyle.SplashElement.LABEL, d.this.glY, z);
                    viewGroup.addView(textView, layoutParams2);
                }
                if (z) {
                    int dimens = l.getDimens(context, R.dimen.tbds90);
                    ImageView imageView = new ImageView(context);
                    imageView.setScaleType(ImageView.ScaleType.CENTER);
                    imageView.setImageResource(d.this.glY.bMD() ? R.drawable.bg_bes_splash_logo_white : R.drawable.bg_bes_splash_logo_blue);
                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, dimens);
                    com.baidu.tieba.advert.sdk.d.a.a(layoutParams3, AdSplashStyle.SplashElement.LOGO, d.this.glY, z);
                    viewGroup.addView(imageView, layoutParams3);
                }
            }
        }

        @Override // com.baidu.mobads.SplashAdListener
        public void onAdDismissed() {
            d.this.destroy();
            boolean z = d.this.gmb == AdLoadState.DISMISSED;
            d.this.gmb = AdLoadState.DISMISSED;
            if (this.gme != null && !z) {
                this.gme.onAdDismiss();
            }
        }

        @Override // com.baidu.mobads.SplashAdListener
        public void onAdFailed(String str) {
            d.this.gmb = AdLoadState.FAILED;
            com.baidu.tieba.advert.sdk.b.a.bMI().b(this.gme);
            TiebaStatic.log(new ar("c14006").aq("obj_source", 7).dR("obj_type", "a064").aq("obj_locate", 1));
        }

        @Override // com.baidu.mobads.SplashAdListener
        public void onAdClick() {
            if (this.gme != null) {
                this.gme.f(d.this.glW == RsplashType.VIDEO, 1 == d.this.mPattern, 7);
            }
        }

        @Override // com.baidu.mobads.SplashAdListener
        public void onADLoaded(RsplashType rsplashType, int i) {
            d.this.gmb = AdLoadState.SUCCEED;
            if (d.this.glZ != null && d.this.gma != null) {
                d.this.glW = rsplashType;
                d.this.mPattern = 0;
                int i2 = i / 1000;
                if (rsplashType != RsplashType.VIDEO) {
                    d.this.glX = 3;
                } else {
                    if (i2 < 3 || i2 > 5) {
                        i2 = 5;
                    }
                    d.this.glX = i2;
                }
                com.baidu.tieba.advert.sdk.b.a.bMI().b(this.gme);
            }
        }
    }
}
