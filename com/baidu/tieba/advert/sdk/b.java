package com.baidu.tieba.advert.sdk;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
/* loaded from: classes8.dex */
public class b {
    private RsplashType gkt;
    private SplashAd gkw;
    private WeakReference<ViewGroup> gkx;
    private c gkz;
    private int gku = 5;
    private int mPattern = 1;
    private final AdSplashStyle gkv = new AdSplashStyle();
    private AdLoadState gky = AdLoadState.INIT;
    private com.baidu.tbadk.g.b gkA = new com.baidu.tbadk.g.b() { // from class: com.baidu.tieba.advert.sdk.b.1
        @Override // com.baidu.tbadk.g.b
        public void bkp() {
            b.this.bMw();
        }
    };
    private CustomMessageTask gkB = new CustomMessageTask(CmdConfigCustom.CMD_START_REQUEST_BES_AD, new CustomMessageTask.CustomRunnable<com.baidu.tbadk.g.c>() { // from class: com.baidu.tieba.advert.sdk.b.2
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<com.baidu.tbadk.g.c> customMessage) {
            if (customMessage != null) {
                b.this.b(customMessage.getData());
                b.this.a(customMessage.getData());
            }
            return null;
        }
    });

    public AdLoadState bMv() {
        return this.gky;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMw() {
        if (this.gkx != null && this.gkx.get().getParent() != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gkx.get().getLayoutParams();
            if (1 != this.mPattern) {
                layoutParams.width = l.getEquipmentWidth(this.gkx.get().getContext());
                layoutParams.height = (int) (l.getEquipmentHeight(this.gkx.get().getContext()) * 0.8125d);
            } else {
                layoutParams.width = -1;
                layoutParams.height = -1;
            }
            this.gkx.get().setLayoutParams(layoutParams);
        }
    }

    public b() {
        bMx();
    }

    private void bMx() {
    }

    public void registerTask() {
        this.gkB.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.gkB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tbadk.g.c cVar) {
        if (cVar != null && cVar.bkq() != null && cVar.bkq().getContext() != null) {
            this.gkz = new c(this);
            this.gkz.b(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tbadk.g.c cVar) {
        if (cVar != null && cVar.bkq() != null && cVar.bkq().getContext() != null) {
            cVar.eHh = this.gkA;
            com.baidu.tbadk.g.a bkr = cVar.bkr();
            this.gkx = new WeakReference<>(cVar.bkq());
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(bkr);
            try {
                Context context = cVar.bkq().getContext();
                ViewGroup bkq = cVar.bkq();
                new RequestParameters.Builder().setHeight(l.getEquipmentWidth(context)).setWidth(l.getEquipmentHeight(context)).build();
                this.gkw = new SplashAd(context, bkq, anonymousClass3, "4776976", true, null, 1000, false, true);
                this.gky = AdLoadState.LOADING;
                this.gkw.load();
            } catch (OutOfMemoryError e) {
                TbadkCoreApplication.getInst().onLowMemory();
                bkr.zv("oom");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.advert.sdk.b$3  reason: invalid class name */
    /* loaded from: classes8.dex */
    public class AnonymousClass3 implements SplashLpCloseListener {
        final /* synthetic */ com.baidu.tbadk.g.a gkD;

        AnonymousClass3(com.baidu.tbadk.g.a aVar) {
            this.gkD = aVar;
        }

        @Override // com.baidu.mobads.SplashLpCloseListener
        public void onLpClosed() {
        }

        @Override // com.baidu.mobads.SplashAdListener
        public void onAdPresent() {
            boolean z = 1 == b.this.mPattern;
            if (this.gkD != null) {
                this.gkD.e(b.this.gkt == RsplashType.VIDEO, z, 1);
            }
            ViewGroup viewGroup = (ViewGroup) b.this.gkx.get();
            if (viewGroup != null) {
                Context context = viewGroup.getContext();
                CountDownTextView countDownTextView = new CountDownTextView(context);
                countDownTextView.setGravity(17);
                countDownTextView.setNumTypeFromBes(true);
                countDownTextView.aE(context.getResources().getString(R.string.ad_skip), b.this.gku);
                com.baidu.tbadk.core.elementsMaven.c.br(countDownTextView).og(R.string.AD_J_X45).nZ(R.dimen.tbds42).nY(R.color.CAM_X0101).setBackGroundColor(R.color.black_alpha20);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.getDimens(context, R.dimen.tbds216), l.getDimens(context, R.dimen.tbds90));
                com.baidu.tieba.advert.sdk.c.a.a(layoutParams, AdSplashStyle.SplashElement.SKIP, b.this.gkv, z);
                viewGroup.addView(countDownTextView, layoutParams);
                countDownTextView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.b.3.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        com.baidu.tieba.advert.sdk.c.a.bMK();
                    }
                });
                countDownTextView.setTimeoutListener(new CountDownTextView.c() { // from class: com.baidu.tieba.advert.sdk.b.3.2
                    @Override // com.baidu.tieba.advert.sdk.widget.CountDownTextView.c
                    public void cf(View view) {
                        boolean z2 = b.this.gky == AdLoadState.DISMISSED;
                        if (AnonymousClass3.this.gkD != null && !z2) {
                            b.this.bMz();
                            AnonymousClass3.this.gkD.onAdDismiss();
                        }
                        b.this.gky = AdLoadState.DISMISSED;
                    }
                });
                countDownTextView.setTimerChangedListener(new CountDownTextView.a() { // from class: com.baidu.tieba.advert.sdk.b.3.3
                    @Override // com.baidu.tieba.advert.sdk.widget.CountDownTextView.a
                    public void tg(int i) {
                        if (i == 1 && b.this.gkt != null && b.this.gkt != RsplashType.VIDEO) {
                            e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.advert.sdk.b.3.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    boolean z2 = b.this.gky == AdLoadState.DISMISSED;
                                    if (AnonymousClass3.this.gkD != null && !z2) {
                                        b.this.bMz();
                                        AnonymousClass3.this.gkD.onAdDismiss();
                                    }
                                    b.this.gky = AdLoadState.DISMISSED;
                                }
                            }, 300L);
                        }
                    }
                });
                if (!TextUtils.isEmpty(b.this.gkv.labelName)) {
                    TextView textView = new TextView(context);
                    textView.setGravity(17);
                    textView.setText(b.this.gkv.labelName);
                    com.baidu.tbadk.core.elementsMaven.c.br(textView).og(R.string.AD_J_X09).nZ(R.dimen.tbds36).nY(R.color.CAM_X0101).setBackGroundColor(R.color.black_alpha20);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(l.getDimens(context, R.dimen.tbds105), l.getDimens(context, R.dimen.tbds63));
                    com.baidu.tieba.advert.sdk.c.a.a(layoutParams2, AdSplashStyle.SplashElement.LABEL, b.this.gkv, z);
                    viewGroup.addView(textView, layoutParams2);
                }
                if (z) {
                    int dimens = l.getDimens(context, R.dimen.tbds90);
                    ImageView imageView = new ImageView(context);
                    imageView.setScaleType(ImageView.ScaleType.CENTER);
                    imageView.setImageResource(b.this.gkv.bMA() ? R.drawable.bg_bes_splash_logo_white : R.drawable.bg_bes_splash_logo_blue);
                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, dimens);
                    com.baidu.tieba.advert.sdk.c.a.a(layoutParams3, AdSplashStyle.SplashElement.LOGO, b.this.gkv, z);
                    viewGroup.addView(imageView, layoutParams3);
                }
            }
        }

        @Override // com.baidu.mobads.SplashAdListener
        public void onAdDismissed() {
            b.this.bMz();
            boolean z = b.this.gky == AdLoadState.DISMISSED;
            b.this.gky = AdLoadState.DISMISSED;
            if (this.gkD != null && !z) {
                this.gkD.onAdDismiss();
            }
        }

        @Override // com.baidu.mobads.SplashAdListener
        public void onAdFailed(String str) {
            b.this.gky = AdLoadState.FAILED;
            b.this.bMz();
            if (b.this.gkz != null) {
                if (b.this.gkz.bMv() == AdLoadState.SUCCEED) {
                    b.this.gkz.bMy();
                } else if (b.this.gkz.bMv() == AdLoadState.FAILED && this.gkD != null) {
                    this.gkD.zv(str);
                }
            } else if (this.gkD != null) {
                this.gkD.zv(str);
            }
        }

        @Override // com.baidu.mobads.SplashAdListener
        public void onAdClick() {
            if (this.gkD != null) {
                this.gkD.f(b.this.gkt == RsplashType.VIDEO, 1 == b.this.mPattern, 1);
            }
        }

        @Override // com.baidu.mobads.SplashAdListener
        public void onADLoaded(RsplashType rsplashType, int i) {
            b.this.gky = AdLoadState.SUCCEED;
            if (b.this.gkw != null && b.this.gkx != null) {
                b.this.gkt = rsplashType;
                if (b.this.gkw != null && b.this.gkw.getExtData() != null) {
                    HashMap extData = b.this.gkw.getExtData();
                    Object obj = extData.get("custom_ext_data");
                    Object obj2 = extData.get("pattern");
                    if (obj2 != null) {
                        b.this.mPattern = com.baidu.adp.lib.f.b.toInt(obj2.toString(), 1);
                    }
                    if (obj != null) {
                        b.this.gkv.parseJsonStr(obj.toString());
                    }
                }
                int i2 = b.this.gkv.duration;
                if (rsplashType == RsplashType.VIDEO) {
                    if (i2 >= 3) {
                        b.this.gku = i2;
                        b.this.bMy();
                        return;
                    }
                    b.this.gky = AdLoadState.FAILED;
                    return;
                }
                if (i2 < 3 || i2 > 5) {
                    b.this.gku = 3;
                } else {
                    b.this.gku = i2;
                }
                b.this.bMy();
            }
        }
    }

    public void bMy() {
        if (this.gkw != null && this.gkx != null && this.gky == AdLoadState.SUCCEED) {
            bMw();
            if (1 == this.mPattern) {
            }
            this.gky = AdLoadState.SHOWED;
            this.gkw.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMz() {
        if (this.gkw != null) {
            this.gkw.destroy();
        }
    }
}
