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
/* loaded from: classes10.dex */
public class AlaSeriesGiftPendant extends LinearLayout implements View.OnClickListener {
    public static volatile boolean ieQ = true;
    public static volatile boolean ieR = false;
    private FrameLayout container;
    Context context;
    private final int ieL;
    private final int ieM;
    private final int ieN;
    private final int ieO;
    private final int ieP;
    public volatile int ieS;
    private volatile boolean ieT;
    private volatile boolean ieU;
    private volatile boolean ieV;
    private LinearLayout ieW;
    private LinearLayout ieX;
    private LinearLayout ieY;
    private HeadImageView ieZ;
    private HeadImageView ifa;
    private HeadImageView ifb;
    private HeadImageView ifc;
    private AnimatorSet ifd;
    private AnimatorSet ife;
    private TextView iff;
    private Button ifg;
    private volatile boolean ifh;
    private boolean ifi;
    private boolean ifj;
    private int ifk;
    private int ifl;
    com.baidu.tieba.ala.data.j ifm;
    com.baidu.tieba.ala.data.k[] ifn;
    HashMap<Integer, HeadImageView> ifo;
    a ifp;
    boolean isHost;
    private View mView;
    private TextView titleText;

    public AlaSeriesGiftPendant(Context context, boolean z, String str) {
        super(context);
        this.ieL = 4;
        this.ieM = 0;
        this.ieN = 1;
        this.ieO = 2;
        this.ieP = 3;
        this.ieS = 0;
        this.ieT = false;
        this.ieU = false;
        this.ieV = true;
        this.ifd = new AnimatorSet();
        this.ife = new AnimatorSet();
        this.ifh = false;
        this.ifi = false;
        this.ifo = new HashMap<>();
        this.ifp = new a(this);
        this.context = context;
        this.isHost = z;
        this.ifj = true;
        initView();
        cow();
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
        this.ieW = (LinearLayout) this.mView.findViewById(a.f.front_view);
        this.ieX = (LinearLayout) this.mView.findViewById(a.f.back_view);
        this.ifg = (Button) this.mView.findViewById(a.f.pendant_send_btn);
        this.ifg.setOnClickListener(this);
        this.iff = (TextView) this.mView.findViewById(a.f.pendant_countdown_text);
        this.ieZ = (HeadImageView) this.mView.findViewById(a.f.first_icon);
        this.ieZ.setOnClickListener(this);
        this.ifo.put(0, this.ieZ);
        this.ifa = (HeadImageView) this.mView.findViewById(a.f.second_icon);
        this.ifa.setOnClickListener(this);
        this.ifo.put(1, this.ifa);
        this.ifb = (HeadImageView) this.mView.findViewById(a.f.third_icon);
        this.ifb.setOnClickListener(this);
        this.ifo.put(2, this.ifb);
        this.ifc = (HeadImageView) this.mView.findViewById(a.f.fourth_icon);
        this.ifc.setOnClickListener(this);
        this.ifo.put(3, this.ifc);
        this.ieY = (LinearLayout) this.mView.findViewById(a.f.second_row);
        this.titleText = (TextView) this.mView.findViewById(a.f.title_text);
        this.ieX.setVisibility(8);
        setCanVisible(false);
    }

