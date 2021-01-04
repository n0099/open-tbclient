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
import com.baidu.live.d.t;
import com.baidu.live.data.ak;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.live.utils.i;
import com.baidu.live.utils.m;
import com.baidu.tieba.ala.data.l;
import com.baidu.tieba.ala.g.h;
import com.baidu.tieba.ala.view.RoundProgressBar;
/* loaded from: classes11.dex */
public class AlaSnatchRedPacketActivity extends BaseFragmentActivity {
    private HeadImageView bmO;
    private String bvS;
    private FrameLayout cFY;
    private TextView eLt;
    private View gpT;
    private View gsb;
    private View gsc;
    private FrameLayout gsd;
    private FrameLayout gse;
    private FrameLayout gsf;
    private RoundProgressBar gsg;
    private TextView gsh;
    private TextView gsi;
    private ImageView gsj;
    private FrameLayout gsk;
    private ImageView gsl;
    private com.baidu.tieba.ala.g.h gsm;
    private String gsn;
    private ValueAnimator gso;
    private ValueAnimator gsp;
    private FrameLayout.LayoutParams gsq;
    private com.baidu.tieba.ala.data.c gsr;
    private l gss;
    private boolean gst;
    private boolean gsu;
    private long gsv;
    private int gsx;
    private ImageView mCloseBtn;
    private LinearLayout mContentView;
    private String mLiveId;
    private String mRedPacketId;
    private int gsw = 2;
    private CustomMessageListener aBj = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaSnatchRedPacketActivity.this.finish();
        }
    };
    private CustomMessageListener gsy = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(AlaSnatchRedPacketActivity.this.gsn)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (updateAttentionMessage.getData().isAttention) {
                            AlaSnatchRedPacketActivity.this.showToast(AlaSnatchRedPacketActivity.this.getString(a.h.sdk_attention_success_toast));
                            AlaSnatchRedPacketActivity.this.gsd.setVisibility(8);
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
    private h.a gsz = new h.a() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.9
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
            AlaSnatchRedPacketActivity.this.mHandler.removeCallbacks(AlaSnatchRedPacketActivity.this.gsB);
            AlaSnatchRedPacketActivity.this.gsl.setEnabled(true);
            AlaSnatchRedPacketActivity.this.a(lVar);
        }

        @Override // com.baidu.tieba.ala.g.h.a
        public void aR(int i, String str) {
            AlaSnatchRedPacketActivity.this.mHandler.removeCallbacks(AlaSnatchRedPacketActivity.this.gsB);
            AlaSnatchRedPacketActivity.this.gsl.setEnabled(true);
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                AlaSnatchRedPacketActivity.this.showToast(a.h.sdk_net_fail_tip);
            } else if (!StringUtils.isNullObject(str)) {
                AlaSnatchRedPacketActivity.this.showToast(str);
            } else {
                AlaSnatchRedPacketActivity.this.showToast(a.h.snatch_red_packet_failed_3);
            }
        }
    };
    private CustomMessageListener gsA = new CustomMessageListener(2913133) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                AlaSnatchRedPacketActivity.this.gsv = ((Long) customResponsedMessage.getData()).longValue();
                AlaSnatchRedPacketActivity.this.eX(AlaSnatchRedPacketActivity.this.gsv);
                if (AlaSnatchRedPacketActivity.this.gsv < 1) {
                    AlaSnatchRedPacketActivity.this.bRN();
                }
            }
        }
    };
    private Runnable gsB = new Runnable() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.3
        @Override // java.lang.Runnable
        public void run() {
            if (AlaSnatchRedPacketActivity.this.gsl != null) {
                AlaSnatchRedPacketActivity.this.gsl.setEnabled(true);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
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
            this.gsm = new com.baidu.tieba.ala.g.h(getPageContext(), this.gsz);
            this.gsm.az(this.mRedPacketId, this.mLiveId, this.bvS);
            MessageManager.getInstance().registerListener(this.aBj);
            MessageManager.getInstance().registerListener(this.gsy);
            MessageManager.getInstance().registerListener(this.gsA);
            this.gsq = new FrameLayout.LayoutParams(-1, -1);
            mi(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.bvS = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.gpT = findViewById(a.f.rp_root_bg);
        this.gpT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaSnatchRedPacketActivity.this.finish();
                }
            }
        });
        this.cFY = (FrameLayout) findViewById(a.f.rp_root_container);
        this.mContentView = (LinearLayout) findViewById(a.f.rp_content_layout);
        this.mContentView.setVisibility(8);
        this.bmO = (HeadImageView) findViewById(a.f.rp_user_icon);
        this.bmO.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds6));
        this.bmO.setBorderColor(getPageContext().getResources().getColor(a.c.ala_red_packet_main_color));
        this.bmO.setIsRound(true);
        this.bmO.setDefaultResource(a.e.sdk_icon_default_avatar100_bg);
        this.bmO.setAutoChangeStyle(true);
        this.bmO.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eLt = (TextView) findViewById(a.f.rp_user_name);
        this.gsd = (FrameLayout) findViewById(a.f.rp_follow_sender);
        this.gsd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bRP();
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
        this.gsc = findViewById(a.f.rp_normal_bg);
        this.gsb = findViewById(a.f.rp_condition_guide_bg);
        this.gse = (FrameLayout) findViewById(a.f.rp_sub_content_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar) {
        this.gss = lVar;
        if (lVar.bXq()) {
            this.gsx = 101;
        } else {
            this.gsx = 100;
        }
        bRL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.data.c cVar) {
        if (cVar.gUa != null) {
            this.mContentView.setVisibility(0);
            this.gsr = cVar;
            this.gsn = this.gsr.gUb.gUi;
            if (!StringUtils.isNullObject(cVar.gUa.portrait)) {
                m.a(this.bmO, cVar.gUa.portrait, true, false);
            }
            this.eLt.setText(cVar.gUa.userName);
            if (!cVar.bXt()) {
                this.gsd.setVisibility(8);
            } else {
                boolean equals = TbadkCoreApplication.getCurrentAccount() != null ? TbadkCoreApplication.getCurrentAccount().equals(this.gsn) : true;
                if (this.gsr.gUb.gUj || equals) {
                    this.gsd.setVisibility(8);
                } else {
                    this.gsd.setVisibility(0);
                }
            }
            if (this.gsr.bXq()) {
                this.gsw = 3;
            } else if (this.gsr.isValid()) {
                if (cVar.bXs()) {
                    this.gsw = 1;
                    this.gsd.setVisibility(8);
                } else {
                    this.gsw = 2;
                }
            } else if (this.gsr.bXn()) {
                this.gsw = 5;
            } else if (this.gsr.bXo()) {
                this.gsw = 4;
            }
            bRK();
        }
    }

    private void bRK() {
        switch (this.gsw) {
            case 1:
                bRO();
                return;
            case 2:
                bRM();
                return;
            case 3:
                this.gsx = 102;
                bRL();
                return;
            case 4:
                this.gsx = 103;
                bRL();
                return;
            case 5:
                this.gsx = 104;
                bRL();
                return;
            default:
                return;
        }
    }

    private void bRL() {
        String str;
        this.gsc.setVisibility(8);
        this.gsb.setVisibility(0);
        this.gse.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_red_packet_outcome, (ViewGroup) null);
        this.gse.addView(inflate, this.gsq);
        TextView textView = (TextView) inflate.findViewById(a.f.rp_show_result);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new t(AlaSnatchRedPacketActivity.this.getPageContext().getPageActivity(), AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.bvS)));
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(a.f.rp_gift_btn);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bRI();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        switch (this.gsx) {
            case 100:
            case 103:
            case 104:
                TextView textView3 = (TextView) inflate.findViewById(a.f.rp_snatch_fail);
                textView3.setVisibility(0);
                textView2.setVisibility(8);
                if (this.gsx == 103) {
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
                textView4.setText(String.format(getResources().getString(a.h.snatch_red_packet_t_dou_suffix), Long.valueOf(this.gss.bXr())));
                textView4.setVisibility(0);
                return;
            case 102:
                textView2.setVisibility(0);
                TextView textView5 = (TextView) inflate.findViewById(a.f.rp_snatched);
                textView5.setVisibility(0);
                textView5.setText(getPageContext().getString(a.h.snatch_red_packet_loot_prefix) + String.format(getResources().getString(a.h.snatch_red_packet_t_dou_suffix), Long.valueOf(this.gsr.bXr())));
                return;
            default:
                return;
        }
    }

    private void bRM() {
        this.gsc.setVisibility(0);
        this.gsb.setVisibility(8);
        this.gse.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_red_packet_snatch, (ViewGroup) null);
        this.gse.addView(inflate, this.gsq);
        ((TextView) inflate.findViewById(a.f.rp_follow_tip)).setVisibility(0);
        ((TextView) inflate.findViewById(a.f.rp_total_amount)).setText(String.format(getResources().getString(a.h.send_ref_packet_desc), Long.valueOf(this.gsr.gUa.gUG)));
        this.gsk = (FrameLayout) inflate.findViewById(a.f.rp_snatch_layout);
        if (UtilHelper.getRealScreenOrientation(this) == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gsk.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds126);
            this.gsk.setLayoutParams(layoutParams);
        }
        this.gsl = (ImageView) inflate.findViewById(a.f.rp_snatch_btn);
        this.gsl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.gsl.setEnabled(false);
                AlaSnatchRedPacketActivity.this.mHandler.postDelayed(AlaSnatchRedPacketActivity.this.gsB, 1000L);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                if (AlaSnatchRedPacketActivity.this.gsr != null && AlaSnatchRedPacketActivity.this.gsr.gUa != null) {
                    alaStatsItem.addValue("redpacketId", AlaSnatchRedPacketActivity.this.gsr.gUa.id);
                }
                AlaStatManager.getInstance().debug("redpacket_loot_before", "", "", alaStatsItem);
                AlaSnatchRedPacketActivity.this.gsm.aA(AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.bvS);
            }
        });
        this.gsf = (FrameLayout) inflate.findViewById(a.f.rp_count_down_layout);
        this.gsg = (RoundProgressBar) inflate.findViewById(a.f.rp_snatch_progress);
        this.gsh = (TextView) inflate.findViewById(a.f.rp_snatch_countdown_min);
        this.gsj = (ImageView) inflate.findViewById(a.f.rp_snatch_countdown_dot);
        this.gsj.setVisibility(8);
        this.gsi = (TextView) inflate.findViewById(a.f.rp_snatch_countdown_second);
        if (!this.gsr.bXp()) {
            this.gsl.setVisibility(0);
            this.gsf.setVisibility(8);
            mj(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRN() {
        bRQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eX(long j) {
        if (this.gsr != null) {
            String[] ff = this.gsr.ff(j);
            if (j <= 60) {
                if (!this.gsu) {
                    this.gsu = true;
                    if (this.gsj != null) {
                        this.gsj.setVisibility(8);
                    }
                    if (this.gsi != null) {
                        this.gsi.setVisibility(8);
                    }
                    if (this.gsh != null) {
                        this.gsh.setTextSize(0, getResources().getDimensionPixelSize(a.d.sdk_ds108));
                    }
                }
                if (this.gsh != null) {
                    this.gsh.setText(ff[1]);
                }
            } else {
                if (this.gsj != null && this.gsj.getVisibility() != 0) {
                    this.gsj.setVisibility(0);
                }
                if (this.gsh != null) {
                    this.gsh.setText(ff[0]);
                }
                if (this.gsi != null) {
                    this.gsi.setText(ff[1]);
                }
            }
            if (this.gsg != null) {
                this.gsg.setProgress(this.gsr.fe(j));
            }
        }
    }

    private void bRO() {
        this.gsc.setVisibility(8);
        this.gsb.setVisibility(0);
        this.gse.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_red_packet_condition, (ViewGroup) null);
        this.gse.addView(inflate, this.gsq);
        TextView textView = (TextView) inflate.findViewById(a.f.rp_condition_desc);
        TextView textView2 = (TextView) inflate.findViewById(a.f.rp_condition_btn);
        if (this.gsr.bXu()) {
            this.gst = false;
            textView.setText(a.h.snatch_red_packet_cond_follow_desc);
            textView2.setText(a.h.snatch_red_packet_follow_btn);
        } else if (this.gsr.bXv()) {
            this.gst = true;
            textView.setText(a.h.snatch_red_packet_cond_gift_desc);
            textView2.setText(a.h.snatch_red_packet_gift_btn);
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaSnatchRedPacketActivity.this.gst) {
                    AlaSnatchRedPacketActivity.this.bRI();
                    AlaSnatchRedPacketActivity.this.finish();
                    return;
                }
                AlaSnatchRedPacketActivity.this.bwf();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwf() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913131, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRP() {
        String str = this.gsr.gUb.gUi;
        com.baidu.live.data.f fVar = new com.baidu.live.data.f(this.gsr.gUa.portrait, str, true, getUniqueId());
        fVar.setFrom("source_snatch_red_packet");
        com.baidu.live.view.a.Zx().a(str, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRI() {
        ak akVar = new ak();
        akVar.aMe = -1;
        akVar.aMf = -1;
        akVar.aMh = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, akVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mj(boolean z) {
        this.gsp = ValueAnimator.ofFloat(1.0f, 0.8f);
        this.gsp.setDuration(250L);
        this.gsp.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                AlaSnatchRedPacketActivity.this.gsl.setScaleX(floatValue);
                AlaSnatchRedPacketActivity.this.gsl.setScaleY(floatValue);
            }
        });
        this.gsp.setRepeatCount(-1);
        this.gsp.setRepeatMode(2);
        this.gsp.start();
        AlaStatsItem alaStatsItem = new AlaStatsItem();
        if (this.gsr != null && this.gsr.gUa != null) {
            alaStatsItem.addValue("redpacketId", this.gsr.gUa.id);
        }
        alaStatsItem.addValue("source", z ? "countdown_finish" : "redpacket_status_3");
        AlaStatManager.getInstance().debug("redpacket_loot_enable", "", "", alaStatsItem);
    }

    private void bRQ() {
        this.gsf.setVisibility(0);
        this.gsl.setVisibility(0);
        this.gso = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.gso.setDuration(500L);
        this.gso.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                AlaSnatchRedPacketActivity.this.gsf.setAlpha(1.0f - animatedFraction);
                AlaSnatchRedPacketActivity.this.gsl.setAlpha(animatedFraction);
                float f = (float) (animatedFraction * 0.5d);
                AlaSnatchRedPacketActivity.this.gsf.setScaleX(1.0f - f);
                AlaSnatchRedPacketActivity.this.gsf.setScaleY(1.0f - f);
                AlaSnatchRedPacketActivity.this.gsl.setScaleX((float) (f + 0.5d));
                AlaSnatchRedPacketActivity.this.gsl.setScaleY((float) (f + 0.5d));
            }
        });
        this.gso.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.7
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSnatchRedPacketActivity.this.mj(true);
                AlaSnatchRedPacketActivity.this.gsf.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.gso.start();
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

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        mi(configuration.orientation == 2);
    }

    private void mi(boolean z) {
        if (z) {
            i.ae(this.cFY);
            this.cFY.setScaleX(0.7f);
            this.cFY.setScaleY(0.7f);
            if (this.gsk != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gsk.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds126);
                this.gsk.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        i.af(this.cFY);
        this.cFY.setScaleX(1.0f);
        this.cFY.setScaleY(1.0f);
        if (this.gsk != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gsk.getLayoutParams();
            layoutParams2.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds146);
            this.gsk.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.gsm != null) {
            this.gsm.onDestroy();
        }
        if (this.gsp != null) {
            this.gsp.removeAllListeners();
            this.gsp.cancel();
            this.gsp = null;
        }
        if (this.gso != null) {
            this.gso.removeAllListeners();
            this.gso.cancel();
            this.gso = null;
        }
        if (this.gsp != null) {
            this.gsp.removeAllUpdateListeners();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gsA);
        MessageManager.getInstance().unRegisterListener(this.gsy);
        MessageManager.getInstance().unRegisterListener(this.aBj);
        super.onDestroy();
    }
}
