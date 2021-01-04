package com.baidu.tieba.ala.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.ak;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class AlaSeriesGiftPendant extends LinearLayout implements View.OnClickListener {
    public static volatile boolean ijx = true;
    public static volatile boolean ijy = false;
    private FrameLayout container;
    Context context;
    private volatile boolean ijA;
    private volatile boolean ijB;
    private volatile boolean ijC;
    private LinearLayout ijD;
    private LinearLayout ijE;
    private LinearLayout ijF;
    private HeadImageView ijG;
    private HeadImageView ijH;
    private HeadImageView ijI;
    private HeadImageView ijJ;
    private AnimatorSet ijK;
    private AnimatorSet ijL;
    private TextView ijM;
    private Button ijN;
    private volatile boolean ijO;
    private boolean ijP;
    private boolean ijQ;
    private int ijR;
    private int ijS;
    com.baidu.tieba.ala.data.j ijT;
    com.baidu.tieba.ala.data.k[] ijU;
    HashMap<Integer, HeadImageView> ijV;
    a ijW;
    private final int ijs;
    private final int ijt;
    private final int iju;
    private final int ijv;
    private final int ijw;
    public volatile int ijz;
    boolean isHost;
    private View mView;
    private TextView titleText;

    public AlaSeriesGiftPendant(Context context, boolean z, String str) {
        super(context);
        this.ijs = 4;
        this.ijt = 0;
        this.iju = 1;
        this.ijv = 2;
        this.ijw = 3;
        this.ijz = 0;
        this.ijA = false;
        this.ijB = false;
        this.ijC = true;
        this.ijK = new AnimatorSet();
        this.ijL = new AnimatorSet();
        this.ijO = false;
        this.ijP = false;
        this.ijV = new HashMap<>();
        this.ijW = new a(this);
        this.context = context;
        this.isHost = z;
        this.ijQ = true;
        initView();
        csn();
        getSpinTime();
        if (str != null) {
            try {
                ee(new JSONObject(str));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void initView() {
        this.mView = LayoutInflater.from(this.context).inflate(a.g.ala_pendant_series_gift, (ViewGroup) this, true);
        this.container = (FrameLayout) this.mView.findViewById(a.f.pendant_card_container);
        this.ijD = (LinearLayout) this.mView.findViewById(a.f.front_view);
        this.ijE = (LinearLayout) this.mView.findViewById(a.f.back_view);
        this.ijN = (Button) this.mView.findViewById(a.f.pendant_send_btn);
        this.ijN.setOnClickListener(this);
        this.ijM = (TextView) this.mView.findViewById(a.f.pendant_countdown_text);
        this.ijG = (HeadImageView) this.mView.findViewById(a.f.first_icon);
        this.ijG.setOnClickListener(this);
        this.ijV.put(0, this.ijG);
        this.ijH = (HeadImageView) this.mView.findViewById(a.f.second_icon);
        this.ijH.setOnClickListener(this);
        this.ijV.put(1, this.ijH);
        this.ijI = (HeadImageView) this.mView.findViewById(a.f.third_icon);
        this.ijI.setOnClickListener(this);
        this.ijV.put(2, this.ijI);
        this.ijJ = (HeadImageView) this.mView.findViewById(a.f.fourth_icon);
        this.ijJ.setOnClickListener(this);
        this.ijV.put(3, this.ijJ);
        this.ijF = (LinearLayout) this.mView.findViewById(a.f.second_row);
        this.titleText = (TextView) this.mView.findViewById(a.f.title_text);
        this.ijE.setVisibility(8);
        setCanVisible(false);
    }

    private void csn() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ijD, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(750L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.ijD, "alpha", 0.0f, 1.0f);
        ofFloat2.setDuration(750L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.ijE, "alpha", 1.0f, 0.0f);
        ofFloat3.setDuration(750L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.ijE, "alpha", 0.0f, 1.0f);
        ofFloat4.setDuration(750L);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.ijD, "scaleX", 1.0f, 0.0f);
        ofFloat5.setDuration(750L);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.ijD, "scaleY", 1.0f, 0.0f);
        ofFloat6.setDuration(750L);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.ijD, "scaleX", 0.0f, 1.0f);
        ofFloat7.setDuration(750L);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.ijD, "scaleY", 0.0f, 1.0f);
        ofFloat8.setDuration(750L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.ijE, "scaleX", 1.0f, 0.0f);
        ofFloat9.setDuration(750L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.ijE, "scaleY", 1.0f, 0.0f);
        ofFloat10.setDuration(750L);
        ObjectAnimator ofFloat11 = ObjectAnimator.ofFloat(this.ijE, "scaleX", 0.0f, 1.0f);
        ofFloat11.setDuration(750L);
        ObjectAnimator ofFloat12 = ObjectAnimator.ofFloat(this.ijE, "scaleY", 0.0f, 1.0f);
        ofFloat12.setDuration(750L);
        this.ijK.play(ofFloat2).with(ofFloat7).with(ofFloat8).with(ofFloat3).with(ofFloat9).with(ofFloat10);
        this.ijL.play(ofFloat4).with(ofFloat11).with(ofFloat12).with(ofFloat).with(ofFloat5).with(ofFloat6);
        this.ijK.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                AlaSeriesGiftPendant.this.container.setClickable(false);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSeriesGiftPendant.this.pe(true);
                super.onAnimationEnd(animator);
            }
        });
        this.ijL.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                AlaSeriesGiftPendant.this.ijE.setVisibility(0);
                AlaSeriesGiftPendant.this.container.setClickable(false);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSeriesGiftPendant.this.pe(false);
                super.onAnimationEnd(animator);
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tieba.ala.view.AlaSeriesGiftPendant$3] */
    public void cso() {
        new Thread() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.3
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                while (AlaSeriesGiftPendant.this.ijz >= 0 && AlaSeriesGiftPendant.this.ijC) {
                    if (!AlaSeriesGiftPendant.ijy) {
                        if (AlaSeriesGiftPendant.this.ijQ) {
                            AlaSeriesGiftPendant.this.ijW.sendEmptyMessageDelayed(1, AlaSeriesGiftPendant.this.ijR);
                            try {
                                sleep(AlaSeriesGiftPendant.this.ijR + AlaSeriesGiftPendant.this.ijS);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            AlaSeriesGiftPendant.this.ijQ = false;
                        }
                        if (!AlaSeriesGiftPendant.this.ijO) {
                            AlaSeriesGiftPendant.this.ijA = true;
                            AlaSeriesGiftPendant.this.ijW.sendEmptyMessage(1);
                            try {
                                sleep(AlaSeriesGiftPendant.this.ijS);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        } else {
                            AlaSeriesGiftPendant.this.ijA = true;
                            AlaSeriesGiftPendant.this.ijW.sendEmptyMessage(1);
                            try {
                                sleep(AlaSeriesGiftPendant.this.ijR);
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                    } else {
                        AlaSeriesGiftPendant.this.ijW.sendEmptyMessage(4);
                        return;
                    }
                }
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.tieba.ala.view.AlaSeriesGiftPendant$4] */
    public void startCountDown() {
        if (this.ijz <= 0) {
            this.ijB = false;
        } else {
            new Thread() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.4
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (true) {
                        if (AlaSeriesGiftPendant.this.ijz <= 0) {
                            break;
                        } else if (!AlaSeriesGiftPendant.ijy) {
                            AlaSeriesGiftPendant.this.ijB = true;
                            AlaSeriesGiftPendant.this.ijW.sendEmptyMessage(2);
                            AlaSeriesGiftPendant alaSeriesGiftPendant = AlaSeriesGiftPendant.this;
                            alaSeriesGiftPendant.ijz--;
                            try {
                                sleep(1000L);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            AlaSeriesGiftPendant.this.ijW.sendEmptyMessage(5);
                            break;
                        }
                    }
                    try {
                        sleep(2000L);
                        if (AlaSeriesGiftPendant.this.ijz <= 0) {
                            AlaSeriesGiftPendant.this.ijW.sendEmptyMessage(3);
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
        this.ijM.setText(i + "s");
        this.ijN.setText("赠送" + i + "s");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csp() {
        this.ijM.setText(" ");
        this.ijB = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csq() {
        if (this.ijO) {
            this.ijO = false;
            this.ijK.start();
        } else if (this.ijC) {
            this.ijO = true;
            this.ijL.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csr() {
        if (this.ijO) {
            this.ijK.start();
            this.ijO = false;
            return;
        }
        this.ijC = false;
    }

    public void ee(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ijT = new com.baidu.tieba.ala.data.j();
            this.ijT.parserJson(jSONObject);
            this.ijU = this.ijT.bXy();
            JSONObject jSONObject2 = new JSONObject();
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(LogConfig.LOG_GIFT_ID, jSONObject.optInt(LogConfig.LOG_GIFT_ID));
                jSONObject3.put("tying_gift_id", jSONObject.optLong("tying_gift_id"));
                jSONObject2.putOpt(UbcStatConstant.ContentType.UBC_TYPE_TYING_GIFT, jSONObject3);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_TYING_GIFT, UbcStatConstant.ContentType.UBC_TYPE_TYING_GIFT, this.isHost ? "author_liveroom" : "liveroom", UbcStatConstant.Value.VALUE_TYING_IM_REC).setContentExt(null, null, jSONObject2));
            this.ijz = this.ijT.bXw();
            if (this.ijT.bXx()) {
                csp();
            } else {
                setCountDownNum(this.ijz);
            }
            this.titleText.setText(this.ijT.HA() == null ? "套系礼物" : this.ijT.HA());
            switch (this.ijU.length) {
                case 2:
                    this.ijF.setVisibility(8);
                    break;
                case 3:
                    this.ijF.setVisibility(0);
                    this.ijJ.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ijI.getLayoutParams());
                    layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds58);
                    this.ijI.setLayoutParams(layoutParams);
                    break;
                case 4:
                    this.ijF.setVisibility(0);
                    break;
            }
            for (int i = 0; i < this.ijU.length; i++) {
                if (this.ijU[i].getStatus() == 0) {
                    HeadImageView headImageView = this.ijV.get(Integer.valueOf(i));
                    headImageView.setIsRound(true);
                    headImageView.setBorderColor(this.context.getResources().getColor(a.c.sdk_black_alpha10));
                    headImageView.setAutoChangeStyle(false);
                    headImageView.stopLoad();
                    headImageView.startLoad(this.ijU[i].bXz(), 12, false, false);
                } else if (this.ijU[i].getStatus() == 1) {
                    HeadImageView headImageView2 = this.ijV.get(Integer.valueOf(i));
                    headImageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    headImageView2.setIsRound(true);
                    headImageView2.setBorderColor(this.context.getResources().getColor(a.c.sdk_black_alpha10));
                    headImageView2.setAutoChangeStyle(false);
                    headImageView2.stopLoad();
                    headImageView2.startLoad(this.ijU[i].getPortrait(), 12, false, false);
                }
            }
            setCanVisible(true);
            if (this.ijT.bXx()) {
                JSONObject jSONObject4 = new JSONObject();
                try {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put(LogConfig.LOG_GIFT_ID, jSONObject.optInt(LogConfig.LOG_GIFT_ID));
                    jSONObject5.put("tying_gift_id", jSONObject.optLong("tying_gift_id"));
                    jSONObject4.putOpt(UbcStatConstant.ContentType.UBC_TYPE_TYING_GIFT, jSONObject5);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_TYING_GIFT, UbcStatConstant.ContentType.UBC_TYPE_TYING_GIFT, this.isHost ? "author_liveroom" : "liveroom", UbcStatConstant.Value.VALUE_TYING_GIFT_GATHER).setContentExt(null, null, jSONObject4));
                ijy = true;
                this.ijW.sendEmptyMessageDelayed(3, IMConnection.RETRY_DELAY_TIMES);
            } else {
                ijy = false;
            }
            if (!this.ijA && !this.ijB) {
                startCountDown();
                if (!this.isHost) {
                    cso();
                }
            }
            if (this.isHost) {
                this.ijD.setOnClickListener(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pe(boolean z) {
        if (z) {
            this.ijG.setClickable(true);
            this.ijH.setClickable(true);
            this.ijI.setClickable(true);
            this.ijJ.setClickable(true);
            this.ijN.setClickable(false);
            return;
        }
        this.ijG.setClickable(false);
        this.ijH.setClickable(false);
        this.ijI.setClickable(false);
        this.ijJ.setClickable(false);
        this.ijN.setClickable(true);
    }

    private void css() {
        if (this.ijT.HA() == null) {
            BdUtilHelper.showToast(this.context, "每" + this.ijT.bXw() + "s内送出1个套系礼物，集齐全部获得惊喜特效，尊享全站广播哟！");
        } else {
            BdUtilHelper.showToast(this.context, "每" + this.ijT.bXw() + "s内送出1个" + this.ijT.HA() + "系列礼物，集齐全部获得惊喜特效，尊享全站广播哟！");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = 0;
        if (this.isHost || this.ijU == null) {
            css();
        } else if (this.ijG == view) {
            if (this.ijU[0].getStatus() == 1) {
                AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.ijU[0].bXA()));
                alaPersonCardActivityConfig.setExtInfo(this.ijU[0].bXB());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                return;
            }
            ak akVar = new ak();
            akVar.aMf = this.ijU[0].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, akVar));
        } else if (this.ijH == view) {
            if (this.ijU[1].getStatus() == 1) {
                AlaPersonCardActivityConfig alaPersonCardActivityConfig2 = new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.ijU[1].bXA()));
                alaPersonCardActivityConfig2.setExtInfo(this.ijU[1].bXB());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig2));
                return;
            }
            ak akVar2 = new ak();
            akVar2.aMf = this.ijU[1].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, akVar2));
        } else if (this.ijI == view) {
            if (this.ijU[2].getStatus() == 1) {
                AlaPersonCardActivityConfig alaPersonCardActivityConfig3 = new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.ijU[2].bXA()));
                alaPersonCardActivityConfig3.setExtInfo(this.ijU[2].bXB());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig3));
                return;
            }
            ak akVar3 = new ak();
            akVar3.aMf = this.ijU[2].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, akVar3));
        } else if (this.ijJ == view) {
            if (this.ijU[3].getStatus() == 1) {
                AlaPersonCardActivityConfig alaPersonCardActivityConfig4 = new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.ijU[3].bXA()));
                alaPersonCardActivityConfig4.setExtInfo(this.ijU[3].bXB());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig4));
                return;
            }
            ak akVar4 = new ak();
            akVar4.aMf = this.ijU[3].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, akVar4));
        } else if (this.ijN == view) {
            ak akVar5 = new ak();
            akVar5.aMe = -1;
            akVar5.aMf = -1;
            akVar5.aMh = null;
            com.baidu.tieba.ala.data.k[] kVarArr = this.ijU;
            int length = kVarArr.length;
            while (true) {
                if (i >= length) {
                    break;
                }
                com.baidu.tieba.ala.data.k kVar = kVarArr[i];
                if (kVar.getStatus() != 0) {
                    i++;
                } else {
                    akVar5.aMf = kVar.getGiftId();
                    break;
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, akVar5));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cst() {
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
        ijx = true;
        this.ijC = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a extends Handler {
        private final WeakReference<AlaSeriesGiftPendant> ijY;

        public a(AlaSeriesGiftPendant alaSeriesGiftPendant) {
            this.ijY = new WeakReference<>(alaSeriesGiftPendant);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (this.ijY.get() != null) {
                if (message.what == 1 && !AlaSeriesGiftPendant.ijy) {
                    this.ijY.get().csq();
                } else if (message.what == 2) {
                    this.ijY.get().setCountDownNum(this.ijY.get().ijz);
                } else if (message.what == 3) {
                    this.ijY.get().cst();
                } else if (message.what == 4) {
                    this.ijY.get().csr();
                } else if (message.what == 5) {
                    this.ijY.get().csp();
                }
            }
        }
    }

    public void setCanVisible(boolean z) {
        this.ijP = z;
        this.mView.setVisibility(z ? 0 : 8);
        if (z) {
            ijx = false;
        }
    }

    private void getSpinTime() {
        this.ijR = com.baidu.live.af.a.SE().bwi.aOk * 1000;
        this.ijS = com.baidu.live.af.a.SE().bwi.aOl * 1000;
    }
}
