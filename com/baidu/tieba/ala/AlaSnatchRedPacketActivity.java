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
    private HeadImageView aZK;
    private FrameLayout bTj;
    private String ber;
    private TextView dTQ;
    private View ful;
    private int fwB;
    private View fwf;
    private View fwg;
    private FrameLayout fwh;
    private FrameLayout fwi;
    private FrameLayout fwj;
    private RoundProgressBar fwk;
    private TextView fwl;
    private TextView fwm;
    private ImageView fwn;
    private FrameLayout fwo;
    private ImageView fwp;
    private g fwq;
    private String fwr;
    private ValueAnimator fws;
    private ValueAnimator fwt;
    private FrameLayout.LayoutParams fwu;
    private com.baidu.tieba.ala.data.c fwv;
    private j fww;
    private boolean fwx;
    private boolean fwy;
    private long fwz;
    private ImageView mCloseBtn;
    private LinearLayout mContentView;
    private String mLiveId;
    private String mRedPacketId;
    private int fwA = 2;
    private CustomMessageListener fvX = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaSnatchRedPacketActivity.this.finish();
        }
    };
    private CustomMessageListener fwC = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(AlaSnatchRedPacketActivity.this.fwr)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (updateAttentionMessage.getData().isAttention) {
                            AlaSnatchRedPacketActivity.this.showToast(AlaSnatchRedPacketActivity.this.getString(a.i.sdk_attention_success_toast));
                            AlaSnatchRedPacketActivity.this.fwh.setVisibility(8);
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
    private g.a fwD = new g.a() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.8
        @Override // com.baidu.tieba.ala.f.g.a
        public void b(com.baidu.tieba.ala.data.c cVar) {
            AlaSnatchRedPacketActivity.this.a(cVar);
        }

        @Override // com.baidu.tieba.ala.f.g.a
        public void aA(int i, String str) {
            AlaSnatchRedPacketActivity.this.showToast(a.i.sdk_net_fail_tip);
        }

        @Override // com.baidu.tieba.ala.f.g.a
        public void b(j jVar) {
            AlaSnatchRedPacketActivity.this.fwp.setEnabled(true);
            AlaSnatchRedPacketActivity.this.a(jVar);
        }

        @Override // com.baidu.tieba.ala.f.g.a
        public void aB(int i, String str) {
            AlaSnatchRedPacketActivity.this.fwp.setEnabled(true);
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                AlaSnatchRedPacketActivity.this.showToast(a.i.sdk_net_fail_tip);
            } else if (!StringUtils.isNullObject(str)) {
                AlaSnatchRedPacketActivity.this.showToast(str);
            } else {
                AlaSnatchRedPacketActivity.this.showToast(a.i.snatch_red_packet_failed_3);
            }
        }
    };
    private CustomMessageListener fwE = new CustomMessageListener(2913133) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                AlaSnatchRedPacketActivity.this.fwz = ((Long) customResponsedMessage.getData()).longValue();
                AlaSnatchRedPacketActivity.this.dM(AlaSnatchRedPacketActivity.this.fwz);
                if (AlaSnatchRedPacketActivity.this.fwz < 1) {
                    AlaSnatchRedPacketActivity.this.bDP();
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
            this.fwq = new g(getPageContext(), this.fwD);
            this.fwq.ak(this.mRedPacketId, this.mLiveId, this.ber);
            MessageManager.getInstance().registerListener(this.fvX);
            MessageManager.getInstance().registerListener(this.fwC);
            MessageManager.getInstance().registerListener(this.fwE);
            this.fwu = new FrameLayout.LayoutParams(-1, -1);
            ks(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.ber = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.ful = findViewById(a.g.rp_root_bg);
        this.ful.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaSnatchRedPacketActivity.this.finish();
                }
            }
        });
        this.bTj = (FrameLayout) findViewById(a.g.rp_root_container);
        this.mContentView = (LinearLayout) findViewById(a.g.rp_content_layout);
        this.mContentView.setVisibility(8);
        this.aZK = (HeadImageView) findViewById(a.g.rp_user_icon);
        this.aZK.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds6));
        this.aZK.setBorderColor(getPageContext().getResources().getColor(a.d.ala_red_packet_main_color));
        this.aZK.setIsRound(true);
        this.aZK.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.aZK.setAutoChangeStyle(true);
        this.aZK.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dTQ = (TextView) findViewById(a.g.rp_user_name);
        this.fwh = (FrameLayout) findViewById(a.g.rp_follow_sender);
        this.fwh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bDR();
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
        this.fwg = findViewById(a.g.rp_normal_bg);
        this.fwf = findViewById(a.g.rp_condition_guide_bg);
        this.fwi = (FrameLayout) findViewById(a.g.rp_sub_content_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j jVar) {
        this.fww = jVar;
        if (jVar.bIO()) {
            this.fwB = 101;
        } else {
            this.fwB = 100;
        }
        bDN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.data.c cVar) {
        if (cVar.fUf != null) {
            this.mContentView.setVisibility(0);
            this.fwv = cVar;
            this.fwr = this.fwv.fUg.fUn;
            if (!StringUtils.isNullObject(cVar.fUf.portrait)) {
                k.a(this.aZK, cVar.fUf.portrait, true, false);
            }
            this.dTQ.setText(cVar.fUf.userName);
            if (!cVar.bIR()) {
                this.fwh.setVisibility(8);
            } else {
                boolean equals = TbadkCoreApplication.getCurrentAccount() != null ? TbadkCoreApplication.getCurrentAccount().equals(this.fwr) : true;
                if (this.fwv.fUg.fUo || equals) {
                    this.fwh.setVisibility(8);
                } else {
                    this.fwh.setVisibility(0);
                }
            }
            if (this.fwv.bIO()) {
                this.fwA = 3;
            } else if (this.fwv.isValid()) {
                if (cVar.bIQ()) {
                    this.fwA = 1;
                    this.fwh.setVisibility(8);
                } else {
                    this.fwA = 2;
                }
            } else if (this.fwv.bIL()) {
                this.fwA = 5;
            } else if (this.fwv.bIM()) {
                this.fwA = 4;
            }
            bDM();
        }
    }

    private void bDM() {
        switch (this.fwA) {
            case 1:
                bDQ();
                return;
            case 2:
                bDO();
                return;
            case 3:
                this.fwB = 102;
                bDN();
                return;
            case 4:
                this.fwB = 103;
                bDN();
                return;
            case 5:
                this.fwB = 104;
                bDN();
                return;
            default:
                return;
        }
    }

    private void bDN() {
        String str;
        this.fwg.setVisibility(8);
        this.fwf.setVisibility(0);
        this.fwi.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_outcome, (ViewGroup) null);
        this.fwi.addView(inflate, this.fwu);
        TextView textView = (TextView) inflate.findViewById(a.g.rp_show_result);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new q(AlaSnatchRedPacketActivity.this.getPageContext().getPageActivity(), AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.ber)));
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(a.g.rp_gift_btn);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bDL();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        switch (this.fwB) {
            case 100:
            case 103:
            case 104:
                TextView textView3 = (TextView) inflate.findViewById(a.g.rp_snatch_fail);
                textView3.setVisibility(0);
                textView2.setVisibility(8);
                if (this.fwB == 103) {
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
                textView4.setText(String.format(getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(this.fww.bIP())));
                textView4.setVisibility(0);
                return;
            case 102:
                textView2.setVisibility(0);
                TextView textView5 = (TextView) inflate.findViewById(a.g.rp_snatched);
                textView5.setVisibility(0);
                textView5.setText(getPageContext().getString(a.i.snatch_red_packet_loot_prefix) + String.format(getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(this.fwv.bIP())));
                return;
            default:
                return;
        }
    }

    private void bDO() {
        this.fwg.setVisibility(0);
        this.fwf.setVisibility(8);
        this.fwi.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_snatch, (ViewGroup) null);
        this.fwi.addView(inflate, this.fwu);
        ((TextView) inflate.findViewById(a.g.rp_follow_tip)).setVisibility(0);
        ((TextView) inflate.findViewById(a.g.rp_total_amount)).setText(String.format(getResources().getString(a.i.send_ref_packet_desc), Long.valueOf(this.fwv.fUf.fUM)));
        this.fwo = (FrameLayout) inflate.findViewById(a.g.rp_snatch_layout);
        if (UtilHelper.getRealScreenOrientation(this) == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fwo.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds126);
            this.fwo.setLayoutParams(layoutParams);
        }
        this.fwp = (ImageView) inflate.findViewById(a.g.rp_snatch_btn);
        this.fwp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.fwp.setEnabled(false);
                AlaSnatchRedPacketActivity.this.fwq.al(AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.ber);
            }
        });
        this.fwj = (FrameLayout) inflate.findViewById(a.g.rp_count_down_layout);
        this.fwk = (RoundProgressBar) inflate.findViewById(a.g.rp_snatch_progress);
        this.fwl = (TextView) inflate.findViewById(a.g.rp_snatch_countdown_min);
        this.fwn = (ImageView) inflate.findViewById(a.g.rp_snatch_countdown_dot);
        this.fwn.setVisibility(8);
        this.fwm = (TextView) inflate.findViewById(a.g.rp_snatch_countdown_second);
        if (!this.fwv.bIN()) {
            this.fwp.setVisibility(0);
            this.fwj.setVisibility(8);
            bDS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDP() {
        bDT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dM(long j) {
        if (this.fwv != null) {
            String[] dS = this.fwv.dS(j);
            if (j <= 60) {
                if (!this.fwy) {
                    this.fwy = true;
                    if (this.fwn != null) {
                        this.fwn.setVisibility(8);
                    }
                    if (this.fwm != null) {
                        this.fwm.setVisibility(8);
                    }
                    if (this.fwl != null) {
                        this.fwl.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_ds108));
                    }
                }
                if (this.fwl != null) {
                    this.fwl.setText(dS[1]);
                }
            } else {
                if (this.fwn != null && this.fwn.getVisibility() != 0) {
                    this.fwn.setVisibility(0);
                }
                if (this.fwl != null) {
                    this.fwl.setText(dS[0]);
                }
                if (this.fwm != null) {
                    this.fwm.setText(dS[1]);
                }
            }
            if (this.fwk != null) {
                this.fwk.setProgress(this.fwv.dR(j));
            }
        }
    }

    private void bDQ() {
        this.fwg.setVisibility(8);
        this.fwf.setVisibility(0);
        this.fwi.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_condition, (ViewGroup) null);
        this.fwi.addView(inflate, this.fwu);
        TextView textView = (TextView) inflate.findViewById(a.g.rp_condition_desc);
        TextView textView2 = (TextView) inflate.findViewById(a.g.rp_condition_btn);
        if (this.fwv.bIS()) {
            this.fwx = false;
            textView.setText(a.i.snatch_red_packet_cond_follow_desc);
            textView2.setText(a.i.snatch_red_packet_follow_btn);
        } else if (this.fwv.bIT()) {
            this.fwx = true;
            textView.setText(a.i.snatch_red_packet_cond_gift_desc);
            textView2.setText(a.i.snatch_red_packet_gift_btn);
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaSnatchRedPacketActivity.this.fwx) {
                    AlaSnatchRedPacketActivity.this.bDL();
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
    public void bDR() {
        String str = this.fwv.fUg.fUn;
        com.baidu.live.data.d dVar = new com.baidu.live.data.d(this.fwv.fUf.portrait, str, true, getUniqueId());
        dVar.setFrom("source_snatch_red_packet");
        com.baidu.live.view.a.Qx().a(str, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDL() {
        y yVar = new y();
        yVar.aEz = -1;
        yVar.aEA = -1;
        yVar.aEC = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, yVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDS() {
        this.fwt = ValueAnimator.ofFloat(1.0f, 0.8f);
        this.fwt.setDuration(250L);
        this.fwt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                AlaSnatchRedPacketActivity.this.fwp.setScaleX(floatValue);
                AlaSnatchRedPacketActivity.this.fwp.setScaleY(floatValue);
            }
        });
        this.fwt.setRepeatCount(-1);
        this.fwt.setRepeatMode(2);
        this.fwt.start();
    }

    private void bDT() {
        this.fwj.setVisibility(0);
        this.fwp.setVisibility(0);
        this.fws = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.fws.setDuration(500L);
        this.fws.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                AlaSnatchRedPacketActivity.this.fwj.setAlpha(1.0f - animatedFraction);
                AlaSnatchRedPacketActivity.this.fwp.setAlpha(animatedFraction);
                float f = (float) (animatedFraction * 0.5d);
                AlaSnatchRedPacketActivity.this.fwj.setScaleX(1.0f - f);
                AlaSnatchRedPacketActivity.this.fwj.setScaleY(1.0f - f);
                AlaSnatchRedPacketActivity.this.fwp.setScaleX((float) (f + 0.5d));
                AlaSnatchRedPacketActivity.this.fwp.setScaleY((float) (f + 0.5d));
            }
        });
        this.fws.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSnatchRedPacketActivity.this.bDS();
                AlaSnatchRedPacketActivity.this.fwj.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fws.start();
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
        ks(configuration.orientation == 2);
    }

    private void ks(boolean z) {
        if (z) {
            h.Y(this.bTj);
            this.bTj.setScaleX(0.7f);
            this.bTj.setScaleY(0.7f);
            if (this.fwo != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fwo.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds126);
                this.fwo.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        h.Z(this.bTj);
        this.bTj.setScaleX(1.0f);
        this.bTj.setScaleY(1.0f);
        if (this.fwo != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fwo.getLayoutParams();
            layoutParams2.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds146);
            this.fwo.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.fwq != null) {
            this.fwq.onDestroy();
        }
        if (this.fwt != null) {
            this.fwt.removeAllListeners();
            this.fwt.cancel();
            this.fwt = null;
        }
        if (this.fws != null) {
            this.fws.removeAllListeners();
            this.fws.cancel();
            this.fws = null;
        }
        MessageManager.getInstance().unRegisterListener(this.fwE);
        MessageManager.getInstance().unRegisterListener(this.fwC);
        MessageManager.getInstance().unRegisterListener(this.fvX);
        super.onDestroy();
    }
}
