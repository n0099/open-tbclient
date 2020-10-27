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
import com.baidu.live.data.ag;
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
    public static volatile boolean hGx = true;
    public static volatile boolean hGy = false;
    private FrameLayout container;
    Context context;
    private volatile boolean hGA;
    private volatile boolean hGB;
    private volatile boolean hGC;
    private LinearLayout hGD;
    private LinearLayout hGE;
    private LinearLayout hGF;
    private HeadImageView hGG;
    private HeadImageView hGH;
    private HeadImageView hGI;
    private HeadImageView hGJ;
    private AnimatorSet hGK;
    private AnimatorSet hGL;
    private TextView hGM;
    private Button hGN;
    private volatile boolean hGO;
    private boolean hGP;
    private boolean hGQ;
    private int hGR;
    private int hGS;
    com.baidu.tieba.ala.data.j hGT;
    com.baidu.tieba.ala.data.k[] hGU;
    HashMap<Integer, HeadImageView> hGV;
    a hGW;
    private final int hGs;
    private final int hGt;
    private final int hGu;
    private final int hGv;
    private final int hGw;
    public volatile int hGz;
    boolean isHost;
    private View mView;
    private TextView titleText;

    public AlaSeriesGiftPendant(Context context, boolean z, String str) {
        super(context);
        this.hGs = 4;
        this.hGt = 0;
        this.hGu = 1;
        this.hGv = 2;
        this.hGw = 3;
        this.hGz = 0;
        this.hGA = false;
        this.hGB = false;
        this.hGC = true;
        this.hGK = new AnimatorSet();
        this.hGL = new AnimatorSet();
        this.hGO = false;
        this.hGP = false;
        this.hGV = new HashMap<>();
        this.hGW = new a(this);
        this.context = context;
        this.isHost = z;
        this.hGQ = true;
        initView();
        cjj();
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
        this.mView = LayoutInflater.from(this.context).inflate(a.h.ala_pendant_series_gift, (ViewGroup) this, true);
        this.container = (FrameLayout) this.mView.findViewById(a.g.pendant_card_container);
        this.hGD = (LinearLayout) this.mView.findViewById(a.g.front_view);
        this.hGE = (LinearLayout) this.mView.findViewById(a.g.back_view);
        this.hGN = (Button) this.mView.findViewById(a.g.pendant_send_btn);
        this.hGN.setOnClickListener(this);
        this.hGM = (TextView) this.mView.findViewById(a.g.pendant_countdown_text);
        this.hGG = (HeadImageView) this.mView.findViewById(a.g.first_icon);
        this.hGG.setOnClickListener(this);
        this.hGV.put(0, this.hGG);
        this.hGH = (HeadImageView) this.mView.findViewById(a.g.second_icon);
        this.hGH.setOnClickListener(this);
        this.hGV.put(1, this.hGH);
        this.hGI = (HeadImageView) this.mView.findViewById(a.g.third_icon);
        this.hGI.setOnClickListener(this);
        this.hGV.put(2, this.hGI);
        this.hGJ = (HeadImageView) this.mView.findViewById(a.g.fourth_icon);
        this.hGJ.setOnClickListener(this);
        this.hGV.put(3, this.hGJ);
        this.hGF = (LinearLayout) this.mView.findViewById(a.g.second_row);
        this.titleText = (TextView) this.mView.findViewById(a.g.title_text);
        this.hGE.setVisibility(8);
        setCanVisible(false);
    }

    private void cjj() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hGD, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(750L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hGD, "alpha", 0.0f, 1.0f);
        ofFloat2.setDuration(750L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.hGE, "alpha", 1.0f, 0.0f);
        ofFloat3.setDuration(750L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.hGE, "alpha", 0.0f, 1.0f);
        ofFloat4.setDuration(750L);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.hGD, "scaleX", 1.0f, 0.0f);
        ofFloat5.setDuration(750L);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.hGD, "scaleY", 1.0f, 0.0f);
        ofFloat6.setDuration(750L);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.hGD, "scaleX", 0.0f, 1.0f);
        ofFloat7.setDuration(750L);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.hGD, "scaleY", 0.0f, 1.0f);
        ofFloat8.setDuration(750L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.hGE, "scaleX", 1.0f, 0.0f);
        ofFloat9.setDuration(750L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.hGE, "scaleY", 1.0f, 0.0f);
        ofFloat10.setDuration(750L);
        ObjectAnimator ofFloat11 = ObjectAnimator.ofFloat(this.hGE, "scaleX", 0.0f, 1.0f);
        ofFloat11.setDuration(750L);
        ObjectAnimator ofFloat12 = ObjectAnimator.ofFloat(this.hGE, "scaleY", 0.0f, 1.0f);
        ofFloat12.setDuration(750L);
        this.hGK.play(ofFloat2).with(ofFloat7).with(ofFloat8).with(ofFloat3).with(ofFloat9).with(ofFloat10);
        this.hGL.play(ofFloat4).with(ofFloat11).with(ofFloat12).with(ofFloat).with(ofFloat5).with(ofFloat6);
        this.hGK.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                AlaSeriesGiftPendant.this.container.setClickable(false);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSeriesGiftPendant.this.nZ(true);
                super.onAnimationEnd(animator);
            }
        });
        this.hGL.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                AlaSeriesGiftPendant.this.hGE.setVisibility(0);
                AlaSeriesGiftPendant.this.container.setClickable(false);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSeriesGiftPendant.this.nZ(false);
                super.onAnimationEnd(animator);
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tieba.ala.view.AlaSeriesGiftPendant$3] */
    public void cjk() {
        new Thread() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.3
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                while (AlaSeriesGiftPendant.this.hGz >= 0 && AlaSeriesGiftPendant.this.hGC) {
                    if (!AlaSeriesGiftPendant.hGy) {
                        if (AlaSeriesGiftPendant.this.hGQ) {
                            AlaSeriesGiftPendant.this.hGW.sendEmptyMessageDelayed(1, AlaSeriesGiftPendant.this.hGR);
                            try {
                                sleep(AlaSeriesGiftPendant.this.hGR + AlaSeriesGiftPendant.this.hGS);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            AlaSeriesGiftPendant.this.hGQ = false;
                        }
                        if (!AlaSeriesGiftPendant.this.hGO) {
                            AlaSeriesGiftPendant.this.hGA = true;
                            AlaSeriesGiftPendant.this.hGW.sendEmptyMessage(1);
                            try {
                                sleep(AlaSeriesGiftPendant.this.hGS);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        } else {
                            AlaSeriesGiftPendant.this.hGA = true;
                            AlaSeriesGiftPendant.this.hGW.sendEmptyMessage(1);
                            try {
                                sleep(AlaSeriesGiftPendant.this.hGR);
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                    } else {
                        AlaSeriesGiftPendant.this.hGW.sendEmptyMessage(4);
                        return;
                    }
                }
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.tieba.ala.view.AlaSeriesGiftPendant$4] */
    public void startCountDown() {
        if (this.hGz <= 0) {
            this.hGB = false;
        } else {
            new Thread() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.4
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (true) {
                        if (AlaSeriesGiftPendant.this.hGz <= 0) {
                            break;
                        } else if (!AlaSeriesGiftPendant.hGy) {
                            AlaSeriesGiftPendant.this.hGB = true;
                            AlaSeriesGiftPendant.this.hGW.sendEmptyMessage(2);
                            AlaSeriesGiftPendant alaSeriesGiftPendant = AlaSeriesGiftPendant.this;
                            alaSeriesGiftPendant.hGz--;
                            try {
                                sleep(1000L);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            AlaSeriesGiftPendant.this.hGW.sendEmptyMessage(5);
                            break;
                        }
                    }
                    try {
                        sleep(2000L);
                        if (AlaSeriesGiftPendant.this.hGz <= 0) {
                            AlaSeriesGiftPendant.this.hGW.sendEmptyMessage(3);
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
        this.hGM.setText(i + "s");
        this.hGN.setText("赠送" + i + "s");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjl() {
        this.hGM.setText(" ");
        this.hGB = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjm() {
        if (this.hGO) {
            this.hGO = false;
            this.hGK.start();
        } else if (this.hGC) {
            this.hGO = true;
            this.hGL.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cjn() {
        if (this.hGO) {
            this.hGK.start();
            this.hGO = false;
            return;
        }
        this.hGC = false;
    }

    public void dO(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.hGT = new com.baidu.tieba.ala.data.j();
            this.hGT.parserJson(jSONObject);
            this.hGU = this.hGT.bPq();
            this.hGz = this.hGT.bPo();
            if (this.hGT.bPp()) {
                cjl();
            } else {
                setCountDownNum(this.hGz);
            }
            this.titleText.setText(this.hGT.Gs() == null ? "套系礼物" : this.hGT.Gs());
            switch (this.hGU.length) {
                case 2:
                    this.hGF.setVisibility(8);
                    break;
                case 3:
                    this.hGF.setVisibility(0);
                    this.hGJ.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.hGI.getLayoutParams());
                    layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.e.sdk_ds58);
                    this.hGI.setLayoutParams(layoutParams);
                    break;
                case 4:
                    this.hGF.setVisibility(0);
                    break;
            }
            for (int i = 0; i < this.hGU.length; i++) {
                if (this.hGU[i].getStatus() == 0) {
                    HeadImageView headImageView = this.hGV.get(Integer.valueOf(i));
                    headImageView.setIsRound(true);
                    headImageView.setBorderColor(this.context.getResources().getColor(a.d.sdk_black_alpha10));
                    headImageView.setAutoChangeStyle(false);
                    headImageView.stopLoad();
                    headImageView.startLoad(this.hGU[i].bPr(), 12, false, false);
                } else if (this.hGU[i].getStatus() == 1) {
                    HeadImageView headImageView2 = this.hGV.get(Integer.valueOf(i));
                    headImageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    headImageView2.setIsRound(true);
                    headImageView2.setBorderColor(this.context.getResources().getColor(a.d.sdk_black_alpha10));
                    headImageView2.setAutoChangeStyle(false);
                    headImageView2.stopLoad();
                    headImageView2.startLoad(this.hGU[i].getPortrait(), 12, false, false);
                }
            }
            setCanVisible(true);
            if (this.hGT.bPp()) {
                hGy = true;
                this.hGW.sendEmptyMessageDelayed(3, IMConnection.RETRY_DELAY_TIMES);
            } else {
                hGy = false;
            }
            if (!this.hGA && !this.hGB) {
                startCountDown();
                if (!this.isHost) {
                    cjk();
                }
            }
            if (this.isHost) {
                this.hGD.setOnClickListener(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nZ(boolean z) {
        if (z) {
            this.hGG.setClickable(true);
            this.hGH.setClickable(true);
            this.hGI.setClickable(true);
            this.hGJ.setClickable(true);
            this.hGN.setClickable(false);
            return;
        }
        this.hGG.setClickable(false);
        this.hGH.setClickable(false);
        this.hGI.setClickable(false);
        this.hGJ.setClickable(false);
        this.hGN.setClickable(true);
    }

    private void cjo() {
        if (this.hGT.Gs() == null) {
            BdUtilHelper.showToast(this.context, "每" + this.hGT.bPo() + "s内送出1个套系礼物，集齐全部获得惊喜特效，尊享全站广播哟！");
        } else {
            BdUtilHelper.showToast(this.context, "每" + this.hGT.bPo() + "s内送出1个" + this.hGT.Gs() + "系列礼物，集齐全部获得惊喜特效，尊享全站广播哟！");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = 0;
        if (this.isHost || this.hGU == null) {
            cjo();
        } else if (this.hGG == view) {
            if (this.hGU[0].getStatus() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.hGU[0].bPs()))));
                return;
            }
            ag agVar = new ag();
            agVar.aJt = this.hGU[0].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, agVar));
        } else if (this.hGH == view) {
            if (this.hGU[1].getStatus() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.hGU[1].bPs()))));
                return;
            }
            ag agVar2 = new ag();
            agVar2.aJt = this.hGU[1].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, agVar2));
        } else if (this.hGI == view) {
            if (this.hGU[2].getStatus() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.hGU[2].bPs()))));
                return;
            }
            ag agVar3 = new ag();
            agVar3.aJt = this.hGU[2].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, agVar3));
        } else if (this.hGJ == view) {
            if (this.hGU[3].getStatus() == 1) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.hGU[3].bPs()))));
                return;
            }
            ag agVar4 = new ag();
            agVar4.aJt = this.hGU[3].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, agVar4));
        } else if (this.hGN == view) {
            ag agVar5 = new ag();
            agVar5.aJs = -1;
            agVar5.aJt = -1;
            agVar5.aJv = null;
            com.baidu.tieba.ala.data.k[] kVarArr = this.hGU;
            int length = kVarArr.length;
            while (true) {
                if (i >= length) {
                    break;
                }
                com.baidu.tieba.ala.data.k kVar = kVarArr[i];
                if (kVar.getStatus() != 0) {
                    i++;
                } else {
                    agVar5.aJt = kVar.getGiftId();
                    break;
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, agVar5));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cjp() {
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
        hGx = true;
        this.hGC = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a extends Handler {
        private final WeakReference<AlaSeriesGiftPendant> hGY;

        public a(AlaSeriesGiftPendant alaSeriesGiftPendant) {
            this.hGY = new WeakReference<>(alaSeriesGiftPendant);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (this.hGY.get() != null) {
                if (message.what == 1 && !AlaSeriesGiftPendant.hGy) {
                    this.hGY.get().cjm();
                } else if (message.what == 2) {
                    this.hGY.get().setCountDownNum(this.hGY.get().hGz);
                } else if (message.what == 3) {
                    this.hGY.get().cjp();
                } else if (message.what == 4) {
                    this.hGY.get().cjn();
                } else if (message.what == 5) {
                    this.hGY.get().cjl();
                }
            }
        }
    }

    public void onDestroy() {
        super.onDetachedFromWindow();
    }

    public void setCanVisible(boolean z) {
        this.hGP = z;
        this.mView.setVisibility(z ? 0 : 8);
        if (z) {
            hGx = false;
        }
    }

    private void getSpinTime() {
        this.hGR = com.baidu.live.z.a.Pq().bmJ.aLw * 1000;
        this.hGS = com.baidu.live.z.a.Pq().bmJ.aLx * 1000;
    }
}
