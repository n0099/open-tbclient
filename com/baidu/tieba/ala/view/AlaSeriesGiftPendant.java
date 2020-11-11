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
    public static volatile boolean hMu = true;
    public static volatile boolean hMv = false;
    private FrameLayout container;
    Context context;
    private LinearLayout hMA;
    private LinearLayout hMB;
    private LinearLayout hMC;
    private HeadImageView hMD;
    private HeadImageView hME;
    private HeadImageView hMF;
    private HeadImageView hMG;
    private AnimatorSet hMH;
    private AnimatorSet hMI;
    private TextView hMJ;
    private Button hMK;
    private volatile boolean hML;
    private boolean hMM;
    private boolean hMN;
    private int hMO;
    private int hMP;
    com.baidu.tieba.ala.data.j hMQ;
    com.baidu.tieba.ala.data.k[] hMR;
    HashMap<Integer, HeadImageView> hMS;
    a hMT;
    private final int hMp;
    private final int hMq;
    private final int hMr;
    private final int hMs;
    private final int hMt;
    public volatile int hMw;
    private volatile boolean hMx;
    private volatile boolean hMy;
    private volatile boolean hMz;
    boolean isHost;
    private View mView;
    private TextView titleText;

    public AlaSeriesGiftPendant(Context context, boolean z, String str) {
        super(context);
        this.hMp = 4;
        this.hMq = 0;
        this.hMr = 1;
        this.hMs = 2;
        this.hMt = 3;
        this.hMw = 0;
        this.hMx = false;
        this.hMy = false;
        this.hMz = true;
        this.hMH = new AnimatorSet();
        this.hMI = new AnimatorSet();
        this.hML = false;
        this.hMM = false;
        this.hMS = new HashMap<>();
        this.hMT = new a(this);
        this.context = context;
        this.isHost = z;
        this.hMN = true;
        initView();
        clL();
        getSpinTime();
        if (str != null) {
            try {
                dU(new JSONObject(str));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void initView() {
        this.mView = LayoutInflater.from(this.context).inflate(a.g.ala_pendant_series_gift, (ViewGroup) this, true);
        this.container = (FrameLayout) this.mView.findViewById(a.f.pendant_card_container);
        this.hMA = (LinearLayout) this.mView.findViewById(a.f.front_view);
        this.hMB = (LinearLayout) this.mView.findViewById(a.f.back_view);
        this.hMK = (Button) this.mView.findViewById(a.f.pendant_send_btn);
        this.hMK.setOnClickListener(this);
        this.hMJ = (TextView) this.mView.findViewById(a.f.pendant_countdown_text);
        this.hMD = (HeadImageView) this.mView.findViewById(a.f.first_icon);
        this.hMD.setOnClickListener(this);
        this.hMS.put(0, this.hMD);
        this.hME = (HeadImageView) this.mView.findViewById(a.f.second_icon);
        this.hME.setOnClickListener(this);
        this.hMS.put(1, this.hME);
        this.hMF = (HeadImageView) this.mView.findViewById(a.f.third_icon);
        this.hMF.setOnClickListener(this);
        this.hMS.put(2, this.hMF);
        this.hMG = (HeadImageView) this.mView.findViewById(a.f.fourth_icon);
        this.hMG.setOnClickListener(this);
        this.hMS.put(3, this.hMG);
        this.hMC = (LinearLayout) this.mView.findViewById(a.f.second_row);
        this.titleText = (TextView) this.mView.findViewById(a.f.title_text);
        this.hMB.setVisibility(8);
        setCanVisible(false);
    }

    private void clL() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hMA, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(750L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hMA, "alpha", 0.0f, 1.0f);
        ofFloat2.setDuration(750L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.hMB, "alpha", 1.0f, 0.0f);
        ofFloat3.setDuration(750L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.hMB, "alpha", 0.0f, 1.0f);
        ofFloat4.setDuration(750L);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.hMA, "scaleX", 1.0f, 0.0f);
        ofFloat5.setDuration(750L);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.hMA, "scaleY", 1.0f, 0.0f);
        ofFloat6.setDuration(750L);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.hMA, "scaleX", 0.0f, 1.0f);
        ofFloat7.setDuration(750L);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.hMA, "scaleY", 0.0f, 1.0f);
        ofFloat8.setDuration(750L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.hMB, "scaleX", 1.0f, 0.0f);
        ofFloat9.setDuration(750L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.hMB, "scaleY", 1.0f, 0.0f);
        ofFloat10.setDuration(750L);
        ObjectAnimator ofFloat11 = ObjectAnimator.ofFloat(this.hMB, "scaleX", 0.0f, 1.0f);
        ofFloat11.setDuration(750L);
        ObjectAnimator ofFloat12 = ObjectAnimator.ofFloat(this.hMB, "scaleY", 0.0f, 1.0f);
        ofFloat12.setDuration(750L);
        this.hMH.play(ofFloat2).with(ofFloat7).with(ofFloat8).with(ofFloat3).with(ofFloat9).with(ofFloat10);
        this.hMI.play(ofFloat4).with(ofFloat11).with(ofFloat12).with(ofFloat).with(ofFloat5).with(ofFloat6);
        this.hMH.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                AlaSeriesGiftPendant.this.container.setClickable(false);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSeriesGiftPendant.this.oi(true);
                super.onAnimationEnd(animator);
            }
        });
        this.hMI.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                AlaSeriesGiftPendant.this.hMB.setVisibility(0);
                AlaSeriesGiftPendant.this.container.setClickable(false);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSeriesGiftPendant.this.oi(false);
                super.onAnimationEnd(animator);
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tieba.ala.view.AlaSeriesGiftPendant$3] */
    public void clM() {
        new Thread() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.3
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                while (AlaSeriesGiftPendant.this.hMw >= 0 && AlaSeriesGiftPendant.this.hMz) {
                    if (!AlaSeriesGiftPendant.hMv) {
                        if (AlaSeriesGiftPendant.this.hMN) {
                            AlaSeriesGiftPendant.this.hMT.sendEmptyMessageDelayed(1, AlaSeriesGiftPendant.this.hMO);
                            try {
                                sleep(AlaSeriesGiftPendant.this.hMO + AlaSeriesGiftPendant.this.hMP);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            AlaSeriesGiftPendant.this.hMN = false;
                        }
                        if (!AlaSeriesGiftPendant.this.hML) {
                            AlaSeriesGiftPendant.this.hMx = true;
                            AlaSeriesGiftPendant.this.hMT.sendEmptyMessage(1);
                            try {
                                sleep(AlaSeriesGiftPendant.this.hMP);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        } else {
                            AlaSeriesGiftPendant.this.hMx = true;
                            AlaSeriesGiftPendant.this.hMT.sendEmptyMessage(1);
                            try {
                                sleep(AlaSeriesGiftPendant.this.hMO);
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                    } else {
                        AlaSeriesGiftPendant.this.hMT.sendEmptyMessage(4);
                        return;
                    }
                }
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.tieba.ala.view.AlaSeriesGiftPendant$4] */
    public void startCountDown() {
        if (this.hMw <= 0) {
            this.hMy = false;
        } else {
            new Thread() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.4
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (true) {
                        if (AlaSeriesGiftPendant.this.hMw <= 0) {
                            break;
                        } else if (!AlaSeriesGiftPendant.hMv) {
                            AlaSeriesGiftPendant.this.hMy = true;
                            AlaSeriesGiftPendant.this.hMT.sendEmptyMessage(2);
                            AlaSeriesGiftPendant alaSeriesGiftPendant = AlaSeriesGiftPendant.this;
                            alaSeriesGiftPendant.hMw--;
                            try {
                                sleep(1000L);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            AlaSeriesGiftPendant.this.hMT.sendEmptyMessage(5);
                            break;
                        }
                    }
                    try {
                        sleep(2000L);
                        if (AlaSeriesGiftPendant.this.hMw <= 0) {
                            AlaSeriesGiftPendant.this.hMT.sendEmptyMessage(3);
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
        this.hMJ.setText(i + "s");
        this.hMK.setText("赠送" + i + "s");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clN() {
        this.hMJ.setText(" ");
        this.hMy = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clO() {
        if (this.hML) {
            this.hML = false;
            this.hMH.start();
        } else if (this.hMz) {
            this.hML = true;
            this.hMI.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clP() {
        if (this.hML) {
            this.hMH.start();
            this.hML = false;
            return;
        }
        this.hMz = false;
    }

    public void dU(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hMQ = new com.baidu.tieba.ala.data.j();
            this.hMQ.parserJson(jSONObject);
            this.hMR = this.hMQ.bRQ();
            this.hMw = this.hMQ.bRO();
            if (this.hMQ.bRP()) {
                clN();
            } else {
                setCountDownNum(this.hMw);
            }
            this.titleText.setText(this.hMQ.GT() == null ? "套系礼物" : this.hMQ.GT());
            switch (this.hMR.length) {
                case 2:
                    this.hMC.setVisibility(8);
                    break;
                case 3:
                    this.hMC.setVisibility(0);
                    this.hMG.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.hMF.getLayoutParams());
                    layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds58);
                    this.hMF.setLayoutParams(layoutParams);
                    break;
                case 4:
                    this.hMC.setVisibility(0);
                    break;
            }
            for (int i = 0; i < this.hMR.length; i++) {
                if (this.hMR[i].getStatus() == 0) {
                    HeadImageView headImageView = this.hMS.get(Integer.valueOf(i));
                    headImageView.setIsRound(true);
                    headImageView.setBorderColor(this.context.getResources().getColor(a.c.sdk_black_alpha10));
                    headImageView.setAutoChangeStyle(false);
                    headImageView.stopLoad();
                    headImageView.startLoad(this.hMR[i].bRR(), 12, false, false);
                } else if (this.hMR[i].getStatus() == 1) {
                    HeadImageView headImageView2 = this.hMS.get(Integer.valueOf(i));
                    headImageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    headImageView2.setIsRound(true);
                    headImageView2.setBorderColor(this.context.getResources().getColor(a.c.sdk_black_alpha10));
                    headImageView2.setAutoChangeStyle(false);
                    headImageView2.stopLoad();
                    headImageView2.startLoad(this.hMR[i].getPortrait(), 12, false, false);
                }
            }
            setCanVisible(true);
            if (this.hMQ.bRP()) {
                hMv = true;
                this.hMT.sendEmptyMessageDelayed(3, IMConnection.RETRY_DELAY_TIMES);
            } else {
                hMv = false;
            }
            if (!this.hMx && !this.hMy) {
                startCountDown();
                if (!this.isHost) {
                    clM();
                }
            }
            if (this.isHost) {
                this.hMA.setOnClickListener(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oi(boolean z) {
        if (z) {
            this.hMD.setClickable(true);
            this.hME.setClickable(true);
            this.hMF.setClickable(true);
            this.hMG.setClickable(true);
            this.hMK.setClickable(false);
            return;
        }
        this.hMD.setClickable(false);
        this.hME.setClickable(false);
        this.hMF.setClickable(false);
        this.hMG.setClickable(false);
        this.hMK.setClickable(true);
    }

    private void clQ() {
        if (this.hMQ.GT() == null) {
            BdUtilHelper.showToast(this.context, "每" + this.hMQ.bRO() + "s内送出1个套系礼物，集齐全部获得惊喜特效，尊享全站广播哟！");
        } else {
            BdUtilHelper.showToast(this.context, "每" + this.hMQ.bRO() + "s内送出1个" + this.hMQ.GT() + "系列礼物，集齐全部获得惊喜特效，尊享全站广播哟！");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = 0;
        if (this.isHost || this.hMR == null) {
            clQ();
        } else if (this.hMD == view) {
            if (this.hMR[0].getStatus() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.hMR[0].bRS()))));
                return;
            }
            ah ahVar = new ah();
            ahVar.aKt = this.hMR[0].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, ahVar));
        } else if (this.hME == view) {
            if (this.hMR[1].getStatus() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.hMR[1].bRS()))));
                return;
            }
            ah ahVar2 = new ah();
            ahVar2.aKt = this.hMR[1].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, ahVar2));
        } else if (this.hMF == view) {
            if (this.hMR[2].getStatus() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.hMR[2].bRS()))));
                return;
            }
            ah ahVar3 = new ah();
            ahVar3.aKt = this.hMR[2].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, ahVar3));
        } else if (this.hMG == view) {
            if (this.hMR[3].getStatus() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.hMR[3].bRS()))));
                return;
            }
            ah ahVar4 = new ah();
            ahVar4.aKt = this.hMR[3].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, ahVar4));
        } else if (this.hMK == view) {
            ah ahVar5 = new ah();
            ahVar5.aKs = -1;
            ahVar5.aKt = -1;
            ahVar5.aKv = null;
            com.baidu.tieba.ala.data.k[] kVarArr = this.hMR;
            int length = kVarArr.length;
            while (true) {
                if (i >= length) {
                    break;
                }
                com.baidu.tieba.ala.data.k kVar = kVarArr[i];
                if (kVar.getStatus() != 0) {
                    i++;
                } else {
                    ahVar5.aKt = kVar.getGiftId();
                    break;
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, ahVar5));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void clR() {
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
        hMu = true;
        this.hMz = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a extends Handler {
        private final WeakReference<AlaSeriesGiftPendant> hMV;

        public a(AlaSeriesGiftPendant alaSeriesGiftPendant) {
            this.hMV = new WeakReference<>(alaSeriesGiftPendant);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (this.hMV.get() != null) {
                if (message.what == 1 && !AlaSeriesGiftPendant.hMv) {
                    this.hMV.get().clO();
                } else if (message.what == 2) {
                    this.hMV.get().setCountDownNum(this.hMV.get().hMw);
                } else if (message.what == 3) {
                    this.hMV.get().clR();
                } else if (message.what == 4) {
                    this.hMV.get().clP();
                } else if (message.what == 5) {
                    this.hMV.get().clN();
                }
            }
        }
    }

    public void onDestroy() {
        super.onDetachedFromWindow();
    }

    public void setCanVisible(boolean z) {
        this.hMM = z;
        this.mView.setVisibility(z ? 0 : 8);
        if (z) {
            hMu = false;
        }
    }

    private void getSpinTime() {
        this.hMO = com.baidu.live.aa.a.PQ().bod.aMw * 1000;
        this.hMP = com.baidu.live.aa.a.PQ().bod.aMx * 1000;
    }
}
