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
import com.baidu.live.data.s;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.live.u.a;
import com.baidu.live.utils.h;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.data.i;
import com.baidu.tieba.ala.f.f;
import com.baidu.tieba.ala.view.RoundProgressBar;
/* loaded from: classes3.dex */
public class AlaSnatchRedPacketActivity extends BaseFragmentActivity {
    private HeadImageView aKJ;
    private String aQi;
    private FrameLayout bAv;
    private TextView cBd;
    private View eHd;
    private View eIO;
    private View eIP;
    private FrameLayout eIQ;
    private FrameLayout eIR;
    private FrameLayout eIS;
    private RoundProgressBar eIT;
    private TextView eIU;
    private TextView eIV;
    private ImageView eIW;
    private FrameLayout eIX;
    private ImageView eIY;
    private f eIZ;
    private String eJa;
    private ValueAnimator eJb;
    private ValueAnimator eJc;
    private FrameLayout.LayoutParams eJd;
    private com.baidu.tieba.ala.data.b eJe;
    private i eJf;
    private boolean eJg;
    private boolean eJh;
    private long eJi;
    private int eJk;
    private ImageView mCloseBtn;
    private LinearLayout mContentView;
    private String mLiveId;
    private String mRedPacketId;
    private int eJj = 2;
    private CustomMessageListener eIC = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaSnatchRedPacketActivity.this.finish();
        }
    };
    private CustomMessageListener eJl = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(AlaSnatchRedPacketActivity.this.eJa)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (updateAttentionMessage.getData().isAttention) {
                            AlaSnatchRedPacketActivity.this.showToast(AlaSnatchRedPacketActivity.this.getString(a.i.sdk_attention_success_toast));
                            AlaSnatchRedPacketActivity.this.eIQ.setVisibility(8);
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
    private f.a eJm = new f.a() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.8
        @Override // com.baidu.tieba.ala.f.f.a
        public void b(com.baidu.tieba.ala.data.b bVar) {
            AlaSnatchRedPacketActivity.this.a(bVar);
        }

        @Override // com.baidu.tieba.ala.f.f.a
        public void at(int i, String str) {
            AlaSnatchRedPacketActivity.this.showToast(a.i.sdk_net_fail_tip);
        }

        @Override // com.baidu.tieba.ala.f.f.a
        public void b(i iVar) {
            AlaSnatchRedPacketActivity.this.a(iVar);
        }

        @Override // com.baidu.tieba.ala.f.f.a
        public void au(int i, String str) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                AlaSnatchRedPacketActivity.this.showToast(a.i.sdk_net_fail_tip);
            } else if (!StringUtils.isNullObject(str)) {
                AlaSnatchRedPacketActivity.this.showToast(str);
            } else {
                AlaSnatchRedPacketActivity.this.showToast(a.i.snatch_red_packet_failed_3);
            }
        }
    };
    private CustomMessageListener eJn = new CustomMessageListener(2913133) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                AlaSnatchRedPacketActivity.this.eJi = ((Long) customResponsedMessage.getData()).longValue();
                AlaSnatchRedPacketActivity.this.dj(AlaSnatchRedPacketActivity.this.eJi);
                if (AlaSnatchRedPacketActivity.this.eJi < 1) {
                    AlaSnatchRedPacketActivity.this.bjR();
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
            this.eIZ = new f(getPageContext(), this.eJm);
            this.eIZ.ae(this.mRedPacketId, this.mLiveId, this.aQi);
            MessageManager.getInstance().registerListener(this.eIC);
            MessageManager.getInstance().registerListener(this.eJl);
            MessageManager.getInstance().registerListener(this.eJn);
            this.eJd = new FrameLayout.LayoutParams(-1, -1);
            iM(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.aQi = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.eHd = findViewById(a.g.rp_root_bg);
        this.eHd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaSnatchRedPacketActivity.this.finish();
                }
            }
        });
        this.bAv = (FrameLayout) findViewById(a.g.rp_root_container);
        this.mContentView = (LinearLayout) findViewById(a.g.rp_content_layout);
        this.mContentView.setVisibility(8);
        this.aKJ = (HeadImageView) findViewById(a.g.rp_user_icon);
        this.aKJ.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds6));
        this.aKJ.setBorderColor(getPageContext().getResources().getColor(a.d.ala_red_packet_main_color));
        this.aKJ.setIsRound(true);
        this.aKJ.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.aKJ.setAutoChangeStyle(true);
        this.aKJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cBd = (TextView) findViewById(a.g.rp_user_name);
        this.eIQ = (FrameLayout) findViewById(a.g.rp_follow_sender);
        this.eIQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bjT();
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
        this.eIP = findViewById(a.g.rp_normal_bg);
        this.eIO = findViewById(a.g.rp_condition_guide_bg);
        this.eIR = (FrameLayout) findViewById(a.g.rp_sub_content_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i iVar) {
        this.eJf = iVar;
        if (iVar.bnF()) {
            this.eJk = 101;
        } else {
            this.eJk = 100;
        }
        bjP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.data.b bVar) {
        if (bVar.fes != null) {
            this.mContentView.setVisibility(0);
            this.eJe = bVar;
            this.eJa = this.eJe.fet.feA;
            if (!StringUtils.isNullObject(bVar.fes.portrait)) {
                k.a(this.aKJ, bVar.fes.portrait, true, false);
            }
            this.cBd.setText(bVar.fes.userName);
            if (!bVar.bnI()) {
                this.eIQ.setVisibility(8);
            } else {
                boolean equals = TbadkCoreApplication.getCurrentAccount() != null ? TbadkCoreApplication.getCurrentAccount().equals(this.eJa) : true;
                if (this.eJe.fet.feB || equals) {
                    this.eIQ.setVisibility(8);
                } else {
                    this.eIQ.setVisibility(0);
                }
            }
            if (this.eJe.bnF()) {
                this.eJj = 3;
            } else if (this.eJe.isValid()) {
                if (bVar.bnH()) {
                    this.eJj = 1;
                    this.eIQ.setVisibility(8);
                } else {
                    this.eJj = 2;
                }
            } else if (this.eJe.bnC()) {
                this.eJj = 5;
            } else if (this.eJe.bnD()) {
                this.eJj = 4;
            }
            bjO();
        }
    }

    private void bjO() {
        switch (this.eJj) {
            case 1:
                bjS();
                return;
            case 2:
                bjQ();
                return;
            case 3:
                this.eJk = 102;
                bjP();
                return;
            case 4:
                this.eJk = 103;
                bjP();
                return;
            case 5:
                this.eJk = 104;
                bjP();
                return;
            default:
                return;
        }
    }

    private void bjP() {
        String str;
        this.eIP.setVisibility(8);
        this.eIO.setVisibility(0);
        this.eIR.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_outcome, (ViewGroup) null);
        this.eIR.addView(inflate, this.eJd);
        TextView textView = (TextView) inflate.findViewById(a.g.rp_show_result);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new o(AlaSnatchRedPacketActivity.this.getPageContext().getPageActivity(), AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.aQi)));
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(a.g.rp_gift_btn);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bjN();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        switch (this.eJk) {
            case 100:
            case 103:
            case 104:
                TextView textView3 = (TextView) inflate.findViewById(a.g.rp_snatch_fail);
                textView3.setVisibility(0);
                textView2.setVisibility(8);
                if (this.eJk == 103) {
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
                textView4.setText(String.format(getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(this.eJf.bnG())));
                textView4.setVisibility(0);
                return;
            case 102:
                textView2.setVisibility(0);
                TextView textView5 = (TextView) inflate.findViewById(a.g.rp_snatched);
                textView5.setVisibility(0);
                textView5.setText(getPageContext().getString(a.i.snatch_red_packet_loot_prefix) + String.format(getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(this.eJe.bnG())));
                return;
            default:
                return;
        }
    }

    private void bjQ() {
        this.eIP.setVisibility(0);
        this.eIO.setVisibility(8);
        this.eIR.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_snatch, (ViewGroup) null);
        this.eIR.addView(inflate, this.eJd);
        ((TextView) inflate.findViewById(a.g.rp_follow_tip)).setVisibility(0);
        ((TextView) inflate.findViewById(a.g.rp_total_amount)).setText(String.format(getResources().getString(a.i.send_ref_packet_desc), Long.valueOf(this.eJe.fes.feZ)));
        this.eIX = (FrameLayout) inflate.findViewById(a.g.rp_snatch_layout);
        if (UtilHelper.getRealScreenOrientation(this) == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eIX.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds126);
            this.eIX.setLayoutParams(layoutParams);
        }
        this.eIY = (ImageView) inflate.findViewById(a.g.rp_snatch_btn);
        this.eIY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.eIZ.af(AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.aQi);
            }
        });
        this.eIS = (FrameLayout) inflate.findViewById(a.g.rp_count_down_layout);
        this.eIT = (RoundProgressBar) inflate.findViewById(a.g.rp_snatch_progress);
        this.eIU = (TextView) inflate.findViewById(a.g.rp_snatch_countdown_min);
        this.eIW = (ImageView) inflate.findViewById(a.g.rp_snatch_countdown_dot);
        this.eIW.setVisibility(8);
        this.eIV = (TextView) inflate.findViewById(a.g.rp_snatch_countdown_second);
        if (!this.eJe.bnE()) {
            this.eIY.setVisibility(0);
            this.eIS.setVisibility(8);
            bjU();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjR() {
        bjV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dj(long j) {
        if (this.eJe != null) {
            String[] m32do = this.eJe.m32do(j);
            if (j <= 60) {
                if (!this.eJh) {
                    this.eJh = true;
                    this.eIW.setVisibility(8);
                    this.eIV.setVisibility(8);
                    this.eIU.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_ds108));
                }
                this.eIU.setText(m32do[1]);
            } else {
                if (this.eIW.getVisibility() != 0) {
                    this.eIW.setVisibility(0);
                }
                this.eIU.setText(m32do[0]);
                this.eIV.setText(m32do[1]);
            }
            this.eIT.setProgress(this.eJe.dn(j));
        }
    }

    private void bjS() {
        this.eIP.setVisibility(8);
        this.eIO.setVisibility(0);
        this.eIR.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_condition, (ViewGroup) null);
        this.eIR.addView(inflate, this.eJd);
        TextView textView = (TextView) inflate.findViewById(a.g.rp_condition_desc);
        TextView textView2 = (TextView) inflate.findViewById(a.g.rp_condition_btn);
        if (this.eJe.bnJ()) {
            this.eJg = false;
            textView.setText(a.i.snatch_red_packet_cond_follow_desc);
            textView2.setText(a.i.snatch_red_packet_follow_btn);
        } else if (this.eJe.bnK()) {
            this.eJg = true;
            textView.setText(a.i.snatch_red_packet_cond_gift_desc);
            textView2.setText(a.i.snatch_red_packet_gift_btn);
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaSnatchRedPacketActivity.this.eJg) {
                    AlaSnatchRedPacketActivity.this.bjN();
                    AlaSnatchRedPacketActivity.this.finish();
                    return;
                }
                AlaSnatchRedPacketActivity.this.aOJ();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOJ() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913131, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjT() {
        String str = this.eJe.fet.feA;
        com.baidu.live.data.b bVar = new com.baidu.live.data.b(this.eJe.fes.portrait, str, true, getUniqueId());
        bVar.setFrom("source_snatch_red_packet");
        com.baidu.live.view.a.Hs().a(str, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjN() {
        s sVar = new s();
        sVar.aqT = -1;
        sVar.aqU = -1;
        sVar.aqW = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, sVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjU() {
        this.eJc = ValueAnimator.ofFloat(1.0f, 0.8f);
        this.eJc.setDuration(250L);
        this.eJc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                AlaSnatchRedPacketActivity.this.eIY.setScaleX(floatValue);
                AlaSnatchRedPacketActivity.this.eIY.setScaleY(floatValue);
            }
        });
        this.eJc.setRepeatCount(-1);
        this.eJc.setRepeatMode(2);
        this.eJc.start();
    }

    private void bjV() {
        this.eIS.setVisibility(0);
        this.eIY.setVisibility(0);
        this.eJb = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.eJb.setDuration(500L);
        this.eJb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                AlaSnatchRedPacketActivity.this.eIS.setAlpha(1.0f - animatedFraction);
                AlaSnatchRedPacketActivity.this.eIY.setAlpha(animatedFraction);
                float f = (float) (animatedFraction * 0.5d);
                AlaSnatchRedPacketActivity.this.eIS.setScaleX(1.0f - f);
                AlaSnatchRedPacketActivity.this.eIS.setScaleY(1.0f - f);
                AlaSnatchRedPacketActivity.this.eIY.setScaleX((float) (f + 0.5d));
                AlaSnatchRedPacketActivity.this.eIY.setScaleY((float) (f + 0.5d));
            }
        });
        this.eJb.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSnatchRedPacketActivity.this.bjU();
                AlaSnatchRedPacketActivity.this.eIS.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.eJb.start();
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
        iM(configuration.orientation == 2);
    }

    private void iM(boolean z) {
        if (z) {
            h.U(this.bAv);
            this.bAv.setScaleX(0.7f);
            this.bAv.setScaleY(0.7f);
            if (this.eIX != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eIX.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds126);
                this.eIX.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        h.V(this.bAv);
        this.bAv.setScaleX(1.0f);
        this.bAv.setScaleY(1.0f);
        if (this.eIX != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.eIX.getLayoutParams();
            layoutParams2.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds146);
            this.eIX.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.eIZ != null) {
            this.eIZ.onDestroy();
        }
        if (this.eJc != null) {
            this.eJc.removeAllListeners();
            this.eJc.cancel();
            this.eJc = null;
        }
        if (this.eJb != null) {
            this.eJb.removeAllListeners();
            this.eJb.cancel();
            this.eJb = null;
        }
        MessageManager.getInstance().unRegisterListener(this.eJn);
        MessageManager.getInstance().unRegisterListener(this.eJl);
        MessageManager.getInstance().unRegisterListener(this.eIC);
        super.onDestroy();
    }
}
