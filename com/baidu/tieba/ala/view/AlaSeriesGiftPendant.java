package com.baidu.tieba.ala.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.ah;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.view.HeadImageView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaSeriesGiftPendant extends LinearLayout implements View.OnClickListener {
    public static volatile boolean hMb = true;
    public static volatile boolean hMc = false;
    private FrameLayout container;
    Context context;
    private final int hLW;
    private final int hLX;
    private final int hLY;
    private final int hLZ;
    a hMA;
    private final int hMa;
    public volatile int hMd;
    private volatile boolean hMe;
    private volatile boolean hMf;
    private volatile boolean hMg;
    private LinearLayout hMh;
    private LinearLayout hMi;
    private LinearLayout hMj;
    private HeadImageView hMk;
    private HeadImageView hMl;
    private HeadImageView hMm;
    private HeadImageView hMn;
    private AnimatorSet hMo;
    private AnimatorSet hMp;
    private TextView hMq;
    private Button hMr;
    private volatile boolean hMs;
    private boolean hMt;
    private boolean hMu;
    private int hMv;
    private int hMw;
    com.baidu.tieba.ala.data.j hMx;
    com.baidu.tieba.ala.data.k[] hMy;
    HashMap<Integer, HeadImageView> hMz;
    boolean isHost;
    private View mView;
    private TextView titleText;

    public AlaSeriesGiftPendant(Context context, boolean z, String str) {
        super(context);
        this.hLW = 4;
        this.hLX = 0;
        this.hLY = 1;
        this.hLZ = 2;
        this.hMa = 3;
        this.hMd = 0;
        this.hMe = false;
        this.hMf = false;
        this.hMg = true;
        this.hMo = new AnimatorSet();
        this.hMp = new AnimatorSet();
        this.hMs = false;
        this.hMt = false;
        this.hMz = new HashMap<>();
        this.hMA = new a(this);
        this.context = context;
        this.isHost = z;
        this.hMu = true;
        initView();
        cle();
        getSpinTime();
        if (str != null) {
            try {
                dO(new JSONObject(str));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void initView() {
        this.mView = LayoutInflater.from(this.context).inflate(a.g.ala_pendant_series_gift, (ViewGroup) this, true);
        this.container = (FrameLayout) this.mView.findViewById(a.f.pendant_card_container);
        this.hMh = (LinearLayout) this.mView.findViewById(a.f.front_view);
        this.hMi = (LinearLayout) this.mView.findViewById(a.f.back_view);
        this.hMr = (Button) this.mView.findViewById(a.f.pendant_send_btn);
        this.hMr.setOnClickListener(this);
        this.hMq = (TextView) this.mView.findViewById(a.f.pendant_countdown_text);
        this.hMk = (HeadImageView) this.mView.findViewById(a.f.first_icon);
        this.hMk.setOnClickListener(this);
        this.hMz.put(0, this.hMk);
        this.hMl = (HeadImageView) this.mView.findViewById(a.f.second_icon);
        this.hMl.setOnClickListener(this);
        this.hMz.put(1, this.hMl);
        this.hMm = (HeadImageView) this.mView.findViewById(a.f.third_icon);
        this.hMm.setOnClickListener(this);
        this.hMz.put(2, this.hMm);
        this.hMn = (HeadImageView) this.mView.findViewById(a.f.fourth_icon);
        this.hMn.setOnClickListener(this);
        this.hMz.put(3, this.hMn);
        this.hMj = (LinearLayout) this.mView.findViewById(a.f.second_row);
        this.titleText = (TextView) this.mView.findViewById(a.f.title_text);
        this.hMi.setVisibility(8);
        setCanVisible(false);
    }

    private void cle() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hMh, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(750L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hMh, "alpha", 0.0f, 1.0f);
        ofFloat2.setDuration(750L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.hMi, "alpha", 1.0f, 0.0f);
        ofFloat3.setDuration(750L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.hMi, "alpha", 0.0f, 1.0f);
        ofFloat4.setDuration(750L);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.hMh, "scaleX", 1.0f, 0.0f);
        ofFloat5.setDuration(750L);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.hMh, "scaleY", 1.0f, 0.0f);
        ofFloat6.setDuration(750L);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.hMh, "scaleX", 0.0f, 1.0f);
        ofFloat7.setDuration(750L);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.hMh, "scaleY", 0.0f, 1.0f);
        ofFloat8.setDuration(750L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.hMi, "scaleX", 1.0f, 0.0f);
        ofFloat9.setDuration(750L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.hMi, "scaleY", 1.0f, 0.0f);
        ofFloat10.setDuration(750L);
        ObjectAnimator ofFloat11 = ObjectAnimator.ofFloat(this.hMi, "scaleX", 0.0f, 1.0f);
        ofFloat11.setDuration(750L);
        ObjectAnimator ofFloat12 = ObjectAnimator.ofFloat(this.hMi, "scaleY", 0.0f, 1.0f);
        ofFloat12.setDuration(750L);
        this.hMo.play(ofFloat2).with(ofFloat7).with(ofFloat8).with(ofFloat3).with(ofFloat9).with(ofFloat10);
        this.hMp.play(ofFloat4).with(ofFloat11).with(ofFloat12).with(ofFloat).with(ofFloat5).with(ofFloat6);
        this.hMo.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                AlaSeriesGiftPendant.this.container.setClickable(false);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSeriesGiftPendant.this.oj(true);
                super.onAnimationEnd(animator);
            }
        });
        this.hMp.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                AlaSeriesGiftPendant.this.hMi.setVisibility(0);
                AlaSeriesGiftPendant.this.container.setClickable(false);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSeriesGiftPendant.this.oj(false);
                super.onAnimationEnd(animator);
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tieba.ala.view.AlaSeriesGiftPendant$3] */
    public void clf() {
        new Thread() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.3
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                while (AlaSeriesGiftPendant.this.hMd >= 0 && AlaSeriesGiftPendant.this.hMg) {
                    if (!AlaSeriesGiftPendant.hMc) {
                        if (AlaSeriesGiftPendant.this.hMu) {
                            AlaSeriesGiftPendant.this.hMA.sendEmptyMessageDelayed(1, AlaSeriesGiftPendant.this.hMv);
                            try {
                                sleep(AlaSeriesGiftPendant.this.hMv + AlaSeriesGiftPendant.this.hMw);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            AlaSeriesGiftPendant.this.hMu = false;
                        }
                        if (!AlaSeriesGiftPendant.this.hMs) {
                            AlaSeriesGiftPendant.this.hMe = true;
                            AlaSeriesGiftPendant.this.hMA.sendEmptyMessage(1);
                            try {
                                sleep(AlaSeriesGiftPendant.this.hMw);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        } else {
                            AlaSeriesGiftPendant.this.hMe = true;
                            AlaSeriesGiftPendant.this.hMA.sendEmptyMessage(1);
                            try {
                                sleep(AlaSeriesGiftPendant.this.hMv);
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                    } else {
                        AlaSeriesGiftPendant.this.hMA.sendEmptyMessage(4);
                        return;
                    }
                }
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.tieba.ala.view.AlaSeriesGiftPendant$4] */
    public void startCountDown() {
        if (this.hMd <= 0) {
            this.hMf = false;
        } else {
            new Thread() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.4
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (true) {
                        if (AlaSeriesGiftPendant.this.hMd <= 0) {
                            break;
                        } else if (!AlaSeriesGiftPendant.hMc) {
                            AlaSeriesGiftPendant.this.hMf = true;
                            AlaSeriesGiftPendant.this.hMA.sendEmptyMessage(2);
                            AlaSeriesGiftPendant alaSeriesGiftPendant = AlaSeriesGiftPendant.this;
                            alaSeriesGiftPendant.hMd--;
                            try {
                                sleep(1000L);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            AlaSeriesGiftPendant.this.hMA.sendEmptyMessage(5);
                            break;
                        }
                    }
                    try {
                        sleep(2000L);
                        if (AlaSeriesGiftPendant.this.hMd <= 0) {
                            AlaSeriesGiftPendant.this.hMA.sendEmptyMessage(3);
                        } else {
                            AlaSeriesGiftPendant.this.startCountDown();
                        }
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCountDownNum(int i) {
        this.hMq.setText(i + "s");
        this.hMr.setText("赠送" + i + "s");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clg() {
        this.hMq.setText(" ");
        this.hMf = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clh() {
        if (this.hMs) {
            this.hMs = false;
            this.hMo.start();
        } else if (this.hMg) {
            this.hMs = true;
            this.hMp.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cli() {
        if (this.hMs) {
            this.hMo.start();
            this.hMs = false;
            return;
        }
        this.hMg = false;
    }

    public void dO(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hMx = new com.baidu.tieba.ala.data.j();
            this.hMx.parserJson(jSONObject);
            this.hMy = this.hMx.bRj();
            this.hMd = this.hMx.bRh();
            if (this.hMx.bRi()) {
                clg();
            } else {
                setCountDownNum(this.hMd);
            }
            this.titleText.setText(this.hMx.Gk() == null ? "套系礼物" : this.hMx.Gk());
            switch (this.hMy.length) {
                case 2:
                    this.hMj.setVisibility(8);
                    break;
                case 3:
                    this.hMj.setVisibility(0);
                    this.hMn.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.hMm.getLayoutParams());
                    layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds58);
                    this.hMm.setLayoutParams(layoutParams);
                    break;
                case 4:
                    this.hMj.setVisibility(0);
                    break;
            }
            for (int i = 0; i < this.hMy.length; i++) {
                if (this.hMy[i].getStatus() == 0) {
                    HeadImageView headImageView = this.hMz.get(Integer.valueOf(i));
                    headImageView.setIsRound(true);
                    headImageView.setBorderColor(this.context.getResources().getColor(a.c.sdk_black_alpha10));
                    headImageView.setAutoChangeStyle(false);
                    headImageView.stopLoad();
                    headImageView.startLoad(this.hMy[i].bRk(), 12, false, false);
                } else if (this.hMy[i].getStatus() == 1) {
                    HeadImageView headImageView2 = this.hMz.get(Integer.valueOf(i));
                    headImageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    headImageView2.setIsRound(true);
                    headImageView2.setBorderColor(this.context.getResources().getColor(a.c.sdk_black_alpha10));
                    headImageView2.setAutoChangeStyle(false);
                    headImageView2.stopLoad();
                    headImageView2.startLoad(this.hMy[i].getPortrait(), 12, false, false);
                }
            }
            setCanVisible(true);
            if (this.hMx.bRi()) {
                hMc = true;
                this.hMA.sendEmptyMessageDelayed(3, IMConnection.RETRY_DELAY_TIMES);
            } else {
                hMc = false;
            }
            if (!this.hMe && !this.hMf) {
                startCountDown();
                if (!this.isHost) {
                    clf();
                }
            }
            if (this.isHost) {
                this.hMh.setOnClickListener(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oj(boolean z) {
        if (z) {
            this.hMk.setClickable(true);
            this.hMl.setClickable(true);
            this.hMm.setClickable(true);
            this.hMn.setClickable(true);
            this.hMr.setClickable(false);
            return;
        }
        this.hMk.setClickable(false);
        this.hMl.setClickable(false);
        this.hMm.setClickable(false);
        this.hMn.setClickable(false);
        this.hMr.setClickable(true);
    }

    private void clj() {
        if (this.hMx.Gk() == null) {
            BdUtilHelper.showToast(this.context, "每" + this.hMx.bRh() + "s内送出1个套系礼物，集齐全部获得惊喜特效，尊享全站广播哟！");
        } else {
            BdUtilHelper.showToast(this.context, "每" + this.hMx.bRh() + "s内送出1个" + this.hMx.Gk() + "系列礼物，集齐全部获得惊喜特效，尊享全站广播哟！");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = 0;
        if (this.isHost || this.hMy == null) {
            clj();
        } else if (this.hMk == view) {
            if (this.hMy[0].getStatus() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.hMy[0].bRl()))));
                return;
            }
            ah ahVar = new ah();
            ahVar.aII = this.hMy[0].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, ahVar));
        } else if (this.hMl == view) {
            if (this.hMy[1].getStatus() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.hMy[1].bRl()))));
                return;
            }
            ah ahVar2 = new ah();
            ahVar2.aII = this.hMy[1].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, ahVar2));
        } else if (this.hMm == view) {
            if (this.hMy[2].getStatus() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.hMy[2].bRl()))));
                return;
            }
            ah ahVar3 = new ah();
            ahVar3.aII = this.hMy[2].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, ahVar3));
        } else if (this.hMn == view) {
            if (this.hMy[3].getStatus() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.hMy[3].bRl()))));
                return;
            }
            ah ahVar4 = new ah();
            ahVar4.aII = this.hMy[3].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, ahVar4));
        } else if (this.hMr == view) {
            ah ahVar5 = new ah();
            ahVar5.aIH = -1;
            ahVar5.aII = -1;
            ahVar5.aIK = null;
            com.baidu.tieba.ala.data.k[] kVarArr = this.hMy;
            int length = kVarArr.length;
            while (true) {
                if (i >= length) {
                    break;
                }
                com.baidu.tieba.ala.data.k kVar = kVarArr[i];
                if (kVar.getStatus() != 0) {
                    i++;
                } else {
                    ahVar5.aII = kVar.getGiftId();
                    break;
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, ahVar5));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void clk() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mView, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(750L);
        ofFloat.start();
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.5
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSeriesGiftPendant.this.setCanVisible(false);
                AlaSeriesGiftPendant.this.mView.setAlpha(1.0f);
            }
        });
        hMb = true;
        this.hMg = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a extends Handler {
        private final WeakReference<AlaSeriesGiftPendant> hMC;

        public a(AlaSeriesGiftPendant alaSeriesGiftPendant) {
            this.hMC = new WeakReference<>(alaSeriesGiftPendant);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (this.hMC.get() != null) {
                if (message.what == 1 && !AlaSeriesGiftPendant.hMc) {
                    this.hMC.get().clh();
                } else if (message.what == 2) {
                    this.hMC.get().setCountDownNum(this.hMC.get().hMd);
                } else if (message.what == 3) {
                    this.hMC.get().clk();
                } else if (message.what == 4) {
                    this.hMC.get().cli();
                } else if (message.what == 5) {
                    this.hMC.get().clg();
                }
            }
        }
    }

    public void onDestroy() {
        super.onDetachedFromWindow();
    }

    public void setCanVisible(boolean z) {
        this.hMt = z;
        this.mView.setVisibility(z ? 0 : 8);
        if (z) {
            hMb = false;
        }
    }

    private void getSpinTime() {
        this.hMv = com.baidu.live.aa.a.Ph().bms.aKL * 1000;
        this.hMw = com.baidu.live.aa.a.Ph().bms.aKM * 1000;
    }
}