    private void cow() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ieW, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(750L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.ieW, "alpha", 0.0f, 1.0f);
        ofFloat2.setDuration(750L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.ieX, "alpha", 1.0f, 0.0f);
        ofFloat3.setDuration(750L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.ieX, "alpha", 0.0f, 1.0f);
        ofFloat4.setDuration(750L);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.ieW, "scaleX", 1.0f, 0.0f);
        ofFloat5.setDuration(750L);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.ieW, "scaleY", 1.0f, 0.0f);
        ofFloat6.setDuration(750L);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.ieW, "scaleX", 0.0f, 1.0f);
        ofFloat7.setDuration(750L);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.ieW, "scaleY", 0.0f, 1.0f);
        ofFloat8.setDuration(750L);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.ieX, "scaleX", 1.0f, 0.0f);
        ofFloat9.setDuration(750L);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.ieX, "scaleY", 1.0f, 0.0f);
        ofFloat10.setDuration(750L);
        ObjectAnimator ofFloat11 = ObjectAnimator.ofFloat(this.ieX, "scaleX", 0.0f, 1.0f);
        ofFloat11.setDuration(750L);
        ObjectAnimator ofFloat12 = ObjectAnimator.ofFloat(this.ieX, "scaleY", 0.0f, 1.0f);
        ofFloat12.setDuration(750L);
        this.ifd.play(ofFloat2).with(ofFloat7).with(ofFloat8).with(ofFloat3).with(ofFloat9).with(ofFloat10);
        this.ife.play(ofFloat4).with(ofFloat11).with(ofFloat12).with(ofFloat).with(ofFloat5).with(ofFloat6);
        this.ifd.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                AlaSeriesGiftPendant.this.container.setClickable(false);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSeriesGiftPendant.this.pa(true);
                super.onAnimationEnd(animator);
            }
        });
        this.ife.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                AlaSeriesGiftPendant.this.ieX.setVisibility(0);
                AlaSeriesGiftPendant.this.container.setClickable(false);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSeriesGiftPendant.this.pa(false);
                super.onAnimationEnd(animator);
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.baidu.tieba.ala.view.AlaSeriesGiftPendant$3] */
    public void cox() {
        new Thread() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.3
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                while (AlaSeriesGiftPendant.this.ieS >= 0 && AlaSeriesGiftPendant.this.ieV) {
                    if (!AlaSeriesGiftPendant.ieR) {
                        if (AlaSeriesGiftPendant.this.ifj) {
                            AlaSeriesGiftPendant.this.ifp.sendEmptyMessageDelayed(1, AlaSeriesGiftPendant.this.ifk);
                            try {
                                sleep(AlaSeriesGiftPendant.this.ifk + AlaSeriesGiftPendant.this.ifl);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            AlaSeriesGiftPendant.this.ifj = false;
                        }
                        if (!AlaSeriesGiftPendant.this.ifh) {
                            AlaSeriesGiftPendant.this.ieT = true;
                            AlaSeriesGiftPendant.this.ifp.sendEmptyMessage(1);
                            try {
                                sleep(AlaSeriesGiftPendant.this.ifl);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        } else {
                            AlaSeriesGiftPendant.this.ieT = true;
                            AlaSeriesGiftPendant.this.ifp.sendEmptyMessage(1);
                            try {
                                sleep(AlaSeriesGiftPendant.this.ifk);
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                    } else {
                        AlaSeriesGiftPendant.this.ifp.sendEmptyMessage(4);
                        return;
                    }
                }
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.tieba.ala.view.AlaSeriesGiftPendant$4] */
    public void startCountDown() {
        if (this.ieS <= 0) {
            this.ieU = false;
        } else {
            new Thread() { // from class: com.baidu.tieba.ala.view.AlaSeriesGiftPendant.4
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (true) {
                        if (AlaSeriesGiftPendant.this.ieS <= 0) {
                            break;
                        } else if (!AlaSeriesGiftPendant.ieR) {
                            AlaSeriesGiftPendant.this.ieU = true;
                            AlaSeriesGiftPendant.this.ifp.sendEmptyMessage(2);
                            AlaSeriesGiftPendant alaSeriesGiftPendant = AlaSeriesGiftPendant.this;
                            alaSeriesGiftPendant.ieS--;
                            try {
                                sleep(1000L);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            AlaSeriesGiftPendant.this.ifp.sendEmptyMessage(5);
                            break;
                        }
                    }
                    try {
                        sleep(2000L);
                        if (AlaSeriesGiftPendant.this.ieS <= 0) {
                            AlaSeriesGiftPendant.this.ifp.sendEmptyMessage(3);
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
        this.iff.setText(i + "s");
        this.ifg.setText("赠送" + i + "s");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coy() {
        this.iff.setText(" ");
        this.ieU = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coz() {
        if (this.ifh) {
            this.ifh = false;
            this.ifd.start();
        } else if (this.ieV) {
            this.ifh = true;
            this.ife.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coA() {
        if (this.ifh) {
            this.ifd.start();
            this.ifh = false;
            return;
        }
        this.ieV = false;
    }

    public void ee(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.ifm = new com.baidu.tieba.ala.data.j();
            this.ifm.parserJson(jSONObject);
            this.ifn = this.ifm.bTH();
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
            this.ieS = this.ifm.bTF();
            if (this.ifm.bTG()) {
                coy();
            } else {
                setCountDownNum(this.ieS);
            }
            this.titleText.setText(this.ifm.DF() == null ? "套系礼物" : this.ifm.DF());
            switch (this.ifn.length) {
                case 2:
                    this.ieY.setVisibility(8);
                    break;
                case 3:
                    this.ieY.setVisibility(0);
                    this.ifc.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ifb.getLayoutParams());
                    layoutParams.leftMargin = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(a.d.sdk_ds58);
                    this.ifb.setLayoutParams(layoutParams);
                    break;
                case 4:
                    this.ieY.setVisibility(0);
                    break;
            }
            for (int i = 0; i < this.ifn.length; i++) {
                if (this.ifn[i].getStatus() == 0) {
                    HeadImageView headImageView = this.ifo.get(Integer.valueOf(i));
                    headImageView.setIsRound(true);
                    headImageView.setBorderColor(this.context.getResources().getColor(a.c.sdk_black_alpha10));
                    headImageView.setAutoChangeStyle(false);
                    headImageView.stopLoad();
                    headImageView.startLoad(this.ifn[i].bTI(), 12, false, false);
                } else if (this.ifn[i].getStatus() == 1) {
                    HeadImageView headImageView2 = this.ifo.get(Integer.valueOf(i));
                    headImageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    headImageView2.setIsRound(true);
                    headImageView2.setBorderColor(this.context.getResources().getColor(a.c.sdk_black_alpha10));
                    headImageView2.setAutoChangeStyle(false);
                    headImageView2.stopLoad();
                    headImageView2.startLoad(this.ifn[i].getPortrait(), 12, false, false);
                }
            }
            setCanVisible(true);
            if (this.ifm.bTG()) {
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
                ieR = true;
                this.ifp.sendEmptyMessageDelayed(3, IMConnection.RETRY_DELAY_TIMES);
            } else {
                ieR = false;
            }
            if (!this.ieT && !this.ieU) {
                startCountDown();
                if (!this.isHost) {
                    cox();
                }
            }
            if (this.isHost) {
                this.ieW.setOnClickListener(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pa(boolean z) {
        if (z) {
            this.ieZ.setClickable(true);
            this.ifa.setClickable(true);
            this.ifb.setClickable(true);
            this.ifc.setClickable(true);
            this.ifg.setClickable(false);
            return;
        }
        this.ieZ.setClickable(false);
        this.ifa.setClickable(false);
        this.ifb.setClickable(false);
        this.ifc.setClickable(false);
        this.ifg.setClickable(true);
    }

    private void coB() {
        if (this.ifm.DF() == null) {
            BdUtilHelper.showToast(this.context, "每" + this.ifm.bTF() + "s内送出1个套系礼物，集齐全部获得惊喜特效，尊享全站广播哟！");
        } else {
            BdUtilHelper.showToast(this.context, "每" + this.ifm.bTF() + "s内送出1个" + this.ifm.DF() + "系列礼物，集齐全部获得惊喜特效，尊享全站广播哟！");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = 0;
        if (this.isHost || this.ifn == null) {
            coB();
        } else if (this.ieZ == view) {
            if (this.ifn[0].getStatus() == 1) {
                AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.ifn[0].bTJ()));
                alaPersonCardActivityConfig.setExtInfo(this.ifn[0].bTK());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                return;
            }
            ak akVar = new ak();
            akVar.aHs = this.ifn[0].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, akVar));
        } else if (this.ifa == view) {
            if (this.ifn[1].getStatus() == 1) {
                AlaPersonCardActivityConfig alaPersonCardActivityConfig2 = new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.ifn[1].bTJ()));
                alaPersonCardActivityConfig2.setExtInfo(this.ifn[1].bTK());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig2));
                return;
            }
            ak akVar2 = new ak();
            akVar2.aHs = this.ifn[1].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, akVar2));
        } else if (this.ifb == view) {
            if (this.ifn[2].getStatus() == 1) {
                AlaPersonCardActivityConfig alaPersonCardActivityConfig3 = new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.ifn[2].bTJ()));
                alaPersonCardActivityConfig3.setExtInfo(this.ifn[2].bTK());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig3));
                return;
            }
            ak akVar3 = new ak();
            akVar3.aHs = this.ifn[2].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, akVar3));
        } else if (this.ifc == view) {
            if (this.ifn[3].getStatus() == 1) {
                AlaPersonCardActivityConfig alaPersonCardActivityConfig4 = new AlaPersonCardActivityConfig(TbadkCoreApplication.getInst(), String.valueOf(this.ifn[3].bTJ()));
                alaPersonCardActivityConfig4.setExtInfo(this.ifn[3].bTK());
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig4));
                return;
            }
            ak akVar4 = new ak();
            akVar4.aHs = this.ifn[3].getGiftId();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, akVar4));
        } else if (this.ifg == view) {
            ak akVar5 = new ak();
            akVar5.aHr = -1;
            akVar5.aHs = -1;
            akVar5.aHu = null;
            com.baidu.tieba.ala.data.k[] kVarArr = this.ifn;
            int length = kVarArr.length;
            while (true) {
                if (i >= length) {
                    break;
                }
                com.baidu.tieba.ala.data.k kVar = kVarArr[i];
                if (kVar.getStatus() != 0) {
                    i++;
                } else {
                    akVar5.aHs = kVar.getGiftId();
                    break;
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, akVar5));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void coC() {
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
        ieQ = true;
        this.ieV = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a extends Handler {
        private final WeakReference<AlaSeriesGiftPendant> ifr;

        public a(AlaSeriesGiftPendant alaSeriesGiftPendant) {
            this.ifr = new WeakReference<>(alaSeriesGiftPendant);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            if (this.ifr.get() != null) {
                if (message.what == 1 && !AlaSeriesGiftPendant.ieR) {
                    this.ifr.get().coz();
                } else if (message.what == 2) {
                    this.ifr.get().setCountDownNum(this.ifr.get().ieS);
                } else if (message.what == 3) {
                    this.ifr.get().coC();
                } else if (message.what == 4) {
                    this.ifr.get().coA();
                } else if (message.what == 5) {
                    this.ifr.get().coy();
                }
            }
        }
    }

    public void setCanVisible(boolean z) {
        this.ifi = z;
        this.mView.setVisibility(z ? 0 : 8);
        if (z) {
            ieQ = false;
        }
    }

    private void getSpinTime() {
        this.ifk = com.baidu.live.af.a.OJ().bru.aJx * 1000;
        this.ifl = com.baidu.live.af.a.OJ().bru.aJy * 1000;
    }
}
