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
import com.baidu.mobad.a.e;
import com.baidu.mobads.RsplashType;
import com.baidu.mobads.d;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.g.c;
import com.baidu.tieba.R;
import com.baidu.tieba.advert.sdk.widget.CountDownTextView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class b {
    private int dae;
    private Float daf;
    private RsplashType dah;
    private WeakReference<ViewGroup> dai;
    private int dad = 5;
    private int dag = -1;
    private com.baidu.tbadk.g.b daj = new com.baidu.tbadk.g.b() { // from class: com.baidu.tieba.advert.sdk.b.1
        @Override // com.baidu.tbadk.g.b
        public void onScreenSizeChanged() {
            if (b.this.dai != null && ((ViewGroup) b.this.dai.get()).getParent() != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ((ViewGroup) b.this.dai.get()).getLayoutParams();
                if (1 != b.this.dae) {
                    layoutParams.width = l.af(((ViewGroup) b.this.dai.get()).getContext());
                    layoutParams.height = (int) (l.ah(((ViewGroup) b.this.dai.get()).getContext()) * 0.8125d);
                } else {
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                }
                ((ViewGroup) b.this.dai.get()).setLayoutParams(layoutParams);
            }
        }
    };
    private CustomMessageTask dak = new CustomMessageTask(2016555, new CustomMessageTask.CustomRunnable<c>() { // from class: com.baidu.tieba.advert.sdk.b.2
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<c> customMessage) {
            if (customMessage != null) {
                b.this.a(customMessage.getData());
            }
            return null;
        }
    });

    public b() {
        aDR();
    }

    private void aDR() {
        e.ay(TbadkCoreApplication.getInst()).newAdContext().setAdServerRequestingTimeout(1000);
    }

    public void registerTask() {
        this.dak.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.dak);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        if (cVar != null && cVar.aaU() != null && cVar.aaU().getContext() != null) {
            cVar.bBI = this.daj;
            final com.baidu.tbadk.g.a aaV = cVar.aaV();
            this.dai = new WeakReference<>(cVar.aaU());
            try {
                new d(cVar.aaU().getContext(), cVar.aaU(), new com.baidu.mobads.e() { // from class: com.baidu.tieba.advert.sdk.b.3
                    @Override // com.baidu.mobads.e
                    public void uv() {
                        int i;
                        if (b.this.dai.get() != null) {
                            Context context = ((ViewGroup) b.this.dai.get()).getContext();
                            int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.ds60);
                            int af = l.af(context);
                            int ah = l.ah(context);
                            int i2 = (int) (af * 0.18f);
                            int i3 = (i2 * 48) / 195;
                            int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R.dimen.ds144);
                            int dimensionPixelOffset3 = context.getResources().getDimensionPixelOffset(R.dimen.ds60);
                            if (b.this.daf.floatValue() > 0.0f) {
                                dimensionPixelOffset = (int) (((ah * b.this.daf.floatValue()) / 100.0f) - (dimensionPixelOffset3 / 2));
                                i = (int) (((ah * b.this.daf.floatValue()) / 100.0f) - (i3 / 2));
                            } else {
                                i = dimensionPixelOffset;
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
                            countDownTextView.ah(string, b.this.dad);
                            countDownTextView.setTextColor(-1);
                            countDownTextView.setGravity(17);
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimensionPixelOffset2, dimensionPixelOffset3);
                            layoutParams.addRule(10);
                            layoutParams.addRule(11);
                            layoutParams.setMargins(0, dimensionPixelOffset, 45, 0);
                            ((ViewGroup) b.this.dai.get()).addView(countDownTextView, layoutParams);
                            countDownTextView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.advert.sdk.b.3.1
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, "advertevent://ignore"));
                                }
                            });
                            countDownTextView.setTimeoutListener(new CountDownTextView.b() { // from class: com.baidu.tieba.advert.sdk.b.3.2
                                @Override // com.baidu.tieba.advert.sdk.widget.CountDownTextView.b
                                public void bp(View view) {
                                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016311, "advertevent://ignore"));
                                }
                            });
                            if (b.this.dag != -1) {
                                ImageView imageView = new ImageView(context);
                                imageView.setBackgroundResource(R.drawable.bg_bes_splash_logo_white);
                                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i2, i3);
                                layoutParams2.addRule(10);
                                layoutParams2.addRule(9);
                                layoutParams2.setMargins(45, i, 0, 0);
                                ((ViewGroup) b.this.dai.get()).addView(imageView, layoutParams2);
                            }
                        }
                        if (aaV != null) {
                            aaV.j(b.this.dah == RsplashType.VIDEO, 1 == b.this.dae);
                        }
                    }

                    @Override // com.baidu.mobads.e
                    public void uw() {
                        if (aaV != null) {
                            aaV.aaT();
                        }
                    }

                    @Override // com.baidu.mobads.e
                    public void cM(String str) {
                        if (aaV != null) {
                            aaV.lB(str);
                        }
                    }

                    @Override // com.baidu.mobads.e
                    public void ux() {
                        if (aaV != null) {
                            aaV.k(b.this.dah == RsplashType.VIDEO, 1 == b.this.dae);
                        }
                    }

                    @Override // com.baidu.mobads.e
                    public void a(RsplashType rsplashType, int i) {
                        b.this.dah = rsplashType;
                        int i2 = i / 1000;
                        if (rsplashType != RsplashType.VIDEO) {
                            b.this.dad = 3;
                            return;
                        }
                        if (i2 < 3 || i2 > 5) {
                            i2 = 5;
                        }
                        b.this.dad = i2;
                    }

                    @Override // com.baidu.mobads.e
                    public void l(HashMap hashMap) {
                        b.this.dae = ((Integer) hashMap.get(d.agC)).intValue();
                        b.this.daf = (Float) hashMap.get(d.agD);
                        if (b.this.dai != null) {
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                            if (1 != b.this.dae) {
                                layoutParams.width = l.af(((ViewGroup) b.this.dai.get()).getContext());
                                layoutParams.height = (int) (l.ah(((ViewGroup) b.this.dai.get()).getContext()) * 0.8125d);
                            }
                            ((ViewGroup) b.this.dai.get()).setLayoutParams(layoutParams);
                        }
                    }
                }, "4776976", true);
            } catch (OutOfMemoryError e) {
                TbadkCoreApplication.getInst().onLowMemory();
                aaV.lB("oom");
            }
        }
    }
}
