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
/* loaded from: classes10.dex */
public class AlaSeriesGiftPendant extends LinearLayout implements View.OnClickListener {
    public static volatile boolean ilC = true;
    public static volatile boolean ilD = false;
    private FrameLayout container;
    Context context;
    public volatile int ilE;
    private volatile boolean ilF;
    private volatile boolean ilG;
    private volatile boolean ilH;
    private LinearLayout ilI;
    private LinearLayout ilJ;
    private LinearLayout ilK;
    private HeadImageView ilL;
    private HeadImageView ilM;
    private HeadImageView ilN;
    private HeadImageView ilO;
    private AnimatorSet ilP;
    private AnimatorSet ilQ;
    private TextView ilR;
    private Button ilS;
    private volatile boolean ilT;
    private boolean ilU;
    private boolean ilV;
    private int ilW;
    private int ilX;
    com.baidu.tieba.ala.data.j ilY;
    com.baidu.tieba.ala.data.k[] ilZ;
    HashMap<Integer, HeadImageView> ima;
    a imb;
    boolean isHost;
    private View mView;
    private TextView titleText;

    public AlaSeriesGiftPendant(Context context, boolean z, String str) {
        super(context);
        this.ilE = 0;
        this.ilF = false;
        this.ilG = false;
        this.ilH = true;
        this.ilP = new AnimatorSet();
        this.ilQ = new AnimatorSet();
        this.ilT = false;
        this.ilU = false;
        this.ima = new HashMap<>();
        this.imb = new a(this);
        this.context = context;
        this.isHost = z;
        this.ilV = true;
        initView();
        cpO();
        getSpinTime();
        if (str != null) {
            try {
                eh(new JSONObject(str));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void initView() {
        this.mView = LayoutInflater.from(this.context).inflate(a.g.ala_pendant_series_gift, (ViewGroup) this, true);
        this.container = (FrameLayout) this.mView.findViewById(a.f.pendant_card_container);
        this.ilI = (LinearLayout) this.mView.findViewById(a.f.front_view);
        this.ilJ = (LinearLayout) this.mView.findViewById(a.f.back_view);
        this.ilS = (Button) this.mView.findViewById(a.f.pendant_send_btn);
        this.ilS.setOnClickListener(this);
        this.ilR = (TextView) this.mView.findViewById(a.f.pendant_countdown_text);
        this.ilL = (HeadImageView) this.mView.findViewById(a.f.first_icon);
        this.ilL.setOnClickListener(this);
        this.ima.put(0, this.ilL);
        this.ilM = (HeadImageView) this.mView.findViewById(a.f.second_icon);
        this.ilM.setOnClickListener(this);
        this.ima.put(1, this.ilM);
        this.ilN = (HeadImageView) this.mView.findViewById(a.f.third_icon);
        this.ilN.setOnClickListener(this);
        this.ima.put(2, this.ilN);
        this.ilO = (HeadImageView) this.mView.findViewById(a.f.fourth_icon);
        this.ilO.setOnClickListener(this);
        this.ima.put(3, this.ilO);
        this.ilK = (LinearLayout) this.mView.findViewById(a.f.second_row);
        this.titleText = (TextView) this.mView.findViewById(a.f.title_text);
        this.ilJ.setVisibility(8);
        setCanVisible(false);
    }

    private void cpO() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ilI, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(750L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.ilI, "alpha", 0.0f, 1.0f);
        ofFloat2.setDuration(750L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.ilJ, "alpha", 1.0f, 0.0f);
        ofFloat3.setDuration(750L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.ilJ, "alpha", 0.0f, 1.0f);
        ofFloat4.setDuration(750L);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.ilI, "scaleX", 1.0f, 0.0f);
        ofFloat5.setDuration(750L);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.ilI, "scaleY", 1.0f, 0.0f);
        ofFloat6.setDuration(750L);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.ilI, "scaleX", 0.0f, 1.0f);
        ofFloat7.setDuration(750L);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.ilI, "scaleY", 0.0f, 1.0f);
        ofFloat8.setDuration(750L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.ilJ, "scaleX", 1.0f, 0.0f);
        ofFloat9.setDuration(750L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.ilJ, "scaleY", 1.0f, 0.0f);
        ofFloat10.setDuration(750L);
        ObjectAnimator ofFloat11 = ObjectAnimator.ofFloat(this.ilJ, "scaleX", 0.0f, 1.0f);
        ofFloat11.setDuration(750L);
        ObjectAnimator ofFloat12 = ObjectAnimator.ofFloat(this.ilJ, "scaleY", 0.0f, 1.0f);
        ofFloat12.setDuration(750L);
        this.ilP.play(ofFloat2).with(ofFloat7).with(ofFloat8).with(ofFloat3).with(ofFloat9).with(ofFloat10);
        this.ilQ.play(ofFloat4).with(ofFloat11).with(ofFloat12).with(ofFloat).with(ofFloat5).with(ofFloat6);
        this.ilP.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.1
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
        this.ilQ.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                AlaSeriesGiftPendant.this.ilJ.setVisibility(0);
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
    public void cpP() {
        new Thread() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.3
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                while (AlaSeriesGiftPendant.this.ilE >= 0 && AlaSeriesGiftPendant.this.ilH) {
                    if (!AlaSeriesGiftPendant.ilD) {
                        if (AlaSeriesGiftPendant.this.ilV) {
                            AlaSeriesGiftPendant.this.imb.sendEmptyMessageDelayed(1, AlaSeriesGiftPendant.this.ilW);
                            try {
                                sleep(AlaSeriesGiftPendant.this.ilW + AlaSeriesGiftPendant.this.ilX);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            AlaSeriesGiftPendant.this.ilV = false;
                        }
                        if (!AlaSeriesGiftPendant.this.ilT) {
                            AlaSeriesGiftPendant.this.ilF = true;
                            AlaSeriesGiftPendant.this.imb.sendEmptyMessage(1);
                            try {
                                sleep(AlaSeriesGiftPendant.this.ilX);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        } else {
                            AlaSeriesGiftPendant.this.ilF = true;
                            AlaSeriesGiftPendant.this.imb.sendEmptyMessage(1);
                            try {
                                sleep(AlaSeriesGiftPendant.this.ilW);
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                    } else {
                        AlaSeriesGiftPendant.this.imb.sendEmptyMessage(4);
                        return;
                    }
                }
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.tieba.ala.view.AlaSeriesGiftPendant$4] */
    public void startCountDown() {
        if (this.ilE <= 0) {
            this.ilG = false;
        } else {
            new Thread() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.4
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (true) {
                        if (AlaSeriesGiftPendant.this.ilE <= 0) {
                            break;
                        } else if (!AlaSeriesGiftPendant.ilD) {
                            AlaSeriesGiftPendant.this.ilG = true;
                            AlaSeriesGiftPendant.this.imb.sendEmptyMessage(2);
                            AlaSeriesGiftPendant alaSeriesGiftPendant = AlaSeriesGiftPendant.this;
                            alaSeriesGiftPendant.ilE--;
                            try {
                                sleep(1000L);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            AlaSeriesGiftPendant.this.imb.sendEmptyMessage(5);
                            break;
                        }
                    }
                    try {
                        sleep(2000L);
                        if (AlaSeriesGiftPendant.this.ilE <= 0) {
                            AlaSeriesGiftPendant.this.imb.sendEmptyMessage(3);
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
        this.ilR.setText(i + "s");
        this.ilS.setText("赠送" + i + "s");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpQ() {
        this.ilR.setText(" ");
        this.ilG = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpR() {
        if (this.ilT) {
            this.ilT = false;
            this.ilP.start();
        } else if (this.ilH) {
            this.ilT = true;
            this.ilQ.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpS() {
        if (this.ilT) {
            this.ilP.start();
            this.ilT = false;
            return;
        }
        this.ilH = false;
    }

    public void eh(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ilY = new com.baidu.tieba.ala.data.j();
            this.ilY.parserJson(jSONObject);
            this.ilZ = this.ilY.bUz();
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
            this.ilE = this.ilY.bUx();
            if (this.ilY.bUy()) {
                cpQ();
            } else {
                setCountDownNum(this.ilE);
            }
            this.titleText.setText(this.ilY.EY() == null ? "套系礼物" : this.ilY.EY());
            switch (this.ilZ.length) {
                case 2:
                    this.ilK.setVisibility(8);
                    break;
                case 3:
                    this.ilK.setVisibility(0);
                    this.ilO.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ilN.getLayoutParams());
                    layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds58);
                    this.ilN.setLayoutParams(layoutParams);
                    break;
                case 4:
                    this.ilK.setVisibility(0);
                    break;
            }
            for (int i = 0; i < this.ilZ.length; i++) {
                if (this.ilZ[i].getStatus() == 0) {
                    HeadImageView headImageView = this.ima.get(Integer.valueOf(i));
                    headImageView.setIsRound(true);
                    headImageView.setBorderColor(this.context.getResources().getColor(a.c.sdk_black_alpha10));
                    headImageView.setAutoChangeStyle(false);
                    headImageView.stopLoad();
                    headImageView.startLoad(this.ilZ[i].bUA(), 12, false, false);
                } else if (this.ilZ[i].getStatus() == 1) {
                    HeadImageView headImageView2 = this.ima.get(Integer.valueOf(i));
                    headImageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    headImageView2.setIsRound(true);
                    headImageView2.setBorderColor(this.context.getResources().getColor(a.c.sdk_black_alpha10));
                    headImageView2.setAutoChangeStyle(false);
                    headImageView2.stopLoad();
                    headImageView2.startLoad(this.ilZ[i].getPortrait(), 12, false, false);
                }
            }
            setCanVisible(true);
            if (this.ilY.bUy()) {
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
                ilD = true;
                this.imb.sendEmptyMessageDelayed(3, IMConnection.RETRY_DELAY_TIMES);
            } else {
                ilD = false;
            }
            if (!this.ilF && !this.ilG) {
                startCountDown();
                if (!this.isHost) {
                    cpP();
                }
            }
            if (this.isHost) {
                this.ilI.setOnClickListener(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pk(boolean z) {
        if (z) {
            this.ilL.setClickable(true);
            this.ilM.setClickable(true);
            this.ilN.setClickable(true);
            this.ilO.setClickable(true);
            this.ilS.setClickable(false);
            return;
        }
        this.ilL.setClickable(false);
        this.ilM.setClickable(false);
        this.ilN.setClickable(false);
        this.ilO.setClickable(false);
        this.ilS.setClickable(true);
    }

    private void cpT() {
        if (this.ilY.EY() == null) {
            BdUtilHelper.showToast(this.context, "每" + this.ilY.bUx() + "s内送出1个套系礼物，集齐全部获得惊喜特效，尊享全站广播哟！");
        } else {
            BdUtilHelper.showToast(this.context, "每" + this.ilY.bUx() + "s内送出1个" + this.ilY.EY() + "系列礼物，集齐全部获得惊喜特效，尊享全站广播哟！");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = 0;
        if (this.isHost || this.ilZ == null) {
            cpT();
        } else if (this.ilL == view) {
            if (this.ilZ[0].getStatus() == 1) {
                AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.ilZ[0].bUB()));
                alaPersonCardActivityConfig.setExtInfo(this.ilZ[0].bUC());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                return;
            }
            ao aoVar = new ao();
            aoVar.aLx = this.ilZ[0].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aoVar));
        } else if (this.ilM == view) {
            if (this.ilZ[1].getStatus() == 1) {
                AlaPersonCardActivityConfig alaPersonCardActivityConfig2 = new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.ilZ[1].bUB()));
                alaPersonCardActivityConfig2.setExtInfo(this.ilZ[1].bUC());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig2));
                return;
            }
            ao aoVar2 = new ao();
            aoVar2.aLx = this.ilZ[1].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aoVar2));
        } else if (this.ilN == view) {
            if (this.ilZ[2].getStatus() == 1) {
                AlaPersonCardActivityConfig alaPersonCardActivityConfig3 = new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.ilZ[2].bUB()));
                alaPersonCardActivityConfig3.setExtInfo(this.ilZ[2].bUC());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig3));
                return;
            }
            ao aoVar3 = new ao();
            aoVar3.aLx = this.ilZ[2].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aoVar3));
        } else if (this.ilO == view) {
            if (this.ilZ[3].getStatus() == 1) {
                AlaPersonCardActivityConfig alaPersonCardActivityConfig4 = new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.ilZ[3].bUB()));
                alaPersonCardActivityConfig4.setExtInfo(this.ilZ[3].bUC());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig4));
                return;
            }
            ao aoVar4 = new ao();
            aoVar4.aLx = this.ilZ[3].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aoVar4));
        } else if (this.ilS == view) {
            ao aoVar5 = new ao();
            aoVar5.aLw = -1;
            aoVar5.aLx = -1;
            aoVar5.aLz = null;
            com.baidu.tieba.ala.data.k[] kVarArr = this.ilZ;
            int length = kVarArr.length;
            while (true) {
                if (i >= length) {
                    break;
                }
                com.baidu.tieba.ala.data.k kVar = kVarArr[i];
                if (kVar.getStatus() != 0) {
                    i++;
                } else {
                    aoVar5.aLx = kVar.getGiftId();
                    break;
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aoVar5));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void cpU() {
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
        ilC = true;
        this.ilH = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a extends Handler {
        private final WeakReference<AlaSeriesGiftPendant> imd;

        public a(AlaSeriesGiftPendant alaSeriesGiftPendant) {
            this.imd = new WeakReference<>(alaSeriesGiftPendant);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (this.imd.get() != null) {
                if (message.what == 1 && !AlaSeriesGiftPendant.ilD) {
                    this.imd.get().cpR();
                } else if (message.what == 2) {
                    this.imd.get().setCountDownNum(this.imd.get().ilE);
                } else if (message.what == 3) {
                    this.imd.get().cpU();
                } else if (message.what == 4) {
                    this.imd.get().cpS();
                } else if (message.what == 5) {
                    this.imd.get().cpQ();
                }
            }
        }
    }

    public void setCanVisible(boolean z) {
        this.ilU = z;
        this.mView.setVisibility(z ? 0 : 8);
        if (z) {
            ilC = false;
        }
    }

    private void getSpinTime() {
        this.ilW = com.baidu.live.ae.a.Qm().bwx.aNH * 1000;
        this.ilX = com.baidu.live.ae.a.Qm().bwx.aNI * 1000;
    }
}
