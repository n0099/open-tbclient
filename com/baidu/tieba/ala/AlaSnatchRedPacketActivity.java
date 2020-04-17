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
    private HeadImageView aKD;
    private String aQc;
    private FrameLayout bAq;
    private TextView cAX;
    private View eGY;
    private View eIJ;
    private View eIK;
    private FrameLayout eIL;
    private FrameLayout eIM;
    private FrameLayout eIN;
    private RoundProgressBar eIO;
    private TextView eIP;
    private TextView eIQ;
    private ImageView eIR;
    private FrameLayout eIS;
    private ImageView eIT;
    private f eIU;
    private String eIV;
    private ValueAnimator eIW;
    private ValueAnimator eIX;
    private FrameLayout.LayoutParams eIY;
    private com.baidu.tieba.ala.data.b eIZ;
    private i eJa;
    private boolean eJb;
    private boolean eJc;
    private long eJd;
    private int eJf;
    private ImageView mCloseBtn;
    private LinearLayout mContentView;
    private String mLiveId;
    private String mRedPacketId;
    private int eJe = 2;
    private CustomMessageListener eIx = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaSnatchRedPacketActivity.this.finish();
        }
    };
    private CustomMessageListener eJg = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(AlaSnatchRedPacketActivity.this.eIV)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (updateAttentionMessage.getData().isAttention) {
                            AlaSnatchRedPacketActivity.this.showToast(AlaSnatchRedPacketActivity.this.getString(a.i.sdk_attention_success_toast));
                            AlaSnatchRedPacketActivity.this.eIL.setVisibility(8);
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
    private f.a eJh = new f.a() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.8
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
    private CustomMessageListener eJi = new CustomMessageListener(2913133) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                AlaSnatchRedPacketActivity.this.eJd = ((Long) customResponsedMessage.getData()).longValue();
                AlaSnatchRedPacketActivity.this.dj(AlaSnatchRedPacketActivity.this.eJd);
                if (AlaSnatchRedPacketActivity.this.eJd < 1) {
                    AlaSnatchRedPacketActivity.this.bjT();
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
            this.eIU = new f(getPageContext(), this.eJh);
            this.eIU.ae(this.mRedPacketId, this.mLiveId, this.aQc);
            MessageManager.getInstance().registerListener(this.eIx);
            MessageManager.getInstance().registerListener(this.eJg);
            MessageManager.getInstance().registerListener(this.eJi);
            this.eIY = new FrameLayout.LayoutParams(-1, -1);
            iM(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.aQc = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.eGY = findViewById(a.g.rp_root_bg);
        this.eGY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaSnatchRedPacketActivity.this.finish();
                }
            }
        });
        this.bAq = (FrameLayout) findViewById(a.g.rp_root_container);
        this.mContentView = (LinearLayout) findViewById(a.g.rp_content_layout);
        this.mContentView.setVisibility(8);
        this.aKD = (HeadImageView) findViewById(a.g.rp_user_icon);
        this.aKD.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds6));
        this.aKD.setBorderColor(getPageContext().getResources().getColor(a.d.ala_red_packet_main_color));
        this.aKD.setIsRound(true);
        this.aKD.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.aKD.setAutoChangeStyle(true);
        this.aKD.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cAX = (TextView) findViewById(a.g.rp_user_name);
        this.eIL = (FrameLayout) findViewById(a.g.rp_follow_sender);
        this.eIL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bjV();
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
        this.eIK = findViewById(a.g.rp_normal_bg);
        this.eIJ = findViewById(a.g.rp_condition_guide_bg);
        this.eIM = (FrameLayout) findViewById(a.g.rp_sub_content_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i iVar) {
        this.eJa = iVar;
        if (iVar.bnH()) {
            this.eJf = 101;
        } else {
            this.eJf = 100;
        }
        bjR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.data.b bVar) {
        if (bVar.fen != null) {
            this.mContentView.setVisibility(0);
            this.eIZ = bVar;
            this.eIV = this.eIZ.feo.fev;
            if (!StringUtils.isNullObject(bVar.fen.portrait)) {
                k.a(this.aKD, bVar.fen.portrait, true, false);
            }
            this.cAX.setText(bVar.fen.userName);
            if (!bVar.bnK()) {
                this.eIL.setVisibility(8);
            } else {
                boolean equals = TbadkCoreApplication.getCurrentAccount() != null ? TbadkCoreApplication.getCurrentAccount().equals(this.eIV) : true;
                if (this.eIZ.feo.few || equals) {
                    this.eIL.setVisibility(8);
                } else {
                    this.eIL.setVisibility(0);
                }
            }
            if (this.eIZ.bnH()) {
                this.eJe = 3;
            } else if (this.eIZ.isValid()) {
                if (bVar.bnJ()) {
                    this.eJe = 1;
                    this.eIL.setVisibility(8);
                } else {
                    this.eJe = 2;
                }
            } else if (this.eIZ.bnE()) {
                this.eJe = 5;
            } else if (this.eIZ.bnF()) {
                this.eJe = 4;
            }
            bjQ();
        }
    }

    private void bjQ() {
        switch (this.eJe) {
            case 1:
                bjU();
                return;
            case 2:
                bjS();
                return;
            case 3:
                this.eJf = 102;
                bjR();
                return;
            case 4:
                this.eJf = 103;
                bjR();
                return;
            case 5:
                this.eJf = 104;
                bjR();
                return;
            default:
                return;
        }
    }

    private void bjR() {
        String str;
        this.eIK.setVisibility(8);
        this.eIJ.setVisibility(0);
        this.eIM.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_outcome, (ViewGroup) null);
        this.eIM.addView(inflate, this.eIY);
        TextView textView = (TextView) inflate.findViewById(a.g.rp_show_result);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new o(AlaSnatchRedPacketActivity.this.getPageContext().getPageActivity(), AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.aQc)));
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(a.g.rp_gift_btn);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bjP();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        switch (this.eJf) {
            case 100:
            case 103:
            case 104:
                TextView textView3 = (TextView) inflate.findViewById(a.g.rp_snatch_fail);
                textView3.setVisibility(0);
                textView2.setVisibility(8);
                if (this.eJf == 103) {
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
                textView4.setText(String.format(getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(this.eJa.bnI())));
                textView4.setVisibility(0);
                return;
            case 102:
                textView2.setVisibility(0);
                TextView textView5 = (TextView) inflate.findViewById(a.g.rp_snatched);
                textView5.setVisibility(0);
                textView5.setText(getPageContext().getString(a.i.snatch_red_packet_loot_prefix) + String.format(getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(this.eIZ.bnI())));
                return;
            default:
                return;
        }
    }

    private void bjS() {
        this.eIK.setVisibility(0);
        this.eIJ.setVisibility(8);
        this.eIM.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_snatch, (ViewGroup) null);
        this.eIM.addView(inflate, this.eIY);
        ((TextView) inflate.findViewById(a.g.rp_follow_tip)).setVisibility(0);
        ((TextView) inflate.findViewById(a.g.rp_total_amount)).setText(String.format(getResources().getString(a.i.send_ref_packet_desc), Long.valueOf(this.eIZ.fen.feU)));
        this.eIS = (FrameLayout) inflate.findViewById(a.g.rp_snatch_layout);
        if (UtilHelper.getRealScreenOrientation(this) == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eIS.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds126);
            this.eIS.setLayoutParams(layoutParams);
        }
        this.eIT = (ImageView) inflate.findViewById(a.g.rp_snatch_btn);
        this.eIT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.eIU.af(AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.aQc);
            }
        });
        this.eIN = (FrameLayout) inflate.findViewById(a.g.rp_count_down_layout);
        this.eIO = (RoundProgressBar) inflate.findViewById(a.g.rp_snatch_progress);
        this.eIP = (TextView) inflate.findViewById(a.g.rp_snatch_countdown_min);
        this.eIR = (ImageView) inflate.findViewById(a.g.rp_snatch_countdown_dot);
        this.eIR.setVisibility(8);
        this.eIQ = (TextView) inflate.findViewById(a.g.rp_snatch_countdown_second);
        if (!this.eIZ.bnG()) {
            this.eIT.setVisibility(0);
            this.eIN.setVisibility(8);
            bjW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjT() {
        bjX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dj(long j) {
        if (this.eIZ != null) {
            String[] m32do = this.eIZ.m32do(j);
            if (j <= 60) {
                if (!this.eJc) {
                    this.eJc = true;
                    this.eIR.setVisibility(8);
                    this.eIQ.setVisibility(8);
                    this.eIP.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_ds108));
                }
                this.eIP.setText(m32do[1]);
            } else {
                if (this.eIR.getVisibility() != 0) {
                    this.eIR.setVisibility(0);
                }
                this.eIP.setText(m32do[0]);
                this.eIQ.setText(m32do[1]);
            }
            this.eIO.setProgress(this.eIZ.dn(j));
        }
    }

    private void bjU() {
        this.eIK.setVisibility(8);
        this.eIJ.setVisibility(0);
        this.eIM.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_condition, (ViewGroup) null);
        this.eIM.addView(inflate, this.eIY);
        TextView textView = (TextView) inflate.findViewById(a.g.rp_condition_desc);
        TextView textView2 = (TextView) inflate.findViewById(a.g.rp_condition_btn);
        if (this.eIZ.bnL()) {
            this.eJb = false;
            textView.setText(a.i.snatch_red_packet_cond_follow_desc);
            textView2.setText(a.i.snatch_red_packet_follow_btn);
        } else if (this.eIZ.bnM()) {
            this.eJb = true;
            textView.setText(a.i.snatch_red_packet_cond_gift_desc);
            textView2.setText(a.i.snatch_red_packet_gift_btn);
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaSnatchRedPacketActivity.this.eJb) {
                    AlaSnatchRedPacketActivity.this.bjP();
                    AlaSnatchRedPacketActivity.this.finish();
                    return;
                }
                AlaSnatchRedPacketActivity.this.aOL();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOL() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913131, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjV() {
        String str = this.eIZ.feo.fev;
        com.baidu.live.data.b bVar = new com.baidu.live.data.b(this.eIZ.fen.portrait, str, true, getUniqueId());
        bVar.setFrom("source_snatch_red_packet");
        com.baidu.live.view.a.Ht().a(str, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjP() {
        s sVar = new s();
        sVar.aqN = -1;
        sVar.aqO = -1;
        sVar.aqQ = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, sVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bjW() {
        this.eIX = ValueAnimator.ofFloat(1.0f, 0.8f);
        this.eIX.setDuration(250L);
        this.eIX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                AlaSnatchRedPacketActivity.this.eIT.setScaleX(floatValue);
                AlaSnatchRedPacketActivity.this.eIT.setScaleY(floatValue);
            }
        });
        this.eIX.setRepeatCount(-1);
        this.eIX.setRepeatMode(2);
        this.eIX.start();
    }

    private void bjX() {
        this.eIN.setVisibility(0);
        this.eIT.setVisibility(0);
        this.eIW = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.eIW.setDuration(500L);
        this.eIW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                AlaSnatchRedPacketActivity.this.eIN.setAlpha(1.0f - animatedFraction);
                AlaSnatchRedPacketActivity.this.eIT.setAlpha(animatedFraction);
                float f = (float) (animatedFraction * 0.5d);
                AlaSnatchRedPacketActivity.this.eIN.setScaleX(1.0f - f);
                AlaSnatchRedPacketActivity.this.eIN.setScaleY(1.0f - f);
                AlaSnatchRedPacketActivity.this.eIT.setScaleX((float) (f + 0.5d));
                AlaSnatchRedPacketActivity.this.eIT.setScaleY((float) (f + 0.5d));
            }
        });
        this.eIW.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSnatchRedPacketActivity.this.bjW();
                AlaSnatchRedPacketActivity.this.eIN.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.eIW.start();
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
            h.U(this.bAq);
            this.bAq.setScaleX(0.7f);
            this.bAq.setScaleY(0.7f);
            if (this.eIS != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eIS.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds126);
                this.eIS.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        h.V(this.bAq);
        this.bAq.setScaleX(1.0f);
        this.bAq.setScaleY(1.0f);
        if (this.eIS != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.eIS.getLayoutParams();
            layoutParams2.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds146);
            this.eIS.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.eIU != null) {
            this.eIU.onDestroy();
        }
        if (this.eIX != null) {
            this.eIX.removeAllListeners();
            this.eIX.cancel();
            this.eIX = null;
        }
        if (this.eIW != null) {
            this.eIW.removeAllListeners();
            this.eIW.cancel();
            this.eIW = null;
        }
        MessageManager.getInstance().unRegisterListener(this.eJi);
        MessageManager.getInstance().unRegisterListener(this.eJg);
        MessageManager.getInstance().unRegisterListener(this.eIx);
        super.onDestroy();
    }
}
