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
import com.baidu.live.data.v;
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
    private HeadImageView aQx;
    private String aWr;
    private FrameLayout bIi;
    private TextView dXU;
    private View eTL;
    private FrameLayout eVA;
    private RoundProgressBar eVB;
    private TextView eVC;
    private TextView eVD;
    private ImageView eVE;
    private FrameLayout eVF;
    private ImageView eVG;
    private f eVH;
    private String eVI;
    private ValueAnimator eVJ;
    private ValueAnimator eVK;
    private FrameLayout.LayoutParams eVL;
    private com.baidu.tieba.ala.data.b eVM;
    private i eVN;
    private boolean eVO;
    private boolean eVP;
    private long eVQ;
    private int eVS;
    private View eVw;
    private View eVx;
    private FrameLayout eVy;
    private FrameLayout eVz;
    private ImageView mCloseBtn;
    private LinearLayout mContentView;
    private String mLiveId;
    private String mRedPacketId;
    private int eVR = 2;
    private CustomMessageListener eVn = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaSnatchRedPacketActivity.this.finish();
        }
    };
    private CustomMessageListener eVT = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(AlaSnatchRedPacketActivity.this.eVI)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (updateAttentionMessage.getData().isAttention) {
                            AlaSnatchRedPacketActivity.this.showToast(AlaSnatchRedPacketActivity.this.getString(a.i.sdk_attention_success_toast));
                            AlaSnatchRedPacketActivity.this.eVy.setVisibility(8);
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
    private f.a eVU = new f.a() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.8
        @Override // com.baidu.tieba.ala.f.f.a
        public void b(com.baidu.tieba.ala.data.b bVar) {
            AlaSnatchRedPacketActivity.this.a(bVar);
        }

        @Override // com.baidu.tieba.ala.f.f.a
        public void ay(int i, String str) {
            AlaSnatchRedPacketActivity.this.showToast(a.i.sdk_net_fail_tip);
        }

        @Override // com.baidu.tieba.ala.f.f.a
        public void b(i iVar) {
            AlaSnatchRedPacketActivity.this.a(iVar);
        }

        @Override // com.baidu.tieba.ala.f.f.a
        public void az(int i, String str) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                AlaSnatchRedPacketActivity.this.showToast(a.i.sdk_net_fail_tip);
            } else if (!StringUtils.isNullObject(str)) {
                AlaSnatchRedPacketActivity.this.showToast(str);
            } else {
                AlaSnatchRedPacketActivity.this.showToast(a.i.snatch_red_packet_failed_3);
            }
        }
    };
    private CustomMessageListener eVV = new CustomMessageListener(2913133) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                AlaSnatchRedPacketActivity.this.eVQ = ((Long) customResponsedMessage.getData()).longValue();
                AlaSnatchRedPacketActivity.this.dl(AlaSnatchRedPacketActivity.this.eVQ);
                if (AlaSnatchRedPacketActivity.this.eVQ < 1) {
                    AlaSnatchRedPacketActivity.this.bpn();
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
            this.eVH = new f(getPageContext(), this.eVU);
            this.eVH.ai(this.mRedPacketId, this.mLiveId, this.aWr);
            MessageManager.getInstance().registerListener(this.eVn);
            MessageManager.getInstance().registerListener(this.eVT);
            MessageManager.getInstance().registerListener(this.eVV);
            this.eVL = new FrameLayout.LayoutParams(-1, -1);
            je(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.aWr = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.eTL = findViewById(a.g.rp_root_bg);
        this.eTL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaSnatchRedPacketActivity.this.finish();
                }
            }
        });
        this.bIi = (FrameLayout) findViewById(a.g.rp_root_container);
        this.mContentView = (LinearLayout) findViewById(a.g.rp_content_layout);
        this.mContentView.setVisibility(8);
        this.aQx = (HeadImageView) findViewById(a.g.rp_user_icon);
        this.aQx.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds6));
        this.aQx.setBorderColor(getPageContext().getResources().getColor(a.d.ala_red_packet_main_color));
        this.aQx.setIsRound(true);
        this.aQx.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.aQx.setAutoChangeStyle(true);
        this.aQx.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dXU = (TextView) findViewById(a.g.rp_user_name);
        this.eVy = (FrameLayout) findViewById(a.g.rp_follow_sender);
        this.eVy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bpp();
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
        this.eVx = findViewById(a.g.rp_normal_bg);
        this.eVw = findViewById(a.g.rp_condition_guide_bg);
        this.eVz = (FrameLayout) findViewById(a.g.rp_sub_content_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i iVar) {
        this.eVN = iVar;
        if (iVar.btz()) {
            this.eVS = 101;
        } else {
            this.eVS = 100;
        }
        bpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.data.b bVar) {
        if (bVar.fsi != null) {
            this.mContentView.setVisibility(0);
            this.eVM = bVar;
            this.eVI = this.eVM.fsj.fsq;
            if (!StringUtils.isNullObject(bVar.fsi.portrait)) {
                k.a(this.aQx, bVar.fsi.portrait, true, false);
            }
            this.dXU.setText(bVar.fsi.userName);
            if (!bVar.btC()) {
                this.eVy.setVisibility(8);
            } else {
                boolean equals = TbadkCoreApplication.getCurrentAccount() != null ? TbadkCoreApplication.getCurrentAccount().equals(this.eVI) : true;
                if (this.eVM.fsj.fsr || equals) {
                    this.eVy.setVisibility(8);
                } else {
                    this.eVy.setVisibility(0);
                }
            }
            if (this.eVM.btz()) {
                this.eVR = 3;
            } else if (this.eVM.isValid()) {
                if (bVar.btB()) {
                    this.eVR = 1;
                    this.eVy.setVisibility(8);
                } else {
                    this.eVR = 2;
                }
            } else if (this.eVM.btw()) {
                this.eVR = 5;
            } else if (this.eVM.btx()) {
                this.eVR = 4;
            }
            bpk();
        }
    }

    private void bpk() {
        switch (this.eVR) {
            case 1:
                bpo();
                return;
            case 2:
                bpm();
                return;
            case 3:
                this.eVS = 102;
                bpl();
                return;
            case 4:
                this.eVS = 103;
                bpl();
                return;
            case 5:
                this.eVS = 104;
                bpl();
                return;
            default:
                return;
        }
    }

    private void bpl() {
        String str;
        this.eVx.setVisibility(8);
        this.eVw.setVisibility(0);
        this.eVz.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_outcome, (ViewGroup) null);
        this.eVz.addView(inflate, this.eVL);
        TextView textView = (TextView) inflate.findViewById(a.g.rp_show_result);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new o(AlaSnatchRedPacketActivity.this.getPageContext().getPageActivity(), AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.aWr)));
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(a.g.rp_gift_btn);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bpj();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        switch (this.eVS) {
            case 100:
            case 103:
            case 104:
                TextView textView3 = (TextView) inflate.findViewById(a.g.rp_snatch_fail);
                textView3.setVisibility(0);
                textView2.setVisibility(8);
                if (this.eVS == 103) {
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
                textView4.setText(String.format(getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(this.eVN.btA())));
                textView4.setVisibility(0);
                return;
            case 102:
                textView2.setVisibility(0);
                TextView textView5 = (TextView) inflate.findViewById(a.g.rp_snatched);
                textView5.setVisibility(0);
                textView5.setText(getPageContext().getString(a.i.snatch_red_packet_loot_prefix) + String.format(getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(this.eVM.btA())));
                return;
            default:
                return;
        }
    }

    private void bpm() {
        this.eVx.setVisibility(0);
        this.eVw.setVisibility(8);
        this.eVz.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_snatch, (ViewGroup) null);
        this.eVz.addView(inflate, this.eVL);
        ((TextView) inflate.findViewById(a.g.rp_follow_tip)).setVisibility(0);
        ((TextView) inflate.findViewById(a.g.rp_total_amount)).setText(String.format(getResources().getString(a.i.send_ref_packet_desc), Long.valueOf(this.eVM.fsi.fsP)));
        this.eVF = (FrameLayout) inflate.findViewById(a.g.rp_snatch_layout);
        if (UtilHelper.getRealScreenOrientation(this) == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eVF.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds126);
            this.eVF.setLayoutParams(layoutParams);
        }
        this.eVG = (ImageView) inflate.findViewById(a.g.rp_snatch_btn);
        this.eVG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.eVH.aj(AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.aWr);
            }
        });
        this.eVA = (FrameLayout) inflate.findViewById(a.g.rp_count_down_layout);
        this.eVB = (RoundProgressBar) inflate.findViewById(a.g.rp_snatch_progress);
        this.eVC = (TextView) inflate.findViewById(a.g.rp_snatch_countdown_min);
        this.eVE = (ImageView) inflate.findViewById(a.g.rp_snatch_countdown_dot);
        this.eVE.setVisibility(8);
        this.eVD = (TextView) inflate.findViewById(a.g.rp_snatch_countdown_second);
        if (!this.eVM.bty()) {
            this.eVG.setVisibility(0);
            this.eVA.setVisibility(8);
            bpq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpn() {
        bpr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl(long j) {
        if (this.eVM != null) {
            String[] dq = this.eVM.dq(j);
            if (j <= 60) {
                if (!this.eVP) {
                    this.eVP = true;
                    this.eVE.setVisibility(8);
                    this.eVD.setVisibility(8);
                    this.eVC.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_ds108));
                }
                this.eVC.setText(dq[1]);
            } else {
                if (this.eVE.getVisibility() != 0) {
                    this.eVE.setVisibility(0);
                }
                this.eVC.setText(dq[0]);
                this.eVD.setText(dq[1]);
            }
            this.eVB.setProgress(this.eVM.dp(j));
        }
    }

    private void bpo() {
        this.eVx.setVisibility(8);
        this.eVw.setVisibility(0);
        this.eVz.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_condition, (ViewGroup) null);
        this.eVz.addView(inflate, this.eVL);
        TextView textView = (TextView) inflate.findViewById(a.g.rp_condition_desc);
        TextView textView2 = (TextView) inflate.findViewById(a.g.rp_condition_btn);
        if (this.eVM.btD()) {
            this.eVO = false;
            textView.setText(a.i.snatch_red_packet_cond_follow_desc);
            textView2.setText(a.i.snatch_red_packet_follow_btn);
        } else if (this.eVM.btE()) {
            this.eVO = true;
            textView.setText(a.i.snatch_red_packet_cond_gift_desc);
            textView2.setText(a.i.snatch_red_packet_gift_btn);
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaSnatchRedPacketActivity.this.eVO) {
                    AlaSnatchRedPacketActivity.this.bpj();
                    AlaSnatchRedPacketActivity.this.finish();
                    return;
                }
                AlaSnatchRedPacketActivity.this.aUN();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUN() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913131, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpp() {
        String str = this.eVM.fsj.fsq;
        com.baidu.live.data.d dVar = new com.baidu.live.data.d(this.eVM.fsi.portrait, str, true, getUniqueId());
        dVar.setFrom("source_snatch_red_packet");
        com.baidu.live.view.a.Jl().a(str, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpj() {
        v vVar = new v();
        vVar.avT = -1;
        vVar.avU = -1;
        vVar.avW = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, vVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpq() {
        this.eVK = ValueAnimator.ofFloat(1.0f, 0.8f);
        this.eVK.setDuration(250L);
        this.eVK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                AlaSnatchRedPacketActivity.this.eVG.setScaleX(floatValue);
                AlaSnatchRedPacketActivity.this.eVG.setScaleY(floatValue);
            }
        });
        this.eVK.setRepeatCount(-1);
        this.eVK.setRepeatMode(2);
        this.eVK.start();
    }

    private void bpr() {
        this.eVA.setVisibility(0);
        this.eVG.setVisibility(0);
        this.eVJ = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.eVJ.setDuration(500L);
        this.eVJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                AlaSnatchRedPacketActivity.this.eVA.setAlpha(1.0f - animatedFraction);
                AlaSnatchRedPacketActivity.this.eVG.setAlpha(animatedFraction);
                float f = (float) (animatedFraction * 0.5d);
                AlaSnatchRedPacketActivity.this.eVA.setScaleX(1.0f - f);
                AlaSnatchRedPacketActivity.this.eVA.setScaleY(1.0f - f);
                AlaSnatchRedPacketActivity.this.eVG.setScaleX((float) (f + 0.5d));
                AlaSnatchRedPacketActivity.this.eVG.setScaleY((float) (f + 0.5d));
            }
        });
        this.eVJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSnatchRedPacketActivity.this.bpq();
                AlaSnatchRedPacketActivity.this.eVA.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.eVJ.start();
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
        je(configuration.orientation == 2);
    }

    private void je(boolean z) {
        if (z) {
            h.T(this.bIi);
            this.bIi.setScaleX(0.7f);
            this.bIi.setScaleY(0.7f);
            if (this.eVF != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eVF.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds126);
                this.eVF.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        h.U(this.bIi);
        this.bIi.setScaleX(1.0f);
        this.bIi.setScaleY(1.0f);
        if (this.eVF != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.eVF.getLayoutParams();
            layoutParams2.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds146);
            this.eVF.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.eVH != null) {
            this.eVH.onDestroy();
        }
        if (this.eVK != null) {
            this.eVK.removeAllListeners();
            this.eVK.cancel();
            this.eVK = null;
        }
        if (this.eVJ != null) {
            this.eVJ.removeAllListeners();
            this.eVJ.cancel();
            this.eVJ = null;
        }
        MessageManager.getInstance().unRegisterListener(this.eVV);
        MessageManager.getInstance().unRegisterListener(this.eVT);
        MessageManager.getInstance().unRegisterListener(this.eVn);
        super.onDestroy();
    }
}
