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
    public static volatile boolean ijT = true;
    public static volatile boolean ijU = false;
    private FrameLayout container;
    Context context;
    public volatile int ijV;
    private volatile boolean ijW;
    private volatile boolean ijX;
    private volatile boolean ijY;
    private LinearLayout ijZ;
    private LinearLayout ika;
    private LinearLayout ikb;
    private HeadImageView ikc;
    private HeadImageView ikd;
    private HeadImageView ike;
    private HeadImageView ikf;
    private AnimatorSet ikg;
    private AnimatorSet ikh;
    private TextView iki;
    private Button ikj;
    private volatile boolean ikk;
    private boolean ikl;
    private boolean ikm;
    private int ikn;
    private int iko;
    com.baidu.tieba.ala.data.j ikp;
    com.baidu.tieba.ala.data.k[] ikq;
    HashMap<Integer, HeadImageView> ikr;
    a iks;
    boolean isHost;
    private View mView;
    private TextView titleText;

    public AlaSeriesGiftPendant(Context context, boolean z, String str) {
        super(context);
        this.ijV = 0;
        this.ijW = false;
        this.ijX = false;
        this.ijY = true;
        this.ikg = new AnimatorSet();
        this.ikh = new AnimatorSet();
        this.ikk = false;
        this.ikl = false;
        this.ikr = new HashMap<>();
        this.iks = new a(this);
        this.context = context;
        this.isHost = z;
        this.ikm = true;
        initView();
        cpI();
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
        this.ijZ = (LinearLayout) this.mView.findViewById(a.f.front_view);
        this.ika = (LinearLayout) this.mView.findViewById(a.f.back_view);
        this.ikj = (Button) this.mView.findViewById(a.f.pendant_send_btn);
        this.ikj.setOnClickListener(this);
        this.iki = (TextView) this.mView.findViewById(a.f.pendant_countdown_text);
        this.ikc = (HeadImageView) this.mView.findViewById(a.f.first_icon);
        this.ikc.setOnClickListener(this);
        this.ikr.put(0, this.ikc);
        this.ikd = (HeadImageView) this.mView.findViewById(a.f.second_icon);
        this.ikd.setOnClickListener(this);
        this.ikr.put(1, this.ikd);
        this.ike = (HeadImageView) this.mView.findViewById(a.f.third_icon);
        this.ike.setOnClickListener(this);
        this.ikr.put(2, this.ike);
        this.ikf = (HeadImageView) this.mView.findViewById(a.f.fourth_icon);
        this.ikf.setOnClickListener(this);
        this.ikr.put(3, this.ikf);
        this.ikb = (LinearLayout) this.mView.findViewById(a.f.second_row);
        this.titleText = (TextView) this.mView.findViewById(a.f.title_text);
        this.ika.setVisibility(8);
        setCanVisible(false);
    }

    private void cpI() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ijZ, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(750L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.ijZ, "alpha", 0.0f, 1.0f);
        ofFloat2.setDuration(750L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.ika, "alpha", 1.0f, 0.0f);
        ofFloat3.setDuration(750L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.ika, "alpha", 0.0f, 1.0f);
        ofFloat4.setDuration(750L);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.ijZ, "scaleX", 1.0f, 0.0f);
        ofFloat5.setDuration(750L);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.ijZ, "scaleY", 1.0f, 0.0f);
        ofFloat6.setDuration(750L);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.ijZ, "scaleX", 0.0f, 1.0f);
        ofFloat7.setDuration(750L);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.ijZ, "scaleY", 0.0f, 1.0f);
        ofFloat8.setDuration(750L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.ika, "scaleX", 1.0f, 0.0f);
        ofFloat9.setDuration(750L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.ika, "scaleY", 1.0f, 0.0f);
        ofFloat10.setDuration(750L);
        ObjectAnimator ofFloat11 = ObjectAnimator.ofFloat(this.ika, "scaleX", 0.0f, 1.0f);
        ofFloat11.setDuration(750L);
        ObjectAnimator ofFloat12 = ObjectAnimator.ofFloat(this.ika, "scaleY", 0.0f, 1.0f);
        ofFloat12.setDuration(750L);
        this.ikg.play(ofFloat2).with(ofFloat7).with(ofFloat8).with(ofFloat3).with(ofFloat9).with(ofFloat10);
        this.ikh.play(ofFloat4).with(ofFloat11).with(ofFloat12).with(ofFloat).with(ofFloat5).with(ofFloat6);
        this.ikg.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.1
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
        this.ikh.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                AlaSeriesGiftPendant.this.ika.setVisibility(0);
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
    public void cpJ() {
        new Thread() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.3
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                while (AlaSeriesGiftPendant.this.ijV >= 0 && AlaSeriesGiftPendant.this.ijY) {
                    if (!AlaSeriesGiftPendant.ijU) {
                        if (AlaSeriesGiftPendant.this.ikm) {
                            AlaSeriesGiftPendant.this.iks.sendEmptyMessageDelayed(1, AlaSeriesGiftPendant.this.ikn);
                            try {
                                sleep(AlaSeriesGiftPendant.this.ikn + AlaSeriesGiftPendant.this.iko);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            AlaSeriesGiftPendant.this.ikm = false;
                        }
                        if (!AlaSeriesGiftPendant.this.ikk) {
                            AlaSeriesGiftPendant.this.ijW = true;
                            AlaSeriesGiftPendant.this.iks.sendEmptyMessage(1);
                            try {
                                sleep(AlaSeriesGiftPendant.this.iko);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        } else {
                            AlaSeriesGiftPendant.this.ijW = true;
                            AlaSeriesGiftPendant.this.iks.sendEmptyMessage(1);
                            try {
                                sleep(AlaSeriesGiftPendant.this.ikn);
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                    } else {
                        AlaSeriesGiftPendant.this.iks.sendEmptyMessage(4);
                        return;
                    }
                }
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.tieba.ala.view.AlaSeriesGiftPendant$4] */
    public void startCountDown() {
        if (this.ijV <= 0) {
            this.ijX = false;
        } else {
            new Thread() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.4
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (true) {
                        if (AlaSeriesGiftPendant.this.ijV <= 0) {
                            break;
                        } else if (!AlaSeriesGiftPendant.ijU) {
                            AlaSeriesGiftPendant.this.ijX = true;
                            AlaSeriesGiftPendant.this.iks.sendEmptyMessage(2);
                            AlaSeriesGiftPendant alaSeriesGiftPendant = AlaSeriesGiftPendant.this;
                            alaSeriesGiftPendant.ijV--;
                            try {
                                sleep(1000L);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            AlaSeriesGiftPendant.this.iks.sendEmptyMessage(5);
                            break;
                        }
                    }
                    try {
                        sleep(2000L);
                        if (AlaSeriesGiftPendant.this.ijV <= 0) {
                            AlaSeriesGiftPendant.this.iks.sendEmptyMessage(3);
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
        this.iki.setText(i + "s");
        this.ikj.setText("赠送" + i + "s");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpK() {
        this.iki.setText(" ");
        this.ijX = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpL() {
        if (this.ikk) {
            this.ikk = false;
            this.ikg.start();
        } else if (this.ijY) {
            this.ikk = true;
            this.ikh.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpM() {
        if (this.ikk) {
            this.ikg.start();
            this.ikk = false;
            return;
        }
        this.ijY = false;
    }

    public void ef(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ikp = new com.baidu.tieba.ala.data.j();
            this.ikp.parserJson(jSONObject);
            this.ikq = this.ikp.bUt();
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
            this.ijV = this.ikp.bUr();
            if (this.ikp.bUs()) {
                cpK();
            } else {
                setCountDownNum(this.ijV);
            }
            this.titleText.setText(this.ikp.EV() == null ? "套系礼物" : this.ikp.EV());
            switch (this.ikq.length) {
                case 2:
                    this.ikb.setVisibility(8);
                    break;
                case 3:
                    this.ikb.setVisibility(0);
                    this.ikf.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ike.getLayoutParams());
                    layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds58);
                    this.ike.setLayoutParams(layoutParams);
                    break;
                case 4:
                    this.ikb.setVisibility(0);
                    break;
            }
            for (int i = 0; i < this.ikq.length; i++) {
                if (this.ikq[i].getStatus() == 0) {
                    HeadImageView headImageView = this.ikr.get(Integer.valueOf(i));
                    headImageView.setIsRound(true);
                    headImageView.setBorderColor(this.context.getResources().getColor(a.c.sdk_black_alpha10));
                    headImageView.setAutoChangeStyle(false);
                    headImageView.stopLoad();
                    headImageView.startLoad(this.ikq[i].bUu(), 12, false, false);
                } else if (this.ikq[i].getStatus() == 1) {
                    HeadImageView headImageView2 = this.ikr.get(Integer.valueOf(i));
                    headImageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    headImageView2.setIsRound(true);
                    headImageView2.setBorderColor(this.context.getResources().getColor(a.c.sdk_black_alpha10));
                    headImageView2.setAutoChangeStyle(false);
                    headImageView2.stopLoad();
                    headImageView2.startLoad(this.ikq[i].getPortrait(), 12, false, false);
                }
            }
            setCanVisible(true);
            if (this.ikp.bUs()) {
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
                ijU = true;
                this.iks.sendEmptyMessageDelayed(3, IMConnection.RETRY_DELAY_TIMES);
            } else {
                ijU = false;
            }
            if (!this.ijW && !this.ijX) {
                startCountDown();
                if (!this.isHost) {
                    cpJ();
                }
            }
            if (this.isHost) {
                this.ijZ.setOnClickListener(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pk(boolean z) {
        if (z) {
            this.ikc.setClickable(true);
            this.ikd.setClickable(true);
            this.ike.setClickable(true);
            this.ikf.setClickable(true);
            this.ikj.setClickable(false);
            return;
        }
        this.ikc.setClickable(false);
        this.ikd.setClickable(false);
        this.ike.setClickable(false);
        this.ikf.setClickable(false);
        this.ikj.setClickable(true);
    }

    private void cpN() {
        if (this.ikp.EV() == null) {
            BdUtilHelper.showToast(this.context, "每" + this.ikp.bUr() + "s内送出1个套系礼物，集齐全部获得惊喜特效，尊享全站广播哟！");
        } else {
            BdUtilHelper.showToast(this.context, "每" + this.ikp.bUr() + "s内送出1个" + this.ikp.EV() + "系列礼物，集齐全部获得惊喜特效，尊享全站广播哟！");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = 0;
        if (this.isHost || this.ikq == null) {
            cpN();
        } else if (this.ikc == view) {
            if (this.ikq[0].getStatus() == 1) {
                AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.ikq[0].bUv()));
                alaPersonCardActivityConfig.setExtInfo(this.ikq[0].bUw());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                return;
            }
            ao aoVar = new ao();
            aoVar.aJX = this.ikq[0].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aoVar));
        } else if (this.ikd == view) {
            if (this.ikq[1].getStatus() == 1) {
                AlaPersonCardActivityConfig alaPersonCardActivityConfig2 = new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.ikq[1].bUv()));
                alaPersonCardActivityConfig2.setExtInfo(this.ikq[1].bUw());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig2));
                return;
            }
            ao aoVar2 = new ao();
            aoVar2.aJX = this.ikq[1].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aoVar2));
        } else if (this.ike == view) {
            if (this.ikq[2].getStatus() == 1) {
                AlaPersonCardActivityConfig alaPersonCardActivityConfig3 = new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.ikq[2].bUv()));
                alaPersonCardActivityConfig3.setExtInfo(this.ikq[2].bUw());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig3));
                return;
            }
            ao aoVar3 = new ao();
            aoVar3.aJX = this.ikq[2].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aoVar3));
        } else if (this.ikf == view) {
            if (this.ikq[3].getStatus() == 1) {
                AlaPersonCardActivityConfig alaPersonCardActivityConfig4 = new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.ikq[3].bUv()));
                alaPersonCardActivityConfig4.setExtInfo(this.ikq[3].bUw());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig4));
                return;
            }
            ao aoVar4 = new ao();
            aoVar4.aJX = this.ikq[3].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aoVar4));
        } else if (this.ikj == view) {
            ao aoVar5 = new ao();
            aoVar5.aJW = -1;
            aoVar5.aJX = -1;
            aoVar5.aJZ = null;
            com.baidu.tieba.ala.data.k[] kVarArr = this.ikq;
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
    public synchronized void cpO() {
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
        ijT = true;
        this.ijY = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class a extends Handler {
        private final WeakReference<AlaSeriesGiftPendant> iku;

        public a(AlaSeriesGiftPendant alaSeriesGiftPendant) {
            this.iku = new WeakReference<>(alaSeriesGiftPendant);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (this.iku.get() != null) {
                if (message.what == 1 && !AlaSeriesGiftPendant.ijU) {
                    this.iku.get().cpL();
                } else if (message.what == 2) {
                    this.iku.get().setCountDownNum(this.iku.get().ijV);
                } else if (message.what == 3) {
                    this.iku.get().cpO();
                } else if (message.what == 4) {
                    this.iku.get().cpM();
                } else if (message.what == 5) {
                    this.iku.get().cpK();
                }
            }
        }
    }

    public void setCanVisible(boolean z) {
        this.ikl = z;
        this.mView.setVisibility(z ? 0 : 8);
        if (z) {
            ijT = false;
        }
    }

    private void getSpinTime() {
        this.ikn = com.baidu.live.ae.a.Qj().buX.aMh * 1000;
        this.iko = com.baidu.live.ae.a.Qj().buX.aMi * 1000;
    }
}
