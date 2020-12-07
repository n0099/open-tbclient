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
    public static volatile boolean hWV = true;
    public static volatile boolean hWW = false;
    private FrameLayout container;
    Context context;
    private final int hWQ;
    private final int hWR;
    private final int hWS;
    private final int hWT;
    private final int hWU;
    public volatile int hWX;
    private volatile boolean hWY;
    private volatile boolean hWZ;
    private volatile boolean hXa;
    private LinearLayout hXb;
    private LinearLayout hXc;
    private LinearLayout hXd;
    private HeadImageView hXe;
    private HeadImageView hXf;
    private HeadImageView hXg;
    private HeadImageView hXh;
    private AnimatorSet hXi;
    private AnimatorSet hXj;
    private TextView hXk;
    private Button hXl;
    private volatile boolean hXm;
    private boolean hXn;
    private boolean hXo;
    private int hXp;
    private int hXq;
    com.baidu.tieba.ala.data.j hXr;
    com.baidu.tieba.ala.data.k[] hXs;
    HashMap<Integer, HeadImageView> hXt;
    a hXu;
    boolean isHost;
    private View mView;
    private TextView titleText;

    public AlaSeriesGiftPendant(Context context, boolean z, String str) {
        super(context);
        this.hWQ = 4;
        this.hWR = 0;
        this.hWS = 1;
        this.hWT = 2;
        this.hWU = 3;
        this.hWX = 0;
        this.hWY = false;
        this.hWZ = false;
        this.hXa = true;
        this.hXi = new AnimatorSet();
        this.hXj = new AnimatorSet();
        this.hXm = false;
        this.hXn = false;
        this.hXt = new HashMap<>();
        this.hXu = new a(this);
        this.context = context;
        this.isHost = z;
        this.hXo = true;
        initView();
        cpt();
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
        this.hXb = (LinearLayout) this.mView.findViewById(a.f.front_view);
        this.hXc = (LinearLayout) this.mView.findViewById(a.f.back_view);
        this.hXl = (Button) this.mView.findViewById(a.f.pendant_send_btn);
        this.hXl.setOnClickListener(this);
        this.hXk = (TextView) this.mView.findViewById(a.f.pendant_countdown_text);
        this.hXe = (HeadImageView) this.mView.findViewById(a.f.first_icon);
        this.hXe.setOnClickListener(this);
        this.hXt.put(0, this.hXe);
        this.hXf = (HeadImageView) this.mView.findViewById(a.f.second_icon);
        this.hXf.setOnClickListener(this);
        this.hXt.put(1, this.hXf);
        this.hXg = (HeadImageView) this.mView.findViewById(a.f.third_icon);
        this.hXg.setOnClickListener(this);
        this.hXt.put(2, this.hXg);
        this.hXh = (HeadImageView) this.mView.findViewById(a.f.fourth_icon);
        this.hXh.setOnClickListener(this);
        this.hXt.put(3, this.hXh);
        this.hXd = (LinearLayout) this.mView.findViewById(a.f.second_row);
        this.titleText = (TextView) this.mView.findViewById(a.f.title_text);
        this.hXc.setVisibility(8);
        setCanVisible(false);
    }

    private void cpt() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hXb, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(750L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hXb, "alpha", 0.0f, 1.0f);
        ofFloat2.setDuration(750L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.hXc, "alpha", 1.0f, 0.0f);
        ofFloat3.setDuration(750L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.hXc, "alpha", 0.0f, 1.0f);
        ofFloat4.setDuration(750L);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.hXb, "scaleX", 1.0f, 0.0f);
        ofFloat5.setDuration(750L);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.hXb, "scaleY", 1.0f, 0.0f);
        ofFloat6.setDuration(750L);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.hXb, "scaleX", 0.0f, 1.0f);
        ofFloat7.setDuration(750L);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.hXb, "scaleY", 0.0f, 1.0f);
        ofFloat8.setDuration(750L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.hXc, "scaleX", 1.0f, 0.0f);
        ofFloat9.setDuration(750L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.hXc, "scaleY", 1.0f, 0.0f);
        ofFloat10.setDuration(750L);
        ObjectAnimator ofFloat11 = ObjectAnimator.ofFloat(this.hXc, "scaleX", 0.0f, 1.0f);
        ofFloat11.setDuration(750L);
        ObjectAnimator ofFloat12 = ObjectAnimator.ofFloat(this.hXc, "scaleY", 0.0f, 1.0f);
        ofFloat12.setDuration(750L);
        this.hXi.play(ofFloat2).with(ofFloat7).with(ofFloat8).with(ofFloat3).with(ofFloat9).with(ofFloat10);
        this.hXj.play(ofFloat4).with(ofFloat11).with(ofFloat12).with(ofFloat).with(ofFloat5).with(ofFloat6);
        this.hXi.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.1
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
        this.hXj.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                AlaSeriesGiftPendant.this.hXc.setVisibility(0);
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
    public void cpu() {
        new Thread() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.3
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                while (AlaSeriesGiftPendant.this.hWX >= 0 && AlaSeriesGiftPendant.this.hXa) {
                    if (!AlaSeriesGiftPendant.hWW) {
                        if (AlaSeriesGiftPendant.this.hXo) {
                            AlaSeriesGiftPendant.this.hXu.sendEmptyMessageDelayed(1, AlaSeriesGiftPendant.this.hXp);
                            try {
                                sleep(AlaSeriesGiftPendant.this.hXp + AlaSeriesGiftPendant.this.hXq);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            AlaSeriesGiftPendant.this.hXo = false;
                        }
                        if (!AlaSeriesGiftPendant.this.hXm) {
                            AlaSeriesGiftPendant.this.hWY = true;
                            AlaSeriesGiftPendant.this.hXu.sendEmptyMessage(1);
                            try {
                                sleep(AlaSeriesGiftPendant.this.hXq);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        } else {
                            AlaSeriesGiftPendant.this.hWY = true;
                            AlaSeriesGiftPendant.this.hXu.sendEmptyMessage(1);
                            try {
                                sleep(AlaSeriesGiftPendant.this.hXp);
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                    } else {
                        AlaSeriesGiftPendant.this.hXu.sendEmptyMessage(4);
                        return;
                    }
                }
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.tieba.ala.view.AlaSeriesGiftPendant$4] */
    public void startCountDown() {
        if (this.hWX <= 0) {
            this.hWZ = false;
        } else {
            new Thread() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.4
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (true) {
                        if (AlaSeriesGiftPendant.this.hWX <= 0) {
                            break;
                        } else if (!AlaSeriesGiftPendant.hWW) {
                            AlaSeriesGiftPendant.this.hWZ = true;
                            AlaSeriesGiftPendant.this.hXu.sendEmptyMessage(2);
                            AlaSeriesGiftPendant alaSeriesGiftPendant = AlaSeriesGiftPendant.this;
                            alaSeriesGiftPendant.hWX--;
                            try {
                                sleep(1000L);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            AlaSeriesGiftPendant.this.hXu.sendEmptyMessage(5);
                            break;
                        }
                    }
                    try {
                        sleep(2000L);
                        if (AlaSeriesGiftPendant.this.hWX <= 0) {
                            AlaSeriesGiftPendant.this.hXu.sendEmptyMessage(3);
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
        this.hXk.setText(i + "s");
        this.hXl.setText("赠送" + i + "s");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpv() {
        this.hXk.setText(" ");
        this.hWZ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpw() {
        if (this.hXm) {
            this.hXm = false;
            this.hXi.start();
        } else if (this.hXa) {
            this.hXm = true;
            this.hXj.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpx() {
        if (this.hXm) {
            this.hXi.start();
            this.hXm = false;
            return;
        }
        this.hXa = false;
    }

    public void dQ(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hXr = new com.baidu.tieba.ala.data.j();
            this.hXr.parserJson(jSONObject);
            this.hXs = this.hXr.bUT();
            this.hWX = this.hXr.bUR();
            if (this.hXr.bUS()) {
                cpv();
            } else {
                setCountDownNum(this.hWX);
            }
            this.titleText.setText(this.hXr.HZ() == null ? "套系礼物" : this.hXr.HZ());
            switch (this.hXs.length) {
                case 2:
                    this.hXd.setVisibility(8);
                    break;
                case 3:
                    this.hXd.setVisibility(0);
                    this.hXh.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.hXg.getLayoutParams());
                    layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds58);
                    this.hXg.setLayoutParams(layoutParams);
                    break;
                case 4:
                    this.hXd.setVisibility(0);
                    break;
            }
            for (int i = 0; i < this.hXs.length; i++) {
                if (this.hXs[i].getStatus() == 0) {
                    HeadImageView headImageView = this.hXt.get(Integer.valueOf(i));
                    headImageView.setIsRound(true);
                    headImageView.setBorderColor(this.context.getResources().getColor(a.c.sdk_black_alpha10));
                    headImageView.setAutoChangeStyle(false);
                    headImageView.stopLoad();
                    headImageView.startLoad(this.hXs[i].bUU(), 12, false, false);
                } else if (this.hXs[i].getStatus() == 1) {
                    HeadImageView headImageView2 = this.hXt.get(Integer.valueOf(i));
                    headImageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    headImageView2.setIsRound(true);
                    headImageView2.setBorderColor(this.context.getResources().getColor(a.c.sdk_black_alpha10));
                    headImageView2.setAutoChangeStyle(false);
                    headImageView2.stopLoad();
                    headImageView2.startLoad(this.hXs[i].getPortrait(), 12, false, false);
                }
            }
            setCanVisible(true);
            if (this.hXr.bUS()) {
                hWW = true;
                this.hXu.sendEmptyMessageDelayed(3, IMConnection.RETRY_DELAY_TIMES);
            } else {
                hWW = false;
            }
            if (!this.hWY && !this.hWZ) {
                startCountDown();
                if (!this.isHost) {
                    cpu();
                }
            }
            if (this.isHost) {
                this.hXb.setOnClickListener(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oF(boolean z) {
        if (z) {
            this.hXe.setClickable(true);
            this.hXf.setClickable(true);
            this.hXg.setClickable(true);
            this.hXh.setClickable(true);
            this.hXl.setClickable(false);
            return;
        }
        this.hXe.setClickable(false);
        this.hXf.setClickable(false);
        this.hXg.setClickable(false);
        this.hXh.setClickable(false);
        this.hXl.setClickable(true);
    }

    private void cpy() {
        if (this.hXr.HZ() == null) {
            BdUtilHelper.showToast(this.context, "每" + this.hXr.bUR() + "s内送出1个套系礼物，集齐全部获得惊喜特效，尊享全站广播哟！");
        } else {
            BdUtilHelper.showToast(this.context, "每" + this.hXr.bUR() + "s内送出1个" + this.hXr.HZ() + "系列礼物，集齐全部获得惊喜特效，尊享全站广播哟！");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = 0;
        if (this.isHost || this.hXs == null) {
            cpy();
        } else if (this.hXe == view) {
            if (this.hXs[0].getStatus() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.hXs[0].bUV()))));
                return;
            }
            ai aiVar = new ai();
            aiVar.aLB = this.hXs[0].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aiVar));
        } else if (this.hXf == view) {
            if (this.hXs[1].getStatus() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.hXs[1].bUV()))));
                return;
            }
            ai aiVar2 = new ai();
            aiVar2.aLB = this.hXs[1].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aiVar2));
        } else if (this.hXg == view) {
            if (this.hXs[2].getStatus() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.hXs[2].bUV()))));
                return;
            }
            ai aiVar3 = new ai();
            aiVar3.aLB = this.hXs[2].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aiVar3));
        } else if (this.hXh == view) {
            if (this.hXs[3].getStatus() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.hXs[3].bUV()))));
                return;
            }
            ai aiVar4 = new ai();
            aiVar4.aLB = this.hXs[3].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aiVar4));
        } else if (this.hXl == view) {
            ai aiVar5 = new ai();
            aiVar5.aLA = -1;
            aiVar5.aLB = -1;
            aiVar5.aLD = null;
            com.baidu.tieba.ala.data.k[] kVarArr = this.hXs;
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
    public synchronized void cpz() {
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
        hWV = true;
        this.hXa = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a extends Handler {
        private final WeakReference<AlaSeriesGiftPendant> hXw;

        public a(AlaSeriesGiftPendant alaSeriesGiftPendant) {
            this.hXw = new WeakReference<>(alaSeriesGiftPendant);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (this.hXw.get() != null) {
                if (message.what == 1 && !AlaSeriesGiftPendant.hWW) {
                    this.hXw.get().cpw();
                } else if (message.what == 2) {
                    this.hXw.get().setCountDownNum(this.hXw.get().hWX);
                } else if (message.what == 3) {
                    this.hXw.get().cpz();
                } else if (message.what == 4) {
                    this.hXw.get().cpx();
                } else if (message.what == 5) {
                    this.hXw.get().cpv();
                }
            }
        }
    }

    public void setCanVisible(boolean z) {
        this.hXn = z;
        this.mView.setVisibility(z ? 0 : 8);
        if (z) {
            hWV = false;
        }
    }

    private void getSpinTime() {
        this.hXp = com.baidu.live.ae.a.RB().brA.aNG * 1000;
        this.hXq = com.baidu.live.ae.a.RB().brA.aNH * 1000;
    }
}
