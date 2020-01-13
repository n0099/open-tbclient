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
import com.baidu.live.c.o;
import com.baidu.live.data.q;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.live.utils.h;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.data.i;
import com.baidu.tieba.ala.e.f;
import com.baidu.tieba.ala.view.RoundProgressBar;
/* loaded from: classes2.dex */
public class AlaSnatchRedPacketActivity extends BaseFragmentActivity {
    private FrameLayout aXC;
    private HeadImageView aod;
    private String asd;
    private TextView bXF;
    private View ecB;
    private ImageView eeA;
    private f eeB;
    private String eeC;
    private ValueAnimator eeD;
    private ValueAnimator eeE;
    private FrameLayout.LayoutParams eeF;
    private com.baidu.tieba.ala.data.b eeG;
    private i eeH;
    private boolean eeI;
    private boolean eeJ;
    private long eeK;
    private int eeM;
    private View eeq;
    private View eer;
    private FrameLayout ees;
    private FrameLayout eet;
    private FrameLayout eeu;
    private RoundProgressBar eev;
    private TextView eew;
    private TextView eex;
    private ImageView eey;
    private FrameLayout eez;
    private ImageView mCloseBtn;
    private LinearLayout mContentView;
    private String mLiveId;
    private String mRedPacketId;
    private int eeL = 2;
    private CustomMessageListener eef = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaSnatchRedPacketActivity.this.finish();
        }
    };
    private CustomMessageListener eeN = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(AlaSnatchRedPacketActivity.this.eeC)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (updateAttentionMessage.getData().isAttention) {
                            AlaSnatchRedPacketActivity.this.showToast(AlaSnatchRedPacketActivity.this.getString(a.i.sdk_attention_success_toast));
                            AlaSnatchRedPacketActivity.this.ees.setVisibility(8);
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
    private f.a eeO = new f.a() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.8
        @Override // com.baidu.tieba.ala.e.f.a
        public void b(com.baidu.tieba.ala.data.b bVar) {
            AlaSnatchRedPacketActivity.this.a(bVar);
        }

        @Override // com.baidu.tieba.ala.e.f.a
        public void ad(int i, String str) {
            AlaSnatchRedPacketActivity.this.showToast(a.i.sdk_net_fail_tip);
        }

        @Override // com.baidu.tieba.ala.e.f.a
        public void b(i iVar) {
            AlaSnatchRedPacketActivity.this.a(iVar);
        }

        @Override // com.baidu.tieba.ala.e.f.a
        public void ae(int i, String str) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                AlaSnatchRedPacketActivity.this.showToast(a.i.sdk_net_fail_tip);
            } else if (!StringUtils.isNULL(str)) {
                AlaSnatchRedPacketActivity.this.showToast(str);
            } else {
                AlaSnatchRedPacketActivity.this.showToast(a.i.snatch_red_packet_failed_3);
            }
        }
    };
    private CustomMessageListener eeP = new CustomMessageListener(2913133) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                AlaSnatchRedPacketActivity.this.eeK = ((Long) customResponsedMessage.getData()).longValue();
                AlaSnatchRedPacketActivity.this.cy(AlaSnatchRedPacketActivity.this.eeK);
                if (AlaSnatchRedPacketActivity.this.eeK < 1) {
                    AlaSnatchRedPacketActivity.this.aZu();
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
        if (getIntent() == null) {
            finish();
            return;
        }
        parserIntent();
        if (StringUtils.isNULL(this.mRedPacketId)) {
            finish();
            return;
        }
        String str = Build.DISPLAY;
        if (str != null && str.contains("Flyme")) {
            getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.d.sdk_transparent)));
        }
        setContentView(a.h.ala_snatch_red_packet_view);
        initView();
        this.eeB = new f(getPageContext(), this.eeO);
        this.eeB.af(this.mRedPacketId, this.mLiveId, this.asd);
        MessageManager.getInstance().registerListener(this.eef);
        MessageManager.getInstance().registerListener(this.eeN);
        MessageManager.getInstance().registerListener(this.eeP);
        this.eeF = new FrameLayout.LayoutParams(-1, -1);
        hG(UtilHelper.getRealScreenOrientation(this) == 2);
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.asd = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.ecB = findViewById(a.g.rp_root_bg);
        this.ecB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaSnatchRedPacketActivity.this.finish();
                }
            }
        });
        this.aXC = (FrameLayout) findViewById(a.g.rp_root_container);
        this.mContentView = (LinearLayout) findViewById(a.g.rp_content_layout);
        this.mContentView.setVisibility(8);
        this.aod = (HeadImageView) findViewById(a.g.rp_user_icon);
        this.aod.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds6));
        this.aod.setBorderColor(getPageContext().getResources().getColor(a.d.ala_red_packet_main_color));
        this.aod.setIsRound(true);
        this.aod.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.aod.setAutoChangeStyle(true);
        this.aod.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.bXF = (TextView) findViewById(a.g.rp_user_name);
        this.ees = (FrameLayout) findViewById(a.g.rp_follow_sender);
        this.ees.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.aZw();
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
        this.eer = findViewById(a.g.rp_normal_bg);
        this.eeq = findViewById(a.g.rp_condition_guide_bg);
        this.eet = (FrameLayout) findViewById(a.g.rp_sub_content_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i iVar) {
        this.eeH = iVar;
        if (iVar.bbU()) {
            this.eeM = 101;
        } else {
            this.eeM = 100;
        }
        aZs();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.data.b bVar) {
        if (bVar.euX != null) {
            this.mContentView.setVisibility(0);
            this.eeG = bVar;
            this.eeC = this.eeG.euY.evg;
            if (!StringUtils.isNULL(bVar.euX.portrait)) {
                k.a(this.aod, bVar.euX.portrait, true, false);
            }
            this.bXF.setText(bVar.euX.userName);
            if (bVar.bbX()) {
                this.ees.setVisibility(8);
            } else {
                boolean equals = TbadkCoreApplication.getCurrentAccount() != null ? TbadkCoreApplication.getCurrentAccount().equals(this.eeC) : true;
                if (this.eeG.euY.evh || equals) {
                    this.ees.setVisibility(8);
                } else {
                    this.ees.setVisibility(0);
                }
            }
            if (this.eeG.bbU()) {
                this.eeL = 3;
            } else if (this.eeG.isValid()) {
                if (bVar.bbW()) {
                    this.eeL = 1;
                    this.ees.setVisibility(8);
                } else {
                    this.eeL = 2;
                }
            } else if (this.eeG.bbR()) {
                this.eeL = 5;
            } else if (this.eeG.bbS()) {
                this.eeL = 4;
            }
            aZr();
        }
    }

    private void aZr() {
        switch (this.eeL) {
            case 1:
                aZv();
                return;
            case 2:
                aZt();
                return;
            case 3:
                this.eeM = 102;
                aZs();
                return;
            case 4:
                this.eeM = 103;
                aZs();
                return;
            case 5:
                this.eeM = 104;
                aZs();
                return;
            default:
                return;
        }
    }

    private void aZs() {
        String str;
        this.eer.setVisibility(8);
        this.eeq.setVisibility(0);
        this.eet.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_outcome, (ViewGroup) null);
        this.eet.addView(inflate, this.eeF);
        TextView textView = (TextView) inflate.findViewById(a.g.rp_show_result);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new o(AlaSnatchRedPacketActivity.this.getPageContext().getPageActivity(), AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.asd)));
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(a.g.rp_gift_btn);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.aZq();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        switch (this.eeM) {
            case 100:
            case 103:
            case 104:
                TextView textView3 = (TextView) inflate.findViewById(a.g.rp_snatch_fail);
                textView3.setVisibility(0);
                textView2.setVisibility(8);
                if (this.eeM == 103) {
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
                textView4.setText(String.format(getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(this.eeH.bbV())));
                textView4.setVisibility(0);
                return;
            case 102:
                textView2.setVisibility(0);
                TextView textView5 = (TextView) inflate.findViewById(a.g.rp_snatched);
                textView5.setVisibility(0);
                textView5.setText(getPageContext().getString(a.i.snatch_red_packet_loot_prefix) + String.format(getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(this.eeG.bbV())));
                return;
            default:
                return;
        }
    }

    private void aZt() {
        this.eer.setVisibility(0);
        this.eeq.setVisibility(8);
        this.eet.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_snatch, (ViewGroup) null);
        this.eet.addView(inflate, this.eeF);
        ((TextView) inflate.findViewById(a.g.rp_follow_tip)).setVisibility(0);
        ((TextView) inflate.findViewById(a.g.rp_total_amount)).setText(String.format(getResources().getString(a.i.send_ref_packet_desc), Long.valueOf(this.eeG.euX.evG)));
        this.eez = (FrameLayout) inflate.findViewById(a.g.rp_snatch_layout);
        if (UtilHelper.getRealScreenOrientation(this) == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eez.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds126);
            this.eez.setLayoutParams(layoutParams);
        }
        this.eeA = (ImageView) inflate.findViewById(a.g.rp_snatch_btn);
        this.eeA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.eeB.ag(AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.asd);
            }
        });
        this.eeu = (FrameLayout) inflate.findViewById(a.g.rp_count_down_layout);
        this.eev = (RoundProgressBar) inflate.findViewById(a.g.rp_snatch_progress);
        this.eew = (TextView) inflate.findViewById(a.g.rp_snatch_countdown_min);
        this.eey = (ImageView) inflate.findViewById(a.g.rp_snatch_countdown_dot);
        this.eey.setVisibility(8);
        this.eex = (TextView) inflate.findViewById(a.g.rp_snatch_countdown_second);
        if (!this.eeG.bbT()) {
            this.eeA.setVisibility(0);
            this.eeu.setVisibility(8);
            aZx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZu() {
        aZy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cy(long j) {
        String[] cD = this.eeG.cD(j);
        if (j <= 60) {
            if (!this.eeJ) {
                this.eeJ = true;
                this.eey.setVisibility(8);
                this.eex.setVisibility(8);
                this.eew.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_ds108));
            }
            this.eew.setText(cD[1]);
        } else {
            if (this.eey.getVisibility() != 0) {
                this.eey.setVisibility(0);
            }
            this.eew.setText(cD[0]);
            this.eex.setText(cD[1]);
        }
        this.eev.setProgress(this.eeG.cC(j));
    }

    private void aZv() {
        this.eer.setVisibility(8);
        this.eeq.setVisibility(0);
        this.eet.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_condition, (ViewGroup) null);
        this.eet.addView(inflate, this.eeF);
        TextView textView = (TextView) inflate.findViewById(a.g.rp_condition_desc);
        TextView textView2 = (TextView) inflate.findViewById(a.g.rp_condition_btn);
        if (this.eeG.bbY()) {
            this.eeI = false;
            textView.setText(a.i.snatch_red_packet_cond_follow_desc);
            textView2.setText(a.i.snatch_red_packet_follow_btn);
        } else if (this.eeG.bbZ()) {
            this.eeI = true;
            textView.setText(a.i.snatch_red_packet_cond_gift_desc);
            textView2.setText(a.i.snatch_red_packet_gift_btn);
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaSnatchRedPacketActivity.this.eeI) {
                    AlaSnatchRedPacketActivity.this.aZq();
                    AlaSnatchRedPacketActivity.this.finish();
                    return;
                }
                AlaSnatchRedPacketActivity.this.aEh();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEh() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913131, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZw() {
        String str = this.eeG.euY.evg;
        com.baidu.live.view.a.yR().a(str, new com.baidu.live.data.b(this.eeG.euX.portrait, str, true, getUniqueId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZq() {
        q qVar = new q();
        qVar.WH = -1;
        qVar.WI = -1;
        qVar.WK = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, qVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZx() {
        this.eeE = ValueAnimator.ofFloat(1.0f, 0.8f);
        this.eeE.setDuration(250L);
        this.eeE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                AlaSnatchRedPacketActivity.this.eeA.setScaleX(floatValue);
                AlaSnatchRedPacketActivity.this.eeA.setScaleY(floatValue);
            }
        });
        this.eeE.setRepeatCount(-1);
        this.eeE.setRepeatMode(2);
        this.eeE.start();
    }

    private void aZy() {
        this.eeu.setVisibility(0);
        this.eeA.setVisibility(0);
        this.eeD = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.eeD.setDuration(500L);
        this.eeD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                AlaSnatchRedPacketActivity.this.eeu.setAlpha(1.0f - animatedFraction);
                AlaSnatchRedPacketActivity.this.eeA.setAlpha(animatedFraction);
                float f = (float) (animatedFraction * 0.5d);
                AlaSnatchRedPacketActivity.this.eeu.setScaleX(1.0f - f);
                AlaSnatchRedPacketActivity.this.eeu.setScaleY(1.0f - f);
                AlaSnatchRedPacketActivity.this.eeA.setScaleX((float) (f + 0.5d));
                AlaSnatchRedPacketActivity.this.eeA.setScaleY((float) (f + 0.5d));
            }
        });
        this.eeD.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSnatchRedPacketActivity.this.aZx();
                AlaSnatchRedPacketActivity.this.eeu.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.eeD.start();
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
        hG(configuration.orientation == 2);
    }

    private void hG(boolean z) {
        if (z) {
            h.S(this.aXC);
            this.aXC.setScaleX(0.7f);
            this.aXC.setScaleY(0.7f);
            if (this.eez != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eez.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds126);
                this.eez.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        h.T(this.aXC);
        this.aXC.setScaleX(1.0f);
        this.aXC.setScaleY(1.0f);
        if (this.eez != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.eez.getLayoutParams();
            layoutParams2.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds146);
            this.eez.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.eeB != null) {
            this.eeB.onDestroy();
        }
        if (this.eeE != null) {
            this.eeE.removeAllListeners();
            this.eeE.cancel();
            this.eeE = null;
        }
        if (this.eeD != null) {
            this.eeD.removeAllListeners();
            this.eeD.cancel();
            this.eeD = null;
        }
        MessageManager.getInstance().unRegisterListener(this.eeP);
        MessageManager.getInstance().unRegisterListener(this.eeN);
        MessageManager.getInstance().unRegisterListener(this.eef);
        super.onDestroy();
    }
}
