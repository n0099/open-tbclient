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
    private int cZX;
    private Float cZY;
    private RsplashType daa;
    private WeakReference<ViewGroup> dab;
    private int cZW = 5;
    private int cZZ = -1;
    private com.baidu.tbadk.g.b dac = new com.baidu.tbadk.g.b() { // from class: com.baidu.tieba.advert.sdk.b.1
        @Override // com.baidu.tbadk.g.b
        public void onScreenSizeChanged() {
            if (b.this.dab != null && ((ViewGroup) b.this.dab.get()).getParent() != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ((ViewGroup) b.this.dab.get()).getLayoutParams();
                if (1 != b.this.cZX) {
                    layoutParams.width = l.af(((ViewGroup) b.this.dab.get()).getContext());
                    layoutParams.height = (int) (l.ah(((ViewGroup) b.this.dab.get()).getContext()) * 0.8125d);
                } else {
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                }
                ((ViewGroup) b.this.dab.get()).setLayoutParams(layoutParams);
            }
        }
    };
    private CustomMessageTask dad = new CustomMessageTask(2016555, new CustomMessageTask.CustomRunnable<c>() { // from class: com.baidu.tieba.advert.sdk.b.2
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<c> customMessage) {
            if (customMessage != null) {
                b.this.a(customMessage.getData());
            }
            return null;
        }
    });

    public b() {
        aDP();
    }

    private void aDP() {
        e.ay(TbadkCoreApplication.getInst()).newAdContext().setAdServerRequestingTimeout(1000);
    }

    public void registerTask() {
        this.dad.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.dad);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        if (cVar != null && cVar.aaU() != null && cVar.aaU().getContext() != null) {
            cVar.bBI = this.dac;
            final com.baidu.tbadk.g.a aaV = cVar.aaV();
            this.dab = new WeakReference<>(cVar.aaU());
            try {
                new d(cVar.aaU().getContext(), cVar.aaU(), new com.baidu.mobads.e() { // from class: com.baidu.tieba.advert.sdk.b.3
                    @Override // com.baidu.mobads.e
                    public void uv() {
                        int i;
                        if (b.this.dab.get() != null) {
                            Context context = ((ViewGroup) b.this.dab.get()).getContext();
                            int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.ds60);
                            int af = l.af(context);
                            int ah = l.ah(context);
                            int i2 = (int) (af * 0.18f);
                            int i3 = (i2 * 48) / 195;
                            int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R.dimen.ds144);
                            int dimensionPixelOffset3 = context.getResources().getDimensionPixelOffset(R.dimen.ds60);
                            if (b.this.cZY.floatValue() > 0.0f) {
                                dimensionPixelOffset = (int) (((ah * b.this.cZY.floatValue()) / 100.0f) - (dimensionPixelOffset3 / 2));
                                i = (int) (((ah * b.this.cZY.floatValue()) / 100.0f) - (i3 / 2));
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
                            countDownTextView.ah(string, b.this.cZW);
                            countDownTextView.setTextColor(-1);
                            countDownTextView.setGravity(17);
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimensionPixelOffset2, dimensionPixelOffset3);
                            layoutParams.addRule(10);
                            layoutParams.addRule(11);
                            layoutParams.setMargins(0, dimensionPixelOffset, 45, 0);
                            ((ViewGroup) b.this.dab.get()).addView(countDownTextView, layoutParams);
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
                            if (b.this.cZZ != -1) {
                                ImageView imageView = new ImageView(context);
                                imageView.setBackgroundResource(R.drawable.bg_bes_splash_logo_white);
                                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i2, i3);
                                layoutParams2.addRule(10);
                                layoutParams2.addRule(9);
                                layoutParams2.setMargins(45, i, 0, 0);
                                ((ViewGroup) b.this.dab.get()).addView(imageView, layoutParams2);
                            }
                        }
                        if (aaV != null) {
                            aaV.j(b.this.daa == RsplashType.VIDEO, 1 == b.this.cZX);
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
                            aaV.k(b.this.daa == RsplashType.VIDEO, 1 == b.this.cZX);
                        }
                    }

                    @Override // com.baidu.mobads.e
                    public void a(RsplashType rsplashType, int i) {
                        b.this.daa = rsplashType;
                        int i2 = i / 1000;
                        if (rsplashType != RsplashType.VIDEO) {
                            b.this.cZW = 3;
                            return;
                        }
                        if (i2 < 3 || i2 > 5) {
                            i2 = 5;
                        }
                        b.this.cZW = i2;
                    }

                    @Override // com.baidu.mobads.e
                    public void l(HashMap hashMap) {
                        b.this.cZX = ((Integer) hashMap.get(d.agC)).intValue();
                        b.this.cZY = (Float) hashMap.get(d.agD);
                        if (b.this.dab != null) {
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                            if (1 != b.this.cZX) {
                                layoutParams.width = l.af(((ViewGroup) b.this.dab.get()).getContext());
                                layoutParams.height = (int) (l.ah(((ViewGroup) b.this.dab.get()).getContext()) * 0.8125d);
                            }
                            ((ViewGroup) b.this.dab.get()).setLayoutParams(layoutParams);
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
