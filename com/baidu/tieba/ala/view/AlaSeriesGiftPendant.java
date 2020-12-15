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
import com.baidu.live.data.ai;
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
    public static volatile boolean hWX = true;
    public static volatile boolean hWY = false;
    private FrameLayout container;
    Context context;
    private final int hWS;
    private final int hWT;
    private final int hWU;
    private final int hWV;
    private final int hWW;
    public volatile int hWZ;
    private volatile boolean hXa;
    private volatile boolean hXb;
    private volatile boolean hXc;
    private LinearLayout hXd;
    private LinearLayout hXe;
    private LinearLayout hXf;
    private HeadImageView hXg;
    private HeadImageView hXh;
    private HeadImageView hXi;
    private HeadImageView hXj;
    private AnimatorSet hXk;
    private AnimatorSet hXl;
    private TextView hXm;
    private Button hXn;
    private volatile boolean hXo;
    private boolean hXp;
    private boolean hXq;
    private int hXr;
    private int hXs;
    com.baidu.tieba.ala.data.j hXt;
    com.baidu.tieba.ala.data.k[] hXu;
    HashMap<Integer, HeadImageView> hXv;
    a hXw;
    boolean isHost;
    private View mView;
    private TextView titleText;

    public AlaSeriesGiftPendant(Context context, boolean z, String str) {
        super(context);
        this.hWS = 4;
        this.hWT = 0;
        this.hWU = 1;
        this.hWV = 2;
        this.hWW = 3;
        this.hWZ = 0;
        this.hXa = false;
        this.hXb = false;
        this.hXc = true;
        this.hXk = new AnimatorSet();
        this.hXl = new AnimatorSet();
        this.hXo = false;
        this.hXp = false;
        this.hXv = new HashMap<>();
        this.hXw = new a(this);
        this.context = context;
        this.isHost = z;
        this.hXq = true;
        initView();
        cpu();
        getSpinTime();
        if (str != null) {
            try {
                dQ(new JSONObject(str));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void initView() {
        this.mView = LayoutInflater.from(this.context).inflate(a.g.ala_pendant_series_gift, (ViewGroup) this, true);
        this.container = (FrameLayout) this.mView.findViewById(a.f.pendant_card_container);
        this.hXd = (LinearLayout) this.mView.findViewById(a.f.front_view);
        this.hXe = (LinearLayout) this.mView.findViewById(a.f.back_view);
        this.hXn = (Button) this.mView.findViewById(a.f.pendant_send_btn);
        this.hXn.setOnClickListener(this);
        this.hXm = (TextView) this.mView.findViewById(a.f.pendant_countdown_text);
        this.hXg = (HeadImageView) this.mView.findViewById(a.f.first_icon);
        this.hXg.setOnClickListener(this);
        this.hXv.put(0, this.hXg);
        this.hXh = (HeadImageView) this.mView.findViewById(a.f.second_icon);
        this.hXh.setOnClickListener(this);
        this.hXv.put(1, this.hXh);
        this.hXi = (HeadImageView) this.mView.findViewById(a.f.third_icon);
        this.hXi.setOnClickListener(this);
        this.hXv.put(2, this.hXi);
        this.hXj = (HeadImageView) this.mView.findViewById(a.f.fourth_icon);
        this.hXj.setOnClickListener(this);
        this.hXv.put(3, this.hXj);
        this.hXf = (LinearLayout) this.mView.findViewById(a.f.second_row);
        this.titleText = (TextView) this.mView.findViewById(a.f.title_text);
        this.hXe.setVisibility(8);
        setCanVisible(false);
    }

    private void cpu() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hXd, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(750L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hXd, "alpha", 0.0f, 1.0f);
        ofFloat2.setDuration(750L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.hXe, "alpha", 1.0f, 0.0f);
        ofFloat3.setDuration(750L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.hXe, "alpha", 0.0f, 1.0f);
        ofFloat4.setDuration(750L);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.hXd, "scaleX", 1.0f, 0.0f);
        ofFloat5.setDuration(750L);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.hXd, "scaleY", 1.0f, 0.0f);
        ofFloat6.setDuration(750L);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.hXd, "scaleX", 0.0f, 1.0f);
        ofFloat7.setDuration(750L);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.hXd, "scaleY", 0.0f, 1.0f);
        ofFloat8.setDuration(750L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.hXe, "scaleX", 1.0f, 0.0f);
        ofFloat9.setDuration(750L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.hXe, "scaleY", 1.0f, 0.0f);
        ofFloat10.setDuration(750L);
        ObjectAnimator ofFloat11 = ObjectAnimator.ofFloat(this.hXe, "scaleX", 0.0f, 1.0f);
        ofFloat11.setDuration(750L);
        ObjectAnimator ofFloat12 = ObjectAnimator.ofFloat(this.hXe, "scaleY", 0.0f, 1.0f);
        ofFloat12.setDuration(750L);
        this.hXk.play(ofFloat2).with(ofFloat7).with(ofFloat8).with(ofFloat3).with(ofFloat9).with(ofFloat10);
        this.hXl.play(ofFloat4).with(ofFloat11).with(ofFloat12).with(ofFloat).with(ofFloat5).with(ofFloat6);
        this.hXk.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                AlaSeriesGiftPendant.this.container.setClickable(false);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSeriesGiftPendant.this.oF(true);
                super.onAnimationEnd(animator);
            }
        });
        this.hXl.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                AlaSeriesGiftPendant.this.hXe.setVisibility(0);
                AlaSeriesGiftPendant.this.container.setClickable(false);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSeriesGiftPendant.this.oF(false);
                super.onAnimationEnd(animator);
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tieba.ala.view.AlaSeriesGiftPendant$3] */
    public void cpv() {
        new Thread() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.3
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                while (AlaSeriesGiftPendant.this.hWZ >= 0 && AlaSeriesGiftPendant.this.hXc) {
                    if (!AlaSeriesGiftPendant.hWY) {
                        if (AlaSeriesGiftPendant.this.hXq) {
                            AlaSeriesGiftPendant.this.hXw.sendEmptyMessageDelayed(1, AlaSeriesGiftPendant.this.hXr);
                            try {
                                sleep(AlaSeriesGiftPendant.this.hXr + AlaSeriesGiftPendant.this.hXs);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            AlaSeriesGiftPendant.this.hXq = false;
                        }
                        if (!AlaSeriesGiftPendant.this.hXo) {
                            AlaSeriesGiftPendant.this.hXa = true;
                            AlaSeriesGiftPendant.this.hXw.sendEmptyMessage(1);
                            try {
                                sleep(AlaSeriesGiftPendant.this.hXs);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        } else {
                            AlaSeriesGiftPendant.this.hXa = true;
                            AlaSeriesGiftPendant.this.hXw.sendEmptyMessage(1);
                            try {
                                sleep(AlaSeriesGiftPendant.this.hXr);
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                    } else {
                        AlaSeriesGiftPendant.this.hXw.sendEmptyMessage(4);
                        return;
                    }
                }
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.tieba.ala.view.AlaSeriesGiftPendant$4] */
    public void startCountDown() {
        if (this.hWZ <= 0) {
            this.hXb = false;
        } else {
            new Thread() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.4
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (true) {
                        if (AlaSeriesGiftPendant.this.hWZ <= 0) {
                            break;
                        } else if (!AlaSeriesGiftPendant.hWY) {
                            AlaSeriesGiftPendant.this.hXb = true;
                            AlaSeriesGiftPendant.this.hXw.sendEmptyMessage(2);
                            AlaSeriesGiftPendant alaSeriesGiftPendant = AlaSeriesGiftPendant.this;
                            alaSeriesGiftPendant.hWZ--;
                            try {
                                sleep(1000L);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            AlaSeriesGiftPendant.this.hXw.sendEmptyMessage(5);
                            break;
                        }
                    }
                    try {
                        sleep(2000L);
                        if (AlaSeriesGiftPendant.this.hWZ <= 0) {
                            AlaSeriesGiftPendant.this.hXw.sendEmptyMessage(3);
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
        this.hXm.setText(i + "s");
        this.hXn.setText("赠送" + i + "s");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpw() {
        this.hXm.setText(" ");
        this.hXb = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpx() {
        if (this.hXo) {
            this.hXo = false;
            this.hXk.start();
        } else if (this.hXc) {
            this.hXo = true;
            this.hXl.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpy() {
        if (this.hXo) {
            this.hXk.start();
            this.hXo = false;
            return;
        }
        this.hXc = false;
    }

    public void dQ(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hXt = new com.baidu.tieba.ala.data.j();
            this.hXt.parserJson(jSONObject);
            this.hXu = this.hXt.bUU();
            this.hWZ = this.hXt.bUS();
            if (this.hXt.bUT()) {
                cpw();
            } else {
                setCountDownNum(this.hWZ);
            }
            this.titleText.setText(this.hXt.HZ() == null ? "套系礼物" : this.hXt.HZ());
            switch (this.hXu.length) {
                case 2:
                    this.hXf.setVisibility(8);
                    break;
                case 3:
                    this.hXf.setVisibility(0);
                    this.hXj.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.hXi.getLayoutParams());
                    layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds58);
                    this.hXi.setLayoutParams(layoutParams);
                    break;
                case 4:
                    this.hXf.setVisibility(0);
                    break;
            }
            for (int i = 0; i < this.hXu.length; i++) {
                if (this.hXu[i].getStatus() == 0) {
                    HeadImageView headImageView = this.hXv.get(Integer.valueOf(i));
                    headImageView.setIsRound(true);
                    headImageView.setBorderColor(this.context.getResources().getColor(a.c.sdk_black_alpha10));
                    headImageView.setAutoChangeStyle(false);
                    headImageView.stopLoad();
                    headImageView.startLoad(this.hXu[i].bUV(), 12, false, false);
                } else if (this.hXu[i].getStatus() == 1) {
                    HeadImageView headImageView2 = this.hXv.get(Integer.valueOf(i));
                    headImageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    headImageView2.setIsRound(true);
                    headImageView2.setBorderColor(this.context.getResources().getColor(a.c.sdk_black_alpha10));
                    headImageView2.setAutoChangeStyle(false);
                    headImageView2.stopLoad();
                    headImageView2.startLoad(this.hXu[i].getPortrait(), 12, false, false);
                }
            }
            setCanVisible(true);
            if (this.hXt.bUT()) {
                hWY = true;
                this.hXw.sendEmptyMessageDelayed(3, IMConnection.RETRY_DELAY_TIMES);
            } else {
                hWY = false;
            }
            if (!this.hXa && !this.hXb) {
                startCountDown();
                if (!this.isHost) {
                    cpv();
                }
            }
            if (this.isHost) {
                this.hXd.setOnClickListener(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oF(boolean z) {
        if (z) {
            this.hXg.setClickable(true);
            this.hXh.setClickable(true);
            this.hXi.setClickable(true);
            this.hXj.setClickable(true);
            this.hXn.setClickable(false);
            return;
        }
        this.hXg.setClickable(false);
        this.hXh.setClickable(false);
        this.hXi.setClickable(false);
        this.hXj.setClickable(false);
        this.hXn.setClickable(true);
    }

    private void cpz() {
        if (this.hXt.HZ() == null) {
            BdUtilHelper.showToast(this.context, "每" + this.hXt.bUS() + "s内送出1个套系礼物，集齐全部获得惊喜特效，尊享全站广播哟！");
        } else {
            BdUtilHelper.showToast(this.context, "每" + this.hXt.bUS() + "s内送出1个" + this.hXt.HZ() + "系列礼物，集齐全部获得惊喜特效，尊享全站广播哟！");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = 0;
        if (this.isHost || this.hXu == null) {
            cpz();
        } else if (this.hXg == view) {
            if (this.hXu[0].getStatus() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.hXu[0].bUW()))));
                return;
            }
            ai aiVar = new ai();
            aiVar.aLB = this.hXu[0].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aiVar));
        } else if (this.hXh == view) {
            if (this.hXu[1].getStatus() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.hXu[1].bUW()))));
                return;
            }
            ai aiVar2 = new ai();
            aiVar2.aLB = this.hXu[1].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aiVar2));
        } else if (this.hXi == view) {
            if (this.hXu[2].getStatus() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.hXu[2].bUW()))));
                return;
            }
            ai aiVar3 = new ai();
            aiVar3.aLB = this.hXu[2].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aiVar3));
        } else if (this.hXj == view) {
            if (this.hXu[3].getStatus() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.hXu[3].bUW()))));
                return;
            }
            ai aiVar4 = new ai();
            aiVar4.aLB = this.hXu[3].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aiVar4));
        } else if (this.hXn == view) {
            ai aiVar5 = new ai();
            aiVar5.aLA = -1;
            aiVar5.aLB = -1;
            aiVar5.aLD = null;
            com.baidu.tieba.ala.data.k[] kVarArr = this.hXu;
            int length = kVarArr.length;
            while (true) {
                if (i >= length) {
                    break;
                }
                com.baidu.tieba.ala.data.k kVar = kVarArr[i];
                if (kVar.getStatus() != 0) {
                    i++;
                } else {
                    aiVar5.aLB = kVar.getGiftId();
                    break;
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aiVar5));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cpA() {
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
        hWX = true;
        this.hXc = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a extends Handler {
        private final WeakReference<AlaSeriesGiftPendant> hXy;

        public a(AlaSeriesGiftPendant alaSeriesGiftPendant) {
            this.hXy = new WeakReference<>(alaSeriesGiftPendant);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (this.hXy.get() != null) {
                if (message.what == 1 && !AlaSeriesGiftPendant.hWY) {
                    this.hXy.get().cpx();
                } else if (message.what == 2) {
                    this.hXy.get().setCountDownNum(this.hXy.get().hWZ);
                } else if (message.what == 3) {
                    this.hXy.get().cpA();
                } else if (message.what == 4) {
                    this.hXy.get().cpy();
                } else if (message.what == 5) {
                    this.hXy.get().cpw();
                }
            }
        }
    }

    public void setCanVisible(boolean z) {
        this.hXp = z;
        this.mView.setVisibility(z ? 0 : 8);
        if (z) {
            hWX = false;
        }
    }

    private void getSpinTime() {
        this.hXr = com.baidu.live.ae.a.RB().brA.aNG * 1000;
        this.hXs = com.baidu.live.ae.a.RB().brA.aNH * 1000;
    }
}
