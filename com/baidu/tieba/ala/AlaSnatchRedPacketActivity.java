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
    private View eTA;
    private FrameLayout.LayoutParams eVA;
    private com.baidu.tieba.ala.data.b eVB;
    private i eVC;
    private boolean eVD;
    private boolean eVE;
    private long eVF;
    private int eVH;
    private View eVl;
    private View eVm;
    private FrameLayout eVn;
    private FrameLayout eVo;
    private FrameLayout eVp;
    private RoundProgressBar eVq;
    private TextView eVr;
    private TextView eVs;
    private ImageView eVt;
    private FrameLayout eVu;
    private ImageView eVv;
    private f eVw;
    private String eVx;
    private ValueAnimator eVy;
    private ValueAnimator eVz;
    private ImageView mCloseBtn;
    private LinearLayout mContentView;
    private String mLiveId;
    private String mRedPacketId;
    private int eVG = 2;
    private CustomMessageListener eVc = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaSnatchRedPacketActivity.this.finish();
        }
    };
    private CustomMessageListener eVI = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(AlaSnatchRedPacketActivity.this.eVx)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (updateAttentionMessage.getData().isAttention) {
                            AlaSnatchRedPacketActivity.this.showToast(AlaSnatchRedPacketActivity.this.getString(a.i.sdk_attention_success_toast));
                            AlaSnatchRedPacketActivity.this.eVn.setVisibility(8);
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
    private f.a eVJ = new f.a() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.8
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
    private CustomMessageListener eVK = new CustomMessageListener(2913133) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                AlaSnatchRedPacketActivity.this.eVF = ((Long) customResponsedMessage.getData()).longValue();
                AlaSnatchRedPacketActivity.this.dl(AlaSnatchRedPacketActivity.this.eVF);
                if (AlaSnatchRedPacketActivity.this.eVF < 1) {
                    AlaSnatchRedPacketActivity.this.bpl();
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
            this.eVw = new f(getPageContext(), this.eVJ);
            this.eVw.ai(this.mRedPacketId, this.mLiveId, this.aWr);
            MessageManager.getInstance().registerListener(this.eVc);
            MessageManager.getInstance().registerListener(this.eVI);
            MessageManager.getInstance().registerListener(this.eVK);
            this.eVA = new FrameLayout.LayoutParams(-1, -1);
            je(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.aWr = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.eTA = findViewById(a.g.rp_root_bg);
        this.eTA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.10
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
        this.eVn = (FrameLayout) findViewById(a.g.rp_follow_sender);
        this.eVn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bpn();
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
        this.eVm = findViewById(a.g.rp_normal_bg);
        this.eVl = findViewById(a.g.rp_condition_guide_bg);
        this.eVo = (FrameLayout) findViewById(a.g.rp_sub_content_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i iVar) {
        this.eVC = iVar;
        if (iVar.btx()) {
            this.eVH = 101;
        } else {
            this.eVH = 100;
        }
        bpj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.data.b bVar) {
        if (bVar.frX != null) {
            this.mContentView.setVisibility(0);
            this.eVB = bVar;
            this.eVx = this.eVB.frY.fsf;
            if (!StringUtils.isNullObject(bVar.frX.portrait)) {
                k.a(this.aQx, bVar.frX.portrait, true, false);
            }
            this.dXU.setText(bVar.frX.userName);
            if (!bVar.btA()) {
                this.eVn.setVisibility(8);
            } else {
                boolean equals = TbadkCoreApplication.getCurrentAccount() != null ? TbadkCoreApplication.getCurrentAccount().equals(this.eVx) : true;
                if (this.eVB.frY.fsg || equals) {
                    this.eVn.setVisibility(8);
                } else {
                    this.eVn.setVisibility(0);
                }
            }
            if (this.eVB.btx()) {
                this.eVG = 3;
            } else if (this.eVB.isValid()) {
                if (bVar.btz()) {
                    this.eVG = 1;
                    this.eVn.setVisibility(8);
                } else {
                    this.eVG = 2;
                }
            } else if (this.eVB.btu()) {
                this.eVG = 5;
            } else if (this.eVB.btv()) {
                this.eVG = 4;
            }
            bpi();
        }
    }

    private void bpi() {
        switch (this.eVG) {
            case 1:
                bpm();
                return;
            case 2:
                bpk();
                return;
            case 3:
                this.eVH = 102;
                bpj();
                return;
            case 4:
                this.eVH = 103;
                bpj();
                return;
            case 5:
                this.eVH = 104;
                bpj();
                return;
            default:
                return;
        }
    }

    private void bpj() {
        String str;
        this.eVm.setVisibility(8);
        this.eVl.setVisibility(0);
        this.eVo.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_outcome, (ViewGroup) null);
        this.eVo.addView(inflate, this.eVA);
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
                AlaSnatchRedPacketActivity.this.bph();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        switch (this.eVH) {
            case 100:
            case 103:
            case 104:
                TextView textView3 = (TextView) inflate.findViewById(a.g.rp_snatch_fail);
                textView3.setVisibility(0);
                textView2.setVisibility(8);
                if (this.eVH == 103) {
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
                textView4.setText(String.format(getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(this.eVC.bty())));
                textView4.setVisibility(0);
                return;
            case 102:
                textView2.setVisibility(0);
                TextView textView5 = (TextView) inflate.findViewById(a.g.rp_snatched);
                textView5.setVisibility(0);
                textView5.setText(getPageContext().getString(a.i.snatch_red_packet_loot_prefix) + String.format(getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(this.eVB.bty())));
                return;
            default:
                return;
        }
    }

    private void bpk() {
        this.eVm.setVisibility(0);
        this.eVl.setVisibility(8);
        this.eVo.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_snatch, (ViewGroup) null);
        this.eVo.addView(inflate, this.eVA);
        ((TextView) inflate.findViewById(a.g.rp_follow_tip)).setVisibility(0);
        ((TextView) inflate.findViewById(a.g.rp_total_amount)).setText(String.format(getResources().getString(a.i.send_ref_packet_desc), Long.valueOf(this.eVB.frX.fsE)));
        this.eVu = (FrameLayout) inflate.findViewById(a.g.rp_snatch_layout);
        if (UtilHelper.getRealScreenOrientation(this) == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eVu.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds126);
            this.eVu.setLayoutParams(layoutParams);
        }
        this.eVv = (ImageView) inflate.findViewById(a.g.rp_snatch_btn);
        this.eVv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.eVw.aj(AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.aWr);
            }
        });
        this.eVp = (FrameLayout) inflate.findViewById(a.g.rp_count_down_layout);
        this.eVq = (RoundProgressBar) inflate.findViewById(a.g.rp_snatch_progress);
        this.eVr = (TextView) inflate.findViewById(a.g.rp_snatch_countdown_min);
        this.eVt = (ImageView) inflate.findViewById(a.g.rp_snatch_countdown_dot);
        this.eVt.setVisibility(8);
        this.eVs = (TextView) inflate.findViewById(a.g.rp_snatch_countdown_second);
        if (!this.eVB.btw()) {
            this.eVv.setVisibility(0);
            this.eVp.setVisibility(8);
            bpo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpl() {
        bpp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl(long j) {
        if (this.eVB != null) {
            String[] dq = this.eVB.dq(j);
            if (j <= 60) {
                if (!this.eVE) {
                    this.eVE = true;
                    this.eVt.setVisibility(8);
                    this.eVs.setVisibility(8);
                    this.eVr.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_ds108));
                }
                this.eVr.setText(dq[1]);
            } else {
                if (this.eVt.getVisibility() != 0) {
                    this.eVt.setVisibility(0);
                }
                this.eVr.setText(dq[0]);
                this.eVs.setText(dq[1]);
            }
            this.eVq.setProgress(this.eVB.dp(j));
        }
    }

    private void bpm() {
        this.eVm.setVisibility(8);
        this.eVl.setVisibility(0);
        this.eVo.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_condition, (ViewGroup) null);
        this.eVo.addView(inflate, this.eVA);
        TextView textView = (TextView) inflate.findViewById(a.g.rp_condition_desc);
        TextView textView2 = (TextView) inflate.findViewById(a.g.rp_condition_btn);
        if (this.eVB.btB()) {
            this.eVD = false;
            textView.setText(a.i.snatch_red_packet_cond_follow_desc);
            textView2.setText(a.i.snatch_red_packet_follow_btn);
        } else if (this.eVB.btC()) {
            this.eVD = true;
            textView.setText(a.i.snatch_red_packet_cond_gift_desc);
            textView2.setText(a.i.snatch_red_packet_gift_btn);
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaSnatchRedPacketActivity.this.eVD) {
                    AlaSnatchRedPacketActivity.this.bph();
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
    public void bpn() {
        String str = this.eVB.frY.fsf;
        com.baidu.live.data.d dVar = new com.baidu.live.data.d(this.eVB.frX.portrait, str, true, getUniqueId());
        dVar.setFrom("source_snatch_red_packet");
        com.baidu.live.view.a.Jl().a(str, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bph() {
        v vVar = new v();
        vVar.avT = -1;
        vVar.avU = -1;
        vVar.avW = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, vVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpo() {
        this.eVz = ValueAnimator.ofFloat(1.0f, 0.8f);
        this.eVz.setDuration(250L);
        this.eVz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                AlaSnatchRedPacketActivity.this.eVv.setScaleX(floatValue);
                AlaSnatchRedPacketActivity.this.eVv.setScaleY(floatValue);
            }
        });
        this.eVz.setRepeatCount(-1);
        this.eVz.setRepeatMode(2);
        this.eVz.start();
    }

    private void bpp() {
        this.eVp.setVisibility(0);
        this.eVv.setVisibility(0);
        this.eVy = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.eVy.setDuration(500L);
        this.eVy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                AlaSnatchRedPacketActivity.this.eVp.setAlpha(1.0f - animatedFraction);
                AlaSnatchRedPacketActivity.this.eVv.setAlpha(animatedFraction);
                float f = (float) (animatedFraction * 0.5d);
                AlaSnatchRedPacketActivity.this.eVp.setScaleX(1.0f - f);
                AlaSnatchRedPacketActivity.this.eVp.setScaleY(1.0f - f);
                AlaSnatchRedPacketActivity.this.eVv.setScaleX((float) (f + 0.5d));
                AlaSnatchRedPacketActivity.this.eVv.setScaleY((float) (f + 0.5d));
            }
        });
        this.eVy.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSnatchRedPacketActivity.this.bpo();
                AlaSnatchRedPacketActivity.this.eVp.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.eVy.start();
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
            if (this.eVu != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eVu.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds126);
                this.eVu.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        h.U(this.bIi);
        this.bIi.setScaleX(1.0f);
        this.bIi.setScaleY(1.0f);
        if (this.eVu != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.eVu.getLayoutParams();
            layoutParams2.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds146);
            this.eVu.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.eVw != null) {
            this.eVw.onDestroy();
        }
        if (this.eVz != null) {
            this.eVz.removeAllListeners();
            this.eVz.cancel();
            this.eVz = null;
        }
        if (this.eVy != null) {
            this.eVy.removeAllListeners();
            this.eVy.cancel();
            this.eVy = null;
        }
        MessageManager.getInstance().unRegisterListener(this.eVK);
        MessageManager.getInstance().unRegisterListener(this.eVI);
        MessageManager.getInstance().unRegisterListener(this.eVc);
        super.onDestroy();
    }
}
