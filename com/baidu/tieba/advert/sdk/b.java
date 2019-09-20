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
    private int dbQ;
    private Float dbR;
    private RsplashType dbT;
    private WeakReference<ViewGroup> dbU;
    private int dbP = 5;
    private int dbS = -1;
    private com.baidu.tbadk.g.b dbV = new com.baidu.tbadk.g.b() { // from class: com.baidu.tieba.advert.sdk.b.1
        @Override // com.baidu.tbadk.g.b
        public void onScreenSizeChanged() {
            if (b.this.dbU != null && ((ViewGroup) b.this.dbU.get()).getParent() != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ((ViewGroup) b.this.dbU.get()).getLayoutParams();
                if (1 != b.this.dbQ) {
                    layoutParams.width = l.af(((ViewGroup) b.this.dbU.get()).getContext());
                    layoutParams.height = (int) (l.ah(((ViewGroup) b.this.dbU.get()).getContext()) * 0.8125d);
                } else {
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                }
                ((ViewGroup) b.this.dbU.get()).setLayoutParams(layoutParams);
            }
        }
    };
    private CustomMessageTask dbW = new CustomMessageTask(2016555, new CustomMessageTask.CustomRunnable<c>() { // from class: com.baidu.tieba.advert.sdk.b.2
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<c> customMessage) {
            if (customMessage != null) {
                b.this.a(customMessage.getData());
            }
            return null;
        }
    });

    public b() {
        aEv();
    }

    private void aEv() {
        e.ay(TbadkCoreApplication.getInst()).newAdContext().setAdServerRequestingTimeout(1000);
    }

    public void registerTask() {
        this.dbW.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(this.dbW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar) {
        if (cVar != null && cVar.aaY() != null && cVar.aaY().getContext() != null) {
            cVar.bCg = this.dbV;
            final com.baidu.tbadk.g.a aaZ = cVar.aaZ();
            this.dbU = new WeakReference<>(cVar.aaY());
            try {
                new d(cVar.aaY().getContext(), cVar.aaY(), new com.baidu.mobads.e() { // from class: com.baidu.tieba.advert.sdk.b.3
                    @Override // com.baidu.mobads.e
                    public void uz() {
                        int i;
                        if (b.this.dbU.get() != null) {
                            Context context = ((ViewGroup) b.this.dbU.get()).getContext();
                            int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.ds60);
                            int af = l.af(context);
                            int ah = l.ah(context);
                            int i2 = (int) (af * 0.18f);
                            int i3 = (i2 * 48) / 195;
                            int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R.dimen.ds144);
                            int dimensionPixelOffset3 = context.getResources().getDimensionPixelOffset(R.dimen.ds60);
                            if (b.this.dbR.floatValue() > 0.0f) {
                                dimensionPixelOffset = (int) (((ah * b.this.dbR.floatValue()) / 100.0f) - (dimensionPixelOffset3 / 2));
                                i = (int) (((ah * b.this.dbR.floatValue()) / 100.0f) - (i3 / 2));
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
                            countDownTextView.aj(string, b.this.dbP);
                            countDownTextView.setTextColor(-1);
                            countDownTextView.setGravity(17);
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimensionPixelOffset2, dimensionPixelOffset3);
                            layoutParams.addRule(10);
                            layoutParams.addRule(11);
                            layoutParams.setMargins(0, dimensionPixelOffset, 45, 0);
                            ((ViewGroup) b.this.dbU.get()).addView(countDownTextView, layoutParams);
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
                            if (b.this.dbS != -1) {
                                ImageView imageView = new ImageView(context);
                                imageView.setBackgroundResource(R.drawable.bg_bes_splash_logo_white);
                                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i2, i3);
                                layoutParams2.addRule(10);
                                layoutParams2.addRule(9);
                                layoutParams2.setMargins(45, i, 0, 0);
                                ((ViewGroup) b.this.dbU.get()).addView(imageView, layoutParams2);
                            }
                        }
                        if (aaZ != null) {
                            aaZ.j(b.this.dbT == RsplashType.VIDEO, 1 == b.this.dbQ);
                        }
                    }

                    @Override // com.baidu.mobads.e
                    public void uA() {
                        if (aaZ != null) {
                            aaZ.aaX();
                        }
                    }

                    @Override // com.baidu.mobads.e
                    public void cO(String str) {
                        if (aaZ != null) {
                            aaZ.lD(str);
                        }
                    }

                    @Override // com.baidu.mobads.e
                    public void uB() {
                        if (aaZ != null) {
                            aaZ.k(b.this.dbT == RsplashType.VIDEO, 1 == b.this.dbQ);
                        }
                    }

                    @Override // com.baidu.mobads.e
                    public void a(RsplashType rsplashType, int i) {
                        b.this.dbT = rsplashType;
                        int i2 = i / 1000;
                        if (rsplashType != RsplashType.VIDEO) {
                            b.this.dbP = 3;
                            return;
                        }
                        if (i2 < 3 || i2 > 5) {
                            i2 = 5;
                        }
                        b.this.dbP = i2;
                    }

                    @Override // com.baidu.mobads.e
                    public void l(HashMap hashMap) {
                        b.this.dbQ = ((Integer) hashMap.get(d.agY)).intValue();
                        b.this.dbR = (Float) hashMap.get(d.agZ);
                        if (b.this.dbU != null) {
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                            if (1 != b.this.dbQ) {
                                layoutParams.width = l.af(((ViewGroup) b.this.dbU.get()).getContext());
                                layoutParams.height = (int) (l.ah(((ViewGroup) b.this.dbU.get()).getContext()) * 0.8125d);
                            }
                            ((ViewGroup) b.this.dbU.get()).setLayoutParams(layoutParams);
                        }
                    }
                }, "4776976", true);
            } catch (OutOfMemoryError e) {
                TbadkCoreApplication.getInst().onLowMemory();
                aaZ.lD("oom");
            }
        }
    }
}
