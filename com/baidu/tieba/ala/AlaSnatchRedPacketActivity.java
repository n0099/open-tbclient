package com.baidu.tieba.ala;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.stats.AlaStatManager;
import com.baidu.live.adp.lib.stats.AlaStatsItem;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.b.q;
import com.baidu.live.data.ad;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.live.utils.i;
import com.baidu.live.utils.l;
import com.baidu.tieba.ala.data.j;
import com.baidu.tieba.ala.g.h;
import com.baidu.tieba.ala.view.RoundProgressBar;
/* loaded from: classes4.dex */
public class AlaSnatchRedPacketActivity extends BaseFragmentActivity {
    private HeadImageView bfW;
    private String bla;
    private FrameLayout chB;
    private TextView eig;
    private View fJJ;
    private View fLC;
    private View fLD;
    private FrameLayout fLE;
    private FrameLayout fLF;
    private FrameLayout fLG;
    private RoundProgressBar fLH;
    private TextView fLI;
    private TextView fLJ;
    private ImageView fLK;
    private FrameLayout fLL;
    private ImageView fLM;
    private h fLN;
    private String fLO;
    private ValueAnimator fLP;
    private ValueAnimator fLQ;
    private FrameLayout.LayoutParams fLR;
    private com.baidu.tieba.ala.data.c fLS;
    private j fLT;
    private boolean fLU;
    private boolean fLV;
    private long fLW;
    private int fLY;
    private ImageView mCloseBtn;
    private LinearLayout mContentView;
    private String mLiveId;
    private String mRedPacketId;
    private int fLX = 2;
    private CustomMessageListener aAd = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaSnatchRedPacketActivity.this.finish();
        }
    };
    private CustomMessageListener fLZ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(AlaSnatchRedPacketActivity.this.fLO)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (updateAttentionMessage.getData().isAttention) {
                            AlaSnatchRedPacketActivity.this.showToast(AlaSnatchRedPacketActivity.this.getString(a.i.sdk_attention_success_toast));
                            AlaSnatchRedPacketActivity.this.fLE.setVisibility(8);
                            return;
                        }
                        AlaSnatchRedPacketActivity.this.showToast(AlaSnatchRedPacketActivity.this.getString(a.i.sdk_unfollow_success_toast));
                        return;
                    }
                    AlaSnatchRedPacketActivity.this.showToast(a.i.follow_failed_tip);
                }
            }
        }
    };
    private h.a fMa = new h.a() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.9
        @Override // com.baidu.tieba.ala.g.h.a
        public void b(com.baidu.tieba.ala.data.c cVar) {
            AlaSnatchRedPacketActivity.this.a(cVar);
        }

        @Override // com.baidu.tieba.ala.g.h.a
        public void aL(int i, String str) {
            AlaSnatchRedPacketActivity.this.showToast(a.i.sdk_net_fail_tip);
        }

        @Override // com.baidu.tieba.ala.g.h.a
        public void b(j jVar) {
            AlaSnatchRedPacketActivity.this.mHandler.removeCallbacks(AlaSnatchRedPacketActivity.this.fMc);
            AlaSnatchRedPacketActivity.this.fLM.setEnabled(true);
            AlaSnatchRedPacketActivity.this.a(jVar);
        }

        @Override // com.baidu.tieba.ala.g.h.a
        public void aM(int i, String str) {
            AlaSnatchRedPacketActivity.this.mHandler.removeCallbacks(AlaSnatchRedPacketActivity.this.fMc);
            AlaSnatchRedPacketActivity.this.fLM.setEnabled(true);
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                AlaSnatchRedPacketActivity.this.showToast(a.i.sdk_net_fail_tip);
            } else if (!StringUtils.isNullObject(str)) {
                AlaSnatchRedPacketActivity.this.showToast(str);
            } else {
                AlaSnatchRedPacketActivity.this.showToast(a.i.snatch_red_packet_failed_3);
            }
        }
    };
    private CustomMessageListener fMb = new CustomMessageListener(2913133) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                AlaSnatchRedPacketActivity.this.fLW = ((Long) customResponsedMessage.getData()).longValue();
                AlaSnatchRedPacketActivity.this.dW(AlaSnatchRedPacketActivity.this.fLW);
                if (AlaSnatchRedPacketActivity.this.fLW < 1) {
                    AlaSnatchRedPacketActivity.this.bHT();
                }
            }
        }
    };
    private Runnable fMc = new Runnable() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.3
        @Override // java.lang.Runnable
        public void run() {
            if (AlaSnatchRedPacketActivity.this.fLM != null) {
                AlaSnatchRedPacketActivity.this.fLM.setEnabled(true);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        if (!isFinishing()) {
            if (getIntent() == null) {
                finish();
                return;
            }
            parserIntent();
            if (StringUtils.isNullObject(this.mRedPacketId)) {
                finish();
                return;
            }
            String str = Build.DISPLAY;
            if (str != null && str.contains("Flyme")) {
                getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.d.sdk_transparent)));
            }
            setContentView(a.h.ala_snatch_red_packet_view);
            initView();
            this.fLN = new h(getPageContext(), this.fMa);
            this.fLN.am(this.mRedPacketId, this.mLiveId, this.bla);
            MessageManager.getInstance().registerListener(this.aAd);
            MessageManager.getInstance().registerListener(this.fLZ);
            MessageManager.getInstance().registerListener(this.fMb);
            this.fLR = new FrameLayout.LayoutParams(-1, -1);
            kT(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.bla = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.fJJ = findViewById(a.g.rp_root_bg);
        this.fJJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaSnatchRedPacketActivity.this.finish();
                }
            }
        });
        this.chB = (FrameLayout) findViewById(a.g.rp_root_container);
        this.mContentView = (LinearLayout) findViewById(a.g.rp_content_layout);
        this.mContentView.setVisibility(8);
        this.bfW = (HeadImageView) findViewById(a.g.rp_user_icon);
        this.bfW.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds6));
        this.bfW.setBorderColor(getPageContext().getResources().getColor(a.d.ala_red_packet_main_color));
        this.bfW.setIsRound(true);
        this.bfW.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.bfW.setAutoChangeStyle(true);
        this.bfW.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eig = (TextView) findViewById(a.g.rp_user_name);
        this.fLE = (FrameLayout) findViewById(a.g.rp_follow_sender);
        this.fLE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bHV();
            }
        });
        this.mCloseBtn = (ImageView) findViewById(a.g.rp_close_btn);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.mCloseBtn.setVisibility(0);
            this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaSnatchRedPacketActivity.this.finish();
                }
            });
        } else {
            this.mCloseBtn.setVisibility(8);
        }
        this.fLD = findViewById(a.g.rp_normal_bg);
        this.fLC = findViewById(a.g.rp_condition_guide_bg);
        this.fLF = (FrameLayout) findViewById(a.g.rp_sub_content_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j jVar) {
        this.fLT = jVar;
        if (jVar.bMI()) {
            this.fLY = 101;
        } else {
            this.fLY = 100;
        }
        bHR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.data.c cVar) {
        if (cVar.gjR != null) {
            this.mContentView.setVisibility(0);
            this.fLS = cVar;
            this.fLO = this.fLS.gjS.gjZ;
            if (!StringUtils.isNullObject(cVar.gjR.portrait)) {
                l.a(this.bfW, cVar.gjR.portrait, true, false);
            }
            this.eig.setText(cVar.gjR.userName);
            if (!cVar.bML()) {
                this.fLE.setVisibility(8);
            } else {
                boolean equals = TbadkCoreApplication.getCurrentAccount() != null ? TbadkCoreApplication.getCurrentAccount().equals(this.fLO) : true;
                if (this.fLS.gjS.gka || equals) {
                    this.fLE.setVisibility(8);
                } else {
                    this.fLE.setVisibility(0);
                }
            }
            if (this.fLS.bMI()) {
                this.fLX = 3;
            } else if (this.fLS.isValid()) {
                if (cVar.bMK()) {
                    this.fLX = 1;
                    this.fLE.setVisibility(8);
                } else {
                    this.fLX = 2;
                }
            } else if (this.fLS.bMF()) {
                this.fLX = 5;
            } else if (this.fLS.bMG()) {
                this.fLX = 4;
            }
            bHQ();
        }
    }

    private void bHQ() {
        switch (this.fLX) {
            case 1:
                bHU();
                return;
            case 2:
                bHS();
                return;
            case 3:
                this.fLY = 102;
                bHR();
                return;
            case 4:
                this.fLY = 103;
                bHR();
                return;
            case 5:
                this.fLY = 104;
                bHR();
                return;
            default:
                return;
        }
    }

    private void bHR() {
        String str;
        this.fLD.setVisibility(8);
        this.fLC.setVisibility(0);
        this.fLF.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_outcome, (ViewGroup) null);
        this.fLF.addView(inflate, this.fLR);
        TextView textView = (TextView) inflate.findViewById(a.g.rp_show_result);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new q(AlaSnatchRedPacketActivity.this.getPageContext().getPageActivity(), AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.bla)));
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(a.g.rp_gift_btn);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bHP();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        switch (this.fLY) {
            case 100:
            case 103:
            case 104:
                TextView textView3 = (TextView) inflate.findViewById(a.g.rp_snatch_fail);
                textView3.setVisibility(0);
                textView2.setVisibility(8);
                if (this.fLY == 103) {
                    String string = getResources().getString(a.i.snatch_red_packet_failed_4);
                    textView.setVisibility(8);
                    str = string;
                } else {
                    String string2 = getResources().getString(a.i.snatch_red_packet_failed_2);
                    textView.setVisibility(0);
                    str = string2;
                }
                textView3.setText(str);
                return;
            case 101:
                textView2.setVisibility(0);
                ((LinearLayout) inflate.findViewById(a.g.rp_snatch_succ_layout)).setVisibility(0);
                TextView textView4 = (TextView) inflate.findViewById(a.g.rp_snatch_amount);
                textView4.setText(String.format(getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(this.fLT.bMJ())));
                textView4.setVisibility(0);
                return;
            case 102:
                textView2.setVisibility(0);
                TextView textView5 = (TextView) inflate.findViewById(a.g.rp_snatched);
                textView5.setVisibility(0);
                textView5.setText(getPageContext().getString(a.i.snatch_red_packet_loot_prefix) + String.format(getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(this.fLS.bMJ())));
                return;
            default:
                return;
        }
    }

    private void bHS() {
        this.fLD.setVisibility(0);
        this.fLC.setVisibility(8);
        this.fLF.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_snatch, (ViewGroup) null);
        this.fLF.addView(inflate, this.fLR);
        ((TextView) inflate.findViewById(a.g.rp_follow_tip)).setVisibility(0);
        ((TextView) inflate.findViewById(a.g.rp_total_amount)).setText(String.format(getResources().getString(a.i.send_ref_packet_desc), Long.valueOf(this.fLS.gjR.gkw)));
        this.fLL = (FrameLayout) inflate.findViewById(a.g.rp_snatch_layout);
        if (UtilHelper.getRealScreenOrientation(this) == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fLL.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds126);
            this.fLL.setLayoutParams(layoutParams);
        }
        this.fLM = (ImageView) inflate.findViewById(a.g.rp_snatch_btn);
        this.fLM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.fLM.setEnabled(false);
                AlaSnatchRedPacketActivity.this.mHandler.postDelayed(AlaSnatchRedPacketActivity.this.fMc, 1000L);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                if (AlaSnatchRedPacketActivity.this.fLS != null && AlaSnatchRedPacketActivity.this.fLS.gjR != null) {
                    alaStatsItem.addValue("redpacketId", AlaSnatchRedPacketActivity.this.fLS.gjR.id);
                }
                AlaStatManager.getInstance().debug("redpacket_loot_before", "", "", alaStatsItem);
                AlaSnatchRedPacketActivity.this.fLN.an(AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.bla);
            }
        });
        this.fLG = (FrameLayout) inflate.findViewById(a.g.rp_count_down_layout);
        this.fLH = (RoundProgressBar) inflate.findViewById(a.g.rp_snatch_progress);
        this.fLI = (TextView) inflate.findViewById(a.g.rp_snatch_countdown_min);
        this.fLK = (ImageView) inflate.findViewById(a.g.rp_snatch_countdown_dot);
        this.fLK.setVisibility(8);
        this.fLJ = (TextView) inflate.findViewById(a.g.rp_snatch_countdown_second);
        if (!this.fLS.bMH()) {
            this.fLM.setVisibility(0);
            this.fLG.setVisibility(8);
            kU(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHT() {
        bHW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dW(long j) {
        if (this.fLS != null) {
            String[] ed = this.fLS.ed(j);
            if (j <= 60) {
                if (!this.fLV) {
                    this.fLV = true;
                    if (this.fLK != null) {
                        this.fLK.setVisibility(8);
                    }
                    if (this.fLJ != null) {
                        this.fLJ.setVisibility(8);
                    }
                    if (this.fLI != null) {
                        this.fLI.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_ds108));
                    }
                }
                if (this.fLI != null) {
                    this.fLI.setText(ed[1]);
                }
            } else {
                if (this.fLK != null && this.fLK.getVisibility() != 0) {
                    this.fLK.setVisibility(0);
                }
                if (this.fLI != null) {
                    this.fLI.setText(ed[0]);
                }
                if (this.fLJ != null) {
                    this.fLJ.setText(ed[1]);
                }
            }
            if (this.fLH != null) {
                this.fLH.setProgress(this.fLS.ec(j));
            }
        }
    }

    private void bHU() {
        this.fLD.setVisibility(8);
        this.fLC.setVisibility(0);
        this.fLF.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_condition, (ViewGroup) null);
        this.fLF.addView(inflate, this.fLR);
        TextView textView = (TextView) inflate.findViewById(a.g.rp_condition_desc);
        TextView textView2 = (TextView) inflate.findViewById(a.g.rp_condition_btn);
        if (this.fLS.bMM()) {
            this.fLU = false;
            textView.setText(a.i.snatch_red_packet_cond_follow_desc);
            textView2.setText(a.i.snatch_red_packet_follow_btn);
        } else if (this.fLS.bMN()) {
            this.fLU = true;
            textView.setText(a.i.snatch_red_packet_cond_gift_desc);
            textView2.setText(a.i.snatch_red_packet_gift_btn);
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaSnatchRedPacketActivity.this.fLU) {
                    AlaSnatchRedPacketActivity.this.bHP();
                    AlaSnatchRedPacketActivity.this.finish();
                    return;
                }
                AlaSnatchRedPacketActivity.this.bmK();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bmK() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913131, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHV() {
        String str = this.fLS.gjS.gjZ;
        com.baidu.live.data.e eVar = new com.baidu.live.data.e(this.fLS.gjR.portrait, str, true, getUniqueId());
        eVar.setFrom("source_snatch_red_packet");
        com.baidu.live.view.a.SY().a(str, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHP() {
        ad adVar = new ad();
        adVar.aIQ = -1;
        adVar.aIR = -1;
        adVar.aIT = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, adVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kU(boolean z) {
        this.fLQ = ValueAnimator.ofFloat(1.0f, 0.8f);
        this.fLQ.setDuration(250L);
        this.fLQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                AlaSnatchRedPacketActivity.this.fLM.setScaleX(floatValue);
                AlaSnatchRedPacketActivity.this.fLM.setScaleY(floatValue);
            }
        });
        this.fLQ.setRepeatCount(-1);
        this.fLQ.setRepeatMode(2);
        this.fLQ.start();
        AlaStatsItem alaStatsItem = new AlaStatsItem();
        if (this.fLS != null && this.fLS.gjR != null) {
            alaStatsItem.addValue("redpacketId", this.fLS.gjR.id);
        }
        alaStatsItem.addValue("source", z ? "countdown_finish" : "redpacket_status_3");
        AlaStatManager.getInstance().debug("redpacket_loot_enable", "", "", alaStatsItem);
    }

    private void bHW() {
        this.fLG.setVisibility(0);
        this.fLM.setVisibility(0);
        this.fLP = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.fLP.setDuration(500L);
        this.fLP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                AlaSnatchRedPacketActivity.this.fLG.setAlpha(1.0f - animatedFraction);
                AlaSnatchRedPacketActivity.this.fLM.setAlpha(animatedFraction);
                float f = (float) (animatedFraction * 0.5d);
                AlaSnatchRedPacketActivity.this.fLG.setScaleX(1.0f - f);
                AlaSnatchRedPacketActivity.this.fLG.setScaleY(1.0f - f);
                AlaSnatchRedPacketActivity.this.fLM.setScaleX((float) (f + 0.5d));
                AlaSnatchRedPacketActivity.this.fLM.setScaleY((float) (f + 0.5d));
            }
        });
        this.fLP.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.7
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSnatchRedPacketActivity.this.kU(true);
                AlaSnatchRedPacketActivity.this.fLG.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fLP.start();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        overridePendingTransition(0, 0);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        overridePendingTransition(0, 0);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        kT(configuration.orientation == 2);
    }

    private void kT(boolean z) {
        if (z) {
            i.aa(this.chB);
            this.chB.setScaleX(0.7f);
            this.chB.setScaleY(0.7f);
            if (this.fLL != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fLL.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds126);
                this.fLL.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        i.ab(this.chB);
        this.chB.setScaleX(1.0f);
        this.chB.setScaleY(1.0f);
        if (this.fLL != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fLL.getLayoutParams();
            layoutParams2.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds146);
            this.fLL.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.fLN != null) {
            this.fLN.onDestroy();
        }
        if (this.fLQ != null) {
            this.fLQ.removeAllListeners();
            this.fLQ.cancel();
            this.fLQ = null;
        }
        if (this.fLP != null) {
            this.fLP.removeAllListeners();
            this.fLP.cancel();
            this.fLP = null;
        }
        this.mHandler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.fMb);
        MessageManager.getInstance().unRegisterListener(this.fLZ);
        MessageManager.getInstance().unRegisterListener(this.aAd);
        super.onDestroy();
    }
}
