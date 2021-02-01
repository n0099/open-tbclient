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
import com.baidu.live.data.ao;
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
    public static volatile boolean ijF = true;
    public static volatile boolean ijG = false;
    private FrameLayout container;
    Context context;
    public volatile int ijH;
    private volatile boolean ijI;
    private volatile boolean ijJ;
    private volatile boolean ijK;
    private LinearLayout ijL;
    private LinearLayout ijM;
    private LinearLayout ijN;
    private HeadImageView ijO;
    private HeadImageView ijP;
    private HeadImageView ijQ;
    private HeadImageView ijR;
    private AnimatorSet ijS;
    private AnimatorSet ijT;
    private TextView ijU;
    private Button ijV;
    private volatile boolean ijW;
    private boolean ijX;
    private boolean ijY;
    private int ijZ;
    private int ika;
    com.baidu.tieba.ala.data.j ikb;
    com.baidu.tieba.ala.data.k[] ikc;
    HashMap<Integer, HeadImageView> ikd;
    a ike;
    boolean isHost;
    private View mView;
    private TextView titleText;

    public AlaSeriesGiftPendant(Context context, boolean z, String str) {
        super(context);
        this.ijH = 0;
        this.ijI = false;
        this.ijJ = false;
        this.ijK = true;
        this.ijS = new AnimatorSet();
        this.ijT = new AnimatorSet();
        this.ijW = false;
        this.ijX = false;
        this.ikd = new HashMap<>();
        this.ike = new a(this);
        this.context = context;
        this.isHost = z;
        this.ijY = true;
        initView();
        cpB();
        getSpinTime();
        if (str != null) {
            try {
                ef(new JSONObject(str));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void initView() {
        this.mView = LayoutInflater.from(this.context).inflate(a.g.ala_pendant_series_gift, (ViewGroup) this, true);
        this.container = (FrameLayout) this.mView.findViewById(a.f.pendant_card_container);
        this.ijL = (LinearLayout) this.mView.findViewById(a.f.front_view);
        this.ijM = (LinearLayout) this.mView.findViewById(a.f.back_view);
        this.ijV = (Button) this.mView.findViewById(a.f.pendant_send_btn);
        this.ijV.setOnClickListener(this);
        this.ijU = (TextView) this.mView.findViewById(a.f.pendant_countdown_text);
        this.ijO = (HeadImageView) this.mView.findViewById(a.f.first_icon);
        this.ijO.setOnClickListener(this);
        this.ikd.put(0, this.ijO);
        this.ijP = (HeadImageView) this.mView.findViewById(a.f.second_icon);
        this.ijP.setOnClickListener(this);
        this.ikd.put(1, this.ijP);
        this.ijQ = (HeadImageView) this.mView.findViewById(a.f.third_icon);
        this.ijQ.setOnClickListener(this);
        this.ikd.put(2, this.ijQ);
        this.ijR = (HeadImageView) this.mView.findViewById(a.f.fourth_icon);
        this.ijR.setOnClickListener(this);
        this.ikd.put(3, this.ijR);
        this.ijN = (LinearLayout) this.mView.findViewById(a.f.second_row);
        this.titleText = (TextView) this.mView.findViewById(a.f.title_text);
        this.ijM.setVisibility(8);
        setCanVisible(false);
    }

    private void cpB() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ijL, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(750L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.ijL, "alpha", 0.0f, 1.0f);
        ofFloat2.setDuration(750L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.ijM, "alpha", 1.0f, 0.0f);
        ofFloat3.setDuration(750L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.ijM, "alpha", 0.0f, 1.0f);
        ofFloat4.setDuration(750L);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.ijL, "scaleX", 1.0f, 0.0f);
        ofFloat5.setDuration(750L);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.ijL, "scaleY", 1.0f, 0.0f);
        ofFloat6.setDuration(750L);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.ijL, "scaleX", 0.0f, 1.0f);
        ofFloat7.setDuration(750L);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.ijL, "scaleY", 0.0f, 1.0f);
        ofFloat8.setDuration(750L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.ijM, "scaleX", 1.0f, 0.0f);
        ofFloat9.setDuration(750L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.ijM, "scaleY", 1.0f, 0.0f);
        ofFloat10.setDuration(750L);
        ObjectAnimator ofFloat11 = ObjectAnimator.ofFloat(this.ijM, "scaleX", 0.0f, 1.0f);
        ofFloat11.setDuration(750L);
        ObjectAnimator ofFloat12 = ObjectAnimator.ofFloat(this.ijM, "scaleY", 0.0f, 1.0f);
        ofFloat12.setDuration(750L);
        this.ijS.play(ofFloat2).with(ofFloat7).with(ofFloat8).with(ofFloat3).with(ofFloat9).with(ofFloat10);
        this.ijT.play(ofFloat4).with(ofFloat11).with(ofFloat12).with(ofFloat).with(ofFloat5).with(ofFloat6);
        this.ijS.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                AlaSeriesGiftPendant.this.container.setClickable(false);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSeriesGiftPendant.this.pk(true);
                super.onAnimationEnd(animator);
            }
        });
        this.ijT.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                AlaSeriesGiftPendant.this.ijM.setVisibility(0);
                AlaSeriesGiftPendant.this.container.setClickable(false);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSeriesGiftPendant.this.pk(false);
                super.onAnimationEnd(animator);
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tieba.ala.view.AlaSeriesGiftPendant$3] */
    public void cpC() {
        new Thread() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.3
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                while (AlaSeriesGiftPendant.this.ijH >= 0 && AlaSeriesGiftPendant.this.ijK) {
                    if (!AlaSeriesGiftPendant.ijG) {
                        if (AlaSeriesGiftPendant.this.ijY) {
                            AlaSeriesGiftPendant.this.ike.sendEmptyMessageDelayed(1, AlaSeriesGiftPendant.this.ijZ);
                            try {
                                sleep(AlaSeriesGiftPendant.this.ijZ + AlaSeriesGiftPendant.this.ika);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            AlaSeriesGiftPendant.this.ijY = false;
                        }
                        if (!AlaSeriesGiftPendant.this.ijW) {
                            AlaSeriesGiftPendant.this.ijI = true;
                            AlaSeriesGiftPendant.this.ike.sendEmptyMessage(1);
                            try {
                                sleep(AlaSeriesGiftPendant.this.ika);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        } else {
                            AlaSeriesGiftPendant.this.ijI = true;
                            AlaSeriesGiftPendant.this.ike.sendEmptyMessage(1);
                            try {
                                sleep(AlaSeriesGiftPendant.this.ijZ);
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                    } else {
                        AlaSeriesGiftPendant.this.ike.sendEmptyMessage(4);
                        return;
                    }
                }
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.tieba.ala.view.AlaSeriesGiftPendant$4] */
    public void startCountDown() {
        if (this.ijH <= 0) {
            this.ijJ = false;
        } else {
            new Thread() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.4
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (true) {
                        if (AlaSeriesGiftPendant.this.ijH <= 0) {
                            break;
                        } else if (!AlaSeriesGiftPendant.ijG) {
                            AlaSeriesGiftPendant.this.ijJ = true;
                            AlaSeriesGiftPendant.this.ike.sendEmptyMessage(2);
                            AlaSeriesGiftPendant alaSeriesGiftPendant = AlaSeriesGiftPendant.this;
                            alaSeriesGiftPendant.ijH--;
                            try {
                                sleep(1000L);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            AlaSeriesGiftPendant.this.ike.sendEmptyMessage(5);
                            break;
                        }
                    }
                    try {
                        sleep(2000L);
                        if (AlaSeriesGiftPendant.this.ijH <= 0) {
                            AlaSeriesGiftPendant.this.ike.sendEmptyMessage(3);
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
        this.ijU.setText(i + "s");
        this.ijV.setText("赠送" + i + "s");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpD() {
        this.ijU.setText(" ");
        this.ijJ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpE() {
        if (this.ijW) {
            this.ijW = false;
            this.ijS.start();
        } else if (this.ijK) {
            this.ijW = true;
            this.ijT.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpF() {
        if (this.ijW) {
            this.ijS.start();
            this.ijW = false;
            return;
        }
        this.ijK = false;
    }

    public void ef(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ikb = new com.baidu.tieba.ala.data.j();
            this.ikb.parserJson(jSONObject);
            this.ikc = this.ikb.bUm();
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
            this.ijH = this.ikb.bUk();
            if (this.ikb.bUl()) {
                cpD();
            } else {
                setCountDownNum(this.ijH);
            }
            this.titleText.setText(this.ikb.EV() == null ? "套系礼物" : this.ikb.EV());
            switch (this.ikc.length) {
                case 2:
                    this.ijN.setVisibility(8);
                    break;
                case 3:
                    this.ijN.setVisibility(0);
                    this.ijR.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ijQ.getLayoutParams());
                    layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds58);
                    this.ijQ.setLayoutParams(layoutParams);
                    break;
                case 4:
                    this.ijN.setVisibility(0);
                    break;
            }
            for (int i = 0; i < this.ikc.length; i++) {
                if (this.ikc[i].getStatus() == 0) {
                    HeadImageView headImageView = this.ikd.get(Integer.valueOf(i));
                    headImageView.setIsRound(true);
                    headImageView.setBorderColor(this.context.getResources().getColor(a.c.sdk_black_alpha10));
                    headImageView.setAutoChangeStyle(false);
                    headImageView.stopLoad();
                    headImageView.startLoad(this.ikc[i].bUn(), 12, false, false);
                } else if (this.ikc[i].getStatus() == 1) {
                    HeadImageView headImageView2 = this.ikd.get(Integer.valueOf(i));
                    headImageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    headImageView2.setIsRound(true);
                    headImageView2.setBorderColor(this.context.getResources().getColor(a.c.sdk_black_alpha10));
                    headImageView2.setAutoChangeStyle(false);
                    headImageView2.stopLoad();
                    headImageView2.startLoad(this.ikc[i].getPortrait(), 12, false, false);
                }
            }
            setCanVisible(true);
            if (this.ikb.bUl()) {
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
                ijG = true;
                this.ike.sendEmptyMessageDelayed(3, IMConnection.RETRY_DELAY_TIMES);
            } else {
                ijG = false;
            }
            if (!this.ijI && !this.ijJ) {
                startCountDown();
                if (!this.isHost) {
                    cpC();
                }
            }
            if (this.isHost) {
                this.ijL.setOnClickListener(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pk(boolean z) {
        if (z) {
            this.ijO.setClickable(true);
            this.ijP.setClickable(true);
            this.ijQ.setClickable(true);
            this.ijR.setClickable(true);
            this.ijV.setClickable(false);
            return;
        }
        this.ijO.setClickable(false);
        this.ijP.setClickable(false);
        this.ijQ.setClickable(false);
        this.ijR.setClickable(false);
        this.ijV.setClickable(true);
    }

    private void cpG() {
        if (this.ikb.EV() == null) {
            BdUtilHelper.showToast(this.context, "每" + this.ikb.bUk() + "s内送出1个套系礼物，集齐全部获得惊喜特效，尊享全站广播哟！");
        } else {
            BdUtilHelper.showToast(this.context, "每" + this.ikb.bUk() + "s内送出1个" + this.ikb.EV() + "系列礼物，集齐全部获得惊喜特效，尊享全站广播哟！");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = 0;
        if (this.isHost || this.ikc == null) {
            cpG();
        } else if (this.ijO == view) {
            if (this.ikc[0].getStatus() == 1) {
                AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.ikc[0].bUo()));
                alaPersonCardActivityConfig.setExtInfo(this.ikc[0].bUp());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                return;
            }
            ao aoVar = new ao();
            aoVar.aJX = this.ikc[0].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aoVar));
        } else if (this.ijP == view) {
            if (this.ikc[1].getStatus() == 1) {
                AlaPersonCardActivityConfig alaPersonCardActivityConfig2 = new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.ikc[1].bUo()));
                alaPersonCardActivityConfig2.setExtInfo(this.ikc[1].bUp());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig2));
                return;
            }
            ao aoVar2 = new ao();
            aoVar2.aJX = this.ikc[1].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aoVar2));
        } else if (this.ijQ == view) {
            if (this.ikc[2].getStatus() == 1) {
                AlaPersonCardActivityConfig alaPersonCardActivityConfig3 = new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.ikc[2].bUo()));
                alaPersonCardActivityConfig3.setExtInfo(this.ikc[2].bUp());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig3));
                return;
            }
            ao aoVar3 = new ao();
            aoVar3.aJX = this.ikc[2].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aoVar3));
        } else if (this.ijR == view) {
            if (this.ikc[3].getStatus() == 1) {
                AlaPersonCardActivityConfig alaPersonCardActivityConfig4 = new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.ikc[3].bUo()));
                alaPersonCardActivityConfig4.setExtInfo(this.ikc[3].bUp());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig4));
                return;
            }
            ao aoVar4 = new ao();
            aoVar4.aJX = this.ikc[3].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aoVar4));
        } else if (this.ijV == view) {
            ao aoVar5 = new ao();
            aoVar5.aJW = -1;
            aoVar5.aJX = -1;
            aoVar5.aJZ = null;
            com.baidu.tieba.ala.data.k[] kVarArr = this.ikc;
            int length = kVarArr.length;
            while (true) {
                if (i >= length) {
                    break;
                }
                com.baidu.tieba.ala.data.k kVar = kVarArr[i];
                if (kVar.getStatus() != 0) {
                    i++;
                } else {
                    aoVar5.aJX = kVar.getGiftId();
                    break;
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aoVar5));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cpH() {
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
        ijF = true;
        this.ijK = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a extends Handler {
        private final WeakReference<AlaSeriesGiftPendant> ikg;

        public a(AlaSeriesGiftPendant alaSeriesGiftPendant) {
            this.ikg = new WeakReference<>(alaSeriesGiftPendant);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (this.ikg.get() != null) {
                if (message.what == 1 && !AlaSeriesGiftPendant.ijG) {
                    this.ikg.get().cpE();
                } else if (message.what == 2) {
                    this.ikg.get().setCountDownNum(this.ikg.get().ijH);
                } else if (message.what == 3) {
                    this.ikg.get().cpH();
                } else if (message.what == 4) {
                    this.ikg.get().cpF();
                } else if (message.what == 5) {
                    this.ikg.get().cpD();
                }
            }
        }
    }

    public void setCanVisible(boolean z) {
        this.ijX = z;
        this.mView.setVisibility(z ? 0 : 8);
        if (z) {
            ijF = false;
        }
    }

    private void getSpinTime() {
        this.ijZ = com.baidu.live.ae.a.Qj().buX.aMh * 1000;
        this.ika = com.baidu.live.ae.a.Qj().buX.aMi * 1000;
    }
}
