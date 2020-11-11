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
    private HeadImageView biH;
    private String bnP;
    private FrameLayout cwa;
    private TextView ewx;
    private View fXU;
    private View fZJ;
    private View fZK;
    private FrameLayout fZL;
    private FrameLayout fZM;
    private FrameLayout fZN;
    private RoundProgressBar fZO;
    private TextView fZP;
    private TextView fZQ;
    private ImageView fZR;
    private FrameLayout fZS;
    private ImageView fZT;
    private h fZU;
    private String fZV;
    private ValueAnimator fZW;
    private ValueAnimator fZX;
    private FrameLayout.LayoutParams fZY;
    private com.baidu.tieba.ala.data.c fZZ;
    private l gaa;
    private boolean gab;
    private boolean gac;
    private long gad;
    private int gaf;
    private ImageView mCloseBtn;
    private LinearLayout mContentView;
    private String mLiveId;
    private String mRedPacketId;
    private int gae = 2;
    private CustomMessageListener aAi = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaSnatchRedPacketActivity.this.finish();
        }
    };
    private CustomMessageListener gag = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(AlaSnatchRedPacketActivity.this.fZV)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (updateAttentionMessage.getData().isAttention) {
                            AlaSnatchRedPacketActivity.this.showToast(AlaSnatchRedPacketActivity.this.getString(a.h.sdk_attention_success_toast));
                            AlaSnatchRedPacketActivity.this.fZL.setVisibility(8);
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
    private h.a gah = new h.a() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.9
        @Override // com.baidu.tieba.ala.g.h.a
        public void b(com.baidu.tieba.ala.data.c cVar) {
            AlaSnatchRedPacketActivity.this.a(cVar);
        }

        @Override // com.baidu.tieba.ala.g.h.a
        public void aQ(int i, String str) {
            AlaSnatchRedPacketActivity.this.showToast(a.h.sdk_net_fail_tip);
        }

        @Override // com.baidu.tieba.ala.g.h.a
        public void b(l lVar) {
            AlaSnatchRedPacketActivity.this.mHandler.removeCallbacks(AlaSnatchRedPacketActivity.this.gaj);
            AlaSnatchRedPacketActivity.this.fZT.setEnabled(true);
            AlaSnatchRedPacketActivity.this.a(lVar);
        }

        @Override // com.baidu.tieba.ala.g.h.a
        public void aR(int i, String str) {
            AlaSnatchRedPacketActivity.this.mHandler.removeCallbacks(AlaSnatchRedPacketActivity.this.gaj);
            AlaSnatchRedPacketActivity.this.fZT.setEnabled(true);
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                AlaSnatchRedPacketActivity.this.showToast(a.h.sdk_net_fail_tip);
            } else if (!StringUtils.isNullObject(str)) {
                AlaSnatchRedPacketActivity.this.showToast(str);
            } else {
                AlaSnatchRedPacketActivity.this.showToast(a.h.snatch_red_packet_failed_3);
            }
        }
    };
    private CustomMessageListener gai = new CustomMessageListener(2913133) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                AlaSnatchRedPacketActivity.this.gad = ((Long) customResponsedMessage.getData()).longValue();
                AlaSnatchRedPacketActivity.this.eu(AlaSnatchRedPacketActivity.this.gad);
                if (AlaSnatchRedPacketActivity.this.gad < 1) {
                    AlaSnatchRedPacketActivity.this.bMk();
                }
            }
        }
    };
    private Runnable gaj = new Runnable() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.3
        @Override // java.lang.Runnable
        public void run() {
            if (AlaSnatchRedPacketActivity.this.fZT != null) {
                AlaSnatchRedPacketActivity.this.fZT.setEnabled(true);
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
            this.fZU = new h(getPageContext(), this.gah);
            this.fZU.au(this.mRedPacketId, this.mLiveId, this.bnP);
            MessageManager.getInstance().registerListener(this.aAi);
            MessageManager.getInstance().registerListener(this.gag);
            MessageManager.getInstance().registerListener(this.gai);
            this.fZY = new FrameLayout.LayoutParams(-1, -1);
            lp(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.bnP = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.fXU = findViewById(a.f.rp_root_bg);
        this.fXU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaSnatchRedPacketActivity.this.finish();
                }
            }
        });
        this.cwa = (FrameLayout) findViewById(a.f.rp_root_container);
        this.mContentView = (LinearLayout) findViewById(a.f.rp_content_layout);
        this.mContentView.setVisibility(8);
        this.biH = (HeadImageView) findViewById(a.f.rp_user_icon);
        this.biH.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds6));
        this.biH.setBorderColor(getPageContext().getResources().getColor(a.c.ala_red_packet_main_color));
        this.biH.setIsRound(true);
        this.biH.setDefaultResource(a.e.sdk_icon_default_avatar100_bg);
        this.biH.setAutoChangeStyle(true);
        this.biH.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ewx = (TextView) findViewById(a.f.rp_user_name);
        this.fZL = (FrameLayout) findViewById(a.f.rp_follow_sender);
        this.fZL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bMm();
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
        this.fZK = findViewById(a.f.rp_normal_bg);
        this.fZJ = findViewById(a.f.rp_condition_guide_bg);
        this.fZM = (FrameLayout) findViewById(a.f.rp_sub_content_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar) {
        this.gaa = lVar;
        if (lVar.bRI()) {
            this.gaf = 101;
        } else {
            this.gaf = 100;
        }
        bMi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.data.c cVar) {
        if (cVar.gzJ != null) {
            this.mContentView.setVisibility(0);
            this.fZZ = cVar;
            this.fZV = this.fZZ.gzK.gzR;
            if (!StringUtils.isNullObject(cVar.gzJ.portrait)) {
                com.baidu.live.utils.l.a(this.biH, cVar.gzJ.portrait, true, false);
            }
            this.ewx.setText(cVar.gzJ.userName);
            if (!cVar.bRL()) {
                this.fZL.setVisibility(8);
            } else {
                boolean equals = TbadkCoreApplication.getCurrentAccount() != null ? TbadkCoreApplication.getCurrentAccount().equals(this.fZV) : true;
                if (this.fZZ.gzK.gzS || equals) {
                    this.fZL.setVisibility(8);
                } else {
                    this.fZL.setVisibility(0);
                }
            }
            if (this.fZZ.bRI()) {
                this.gae = 3;
            } else if (this.fZZ.isValid()) {
                if (cVar.bRK()) {
                    this.gae = 1;
                    this.fZL.setVisibility(8);
                } else {
                    this.gae = 2;
                }
            } else if (this.fZZ.bRF()) {
                this.gae = 5;
            } else if (this.fZZ.bRG()) {
                this.gae = 4;
            }
            bMh();
        }
    }

    private void bMh() {
        switch (this.gae) {
            case 1:
                bMl();
                return;
            case 2:
                bMj();
                return;
            case 3:
                this.gaf = 102;
                bMi();
                return;
            case 4:
                this.gaf = 103;
                bMi();
                return;
            case 5:
                this.gaf = 104;
                bMi();
                return;
            default:
                return;
        }
    }

    private void bMi() {
        String str;
        this.fZK.setVisibility(8);
        this.fZJ.setVisibility(0);
        this.fZM.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_red_packet_outcome, (ViewGroup) null);
        this.fZM.addView(inflate, this.fZY);
        TextView textView = (TextView) inflate.findViewById(a.f.rp_show_result);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new s(AlaSnatchRedPacketActivity.this.getPageContext().getPageActivity(), AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.bnP)));
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(a.f.rp_gift_btn);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bMf();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        switch (this.gaf) {
            case 100:
            case 103:
            case 104:
                TextView textView3 = (TextView) inflate.findViewById(a.f.rp_snatch_fail);
                textView3.setVisibility(0);
                textView2.setVisibility(8);
                if (this.gaf == 103) {
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
                textView4.setText(String.format(getResources().getString(a.h.snatch_red_packet_t_dou_suffix), Long.valueOf(this.gaa.bRJ())));
                textView4.setVisibility(0);
                return;
            case 102:
                textView2.setVisibility(0);
                TextView textView5 = (TextView) inflate.findViewById(a.f.rp_snatched);
                textView5.setVisibility(0);
                textView5.setText(getPageContext().getString(a.h.snatch_red_packet_loot_prefix) + String.format(getResources().getString(a.h.snatch_red_packet_t_dou_suffix), Long.valueOf(this.fZZ.bRJ())));
                return;
            default:
                return;
        }
    }

    private void bMj() {
        this.fZK.setVisibility(0);
        this.fZJ.setVisibility(8);
        this.fZM.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_red_packet_snatch, (ViewGroup) null);
        this.fZM.addView(inflate, this.fZY);
        ((TextView) inflate.findViewById(a.f.rp_follow_tip)).setVisibility(0);
        ((TextView) inflate.findViewById(a.f.rp_total_amount)).setText(String.format(getResources().getString(a.h.send_ref_packet_desc), Long.valueOf(this.fZZ.gzJ.gAo)));
        this.fZS = (FrameLayout) inflate.findViewById(a.f.rp_snatch_layout);
        if (UtilHelper.getRealScreenOrientation(this) == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fZS.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds126);
            this.fZS.setLayoutParams(layoutParams);
        }
        this.fZT = (ImageView) inflate.findViewById(a.f.rp_snatch_btn);
        this.fZT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.fZT.setEnabled(false);
                AlaSnatchRedPacketActivity.this.mHandler.postDelayed(AlaSnatchRedPacketActivity.this.gaj, 1000L);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                if (AlaSnatchRedPacketActivity.this.fZZ != null && AlaSnatchRedPacketActivity.this.fZZ.gzJ != null) {
                    alaStatsItem.addValue("redpacketId", AlaSnatchRedPacketActivity.this.fZZ.gzJ.id);
                }
                AlaStatManager.getInstance().debug("redpacket_loot_before", "", "", alaStatsItem);
                AlaSnatchRedPacketActivity.this.fZU.av(AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.bnP);
            }
        });
        this.fZN = (FrameLayout) inflate.findViewById(a.f.rp_count_down_layout);
        this.fZO = (RoundProgressBar) inflate.findViewById(a.f.rp_snatch_progress);
        this.fZP = (TextView) inflate.findViewById(a.f.rp_snatch_countdown_min);
        this.fZR = (ImageView) inflate.findViewById(a.f.rp_snatch_countdown_dot);
        this.fZR.setVisibility(8);
        this.fZQ = (TextView) inflate.findViewById(a.f.rp_snatch_countdown_second);
        if (!this.fZZ.bRH()) {
            this.fZT.setVisibility(0);
            this.fZN.setVisibility(8);
            lq(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMk() {
        bMn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eu(long j) {
        if (this.fZZ != null) {
            String[] eB = this.fZZ.eB(j);
            if (j <= 60) {
                if (!this.gac) {
                    this.gac = true;
                    if (this.fZR != null) {
                        this.fZR.setVisibility(8);
                    }
                    if (this.fZQ != null) {
                        this.fZQ.setVisibility(8);
                    }
                    if (this.fZP != null) {
                        this.fZP.setTextSize(0, getResources().getDimensionPixelSize(a.d.sdk_ds108));
                    }
                }
                if (this.fZP != null) {
                    this.fZP.setText(eB[1]);
                }
            } else {
                if (this.fZR != null && this.fZR.getVisibility() != 0) {
                    this.fZR.setVisibility(0);
                }
                if (this.fZP != null) {
                    this.fZP.setText(eB[0]);
                }
                if (this.fZQ != null) {
                    this.fZQ.setText(eB[1]);
                }
            }
            if (this.fZO != null) {
                this.fZO.setProgress(this.fZZ.eA(j));
            }
        }
    }

    private void bMl() {
        this.fZK.setVisibility(8);
        this.fZJ.setVisibility(0);
        this.fZM.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_red_packet_condition, (ViewGroup) null);
        this.fZM.addView(inflate, this.fZY);
        TextView textView = (TextView) inflate.findViewById(a.f.rp_condition_desc);
        TextView textView2 = (TextView) inflate.findViewById(a.f.rp_condition_btn);
        if (this.fZZ.bRM()) {
            this.gab = false;
            textView.setText(a.h.snatch_red_packet_cond_follow_desc);
            textView2.setText(a.h.snatch_red_packet_follow_btn);
        } else if (this.fZZ.bRN()) {
            this.gab = true;
            textView.setText(a.h.snatch_red_packet_cond_gift_desc);
            textView2.setText(a.h.snatch_red_packet_gift_btn);
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaSnatchRedPacketActivity.this.gab) {
                    AlaSnatchRedPacketActivity.this.bMf();
                    AlaSnatchRedPacketActivity.this.finish();
                    return;
                }
                AlaSnatchRedPacketActivity.this.brd();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brd() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913131, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMm() {
        String str = this.fZZ.gzK.gzR;
        com.baidu.live.data.f fVar = new com.baidu.live.data.f(this.fZZ.gzJ.portrait, str, true, getUniqueId());
        fVar.setFrom("source_snatch_red_packet");
        com.baidu.live.view.a.Wx().a(str, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMf() {
        ah ahVar = new ah();
        ahVar.aKs = -1;
        ahVar.aKt = -1;
        ahVar.aKv = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, ahVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lq(boolean z) {
        this.fZX = ValueAnimator.ofFloat(1.0f, 0.8f);
        this.fZX.setDuration(250L);
        this.fZX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                AlaSnatchRedPacketActivity.this.fZT.setScaleX(floatValue);
                AlaSnatchRedPacketActivity.this.fZT.setScaleY(floatValue);
            }
        });
        this.fZX.setRepeatCount(-1);
        this.fZX.setRepeatMode(2);
        this.fZX.start();
        AlaStatsItem alaStatsItem = new AlaStatsItem();
        if (this.fZZ != null && this.fZZ.gzJ != null) {
            alaStatsItem.addValue("redpacketId", this.fZZ.gzJ.id);
        }
        alaStatsItem.addValue("source", z ? "countdown_finish" : "redpacket_status_3");
        AlaStatManager.getInstance().debug("redpacket_loot_enable", "", "", alaStatsItem);
    }

    private void bMn() {
        this.fZN.setVisibility(0);
        this.fZT.setVisibility(0);
        this.fZW = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.fZW.setDuration(500L);
        this.fZW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                AlaSnatchRedPacketActivity.this.fZN.setAlpha(1.0f - animatedFraction);
                AlaSnatchRedPacketActivity.this.fZT.setAlpha(animatedFraction);
                float f = (float) (animatedFraction * 0.5d);
                AlaSnatchRedPacketActivity.this.fZN.setScaleX(1.0f - f);
                AlaSnatchRedPacketActivity.this.fZN.setScaleY(1.0f - f);
                AlaSnatchRedPacketActivity.this.fZT.setScaleX((float) (f + 0.5d));
                AlaSnatchRedPacketActivity.this.fZT.setScaleY((float) (f + 0.5d));
            }
        });
        this.fZW.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.7
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSnatchRedPacketActivity.this.lq(true);
                AlaSnatchRedPacketActivity.this.fZN.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fZW.start();
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
        lp(configuration.orientation == 2);
    }

    private void lp(boolean z) {
        if (z) {
            i.ae(this.cwa);
            this.cwa.setScaleX(0.7f);
            this.cwa.setScaleY(0.7f);
            if (this.fZS != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fZS.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds126);
                this.fZS.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        i.af(this.cwa);
        this.cwa.setScaleX(1.0f);
        this.cwa.setScaleY(1.0f);
        if (this.fZS != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fZS.getLayoutParams();
            layoutParams2.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds146);
            this.fZS.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.fZU != null) {
            this.fZU.onDestroy();
        }
        if (this.fZX != null) {
            this.fZX.removeAllListeners();
            this.fZX.cancel();
            this.fZX = null;
        }
        if (this.fZW != null) {
            this.fZW.removeAllListeners();
            this.fZW.cancel();
            this.fZW = null;
        }
        this.mHandler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gai);
        MessageManager.getInstance().unRegisterListener(this.gag);
        MessageManager.getInstance().unRegisterListener(this.aAi);
        super.onDestroy();
    }
}
