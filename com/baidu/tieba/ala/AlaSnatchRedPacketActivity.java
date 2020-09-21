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
    private FrameLayout bVn;
    private HeadImageView bck;
    private String bhk;
    private TextView dWe;
    private View fxA;
    private TextView fzA;
    private ImageView fzB;
    private FrameLayout fzC;
    private ImageView fzD;
    private h fzE;
    private String fzF;
    private ValueAnimator fzG;
    private ValueAnimator fzH;
    private FrameLayout.LayoutParams fzI;
    private com.baidu.tieba.ala.data.c fzJ;
    private j fzK;
    private boolean fzL;
    private boolean fzM;
    private long fzN;
    private int fzP;
    private View fzt;
    private View fzu;
    private FrameLayout fzv;
    private FrameLayout fzw;
    private FrameLayout fzx;
    private RoundProgressBar fzy;
    private TextView fzz;
    private ImageView mCloseBtn;
    private LinearLayout mContentView;
    private String mLiveId;
    private String mRedPacketId;
    private int fzO = 2;
    private CustomMessageListener azu = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaSnatchRedPacketActivity.this.finish();
        }
    };
    private CustomMessageListener fzQ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(AlaSnatchRedPacketActivity.this.fzF)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (updateAttentionMessage.getData().isAttention) {
                            AlaSnatchRedPacketActivity.this.showToast(AlaSnatchRedPacketActivity.this.getString(a.i.sdk_attention_success_toast));
                            AlaSnatchRedPacketActivity.this.fzv.setVisibility(8);
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
    private h.a fzR = new h.a() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.9
        @Override // com.baidu.tieba.ala.g.h.a
        public void b(com.baidu.tieba.ala.data.c cVar) {
            AlaSnatchRedPacketActivity.this.a(cVar);
        }

        @Override // com.baidu.tieba.ala.g.h.a
        public void aA(int i, String str) {
            AlaSnatchRedPacketActivity.this.showToast(a.i.sdk_net_fail_tip);
        }

        @Override // com.baidu.tieba.ala.g.h.a
        public void b(j jVar) {
            AlaSnatchRedPacketActivity.this.mHandler.removeCallbacks(AlaSnatchRedPacketActivity.this.fzT);
            AlaSnatchRedPacketActivity.this.fzD.setEnabled(true);
            AlaSnatchRedPacketActivity.this.a(jVar);
        }

        @Override // com.baidu.tieba.ala.g.h.a
        public void aB(int i, String str) {
            AlaSnatchRedPacketActivity.this.mHandler.removeCallbacks(AlaSnatchRedPacketActivity.this.fzT);
            AlaSnatchRedPacketActivity.this.fzD.setEnabled(true);
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                AlaSnatchRedPacketActivity.this.showToast(a.i.sdk_net_fail_tip);
            } else if (!StringUtils.isNullObject(str)) {
                AlaSnatchRedPacketActivity.this.showToast(str);
            } else {
                AlaSnatchRedPacketActivity.this.showToast(a.i.snatch_red_packet_failed_3);
            }
        }
    };
    private CustomMessageListener fzS = new CustomMessageListener(2913133) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                AlaSnatchRedPacketActivity.this.fzN = ((Long) customResponsedMessage.getData()).longValue();
                AlaSnatchRedPacketActivity.this.dN(AlaSnatchRedPacketActivity.this.fzN);
                if (AlaSnatchRedPacketActivity.this.fzN < 1) {
                    AlaSnatchRedPacketActivity.this.bFh();
                }
            }
        }
    };
    private Runnable fzT = new Runnable() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.3
        @Override // java.lang.Runnable
        public void run() {
            if (AlaSnatchRedPacketActivity.this.fzD != null) {
                AlaSnatchRedPacketActivity.this.fzD.setEnabled(true);
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
            this.fzE = new h(getPageContext(), this.fzR);
            this.fzE.ak(this.mRedPacketId, this.mLiveId, this.bhk);
            MessageManager.getInstance().registerListener(this.azu);
            MessageManager.getInstance().registerListener(this.fzQ);
            MessageManager.getInstance().registerListener(this.fzS);
            this.fzI = new FrameLayout.LayoutParams(-1, -1);
            kv(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.bhk = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.fxA = findViewById(a.g.rp_root_bg);
        this.fxA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaSnatchRedPacketActivity.this.finish();
                }
            }
        });
        this.bVn = (FrameLayout) findViewById(a.g.rp_root_container);
        this.mContentView = (LinearLayout) findViewById(a.g.rp_content_layout);
        this.mContentView.setVisibility(8);
        this.bck = (HeadImageView) findViewById(a.g.rp_user_icon);
        this.bck.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds6));
        this.bck.setBorderColor(getPageContext().getResources().getColor(a.d.ala_red_packet_main_color));
        this.bck.setIsRound(true);
        this.bck.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.bck.setAutoChangeStyle(true);
        this.bck.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dWe = (TextView) findViewById(a.g.rp_user_name);
        this.fzv = (FrameLayout) findViewById(a.g.rp_follow_sender);
        this.fzv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bFj();
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
        this.fzu = findViewById(a.g.rp_normal_bg);
        this.fzt = findViewById(a.g.rp_condition_guide_bg);
        this.fzw = (FrameLayout) findViewById(a.g.rp_sub_content_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j jVar) {
        this.fzK = jVar;
        if (jVar.bJY()) {
            this.fzP = 101;
        } else {
            this.fzP = 100;
        }
        bFf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.data.c cVar) {
        if (cVar.fXy != null) {
            this.mContentView.setVisibility(0);
            this.fzJ = cVar;
            this.fzF = this.fzJ.fXz.fXG;
            if (!StringUtils.isNullObject(cVar.fXy.portrait)) {
                l.a(this.bck, cVar.fXy.portrait, true, false);
            }
            this.dWe.setText(cVar.fXy.userName);
            if (!cVar.bKb()) {
                this.fzv.setVisibility(8);
            } else {
                boolean equals = TbadkCoreApplication.getCurrentAccount() != null ? TbadkCoreApplication.getCurrentAccount().equals(this.fzF) : true;
                if (this.fzJ.fXz.fXH || equals) {
                    this.fzv.setVisibility(8);
                } else {
                    this.fzv.setVisibility(0);
                }
            }
            if (this.fzJ.bJY()) {
                this.fzO = 3;
            } else if (this.fzJ.isValid()) {
                if (cVar.bKa()) {
                    this.fzO = 1;
                    this.fzv.setVisibility(8);
                } else {
                    this.fzO = 2;
                }
            } else if (this.fzJ.bJV()) {
                this.fzO = 5;
            } else if (this.fzJ.bJW()) {
                this.fzO = 4;
            }
            bFe();
        }
    }

    private void bFe() {
        switch (this.fzO) {
            case 1:
                bFi();
                return;
            case 2:
                bFg();
                return;
            case 3:
                this.fzP = 102;
                bFf();
                return;
            case 4:
                this.fzP = 103;
                bFf();
                return;
            case 5:
                this.fzP = 104;
                bFf();
                return;
            default:
                return;
        }
    }

    private void bFf() {
        String str;
        this.fzu.setVisibility(8);
        this.fzt.setVisibility(0);
        this.fzw.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_outcome, (ViewGroup) null);
        this.fzw.addView(inflate, this.fzI);
        TextView textView = (TextView) inflate.findViewById(a.g.rp_show_result);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new q(AlaSnatchRedPacketActivity.this.getPageContext().getPageActivity(), AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.bhk)));
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(a.g.rp_gift_btn);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bFd();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        switch (this.fzP) {
            case 100:
            case 103:
            case 104:
                TextView textView3 = (TextView) inflate.findViewById(a.g.rp_snatch_fail);
                textView3.setVisibility(0);
                textView2.setVisibility(8);
                if (this.fzP == 103) {
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
                textView4.setText(String.format(getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(this.fzK.bJZ())));
                textView4.setVisibility(0);
                return;
            case 102:
                textView2.setVisibility(0);
                TextView textView5 = (TextView) inflate.findViewById(a.g.rp_snatched);
                textView5.setVisibility(0);
                textView5.setText(getPageContext().getString(a.i.snatch_red_packet_loot_prefix) + String.format(getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(this.fzJ.bJZ())));
                return;
            default:
                return;
        }
    }

    private void bFg() {
        this.fzu.setVisibility(0);
        this.fzt.setVisibility(8);
        this.fzw.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_snatch, (ViewGroup) null);
        this.fzw.addView(inflate, this.fzI);
        ((TextView) inflate.findViewById(a.g.rp_follow_tip)).setVisibility(0);
        ((TextView) inflate.findViewById(a.g.rp_total_amount)).setText(String.format(getResources().getString(a.i.send_ref_packet_desc), Long.valueOf(this.fzJ.fXy.fYe)));
        this.fzC = (FrameLayout) inflate.findViewById(a.g.rp_snatch_layout);
        if (UtilHelper.getRealScreenOrientation(this) == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fzC.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds126);
            this.fzC.setLayoutParams(layoutParams);
        }
        this.fzD = (ImageView) inflate.findViewById(a.g.rp_snatch_btn);
        this.fzD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.fzD.setEnabled(false);
                AlaSnatchRedPacketActivity.this.mHandler.postDelayed(AlaSnatchRedPacketActivity.this.fzT, 1000L);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                if (AlaSnatchRedPacketActivity.this.fzJ != null && AlaSnatchRedPacketActivity.this.fzJ.fXy != null) {
                    alaStatsItem.addValue("redpacketId", AlaSnatchRedPacketActivity.this.fzJ.fXy.id);
                }
                AlaStatManager.getInstance().debug("redpacket_loot_before", "", "", alaStatsItem);
                AlaSnatchRedPacketActivity.this.fzE.al(AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.bhk);
            }
        });
        this.fzx = (FrameLayout) inflate.findViewById(a.g.rp_count_down_layout);
        this.fzy = (RoundProgressBar) inflate.findViewById(a.g.rp_snatch_progress);
        this.fzz = (TextView) inflate.findViewById(a.g.rp_snatch_countdown_min);
        this.fzB = (ImageView) inflate.findViewById(a.g.rp_snatch_countdown_dot);
        this.fzB.setVisibility(8);
        this.fzA = (TextView) inflate.findViewById(a.g.rp_snatch_countdown_second);
        if (!this.fzJ.bJX()) {
            this.fzD.setVisibility(0);
            this.fzx.setVisibility(8);
            kw(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFh() {
        bFk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dN(long j) {
        if (this.fzJ != null) {
            String[] dU = this.fzJ.dU(j);
            if (j <= 60) {
                if (!this.fzM) {
                    this.fzM = true;
                    if (this.fzB != null) {
                        this.fzB.setVisibility(8);
                    }
                    if (this.fzA != null) {
                        this.fzA.setVisibility(8);
                    }
                    if (this.fzz != null) {
                        this.fzz.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_ds108));
                    }
                }
                if (this.fzz != null) {
                    this.fzz.setText(dU[1]);
                }
            } else {
                if (this.fzB != null && this.fzB.getVisibility() != 0) {
                    this.fzB.setVisibility(0);
                }
                if (this.fzz != null) {
                    this.fzz.setText(dU[0]);
                }
                if (this.fzA != null) {
                    this.fzA.setText(dU[1]);
                }
            }
            if (this.fzy != null) {
                this.fzy.setProgress(this.fzJ.dT(j));
            }
        }
    }

    private void bFi() {
        this.fzu.setVisibility(8);
        this.fzt.setVisibility(0);
        this.fzw.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_condition, (ViewGroup) null);
        this.fzw.addView(inflate, this.fzI);
        TextView textView = (TextView) inflate.findViewById(a.g.rp_condition_desc);
        TextView textView2 = (TextView) inflate.findViewById(a.g.rp_condition_btn);
        if (this.fzJ.bKc()) {
            this.fzL = false;
            textView.setText(a.i.snatch_red_packet_cond_follow_desc);
            textView2.setText(a.i.snatch_red_packet_follow_btn);
        } else if (this.fzJ.bKd()) {
            this.fzL = true;
            textView.setText(a.i.snatch_red_packet_cond_gift_desc);
            textView2.setText(a.i.snatch_red_packet_gift_btn);
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaSnatchRedPacketActivity.this.fzL) {
                    AlaSnatchRedPacketActivity.this.bFd();
                    AlaSnatchRedPacketActivity.this.finish();
                    return;
                }
                AlaSnatchRedPacketActivity.this.bkb();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkb() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913131, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFj() {
        String str = this.fzJ.fXz.fXG;
        com.baidu.live.data.e eVar = new com.baidu.live.data.e(this.fzJ.fXy.portrait, str, true, getUniqueId());
        eVar.setFrom("source_snatch_red_packet");
        com.baidu.live.view.a.Rg().a(str, eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFd() {
        ad adVar = new ad();
        adVar.aFM = -1;
        adVar.aFN = -1;
        adVar.aFP = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, adVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kw(boolean z) {
        this.fzH = ValueAnimator.ofFloat(1.0f, 0.8f);
        this.fzH.setDuration(250L);
        this.fzH.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                AlaSnatchRedPacketActivity.this.fzD.setScaleX(floatValue);
                AlaSnatchRedPacketActivity.this.fzD.setScaleY(floatValue);
            }
        });
        this.fzH.setRepeatCount(-1);
        this.fzH.setRepeatMode(2);
        this.fzH.start();
        AlaStatsItem alaStatsItem = new AlaStatsItem();
        if (this.fzJ != null && this.fzJ.fXy != null) {
            alaStatsItem.addValue("redpacketId", this.fzJ.fXy.id);
        }
        alaStatsItem.addValue("source", z ? "countdown_finish" : "redpacket_status_3");
        AlaStatManager.getInstance().debug("redpacket_loot_enable", "", "", alaStatsItem);
    }

    private void bFk() {
        this.fzx.setVisibility(0);
        this.fzD.setVisibility(0);
        this.fzG = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.fzG.setDuration(500L);
        this.fzG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                AlaSnatchRedPacketActivity.this.fzx.setAlpha(1.0f - animatedFraction);
                AlaSnatchRedPacketActivity.this.fzD.setAlpha(animatedFraction);
                float f = (float) (animatedFraction * 0.5d);
                AlaSnatchRedPacketActivity.this.fzx.setScaleX(1.0f - f);
                AlaSnatchRedPacketActivity.this.fzx.setScaleY(1.0f - f);
                AlaSnatchRedPacketActivity.this.fzD.setScaleX((float) (f + 0.5d));
                AlaSnatchRedPacketActivity.this.fzD.setScaleY((float) (f + 0.5d));
            }
        });
        this.fzG.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.7
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSnatchRedPacketActivity.this.kw(true);
                AlaSnatchRedPacketActivity.this.fzx.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fzG.start();
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
        kv(configuration.orientation == 2);
    }

    private void kv(boolean z) {
        if (z) {
            i.aa(this.bVn);
            this.bVn.setScaleX(0.7f);
            this.bVn.setScaleY(0.7f);
            if (this.fzC != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fzC.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds126);
                this.fzC.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        i.ab(this.bVn);
        this.bVn.setScaleX(1.0f);
        this.bVn.setScaleY(1.0f);
        if (this.fzC != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fzC.getLayoutParams();
            layoutParams2.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds146);
            this.fzC.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.fzE != null) {
            this.fzE.onDestroy();
        }
        if (this.fzH != null) {
            this.fzH.removeAllListeners();
            this.fzH.cancel();
            this.fzH = null;
        }
        if (this.fzG != null) {
            this.fzG.removeAllListeners();
            this.fzG.cancel();
            this.fzG = null;
        }
        this.mHandler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.fzS);
        MessageManager.getInstance().unRegisterListener(this.fzQ);
        MessageManager.getInstance().unRegisterListener(this.azu);
        super.onDestroy();
    }
}
