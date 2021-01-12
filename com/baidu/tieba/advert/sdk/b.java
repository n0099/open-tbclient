package com.baidu.tieba.advert.sdk;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.l;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.mobad.video.XAdManager;
import com.baidu.mobads.RsplashType;
import com.baidu.mobads.SplashAd;
import com.baidu.mobads.SplashAdListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.g.e;
import com.baidu.tieba.R;
import com.baidu.tieba.advert.sdk.widget.CountDownTextView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class b {
    private Float ghS;
    private RsplashType ghU;
    private WeakReference<ViewGroup> ghV;
    private int mPattern;
    private int ghR = 5;
    private int ghT = -1;
    private com.baidu.tbadk.g.b ghW = new com.baidu.tbadk.g.b() { // from class: com.baidu.tieba.advert.sdk.b.1
        @Override // com.baidu.tbadk.g.b
        public void bjV() {
            if (b.this.ghV != null && ((ViewGroup) b.this.ghV.get()).getParent() != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ((ViewGroup) b.this.ghV.get()).getLayoutParams();
                if (1 != b.this.mPattern) {
                    layoutParams.width = l.getEquipmentWidth(((ViewGroup) b.this.ghV.get()).getContext());
                    layoutParams.height = (int) (l.getEquipmentHeight(((ViewGroup) b.this.ghV.get()).getContext()) * 0.8125d);
                } else {
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                }
                ((ViewGroup) b.this.ghV.get()).setLayoutParams(layoutParams);
            }
        }
    };
    private CustomMessageTask ghX = new CustomMessageTask(CmdConfigCustom.CMD_START_REQUEST_BES_AD, new CustomMessageTask.CustomRunnable<e>() { // from class: com.baidu.tieba.advert.sdk.b.2
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<e> customMessage) {
            if (customMessage != null) {
                b.this.a(customMessage.getData());
            }
            return null;
        }
    });

    public b() {
        bLU();
    }

    private void bLU() {
        XAdManager.getInstance(TbadkCoreApplication.getInst()).newAdContext().setAdServerRequestingTimeout(1000);
    }

    public void registerTask() {
        this.ghX.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.ghX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar) {
        if (eVar != null && eVar.bjX() != null && eVar.bjX().getContext() != null) {
            eVar.eFb = this.ghW;
            final com.baidu.tbadk.g.a bjZ = eVar.bjZ();
            this.ghV = new WeakReference<>(eVar.bjX());
            try {
                new SplashAd(eVar.bjX().getContext(), eVar.bjX(), new SplashAdListener() { // from class: com.baidu.tieba.advert.sdk.b.3
                    @Override // com.baidu.mobads.SplashAdListener
                    public void onAdPresent() {
                        int i;
                        int i2;
                        if (b.this.ghV.get() != null) {
                            Context context = ((ViewGroup) b.this.ghV.get()).getContext();
                            int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.ds60);
                            int equipmentWidth = l.getEquipmentWidth(context);
                            int equipmentHeight = l.getEquipmentHeight(context);
                            int i3 = (int) (equipmentWidth * 0.18f);
                            int i4 = (i3 * 48) / DownloadConstants.STATUS_WAITING_FOR_NETWORK;
                            int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R.dimen.ds144);
                            int dimensionPixelOffset3 = context.getResources().getDimensionPixelOffset(R.dimen.ds60);
                            if (b.this.ghS.floatValue() > 0.0f) {
                                i = (int) (((equipmentHeight * b.this.ghS.floatValue()) / 100.0f) - (dimensionPixelOffset3 / 2));
                                i2 = (int) (((equipmentHeight * b.this.ghS.floatValue()) / 100.0f) - (i4 / 2));
                            } else {
                                i = dimensionPixelOffset;
                                i2 = dimensionPixelOffset;
                            }
                            CountDownTextView countDownTextView = new CountDownTextView(context);
                            countDownTextView.setNumTypeFromBes(true);
                            int color = context.getResources().getColor(R.color.black_alpha20);
                            context.getResources().getColor(R.color.black_alpha20);
                            String string = context.getResources().getString(R.string.ad_skip);
                            countDownTextView.setTextSize(0, (int) context.getResources().getDimension(R.dimen.ds28));
                            GradientDrawable gradientDrawable = new GradientDrawable();
                            gradientDrawable.setColor(color);
                            gradientDrawable.setCornerRadius(context.getResources().getDimension(R.dimen.ds45));
                            countDownTextView.setBackgroundDrawable(gradientDrawable);
                            countDownTextView.aC(string, b.this.ghR);
                            countDownTextView.setTextColor(-1);
                            countDownTextView.setGravity(17);
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimensionPixelOffset2, dimensionPixelOffset3);
                            layoutParams.addRule(10);
                            layoutParams.addRule(11);
                            layoutParams.setMargins(0, i, 45, 0);
                            ((ViewGroup) b.this.ghV.get()).addView(countDownTextView, layoutParams);
                            countDownTextView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.b.3.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://ignore"));
                                }
                            });
                            countDownTextView.setTimeoutListener(new CountDownTextView.b() { // from class: com.baidu.tieba.advert.sdk.b.3.2
                                @Override // com.baidu.tieba.advert.sdk.widget.CountDownTextView.b
                                public void cj(View view) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ADVERT_SDK_SPLASH_CLICK, "advertevent://ignore"));
                                }
                            });
                            if (b.this.ghT != -1) {
                                ImageView imageView = new ImageView(context);
                                imageView.setBackgroundResource(R.drawable.bg_bes_splash_logo_white);
                                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i3, i4);
                                layoutParams2.addRule(10);
                                layoutParams2.addRule(9);
                                layoutParams2.setMargins(45, i2, 0, 0);
                                ((ViewGroup) b.this.ghV.get()).addView(imageView, layoutParams2);
                            }
                        }
                        if (bjZ != null) {
                            bjZ.v(b.this.ghU == RsplashType.VIDEO, 1 == b.this.mPattern);
                        }
                    }

                    @Override // com.baidu.mobads.SplashAdListener
                    public void onAdDismissed() {
                        if (bjZ != null) {
                            bjZ.onAdDismiss();
                        }
                    }

                    @Override // com.baidu.mobads.SplashAdListener
                    public void onAdFailed(String str) {
                        if (bjZ != null) {
                            bjZ.zd(str);
                        }
                    }

                    @Override // com.baidu.mobads.SplashAdListener
                    public void onAdClick() {
                        if (bjZ != null) {
                            bjZ.w(b.this.ghU == RsplashType.VIDEO, 1 == b.this.mPattern);
                        }
                    }

                    @Override // com.baidu.mobads.SplashAdListener
                    public void onAdTypeReady(RsplashType rsplashType, int i) {
                        b.this.ghU = rsplashType;
                        int i2 = i / 1000;
                        if (rsplashType != RsplashType.VIDEO) {
                            b.this.ghR = 3;
                            return;
                        }
                        if (i2 < 3 || i2 > 5) {
                            i2 = 5;
                        }
                        b.this.ghR = i2;
                    }

                    @Override // com.baidu.mobads.SplashAdListener
                    public void onAdLoaded(HashMap hashMap) {
                        b.this.mPattern = ((Integer) hashMap.get(SplashAd.RSPLASH_PATTERN)).intValue();
                        b.this.ghS = (Float) hashMap.get(SplashAd.RSPLASH_BTN_POS);
                        if (b.this.ghV != null) {
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                            if (1 != b.this.mPattern) {
                                layoutParams.width = l.getEquipmentWidth(((ViewGroup) b.this.ghV.get()).getContext());
                                layoutParams.height = (int) (l.getEquipmentHeight(((ViewGroup) b.this.ghV.get()).getContext()) * 0.8125d);
                            }
                            ((ViewGroup) b.this.ghV.get()).setLayoutParams(layoutParams);
                        }
                    }
                }, "4776976", true);
            } catch (OutOfMemoryError e) {
                TbadkCoreApplication.getInst().onLowMemory();
                bjZ.zd("oom");
            }
        }
    }
}
