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
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.c.q;
import com.baidu.live.data.y;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.live.utils.h;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.data.j;
import com.baidu.tieba.ala.f.g;
import com.baidu.tieba.ala.view.RoundProgressBar;
/* loaded from: classes7.dex */
public class AlaSnatchRedPacketActivity extends BaseFragmentActivity {
    private HeadImageView aZM;
    private FrameLayout bTn;
    private String beu;
    private TextView dTU;
    private View fup;
    private j fwA;
    private boolean fwB;
    private boolean fwC;
    private long fwD;
    private int fwF;
    private View fwj;
    private View fwk;
    private FrameLayout fwl;
    private FrameLayout fwm;
    private FrameLayout fwn;
    private RoundProgressBar fwo;
    private TextView fwp;
    private TextView fwq;
    private ImageView fwr;
    private FrameLayout fws;
    private ImageView fwt;
    private g fwu;
    private String fwv;
    private ValueAnimator fww;
    private ValueAnimator fwx;
    private FrameLayout.LayoutParams fwy;
    private com.baidu.tieba.ala.data.c fwz;
    private ImageView mCloseBtn;
    private LinearLayout mContentView;
    private String mLiveId;
    private String mRedPacketId;
    private int fwE = 2;
    private CustomMessageListener fwb = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaSnatchRedPacketActivity.this.finish();
        }
    };
    private CustomMessageListener fwG = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(AlaSnatchRedPacketActivity.this.fwv)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (updateAttentionMessage.getData().isAttention) {
                            AlaSnatchRedPacketActivity.this.showToast(AlaSnatchRedPacketActivity.this.getString(a.i.sdk_attention_success_toast));
                            AlaSnatchRedPacketActivity.this.fwl.setVisibility(8);
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
    private g.a fwH = new g.a() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.8
        @Override // com.baidu.tieba.ala.f.g.a
        public void b(com.baidu.tieba.ala.data.c cVar) {
            AlaSnatchRedPacketActivity.this.a(cVar);
        }

        @Override // com.baidu.tieba.ala.f.g.a
        public void az(int i, String str) {
            AlaSnatchRedPacketActivity.this.showToast(a.i.sdk_net_fail_tip);
        }

        @Override // com.baidu.tieba.ala.f.g.a
        public void b(j jVar) {
            AlaSnatchRedPacketActivity.this.fwt.setEnabled(true);
            AlaSnatchRedPacketActivity.this.a(jVar);
        }

        @Override // com.baidu.tieba.ala.f.g.a
        public void aA(int i, String str) {
            AlaSnatchRedPacketActivity.this.fwt.setEnabled(true);
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                AlaSnatchRedPacketActivity.this.showToast(a.i.sdk_net_fail_tip);
            } else if (!StringUtils.isNullObject(str)) {
                AlaSnatchRedPacketActivity.this.showToast(str);
            } else {
                AlaSnatchRedPacketActivity.this.showToast(a.i.snatch_red_packet_failed_3);
            }
        }
    };
    private CustomMessageListener fwI = new CustomMessageListener(2913133) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                AlaSnatchRedPacketActivity.this.fwD = ((Long) customResponsedMessage.getData()).longValue();
                AlaSnatchRedPacketActivity.this.dM(AlaSnatchRedPacketActivity.this.fwD);
                if (AlaSnatchRedPacketActivity.this.fwD < 1) {
                    AlaSnatchRedPacketActivity.this.bDQ();
                }
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
            this.fwu = new g(getPageContext(), this.fwH);
            this.fwu.ak(this.mRedPacketId, this.mLiveId, this.beu);
            MessageManager.getInstance().registerListener(this.fwb);
            MessageManager.getInstance().registerListener(this.fwG);
            MessageManager.getInstance().registerListener(this.fwI);
            this.fwy = new FrameLayout.LayoutParams(-1, -1);
            ku(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.beu = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.fup = findViewById(a.g.rp_root_bg);
        this.fup.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaSnatchRedPacketActivity.this.finish();
                }
            }
        });
        this.bTn = (FrameLayout) findViewById(a.g.rp_root_container);
        this.mContentView = (LinearLayout) findViewById(a.g.rp_content_layout);
        this.mContentView.setVisibility(8);
        this.aZM = (HeadImageView) findViewById(a.g.rp_user_icon);
        this.aZM.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds6));
        this.aZM.setBorderColor(getPageContext().getResources().getColor(a.d.ala_red_packet_main_color));
        this.aZM.setIsRound(true);
        this.aZM.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.aZM.setAutoChangeStyle(true);
        this.aZM.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dTU = (TextView) findViewById(a.g.rp_user_name);
        this.fwl = (FrameLayout) findViewById(a.g.rp_follow_sender);
        this.fwl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bDS();
            }
        });
        this.mCloseBtn = (ImageView) findViewById(a.g.rp_close_btn);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.mCloseBtn.setVisibility(0);
            this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaSnatchRedPacketActivity.this.finish();
                }
            });
        } else {
            this.mCloseBtn.setVisibility(8);
        }
        this.fwk = findViewById(a.g.rp_normal_bg);
        this.fwj = findViewById(a.g.rp_condition_guide_bg);
        this.fwm = (FrameLayout) findViewById(a.g.rp_sub_content_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j jVar) {
        this.fwA = jVar;
        if (jVar.bIP()) {
            this.fwF = 101;
        } else {
            this.fwF = 100;
        }
        bDO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.data.c cVar) {
        if (cVar.fUj != null) {
            this.mContentView.setVisibility(0);
            this.fwz = cVar;
            this.fwv = this.fwz.fUk.fUr;
            if (!StringUtils.isNullObject(cVar.fUj.portrait)) {
                k.a(this.aZM, cVar.fUj.portrait, true, false);
            }
            this.dTU.setText(cVar.fUj.userName);
            if (!cVar.bIS()) {
                this.fwl.setVisibility(8);
            } else {
                boolean equals = TbadkCoreApplication.getCurrentAccount() != null ? TbadkCoreApplication.getCurrentAccount().equals(this.fwv) : true;
                if (this.fwz.fUk.fUs || equals) {
                    this.fwl.setVisibility(8);
                } else {
                    this.fwl.setVisibility(0);
                }
            }
            if (this.fwz.bIP()) {
                this.fwE = 3;
            } else if (this.fwz.isValid()) {
                if (cVar.bIR()) {
                    this.fwE = 1;
                    this.fwl.setVisibility(8);
                } else {
                    this.fwE = 2;
                }
            } else if (this.fwz.bIM()) {
                this.fwE = 5;
            } else if (this.fwz.bIN()) {
                this.fwE = 4;
            }
            bDN();
        }
    }

    private void bDN() {
        switch (this.fwE) {
            case 1:
                bDR();
                return;
            case 2:
                bDP();
                return;
            case 3:
                this.fwF = 102;
                bDO();
                return;
            case 4:
                this.fwF = 103;
                bDO();
                return;
            case 5:
                this.fwF = 104;
                bDO();
                return;
            default:
                return;
        }
    }

    private void bDO() {
        String str;
        this.fwk.setVisibility(8);
        this.fwj.setVisibility(0);
        this.fwm.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_outcome, (ViewGroup) null);
        this.fwm.addView(inflate, this.fwy);
        TextView textView = (TextView) inflate.findViewById(a.g.rp_show_result);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new q(AlaSnatchRedPacketActivity.this.getPageContext().getPageActivity(), AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.beu)));
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(a.g.rp_gift_btn);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bDM();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        switch (this.fwF) {
            case 100:
            case 103:
            case 104:
                TextView textView3 = (TextView) inflate.findViewById(a.g.rp_snatch_fail);
                textView3.setVisibility(0);
                textView2.setVisibility(8);
                if (this.fwF == 103) {
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
                textView4.setText(String.format(getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(this.fwA.bIQ())));
                textView4.setVisibility(0);
                return;
            case 102:
                textView2.setVisibility(0);
                TextView textView5 = (TextView) inflate.findViewById(a.g.rp_snatched);
                textView5.setVisibility(0);
                textView5.setText(getPageContext().getString(a.i.snatch_red_packet_loot_prefix) + String.format(getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(this.fwz.bIQ())));
                return;
            default:
                return;
        }
    }

    private void bDP() {
        this.fwk.setVisibility(0);
        this.fwj.setVisibility(8);
        this.fwm.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_snatch, (ViewGroup) null);
        this.fwm.addView(inflate, this.fwy);
        ((TextView) inflate.findViewById(a.g.rp_follow_tip)).setVisibility(0);
        ((TextView) inflate.findViewById(a.g.rp_total_amount)).setText(String.format(getResources().getString(a.i.send_ref_packet_desc), Long.valueOf(this.fwz.fUj.fUQ)));
        this.fws = (FrameLayout) inflate.findViewById(a.g.rp_snatch_layout);
        if (UtilHelper.getRealScreenOrientation(this) == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fws.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds126);
            this.fws.setLayoutParams(layoutParams);
        }
        this.fwt = (ImageView) inflate.findViewById(a.g.rp_snatch_btn);
        this.fwt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.fwt.setEnabled(false);
                AlaSnatchRedPacketActivity.this.fwu.al(AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.beu);
            }
        });
        this.fwn = (FrameLayout) inflate.findViewById(a.g.rp_count_down_layout);
        this.fwo = (RoundProgressBar) inflate.findViewById(a.g.rp_snatch_progress);
        this.fwp = (TextView) inflate.findViewById(a.g.rp_snatch_countdown_min);
        this.fwr = (ImageView) inflate.findViewById(a.g.rp_snatch_countdown_dot);
        this.fwr.setVisibility(8);
        this.fwq = (TextView) inflate.findViewById(a.g.rp_snatch_countdown_second);
        if (!this.fwz.bIO()) {
            this.fwt.setVisibility(0);
            this.fwn.setVisibility(8);
            bDT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDQ() {
        bDU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dM(long j) {
        if (this.fwz != null) {
            String[] dS = this.fwz.dS(j);
            if (j <= 60) {
                if (!this.fwC) {
                    this.fwC = true;
                    if (this.fwr != null) {
                        this.fwr.setVisibility(8);
                    }
                    if (this.fwq != null) {
                        this.fwq.setVisibility(8);
                    }
                    if (this.fwp != null) {
                        this.fwp.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_ds108));
                    }
                }
                if (this.fwp != null) {
                    this.fwp.setText(dS[1]);
                }
            } else {
                if (this.fwr != null && this.fwr.getVisibility() != 0) {
                    this.fwr.setVisibility(0);
                }
                if (this.fwp != null) {
                    this.fwp.setText(dS[0]);
                }
                if (this.fwq != null) {
                    this.fwq.setText(dS[1]);
                }
            }
            if (this.fwo != null) {
                this.fwo.setProgress(this.fwz.dR(j));
            }
        }
    }

    private void bDR() {
        this.fwk.setVisibility(8);
        this.fwj.setVisibility(0);
        this.fwm.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_condition, (ViewGroup) null);
        this.fwm.addView(inflate, this.fwy);
        TextView textView = (TextView) inflate.findViewById(a.g.rp_condition_desc);
        TextView textView2 = (TextView) inflate.findViewById(a.g.rp_condition_btn);
        if (this.fwz.bIT()) {
            this.fwB = false;
            textView.setText(a.i.snatch_red_packet_cond_follow_desc);
            textView2.setText(a.i.snatch_red_packet_follow_btn);
        } else if (this.fwz.bIU()) {
            this.fwB = true;
            textView.setText(a.i.snatch_red_packet_cond_gift_desc);
            textView2.setText(a.i.snatch_red_packet_gift_btn);
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaSnatchRedPacketActivity.this.fwB) {
                    AlaSnatchRedPacketActivity.this.bDM();
                    AlaSnatchRedPacketActivity.this.finish();
                    return;
                }
                AlaSnatchRedPacketActivity.this.bjg();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjg() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913131, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDS() {
        String str = this.fwz.fUk.fUr;
        com.baidu.live.data.d dVar = new com.baidu.live.data.d(this.fwz.fUj.portrait, str, true, getUniqueId());
        dVar.setFrom("source_snatch_red_packet");
        com.baidu.live.view.a.Qx().a(str, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDM() {
        y yVar = new y();
        yVar.aEB = -1;
        yVar.aEC = -1;
        yVar.aEE = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, yVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDT() {
        this.fwx = ValueAnimator.ofFloat(1.0f, 0.8f);
        this.fwx.setDuration(250L);
        this.fwx.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                AlaSnatchRedPacketActivity.this.fwt.setScaleX(floatValue);
                AlaSnatchRedPacketActivity.this.fwt.setScaleY(floatValue);
            }
        });
        this.fwx.setRepeatCount(-1);
        this.fwx.setRepeatMode(2);
        this.fwx.start();
    }

    private void bDU() {
        this.fwn.setVisibility(0);
        this.fwt.setVisibility(0);
        this.fww = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.fww.setDuration(500L);
        this.fww.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                AlaSnatchRedPacketActivity.this.fwn.setAlpha(1.0f - animatedFraction);
                AlaSnatchRedPacketActivity.this.fwt.setAlpha(animatedFraction);
                float f = (float) (animatedFraction * 0.5d);
                AlaSnatchRedPacketActivity.this.fwn.setScaleX(1.0f - f);
                AlaSnatchRedPacketActivity.this.fwn.setScaleY(1.0f - f);
                AlaSnatchRedPacketActivity.this.fwt.setScaleX((float) (f + 0.5d));
                AlaSnatchRedPacketActivity.this.fwt.setScaleY((float) (f + 0.5d));
            }
        });
        this.fww.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSnatchRedPacketActivity.this.bDT();
                AlaSnatchRedPacketActivity.this.fwn.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fww.start();
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
        ku(configuration.orientation == 2);
    }

    private void ku(boolean z) {
        if (z) {
            h.Y(this.bTn);
            this.bTn.setScaleX(0.7f);
            this.bTn.setScaleY(0.7f);
            if (this.fws != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fws.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds126);
                this.fws.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        h.Z(this.bTn);
        this.bTn.setScaleX(1.0f);
        this.bTn.setScaleY(1.0f);
        if (this.fws != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fws.getLayoutParams();
            layoutParams2.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds146);
            this.fws.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.fwu != null) {
            this.fwu.onDestroy();
        }
        if (this.fwx != null) {
            this.fwx.removeAllListeners();
            this.fwx.cancel();
            this.fwx = null;
        }
        if (this.fww != null) {
            this.fww.removeAllListeners();
            this.fww.cancel();
            this.fww = null;
        }
        MessageManager.getInstance().unRegisterListener(this.fwI);
        MessageManager.getInstance().unRegisterListener(this.fwG);
        MessageManager.getInstance().unRegisterListener(this.fwb);
        super.onDestroy();
    }
}
