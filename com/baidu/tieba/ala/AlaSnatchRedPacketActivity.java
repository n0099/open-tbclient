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
import com.baidu.live.b.s;
import com.baidu.live.data.ah;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.live.utils.i;
import com.baidu.tieba.ala.data.l;
import com.baidu.tieba.ala.g.h;
import com.baidu.tieba.ala.view.RoundProgressBar;
/* loaded from: classes4.dex */
public class AlaSnatchRedPacketActivity extends BaseFragmentActivity {
    private HeadImageView bgT;
    private String bme;
    private FrameLayout cuo;
    private TextView euO;
    private View fXB;
    private ImageView fZA;
    private h fZB;
    private String fZC;
    private ValueAnimator fZD;
    private ValueAnimator fZE;
    private FrameLayout.LayoutParams fZF;
    private com.baidu.tieba.ala.data.c fZG;
    private l fZH;
    private boolean fZI;
    private boolean fZJ;
    private long fZK;
    private int fZM;
    private View fZq;
    private View fZr;
    private FrameLayout fZs;
    private FrameLayout fZt;
    private FrameLayout fZu;
    private RoundProgressBar fZv;
    private TextView fZw;
    private TextView fZx;
    private ImageView fZy;
    private FrameLayout fZz;
    private ImageView mCloseBtn;
    private LinearLayout mContentView;
    private String mLiveId;
    private String mRedPacketId;
    private int fZL = 2;
    private CustomMessageListener ayx = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaSnatchRedPacketActivity.this.finish();
        }
    };
    private CustomMessageListener fZN = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(AlaSnatchRedPacketActivity.this.fZC)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (updateAttentionMessage.getData().isAttention) {
                            AlaSnatchRedPacketActivity.this.showToast(AlaSnatchRedPacketActivity.this.getString(a.h.sdk_attention_success_toast));
                            AlaSnatchRedPacketActivity.this.fZs.setVisibility(8);
                            return;
                        }
                        AlaSnatchRedPacketActivity.this.showToast(AlaSnatchRedPacketActivity.this.getString(a.h.sdk_unfollow_success_toast));
                        return;
                    }
                    AlaSnatchRedPacketActivity.this.showToast(a.h.follow_failed_tip);
                }
            }
        }
    };
    private h.a fZO = new h.a() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.9
        @Override // com.baidu.tieba.ala.g.h.a
        public void b(com.baidu.tieba.ala.data.c cVar) {
            AlaSnatchRedPacketActivity.this.a(cVar);
        }

        @Override // com.baidu.tieba.ala.g.h.a
        public void aO(int i, String str) {
            AlaSnatchRedPacketActivity.this.showToast(a.h.sdk_net_fail_tip);
        }

        @Override // com.baidu.tieba.ala.g.h.a
        public void b(l lVar) {
            AlaSnatchRedPacketActivity.this.mHandler.removeCallbacks(AlaSnatchRedPacketActivity.this.fZQ);
            AlaSnatchRedPacketActivity.this.fZA.setEnabled(true);
            AlaSnatchRedPacketActivity.this.a(lVar);
        }

        @Override // com.baidu.tieba.ala.g.h.a
        public void aP(int i, String str) {
            AlaSnatchRedPacketActivity.this.mHandler.removeCallbacks(AlaSnatchRedPacketActivity.this.fZQ);
            AlaSnatchRedPacketActivity.this.fZA.setEnabled(true);
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                AlaSnatchRedPacketActivity.this.showToast(a.h.sdk_net_fail_tip);
            } else if (!StringUtils.isNullObject(str)) {
                AlaSnatchRedPacketActivity.this.showToast(str);
            } else {
                AlaSnatchRedPacketActivity.this.showToast(a.h.snatch_red_packet_failed_3);
            }
        }
    };
    private CustomMessageListener fZP = new CustomMessageListener(2913133) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                AlaSnatchRedPacketActivity.this.fZK = ((Long) customResponsedMessage.getData()).longValue();
                AlaSnatchRedPacketActivity.this.eu(AlaSnatchRedPacketActivity.this.fZK);
                if (AlaSnatchRedPacketActivity.this.fZK < 1) {
                    AlaSnatchRedPacketActivity.this.bLD();
                }
            }
        }
    };
    private Runnable fZQ = new Runnable() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.3
        @Override // java.lang.Runnable
        public void run() {
            if (AlaSnatchRedPacketActivity.this.fZA != null) {
                AlaSnatchRedPacketActivity.this.fZA.setEnabled(true);
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
                getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.c.sdk_transparent)));
            }
            setContentView(a.g.ala_snatch_red_packet_view);
            initView();
            this.fZB = new h(getPageContext(), this.fZO);
            this.fZB.au(this.mRedPacketId, this.mLiveId, this.bme);
            MessageManager.getInstance().registerListener(this.ayx);
            MessageManager.getInstance().registerListener(this.fZN);
            MessageManager.getInstance().registerListener(this.fZP);
            this.fZF = new FrameLayout.LayoutParams(-1, -1);
            lq(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.bme = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.fXB = findViewById(a.f.rp_root_bg);
        this.fXB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaSnatchRedPacketActivity.this.finish();
                }
            }
        });
        this.cuo = (FrameLayout) findViewById(a.f.rp_root_container);
        this.mContentView = (LinearLayout) findViewById(a.f.rp_content_layout);
        this.mContentView.setVisibility(8);
        this.bgT = (HeadImageView) findViewById(a.f.rp_user_icon);
        this.bgT.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds6));
        this.bgT.setBorderColor(getPageContext().getResources().getColor(a.c.ala_red_packet_main_color));
        this.bgT.setIsRound(true);
        this.bgT.setDefaultResource(a.e.sdk_icon_default_avatar100_bg);
        this.bgT.setAutoChangeStyle(true);
        this.bgT.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.euO = (TextView) findViewById(a.f.rp_user_name);
        this.fZs = (FrameLayout) findViewById(a.f.rp_follow_sender);
        this.fZs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bLF();
            }
        });
        this.mCloseBtn = (ImageView) findViewById(a.f.rp_close_btn);
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
        this.fZr = findViewById(a.f.rp_normal_bg);
        this.fZq = findViewById(a.f.rp_condition_guide_bg);
        this.fZt = (FrameLayout) findViewById(a.f.rp_sub_content_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar) {
        this.fZH = lVar;
        if (lVar.bRb()) {
            this.fZM = 101;
        } else {
            this.fZM = 100;
        }
        bLB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.data.c cVar) {
        if (cVar.gzq != null) {
            this.mContentView.setVisibility(0);
            this.fZG = cVar;
            this.fZC = this.fZG.gzr.gzy;
            if (!StringUtils.isNullObject(cVar.gzq.portrait)) {
                com.baidu.live.utils.l.a(this.bgT, cVar.gzq.portrait, true, false);
            }
            this.euO.setText(cVar.gzq.userName);
            if (!cVar.bRe()) {
                this.fZs.setVisibility(8);
            } else {
                boolean equals = TbadkCoreApplication.getCurrentAccount() != null ? TbadkCoreApplication.getCurrentAccount().equals(this.fZC) : true;
                if (this.fZG.gzr.gzz || equals) {
                    this.fZs.setVisibility(8);
                } else {
                    this.fZs.setVisibility(0);
                }
            }
            if (this.fZG.bRb()) {
                this.fZL = 3;
            } else if (this.fZG.isValid()) {
                if (cVar.bRd()) {
                    this.fZL = 1;
                    this.fZs.setVisibility(8);
                } else {
                    this.fZL = 2;
                }
            } else if (this.fZG.bQY()) {
                this.fZL = 5;
            } else if (this.fZG.bQZ()) {
                this.fZL = 4;
            }
            bLA();
        }
    }

    private void bLA() {
        switch (this.fZL) {
            case 1:
                bLE();
                return;
            case 2:
                bLC();
                return;
            case 3:
                this.fZM = 102;
                bLB();
                return;
            case 4:
                this.fZM = 103;
                bLB();
                return;
            case 5:
                this.fZM = 104;
                bLB();
                return;
            default:
                return;
        }
    }

    private void bLB() {
        String str;
        this.fZr.setVisibility(8);
        this.fZq.setVisibility(0);
        this.fZt.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_red_packet_outcome, (ViewGroup) null);
        this.fZt.addView(inflate, this.fZF);
        TextView textView = (TextView) inflate.findViewById(a.f.rp_show_result);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new s(AlaSnatchRedPacketActivity.this.getPageContext().getPageActivity(), AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.bme)));
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(a.f.rp_gift_btn);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bLy();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        switch (this.fZM) {
            case 100:
            case 103:
            case 104:
                TextView textView3 = (TextView) inflate.findViewById(a.f.rp_snatch_fail);
                textView3.setVisibility(0);
                textView2.setVisibility(8);
                if (this.fZM == 103) {
                    String string = getResources().getString(a.h.snatch_red_packet_failed_4);
                    textView.setVisibility(8);
                    str = string;
                } else {
                    String string2 = getResources().getString(a.h.snatch_red_packet_failed_2);
                    textView.setVisibility(0);
                    str = string2;
                }
                textView3.setText(str);
                return;
            case 101:
                textView2.setVisibility(0);
                ((LinearLayout) inflate.findViewById(a.f.rp_snatch_succ_layout)).setVisibility(0);
                TextView textView4 = (TextView) inflate.findViewById(a.f.rp_snatch_amount);
                textView4.setText(String.format(getResources().getString(a.h.snatch_red_packet_t_dou_suffix), Long.valueOf(this.fZH.bRc())));
                textView4.setVisibility(0);
                return;
            case 102:
                textView2.setVisibility(0);
                TextView textView5 = (TextView) inflate.findViewById(a.f.rp_snatched);
                textView5.setVisibility(0);
                textView5.setText(getPageContext().getString(a.h.snatch_red_packet_loot_prefix) + String.format(getResources().getString(a.h.snatch_red_packet_t_dou_suffix), Long.valueOf(this.fZG.bRc())));
                return;
            default:
                return;
        }
    }

    private void bLC() {
        this.fZr.setVisibility(0);
        this.fZq.setVisibility(8);
        this.fZt.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_red_packet_snatch, (ViewGroup) null);
        this.fZt.addView(inflate, this.fZF);
        ((TextView) inflate.findViewById(a.f.rp_follow_tip)).setVisibility(0);
        ((TextView) inflate.findViewById(a.f.rp_total_amount)).setText(String.format(getResources().getString(a.h.send_ref_packet_desc), Long.valueOf(this.fZG.gzq.gzV)));
        this.fZz = (FrameLayout) inflate.findViewById(a.f.rp_snatch_layout);
        if (UtilHelper.getRealScreenOrientation(this) == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fZz.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds126);
            this.fZz.setLayoutParams(layoutParams);
        }
        this.fZA = (ImageView) inflate.findViewById(a.f.rp_snatch_btn);
        this.fZA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.fZA.setEnabled(false);
                AlaSnatchRedPacketActivity.this.mHandler.postDelayed(AlaSnatchRedPacketActivity.this.fZQ, 1000L);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                if (AlaSnatchRedPacketActivity.this.fZG != null && AlaSnatchRedPacketActivity.this.fZG.gzq != null) {
                    alaStatsItem.addValue("redpacketId", AlaSnatchRedPacketActivity.this.fZG.gzq.id);
                }
                AlaStatManager.getInstance().debug("redpacket_loot_before", "", "", alaStatsItem);
                AlaSnatchRedPacketActivity.this.fZB.av(AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.bme);
            }
        });
        this.fZu = (FrameLayout) inflate.findViewById(a.f.rp_count_down_layout);
        this.fZv = (RoundProgressBar) inflate.findViewById(a.f.rp_snatch_progress);
        this.fZw = (TextView) inflate.findViewById(a.f.rp_snatch_countdown_min);
        this.fZy = (ImageView) inflate.findViewById(a.f.rp_snatch_countdown_dot);
        this.fZy.setVisibility(8);
        this.fZx = (TextView) inflate.findViewById(a.f.rp_snatch_countdown_second);
        if (!this.fZG.bRa()) {
            this.fZA.setVisibility(0);
            this.fZu.setVisibility(8);
            lr(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLD() {
        bLG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eu(long j) {
        if (this.fZG != null) {
            String[] eB = this.fZG.eB(j);
            if (j <= 60) {
                if (!this.fZJ) {
                    this.fZJ = true;
                    if (this.fZy != null) {
                        this.fZy.setVisibility(8);
                    }
                    if (this.fZx != null) {
                        this.fZx.setVisibility(8);
                    }
                    if (this.fZw != null) {
                        this.fZw.setTextSize(0, getResources().getDimensionPixelSize(a.d.sdk_ds108));
                    }
                }
                if (this.fZw != null) {
                    this.fZw.setText(eB[1]);
                }
            } else {
                if (this.fZy != null && this.fZy.getVisibility() != 0) {
                    this.fZy.setVisibility(0);
                }
                if (this.fZw != null) {
                    this.fZw.setText(eB[0]);
                }
                if (this.fZx != null) {
                    this.fZx.setText(eB[1]);
                }
            }
            if (this.fZv != null) {
                this.fZv.setProgress(this.fZG.eA(j));
            }
        }
    }

    private void bLE() {
        this.fZr.setVisibility(8);
        this.fZq.setVisibility(0);
        this.fZt.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_red_packet_condition, (ViewGroup) null);
        this.fZt.addView(inflate, this.fZF);
        TextView textView = (TextView) inflate.findViewById(a.f.rp_condition_desc);
        TextView textView2 = (TextView) inflate.findViewById(a.f.rp_condition_btn);
        if (this.fZG.bRf()) {
            this.fZI = false;
            textView.setText(a.h.snatch_red_packet_cond_follow_desc);
            textView2.setText(a.h.snatch_red_packet_follow_btn);
        } else if (this.fZG.bRg()) {
            this.fZI = true;
            textView.setText(a.h.snatch_red_packet_cond_gift_desc);
            textView2.setText(a.h.snatch_red_packet_gift_btn);
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaSnatchRedPacketActivity.this.fZI) {
                    AlaSnatchRedPacketActivity.this.bLy();
                    AlaSnatchRedPacketActivity.this.finish();
                    return;
                }
                AlaSnatchRedPacketActivity.this.bqq();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqq() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913131, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLF() {
        String str = this.fZG.gzr.gzy;
        com.baidu.live.data.f fVar = new com.baidu.live.data.f(this.fZG.gzq.portrait, str, true, getUniqueId());
        fVar.setFrom("source_snatch_red_packet");
        com.baidu.live.view.a.VO().a(str, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLy() {
        ah ahVar = new ah();
        ahVar.aIH = -1;
        ahVar.aII = -1;
        ahVar.aIK = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, ahVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lr(boolean z) {
        this.fZE = ValueAnimator.ofFloat(1.0f, 0.8f);
        this.fZE.setDuration(250L);
        this.fZE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                AlaSnatchRedPacketActivity.this.fZA.setScaleX(floatValue);
                AlaSnatchRedPacketActivity.this.fZA.setScaleY(floatValue);
            }
        });
        this.fZE.setRepeatCount(-1);
        this.fZE.setRepeatMode(2);
        this.fZE.start();
        AlaStatsItem alaStatsItem = new AlaStatsItem();
        if (this.fZG != null && this.fZG.gzq != null) {
            alaStatsItem.addValue("redpacketId", this.fZG.gzq.id);
        }
        alaStatsItem.addValue("source", z ? "countdown_finish" : "redpacket_status_3");
        AlaStatManager.getInstance().debug("redpacket_loot_enable", "", "", alaStatsItem);
    }

    private void bLG() {
        this.fZu.setVisibility(0);
        this.fZA.setVisibility(0);
        this.fZD = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.fZD.setDuration(500L);
        this.fZD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                AlaSnatchRedPacketActivity.this.fZu.setAlpha(1.0f - animatedFraction);
                AlaSnatchRedPacketActivity.this.fZA.setAlpha(animatedFraction);
                float f = (float) (animatedFraction * 0.5d);
                AlaSnatchRedPacketActivity.this.fZu.setScaleX(1.0f - f);
                AlaSnatchRedPacketActivity.this.fZu.setScaleY(1.0f - f);
                AlaSnatchRedPacketActivity.this.fZA.setScaleX((float) (f + 0.5d));
                AlaSnatchRedPacketActivity.this.fZA.setScaleY((float) (f + 0.5d));
            }
        });
        this.fZD.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.7
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSnatchRedPacketActivity.this.lr(true);
                AlaSnatchRedPacketActivity.this.fZu.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fZD.start();
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
        lq(configuration.orientation == 2);
    }

    private void lq(boolean z) {
        if (z) {
            i.ae(this.cuo);
            this.cuo.setScaleX(0.7f);
            this.cuo.setScaleY(0.7f);
            if (this.fZz != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fZz.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds126);
                this.fZz.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        i.af(this.cuo);
        this.cuo.setScaleX(1.0f);
        this.cuo.setScaleY(1.0f);
        if (this.fZz != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fZz.getLayoutParams();
            layoutParams2.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds146);
            this.fZz.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.fZB != null) {
            this.fZB.onDestroy();
        }
        if (this.fZE != null) {
            this.fZE.removeAllListeners();
            this.fZE.cancel();
            this.fZE = null;
        }
        if (this.fZD != null) {
            this.fZD.removeAllListeners();
            this.fZD.cancel();
            this.fZD = null;
        }
        this.mHandler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.fZP);
        MessageManager.getInstance().unRegisterListener(this.fZN);
        MessageManager.getInstance().unRegisterListener(this.ayx);
        super.onDestroy();
    }
}
